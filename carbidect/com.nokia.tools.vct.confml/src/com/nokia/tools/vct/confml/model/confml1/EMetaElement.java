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
import org.eclipse.emf.ecore.util.FeatureMap;

import com.nokia.tools.vct.confml.model.metaext.EConfigurationPropertyElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EMeta Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EMetaElement#getId <em>Id</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EMetaElement#getDate <em>Date</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EMetaElement#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EMetaElement#getEditor <em>Editor</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EMetaElement#getProduct <em>Product</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EMetaElement#getStatus <em>Status</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EMetaElement#getPlatform <em>Platform</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EMetaElement#getVersion <em>Version</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EMetaElement#getRelease <em>Release</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EMetaElement#getCustomer <em>Customer</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EMetaElement#getConfigurationProperty <em>Configuration Property</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EMetaElement#getOtherElements <em>Other Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.confml.model.confml1.EConfML1Package#getEMetaElement()
 * @model extendedMetaData="name='metaType' kind='elementOnly'"
 * @generated
 */
public interface EMetaElement extends ELinkContainer, EIconContainer {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.confml.model.confml1.EMetaContent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' containment reference list.
	 * @see com.nokia.tools.vct.confml.model.confml1.EConfML1Package#getEMetaElement_Id()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='id' namespace='##targetNamespace' group='#contents:0'"
	 * @generated
	 */
	EList<EMetaContent> getId();

	/**
	 * Returns the value of the '<em><b>Date</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.confml.model.confml1.EMetaContent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' containment reference list.
	 * @see com.nokia.tools.vct.confml.model.confml1.EConfML1Package#getEMetaElement_Date()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='date' namespace='##targetNamespace' group='#contents:0'"
	 * @generated
	 */
	EList<EMetaContent> getDate();

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.confml.model.confml1.EMetaContent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' containment reference list.
	 * @see com.nokia.tools.vct.confml.model.confml1.EConfML1Package#getEMetaElement_Owner()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='owner' namespace='##targetNamespace' group='#contents:0'"
	 * @generated
	 */
	EList<EMetaContent> getOwner();

	/**
	 * Returns the value of the '<em><b>Editor</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.confml.model.confml1.EMetaContent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Editor</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Editor</em>' containment reference list.
	 * @see com.nokia.tools.vct.confml.model.confml1.EConfML1Package#getEMetaElement_Editor()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='editor' namespace='##targetNamespace' group='#contents:0'"
	 * @generated
	 */
	EList<EMetaContent> getEditor();

	/**
	 * Returns the value of the '<em><b>Product</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.confml.model.confml1.EMetaContent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Product</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Product</em>' containment reference list.
	 * @see com.nokia.tools.vct.confml.model.confml1.EConfML1Package#getEMetaElement_Product()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='product' namespace='##targetNamespace' group='#contents:0'"
	 * @generated
	 */
	EList<EMetaContent> getProduct();

	/**
	 * Returns the value of the '<em><b>Status</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.confml.model.confml1.EMetaContent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' containment reference list.
	 * @see com.nokia.tools.vct.confml.model.confml1.EConfML1Package#getEMetaElement_Status()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='status' namespace='##targetNamespace' group='#contents:0'"
	 * @generated
	 */
	EList<EMetaContent> getStatus();

	/**
	 * Returns the value of the '<em><b>Platform</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.confml.model.confml1.EMetaContent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Platform</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Platform</em>' containment reference list.
	 * @see com.nokia.tools.vct.confml.model.confml1.EConfML1Package#getEMetaElement_Platform()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='platform' namespace='##targetNamespace' group='#contents:0'"
	 * @generated
	 */
	EList<EMetaContent> getPlatform();

	/**
	 * Returns the value of the '<em><b>Version</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.confml.model.confml1.EMetaContent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' containment reference list.
	 * @see com.nokia.tools.vct.confml.model.confml1.EConfML1Package#getEMetaElement_Version()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='version' namespace='##targetNamespace' group='#contents:0'"
	 * @generated
	 */
	EList<EMetaContent> getVersion();

	/**
	 * Returns the value of the '<em><b>Release</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.confml.model.confml1.EMetaContent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Release</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Release</em>' containment reference list.
	 * @see com.nokia.tools.vct.confml.model.confml1.EConfML1Package#getEMetaElement_Release()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='release' namespace='##targetNamespace' group='#contents:0'"
	 * @generated
	 */
	EList<EMetaContent> getRelease();

	/**
	 * Returns the value of the '<em><b>Customer</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.confml.model.confml1.EMetaContent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Customer</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Customer</em>' containment reference list.
	 * @see com.nokia.tools.vct.confml.model.confml1.EConfML1Package#getEMetaElement_Customer()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='customer' namespace='##targetNamespace' group='#contents:0'"
	 * @generated
	 */
	EList<EMetaContent> getCustomer();

	/**
	 * Returns the value of the '<em><b>Configuration Property</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.confml.model.metaext.EConfigurationPropertyElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration Property</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration Property</em>' containment reference list.
	 * @see com.nokia.tools.vct.confml.model.confml1.EConfML1Package#getEMetaElement_ConfigurationProperty()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='configuration-property' namespace='http://www.nokia.com/xml/cpf-id/1' group='#contents:0'"
	 * @generated
	 */
	EList<EConfigurationPropertyElement> getConfigurationProperty();

	/**
	 * Returns the value of the '<em><b>Other Elements</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Other Elements</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Other Elements</em>' attribute list.
	 * @see com.nokia.tools.vct.confml.model.confml1.EConfML1Package#getEMetaElement_OtherElements()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='elementWildcard' name=':12' wildcards='##other' group='#contents:0' processing='lax'"
	 * @generated
	 */
	FeatureMap getOtherElements();

} // EMetaElement
