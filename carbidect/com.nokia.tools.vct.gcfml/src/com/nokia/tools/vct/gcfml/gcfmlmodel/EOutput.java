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
 * Description: This file is part of com.nokia.tools.vct.gcfml component.
 */

package com.nokia.tools.vct.gcfml.gcfmlmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EOutput</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EOutput#getMethod <em>Method</em>}</li>
 *   <li>{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EOutput#getEncoding <em>Encoding</em>}</li>
 *   <li>{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EOutput#getIndent <em>Indent</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.EGCFMLPackage#getEOutput()
 * @model
 * @generated
 */
public interface EOutput extends EObject {

	/**
	 * Returns the value of the '<em><b>Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method</em>' attribute.
	 * @see #setMethod(String)
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.EGCFMLPackage#getEOutput_Method()
	 * @model
	 * @generated
	 */
	String getMethod();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EOutput#getMethod <em>Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method</em>' attribute.
	 * @see #getMethod()
	 * @generated
	 */
	void setMethod(String value);

	/**
	 * Returns the value of the '<em><b>Encoding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Encoding</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Encoding</em>' attribute.
	 * @see #setEncoding(String)
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.EGCFMLPackage#getEOutput_Encoding()
	 * @model
	 * @generated
	 */
	String getEncoding();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EOutput#getEncoding <em>Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Encoding</em>' attribute.
	 * @see #getEncoding()
	 * @generated
	 */
	void setEncoding(String value);

	/**
	 * Returns the value of the '<em><b>Indent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Indent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Indent</em>' attribute.
	 * @see #setIndent(String)
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.EGCFMLPackage#getEOutput_Indent()
	 * @model
	 * @generated
	 */
	String getIndent();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EOutput#getIndent <em>Indent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Indent</em>' attribute.
	 * @see #getIndent()
	 * @generated
	 */
	void setIndent(String value);
} // EOutput
