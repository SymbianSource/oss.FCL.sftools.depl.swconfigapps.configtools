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
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import com.nokia.tools.variant.common.core.utils.ExceptionUtils;
import com.nokia.tools.variant.common.core.utils.FileUtils;
import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.variant.confml.core.ConfMLUtil;
import com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata;
import com.nokia.tools.variant.confml.core.model.metadata.util.ECPFMetadataResourceFactoryImpl;

public class ImportCPFOperation implements IWorkspaceRunnable {

	private static final URI CPF_METADATA_URI = URI.createURI(".metadata");

	private File sourceFile;
	private String projectName;
	private java.net.URI projectURI;

	public ImportCPFOperation() {
		//
	}

	public ImportCPFOperation(File sourceFile) {
		this();
		setSourceFile(sourceFile);
	}

	public void setSourceFile(File sourceFile) {
		this.sourceFile = sourceFile;
	}

	static class NoCloseInputStream extends FilterInputStream {

		NoCloseInputStream(InputStream in) {
			super(in);
		}

		@Override
		public void close() throws IOException {
		}
	}

	public void run(IProgressMonitor monitor) throws CoreException {
		monitor.beginTask("Importing CPF", 100);
		try {
			IProject project = ResourcesPlugin.getWorkspace().getRoot()
					.getProject(projectName);

			ECPFMetadata cpfMetadata = getCPFMetadata();
			ConfMLUtil.createConfMLProject(project, projectURI,new SubProgressMonitor(monitor, 10), cpfMetadata);
			ZipInputStream zis = CPFUtil.openCPFStream(sourceFile);
			for (ZipEntry zipEntry; (zipEntry = zis.getNextEntry()) != null;) {

				
				String name = zipEntry.getName();
				IPath path = new Path(name);
				IContainer ptr = project;
				int segments = path.segmentCount()-1;
				if (name.endsWith("/" ))segments++;
				
				for (int i = 0; i < segments; i++) {
					IFolder folder = ptr.getFolder(new Path(path.segment(i)));
					if (!folder.exists()) {
						folder.create(true, true, null);
					}
					ptr = folder;
				}

				if (!zipEntry.isDirectory())
				{
					IFile file = project.getFile(path);
					InputStream is = new NoCloseInputStream(zis);
					if (file.exists()) {
						file.setContents(is, IResource.NONE, null);
					} else {
						file.create(is, IResource.NONE, null);
					}
					file.setLocalTimeStamp(zipEntry.getTime());
					zis.closeEntry();
				}
			}
			FileUtils.closeStream(zis);

		} catch (Exception ex) {
			throw ExceptionUtils.wrapCoreException(ex, ConfMLCore.PLUGIN_ID,
					"Wizard Error");
		} finally {
			monitor.done();
		}
	}

	private ECPFMetadata getCPFMetadata() throws Exception {
		ZipInputStream zis = CPFUtil.openCPFStream(sourceFile);
		try {
			for (ZipEntry zipEntry; (zipEntry = zis.getNextEntry()) != null;) {
				if (zipEntry.isDirectory()) {
					zis.closeEntry();
					continue;
				}
				if (zipEntry.getName().equals(CPF_METADATA_URI.path())) {
					Resource res = new ECPFMetadataResourceFactoryImpl()
							.createResource(CPF_METADATA_URI);
					res.load(zis, null);
					return (ECPFMetadata) res.getContents().get(0);
				}
			}
		} finally {
			FileUtils.closeStream(zis);
		}
		return null;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setProjectURI(java.net.URI projectURI) {
		this.projectURI = projectURI;
	}
}
