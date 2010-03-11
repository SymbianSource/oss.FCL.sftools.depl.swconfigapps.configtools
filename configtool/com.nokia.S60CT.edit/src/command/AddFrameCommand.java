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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import configurationemf.ConfigurationemfPackage;
import configurationemf.ParentSetting;

public class AddFrameCommand extends AddCommand {

	final static Class<ParentSetting> OWNER_CLASS = ParentSetting.class;
	final static EStructuralFeature FEATURE = ConfigurationemfPackage.eINSTANCE.getParentSetting_Frames();
	
	
	public AddFrameCommand(EditingDomain domain, EObject owner) {
		super(domain, owner, FEATURE, null);
	}


	public void doExecute() {
		if(OWNER_CLASS.isInstance(owner)&&FEATURE.equals(feature)){
			((ParentSetting)owner).addFrame();
		}
	}


	@Override
	public boolean doCanExecute() {
		return true;
	}

	
}
