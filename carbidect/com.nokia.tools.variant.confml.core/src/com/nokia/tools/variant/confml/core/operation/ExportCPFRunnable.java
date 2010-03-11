/*
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies).
 * All rights reserved.
 * This component and the accompanying materials are made available
 * under the terms of "Eclipse Public License v1.0"
 * which accompanies this distribution, and is available
 * at the URL "http://www.eclipse.org/legal/epl-v10.html".
 * 
 * Initial Contributors:
 * Nokia Corporation - Initial contribution
 * 
 * Contributors:
 * 
 * Description: This file is part of com.nokia.tools.variant.confml.core component.
 */

package com.nokia.tools.variant.confml.core.operation;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.w3c.dom.Document;

import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;
import com.nokia.tools.vct.common.appmodel.util.CPFEncryptionUtils;
import com.nokia.tools.vct.common.appmodel.util.CPFSigningUtils;
import com.nokia.tools.vct.common.appmodel.util.ICPFContentProvider;
import com.nokia.tools.vct.common.core.utils.ExceptionUtils;
import com.nokia.tools.vct.common.core.utils.FileUtils;
import com.nokia.tools.vct.common.secure.core.SigningUtils;

public class ExportCPFRunnable implements IWorkspaceRunnable {

	private File outputFile;
	private IProject exportedProject;
	private boolean encrypt;
	private boolean sign;

	private Object[] signTargets;

	private X509Certificate[] certificates;

	private X509Certificate authorCertificate;

	private PrivateKey authorKey;

	private String algorithm;

	private int blockSize;

	public ExportCPFRunnable() {
	}

	public ExportCPFRunnable(File outputFile, IProject project,
			boolean encrypt, boolean sign) {
		this();
		setOutputFile(outputFile);
		setExportedProject(project);
		setEncrypt(encrypt);
		setSign(sign);
	}

	public void setSign(boolean sign) {
		this.sign = sign;
	}

	public void setOutputFile(File outputFile) {
		this.outputFile = outputFile;
	}

	public void setExportedProject(IProject exportedProject) {
		this.exportedProject = exportedProject;
	}

	public void run(final IProgressMonitor monitor) throws CoreException {

		TransactionalEditingDomain domain = ConfMLCore.getEditingDomain();
		RunnableWithResult<Void> runnable = new RunnableWithResult.Impl<Void>() {
			public void run() {
				try {
					performFinish(monitor);
					setStatus(Status.OK_STATUS);
				} catch (CoreException e) {
					setStatus(e.getStatus());
				}
			}
		};

		try {
			TransactionUtil.runExclusive(domain, runnable);
			if (!runnable.getStatus().isOK()) {
				throw new CoreException(runnable.getStatus());
			}
		} catch (InterruptedException e) {
			throw new CoreException(new Status(IStatus.ERROR,
					ConfMLCore.PLUGIN_ID, "Interrupted", e));
		}

	}

	protected void performFinish(IProgressMonitor monitor) throws CoreException {

		try {
			monitor.beginTask("Creating CPF", 100);
			OutputStream os;
			
			if (encrypt) {
				ICPFContentProvider contentProvider = CPFEncryptionUtils.createSecureContentProvider(outputFile, algorithm, blockSize, authorCertificate, authorKey, certificates);
				os = contentProvider.createOutputStream();
			} else {
				os = new BufferedOutputStream(new FileOutputStream(outputFile));
			}
			
			ZipOutputStream zos = new ZipOutputStream(os);
			Date timestamp = new Date();
			// exportMetadata(timestamp, new SubProgressMonitor(monitor, 10),
			// zos);
			exportProject(exportedProject,
					new SubProgressMonitor(monitor, 100), zos);

			zos.close();
			outputFile.setLastModified(timestamp.getTime());
		} catch (Exception ex) {
			ex.printStackTrace();

			throw ExceptionUtils.wrapCoreException(ex, ConfMLCore.PLUGIN_ID,
					"Export exception");
		} finally {
			monitor.done();
		}
	}

	/**
	 * 
	 * @param timestamp
	 * @param path
	 * @param vp
	 * @param monitor
	 * @param zos
	 * @param encrypt
	 * @param alternate
	 * @throws Exception
	 */
	private void exportProject(IProject project, IProgressMonitor monitor,
			ZipOutputStream zos1) throws Exception {
		monitor.beginTask("Exporting project:" + project.getName(), 100);
		final List<IResource> exported = enumerateResources(project,
				new SubProgressMonitor(monitor, 10));
		exportResources(new SubProgressMonitor(monitor, 90), zos1, exported);
		
		if (sign) {
			for (Object next : signTargets) {
				Document signature = null;
				URI uri = null;
				if (next instanceof EConfigurationProject) {
					EConfigurationProject cpf = (EConfigurationProject)next;
					signature = CPFSigningUtils.createSignature(cpf, authorCertificate, authorKey);
					uri = CPFSigningUtils.getSignatureURI(cpf).deresolve(cpf.getRootConfml());
				} else if (next instanceof EConfMLLayer) {
					EConfMLLayer layer = (EConfMLLayer)next;
					signature = CPFSigningUtils.createSignature(layer, authorCertificate, authorKey);
					EConfigurationProject cpf = (EConfigurationProject)layer.eContainer();
					uri = CPFSigningUtils.getSignatureURI(layer).deresolve(cpf.getRootConfml());
				}
				
				if (uri != null) {
					ZipEntry entry = new ZipEntry(uri.path());
					zos1.putNextEntry(entry);
					SigningUtils.marshalSignature(signature, zos1);
					zos1.closeEntry();
				}
			}
		}
		
		monitor.done();
	}

	private void exportResources(IProgressMonitor monitor,
			ZipOutputStream zos1, final List<IResource> exported)
			throws Exception, CoreException {
		monitor.beginTask("Exporting file", exported.size() * 10);
		for (IResource resource : exported) {
			if (resource instanceof IFile)
				exportResourceFile(zos1, (IFile) resource);
			else if (resource instanceof IFolder)
				exportResourceFolder(zos1, (IFolder) resource);
			monitor.worked(10);
		}
		monitor.done();
	}

	private List<IResource> enumerateResources(IProject project,
			IProgressMonitor monitor) throws CoreException {
		monitor.beginTask("Enumerating resources", 100);
		final List<IResource> exported = new ArrayList<IResource>();
		IResourceVisitor visitor = new IResourceVisitor() {
			public boolean visit(IResource resource) throws CoreException {
				if (resource.isTeamPrivateMember()) {
					return false;
				}
				
				if (resource instanceof IFile) {
					if (!ignore((IFile) resource)) {
						exported.add((IFile) resource);
					}
				} else if (resource instanceof IFolder) {
					IFolder folder = (IFolder) resource;
					exported.add(folder);
				}
				return true;
			}
		};
		project.accept(visitor);
		monitor.worked(100);
		monitor.done();
		return exported;
	}

	private boolean ignore(IFile file) {
		if ("sign".equals(file.getFileExtension())) {
			if (!sign) {
				// remove all signatures on export is unsigned
				return true;
			}
			
			boolean match = false;
			for (Object next: signTargets) {
				if (next instanceof EConfigurationProject) {
					EConfigurationProject project = (EConfigurationProject)next;
					URI root = project.getRootConfml();
					URI uri = URI.createURI(root.lastSegment().concat(".sign")).resolve(root);
					String path = uri.toPlatformString(true);
					match = file.getFullPath().equals(new Path(path));
					
				} else if (next instanceof EConfMLLayer) {
					EConfMLLayer layer = (EConfMLLayer)next;
					URI uri = CPFSigningUtils.LAYER_SIGNATURE_LOCATION.resolve(layer.getLayerURI());
					String path = uri.toPlatformString(true);
					match = file.getFullPath().equals(new Path(path));
					
				} else {
					// ignore
				}
				if (match) {
					break;
				}
			}
			if (match) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

	private void exportResourceFile(ZipOutputStream zos, IFile file)
			throws Exception, CoreException {
		IPath ipath = file.getProjectRelativePath();
		ZipEntry entry = new ZipEntry(ipath.toPortableString());
		entry.setTime(file.getModificationStamp());
		zos.putNextEntry(entry);

		InputStream is = file.getContents();
		FileUtils.copyStream(is, zos);
		FileUtils.closeStream(is);
		zos.closeEntry();
	}

	private void exportResourceFolder(ZipOutputStream zos, IFolder folder)
			throws Exception, CoreException {
		IPath ipath = folder.getProjectRelativePath();
		ZipEntry entry = new ZipEntry(ipath.toPortableString() + "/");

		entry.setTime(folder.getModificationStamp());
		zos.putNextEntry(entry);

		// InputStream is = folder.
		// FileUtils.copyStream(is, zos);
		// FileUtils.closeStream(is);
		zos.closeEntry();
	}

	public void setEncrypt(boolean flag) {
		this.encrypt = flag;
	}

	public void setSignTargets(Object[] signTargets) {
		this.signTargets = signTargets;
	}

	public void setCertificates(X509Certificate[] certificates) {
		this.certificates = certificates;
	}

	public void setSigingOptions(X509Certificate certificate,
			PrivateKey privateKey) {
		this.authorCertificate = certificate;
		this.authorKey = privateKey;
	}

	public void setEncryptionOptions(String algorithm, int blockSize) {
		this.algorithm = algorithm;
		this.blockSize = blockSize;
		
	}

}
