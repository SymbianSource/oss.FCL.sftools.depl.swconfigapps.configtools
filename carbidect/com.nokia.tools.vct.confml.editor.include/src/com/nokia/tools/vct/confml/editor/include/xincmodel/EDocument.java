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
 * Description: This file is part of com.nokia.tools.vct.confml.editor.include component.
 */

package com.nokia.tools.vct.confml.editor.include.xincmodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EDocument</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.confml.editor.include.xincmodel.EDocument#getIncludes <em>Includes</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.include.xincmodel.EDocument#getVersion <em>Version</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.include.xincmodel.EDocument#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EXincModelPackage#getEDocument()
 * @model
 * @generated
 */
public interface EDocument extends EResourceContainer {
	/**
	 * Returns the value of the '<em><b>Includes</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.confml.editor.include.xincmodel.EInclude}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Includes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Includes</em>' containment reference list.
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EXincModelPackage#getEDocument_Includes()
	 * @model containment="true"
	 * @generated
	 */
	EList<EInclude> getIncludes();

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * The literals are from the enumeration {@link com.nokia.tools.vct.confml.editor.include.xincmodel.EConfMLVersion}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EConfMLVersion
	 * @see #setVersion(EConfMLVersion)
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EXincModelPackage#getEDocument_Version()
	 * @model required="true"
	 * @generated
	 */
	EConfMLVersion getVersion();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.EDocument#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EConfMLVersion
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(EConfMLVersion value);

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
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EXincModelPackage#getEDocument_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.EDocument#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // EDocument
