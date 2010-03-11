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

package com.nokia.tools.vct.confml.editor.view.commands;

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
import com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef;
import com.nokia.tools.vct.confml.editor.view.vemodel.EView;
import com.nokia.tools.vct.confml.editor.view.vemodel.EViewsEditorDocument;
import com.nokia.tools.vct.confml.editor.view.vemodel.util.ConverterUtils;

public class IncludeViewCommand extends Command {

	private ViewsEditor editor;
	private EGroupContainer parentContainer;
	private List<EView> includedViews;
	private int index = -1;

	public IncludeViewCommand(ViewsEditor editor, EGroupContainer parentContainer, int index,
			List<EView> views) {
		this.editor = editor;
		this.parentContainer = parentContainer;
		this.includedViews = views;
		this.index = index;
		System.out.println("IncludeViewCommand index:"+index+" views: "+views.size()+" "+parentContainer);
	}

	public void execute() {
		editor.getControl().setRedraw(false);
		try {
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(parentContainer);
			domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
				protected void doExecute() {

			for (EView v : includedViews)
			{
				for (EGroup g : v.getGroups())
				{
					for (ESettingRef ref: g.getRefs()) {
						ConverterUtils.updateIndexReference((EViewsEditorDocument)parentContainer.eContainer().eContainer(), ref);
					}
				}
			}
			
			parentContainer.getGroupsAndViews().addAll(index, includedViews);
			
			SWTUtil.getStandardDisplay().asyncExec(new Runnable() {
				public void run() {
					editor.getSite().getSelectionProvider().setSelection(new StructuredSelection(includedViews));
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

			parentContainer.getGroupsAndViews().removeAll(includedViews);
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

