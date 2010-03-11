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
 * A representation of the model object '<em><b>EStylesheet</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EStylesheet#getVersion <em>Version</em>}</li>
 *   <li>{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EStylesheet#getOutput <em>Output</em>}</li>
 *   <li>{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EStylesheet#getContent <em>Content</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.EGCFMLPackage#getEStylesheet()
 * @model
 * @generated
 */
public interface EStylesheet extends EObject {
	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.EGCFMLPackage#getEStylesheet_Version()
	 * @model
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EStylesheet#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Output</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output</em>' containment reference.
	 * @see #setOutput(EOutput)
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.EGCFMLPackage#getEStylesheet_Output()
	 * @model containment="true"
	 * @generated
	 */
	EOutput getOutput();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EStylesheet#getOutput <em>Output</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output</em>' containment reference.
	 * @see #getOutput()
	 * @generated
	 */
	void setOutput(EOutput value);

	/**
	 * Returns the value of the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content</em>' attribute.
	 * @see #setContent(String)
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.EGCFMLPackage#getEStylesheet_Content()
	 * @model
	 * @generated
	 */
	String getContent();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EStylesheet#getContent <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content</em>' attribute.
	 * @see #getContent()
	 * @generated
	 */
	void setContent(String value);

} // EStylesheet
