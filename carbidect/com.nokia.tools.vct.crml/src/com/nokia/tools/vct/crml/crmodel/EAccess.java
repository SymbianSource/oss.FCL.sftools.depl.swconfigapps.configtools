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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EAccess</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.EAccess#getType <em>Type</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.EAccess#getCapabilities <em>Capabilities</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.EAccess#getSid <em>Sid</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getEAccess()
 * @model extendedMetaData="name='accessType' kind='elementOnly'"
 * @generated
 */
public interface EAccess extends EAttributeAndDescription {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link com.nokia.tools.vct.crml.crmodel.EAccessType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see com.nokia.tools.vct.crml.crmodel.EAccessType
	 * @see #setType(EAccessType)
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getEAccess_Type()
	 * @model
	 * @generated
	 */
	EAccessType getType();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.crml.crmodel.EAccess#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see com.nokia.tools.vct.crml.crmodel.EAccessType
	 * @see #getType()
	 * @generated
	 */
	void setType(EAccessType value);

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
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getEAccess_Capabilities()
	 * @model
	 * @generated
	 */
	String getCapabilities();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.crml.crmodel.EAccess#getCapabilities <em>Capabilities</em>}' attribute.
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
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getEAccess_Sid()
	 * @model
	 * @generated
	 */
	String getSid();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.crml.crmodel.EAccess#getSid <em>Sid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sid</em>' attribute.
	 * @see #getSid()
	 * @generated
	 */
	void setSid(String value);

} // EAccess
