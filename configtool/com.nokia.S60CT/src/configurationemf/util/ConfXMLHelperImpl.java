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
package configurationemf.util;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.xmi.impl.XMLHelperImpl;

import configurationemf.ConfigurationemfPackage;

public class ConfXMLHelperImpl extends XMLHelperImpl {

	//@Override
	public EStructuralFeature getFeature(EClass eClass, String namespaceURI, String name, boolean isElement) {
		if(eClass.equals(ConfigurationemfPackage.eINSTANCE.getData()))
			return ConfigurationemfPackage.eINSTANCE.getData_Ref();
			
		return super.getFeature(eClass, namespaceURI, name, isElement);
	}

	//@Override
	public EStructuralFeature getFeature(EClass eClass, String namespaceURI, String name) {
		if(eClass.equals(ConfigurationemfPackage.eINSTANCE.getRef()))
			return ConfigurationemfPackage.eINSTANCE.getRef_Ref();
		
		return super.getFeature(eClass, namespaceURI, name);
	}

}
