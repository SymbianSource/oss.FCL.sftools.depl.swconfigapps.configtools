/**
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
 * $Id$
 */
package com.nokia.tools.carbide.ct.confml.model.metaext;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.nokia.tools.carbide.ct.confml.model.metaext.EMetaExtFactory
 * @model kind="package"
 * @generated
 */
public interface EMetaExtPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "metaext";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.nokia.com/xml/cpf-id/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "cid";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EMetaExtPackage eINSTANCE = com.nokia.tools.carbide.ct.confml.model.metaext.impl.EMetaExtPackageImpl
			.init();

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.confml.model.metaext.impl.EConfigurationPropertyElementImpl <em>EConfiguration Property Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.confml.model.metaext.impl.EConfigurationPropertyElementImpl
	 * @see com.nokia.tools.carbide.ct.confml.model.metaext.impl.EMetaExtPackageImpl#getEConfigurationPropertyElement()
	 * @generated
	 */
	int ECONFIGURATION_PROPERTY_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONFIGURATION_PROPERTY_ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONFIGURATION_PROPERTY_ELEMENT__VALUE = 1;

	/**
	 * The number of structural features of the '<em>EConfiguration Property Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECONFIGURATION_PROPERTY_ELEMENT_FEATURE_COUNT = 2;

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.confml.model.metaext.EConfigurationPropertyElement <em>EConfiguration Property Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EConfiguration Property Element</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.metaext.EConfigurationPropertyElement
	 * @generated
	 */
	EClass getEConfigurationPropertyElement();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.metaext.EConfigurationPropertyElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.metaext.EConfigurationPropertyElement#getName()
	 * @see #getEConfigurationPropertyElement()
	 * @generated
	 */
	EAttribute getEConfigurationPropertyElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.confml.model.metaext.EConfigurationPropertyElement#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.nokia.tools.carbide.ct.confml.model.metaext.EConfigurationPropertyElement#getValue()
	 * @see #getEConfigurationPropertyElement()
	 * @generated
	 */
	EAttribute getEConfigurationPropertyElement_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EMetaExtFactory getEMetaExtFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.confml.model.metaext.impl.EConfigurationPropertyElementImpl <em>EConfiguration Property Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.confml.model.metaext.impl.EConfigurationPropertyElementImpl
		 * @see com.nokia.tools.carbide.ct.confml.model.metaext.impl.EMetaExtPackageImpl#getEConfigurationPropertyElement()
		 * @generated
		 */
		EClass ECONFIGURATION_PROPERTY_ELEMENT = eINSTANCE
				.getEConfigurationPropertyElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECONFIGURATION_PROPERTY_ELEMENT__NAME = eINSTANCE
				.getEConfigurationPropertyElement_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECONFIGURATION_PROPERTY_ELEMENT__VALUE = eINSTANCE
				.getEConfigurationPropertyElement_Value();

	}

} //EMetaExtPackage
