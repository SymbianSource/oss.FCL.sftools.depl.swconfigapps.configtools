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
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import configurationemf.Configuration;
import configurationemf.ConfigurationemfPackage;
import configurationemf.Data;
import configurationemf.EXTENSION_POLICY;
import configurationemf.ParentSetting;
import configurationemf.Ref;
import configurationemf.Referable;
import configurationemf.TYPE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link configurationemf.impl.RefImpl#getName <em>Name</em>}</li>
 *   <li>{@link configurationemf.impl.RefImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link configurationemf.impl.RefImpl#getReferable <em>Referable</em>}</li>
 *   <li>{@link configurationemf.impl.RefImpl#isTemplate <em>Template</em>}</li>
 *   <li>{@link configurationemf.impl.RefImpl#getExtensionPolicy <em>Extension Policy</em>}</li>
 *   <li>{@link configurationemf.impl.RefImpl#isEmpty <em>Empty</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RefImpl extends ContentImpl implements Ref {
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
	 * The cached value of the '{@link #getRef() <em>Ref</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRef()
	 * @generated
	 * @ordered
	 */
	protected EList<Ref> ref;

	/**
	 * The cached value of the '{@link #getReferable() <em>Referable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferable()
	 * @generated
	 * @ordered
	 */
	protected Referable referable;

	/**
	 * The default value of the '{@link #isTemplate() <em>Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTemplate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TEMPLATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTemplate() <em>Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTemplate()
	 * @generated
	 * @ordered
	 */
	protected boolean template = TEMPLATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getExtensionPolicy() <em>Extension Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensionPolicy()
	 * @generated
	 * @ordered
	 */
	protected static final EXTENSION_POLICY EXTENSION_POLICY_EDEFAULT = EXTENSION_POLICY.REPLACE;

	/**
	 * The cached value of the '{@link #getExtensionPolicy() <em>Extension Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensionPolicy()
	 * @generated
	 * @ordered
	 */
	protected EXTENSION_POLICY extensionPolicy = EXTENSION_POLICY_EDEFAULT;

	/**
	 * The default value of the '{@link #isEmpty() <em>Empty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEmpty()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EMPTY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEmpty() <em>Empty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEmpty()
	 * @generated
	 * @ordered
	 */
	protected boolean empty = EMPTY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected RefImpl() {
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
		return ConfigurationemfPackage.Literals.REF;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.REF__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Ref> getRef() {
		if (ref == null) {
			ref = new EObjectContainmentEList<Ref>(Ref.class, this, ConfigurationemfPackage.REF__REF);
		}
		return ref;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Referable getReferable() {
		if (referable != null && referable.eIsProxy()) {
			InternalEObject oldReferable = (InternalEObject)referable;
			referable = (Referable)eResolveProxy(oldReferable);
			if (referable != oldReferable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfigurationemfPackage.REF__REFERABLE, oldReferable, referable));
			}
		}
		return referable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Referable basicGetReferable() {
		return referable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReferable(Referable newReferable, NotificationChain msgs) {
		Referable oldReferable = referable;
		referable = newReferable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.REF__REFERABLE, oldReferable, newReferable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferable(Referable newReferable) {
		if (newReferable != referable) {
			NotificationChain msgs = null;
			if (referable != null)
				msgs = ((InternalEObject)referable).eInverseRemove(this, ConfigurationemfPackage.REFERABLE__REFS, Referable.class, msgs);
			if (newReferable != null)
				msgs = ((InternalEObject)newReferable).eInverseAdd(this, ConfigurationemfPackage.REFERABLE__REFS, Referable.class, msgs);
			msgs = basicSetReferable(newReferable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.REF__REFERABLE, newReferable, newReferable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTemplate() {
		return template;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemplate(boolean newTemplate) {
		boolean oldTemplate = template;
		template = newTemplate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.REF__TEMPLATE, oldTemplate, template));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EXTENSION_POLICY getExtensionPolicy() {
		return extensionPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtensionPolicy(EXTENSION_POLICY newExtensionPolicy) {
		EXTENSION_POLICY oldExtensionPolicy = extensionPolicy;
		extensionPolicy = newExtensionPolicy == null ? EXTENSION_POLICY_EDEFAULT : newExtensionPolicy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.REF__EXTENSION_POLICY, oldExtensionPolicy, extensionPolicy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEmpty() {
		return empty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEmpty(boolean newEmpty) {
		boolean oldEmpty = empty;
		empty = newEmpty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.REF__EMPTY, oldEmpty, empty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getAbsRef() {
		String csAbsRef="";
		if(this.eContainer() instanceof Data){
			csAbsRef = this.getName();			
		}else{
			Ref ref=(Ref)this.eContainer();
			if(ref.eContainer() instanceof Data){
				csAbsRef = ref.getName()+"/"+this.getName();
			}else if(ref.eContainer() instanceof Ref){
				csAbsRef =((Ref)ref.eContainer()).getName()+"/"+ref.getName()+"/"+this.getName();
			}
		}
		return csAbsRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Configuration getConfiguration() {
		while(this.eContainer() instanceof Ref)
			return ((Ref)this.eContainer()).getConfiguration();
		
		return (Configuration)((Data)this.eContainer()).eContainer();
			
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigurationemfPackage.REF__REFERABLE:
				if (referable != null)
					msgs = ((InternalEObject)referable).eInverseRemove(this, ConfigurationemfPackage.REFERABLE__REFS, Referable.class, msgs);
				return basicSetReferable((Referable)otherEnd, msgs);
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
			case ConfigurationemfPackage.REF__REF:
				return ((InternalEList<?>)getRef()).basicRemove(otherEnd, msgs);
			case ConfigurationemfPackage.REF__REFERABLE:
				return basicSetReferable(null, msgs);
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
			case ConfigurationemfPackage.REF__NAME:
				return getName();
			case ConfigurationemfPackage.REF__REF:
				return getRef();
			case ConfigurationemfPackage.REF__REFERABLE:
				if (resolve) return getReferable();
				return basicGetReferable();
			case ConfigurationemfPackage.REF__TEMPLATE:
				return isTemplate() ? Boolean.TRUE : Boolean.FALSE;
			case ConfigurationemfPackage.REF__EXTENSION_POLICY:
				return getExtensionPolicy();
			case ConfigurationemfPackage.REF__EMPTY:
				return isEmpty() ? Boolean.TRUE : Boolean.FALSE;
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
			case ConfigurationemfPackage.REF__NAME:
				setName((String)newValue);
				return;
			case ConfigurationemfPackage.REF__REF:
				getRef().clear();
				getRef().addAll((Collection<? extends Ref>)newValue);
				return;
			case ConfigurationemfPackage.REF__REFERABLE:
				setReferable((Referable)newValue);
				return;
			case ConfigurationemfPackage.REF__TEMPLATE:
				setTemplate(((Boolean)newValue).booleanValue());
				return;
			case ConfigurationemfPackage.REF__EXTENSION_POLICY:
				setExtensionPolicy((EXTENSION_POLICY)newValue);
				return;
			case ConfigurationemfPackage.REF__EMPTY:
				setEmpty(((Boolean)newValue).booleanValue());
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
			case ConfigurationemfPackage.REF__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ConfigurationemfPackage.REF__REF:
				getRef().clear();
				return;
			case ConfigurationemfPackage.REF__REFERABLE:
				setReferable((Referable)null);
				return;
			case ConfigurationemfPackage.REF__TEMPLATE:
				setTemplate(TEMPLATE_EDEFAULT);
				return;
			case ConfigurationemfPackage.REF__EXTENSION_POLICY:
				setExtensionPolicy(EXTENSION_POLICY_EDEFAULT);
				return;
			case ConfigurationemfPackage.REF__EMPTY:
				setEmpty(EMPTY_EDEFAULT);
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
			case ConfigurationemfPackage.REF__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ConfigurationemfPackage.REF__REF:
				return ref != null && !ref.isEmpty();
			case ConfigurationemfPackage.REF__REFERABLE:
				return referable != null;
			case ConfigurationemfPackage.REF__TEMPLATE:
				return template != TEMPLATE_EDEFAULT;
			case ConfigurationemfPackage.REF__EXTENSION_POLICY:
				return extensionPolicy != EXTENSION_POLICY_EDEFAULT;
			case ConfigurationemfPackage.REF__EMPTY:
				return empty != EMPTY_EDEFAULT;
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
		result.append(", template: ");
		result.append(template);
		result.append(", extensionPolicy: ");
		result.append(extensionPolicy);
		result.append(", empty: ");
		result.append(empty);
		result.append(')');
		return result.toString();
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
			switch (notification.getFeatureID(Ref.class)) {
			 case ConfigurationemfPackage.REF__REF:
				Ref ref = (Ref)notification.getNotifier();
			    switch(notification.getEventType()){
					case(Notification.REMOVE):
						handleRefRemoved();
						break;
				 }
				 break;
			 case ConfigurationemfPackage.DATA__REF:
				Ref ref1 = (Ref)notification.getNotifier();
			    switch(notification.getEventType()){
					case(Notification.REMOVE):
						handleRefRemoved();
						break;
				 }
				 break;
			}
		}
	};
	
	private void handleRefRemoved(){
		if(this.getReferable() instanceof ParentSetting){
			ParentSetting ps = (ParentSetting)this.getReferable();
			if(ps.getType()==TYPE.SEQUENCE)
				return;
		}
		
		if(this.getRef().isEmpty()){
			if(eContainer() instanceof Ref)
				((Ref)eContainer()).getRef().remove(this);
			else if(eContainer() instanceof Data)
				((Data)eContainer()).getRef().remove(this);
			this.eAdapters().clear();
				
			}
				
	}
} //RefImpl