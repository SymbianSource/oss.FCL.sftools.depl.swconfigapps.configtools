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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.StructuredSelection;

import com.nokia.tools.vct.common.ui.utils.SWTUtil;
import com.nokia.tools.vct.confml.editor.view.ViewsEditor;

public class AddChildCommand extends Command {

	private ViewsEditor editor;
	private EObject parentContainer;
	private EObject newElement;
	private EStructuralFeature feature;

	public AddChildCommand(ViewsEditor editor, EObject parentContainer,
			EObject newChild, EStructuralFeature feature) {
		this.editor = editor;
		this.parentContainer = parentContainer;
		this.newElement = newChild;
		this.feature = feature;
	}

	public void execute() {
		editor.getControl().setRedraw(false);
		try {
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(parentContainer);
			domain.getCommandStack().execute(new RecordingCommand(domain) {
				@SuppressWarnings("unchecked")
				@Override
				protected void doExecute() {
			((EList)parentContainer.eGet(feature)).add(newElement);
			SWTUtil.getStandardDisplay().asyncExec(new Runnable() {
				public void run() {
					editor.getSite().getSelectionProvider().setSelection(new StructuredSelection(newElement));
				}
			});
				}});
		} finally {
			editor.getControl().setRedraw(true);
		}
	}

	public void undo() {
		editor.getControl().setRedraw(false);
		try {
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(parentContainer);
			domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
				protected void doExecute() {

			((EList<?>)parentContainer.eGet(feature)).remove(newElement);
			SWTUtil.getStandardDisplay().asyncExec(new Runnable() {
				public void run() {
					editor.getSite().getSelectionProvider().setSelection(new StructuredSelection(parentContainer));
				}
			});
				}});
		} finally {
			editor.getControl().setRedraw(true);
		}
	}
}
