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

import configurationemf.RootConf;
import configurationemf.Setting;

public class SettingSearchArea extends WorkspaceSearchArea{

	public Iterator<EObject> iterator() {
		return new Iterator<EObject>() {
			private Collection<RootConf> rootConfs = getRootConfigurations();
			private Iterator<EObject> iterator = null; 
			private EObject next = null; 
			public boolean hasNext() {
				while ((next == null) && (iterator == null || !iterator.hasNext())) {
					if (rootConfs.size() > 0) {
						RootConf conf = rootConfs.iterator().next(); 
						next = conf;
						iterator = new ConfigurationSearchArea(conf).iterator();
						rootConfs.remove(conf); 
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
				if (!(next instanceof Setting)) { //only search from settings
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
