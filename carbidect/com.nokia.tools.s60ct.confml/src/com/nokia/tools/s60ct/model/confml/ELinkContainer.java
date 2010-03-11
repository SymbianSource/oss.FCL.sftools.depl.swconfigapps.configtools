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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ELink Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ELinkContainer#getLinkUri <em>Link Uri</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ELinkContainer#getLinkUriTitle <em>Link Uri Title</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getELinkContainer()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ELinkContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Link Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link Uri</em>' attribute.
	 * @see #setLinkUri(String)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getELinkContainer_LinkUri()
	 * @model
	 * @generated
	 */
	String getLinkUri();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ELinkContainer#getLinkUri <em>Link Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link Uri</em>' attribute.
	 * @see #getLinkUri()
	 * @generated
	 */
	void setLinkUri(String value);

	/**
	 * Returns the value of the '<em><b>Link Uri Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link Uri Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link Uri Title</em>' attribute.
	 * @see #setLinkUriTitle(String)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getELinkContainer_LinkUriTitle()
	 * @model
	 * @generated
	 */
	String getLinkUriTitle();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ELinkContainer#getLinkUriTitle <em>Link Uri Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link Uri Title</em>' attribute.
	 * @see #getLinkUriTitle()
	 * @generated
	 */
	void setLinkUriTitle(String value);

} // ELinkContainer
