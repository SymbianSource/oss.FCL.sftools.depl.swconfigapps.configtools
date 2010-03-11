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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EFile</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EFile#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EFile#getTarget <em>Target</em>}</li>
 *   <li>{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EFile#getSetting <em>Setting</em>}</li>
 *   <li>{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EFile#getStylesheet <em>Stylesheet</em>}</li>
 *   <li>{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EFile#getLocation <em>Location</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.EGCFMLPackage#getEFile()
 * @model
 * @generated
 */
public interface EFile extends EObject {
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
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.EGCFMLPackage#getEFile_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EFile#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' attribute.
	 * @see #setTarget(String)
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.EGCFMLPackage#getEFile_Target()
	 * @model
	 * @generated
	 */
	String getTarget();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EFile#getTarget <em>Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' attribute.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(String value);

	/**
	 * Returns the value of the '<em><b>Setting</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.gcfml.gcfmlmodel.ESetting}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Setting</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Setting</em>' containment reference list.
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.EGCFMLPackage#getEFile_Setting()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ESetting> getSetting();

	/**
	 * Returns the value of the '<em><b>Stylesheet</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stylesheet</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stylesheet</em>' containment reference.
	 * @see #setStylesheet(EStylesheet)
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.EGCFMLPackage#getEFile_Stylesheet()
	 * @model containment="true"
	 * @generated
	 */
	EStylesheet getStylesheet();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EFile#getStylesheet <em>Stylesheet</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stylesheet</em>' containment reference.
	 * @see #getStylesheet()
	 * @generated
	 */
	void setStylesheet(EStylesheet value);

	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(String)
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.EGCFMLPackage#getEFile_Location()
	 * @model
	 * @generated
	 */
	String getLocation();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EFile#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(String value);

} // EFile
