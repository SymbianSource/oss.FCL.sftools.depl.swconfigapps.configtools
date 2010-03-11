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
 * Description: This file is part of com.nokia.tools.variant.resourcelibrary component.
 */

package com.nokia.tools.s60ct.resources.views;

public class DnDStorage {
	private static Object data=null;

	public static synchronized Object getData() {
		return data;
	}

	public static synchronized void setData(Object data) {
		DnDStorage.data = data;
	}
	
	public static synchronized boolean isData() {
		if (data==null) return false;
		return true;
	}
}
