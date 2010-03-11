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

import com.nokia.tools.carbide.ct.confml.model.metaext.EConfigurationPropertyElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EMeta Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement#getId <em>Id</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement#getDate <em>Date</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement#getEditor <em>Editor</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement#getProduct <em>Product</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement#getStatus <em>Status</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement#getPlatform <em>Platform</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement#getVersion <em>Version</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement#getRelease <em>Release</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement#getCustomer <em>Customer</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement#getOrigin <em>Origin</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement#getTarget <em>Target</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement#getConfigurationProperty <em>Configuration Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getEMetaElement()
 * @model extendedMetaData="name='metaType' kind='elementOnly'"
 * @generated
 */
public interface EMetaElement extends ELinkContainer, EIconContainer {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaContent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' containment reference list.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getEMetaElement_Id()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='id' namespace='##targetNamespace' group='#contents:0'"
	 * @generated
	 */
	EList<EMetaContent> getId();

	/**
	 * Returns the value of the '<em><b>Date</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaContent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' containment reference list.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getEMetaElement_Date()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='date' namespace='##targetNamespace' group='#contents:0'"
	 * @generated
	 */
	EList<EMetaContent> getDate();

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaContent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' containment reference list.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getEMetaElement_Owner()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='owner' namespace='##targetNamespace' group='#contents:0'"
	 * @generated
	 */
	EList<EMetaContent> getOwner();

	/**
	 * Returns the value of the '<em><b>Editor</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaContent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Editor</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Editor</em>' containment reference list.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getEMetaElement_Editor()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='editor' namespace='##targetNamespace' group='#contents:0'"
	 * @generated
	 */
	EList<EMetaContent> getEditor();

	/**
	 * Returns the value of the '<em><b>Product</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaContent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Product</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Product</em>' containment reference list.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getEMetaElement_Product()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='product' namespace='##targetNamespace' group='#contents:0'"
	 * @generated
	 */
	EList<EMetaContent> getProduct();

	/**
	 * Returns the value of the '<em><b>Status</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaContent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' containment reference list.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getEMetaElement_Status()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='status' namespace='##targetNamespace' group='#contents:0'"
	 * @generated
	 */
	EList<EMetaContent> getStatus();

	/**
	 * Returns the value of the '<em><b>Platform</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaContent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Platform</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Platform</em>' containment reference list.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getEMetaElement_Platform()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='platform' namespace='##targetNamespace' group='#contents:0'"
	 * @generated
	 */
	EList<EMetaContent> getPlatform();

	/**
	 * Returns the value of the '<em><b>Version</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaContent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' containment reference list.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getEMetaElement_Version()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='version' namespace='##targetNamespace' group='#contents:0'"
	 * @generated
	 */
	EList<EMetaContent> getVersion();

	/**
	 * Returns the value of the '<em><b>Release</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaContent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Release</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Release</em>' containment reference list.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getEMetaElement_Release()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='release' namespace='##targetNamespace' group='#contents:0'"
	 * @generated
	 */
	EList<EMetaContent> getRelease();

	/**
	 * Returns the value of the '<em><b>Customer</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaContent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Customer</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Customer</em>' containment reference list.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getEMetaElement_Customer()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='customer' namespace='##targetNamespace' group='#contents:0'"
	 * @generated
	 */
	EList<EMetaContent> getCustomer();

	/**
	 * Returns the value of the '<em><b>Origin</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaContent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Origin</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Origin</em>' containment reference list.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getEMetaElement_Origin()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='origin' namespace='##targetNamespace' group='#contents:0'"
	 * @generated
	 */
	EList<EMetaContent> getOrigin();

	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaContent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference list.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getEMetaElement_Target()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='target' namespace='##targetNamespace' group='#contents:0'"
	 * @generated
	 */
	EList<EMetaContent> getTarget();

	/**
	 * Returns the value of the '<em><b>Configuration Property</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.carbide.ct.confml.model.metaext.EConfigurationPropertyElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration Property</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration Property</em>' containment reference list.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getEMetaElement_ConfigurationProperty()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='configuration-property' namespace='http://www.nokia.com/xml/cpf-id/1' group='#contents:0'"
	 * @generated
	 */
	EList<EConfigurationPropertyElement> getConfigurationProperty();

} // EMetaElement
