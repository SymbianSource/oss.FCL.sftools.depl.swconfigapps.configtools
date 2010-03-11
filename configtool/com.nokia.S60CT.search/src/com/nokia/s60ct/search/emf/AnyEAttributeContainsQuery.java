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

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

import com.nokia.s60ct.search.IQuery;

public class AnyEAttributeContainsQuery implements IQuery<EObject, EmfMatch> {
	
	private String query;
	
	private boolean caseInsensitive;

	/***
	 * Case insensitiveness add search times by about 5%, so not much.
	 */
	public AnyEAttributeContainsQuery(String query, boolean caseInsensitive) {
		this.query = query; 
		this.caseInsensitive = caseInsensitive;
		if (caseInsensitive) {
			this.query = this.query.toLowerCase();
		}
	}

	public AnyEAttributeContainsQuery(String query) {
		this(query, true); 
	}
	
	public Collection<EmfMatch> getMatches(EObject object) {
		ArrayList<EmfMatch> ret = new ArrayList<EmfMatch>(); 
		
		for (EAttribute attribute: object.eClass().getEAllAttributes()) {
			Object attr;
			try {
				attr = object.eGet(attribute);
			} catch (RuntimeException e ) {
				continue;
			}
			if (attr instanceof String) {
				String str = (String)attr;
				if (caseInsensitive) {
					str = str.toLowerCase();
				}
				if (str.contains(query)) {
					ret.add(new EmfMatch(object, (EAttribute)attribute)); 
				}
			}
	}
		return ret;
	}

}
