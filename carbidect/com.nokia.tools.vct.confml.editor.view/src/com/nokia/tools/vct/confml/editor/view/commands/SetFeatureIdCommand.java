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

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.commands.Command;

import com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef;
import com.nokia.tools.vct.confml.editor.view.vemodel.EViewsEditorDocument;
import com.nokia.tools.vct.confml.editor.view.vemodel.util.ConverterUtils;

public class SetFeatureIdCommand extends Command {

	private ESettingRef ref;
	private String oldFeatureId;
	private String newFeatureId;
	private EViewsEditorDocument document;
	
	public SetFeatureIdCommand(ESettingRef ref, String newValue) {
		this.ref = ref;
		this.newFeatureId = newValue;
	}
	
	@Override
	public void execute() {
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(ref);
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				document = ConverterUtils.getDocument(ref);
				oldFeatureId = ref.getFeatureId();
				ref.setFeatureId(newFeatureId);
				ConverterUtils.updateIndexReference(document, ref);
			}
		});
		domain.getCommandStack().flush();
	}
	
	@Override
	public void undo() {
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(ref);
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				ref.setFeatureId(oldFeatureId);
				ConverterUtils.updateIndexReference(document, ref);
			}
		});
		domain.getCommandStack().flush();
	}
}
