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

package com.nokia.s60ct.init;

import org.eclipse.ui.IStartup;

import com.nokia.s60ct.general.ValidationPlugin;

public class ValidationPluginGUIInit implements IStartup {

	@Override
	public void earlyStartup() {
		ValidationPlugin.getValidator();
	}

}
