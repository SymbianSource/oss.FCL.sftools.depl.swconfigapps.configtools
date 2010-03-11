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
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.actions.BaseSelectionListenerAction;
import org.eclipse.ui.part.IPage;

import com.nokia.tools.variant.resourcelibrary.handlers.commands.CopyResourcesCommand;
import com.nokia.tools.variant.resourcelibrary.handlers.commands.ResourcePickDialog;
import com.nokia.tools.variant.resourcelibrary.model.Directory;
import com.nokia.tools.variant.resourcelibrary.model.FileSystemElement;
import com.nokia.tools.variant.resourcelibrary.views.IResourceLibraryPage;
import com.nokia.tools.variant.resourcelibrary.views.ResourceStorage;

public class CopyResourceAction extends BaseSelectionListenerAction {

	private IResourceLibraryPage page;

	public CopyResourceAction(IResourceLibraryPage page) {
		super("Create Copy");
		// setImageDescriptor(Activator.getImageDescriptor("icons/collapseall.gif"));
		this.page = page;
	}

	@Override
	protected boolean updateSelection(IStructuredSelection selection) {
		return !selection.isEmpty();
	}
	
	@Override
	public void run() {
		CommandStack stack = page.getCommandStack();
		IStructuredSelection sel = getStructuredSelection();

		List<ResourceStorage> resources = new ArrayList<ResourceStorage>();
		for (Object obj: sel.toArray()) {
			if (obj instanceof ResourceStorage) {
				resources.add((ResourceStorage)obj);
			}
		}
		
		Shell shell = ((IPage)page).getControl().getShell();
		
		ResourcePickDialog dialog = new ResourcePickDialog(shell, true, "", resources);
		if (dialog.open() != IDialogConstants.OK_ID) {
			return;
		}
		
		Object result = dialog.getFirstResult(); // target file/folder
		if (result instanceof Directory) {
			Directory target = (Directory) result;
			List<FileSystemElement> sources = new ArrayList<FileSystemElement>();
			for (ResourceStorage storage: resources) {
				sources.add(storage.getFileSystemElement());
			}
			Command command;
			if (sources.size() == 1) {
				command = CopyResourcesCommand.createCopyCommand(target, sources.get(0), dialog.getFileName());
			} else {
				command = CopyResourcesCommand.createCopyCommand(target, sources);
			}
			if (command.canExecute()) {
				stack.execute(command);
			} else {
				command.dispose();
			}
		}
	}
}
