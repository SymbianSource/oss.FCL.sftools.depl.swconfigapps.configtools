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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;

import configurationemf.ParentSetting;

public class EmptySequenceCommand extends RemoveFrameCommand {

	
	public EmptySequenceCommand(EditingDomain domain, EObject owner) {
		super(domain, owner);
	}

	public void doExecute() {
		super.doExecute();
		((ParentSetting)owner).makeEmptySequence();
		
	}

}
