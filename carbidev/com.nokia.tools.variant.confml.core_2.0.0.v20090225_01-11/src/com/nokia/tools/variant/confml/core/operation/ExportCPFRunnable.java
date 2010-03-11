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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;

import com.nokia.tools.variant.common.core.utils.ExceptionUtils;
import com.nokia.tools.variant.common.core.utils.FileUtils;
import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.variant.confml.core.model.application.EConfigurationProject;
import com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata;
import com.nokia.tools.variant.confml.core.model.metadata.EMetadataFactory;
import com.nokia.tools.variant.confml.core.model.metadata.util.ECPFMetadataResourceFactoryImpl;

public class ExportCPFRunnable implements IWorkspaceRunnable {
	
	private static final URI CPF_METADATA_URI = URI.createURI(".metadata");
	
	private String viewId;
	private File outputFile;
	private String cpfName;
	private String cpfDescription;
	private IProject exportedProject;
	private boolean encrypt;
	
	public ExportCPFRunnable() {
	}
	
	public ExportCPFRunnable(File outputFile, IProject project, String cpfName, String cpfDescription, String viewId, boolean encrypt) {
		this();
		setOutputFile(outputFile);
		setExportedProject(project);
		setCpfName(cpfName);
		setCpfDescription(cpfDescription);
		setViewId(viewId);
		setEncrypt(encrypt);
	}

	public void setCpfName(String cpfName) {
		this.cpfName = cpfName;
	}

	public void setCpfDescription(String cpfDescription) {
		this.cpfDescription = cpfDescription;
	}

	public void setViewId(String viewId) {
		this.viewId = viewId;
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
			ZipOutputStream zos = CPFUtil.openCPFOutputStream(outputFile, encrypt);
			Date timestamp = new Date();
			exportMetadata(timestamp, new SubProgressMonitor(monitor, 10), zos);
			exportProject(exportedProject, new SubProgressMonitor(monitor, 10),
					zos);

			zos.close();
			outputFile.setLastModified(timestamp.getTime());
		} catch (Exception ex) {
			ex.printStackTrace();

			throw ExceptionUtils.wrapCoreException(ex, ConfMLCore.PLUGIN_ID,
					"Export exception");
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
		monitor.done();
	}

	private void exportResources(IProgressMonitor monitor,
			ZipOutputStream zos1, final List<IResource> exported) throws Exception,
			CoreException {
		monitor.beginTask("Exporting file", exported.size() * 10);
		for (IResource resource : exported) {
			if (resource instanceof IFile)
				exportResourceFile(zos1, (IFile)resource);
			else if (resource instanceof IFolder)
				exportResourceFolder(zos1, (IFolder)resource);
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
				if (resource instanceof IFile) {
					if (!ignore((IFile) resource)) {
						exported.add((IFile) resource);
					}
				}
				else if (resource instanceof IFolder)
				{
					IFolder folder = (IFolder)resource;
					if (folder.members().length == 0)
					{
						exported.add(folder);
					}
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
		if (file.getName().startsWith(".")) {
			return true;
		} else {
			return false;
		}
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
		ZipEntry entry = new ZipEntry(ipath.toPortableString()+"/");
		
		entry.setTime(folder.getModificationStamp());
		zos.putNextEntry(entry);
	
//		InputStream is = folder.
//		FileUtils.copyStream(is, zos);
//		FileUtils.closeStream(is);
		zos.closeEntry();
	}

	private void exportMetadata(Date timestamp, IProgressMonitor monitor,
			ZipOutputStream zos) throws IOException, CoreException {
		ZipEntry entry = new ZipEntry(CPF_METADATA_URI.path());
		ECPFMetadata metadata = EMetadataFactory.eINSTANCE.createECPFMetadata();
		metadata.setName(cpfName);
		metadata.setDescription(cpfDescription);
		// metadata.setUserLayer(new Path(mainLayerId));
		
		EConfigurationProject configurationProject = ConfMLCore.getProjectModel(exportedProject);
		
		metadata.setCpfRootFile(configurationProject.getRootConfml().lastSegment());
		metadata.setViewId(viewId);
		// for (String exp : exportedLayerIds) {
		// metadata.getProvisioned().add(new Path(exp));
		// }
		entry.setTime(timestamp.getTime());
		zos.putNextEntry(entry);
		Resource cpfResource = new ECPFMetadataResourceFactoryImpl().createResource(CPF_METADATA_URI);
		cpfResource.getContents().add(metadata);
		cpfResource.save(zos, null);
		zos.closeEntry();
	}

	public void setEncrypt(boolean flag) {
		this.encrypt = flag;
	}

}
