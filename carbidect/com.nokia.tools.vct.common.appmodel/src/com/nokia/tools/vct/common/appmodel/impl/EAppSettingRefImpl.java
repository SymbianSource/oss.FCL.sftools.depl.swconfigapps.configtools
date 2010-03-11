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
 * Description: This file is part of com.nokia.tools.vct.common.appmodel component.
 */

package com.nokia.tools.vct.common.appmodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.nokia.tools.vct.common.appmodel.EAppDescriptionContainer;
import com.nokia.tools.vct.common.appmodel.EAppOptionContainer;
import com.nokia.tools.vct.common.appmodel.EAppProperty;
import com.nokia.tools.vct.common.appmodel.EAppSetting;
import com.nokia.tools.vct.common.appmodel.EAppSettingOption;
import com.nokia.tools.vct.common.appmodel.EAppSettingRef;
import com.nokia.tools.vct.common.appmodel.EAppTypeConstraints;
import com.nokia.tools.vct.common.appmodel.EApplicationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EApp Setting Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSettingRefImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSettingRefImpl#getOptions <em>Options</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSettingRefImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSettingRefImpl#getMinInclusive <em>Min Inclusive</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSettingRefImpl#getMaxInclusive <em>Max Inclusive</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSettingRefImpl#getMinExclusive <em>Min Exclusive</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSettingRefImpl#getMaxExclusive <em>Max Exclusive</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSettingRefImpl#getMinLength <em>Min Length</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSettingRefImpl#getLength <em>Length</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSettingRefImpl#getMaxLength <em>Max Length</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSettingRefImpl#getTotalDigits <em>Total Digits</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSettingRefImpl#getPattern <em>Pattern</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSettingRefImpl#getResolved <em>Resolved</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSettingRefImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSettingRefImpl#getSubSettingsRef <em>Sub Settings Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EAppSettingRefImpl extends EObjectImpl implements EAppSettingRef {
	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<EAppProperty> properties;
	/**
	 * The cached value of the '{@link #getOptions() <em>Options</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptions()
	 * @generated
	 * @ordered
	 */
	protected EList<EAppSettingOption> options;
	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;
	/**
	 * The default value of the '{@link #getMinInclusive() <em>Min Inclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinInclusive()
	 * @generated
	 * @ordered
	 */
	protected static final Object MIN_INCLUSIVE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getMinInclusive() <em>Min Inclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinInclusive()
	 * @generated
	 * @ordered
	 */
	protected Object minInclusive = MIN_INCLUSIVE_EDEFAULT;
	/**
	 * The default value of the '{@link #getMaxInclusive() <em>Max Inclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxInclusive()
	 * @generated
	 * @ordered
	 */
	protected static final Object MAX_INCLUSIVE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getMaxInclusive() <em>Max Inclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxInclusive()
	 * @generated
	 * @ordered
	 */
	protected Object maxInclusive = MAX_INCLUSIVE_EDEFAULT;
	/**
	 * The default value of the '{@link #getMinExclusive() <em>Min Exclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinExclusive()
	 * @generated
	 * @ordered
	 */
	protected static final Object MIN_EXCLUSIVE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getMinExclusive() <em>Min Exclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinExclusive()
	 * @generated
	 * @ordered
	 */
	protected Object minExclusive = MIN_EXCLUSIVE_EDEFAULT;
	/**
	 * The default value of the '{@link #getMaxExclusive() <em>Max Exclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxExclusive()
	 * @generated
	 * @ordered
	 */
	protected static final Object MAX_EXCLUSIVE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getMaxExclusive() <em>Max Exclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxExclusive()
	 * @generated
	 * @ordered
	 */
	protected Object maxExclusive = MAX_EXCLUSIVE_EDEFAULT;
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
	 * The cached value of the '{@link #getPattern() <em>Pattern</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected EList<String> pattern;
	/**
	 * The cached value of the '{@link #getResolved() <em>Resolved</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolved()
	 * @generated
	 * @ordered
	 */
	protected EAppSetting resolved;
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
	 * The cached value of the '{@link #getSubSettingsRef() <em>Sub Settings Ref</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubSettingsRef()
	 * @generated
	 * @ordered
	 */
	protected EList<String> subSettingsRef;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EAppSettingRefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EApplicationPackage.Literals.EAPP_SETTING_REF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EAppProperty> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList<EAppProperty>(EAppProperty.class, this, EApplicationPackage.EAPP_SETTING_REF__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EAppSettingOption> getOptions() {
		if (options == null) {
			options = new EObjectContainmentEList<EAppSettingOption>(EAppSettingOption.class, this, EApplicationPackage.EAPP_SETTING_REF__OPTIONS);
		}
		return options;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAppSetting getResolved() {
		if (resolved != null && resolved.eIsProxy()) {
			InternalEObject oldResolved = (InternalEObject)resolved;
			resolved = (EAppSetting)eResolveProxy(oldResolved);
			if (resolved != oldResolved) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EApplicationPackage.EAPP_SETTING_REF__RESOLVED, oldResolved, resolved));
			}
		}
		return resolved;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAppSetting basicGetResolved() {
		return resolved;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResolved(EAppSetting newResolved) {
		EAppSetting oldResolved = resolved;
		resolved = newResolved;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SETTING_REF__RESOLVED, oldResolved, resolved));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SETTING_REF__DESCRIPTION, oldDescription, description));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SETTING_REF__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getSubSettingsRef() {
		if (subSettingsRef == null) {
			subSettingsRef = new EDataTypeUniqueEList<String>(String.class, this, EApplicationPackage.EAPP_SETTING_REF__SUB_SETTINGS_REF);
		}
		return subSettingsRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getMinInclusive() {
		return minInclusive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinInclusive(Object newMinInclusive) {
		Object oldMinInclusive = minInclusive;
		minInclusive = newMinInclusive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SETTING_REF__MIN_INCLUSIVE, oldMinInclusive, minInclusive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getMaxInclusive() {
		return maxInclusive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxInclusive(Object newMaxInclusive) {
		Object oldMaxInclusive = maxInclusive;
		maxInclusive = newMaxInclusive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SETTING_REF__MAX_INCLUSIVE, oldMaxInclusive, maxInclusive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getMinExclusive() {
		return minExclusive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinExclusive(Object newMinExclusive) {
		Object oldMinExclusive = minExclusive;
		minExclusive = newMinExclusive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SETTING_REF__MIN_EXCLUSIVE, oldMinExclusive, minExclusive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getMaxExclusive() {
		return maxExclusive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxExclusive(Object newMaxExclusive) {
		Object oldMaxExclusive = maxExclusive;
		maxExclusive = newMaxExclusive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SETTING_REF__MAX_EXCLUSIVE, oldMaxExclusive, maxExclusive));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SETTING_REF__MIN_LENGTH, oldMinLength, minLength));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SETTING_REF__LENGTH, oldLength, length));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SETTING_REF__MAX_LENGTH, oldMaxLength, maxLength));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SETTING_REF__TOTAL_DIGITS, oldTotalDigits, totalDigits));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getPattern() {
		if (pattern == null) {
			pattern = new EDataTypeUniqueEList<String>(String.class, this, EApplicationPackage.EAPP_SETTING_REF__PATTERN);
		}
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EApplicationPackage.EAPP_SETTING_REF__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
			case EApplicationPackage.EAPP_SETTING_REF__OPTIONS:
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
			case EApplicationPackage.EAPP_SETTING_REF__PROPERTIES:
				return getProperties();
			case EApplicationPackage.EAPP_SETTING_REF__OPTIONS:
				return getOptions();
			case EApplicationPackage.EAPP_SETTING_REF__DESCRIPTION:
				return getDescription();
			case EApplicationPackage.EAPP_SETTING_REF__MIN_INCLUSIVE:
				return getMinInclusive();
			case EApplicationPackage.EAPP_SETTING_REF__MAX_INCLUSIVE:
				return getMaxInclusive();
			case EApplicationPackage.EAPP_SETTING_REF__MIN_EXCLUSIVE:
				return getMinExclusive();
			case EApplicationPackage.EAPP_SETTING_REF__MAX_EXCLUSIVE:
				return getMaxExclusive();
			case EApplicationPackage.EAPP_SETTING_REF__MIN_LENGTH:
				return getMinLength();
			case EApplicationPackage.EAPP_SETTING_REF__LENGTH:
				return getLength();
			case EApplicationPackage.EAPP_SETTING_REF__MAX_LENGTH:
				return getMaxLength();
			case EApplicationPackage.EAPP_SETTING_REF__TOTAL_DIGITS:
				return getTotalDigits();
			case EApplicationPackage.EAPP_SETTING_REF__PATTERN:
				return getPattern();
			case EApplicationPackage.EAPP_SETTING_REF__RESOLVED:
				if (resolve) return getResolved();
				return basicGetResolved();
			case EApplicationPackage.EAPP_SETTING_REF__NAME:
				return getName();
			case EApplicationPackage.EAPP_SETTING_REF__SUB_SETTINGS_REF:
				return getSubSettingsRef();
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
			case EApplicationPackage.EAPP_SETTING_REF__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends EAppProperty>)newValue);
				return;
			case EApplicationPackage.EAPP_SETTING_REF__OPTIONS:
				getOptions().clear();
				getOptions().addAll((Collection<? extends EAppSettingOption>)newValue);
				return;
			case EApplicationPackage.EAPP_SETTING_REF__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case EApplicationPackage.EAPP_SETTING_REF__MIN_INCLUSIVE:
				setMinInclusive(newValue);
				return;
			case EApplicationPackage.EAPP_SETTING_REF__MAX_INCLUSIVE:
				setMaxInclusive(newValue);
				return;
			case EApplicationPackage.EAPP_SETTING_REF__MIN_EXCLUSIVE:
				setMinExclusive(newValue);
				return;
			case EApplicationPackage.EAPP_SETTING_REF__MAX_EXCLUSIVE:
				setMaxExclusive(newValue);
				return;
			case EApplicationPackage.EAPP_SETTING_REF__MIN_LENGTH:
				setMinLength((Integer)newValue);
				return;
			case EApplicationPackage.EAPP_SETTING_REF__LENGTH:
				setLength((Integer)newValue);
				return;
			case EApplicationPackage.EAPP_SETTING_REF__MAX_LENGTH:
				setMaxLength((Integer)newValue);
				return;
			case EApplicationPackage.EAPP_SETTING_REF__TOTAL_DIGITS:
				setTotalDigits((Integer)newValue);
				return;
			case EApplicationPackage.EAPP_SETTING_REF__PATTERN:
				getPattern().clear();
				getPattern().addAll((Collection<? extends String>)newValue);
				return;
			case EApplicationPackage.EAPP_SETTING_REF__RESOLVED:
				setResolved((EAppSetting)newValue);
				return;
			case EApplicationPackage.EAPP_SETTING_REF__NAME:
				setName((String)newValue);
				return;
			case EApplicationPackage.EAPP_SETTING_REF__SUB_SETTINGS_REF:
				getSubSettingsRef().clear();
				getSubSettingsRef().addAll((Collection<? extends String>)newValue);
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
			case EApplicationPackage.EAPP_SETTING_REF__PROPERTIES:
				getProperties().clear();
				return;
			case EApplicationPackage.EAPP_SETTING_REF__OPTIONS:
				getOptions().clear();
				return;
			case EApplicationPackage.EAPP_SETTING_REF__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case EApplicationPackage.EAPP_SETTING_REF__MIN_INCLUSIVE:
				setMinInclusive(MIN_INCLUSIVE_EDEFAULT);
				return;
			case EApplicationPackage.EAPP_SETTING_REF__MAX_INCLUSIVE:
				setMaxInclusive(MAX_INCLUSIVE_EDEFAULT);
				return;
			case EApplicationPackage.EAPP_SETTING_REF__MIN_EXCLUSIVE:
				setMinExclusive(MIN_EXCLUSIVE_EDEFAULT);
				return;
			case EApplicationPackage.EAPP_SETTING_REF__MAX_EXCLUSIVE:
				setMaxExclusive(MAX_EXCLUSIVE_EDEFAULT);
				return;
			case EApplicationPackage.EAPP_SETTING_REF__MIN_LENGTH:
				setMinLength(MIN_LENGTH_EDEFAULT);
				return;
			case EApplicationPackage.EAPP_SETTING_REF__LENGTH:
				setLength(LENGTH_EDEFAULT);
				return;
			case EApplicationPackage.EAPP_SETTING_REF__MAX_LENGTH:
				setMaxLength(MAX_LENGTH_EDEFAULT);
				return;
			case EApplicationPackage.EAPP_SETTING_REF__TOTAL_DIGITS:
				setTotalDigits(TOTAL_DIGITS_EDEFAULT);
				return;
			case EApplicationPackage.EAPP_SETTING_REF__PATTERN:
				getPattern().clear();
				return;
			case EApplicationPackage.EAPP_SETTING_REF__RESOLVED:
				setResolved((EAppSetting)null);
				return;
			case EApplicationPackage.EAPP_SETTING_REF__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EApplicationPackage.EAPP_SETTING_REF__SUB_SETTINGS_REF:
				getSubSettingsRef().clear();
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
			case EApplicationPackage.EAPP_SETTING_REF__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case EApplicationPackage.EAPP_SETTING_REF__OPTIONS:
				return options != null && !options.isEmpty();
			case EApplicationPackage.EAPP_SETTING_REF__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case EApplicationPackage.EAPP_SETTING_REF__MIN_INCLUSIVE:
				return MIN_INCLUSIVE_EDEFAULT == null ? minInclusive != null : !MIN_INCLUSIVE_EDEFAULT.equals(minInclusive);
			case EApplicationPackage.EAPP_SETTING_REF__MAX_INCLUSIVE:
				return MAX_INCLUSIVE_EDEFAULT == null ? maxInclusive != null : !MAX_INCLUSIVE_EDEFAULT.equals(maxInclusive);
			case EApplicationPackage.EAPP_SETTING_REF__MIN_EXCLUSIVE:
				return MIN_EXCLUSIVE_EDEFAULT == null ? minExclusive != null : !MIN_EXCLUSIVE_EDEFAULT.equals(minExclusive);
			case EApplicationPackage.EAPP_SETTING_REF__MAX_EXCLUSIVE:
				return MAX_EXCLUSIVE_EDEFAULT == null ? maxExclusive != null : !MAX_EXCLUSIVE_EDEFAULT.equals(maxExclusive);
			case EApplicationPackage.EAPP_SETTING_REF__MIN_LENGTH:
				return MIN_LENGTH_EDEFAULT == null ? minLength != null : !MIN_LENGTH_EDEFAULT.equals(minLength);
			case EApplicationPackage.EAPP_SETTING_REF__LENGTH:
				return LENGTH_EDEFAULT == null ? length != null : !LENGTH_EDEFAULT.equals(length);
			case EApplicationPackage.EAPP_SETTING_REF__MAX_LENGTH:
				return MAX_LENGTH_EDEFAULT == null ? maxLength != null : !MAX_LENGTH_EDEFAULT.equals(maxLength);
			case EApplicationPackage.EAPP_SETTING_REF__TOTAL_DIGITS:
				return TOTAL_DIGITS_EDEFAULT == null ? totalDigits != null : !TOTAL_DIGITS_EDEFAULT.equals(totalDigits);
			case EApplicationPackage.EAPP_SETTING_REF__PATTERN:
				return pattern != null && !pattern.isEmpty();
			case EApplicationPackage.EAPP_SETTING_REF__RESOLVED:
				return resolved != null;
			case EApplicationPackage.EAPP_SETTING_REF__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EApplicationPackage.EAPP_SETTING_REF__SUB_SETTINGS_REF:
				return subSettingsRef != null && !subSettingsRef.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == EAppOptionContainer.class) {
			switch (derivedFeatureID) {
				case EApplicationPackage.EAPP_SETTING_REF__OPTIONS: return EApplicationPackage.EAPP_OPTION_CONTAINER__OPTIONS;
				default: return -1;
			}
		}
		if (baseClass == EAppDescriptionContainer.class) {
			switch (derivedFeatureID) {
				case EApplicationPackage.EAPP_SETTING_REF__DESCRIPTION: return EApplicationPackage.EAPP_DESCRIPTION_CONTAINER__DESCRIPTION;
				default: return -1;
			}
		}
		if (baseClass == EAppTypeConstraints.class) {
			switch (derivedFeatureID) {
				case EApplicationPackage.EAPP_SETTING_REF__MIN_INCLUSIVE: return EApplicationPackage.EAPP_TYPE_CONSTRAINTS__MIN_INCLUSIVE;
				case EApplicationPackage.EAPP_SETTING_REF__MAX_INCLUSIVE: return EApplicationPackage.EAPP_TYPE_CONSTRAINTS__MAX_INCLUSIVE;
				case EApplicationPackage.EAPP_SETTING_REF__MIN_EXCLUSIVE: return EApplicationPackage.EAPP_TYPE_CONSTRAINTS__MIN_EXCLUSIVE;
				case EApplicationPackage.EAPP_SETTING_REF__MAX_EXCLUSIVE: return EApplicationPackage.EAPP_TYPE_CONSTRAINTS__MAX_EXCLUSIVE;
				case EApplicationPackage.EAPP_SETTING_REF__MIN_LENGTH: return EApplicationPackage.EAPP_TYPE_CONSTRAINTS__MIN_LENGTH;
				case EApplicationPackage.EAPP_SETTING_REF__LENGTH: return EApplicationPackage.EAPP_TYPE_CONSTRAINTS__LENGTH;
				case EApplicationPackage.EAPP_SETTING_REF__MAX_LENGTH: return EApplicationPackage.EAPP_TYPE_CONSTRAINTS__MAX_LENGTH;
				case EApplicationPackage.EAPP_SETTING_REF__TOTAL_DIGITS: return EApplicationPackage.EAPP_TYPE_CONSTRAINTS__TOTAL_DIGITS;
				case EApplicationPackage.EAPP_SETTING_REF__PATTERN: return EApplicationPackage.EAPP_TYPE_CONSTRAINTS__PATTERN;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == EAppOptionContainer.class) {
			switch (baseFeatureID) {
				case EApplicationPackage.EAPP_OPTION_CONTAINER__OPTIONS: return EApplicationPackage.EAPP_SETTING_REF__OPTIONS;
				default: return -1;
			}
		}
		if (baseClass == EAppDescriptionContainer.class) {
			switch (baseFeatureID) {
				case EApplicationPackage.EAPP_DESCRIPTION_CONTAINER__DESCRIPTION: return EApplicationPackage.EAPP_SETTING_REF__DESCRIPTION;
				default: return -1;
			}
		}
		if (baseClass == EAppTypeConstraints.class) {
			switch (baseFeatureID) {
				case EApplicationPackage.EAPP_TYPE_CONSTRAINTS__MIN_INCLUSIVE: return EApplicationPackage.EAPP_SETTING_REF__MIN_INCLUSIVE;
				case EApplicationPackage.EAPP_TYPE_CONSTRAINTS__MAX_INCLUSIVE: return EApplicationPackage.EAPP_SETTING_REF__MAX_INCLUSIVE;
				case EApplicationPackage.EAPP_TYPE_CONSTRAINTS__MIN_EXCLUSIVE: return EApplicationPackage.EAPP_SETTING_REF__MIN_EXCLUSIVE;
				case EApplicationPackage.EAPP_TYPE_CONSTRAINTS__MAX_EXCLUSIVE: return EApplicationPackage.EAPP_SETTING_REF__MAX_EXCLUSIVE;
				case EApplicationPackage.EAPP_TYPE_CONSTRAINTS__MIN_LENGTH: return EApplicationPackage.EAPP_SETTING_REF__MIN_LENGTH;
				case EApplicationPackage.EAPP_TYPE_CONSTRAINTS__LENGTH: return EApplicationPackage.EAPP_SETTING_REF__LENGTH;
				case EApplicationPackage.EAPP_TYPE_CONSTRAINTS__MAX_LENGTH: return EApplicationPackage.EAPP_SETTING_REF__MAX_LENGTH;
				case EApplicationPackage.EAPP_TYPE_CONSTRAINTS__TOTAL_DIGITS: return EApplicationPackage.EAPP_SETTING_REF__TOTAL_DIGITS;
				case EApplicationPackage.EAPP_TYPE_CONSTRAINTS__PATTERN: return EApplicationPackage.EAPP_SETTING_REF__PATTERN;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (description: ");
		result.append(description);
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
		result.append(", length: ");
		result.append(length);
		result.append(", maxLength: ");
		result.append(maxLength);
		result.append(", totalDigits: ");
		result.append(totalDigits);
		result.append(", pattern: ");
		result.append(pattern);
		result.append(", name: ");
		result.append(name);
		result.append(", subSettingsRef: ");
		result.append(subSettingsRef);
		result.append(')');
		return result.toString();
	}

} //EAppSettingRefImpl
