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

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;

import com.nokia.s60ct.search.ISearchArea;

import configurationemf.Configuration;

public class ConfigurationSearchArea implements ISearchArea<EObject> {
	
	private Configuration conf; 
	
	public ConfigurationSearchArea(Configuration conf) {
		this.conf = conf; 
	}

	/**
	 * The nasty thing with the configuration.eAllContent() is that it will
	 * also return the 'root conf' that is the enclosing class. We wish to skip 
	 * such items
	 */
	public Iterator<EObject> iterator() {
		return new Iterator<EObject>() {
			
			Iterator<EObject> iterator = conf.eAllContents(); 
			EObject next = iterator.hasNext() ? iterator.next() : null; 
			
			public boolean hasNext() {
				while (next instanceof Configuration) {
					next = iterator.hasNext() ? iterator.next() : null;
				}
				return next != null;
			}
			public EObject next() {
				hasNext(); // prepares next item. 
				EObject ret = next; 
				next = iterator.hasNext() ? iterator.next() : null;
				return ret;
			}
			public void remove() {}
			
		};
	}

}
