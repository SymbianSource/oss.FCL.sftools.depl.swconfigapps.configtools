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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import configurationemf.Configuration;
import configurationemf.ConfigurationemfFactory;
import configurationemf.ConfigurationemfPackage;
import configurationemf.Data;
import configurationemf.Feature;
import configurationemf.Icon;
import configurationemf.Link;
import configurationemf.ParentSetting;
import configurationemf.Ref;
import configurationemf.Rfs;
import configurationemf.RootConf;
import configurationemf.TYPE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link configurationemf.impl.FeatureImpl#getName <em>Name</em>}</li>
 *   <li>{@link configurationemf.impl.FeatureImpl#getRelevant <em>Relevant</em>}</li>
 *   <li>{@link configurationemf.impl.FeatureImpl#getConf <em>Conf</em>}</li>
 *   <li>{@link configurationemf.impl.FeatureImpl#getParentSetting <em>Parent Setting</em>}</li>
 *   <li>{@link configurationemf.impl.FeatureImpl#getLink <em>Link</em>}</li>
 *   <li>{@link configurationemf.impl.FeatureImpl#getIcon <em>Icon</em>}</li>
 *   <li>{@link configurationemf.impl.FeatureImpl#isReadOnly <em>Read Only</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureImpl extends ReferableImpl implements Feature {
	
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
	 * The default value of the '{@link #getRelevant() <em>Relevant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelevant()
	 * @generated
	 * @ordered
	 */
	protected static final String RELEVANT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRelevant() <em>Relevant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelevant()
	 * @generated
	 * @ordered
	 */
	protected String relevant = RELEVANT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParentSetting() <em>Parent Setting</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentSetting()
	 * @generated
	 * @ordered
	 */
	protected EList<ParentSetting> parentSetting;

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
	 * The cached value of the '{@link #getIcon() <em>Icon</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon()
	 * @generated
	 * @ordered
	 */
	protected EList<Icon> icon;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected FeatureImpl() {
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
		return ConfigurationemfPackage.Literals.FEATURE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.FEATURE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRelevant() {
		return relevant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelevant(String newRelevant) {
		String oldRelevant = relevant;
		relevant = newRelevant;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.FEATURE__RELEVANT, oldRelevant, relevant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Configuration getConf() {
		if (eContainerFeatureID != ConfigurationemfPackage.FEATURE__CONF) return null;
		return (Configuration)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConf(Configuration newConf, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newConf, ConfigurationemfPackage.FEATURE__CONF, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConf(Configuration newConf) {
		if (newConf != eInternalContainer() || (eContainerFeatureID != ConfigurationemfPackage.FEATURE__CONF && newConf != null)) {
			if (EcoreUtil.isAncestor(this, newConf))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newConf != null)
				msgs = ((InternalEObject)newConf).eInverseAdd(this, ConfigurationemfPackage.CONFIGURATION__FEATURE, Configuration.class, msgs);
			msgs = basicSetConf(newConf, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.FEATURE__CONF, newConf, newConf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParentSetting> getParentSetting() {
		if (parentSetting == null) {
			parentSetting = new EObjectContainmentEList<ParentSetting>(ParentSetting.class, this, ConfigurationemfPackage.FEATURE__PARENT_SETTING);
		}
		return parentSetting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Link> getLink() {
		if (link == null) {
			link = new EObjectContainmentEList<Link>(Link.class, this, ConfigurationemfPackage.FEATURE__LINK);
		}
		return link;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Icon> getIcon() {
		if (icon == null) {
			icon = new EObjectContainmentEList<Icon>(Icon.class, this, ConfigurationemfPackage.FEATURE__ICON);
		}
		return icon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isReadOnly() {
		if(this.eContainer()==null)return false;
		return ((Configuration)this.eContainer()).isReadOnly();
	}

	/**
	 * <!-- begin-user-doc -->
	 * Searches setting in feature according to setting ref value.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ParentSetting getSettingByRef(String refSetting) {
		if (getParentSetting() != null) {
			Iterator<configurationemf.ParentSetting> itS = getParentSetting().iterator();
			while (itS.hasNext()) {
				configurationemf.ParentSetting setting = itS.next();
				if (setting.getRef().equals(refSetting)) {
					return setting;
				}
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigurationemfPackage.FEATURE__CONF:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetConf((Configuration)otherEnd, msgs);
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
			case ConfigurationemfPackage.FEATURE__CONF:
				return basicSetConf(null, msgs);
			case ConfigurationemfPackage.FEATURE__PARENT_SETTING:
				return ((InternalEList<?>)getParentSetting()).basicRemove(otherEnd, msgs);
			case ConfigurationemfPackage.FEATURE__LINK:
				return ((InternalEList<?>)getLink()).basicRemove(otherEnd, msgs);
			case ConfigurationemfPackage.FEATURE__ICON:
				return ((InternalEList<?>)getIcon()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case ConfigurationemfPackage.FEATURE__CONF:
				return eInternalContainer().eInverseRemove(this, ConfigurationemfPackage.CONFIGURATION__FEATURE, Configuration.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigurationemfPackage.FEATURE__NAME:
				return getName();
			case ConfigurationemfPackage.FEATURE__RELEVANT:
				return getRelevant();
			case ConfigurationemfPackage.FEATURE__CONF:
				return getConf();
			case ConfigurationemfPackage.FEATURE__PARENT_SETTING:
				return getParentSetting();
			case ConfigurationemfPackage.FEATURE__LINK:
				return getLink();
			case ConfigurationemfPackage.FEATURE__ICON:
				return getIcon();
			case ConfigurationemfPackage.FEATURE__READ_ONLY:
				return isReadOnly() ? Boolean.TRUE : Boolean.FALSE;
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
			case ConfigurationemfPackage.FEATURE__NAME:
				setName((String)newValue);
				return;
			case ConfigurationemfPackage.FEATURE__RELEVANT:
				setRelevant((String)newValue);
				return;
			case ConfigurationemfPackage.FEATURE__CONF:
				setConf((Configuration)newValue);
				return;
			case ConfigurationemfPackage.FEATURE__PARENT_SETTING:
				getParentSetting().clear();
				getParentSetting().addAll((Collection<? extends ParentSetting>)newValue);
				return;
			case ConfigurationemfPackage.FEATURE__LINK:
				getLink().clear();
				getLink().addAll((Collection<? extends Link>)newValue);
				return;
			case ConfigurationemfPackage.FEATURE__ICON:
				getIcon().clear();
				getIcon().addAll((Collection<? extends Icon>)newValue);
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
			case ConfigurationemfPackage.FEATURE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ConfigurationemfPackage.FEATURE__RELEVANT:
				setRelevant(RELEVANT_EDEFAULT);
				return;
			case ConfigurationemfPackage.FEATURE__CONF:
				setConf((Configuration)null);
				return;
			case ConfigurationemfPackage.FEATURE__PARENT_SETTING:
				getParentSetting().clear();
				return;
			case ConfigurationemfPackage.FEATURE__LINK:
				getLink().clear();
				return;
			case ConfigurationemfPackage.FEATURE__ICON:
				getIcon().clear();
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
			case ConfigurationemfPackage.FEATURE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ConfigurationemfPackage.FEATURE__RELEVANT:
				return RELEVANT_EDEFAULT == null ? relevant != null : !RELEVANT_EDEFAULT.equals(relevant);
			case ConfigurationemfPackage.FEATURE__CONF:
				return getConf() != null;
			case ConfigurationemfPackage.FEATURE__PARENT_SETTING:
				return parentSetting != null && !parentSetting.isEmpty();
			case ConfigurationemfPackage.FEATURE__LINK:
				return link != null && !link.isEmpty();
			case ConfigurationemfPackage.FEATURE__ICON:
				return icon != null && !icon.isEmpty();
			case ConfigurationemfPackage.FEATURE__READ_ONLY:
				return isReadOnly() != READ_ONLY_EDEFAULT;
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
		result.append(", relevant: ");
		result.append(relevant);
		result.append(')');
		return result.toString();
	}

//Adapter
	
	Adapter selfAdapter = new AdapterImpl(){
		public void notifyChanged(Notification notification) {
			Object notifier = notification.getNotifier();
			if(notifier instanceof Feature){
				switch (notification.getFeatureID(Feature.class)) {
				 case ConfigurationemfPackage.FEATURE__PARENT_SETTING:
					 ParentSetting addSetting = (ParentSetting)notification.getNewValue();
					 ParentSetting removeSetting = (ParentSetting)notification.getOldValue();
					 
					 switch(notification.getEventType()){
						case(Notification.ADD):
							FeatureImpl.this.addSetting(addSetting);							
							break;
						case(Notification.REMOVE):
							FeatureImpl.this.removeSetting(removeSetting);
							break;
					 }
					 break;
				 case ConfigurationemfPackage.FEATURE__REF:
					 String newRef = notification.getNewStringValue();
					 FeatureImpl.this.updateRefName(newRef);
					 break;
						 
				}
			}
		}
	};
	
	private void updateRefName(String newRefName){
		for(Ref fRef : this.getRefs())
			fRef.setName(newRefName);
		for(Ref fRef : this.getRfsRefs())
			fRef.setName(newRefName);
	}
	
	private void addSetting(ParentSetting setting){
		if(!setting.getRefs().isEmpty()){
			RootConf conf = (RootConf)this.eContainer();
			Ref theRef =null;
			for(Ref fRef : this.getRefs()){
				theRef=fRef;
				break;
			}
			if(theRef==null){
				Data data = conf.getData();
				if(data==null){
					data=ConfigurationemfFactory.eINSTANCE.createData();
					conf.setData(data);
				}
				theRef=ConfigurationemfFactory.eINSTANCE.createRef();
				theRef.setName(this.getRef());
				data.getRef().add(theRef);
				this.getRefs().add(theRef);
			}
			for(Ref sRef : setting.getRefs()){
				theRef.getRef().add(sRef);
				break;
			}
		}
		if(!setting.getRfsRefs().isEmpty()){
			RootConf conf = (RootConf)this.eContainer();
			Ref theRef =null;
			for(Ref fRef : this.getRfsRefs()){
				theRef=fRef;
				break;
			}
			if(theRef==null){
				Rfs rfs = conf.getRfs();
				if(rfs==null){
					rfs=ConfigurationemfFactory.eINSTANCE.createRfs();
					conf.setRfs(rfs);
				}
				theRef=ConfigurationemfFactory.eINSTANCE.createRef();
				theRef.setName(this.getRef());
				rfs.getRef().add(theRef);
				this.getRfsRefs().add(theRef);
			}
			for(Ref sRef : setting.getRfsRefs()){
				theRef.getRef().add(sRef);
				break;
			}
		}
	}
	
	private void removeSetting(ParentSetting setting){
		for(Ref ref : setting.getRfsRefs()){
			Ref parentRef = (Ref)ref.eContainer();
			parentRef.getRef().remove(ref);
		}
		for(Ref ref : setting.getRefs()){
			ref.getRef().removeAll(ref.getRef());
			Ref parentRef = (Ref)ref.eContainer();
			parentRef.getRef().remove(ref);
		}
		
		if(setting.getType().equals(TYPE.SEQUENCE)){
			for(Ref ref : this.getRefs()){
				for (Ref stRef : ref.getRef()) {
					if(stRef.getName().equals(setting.getRef())){
						if(stRef.isTemplate()){
							stRef.getRef().removeAll(stRef.getRef());
							Ref parentRef = (Ref)stRef.eContainer();
							parentRef.getRef().remove(stRef);
						}
							
					}
				}
			}
		}
		
		List<Ref> ref2remove = new ArrayList<Ref>();
		List<Ref> refRFS2remove = new ArrayList<Ref>();
		for(Ref ref : this.getRefs())
			if(ref.getRef().isEmpty())ref2remove.add(ref);
		this.getRefs().removeAll(ref2remove);
		
		for(Ref ref : this.getRfsRefs())
			if(ref.getRef().isEmpty())
				refRFS2remove.add(ref);
		this.getRfsRefs().removeAll(refRFS2remove);
	}
	
} //FeatureImpl