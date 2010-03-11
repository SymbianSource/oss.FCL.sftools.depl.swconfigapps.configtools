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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ESimple Setting</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESimpleSetting#getType <em>Type</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESimpleSetting#getMinInclusive <em>Min Inclusive</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESimpleSetting#getMaxInclusive <em>Max Inclusive</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESimpleSetting#getMinExclusive <em>Min Exclusive</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESimpleSetting#getMaxExclusive <em>Max Exclusive</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESimpleSetting#getMinLength <em>Min Length</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESimpleSetting#getMaxLength <em>Max Length</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESimpleSetting#getLength <em>Length</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESimpleSetting#getPattern <em>Pattern</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESimpleSetting#getTotalDigits <em>Total Digits</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESimpleSetting#getOptions <em>Options</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESimpleSetting()
 * @model
 * @generated
 */
public interface ESimpleSetting extends ESetting {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link com.nokia.tools.s60ct.model.confml.ESettingValueType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see com.nokia.tools.s60ct.model.confml.ESettingValueType
	 * @see #setType(ESettingValueType)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESimpleSetting_Type()
	 * @model required="true"
	 * @generated
	 */
	ESettingValueType getType();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESimpleSetting#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see com.nokia.tools.s60ct.model.confml.ESettingValueType
	 * @see #getType()
	 * @generated
	 */
	void setType(ESettingValueType value);

	/**
	 * Returns the value of the '<em><b>Min Inclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Inclusive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Inclusive</em>' attribute.
	 * @see #setMinInclusive(String)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESimpleSetting_MinInclusive()
	 * @model
	 * @generated
	 */
	String getMinInclusive();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESimpleSetting#getMinInclusive <em>Min Inclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Inclusive</em>' attribute.
	 * @see #getMinInclusive()
	 * @generated
	 */
	void setMinInclusive(String value);

	/**
	 * Returns the value of the '<em><b>Max Inclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Inclusive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Inclusive</em>' attribute.
	 * @see #setMaxInclusive(String)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESimpleSetting_MaxInclusive()
	 * @model
	 * @generated
	 */
	String getMaxInclusive();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESimpleSetting#getMaxInclusive <em>Max Inclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Inclusive</em>' attribute.
	 * @see #getMaxInclusive()
	 * @generated
	 */
	void setMaxInclusive(String value);

	/**
	 * Returns the value of the '<em><b>Min Exclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Exclusive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Exclusive</em>' attribute.
	 * @see #setMinExclusive(String)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESimpleSetting_MinExclusive()
	 * @model
	 * @generated
	 */
	String getMinExclusive();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESimpleSetting#getMinExclusive <em>Min Exclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Exclusive</em>' attribute.
	 * @see #getMinExclusive()
	 * @generated
	 */
	void setMinExclusive(String value);

	/**
	 * Returns the value of the '<em><b>Max Exclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Exclusive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Exclusive</em>' attribute.
	 * @see #setMaxExclusive(String)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESimpleSetting_MaxExclusive()
	 * @model
	 * @generated
	 */
	String getMaxExclusive();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESimpleSetting#getMaxExclusive <em>Max Exclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Exclusive</em>' attribute.
	 * @see #getMaxExclusive()
	 * @generated
	 */
	void setMaxExclusive(String value);

	/**
	 * Returns the value of the '<em><b>Min Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Length</em>' attribute.
	 * @see #setMinLength(Integer)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESimpleSetting_MinLength()
	 * @model
	 * @generated
	 */
	Integer getMinLength();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESimpleSetting#getMinLength <em>Min Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Length</em>' attribute.
	 * @see #getMinLength()
	 * @generated
	 */
	void setMinLength(Integer value);

	/**
	 * Returns the value of the '<em><b>Max Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Length</em>' attribute.
	 * @see #setMaxLength(Integer)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESimpleSetting_MaxLength()
	 * @model
	 * @generated
	 */
	Integer getMaxLength();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESimpleSetting#getMaxLength <em>Max Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Length</em>' attribute.
	 * @see #getMaxLength()
	 * @generated
	 */
	void setMaxLength(Integer value);

	/**
	 * Returns the value of the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Length</em>' attribute.
	 * @see #setLength(Integer)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESimpleSetting_Length()
	 * @model
	 * @generated
	 */
	Integer getLength();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESimpleSetting#getLength <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Length</em>' attribute.
	 * @see #getLength()
	 * @generated
	 */
	void setLength(Integer value);

	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' attribute list.
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESimpleSetting_Pattern()
	 * @model
	 * @generated
	 */
	EList<String> getPattern();

	/**
	 * Returns the value of the '<em><b>Total Digits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Digits</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Digits</em>' attribute.
	 * @see #setTotalDigits(Integer)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESimpleSetting_TotalDigits()
	 * @model
	 * @generated
	 */
	Integer getTotalDigits();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESimpleSetting#getTotalDigits <em>Total Digits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Digits</em>' attribute.
	 * @see #getTotalDigits()
	 * @generated
	 */
	void setTotalDigits(Integer value);

	/**
	 * Returns the value of the '<em><b>Options</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.s60ct.model.confml.ESettingOption}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Options</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Options</em>' containment reference list.
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESimpleSetting_Options()
	 * @model containment="true"
	 * @generated
	 */
	EList<ESettingOption> getOptions();

} // ESimpleSetting
