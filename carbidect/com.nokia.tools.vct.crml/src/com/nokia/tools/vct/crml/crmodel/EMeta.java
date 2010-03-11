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
 * Description: This file is part of com.nokia.tools.vct.crml component.
 */

package com.nokia.tools.vct.crml.crmodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EMeta</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.EMeta#getIdentification <em>Identification</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.EMeta#getDate <em>Date</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.EMeta#getPlatform <em>Platform</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.EMeta#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.EMeta#getEditor <em>Editor</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.EMeta#getStatus <em>Status</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.EMeta#getVersion <em>Version</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.EMeta#getProduct <em>Product</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.EMeta#getRelease <em>Release</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getEMeta()
 * @model extendedMetaData="name='metaType' type='elementOnly'"
 * @generated
 */
public interface EMeta extends CommonAttrs {
	/**
	 * Returns the value of the '<em><b>Identification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identification</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identification</em>' attribute.
	 * @see #setIdentification(String)
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getEMeta_Identification()
	 * @model extendedMetaData="name='id' kind='element' namespace='##targetNamespace'"
	 * @generated
	 */
	String getIdentification();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.crml.crmodel.EMeta#getIdentification <em>Identification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identification</em>' attribute.
	 * @see #getIdentification()
	 * @generated
	 */
	void setIdentification(String value);

	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(String)
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getEMeta_Date()
	 * @model extendedMetaData="name='date' kind='element' namespace='##targetNamespace'"
	 * @generated
	 */
	String getDate();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.crml.crmodel.EMeta#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(String value);

	/**
	 * Returns the value of the '<em><b>Platform</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Platform</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Platform</em>' attribute.
	 * @see #setPlatform(String)
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getEMeta_Platform()
	 * @model extendedMetaData="name='platform' kind='element' namespace='##targetNamespace'"
	 * @generated
	 */
	String getPlatform();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.crml.crmodel.EMeta#getPlatform <em>Platform</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Platform</em>' attribute.
	 * @see #getPlatform()
	 * @generated
	 */
	void setPlatform(String value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' attribute.
	 * @see #setOwner(String)
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getEMeta_Owner()
	 * @model extendedMetaData="name='owner' kind='element' namespace='##targetNamespace'"
	 * @generated
	 */
	String getOwner();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.crml.crmodel.EMeta#getOwner <em>Owner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' attribute.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(String value);

	/**
	 * Returns the value of the '<em><b>Editor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Editor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Editor</em>' attribute.
	 * @see #setEditor(String)
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getEMeta_Editor()
	 * @model extendedMetaData="name='editor' kind='element' namespace='##targetNamespace'"
	 * @generated
	 */
	String getEditor();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.crml.crmodel.EMeta#getEditor <em>Editor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Editor</em>' attribute.
	 * @see #getEditor()
	 * @generated
	 */
	void setEditor(String value);

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see #setStatus(String)
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getEMeta_Status()
	 * @model extendedMetaData="name='status' kind='element' namespace='##targetNamespace'"
	 * @generated
	 */
	String getStatus();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.crml.crmodel.EMeta#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(String value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getEMeta_Version()
	 * @model extendedMetaData="name='version' kind='element' namespace='##targetNamespace'"
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.crml.crmodel.EMeta#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Product</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Product</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Product</em>' attribute.
	 * @see #setProduct(String)
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getEMeta_Product()
	 * @model extendedMetaData="name='product' kind='element' namespace='##targetNamespace'"
	 * @generated
	 */
	String getProduct();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.crml.crmodel.EMeta#getProduct <em>Product</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Product</em>' attribute.
	 * @see #getProduct()
	 * @generated
	 */
	void setProduct(String value);

	/**
	 * Returns the value of the '<em><b>Release</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Release</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Release</em>' attribute.
	 * @see #setRelease(String)
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getEMeta_Release()
	 * @model extendedMetaData="name='release' kind='element' namespace='##targetNamespace'"
	 * @generated
	 */
	String getRelease();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.crml.crmodel.EMeta#getRelease <em>Release</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Release</em>' attribute.
	 * @see #getRelease()
	 * @generated
	 */
	void setRelease(String value);

} // EMeta
