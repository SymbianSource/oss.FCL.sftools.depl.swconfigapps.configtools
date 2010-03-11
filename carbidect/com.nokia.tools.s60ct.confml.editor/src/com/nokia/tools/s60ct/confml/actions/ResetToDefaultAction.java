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
package com.nokia.tools.s60ct.confml.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CompoundCommand;
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

import com.nokia.tools.s60ct.confml.commands.ChangeSettingValueCommand;
import com.nokia.tools.s60ct.confml.editor.Activator;
import com.nokia.tools.s60ct.confml.viewer.FeatureViewer;
import com.nokia.tools.s60ct.model.confml.EResourceSetting;
import com.nokia.tools.s60ct.model.confml.EResourceValue;
import com.nokia.tools.s60ct.model.confml.ESetting;
import com.nokia.tools.s60ct.model.confml.ESimpleSetting;
import com.nokia.tools.s60ct.model.confml.ESimpleValue;
import com.nokia.tools.s60ct.model.confml.presentation.ConfmlEditor;
/**
 * ResetToDefault action resets selected settings in editor to a default value.
 * Action works in 2 modes: 1) as action contributed to toolbar, which listens
 * to the selection done in editor. There is one such action for whole eclipse
 * window. 2) as action contributed to settingsViewer, which is displayed in the
 * popup menu whenever user right clicks mouse in on any of the widgets in
 * settings viewer. In this mode action takes settings to reset from
 * settingsViewer
 * 
 * @author vitasjan
 * 
 */
public class ResetToDefaultAction extends Action {

	private List<ESetting> selectedObjects = new ArrayList<ESetting>();
	FeatureViewer featureViewer;

	private IWorkbenchWindow window;

	public ResetToDefaultAction(FeatureViewer featureViewer) {
		this.featureViewer = featureViewer;
	}

	public void dispose() {
		ISelectionService selectionService = window.getSelectionService();
		selectionService.removeSelectionListener(selectionChangeListener);
		featureViewer = null;
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
	}

	public void run() {
		if (featureViewer == null) {// RUN from global toolbar - action
			// acquires settingsViewer from active
			// editor
			IEditorPart activeEditor = window.getActivePage().getActiveEditor();
			if (activeEditor instanceof ConfmlEditor) {
				ConfmlEditor confmlEditor = (ConfmlEditor) activeEditor;
				FeatureViewer fv = confmlEditor.getFeatureViewer();
				ISelection selection = fv.getSelection();
				
				takeSettingsFromSelection(selection);
				resetSettingsToDefault(selectedObjects);

				ESetting setting = selectedObjects.get(0);
				if (setting instanceof ESimpleSetting)
				{
					ESimpleSetting ss = (ESimpleSetting)setting;
					String value = getValue(ss);
					fv.fireValueChanged(value, setting);
				}
				else if (setting instanceof EResourceSetting)
				{
					EResourceSetting rs = (EResourceSetting)setting;
					String value = getValue(rs);
					fv.fireValueChanged(value, setting);
				}
				
			}
		} else { // RUN from popup menu - action has settingsViewer set by
			// constructor
			ISelection selection = featureViewer.getSelection();
			
			takeSettingsFromSelection(selection);
			resetSettingsToDefault(selectedObjects);
			
			ESetting setting = selectedObjects.get(0);
			if (setting instanceof ESimpleSetting)
			{
				ESimpleSetting ss = (ESimpleSetting)setting;
				String value = getValue(ss);
				featureViewer.fireValueChanged(value, setting);
			}
			else if (setting instanceof EResourceSetting)
			{
				EResourceSetting rs = (EResourceSetting)setting;
				String value = getValue(rs);
				featureViewer.fireValueChanged(value, setting);
			}
		}
	}

	private String getValue(ESimpleSetting setting) {
		ESimpleValue settingValue = (ESimpleValue)setting.getValue();
		return settingValue.getTrueValue();
	}
	private String getValue(EResourceSetting setting) {
		EResourceValue resourceValue = (EResourceValue)setting.getValue();
		return ((ESimpleValue)resourceValue.getLocalPath()).getValue();
	}

	private void resetSettingsToDefault(List<ESetting> settingsToReset) {
		CommandStack cs = (CommandStack) PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor()
				.getAdapter(CommandStack.class);
		CompoundCommand compoundCmd = new CompoundCommand();
		for (int i = 0; i < settingsToReset.size(); i++) {
			ESetting setting = settingsToReset.get(i);
			
			if (setting instanceof ESimpleSetting)
			{
				ESimpleValue defaultValue = (ESimpleValue) setting.getDefaultValue();
				String dValue = defaultValue.getTrueValue();
				if (defaultValue==null || dValue==null) {
					continue;
				}
				
				ESimpleSetting ss = (ESimpleSetting) setting;
				ChangeSettingValueCommand cmd = new ChangeSettingValueCommand(
						(ESimpleValue)ss.getValue(), dValue);
				compoundCmd.append(cmd);
				ss.setSetdefault(true);
			}
			else if (setting instanceof EResourceSetting)
			{
				EResourceValue defaultValue = (EResourceValue) setting.getDefaultValue();
				
				String dValue = ((ESimpleValue)defaultValue.getLocalPath()).getValue();
				if (defaultValue==null || dValue==null) {
					continue;
				}
				
				EResourceSetting rs = (EResourceSetting) setting;
				EResourceValue resVal = (EResourceValue)rs.getValue();
				ChangeSettingValueCommand cmd = new ChangeSettingValueCommand(
						(ESimpleValue)resVal.getLocalPath(), dValue);
				compoundCmd.append(cmd);
				rs.setSetdefault(true);
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
		selectedObjects.clear();
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection ss = (IStructuredSelection) selection;
			List<?> list = ss.toList();
			selectedObjects = new ArrayList<ESetting>();
			for (int i = 0; i < list.size(); i++) {
				Object o = list.get(i);
				if (o instanceof ESimpleSetting) {
					ESimpleSetting setting = (ESimpleSetting) o;
					selectedObjects.add(setting);
				}
				else if (o instanceof EResourceSetting)
				{
					EResourceSetting setting = (EResourceSetting)o;
					selectedObjects.add(setting);
				}
			}
		}
	}

	@Override
	public String getText() {
		return "Reset to Default";
	}

	@Override
	public String getId() {
		return "Reset to Default";
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
			if (object instanceof ESimpleSetting) {
				ESimpleSetting sSetting = (ESimpleSetting) object;
				if(!sSetting.isDefault()) {
					return true;					
				}
			}
			else if (object instanceof EResourceSetting) {
				EResourceSetting rSetting = (EResourceSetting) object;
				if(!rSetting.isDefault()) {
					return true;					
				}
			}
		}
		return false;
	}
}
