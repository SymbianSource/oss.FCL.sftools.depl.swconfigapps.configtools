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
 * Description: This file is part of com.nokia.tools.variant.confml.core component.
 */

package com.nokia.tools.variant.confml.core.model.metadata;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * <p>
 * A representation of the model object ' <em><b>CPF Metadata</b></em>'. This
 * object is used in IDE for specifying currently observed configuration project root.
 * </p>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getDescription <em>Description</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getViewId <em>View Id</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getCpfRootFile <em>Cpf Root File</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getAuthor <em>Author</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getVersion <em>Version</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getDataOverrideFile <em>Data Override File</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getProduct <em>Product</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getPlatform <em>Platform</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getRelease <em>Release</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getCustomer <em>Customer</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getDate <em>Date</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.variant.confml.core.model.metadata.EMetadataPackage#getECPFMetadata()
 * @model
 * @generated
 */
public interface ECPFMetadata extends EObject {
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
     * @see com.nokia.tools.variant.confml.core.model.metadata.EMetadataPackage#getECPFMetadata_Name()
     * @model required="true"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Description</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Description</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Description</em>' attribute.
     * @see #setDescription(String)
     * @see com.nokia.tools.variant.confml.core.model.metadata.EMetadataPackage#getECPFMetadata_Description()
     * @model required="true"
     * @generated
     */
    String getDescription();

    /**
     * Sets the value of the '{@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getDescription <em>Description</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @param value the new value of the '<em>Description</em>' attribute.
     * @see #getDescription()
     * @generated
     */
    void setDescription(String value);

    /**
     * Returns the value of the '<em><b>View Id</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>View Id</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>View Id</em>' attribute.
     * @see #setViewId(String)
     * @see com.nokia.tools.variant.confml.core.model.metadata.EMetadataPackage#getECPFMetadata_ViewId()
     * @model required="true"
     * @generated
     */
    String getViewId();

    /**
     * Sets the value of the '
     * {@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getViewId
     * <em>View Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value the new value of the '<em>View Id</em>' attribute.
     * @see #getViewId()
     * @generated
     */
    void setViewId(String value);

    /**
     * Returns the value of the '<em><b>Cpf Root File</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Cpf Root File</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Cpf Root File</em>' attribute.
     * @see #setCpfRootFile(String)
     * @see com.nokia.tools.variant.confml.core.model.metadata.EMetadataPackage#getECPFMetadata_CpfRootFile()
     * @model required="true"
     * @generated
     */
    String getCpfRootFile();

    /**
     * Sets the value of the '{@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getCpfRootFile <em>Cpf Root File</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @param value the new value of the '<em>Cpf Root File</em>' attribute.
     * @see #getCpfRootFile()
     * @generated
     */
    void setCpfRootFile(String value);

    /**
     * Returns the value of the '<em><b>Author</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Author</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Author</em>' attribute.
     * @see #setAuthor(String)
     * @see com.nokia.tools.variant.confml.core.model.metadata.EMetadataPackage#getECPFMetadata_Author()
     * @model required="true"
     * @generated
     */
    String getAuthor();

    /**
     * Sets the value of the '
     * {@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getAuthor
     * <em>Author</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value the new value of the '<em>Author</em>' attribute.
     * @see #getAuthor()
     * @generated
     */
    void setAuthor(String value);

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
     * @see com.nokia.tools.variant.confml.core.model.metadata.EMetadataPackage#getECPFMetadata_Version()
     * @model required="true"
     * @generated
     */
    String getVersion();

    /**
     * Sets the value of the '
     * {@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getVersion
     * <em>Version</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value the new value of the '<em>Version</em>' attribute.
     * @see #getVersion()
     * @generated
     */
    void setVersion(String value);

    /**
     * Returns the value of the '<em><b>Data Override File</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data Override File</em>' attribute isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Override File</em>' attribute.
     * @see #setDataOverrideFile(String)
     * @see com.nokia.tools.variant.confml.core.model.metadata.EMetadataPackage#getECPFMetadata_DataOverrideFile()
     * @model required="true"
     * @generated
     */
    String getDataOverrideFile();

    /**
     * Sets the value of the '{@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getDataOverrideFile <em>Data Override File</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @param value the new value of the '<em>Data Override File</em>' attribute.
     * @see #getDataOverrideFile()
     * @generated
     */
    void setDataOverrideFile(String value);

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
     * @see com.nokia.tools.variant.confml.core.model.metadata.EMetadataPackage#getECPFMetadata_Product()
     * @model required="true"
     * @generated
     */
    String getProduct();

    /**
     * Sets the value of the '
     * {@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getProduct
     * <em>Product</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value the new value of the '<em>Product</em>' attribute.
     * @see #getProduct()
     * @generated
     */
    void setProduct(String value);

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
     * @see com.nokia.tools.variant.confml.core.model.metadata.EMetadataPackage#getECPFMetadata_Platform()
     * @model required="true"
     * @generated
     */
    String getPlatform();

    /**
     * Sets the value of the '
     * {@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getPlatform
     * <em>Platform</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value the new value of the '<em>Platform</em>' attribute.
     * @see #getPlatform()
     * @generated
     */
    void setPlatform(String value);

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
     * @see com.nokia.tools.variant.confml.core.model.metadata.EMetadataPackage#getECPFMetadata_Release()
     * @model required="true"
     * @generated
     */
    String getRelease();

    /**
     * Sets the value of the '
     * {@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getRelease
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
     * @see com.nokia.tools.variant.confml.core.model.metadata.EMetadataPackage#getECPFMetadata_Customer()
     * @model required="true"
     * @generated
     */
    String getCustomer();

    /**
     * Sets the value of the '
     * {@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getCustomer
     * <em>Customer</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value the new value of the '<em>Customer</em>' attribute.
     * @see #getCustomer()
     * @generated
     */
    void setCustomer(String value);

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
     * @see com.nokia.tools.variant.confml.core.model.metadata.EMetadataPackage#getECPFMetadata_Owner()
     * @model required="true"
     * @generated
     */
    String getOwner();

    /**
     * Sets the value of the '{@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getOwner <em>Owner</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Owner</em>' attribute.
     * @see #getOwner()
     * @generated
     */
    void setOwner(String value);

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
     * @see com.nokia.tools.variant.confml.core.model.metadata.EMetadataPackage#getECPFMetadata_Date()
     * @model required="true"
     * @generated
     */
    String getDate();

    /**
     * Sets the value of the '{@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getDate <em>Date</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Date</em>' attribute.
     * @see #getDate()
     * @generated
     */
    void setDate(String value);

} // ECPFMetadata
