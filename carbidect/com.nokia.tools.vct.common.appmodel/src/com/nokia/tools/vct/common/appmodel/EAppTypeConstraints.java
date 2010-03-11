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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * <p>
 * Interface for representation of primitive value constraints. This interface is applicable for simple setting types and for setting references of simple types.
 * </p>
 * <p>
 * The actual value type depends on the linked value type: <ul>
 * <li>{@link java.math.BigDecimal} for numeric types (integer and real)</li>
 * <li>{@link javax.xml.datatype.Duration} for duration</li>
 * <li>{@link javax.xml.datatype.XMLGregorianCalendar} for date, time and dateTime types</li>
 * </ul> 
 * </p>
 *  
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppTypeConstraints#getMinInclusive <em>Min Inclusive</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppTypeConstraints#getMaxInclusive <em>Max Inclusive</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppTypeConstraints#getMinExclusive <em>Min Exclusive</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppTypeConstraints#getMaxExclusive <em>Max Exclusive</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppTypeConstraints#getMinLength <em>Min Length</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppTypeConstraints#getLength <em>Length</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppTypeConstraints#getMaxLength <em>Max Length</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppTypeConstraints#getTotalDigits <em>Total Digits</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppTypeConstraints#getPattern <em>Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppTypeConstraints()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface EAppTypeConstraints extends EObject {
	/**
	 * Returns the value of the '<em><b>Min Inclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Inclusive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Inclusive</em>' attribute.
	 * @see #setMinInclusive(Object)
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppTypeConstraints_MinInclusive()
	 * @model
	 * @generated
	 */
	Object getMinInclusive();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.common.appmodel.EAppTypeConstraints#getMinInclusive <em>Min Inclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Inclusive</em>' attribute.
	 * @see #getMinInclusive()
	 * @generated
	 */
	void setMinInclusive(Object value);

	/**
	 * Returns the value of the '<em><b>Max Inclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Inclusive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Inclusive</em>' attribute.
	 * @see #setMaxInclusive(Object)
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppTypeConstraints_MaxInclusive()
	 * @model
	 * @generated
	 */
	Object getMaxInclusive();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.common.appmodel.EAppTypeConstraints#getMaxInclusive <em>Max Inclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Inclusive</em>' attribute.
	 * @see #getMaxInclusive()
	 * @generated
	 */
	void setMaxInclusive(Object value);

	/**
	 * Returns the value of the '<em><b>Min Exclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Exclusive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Exclusive</em>' attribute.
	 * @see #setMinExclusive(Object)
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppTypeConstraints_MinExclusive()
	 * @model
	 * @generated
	 */
	Object getMinExclusive();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.common.appmodel.EAppTypeConstraints#getMinExclusive <em>Min Exclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Exclusive</em>' attribute.
	 * @see #getMinExclusive()
	 * @generated
	 */
	void setMinExclusive(Object value);

	/**
	 * Returns the value of the '<em><b>Max Exclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Exclusive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Exclusive</em>' attribute.
	 * @see #setMaxExclusive(Object)
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppTypeConstraints_MaxExclusive()
	 * @model
	 * @generated
	 */
	Object getMaxExclusive();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.common.appmodel.EAppTypeConstraints#getMaxExclusive <em>Max Exclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Exclusive</em>' attribute.
	 * @see #getMaxExclusive()
	 * @generated
	 */
	void setMaxExclusive(Object value);

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
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppTypeConstraints_MinLength()
	 * @model
	 * @generated
	 */
	Integer getMinLength();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.common.appmodel.EAppTypeConstraints#getMinLength <em>Min Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Length</em>' attribute.
	 * @see #getMinLength()
	 * @generated
	 */
	void setMinLength(Integer value);

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
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppTypeConstraints_Length()
	 * @model
	 * @generated
	 */
	Integer getLength();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.common.appmodel.EAppTypeConstraints#getLength <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Length</em>' attribute.
	 * @see #getLength()
	 * @generated
	 */
	void setLength(Integer value);

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
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppTypeConstraints_MaxLength()
	 * @model
	 * @generated
	 */
	Integer getMaxLength();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.common.appmodel.EAppTypeConstraints#getMaxLength <em>Max Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Length</em>' attribute.
	 * @see #getMaxLength()
	 * @generated
	 */
	void setMaxLength(Integer value);

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
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppTypeConstraints_TotalDigits()
	 * @model
	 * @generated
	 */
	Integer getTotalDigits();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.common.appmodel.EAppTypeConstraints#getTotalDigits <em>Total Digits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Digits</em>' attribute.
	 * @see #getTotalDigits()
	 * @generated
	 */
	void setTotalDigits(Integer value);

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
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppTypeConstraints_Pattern()
	 * @model
	 * @generated
	 */
	EList<String> getPattern();

} // EAppTypeConstraints
