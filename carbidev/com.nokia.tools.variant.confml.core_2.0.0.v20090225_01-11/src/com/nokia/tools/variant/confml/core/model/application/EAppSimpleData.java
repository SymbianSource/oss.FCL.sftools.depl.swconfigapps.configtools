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

package com.nokia.tools.variant.confml.core.model.application;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EApp Simple Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.EAppSimpleData#getValue <em>Value</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.EAppSimpleData#getMap <em>Map</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppSimpleData()
 * @model
 * @generated
 */
public interface EAppSimpleData extends EAppSettingData {
	/**
     * Returns the value of the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Value</em>' attribute.
     * @see #setValue(String)
     * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppSimpleData_Value()
     * @model
     * @generated
     */
	String getValue();

	/**
     * Sets the value of the '{@link com.nokia.tools.variant.confml.core.model.application.EAppSimpleData#getValue <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value</em>' attribute.
     * @see #getValue()
     * @generated
     */
	void setValue(String value);

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
     * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppSimpleData_Map()
     * @model
     * @generated
     */
	String getMap();

	/**
     * Sets the value of the '{@link com.nokia.tools.variant.confml.core.model.application.EAppSimpleData#getMap <em>Map</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Map</em>' attribute.
     * @see #getMap()
     * @generated
     */
	void setMap(String value);

} // EAppSimpleData
