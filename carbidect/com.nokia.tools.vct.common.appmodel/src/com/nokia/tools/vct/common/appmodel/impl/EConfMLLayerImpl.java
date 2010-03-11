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
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.nokia.tools.vct.common.appmodel.EAppFeature;
import com.nokia.tools.vct.common.appmodel.EAppIncludeElement;
import com.nokia.tools.vct.common.appmodel.EAppView;
import com.nokia.tools.vct.common.appmodel.EApplicationPackage;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EConf ML Layer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfMLLayerImpl#getDate <em>Date</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfMLLayerImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfMLLayerImpl#getEditor <em>Editor</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfMLLayerImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfMLLayerImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfMLLayerImpl#getPlatform <em>Platform</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfMLLayerImpl#getProduct <em>Product</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfMLLayerImpl#getRelease <em>Release</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfMLLayerImpl#getCustomer <em>Customer</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfMLLayerImpl#getOrigin <em>Origin</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfMLLayerImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfMLLayerImpl#getMetaId <em>Meta Id</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfMLLayerImpl#getConfigurationPropertyMap <em>Configuration Property Map</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfMLLayerImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfMLLayerImpl#getViews <em>Views</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfMLLayerImpl#getResourceMap <em>Resource Map</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfMLLayerImpl#getDocumentMap <em>Document Map</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfMLLayerImpl#getImplMap <em>Impl Map</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfMLLayerImpl#getLayerFiles <em>Layer Files</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfMLLayerImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfMLLayerImpl#getRootConfml <em>Root Confml</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfMLLayerImpl#getLayerURI <em>Layer URI</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfMLLayerImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EConfMLLayerImpl#getIncludes <em>Includes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EConfMLLayerImpl extends EObjectImpl implements EConfMLLayer {
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
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, EAppFeature> features;

	/**
	 * The cached value of the '{@link #getViews() <em>Views</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViews()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, EAppView> views;

	/**
	 * The cached value of the '{@link #getResourceMap() <em>Resource Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<URI, URI> resourceMap;

	/**
	 * The cached value of the '{@link #getDocumentMap() <em>Document Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocumentMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<URI, URI> documentMap;

	/**
	 * The cached value of the '{@link #getImplMap() <em>Impl Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<URI, URI> implMap;

	/**
	 * The cached value of the '{@link #getLayerFiles() <em>Layer Files</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayerFiles()
	 * @generated
	 * @ordered
	 */
	protected EList<URI> layerFiles;

	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected EConfMLLayer parent;

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
	 * The default value of the '{@link #getLayerURI() <em>Layer URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayerURI()
	 * @generated
	 * @ordered
	 */
	protected static final URI LAYER_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLayerURI() <em>Layer URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayerURI()
	 * @generated
	 * @ordered
	 */
	protected URI layerURI = LAYER_URI_EDEFAULT;

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
	 * The cached value of the '{@link #getIncludes() <em>Includes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncludes()
	 * @generated
	 * @ordered
	 */
	protected EList<EAppIncludeElement> includes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EConfMLLayerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EApplicationPackage.Literals.ECONF_ML_LAYER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.ECONF_ML_LAYER__DATE, oldDate, date));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.ECONF_ML_LAYER__OWNER, oldOwner, owner));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.ECONF_ML_LAYER__EDITOR, oldEditor, editor));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.ECONF_ML_LAYER__STATUS, oldStatus, status));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.ECONF_ML_LAYER__VERSION, oldVersion, version));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.ECONF_ML_LAYER__PLATFORM, oldPlatform, platform));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.ECONF_ML_LAYER__PRODUCT, oldProduct, product));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.ECONF_ML_LAYER__RELEASE, oldRelease, release));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.ECONF_ML_LAYER__CUSTOMER, oldCustomer, customer));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.ECONF_ML_LAYER__ORIGIN, oldOrigin, origin));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.ECONF_ML_LAYER__TARGET, oldTarget, target));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.ECONF_ML_LAYER__META_ID, oldMetaId, metaId));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.ECONF_ML_LAYER__CONFIGURATION_PROPERTY_MAP, oldConfigurationPropertyMap, configurationPropertyMap));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, EAppFeature> getFeatures() {
		if (features == null) {
			features = new EcoreEMap<String,EAppFeature>(EApplicationPackage.Literals.EAPP_FEATURE_ENTRY, EAppFeatureEntryImpl.class, this, EApplicationPackage.ECONF_ML_LAYER__FEATURES);
		}
		return features;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, EAppView> getViews() {
		if (views == null) {
			views = new EcoreEMap<String,EAppView>(EApplicationPackage.Literals.EAPP_VIEW_ENTRY, EAppViewEntryImpl.class, this, EApplicationPackage.ECONF_ML_LAYER__VIEWS);
		}
		return views;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<URI, URI> getResourceMap() {
		if (resourceMap == null) {
			resourceMap = new EcoreEMap<URI,URI>(EApplicationPackage.Literals.EAPP_RESOURCE_ENTRY, EAppResourceEntryImpl.class, this, EApplicationPackage.ECONF_ML_LAYER__RESOURCE_MAP);
		}
		return resourceMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<URI, URI> getDocumentMap() {
		if (documentMap == null) {
			documentMap = new EcoreEMap<URI,URI>(EApplicationPackage.Literals.EAPP_RESOURCE_ENTRY, EAppResourceEntryImpl.class, this, EApplicationPackage.ECONF_ML_LAYER__DOCUMENT_MAP);
		}
		return documentMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<URI, URI> getImplMap() {
		if (implMap == null) {
			implMap = new EcoreEMap<URI,URI>(EApplicationPackage.Literals.EAPP_RESOURCE_ENTRY, EAppResourceEntryImpl.class, this, EApplicationPackage.ECONF_ML_LAYER__IMPL_MAP);
		}
		return implMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<URI> getLayerFiles() {
		if (layerFiles == null) {
			layerFiles = new EDataTypeUniqueEList<URI>(URI.class, this, EApplicationPackage.ECONF_ML_LAYER__LAYER_FILES);
		}
		return layerFiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EConfMLLayer getParent() {
		if (parent != null && parent.eIsProxy()) {
			InternalEObject oldParent = (InternalEObject)parent;
			parent = (EConfMLLayer)eResolveProxy(oldParent);
			if (parent != oldParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EApplicationPackage.ECONF_ML_LAYER__PARENT, oldParent, parent));
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EConfMLLayer basicGetParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(EConfMLLayer newParent) {
		EConfMLLayer oldParent = parent;
		parent = newParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.ECONF_ML_LAYER__PARENT, oldParent, parent));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.ECONF_ML_LAYER__ROOT_CONFML, oldRootConfml, rootConfml));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URI getLayerURI() {
		return layerURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayerURI(URI newLayerURI) {
		URI oldLayerURI = layerURI;
		layerURI = newLayerURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.ECONF_ML_LAYER__LAYER_URI, oldLayerURI, layerURI));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.ECONF_ML_LAYER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EAppIncludeElement> getIncludes() {
		if (includes == null) {
			includes = new EObjectContainmentEList<EAppIncludeElement>(EAppIncludeElement.class, this, EApplicationPackage.ECONF_ML_LAYER__INCLUDES);
		}
		return includes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EApplicationPackage.ECONF_ML_LAYER__FEATURES:
				return ((InternalEList<?>)getFeatures()).basicRemove(otherEnd, msgs);
			case EApplicationPackage.ECONF_ML_LAYER__VIEWS:
				return ((InternalEList<?>)getViews()).basicRemove(otherEnd, msgs);
			case EApplicationPackage.ECONF_ML_LAYER__RESOURCE_MAP:
				return ((InternalEList<?>)getResourceMap()).basicRemove(otherEnd, msgs);
			case EApplicationPackage.ECONF_ML_LAYER__DOCUMENT_MAP:
				return ((InternalEList<?>)getDocumentMap()).basicRemove(otherEnd, msgs);
			case EApplicationPackage.ECONF_ML_LAYER__IMPL_MAP:
				return ((InternalEList<?>)getImplMap()).basicRemove(otherEnd, msgs);
			case EApplicationPackage.ECONF_ML_LAYER__INCLUDES:
				return ((InternalEList<?>)getIncludes()).basicRemove(otherEnd, msgs);
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
			case EApplicationPackage.ECONF_ML_LAYER__DATE:
				return getDate();
			case EApplicationPackage.ECONF_ML_LAYER__OWNER:
				return getOwner();
			case EApplicationPackage.ECONF_ML_LAYER__EDITOR:
				return getEditor();
			case EApplicationPackage.ECONF_ML_LAYER__STATUS:
				return getStatus();
			case EApplicationPackage.ECONF_ML_LAYER__VERSION:
				return getVersion();
			case EApplicationPackage.ECONF_ML_LAYER__PLATFORM:
				return getPlatform();
			case EApplicationPackage.ECONF_ML_LAYER__PRODUCT:
				return getProduct();
			case EApplicationPackage.ECONF_ML_LAYER__RELEASE:
				return getRelease();
			case EApplicationPackage.ECONF_ML_LAYER__CUSTOMER:
				return getCustomer();
			case EApplicationPackage.ECONF_ML_LAYER__ORIGIN:
				return getOrigin();
			case EApplicationPackage.ECONF_ML_LAYER__TARGET:
				return getTarget();
			case EApplicationPackage.ECONF_ML_LAYER__META_ID:
				return getMetaId();
			case EApplicationPackage.ECONF_ML_LAYER__CONFIGURATION_PROPERTY_MAP:
				return getConfigurationPropertyMap();
			case EApplicationPackage.ECONF_ML_LAYER__FEATURES:
				if (coreType) return getFeatures();
				else return getFeatures().map();
			case EApplicationPackage.ECONF_ML_LAYER__VIEWS:
				if (coreType) return getViews();
				else return getViews().map();
			case EApplicationPackage.ECONF_ML_LAYER__RESOURCE_MAP:
				if (coreType) return getResourceMap();
				else return getResourceMap().map();
			case EApplicationPackage.ECONF_ML_LAYER__DOCUMENT_MAP:
				if (coreType) return getDocumentMap();
				else return getDocumentMap().map();
			case EApplicationPackage.ECONF_ML_LAYER__IMPL_MAP:
				if (coreType) return getImplMap();
				else return getImplMap().map();
			case EApplicationPackage.ECONF_ML_LAYER__LAYER_FILES:
				return getLayerFiles();
			case EApplicationPackage.ECONF_ML_LAYER__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case EApplicationPackage.ECONF_ML_LAYER__ROOT_CONFML:
				return getRootConfml();
			case EApplicationPackage.ECONF_ML_LAYER__LAYER_URI:
				return getLayerURI();
			case EApplicationPackage.ECONF_ML_LAYER__NAME:
				return getName();
			case EApplicationPackage.ECONF_ML_LAYER__INCLUDES:
				return getIncludes();
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
			case EApplicationPackage.ECONF_ML_LAYER__DATE:
				setDate((String)newValue);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__OWNER:
				setOwner((String)newValue);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__EDITOR:
				setEditor((String)newValue);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__STATUS:
				setStatus((String)newValue);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__VERSION:
				setVersion((String)newValue);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__PLATFORM:
				setPlatform((String)newValue);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__PRODUCT:
				setProduct((String)newValue);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__RELEASE:
				setRelease((String)newValue);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__CUSTOMER:
				setCustomer((String)newValue);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__ORIGIN:
				setOrigin((String)newValue);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__TARGET:
				setTarget((String)newValue);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__META_ID:
				setMetaId((String)newValue);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__CONFIGURATION_PROPERTY_MAP:
				setConfigurationPropertyMap((Map<String, String>)newValue);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__FEATURES:
				((EStructuralFeature.Setting)getFeatures()).set(newValue);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__VIEWS:
				((EStructuralFeature.Setting)getViews()).set(newValue);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__RESOURCE_MAP:
				((EStructuralFeature.Setting)getResourceMap()).set(newValue);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__DOCUMENT_MAP:
				((EStructuralFeature.Setting)getDocumentMap()).set(newValue);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__IMPL_MAP:
				((EStructuralFeature.Setting)getImplMap()).set(newValue);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__LAYER_FILES:
				getLayerFiles().clear();
				getLayerFiles().addAll((Collection<? extends URI>)newValue);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__PARENT:
				setParent((EConfMLLayer)newValue);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__ROOT_CONFML:
				setRootConfml((URI)newValue);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__LAYER_URI:
				setLayerURI((URI)newValue);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__NAME:
				setName((String)newValue);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__INCLUDES:
				getIncludes().clear();
				getIncludes().addAll((Collection<? extends EAppIncludeElement>)newValue);
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
			case EApplicationPackage.ECONF_ML_LAYER__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__OWNER:
				setOwner(OWNER_EDEFAULT);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__EDITOR:
				setEditor(EDITOR_EDEFAULT);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__STATUS:
				setStatus(STATUS_EDEFAULT);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__PLATFORM:
				setPlatform(PLATFORM_EDEFAULT);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__PRODUCT:
				setProduct(PRODUCT_EDEFAULT);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__RELEASE:
				setRelease(RELEASE_EDEFAULT);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__CUSTOMER:
				setCustomer(CUSTOMER_EDEFAULT);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__ORIGIN:
				setOrigin(ORIGIN_EDEFAULT);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__TARGET:
				setTarget(TARGET_EDEFAULT);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__META_ID:
				setMetaId(META_ID_EDEFAULT);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__CONFIGURATION_PROPERTY_MAP:
				setConfigurationPropertyMap((Map<String, String>)null);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__FEATURES:
				getFeatures().clear();
				return;
			case EApplicationPackage.ECONF_ML_LAYER__VIEWS:
				getViews().clear();
				return;
			case EApplicationPackage.ECONF_ML_LAYER__RESOURCE_MAP:
				getResourceMap().clear();
				return;
			case EApplicationPackage.ECONF_ML_LAYER__DOCUMENT_MAP:
				getDocumentMap().clear();
				return;
			case EApplicationPackage.ECONF_ML_LAYER__IMPL_MAP:
				getImplMap().clear();
				return;
			case EApplicationPackage.ECONF_ML_LAYER__LAYER_FILES:
				getLayerFiles().clear();
				return;
			case EApplicationPackage.ECONF_ML_LAYER__PARENT:
				setParent((EConfMLLayer)null);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__ROOT_CONFML:
				setRootConfml(ROOT_CONFML_EDEFAULT);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__LAYER_URI:
				setLayerURI(LAYER_URI_EDEFAULT);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EApplicationPackage.ECONF_ML_LAYER__INCLUDES:
				getIncludes().clear();
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
			case EApplicationPackage.ECONF_ML_LAYER__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case EApplicationPackage.ECONF_ML_LAYER__OWNER:
				return OWNER_EDEFAULT == null ? owner != null : !OWNER_EDEFAULT.equals(owner);
			case EApplicationPackage.ECONF_ML_LAYER__EDITOR:
				return EDITOR_EDEFAULT == null ? editor != null : !EDITOR_EDEFAULT.equals(editor);
			case EApplicationPackage.ECONF_ML_LAYER__STATUS:
				return STATUS_EDEFAULT == null ? status != null : !STATUS_EDEFAULT.equals(status);
			case EApplicationPackage.ECONF_ML_LAYER__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case EApplicationPackage.ECONF_ML_LAYER__PLATFORM:
				return PLATFORM_EDEFAULT == null ? platform != null : !PLATFORM_EDEFAULT.equals(platform);
			case EApplicationPackage.ECONF_ML_LAYER__PRODUCT:
				return PRODUCT_EDEFAULT == null ? product != null : !PRODUCT_EDEFAULT.equals(product);
			case EApplicationPackage.ECONF_ML_LAYER__RELEASE:
				return RELEASE_EDEFAULT == null ? release != null : !RELEASE_EDEFAULT.equals(release);
			case EApplicationPackage.ECONF_ML_LAYER__CUSTOMER:
				return CUSTOMER_EDEFAULT == null ? customer != null : !CUSTOMER_EDEFAULT.equals(customer);
			case EApplicationPackage.ECONF_ML_LAYER__ORIGIN:
				return ORIGIN_EDEFAULT == null ? origin != null : !ORIGIN_EDEFAULT.equals(origin);
			case EApplicationPackage.ECONF_ML_LAYER__TARGET:
				return TARGET_EDEFAULT == null ? target != null : !TARGET_EDEFAULT.equals(target);
			case EApplicationPackage.ECONF_ML_LAYER__META_ID:
				return META_ID_EDEFAULT == null ? metaId != null : !META_ID_EDEFAULT.equals(metaId);
			case EApplicationPackage.ECONF_ML_LAYER__CONFIGURATION_PROPERTY_MAP:
				return configurationPropertyMap != null;
			case EApplicationPackage.ECONF_ML_LAYER__FEATURES:
				return features != null && !features.isEmpty();
			case EApplicationPackage.ECONF_ML_LAYER__VIEWS:
				return views != null && !views.isEmpty();
			case EApplicationPackage.ECONF_ML_LAYER__RESOURCE_MAP:
				return resourceMap != null && !resourceMap.isEmpty();
			case EApplicationPackage.ECONF_ML_LAYER__DOCUMENT_MAP:
				return documentMap != null && !documentMap.isEmpty();
			case EApplicationPackage.ECONF_ML_LAYER__IMPL_MAP:
				return implMap != null && !implMap.isEmpty();
			case EApplicationPackage.ECONF_ML_LAYER__LAYER_FILES:
				return layerFiles != null && !layerFiles.isEmpty();
			case EApplicationPackage.ECONF_ML_LAYER__PARENT:
				return parent != null;
			case EApplicationPackage.ECONF_ML_LAYER__ROOT_CONFML:
				return ROOT_CONFML_EDEFAULT == null ? rootConfml != null : !ROOT_CONFML_EDEFAULT.equals(rootConfml);
			case EApplicationPackage.ECONF_ML_LAYER__LAYER_URI:
				return LAYER_URI_EDEFAULT == null ? layerURI != null : !LAYER_URI_EDEFAULT.equals(layerURI);
			case EApplicationPackage.ECONF_ML_LAYER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EApplicationPackage.ECONF_ML_LAYER__INCLUDES:
				return includes != null && !includes.isEmpty();
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
		result.append(", layerFiles: ");
		result.append(layerFiles);
		result.append(", rootConfml: ");
		result.append(rootConfml);
		result.append(", layerURI: ");
		result.append(layerURI);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //EConfMLLayerImpl
