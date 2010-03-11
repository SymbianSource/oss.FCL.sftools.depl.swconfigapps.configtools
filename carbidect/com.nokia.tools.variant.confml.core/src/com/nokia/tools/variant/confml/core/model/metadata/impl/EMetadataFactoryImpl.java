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
 * Description: This file is part of com.nokia.tools.variant.confml.core component.
 */

package com.nokia.tools.variant.confml.core.model.metadata.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata;
import com.nokia.tools.variant.confml.core.model.metadata.EMetaComponent;
import com.nokia.tools.variant.confml.core.model.metadata.EMetaProperty;
import com.nokia.tools.variant.confml.core.model.metadata.EMetadata;
import com.nokia.tools.variant.confml.core.model.metadata.EMetadataFactory;
import com.nokia.tools.variant.confml.core.model.metadata.EMetadataPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EMetadataFactoryImpl extends EFactoryImpl implements EMetadataFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EMetadataFactory init() {
		try {
			EMetadataFactory theEMetadataFactory = (EMetadataFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.nokia.com/xml/ns/confml-core/metadata-2.0"); 
			if (theEMetadataFactory != null) {
				return theEMetadataFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EMetadataFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMetadataFactoryImpl() {
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
			case EMetadataPackage.EMETADATA: return createEMetadata();
			case EMetadataPackage.EMETA_COMPONENT: return createEMetaComponent();
			case EMetadataPackage.EMETA_PROPERTY: return createEMetaProperty();
			case EMetadataPackage.ECPF_METADATA: return createECPFMetadata();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMetadata createEMetadata() {
		EMetadataImpl eMetadata = new EMetadataImpl();
		return eMetadata;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMetaComponent createEMetaComponent() {
		EMetaComponentImpl eMetaComponent = new EMetaComponentImpl();
		return eMetaComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMetaProperty createEMetaProperty() {
		EMetaPropertyImpl eMetaProperty = new EMetaPropertyImpl();
		return eMetaProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ECPFMetadata createECPFMetadata() {
		ECPFMetadataImpl ecpfMetadata = new ECPFMetadataImpl();
		return ecpfMetadata;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMetadataPackage getEMetadataPackage() {
		return (EMetadataPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EMetadataPackage getPackage() {
		return EMetadataPackage.eINSTANCE;
	}

} //EMetadataFactoryImpl
