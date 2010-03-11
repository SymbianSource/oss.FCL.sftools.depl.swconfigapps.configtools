package com.nokia.tools.s60ct.confml.actions;
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
 * Description: This file is part of com.nokia.tools.variant.editor component.
 */

import java.util.ArrayList;

import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.nokia.tools.s60ct.confml.editor.PluginImages;
import com.nokia.tools.s60ct.confml.widgets.ResourcePickDialog;
import com.nokia.tools.s60ct.model.confml.EResourceKind;
import com.nokia.tools.s60ct.model.confml.EResourceSetting;
import com.nokia.tools.s60ct.model.confml.ESetting;
import com.nokia.tools.s60ct.model.confml.impl.EResourceValueImpl;
import com.nokia.tools.s60ct.model.confml.impl.ESimpleValueImpl;
import com.nokia.tools.s60ct.model.confml.presentation.ConfmlEditor;
import com.nokia.tools.s60ct.resources.model.ELibraryDirectory;
import com.nokia.tools.s60ct.resources.model.ELibraryFile;


/**
 * Action servers for choosing resource from the resource library of Carbide.V
 * via <code>com.nokia.tools.variant.editor.dialogs.ResourcePickDialog</code>.
 * After selecting the resource the selection is fired on the setting
 * <code>com.nokia.tools.variant.editor.editors.CPFEditor</code>.
 */
public class BrowseFileAction extends EditorAction {

	/**
	 * Constructor set action text.
	 */
	public BrowseFileAction() {
		setText("Browse");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() 
	{
		CommandStack cs = (CommandStack) PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor()
				.getAdapter(CommandStack.class);

		Shell sh = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getShell();
		
		Object widgetData = widget.getData();
		ESetting data = null;
		if (widgetData instanceof ESetting)
		{
			data = (ESetting)widgetData;
		}
		else if (widgetData instanceof ESimpleValueImpl)
		{
			ESimpleValueImpl simpleValue = (ESimpleValueImpl)widgetData;
			data = simpleValue.getType();
		}
		else if (widgetData instanceof EResourceValueImpl)
		{
			EResourceValueImpl resValue = (EResourceValueImpl)widgetData;
			data = resValue.getType();
		}
		
		if (data instanceof EResourceSetting)
		{
			EResourceSetting resSetting = (EResourceSetting)data;
			
			boolean isFile = false;
			boolean isFolder = false;
			
			if (resSetting.getKind().getValue() == EResourceKind.FILE_VALUE)
				isFile = true;
			
			if (resSetting.getKind().getValue() == EResourceKind.FOLDER_VALUE)
				isFolder = true;
			
			ResourcePickDialog dialog = new ResourcePickDialog(sh, isFolder, new ArrayList<String>());
			dialog.open();
			Object result = dialog.getFirstResult();
			
			if (result instanceof ELibraryFile && isFile)
			{
				ELibraryFile file = (ELibraryFile) result;
				String fullPath = file.getPath();
				fullPath = fullPath.replaceAll("\\\\", "/");
				
				widget.setValue(fullPath);
//				ChangeFileSettingCommand cmd = new ChangeFileSettingCommand(
//						setting.getSourceFilePath(), fullPath, true);
//				cs.execute(cmd);
//				fireSelectionOnEditor(setting.getSourceFilePath());
			} 
			else if (result instanceof ELibraryDirectory) 
			{
				ELibraryDirectory directory = (ELibraryDirectory) result;
				String fullPath = directory.getPath();
				fullPath = fullPath.replaceAll("\\\\", "/");
				
				widget.setValue(fullPath);
				
//				ChangeFileSettingCommand cmd = new ChangeFileSettingCommand(
//						setting.getSourceFilePath(), fullPath, true);
//				cs.execute(cmd);
//				fireSelectionOnEditor(setting.getSourceFilePath());
			}
		}
	}

	/**
	 * Fires selection on given setting at
	 * <code>com.nokia.tools.variant.editor.editors.CPFEditor</code>.
	 * 
	 * @param setting
	 */
	private void fireSelectionOnEditor(Setting setting) {
		ConfmlEditor editor = (ConfmlEditor) PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		
//		editor.fireSelection(new SelectionChangedEvent(editor,new StructuredSelection(setting)));
	}

	
	@Override
	public ImageDescriptor getDisabledImageDescriptor() {
		return super.getDisabledImageDescriptor();
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return PluginImages.BROWSE;
		
	}

	@Override
	public boolean isEnabled() {
		
		return !widget.isGrayed();
	}

	@Override
	public void initSelectionListener() {
		// do nothing
	}
}
