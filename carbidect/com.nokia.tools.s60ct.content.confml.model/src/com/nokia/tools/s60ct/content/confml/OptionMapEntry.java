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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Option Map Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.OptionMapEntry#getValue2Save <em>Value2 Save</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.OptionMapEntry#getMapValue <em>Map Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getOptionMapEntry()
 * @model
 * @generated
 */
public interface OptionMapEntry extends EObject {
	/**
	 * Returns the value of the '<em><b>Value2 Save</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value2 Save</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value2 Save</em>' attribute.
	 * @see #setValue2Save(String)
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getOptionMapEntry_Value2Save()
	 * @model
	 * @generated
	 */
	String getValue2Save();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.OptionMapEntry#getValue2Save <em>Value2 Save</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value2 Save</em>' attribute.
	 * @see #getValue2Save()
	 * @generated
	 */
	void setValue2Save(String value);

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
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getOptionMapEntry_MapValue()
	 * @model
	 * @generated
	 */
	String getMapValue();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.OptionMapEntry#getMapValue <em>Map Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Map Value</em>' attribute.
	 * @see #getMapValue()
	 * @generated
	 */
	void setMapValue(String value);

} // OptionMapEntry
