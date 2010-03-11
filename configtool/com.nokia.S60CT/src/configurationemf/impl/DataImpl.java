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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import configurationemf.Configuration;
import configurationemf.ConfigurationemfPackage;
import configurationemf.Data;
import configurationemf.Ref;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link configurationemf.impl.DataImpl#getRef <em>Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataImpl extends EObjectImpl implements Data {
	/**
	 * The cached value of the '{@link #getRef() <em>Ref</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRef()
	 * @generated
	 * @ordered
	 */
	protected EList<Ref> ref;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected DataImpl() {
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
		return ConfigurationemfPackage.Literals.DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Ref> getRef() {
		if (ref == null) {
			ref = new EObjectContainmentEList<Ref>(Ref.class, this, ConfigurationemfPackage.DATA__REF);
		}
		return ref;
	}

	private boolean isMyRef(Ref ref){
		EObject container = ref.eContainer();
		if(container instanceof Data && container.equals(this))
			return true;
		else if(container instanceof Ref)
			return isMyRef((Ref)container);
		else 
			return false;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigurationemfPackage.DATA__REF:
				return ((InternalEList<?>)getRef()).basicRemove(otherEnd, msgs);
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
			case ConfigurationemfPackage.DATA__REF:
				return getRef();
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
			case ConfigurationemfPackage.DATA__REF:
				getRef().clear();
				getRef().addAll((Collection<? extends Ref>)newValue);
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
			case ConfigurationemfPackage.DATA__REF:
				getRef().clear();
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
			case ConfigurationemfPackage.DATA__REF:
				return ref != null && !ref.isEmpty();
		}
		return super.eIsSet(featureID);
	}
	
	public Ref giveChildRef(String refString){
		Ref ref=null;
		for(Iterator<Ref> itrRef=this.getRef().iterator();itrRef.hasNext();){
			ref=itrRef.next();
			if(ref.getName().compareTo(refString)==0)
				return ref;
		}
		return null;
	}


	//Adapter
	
	Adapter selfAdapter = new AdapterImpl(){
		public void notifyChanged(Notification notification) {
			switch (notification.getFeatureID(Data.class)) {
			 case ConfigurationemfPackage.DATA__REF:
				Data data = (Data)notification.getNotifier();
				Ref newRef = (Ref)notification.getNewValue();
				Ref oldRef = (Ref)notification.getOldValue();
				switch(notification.getEventType()){
				case Notification.ADD:
					break;
				case Notification.REMOVE:
					handleRefRemove();
					break;
				 }
				 break;
			}
		}
	};
	
	protected void handleRefRemove(){
		if(this.getRef().isEmpty()){
			Configuration conf = (Configuration)this.eContainer();
			if(conf!=null)conf.setData(null);
			this.eAdapters().clear();
		}
	}
	
	
} //DataImpl