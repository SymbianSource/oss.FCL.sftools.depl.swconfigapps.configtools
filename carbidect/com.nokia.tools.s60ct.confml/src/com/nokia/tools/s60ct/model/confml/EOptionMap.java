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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EOption Map</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.EOptionMap#getMapValue <em>Map Value</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.EOptionMap#getValue2Save <em>Value2 Save</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getEOptionMap()
 * @model
 * @generated
 */
public interface EOptionMap extends ESettingOption {
	/**
	 * Returns the value of the '<em><b>Map Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Map Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Map Value</em>' attribute.
	 * @see #setMapValue(String)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getEOptionMap_MapValue()
	 * @model
	 * @generated
	 */
	String getMapValue();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.EOptionMap#getMapValue <em>Map Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Map Value</em>' attribute.
	 * @see #getMapValue()
	 * @generated
	 */
	void setMapValue(String value);

	/**
	 * Returns the value of the '<em><b>Value2 Save</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value2 Save</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value2 Save</em>' attribute.
	 * @see #setValue2Save(String)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getEOptionMap_Value2Save()
	 * @model
	 * @generated
	 */
	String getValue2Save();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.EOptionMap#getValue2Save <em>Value2 Save</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value2 Save</em>' attribute.
	 * @see #getValue2Save()
	 * @generated
	 */
	void setValue2Save(String value);

} // EOptionMap
