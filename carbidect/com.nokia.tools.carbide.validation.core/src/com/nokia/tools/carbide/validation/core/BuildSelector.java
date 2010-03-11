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
 * Description: This file is part of com.nokia.tools.carbide.validation.core component.
 */

package com.nokia.tools.carbide.validation.core;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.validation.model.IClientSelector;

import com.nokia.tools.carbide.validation.core.IValidationResourceSet;

/**
 * Validation context selector.
 * 
 */
public class BuildSelector implements IClientSelector{

	public boolean selects(Object object) {
		ResourceSet rs = null;
		if (object instanceof EObject) {
			EObject obj = (EObject)object;
			Resource res = obj.eResource();
			rs = res == null ? null : res.getResourceSet();
		} else if (object instanceof Resource) {
			rs = ((Resource)object).getResourceSet();
		} else if (object instanceof ResourceSet) {
			rs = (ResourceSet)object;
		}
		
		return rs instanceof IValidationResourceSet;
	}

}
