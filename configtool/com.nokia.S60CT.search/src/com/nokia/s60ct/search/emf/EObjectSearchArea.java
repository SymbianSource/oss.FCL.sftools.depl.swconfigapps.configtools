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

package com.nokia.s60ct.search.emf;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;

import com.nokia.s60ct.search.ISearchArea;

public class EObjectSearchArea implements ISearchArea<EObject> {
	
	private EObject model; 
	
	public EObjectSearchArea(EObject model) {
		this.model = model;
	}

	public Iterator<EObject> iterator() {
		return model.eAllContents();
	}

}
