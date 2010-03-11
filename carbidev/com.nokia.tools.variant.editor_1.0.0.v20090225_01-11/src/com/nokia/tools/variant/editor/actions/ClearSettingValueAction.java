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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.commands.ActionHandler;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerService;

import com.nokia.tools.variant.content.confml.FilePath;
import com.nokia.tools.variant.content.confml.FileSystemEntrySetting;
import com.nokia.tools.variant.content.confml.SequenceSetting;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.SimpleSetting;
import com.nokia.tools.variant.content.confml.TYPE;
import com.nokia.tools.variant.content.confml.View;
import com.nokia.tools.variant.editor.commands.ChangeFileSettingCommand;
import com.nokia.tools.variant.editor.commands.ChangeSettingValueCommand;
import com.nokia.tools.variant.editor.commands.SelectionCompoundCommand;
import com.nokia.tools.variant.editor.editors.CPFEditor;
import com.nokia.tools.variant.editor.model.UISetting;
import com.nokia.tools.variant.editor.model.impl.UISettingImpl;
import com.nokia.tools.variant.viewer.viewer.SettingsViewer;

/**
 * ResetToDefault action resets selected settings in editor to a default value.
 * Action works in 2 modes: 1) as action contributed to toolbar, which listens
 * to the selection done in editor. There is one such action for whole eclipse
 * window. 2) as action contributed to settingsViewer, which is displayed in the
 * popup menu whenever user right clicks mouse in on any of the widgets in
 * settings viewer. In this mode action takes settings to reset from
 * settingsViewer
 * 
 */
public class ClearSettingValueAction extends Action {
	private boolean activated;
	// selected objects in editor, cause elsewhere are not Settings used in an
	// eclipse selection
	private List<Setting> selectedObjects = new ArrayList<Setting>();

	// viewer displaying settings in the CPF editor
	SettingsViewer settingsViewer;

	private IWorkbenchWindow window;

	public ClearSettingValueAction() {

	}

	public ClearSettingValueAction(SettingsViewer settingsViewer) {
		this.settingsViewer = settingsViewer;
	}

	public void dispose() {
		ISelectionService selectionService = window.getSelectionService();
		selectionService.removeSelectionListener(selectionChangeListener);
		settingsViewer = null;
	}

	private ISelectionListener selectionChangeListener = new ISelectionListener() {

		

		public void selectionChanged(IWorkbenchPart part, ISelection selection) {
			if(!activated&&part instanceof CPFEditor){
				IHandlerService hs = (IHandlerService)part.getSite().getService(IHandlerService.class);
				hs.activateHandler("com.nokia.tools.variant.editor.clearValue", new ActionHandler(ClearSettingValueAction.this));
				activated = true;
			}
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection ss = (IStructuredSelection) selection;
				Boolean enabled = shouldBeEnabled(ss);
				setEnabled(!enabled);
				setEnabled(enabled);

			}
		}
	};

	public void init(IWorkbenchWindow window) {
		this.window = window;
		ISelectionService selectionService = window.getSelectionService();
		selectionService.addSelectionListener(selectionChangeListener);
		setActionDefinitionId("com.nokia.tools.variant.editor.clearValue"); 
		
	}

	public void run() {
		if (settingsViewer == null) {// RUN from global toolbar - action
			// acquires settingsViewer from active
			// editor
			IEditorPart activeEditor = window.getActivePage().getActiveEditor();
			if (activeEditor instanceof CPFEditor) {
				CPFEditor cpfEditor = (CPFEditor) activeEditor;
				SettingsViewer sv = cpfEditor.getSettingsViewer();
				ISelection selection = sv.getSelection();
				takeSettingsFromSelection(selection);
				clearSettingsValue(selectedObjects);
			}
		} else { // RUN from popup menu - action has settingsViewer set by
			// constructor
			ISelection selection = settingsViewer.getSelection();
			takeSettingsFromSelection(selection);
			clearSettingsValue(selectedObjects);
		}
	}

	private void clearSettingsValue(List<Setting> settingsToClear) {
		CommandStack cs = (CommandStack) PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor()
				.getAdapter(CommandStack.class);
		CompoundCommand compoundCmd = new SelectionCompoundCommand(settingsToClear);
		Set<Setting> set = new HashSet<Setting>();
		for (int i = 0; i < settingsToClear.size(); i++) {
			Setting setting = settingsToClear.get(i);
			setting = getTopSetting(setting);
			if (set.contains(setting)) {
				continue;
			} else {
				set.add(setting);
			}
			if (setting instanceof SimpleSetting) {
				SimpleSetting ss = (SimpleSetting) setting;
				TYPE type = ss.getType();
				if (type.equals(TYPE.STRING) || type.equals(TYPE.SIMPLE_FILE)
						|| type.equals(TYPE.SIMPLE_FOLDER)) {
					ChangeSettingValueCommand cmd = new ChangeSettingValueCommand(
							ss, "", true);
					compoundCmd.add(cmd);
				}
			} else if (setting instanceof FilePath) {
				FilePath fs = (FilePath) setting;
				ChangeFileSettingCommand cmd = new ChangeFileSettingCommand(fs,
						"", true);
				compoundCmd.add(cmd);

			} else if (setting instanceof SequenceSetting) {

				/*
				 * Clear value should clear only selected subsetting(s) not
				 * whole sequence.
				 */

				// SequenceSetting sequence = (SequenceSetting) setting;
				// EList<SequenceItem> items = sequence.getSequenceItem();
				// for (SequenceItem item : items) {
				// EList<Setting> settings = item.getSetting();
				for (Setting se : selectedObjects) {
					if (se instanceof SimpleSetting) {
						SimpleSetting ss = (SimpleSetting) se;
						TYPE type = ss.getType();
						if (type.equals(TYPE.STRING)
								|| type.equals(TYPE.SIMPLE_FILE)
								|| type.equals(TYPE.SIMPLE_FOLDER)) {
							ChangeSettingValueCommand cmd = new ChangeSettingValueCommand(
									ss, "", true);
							compoundCmd.add(cmd);
						}
					} else if (se instanceof FilePath) {
						FilePath fs = (FilePath) se;
						ChangeFileSettingCommand sCmd = new ChangeFileSettingCommand(
								fs, "", true);
						ChangeFileSettingCommand tCmd = new ChangeFileSettingCommand(
								fs, "", true);
						compoundCmd.add(sCmd);
						compoundCmd.add(tCmd);
					}
				}
				// }
			}
		}
		cs.execute(compoundCmd);
	}

	public void selectionChanged(IAction action, ISelection selection) {
		takeSettingsFromSelection(selection);
		setEnabled(selectedObjects.size() == 0);
		setEnabled(selectedObjects.size() > 0);
	}

	private void takeSettingsFromSelection(ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection s = (IStructuredSelection) selection;
			List<?> list = s.toList();
			selectedObjects = new ArrayList<Setting>();
			for (int i = 0; i < list.size(); i++) {
				Object o = list.get(i);
				if (o instanceof Setting) {
					Setting setting = (Setting) o;
					selectedObjects.add(setting);
				} else if (o instanceof UISettingImpl) {
					UISetting u = (UISetting) o;
					selectedObjects.add(u.getSetting());
				}
			}
		}
	}

	private Setting getTopSetting(Setting s) {
		if (s instanceof FilePath) {
			return s;
		}
		EObject x = s;
		while (x != null && !(x.eContainer() instanceof View)) {
			x = x.eContainer();
		}
		return (Setting) x;
	}

	@Override
	public String getText() {
		return "Clear value";
	}

	@Override
	public String getId() {
		return "Clear value";
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		ImageDescriptor imageDescriptor = super.getImageDescriptor();
		return imageDescriptor;
	}

	private boolean shouldBeEnabled(IStructuredSelection ss) {
		boolean enabled = false;
		List<?> list = ss.toList();
		for (Object object : list) {
			if (object instanceof SimpleSetting) {
				SimpleSetting setting = (SimpleSetting) object;
				TYPE type = setting.getType();
				if (!(type.equals(TYPE.STRING) || type.equals(TYPE.SIMPLE_FILE) || type
						.equals(TYPE.SIMPLE_FOLDER))) {
					enabled = false;
					break;
				} else {
					enabled = true;
				}
			} else if (object instanceof FileSystemEntrySetting) {
				enabled = true;
			}
		}
		return enabled;
	}
}
