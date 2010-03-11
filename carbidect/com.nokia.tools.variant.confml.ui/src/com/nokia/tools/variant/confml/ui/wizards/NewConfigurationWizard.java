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
 * Description: This file is part of com.nokia.tools.vct.common.ui component.
 */

package com.nokia.tools.variant.confml.ui.wizards;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import com.nokia.tools.vct.confml.model.confml1.EConfML1Factory;
import com.nokia.tools.vct.confml.model.confml1.EConfMLDocument;
import com.nokia.tools.vct.confml.model.confml1.EConfigurationElement;
import com.nokia.tools.vct.confml.model.confml1.include.EConfMLIncludeFactory;
import com.nokia.tools.vct.confml.model.confml1.include.EInclude;
import com.nokia.tools.vct.confml.model.confml1.util.EConfML1ResourceFactoryImpl;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Document;
import com.nokia.tools.vct.confml.model.confml2.util.EConfML2ResourceFactoryImpl;

public class NewConfigurationWizard extends Wizard implements INewWizard {
	private IStructuredSelection selection;
	private NewConfigurationWizardPageOne pageOne;
	private NewConfigurationWizardPageTwo pageTwo;
	
	private String windowTitle = "New Configuration";

	public NewConfigurationWizard() {
		setWindowTitle(windowTitle);
	}

	@Override
	public boolean performFinish() {

		try {
			getContainer().run(false, false, new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor)
						throws InvocationTargetException, InterruptedException {
					try {
						ResourcesPlugin.getWorkspace().run(
								new IWorkspaceRunnable() {
									public void run(IProgressMonitor monitor)
											throws CoreException {
										IResource basedOn = pageOne.getBasedOn();
										IResource newConfigRoot = pageOne.getNewConfigurationRoot();
										IFolder layerFolder = pageTwo.getSelectedFolder();
										
										layerFolder.create(true, true,
												new SubProgressMonitor(monitor,
														100));
										createFolder(monitor, layerFolder, "content");
										createFolder(monitor, layerFolder, "doc");
										createFolder(monitor, layerFolder, "confml");
										createFolder(monitor, layerFolder, "implml");
										
										//create layer root file
										IFile layerRoot = layerFolder.getFile("root.confml");
										Resource.Factory rfactory;
										rfactory = new EConfML1ResourceFactoryImpl();
										URI uri = URI.createPlatformResourceURI(layerRoot.getFullPath()
												.toPortableString(), true);
										Resource resource = rfactory.createResource(uri);

										EConfML1Factory factory = EConfML1Factory.eINSTANCE;
										EConfMLIncludeFactory includeFactory = EConfMLIncludeFactory.eINSTANCE;
										EConfMLDocument document = factory.createEConfMLDocument();

										EConfigurationElement configuration = factory
										.createEConfigurationElement();
										document.setConfiguration(configuration);
										
										resource.getContents().add(document);
										Map<Object, Object> options = new HashMap<Object, Object>();
										options.put(XMLResource.OPTION_ENCODING,"UTF-8");
										try {
											resource.save(options);
										} catch (IOException e) {
											e.printStackTrace();
										}
										java.net.URI uri1 = newConfigRoot.getProject().getLocationURI();
										java.net.URI uri2 = layerRoot.getLocationURI();
										String relativePath = uri1.relativize(uri2).toString();
										
										uri = URI.createPlatformResourceURI(newConfigRoot.getFullPath()
												.toPortableString(), true);
										resource = rfactory.createResource(uri);

										document = factory.createEConfMLDocument();

										configuration = factory
										.createEConfigurationElement();
										document.setConfiguration(configuration);
										
										
										//get includes from based on configuration
										if(basedOn instanceof IFile) {
											uri = URI.createPlatformResourceURI(basedOn.getFullPath()
													.toPortableString(), true);
											ResourceSet rs = new ResourceSetImpl();
											Resource basedOnResource = rs.getResource(uri, true);
											EObject root = basedOnResource.getContents().get(0);
											
											EList<EInclude> includes;
											if(root instanceof EConfML2Document) {
												EConfML2Document doc = (EConfML2Document) root;
												includes = doc.getConfiguration().getIncludes();												
											} else {
												EConfMLDocument doc = (EConfMLDocument) root;
												includes = doc.getConfiguration().getIncludes();												
											}
											for (EInclude inc : includes) {
												EInclude temp = includeFactory.createEInclude();
												temp.setHref(inc.getHref());
												configuration.getIncludes().add(temp);
											}											
										}
										EInclude include = includeFactory.createEInclude();
										include.setHref(relativePath);
										configuration.getIncludes().add(include);
										
										resource.getContents().add(document);
										try {
											resource.save(options);
										} catch (IOException e) {
											e.printStackTrace();
										}
									}

									private void createFolder(
											IProgressMonitor monitor,
											IFolder folder, String name)
											throws CoreException {
										IFolder content = folder
												.getFolder(name);
										content.create(true, true,
												new SubProgressMonitor(monitor,
														100));
									}
								}, ResourcesPlugin.getWorkspace().getRoot(),
								IWorkspace.AVOID_UPDATE, monitor);
					} catch (CoreException e) {
						throw new InvocationTargetException(e);
					}
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;	
	}

	@Override
	public void addPages() {
		pageOne = new NewConfigurationWizardPageOne(selection);
		pageTwo = new NewConfigurationWizardPageTwo();
		addPage(pageOne);
		addPage(pageTwo);
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}
	
	IResource getBasedOnConfiguration() {
		return pageOne.getBasedOn();
	}
}
