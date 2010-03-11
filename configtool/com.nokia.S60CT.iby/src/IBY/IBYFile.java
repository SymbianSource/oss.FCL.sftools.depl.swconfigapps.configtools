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
package IBY;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link IBY.IBYFile#getName <em>Name</em>}</li>
 *   <li>{@link IBY.IBYFile#getLocationt <em>Locationt</em>}</li>
 *   <li>{@link IBY.IBYFile#getEntries <em>Entries</em>}</li>
 *   <li>{@link IBY.IBYFile#getFlag <em>Flag</em>}</li>
 *   <li>{@link IBY.IBYFile#isValidContent <em>Valid Content</em>}</li>
 * </ul>
 * </p>
 *
 * @see IBY.IBYPackage#getIBYFile()
 * @model
 * @generated
 */
public interface IBYFile extends EObject {
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
	 * @see IBY.IBYPackage#getIBYFile_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link IBY.IBYFile#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Locationt</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Locationt</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Locationt</em>' containment reference.
	 * @see #setLocationt(Location)
	 * @see IBY.IBYPackage#getIBYFile_Locationt()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Location getLocationt();

	/**
	 * Sets the value of the '{@link IBY.IBYFile#getLocationt <em>Locationt</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Locationt</em>' containment reference.
	 * @see #getLocationt()
	 * @generated
	 */
	void setLocationt(Location value);

	/**
	 * Returns the value of the '<em><b>Entries</b></em>' containment reference list.
	 * The list contents are of type {@link IBY.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entries</em>' containment reference list.
	 * @see IBY.IBYPackage#getIBYFile_Entries()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<Entry> getEntries();

	/**
	 * Returns the value of the '<em><b>Flag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flag</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flag</em>' attribute.
	 * @see #setFlag(String)
	 * @see IBY.IBYPackage#getIBYFile_Flag()
	 * @model
	 * @generated
	 */
	String getFlag();

	/**
	 * Sets the value of the '{@link IBY.IBYFile#getFlag <em>Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flag</em>' attribute.
	 * @see #getFlag()
	 * @generated
	 */
	void setFlag(String value);

	/**
	 * Returns the value of the '<em><b>Valid Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Valid Content</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Valid Content</em>' attribute.
	 * @see IBY.IBYPackage#getIBYFile_ValidContent()
	 * @model transient="true" changeable="false" volatile="true"
	 * @generated
	 */
	boolean isValidContent();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void reset();

} // IBYFile
