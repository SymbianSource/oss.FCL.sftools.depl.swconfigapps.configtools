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

import java.util.Arrays;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.StructuredSelection;

import com.nokia.tools.vct.common.ui.utils.SWTUtil;
import com.nokia.tools.vct.confml.editor.view.ViewsEditor;
import com.nokia.tools.vct.confml.editor.view.vemodel.EGroup;
import com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef;
import com.nokia.tools.vct.confml.editor.view.vemodel.EViewsEditorDocument;
import com.nokia.tools.vct.confml.editor.view.vemodel.util.ConverterUtils;

public class AddSettingCommand extends Command {
	private EGroup subgroup;
	private int index;
	private ESettingRef[] transformedSettings;
	private ViewsEditor editor;

	public AddSettingCommand(ViewsEditor editor, EGroup subgroup, int index,
			ESettingRef[] transformedSettings) {
		this.editor = editor;
		this.index = index;
		this.subgroup = subgroup;
		this.transformedSettings = transformedSettings;
	}

	@Override
	public void execute() {
		editor.getControl().setRedraw(false);
		try {
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(subgroup);
			domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					subgroup.getRefs().addAll(index, Arrays.asList(transformedSettings));
					
					EViewsEditorDocument document = ConverterUtils.getDocument(subgroup);
					for (ESettingRef ref: transformedSettings) {
						ConverterUtils.updateIndexReference(document, ref);
					}
				}
			});
			domain.getCommandStack().flush();
			
			// editor.getsetSelection(new StructuredSelection(transformedSetting), true);
			// editor.updateFilters();
			
			SWTUtil.getStandardDisplay().asyncExec(new Runnable() {
				public void run() {
					editor.getSite().getSelectionProvider().setSelection(new StructuredSelection(transformedSettings));
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
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(subgroup);
			domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					subgroup.getRefs().removeAll(Arrays.asList(transformedSettings));
					for (ESettingRef ref: transformedSettings) {
						ref.setTarget(null);
					}
				}
			});
			domain.getCommandStack().flush();
			// editor.updateFilters();
		} finally {
			editor.getControl().setRedraw(true);
		}
	}
	

}
