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
package cenrep;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Meta</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cenrep.Meta#getIdentification <em>Identification</em>}</li>
 *   <li>{@link cenrep.Meta#getDate <em>Date</em>}</li>
 *   <li>{@link cenrep.Meta#getPlatform <em>Platform</em>}</li>
 *   <li>{@link cenrep.Meta#getOwner <em>Owner</em>}</li>
 *   <li>{@link cenrep.Meta#getEditor <em>Editor</em>}</li>
 *   <li>{@link cenrep.Meta#getStatus <em>Status</em>}</li>
 *   <li>{@link cenrep.Meta#getVersion <em>Version</em>}</li>
 *   <li>{@link cenrep.Meta#getProduct <em>Product</em>}</li>
 *   <li>{@link cenrep.Meta#getRelease <em>Release</em>}</li>
 * </ul>
 * </p>
 *
 * @see cenrep.CenrepPackage#getMeta()
 * @model
 * @generated
 */
public interface Meta extends CommonAttrs {
	/**
	 * Returns the value of the '<em><b>Identification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identification</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identification</em>' reference.
	 * @see #setIdentification(Identification)
	 * @see cenrep.CenrepPackage#getMeta_Identification()
	 * @model required="true"
	 * @generated
	 */
	Identification getIdentification();

	/**
	 * Sets the value of the '{@link cenrep.Meta#getIdentification <em>Identification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identification</em>' reference.
	 * @see #getIdentification()
	 * @generated
	 */
	void setIdentification(Identification value);

	/**
	 * Returns the value of the '<em><b>Date</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' reference.
	 * @see #setDate(Date)
	 * @see cenrep.CenrepPackage#getMeta_Date()
	 * @model required="true"
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link cenrep.Meta#getDate <em>Date</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' reference.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

	/**
	 * Returns the value of the '<em><b>Platform</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Platform</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Platform</em>' reference.
	 * @see #setPlatform(Platform)
	 * @see cenrep.CenrepPackage#getMeta_Platform()
	 * @model required="true"
	 * @generated
	 */
	Platform getPlatform();

	/**
	 * Sets the value of the '{@link cenrep.Meta#getPlatform <em>Platform</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Platform</em>' reference.
	 * @see #getPlatform()
	 * @generated
	 */
	void setPlatform(Platform value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' reference.
	 * @see #setOwner(Owner)
	 * @see cenrep.CenrepPackage#getMeta_Owner()
	 * @model required="true"
	 * @generated
	 */
	Owner getOwner();

	/**
	 * Sets the value of the '{@link cenrep.Meta#getOwner <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Owner value);

	/**
	 * Returns the value of the '<em><b>Editor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Editor</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Editor</em>' reference.
	 * @see #setEditor(Editor)
	 * @see cenrep.CenrepPackage#getMeta_Editor()
	 * @model required="true"
	 * @generated
	 */
	Editor getEditor();

	/**
	 * Sets the value of the '{@link cenrep.Meta#getEditor <em>Editor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Editor</em>' reference.
	 * @see #getEditor()
	 * @generated
	 */
	void setEditor(Editor value);

	/**
	 * Returns the value of the '<em><b>Status</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' reference.
	 * @see #setStatus(Status)
	 * @see cenrep.CenrepPackage#getMeta_Status()
	 * @model required="true"
	 * @generated
	 */
	Status getStatus();

	/**
	 * Sets the value of the '{@link cenrep.Meta#getStatus <em>Status</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' reference.
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(Status value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' reference.
	 * @see #setVersion(Version)
	 * @see cenrep.CenrepPackage#getMeta_Version()
	 * @model required="true"
	 * @generated
	 */
	Version getVersion();

	/**
	 * Sets the value of the '{@link cenrep.Meta#getVersion <em>Version</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' reference.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(Version value);

	/**
	 * Returns the value of the '<em><b>Product</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Product</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Product</em>' reference.
	 * @see #setProduct(Product)
	 * @see cenrep.CenrepPackage#getMeta_Product()
	 * @model required="true"
	 * @generated
	 */
	Product getProduct();

	/**
	 * Sets the value of the '{@link cenrep.Meta#getProduct <em>Product</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Product</em>' reference.
	 * @see #getProduct()
	 * @generated
	 */
	void setProduct(Product value);

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
	 * @see cenrep.CenrepPackage#getMeta_Release()
	 * @model required="true"
	 * @generated
	 */
	Release getRelease();

	/**
	 * Sets the value of the '{@link cenrep.Meta#getRelease <em>Release</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Release</em>' reference.
	 * @see #getRelease()
	 * @generated
	 */
	void setRelease(Release value);

} // Meta