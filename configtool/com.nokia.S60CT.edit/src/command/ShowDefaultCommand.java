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
package command;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;

import configurationemf.ParentSetting;

public class ShowDefaultCommand extends AbstractCommand {

EditingDomain domain = null;	
EObject owner = null;

	public ShowDefaultCommand(EditingDomain domain, EObject owner)
	{
		super();
		this.domain = domain;
		this.owner = owner;
		this.isExecutable = true;
		this.isPrepared = true;
	}
	
	public void execute() {
		((ParentSetting)owner).makeNotEmptySequence();
		((ParentSetting)owner).getFrames();
	

	}

	public void redo() {

	}

}
