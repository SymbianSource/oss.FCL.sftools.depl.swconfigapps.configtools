/*
* Copyright (c) 2007 Nokia Corporation and/or its subsidiary(-ies). 
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
package com.nokia.tools.s60ct.model.confml;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage
 * @generated
 */
public interface ConfmlFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConfmlFactory eINSTANCE = com.nokia.tools.s60ct.model.confml.impl.ConfmlFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>EFeature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EFeature</em>'.
	 * @generated
	 */
	EFeature createEFeature();

	/**
	 * Returns a new object of class '<em>ESimple Setting</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ESimple Setting</em>'.
	 * @generated
	 */
	ESimpleSetting createESimpleSetting();

	/**
	 * Returns a new object of class '<em>ESequence Setting</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ESequence Setting</em>'.
	 * @generated
	 */
	ESequenceSetting createESequenceSetting();

	/**
	 * Returns a new object of class '<em>EItem Setting</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EItem Setting</em>'.
	 * @generated
	 */
	EItemSetting createEItemSetting();

	/**
	 * Returns a new object of class '<em>ESub Setting Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ESub Setting Value</em>'.
	 * @generated
	 */
	ESubSettingValue createESubSettingValue();

	/**
	 * Returns a new object of class '<em>EResource Setting</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EResource Setting</em>'.
	 * @generated
	 */
	EResourceSetting createEResourceSetting();

	/**
	 * Returns a new object of class '<em>ESimple Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ESimple Value</em>'.
	 * @generated
	 */
	ESimpleValue createESimpleValue();

	/**
	 * Returns a new object of class '<em>ESequence Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ESequence Value</em>'.
	 * @generated
	 */
	ESequenceValue createESequenceValue();

	/**
	 * Returns a new object of class '<em>ESequence Value Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ESequence Value Item</em>'.
	 * @generated
	 */
	ESequenceValueItem createESequenceValueItem();

	/**
	 * Returns a new object of class '<em>EResource Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EResource Value</em>'.
	 * @generated
	 */
	EResourceValue createEResourceValue();

	/**
	 * Returns a new object of class '<em>EProperty</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EProperty</em>'.
	 * @generated
	 */
	EProperty createEProperty();

	/**
	 * Returns a new object of class '<em>EOption Map</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EOption Map</em>'.
	 * @generated
	 */
	EOptionMap createEOptionMap();

	/**
	 * Returns a new object of class '<em>EOption</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EOption</em>'.
	 * @generated
	 */
	EOption createEOption();

	/**
	 * Returns a new object of class '<em>EValue Editor Document</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EValue Editor Document</em>'.
	 * @generated
	 */
	EValueEditorDocument createEValueEditorDocument();

	/**
	 * Returns a new object of class '<em>Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pattern</em>'.
	 * @generated
	 */
	Pattern createPattern();

	/**
	 * Returns a new object of class '<em>View</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>View</em>'.
	 * @generated
	 */
	View createView();

	/**
	 * Returns a new object of class '<em>EGroup</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EGroup</em>'.
	 * @generated
	 */
	EGroup createEGroup();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ConfmlPackage getConfmlPackage();

} //ConfmlFactory
