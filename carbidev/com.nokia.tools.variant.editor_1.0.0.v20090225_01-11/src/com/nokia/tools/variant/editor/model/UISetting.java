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


import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.nokia.tools.variant.content.confml.Setting;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UI Setting</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.editor.model.UISetting#getSetting <em>Setting</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.model.UISetting#isSelected <em>Selected</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.model.UISetting#isFocused <em>Focused</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.model.UISetting#getUiMessages <em>Ui Messages</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.model.UISetting#getChildren <em>Children</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.model.UISetting#getData <em>Data</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.variant.editor.model.UIModelPackage#getUISetting()
 * @model
 * @generated
 */
public interface UISetting extends EObject {
	/**
	 * Returns the value of the '<em><b>Setting</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Setting</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Setting</em>' reference.
	 * @see #setSetting(Setting)
	 * @see com.nokia.tools.variant.editor.model.UIModelPackage#getUISetting_Setting()
	 * @model
	 * @generated
	 */
	Setting getSetting();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.editor.model.UISetting#getSetting <em>Setting</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Setting</em>' reference.
	 * @see #getSetting()
	 * @generated
	 */
	void setSetting(Setting value);

	/**
	 * Returns the value of the '<em><b>Selected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selected</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selected</em>' attribute.
	 * @see #setSelected(boolean)
	 * @see com.nokia.tools.variant.editor.model.UIModelPackage#getUISetting_Selected()
	 * @model
	 * @generated
	 */
	boolean isSelected();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.editor.model.UISetting#isSelected <em>Selected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selected</em>' attribute.
	 * @see #isSelected()
	 * @generated
	 */
	void setSelected(boolean value);

	/**
	 * Returns the value of the '<em><b>Focused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Focused</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Focused</em>' attribute.
	 * @see #setFocused(boolean)
	 * @see com.nokia.tools.variant.editor.model.UIModelPackage#getUISetting_Focused()
	 * @model
	 * @generated
	 */
	boolean isFocused();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.editor.model.UISetting#isFocused <em>Focused</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Focused</em>' attribute.
	 * @see #isFocused()
	 * @generated
	 */
	void setFocused(boolean value);

	/**
	 * Returns the value of the '<em><b>Ui Messages</b></em>' reference list.
	 * The list contents are of type {@link com.nokia.tools.variant.editor.model.UIMessage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ui Messages</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ui Messages</em>' reference list.
	 * @see com.nokia.tools.variant.editor.model.UIModelPackage#getUISetting_UiMessages()
	 * @model
	 * @generated
	 */
	EList<UIMessage> getUiMessages();

	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.variant.editor.model.UISetting}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see com.nokia.tools.variant.editor.model.UIModelPackage#getUISetting_Children()
	 * @model containment="true"
	 * @generated
	 */
	EList<UISetting> getChildren();

	/**
	 * Returns the value of the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' attribute.
	 * @see #setData(Object)
	 * @see com.nokia.tools.variant.editor.model.UIModelPackage#getUISetting_Data()
	 * @model
	 * @generated
	 */
	Object getData();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.editor.model.UISetting#getData <em>Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data</em>' attribute.
	 * @see #getData()
	 * @generated
	 */
	void setData(Object value);

} // UISetting
