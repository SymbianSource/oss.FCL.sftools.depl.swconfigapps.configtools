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

import java.math.BigInteger;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import com.nokia.tools.s60ct.content.confml.ConfmlPackage;
import com.nokia.tools.s60ct.content.confml.MaxExclusive;
import com.nokia.tools.s60ct.content.confml.MaxInclusive;
import com.nokia.tools.s60ct.content.confml.MinExclusive;
import com.nokia.tools.s60ct.content.confml.MinInclusive;
import com.nokia.tools.s60ct.content.confml.Option;
import com.nokia.tools.s60ct.content.confml.OptionMapEntry;
import com.nokia.tools.s60ct.content.confml.SequenceItem;
import com.nokia.tools.s60ct.content.confml.SequenceSetting;
import com.nokia.tools.s60ct.content.confml.Setting;
import com.nokia.tools.s60ct.content.confml.SimpleSetting;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Simple Setting</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SimpleSettingImpl#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SimpleSettingImpl#getValue <em>Value</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SimpleSettingImpl#getLastSavedValue <em>Last Saved Value</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SimpleSettingImpl#getMinLength <em>Min Length</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SimpleSettingImpl#getMaxLength <em>Max Length</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SimpleSettingImpl#getLength <em>Length</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SimpleSettingImpl#getPattern <em>Pattern</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SimpleSettingImpl#getTotalDigits <em>Total Digits</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SimpleSettingImpl#getMaxExclusive <em>Max Exclusive</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SimpleSettingImpl#getMinExclusive <em>Min Exclusive</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SimpleSettingImpl#getMaxInclusive <em>Max Inclusive</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SimpleSettingImpl#getMinInclusive <em>Min Inclusive</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SimpleSettingImpl#isContainedInLastLayer <em>Contained In Last Layer</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SimpleSettingImpl#isLastSavedInLastLayer <em>Last Saved In Last Layer</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SimpleSettingImpl#getChosenOption <em>Chosen Option</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleSettingImpl extends SettingImpl implements SimpleSetting {
	/**
	 * The default value of the '{@link #getDefaultValue()
	 * <em>Default Value</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getDefaultValue()
	 * @generated NOT
	 * @ordered
	 */
	protected static final String DEFAULT_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultValue() <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected String defaultValue = DEFAULT_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getValue()
	 * @generated NOT
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLastSavedValue() <em>Last Saved Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getLastSavedValue()
	 * @generated
	 * @ordered
	 */
	protected static final String LAST_SAVED_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastSavedValue() <em>Last Saved Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getLastSavedValue()
	 * @generated
	 * @ordered
	 */
	protected String lastSavedValue = LAST_SAVED_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinLength() <em>Min Length</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMinLength()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger MIN_LENGTH_EDEFAULT = new BigInteger("-1");

	/**
	 * The cached value of the '{@link #getMinLength() <em>Min Length</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMinLength()
	 * @generated
	 * @ordered
	 */
	protected BigInteger minLength = MIN_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxLength() <em>Max Length</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMaxLength()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger MAX_LENGTH_EDEFAULT = new BigInteger("-1");

	/**
	 * The cached value of the '{@link #getMaxLength() <em>Max Length</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMaxLength()
	 * @generated
	 * @ordered
	 */
	protected BigInteger maxLength = MAX_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getLength() <em>Length</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger LENGTH_EDEFAULT = new BigInteger("-1");

	/**
	 * The cached value of the '{@link #getLength() <em>Length</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
	protected BigInteger length = LENGTH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPattern() <em>Pattern</em>}' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected EList<String> pattern;

	/**
	 * The default value of the '{@link #getTotalDigits() <em>Total Digits</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTotalDigits()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger TOTAL_DIGITS_EDEFAULT = new BigInteger("-1");

	/**
	 * The cached value of the '{@link #getTotalDigits() <em>Total Digits</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTotalDigits()
	 * @generated
	 * @ordered
	 */
	protected BigInteger totalDigits = TOTAL_DIGITS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMaxExclusive() <em>Max Exclusive</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getMaxExclusive()
	 * @generated
	 * @ordered
	 */
	protected MaxExclusive maxExclusive;

	/**
	 * The cached value of the '{@link #getMinExclusive() <em>Min Exclusive</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getMinExclusive()
	 * @generated
	 * @ordered
	 */
	protected MinExclusive minExclusive;

	/**
	 * The cached value of the '{@link #getMaxInclusive() <em>Max Inclusive</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getMaxInclusive()
	 * @generated
	 * @ordered
	 */
	protected MaxInclusive maxInclusive;

	/**
	 * The cached value of the '{@link #getMinInclusive() <em>Min Inclusive</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getMinInclusive()
	 * @generated
	 * @ordered
	 */
	protected MinInclusive minInclusive;

	/**
	 * The default value of the '{@link #isContainedInLastLayer() <em>Contained In Last Layer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContainedInLastLayer()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONTAINED_IN_LAST_LAYER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isContainedInLastLayer() <em>Contained In Last Layer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContainedInLastLayer()
	 * @generated
	 * @ordered
	 */
	protected boolean containedInLastLayer = CONTAINED_IN_LAST_LAYER_EDEFAULT;

	/**
	 * The default value of the '{@link #isLastSavedInLastLayer() <em>Last Saved In Last Layer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLastSavedInLastLayer()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LAST_SAVED_IN_LAST_LAYER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isLastSavedInLastLayer() <em>Last Saved In Last Layer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLastSavedInLastLayer()
	 * @generated
	 * @ordered
	 */
	protected boolean lastSavedInLastLayer = LAST_SAVED_IN_LAST_LAYER_EDEFAULT;

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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleSettingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfmlPackage.Literals.SIMPLE_SETTING;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultValue() {
		return defaultValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultValue(String newDefaultValue) {
		String oldDefaultValue = defaultValue;
		defaultValue = newDefaultValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.SIMPLE_SETTING__DEFAULT_VALUE, oldDefaultValue, defaultValue));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		// if value is one of options, then remember it
		chosenOption = null;
		if (option != null && newValue!=null) {
			for (Option opt : option) {
				Map<String, OptionMapEntry> optionValues = opt.getOptionValues();
				if (optionValues != null) {
					for (String optionKey : optionValues.keySet()) {
						if (newValue.equals(optionValues.get(optionKey).getValue2Save())) {
							setChosenOption(optionKey);//opt.getOptionValues().
							// get
							// (
							// newValue);
							break;
						}
					}
					if (getChosenOption() != null) {
						break;
					}
				}
			}
		}

		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ConfmlPackage.SIMPLE_SETTING__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getLastSavedValue() {
		return lastSavedValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastSavedValue(String newLastSavedValue) {
		String oldLastSavedValue = lastSavedValue;
		lastSavedValue = newLastSavedValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.SIMPLE_SETTING__LAST_SAVED_VALUE, oldLastSavedValue, lastSavedValue));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getMinLength() {
		return minLength;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinLength(BigInteger newMinLength) {
		BigInteger oldMinLength = minLength;
		minLength = newMinLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.SIMPLE_SETTING__MIN_LENGTH, oldMinLength, minLength));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getMaxLength() {
		return maxLength;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxLength(BigInteger newMaxLength) {
		BigInteger oldMaxLength = maxLength;
		maxLength = newMaxLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.SIMPLE_SETTING__MAX_LENGTH, oldMaxLength, maxLength));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getLength() {
		return length;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLength(BigInteger newLength) {
		BigInteger oldLength = length;
		length = newLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.SIMPLE_SETTING__LENGTH, oldLength, length));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MaxInclusive getMaxInclusive() {
		if (maxInclusive != null && maxInclusive.eIsProxy()) {
			InternalEObject oldMaxInclusive = (InternalEObject)maxInclusive;
			maxInclusive = (MaxInclusive)eResolveProxy(oldMaxInclusive);
			if (maxInclusive != oldMaxInclusive) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfmlPackage.SIMPLE_SETTING__MAX_INCLUSIVE, oldMaxInclusive, maxInclusive));
			}
		}
		return maxInclusive;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MaxInclusive basicGetMaxInclusive() {
		return maxInclusive;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxInclusive(MaxInclusive newMaxInclusive) {
		MaxInclusive oldMaxInclusive = maxInclusive;
		maxInclusive = newMaxInclusive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.SIMPLE_SETTING__MAX_INCLUSIVE, oldMaxInclusive, maxInclusive));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MaxExclusive getMaxExclusive() {
		if (maxExclusive != null && maxExclusive.eIsProxy()) {
			InternalEObject oldMaxExclusive = (InternalEObject)maxExclusive;
			maxExclusive = (MaxExclusive)eResolveProxy(oldMaxExclusive);
			if (maxExclusive != oldMaxExclusive) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfmlPackage.SIMPLE_SETTING__MAX_EXCLUSIVE, oldMaxExclusive, maxExclusive));
			}
		}
		return maxExclusive;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MaxExclusive basicGetMaxExclusive() {
		return maxExclusive;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxExclusive(MaxExclusive newMaxExclusive) {
		MaxExclusive oldMaxExclusive = maxExclusive;
		maxExclusive = newMaxExclusive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.SIMPLE_SETTING__MAX_EXCLUSIVE, oldMaxExclusive, maxExclusive));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MinInclusive getMinInclusive() {
		if (minInclusive != null && minInclusive.eIsProxy()) {
			InternalEObject oldMinInclusive = (InternalEObject)minInclusive;
			minInclusive = (MinInclusive)eResolveProxy(oldMinInclusive);
			if (minInclusive != oldMinInclusive) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfmlPackage.SIMPLE_SETTING__MIN_INCLUSIVE, oldMinInclusive, minInclusive));
			}
		}
		return minInclusive;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MinInclusive basicGetMinInclusive() {
		return minInclusive;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinInclusive(MinInclusive newMinInclusive) {
		MinInclusive oldMinInclusive = minInclusive;
		minInclusive = newMinInclusive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.SIMPLE_SETTING__MIN_INCLUSIVE, oldMinInclusive, minInclusive));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isContainedInLastLayer() {
		return containedInLastLayer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainedInLastLayer(boolean newContainedInLastLayer) {
		boolean oldContainedInLastLayer = containedInLastLayer;
		containedInLastLayer = newContainedInLastLayer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.SIMPLE_SETTING__CONTAINED_IN_LAST_LAYER, oldContainedInLastLayer, containedInLastLayer));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLastSavedInLastLayer() {
		return lastSavedInLastLayer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastSavedInLastLayer(boolean newLastSavedInLastLayer) {
		boolean oldLastSavedInLastLayer = lastSavedInLastLayer;
		lastSavedInLastLayer = newLastSavedInLastLayer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.SIMPLE_SETTING__LAST_SAVED_IN_LAST_LAYER, oldLastSavedInLastLayer, lastSavedInLastLayer));
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setChosenOption(String newChosenOption) {
		chosenOption = newChosenOption;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MinExclusive getMinExclusive() {
		if (minExclusive != null && minExclusive.eIsProxy()) {
			InternalEObject oldMinExclusive = (InternalEObject)minExclusive;
			minExclusive = (MinExclusive)eResolveProxy(oldMinExclusive);
			if (minExclusive != oldMinExclusive) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfmlPackage.SIMPLE_SETTING__MIN_EXCLUSIVE, oldMinExclusive, minExclusive));
			}
		}
		return minExclusive;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MinExclusive basicGetMinExclusive() {
		return minExclusive;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinExclusive(MinExclusive newMinExclusive) {
		MinExclusive oldMinExclusive = minExclusive;
		minExclusive = newMinExclusive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.SIMPLE_SETTING__MIN_EXCLUSIVE, oldMinExclusive, minExclusive));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getPattern() {
		if (pattern == null) {
			pattern = new EDataTypeUniqueEList<String>(String.class, this, ConfmlPackage.SIMPLE_SETTING__PATTERN);
		}
		return pattern;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getTotalDigits() {
		return totalDigits;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalDigits(BigInteger newTotalDigits) {
		BigInteger oldTotalDigits = totalDigits;
		totalDigits = newTotalDigits;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.SIMPLE_SETTING__TOTAL_DIGITS, oldTotalDigits, totalDigits));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfmlPackage.SIMPLE_SETTING__DEFAULT_VALUE:
				return getDefaultValue();
			case ConfmlPackage.SIMPLE_SETTING__VALUE:
				return getValue();
			case ConfmlPackage.SIMPLE_SETTING__LAST_SAVED_VALUE:
				return getLastSavedValue();
			case ConfmlPackage.SIMPLE_SETTING__MIN_LENGTH:
				return getMinLength();
			case ConfmlPackage.SIMPLE_SETTING__MAX_LENGTH:
				return getMaxLength();
			case ConfmlPackage.SIMPLE_SETTING__LENGTH:
				return getLength();
			case ConfmlPackage.SIMPLE_SETTING__PATTERN:
				return getPattern();
			case ConfmlPackage.SIMPLE_SETTING__TOTAL_DIGITS:
				return getTotalDigits();
			case ConfmlPackage.SIMPLE_SETTING__MAX_EXCLUSIVE:
				if (resolve) return getMaxExclusive();
				return basicGetMaxExclusive();
			case ConfmlPackage.SIMPLE_SETTING__MIN_EXCLUSIVE:
				if (resolve) return getMinExclusive();
				return basicGetMinExclusive();
			case ConfmlPackage.SIMPLE_SETTING__MAX_INCLUSIVE:
				if (resolve) return getMaxInclusive();
				return basicGetMaxInclusive();
			case ConfmlPackage.SIMPLE_SETTING__MIN_INCLUSIVE:
				if (resolve) return getMinInclusive();
				return basicGetMinInclusive();
			case ConfmlPackage.SIMPLE_SETTING__CONTAINED_IN_LAST_LAYER:
				return isContainedInLastLayer() ? Boolean.TRUE : Boolean.FALSE;
			case ConfmlPackage.SIMPLE_SETTING__LAST_SAVED_IN_LAST_LAYER:
				return isLastSavedInLastLayer() ? Boolean.TRUE : Boolean.FALSE;
			case ConfmlPackage.SIMPLE_SETTING__CHOSEN_OPTION:
				return getChosenOption();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConfmlPackage.SIMPLE_SETTING__DEFAULT_VALUE:
				setDefaultValue((String)newValue);
				return;
			case ConfmlPackage.SIMPLE_SETTING__VALUE:
				setValue((String)newValue);
				return;
			case ConfmlPackage.SIMPLE_SETTING__LAST_SAVED_VALUE:
				setLastSavedValue((String)newValue);
				return;
			case ConfmlPackage.SIMPLE_SETTING__MIN_LENGTH:
				setMinLength((BigInteger)newValue);
				return;
			case ConfmlPackage.SIMPLE_SETTING__MAX_LENGTH:
				setMaxLength((BigInteger)newValue);
				return;
			case ConfmlPackage.SIMPLE_SETTING__LENGTH:
				setLength((BigInteger)newValue);
				return;
			case ConfmlPackage.SIMPLE_SETTING__PATTERN:
				getPattern().clear();
				getPattern().addAll((Collection<? extends String>)newValue);
				return;
			case ConfmlPackage.SIMPLE_SETTING__TOTAL_DIGITS:
				setTotalDigits((BigInteger)newValue);
				return;
			case ConfmlPackage.SIMPLE_SETTING__MAX_EXCLUSIVE:
				setMaxExclusive((MaxExclusive)newValue);
				return;
			case ConfmlPackage.SIMPLE_SETTING__MIN_EXCLUSIVE:
				setMinExclusive((MinExclusive)newValue);
				return;
			case ConfmlPackage.SIMPLE_SETTING__MAX_INCLUSIVE:
				setMaxInclusive((MaxInclusive)newValue);
				return;
			case ConfmlPackage.SIMPLE_SETTING__MIN_INCLUSIVE:
				setMinInclusive((MinInclusive)newValue);
				return;
			case ConfmlPackage.SIMPLE_SETTING__CONTAINED_IN_LAST_LAYER:
				setContainedInLastLayer(((Boolean)newValue).booleanValue());
				return;
			case ConfmlPackage.SIMPLE_SETTING__LAST_SAVED_IN_LAST_LAYER:
				setLastSavedInLastLayer(((Boolean)newValue).booleanValue());
				return;
			case ConfmlPackage.SIMPLE_SETTING__CHOSEN_OPTION:
				setChosenOption((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ConfmlPackage.SIMPLE_SETTING__DEFAULT_VALUE:
				setDefaultValue(DEFAULT_VALUE_EDEFAULT);
				return;
			case ConfmlPackage.SIMPLE_SETTING__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case ConfmlPackage.SIMPLE_SETTING__LAST_SAVED_VALUE:
				setLastSavedValue(LAST_SAVED_VALUE_EDEFAULT);
				return;
			case ConfmlPackage.SIMPLE_SETTING__MIN_LENGTH:
				setMinLength(MIN_LENGTH_EDEFAULT);
				return;
			case ConfmlPackage.SIMPLE_SETTING__MAX_LENGTH:
				setMaxLength(MAX_LENGTH_EDEFAULT);
				return;
			case ConfmlPackage.SIMPLE_SETTING__LENGTH:
				setLength(LENGTH_EDEFAULT);
				return;
			case ConfmlPackage.SIMPLE_SETTING__PATTERN:
				getPattern().clear();
				return;
			case ConfmlPackage.SIMPLE_SETTING__TOTAL_DIGITS:
				setTotalDigits(TOTAL_DIGITS_EDEFAULT);
				return;
			case ConfmlPackage.SIMPLE_SETTING__MAX_EXCLUSIVE:
				setMaxExclusive((MaxExclusive)null);
				return;
			case ConfmlPackage.SIMPLE_SETTING__MIN_EXCLUSIVE:
				setMinExclusive((MinExclusive)null);
				return;
			case ConfmlPackage.SIMPLE_SETTING__MAX_INCLUSIVE:
				setMaxInclusive((MaxInclusive)null);
				return;
			case ConfmlPackage.SIMPLE_SETTING__MIN_INCLUSIVE:
				setMinInclusive((MinInclusive)null);
				return;
			case ConfmlPackage.SIMPLE_SETTING__CONTAINED_IN_LAST_LAYER:
				setContainedInLastLayer(CONTAINED_IN_LAST_LAYER_EDEFAULT);
				return;
			case ConfmlPackage.SIMPLE_SETTING__LAST_SAVED_IN_LAST_LAYER:
				setLastSavedInLastLayer(LAST_SAVED_IN_LAST_LAYER_EDEFAULT);
				return;
			case ConfmlPackage.SIMPLE_SETTING__CHOSEN_OPTION:
				setChosenOption(CHOSEN_OPTION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ConfmlPackage.SIMPLE_SETTING__DEFAULT_VALUE:
				return DEFAULT_VALUE_EDEFAULT == null ? defaultValue != null : !DEFAULT_VALUE_EDEFAULT.equals(defaultValue);
			case ConfmlPackage.SIMPLE_SETTING__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case ConfmlPackage.SIMPLE_SETTING__LAST_SAVED_VALUE:
				return LAST_SAVED_VALUE_EDEFAULT == null ? lastSavedValue != null : !LAST_SAVED_VALUE_EDEFAULT.equals(lastSavedValue);
			case ConfmlPackage.SIMPLE_SETTING__MIN_LENGTH:
				return MIN_LENGTH_EDEFAULT == null ? minLength != null : !MIN_LENGTH_EDEFAULT.equals(minLength);
			case ConfmlPackage.SIMPLE_SETTING__MAX_LENGTH:
				return MAX_LENGTH_EDEFAULT == null ? maxLength != null : !MAX_LENGTH_EDEFAULT.equals(maxLength);
			case ConfmlPackage.SIMPLE_SETTING__LENGTH:
				return LENGTH_EDEFAULT == null ? length != null : !LENGTH_EDEFAULT.equals(length);
			case ConfmlPackage.SIMPLE_SETTING__PATTERN:
				return pattern != null && !pattern.isEmpty();
			case ConfmlPackage.SIMPLE_SETTING__TOTAL_DIGITS:
				return TOTAL_DIGITS_EDEFAULT == null ? totalDigits != null : !TOTAL_DIGITS_EDEFAULT.equals(totalDigits);
			case ConfmlPackage.SIMPLE_SETTING__MAX_EXCLUSIVE:
				return maxExclusive != null;
			case ConfmlPackage.SIMPLE_SETTING__MIN_EXCLUSIVE:
				return minExclusive != null;
			case ConfmlPackage.SIMPLE_SETTING__MAX_INCLUSIVE:
				return maxInclusive != null;
			case ConfmlPackage.SIMPLE_SETTING__MIN_INCLUSIVE:
				return minInclusive != null;
			case ConfmlPackage.SIMPLE_SETTING__CONTAINED_IN_LAST_LAYER:
				return containedInLastLayer != CONTAINED_IN_LAST_LAYER_EDEFAULT;
			case ConfmlPackage.SIMPLE_SETTING__LAST_SAVED_IN_LAST_LAYER:
				return lastSavedInLastLayer != LAST_SAVED_IN_LAST_LAYER_EDEFAULT;
			case ConfmlPackage.SIMPLE_SETTING__CHOSEN_OPTION:
				return CHOSEN_OPTION_EDEFAULT == null ? chosenOption != null : !CHOSEN_OPTION_EDEFAULT.equals(chosenOption);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (defaultValue: ");
		result.append(defaultValue);
		result.append(", value: ");
		result.append(value);
		result.append(", lastSavedValue: ");
		result.append(lastSavedValue);
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
		result.append(", containedInLastLayer: ");
		result.append(containedInLastLayer);
		result.append(", lastSavedInLastLayer: ");
		result.append(lastSavedInLastLayer);
		result.append(", chosenOption: ");
		result.append(chosenOption);
		result.append(')');
		return result.toString();
	}

	@Override
	/*
	 * @generated NOT
	 */
	public boolean isDefault() {

		if (eContainer != null && eContainer.eContainer() != null) {
			if (eContainer instanceof SequenceItem) {
				SequenceSetting sequenceSetting = (SequenceSetting) eContainer
						.eContainer();
				return sequenceSetting.isDefault();
			}
		}

		if (eContainer != null) {
			if (defaultValue == null && value == null) {
				return true;
			}
			if (defaultValue != null && value == null) {
				return true;
			}
			if (defaultValue != null && defaultValue.equals(value)
					&& !containedInLastLayer) {
				return true;
			}
		}
		return false;
	}

	@Override
	/*
	 * @generated NOT
	 */
	public boolean isDirty() {
		if (eContainer() instanceof SequenceItem
				&& eContainer().eContainer() != null) {
			SequenceItem item = (SequenceItem) eContainer();
			int indexOf2 = item.getSetting().indexOf(this);
			SequenceSetting sequenceSetting = (SequenceSetting) eContainer()
					.eContainer();
			EList<SequenceItem> sequenceItems = sequenceSetting
					.getSequenceItem();
			int indexOf = sequenceItems.indexOf(item);
			EList<SequenceItem> lastSavedStructure = sequenceSetting
					.getLastSavedStructure();
			if (lastSavedStructure.size() < indexOf + 1) {

				SequenceItem template = sequenceSetting.getTemplate();
				if (template != null) {
					Setting setting = template.getSetting().get(indexOf2);
					if (setting instanceof SimpleSetting) {
						String value2 = ((SimpleSetting) setting).getValue();
						if (value2 != null && !value2.equals(value)) {
							return true;
						}
					}
				}
				return false;

			}
			if(indexOf==-1){
				return false;
			}
			SequenceItem sequenceItem = lastSavedStructure.get(indexOf);
			String value2 = ((SimpleSetting) sequenceItem.getSetting().get(
					indexOf2)).getValue();
			if (value2 != null && !value2.equals(value)) {
				return true;
			}

		} else {
			if (lastSavedValue != null && !lastSavedValue.equals(value)) {
				return true;
			}
			if (lastSavedValue != null && lastSavedValue.equals(value)
					&& lastSavedInLastLayer != containedInLastLayer) {
				return true;
			}
			if (lastSavedValue == null && value != null) {
				return true;
			}

			// return (nrOfChanges!=0)?true:false;

		}
		return false;
	}

} // SimpleSettingImpl
