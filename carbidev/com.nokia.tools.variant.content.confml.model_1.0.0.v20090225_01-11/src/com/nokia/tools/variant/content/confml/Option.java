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

package com.nokia.tools.variant.content.confml;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Option</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.content.confml.Option#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.Option#getValue <em>Value</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.Option#getRelevant <em>Relevant</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.Option#getMap <em>Map</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.Option#getMapSourceSetting <em>Map Source Setting</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.Option#getOptionValues <em>Option Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.variant.content.confml.ConfmlPackage#getOption()
 * @model
 * @generated
 */
public interface Option extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.nokia.tools.variant.content.confml.ConfmlPackage#getOption_Name()
	 * @model default=""
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.content.confml.Option#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see com.nokia.tools.variant.content.confml.ConfmlPackage#getOption_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.content.confml.Option#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relevant</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relevant</em>' attribute.
	 * @see #setRelevant(String)
	 * @see com.nokia.tools.variant.content.confml.ConfmlPackage#getOption_Relevant()
	 * @model
	 * @generated
	 */
	String getRelevant();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.content.confml.Option#getRelevant <em>Relevant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relevant</em>' attribute.
	 * @see #getRelevant()
	 * @generated
	 */
	void setRelevant(String value);

	/**
	 * Returns the value of the '<em><b>Map</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Map</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Map</em>' attribute.
	 * @see #setMap(String)
	 * @see com.nokia.tools.variant.content.confml.ConfmlPackage#getOption_Map()
	 * @model default=""
	 * @generated
	 */
	String getMap();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.content.confml.Option#getMap <em>Map</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Map</em>' attribute.
	 * @see #getMap()
	 * @generated
	 */
	void setMap(String value);

	/**
	 * Returns the value of the '<em><b>Map Source Setting</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Map Source Setting</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Map Source Setting</em>' reference.
	 * @see #setMapSourceSetting(SequenceSetting)
	 * @see com.nokia.tools.variant.content.confml.ConfmlPackage#getOption_MapSourceSetting()
	 * @model
	 * @generated
	 */
	SequenceSetting getMapSourceSetting();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.content.confml.Option#getMapSourceSetting <em>Map Source Setting</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Map Source Setting</em>' reference.
	 * @see #getMapSourceSetting()
	 * @generated
	 */
	void setMapSourceSetting(SequenceSetting value);

	/**
	 * Returns the value of the '<em><b>Option Values</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Option Values</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Option Values</em>' attribute.
	 * @see #setOptionValues(Map)
	 * @see com.nokia.tools.variant.content.confml.ConfmlPackage#getOption_OptionValues()
	 * @model transient="true"
	 * @generated
	 */
	Map<String, OptionMapEntry> getOptionValues();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.content.confml.Option#getOptionValues <em>Option Values</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Option Values</em>' attribute.
	 * @see #getOptionValues()
	 * @generated
	 */
	void setOptionValues(Map<String, OptionMapEntry> value);

} // Option
