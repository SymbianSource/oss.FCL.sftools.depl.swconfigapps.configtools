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
 * Description: This file is part of com.nokia.tools.vct.confml.editor.view component.
 */

package com.nokia.tools.vct.confml.editor.view.vemodel;

import org.eclipse.emf.common.util.EMap;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ESetting</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESetting#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESetting#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESetting#getSubSettings <em>Sub Settings</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage#getESetting()
 * @model
 * @generated
 */
public interface ESetting extends EDescriptionContainer, EResourceLocator, ERefTarget {

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
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage#getESetting_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESetting#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Read Only</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Read Only</em>' attribute.
	 * @see #setReadOnly(boolean)
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage#getESetting_ReadOnly()
	 * @model
	 * @generated
	 */
	boolean isReadOnly();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESetting#isReadOnly <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Read Only</em>' attribute.
	 * @see #isReadOnly()
	 * @generated
	 */
	void setReadOnly(boolean value);

	/**
	 * Returns the value of the '<em><b>Sub Settings</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link com.nokia.tools.vct.confml.editor.view.vemodel.ESetting},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Settings</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Settings</em>' map.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage#getESetting_SubSettings()
	 * @model mapType="com.nokia.tools.vct.confml.editor.view.vemodel.ESettingEntry<org.eclipse.emf.ecore.EString, com.nokia.tools.vct.confml.editor.view.vemodel.ESetting>"
	 * @generated
	 */
	EMap<String, ESetting> getSubSettings();
} // ESetting
