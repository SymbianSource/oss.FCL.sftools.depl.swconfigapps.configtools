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

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

import org.eclipse.swt.graphics.Image;

/**
 * Simple POJO data holder for extensions
 * 
 */
public class ResourceCategory {
	private String categoryName;
	private LinkedHashSet<String> suffixes;
	private Image icon;
	
	public String getCategoryName() {
		return categoryName;
	}

	public LinkedHashSet<String> getCategorySuffixes() {
		return suffixes;
	}

	public Image getIcon() {
		return icon;
	}

	public ResourceCategory(String name, Collection<String> suffixes, Image icon) {
		categoryName = name;
		if (suffixes != null)
			this.suffixes = new LinkedHashSet<String>(suffixes);
		this.icon = icon;
	}
	
	public String getExtensionsString() {
		StringBuffer buf = new StringBuffer();
		Iterator<String> i = suffixes.iterator();
		while (i.hasNext()) {
			buf.append("*." + i.next());
			if (i.hasNext()) buf.append("; ");					
		}		
		return buf.toString();
	}

	public String toString() {
		return getCategoryName() + " (" + getExtensionsString() + ")";
	}
}
