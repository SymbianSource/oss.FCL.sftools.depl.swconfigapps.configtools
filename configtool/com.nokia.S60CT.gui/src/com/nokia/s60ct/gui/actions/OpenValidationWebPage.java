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
package com.nokia.s60ct.gui.actions;

import org.eclipse.core.internal.resources.Marker;

public class OpenValidationWebPage {

	
	public static void openPage(Object selectedObject, String URL)
	{
		String osName = System.getProperties().getProperty("os.name");
		try
		{
			if (osName.startsWith("Windows"))
			{
				if (selectedObject != null && selectedObject instanceof Marker)
				{
					Marker marker = (Marker)selectedObject;
					String postfix = (String)marker.getAttribute(Marker.BOOKMARK);
					if (postfix!=null)
						URL = URL+postfix;
				}	
				java.lang.Runtime.getRuntime().exec("cmd /C start "+URL); //only for windows
			}
			else
			{
				//some other OS implementation
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}	
	}
	
}
