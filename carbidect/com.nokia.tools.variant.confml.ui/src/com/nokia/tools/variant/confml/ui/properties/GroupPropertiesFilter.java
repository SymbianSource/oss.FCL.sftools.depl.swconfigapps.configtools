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
 * Description: This file is part of com.nokia.tools.variant.confml.ui component.
 */

package com.nokia.tools.variant.confml.ui.properties;

import org.eclipse.jface.viewers.IFilter;

import com.nokia.tools.vct.confml.model.confml1.EGroup;

public class GroupPropertiesFilter implements IFilter {

	public boolean select(Object toTest) {
		if(toTest instanceof EGroup){
			return true;
		}
		return false;
	}

}
