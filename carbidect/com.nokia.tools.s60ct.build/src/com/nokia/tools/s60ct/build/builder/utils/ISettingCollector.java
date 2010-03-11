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

import com.nokia.tools.vct.common.appmodel.EConfigurationProject;

public interface ISettingCollector {

	/**
	 * Returns EAppSetting and corresponding layer into which it should be
	 * generated.
	 * @param cp
	 * @param absRef
	 * @return EAppSetting and EConfMLLayer into which it should be generated
	 */
	public abstract SettingAndLayer getSetting(EConfigurationProject cp,
			String absRef);

}