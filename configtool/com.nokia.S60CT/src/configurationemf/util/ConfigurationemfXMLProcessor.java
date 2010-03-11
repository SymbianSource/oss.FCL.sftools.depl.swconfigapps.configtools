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

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import configurationemf.ConfigurationemfPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ConfigurationemfXMLProcessor extends XMLProcessor {
	/*protected ExtendedMetaData createExtendedMetaData() {
		ExtendedMetaData aExtendedMetaData = super.createExtendedMetaData();
		aExtendedMetaData.setName(ConfigurationemfPackage.eINSTANCE.getConfiguration_Feature(), "feature");
		aExtendedMetaData.setName(ConfigurationemfPackage.eINSTANCE.getConfiguration(), "configuration");
		aExtendedMetaData.setNamespace(ConfigurationemfPackage.eINSTANCE.getConfiguration_Feature(), "http:///configurationemf.ecore");
		return aExtendedMetaData;
	}*/
	
	
	private XMLCustomizerCONFML customizer = new XMLCustomizerCONFML();
	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationemfXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		ConfigurationemfPackage.eINSTANCE.eClass();
	}
	
	/**
	 * Register for "*" and "xml" file extensions the ConfigurationemfResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Map getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new ConfigurationemfResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new ConfigurationemfResourceFactoryImpl());
		}
		return registrations;
	}

} //ConfigurationemfXMLProcessor
