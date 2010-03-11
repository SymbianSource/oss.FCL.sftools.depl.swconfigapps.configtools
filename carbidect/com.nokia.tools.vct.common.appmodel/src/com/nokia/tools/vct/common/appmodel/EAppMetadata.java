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
 * Description: This file is part of com.nokia.tools.vct.common.appmodel component.
 */

package com.nokia.tools.vct.common.appmodel;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * <p>
 * Interface for metadata definitions as per ConfML specification. All
 * attributes are presented in a form of strings as the specification does not
 * define any constraints.
 * </p>
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link #getDate <em>Date</em>}</li>
 * <li>
 * {@link #getOwner <em>Owner</em>}</li>
 * <li>
 * {@link #getEditor <em>Editor</em>}</li>
 * <li>
 * {@link #getStatus <em>Status</em>}</li>
 * <li>
 * {@link #getVersion <em>Version</em>}</li>
 * <li>
 * {@link #getPlatform <em>Platform</em>}</li>
 * <li>
 * {@link #getProduct <em>Product</em>}</li>
 * <li>
 * {@link #getRelease <em>Release</em>}</li>
 * <li>
 * {@link #getCustomer <em>Customer</em>}</li>
 * <li>
 * {@link #getOrigin <em>Origin</em>}</li>
 * <li>
 * {@link #getTarget <em>Target</em>}</li>
 * <li>
 * {@link #getMetaId <em>Metadata ID</em>}</li>
 * </ul>
 * </p>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppMetadata#getDate <em>Date</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppMetadata#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppMetadata#getEditor <em>Editor</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppMetadata#getStatus <em>Status</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppMetadata#getVersion <em>Version</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppMetadata#getPlatform <em>Platform</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppMetadata#getProduct <em>Product</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppMetadata#getRelease <em>Release</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppMetadata#getCustomer <em>Customer</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppMetadata#getOrigin <em>Origin</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppMetadata#getTarget <em>Target</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppMetadata#getMetaId <em>Meta Id</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppMetadata#getConfigurationPropertyMap <em>Configuration Property Map</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppMetadata()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface EAppMetadata extends EObject {
    /**
     * Returns the value of the '<em><b>Date</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Date</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Date</em>' attribute.
     * @see #setDate(String)
     * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppMetadata_Date()
     * @model
     * @generated
     */
    String getDate();

    /**
	 * Sets the value of the '{@link com.nokia.tools.vct.common.appmodel.EAppMetadata#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
    void setDate(String value);

    /**
     * Returns the value of the '<em><b>Owner</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Owner</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Owner</em>' attribute.
     * @see #setOwner(String)
     * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppMetadata_Owner()
     * @model
     * @generated
     */
    String getOwner();

    /**
	 * Sets the value of the '{@link com.nokia.tools.vct.common.appmodel.EAppMetadata#getOwner <em>Owner</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' attribute.
	 * @see #getOwner()
	 * @generated
	 */
    void setOwner(String value);

    /**
     * Returns the value of the '<em><b>Editor</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Editor</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Editor</em>' attribute.
     * @see #setEditor(String)
     * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppMetadata_Editor()
     * @model
     * @generated
     */
    String getEditor();

    /**
     * Sets the value of the '
     * {@link com.nokia.tools.vct.common.appmodel.EAppMetadata#getEditor
     * <em>Editor</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value the new value of the '<em>Editor</em>' attribute.
     * @see #getEditor()
     * @generated
     */
    void setEditor(String value);

    /**
     * Returns the value of the '<em><b>Status</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Status</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Status</em>' attribute.
     * @see #setStatus(String)
     * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppMetadata_Status()
     * @model
     * @generated
     */
    String getStatus();

    /**
     * Sets the value of the '
     * {@link com.nokia.tools.vct.common.appmodel.EAppMetadata#getStatus
     * <em>Status</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value the new value of the '<em>Status</em>' attribute.
     * @see #getStatus()
     * @generated
     */
    void setStatus(String value);

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
     * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppMetadata_Version()
     * @model
     * @generated
     */
    String getVersion();

    /**
     * Sets the value of the '
     * {@link com.nokia.tools.vct.common.appmodel.EAppMetadata#getVersion
     * <em>Version</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value the new value of the '<em>Version</em>' attribute.
     * @see #getVersion()
     * @generated
     */
    void setVersion(String value);

    /**
     * Returns the value of the '<em><b>Platform</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Platform</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Platform</em>' attribute.
     * @see #setPlatform(String)
     * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppMetadata_Platform()
     * @model
     * @generated
     */
    String getPlatform();

    /**
     * Sets the value of the '
     * {@link com.nokia.tools.vct.common.appmodel.EAppMetadata#getPlatform
     * <em>Platform</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value the new value of the '<em>Platform</em>' attribute.
     * @see #getPlatform()
     * @generated
     */
    void setPlatform(String value);

    /**
     * Returns the value of the '<em><b>Product</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Product</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Product</em>' attribute.
     * @see #setProduct(String)
     * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppMetadata_Product()
     * @model
     * @generated
     */
    String getProduct();

    /**
     * Sets the value of the '
     * {@link com.nokia.tools.vct.common.appmodel.EAppMetadata#getProduct
     * <em>Product</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value the new value of the '<em>Product</em>' attribute.
     * @see #getProduct()
     * @generated
     */
    void setProduct(String value);

    /**
     * Returns the value of the '<em><b>Release</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Release</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Release</em>' attribute.
     * @see #setRelease(String)
     * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppMetadata_Release()
     * @model
     * @generated
     */
    String getRelease();

    /**
     * Sets the value of the '
     * {@link com.nokia.tools.vct.common.appmodel.EAppMetadata#getRelease
     * <em>Release</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value the new value of the '<em>Release</em>' attribute.
     * @see #getRelease()
     * @generated
     */
    void setRelease(String value);

    /**
     * Returns the value of the '<em><b>Customer</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Customer</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Customer</em>' attribute.
     * @see #setCustomer(String)
     * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppMetadata_Customer()
     * @model
     * @generated
     */
    String getCustomer();

    /**
     * Sets the value of the '
     * {@link com.nokia.tools.vct.common.appmodel.EAppMetadata#getCustomer
     * <em>Customer</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value the new value of the '<em>Customer</em>' attribute.
     * @see #getCustomer()
     * @generated
     */
    void setCustomer(String value);

    /**
     * Returns the value of the '<em><b>Origin</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Origin</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Origin</em>' attribute.
     * @see #setOrigin(String)
     * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppMetadata_Origin()
     * @model
     * @generated
     */
    String getOrigin();

    /**
     * Sets the value of the '
     * {@link com.nokia.tools.vct.common.appmodel.EAppMetadata#getOrigin
     * <em>Origin</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value the new value of the '<em>Origin</em>' attribute.
     * @see #getOrigin()
     * @generated
     */
    void setOrigin(String value);

    /**
     * Returns the value of the '<em><b>Target</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Target</em>' attribute.
     * @see #setTarget(String)
     * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppMetadata_Target()
     * @model
     * @generated
     */
    String getTarget();

    /**
     * Sets the value of the '
     * {@link com.nokia.tools.vct.common.appmodel.EAppMetadata#getTarget
     * <em>Target</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value the new value of the '<em>Target</em>' attribute.
     * @see #getTarget()
     * @generated
     */
    void setTarget(String value);

    /**
     * Returns the value of the '<em><b>Meta Id</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Meta Id</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Meta Id</em>' attribute.
     * @see #setMetaId(String)
     * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppMetadata_MetaId()
     * @model
     * @generated
     */
    String getMetaId();

    /**
     * Sets the value of the '
     * {@link com.nokia.tools.vct.common.appmodel.EAppMetadata#getMetaId
     * <em>Meta Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value the new value of the '<em>Meta Id</em>' attribute.
     * @see #getMetaId()
     * @generated
     */
    void setMetaId(String value);

				/**
	 * Returns the value of the '<em><b>Configuration Property Map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration Property Map</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration Property Map</em>' attribute.
	 * @see #setConfigurationPropertyMap(Map)
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppMetadata_ConfigurationPropertyMap()
	 * @model transient="true"
	 * @generated NOT
	 */
	Map<String, String> getConfigurationPropertyMap();

				/**
	 * Sets the value of the '{@link com.nokia.tools.vct.common.appmodel.EAppMetadata#getConfigurationPropertyMap <em>Configuration Property Map</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration Property Map</em>' attribute.
	 * @see #getConfigurationPropertyMap()
	 */
	void setConfigurationPropertyMap(Map<String, String> value);

} // EAppMetadata
