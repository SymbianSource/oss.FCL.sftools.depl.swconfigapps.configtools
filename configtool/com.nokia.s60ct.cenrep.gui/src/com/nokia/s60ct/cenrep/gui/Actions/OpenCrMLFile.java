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
package com.nokia.s60ct.cenrep.gui.Actions;

import helpers.DefaultProject;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.ui.action.WorkbenchWindowActionDelegate;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IReusableEditor;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import com.nokia.s60ct.cenrep.gui.CenRepPlugin;
import com.nokia.s60ct.cenrep.gui.editors.CRBrowser;
import com.nokia.s60ct.cenrep.gui.editors.CRBrowserEditorInput;


public class OpenCrMLFile extends WorkbenchWindowActionDelegate
		implements IViewActionDelegate {

	private static final String dummyTestFile = "dummytestfile.xxx";
	
	private static String getString(String key) {
		return CenRepPlugin.INSTANCE.getString(key);
	}
	
	public void init(IViewPart view) {
		
	}
	
	
	public void run(IAction action) {
		//prepare extension filter
		String[] fileExtensionFilter = new String[1];
		fileExtensionFilter[0]="*." + getString("_UI_CenrepFilenameExtension");
		
		String[] filePath = openFilePathDialog(getWindow().getShell(), fileExtensionFilter,SWT.OPEN|SWT.MULTI);
		URI[] uris = new URI[filePath.length];
		for (int i = 0 ; i < uris.length ; i++)
			uris[i] = URI.createFileURI(filePath[i]);
		
		openEditor(uris);
	}
	
	
	public static String[] openFilePathDialog(Shell shell, String[] fileExtensionFilter, int type) {
		FileDialog fileDialog = new FileDialog(shell, type);
		
		fileDialog.setFilterExtensions(fileExtensionFilter);

		fileDialog.open();
		if (fileDialog.getFileNames() != null && fileDialog.getFileNames().length > 0) {
			for(int i=0; i<fileDialog.getFileNames().length; i++){
				String fileName = fileDialog.getFileNames()[i];
				fileName = fileDialog.getFilterPath() + File.separator+fileName;
				fileDialog.getFileNames()[i] = fileName;
			}
			return fileDialog.getFileNames();
		}
		else {
			return null;
		}
	}
	
	public static  void openEditor(URI[] fileURIs) {
		//int filePathSize = filePath!=null?filePath.length:0;
		for(int i=0; i< fileURIs.length; i++){
			URI fileURI = fileURIs[i];
			String fileName = fileURI.toFileString();
			 
			if(fileName.endsWith(".crml")){
				File file = new File(fileName);
				if(file.isFile()){
					IWorkbench workbench = PlatformUI.getWorkbench();
					IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
					IWorkbenchPage page = workbenchWindow.getActivePage();
				
					IEditorDescriptor editorDescriptor = workbench.getEditorRegistry().getDefaultEditor(fileName);
					if (editorDescriptor == null) {
						MessageDialog.openError(
						workbenchWindow.getShell(),
						getString("_UI_Error_title"), 
						""); 
					}
					else if (!file.canWrite())
					{
						System.out.println("read-only: "+fileName);
						MessageDialog.openError(
								workbenchWindow.getShell(),
								getString("_UI_Error_title"),
								CenRepPlugin.INSTANCE.getString("_UI_ReadOnlyFileError_message", new Object[]{fileName})); 
					}
					else 
					{
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
									CenRepPlugin.INSTANCE.getString("_UI_ReadOnlyFile2Error_message", new Object[]{fileURI.toFileString()})); 
							return;
						}
						catch (Exception e)
						{
							
						}
						testFile = null;
						testFilePath = null;
						dirPath = null;

						try 
						{
							IEditorReference[] eRefs = page.getEditorReferences();
							IEditorReference theRef = null;
							for (int j = 0; j < eRefs.length&&theRef==null; j++) {
								theRef = eRefs[j];
								if(!theRef.getId().equals(CRBrowser.ID))theRef=null;
							}
							IFile iFile = DefaultProject.createLinkFile(fileURI);

							if(theRef!=null){
								page.reuseEditor((IReusableEditor)theRef.getPart(true), new CRBrowserEditorInput(iFile));
							}else
								page.openEditor(new CRBrowserEditorInput(iFile), editorDescriptor.getId(),true,IWorkbenchPage.MATCH_ID);
						}
						catch (PartInitException exception) {
							MessageDialog.openError(
							workbenchWindow.getShell(),
							getString("_UI_Error_title"), 
							exception.getMessage());
						}
					}
				}
			}
		}
	}
}
