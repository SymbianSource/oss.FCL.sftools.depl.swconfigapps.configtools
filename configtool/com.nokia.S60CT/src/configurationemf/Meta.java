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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Meta</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link configurationemf.Meta#getIdentification <em>Identification</em>}</li>
 *   <li>{@link configurationemf.Meta#getOwner <em>Owner</em>}</li>
 *   <li>{@link configurationemf.Meta#getEditor <em>Editor</em>}</li>
 *   <li>{@link configurationemf.Meta#getStatus <em>Status</em>}</li>
 *   <li>{@link configurationemf.Meta#getVersion <em>Version</em>}</li>
 *   <li>{@link configurationemf.Meta#getPlatform <em>Platform</em>}</li>
 *   <li>{@link configurationemf.Meta#getProduct <em>Product</em>}</li>
 *   <li>{@link configurationemf.Meta#getCustomer <em>Customer</em>}</li>
 *   <li>{@link configurationemf.Meta#getDate <em>Date</em>}</li>
 *   <li>{@link configurationemf.Meta#getRelease <em>Release</em>}</li>
 * </ul>
 * </p>
 *
 * @see configurationemf.ConfigurationemfPackage#getMeta()
 * @model
 * @generated
 */
public interface Meta extends CommonAttr {
	/**
	 * Returns the value of the '<em><b>Identification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identification</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identification</em>' containment reference.
	 * @see #setIdentification(Identification)
	 * @see configurationemf.ConfigurationemfPackage#getMeta_Identification()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Identification getIdentification();

	/**
	 * Sets the value of the '{@link configurationemf.Meta#getIdentification <em>Identification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identification</em>' containment reference.
	 * @see #getIdentification()
	 * @generated
	 */
	void setIdentification(Identification value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' containment reference.
	 * @see #setOwner(Owner)
	 * @see configurationemf.ConfigurationemfPackage#getMeta_Owner()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Owner getOwner();

	/**
	 * Sets the value of the '{@link configurationemf.Meta#getOwner <em>Owner</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' containment reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Owner value);

	/**
	 * Returns the value of the '<em><b>Editor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Editor</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Editor</em>' containment reference.
	 * @see #setEditor(Editor)
	 * @see configurationemf.ConfigurationemfPackage#getMeta_Editor()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Editor getEditor();

	/**
	 * Sets the value of the '{@link configurationemf.Meta#getEditor <em>Editor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Editor</em>' containment reference.
	 * @see #getEditor()
	 * @generated
	 */
	void setEditor(Editor value);

	/**
	 * Returns the value of the '<em><b>Status</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' containment reference.
	 * @see #setStatus(Status)
	 * @see configurationemf.ConfigurationemfPackage#getMeta_Status()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Status getStatus();

	/**
	 * Sets the value of the '{@link configurationemf.Meta#getStatus <em>Status</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' containment reference.
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(Status value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' containment reference.
	 * @see #setVersion(Version)
	 * @see configurationemf.ConfigurationemfPackage#getMeta_Version()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Version getVersion();

	/**
	 * Sets the value of the '{@link configurationemf.Meta#getVersion <em>Version</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' containment reference.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(Version value);

	/**
	 * Returns the value of the '<em><b>Platform</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Platform</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Platform</em>' containment reference.
	 * @see #setPlatform(Platform)
	 * @see configurationemf.ConfigurationemfPackage#getMeta_Platform()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Platform getPlatform();

	/**
	 * Sets the value of the '{@link configurationemf.Meta#getPlatform <em>Platform</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Platform</em>' containment reference.
	 * @see #getPlatform()
	 * @generated
	 */
	void setPlatform(Platform value);

	/**
	 * Returns the value of the '<em><b>Product</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Product</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Product</em>' containment reference.
	 * @see #setProduct(Product)
	 * @see configurationemf.ConfigurationemfPackage#getMeta_Product()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Product getProduct();

	/**
	 * Sets the value of the '{@link configurationemf.Meta#getProduct <em>Product</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Product</em>' containment reference.
	 * @see #getProduct()
	 * @generated
	 */
	void setProduct(Product value);

	/**
	 * Returns the value of the '<em><b>Customer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Customer</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Customer</em>' containment reference.
	 * @see #setCustomer(Customer)
	 * @see configurationemf.ConfigurationemfPackage#getMeta_Customer()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Customer getCustomer();

	/**
	 * Sets the value of the '{@link configurationemf.Meta#getCustomer <em>Customer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Customer</em>' containment reference.
	 * @see #getCustomer()
	 * @generated
	 */
	void setCustomer(Customer value);

	/**
	 * Returns the value of the '<em><b>Date</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' containment reference.
	 * @see #setDate(Date)
	 * @see configurationemf.ConfigurationemfPackage#getMeta_Date()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link configurationemf.Meta#getDate <em>Date</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' containment reference.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

	/**
	 * Returns the value of the '<em><b>Release</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Release</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Release</em>' reference.
	 * @see #setRelease(Release)
	 * @see configurationemf.ConfigurationemfPackage#getMeta_Release()
	 * @model required="true"
	 * @generated
	 */
	Release getRelease();

	/**
	 * Sets the value of the '{@link configurationemf.Meta#getRelease <em>Release</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Release</em>' reference.
	 * @see #getRelease()
	 * @generated
	 */
	void setRelease(Release value);

} // Meta