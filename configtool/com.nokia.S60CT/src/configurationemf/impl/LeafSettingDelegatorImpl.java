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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import configurationemf.ConfigurationemfFactory;
import configurationemf.ConfigurationemfPackage;
import configurationemf.Frame;
import configurationemf.LeafSetting;
import configurationemf.LeafSettingDelegator;
import configurationemf.Ref;
import configurationemf.RootConf;
import configurationemf.TYPE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Leaf Setting Delegator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link configurationemf.impl.LeafSettingDelegatorImpl#getLeafSetting <em>Leaf Setting</em>}</li>
 *   <li>{@link configurationemf.impl.LeafSettingDelegatorImpl#getValue <em>Value</em>}</li>
 *   <li>{@link configurationemf.impl.LeafSettingDelegatorImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link configurationemf.impl.LeafSettingDelegatorImpl#getType <em>Type</em>}</li>
 *   <li>{@link configurationemf.impl.LeafSettingDelegatorImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LeafSettingDelegatorImpl extends EObjectImpl implements LeafSettingDelegator {
	/**
	 * The cached value of the '{@link #getLeafSetting() <em>Leaf Setting</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeafSetting()
	 * @generated
	 * @ordered
	 */
	protected LeafSetting leafSetting;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getRef() <em>Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRef()
	 * @generated
	 * @ordered
	 */
	protected Ref ref;
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final TYPE TYPE_EDEFAULT = TYPE.INT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;
	
	Adapter adapter = new AdapterImpl(){

		@Override
		public void notifyChanged(Notification msg) {
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(LeafSettingDelegatorImpl.this, Notification.RESOLVE, (EStructuralFeature)msg.getFeature(), msg.getOldValue(), msg.getNewValue()));
		}
		
	};
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LeafSettingDelegatorImpl() {
		super();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationemfPackage.Literals.LEAF_SETTING_DELEGATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LeafSetting getLeafSetting() {
		if (leafSetting != null && leafSetting.eIsProxy()) {
			InternalEObject oldLeafSetting = (InternalEObject)leafSetting;
			leafSetting = (LeafSetting)eResolveProxy(oldLeafSetting);
			if (leafSetting != oldLeafSetting) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfigurationemfPackage.LEAF_SETTING_DELEGATOR__LEAF_SETTING, oldLeafSetting, leafSetting));
			}
		}
		return leafSetting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LeafSetting basicGetLeafSetting() {
		return leafSetting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setLeafSetting(LeafSetting newLeafSetting) {
		LeafSetting oldLeafSetting = leafSetting;
		leafSetting = newLeafSetting;
		if(oldLeafSetting!=null)oldLeafSetting.eAdapters().remove(adapter);
		if(leafSetting!=null)leafSetting.eAdapters().add(adapter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getValue() {
		return ref!=null?ref.getValue():null;
	}

	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setValue(String newValue) {
		String oldValue = null;
		if(ref==null){
			FrameImpl frame = (FrameImpl)this.eContainer();
			Ref parentRef = frame.getRef();
			ref = ConfigurationemfFactory.eINSTANCE.createRef();
			ref.setName(getLeafSetting().getRef());
			ref.setValue(newValue);
			int newRefIndex = Math.min(parentRef.getRef().size(),frame.getLeafSettings().indexOf(this));
			parentRef.getRef().add(newRefIndex,ref);
			leafSetting.getRefs().add(ref);
		}
		else{
			oldValue = ref.getValue();
			if(newValue==""){
				Ref parentRef=(Ref)ref.eContainer();
				parentRef.getRef().remove(ref);
				ref=null;
			}
			else
				ref.setValue(newValue);
		}
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.LEAF_SETTING_DELEGATOR__VALUE, oldValue, newValue));
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ref getRef() {
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setRef(Ref newRef) {
		Ref oldRef = ref;
		ref = newRef;
		if(oldRef!=null)oldRef.eAdapters().add(adapter);
		if(newRef!=null)newRef.eAdapters().add(adapter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public TYPE getType() {
		return leafSetting.getType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getName() {
		return leafSetting.getName();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean canModifyValue() {
		if(getLeafSetting().isRo())//variant engineer use case
		{
			Frame frame = (Frame)eContainer();
			RootConf rc = (RootConf)frame.getRef().eContainer().eContainer().eContainer();
			if (rc.getRoot()==null && !getLeafSetting().isReadOnly()) //data stored
				return true;
			else
				return false;
			//return (!((Frame)eContainer()).isTemplate())&& !getLeafSetting().isReadOnly();
		}
		else //developer use case
			return (((Frame)eContainer()).isTemplate())||!getLeafSetting().isReadOnly();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean canModifyAttribute() {
		return ((Frame)eContainer()).isTemplate()&&!getLeafSetting().isRo();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
				case ConfigurationemfPackage.SETTING__DEFAULT_VALUE:
					return "";
				case ConfigurationemfPackage.SETTING__CURRENT_VALUE:
					return getValue();
				case ConfigurationemfPackage.SETTING__TOP_VALUE:
					return getValue();
		}
		return ((LeafSettingImpl)leafSetting).eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConfigurationemfPackage.SETTING__CURRENT_VALUE:
				setValue((String)newValue);
				return;
		}
		((LeafSettingImpl)leafSetting).eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ConfigurationemfPackage.LEAF_SETTING_DELEGATOR__LEAF_SETTING:
				setLeafSetting((LeafSetting)null);
				return;
			case ConfigurationemfPackage.LEAF_SETTING_DELEGATOR__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case ConfigurationemfPackage.LEAF_SETTING_DELEGATOR__REF:
				setRef((Ref)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ConfigurationemfPackage.SETTING__DEFAULT_VALUE:
				return false;
			case ConfigurationemfPackage.SETTING__CURRENT_VALUE:
				return getValue()!=null;
		}
		return ((LeafSettingImpl)leafSetting).eIsSet(featureID);
	}

} //LeafSettingDelegatorImpl
