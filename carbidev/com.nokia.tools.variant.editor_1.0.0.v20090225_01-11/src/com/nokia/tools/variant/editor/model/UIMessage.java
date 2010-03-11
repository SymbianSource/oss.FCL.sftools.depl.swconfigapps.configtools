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
 * Description: This file is part of com.nokia.tools.variant.editor component.
 */

package com.nokia.tools.variant.editor.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UI Message</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.editor.model.UIMessage#getType <em>Type</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.model.UIMessage#getText <em>Text</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.variant.editor.model.UIModelPackage#getUIMessage()
 * @model
 * @generated
 */
public interface UIMessage extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link com.nokia.tools.variant.editor.model.UIMessageType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see com.nokia.tools.variant.editor.model.UIMessageType
	 * @see #setType(UIMessageType)
	 * @see com.nokia.tools.variant.editor.model.UIModelPackage#getUIMessage_Type()
	 * @model
	 * @generated
	 */
	UIMessageType getType();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.editor.model.UIMessage#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see com.nokia.tools.variant.editor.model.UIMessageType
	 * @see #getType()
	 * @generated
	 */
	void setType(UIMessageType value);

	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see com.nokia.tools.variant.editor.model.UIModelPackage#getUIMessage_Text()
	 * @model
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.editor.model.UIMessage#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

} // UIMessage
