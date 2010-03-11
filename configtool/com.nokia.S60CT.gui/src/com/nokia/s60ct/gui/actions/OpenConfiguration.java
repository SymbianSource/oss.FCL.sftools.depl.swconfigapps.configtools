/*
* Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
* All rights reserved.
* This component and the accompanying materials are made available
* under the terms of "Eclipse Public License v1.0"
* which accompanies this distribution, and is available
* at the URL "http://www.eclipse.org/legal/epl-v10.html".
*
* Initial Contributors:
* Nokia Corporation - initial contribution.
*
* Contributors:
*
* Description:
*
*/
package com.nokia.s60ct.gui.actions;

import helpers.DefaultProject;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.ui.action.WorkbenchWindowActionDelegate;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import com.nokia.s60ct.gui.S60CtEditorPlugin;
import com.nokia.s60ct.gui.editors.CBrowserEditorInput;

import configurationemf.Project;

public class OpenConfiguration extends WorkbenchWindowActionDelegate
	implements IViewActionDelegate{

	private final static String dummyTestFile = "dummytestfile.abc";
	
	public static String getString(String key) {
		return S60CtEditorPlugin.INSTANCE.getString(key);
	}
	
	
	public void init(IViewPart view) {
		
	}
	
	
	public void run(IAction action) {
		ResourceSet resourceSet = Project.instance().getEditingDomain().getResourceSet();
		
		String[] fileExtensionFilter = new String[]{"*." + getString("_UI_ConfigurationemfEditorFilenameExtension")};
		String filePath = openFilePathDialog(getWindow().getShell(), fileExtensionFilter,SWT.OPEN);
		for(Iterator iResource = resourceSet.getResources().iterator();
			iResource.hasNext()&&filePath!=null;){
			Resource resource = (Resource)iResource.next();
			String loadedPath = resource.getURI().toFileString();
			if(filePath.equals(loadedPath))filePath=null;
		}

		openEditor(URI.createFileURI(filePath));
	}



	public static  void openEditor(URI fileURI) {
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
		IWorkbenchPage page = workbenchWindow.getActivePage();
		IEditorDescriptor editorDescriptor = workbench.getEditorRegistry().getDefaultEditor(fileURI.toFileString());
		if (editorDescriptor == null) {
			MessageDialog.openError(
			workbenchWindow.getShell(),
			getString("_UI_Error_title"), 
			S60CtEditorPlugin.INSTANCE.getString("_UI_OpenFileError_message", new Object[]{fileURI.toFileString()})); 
		}
		else {
			try 
			{
				File file = new File(fileURI.toFileString());
				if (!file.canWrite()) //if folder is read-only, this doesn't tell that and file cannot be saved.
				{
					MessageDialog.openError(
							workbenchWindow.getShell(),
							getString("_UI_Error_title"),
							S60CtEditorPlugin.INSTANCE.getString("_UI_ReadOnlyFileError_message", new Object[]{fileURI.toFileString()})); 
					return;
				}
	
				//test is the folder (or some other folder in path) is read only. file.canWrite() doesn't tell this
				String dirPath = file.getPath();
				String testFilePath = null;

				try
				{
					dirPath = dirPath.substring(0, dirPath.lastIndexOf(File.separator));
					
					if (file.isAbsolute())
					{
						testFilePath = dirPath+File.separator+dummyTestFile;
					}
					else
					{	//relative path. Add the path to user dir (current directory)
						String curDir = System.getProperty("user.dir");
						testFilePath = curDir+File.separator+dirPath+File.separator+dummyTestFile;
						fileURI = URI.createFileURI(curDir+File.separator+file.toString());
					}
				}
				catch (StringIndexOutOfBoundsException sioobe) //no path given
				{
					String curDir = System.getProperty("user.dir");
					testFilePath = curDir+File.separator+dummyTestFile;
					fileURI = URI.createFileURI(curDir+File.separator+file.toString());
				}
				
				File testFile = new File(testFilePath);
				
				try
				{
					if (!testFile.createNewFile())
					{
						//nothing interesting here. We just want to see if this throws exception.
					}
					testFile.delete();
				} 
				catch (IOException e) //user doesn't have write access to the folder (or some other folder in path)
				{
					testFile = null;
					testFilePath = null;
					dirPath = null;
					MessageDialog.openError(
							workbenchWindow.getShell(),
							getString("_UI_Error_title"),
							S60CtEditorPlugin.INSTANCE.getString("_UI_ReadOnlyFile2Error_message", new Object[]{fileURI.toFileString()})); 
					return;
				}
				catch (Exception e)
				{
					
				}
				testFile = null;
				testFilePath = null;
				dirPath = null;
				IFile iFile = DefaultProject.createLinkFile(fileURI);
				
				page.openEditor(new CBrowserEditorInput(iFile), editorDescriptor.getId());
			}
			catch (PartInitException exception) {
				MessageDialog.openError(
				workbenchWindow.getShell(),
				getString("_UI_OpenEditorError_label"), 
				exception.getMessage());
			}
		}
	}
	
	public static String openFilePathDialog(Shell shell, String[] fileExtensionFilter,int style) {
		FileDialog fileDialog = new FileDialog(shell, style);
		fileDialog.setFilterExtensions(fileExtensionFilter);
		fileDialog.open();
		if (fileDialog.getFileName() != null && fileDialog.getFileName().length() > 0) {
			return fileDialog.getFilterPath() + File.separator + fileDialog.getFileName();
		}
		else {
			return null;
		}
	}
}
