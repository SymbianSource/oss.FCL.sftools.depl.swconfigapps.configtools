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
 * Description: This file is part of com.nokia.tools.vct.confml component.
 */

package com.nokia.tools.vct.confml.model.confml1.util;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.xmi.impl.XMLHelperImpl;

import com.nokia.tools.vct.confml.model.confml1.EConfML1Package;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Package;

public class ConfXMLHelperImpl extends XMLHelperImpl {

	//@Override
	public EStructuralFeature getFeature(EClass eClass, String namespaceURI, String name, boolean isElement) {
		EConfML1Package scope = EConfML1Package.eINSTANCE;
		EConfML2Package scope2 = EConfML2Package.eINSTANCE;
		
		if (eClass.isInstance(scope.getEDescriptionElement())) {
			return super.getFeature(eClass, namespaceURI, name, isElement);
		}
		
		if(eClass.isInstance(scope.getESettingDataContainer())) {
			return scope.getESettingDataContainer_Settings();
		} else if(eClass.isInstance(scope.getEFeatureRfs())) {
			return scope.getEFeatureRfs_Settings();
		}

		if(eClass.isInstance(scope2.getESettingDataContainer())) {
			return scope2.getESettingDataContainer_Settings();
		} else if(eClass.isInstance(scope2.getEFeatureRfs())) {
			return scope2.getEFeatureRfs_Settings();
		}

		return super.getFeature(eClass, namespaceURI, name, isElement);
	}

	//@Override
	public EStructuralFeature getFeature(EClass eClass, String namespaceURI, String name) {
		EConfML1Package scope = EConfML1Package.eINSTANCE;
		EConfML2Package scope2 = EConfML2Package.eINSTANCE;

		if (eClass.isInstance(scope.getEDescriptionElement())) {
			return super.getFeature(eClass, namespaceURI, name);
		}

		
		if(eClass.isInstance(scope.getESettingDataContainer())) {
			return scope.getESettingDataContainer_Settings();
		} else if(eClass.isInstance(scope.getEFeatureRfs())) {
			return scope.getEFeatureRfs_Settings();
		}
		if(eClass.isInstance(scope2.getESettingDataContainer())) {
			return scope2.getESettingDataContainer_Settings();
		} else if(eClass.isInstance(scope2.getEFeatureRfs())) {
			return scope2.getEFeatureRfs_Settings();
		}
		
		return super.getFeature(eClass, namespaceURI, name);
	}

}
