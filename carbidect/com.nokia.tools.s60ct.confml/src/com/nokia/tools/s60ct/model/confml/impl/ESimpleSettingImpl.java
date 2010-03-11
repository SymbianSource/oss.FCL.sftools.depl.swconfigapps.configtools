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
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.nokia.tools.s60ct.model.confml.ConfmlPackage;
import com.nokia.tools.s60ct.model.confml.ESettingOption;
import com.nokia.tools.s60ct.model.confml.ESettingValueType;
import com.nokia.tools.s60ct.model.confml.ESimpleSetting;
import com.nokia.tools.s60ct.model.confml.ESimpleValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ESimple Setting</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESimpleSettingImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESimpleSettingImpl#getMinInclusive <em>Min Inclusive</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESimpleSettingImpl#getMaxInclusive <em>Max Inclusive</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESimpleSettingImpl#getMinExclusive <em>Min Exclusive</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESimpleSettingImpl#getMaxExclusive <em>Max Exclusive</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESimpleSettingImpl#getMinLength <em>Min Length</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESimpleSettingImpl#getMaxLength <em>Max Length</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESimpleSettingImpl#getLength <em>Length</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESimpleSettingImpl#getPattern <em>Pattern</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESimpleSettingImpl#getTotalDigits <em>Total Digits</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESimpleSettingImpl#getOptions <em>Options</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ESimpleSettingImpl extends ESettingImpl implements ESimpleSetting {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final ESettingValueType TYPE_EDEFAULT = ESettingValueType.INTEGER;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected ESettingValueType type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinInclusive() <em>Min Inclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinInclusive()
	 * @generated
	 * @ordered
	 */
	protected static final String MIN_INCLUSIVE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinInclusive() <em>Min Inclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinInclusive()
	 * @generated
	 * @ordered
	 */
	protected String minInclusive = MIN_INCLUSIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxInclusive() <em>Max Inclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxInclusive()
	 * @generated
	 * @ordered
	 */
	protected static final String MAX_INCLUSIVE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxInclusive() <em>Max Inclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxInclusive()
	 * @generated
	 * @ordered
	 */
	protected String maxInclusive = MAX_INCLUSIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinExclusive() <em>Min Exclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinExclusive()
	 * @generated
	 * @ordered
	 */
	protected static final String MIN_EXCLUSIVE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinExclusive() <em>Min Exclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinExclusive()
	 * @generated
	 * @ordered
	 */
	protected String minExclusive = MIN_EXCLUSIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxExclusive() <em>Max Exclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxExclusive()
	 * @generated
	 * @ordered
	 */
	protected static final String MAX_EXCLUSIVE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxExclusive() <em>Max Exclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxExclusive()
	 * @generated
	 * @ordered
	 */
	protected String maxExclusive = MAX_EXCLUSIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinLength() <em>Min Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinLength()
	 * @generated
	 * @ordered
	 */
	protected static final Integer MIN_LENGTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinLength() <em>Min Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinLength()
	 * @generated
	 * @ordered
	 */
	protected Integer minLength = MIN_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxLength() <em>Max Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxLength()
	 * @generated
	 * @ordered
	 */
	protected static final Integer MAX_LENGTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxLength() <em>Max Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxLength()
	 * @generated
	 * @ordered
	 */
	protected Integer maxLength = MAX_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getLength() <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
	protected static final Integer LENGTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLength() <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
	protected Integer length = LENGTH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPattern() <em>Pattern</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected EList<String> pattern;

	/**
	 * The default value of the '{@link #getTotalDigits() <em>Total Digits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalDigits()
	 * @generated
	 * @ordered
	 */
	protected static final Integer TOTAL_DIGITS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTotalDigits() <em>Total Digits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalDigits()
	 * @generated
	 * @ordered
	 */
	protected Integer totalDigits = TOTAL_DIGITS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOptions() <em>Options</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptions()
	 * @generated
	 * @ordered
	 */
	protected EList<ESettingOption> options;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ESimpleSettingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfmlPackage.Literals.ESIMPLE_SETTING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESettingValueType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(ESettingValueType newType) {
		ESettingValueType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESIMPLE_SETTING__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMinInclusive() {
		return minInclusive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinInclusive(String newMinInclusive) {
		String oldMinInclusive = minInclusive;
		minInclusive = newMinInclusive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESIMPLE_SETTING__MIN_INCLUSIVE, oldMinInclusive, minInclusive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaxInclusive() {
		return maxInclusive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxInclusive(String newMaxInclusive) {
		String oldMaxInclusive = maxInclusive;
		maxInclusive = newMaxInclusive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESIMPLE_SETTING__MAX_INCLUSIVE, oldMaxInclusive, maxInclusive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMinExclusive() {
		return minExclusive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinExclusive(String newMinExclusive) {
		String oldMinExclusive = minExclusive;
		minExclusive = newMinExclusive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESIMPLE_SETTING__MIN_EXCLUSIVE, oldMinExclusive, minExclusive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaxExclusive() {
		return maxExclusive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxExclusive(String newMaxExclusive) {
		String oldMaxExclusive = maxExclusive;
		maxExclusive = newMaxExclusive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESIMPLE_SETTING__MAX_EXCLUSIVE, oldMaxExclusive, maxExclusive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getMinLength() {
		return minLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinLength(Integer newMinLength) {
		Integer oldMinLength = minLength;
		minLength = newMinLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESIMPLE_SETTING__MIN_LENGTH, oldMinLength, minLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getMaxLength() {
		return maxLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxLength(Integer newMaxLength) {
		Integer oldMaxLength = maxLength;
		maxLength = newMaxLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESIMPLE_SETTING__MAX_LENGTH, oldMaxLength, maxLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getLength() {
		return length;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLength(Integer newLength) {
		Integer oldLength = length;
		length = newLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESIMPLE_SETTING__LENGTH, oldLength, length));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getPattern() {
		if (pattern == null) {
			pattern = new EDataTypeUniqueEList<String>(String.class, this, ConfmlPackage.ESIMPLE_SETTING__PATTERN);
		}
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getTotalDigits() {
		return totalDigits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalDigits(Integer newTotalDigits) {
		Integer oldTotalDigits = totalDigits;
		totalDigits = newTotalDigits;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESIMPLE_SETTING__TOTAL_DIGITS, oldTotalDigits, totalDigits));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ESettingOption> getOptions() {
		if (options == null) {
			options = new EObjectContainmentEList<ESettingOption>(ESettingOption.class, this, ConfmlPackage.ESIMPLE_SETTING__OPTIONS);
		}
		return options;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfmlPackage.ESIMPLE_SETTING__OPTIONS:
				return ((InternalEList<?>)getOptions()).basicRemove(otherEnd, msgs);
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
			case ConfmlPackage.ESIMPLE_SETTING__TYPE:
				return getType();
			case ConfmlPackage.ESIMPLE_SETTING__MIN_INCLUSIVE:
				return getMinInclusive();
			case ConfmlPackage.ESIMPLE_SETTING__MAX_INCLUSIVE:
				return getMaxInclusive();
			case ConfmlPackage.ESIMPLE_SETTING__MIN_EXCLUSIVE:
				return getMinExclusive();
			case ConfmlPackage.ESIMPLE_SETTING__MAX_EXCLUSIVE:
				return getMaxExclusive();
			case ConfmlPackage.ESIMPLE_SETTING__MIN_LENGTH:
				return getMinLength();
			case ConfmlPackage.ESIMPLE_SETTING__MAX_LENGTH:
				return getMaxLength();
			case ConfmlPackage.ESIMPLE_SETTING__LENGTH:
				return getLength();
			case ConfmlPackage.ESIMPLE_SETTING__PATTERN:
				return getPattern();
			case ConfmlPackage.ESIMPLE_SETTING__TOTAL_DIGITS:
				return getTotalDigits();
			case ConfmlPackage.ESIMPLE_SETTING__OPTIONS:
				return getOptions();
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
			case ConfmlPackage.ESIMPLE_SETTING__TYPE:
				setType((ESettingValueType)newValue);
				return;
			case ConfmlPackage.ESIMPLE_SETTING__MIN_INCLUSIVE:
				setMinInclusive((String)newValue);
				return;
			case ConfmlPackage.ESIMPLE_SETTING__MAX_INCLUSIVE:
				setMaxInclusive((String)newValue);
				return;
			case ConfmlPackage.ESIMPLE_SETTING__MIN_EXCLUSIVE:
				setMinExclusive((String)newValue);
				return;
			case ConfmlPackage.ESIMPLE_SETTING__MAX_EXCLUSIVE:
				setMaxExclusive((String)newValue);
				return;
			case ConfmlPackage.ESIMPLE_SETTING__MIN_LENGTH:
				setMinLength((Integer)newValue);
				return;
			case ConfmlPackage.ESIMPLE_SETTING__MAX_LENGTH:
				setMaxLength((Integer)newValue);
				return;
			case ConfmlPackage.ESIMPLE_SETTING__LENGTH:
				setLength((Integer)newValue);
				return;
			case ConfmlPackage.ESIMPLE_SETTING__PATTERN:
				getPattern().clear();
				getPattern().addAll((Collection<? extends String>)newValue);
				return;
			case ConfmlPackage.ESIMPLE_SETTING__TOTAL_DIGITS:
				setTotalDigits((Integer)newValue);
				return;
			case ConfmlPackage.ESIMPLE_SETTING__OPTIONS:
				getOptions().clear();
				getOptions().addAll((Collection<? extends ESettingOption>)newValue);
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
			case ConfmlPackage.ESIMPLE_SETTING__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ConfmlPackage.ESIMPLE_SETTING__MIN_INCLUSIVE:
				setMinInclusive(MIN_INCLUSIVE_EDEFAULT);
				return;
			case ConfmlPackage.ESIMPLE_SETTING__MAX_INCLUSIVE:
				setMaxInclusive(MAX_INCLUSIVE_EDEFAULT);
				return;
			case ConfmlPackage.ESIMPLE_SETTING__MIN_EXCLUSIVE:
				setMinExclusive(MIN_EXCLUSIVE_EDEFAULT);
				return;
			case ConfmlPackage.ESIMPLE_SETTING__MAX_EXCLUSIVE:
				setMaxExclusive(MAX_EXCLUSIVE_EDEFAULT);
				return;
			case ConfmlPackage.ESIMPLE_SETTING__MIN_LENGTH:
				setMinLength(MIN_LENGTH_EDEFAULT);
				return;
			case ConfmlPackage.ESIMPLE_SETTING__MAX_LENGTH:
				setMaxLength(MAX_LENGTH_EDEFAULT);
				return;
			case ConfmlPackage.ESIMPLE_SETTING__LENGTH:
				setLength(LENGTH_EDEFAULT);
				return;
			case ConfmlPackage.ESIMPLE_SETTING__PATTERN:
				getPattern().clear();
				return;
			case ConfmlPackage.ESIMPLE_SETTING__TOTAL_DIGITS:
				setTotalDigits(TOTAL_DIGITS_EDEFAULT);
				return;
			case ConfmlPackage.ESIMPLE_SETTING__OPTIONS:
				getOptions().clear();
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
			case ConfmlPackage.ESIMPLE_SETTING__TYPE:
				return type != TYPE_EDEFAULT;
			case ConfmlPackage.ESIMPLE_SETTING__MIN_INCLUSIVE:
				return MIN_INCLUSIVE_EDEFAULT == null ? minInclusive != null : !MIN_INCLUSIVE_EDEFAULT.equals(minInclusive);
			case ConfmlPackage.ESIMPLE_SETTING__MAX_INCLUSIVE:
				return MAX_INCLUSIVE_EDEFAULT == null ? maxInclusive != null : !MAX_INCLUSIVE_EDEFAULT.equals(maxInclusive);
			case ConfmlPackage.ESIMPLE_SETTING__MIN_EXCLUSIVE:
				return MIN_EXCLUSIVE_EDEFAULT == null ? minExclusive != null : !MIN_EXCLUSIVE_EDEFAULT.equals(minExclusive);
			case ConfmlPackage.ESIMPLE_SETTING__MAX_EXCLUSIVE:
				return MAX_EXCLUSIVE_EDEFAULT == null ? maxExclusive != null : !MAX_EXCLUSIVE_EDEFAULT.equals(maxExclusive);
			case ConfmlPackage.ESIMPLE_SETTING__MIN_LENGTH:
				return MIN_LENGTH_EDEFAULT == null ? minLength != null : !MIN_LENGTH_EDEFAULT.equals(minLength);
			case ConfmlPackage.ESIMPLE_SETTING__MAX_LENGTH:
				return MAX_LENGTH_EDEFAULT == null ? maxLength != null : !MAX_LENGTH_EDEFAULT.equals(maxLength);
			case ConfmlPackage.ESIMPLE_SETTING__LENGTH:
				return LENGTH_EDEFAULT == null ? length != null : !LENGTH_EDEFAULT.equals(length);
			case ConfmlPackage.ESIMPLE_SETTING__PATTERN:
				return pattern != null && !pattern.isEmpty();
			case ConfmlPackage.ESIMPLE_SETTING__TOTAL_DIGITS:
				return TOTAL_DIGITS_EDEFAULT == null ? totalDigits != null : !TOTAL_DIGITS_EDEFAULT.equals(totalDigits);
			case ConfmlPackage.ESIMPLE_SETTING__OPTIONS:
				return options != null && !options.isEmpty();
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
		result.append(" (type: ");
		result.append(type);
		result.append(", minInclusive: ");
		result.append(minInclusive);
		result.append(", maxInclusive: ");
		result.append(maxInclusive);
		result.append(", minExclusive: ");
		result.append(minExclusive);
		result.append(", maxExclusive: ");
		result.append(maxExclusive);
		result.append(", minLength: ");
		result.append(minLength);
		result.append(", maxLength: ");
		result.append(maxLength);
		result.append(", length: ");
		result.append(length);
		result.append(", pattern: ");
		result.append(pattern);
		result.append(", totalDigits: ");
		result.append(totalDigits);
		result.append(')');
		return result.toString();
	}

	@Override
	public void clearDirty() {
		setModified(false);
	}

	@Override
	public boolean isDirty() {
		ESimpleValue currentValue = (ESimpleValue) getValue();
		ESimpleValue defaultValue = (ESimpleValue) getDefaultValue();
		if (currentValue == null || currentValue.getValue() == null) {
			return false;			
		} else if ((defaultValue == null || defaultValue.getValue() == null) 
				&& isModified()) {
			return true;		
		} 
		else if (defaultValue.getValue() == null)
		{
			return false;
		}
		else if ((currentValue.getValue().compareTo(defaultValue.getValue()) != 0)
				&& isModified()) {				
			return true;
		} if ((currentValue.getValue().compareTo(defaultValue.getValue()) == 0)
				&& isModified()) {				
			return true;
		} else {
			return false;				
		}
	}

	@Override
	public boolean isDefault() {
		ESimpleValue settingValue = (ESimpleValue) getValue();
		ESimpleValue defaultValue = (ESimpleValue) getDefaultValue();
		
		if((settingValue!=null)&&(defaultValue!=null)&&(defaultValue.getMap()!=null)
		   &&(settingValue.getMap()!=null)&&(settingValue.getMap() != defaultValue.getMap())
		   && settingValue.getChosenOption()!=null)
			return false;
		else if((settingValue!=null)&&(defaultValue!=null)&&(defaultValue.getTrueValue()!=null)
				&&(settingValue.getTrueValue()!=null)&&(settingValue.getTrueValue() != defaultValue.getTrueValue()))
			return false;
		else 
			return true;

	}

} //ESimpleSettingImpl
