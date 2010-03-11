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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.StructuredSelection;

import com.nokia.tools.vct.common.ui.utils.SWTUtil;
import com.nokia.tools.vct.confml.editor.view.ViewsEditor;
import com.nokia.tools.vct.confml.editor.view.vemodel.EGroup;
import com.nokia.tools.vct.confml.editor.view.vemodel.EGroupContainer;
import com.nokia.tools.vct.confml.editor.view.vemodel.ERefOption;
import com.nokia.tools.vct.confml.editor.view.vemodel.ERefProperty;
import com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef;
import com.nokia.tools.vct.confml.editor.view.vemodel.EView;
import com.nokia.tools.vct.confml.editor.view.vemodel.EViewsEditorDocument;
import com.nokia.tools.vct.confml.editor.view.vemodel.util.ConverterUtils;

public class DeleteCommand extends Command {

	private List<EObject> parentsOfObjectsToRemove = new ArrayList<EObject>();
	private List<Integer> indexesOfChildrenInParents = new ArrayList<Integer>();
	private List<EObject> objectsToRemove;

	private ViewsEditor editor;
	private TransactionalEditingDomain domain;
	private EViewsEditorDocument document;

	public DeleteCommand(ViewsEditor editor, List<EObject> objs) {
		this.objectsToRemove = objs;
		this.editor = editor;
		domain = TransactionUtil.getEditingDomain(objectsToRemove.get(0));
		document = ConverterUtils.getDocument(objectsToRemove.get(0));
	}

	public void execute() {
		// compute parents of removed elements
		editor.getControl().setRedraw(false);
		try {
			domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
			for (int i = 0; i < objectsToRemove.size(); i++) {
				EObject child = objectsToRemove.get(i);
				EObject parent = child.eContainer();
				
				parentsOfObjectsToRemove.add(parent);
				int index;
				if (child instanceof EGroup) {
					// group from group container
					index = ((EGroupContainer) parent)
							.getGroupsAndViews().indexOf(child);
					((EGroupContainer)parent).getGroupsAndViews().remove(index);
					cleanRefs((EGroup)child);
				} 
				else if (child instanceof EView)
				{
					index = ((EView)parent).getGroupsAndViews().indexOf(child);
					((EView)parent).getGroupsAndViews().remove(index);
					cleanRefs((EView)child);
				}
				else if (child instanceof ESettingRef) {
					// setting ref from group
					index = ((EGroup) parent)
							.getRefs().indexOf(child);
					((EGroup)parent).getRefs().remove(index);
					
					cleanRef((ESettingRef)child);
				} else if (child instanceof ERefOption) {
					// setting ref from group
					index = ((ESettingRef) parent)
							.getOptions().indexOf(child);
					((ESettingRef)parent).getOptions().remove(index);
				} else if (child instanceof ERefProperty) {
					// setting ref from group
					index = ((ESettingRef) parent)
							.getProperties().indexOf(child);
					((ESettingRef)parent).getProperties().remove(index);
				} else {
					throw new UnsupportedOperationException();
				}
				indexesOfChildrenInParents.add(index);
			}
				}});
			domain.getCommandStack().flush();
			// editor.updateFilters();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			editor.getControl().setRedraw(true);
		}
		// editor.refreshConfmlTree();
		SWTUtil.getStandardDisplay().asyncExec(new Runnable() {
			public void run() {
				editor.refreshConfmlTree();
				editor.getSite().getSelectionProvider().setSelection(new StructuredSelection(parentsOfObjectsToRemove));
			}
		});
	}

	private void cleanRefs(EGroup group) {
		for (ESettingRef ref: group.getRefs()) {
			cleanRef(ref);
		}
		EGroupContainer gContainer = (EGroupContainer)group;
		//clean sub groups
		for(EGroup g: gContainer.getGroups()) {
			cleanRefs(g);
		}
	}
	private void cleanRef(ESettingRef ref) {
		ref.setTarget(null);
	}
	
	private void cleanRefs(EView view) {
		//ref.setTarget(null); // no need to do anything?
	}

	private void connectRefs(EGroup group) {
		for (ESettingRef ref: group.getRefs()) {
			connectRef(ref);
		}
	}
	private void connectRef(ESettingRef ref) {
		ConverterUtils.updateIndexReference(document, ref);
	}

	private void addElement(EObject parent, EObject child, int indexInParent) {
		if (parent instanceof EGroup) {
			EGroup pGroup = (EGroup) parent;
			if (child instanceof EGroup) {
				EGroup cGroup = (EGroup) child;
				// remove
				pGroup.getGroups().add(indexInParent, cGroup);
				connectRefs(cGroup);
			} else if (child instanceof ESettingRef) {
				ESettingRef cViewSettingRef = (ESettingRef) child;
				// remove
				pGroup.getRefs().add(indexInParent, cViewSettingRef);
				connectRef(cViewSettingRef);
			}
		} else if (parent instanceof EGroupContainer) {
			EGroupContainer pGroupContainer = (EGroupContainer) parent;
			if (child instanceof EGroup) {
				EGroup cGroup = (EGroup) child;
				// remove
				pGroupContainer.getGroups().add(indexInParent, cGroup);
				connectRefs(cGroup);
			}
		} else if (parent instanceof ESettingRef) {
			ESettingRef settingRef = (ESettingRef)parent;
			if (child instanceof ERefOption) {
				ERefOption opt = (ERefOption) child;
				settingRef.getOptions().add(indexInParent, opt);
			} else if (child instanceof ERefProperty) {
				ERefProperty prop = (ERefProperty) child;
				settingRef.getProperties().add(indexInParent, prop);
			}
		}
	}

	@Override
	public void undo() {
		editor.getControl().setRedraw(false);
		try {
			domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
					protected void doExecute() {
			// add removed elements to their previous parents
			// do it in reverse order
			for (int i = parentsOfObjectsToRemove.size() - 1; i >= 0; i--) {
				Integer index = indexesOfChildrenInParents.get(i);
				EObject parent = (EObject) parentsOfObjectsToRemove.get(i);
				EObject child = objectsToRemove.get(i);
				addElement(parent, child, index);
			}
			}});
			domain.getCommandStack().flush();
			//editor.updateFilters();
			SWTUtil.getStandardDisplay().asyncExec(new Runnable() {
				public void run() {
					editor.refreshConfmlTree(parentsOfObjectsToRemove);
					editor.getSite().getSelectionProvider().setSelection(new StructuredSelection(objectsToRemove));
				}
			});
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			editor.getControl().setRedraw(true);
		}
		parentsOfObjectsToRemove.clear();
		indexesOfChildrenInParents.clear();
	}
}
