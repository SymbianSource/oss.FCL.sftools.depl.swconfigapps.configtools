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
 * Description: This file is part of com.nokia.tools.vct.common.appmodel component.
 */

package com.nokia.tools.vct.common.appmodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage
 * @generated
 */
public interface EApplicationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EApplicationFactory eINSTANCE = com.nokia.tools.vct.common.appmodel.impl.EApplicationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>EConf ML Layer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EConf ML Layer</em>'.
	 * @generated
	 */
	EConfMLLayer createEConfMLLayer();

	/**
	 * Returns a new object of class '<em>EApp Feature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EApp Feature</em>'.
	 * @generated
	 */
	EAppFeature createEAppFeature();

	/**
	 * Returns a new object of class '<em>EApp View</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EApp View</em>'.
	 * @generated
	 */
	EAppView createEAppView();

	/**
	 * Returns a new object of class '<em>EApp Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EApp Group</em>'.
	 * @generated
	 */
	EAppGroup createEAppGroup();

	/**
	 * Returns a new object of class '<em>EApp Setting Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EApp Setting Ref</em>'.
	 * @generated
	 */
	EAppSettingRef createEAppSettingRef();

	/**
	 * Returns a new object of class '<em>EApp Simple Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EApp Simple Data</em>'.
	 * @generated
	 */
	EAppSimpleData createEAppSimpleData();

	/**
	 * Returns a new object of class '<em>EApp Sequence Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EApp Sequence Data</em>'.
	 * @generated
	 */
	EAppSequenceData createEAppSequenceData();

	/**
	 * Returns a new object of class '<em>EApp Sequence Data Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EApp Sequence Data Item</em>'.
	 * @generated
	 */
	EAppSequenceDataItem createEAppSequenceDataItem();

	/**
	 * Returns a new object of class '<em>EApp Resource Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EApp Resource Data</em>'.
	 * @generated
	 */
	EAppResourceData createEAppResourceData();

	/**
	 * Returns a new object of class '<em>EApp Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EApp Expression</em>'.
	 * @generated
	 */
	EAppExpression createEAppExpression();

	/**
	 * Returns a new object of class '<em>EApp Simple Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EApp Simple Type</em>'.
	 * @generated
	 */
	EAppSimpleType createEAppSimpleType();

	/**
	 * Returns a new object of class '<em>EApp Sequence Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EApp Sequence Type</em>'.
	 * @generated
	 */
	EAppSequenceType createEAppSequenceType();

	/**
	 * Returns a new object of class '<em>EApp Resource Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EApp Resource Type</em>'.
	 * @generated
	 */
	EAppResourceType createEAppResourceType();

	/**
	 * Returns a new object of class '<em>EApp Setting Option</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EApp Setting Option</em>'.
	 * @generated
	 */
	EAppSettingOption createEAppSettingOption();

	/**
	 * Returns a new object of class '<em>EApp Setting</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EApp Setting</em>'.
	 * @generated
	 */
	EAppSetting createEAppSetting();

	/**
	 * Returns a new object of class '<em>EApp Rfs Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EApp Rfs Info</em>'.
	 * @generated
	 */
	EAppRfsInfo createEAppRfsInfo();

	/**
	 * Returns a new object of class '<em>EApp Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EApp Property</em>'.
	 * @generated
	 */
	EAppProperty createEAppProperty();

	/**
	 * Returns a new object of class '<em>EConfiguration Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EConfiguration Project</em>'.
	 * @generated
	 */
	EConfigurationProject createEConfigurationProject();

	/**
	 * Returns a new object of class '<em>EApp Include Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EApp Include Element</em>'.
	 * @generated
	 */
	EAppIncludeElement createEAppIncludeElement();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EApplicationPackage getEApplicationPackage();

} //EApplicationFactory
