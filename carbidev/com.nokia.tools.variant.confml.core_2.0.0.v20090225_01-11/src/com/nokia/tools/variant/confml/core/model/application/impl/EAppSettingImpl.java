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

package com.nokia.tools.variant.confml.core.model.application.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.nokia.tools.variant.confml.core.model.application.EAppRfsInfo;
import com.nokia.tools.variant.confml.core.model.application.EAppSetting;
import com.nokia.tools.variant.confml.core.model.application.EAppSettingData;
import com.nokia.tools.variant.confml.core.model.application.EAppSettingType;
import com.nokia.tools.variant.confml.core.model.application.EApplicationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EApp Setting</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppSettingImpl#getRfsInfo <em>Rfs Info</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppSettingImpl#getTypeInfo <em>Type Info</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppSettingImpl#getValueInfo <em>Value Info</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppSettingImpl#getRef <em>Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EAppSettingImpl extends EObjectImpl implements EAppSetting {
	/**
     * The cached value of the '{@link #getRfsInfo() <em>Rfs Info</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getRfsInfo()
     * @generated
     * @ordered
     */
	protected EAppRfsInfo rfsInfo;

	/**
     * The cached value of the '{@link #getTypeInfo() <em>Type Info</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTypeInfo()
     * @generated
     * @ordered
     */
	protected EAppSettingType typeInfo;

	/**
     * The cached value of the '{@link #getValueInfo() <em>Value Info</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getValueInfo()
     * @generated
     * @ordered
     */
	protected EAppSettingData valueInfo;

	/**
     * The default value of the '{@link #getRef() <em>Ref</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getRef()
     * @generated
     * @ordered
     */
	protected static final String REF_EDEFAULT = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EAppSettingImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return EApplicationPackage.Literals.EAPP_SETTING;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAppSettingData getValueInfo() {
        return valueInfo;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetValueInfo(EAppSettingData newValueInfo, NotificationChain msgs) {
        EAppSettingData oldValueInfo = valueInfo;
        valueInfo = newValueInfo;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SETTING__VALUE_INFO, oldValueInfo, newValueInfo);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setValueInfo(EAppSettingData newValueInfo) {
        if (newValueInfo != valueInfo) {
            NotificationChain msgs = null;
            if (valueInfo != null)
                msgs = ((InternalEObject)valueInfo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EApplicationPackage.EAPP_SETTING__VALUE_INFO, null, msgs);
            if (newValueInfo != null)
                msgs = ((InternalEObject)newValueInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EApplicationPackage.EAPP_SETTING__VALUE_INFO, null, msgs);
            msgs = basicSetValueInfo(newValueInfo, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SETTING__VALUE_INFO, newValueInfo, newValueInfo));
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getRef() {
		EObject container = eContainer();
		if (container instanceof EAppSettingEntryImpl) {
			return ((EAppSettingEntryImpl) container).getKey();
		}

		return null;
	}

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAppSettingType getTypeInfo() {
        return typeInfo;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetTypeInfo(EAppSettingType newTypeInfo, NotificationChain msgs) {
        EAppSettingType oldTypeInfo = typeInfo;
        typeInfo = newTypeInfo;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SETTING__TYPE_INFO, oldTypeInfo, newTypeInfo);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTypeInfo(EAppSettingType newTypeInfo) {
        if (newTypeInfo != typeInfo) {
            NotificationChain msgs = null;
            if (typeInfo != null)
                msgs = ((InternalEObject)typeInfo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EApplicationPackage.EAPP_SETTING__TYPE_INFO, null, msgs);
            if (newTypeInfo != null)
                msgs = ((InternalEObject)newTypeInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EApplicationPackage.EAPP_SETTING__TYPE_INFO, null, msgs);
            msgs = basicSetTypeInfo(newTypeInfo, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SETTING__TYPE_INFO, newTypeInfo, newTypeInfo));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAppRfsInfo getRfsInfo() {
        return rfsInfo;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetRfsInfo(EAppRfsInfo newRfsInfo, NotificationChain msgs) {
        EAppRfsInfo oldRfsInfo = rfsInfo;
        rfsInfo = newRfsInfo;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SETTING__RFS_INFO, oldRfsInfo, newRfsInfo);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setRfsInfo(EAppRfsInfo newRfsInfo) {
        if (newRfsInfo != rfsInfo) {
            NotificationChain msgs = null;
            if (rfsInfo != null)
                msgs = ((InternalEObject)rfsInfo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EApplicationPackage.EAPP_SETTING__RFS_INFO, null, msgs);
            if (newRfsInfo != null)
                msgs = ((InternalEObject)newRfsInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EApplicationPackage.EAPP_SETTING__RFS_INFO, null, msgs);
            msgs = basicSetRfsInfo(newRfsInfo, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SETTING__RFS_INFO, newRfsInfo, newRfsInfo));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case EApplicationPackage.EAPP_SETTING__RFS_INFO:
                return basicSetRfsInfo(null, msgs);
            case EApplicationPackage.EAPP_SETTING__TYPE_INFO:
                return basicSetTypeInfo(null, msgs);
            case EApplicationPackage.EAPP_SETTING__VALUE_INFO:
                return basicSetValueInfo(null, msgs);
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
            case EApplicationPackage.EAPP_SETTING__RFS_INFO:
                return getRfsInfo();
            case EApplicationPackage.EAPP_SETTING__TYPE_INFO:
                return getTypeInfo();
            case EApplicationPackage.EAPP_SETTING__VALUE_INFO:
                return getValueInfo();
            case EApplicationPackage.EAPP_SETTING__REF:
                return getRef();
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
            case EApplicationPackage.EAPP_SETTING__RFS_INFO:
                setRfsInfo((EAppRfsInfo)newValue);
                return;
            case EApplicationPackage.EAPP_SETTING__TYPE_INFO:
                setTypeInfo((EAppSettingType)newValue);
                return;
            case EApplicationPackage.EAPP_SETTING__VALUE_INFO:
                setValueInfo((EAppSettingData)newValue);
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
            case EApplicationPackage.EAPP_SETTING__RFS_INFO:
                setRfsInfo((EAppRfsInfo)null);
                return;
            case EApplicationPackage.EAPP_SETTING__TYPE_INFO:
                setTypeInfo((EAppSettingType)null);
                return;
            case EApplicationPackage.EAPP_SETTING__VALUE_INFO:
                setValueInfo((EAppSettingData)null);
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
            case EApplicationPackage.EAPP_SETTING__RFS_INFO:
                return rfsInfo != null;
            case EApplicationPackage.EAPP_SETTING__TYPE_INFO:
                return typeInfo != null;
            case EApplicationPackage.EAPP_SETTING__VALUE_INFO:
                return valueInfo != null;
            case EApplicationPackage.EAPP_SETTING__REF:
                return REF_EDEFAULT == null ? getRef() != null : !REF_EDEFAULT.equals(getRef());
        }
        return super.eIsSet(featureID);
    }

} //EAppSettingImpl
