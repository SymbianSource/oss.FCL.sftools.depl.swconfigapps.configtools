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
 * Description: This file is part of com.nokia.tools.variant.javascript component.
 */

package com.nokia.tools.variant.javascript.binding;

import org.mozilla.javascript.ScriptableObject;

public class Feature extends ScriptableObject {
	private String name;

	public Feature() {
		
	}
	
	public void jsConstructor(String name) {
		this.name = name;
	}
	
	
	public String jsGet_name() {
		return name;
	}

	
	@Override
	public String getClassName() {
		return "Feature";
	}
	
}
