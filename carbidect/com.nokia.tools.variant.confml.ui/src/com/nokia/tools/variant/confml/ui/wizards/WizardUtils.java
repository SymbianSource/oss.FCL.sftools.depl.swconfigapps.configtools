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
 * Description: This file is part of com.nokia.tools.vct.common.ui component.
 */

package com.nokia.tools.variant.confml.ui.wizards;

public class WizardUtils {

	/**
	 * Returns the extension part of the given name
	 * @param name
	 * @return
	 */
	public static String getExtension(String name) {
		int index = name.indexOf('.');
		if(index != -1) {			
			return name.substring(index+1);
		}
		return null;
	}

}
