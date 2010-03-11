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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ESetting Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESettingValue#getRef <em>Ref</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESettingValue#getType <em>Type</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESettingValue#getMap <em>Map</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESettingValue#getChosenOption <em>Chosen Option</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESettingValue()
 * @model abstract="true"
 * @generated
 */
public interface ESettingValue extends EObject {
	/**
	 * Returns the value of the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref</em>' attribute.
	 * @see #setRef(String)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESettingValue_Ref()
	 * @model required="true"
	 * @generated
	 */
	String getRef();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESettingValue#getRef <em>Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref</em>' attribute.
	 * @see #getRef()
	 * @generated
	 */
	void setRef(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(ESetting)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESettingValue_Type()
	 * @model required="true"
	 * @generated
	 */
	ESetting getType();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESettingValue#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(ESetting value);

	/**
	 * Returns the value of the '<em><b>Map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Map</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Map</em>' attribute.
	 * @see #setMap(String)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESettingValue_Map()
	 * @model
	 * @generated
	 */
	String getMap();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESettingValue#getMap <em>Map</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Map</em>' attribute.
	 * @see #getMap()
	 * @generated
	 */
	void setMap(String value);

	/**
	 * Returns the value of the '<em><b>Chosen Option</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Chosen Option</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chosen Option</em>' attribute.
	 * @see #setChosenOption(String)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESettingValue_ChosenOption()
	 * @model
	 * @generated
	 */
	String getChosenOption();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESettingValue#getChosenOption <em>Chosen Option</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Chosen Option</em>' attribute.
	 * @see #getChosenOption()
	 * @generated
	 */
	void setChosenOption(String value);

} // ESettingValue
