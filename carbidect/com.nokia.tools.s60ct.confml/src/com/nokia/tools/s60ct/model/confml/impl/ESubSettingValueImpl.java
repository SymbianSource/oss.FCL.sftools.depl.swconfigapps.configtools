/*
* Copyright (c) 2007 Nokia Corporation and/or its subsidiary(-ies). 
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
package com.nokia.tools.s60ct.model.confml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.nokia.tools.s60ct.model.confml.ConfmlPackage;
import com.nokia.tools.s60ct.model.confml.ESimpleSetting;
import com.nokia.tools.s60ct.model.confml.ESubSettingValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ESub Setting Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESubSettingValueImpl#getSimpleSetting <em>Simple Setting</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ESubSettingValueImpl extends EObjectImpl implements ESubSettingValue {
	/**
	 * The cached value of the '{@link #getSimpleSetting() <em>Simple Setting</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleSetting()
	 * @generated
	 * @ordered
	 */
	protected ESimpleSetting simpleSetting;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ESubSettingValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfmlPackage.Literals.ESUB_SETTING_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESimpleSetting getSimpleSetting() {
		if (simpleSetting != null && simpleSetting.eIsProxy()) {
			InternalEObject oldSimpleSetting = (InternalEObject)simpleSetting;
			simpleSetting = (ESimpleSetting)eResolveProxy(oldSimpleSetting);
			if (simpleSetting != oldSimpleSetting) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfmlPackage.ESUB_SETTING_VALUE__SIMPLE_SETTING, oldSimpleSetting, simpleSetting));
			}
		}
		return simpleSetting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESimpleSetting basicGetSimpleSetting() {
		return simpleSetting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimpleSetting(ESimpleSetting newSimpleSetting) {
		ESimpleSetting oldSimpleSetting = simpleSetting;
		simpleSetting = newSimpleSetting;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESUB_SETTING_VALUE__SIMPLE_SETTING, oldSimpleSetting, simpleSetting));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfmlPackage.ESUB_SETTING_VALUE__SIMPLE_SETTING:
				if (resolve) return getSimpleSetting();
				return basicGetSimpleSetting();
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
			case ConfmlPackage.ESUB_SETTING_VALUE__SIMPLE_SETTING:
				setSimpleSetting((ESimpleSetting)newValue);
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
			case ConfmlPackage.ESUB_SETTING_VALUE__SIMPLE_SETTING:
				setSimpleSetting((ESimpleSetting)null);
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
			case ConfmlPackage.ESUB_SETTING_VALUE__SIMPLE_SETTING:
				return simpleSetting != null;
		}
		return super.eIsSet(featureID);
	}

} //ESubSettingValueImpl
