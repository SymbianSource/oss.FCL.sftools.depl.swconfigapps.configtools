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
 * A representation of the model object '<em><b>Key Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cenrep.KeyRange#getName <em>Name</em>}</li>
 *   <li>{@link cenrep.KeyRange#getInt <em>Int</em>}</li>
 *   <li>{@link cenrep.KeyRange#getFirstInt <em>First Int</em>}</li>
 *   <li>{@link cenrep.KeyRange#getLastInt <em>Last Int</em>}</li>
 *   <li>{@link cenrep.KeyRange#getIndexBits <em>Index Bits</em>}</li>
 *   <li>{@link cenrep.KeyRange#getFirstIndex <em>First Index</em>}</li>
 *   <li>{@link cenrep.KeyRange#getCountInt <em>Count Int</em>}</li>
 *   <li>{@link cenrep.KeyRange#getKeys <em>Keys</em>}</li>
 * </ul>
 * </p>
 *
 * @see cenrep.CenrepPackage#getKeyRange()
 * @model
 * @generated
 */
public interface KeyRange extends AttributeAndDescription, RVG, IReadOnly, IAccessable, IBackup {
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
	 * @see cenrep.CenrepPackage#getKeyRange_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link cenrep.KeyRange#getName <em>Name</em>}' attribute.
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
	 * @see cenrep.CenrepPackage#getKeyRange_Int()
	 * @model
	 * @generated
	 */
	String getInt();

	/**
	 * Sets the value of the '{@link cenrep.KeyRange#getInt <em>Int</em>}' attribute.
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
	 * @see cenrep.CenrepPackage#getKeyRange_FirstInt()
	 * @model
	 * @generated
	 */
	String getFirstInt();

	/**
	 * Sets the value of the '{@link cenrep.KeyRange#getFirstInt <em>First Int</em>}' attribute.
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
	 * @see cenrep.CenrepPackage#getKeyRange_LastInt()
	 * @model
	 * @generated
	 */
	String getLastInt();

	/**
	 * Sets the value of the '{@link cenrep.KeyRange#getLastInt <em>Last Int</em>}' attribute.
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
	 * @see cenrep.CenrepPackage#getKeyRange_IndexBits()
	 * @model
	 * @generated
	 */
	String getIndexBits();

	/**
	 * Sets the value of the '{@link cenrep.KeyRange#getIndexBits <em>Index Bits</em>}' attribute.
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
	 * @see cenrep.CenrepPackage#getKeyRange_FirstIndex()
	 * @model
	 * @generated
	 */
	String getFirstIndex();

	/**
	 * Sets the value of the '{@link cenrep.KeyRange#getFirstIndex <em>First Index</em>}' attribute.
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
	 * @see cenrep.CenrepPackage#getKeyRange_CountInt()
	 * @model
	 * @generated
	 */
	String getCountInt();

	/**
	 * Sets the value of the '{@link cenrep.KeyRange#getCountInt <em>Count Int</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Count Int</em>' attribute.
	 * @see #getCountInt()
	 * @generated
	 */
	void setCountInt(String value);

	/**
	 * Returns the value of the '<em><b>Keys</b></em>' containment reference list.
	 * The list contents are of type {@link cenrep.Key}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Keys</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Keys</em>' containment reference list.
	 * @see cenrep.CenrepPackage#getKeyRange_Keys()
	 * @model containment="true"
	 * @generated
	 */
	EList<Key> getKeys();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" many="false"
	 * @generated
	 */
	EList<Key> getGKeys();

} // KeyRange
