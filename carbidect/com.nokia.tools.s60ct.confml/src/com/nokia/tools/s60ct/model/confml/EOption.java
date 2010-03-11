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

import java.util.Map;
import org.eclipse.emf.ecore.EObject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EOption</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.EOption#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.EOption#getValue <em>Value</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.EOption#getMap <em>Map</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.EOption#getMapSourceSetting <em>Map Source Setting</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.EOption#getOptionValues <em>Option Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getEOption()
 * @model
 * @generated
 */
public interface EOption extends ESettingOption {
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
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getEOption_Name()
	 * @model default=""
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.EOption#getName <em>Name</em>}' attribute.
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
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getEOption_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.EOption#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

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
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getEOption_Map()
	 * @model default=""
	 * @generated
	 */
	String getMap();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.EOption#getMap <em>Map</em>}' attribute.
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
	 * @see #setMapSourceSetting(ESequenceSetting)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getEOption_MapSourceSetting()
	 * @model
	 * @generated
	 */
	ESequenceSetting getMapSourceSetting();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.EOption#getMapSourceSetting <em>Map Source Setting</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Map Source Setting</em>' reference.
	 * @see #getMapSourceSetting()
	 * @generated
	 */
	void setMapSourceSetting(ESequenceSetting value);

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
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getEOption_OptionValues()
	 * @model transient="true"
	 * @generated
	 */
	Map<String, EOptionMap> getOptionValues();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.EOption#getOptionValues <em>Option Values</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Option Values</em>' attribute.
	 * @see #getOptionValues()
	 * @generated
	 */
	void setOptionValues(Map<String, EOptionMap> value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String getMapValue(String key);

} // EOption
