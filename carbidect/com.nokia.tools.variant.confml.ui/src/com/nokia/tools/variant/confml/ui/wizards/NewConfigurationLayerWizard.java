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
 * Description: This file is part of com.nokia.tools.variant.confml.ui component.
 */

package com.nokia.tools.variant.confml.ui.wizards;

import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.internal.resources.Folder;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;

import com.nokia.tools.variant.confml.ui.views.CustomProjectExplorer;
import com.nokia.tools.variant.confml.ui.views.CustomViewer;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Document;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Factory;
import com.nokia.tools.vct.confml.model.confml2.util.EConfML2ResourceFactoryImpl;

public class NewConfigurationLayerWizard extends NewElementWizard {

	private IStructuredSelection selection;
	private NewConfigurationLayerWizardPageOne pageOne;
	private IWorkbenchPart part = null;
	private IFolder newFolder = null;
	private static final String CONFML_INCLUSION_EDITOR_ID = "com.nokia.tools.vct.confml.editor.include.xincmodel.presentation.EXincModelEditorID";

	public NewConfigurationLayerWizard() {
		super();
		setNeedsProgressMonitor(true);
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
										newFolder = pageOne
												.getSelectedFolder();
										newFolder.create(true, true,
												new SubProgressMonitor(monitor,
														100));
										createFolder(monitor, newFolder, "content");
										createFolder(monitor, newFolder, "doc");
										createFolder(monitor, newFolder, "confml");
										createFolder(monitor, newFolder, "implml");
										
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
								}, pageOne.getParentContainer(),
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
		
		if (part instanceof CustomProjectExplorer)
		{
			CustomProjectExplorer pe = (CustomProjectExplorer)part;
			setSelected(pe, newFolder);
		}
		IPath path = newFolder.getFullPath();
		path = new Path("/root.confml");
		IFile file = newFolder.getFile(path);
		try 
		{
			URI uri = URI.createPlatformResourceURI(file.getFullPath().toPortableString(), true);
			Resource resource = new EConfML2ResourceFactoryImpl().createResource(uri);
			EConfML2Factory factory = EConfML2Factory.eINSTANCE;
			EConfML2Document document = factory.createEConfML2Document();
			resource.getContents().add(document);
			com.nokia.tools.vct.confml.model.confml2.EConfigurationElement configuration = factory.createEConfigurationElement();
			document.setConfiguration(configuration);
			Map<Object, Object> options = new HashMap<Object, Object>();
			options.put(XMLResource.OPTION_ENCODING,"UTF-8");
			resource.save(options);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}

	private void setSelected(CustomProjectExplorer pe, IFolder folder)
	{
		CustomViewer viewer = (CustomViewer)pe.getCommonViewer();
		final Tree tree = viewer.getTree();
		final TreeItem newItem = findNewItem(folder, tree.getItems());
		tree.setSelection(newItem);
		tree.showItem(newItem);
	}
	
	private TreeItem findNewItem(IFolder newFolder, TreeItem[] items)
	{
		String newFolderString = newFolder.getFullPath().toString();
		for (int i = 0 ; i < items.length ; i++)
		{
			Object data = items[i].getData();
			if (data instanceof Folder)
			{
				Folder folder = (Folder)data;
				if (folder.getFullPath().toString().equals(newFolderString))
				{
					return items[i];
				}
			}
			TreeItem item = findNewItem(newFolder, items[i].getItems());
			if (item!=null)
				return item;
		}
		return null;
	}
	
	@Override
	public void addPages() {
		pageOne = new NewConfigurationLayerWizardPageOne();
		for (Object obj : selection.toArray()) {
			if (obj instanceof IContainer) {
				pageOne.setInitialContainer((IContainer) obj);
				break;
			} else if (obj instanceof IResource) {
				pageOne.setInitialContainer(((IResource) obj).getParent());
				break;
			}
		}
		;
		addPage(pageOne);
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
		IWorkbenchPage page = workbench.getActiveWorkbenchWindow().getActivePage();
		part =  page.getActivePart();
	}

	@Override
	protected void finishPage(IProgressMonitor monitor)
			throws InterruptedException, CoreException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getCreatedElement() {
		// TODO Auto-generated method stub
		return null;
	}
}
