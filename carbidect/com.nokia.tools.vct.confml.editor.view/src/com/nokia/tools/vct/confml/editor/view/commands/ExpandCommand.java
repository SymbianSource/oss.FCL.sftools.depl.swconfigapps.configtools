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

import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.commands.Command;

import com.nokia.tools.vct.confml.editor.view.ViewsEditor;
import com.nokia.tools.vct.confml.editor.view.vemodel.EFeature;
import com.nokia.tools.vct.confml.editor.view.vemodel.EGroup;
import com.nokia.tools.vct.confml.editor.view.vemodel.ESetting;
import com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef;
import com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorFactory;
import com.nokia.tools.vct.confml.editor.view.vemodel.impl.EFeatureEntryImpl;

public class ExpandCommand extends Command {

	private ViewsEditor editor;
	private TransactionalEditingDomain domain;
	private ESettingRef expandSettingRef;

	public ExpandCommand(ViewsEditor editor, ESettingRef element) {
		this.expandSettingRef = element;
		this.editor = editor;
		domain = TransactionUtil.getEditingDomain(element);
	}

	public void execute() {
		editor.getControl().setRedraw(false);
		try {
			domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					EGroup parent = (EGroup) expandSettingRef.eContainer();
					parent.getRefs().remove(expandSettingRef);
					
					
					EViewEditorFactory factory = EViewEditorFactory.eINSTANCE;
					
					EFeature target = (EFeature) expandSettingRef.getTarget();
					EFeatureEntryImpl container = (EFeatureEntryImpl) target.eContainer();
					String featureId = container.getKey();
					EMap<String, ESetting> settings = target.getSettings();
					Set<Entry<String, ESetting>> entrySet = settings.entrySet();
					for (Entry<String, ESetting> entry : entrySet) {
						String ref = entry.getKey();
						ESetting setting = entry.getValue();
						ESettingRef settingRef = factory.createESettingRef();
						settingRef.setSettingId(ref);
						settingRef.setFeatureId(featureId);
//						settingRef.setName(setting.getName());
//						settingRef.setDescriptionText(setting.getDescriptionText());
//						settingRef.setDescriptionUri(setting.getDescriptionUri());
//						settingRef.setDescriptionUriTitle(setting.getDescriptionUriTitle());
						settingRef.setTarget(setting);
						parent.getRefs().add(settingRef);
					}
				}});
			domain.getCommandStack().flush();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			editor.getControl().setRedraw(true);
		}
		editor.refreshConfmlTree();
	}

}
