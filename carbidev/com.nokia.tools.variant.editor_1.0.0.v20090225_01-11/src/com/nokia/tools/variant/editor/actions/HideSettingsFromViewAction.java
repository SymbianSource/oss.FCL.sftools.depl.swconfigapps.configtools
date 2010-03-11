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
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.nokia.tools.variant.content.confml.Group;
import com.nokia.tools.variant.content.confml.LeafGroup;
import com.nokia.tools.variant.content.confml.ParentGroup;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.View;
import com.nokia.tools.variant.editor.Activator;
import com.nokia.tools.variant.editor.commands.RemoveSettingFromGroupCommand;
import com.nokia.tools.variant.editor.commands.StructureCompoundCommand;
import com.nokia.tools.variant.editor.editors.CPFEditor;
import com.nokia.tools.variant.editor.model.UISetting;
import com.nokia.tools.variant.viewer.viewer.SettingsViewer;

/**

 * Action hides selected settings from a opened view, hence the mentioned view
 * in next opening of the CPF will not contain these settings. In this meaning,
 * this operation is for the users irreversible.
 */
public class HideSettingsFromViewAction extends Action {

	// selected objects in editor, cause elsewhere are not Settings used in an
	// eclipse selection
	private List<Setting> selectedObjects = new ArrayList<Setting>();
	private boolean removeFromAllGroups = true;
	// viewer displaying settings in the CPF editor
	SettingsViewer settingsViewer;

	private IWorkbenchWindow window;

	public HideSettingsFromViewAction() {

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

				Object firstElement = ss.getFirstElement();
				if (firstElement instanceof Setting) {
					setEnabled(false);
					setEnabled(true);
					return;
				}
			}
			if (isEnabled()) {
				setEnabled(true);
				setEnabled(false);
			}
		}
	};

	public void init(IWorkbenchWindow window) {
		this.window = window;
		ISelectionService selectionService = window.getSelectionService();
		selectionService.addSelectionListener(selectionChangeListener);
		setActionDefinitionId("com.nokia.tools.variant.editor.hide");
	}

	public HideSettingsFromViewAction(
			com.nokia.tools.variant.viewer.viewer.SettingsViewer settingsViewer2) {
		this.settingsViewer = settingsViewer2;
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
				hideSettingsFromViewGroup(selectedObjects);
			}
		} else {
			ISelection selection = settingsViewer.getSelection();
			takeSettingsFromSelection(selection);
			hideSettingsFromViewGroup(selectedObjects);
		}
	}

	private void hideSettingsFromViewGroup(List<Setting> settingsToReset) {
		CommandStack cs = (CommandStack) PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor()
				.getAdapter(CommandStack.class);
		CompoundCommand compoundCmd = new StructureCompoundCommand();
		IEditorPart activeEditor = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (activeEditor instanceof CPFEditor) {
			CPFEditor cpfEditor = (CPFEditor) activeEditor;
			View view = cpfEditor.getView();

			if (!containedInMultipleGroups(settingsToReset)) {

				removeSettingsFromAllGroups(settingsToReset, compoundCmd, view);
			} else if (dialogOK()) {
				if (removeFromAllGroups) {
					removeSettingsFromAllGroups(settingsToReset, compoundCmd,
							view);
				} else {
					removeSettingsFromCurrentGroup(settingsToReset, cpfEditor
							.getCurrentGroup(), compoundCmd);
					removeFromAllGroups = true;
				}

			} else {
				removeFromAllGroups = true;
				return;

			}
			cs.execute(compoundCmd);
		}
	}

	private void removeSettingsFromCurrentGroup(List<Setting> settingsToReset,
			Group currentGroup, CompoundCommand compoundCmd) {
		if (currentGroup != null) {
			for (Setting setting : settingsToReset) {
				RemoveSettingFromGroupCommand cmd = new RemoveSettingFromGroupCommand(
						currentGroup, setting);
				compoundCmd.add(cmd);
			}
		}
		if (currentGroup instanceof ParentGroup) {
			ParentGroup parentGroup = (ParentGroup) currentGroup;
			EList<LeafGroup> leafGroups = parentGroup.getLeafGroup();
			for (LeafGroup leafGroup : leafGroups) {
				for (Setting setting : settingsToReset) {
					RemoveSettingFromGroupCommand cmd = new RemoveSettingFromGroupCommand(
							leafGroup, setting);
					compoundCmd.add(cmd);
				}
			}
		}

	}

	private boolean dialogOK() {
		Dialog d = new Dialog(Display.getCurrent().getActiveShell()) {
			protected Control createDialogArea(Composite parent) {

				Composite control = new Composite(parent, SWT.NONE);
				control.setLayout(new GridLayout());
				Label label = new Label(control, SWT.NONE);
				label.setText("Remove settings from:");
				Button allGroupsButton = new Button(control, SWT.RADIO);
				allGroupsButton.setText("All groups");
				allGroupsButton.setSelection(true);
				allGroupsButton.addSelectionListener(new SelectionAdapter() {

					public void widgetSelected(SelectionEvent e) {
						removeFromAllGroups = true;
					}

				});
				Button selectedGroupButton = new Button(control, SWT.RADIO);
				selectedGroupButton.setText("Selected group");
				selectedGroupButton
						.addSelectionListener(new SelectionAdapter() {
							public void widgetSelected(SelectionEvent e) {
								removeFromAllGroups = false;
							}
						});
				return super.createDialogArea(parent);
			}

			@Override
			protected void configureShell(Shell newShell) {

				super.configureShell(newShell);

				newShell.setText("Multiple references for a setting found");

			}

			@Override
			protected Point getInitialSize() {

				return new Point(350, 150);
			}
		};

		if (d.open() == Dialog.OK) {
			return true;
		}

		return false;
	}

	private void removeSettingsFromAllGroups(List<Setting> settingsToReset,
			CompoundCommand compoundCmd, View view) {
		for (int i = 0; i < settingsToReset.size(); i++) {
			Setting setting = settingsToReset.get(i);
			// remove shared setting instance
//			RemoveSharedInstanceSettingFromViewCommand removeSharedSettingInstanceCommand = new RemoveSharedInstanceSettingFromViewCommand(
//					view, setting);
//			compoundCmd.add(removeSharedSettingInstanceCommand);

			// remove setting from each group which contains it
			EList<ParentGroup> parentGroups = setting.getParentGroup();
			for (ParentGroup parentGroup : parentGroups) {
				RemoveSettingFromGroupCommand cmd = new RemoveSettingFromGroupCommand(
						parentGroup, setting);
				compoundCmd.add(cmd);

			}
			EList<LeafGroup> leafGroups = setting.getLeafGroup();
			for (LeafGroup leafGroup : leafGroups) {
				RemoveSettingFromGroupCommand cmd = new RemoveSettingFromGroupCommand(
						leafGroup, setting);
				compoundCmd.add(cmd);
			}

		}
	}

	private boolean containedInMultipleGroups(List<Setting> settingsToReset) {

		for (Setting setting : settingsToReset) {
			EList<ParentGroup> parentGroups = setting.getParentGroup();
			if (parentGroups.size() > 1) {
				return true;
			}
			EList<LeafGroup> leafGroups = setting.getLeafGroup();
			if (leafGroups.size() > 1) {
				return true;
			}
			if (parentGroups.size() > 0 && leafGroups.size() > 0) {
				return true;
			}
		}
		return false;
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
					setting = getTopSetting(setting);
					selectedObjects.add(setting);
				} else if (o instanceof UISetting) {
					UISetting u = (UISetting) o;
					Setting setting = getTopSetting(u.getSetting());
					selectedObjects.add(setting);
				}
			}
		}
	}

	private Setting getTopSetting(Setting s) {
		EObject x = s;

		while (x != null && !(x.eContainer() instanceof View)) {

			x = x.eContainer();
		}
		return (Setting) x;
	}

	@Override
	public String getText() {
		return "Hide selected settings";
	}

	@Override
	public String getId() {
		return "Hide selected settings";
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		if (super.getImageDescriptor() == null) {
			setImageDescriptor(Activator
					.getImageDescriptor("icons/hidesettings_16_tlb.png"));
		}
		ImageDescriptor imageDescriptor = super.getImageDescriptor();
		return imageDescriptor;
	}

}
