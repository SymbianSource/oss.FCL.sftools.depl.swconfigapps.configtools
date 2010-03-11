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
package configurationemf;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link configurationemf.Group#getName <em>Name</em>}</li>
 *   <li>{@link configurationemf.Group#getGSetting <em>GSetting</em>}</li>
 *   <li>{@link configurationemf.Group#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link configurationemf.Group#getIcon <em>Icon</em>}</li>
 * </ul>
 * </p>
 *
 * @see configurationemf.ConfigurationemfPackage#getGroup()
 * @model abstract="true"
 * @generated
 */
public interface Group extends AttributeAndDesc {
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
	 * @see configurationemf.ConfigurationemfPackage#getGroup_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link configurationemf.Group#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>GSetting</b></em>' containment reference list.
	 * The list contents are of type {@link configurationemf.GSetting}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>GSetting</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>GSetting</em>' containment reference list.
	 * @see configurationemf.ConfigurationemfPackage#getGroup_GSetting()
	 * @model containment="true"
	 * @generated
	 */
	EList<GSetting> getGSetting();

	/**
	 * Returns the value of the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Read Only</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Read Only</em>' attribute.
	 * @see configurationemf.ConfigurationemfPackage#getGroup_ReadOnly()
	 * @model transient="true" changeable="false" volatile="true"
	 * @generated
	 */
	boolean isReadOnly();

	/**
	 * Returns the value of the '<em><b>Icon</b></em>' containment reference list.
	 * The list contents are of type {@link configurationemf.Icon}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon</em>' containment reference list.
	 * @see configurationemf.ConfigurationemfPackage#getGroup_Icon()
	 * @model containment="true"
	 * @generated
	 */
	EList<Icon> getIcon();

} // Group