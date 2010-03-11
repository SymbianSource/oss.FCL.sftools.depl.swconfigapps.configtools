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
 * Description: This file is part of com.nokia.tools.variant.editor component.
 */

package com.nokia.tools.variant.editor.cpfInfo.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.nokia.tools.variant.editor.cpfInfo.CPFInformation;
import com.nokia.tools.variant.editor.cpfInfo.CpfInfoPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CPF Information</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.editor.cpfInfo.impl.CPFInformationImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.cpfInfo.impl.CPFInformationImpl#getAuthor <em>Author</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.cpfInfo.impl.CPFInformationImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.cpfInfo.impl.CPFInformationImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.cpfInfo.impl.CPFInformationImpl#getPlatform <em>Platform</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.cpfInfo.impl.CPFInformationImpl#getDate <em>Date</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.cpfInfo.impl.CPFInformationImpl#getRelease <em>Release</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.cpfInfo.impl.CPFInformationImpl#getDataFile <em>Data File</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.cpfInfo.impl.CPFInformationImpl#getViewId <em>View Id</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.cpfInfo.impl.CPFInformationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.cpfInfo.impl.CPFInformationImpl#getProduct <em>Product</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.cpfInfo.impl.CPFInformationImpl#getCustomer <em>Customer</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.cpfInfo.impl.CPFInformationImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.cpfInfo.impl.CPFInformationImpl#getOrigin <em>Origin</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.cpfInfo.impl.CPFInformationImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.cpfInfo.impl.CPFInformationImpl#getRootConfMLPath <em>Root Conf ML Path</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.cpfInfo.impl.CPFInformationImpl#getLayerPopupInfoText <em>Layer Popup Info Text</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CPFInformationImpl extends EObjectImpl implements CPFInformation {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getAuthor() <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected static final String AUTHOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAuthor() <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected String author = AUTHOR_EDEFAULT;

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
	 * The default value of the '{@link #getDataFile() <em>Data File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataFile()
	 * @generated
	 * @ordered
	 */
	protected static final String DATA_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDataFile() <em>Data File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataFile()
	 * @generated
	 * @ordered
	 */
	protected String dataFile = DATA_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getViewId() <em>View Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewId()
	 * @generated
	 * @ordered
	 */
	protected static final String VIEW_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getViewId() <em>View Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewId()
	 * @generated
	 * @ordered
	 */
	protected String viewId = VIEW_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

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
	 * The default value of the '{@link #getCustomer() <em>Customer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomer()
	 * @generated
	 * @ordered
	 */
	protected static final String CUSTOMER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCustomer() <em>Customer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomer()
	 * @generated
	 * @ordered
	 */
	protected String customer = CUSTOMER_EDEFAULT;

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
	 * The default value of the '{@link #getOrigin() <em>Origin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrigin()
	 * @generated
	 * @ordered
	 */
	protected static final String ORIGIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOrigin() <em>Origin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrigin()
	 * @generated
	 * @ordered
	 */
	protected String origin = ORIGIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getTarget() <em>Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected String target = TARGET_EDEFAULT;

	/**
	 * The default value of the '{@link #getRootConfMLPath() <em>Root Conf ML Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootConfMLPath()
	 * @generated
	 * @ordered
	 */
	protected static final String ROOT_CONF_ML_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRootConfMLPath() <em>Root Conf ML Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootConfMLPath()
	 * @generated
	 * @ordered
	 */
	protected String rootConfMLPath = ROOT_CONF_ML_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getLayerPopupInfoText() <em>Layer Popup Info Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayerPopupInfoText()
	 * @generated
	 * @ordered
	 */
	protected static final String LAYER_POPUP_INFO_TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLayerPopupInfoText() <em>Layer Popup Info Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayerPopupInfoText()
	 * @generated
	 * @ordered
	 */
	protected String layerPopupInfoText = LAYER_POPUP_INFO_TEXT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CPFInformationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CpfInfoPackage.Literals.CPF_INFORMATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CpfInfoPackage.CPF_INFORMATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuthor(String newAuthor) {
		String oldAuthor = author;
		author = newAuthor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CpfInfoPackage.CPF_INFORMATION__AUTHOR, oldAuthor, author));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CpfInfoPackage.CPF_INFORMATION__OWNER, oldOwner, owner));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CpfInfoPackage.CPF_INFORMATION__VERSION, oldVersion, version));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CpfInfoPackage.CPF_INFORMATION__PLATFORM, oldPlatform, platform));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CpfInfoPackage.CPF_INFORMATION__DATE, oldDate, date));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CpfInfoPackage.CPF_INFORMATION__RELEASE, oldRelease, release));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDataFile() {
		return dataFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataFile(String newDataFile) {
		String oldDataFile = dataFile;
		dataFile = newDataFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CpfInfoPackage.CPF_INFORMATION__DATA_FILE, oldDataFile, dataFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getViewId() {
		return viewId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setViewId(String newViewId) {
		String oldViewId = viewId;
		viewId = newViewId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CpfInfoPackage.CPF_INFORMATION__VIEW_ID, oldViewId, viewId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CpfInfoPackage.CPF_INFORMATION__DESCRIPTION, oldDescription, description));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CpfInfoPackage.CPF_INFORMATION__PRODUCT, oldProduct, product));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCustomer() {
		return customer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCustomer(String newCustomer) {
		String oldCustomer = customer;
		customer = newCustomer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CpfInfoPackage.CPF_INFORMATION__CUSTOMER, oldCustomer, customer));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CpfInfoPackage.CPF_INFORMATION__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrigin(String newOrigin) {
		String oldOrigin = origin;
		origin = newOrigin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CpfInfoPackage.CPF_INFORMATION__ORIGIN, oldOrigin, origin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(String newTarget) {
		String oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CpfInfoPackage.CPF_INFORMATION__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRootConfMLPath() {
		return rootConfMLPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRootConfMLPath(String newRootConfMLPath) {
		String oldRootConfMLPath = rootConfMLPath;
		rootConfMLPath = newRootConfMLPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CpfInfoPackage.CPF_INFORMATION__ROOT_CONF_ML_PATH, oldRootConfMLPath, rootConfMLPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLayerPopupInfoText() {
		return layerPopupInfoText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayerPopupInfoText(String newLayerPopupInfoText) {
		String oldLayerPopupInfoText = layerPopupInfoText;
		layerPopupInfoText = newLayerPopupInfoText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CpfInfoPackage.CPF_INFORMATION__LAYER_POPUP_INFO_TEXT, oldLayerPopupInfoText, layerPopupInfoText));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CpfInfoPackage.CPF_INFORMATION__NAME:
				return getName();
			case CpfInfoPackage.CPF_INFORMATION__AUTHOR:
				return getAuthor();
			case CpfInfoPackage.CPF_INFORMATION__OWNER:
				return getOwner();
			case CpfInfoPackage.CPF_INFORMATION__VERSION:
				return getVersion();
			case CpfInfoPackage.CPF_INFORMATION__PLATFORM:
				return getPlatform();
			case CpfInfoPackage.CPF_INFORMATION__DATE:
				return getDate();
			case CpfInfoPackage.CPF_INFORMATION__RELEASE:
				return getRelease();
			case CpfInfoPackage.CPF_INFORMATION__DATA_FILE:
				return getDataFile();
			case CpfInfoPackage.CPF_INFORMATION__VIEW_ID:
				return getViewId();
			case CpfInfoPackage.CPF_INFORMATION__DESCRIPTION:
				return getDescription();
			case CpfInfoPackage.CPF_INFORMATION__PRODUCT:
				return getProduct();
			case CpfInfoPackage.CPF_INFORMATION__CUSTOMER:
				return getCustomer();
			case CpfInfoPackage.CPF_INFORMATION__STATUS:
				return getStatus();
			case CpfInfoPackage.CPF_INFORMATION__ORIGIN:
				return getOrigin();
			case CpfInfoPackage.CPF_INFORMATION__TARGET:
				return getTarget();
			case CpfInfoPackage.CPF_INFORMATION__ROOT_CONF_ML_PATH:
				return getRootConfMLPath();
			case CpfInfoPackage.CPF_INFORMATION__LAYER_POPUP_INFO_TEXT:
				return getLayerPopupInfoText();
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
			case CpfInfoPackage.CPF_INFORMATION__NAME:
				setName((String)newValue);
				return;
			case CpfInfoPackage.CPF_INFORMATION__AUTHOR:
				setAuthor((String)newValue);
				return;
			case CpfInfoPackage.CPF_INFORMATION__OWNER:
				setOwner((String)newValue);
				return;
			case CpfInfoPackage.CPF_INFORMATION__VERSION:
				setVersion((String)newValue);
				return;
			case CpfInfoPackage.CPF_INFORMATION__PLATFORM:
				setPlatform((String)newValue);
				return;
			case CpfInfoPackage.CPF_INFORMATION__DATE:
				setDate((String)newValue);
				return;
			case CpfInfoPackage.CPF_INFORMATION__RELEASE:
				setRelease((String)newValue);
				return;
			case CpfInfoPackage.CPF_INFORMATION__DATA_FILE:
				setDataFile((String)newValue);
				return;
			case CpfInfoPackage.CPF_INFORMATION__VIEW_ID:
				setViewId((String)newValue);
				return;
			case CpfInfoPackage.CPF_INFORMATION__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case CpfInfoPackage.CPF_INFORMATION__PRODUCT:
				setProduct((String)newValue);
				return;
			case CpfInfoPackage.CPF_INFORMATION__CUSTOMER:
				setCustomer((String)newValue);
				return;
			case CpfInfoPackage.CPF_INFORMATION__STATUS:
				setStatus((String)newValue);
				return;
			case CpfInfoPackage.CPF_INFORMATION__ORIGIN:
				setOrigin((String)newValue);
				return;
			case CpfInfoPackage.CPF_INFORMATION__TARGET:
				setTarget((String)newValue);
				return;
			case CpfInfoPackage.CPF_INFORMATION__ROOT_CONF_ML_PATH:
				setRootConfMLPath((String)newValue);
				return;
			case CpfInfoPackage.CPF_INFORMATION__LAYER_POPUP_INFO_TEXT:
				setLayerPopupInfoText((String)newValue);
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
			case CpfInfoPackage.CPF_INFORMATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CpfInfoPackage.CPF_INFORMATION__AUTHOR:
				setAuthor(AUTHOR_EDEFAULT);
				return;
			case CpfInfoPackage.CPF_INFORMATION__OWNER:
				setOwner(OWNER_EDEFAULT);
				return;
			case CpfInfoPackage.CPF_INFORMATION__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case CpfInfoPackage.CPF_INFORMATION__PLATFORM:
				setPlatform(PLATFORM_EDEFAULT);
				return;
			case CpfInfoPackage.CPF_INFORMATION__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case CpfInfoPackage.CPF_INFORMATION__RELEASE:
				setRelease(RELEASE_EDEFAULT);
				return;
			case CpfInfoPackage.CPF_INFORMATION__DATA_FILE:
				setDataFile(DATA_FILE_EDEFAULT);
				return;
			case CpfInfoPackage.CPF_INFORMATION__VIEW_ID:
				setViewId(VIEW_ID_EDEFAULT);
				return;
			case CpfInfoPackage.CPF_INFORMATION__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case CpfInfoPackage.CPF_INFORMATION__PRODUCT:
				setProduct(PRODUCT_EDEFAULT);
				return;
			case CpfInfoPackage.CPF_INFORMATION__CUSTOMER:
				setCustomer(CUSTOMER_EDEFAULT);
				return;
			case CpfInfoPackage.CPF_INFORMATION__STATUS:
				setStatus(STATUS_EDEFAULT);
				return;
			case CpfInfoPackage.CPF_INFORMATION__ORIGIN:
				setOrigin(ORIGIN_EDEFAULT);
				return;
			case CpfInfoPackage.CPF_INFORMATION__TARGET:
				setTarget(TARGET_EDEFAULT);
				return;
			case CpfInfoPackage.CPF_INFORMATION__ROOT_CONF_ML_PATH:
				setRootConfMLPath(ROOT_CONF_ML_PATH_EDEFAULT);
				return;
			case CpfInfoPackage.CPF_INFORMATION__LAYER_POPUP_INFO_TEXT:
				setLayerPopupInfoText(LAYER_POPUP_INFO_TEXT_EDEFAULT);
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
			case CpfInfoPackage.CPF_INFORMATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CpfInfoPackage.CPF_INFORMATION__AUTHOR:
				return AUTHOR_EDEFAULT == null ? author != null : !AUTHOR_EDEFAULT.equals(author);
			case CpfInfoPackage.CPF_INFORMATION__OWNER:
				return OWNER_EDEFAULT == null ? owner != null : !OWNER_EDEFAULT.equals(owner);
			case CpfInfoPackage.CPF_INFORMATION__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case CpfInfoPackage.CPF_INFORMATION__PLATFORM:
				return PLATFORM_EDEFAULT == null ? platform != null : !PLATFORM_EDEFAULT.equals(platform);
			case CpfInfoPackage.CPF_INFORMATION__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case CpfInfoPackage.CPF_INFORMATION__RELEASE:
				return RELEASE_EDEFAULT == null ? release != null : !RELEASE_EDEFAULT.equals(release);
			case CpfInfoPackage.CPF_INFORMATION__DATA_FILE:
				return DATA_FILE_EDEFAULT == null ? dataFile != null : !DATA_FILE_EDEFAULT.equals(dataFile);
			case CpfInfoPackage.CPF_INFORMATION__VIEW_ID:
				return VIEW_ID_EDEFAULT == null ? viewId != null : !VIEW_ID_EDEFAULT.equals(viewId);
			case CpfInfoPackage.CPF_INFORMATION__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case CpfInfoPackage.CPF_INFORMATION__PRODUCT:
				return PRODUCT_EDEFAULT == null ? product != null : !PRODUCT_EDEFAULT.equals(product);
			case CpfInfoPackage.CPF_INFORMATION__CUSTOMER:
				return CUSTOMER_EDEFAULT == null ? customer != null : !CUSTOMER_EDEFAULT.equals(customer);
			case CpfInfoPackage.CPF_INFORMATION__STATUS:
				return STATUS_EDEFAULT == null ? status != null : !STATUS_EDEFAULT.equals(status);
			case CpfInfoPackage.CPF_INFORMATION__ORIGIN:
				return ORIGIN_EDEFAULT == null ? origin != null : !ORIGIN_EDEFAULT.equals(origin);
			case CpfInfoPackage.CPF_INFORMATION__TARGET:
				return TARGET_EDEFAULT == null ? target != null : !TARGET_EDEFAULT.equals(target);
			case CpfInfoPackage.CPF_INFORMATION__ROOT_CONF_ML_PATH:
				return ROOT_CONF_ML_PATH_EDEFAULT == null ? rootConfMLPath != null : !ROOT_CONF_ML_PATH_EDEFAULT.equals(rootConfMLPath);
			case CpfInfoPackage.CPF_INFORMATION__LAYER_POPUP_INFO_TEXT:
				return LAYER_POPUP_INFO_TEXT_EDEFAULT == null ? layerPopupInfoText != null : !LAYER_POPUP_INFO_TEXT_EDEFAULT.equals(layerPopupInfoText);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", author: ");
		result.append(author);
		result.append(", owner: ");
		result.append(owner);
		result.append(", version: ");
		result.append(version);
		result.append(", platform: ");
		result.append(platform);
		result.append(", date: ");
		result.append(date);
		result.append(", release: ");
		result.append(release);
		result.append(", dataFile: ");
		result.append(dataFile);
		result.append(", viewId: ");
		result.append(viewId);
		result.append(", description: ");
		result.append(description);
		result.append(", product: ");
		result.append(product);
		result.append(", customer: ");
		result.append(customer);
		result.append(", status: ");
		result.append(status);
		result.append(", origin: ");
		result.append(origin);
		result.append(", target: ");
		result.append(target);
		result.append(", rootConfMLPath: ");
		result.append(rootConfMLPath);
		result.append(", layerPopupInfoText: ");
		result.append(layerPopupInfoText);
		result.append(')');
		return result.toString();
	}

} //CPFInformationImpl
