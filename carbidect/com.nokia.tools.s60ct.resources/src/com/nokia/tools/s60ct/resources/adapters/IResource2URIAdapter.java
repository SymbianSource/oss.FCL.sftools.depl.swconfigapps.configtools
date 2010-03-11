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

package com.nokia.tools.s60ct.resources.adapters;

import java.net.URI;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdapterFactory;

import com.nokia.tools.s60ct.resources.resources.ResourceUtil;

public class IResource2URIAdapter implements IAdapterFactory {
	
	static final Class<?>[] adapters = { URI.class };

	@SuppressWarnings("unchecked")
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		
		if (adapterType == URI.class) {
			if (adaptableObject == null || 
					!(adaptableObject instanceof IResource)) return null;
			
			return ResourceUtil.toURI(((IResource) 
					adaptableObject).getProjectRelativePath());
		}
		return null;
	}

	public Class<?>[] getAdapterList() {
		return adapters;
	}

}
