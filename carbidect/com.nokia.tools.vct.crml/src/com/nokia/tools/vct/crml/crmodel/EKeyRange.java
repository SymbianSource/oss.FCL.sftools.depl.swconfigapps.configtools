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
 * A representation of the model object '<em><b>EKey Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.EKeyRange#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.EKeyRange#getInt <em>Int</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.EKeyRange#getFirstInt <em>First Int</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.EKeyRange#getLastInt <em>Last Int</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.EKeyRange#getIndexBits <em>Index Bits</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.EKeyRange#getFirstIndex <em>First Index</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.EKeyRange#getCountInt <em>Count Int</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.EKeyRange#getKeys <em>Keys</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getEKeyRange()
 * @model extendedMetaData="name='keyRangeType' kind='elementOnly'"
 * @generated
 */
public interface EKeyRange extends EAttributeAndDescription, ERefContainer, EReadOnly, EAccessContainer, EBackup {
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
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getEKeyRange_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.crml.crmodel.EKeyRange#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Int</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Int</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Int</em>' attribute.
	 * @see #setInt(String)
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getEKeyRange_Int()
	 * @model
	 * @generated
	 */
	String getInt();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.crml.crmodel.EKeyRange#getInt <em>Int</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Int</em>' attribute.
	 * @see #getInt()
	 * @generated
	 */
	void setInt(String value);

	/**
	 * Returns the value of the '<em><b>First Int</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Int</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Int</em>' attribute.
	 * @see #setFirstInt(String)
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getEKeyRange_FirstInt()
	 * @model
	 * @generated
	 */
	String getFirstInt();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.crml.crmodel.EKeyRange#getFirstInt <em>First Int</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Int</em>' attribute.
	 * @see #getFirstInt()
	 * @generated
	 */
	void setFirstInt(String value);

	/**
	 * Returns the value of the '<em><b>Last Int</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Int</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Int</em>' attribute.
	 * @see #setLastInt(String)
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getEKeyRange_LastInt()
	 * @model
	 * @generated
	 */
	String getLastInt();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.crml.crmodel.EKeyRange#getLastInt <em>Last Int</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Int</em>' attribute.
	 * @see #getLastInt()
	 * @generated
	 */
	void setLastInt(String value);

	/**
	 * Returns the value of the '<em><b>Index Bits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index Bits</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index Bits</em>' attribute.
	 * @see #setIndexBits(String)
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getEKeyRange_IndexBits()
	 * @model
	 * @generated
	 */
	String getIndexBits();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.crml.crmodel.EKeyRange#getIndexBits <em>Index Bits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index Bits</em>' attribute.
	 * @see #getIndexBits()
	 * @generated
	 */
	void setIndexBits(String value);

	/**
	 * Returns the value of the '<em><b>First Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Index</em>' attribute.
	 * @see #setFirstIndex(String)
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getEKeyRange_FirstIndex()
	 * @model
	 * @generated
	 */
	String getFirstIndex();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.crml.crmodel.EKeyRange#getFirstIndex <em>First Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Index</em>' attribute.
	 * @see #getFirstIndex()
	 * @generated
	 */
	void setFirstIndex(String value);

	/**
	 * Returns the value of the '<em><b>Count Int</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Count Int</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Count Int</em>' attribute.
	 * @see #setCountInt(String)
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getEKeyRange_CountInt()
	 * @model
	 * @generated
	 */
	String getCountInt();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.crml.crmodel.EKeyRange#getCountInt <em>Count Int</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Count Int</em>' attribute.
	 * @see #getCountInt()
	 * @generated
	 */
	void setCountInt(String value);

	/**
	 * Returns the value of the '<em><b>Keys</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.crml.crmodel.EKey}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Keys</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Keys</em>' containment reference list.
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getEKeyRange_Keys()
	 * @model containment="true"
	 *        extendedMetaData="name='key' namespace='##targetNamespace' kind='element'"
	 * @generated
	 */
	EList<EKey> getKeys();

} // EKeyRange
