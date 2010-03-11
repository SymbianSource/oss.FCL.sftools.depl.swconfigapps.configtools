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

package com.nokia.tools.vct.common.appmodel.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.nokia.tools.vct.common.appmodel.EAppView;
import com.nokia.tools.vct.common.appmodel.EApplicationPackage;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;
import com.nokia.tools.vct.common.appmodel.EStorageClass;
import com.nokia.tools.vct.common.core.utils.ArrayUtils;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EConfiguration Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfigurationProjectImpl#getDate <em>Date</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfigurationProjectImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfigurationProjectImpl#getEditor <em>Editor</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfigurationProjectImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfigurationProjectImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfigurationProjectImpl#getPlatform <em>Platform</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfigurationProjectImpl#getProduct <em>Product</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfigurationProjectImpl#getRelease <em>Release</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfigurationProjectImpl#getCustomer <em>Customer</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfigurationProjectImpl#getOrigin <em>Origin</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfigurationProjectImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfigurationProjectImpl#getMetaId <em>Meta Id</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfigurationProjectImpl#getConfigurationPropertyMap <em>Configuration Property Map</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfigurationProjectImpl#getLayers <em>Layers</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfigurationProjectImpl#getLastLayer <em>Last Layer</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfigurationProjectImpl#getRootConfml <em>Root Confml</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfigurationProjectImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfigurationProjectImpl#getStorage <em>Storage</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfigurationProjectImpl#getConfVersion <em>Conf Version</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfigurationProjectImpl#getDefaultView <em>Default View</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfigurationProjectImpl#isSettingHidden <em>Setting Hidden</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EConfigurationProjectImpl extends EObjectImpl implements EConfigurationProject {
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
	 * The default value of the '{@link #getMetaId() <em>Meta Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaId()
	 * @generated
	 * @ordered
	 */
	protected static final String META_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMetaId() <em>Meta Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaId()
	 * @generated
	 * @ordered
	 */
	protected String metaId = META_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConfigurationPropertyMap() <em>Configuration Property Map</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigurationPropertyMap()
	 * @ordered
	 */
	protected Map<String, String> configurationPropertyMap;

	/**
	 * The cached value of the '{@link #getLayers() <em>Layers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayers()
	 * @generated
	 * @ordered
	 */
	protected EList<EConfMLLayer> layers;

	/**
	 * The default value of the '{@link #getRootConfml() <em>Root Confml</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootConfml()
	 * @generated
	 * @ordered
	 */
	protected static final URI ROOT_CONFML_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRootConfml() <em>Root Confml</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootConfml()
	 * @generated
	 * @ordered
	 */
	protected URI rootConfml = ROOT_CONFML_EDEFAULT;

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
	 * The default value of the '{@link #getStorage() <em>Storage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStorage()
	 * @generated
	 * @ordered
	 */
	protected static final EStorageClass STORAGE_EDEFAULT = EStorageClass.PROJECT;

	/**
	 * The cached value of the '{@link #getStorage() <em>Storage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStorage()
	 * @generated
	 * @ordered
	 */
	protected EStorageClass storage = STORAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getConfVersion() <em>Conf Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String CONF_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConfVersion() <em>Conf Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfVersion()
	 * @generated
	 * @ordered
	 */
	protected String confVersion = CONF_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #isSettingHidden() <em>Setting Hidden</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSettingHidden()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SETTING_HIDDEN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSettingHidden() <em>Setting Hidden</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSettingHidden()
	 * @generated
	 * @ordered
	 */
	protected boolean settingHidden = SETTING_HIDDEN_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EConfigurationProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EApplicationPackage.Literals.ECONFIGURATION_PROJECT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.ECONFIGURATION_PROJECT__DATE, oldDate, date));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.ECONFIGURATION_PROJECT__OWNER, oldOwner, owner));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.ECONFIGURATION_PROJECT__EDITOR, oldEditor, editor));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.ECONFIGURATION_PROJECT__STATUS, oldStatus, status));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.ECONFIGURATION_PROJECT__VERSION, oldVersion, version));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.ECONFIGURATION_PROJECT__PLATFORM, oldPlatform, platform));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.ECONFIGURATION_PROJECT__PRODUCT, oldProduct, product));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.ECONFIGURATION_PROJECT__RELEASE, oldRelease, release));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.ECONFIGURATION_PROJECT__CUSTOMER, oldCustomer, customer));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.ECONFIGURATION_PROJECT__ORIGIN, oldOrigin, origin));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.ECONFIGURATION_PROJECT__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMetaId() {
		return metaId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetaId(String newMetaId) {
		String oldMetaId = metaId;
		metaId = newMetaId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.ECONFIGURATION_PROJECT__META_ID, oldMetaId, metaId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Map<String, String> getConfigurationPropertyMap() {
		return configurationPropertyMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setConfigurationPropertyMap(Map<String, String> newConfigurationPropertyMap) {
		Map<?, ?> oldConfigurationPropertyMap = configurationPropertyMap;
		configurationPropertyMap = newConfigurationPropertyMap;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.ECONFIGURATION_PROJECT__CONFIGURATION_PROPERTY_MAP, oldConfigurationPropertyMap, configurationPropertyMap));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EConfMLLayer> getLayers() {
		if (layers == null) {
			layers = new EObjectContainmentEList<EConfMLLayer>(EConfMLLayer.class, this, EApplicationPackage.ECONFIGURATION_PROJECT__LAYERS);
		}
		return layers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EConfMLLayer getLastLayer() {
		if (layers == null || layers.isEmpty()) {
			return null;
		} else {
			return layers.get(layers.size() - 1);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URI getRootConfml() {
		return rootConfml;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRootConfml(URI newRootConfml) {
		URI oldRootConfml = rootConfml;
		rootConfml = newRootConfml;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.ECONFIGURATION_PROJECT__ROOT_CONFML, oldRootConfml, rootConfml));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.ECONFIGURATION_PROJECT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStorageClass getStorage() {
		return storage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStorage(EStorageClass newStorage) {
		EStorageClass oldStorage = storage;
		storage = newStorage == null ? STORAGE_EDEFAULT : newStorage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.ECONFIGURATION_PROJECT__STORAGE, oldStorage, storage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConfVersion() {
		return confVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfVersion(String newConfVersion) {
		String oldConfVersion = confVersion;
		confVersion = newConfVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.ECONFIGURATION_PROJECT__CONF_VERSION, oldConfVersion, confVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EAppView getDefaultView() {
		EConfMLLayer lastLayer = getLastLayer();
		if (lastLayer == null) {
			return null;
		}
		Map.Entry<String,EAppView> entry = ArrayUtils.getLast(lastLayer.getViews());
		return entry != null ? entry.getValue(): null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSettingHidden() {
		return settingHidden;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSettingHidden(boolean newSettingHidden) {
		boolean oldSettingHidden = settingHidden;
		settingHidden = newSettingHidden;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.ECONFIGURATION_PROJECT__SETTING_HIDDEN, oldSettingHidden, settingHidden));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EApplicationPackage.ECONFIGURATION_PROJECT__LAYERS:
				return ((InternalEList<?>)getLayers()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EApplicationPackage.ECONFIGURATION_PROJECT__DATE:
				return getDate();
			case EApplicationPackage.ECONFIGURATION_PROJECT__OWNER:
				return getOwner();
			case EApplicationPackage.ECONFIGURATION_PROJECT__EDITOR:
				return getEditor();
			case EApplicationPackage.ECONFIGURATION_PROJECT__STATUS:
				return getStatus();
			case EApplicationPackage.ECONFIGURATION_PROJECT__VERSION:
				return getVersion();
			case EApplicationPackage.ECONFIGURATION_PROJECT__PLATFORM:
				return getPlatform();
			case EApplicationPackage.ECONFIGURATION_PROJECT__PRODUCT:
				return getProduct();
			case EApplicationPackage.ECONFIGURATION_PROJECT__RELEASE:
				return getRelease();
			case EApplicationPackage.ECONFIGURATION_PROJECT__CUSTOMER:
				return getCustomer();
			case EApplicationPackage.ECONFIGURATION_PROJECT__ORIGIN:
				return getOrigin();
			case EApplicationPackage.ECONFIGURATION_PROJECT__TARGET:
				return getTarget();
			case EApplicationPackage.ECONFIGURATION_PROJECT__META_ID:
				return getMetaId();
			case EApplicationPackage.ECONFIGURATION_PROJECT__CONFIGURATION_PROPERTY_MAP:
				return getConfigurationPropertyMap();
			case EApplicationPackage.ECONFIGURATION_PROJECT__LAYERS:
				return getLayers();
			case EApplicationPackage.ECONFIGURATION_PROJECT__LAST_LAYER:
				return getLastLayer();
			case EApplicationPackage.ECONFIGURATION_PROJECT__ROOT_CONFML:
				return getRootConfml();
			case EApplicationPackage.ECONFIGURATION_PROJECT__NAME:
				return getName();
			case EApplicationPackage.ECONFIGURATION_PROJECT__STORAGE:
				return getStorage();
			case EApplicationPackage.ECONFIGURATION_PROJECT__CONF_VERSION:
				return getConfVersion();
			case EApplicationPackage.ECONFIGURATION_PROJECT__DEFAULT_VIEW:
				return getDefaultView();
			case EApplicationPackage.ECONFIGURATION_PROJECT__SETTING_HIDDEN:
				return isSettingHidden() ? Boolean.TRUE : Boolean.FALSE;
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EApplicationPackage.ECONFIGURATION_PROJECT__DATE:
				setDate((String)newValue);
				return;
			case EApplicationPackage.ECONFIGURATION_PROJECT__OWNER:
				setOwner((String)newValue);
				return;
			case EApplicationPackage.ECONFIGURATION_PROJECT__EDITOR:
				setEditor((String)newValue);
				return;
			case EApplicationPackage.ECONFIGURATION_PROJECT__STATUS:
				setStatus((String)newValue);
				return;
			case EApplicationPackage.ECONFIGURATION_PROJECT__VERSION:
				setVersion((String)newValue);
				return;
			case EApplicationPackage.ECONFIGURATION_PROJECT__PLATFORM:
				setPlatform((String)newValue);
				return;
			case EApplicationPackage.ECONFIGURATION_PROJECT__PRODUCT:
				setProduct((String)newValue);
				return;
			case EApplicationPackage.ECONFIGURATION_PROJECT__RELEASE:
				setRelease((String)newValue);
				return;
			case EApplicationPackage.ECONFIGURATION_PROJECT__CUSTOMER:
				setCustomer((String)newValue);
				return;
			case EApplicationPackage.ECONFIGURATION_PROJECT__ORIGIN:
				setOrigin((String)newValue);
				return;
			case EApplicationPackage.ECONFIGURATION_PROJECT__TARGET:
				setTarget((String)newValue);
				return;
			case EApplicationPackage.ECONFIGURATION_PROJECT__META_ID:
				setMetaId((String)newValue);
				return;
			case EApplicationPackage.ECONFIGURATION_PROJECT__CONFIGURATION_PROPERTY_MAP:
				setConfigurationPropertyMap((Map<String, String>)newValue);
				return;
			case EApplicationPackage.ECONFIGURATION_PROJECT__LAYERS:
				getLayers().clear();
				getLayers().addAll((Collection<? extends EConfMLLayer>)newValue);
				return;
			case EApplicationPackage.ECONFIGURATION_PROJECT__ROOT_CONFML:
				setRootConfml((URI)newValue);
				return;
			case EApplicationPackage.ECONFIGURATION_PROJECT__NAME:
				setName((String)newValue);
				return;
			case EApplicationPackage.ECONFIGURATION_PROJECT__STORAGE:
				setStorage((EStorageClass)newValue);
				return;
			case EApplicationPackage.ECONFIGURATION_PROJECT__CONF_VERSION:
				setConfVersion((String)newValue);
				return;
			case EApplicationPackage.ECONFIGURATION_PROJECT__SETTING_HIDDEN:
				setSettingHidden(((Boolean)newValue).booleanValue());
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
			case EApplicationPackage.ECONFIGURATION_PROJECT__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case EApplicationPackage.ECONFIGURATION_PROJECT__OWNER:
				setOwner(OWNER_EDEFAULT);
				return;
			case EApplicationPackage.ECONFIGURATION_PROJECT__EDITOR:
				setEditor(EDITOR_EDEFAULT);
				return;
			case EApplicationPackage.ECONFIGURATION_PROJECT__STATUS:
				setStatus(STATUS_EDEFAULT);
				return;
			case EApplicationPackage.ECONFIGURATION_PROJECT__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case EApplicationPackage.ECONFIGURATION_PROJECT__PLATFORM:
				setPlatform(PLATFORM_EDEFAULT);
				return;
			case EApplicationPackage.ECONFIGURATION_PROJECT__PRODUCT:
				setProduct(PRODUCT_EDEFAULT);
				return;
			case EApplicationPackage.ECONFIGURATION_PROJECT__RELEASE:
				setRelease(RELEASE_EDEFAULT);
				return;
			case EApplicationPackage.ECONFIGURATION_PROJECT__CUSTOMER:
				setCustomer(CUSTOMER_EDEFAULT);
				return;
			case EApplicationPackage.ECONFIGURATION_PROJECT__ORIGIN:
				setOrigin(ORIGIN_EDEFAULT);
				return;
			case EApplicationPackage.ECONFIGURATION_PROJECT__TARGET:
				setTarget(TARGET_EDEFAULT);
				return;
			case EApplicationPackage.ECONFIGURATION_PROJECT__META_ID:
				setMetaId(META_ID_EDEFAULT);
				return;
			case EApplicationPackage.ECONFIGURATION_PROJECT__CONFIGURATION_PROPERTY_MAP:
				setConfigurationPropertyMap((Map<String, String>)null);
				return;
			case EApplicationPackage.ECONFIGURATION_PROJECT__LAYERS:
				getLayers().clear();
				return;
			case EApplicationPackage.ECONFIGURATION_PROJECT__ROOT_CONFML:
				setRootConfml(ROOT_CONFML_EDEFAULT);
				return;
			case EApplicationPackage.ECONFIGURATION_PROJECT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EApplicationPackage.ECONFIGURATION_PROJECT__STORAGE:
				setStorage(STORAGE_EDEFAULT);
				return;
			case EApplicationPackage.ECONFIGURATION_PROJECT__CONF_VERSION:
				setConfVersion(CONF_VERSION_EDEFAULT);
				return;
			case EApplicationPackage.ECONFIGURATION_PROJECT__SETTING_HIDDEN:
				setSettingHidden(SETTING_HIDDEN_EDEFAULT);
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
			case EApplicationPackage.ECONFIGURATION_PROJECT__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case EApplicationPackage.ECONFIGURATION_PROJECT__OWNER:
				return OWNER_EDEFAULT == null ? owner != null : !OWNER_EDEFAULT.equals(owner);
			case EApplicationPackage.ECONFIGURATION_PROJECT__EDITOR:
				return EDITOR_EDEFAULT == null ? editor != null : !EDITOR_EDEFAULT.equals(editor);
			case EApplicationPackage.ECONFIGURATION_PROJECT__STATUS:
				return STATUS_EDEFAULT == null ? status != null : !STATUS_EDEFAULT.equals(status);
			case EApplicationPackage.ECONFIGURATION_PROJECT__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case EApplicationPackage.ECONFIGURATION_PROJECT__PLATFORM:
				return PLATFORM_EDEFAULT == null ? platform != null : !PLATFORM_EDEFAULT.equals(platform);
			case EApplicationPackage.ECONFIGURATION_PROJECT__PRODUCT:
				return PRODUCT_EDEFAULT == null ? product != null : !PRODUCT_EDEFAULT.equals(product);
			case EApplicationPackage.ECONFIGURATION_PROJECT__RELEASE:
				return RELEASE_EDEFAULT == null ? release != null : !RELEASE_EDEFAULT.equals(release);
			case EApplicationPackage.ECONFIGURATION_PROJECT__CUSTOMER:
				return CUSTOMER_EDEFAULT == null ? customer != null : !CUSTOMER_EDEFAULT.equals(customer);
			case EApplicationPackage.ECONFIGURATION_PROJECT__ORIGIN:
				return ORIGIN_EDEFAULT == null ? origin != null : !ORIGIN_EDEFAULT.equals(origin);
			case EApplicationPackage.ECONFIGURATION_PROJECT__TARGET:
				return TARGET_EDEFAULT == null ? target != null : !TARGET_EDEFAULT.equals(target);
			case EApplicationPackage.ECONFIGURATION_PROJECT__META_ID:
				return META_ID_EDEFAULT == null ? metaId != null : !META_ID_EDEFAULT.equals(metaId);
			case EApplicationPackage.ECONFIGURATION_PROJECT__CONFIGURATION_PROPERTY_MAP:
				return configurationPropertyMap != null;
			case EApplicationPackage.ECONFIGURATION_PROJECT__LAYERS:
				return layers != null && !layers.isEmpty();
			case EApplicationPackage.ECONFIGURATION_PROJECT__LAST_LAYER:
				return getLastLayer() != null;
			case EApplicationPackage.ECONFIGURATION_PROJECT__ROOT_CONFML:
				return ROOT_CONFML_EDEFAULT == null ? rootConfml != null : !ROOT_CONFML_EDEFAULT.equals(rootConfml);
			case EApplicationPackage.ECONFIGURATION_PROJECT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EApplicationPackage.ECONFIGURATION_PROJECT__STORAGE:
				return storage != STORAGE_EDEFAULT;
			case EApplicationPackage.ECONFIGURATION_PROJECT__CONF_VERSION:
				return CONF_VERSION_EDEFAULT == null ? confVersion != null : !CONF_VERSION_EDEFAULT.equals(confVersion);
			case EApplicationPackage.ECONFIGURATION_PROJECT__DEFAULT_VIEW:
				return getDefaultView() != null;
			case EApplicationPackage.ECONFIGURATION_PROJECT__SETTING_HIDDEN:
				return settingHidden != SETTING_HIDDEN_EDEFAULT;
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
		result.append(" (date: ");
		result.append(date);
		result.append(", owner: ");
		result.append(owner);
		result.append(", editor: ");
		result.append(editor);
		result.append(", status: ");
		result.append(status);
		result.append(", version: ");
		result.append(version);
		result.append(", platform: ");
		result.append(platform);
		result.append(", product: ");
		result.append(product);
		result.append(", release: ");
		result.append(release);
		result.append(", customer: ");
		result.append(customer);
		result.append(", origin: ");
		result.append(origin);
		result.append(", target: ");
		result.append(target);
		result.append(", metaId: ");
		result.append(metaId);
		result.append(", configurationPropertyMap: ");
		result.append(configurationPropertyMap);
		result.append(", rootConfml: ");
		result.append(rootConfml);
		result.append(", name: ");
		result.append(name);
		result.append(", storage: ");
		result.append(storage);
		result.append(", confVersion: ");
		result.append(confVersion);
		result.append(", settingHidden: ");
		result.append(settingHidden);
		result.append(')');
		return result.toString();
	}

} //EConfigurationProjectImpl
