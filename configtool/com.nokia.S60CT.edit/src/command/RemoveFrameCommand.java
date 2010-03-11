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
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import configurationemf.ConfigurationemfPackage;
import configurationemf.Frame;
import configurationemf.ParentSetting;

public class RemoveFrameCommand extends RemoveCommand {

	final static Class<ParentSetting> OWNER_CLASS = ParentSetting.class;
	final static EStructuralFeature FEATURE = ConfigurationemfPackage.eINSTANCE.getParentSetting_Frames();
	
	// to remove single frame
	public RemoveFrameCommand(EditingDomain domain, EObject owner,Object value) {
		super(domain, owner, FEATURE, value);
	}
	
	//to remove all my current frames
	public RemoveFrameCommand(EditingDomain domain, EObject owner) {
		super(domain, owner, FEATURE, ((ParentSetting)owner).getMyCurrentFrames());
	}
	

	public void doExecute() {
//		super.doExecute();
		if(OWNER_CLASS.isInstance(owner)&&FEATURE.equals(feature)){
			for(Object frame : this.collection)
			((ParentSetting)owner).removeFrame((Frame)frame);
		}
	}

}
