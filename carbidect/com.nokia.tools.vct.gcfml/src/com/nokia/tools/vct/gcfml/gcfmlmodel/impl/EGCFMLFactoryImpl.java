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

package com.nokia.tools.vct.gcfml.gcfmlmodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.nokia.tools.vct.gcfml.gcfmlmodel.EFile;
import com.nokia.tools.vct.gcfml.gcfmlmodel.EGCFMLDocumentRoot;
import com.nokia.tools.vct.gcfml.gcfmlmodel.EGCFMLFactory;
import com.nokia.tools.vct.gcfml.gcfmlmodel.EGCFMLPackage;
import com.nokia.tools.vct.gcfml.gcfmlmodel.EOutput;
import com.nokia.tools.vct.gcfml.gcfmlmodel.ESetting;
import com.nokia.tools.vct.gcfml.gcfmlmodel.EStylesheet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EGCFMLFactoryImpl extends EFactoryImpl implements EGCFMLFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EGCFMLFactory init() {
		try {
			EGCFMLFactory theEGCFMLFactory = (EGCFMLFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.s60.com/xml/gcfml/1"); 
			if (theEGCFMLFactory != null) {
				return theEGCFMLFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EGCFMLFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EGCFMLFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EGCFMLPackage.EFILE: return createEFile();
			case EGCFMLPackage.ESETTING: return createESetting();
			case EGCFMLPackage.EGCFML_DOCUMENT_ROOT: return createEGCFMLDocumentRoot();
			case EGCFMLPackage.ESTYLESHEET: return createEStylesheet();
			case EGCFMLPackage.EOUTPUT: return createEOutput();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EFile createEFile() {
		EFileImpl eFile = new EFileImpl();
		return eFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESetting createESetting() {
		ESettingImpl eSetting = new ESettingImpl();
		return eSetting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EGCFMLDocumentRoot createEGCFMLDocumentRoot() {
		EGCFMLDocumentRootImpl egcfmlDocumentRoot = new EGCFMLDocumentRootImpl();
		return egcfmlDocumentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStylesheet createEStylesheet() {
		EStylesheetImpl eStylesheet = new EStylesheetImpl();
		return eStylesheet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOutput createEOutput() {
		EOutputImpl eOutput = new EOutputImpl();
		return eOutput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EGCFMLPackage getEGCFMLPackage() {
		return (EGCFMLPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EGCFMLPackage getPackage() {
		return EGCFMLPackage.eINSTANCE;
	}

} //EGCFMLFactoryImpl
