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
package com.nokia.s60ct.gui.actions;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import configurationemf.ConfigurationemfPackage;

public class AddViewGroupAction extends AddChildAction {
	
	EReference childReference = ConfigurationemfPackage.eINSTANCE.getView_ParentGroup();
	EClass childClass = ConfigurationemfPackage.eINSTANCE.getParentGroup();
	EAttribute roAttribute = ConfigurationemfPackage.eINSTANCE.getView_ReadOnly();
	
	public AddViewGroupAction() {
		
	}

	@Override
	protected EClass getChildClass() {
		return childClass;
	}

	@Override
	protected EReference getChildReference() {
		return childReference;
	}

	@Override
	protected boolean isObjectReadOnly(EObject object) {
		return ((Boolean)object.eGet(roAttribute)).booleanValue();
	}

}
