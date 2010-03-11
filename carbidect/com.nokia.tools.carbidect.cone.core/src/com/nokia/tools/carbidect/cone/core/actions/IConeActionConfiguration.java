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

package com.nokia.tools.carbidect.cone.core.actions;

import java.util.List;


public interface IConeActionConfiguration {
	public void setArgumentValue(String name, String value);
	public String getArgumentValue(String name);
	public void setConfiguration(String configuration);
	public String getConfiguration();
	public void setStorage(String storage);
	public String getStorage();
	public void addArgumentWithNoValue(String argument);
	public List<String> parseArguments();
	public void setVerbose(int verbose);
	public void setTarget(int target);
	public void setLayer(int layer);
	public void setOutput(String absolutePath);
	public void setLog(String absolutePath);
}
