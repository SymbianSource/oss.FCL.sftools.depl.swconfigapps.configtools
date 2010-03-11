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

package com.nokia.tools.variant.resourcelibrary.resources;

import org.eclipse.swt.graphics.Image;

class DefaultResourceCategory extends ResourceCategory {
	public DefaultResourceCategory(String name, Image icon) {
		super(name, null, icon);
	}
	
	public String toString() {
		return getCategoryName() + " (*.*)";
	}
}