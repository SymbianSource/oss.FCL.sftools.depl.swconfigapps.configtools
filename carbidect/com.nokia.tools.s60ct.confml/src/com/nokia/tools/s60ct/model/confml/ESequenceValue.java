/*
* Copyright (c) 2007 Nokia Corporation and/or its subsidiary(-ies). 
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
package com.nokia.tools.s60ct.model.confml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ESequence Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESequenceValue#getTemplate <em>Template</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESequenceValue#getItems <em>Items</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESequenceValue#getExtensionPolicy <em>Extension Policy</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESequenceValue()
 * @model
 * @generated
 */
public interface ESequenceValue extends ESettingValue {
	/**
	 * Returns the value of the '<em><b>Template</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template</em>' containment reference.
	 * @see #setTemplate(ESequenceValueItem)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESequenceValue_Template()
	 * @model containment="true"
	 * @generated
	 */
	ESequenceValueItem getTemplate();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESequenceValue#getTemplate <em>Template</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template</em>' containment reference.
	 * @see #getTemplate()
	 * @generated
	 */
	void setTemplate(ESequenceValueItem value);

	/**
	 * Returns the value of the '<em><b>Items</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.s60ct.model.confml.ESequenceValueItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Items</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Items</em>' containment reference list.
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESequenceValue_Items()
	 * @model containment="true"
	 * @generated
	 */
	EList<ESequenceValueItem> getItems();

	/**
	 * Returns the value of the '<em><b>Extension Policy</b></em>' attribute.
	 * The literals are from the enumeration {@link com.nokia.tools.s60ct.model.confml.EExtensionPolicy}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension Policy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension Policy</em>' attribute.
	 * @see com.nokia.tools.s60ct.model.confml.EExtensionPolicy
	 * @see #setExtensionPolicy(EExtensionPolicy)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESequenceValue_ExtensionPolicy()
	 * @model
	 * @generated
	 */
	EExtensionPolicy getExtensionPolicy();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESequenceValue#getExtensionPolicy <em>Extension Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension Policy</em>' attribute.
	 * @see com.nokia.tools.s60ct.model.confml.EExtensionPolicy
	 * @see #getExtensionPolicy()
	 * @generated
	 */
	void setExtensionPolicy(EExtensionPolicy value);

} // ESequenceValue
