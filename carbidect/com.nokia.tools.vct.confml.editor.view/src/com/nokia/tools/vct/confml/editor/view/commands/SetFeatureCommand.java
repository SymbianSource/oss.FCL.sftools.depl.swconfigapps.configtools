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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.commands.Command;

public class SetFeatureCommand extends Command {
	private EObject target;
	private EStructuralFeature feature;
	private Object newValue;
	private Object oldValue;
	
	protected SetFeatureCommand(EObject target, EStructuralFeature feature, Object newValue) {
		this.target = target;
		this.newValue = newValue;
		this.feature = feature;
	}
	
	@Override
	public void execute() {
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(target);
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				oldValue = target.eGet(feature);
				target.eSet(feature, newValue);
			}
		});
		domain.getCommandStack().flush();
	}
	
	@Override
	public void undo() {
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(target);
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				target.eSet(feature, oldValue);
			}
		});
		domain.getCommandStack().flush();
	}
	
	public EObject getTarget() {
		return target;
	}
}
