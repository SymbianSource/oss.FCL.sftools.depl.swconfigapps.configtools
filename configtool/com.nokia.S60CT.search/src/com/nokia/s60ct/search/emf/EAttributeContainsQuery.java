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

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.nokia.s60ct.search.IQuery;

/**
 * 
 */
public class EAttributeContainsQuery implements IQuery<EObject, EmfMatch>{
	
	private int attribute;
	
	private String query;

	public EAttributeContainsQuery(int attribute, String query) {
		this.attribute = attribute; 
		this.query = query; 
	}
	
	public Collection<EmfMatch> getMatches(EObject object) {
		EStructuralFeature feature = object.eClass().getEStructuralFeature(attribute);
		if (feature instanceof EAttribute) {
			Object attr = object.eGet(feature);
			if (attr instanceof String) {
				if (((String)attr).contains(query)) {
					return Collections.singleton(new EmfMatch(object, (EAttribute)feature)); 
				}
			}
		}
		return Collections.EMPTY_SET;
	}

}
