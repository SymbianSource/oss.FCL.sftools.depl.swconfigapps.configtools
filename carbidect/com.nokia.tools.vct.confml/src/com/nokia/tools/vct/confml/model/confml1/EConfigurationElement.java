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
 * Description: This file is part of com.nokia.tools.vct.confml component.
 */

package com.nokia.tools.vct.confml.model.confml1;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.nokia.tools.vct.confml.model.confml1.include.EInclude;

/**
 * <!-- begin-user-doc -->
 * <p>
 * Top-level XML element object for ConfML v1 content model.
 * </p>
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link EConfigurationElement#getConfigurations <em>Nested configuration
 * containers</em>}</li>
 * <li>
 * {@link EConfigurationElement#getFeatures <em>Feature Types</em>}</li>
 * <li>
 * {@link EConfigurationElement#getViews <em>Views</em>}</li>
 * <li>
 * {@link EConfigurationElement#getData <em>Data Section</em>}</li>
 * <li>
 * {@link EConfigurationElement#getRfs <em>Rfs Section</em>}</li>
 * <li>
 * {@link EConfigurationElement#getName <em>Configuration Name</em>}</li>
 * <li>
 * {@link EConfigurationElement#getVersion <em>Configuration Version</em>}</li>
 * <li>
 * {@link EConfigurationElement#getIncludes <em>Includes</em>}</li>
 * </ul>
 * </p>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EConfigurationElement#getConfigurations <em>Configurations</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EConfigurationElement#getFeatures <em>Features</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EConfigurationElement#getViews <em>Views</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EConfigurationElement#getData <em>Data</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EConfigurationElement#getRfs <em>Rfs</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EConfigurationElement#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EConfigurationElement#getVersion <em>Version</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EConfigurationElement#getIncludes <em>Includes</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.confml.model.confml1.EConfML1Package#getEConfigurationElement()
 * @model extendedMetaData="name='configurationType' kind='elementOnly'"
 * @generated
 */
public interface EConfigurationElement extends ECommonAttrs, EObject,
		ELinkContainer, EIconContainer, EDescriptionContainer, EMetaContainer {
	/**
	 * Returns the value of the '<em><b>Configurations</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.confml.model.confml1.EConfigurationElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Get contained configurations objects. Usually this list is empty.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configurations</em>' containment reference list.
	 * @see com.nokia.tools.vct.confml.model.confml1.EConfML1Package#getEConfigurationElement_Configurations()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='configuration' namespace='##targetNamespace' group='#contents:0'"
	 * @generated
	 */
	EList<EConfigurationElement> getConfigurations();

	/**
	 * Returns the value of the '<em><b>Features</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.confml.model.confml1.EFeatureElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Get contained feature type definitions for this configuration
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' containment reference list.
	 * @see com.nokia.tools.vct.confml.model.confml1.EConfML1Package#getEConfigurationElement_Features()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='feature' namespace='##targetNamespace' group='#contents:0'"
	 * @generated
	 */
	EList<EFeatureElement> getFeatures();

	/**
	 * Returns the value of the '<em><b>Views</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.confml.model.confml1.EViewElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Views</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Views</em>' containment reference list.
	 * @see com.nokia.tools.vct.confml.model.confml1.EConfML1Package#getEConfigurationElement_Views()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='view' namespace='##targetNamespace' group='#contents:0'"
	 * @generated
	 */
	EList<EViewElement> getViews();

	/**
	 * Returns the value of the '<em><b>Data</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.confml.model.confml1.EDataElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' containment reference list.
	 * @see com.nokia.tools.vct.confml.model.confml1.EConfML1Package#getEConfigurationElement_Data()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='data' namespace='##targetNamespace' group='#contents:0'"
	 * @generated
	 */
	EList<EDataElement> getData();

	/**
	 * Returns the value of the '<em><b>Rfs</b></em>' containment reference
	 * list. The list contents are of type
	 * {@link com.nokia.tools.vct.confml.model.confml1.ERfsElement}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rfs</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Rfs</em>' containment reference list.
	 * @see com.nokia.tools.vct.confml.model.confml1.EConfML1Package#getEConfigurationElement_Rfs()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData=
	 *        "kind='element' name='rfs' namespace='##targetNamespace' group='#contents:0'"
	 * @generated
	 */
	EList<ERfsElement> getRfs();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.nokia.tools.vct.confml.model.confml1.EConfML1Package#getEConfigurationElement_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.confml.model.confml1.EConfigurationElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see com.nokia.tools.vct.confml.model.confml1.EConfML1Package#getEConfigurationElement_Version()
	 * @model
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '
	 * {@link com.nokia.tools.vct.confml.model.confml1.EConfigurationElement#getVersion
	 * <em>Version</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Includes</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.confml.model.confml1.include.EInclude}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Includes</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Includes</em>' containment reference list.
	 * @see com.nokia.tools.vct.confml.model.confml1.EConfML1Package#getEConfigurationElement_Includes()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='include' namespace='http://www.w3.org/2001/XInclude' group='#contents:0'"
	 * @generated
	 */
	EList<EInclude> getIncludes();

} // EConfigurationElement
