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

package com.nokia.tools.vct.crml.crmodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.nokia.tools.vct.crml.crmodel.ECRMLPackage;
import com.nokia.tools.vct.crml.crmodel.EMeta;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EMeta</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.EMetaImpl#getIdentification <em>Identification</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.EMetaImpl#getDate <em>Date</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.EMetaImpl#getPlatform <em>Platform</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.EMetaImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.EMetaImpl#getEditor <em>Editor</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.EMetaImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.EMetaImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.EMetaImpl#getProduct <em>Product</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.EMetaImpl#getRelease <em>Release</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EMetaImpl extends CommonAttrsImpl implements EMeta {
	/**
	 * The default value of the '{@link #getIdentification() <em>Identification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentification()
	 * @generated
	 * @ordered
	 */
	protected static final String IDENTIFICATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdentification() <em>Identification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentification()
	 * @generated
	 * @ordered
	 */
	protected String identification = IDENTIFICATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final String DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected String date = DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPlatform() <em>Platform</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlatform()
	 * @generated
	 * @ordered
	 */
	protected static final String PLATFORM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPlatform() <em>Platform</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlatform()
	 * @generated
	 * @ordered
	 */
	protected String platform = PLATFORM_EDEFAULT;

	/**
	 * The default value of the '{@link #getOwner() <em>Owner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwner()
	 * @generated
	 * @ordered
	 */
	protected static final String OWNER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOwner() <em>Owner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwner()
	 * @generated
	 * @ordered
	 */
	protected String owner = OWNER_EDEFAULT;

	/**
	 * The default value of the '{@link #getEditor() <em>Editor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditor()
	 * @generated
	 * @ordered
	 */
	protected static final String EDITOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEditor() <em>Editor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditor()
	 * @generated
	 * @ordered
	 */
	protected String editor = EDITOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final String STATUS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected String status = STATUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getProduct() <em>Product</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProduct()
	 * @generated
	 * @ordered
	 */
	protected static final String PRODUCT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProduct() <em>Product</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProduct()
	 * @generated
	 * @ordered
	 */
	protected String product = PRODUCT_EDEFAULT;

	/**
	 * The default value of the '{@link #getRelease() <em>Release</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelease()
	 * @generated
	 * @ordered
	 */
	protected static final String RELEASE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRelease() <em>Release</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelease()
	 * @generated
	 * @ordered
	 */
	protected String release = RELEASE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMetaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ECRMLPackage.Literals.EMETA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdentification() {
		return identification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentification(String newIdentification) {
		String oldIdentification = identification;
		identification = newIdentification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECRMLPackage.EMETA__IDENTIFICATION, oldIdentification, identification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(String newDate) {
		String oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECRMLPackage.EMETA__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPlatform() {
		return platform;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlatform(String newPlatform) {
		String oldPlatform = platform;
		platform = newPlatform;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECRMLPackage.EMETA__PLATFORM, oldPlatform, platform));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(String newOwner) {
		String oldOwner = owner;
		owner = newOwner;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECRMLPackage.EMETA__OWNER, oldOwner, owner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEditor() {
		return editor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEditor(String newEditor) {
		String oldEditor = editor;
		editor = newEditor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECRMLPackage.EMETA__EDITOR, oldEditor, editor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(String newStatus) {
		String oldStatus = status;
		status = newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECRMLPackage.EMETA__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECRMLPackage.EMETA__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProduct() {
		return product;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProduct(String newProduct) {
		String oldProduct = product;
		product = newProduct;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECRMLPackage.EMETA__PRODUCT, oldProduct, product));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRelease() {
		return release;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelease(String newRelease) {
		String oldRelease = release;
		release = newRelease;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECRMLPackage.EMETA__RELEASE, oldRelease, release));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ECRMLPackage.EMETA__IDENTIFICATION:
				return getIdentification();
			case ECRMLPackage.EMETA__DATE:
				return getDate();
			case ECRMLPackage.EMETA__PLATFORM:
				return getPlatform();
			case ECRMLPackage.EMETA__OWNER:
				return getOwner();
			case ECRMLPackage.EMETA__EDITOR:
				return getEditor();
			case ECRMLPackage.EMETA__STATUS:
				return getStatus();
			case ECRMLPackage.EMETA__VERSION:
				return getVersion();
			case ECRMLPackage.EMETA__PRODUCT:
				return getProduct();
			case ECRMLPackage.EMETA__RELEASE:
				return getRelease();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ECRMLPackage.EMETA__IDENTIFICATION:
				setIdentification((String)newValue);
				return;
			case ECRMLPackage.EMETA__DATE:
				setDate((String)newValue);
				return;
			case ECRMLPackage.EMETA__PLATFORM:
				setPlatform((String)newValue);
				return;
			case ECRMLPackage.EMETA__OWNER:
				setOwner((String)newValue);
				return;
			case ECRMLPackage.EMETA__EDITOR:
				setEditor((String)newValue);
				return;
			case ECRMLPackage.EMETA__STATUS:
				setStatus((String)newValue);
				return;
			case ECRMLPackage.EMETA__VERSION:
				setVersion((String)newValue);
				return;
			case ECRMLPackage.EMETA__PRODUCT:
				setProduct((String)newValue);
				return;
			case ECRMLPackage.EMETA__RELEASE:
				setRelease((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ECRMLPackage.EMETA__IDENTIFICATION:
				setIdentification(IDENTIFICATION_EDEFAULT);
				return;
			case ECRMLPackage.EMETA__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case ECRMLPackage.EMETA__PLATFORM:
				setPlatform(PLATFORM_EDEFAULT);
				return;
			case ECRMLPackage.EMETA__OWNER:
				setOwner(OWNER_EDEFAULT);
				return;
			case ECRMLPackage.EMETA__EDITOR:
				setEditor(EDITOR_EDEFAULT);
				return;
			case ECRMLPackage.EMETA__STATUS:
				setStatus(STATUS_EDEFAULT);
				return;
			case ECRMLPackage.EMETA__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case ECRMLPackage.EMETA__PRODUCT:
				setProduct(PRODUCT_EDEFAULT);
				return;
			case ECRMLPackage.EMETA__RELEASE:
				setRelease(RELEASE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ECRMLPackage.EMETA__IDENTIFICATION:
				return IDENTIFICATION_EDEFAULT == null ? identification != null : !IDENTIFICATION_EDEFAULT.equals(identification);
			case ECRMLPackage.EMETA__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case ECRMLPackage.EMETA__PLATFORM:
				return PLATFORM_EDEFAULT == null ? platform != null : !PLATFORM_EDEFAULT.equals(platform);
			case ECRMLPackage.EMETA__OWNER:
				return OWNER_EDEFAULT == null ? owner != null : !OWNER_EDEFAULT.equals(owner);
			case ECRMLPackage.EMETA__EDITOR:
				return EDITOR_EDEFAULT == null ? editor != null : !EDITOR_EDEFAULT.equals(editor);
			case ECRMLPackage.EMETA__STATUS:
				return STATUS_EDEFAULT == null ? status != null : !STATUS_EDEFAULT.equals(status);
			case ECRMLPackage.EMETA__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case ECRMLPackage.EMETA__PRODUCT:
				return PRODUCT_EDEFAULT == null ? product != null : !PRODUCT_EDEFAULT.equals(product);
			case ECRMLPackage.EMETA__RELEASE:
				return RELEASE_EDEFAULT == null ? release != null : !RELEASE_EDEFAULT.equals(release);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (identification: ");
		result.append(identification);
		result.append(", date: ");
		result.append(date);
		result.append(", platform: ");
		result.append(platform);
		result.append(", owner: ");
		result.append(owner);
		result.append(", editor: ");
		result.append(editor);
		result.append(", status: ");
		result.append(status);
		result.append(", version: ");
		result.append(version);
		result.append(", product: ");
		result.append(product);
		result.append(", release: ");
		result.append(release);
		result.append(')');
		return result.toString();
	}

} //EMetaImpl
