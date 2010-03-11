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

package com.nokia.tools.s60ct.build.builder.utils;

import java.util.HashMap;

import org.eclipse.emf.ecore.EObject;

import com.nokia.tools.vct.common.appmodel.EAppSetting;


public class SettingImplementationCollector {
	
	private static HashMap<String, EObject> implMap = new HashMap<String, EObject>();

	public static void addImplementation(String ref, EObject implementation)
	{
		implMap.put(ref, implementation);
	}
	
	public static EObject getImplementation(String ref)
	{
		return implMap.get(ref);
	}
	
}



