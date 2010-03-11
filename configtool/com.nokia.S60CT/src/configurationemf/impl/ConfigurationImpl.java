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
package configurationemf.impl;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import configurationemf.Configuration;
import configurationemf.ConfigurationemfFactory;
import configurationemf.ConfigurationemfPackage;
import configurationemf.Data;
import configurationemf.Feature;
import configurationemf.Icon;
import configurationemf.Link;
import configurationemf.Meta;
import configurationemf.Setting;
import configurationemf.View;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link configurationemf.impl.ConfigurationImpl#getName <em>Name</em>}</li>
 *   <li>{@link configurationemf.impl.ConfigurationImpl#getVers <em>Vers</em>}</li>
 *   <li>{@link configurationemf.impl.ConfigurationImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link configurationemf.impl.ConfigurationImpl#getView <em>View</em>}</li>
 *   <li>{@link configurationemf.impl.ConfigurationImpl#getMeta <em>Meta</em>}</li>
 *   <li>{@link configurationemf.impl.ConfigurationImpl#getIcon <em>Icon</em>}</li>
 *   <li>{@link configurationemf.impl.ConfigurationImpl#getLink <em>Link</em>}</li>
 *   <li>{@link configurationemf.impl.ConfigurationImpl#getData <em>Data</em>}</li>
 *   <li>{@link configurationemf.impl.ConfigurationImpl#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link configurationemf.impl.ConfigurationImpl#getMetaId <em>Meta Id</em>}</li>
 *   <li>{@link configurationemf.impl.ConfigurationImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link configurationemf.impl.ConfigurationImpl#getEditor <em>Editor</em>}</li>
 *   <li>{@link configurationemf.impl.ConfigurationImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link configurationemf.impl.ConfigurationImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link configurationemf.impl.ConfigurationImpl#getPlatform <em>Platform</em>}</li>
 *   <li>{@link configurationemf.impl.ConfigurationImpl#getProduct <em>Product</em>}</li>
 *   <li>{@link configurationemf.impl.ConfigurationImpl#getCustomer <em>Customer</em>}</li>
 *   <li>{@link configurationemf.impl.ConfigurationImpl#getDate <em>Date</em>}</li>
 *   <li>{@link configurationemf.impl.ConfigurationImpl#getRelease <em>Release</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ConfigurationImpl extends AttributeAndDescImpl implements Configuration {
	
	
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
	 * The default value of the '{@link #getVers() <em>Vers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVers()
	 * @generated
	 * @ordered
	 */
	protected static final String VERS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVers() <em>Vers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVers()
	 * @generated
	 * @ordered
	 */
	protected String vers = VERS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFeature() <em>Feature</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeature()
	 * @generated
	 * @ordered
	 */
	protected EList<Feature> feature;

	/**
	 * The cached value of the '{@link #getView() <em>View</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getView()
	 * @generated
	 * @ordered
	 */
	protected EList<View> view;

	/**
	 * The cached value of the '{@link #getMeta() <em>Meta</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeta()
	 * @generated
	 * @ordered
	 */
	protected Meta meta;

	/**
	 * The cached value of the '{@link #getIcon() <em>Icon</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon()
	 * @generated
	 * @ordered
	 */
	protected EList<Icon> icon;

	/**
	 * The cached value of the '{@link #getLink() <em>Link</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink()
	 * @generated
	 * @ordered
	 */
	protected EList<Link> link;

	/**
	 * The cached value of the '{@link #getData() <em>Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected Data data;

	/**
	 * The default value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReadOnly()
	 * @generated
	 * @ordered
	 */
	protected static final boolean READ_ONLY_EDEFAULT = false;

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
	 * The default value of the '{@link #getOwner() <em>Owner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwner()
	 * @generated
	 * @ordered
	 */
	protected static final String OWNER_EDEFAULT = null;

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
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final String STATUS_EDEFAULT = null;

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
	 * The default value of the '{@link #getPlatform() <em>Platform</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlatform()
	 * @generated
	 * @ordered
	 */
	protected static final String PLATFORM_EDEFAULT = null;

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
	 * The default value of the '{@link #getCustomer() <em>Customer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomer()
	 * @generated
	 * @ordered
	 */
	protected static final String CUSTOMER_EDEFAULT = null;

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
	 * The default value of the '{@link #getRelease() <em>Release</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelease()
	 * @generated
	 * @ordered
	 */
	protected static final String RELEASE_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationemfPackage.Literals.CONFIGURATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.CONFIGURATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVers() {
		return vers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVers(String newVers) {
		String oldVers = vers;
		vers = newVers;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.CONFIGURATION__VERS, oldVers, vers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Feature> getFeature() {
		if (feature == null) {
			feature = new EObjectContainmentWithInverseEList<Feature>(Feature.class, this, ConfigurationemfPackage.CONFIGURATION__FEATURE, ConfigurationemfPackage.FEATURE__CONF);
		}
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<View> getView() {
		if (view == null) {
			view = new EObjectContainmentWithInverseEList<View>(View.class, this, ConfigurationemfPackage.CONFIGURATION__VIEW, ConfigurationemfPackage.VIEW__CONF);
		}
		return view;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Meta getMeta() {
		return meta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMeta(Meta newMeta, NotificationChain msgs) {
		Meta oldMeta = meta;
		meta = newMeta;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.CONFIGURATION__META, oldMeta, newMeta);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeta(Meta newMeta) {
		if (newMeta != meta) {
			NotificationChain msgs = null;
			if (meta != null)
				msgs = ((InternalEObject)meta).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.CONFIGURATION__META, null, msgs);
			if (newMeta != null)
				msgs = ((InternalEObject)newMeta).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.CONFIGURATION__META, null, msgs);
			msgs = basicSetMeta(newMeta, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.CONFIGURATION__META, newMeta, newMeta));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Icon> getIcon() {
		if (icon == null) {
			icon = new EObjectContainmentEList<Icon>(Icon.class, this, ConfigurationemfPackage.CONFIGURATION__ICON);
		}
		return icon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Link> getLink() {
		if (link == null) {
			link = new EObjectContainmentEList<Link>(Link.class, this, ConfigurationemfPackage.CONFIGURATION__LINK);
		}
		return link;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Data getData() {
		return data;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetData(Data newData, NotificationChain msgs) {
		Data oldData = data;
		data = newData;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.CONFIGURATION__DATA, oldData, newData);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setData(Data newData) {
		if (newData != data) {
			NotificationChain msgs = null;
			if (data != null)
				msgs = ((InternalEObject)data).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.CONFIGURATION__DATA, null, msgs);
			if (newData != null)
				msgs = ((InternalEObject)newData).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.CONFIGURATION__DATA, null, msgs);
			msgs = basicSetData(newData, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.CONFIGURATION__DATA, newData, newData));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReadOnly() {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getMetaId() {
		return getMetaAttribute(ConfigurationemfPackage.eINSTANCE.getMeta_Identification());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setMetaId(String newMetaId) {
		setMetaAttribute(ConfigurationemfPackage.eINSTANCE.getMeta_Identification(), newMetaId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getOwner() {
		return getMetaAttribute(ConfigurationemfPackage.eINSTANCE.getMeta_Owner());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setOwner(String newOwner) {
		setMetaAttribute(ConfigurationemfPackage.eINSTANCE.getMeta_Owner(), newOwner);
	}

	private void setMetaAttribute(EStructuralFeature sFeature, String value){
		Meta meta = getMeta();
		if(value!=null){
			if(meta==null){
				this.setMeta(ConfigurationemfFactory.eINSTANCE.createMeta());
				meta=getMeta();
			}
			EObject eObject=(EObject)meta.eGet(sFeature);
			if(eObject==null){
				meta.eSet(sFeature, ConfigurationemfFactory.eINSTANCE.create((EClass)sFeature.getEType()));
				eObject=(EObject)meta.eGet(sFeature);
			}
			eObject.eSet(ConfigurationemfPackage.eINSTANCE.getContent_Value(), value);
		}else{
			if(meta!=null){
				meta.eSet(sFeature, null);
			}
			EClass metaEClass = ConfigurationemfPackage.eINSTANCE.getMeta();
			boolean isEmpty=true;
			for(EReference eReference : metaEClass.getEAllReferences()){
				isEmpty=meta.eGet(eReference)==null;
				if(!isEmpty)break;
			}
			if(isEmpty){
				this.setMeta(null);
			}
		}
	}
	
	private String getMetaAttribute(EStructuralFeature sFeature){
		Meta meta = getMeta();
		String result=null;
		if(meta!=null){
			EObject eObject = (EObject)meta.eGet(sFeature);
			if(eObject!=null)
				result=(String)eObject.eGet(ConfigurationemfPackage.eINSTANCE.getContent_Value());
		}
		return result;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getEditor() {
		return getMetaAttribute(ConfigurationemfPackage.eINSTANCE.getMeta_Editor());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setEditor(String newEditor) {
		setMetaAttribute(ConfigurationemfPackage.eINSTANCE.getMeta_Editor(), newEditor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getStatus() {
		return getMetaAttribute(ConfigurationemfPackage.eINSTANCE.getMeta_Status());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setStatus(String newStatus) {
		setMetaAttribute(ConfigurationemfPackage.eINSTANCE.getMeta_Status(), newStatus);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getVersion() {
		return getMetaAttribute(ConfigurationemfPackage.eINSTANCE.getMeta_Version());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setVersion(String newVersion) {
		setMetaAttribute(ConfigurationemfPackage.eINSTANCE.getMeta_Version(), newVersion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getPlatform() {
		return getMetaAttribute(ConfigurationemfPackage.eINSTANCE.getMeta_Platform());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setPlatform(String newPlatform) {
		setMetaAttribute(ConfigurationemfPackage.eINSTANCE.getMeta_Platform(), newPlatform);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getProduct() {
		return getMetaAttribute(ConfigurationemfPackage.eINSTANCE.getMeta_Product());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setProduct(String newProduct) {
		setMetaAttribute(ConfigurationemfPackage.eINSTANCE.getMeta_Product(), newProduct);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getCustomer() {
		return getMetaAttribute(ConfigurationemfPackage.eINSTANCE.getMeta_Customer());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setCustomer(String newCustomer) {
		setMetaAttribute(ConfigurationemfPackage.eINSTANCE.getMeta_Customer(), newCustomer);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getDate() {
		return getMetaAttribute(ConfigurationemfPackage.eINSTANCE.getMeta_Date());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setDate(String newDate) {
		setMetaAttribute(ConfigurationemfPackage.eINSTANCE.getMeta_Date(), newDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getRelease() {
		return getMetaAttribute(ConfigurationemfPackage.eINSTANCE.getMeta_Release());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setRelease(String newRelease) {
		setMetaAttribute(ConfigurationemfPackage.eINSTANCE.getMeta_Release(), newRelease);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract EList<Setting> getAllSettings();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public View getViewById(String viewId) {
		View theView = getViewBy(viewId, ConfigurationemfPackage.eINSTANCE.getCommonAttr_Id());
		return theView;
	}

	protected View getViewBy(String value, EStructuralFeature structuralFeature){
		View theView = null;
		for(Iterator<View> iView=this.getView().iterator();iView.hasNext()&&theView==null;){
			View view = iView.next();
			String temp = (String)view.eGet(structuralFeature);
			if(temp!=null&&temp.trim().equalsIgnoreCase(value))theView=view;
		}
		return theView;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public View getViewByName(String viewName) {
		View theView = getViewBy(viewName, ConfigurationemfPackage.eINSTANCE.getView_Name());
		return theView;
	}

	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
		@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigurationemfPackage.CONFIGURATION__FEATURE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFeature()).basicAdd(otherEnd, msgs);
			case ConfigurationemfPackage.CONFIGURATION__VIEW:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getView()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigurationemfPackage.CONFIGURATION__FEATURE:
				return ((InternalEList<?>)getFeature()).basicRemove(otherEnd, msgs);
			case ConfigurationemfPackage.CONFIGURATION__VIEW:
				return ((InternalEList<?>)getView()).basicRemove(otherEnd, msgs);
			case ConfigurationemfPackage.CONFIGURATION__META:
				return basicSetMeta(null, msgs);
			case ConfigurationemfPackage.CONFIGURATION__ICON:
				return ((InternalEList<?>)getIcon()).basicRemove(otherEnd, msgs);
			case ConfigurationemfPackage.CONFIGURATION__LINK:
				return ((InternalEList<?>)getLink()).basicRemove(otherEnd, msgs);
			case ConfigurationemfPackage.CONFIGURATION__DATA:
				return basicSetData(null, msgs);
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
			case ConfigurationemfPackage.CONFIGURATION__NAME:
				return getName();
			case ConfigurationemfPackage.CONFIGURATION__VERS:
				return getVers();
			case ConfigurationemfPackage.CONFIGURATION__FEATURE:
				return getFeature();
			case ConfigurationemfPackage.CONFIGURATION__VIEW:
				return getView();
			case ConfigurationemfPackage.CONFIGURATION__META:
				return getMeta();
			case ConfigurationemfPackage.CONFIGURATION__ICON:
				return getIcon();
			case ConfigurationemfPackage.CONFIGURATION__LINK:
				return getLink();
			case ConfigurationemfPackage.CONFIGURATION__DATA:
				return getData();
			case ConfigurationemfPackage.CONFIGURATION__READ_ONLY:
				return isReadOnly() ? Boolean.TRUE : Boolean.FALSE;
			case ConfigurationemfPackage.CONFIGURATION__META_ID:
				return getMetaId();
			case ConfigurationemfPackage.CONFIGURATION__OWNER:
				return getOwner();
			case ConfigurationemfPackage.CONFIGURATION__EDITOR:
				return getEditor();
			case ConfigurationemfPackage.CONFIGURATION__STATUS:
				return getStatus();
			case ConfigurationemfPackage.CONFIGURATION__VERSION:
				return getVersion();
			case ConfigurationemfPackage.CONFIGURATION__PLATFORM:
				return getPlatform();
			case ConfigurationemfPackage.CONFIGURATION__PRODUCT:
				return getProduct();
			case ConfigurationemfPackage.CONFIGURATION__CUSTOMER:
				return getCustomer();
			case ConfigurationemfPackage.CONFIGURATION__DATE:
				return getDate();
			case ConfigurationemfPackage.CONFIGURATION__RELEASE:
				return getRelease();
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
			case ConfigurationemfPackage.CONFIGURATION__NAME:
				setName((String)newValue);
				return;
			case ConfigurationemfPackage.CONFIGURATION__VERS:
				setVers((String)newValue);
				return;
			case ConfigurationemfPackage.CONFIGURATION__FEATURE:
				getFeature().clear();
				getFeature().addAll((Collection<? extends Feature>)newValue);
				return;
			case ConfigurationemfPackage.CONFIGURATION__VIEW:
				getView().clear();
				getView().addAll((Collection<? extends View>)newValue);
				return;
			case ConfigurationemfPackage.CONFIGURATION__META:
				setMeta((Meta)newValue);
				return;
			case ConfigurationemfPackage.CONFIGURATION__ICON:
				getIcon().clear();
				getIcon().addAll((Collection<? extends Icon>)newValue);
				return;
			case ConfigurationemfPackage.CONFIGURATION__LINK:
				getLink().clear();
				getLink().addAll((Collection<? extends Link>)newValue);
				return;
			case ConfigurationemfPackage.CONFIGURATION__DATA:
				setData((Data)newValue);
				return;
			case ConfigurationemfPackage.CONFIGURATION__META_ID:
				setMetaId((String)newValue);
				return;
			case ConfigurationemfPackage.CONFIGURATION__OWNER:
				setOwner((String)newValue);
				return;
			case ConfigurationemfPackage.CONFIGURATION__EDITOR:
				setEditor((String)newValue);
				return;
			case ConfigurationemfPackage.CONFIGURATION__STATUS:
				setStatus((String)newValue);
				return;
			case ConfigurationemfPackage.CONFIGURATION__VERSION:
				setVersion((String)newValue);
				return;
			case ConfigurationemfPackage.CONFIGURATION__PLATFORM:
				setPlatform((String)newValue);
				return;
			case ConfigurationemfPackage.CONFIGURATION__PRODUCT:
				setProduct((String)newValue);
				return;
			case ConfigurationemfPackage.CONFIGURATION__CUSTOMER:
				setCustomer((String)newValue);
				return;
			case ConfigurationemfPackage.CONFIGURATION__DATE:
				setDate((String)newValue);
				return;
			case ConfigurationemfPackage.CONFIGURATION__RELEASE:
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
			case ConfigurationemfPackage.CONFIGURATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ConfigurationemfPackage.CONFIGURATION__VERS:
				setVers(VERS_EDEFAULT);
				return;
			case ConfigurationemfPackage.CONFIGURATION__FEATURE:
				getFeature().clear();
				return;
			case ConfigurationemfPackage.CONFIGURATION__VIEW:
				getView().clear();
				return;
			case ConfigurationemfPackage.CONFIGURATION__META:
				setMeta((Meta)null);
				return;
			case ConfigurationemfPackage.CONFIGURATION__ICON:
				getIcon().clear();
				return;
			case ConfigurationemfPackage.CONFIGURATION__LINK:
				getLink().clear();
				return;
			case ConfigurationemfPackage.CONFIGURATION__DATA:
				setData((Data)null);
				return;
			case ConfigurationemfPackage.CONFIGURATION__META_ID:
				setMetaId(META_ID_EDEFAULT);
				return;
			case ConfigurationemfPackage.CONFIGURATION__OWNER:
				setOwner(OWNER_EDEFAULT);
				return;
			case ConfigurationemfPackage.CONFIGURATION__EDITOR:
				setEditor(EDITOR_EDEFAULT);
				return;
			case ConfigurationemfPackage.CONFIGURATION__STATUS:
				setStatus(STATUS_EDEFAULT);
				return;
			case ConfigurationemfPackage.CONFIGURATION__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case ConfigurationemfPackage.CONFIGURATION__PLATFORM:
				setPlatform(PLATFORM_EDEFAULT);
				return;
			case ConfigurationemfPackage.CONFIGURATION__PRODUCT:
				setProduct(PRODUCT_EDEFAULT);
				return;
			case ConfigurationemfPackage.CONFIGURATION__CUSTOMER:
				setCustomer(CUSTOMER_EDEFAULT);
				return;
			case ConfigurationemfPackage.CONFIGURATION__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case ConfigurationemfPackage.CONFIGURATION__RELEASE:
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
			case ConfigurationemfPackage.CONFIGURATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ConfigurationemfPackage.CONFIGURATION__VERS:
				return VERS_EDEFAULT == null ? vers != null : !VERS_EDEFAULT.equals(vers);
			case ConfigurationemfPackage.CONFIGURATION__FEATURE:
				return feature != null && !feature.isEmpty();
			case ConfigurationemfPackage.CONFIGURATION__VIEW:
				return view != null && !view.isEmpty();
			case ConfigurationemfPackage.CONFIGURATION__META:
				return meta != null;
			case ConfigurationemfPackage.CONFIGURATION__ICON:
				return icon != null && !icon.isEmpty();
			case ConfigurationemfPackage.CONFIGURATION__LINK:
				return link != null && !link.isEmpty();
			case ConfigurationemfPackage.CONFIGURATION__DATA:
				return data != null;
			case ConfigurationemfPackage.CONFIGURATION__READ_ONLY:
				return isReadOnly() != READ_ONLY_EDEFAULT;
			case ConfigurationemfPackage.CONFIGURATION__META_ID:
				return META_ID_EDEFAULT == null ? getMetaId() != null : !META_ID_EDEFAULT.equals(getMetaId());
			case ConfigurationemfPackage.CONFIGURATION__OWNER:
				return OWNER_EDEFAULT == null ? getOwner() != null : !OWNER_EDEFAULT.equals(getOwner());
			case ConfigurationemfPackage.CONFIGURATION__EDITOR:
				return EDITOR_EDEFAULT == null ? getEditor() != null : !EDITOR_EDEFAULT.equals(getEditor());
			case ConfigurationemfPackage.CONFIGURATION__STATUS:
				return STATUS_EDEFAULT == null ? getStatus() != null : !STATUS_EDEFAULT.equals(getStatus());
			case ConfigurationemfPackage.CONFIGURATION__VERSION:
				return VERSION_EDEFAULT == null ? getVersion() != null : !VERSION_EDEFAULT.equals(getVersion());
			case ConfigurationemfPackage.CONFIGURATION__PLATFORM:
				return PLATFORM_EDEFAULT == null ? getPlatform() != null : !PLATFORM_EDEFAULT.equals(getPlatform());
			case ConfigurationemfPackage.CONFIGURATION__PRODUCT:
				return PRODUCT_EDEFAULT == null ? getProduct() != null : !PRODUCT_EDEFAULT.equals(getProduct());
			case ConfigurationemfPackage.CONFIGURATION__CUSTOMER:
				return CUSTOMER_EDEFAULT == null ? getCustomer() != null : !CUSTOMER_EDEFAULT.equals(getCustomer());
			case ConfigurationemfPackage.CONFIGURATION__DATE:
				return DATE_EDEFAULT == null ? getDate() != null : !DATE_EDEFAULT.equals(getDate());
			case ConfigurationemfPackage.CONFIGURATION__RELEASE:
				return RELEASE_EDEFAULT == null ? getRelease() != null : !RELEASE_EDEFAULT.equals(getRelease());
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
		result.append(", vers: ");
		result.append(vers);
		result.append(')');
		return result.toString();
	}

	public Object eGet(EStructuralFeature eFeature) {
		if(eFeature.equals(ConfigurationemfPackage.Literals.META__PLATFORM)){
			if(this.meta!=null&&this.meta.getPlatform()!=null)
				return this.meta.getPlatform().getValue();
			else return null;
		
		}
		else return super.eGet(eFeature);
	}

	public void eSet(EStructuralFeature eFeature, Object newValue) {
		super.eSet(eFeature, newValue);
	}
	
	

} //ConfigurationImpl