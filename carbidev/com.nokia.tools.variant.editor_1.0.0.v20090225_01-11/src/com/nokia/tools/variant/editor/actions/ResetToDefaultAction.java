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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.nokia.tools.variant.content.confml.FilePath;
import com.nokia.tools.variant.content.confml.FileSystemEntrySetting;
import com.nokia.tools.variant.content.confml.SequenceItem;
import com.nokia.tools.variant.content.confml.SequenceSetting;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.SimpleSetting;
import com.nokia.tools.variant.content.confml.View;
import com.nokia.tools.variant.editor.Activator;
import com.nokia.tools.variant.editor.commands.AddSequenceItemCommand;
import com.nokia.tools.variant.editor.commands.ChangeFileSettingCommand;
import com.nokia.tools.variant.editor.commands.ChangeSettingValueCommand;
import com.nokia.tools.variant.editor.commands.RemoveSequenceItemCommand;
import com.nokia.tools.variant.editor.commands.SelectionCompoundCommand;
import com.nokia.tools.variant.editor.editors.CPFEditor;
import com.nokia.tools.variant.editor.model.UISetting;
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
public class ResetToDefaultAction extends Action {

	// selected objects in editor, cause elsewhere are not Settings used in an
	// eclipse selection
	private List<Setting> selectedObjects = new ArrayList<Setting>();
	private List<UISetting> selectedUISettings = new ArrayList<UISetting>();
	// viewer displaying settings in the CPF editor
	SettingsViewer settingsViewer;

	private IWorkbenchWindow window;

	public ResetToDefaultAction() {

	}

	public ResetToDefaultAction(SettingsViewer settingsViewer) {
		this.settingsViewer = settingsViewer;
	}

	public void dispose() {
		ISelectionService selectionService = window.getSelectionService();
		selectionService.removeSelectionListener(selectionChangeListener);
		settingsViewer = null;
	}

	private ISelectionListener selectionChangeListener = new ISelectionListener() {

		public void selectionChanged(IWorkbenchPart part, ISelection selection) {
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
		setActionDefinitionId("com.nokia.tools.variant.editor.resetToDefault");
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
				resetSettingsToDefault(selectedObjects);
			}
		} else { // RUN from popup menu - action has settingsViewer set by
			// constructor
			ISelection selection = settingsViewer.getSelection();
			takeSettingsFromSelection(selection);
			resetSettingsToDefault(selectedObjects);
			

		}
	}

	private String getValue(Setting setting) {
		if (setting instanceof SimpleSetting) {
			// Translation optionValue to value
			String choosenOption;
			choosenOption = ((SimpleSetting) setting).getChoosenOption();
			if (choosenOption != null && !"".equals(choosenOption)) {
				return choosenOption;
			}
			return ((SimpleSetting) setting).getValue();
		}
		if (setting instanceof FilePath) {
			// Translation optionValue to value
			String choosenOption;
			choosenOption = ((FilePath) setting).getChoosenOption();
			if (choosenOption != null && !"".equals(choosenOption)) {
				return choosenOption;
			}
			return ((FilePath) setting).getPath();
		}
		return null;
	}

	private void resetSettingsToDefault(List<Setting> settingsToReset) {
		CommandStack cs = (CommandStack) PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor()
				.getAdapter(CommandStack.class);
		CompoundCommand compoundCmd = new SelectionCompoundCommand(settingsToReset);
		Set<Setting> set = new HashSet<Setting>();
		for (int i = 0; i < settingsToReset.size(); i++) {
			Setting setting = settingsToReset.get(i);
			setting = getTopSetting(setting);
			if (set.contains(setting)) {
				continue;
			} else {
				set.add(setting);
			}
			if (setting.isDefault()) {
				continue;
			}
			if (setting instanceof SimpleSetting) {
				SimpleSetting ss = (SimpleSetting) setting;
				ChangeSettingValueCommand cmd = new ChangeSettingValueCommand(
						ss, ss.getDefaultValue(), false);
				compoundCmd.add(cmd);
			} else if (setting instanceof FilePath) {
				FilePath fs = (FilePath) setting;
				ChangeFileSettingCommand cmd = new ChangeFileSettingCommand(
				fs, fs.getDefaultPath(),false);
				
//				ChangeFileSettingSourceCommand sCmd = new ChangeFileSettingSourceCommand(
//						fs, fs.getDefaultSourcePath(),false);
//				ChangeFileSettingTargetCommand tCmd = new ChangeFileSettingTargetCommand(
//						fs, fs.getDefaultTargetPath(),false);
				compoundCmd.add(cmd);
			//	compoundCmd.add(tCmd);
			} else if (setting instanceof SequenceSetting) {
				SequenceSetting ss = (SequenceSetting) setting;

				// remove all items
				EList<SequenceItem> items2Remove = ss.getSequenceItem();
				int numItems = items2Remove.size();
				for (int j = numItems - 1; j >= 0; j--) {
					SequenceItem si = items2Remove.get(j);
					RemoveSequenceItemCommand riCmd = new RemoveSequenceItemCommand(
							ss, si);
					compoundCmd.add(riCmd);
				}

				// add default items
				EList<SequenceItem> defaultItemsStructure = ss
						.getDefaultStructure();
				for (int j = 0; j < defaultItemsStructure.size(); j++) {
					SequenceItem si = defaultItemsStructure.get(j);
					SequenceItem copy = (SequenceItem) EcoreUtil.copy(si);
					AddSequenceItemCommand aiCmd = new AddSequenceItemCommand(
							ss, copy);
					compoundCmd.add(aiCmd);
				}

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
			selectedUISettings = new ArrayList<UISetting>();
			for (int i = 0; i < list.size(); i++) {
				Object o = list.get(i);
				if (o instanceof Setting) {
					Setting setting = (Setting) o;
					selectedObjects.add(setting);
				} else if (o instanceof UISetting) {
					UISetting u = (UISetting) o;
					selectedObjects.add(u.getSetting());
					selectedUISettings.add(u);
				}
			}
		}
	}

	private Setting getTopSetting(Setting s) {
		if (s instanceof FilePath) {
			FilePath filePath = (FilePath) s;
			FileSystemEntrySetting parent = filePath.getParent();
			if (parent != null && !(parent.eContainer() instanceof SequenceItem))
				return filePath;

		}
		
		EObject x = s;
		while (x != null && !(x.eContainer() instanceof View)) {
			x = x.eContainer();
		}
		return (Setting) x;
	}

	@Override
	public String getText() {
		return "Reset to default";
	}

	@Override
	public String getId() {
		return "Reset to default";
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		if (super.getImageDescriptor() == null) {
			setImageDescriptor(Activator
					.getImageDescriptor("icons/resettodefault_16.png"));
		}
		ImageDescriptor imageDescriptor = super.getImageDescriptor();
		return imageDescriptor;
	}

	private boolean shouldBeEnabled(IStructuredSelection ss) {
		List<?> list = ss.toList();
		for (Object object : list) {
			if (object instanceof Setting) {
				return true;
			}
		}
		return false;
	}
}
