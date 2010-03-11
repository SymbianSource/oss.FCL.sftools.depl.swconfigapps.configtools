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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.actions.BaseSelectionListenerAction;

import com.nokia.tools.variant.common.ui.utils.SWTUtil;
import com.nokia.tools.variant.resourcelibrary.Activator;
import com.nokia.tools.variant.resourcelibrary.handlers.commands.RemoveCommand;
import com.nokia.tools.variant.resourcelibrary.handlers.commands.ResourceLibraryCommandHelper;
import com.nokia.tools.variant.resourcelibrary.model.FileSystemElement;
import com.nokia.tools.variant.resourcelibrary.views.IResourceLibraryPage;
import com.nokia.tools.variant.resourcelibrary.views.ResourceStorage;

public class DeleteResourceAction extends BaseSelectionListenerAction {
	public static final String DELETE_CONFIRMATION_STRING = "Delete selected resources?";

	private IResourceLibraryPage page;

	public DeleteResourceAction(IResourceLibraryPage page) {
		super("Delete");
		setImageDescriptor(Activator.getImageDescriptor("icons/delete_16_tlb.png"));
		this.page = page;
	}

	@Override
	protected boolean updateSelection(IStructuredSelection selection) {
		if (selection.isEmpty()) {
			return false;
		}
		
		for (Object obj : selection.toArray()) {
			if (!(obj instanceof ResourceStorage)) {
				return false;
			}
			FileSystemElement element = ((ResourceStorage)obj).getFileSystemElement();
			if (ResourceLibraryCommandHelper.checkModifyStatus(element) != ResourceLibraryCommandHelper.STATUS_OK || element.touchedByReadonlySetting()) {
				return false;
			}
		}
		
		return true;
	}

	@Override
	public void run() {
		CommandStack stack = page.getCommandStack();
		IStructuredSelection sel = getStructuredSelection();

		List<ResourceStorage> resources = new ArrayList<ResourceStorage>();
		for (Object obj : sel.toArray()) {
			if (obj instanceof ResourceStorage) {
				resources.add((ResourceStorage) obj);
			}
		}

		Shell shell = SWTUtil.getStandardDisplay().getActiveShell();

		// Fetch a handle for progress monitor

		List<FileSystemElement> elements = new ArrayList<FileSystemElement>();
		for (Object obj : sel.toArray()) {
			if (obj instanceof ResourceStorage) {
				FileSystemElement element = ((ResourceStorage) obj)
						.getFileSystemElement();
				elements.add(element);
			}
		}

		Command command = RemoveCommand.createResourceRemove(elements);
		if (command.canExecute()) {
			// Warn the user
			MessageBox messageBox = new MessageBox(shell, SWT.ICON_QUESTION | SWT.OK
					| SWT.CANCEL);
			messageBox.setText("Deleting resources");
			messageBox.setMessage(DELETE_CONFIRMATION_STRING);
			if (messageBox.open() != SWT.OK) {
				command.dispose();
				return;
			}

			stack.execute(command);
		} else {
			command.dispose();
		}
	}
}
