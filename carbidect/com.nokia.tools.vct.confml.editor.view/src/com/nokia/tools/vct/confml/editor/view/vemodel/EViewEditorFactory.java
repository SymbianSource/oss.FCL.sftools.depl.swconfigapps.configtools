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
 * Description: This file is part of com.nokia.tools.vct.confml.editor.view component.
 */

package com.nokia.tools.vct.confml.editor.view.vemodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage
 * @generated
 */
public interface EViewEditorFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EViewEditorFactory eINSTANCE = com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEditorFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>EViews Editor Document</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EViews Editor Document</em>'.
	 * @generated
	 */
	EViewsEditorDocument createEViewsEditorDocument();

	/**
	 * Returns a new object of class '<em>EView</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EView</em>'.
	 * @generated
	 */
	EView createEView();

	/**
	 * Returns a new object of class '<em>EGroup</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EGroup</em>'.
	 * @generated
	 */
	EGroup createEGroup();

	/**
	 * Returns a new object of class '<em>ESetting Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ESetting Ref</em>'.
	 * @generated
	 */
	ESettingRef createESettingRef();

	/**
	 * Returns a new object of class '<em>EFeature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EFeature</em>'.
	 * @generated
	 */
	EFeature createEFeature();

	/**
	 * Returns a new object of class '<em>ESetting</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ESetting</em>'.
	 * @generated
	 */
	ESetting createESetting();

	/**
	 * Returns a new object of class '<em>ERef Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ERef Property</em>'.
	 * @generated
	 */
	ERefProperty createERefProperty();

	/**
	 * Returns a new object of class '<em>ERef Option</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ERef Option</em>'.
	 * @generated
	 */
	ERefOption createERefOption();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EViewEditorPackage getEViewEditorPackage();

} //EViewEditorFactory
