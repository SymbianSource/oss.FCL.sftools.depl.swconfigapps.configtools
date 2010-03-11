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

import org.eclipse.emf.common.util.URI;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ESequence Value Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESequenceValueItem#isEditable <em>Editable</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESequenceValueItem#getFrameLocationUri <em>Frame Location Uri</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESequenceValueItem#isRemoved <em>Removed</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESequenceValueItem()
 * @model
 * @generated
 */
public interface ESequenceValueItem extends ESettingValueContainer {

	/**
	 * Returns the value of the '<em><b>Editable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Editable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Editable</em>' attribute.
	 * @see #setEditable(boolean)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESequenceValueItem_Editable()
	 * @model
	 * @generated
	 */
	boolean isEditable();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESequenceValueItem#isEditable <em>Editable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Editable</em>' attribute.
	 * @see #isEditable()
	 * @generated
	 */
	void setEditable(boolean value);

	/**
	 * Returns the value of the '<em><b>Frame Location Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Frame Location Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Frame Location Uri</em>' attribute.
	 * @see #setFrameLocationUri(URI)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESequenceValueItem_FrameLocationUri()
	 * @model dataType="com.nokia.tools.s60ct.model.confml.Ecore_URI"
	 * @generated
	 */
	URI getFrameLocationUri();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESequenceValueItem#getFrameLocationUri <em>Frame Location Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Frame Location Uri</em>' attribute.
	 * @see #getFrameLocationUri()
	 * @generated
	 */
	void setFrameLocationUri(URI value);

	/**
	 * Returns the value of the '<em><b>Removed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Removed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Removed</em>' attribute.
	 * @see #setRemoved(boolean)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESequenceValueItem_Removed()
	 * @model
	 * @generated
	 */
	boolean isRemoved();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESequenceValueItem#isRemoved <em>Removed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Removed</em>' attribute.
	 * @see #isRemoved()
	 * @generated
	 */
	void setRemoved(boolean value);
} // ESequenceValueItem
