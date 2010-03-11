/*
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
*/
package configurationemf;

import java.util.List;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link configurationemf.Configuration#getName <em>Name</em>}</li>
 *   <li>{@link configurationemf.Configuration#getVers <em>Vers</em>}</li>
 *   <li>{@link configurationemf.Configuration#getFeature <em>Feature</em>}</li>
 *   <li>{@link configurationemf.Configuration#getView <em>View</em>}</li>
 *   <li>{@link configurationemf.Configuration#getMeta <em>Meta</em>}</li>
 *   <li>{@link configurationemf.Configuration#getIcon <em>Icon</em>}</li>
 *   <li>{@link configurationemf.Configuration#getLink <em>Link</em>}</li>
 *   <li>{@link configurationemf.Configuration#getData <em>Data</em>}</li>
 *   <li>{@link configurationemf.Configuration#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link configurationemf.Configuration#getMetaId <em>Meta Id</em>}</li>
 *   <li>{@link configurationemf.Configuration#getOwner <em>Owner</em>}</li>
 *   <li>{@link configurationemf.Configuration#getEditor <em>Editor</em>}</li>
 *   <li>{@link configurationemf.Configuration#getStatus <em>Status</em>}</li>
 *   <li>{@link configurationemf.Configuration#getVersion <em>Version</em>}</li>
 *   <li>{@link configurationemf.Configuration#getPlatform <em>Platform</em>}</li>
 *   <li>{@link configurationemf.Configuration#getProduct <em>Product</em>}</li>
 *   <li>{@link configurationemf.Configuration#getCustomer <em>Customer</em>}</li>
 *   <li>{@link configurationemf.Configuration#getDate <em>Date</em>}</li>
 *   <li>{@link configurationemf.Configuration#getRelease <em>Release</em>}</li>
 * </ul>
 * </p>
 *
 * @see configurationemf.ConfigurationemfPackage#getConfiguration()
 * @model abstract="true"
 * @generated
 */
public interface Configuration extends AttributeAndDesc {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see configurationemf.ConfigurationemfPackage#getConfiguration_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link configurationemf.Configuration#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Vers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vers</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vers</em>' attribute.
	 * @see #setVers(String)
	 * @see configurationemf.ConfigurationemfPackage#getConfiguration_Vers()
	 * @model
	 * @generated
	 */
	String getVers();

	/**
	 * Sets the value of the '{@link configurationemf.Configuration#getVers <em>Vers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vers</em>' attribute.
	 * @see #getVers()
	 * @generated
	 */
	void setVers(String value);

	/**
	 * Returns the value of the '<em><b>Feature</b></em>' containment reference list.
	 * The list contents are of type {@link configurationemf.Feature}.
	 * It is bidirectional and its opposite is '{@link configurationemf.Feature#getConf <em>Conf</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' containment reference list.
	 * @see configurationemf.ConfigurationemfPackage#getConfiguration_Feature()
	 * @see configurationemf.Feature#getConf
	 * @model opposite="conf" containment="true"
	 * @generated
	 */
	EList<Feature> getFeature();

	/**
	 * Returns the value of the '<em><b>View</b></em>' containment reference list.
	 * The list contents are of type {@link configurationemf.View}.
	 * It is bidirectional and its opposite is '{@link configurationemf.View#getConf <em>Conf</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>View</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>View</em>' containment reference list.
	 * @see configurationemf.ConfigurationemfPackage#getConfiguration_View()
	 * @see configurationemf.View#getConf
	 * @model opposite="conf" containment="true"
	 * @generated
	 */
	EList<View> getView();

	/**
	 * Returns the value of the '<em><b>Meta</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta</em>' containment reference.
	 * @see #setMeta(Meta)
	 * @see configurationemf.ConfigurationemfPackage#getConfiguration_Meta()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Meta getMeta();

	/**
	 * Sets the value of the '{@link configurationemf.Configuration#getMeta <em>Meta</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta</em>' containment reference.
	 * @see #getMeta()
	 * @generated
	 */
	void setMeta(Meta value);

	/**
	 * Returns the value of the '<em><b>Icon</b></em>' containment reference list.
	 * The list contents are of type {@link configurationemf.Icon}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon</em>' containment reference list.
	 * @see configurationemf.ConfigurationemfPackage#getConfiguration_Icon()
	 * @model containment="true"
	 * @generated
	 */
	EList<Icon> getIcon();

	/**
	 * Returns the value of the '<em><b>Link</b></em>' containment reference list.
	 * The list contents are of type {@link configurationemf.Link}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link</em>' containment reference list.
	 * @see configurationemf.ConfigurationemfPackage#getConfiguration_Link()
	 * @model containment="true"
	 * @generated
	 */
	EList<Link> getLink();

	/**
	 * Returns the value of the '<em><b>Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' containment reference.
	 * @see #setData(Data)
	 * @see configurationemf.ConfigurationemfPackage#getConfiguration_Data()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Data getData();

	/**
	 * Sets the value of the '{@link configurationemf.Configuration#getData <em>Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data</em>' containment reference.
	 * @see #getData()
	 * @generated
	 */
	void setData(Data value);

	/**
	 * Returns the value of the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Read Only</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Read Only</em>' attribute.
	 * @see configurationemf.ConfigurationemfPackage#getConfiguration_ReadOnly()
	 * @model transient="true" changeable="false" volatile="true"
	 * @generated
	 */
	boolean isReadOnly();

	/**
	 * Returns the value of the '<em><b>Meta Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Id</em>' attribute.
	 * @see #setMetaId(String)
	 * @see configurationemf.ConfigurationemfPackage#getConfiguration_MetaId()
	 * @model transient="true" volatile="true"
	 * @generated
	 */
	String getMetaId();

	/**
	 * Sets the value of the '{@link configurationemf.Configuration#getMetaId <em>Meta Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Id</em>' attribute.
	 * @see #getMetaId()
	 * @generated
	 */
	void setMetaId(String value);

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
	 * @see configurationemf.ConfigurationemfPackage#getConfiguration_Owner()
	 * @model transient="true" volatile="true"
	 * @generated
	 */
	String getOwner();

	/**
	 * Sets the value of the '{@link configurationemf.Configuration#getOwner <em>Owner</em>}' attribute.
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
	 * @see configurationemf.ConfigurationemfPackage#getConfiguration_Editor()
	 * @model transient="true" volatile="true"
	 * @generated
	 */
	String getEditor();

	/**
	 * Sets the value of the '{@link configurationemf.Configuration#getEditor <em>Editor</em>}' attribute.
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
	 * @see configurationemf.ConfigurationemfPackage#getConfiguration_Status()
	 * @model transient="true" volatile="true"
	 * @generated
	 */
	String getStatus();

	/**
	 * Sets the value of the '{@link configurationemf.Configuration#getStatus <em>Status</em>}' attribute.
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
	 * @see configurationemf.ConfigurationemfPackage#getConfiguration_Version()
	 * @model transient="true" volatile="true"
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link configurationemf.Configuration#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

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
	 * @see configurationemf.ConfigurationemfPackage#getConfiguration_Platform()
	 * @model transient="true" volatile="true"
	 * @generated
	 */
	String getPlatform();

	/**
	 * Sets the value of the '{@link configurationemf.Configuration#getPlatform <em>Platform</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Platform</em>' attribute.
	 * @see #getPlatform()
	 * @generated
	 */
	void setPlatform(String value);

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
	 * @see configurationemf.ConfigurationemfPackage#getConfiguration_Product()
	 * @model transient="true" volatile="true"
	 * @generated
	 */
	String getProduct();

	/**
	 * Sets the value of the '{@link configurationemf.Configuration#getProduct <em>Product</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Product</em>' attribute.
	 * @see #getProduct()
	 * @generated
	 */
	void setProduct(String value);

	/**
	 * Returns the value of the '<em><b>Customer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Customer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Customer</em>' attribute.
	 * @see #setCustomer(String)
	 * @see configurationemf.ConfigurationemfPackage#getConfiguration_Customer()
	 * @model transient="true" volatile="true"
	 * @generated
	 */
	String getCustomer();

	/**
	 * Sets the value of the '{@link configurationemf.Configuration#getCustomer <em>Customer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Customer</em>' attribute.
	 * @see #getCustomer()
	 * @generated
	 */
	void setCustomer(String value);

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
	 * @see configurationemf.ConfigurationemfPackage#getConfiguration_Date()
	 * @model transient="true" volatile="true"
	 * @generated
	 */
	String getDate();

	/**
	 * Sets the value of the '{@link configurationemf.Configuration#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(String value);

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
	 * @see configurationemf.ConfigurationemfPackage#getConfiguration_Release()
	 * @model transient="true" volatile="true"
	 * @generated
	 */
	String getRelease();

	/**
	 * Sets the value of the '{@link configurationemf.Configuration#getRelease <em>Release</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Release</em>' attribute.
	 * @see #getRelease()
	 * @generated
	 */
	void setRelease(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" many="false"
	 * @generated
	 */
	EList<Setting> getAllSettings();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	View getViewById(String viewId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	View getViewByName(String viewName);
	
	
} // Configuration