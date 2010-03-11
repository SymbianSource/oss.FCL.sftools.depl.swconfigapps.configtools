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
import com.nokia.s60ct.search.SearchResult;

public class EmfResultSearchArea implements ISearchArea<EObject> {
	
	private SearchResult<EmfMatch> result; 
	
	public EmfResultSearchArea(SearchResult<EmfMatch> result) {
		this.result = result; 
	}

	public Iterator<EObject> iterator() {
		return new Iterator<EObject>() {
			Iterator<EmfMatch> iterator = result.iterator();
			EObject next = iterator.hasNext() ? iterator.next().getEObject() : null;
			public boolean hasNext() {
				return next != null;
			}
 
			public EObject next() {
				EObject ret = next; 
				// skip matches of the same object. 
				while (true) {
					if (!iterator.hasNext()) {
						next = null;
						break;
					}
					if ((next = iterator.next().getEObject()) != ret) {
						break;
					}
				}
				return ret;
			}
			public void remove() {}
		};
	}
	
}
