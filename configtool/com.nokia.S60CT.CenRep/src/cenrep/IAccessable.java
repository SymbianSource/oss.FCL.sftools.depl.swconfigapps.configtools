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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IAccessable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cenrep.IAccessable#getAccess <em>Access</em>}</li>
 *   <li>{@link cenrep.IAccessable#getReadAccess <em>Read Access</em>}</li>
 *   <li>{@link cenrep.IAccessable#getWriteAccess <em>Write Access</em>}</li>
 *   <li>{@link cenrep.IAccessable#getGAccess <em>GAccess</em>}</li>
 * </ul>
 * </p>
 *
 * @see cenrep.CenrepPackage#getIAccessable()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IAccessable extends EObject {
	/**
	 * Returns the value of the '<em><b>Access</b></em>' containment reference list.
	 * The list contents are of type {@link cenrep.Access}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Access</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Access</em>' containment reference list.
	 * @see cenrep.CenrepPackage#getIAccessable_Access()
	 * @model containment="true"
	 * @generated
	 */
	EList<Access> getAccess();

	/**
	 * Returns the value of the '<em><b>Read Access</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Read Access</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Read Access</em>' reference.
	 * @see #setReadAccess(Access)
	 * @see cenrep.CenrepPackage#getIAccessable_ReadAccess()
	 * @model resolveProxies="false" transient="true" volatile="true"
	 * @generated
	 */
	Access getReadAccess();

	/**
	 * Sets the value of the '{@link cenrep.IAccessable#getReadAccess <em>Read Access</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Read Access</em>' reference.
	 * @see #getReadAccess()
	 * @generated
	 */
	void setReadAccess(Access value);

	/**
	 * Returns the value of the '<em><b>Write Access</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Write Access</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Write Access</em>' reference.
	 * @see #setWriteAccess(Access)
	 * @see cenrep.CenrepPackage#getIAccessable_WriteAccess()
	 * @model resolveProxies="false" transient="true" volatile="true"
	 * @generated
	 */
	Access getWriteAccess();

	/**
	 * Sets the value of the '{@link cenrep.IAccessable#getWriteAccess <em>Write Access</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Write Access</em>' reference.
	 * @see #getWriteAccess()
	 * @generated
	 */
	void setWriteAccess(Access value);

	/**
	 * Returns the value of the '<em><b>GAccess</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>GAccess</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>GAccess</em>' attribute.
	 * @see cenrep.CenrepPackage#getIAccessable_GAccess()
	 * @model transient="true" changeable="false" volatile="true"
	 * @generated
	 */
	String getGAccess();

} // IAccessable
