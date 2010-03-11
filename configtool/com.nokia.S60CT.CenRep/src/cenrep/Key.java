/*
* Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
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
package cenrep;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Key</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cenrep.Key#getName <em>Name</em>}</li>
 *   <li>{@link cenrep.Key#getIdent <em>Ident</em>}</li>
 *   <li>{@link cenrep.Key#getType <em>Type</em>}</li>
 *   <li>{@link cenrep.Key#getValue <em>Value</em>}</li>
 *   <li>{@link cenrep.Key#getBits <em>Bits</em>}</li>
 *   <li>{@link cenrep.Key#isBitmaskKey <em>Bitmask Key</em>}</li>
 *   <li>{@link cenrep.Key#isSimpleKey <em>Simple Key</em>}</li>
 *   <li>{@link cenrep.Key#getShortIdent <em>Short Ident</em>}</li>
 *   <li>{@link cenrep.Key#getStrType <em>Str Type</em>}</li>
 *   <li>{@link cenrep.Key#isDecFormat <em>Dec Format</em>}</li>
 *   <li>{@link cenrep.Key#isHexFormat <em>Hex Format</em>}</li>
 * </ul>
 * </p>
 *
 * @see cenrep.CenrepPackage#getKey()
 * @model
 * @generated
 */
public interface Key extends AttributeAndDescription, RVG, IReadOnly, IAccessable, IBackup {
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
	 * @see cenrep.CenrepPackage#getKey_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link cenrep.Key#getName <em>Name</em>}' attribute.
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
	 * @see cenrep.CenrepPackage#getKey_Ident()
	 * @model
	 * @generated
	 */
	String getIdent();

	/**
	 * Sets the value of the '{@link cenrep.Key#getIdent <em>Ident</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ident</em>' attribute.
	 * @see #getIdent()
	 * @generated
	 */
	void setIdent(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link cenrep.TYPE}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see cenrep.TYPE
	 * @see #setType(TYPE)
	 * @see cenrep.CenrepPackage#getKey_Type()
	 * @model
	 * @generated
	 */
	TYPE getType();

	/**
	 * Sets the value of the '{@link cenrep.Key#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see cenrep.TYPE
	 * @see #getType()
	 * @generated
	 */
	void setType(TYPE value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference list.
	 * The list contents are of type {@link cenrep.Value}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference list.
	 * @see cenrep.CenrepPackage#getKey_Value()
	 * @model containment="true"
	 * @generated
	 */
	EList<Value> getValue();

	/**
	 * Returns the value of the '<em><b>Bits</b></em>' containment reference list.
	 * The list contents are of type {@link cenrep.Bit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bits</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bits</em>' containment reference list.
	 * @see cenrep.CenrepPackage#getKey_Bits()
	 * @model containment="true"
	 * @generated
	 */
	EList<Bit> getBits();

	/**
	 * Returns the value of the '<em><b>Bitmask Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bitmask Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bitmask Key</em>' attribute.
	 * @see #setBitmaskKey(boolean)
	 * @see cenrep.CenrepPackage#getKey_BitmaskKey()
	 * @model transient="true" volatile="true"
	 * @generated
	 */
	boolean isBitmaskKey();

	/**
	 * Sets the value of the '{@link cenrep.Key#isBitmaskKey <em>Bitmask Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bitmask Key</em>' attribute.
	 * @see #isBitmaskKey()
	 * @generated
	 */
	void setBitmaskKey(boolean value);

	/**
	 * Returns the value of the '<em><b>Simple Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Key</em>' attribute.
	 * @see #setSimpleKey(boolean)
	 * @see cenrep.CenrepPackage#getKey_SimpleKey()
	 * @model transient="true" volatile="true"
	 * @generated
	 */
	boolean isSimpleKey();

	/**
	 * Sets the value of the '{@link cenrep.Key#isSimpleKey <em>Simple Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Key</em>' attribute.
	 * @see #isSimpleKey()
	 * @generated
	 */
	void setSimpleKey(boolean value);

	/**
	 * Returns the value of the '<em><b>Short Ident</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Short Ident</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Short Ident</em>' attribute.
	 * @see #setShortIdent(String)
	 * @see cenrep.CenrepPackage#getKey_ShortIdent()
	 * @model transient="true" volatile="true"
	 * @generated
	 */
	String getShortIdent();

	/**
	 * Sets the value of the '{@link cenrep.Key#getShortIdent <em>Short Ident</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Short Ident</em>' attribute.
	 * @see #getShortIdent()
	 * @generated
	 */
	void setShortIdent(String value);

	/**
	 * Returns the value of the '<em><b>Str Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Str Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Str Type</em>' attribute.
	 * @see cenrep.CenrepPackage#getKey_StrType()
	 * @model transient="true" changeable="false" volatile="true"
	 * @generated
	 */
	String getStrType();

	/**
	 * Returns the value of the '<em><b>Dec Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dec Format</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dec Format</em>' attribute.
	 * @see cenrep.CenrepPackage#getKey_DecFormat()
	 * @model transient="true" changeable="false" volatile="true"
	 * @generated
	 */
	boolean isDecFormat();

	/**
	 * Returns the value of the '<em><b>Hex Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hex Format</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hex Format</em>' attribute.
	 * @see cenrep.CenrepPackage#getKey_HexFormat()
	 * @model transient="true" changeable="false" volatile="true"
	 * @generated
	 */
	boolean isHexFormat();

} // Key