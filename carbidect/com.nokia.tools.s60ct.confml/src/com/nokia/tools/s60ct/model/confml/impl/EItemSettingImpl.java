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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.nokia.tools.s60ct.model.confml.ConfmlPackage;
import com.nokia.tools.s60ct.model.confml.EItemSetting;
import com.nokia.tools.s60ct.model.confml.ESetting;
import com.nokia.tools.s60ct.model.confml.ESubSettingValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EItem Setting</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.EItemSettingImpl#getNumber <em>Number</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.EItemSettingImpl#getSubSettings <em>Sub Settings</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.EItemSettingImpl#getFields <em>Fields</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EItemSettingImpl extends EObjectImpl implements EItemSetting {
	/**
	 * The default value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected int number = NUMBER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSubSettings() <em>Sub Settings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubSettings()
	 * @generated
	 * @ordered
	 */
	protected EList<ESubSettingValue> subSettings;

	/**
	 * The cached value of the '{@link #getFields() <em>Fields</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFields()
	 * @generated
	 * @ordered
	 */
	protected EList<ESetting> fields;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EItemSettingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfmlPackage.Literals.EITEM_SETTING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumber(int newNumber) {
		int oldNumber = number;
		number = newNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.EITEM_SETTING__NUMBER, oldNumber, number));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ESubSettingValue> getSubSettings() {
		if (subSettings == null) {
			subSettings = new EObjectContainmentEList<ESubSettingValue>(ESubSettingValue.class, this, ConfmlPackage.EITEM_SETTING__SUB_SETTINGS);
		}
		return subSettings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ESetting> getFields() {
		if (fields == null) {
			fields = new EObjectContainmentEList<ESetting>(ESetting.class, this, ConfmlPackage.EITEM_SETTING__FIELDS);
		}
		return fields;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfmlPackage.EITEM_SETTING__SUB_SETTINGS:
				return ((InternalEList<?>)getSubSettings()).basicRemove(otherEnd, msgs);
			case ConfmlPackage.EITEM_SETTING__FIELDS:
				return ((InternalEList<?>)getFields()).basicRemove(otherEnd, msgs);
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
			case ConfmlPackage.EITEM_SETTING__NUMBER:
				return new Integer(getNumber());
			case ConfmlPackage.EITEM_SETTING__SUB_SETTINGS:
				return getSubSettings();
			case ConfmlPackage.EITEM_SETTING__FIELDS:
				return getFields();
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
			case ConfmlPackage.EITEM_SETTING__NUMBER:
				setNumber(((Integer)newValue).intValue());
				return;
			case ConfmlPackage.EITEM_SETTING__SUB_SETTINGS:
				getSubSettings().clear();
				getSubSettings().addAll((Collection<? extends ESubSettingValue>)newValue);
				return;
			case ConfmlPackage.EITEM_SETTING__FIELDS:
				getFields().clear();
				getFields().addAll((Collection<? extends ESetting>)newValue);
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
			case ConfmlPackage.EITEM_SETTING__NUMBER:
				setNumber(NUMBER_EDEFAULT);
				return;
			case ConfmlPackage.EITEM_SETTING__SUB_SETTINGS:
				getSubSettings().clear();
				return;
			case ConfmlPackage.EITEM_SETTING__FIELDS:
				getFields().clear();
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
			case ConfmlPackage.EITEM_SETTING__NUMBER:
				return number != NUMBER_EDEFAULT;
			case ConfmlPackage.EITEM_SETTING__SUB_SETTINGS:
				return subSettings != null && !subSettings.isEmpty();
			case ConfmlPackage.EITEM_SETTING__FIELDS:
				return fields != null && !fields.isEmpty();
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
		result.append(" (number: ");
		result.append(number);
		result.append(')');
		return result.toString();
	}

} //EItemSettingImpl
