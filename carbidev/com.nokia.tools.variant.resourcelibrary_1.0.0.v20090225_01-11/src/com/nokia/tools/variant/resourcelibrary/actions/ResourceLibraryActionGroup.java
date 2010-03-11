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
 * Description: This file is part of com.nokia.tools.variant.resourcelibrary component.
 */

package com.nokia.tools.variant.resourcelibrary.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.actions.ActionGroup;

import com.nokia.tools.variant.resourcelibrary.views.IResourceLibraryPage;

public class ResourceLibraryActionGroup extends ActionGroup {

	private IResourceLibraryPage page;

	/** Tree Viewer : expand all */
	private ExpandAllAction expandAllAction;
	/** Tree Viewer : collapse all */
	private CollapseAllAction collapseAllAction;

	private ImportResourceAction importResourceAction;
	private CopyResourceAction copyResourceAction;
	private MoveResourceAction moveResourceAction;
	private CreateFolderAction createFolderAction;
	private DeleteResourceAction deleteResourceAction;
	private RenameResourceAction renameResourceAction;
	
	private OpenEditorAction openAction;
	private OpenEditorAction openWithAction;
	
	private RefreshAction synchronizeAction;

	public ResourceLibraryActionGroup(IResourceLibraryPage page) {
		this.page = page;
		initActions();
	}

	protected void initActions() {
		expandAllAction = new ExpandAllAction(page);
		collapseAllAction = new CollapseAllAction(page);

		importResourceAction = new ImportResourceAction(page);

		copyResourceAction = new CopyResourceAction(page);
		moveResourceAction = new MoveResourceAction(page);
		createFolderAction = new CreateFolderAction(page);
		deleteResourceAction = new DeleteResourceAction(page);
		renameResourceAction = new RenameResourceAction(page);
		
		synchronizeAction = new RefreshAction(page);
		
		openAction = new OpenEditorAction(page, false);
		openWithAction = new OpenEditorAction(page, true);
	}

	@Override
	public void dispose() {
		
		super.dispose();
	}

	@Override
	public void fillActionBars(IActionBars actionBars) {
		actionBars.getToolBarManager().add(new Separator(IWorkbenchActionConstants.IMPORT_EXT));
		actionBars.getToolBarManager().add(deleteResourceAction);
		actionBars.getToolBarManager().add(importResourceAction);
		actionBars.getToolBarManager().add(new Separator(IWorkbenchActionConstants.GROUP_SHOW_IN));
		actionBars.getToolBarManager().add(expandAllAction);
		actionBars.getToolBarManager().add(collapseAllAction);
		actionBars.getToolBarManager().add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	@Override
	public void fillContextMenu(IMenuManager menu) {
		menu.add(new Separator(IWorkbenchActionConstants.NEW_GROUP));
		menu.add(createFolderAction);

		menu.add(new Separator(IWorkbenchActionConstants.OPEN_EXT));
		addIfEnabled(menu, openAction);
		addIfEnabled(menu, openWithAction);

		menu.add(new Separator(IWorkbenchActionConstants.FILE_START));
		addIfEnabled(menu, copyResourceAction);
		addIfEnabled(menu, moveResourceAction);
		addIfEnabled(menu, renameResourceAction);
		addIfEnabled(menu, deleteResourceAction);

		menu.add(new Separator(IWorkbenchActionConstants.IMPORT_EXT));
		menu.add(importResourceAction);
		menu.add(new Separator(IWorkbenchActionConstants.FILE_END));
		menu.add(new Separator(IWorkbenchActionConstants.EDIT_START));
		menu.add(new Separator(IWorkbenchActionConstants.EDIT_END));
		menu.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
		menu.add(synchronizeAction);
	}


    protected void addIfEnabled(IMenuManager menu, Action action) {
		if (action.isEnabled()) {
			menu.add(action);
		}
	}

	/**
     * Handles a key pressed event by invoking the appropriate action.
     */
    public void handleKeyPressed(KeyEvent event) {
        if (event.character == SWT.DEL && event.stateMask == 0) {
            if (deleteResourceAction.isEnabled()) {
            	deleteResourceAction.run();
            }

            // Swallow the event.
            event.doit = false;
        } 
    }
    
   
    
	@Override
	public void updateActionBars() {
		IStructuredSelection selection = (IStructuredSelection) getContext()
				.getSelection();

		// synch, expand all / collapse all are always enabled

		copyResourceAction.selectionChanged(selection);
		moveResourceAction.selectionChanged(selection);
		createFolderAction.selectionChanged(selection);
		deleteResourceAction.selectionChanged(selection);
		importResourceAction.selectionChanged(selection);
		renameResourceAction.selectionChanged(selection);

		openAction.selectionChanged(selection);
		openWithAction.selectionChanged(selection);

	}

	public DeleteResourceAction getDeleteResourceAction() {
		return deleteResourceAction;
	}

	public CopyResourceAction getCopyResourceAction() {
		return copyResourceAction;
	}

	public MoveResourceAction getMoveResourceAction() {
		return moveResourceAction;
	}

}
