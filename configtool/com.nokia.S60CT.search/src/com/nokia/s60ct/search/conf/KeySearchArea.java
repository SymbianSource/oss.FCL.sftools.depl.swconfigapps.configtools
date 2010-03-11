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
package com.nokia.s60ct.search.conf;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;

import cenrep.Access;
import cenrep.Repository;

import com.nokia.s60ct.search.emf.EObjectSearchArea;

public class KeySearchArea extends WorkspaceSearchArea {

	public Iterator<EObject> iterator() {
		return new Iterator<EObject>() {
			private Collection<Repository> repositories = getRepositories(); 
			private Iterator<EObject> iterator = null; 
			private EObject next = null; 
			public boolean hasNext() {
				while ((next == null) && (iterator == null || !iterator.hasNext())) {
					
					if (repositories.size() > 0) {
						Repository repository = repositories.iterator().next(); 
						next = repository;
						iterator = new EObjectSearchArea(repository).iterator();
						repositories.remove(repository);
					} else {
						return false;
					}
				}
				if (next == null) {
					next = iterator.next(); 
				}
				return true;
			}
			
			public void filter() {
				if (next instanceof Access || next instanceof Repository) {//no need to search from these
					next = null;
					if (hasNext()) {
						filter(); 
					} 
				}
			}
			
			public EObject next() {
				hasNext(); // prepares the iterator
				
				EObject ret = next; 
				next = null; 
				if (hasNext()) {
					filter();
				}
				return ret;
			}
			
			public void remove() {
			}
		};
	}
	
}
