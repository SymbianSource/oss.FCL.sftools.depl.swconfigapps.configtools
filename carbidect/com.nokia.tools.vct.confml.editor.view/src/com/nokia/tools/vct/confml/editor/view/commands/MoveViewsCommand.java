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
 * Description: This file is part of com.nokia.tools.vct.confml.editor.view component.
 */

package com.nokia.tools.vct.confml.editor.view.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.StructuredSelection;

import com.nokia.tools.vct.common.ui.utils.SWTUtil;
import com.nokia.tools.vct.confml.editor.view.ViewsEditor;
import com.nokia.tools.vct.confml.editor.view.vemodel.EGroup;
import com.nokia.tools.vct.confml.editor.view.vemodel.EGroupContainer;
import com.nokia.tools.vct.confml.editor.view.vemodel.EGroupEntry;
import com.nokia.tools.vct.confml.editor.view.vemodel.EView;

public class MoveViewsCommand extends Command {

	private List<EGroupContainer> parentsOfObjectsToRemove = new ArrayList<EGroupContainer>();
	private List<Integer> indexesOfChildrenInParents = new ArrayList<Integer>();
	private List<EView> objectsToMove;

	private EGroupContainer newParent;
	private int index;
	
	private ViewsEditor editor;

	public MoveViewsCommand(ViewsEditor editor, EGroupContainer newParent, int index,  List<EView> objs) {
		this.objectsToMove = objs;
		this.editor = editor;
		this.newParent = newParent;
		this.index = index;

	}

	public void execute() {
		// compute parents of removed elements
		editor.getControl().setRedraw(false);
		try {
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(newParent);
			domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					EGroupEntry refGroup = null;
					if (index < newParent.getGroupsAndViews().size()) {
						refGroup = newParent.getGroupsAndViews().get(index);
					}

					for (int i = 0; i < objectsToMove.size(); i++) {
						EView view = objectsToMove.get(i);
						EGroupContainer container = (EGroupContainer)view.eContainer();
						parentsOfObjectsToRemove.add(container);
						int indexOfChildInParent = container.getGroupsAndViews().indexOf(view);
						indexesOfChildrenInParents.add(indexOfChildInParent);
						container.getGroupsAndViews().remove(indexOfChildInParent);
					}

					int idx = newParent.getGroupsAndViews().indexOf(refGroup);
					if (idx >= 0) {
						newParent.getGroupsAndViews().addAll(idx, objectsToMove);
					} else {
						// we get here when asked to add last or one of sibling objects have been moved.
						newParent.getGroupsAndViews().addAll(objectsToMove);
					}
				}
			});
			domain.getCommandStack().flush();
			
			SWTUtil.getStandardDisplay().asyncExec(new Runnable() {
				public void run() {
					editor.getSite().getSelectionProvider().setSelection(new StructuredSelection(objectsToMove));
				}
			});

		} finally {
			editor.getControl().setRedraw(true);
		}
	}

	@Override
	public void undo() {
		editor.getControl().setRedraw(false);
		try {
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(newParent);
			domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
			newParent.getGroupsAndViews().removeAll(objectsToMove);
			// add removed elements to their previous parents
			for (int i = objectsToMove.size() - 1; i >= 0; i--) {
				Integer index = indexesOfChildrenInParents.get(i);
				EGroupContainer parent = parentsOfObjectsToRemove.get(i);
				EView view = objectsToMove.get(i);
				parent.getGroupsAndViews().add(index, view);
			}
				}});
			domain.getCommandStack().flush();
			
			SWTUtil.getStandardDisplay().asyncExec(new Runnable() {
				public void run() {
					editor.getSite().getSelectionProvider().setSelection(new StructuredSelection(objectsToMove));
				}
			});
		} finally {
			editor.getControl().setRedraw(true);
		}
	}

}
