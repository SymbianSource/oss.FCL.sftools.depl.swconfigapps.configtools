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

package com.nokia.s60ct.interfaces;

import java.util.Collection;
import java.util.Map;

import com.nokia.s60ct.generate.GenerationReport;

public interface IPlugin {
	public static final String RFS_PREFIX ="@RFS@";
	public static final int VALIDATE = 0;
	public static final int GENERATE = 1;
	
	Collection<Object> setRefValue(Map<String, Object>refToValue);
	GenerationReport getReport();
	
}
