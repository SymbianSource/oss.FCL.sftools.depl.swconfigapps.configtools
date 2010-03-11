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
package com.nokia.tools.s60ct.model.confml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EDescription Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.EDescriptionContainer#getDescriptionText <em>Description Text</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.EDescriptionContainer#getDescriptionUri <em>Description Uri</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.EDescriptionContainer#getDescriptionUriText <em>Description Uri Text</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getEDescriptionContainer()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface EDescriptionContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Description Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description Text</em>' attribute.
	 * @see #setDescriptionText(String)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getEDescriptionContainer_DescriptionText()
	 * @model
	 * @generated
	 */
	String getDescriptionText();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.EDescriptionContainer#getDescriptionText <em>Description Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description Text</em>' attribute.
	 * @see #getDescriptionText()
	 * @generated
	 */
	void setDescriptionText(String value);

	/**
	 * Returns the value of the '<em><b>Description Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description Uri</em>' attribute.
	 * @see #setDescriptionUri(String)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getEDescriptionContainer_DescriptionUri()
	 * @model
	 * @generated
	 */
	String getDescriptionUri();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.EDescriptionContainer#getDescriptionUri <em>Description Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description Uri</em>' attribute.
	 * @see #getDescriptionUri()
	 * @generated
	 */
	void setDescriptionUri(String value);

	/**
	 * Returns the value of the '<em><b>Description Uri Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description Uri Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description Uri Text</em>' attribute.
	 * @see #setDescriptionUriText(String)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getEDescriptionContainer_DescriptionUriText()
	 * @model
	 * @generated
	 */
	String getDescriptionUriText();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.EDescriptionContainer#getDescriptionUriText <em>Description Uri Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description Uri Text</em>' attribute.
	 * @see #getDescriptionUriText()
	 * @generated
	 */
	void setDescriptionUriText(String value);

} // EDescriptionContainer
