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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import configurationemf.BasedOn;
import configurationemf.Configuration;
import configurationemf.ConfigurationemfPackage;
import configurationemf.Data;
import configurationemf.Feature;
import configurationemf.Ref;
import configurationemf.Rfs;
import configurationemf.RootConf;
import configurationemf.Setting;
import configurationemf.SubConf;
import configurationemf.View;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root Conf</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link configurationemf.impl.RootConfImpl#getSubConf <em>Sub Conf</em>}</li>
 *   <li>{@link configurationemf.impl.RootConfImpl#getInclude <em>Include</em>}</li>
 *   <li>{@link configurationemf.impl.RootConfImpl#getRoot <em>Root</em>}</li>
 *   <li>{@link configurationemf.impl.RootConfImpl#getRfs <em>Rfs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RootConfImpl extends ConfigurationImpl implements RootConf {
	/**
	 * The cached value of the '{@link #getSubConf() <em>Sub Conf</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubConf()
	 * @generated
	 * @ordered
	 */
	protected EList<SubConf> subConf;

	/**
	 * The cached value of the '{@link #getInclude() <em>Include</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInclude()
	 * @generated
	 * @ordered
	 */
	protected EList<RootConf> include;

	/**
	 * The cached value of the '{@link #getRoot() <em>Root</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoot()
	 * @generated
	 * @ordered
	 */
	protected RootConf root;

	/**
	 * The cached value of the '{@link #getRfs() <em>Rfs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRfs()
	 * @generated
	 * @ordered
	 */
	protected Rfs rfs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected RootConfImpl() {
		super();
		this.eAdapters().add(selfAdapter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationemfPackage.Literals.ROOT_CONF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubConf> getSubConf() {
		if (subConf == null) {
			subConf = new EObjectContainmentEList<SubConf>(SubConf.class, this, ConfigurationemfPackage.ROOT_CONF__SUB_CONF);
		}
		return subConf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RootConf> getInclude() {
		if (include == null) {
			include = new EObjectResolvingEList<RootConf>(RootConf.class, this, ConfigurationemfPackage.ROOT_CONF__INCLUDE);
		}
		return include;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RootConf getRoot() {
		return root;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setRoot(RootConf newRoot) {
		root=newRoot;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rfs getRfs() {
		return rfs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRfs(Rfs newRfs, NotificationChain msgs) {
		Rfs oldRfs = rfs;
		rfs = newRfs;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.ROOT_CONF__RFS, oldRfs, newRfs);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRfs(Rfs newRfs) {
		if (newRfs != rfs) {
			NotificationChain msgs = null;
			if (rfs != null)
				msgs = ((InternalEObject)rfs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.ROOT_CONF__RFS, null, msgs);
			if (newRfs != null)
				msgs = ((InternalEObject)newRfs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.ROOT_CONF__RFS, null, msgs);
			msgs = basicSetRfs(newRfs, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.ROOT_CONF__RFS, newRfs, newRfs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * Goes through rootConf and recursively through its includes and compares
	 * features' ref attribute. The corresponding feature is returned;
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Feature getFeatureByRef(String refFeature) {
		Iterator<RootConf> itR = getInclude().iterator();
		Feature feature = null;
		while (itR.hasNext() && feature == null) {
			feature = itR.next().getFeatureByRef(refFeature);
		}
		if (feature != null) // if parent Setting found, return, if not,
								// continue in defined features
			return feature;

		// continue in searching feature in current configuration

		Iterator<Feature> itF = getFeature().iterator();
		while (itF.hasNext()) {
			Feature unknownFeature = itF.next();
			if (unknownFeature.getRef().equals(refFeature)) {
				return unknownFeature;
			}
		}
		return null;
	}
 
	@Override
	public View getViewById(String viewId) {
		View theView = super.getViewById(viewId);
		if(theView==null) // search in SubConfigurations
			for(Iterator<SubConf> iSubConf=this.getSubConf().iterator();iSubConf.hasNext()&&theView==null;){
				Configuration subConf = iSubConf.next();
				theView = subConf.getViewById(viewId);
			}
		if(theView==null) // search in BasedOnConfiguration
			for(Iterator<RootConf> iBasedOn=this.getInclude().iterator();iBasedOn.hasNext()&&theView==null;){
				RootConf basedOn = iBasedOn.next();
				theView = basedOn.getViewById(viewId);
			}
		return theView; 
	}

	@Override
	public View getViewByName(String viewName) {
		View theView = super.getViewByName(viewName);
		if(theView==null) // search in SubConfigurations
			for(Iterator<SubConf> iSubConf=this.getSubConf().iterator();iSubConf.hasNext()&&theView==null;){
				Configuration subConf = iSubConf.next();
				theView = subConf.getViewByName(viewName);
			}
		if(theView==null) // search in BasedOnConfiguration
			for(Iterator<RootConf> iBasedOn=this.getInclude().iterator();iBasedOn.hasNext()&&theView==null;){
				RootConf basedOn = iBasedOn.next();
				theView = basedOn.getViewByName(viewName);
			}
		return theView;
	}





	int level=-1;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getLevel() {
		if(level == -1){
			level=this.getRoot()!=null?this.getRoot().getLevel()+1:0;
		}
			return level;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigurationemfPackage.ROOT_CONF__SUB_CONF:
				return ((InternalEList<?>)getSubConf()).basicRemove(otherEnd, msgs);
			case ConfigurationemfPackage.ROOT_CONF__RFS:
				return basicSetRfs(null, msgs);
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
			case ConfigurationemfPackage.ROOT_CONF__SUB_CONF:
				return getSubConf();
			case ConfigurationemfPackage.ROOT_CONF__INCLUDE:
				return getInclude();
			case ConfigurationemfPackage.ROOT_CONF__ROOT:
				return getRoot();
			case ConfigurationemfPackage.ROOT_CONF__RFS:
				return getRfs();
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
			case ConfigurationemfPackage.ROOT_CONF__SUB_CONF:
				getSubConf().clear();
				getSubConf().addAll((Collection<? extends SubConf>)newValue);
				return;
			case ConfigurationemfPackage.ROOT_CONF__INCLUDE:
				getInclude().clear();
				getInclude().addAll((Collection<? extends RootConf>)newValue);
				return;
			case ConfigurationemfPackage.ROOT_CONF__ROOT:
				setRoot((RootConf)newValue);
				return;
			case ConfigurationemfPackage.ROOT_CONF__RFS:
				setRfs((Rfs)newValue);
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
			case ConfigurationemfPackage.ROOT_CONF__SUB_CONF:
				getSubConf().clear();
				return;
			case ConfigurationemfPackage.ROOT_CONF__INCLUDE:
				getInclude().clear();
				return;
			case ConfigurationemfPackage.ROOT_CONF__ROOT:
				setRoot((RootConf)null);
				return;
			case ConfigurationemfPackage.ROOT_CONF__RFS:
				setRfs((Rfs)null);
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
			case ConfigurationemfPackage.ROOT_CONF__SUB_CONF:
				return subConf != null && !subConf.isEmpty();
			case ConfigurationemfPackage.ROOT_CONF__INCLUDE:
				return include != null && !include.isEmpty();
			case ConfigurationemfPackage.ROOT_CONF__ROOT:
				return root != null;
			case ConfigurationemfPackage.ROOT_CONF__RFS:
				return rfs != null;
		}
		return super.eIsSet(featureID);
	}


	//Adapter
	Adapter selfAdapter = new AdapterImpl(){
		@Override
		public void notifyChanged(Notification notification) {
			switch (notification.getFeatureID(RootConf.class)) {
			 case ConfigurationemfPackage.ROOT_CONF__FEATURE:
				 Feature addFt = (Feature)notification.getNewValue();
				 Feature remFt = (Feature)notification.getOldValue();
				 switch(notification.getEventType()){
					case Notification.ADD:
						RootConfImpl.this.addFeature(addFt);
						break;
					case Notification.REMOVE:
						RootConfImpl.this.removeFeature(remFt);
						break;
					}
				 
				
				 break;
			case ConfigurationemfPackage.ROOT_CONF__INCLUDE:
                RootConf root = (RootConf)notification.getNotifier();
                RootConf basedOnConf=null;
				switch(notification.getEventType()){
				case Notification.ADD:
					basedOnConf = (RootConf)notification.getNewValue();
					if(basedOnConf.eIsProxy()){
						basedOnConf = (RootConf)EcoreUtil.resolve(basedOnConf, root.eResource().getResourceSet());
					}
					basedOnConf.setRoot(root);
					break;
				case Notification.REMOVE:
					basedOnConf = (RootConf)notification.getOldValue();
					basedOnConf.setRoot(null);
					break;
				}
				return;

			}
		}
		
	};

	public boolean isReadOnly() {
		return getRoot()!=null;
	}

	@Override
	public EList<Setting> getAllSettings() {
		EList<Setting> result = new BasicEList<Setting>();
		for(Iterator<Feature>iFeature=getFeature().iterator();iFeature.hasNext();)
			result.addAll(iFeature.next().getParentSetting());
		for(Iterator<RootConf>iBasedOn=this.getInclude().iterator();iBasedOn.hasNext();)
			result.addAll(iBasedOn.next().getAllSettings());
		return result;
	}
	
	private static void removeFeature(Feature ftr){
		Data data = null;
		for(Ref ref : ftr.getRfsRefs()){
			data = (Data)ref.eContainer();
			data.getRef().remove(ref);
		}
		for(Ref ref : ftr.getRefs()){
			data = (Data)ref.eContainer();
			data.getRef().remove(ref);
		}
		
		if(data!=null && data.getRef().isEmpty()){
			RootConf conf = (RootConf)data.eContainer();
			if(conf!=null)
				conf.setData(null);
		}
			
	}
	
	private void addFeature(Feature ftr){
		RootConfImpl.this.getFeature().add(ftr);
	}
	
} //RootConfImpl