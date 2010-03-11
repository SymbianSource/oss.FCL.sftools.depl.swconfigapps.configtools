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

package com.nokia.tools.variant.confml.core.model.core.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.nokia.tools.variant.confml.core.model.application.EConfigurationProject;
import com.nokia.tools.variant.confml.core.model.core.EConfmlRootPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EProject Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.core.impl.EProjectEntryImpl#getTypedKey <em>Key</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.core.impl.EProjectEntryImpl#getTypedValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EProjectEntryImpl extends EObjectImpl implements BasicEMap.Entry<String,EConfigurationProject> {
	/**
     * The default value of the '{@link #getTypedKey() <em>Key</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTypedKey()
     * @generated
     * @ordered
     */
	protected static final String KEY_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getTypedKey() <em>Key</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTypedKey()
     * @generated
     * @ordered
     */
	protected String key = KEY_EDEFAULT;

	/**
     * The cached value of the '{@link #getTypedValue() <em>Value</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTypedValue()
     * @generated
     * @ordered
     */
	protected EConfigurationProject value;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EProjectEntryImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return EConfmlRootPackage.Literals.EPROJECT_ENTRY;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getTypedKey() {
        return key;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTypedKey(String newKey) {
        String oldKey = key;
        key = newKey;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EConfmlRootPackage.EPROJECT_ENTRY__KEY, oldKey, key));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EConfigurationProject getTypedValue() {
        return value;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetTypedValue(EConfigurationProject newValue, NotificationChain msgs) {
        EConfigurationProject oldValue = value;
        value = newValue;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EConfmlRootPackage.EPROJECT_ENTRY__VALUE, oldValue, newValue);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTypedValue(EConfigurationProject newValue) {
        if (newValue != value) {
            NotificationChain msgs = null;
            if (value != null)
                msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EConfmlRootPackage.EPROJECT_ENTRY__VALUE, null, msgs);
            if (newValue != null)
                msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EConfmlRootPackage.EPROJECT_ENTRY__VALUE, null, msgs);
            msgs = basicSetTypedValue(newValue, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EConfmlRootPackage.EPROJECT_ENTRY__VALUE, newValue, newValue));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case EConfmlRootPackage.EPROJECT_ENTRY__VALUE:
                return basicSetTypedValue(null, msgs);
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
            case EConfmlRootPackage.EPROJECT_ENTRY__KEY:
                return getTypedKey();
            case EConfmlRootPackage.EPROJECT_ENTRY__VALUE:
                return getTypedValue();
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
            case EConfmlRootPackage.EPROJECT_ENTRY__KEY:
                setTypedKey((String)newValue);
                return;
            case EConfmlRootPackage.EPROJECT_ENTRY__VALUE:
                setTypedValue((EConfigurationProject)newValue);
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
            case EConfmlRootPackage.EPROJECT_ENTRY__KEY:
                setTypedKey(KEY_EDEFAULT);
                return;
            case EConfmlRootPackage.EPROJECT_ENTRY__VALUE:
                setTypedValue((EConfigurationProject)null);
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
            case EConfmlRootPackage.EPROJECT_ENTRY__KEY:
                return KEY_EDEFAULT == null ? key != null : !KEY_EDEFAULT.equals(key);
            case EConfmlRootPackage.EPROJECT_ENTRY__VALUE:
                return value != null;
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
        result.append(" (key: ");
        result.append(key);
        result.append(')');
        return result.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected int hash = -1;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int getHash() {
        if (hash == -1) {
            Object theKey = getKey();
            hash = (theKey == null ? 0 : theKey.hashCode());
        }
        return hash;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setHash(int hash) {
        this.hash = hash;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getKey() {
        return getTypedKey();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setKey(String key) {
        setTypedKey(key);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EConfigurationProject getValue() {
        return getTypedValue();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EConfigurationProject setValue(EConfigurationProject value) {
        EConfigurationProject oldValue = getValue();
        setTypedValue(value);
        return oldValue;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@SuppressWarnings("unchecked")
	public EMap<String, EConfigurationProject> getEMap() {
        EObject container = eContainer();
        return container == null ? null : (EMap<String, EConfigurationProject>)container.eGet(eContainmentFeature());
    }

} //EProjectEntryImpl
