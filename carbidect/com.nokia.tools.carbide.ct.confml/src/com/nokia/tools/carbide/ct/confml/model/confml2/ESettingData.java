/**
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
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
 * $Id$
 */
package com.nokia.tools.carbide.ct.confml.model.confml2;

import com.nokia.tools.carbide.ct.confml.model.confml1.ERefNamedElement;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ESetting Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingData#getTemplate <em>Template</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingData#getExtensionPolicy <em>Extension Policy</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingData#getValue <em>Value</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingData#getText <em>Text</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingData#getMap <em>Map</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getESettingData()
 * @model extendedMetaData="name='settingDataType' kind='mixed'"
 * @generated
 */
public interface ESettingData extends ERefNamedElement, ESettingDataContainer {
	/**
	 * Returns the value of the '<em><b>Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template</em>' attribute.
	 * @see #setTemplate(String)
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getESettingData_Template()
	 * @model extendedMetaData="name='template' kind='attribute'"
	 * @generated
	 */
	String getTemplate();

	/**
	 * Sets the value of the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingData#getTemplate <em>Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template</em>' attribute.
	 * @see #getTemplate()
	 * @generated
	 */
	void setTemplate(String value);

	/**
	 * Returns the value of the '<em><b>Extension Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension Policy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension Policy</em>' attribute.
	 * @see #setExtensionPolicy(String)
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getESettingData_ExtensionPolicy()
	 * @model extendedMetaData="name='extensionPolicy' kind='attribute'"
	 * @generated
	 */
	String getExtensionPolicy();

	/**
	 * Sets the value of the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingData#getExtensionPolicy <em>Extension Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension Policy</em>' attribute.
	 * @see #getExtensionPolicy()
	 * @generated
	 */
	void setExtensionPolicy(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute list.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getESettingData_Value()
	 * @model dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="name=':mixed' kind='elementWildcard'"
	 * @generated
	 */
	FeatureMap getValue();

	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getESettingData_Text()
	 * @model transient="true" volatile="true" derived="true"
	 *        extendedMetaData="name='ESettingData' kind='simple' group='#mixed:0'"
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingData#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Map</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Map</em>' attribute.
	 * @see #setMap(String)
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getESettingData_Map()
	 * @model extendedMetaData="name='map' kind='attribute'"
	 * @generated
	 */
	String getMap();

	/**
	 * Sets the value of the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingData#getMap <em>Map</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Map</em>' attribute.
	 * @see #getMap()
	 * @generated
	 */
	void setMap(String value);

} // ESettingData
