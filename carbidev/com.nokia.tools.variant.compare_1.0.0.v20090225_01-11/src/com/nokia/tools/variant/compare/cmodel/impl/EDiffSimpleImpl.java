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
 * Description: This file is part of com.nokia.tools.variant.compare component.
 */

package com.nokia.tools.variant.compare.cmodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.nokia.tools.variant.compare.cmodel.ECompareModelPackage;
import com.nokia.tools.variant.compare.cmodel.EDiffSimple;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EDiff Simple</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.impl.EDiffSimpleImpl#getSourceValue <em>Source Value</em>}</li>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.impl.EDiffSimpleImpl#getTargetValue <em>Target Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EDiffSimpleImpl extends EDiffSettingImpl implements EDiffSimple {
	/**
	 * The default value of the '{@link #getSourceValue() <em>Source Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceValue()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceValue() <em>Source Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceValue()
	 * @generated
	 * @ordered
	 */
	protected String sourceValue = SOURCE_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetValue() <em>Target Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetValue()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetValue() <em>Target Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetValue()
	 * @generated
	 * @ordered
	 */
	protected String targetValue = TARGET_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EDiffSimpleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ECompareModelPackage.Literals.EDIFF_SIMPLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceValue() {
		return sourceValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceValue(String newSourceValue) {
		String oldSourceValue = sourceValue;
		sourceValue = newSourceValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECompareModelPackage.EDIFF_SIMPLE__SOURCE_VALUE, oldSourceValue, sourceValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetValue() {
		return targetValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetValue(String newTargetValue) {
		String oldTargetValue = targetValue;
		targetValue = newTargetValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECompareModelPackage.EDIFF_SIMPLE__TARGET_VALUE, oldTargetValue, targetValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ECompareModelPackage.EDIFF_SIMPLE__SOURCE_VALUE:
				return getSourceValue();
			case ECompareModelPackage.EDIFF_SIMPLE__TARGET_VALUE:
				return getTargetValue();
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
			case ECompareModelPackage.EDIFF_SIMPLE__SOURCE_VALUE:
				setSourceValue((String)newValue);
				return;
			case ECompareModelPackage.EDIFF_SIMPLE__TARGET_VALUE:
				setTargetValue((String)newValue);
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
			case ECompareModelPackage.EDIFF_SIMPLE__SOURCE_VALUE:
				setSourceValue(SOURCE_VALUE_EDEFAULT);
				return;
			case ECompareModelPackage.EDIFF_SIMPLE__TARGET_VALUE:
				setTargetValue(TARGET_VALUE_EDEFAULT);
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
			case ECompareModelPackage.EDIFF_SIMPLE__SOURCE_VALUE:
				return SOURCE_VALUE_EDEFAULT == null ? sourceValue != null : !SOURCE_VALUE_EDEFAULT.equals(sourceValue);
			case ECompareModelPackage.EDIFF_SIMPLE__TARGET_VALUE:
				return TARGET_VALUE_EDEFAULT == null ? targetValue != null : !TARGET_VALUE_EDEFAULT.equals(targetValue);
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
		result.append(" (sourceValue: ");
		result.append(sourceValue);
		result.append(", targetValue: ");
		result.append(targetValue);
		result.append(')');
		return result.toString();
	}

} //EDiffSimpleImpl
