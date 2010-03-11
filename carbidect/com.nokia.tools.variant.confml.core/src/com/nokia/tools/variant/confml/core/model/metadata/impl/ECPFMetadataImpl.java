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

package com.nokia.tools.variant.confml.core.model.metadata.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata;
import com.nokia.tools.variant.confml.core.model.metadata.EMetadataPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ECPF Metadata</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.metadata.impl.ECPFMetadataImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.metadata.impl.ECPFMetadataImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.metadata.impl.ECPFMetadataImpl#getViewId <em>View Id</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.metadata.impl.ECPFMetadataImpl#getCpfRootFile <em>Cpf Root File</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.metadata.impl.ECPFMetadataImpl#getAuthor <em>Author</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.metadata.impl.ECPFMetadataImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.metadata.impl.ECPFMetadataImpl#getDataOverrideFile <em>Data Override File</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.metadata.impl.ECPFMetadataImpl#getProduct <em>Product</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.metadata.impl.ECPFMetadataImpl#getPlatform <em>Platform</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.metadata.impl.ECPFMetadataImpl#getRelease <em>Release</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.metadata.impl.ECPFMetadataImpl#getCustomer <em>Customer</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.metadata.impl.ECPFMetadataImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.metadata.impl.ECPFMetadataImpl#getDate <em>Date</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ECPFMetadataImpl extends EObjectImpl implements ECPFMetadata {
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
	 * The default value of the '{@link #getCpfRootFile() <em>Cpf Root File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpfRootFile()
	 * @generated
	 * @ordered
	 */
	protected static final String CPF_ROOT_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCpfRootFile() <em>Cpf Root File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpfRootFile()
	 * @generated
	 * @ordered
	 */
	protected String cpfRootFile = CPF_ROOT_FILE_EDEFAULT;

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
	 * The default value of the '{@link #getDataOverrideFile() <em>Data Override File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataOverrideFile()
	 * @generated
	 * @ordered
	 */
	protected static final String DATA_OVERRIDE_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDataOverrideFile() <em>Data Override File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataOverrideFile()
	 * @generated
	 * @ordered
	 */
	protected String dataOverrideFile = DATA_OVERRIDE_FILE_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ECPFMetadataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EMetadataPackage.Literals.ECPF_METADATA;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EMetadataPackage.ECPF_METADATA__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EMetadataPackage.ECPF_METADATA__DESCRIPTION, oldDescription, description));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EMetadataPackage.ECPF_METADATA__VIEW_ID, oldViewId, viewId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCpfRootFile() {
		return cpfRootFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCpfRootFile(String newCpfRootFile) {
		String oldCpfRootFile = cpfRootFile;
		cpfRootFile = newCpfRootFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EMetadataPackage.ECPF_METADATA__CPF_ROOT_FILE, oldCpfRootFile, cpfRootFile));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EMetadataPackage.ECPF_METADATA__AUTHOR, oldAuthor, author));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EMetadataPackage.ECPF_METADATA__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDataOverrideFile() {
		return dataOverrideFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataOverrideFile(String newDataOverrideFile) {
		String oldDataOverrideFile = dataOverrideFile;
		dataOverrideFile = newDataOverrideFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EMetadataPackage.ECPF_METADATA__DATA_OVERRIDE_FILE, oldDataOverrideFile, dataOverrideFile));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EMetadataPackage.ECPF_METADATA__PRODUCT, oldProduct, product));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EMetadataPackage.ECPF_METADATA__PLATFORM, oldPlatform, platform));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EMetadataPackage.ECPF_METADATA__RELEASE, oldRelease, release));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EMetadataPackage.ECPF_METADATA__CUSTOMER, oldCustomer, customer));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EMetadataPackage.ECPF_METADATA__OWNER, oldOwner, owner));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EMetadataPackage.ECPF_METADATA__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EMetadataPackage.ECPF_METADATA__NAME:
				return getName();
			case EMetadataPackage.ECPF_METADATA__DESCRIPTION:
				return getDescription();
			case EMetadataPackage.ECPF_METADATA__VIEW_ID:
				return getViewId();
			case EMetadataPackage.ECPF_METADATA__CPF_ROOT_FILE:
				return getCpfRootFile();
			case EMetadataPackage.ECPF_METADATA__AUTHOR:
				return getAuthor();
			case EMetadataPackage.ECPF_METADATA__VERSION:
				return getVersion();
			case EMetadataPackage.ECPF_METADATA__DATA_OVERRIDE_FILE:
				return getDataOverrideFile();
			case EMetadataPackage.ECPF_METADATA__PRODUCT:
				return getProduct();
			case EMetadataPackage.ECPF_METADATA__PLATFORM:
				return getPlatform();
			case EMetadataPackage.ECPF_METADATA__RELEASE:
				return getRelease();
			case EMetadataPackage.ECPF_METADATA__CUSTOMER:
				return getCustomer();
			case EMetadataPackage.ECPF_METADATA__OWNER:
				return getOwner();
			case EMetadataPackage.ECPF_METADATA__DATE:
				return getDate();
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
			case EMetadataPackage.ECPF_METADATA__NAME:
				setName((String)newValue);
				return;
			case EMetadataPackage.ECPF_METADATA__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case EMetadataPackage.ECPF_METADATA__VIEW_ID:
				setViewId((String)newValue);
				return;
			case EMetadataPackage.ECPF_METADATA__CPF_ROOT_FILE:
				setCpfRootFile((String)newValue);
				return;
			case EMetadataPackage.ECPF_METADATA__AUTHOR:
				setAuthor((String)newValue);
				return;
			case EMetadataPackage.ECPF_METADATA__VERSION:
				setVersion((String)newValue);
				return;
			case EMetadataPackage.ECPF_METADATA__DATA_OVERRIDE_FILE:
				setDataOverrideFile((String)newValue);
				return;
			case EMetadataPackage.ECPF_METADATA__PRODUCT:
				setProduct((String)newValue);
				return;
			case EMetadataPackage.ECPF_METADATA__PLATFORM:
				setPlatform((String)newValue);
				return;
			case EMetadataPackage.ECPF_METADATA__RELEASE:
				setRelease((String)newValue);
				return;
			case EMetadataPackage.ECPF_METADATA__CUSTOMER:
				setCustomer((String)newValue);
				return;
			case EMetadataPackage.ECPF_METADATA__OWNER:
				setOwner((String)newValue);
				return;
			case EMetadataPackage.ECPF_METADATA__DATE:
				setDate((String)newValue);
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
			case EMetadataPackage.ECPF_METADATA__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EMetadataPackage.ECPF_METADATA__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case EMetadataPackage.ECPF_METADATA__VIEW_ID:
				setViewId(VIEW_ID_EDEFAULT);
				return;
			case EMetadataPackage.ECPF_METADATA__CPF_ROOT_FILE:
				setCpfRootFile(CPF_ROOT_FILE_EDEFAULT);
				return;
			case EMetadataPackage.ECPF_METADATA__AUTHOR:
				setAuthor(AUTHOR_EDEFAULT);
				return;
			case EMetadataPackage.ECPF_METADATA__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case EMetadataPackage.ECPF_METADATA__DATA_OVERRIDE_FILE:
				setDataOverrideFile(DATA_OVERRIDE_FILE_EDEFAULT);
				return;
			case EMetadataPackage.ECPF_METADATA__PRODUCT:
				setProduct(PRODUCT_EDEFAULT);
				return;
			case EMetadataPackage.ECPF_METADATA__PLATFORM:
				setPlatform(PLATFORM_EDEFAULT);
				return;
			case EMetadataPackage.ECPF_METADATA__RELEASE:
				setRelease(RELEASE_EDEFAULT);
				return;
			case EMetadataPackage.ECPF_METADATA__CUSTOMER:
				setCustomer(CUSTOMER_EDEFAULT);
				return;
			case EMetadataPackage.ECPF_METADATA__OWNER:
				setOwner(OWNER_EDEFAULT);
				return;
			case EMetadataPackage.ECPF_METADATA__DATE:
				setDate(DATE_EDEFAULT);
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
			case EMetadataPackage.ECPF_METADATA__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EMetadataPackage.ECPF_METADATA__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case EMetadataPackage.ECPF_METADATA__VIEW_ID:
				return VIEW_ID_EDEFAULT == null ? viewId != null : !VIEW_ID_EDEFAULT.equals(viewId);
			case EMetadataPackage.ECPF_METADATA__CPF_ROOT_FILE:
				return CPF_ROOT_FILE_EDEFAULT == null ? cpfRootFile != null : !CPF_ROOT_FILE_EDEFAULT.equals(cpfRootFile);
			case EMetadataPackage.ECPF_METADATA__AUTHOR:
				return AUTHOR_EDEFAULT == null ? author != null : !AUTHOR_EDEFAULT.equals(author);
			case EMetadataPackage.ECPF_METADATA__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case EMetadataPackage.ECPF_METADATA__DATA_OVERRIDE_FILE:
				return DATA_OVERRIDE_FILE_EDEFAULT == null ? dataOverrideFile != null : !DATA_OVERRIDE_FILE_EDEFAULT.equals(dataOverrideFile);
			case EMetadataPackage.ECPF_METADATA__PRODUCT:
				return PRODUCT_EDEFAULT == null ? product != null : !PRODUCT_EDEFAULT.equals(product);
			case EMetadataPackage.ECPF_METADATA__PLATFORM:
				return PLATFORM_EDEFAULT == null ? platform != null : !PLATFORM_EDEFAULT.equals(platform);
			case EMetadataPackage.ECPF_METADATA__RELEASE:
				return RELEASE_EDEFAULT == null ? release != null : !RELEASE_EDEFAULT.equals(release);
			case EMetadataPackage.ECPF_METADATA__CUSTOMER:
				return CUSTOMER_EDEFAULT == null ? customer != null : !CUSTOMER_EDEFAULT.equals(customer);
			case EMetadataPackage.ECPF_METADATA__OWNER:
				return OWNER_EDEFAULT == null ? owner != null : !OWNER_EDEFAULT.equals(owner);
			case EMetadataPackage.ECPF_METADATA__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
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
		result.append(", description: ");
		result.append(description);
		result.append(", viewId: ");
		result.append(viewId);
		result.append(", cpfRootFile: ");
		result.append(cpfRootFile);
		result.append(", author: ");
		result.append(author);
		result.append(", version: ");
		result.append(version);
		result.append(", dataOverrideFile: ");
		result.append(dataOverrideFile);
		result.append(", product: ");
		result.append(product);
		result.append(", platform: ");
		result.append(platform);
		result.append(", release: ");
		result.append(release);
		result.append(", customer: ");
		result.append(customer);
		result.append(", owner: ");
		result.append(owner);
		result.append(", date: ");
		result.append(date);
		result.append(')');
		return result.toString();
	}

} //ECPFMetadataImpl
