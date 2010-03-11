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
 * Description: This file is part of com.nokia.tools.vct.crml component.
 */

package com.nokia.tools.vct.crml.crmodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EKey</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.EKey#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.EKey#getIdent <em>Ident</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.EKey#getType <em>Type</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.EKey#getValue <em>Value</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.EKey#getBits <em>Bits</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getEKey()
 * @model extendedMetaData="name='keyType' kind='elementOnly'"
 * @generated
 */
public interface EKey extends EAttributeAndDescription, ERefContainer, EReadOnly, EAccessContainer, EBackup {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getEKey_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.crml.crmodel.EKey#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Ident</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ident</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ident</em>' attribute.
	 * @see #setIdent(String)
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getEKey_Ident()
	 * @model extendedMetaData="name='int' kind='attribute'"
	 * @generated
	 */
	String getIdent();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.crml.crmodel.EKey#getIdent <em>Ident</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ident</em>' attribute.
	 * @see #getIdent()
	 * @generated
	 */
	void setIdent(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link com.nokia.tools.vct.crml.crmodel.EKeyType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see com.nokia.tools.vct.crml.crmodel.EKeyType
	 * @see #setType(EKeyType)
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getEKey_Type()
	 * @model
	 * @generated
	 */
	EKeyType getType();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.crml.crmodel.EKey#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see com.nokia.tools.vct.crml.crmodel.EKeyType
	 * @see #getType()
	 * @generated
	 */
	void setType(EKeyType value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.crml.crmodel.EValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference list.
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getEKey_Value()
	 * @model containment="true"
	 *        extendedMetaData="name='value' namespace='##targetNamespace' kind='element'"
	 * @generated
	 */
	EList<EValue> getValue();

	/**
	 * Returns the value of the '<em><b>Bits</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.crml.crmodel.EBit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bits</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bits</em>' containment reference list.
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getEKey_Bits()
	 * @model containment="true"
	 *        extendedMetaData="name='bit' namespace='##targetNamespace' kind='element'"
	 * @generated
	 */
	EList<EBit> getBits();

} // EKey
