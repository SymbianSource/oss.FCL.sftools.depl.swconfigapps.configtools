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
package objectview;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 *
 *
 */
public class ObjectViewRegistry {

	private static ObjectViewRegistry theInstance; 

	private Set<IObjectView> views = new HashSet<IObjectView>(); 
	
	private ObjectViewRegistry() {
	}
	
	public static ObjectViewRegistry getInstance() {
		if (theInstance == null) {
			theInstance = new ObjectViewRegistry();
		}
		return theInstance; 
	}

	public void addView(IObjectView view) {
		views.add(view); 
	}
	
	public void removeView(IObjectView view) {
		views.remove(view); 
	}
	
	public Collection<IObjectView> getViewsFor(Object object) {
		Collection<IObjectView> ret = new ArrayList<IObjectView>(); 
		
		for (IObjectView view : views) {
			if (view.canShow(object)) {
				ret.add(view); 
			}
		}
		return ret; 
	}

	public boolean canShow(Object object) {
		return getViewsFor(object).size() > 0 ; 
	}

	public void show(Object object) {
		Collection<IObjectView> v = getViewsFor(object);
		for (IObjectView view : v) {
			view.show(object, false); 
		}
	}

	public void activate(Object object) {
		Collection<IObjectView> v = getViewsFor(object);
		for (IObjectView view : v) {
			view.show(object, true); 
		}
	}

}
