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

package com.nokia.tools.carbidect.cone.ui;

public interface IConeConfigurationConstants {
	public static final String ATTR_PROJECT = "project";
	public static final String ATTR_CONFIGURATION = "configuration";

	public static final String ATTR_OUTPUT = "output";
	public static final String ATTR_LOGFILE = "logfile";
	public static final String ATTR_VERBOSE = "verbose";
	public static final String ATTR_TARGET = "target";
	public static final String ATTR_LAYER = "layer";
	
	public static final String ATTR_CONFIGURATION_ENGINE = "engine";
	public final String ATTR_VALUE_CONFIGURATION_ENGINE_CUSTOM = "custom";

	public static final String ATTR_ARGUMENTS = "arguments";
	public static final String LAUNCH_CONFIGURATIONTYPE_ID = "com.nokia.tools.carbidect.cone.ui.launchConfigurationType";

	public static final String ATTR_VALUE_DEFAULT_OUTPUT = "output";
	public static final String ATTR_VALUE_DEFAULT_LOGFILE = "cone.log";
	public static final int ATTR_VALUE_DEFAULT_VERBOSE = 3;
	public static final int ATTR_VALUE_DEFAULT_TARGET = 1;
	public static final int ATTR_VALUE_DEFAULT_LAYER = 1;
}
