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
 * Description: This file is part of com.nokia.tools.vct.confml.editor.include component.
 */

package com.nokia.tools.vct.confml.editor.include.xincmodel.command;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.nokia.tools.vct.confml.editor.include.xincmodel.EDocument;
import com.nokia.tools.vct.confml.editor.include.xincmodel.EInclude;
import com.nokia.tools.vct.confml.editor.include.xincmodel.EProjectFile;
import com.nokia.tools.vct.confml.editor.include.xincmodel.util.EXincModelUtils;

public class LinkTargetFileCommand extends AbstractCommand {

	EInclude owner;
	EProjectFile oldTarget;
	EditingDomain domain;
	Collection<Object> affectedObjects;
	
	public LinkTargetFileCommand(EditingDomain domain, EInclude owner) {
		this.domain = domain;
		this.owner = owner;
	}
	
	public void execute() {
		oldTarget = owner.getTarget();
		EProjectFile targetFile;
		
		EDocument document = (EDocument) owner.eContainer();
		if (document != null) {
		String href = EXincModelUtils.normalizeHref(owner.getHref());
			targetFile = EXincModelUtils.findTargetFile(document,
				href);
		} else {
			targetFile = null;
		}

		owner.setTarget(targetFile);
		
		affectedObjects = new ArrayList<Object>();
		affectedObjects.add(owner);
		if (oldTarget != null) {
			affectedObjects.add(oldTarget);
			affectedObjects.add(oldTarget.eContainer());
		}
		if (targetFile != null) {
			affectedObjects.add(targetFile);
			affectedObjects.add(targetFile.eContainer());
		}
	}
	
	
	@Override
	public Collection<?> getAffectedObjects() {
		return affectedObjects;
	}
	
	@Override
	public Collection<?> getResult() {
		return Collections.singleton(owner);
	}
	
	public void redo() {
		execute();
	}

	@Override
	protected boolean prepare() {
		return true;
	}
	
	@Override
	public void undo() {
		owner.setTarget(oldTarget);
	}
	
}
