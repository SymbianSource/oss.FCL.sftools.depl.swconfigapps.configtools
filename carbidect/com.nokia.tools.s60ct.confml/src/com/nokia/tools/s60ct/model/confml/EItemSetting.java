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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EItem Setting</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.EItemSetting#getNumber <em>Number</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.EItemSetting#getSubSettings <em>Sub Settings</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.EItemSetting#getFields <em>Fields</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getEItemSetting()
 * @model
 * @generated
 */
public interface EItemSetting extends EObject {
	/**
	 * Returns the value of the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number</em>' attribute.
	 * @see #setNumber(int)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getEItemSetting_Number()
	 * @model
	 * @generated
	 */
	int getNumber();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.EItemSetting#getNumber <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number</em>' attribute.
	 * @see #getNumber()
	 * @generated
	 */
	void setNumber(int value);

	/**
	 * Returns the value of the '<em><b>Sub Settings</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.s60ct.model.confml.ESubSettingValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Settings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Settings</em>' containment reference list.
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getEItemSetting_SubSettings()
	 * @model containment="true"
	 * @generated
	 */
	EList<ESubSettingValue> getSubSettings();

	/**
	 * Returns the value of the '<em><b>Fields</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.s60ct.model.confml.ESetting}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fields</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fields</em>' containment reference list.
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getEItemSetting_Fields()
	 * @model containment="true"
	 * @generated
	 */
	EList<ESetting> getFields();

} // EItemSetting
