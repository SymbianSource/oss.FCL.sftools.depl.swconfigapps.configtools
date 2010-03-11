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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Access</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cenrep.Access#getType <em>Type</em>}</li>
 *   <li>{@link cenrep.Access#getCapabilities <em>Capabilities</em>}</li>
 *   <li>{@link cenrep.Access#getSid <em>Sid</em>}</li>
 *   <li>{@link cenrep.Access#getStrFormat <em>Str Format</em>}</li>
 * </ul>
 * </p>
 *
 * @see cenrep.CenrepPackage#getAccess()
 * @model
 * @generated
 */
public interface Access extends AttributeAndDescription {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link cenrep.ACCESS_TYPE}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see cenrep.ACCESS_TYPE
	 * @see #setType(ACCESS_TYPE)
	 * @see cenrep.CenrepPackage#getAccess_Type()
	 * @model
	 * @generated
	 */
	ACCESS_TYPE getType();

	/**
	 * Sets the value of the '{@link cenrep.Access#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see cenrep.ACCESS_TYPE
	 * @see #getType()
	 * @generated
	 */
	void setType(ACCESS_TYPE value);

	/**
	 * Returns the value of the '<em><b>Capabilities</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capabilities</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capabilities</em>' attribute.
	 * @see #setCapabilities(String)
	 * @see cenrep.CenrepPackage#getAccess_Capabilities()
	 * @model
	 * @generated
	 */
	String getCapabilities();

	/**
	 * Sets the value of the '{@link cenrep.Access#getCapabilities <em>Capabilities</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capabilities</em>' attribute.
	 * @see #getCapabilities()
	 * @generated
	 */
	void setCapabilities(String value);

	/**
	 * Returns the value of the '<em><b>Sid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sid</em>' attribute.
	 * @see #setSid(String)
	 * @see cenrep.CenrepPackage#getAccess_Sid()
	 * @model
	 * @generated
	 */
	String getSid();

	/**
	 * Sets the value of the '{@link cenrep.Access#getSid <em>Sid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sid</em>' attribute.
	 * @see #getSid()
	 * @generated
	 */
	void setSid(String value);

	/**
	 * Returns the value of the '<em><b>Str Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Str Format</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Str Format</em>' attribute.
	 * @see cenrep.CenrepPackage#getAccess_StrFormat()
	 * @model transient="true" changeable="false" volatile="true"
	 * @generated
	 */
	String getStrFormat();

} // Access