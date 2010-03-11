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

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import com.nokia.tools.vct.confml.model.confml1.EConfML1Package;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EConfML1XMLProcessor extends XMLProcessor {

	public static final String CONFML_EXTENSION = "confml";

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EConfML1XMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		EConfML1Package.eINSTANCE.eClass();
	}

	/**
	 * Register for "*" and "xml" file extensions the EConfML1ResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(CONFML_EXTENSION,
					new EConfML1ResourceFactoryImpl());
			registrations.put(XML_EXTENSION, new EConfML1ResourceFactoryImpl());
			registrations
					.put(STAR_EXTENSION, new EConfML1ResourceFactoryImpl());
		}
		return registrations;
	}

} //EConfML1XMLProcessor
