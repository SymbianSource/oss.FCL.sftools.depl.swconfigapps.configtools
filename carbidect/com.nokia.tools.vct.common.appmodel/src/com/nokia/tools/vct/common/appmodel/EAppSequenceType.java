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


/**
 * <!-- begin-user-doc -->
 * Object mapping for sequence type information.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppSequenceType#getMinOccurs <em>Min Occurs</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppSequenceType#getMaxOccurs <em>Max Occurs</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppSequenceType#getMapKey <em>Map Key</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppSequenceType#getMapValue <em>Map Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppSequenceType()
 * @model
 * @generated
 */
public interface EAppSequenceType extends EAppTypeContainer, EAppSettingType {
	/**
	 * Returns the value of the '<em><b>Min Occurs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Occurs</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Occurs</em>' attribute.
	 * @see #setMinOccurs(Integer)
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppSequenceType_MinOccurs()
	 * @model
	 * @generated
	 */
	Integer getMinOccurs();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.common.appmodel.EAppSequenceType#getMinOccurs <em>Min Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Occurs</em>' attribute.
	 * @see #getMinOccurs()
	 * @generated
	 */
	void setMinOccurs(Integer value);

	/**
	 * Returns the value of the '<em><b>Max Occurs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Occurs</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Occurs</em>' attribute.
	 * @see #setMaxOccurs(Integer)
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppSequenceType_MaxOccurs()
	 * @model
	 * @generated
	 */
	Integer getMaxOccurs();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.common.appmodel.EAppSequenceType#getMaxOccurs <em>Max Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Occurs</em>' attribute.
	 * @see #getMaxOccurs()
	 * @generated
	 */
	void setMaxOccurs(Integer value);

	/**
	 * Returns the value of the '<em><b>Map Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Map Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Map Key</em>' attribute.
	 * @see #setMapKey(String)
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppSequenceType_MapKey()
	 * @model
	 * @generated
	 */
	String getMapKey();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.common.appmodel.EAppSequenceType#getMapKey <em>Map Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Map Key</em>' attribute.
	 * @see #getMapKey()
	 * @generated
	 */
	void setMapKey(String value);

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
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppSequenceType_MapValue()
	 * @model
	 * @generated
	 */
	String getMapValue();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.common.appmodel.EAppSequenceType#getMapValue <em>Map Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Map Value</em>' attribute.
	 * @see #getMapValue()
	 * @generated
	 */
	void setMapValue(String value);

} // EAppSequenceType
