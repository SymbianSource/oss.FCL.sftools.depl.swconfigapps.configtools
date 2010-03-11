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

package com.nokia.tools.variant.editor.actionbars;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.SubCoolBarManager;
import org.eclipse.jface.action.ToolBarContributionItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.internal.EditorActionBars;
import org.eclipse.ui.internal.PluginAction;
import org.eclipse.ui.internal.PluginActionCoolBarContributionItem;
import org.eclipse.ui.internal.WWinPluginAction;
import org.eclipse.ui.part.EditorActionBarContributor;

import com.nokia.tools.variant.editor.actions.DeselectAllSettingsAction;
import com.nokia.tools.variant.editor.actions.HideSettingsFromViewAction;
import com.nokia.tools.variant.editor.actions.ResetToDefaultAction;
import com.nokia.tools.variant.editor.actions.SelectAllSettingsAction;
import com.nokia.tools.variant.editor.editors.CPFEditor;

public class CPFEditorActionBarContributor extends EditorActionBarContributor {

	private IWorkbenchAction undo;
	private IWorkbenchAction redo;
	private SelectAllSettingsAction selectAll;
	private DeselectAllSettingsAction deselectAll;
	private HideSettingsFromViewAction hideSettingsFromView;
	private ResetToDefaultAction resetToDefault;
	private CPFEditor editor;

	public CPFEditorActionBarContributor() {

	}

	@Override
	public void setActiveEditor(IEditorPart targetEditor) {
		// IActionBars bars = getActionBars();
		// if (bars == null)
		// return;
		//		
		// bars.updateActionBars();

		if (targetEditor instanceof CPFEditor) {
			editor = (CPFEditor) targetEditor;
			registerUndoRedo();
		}

		super.setActiveEditor(targetEditor);
	}

	/**
	 * Hooks Undo/Redo to global Undo/Redo.
	 */
	public void registerUndoRedo() {
		IActionBars actionBars = getActionBars();
		if (actionBars != null) {
			ActionRegistry registry = editor.getActionRegistry();
			if (registry != null) {
				actionBars.setGlobalActionHandler(ActionFactory.UNDO.getId(),
						registry.getAction(ActionFactory.UNDO.getId()));
				actionBars.setGlobalActionHandler(ActionFactory.REDO.getId(),
						registry.getAction(ActionFactory.REDO.getId()));
			}
			actionBars.updateActionBars();

		}
	}

	@Override
	public void contributeToToolBar(IToolBarManager toolBarManager) {
		createDelegateForReportAction();
		undo = ActionFactory.UNDO.create(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow());
		redo = ActionFactory.REDO.create(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow());
		// create actions
		selectAll = SelectAllSettingsAction.getInstance();//new SelectAllSettingsAction();
		deselectAll = new DeselectAllSettingsAction();
		hideSettingsFromView = new HideSettingsFromViewAction();
		resetToDefault = new ResetToDefaultAction();

		IWorkbenchWindow window = getPage().getWorkbenchWindow();
		selectAll.init(window);
		deselectAll.init(window);
		hideSettingsFromView.init(window);
		resetToDefault.init(window);

		disableActions();

		toolBarManager.add(undo);
		toolBarManager.add(redo);
		toolBarManager.add(selectAll);
		toolBarManager.add(deselectAll);
		toolBarManager.add(resetToDefault);
		toolBarManager.add(hideSettingsFromView);

		super.contributeToToolBar(toolBarManager);
	}

	/**
	 * This method creates delegate for Create report button. This delegate sets
	 * enable/disable state of the button.
	 * 
	 */
	@SuppressWarnings("restriction")
	private void createDelegateForReportAction() {
		EditorActionBars actionBars = (EditorActionBars) getActionBars();
		SubCoolBarManager coolBarManager = (SubCoolBarManager) actionBars
				.getCoolBarManager();
		IContributionManager parent = coolBarManager.getParent();
		IContributionItem[] items = parent.getItems();
		ToolBarContributionItem contributionItem = (ToolBarContributionItem) items[0];
		IToolBarManager toolBarManager2 = contributionItem.getToolBarManager();
		IContributionItem[] items2 = toolBarManager2.getItems();
		PluginActionCoolBarContributionItem contributionItem3 = null;
		for (IContributionItem contributionItem2 : items2) {
			if (("com.nokia.tools.variant.report.actions.GenerateReportAction")
					.equals(contributionItem2.getId())) {
				contributionItem3 = (PluginActionCoolBarContributionItem) contributionItem2;
				break;
			}
		}
		if (contributionItem3 == null){
			return;
		}
		WWinPluginAction action = (WWinPluginAction) contributionItem3
				.getAction();
		try {
			Method declaredMethod = PluginAction.class
					.getDeclaredMethod("createDelegate");
			declaredMethod.setAccessible(true);
			declaredMethod.invoke(action);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Disables actions and waits on change in selection to enable them
	 */
	private void disableActions() {

		if (deselectAll.isEnabled()) {
			deselectAll.setEnabled(true);
			deselectAll.setEnabled(false);
		}

		if (hideSettingsFromView.isEnabled()) {
			hideSettingsFromView.setEnabled(true);
			hideSettingsFromView.setEnabled(false);
		}

		if (resetToDefault.isEnabled()) {
			resetToDefault.setEnabled(true);
			resetToDefault.setEnabled(false);
		}

	}

	@Override
	public void init(IActionBars bars, IWorkbenchPage page) {
		super.init(bars, page);
	}

	@Override
	public void dispose() {
		selectAll.dispose();
		deselectAll.dispose();
		resetToDefault.dispose();
		hideSettingsFromView.dispose();
		editor = null;
		super.dispose();
	}
}
