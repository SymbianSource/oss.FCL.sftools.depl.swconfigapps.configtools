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
 * Description: This file is part of com.nokia.tools.vct.ibyml component.
 */

package com.nokia.tools.vct.ibyml.ibymodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.nokia.tools.vct.ibyml.ibymodel.EEntity;
import com.nokia.tools.vct.ibyml.ibymodel.EEntry;
import com.nokia.tools.vct.ibyml.ibymodel.EFileName;
import com.nokia.tools.vct.ibyml.ibymodel.EIBYDocument;
import com.nokia.tools.vct.ibyml.ibymodel.EIBYFile;
import com.nokia.tools.vct.ibyml.ibymodel.EIBYModelFactory;
import com.nokia.tools.vct.ibyml.ibymodel.EIBYModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EIBYModelFactoryImpl extends EFactoryImpl implements EIBYModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EIBYModelFactory init() {
		try {
			EIBYModelFactory theEIBYModelFactory = (EIBYModelFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.s60.com/xml/iby/1"); 
			if (theEIBYModelFactory != null) {
				return theEIBYModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EIBYModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EIBYModelFactoryImpl() {
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
			case EIBYModelPackage.EENTITY: return createEEntity();
			case EIBYModelPackage.EIBY_FILE: return createEIBYFile();
			case EIBYModelPackage.EENTRY: return createEEntry();
			case EIBYModelPackage.EFILE_NAME: return createEFileName();
			case EIBYModelPackage.EIBY_DOCUMENT: return createEIBYDocument();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEntity createEEntity() {
		EEntityImpl eEntity = new EEntityImpl();
		return eEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EIBYFile createEIBYFile() {
		EIBYFileImpl eibyFile = new EIBYFileImpl();
		return eibyFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEntry createEEntry() {
		EEntryImpl eEntry = new EEntryImpl();
		return eEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EFileName createEFileName() {
		EFileNameImpl eFileName = new EFileNameImpl();
		return eFileName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EIBYDocument createEIBYDocument() {
		EIBYDocumentImpl eibyDocument = new EIBYDocumentImpl();
		return eibyDocument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EIBYModelPackage getEIBYModelPackage() {
		return (EIBYModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EIBYModelPackage getPackage() {
		return EIBYModelPackage.eINSTANCE;
	}

} //EIBYModelFactoryImpl
