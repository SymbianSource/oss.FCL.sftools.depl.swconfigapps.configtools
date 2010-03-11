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
 * Description: This file is part of com.nokia.tools.vct.gcfml component.
 */

package com.nokia.tools.vct.gcfml.gcfmlmodel.util;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.xmi.impl.XMLHelperImpl;

public class GCFMLXMLHelperImpl extends XMLHelperImpl
{
	@Override
	public EStructuralFeature getFeature(EClass eClass, String namespaceURI, String name)
	{
		EStructuralFeature feature = super.getFeature(eClass, namespaceURI, name);
		return feature;
	}
	
	@Override
	public EStructuralFeature getFeature(EClass eClass, String namespaceURI, String name, boolean isElement)
	{
		return super.getFeature(eClass, namespaceURI, name, isElement);
	}
}
