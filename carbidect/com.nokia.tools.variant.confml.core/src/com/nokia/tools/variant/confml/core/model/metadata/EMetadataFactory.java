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

package com.nokia.tools.variant.confml.core.model.metadata;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.nokia.tools.variant.confml.core.model.metadata.EMetadataPackage
 * @generated
 */
public interface EMetadataFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EMetadataFactory eINSTANCE = com.nokia.tools.variant.confml.core.model.metadata.impl.EMetadataFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>EMetadata</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EMetadata</em>'.
	 * @generated
	 */
	EMetadata createEMetadata();

	/**
	 * Returns a new object of class '<em>EMeta Component</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EMeta Component</em>'.
	 * @generated
	 */
	EMetaComponent createEMetaComponent();

	/**
	 * Returns a new object of class '<em>EMeta Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EMeta Property</em>'.
	 * @generated
	 */
	EMetaProperty createEMetaProperty();

	/**
	 * Returns a new object of class '<em>ECPF Metadata</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ECPF Metadata</em>'.
	 * @generated
	 */
	ECPFMetadata createECPFMetadata();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EMetadataPackage getEMetadataPackage();

} //EMetadataFactory
