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

import java.net.URI;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EResource Locator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.EResourceLocator#getResourceUri <em>Resource Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getEResourceLocator()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface EResourceLocator extends EObject {
	/**
	 * Returns the value of the '<em><b>Resource Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Uri</em>' attribute.
	 * @see #setResourceUri(URI)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getEResourceLocator_ResourceUri()
	 * @model dataType="com.nokia.tools.s60ct.model.confml.EJavaURI"
	 * @generated
	 */
	URI getResourceUri();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.EResourceLocator#getResourceUri <em>Resource Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Uri</em>' attribute.
	 * @see #getResourceUri()
	 * @generated
	 */
	void setResourceUri(URI value);

} // EResourceLocator
