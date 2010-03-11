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
 * Description: This file is part of com.nokia.tools.variant.content.confml.model component.
 */

package com.nokia.tools.s60ct.content.confml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.nokia.tools.s60ct.content.confml.ConfmlPackage;
import com.nokia.tools.s60ct.content.confml.OptionMapEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Option Map Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.OptionMapEntryImpl#getValue2Save <em>Value2 Save</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.OptionMapEntryImpl#getMapValue <em>Map Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OptionMapEntryImpl extends EObjectImpl implements OptionMapEntry {
	/**
	 * The default value of the '{@link #getValue2Save() <em>Value2 Save</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue2Save()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE2_SAVE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue2Save() <em>Value2 Save</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue2Save()
	 * @generated
	 * @ordered
	 */
	protected String value2Save = VALUE2_SAVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMapValue() <em>Map Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMapValue()
	 * @generated
	 * @ordered
	 */
	protected static final String MAP_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMapValue() <em>Map Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMapValue()
	 * @generated
	 * @ordered
	 */
	protected String mapValue = MAP_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OptionMapEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfmlPackage.Literals.OPTION_MAP_ENTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue2Save() {
		return value2Save;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue2Save(String newValue2Save) {
		String oldValue2Save = value2Save;
		value2Save = newValue2Save;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.OPTION_MAP_ENTRY__VALUE2_SAVE, oldValue2Save, value2Save));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMapValue() {
		return mapValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMapValue(String newMapValue) {
		String oldMapValue = mapValue;
		mapValue = newMapValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.OPTION_MAP_ENTRY__MAP_VALUE, oldMapValue, mapValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfmlPackage.OPTION_MAP_ENTRY__VALUE2_SAVE:
				return getValue2Save();
			case ConfmlPackage.OPTION_MAP_ENTRY__MAP_VALUE:
				return getMapValue();
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
			case ConfmlPackage.OPTION_MAP_ENTRY__VALUE2_SAVE:
				setValue2Save((String)newValue);
				return;
			case ConfmlPackage.OPTION_MAP_ENTRY__MAP_VALUE:
				setMapValue((String)newValue);
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
			case ConfmlPackage.OPTION_MAP_ENTRY__VALUE2_SAVE:
				setValue2Save(VALUE2_SAVE_EDEFAULT);
				return;
			case ConfmlPackage.OPTION_MAP_ENTRY__MAP_VALUE:
				setMapValue(MAP_VALUE_EDEFAULT);
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
			case ConfmlPackage.OPTION_MAP_ENTRY__VALUE2_SAVE:
				return VALUE2_SAVE_EDEFAULT == null ? value2Save != null : !VALUE2_SAVE_EDEFAULT.equals(value2Save);
			case ConfmlPackage.OPTION_MAP_ENTRY__MAP_VALUE:
				return MAP_VALUE_EDEFAULT == null ? mapValue != null : !MAP_VALUE_EDEFAULT.equals(mapValue);
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
		result.append(" (value2Save: ");
		result.append(value2Save);
		result.append(", mapValue: ");
		result.append(mapValue);
		result.append(')');
		return result.toString();
	}

} //OptionMapEntryImpl
