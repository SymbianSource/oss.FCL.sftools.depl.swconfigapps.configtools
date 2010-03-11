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

package com.nokia.tools.variant.editor.actions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.nokia.tools.variant.content.confml.FilePath;
import com.nokia.tools.variant.content.confml.FileSystemEntrySetting;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.SimpleSetting;
import com.nokia.tools.variant.content.confml.TYPE;
import com.nokia.tools.variant.editor.commands.ChangeFileSettingCommand;
import com.nokia.tools.variant.editor.commands.ChangeSettingValueCommand;
import com.nokia.tools.variant.editor.dialogs.ResourcePickDialog;
import com.nokia.tools.variant.editor.editors.CPFEditor;
import com.nokia.tools.variant.editor.model.UISetting;
import com.nokia.tools.variant.resourcelibrary.model.Directory;
import com.nokia.tools.variant.resourcelibrary.model.File;
import com.nokia.tools.variant.resourcelibrary.model.FileSystemElement;
import com.nokia.tools.variant.viewer.actions.EditorAction;

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
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		CommandStack cs = (CommandStack) PlatformUI.getWorkbench()
		.getActiveWorkbenchWindow().getActivePage().getActiveEditor()
		.getAdapter(CommandStack.class);

		Shell sh = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getShell();
		UISetting ui = (UISetting) widget.getData();
		EObject container = ui.eContainer();
		if (container instanceof UISetting
				&& !(container.eContainer() instanceof UISetting)) {
			UISetting uiSetting = (UISetting) container;
			FileSystemEntrySetting setting = (FileSystemEntrySetting) uiSetting
					.getSetting();

			ResourcePickDialog dialog = new ResourcePickDialog(sh, !setting
					.isFile(), "");
			dialog.open();
			Object result = dialog.getFirstResult();
			if ((result instanceof File) && (setting.isFile())) {
				File file = (File) result;
				String fullPath = file.getPath();
				fullPath = fullPath.replaceAll("\\\\", "/");
				ChangeFileSettingCommand cmd = new ChangeFileSettingCommand(setting.getSourceFilePath(),
						fullPath, true);
				cs.execute(cmd);
				fireSelectionOnEditor(setting.getSourceFilePath());
			} else if ((result instanceof Directory) && (!setting.isFile())) {
				Directory directory = (Directory) result;
				String fullPath = directory.getPath();
				fullPath = fullPath.replaceAll("\\\\", "/");
				ChangeFileSettingCommand cmd = new ChangeFileSettingCommand(setting.getSourceFilePath(),
						fullPath, true);
				cs.execute(cmd);
				fireSelectionOnEditor(setting.getSourceFilePath());
			}
		} else {
			Setting setting = ui.getSetting();
			ResourcePickDialog dialog;
			if (setting instanceof FileSystemEntrySetting) {
				FileSystemEntrySetting file = (FileSystemEntrySetting) setting;
				if (file.isFile()) {
					dialog = new ResourcePickDialog(sh, false, "");
				} else {
					dialog = new ResourcePickDialog(sh, true, "");
				}
			} else if (setting.getType() == TYPE.FILE) {
				dialog = new ResourcePickDialog(sh, false, "");
			} else if (setting.getType() == TYPE.SIMPLE_FILE) {
				String pattern = "";
				if (setting instanceof SimpleSetting) {
					SimpleSetting ss = (SimpleSetting) setting;
					pattern = ss.getPattern();
				}
				dialog = new ResourcePickDialog(sh, false, pattern);
			} else {
				dialog = new ResourcePickDialog(sh, true, "");
			}
			dialog.open();
			Object result = dialog.getFirstResult();
			if (result instanceof File) {
				if (setting instanceof SimpleSetting) {
					File file = (File) result;
					String path = file.getPath();
					path = path.replaceAll("\\\\", "/");
					ChangeSettingValueCommand cmd = new ChangeSettingValueCommand(
							(SimpleSetting) setting, path, true);
					cs.execute(cmd);
					fireSelectionOnEditor(setting);
				}
			}
			if (result instanceof Directory) {
				if (setting instanceof SimpleSetting) {
					Directory file = (Directory) result;
					String path = file.getPath();
					path = path.replaceAll("\\\\", "/");
					ChangeSettingValueCommand cmd = new ChangeSettingValueCommand(
							(SimpleSetting) setting, path, true);
					cs.execute(cmd);
					fireSelectionOnEditor(setting);
				}
			}
		}
	}

	/**
	 * Fires selection on given setting at <code>com.nokia.tools.variant.editor.editors.CPFEditor</code>.
	 * @param setting
	 */
	private void fireSelectionOnEditor(Setting setting) {
		CPFEditor editor = (CPFEditor) PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		editor.fireSelection(new SelectionChangedEvent(editor,
				new StructuredSelection(setting)));
	}

	@Override
	public void initSelectionListener() {
		// do nothing
	}
}
