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
 * Description: This file is part of com.nokia.tools.variant.content.confml.model component.
 */

package com.nokia.tools.s60ct.content.confml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence Setting</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.SequenceSetting#getDefaultStructure <em>Default Structure</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.SequenceSetting#getTemplate <em>Template</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.SequenceSetting#getSequenceItem <em>Sequence Item</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.SequenceSetting#getMinOccurs <em>Min Occurs</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.SequenceSetting#getMaxOccurs <em>Max Occurs</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.SequenceSetting#getLastSavedStructure <em>Last Saved Structure</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.SequenceSetting#getMapKey <em>Map Key</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.SequenceSetting#getMapValue <em>Map Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getSequenceSetting()
 * @model
 * @generated
 */
public interface SequenceSetting extends Setting {
	/**
	 * Returns the value of the '<em><b>Default Structure</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.s60ct.content.confml.SequenceItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Structure</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Structure</em>' containment reference list.
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getSequenceSetting_DefaultStructure()
	 * @model containment="true"
	 * @generated
	 */
	EList<SequenceItem> getDefaultStructure();

	/**
	 * Returns the value of the '<em><b>Template</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template</em>' containment reference.
	 * @see #setTemplate(SequenceItem)
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getSequenceSetting_Template()
	 * @model containment="true"
	 * @generated
	 */
	SequenceItem getTemplate();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.SequenceSetting#getTemplate <em>Template</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template</em>' containment reference.
	 * @see #getTemplate()
	 * @generated
	 */
	void setTemplate(SequenceItem value);

	/**
	 * Returns the value of the '<em><b>Sequence Item</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.s60ct.content.confml.SequenceItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence Item</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence Item</em>' containment reference list.
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getSequenceSetting_SequenceItem()
	 * @model containment="true"
	 * @generated
	 */
	EList<SequenceItem> getSequenceItem();

	/**
	 * Returns the value of the '<em><b>Min Occurs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Occurs</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Occurs</em>' attribute.
	 * @see #setMinOccurs(int)
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getSequenceSetting_MinOccurs()
	 * @model
	 * @generated
	 */
	int getMinOccurs();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.SequenceSetting#getMinOccurs <em>Min Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Occurs</em>' attribute.
	 * @see #getMinOccurs()
	 * @generated
	 */
	void setMinOccurs(int value);

	/**
	 * Returns the value of the '<em><b>Max Occurs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Occurs</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Occurs</em>' attribute.
	 * @see #setMaxOccurs(int)
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getSequenceSetting_MaxOccurs()
	 * @model
	 * @generated
	 */
	int getMaxOccurs();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.SequenceSetting#getMaxOccurs <em>Max Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Occurs</em>' attribute.
	 * @see #getMaxOccurs()
	 * @generated
	 */
	void setMaxOccurs(int value);

	/**
	 * Returns the value of the '<em><b>Last Saved Structure</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.s60ct.content.confml.SequenceItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Saved Structure</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Saved Structure</em>' containment reference list.
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getSequenceSetting_LastSavedStructure()
	 * @model containment="true"
	 * @generated
	 */
	EList<SequenceItem> getLastSavedStructure();

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
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getSequenceSetting_MapKey()
	 * @model
	 * @generated
	 */
	String getMapKey();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.SequenceSetting#getMapKey <em>Map Key</em>}' attribute.
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
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getSequenceSetting_MapValue()
	 * @model
	 * @generated
	 */
	String getMapValue();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.SequenceSetting#getMapValue <em>Map Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Map Value</em>' attribute.
	 * @see #getMapValue()
	 * @generated
	 */
	void setMapValue(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean computeDefault();

} // SequenceSetting
