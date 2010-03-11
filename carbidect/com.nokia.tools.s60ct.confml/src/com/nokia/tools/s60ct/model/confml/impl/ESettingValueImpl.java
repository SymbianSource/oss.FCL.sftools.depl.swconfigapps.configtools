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
import com.nokia.tools.s60ct.model.confml.ESetting;
import com.nokia.tools.s60ct.model.confml.ESettingValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ESetting Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESettingValueImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESettingValueImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESettingValueImpl#getMap <em>Map</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESettingValueImpl#getChosenOption <em>Chosen Option</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ESettingValueImpl extends EObjectImpl implements ESettingValue {
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
	 * The cached value of the '{@link #getRef() <em>Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRef()
	 * @generated
	 * @ordered
	 */
	protected String ref = REF_EDEFAULT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected ESetting type;

	/**
	 * The default value of the '{@link #getMap() <em>Map</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMap()
	 * @generated
	 * @ordered
	 */
	protected static final String MAP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMap() <em>Map</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMap()
	 * @generated
	 * @ordered
	 */
	protected String map = MAP_EDEFAULT;

	/**
	 * The default value of the '{@link #getChosenOption() <em>Chosen Option</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChosenOption()
	 * @generated
	 * @ordered
	 */
	protected static final String CHOSEN_OPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getChosenOption() <em>Chosen Option</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChosenOption()
	 * @generated
	 * @ordered
	 */
	protected String chosenOption = CHOSEN_OPTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ESettingValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfmlPackage.Literals.ESETTING_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRef() {
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRef(String newRef) {
		String oldRef = ref;
		ref = newRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING_VALUE__REF, oldRef, ref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESetting getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (ESetting)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfmlPackage.ESETTING_VALUE__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESetting basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(ESetting newType) {
		ESetting oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING_VALUE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMap() {
		return map;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMap(String newMap) {
		String oldMap = map;
		map = newMap;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING_VALUE__MAP, oldMap, map));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getChosenOption() {
		return chosenOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChosenOption(String newChosenOption) {
		String oldChosenOption = chosenOption;
		chosenOption = newChosenOption;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING_VALUE__CHOSEN_OPTION, oldChosenOption, chosenOption));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfmlPackage.ESETTING_VALUE__REF:
				return getRef();
			case ConfmlPackage.ESETTING_VALUE__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case ConfmlPackage.ESETTING_VALUE__MAP:
				return getMap();
			case ConfmlPackage.ESETTING_VALUE__CHOSEN_OPTION:
				return getChosenOption();
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
			case ConfmlPackage.ESETTING_VALUE__REF:
				setRef((String)newValue);
				return;
			case ConfmlPackage.ESETTING_VALUE__TYPE:
				setType((ESetting)newValue);
				return;
			case ConfmlPackage.ESETTING_VALUE__MAP:
				setMap((String)newValue);
				return;
			case ConfmlPackage.ESETTING_VALUE__CHOSEN_OPTION:
				setChosenOption((String)newValue);
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
			case ConfmlPackage.ESETTING_VALUE__REF:
				setRef(REF_EDEFAULT);
				return;
			case ConfmlPackage.ESETTING_VALUE__TYPE:
				setType((ESetting)null);
				return;
			case ConfmlPackage.ESETTING_VALUE__MAP:
				setMap(MAP_EDEFAULT);
				return;
			case ConfmlPackage.ESETTING_VALUE__CHOSEN_OPTION:
				setChosenOption(CHOSEN_OPTION_EDEFAULT);
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
			case ConfmlPackage.ESETTING_VALUE__REF:
				return REF_EDEFAULT == null ? ref != null : !REF_EDEFAULT.equals(ref);
			case ConfmlPackage.ESETTING_VALUE__TYPE:
				return type != null;
			case ConfmlPackage.ESETTING_VALUE__MAP:
				return MAP_EDEFAULT == null ? map != null : !MAP_EDEFAULT.equals(map);
			case ConfmlPackage.ESETTING_VALUE__CHOSEN_OPTION:
				return CHOSEN_OPTION_EDEFAULT == null ? chosenOption != null : !CHOSEN_OPTION_EDEFAULT.equals(chosenOption);
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
		result.append(" (ref: ");
		result.append(ref);
		result.append(", map: ");
		result.append(map);
		result.append(", chosenOption: ");
		result.append(chosenOption);
		result.append(')');
		return result.toString();
	}

} //ESettingValueImpl
