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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ESequence Setting</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESequenceSetting#getMinOccurs <em>Min Occurs</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESequenceSetting#getMaxOccurs <em>Max Occurs</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESequenceSetting#getItems <em>Items</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESequenceSetting#getTemplate <em>Template</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESequenceSetting#getMapKey <em>Map Key</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESequenceSetting#getMapValue <em>Map Value</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESequenceSetting#getVisibleSubSettings <em>Visible Sub Settings</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESequenceSetting()
 * @model
 * @generated
 */
public interface ESequenceSetting extends ESetting, ESettingContainer {
	/**
	 * Returns the value of the '<em><b>Min Occurs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Occurs</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Occurs</em>' attribute.
	 * @see #setMinOccurs(Integer)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESequenceSetting_MinOccurs()
	 * @model
	 * @generated
	 */
	Integer getMinOccurs();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESequenceSetting#getMinOccurs <em>Min Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Occurs</em>' attribute.
	 * @see #getMinOccurs()
	 * @generated
	 */
	void setMinOccurs(Integer value);

	/**
	 * Returns the value of the '<em><b>Max Occurs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Occurs</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Occurs</em>' attribute.
	 * @see #setMaxOccurs(Integer)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESequenceSetting_MaxOccurs()
	 * @model
	 * @generated
	 */
	Integer getMaxOccurs();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESequenceSetting#getMaxOccurs <em>Max Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Occurs</em>' attribute.
	 * @see #getMaxOccurs()
	 * @generated
	 */
	void setMaxOccurs(Integer value);

	/**
	 * Returns the value of the '<em><b>Items</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.s60ct.model.confml.EItemSetting}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Items</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Items</em>' containment reference list.
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESequenceSetting_Items()
	 * @model containment="true"
	 * @generated
	 */
	EList<EItemSetting> getItems();

	/**
	 * Returns the value of the '<em><b>Template</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template</em>' containment reference.
	 * @see #setTemplate(EItemSetting)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESequenceSetting_Template()
	 * @model containment="true"
	 * @generated
	 */
	EItemSetting getTemplate();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESequenceSetting#getTemplate <em>Template</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template</em>' containment reference.
	 * @see #getTemplate()
	 * @generated
	 */
	void setTemplate(EItemSetting value);

	/**
	 * Returns the value of the '<em><b>Map Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Map Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Map Key</em>' attribute.
	 * @see #setMapKey(String)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESequenceSetting_MapKey()
	 * @model
	 * @generated
	 */
	String getMapKey();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESequenceSetting#getMapKey <em>Map Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Map Key</em>' attribute.
	 * @see #getMapKey()
	 * @generated
	 */
	void setMapKey(String value);

	/**
	 * Returns the value of the '<em><b>Map Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Map Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Map Value</em>' attribute.
	 * @see #setMapValue(String)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESequenceSetting_MapValue()
	 * @model
	 * @generated
	 */
	String getMapValue();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESequenceSetting#getMapValue <em>Map Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Map Value</em>' attribute.
	 * @see #getMapValue()
	 * @generated
	 */
	void setMapValue(String value);

	/**
	 * Returns the value of the '<em><b>Visible Sub Settings</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visible Sub Settings</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visible Sub Settings</em>' attribute list.
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESequenceSetting_VisibleSubSettings()
	 * @model
	 * @generated
	 */
	EList<String> getVisibleSubSettings();

} // ESequenceSetting
