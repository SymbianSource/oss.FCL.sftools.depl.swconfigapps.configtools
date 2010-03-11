/*
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
 * All rights reserved.
 * This component and the accompanying materials are made available
 * under the terms of "Eclipse Public License v1.0"
 * which accompanies this distribution, and is available
 * at the URL "http://www.eclipse.org/legal/epl-v10.html".
 * 
 * Initial Contributors:
 * Nokia Corporation - Initial contribution
 * 
 * Contributors:
 * 
 * Description: This file is part of com.nokia.tools.variant.views component.
 */

package com.nokia.tools.variant.views.actions.registry;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.jface.action.IAction;

public class ViewActionRegistry {

	private static ViewActionRegistry INSTANCE;
	
	public static ViewActionRegistry getInstance() {
		if(INSTANCE == null) {
			synchronized (ViewActionRegistry.class) {
				INSTANCE = new ViewActionRegistry();
			}			
		}
		return INSTANCE;
	}
	
	private ViewActionRegistry() {

	}
	
	private Map<String, IAction> registry = new HashMap<String, IAction>();
	
	public IAction getAction(String viewId) {
		
		if(registry.containsKey(viewId)) {
			
			return (IAction) registry.get(viewId);
			
		}
		
		return null;
		
	}
	
	public void setAction(String viewId, IAction action) {
		
		registry.put(viewId, action);
		
	}
	
	public void setActionsAsChecked() {
		
		for(Iterator<IAction> it = registry.values().iterator(); it.hasNext(); ) {
			
			IAction action = it.next();
			
			action.setChecked(true);
			
		}
		
	}
	
}
