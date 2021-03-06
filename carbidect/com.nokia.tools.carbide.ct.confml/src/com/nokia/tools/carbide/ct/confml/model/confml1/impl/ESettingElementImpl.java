/**
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
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
 * $Id$
 */
package com.nokia.tools.carbide.ct.confml.model.confml1.impl;

import com.nokia.tools.carbide.ct.confml.model.confml1.EConfML1Package;
import com.nokia.tools.carbide.ct.confml.model.confml1.EDescriptionContainer;
import com.nokia.tools.carbide.ct.confml.model.confml1.EDescriptionElement;
import com.nokia.tools.carbide.ct.confml.model.confml1.EIconContainer;
import com.nokia.tools.carbide.ct.confml.model.confml1.EIconElement;
import com.nokia.tools.carbide.ct.confml.model.confml1.ELinkContainer;
import com.nokia.tools.carbide.ct.confml.model.confml1.ELinkElement;
import com.nokia.tools.carbide.ct.confml.model.confml1.EOptionElement;
import com.nokia.tools.carbide.ct.confml.model.confml1.EPropertyElement;
import com.nokia.tools.carbide.ct.confml.model.confml1.ESettingElement;
import com.nokia.tools.carbide.ct.confml.model.confml1.ESettingTypeContainer;

import com.nokia.tools.carbide.ct.confml.model.xsd.ELength;
import com.nokia.tools.carbide.ct.confml.model.xsd.EMaxExclusive;
import com.nokia.tools.carbide.ct.confml.model.xsd.EMaxInclusive;
import com.nokia.tools.carbide.ct.confml.model.xsd.EMaxLength;
import com.nokia.tools.carbide.ct.confml.model.xsd.EMinExclusive;
import com.nokia.tools.carbide.ct.confml.model.xsd.EMinInclusive;
import com.nokia.tools.carbide.ct.confml.model.xsd.EMinLength;
import com.nokia.tools.carbide.ct.confml.model.xsd.EPattern;
import com.nokia.tools.carbide.ct.confml.model.xsd.ETotalDigits;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ESetting Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml1.impl.ESettingElementImpl#getContents <em>Contents</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml1.impl.ESettingElementImpl#getDescriptions <em>Descriptions</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml1.impl.ESettingElementImpl#getLinks <em>Links</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml1.impl.ESettingElementImpl#getSettings <em>Settings</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml1.impl.ESettingElementImpl#getIcons <em>Icons</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml1.impl.ESettingElementImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml1.impl.ESettingElementImpl#getReadOnly <em>Read Only</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml1.impl.ESettingElementImpl#getRelevant <em>Relevant</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml1.impl.ESettingElementImpl#getRequired <em>Required</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml1.impl.ESettingElementImpl#getMapKey <em>Map Key</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml1.impl.ESettingElementImpl#getMapValue <em>Map Value</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml1.impl.ESettingElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml1.impl.ESettingElementImpl#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml1.impl.ESettingElementImpl#getOptions <em>Options</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml1.impl.ESettingElementImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml1.impl.ESettingElementImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml1.impl.ESettingElementImpl#getMinOccurs <em>Min Occurs</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml1.impl.ESettingElementImpl#getMaxOccurs <em>Max Occurs</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml1.impl.ESettingElementImpl#getMinExclusive <em>Min Exclusive</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml1.impl.ESettingElementImpl#getMaxExclusive <em>Max Exclusive</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml1.impl.ESettingElementImpl#getMinInclusive <em>Min Inclusive</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml1.impl.ESettingElementImpl#getMaxInclusive <em>Max Inclusive</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml1.impl.ESettingElementImpl#getMinLength <em>Min Length</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml1.impl.ESettingElementImpl#getMaxLength <em>Max Length</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml1.impl.ESettingElementImpl#getLength <em>Length</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml1.impl.ESettingElementImpl#getTotalDigits <em>Total Digits</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml1.impl.ESettingElementImpl#getPattern <em>Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ESettingElementImpl extends ECommonAttrsImpl implements
		ESettingElement {
	/**
	 * The cached value of the '{@link #getContents() <em>Contents</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContents()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap contents;

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
	 * The default value of the '{@link #getReadOnly() <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReadOnly()
	 * @generated
	 * @ordered
	 */
	protected static final String READ_ONLY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReadOnly() <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReadOnly()
	 * @generated
	 * @ordered
	 */
	protected String readOnly = READ_ONLY_EDEFAULT;

	/**
	 * The default value of the '{@link #getRelevant() <em>Relevant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelevant()
	 * @generated
	 * @ordered
	 */
	protected static final String RELEVANT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRelevant() <em>Relevant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelevant()
	 * @generated
	 * @ordered
	 */
	protected String relevant = RELEVANT_EDEFAULT;

	/**
	 * The default value of the '{@link #getRequired() <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequired()
	 * @generated
	 * @ordered
	 */
	protected static final String REQUIRED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRequired() <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequired()
	 * @generated
	 * @ordered
	 */
	protected String required = REQUIRED_EDEFAULT;

	/**
	 * The default value of the '{@link #getMapKey() <em>Map Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMapKey()
	 * @generated
	 * @ordered
	 */
	protected static final String MAP_KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMapKey() <em>Map Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMapKey()
	 * @generated
	 * @ordered
	 */
	protected String mapKey = MAP_KEY_EDEFAULT;

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
	 * The default value of the '{@link #getConstraint() <em>Constraint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraint()
	 * @generated
	 * @ordered
	 */
	protected static final String CONSTRAINT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConstraint() <em>Constraint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraint()
	 * @generated
	 * @ordered
	 */
	protected String constraint = CONSTRAINT_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinOccurs() <em>Min Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinOccurs()
	 * @generated
	 * @ordered
	 */
	protected static final Integer MIN_OCCURS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinOccurs() <em>Min Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinOccurs()
	 * @generated
	 * @ordered
	 */
	protected Integer minOccurs = MIN_OCCURS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxOccurs() <em>Max Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxOccurs()
	 * @generated
	 * @ordered
	 */
	protected static final Integer MAX_OCCURS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxOccurs() <em>Max Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxOccurs()
	 * @generated
	 * @ordered
	 */
	protected Integer maxOccurs = MAX_OCCURS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ESettingElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EConfML1Package.Literals.ESETTING_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getContents() {
		if (contents == null) {
			contents = new BasicFeatureMap(this,
					EConfML1Package.ESETTING_ELEMENT__CONTENTS);
		}
		return contents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EDescriptionElement> getDescriptions() {
		return getContents().list(
				EConfML1Package.Literals.EDESCRIPTION_CONTAINER__DESCRIPTIONS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ELinkElement> getLinks() {
		return getContents().list(
				EConfML1Package.Literals.ELINK_CONTAINER__LINKS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ESettingElement> getSettings() {
		return getContents().list(
				EConfML1Package.Literals.ESETTING_TYPE_CONTAINER__SETTINGS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EIconElement> getIcons() {
		return getContents().list(
				EConfML1Package.Literals.EICON_CONTAINER__ICONS);
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
			eNotify(new ENotificationImpl(this, Notification.SET,
					EConfML1Package.ESETTING_ELEMENT__REF, oldRef, ref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReadOnly() {
		return readOnly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReadOnly(String newReadOnly) {
		String oldReadOnly = readOnly;
		readOnly = newReadOnly;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					EConfML1Package.ESETTING_ELEMENT__READ_ONLY, oldReadOnly,
					readOnly));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRelevant() {
		return relevant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelevant(String newRelevant) {
		String oldRelevant = relevant;
		relevant = newRelevant;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					EConfML1Package.ESETTING_ELEMENT__RELEVANT, oldRelevant,
					relevant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRequired() {
		return required;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequired(String newRequired) {
		String oldRequired = required;
		required = newRequired;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					EConfML1Package.ESETTING_ELEMENT__REQUIRED, oldRequired,
					required));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMapKey() {
		return mapKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMapKey(String newMapKey) {
		String oldMapKey = mapKey;
		mapKey = newMapKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					EConfML1Package.ESETTING_ELEMENT__MAP_KEY, oldMapKey,
					mapKey));
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
			eNotify(new ENotificationImpl(this, Notification.SET,
					EConfML1Package.ESETTING_ELEMENT__MAP_VALUE, oldMapValue,
					mapValue));
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
			eNotify(new ENotificationImpl(this, Notification.SET,
					EConfML1Package.ESETTING_ELEMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConstraint() {
		return constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstraint(String newConstraint) {
		String oldConstraint = constraint;
		constraint = newConstraint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					EConfML1Package.ESETTING_ELEMENT__CONSTRAINT,
					oldConstraint, constraint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EOptionElement> getOptions() {
		return getContents().list(
				EConfML1Package.Literals.ESETTING_ELEMENT__OPTIONS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EPropertyElement> getProperties() {
		return getContents().list(
				EConfML1Package.Literals.ESETTING_ELEMENT__PROPERTIES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					EConfML1Package.ESETTING_ELEMENT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getMinOccurs() {
		return minOccurs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinOccurs(Integer newMinOccurs) {
		Integer oldMinOccurs = minOccurs;
		minOccurs = newMinOccurs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					EConfML1Package.ESETTING_ELEMENT__MIN_OCCURS, oldMinOccurs,
					minOccurs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getMaxOccurs() {
		return maxOccurs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxOccurs(Integer newMaxOccurs) {
		Integer oldMaxOccurs = maxOccurs;
		maxOccurs = newMaxOccurs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					EConfML1Package.ESETTING_ELEMENT__MAX_OCCURS, oldMaxOccurs,
					maxOccurs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EMinExclusive> getMinExclusive() {
		return getContents().list(
				EConfML1Package.Literals.ESETTING_ELEMENT__MIN_EXCLUSIVE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EMaxExclusive> getMaxExclusive() {
		return getContents().list(
				EConfML1Package.Literals.ESETTING_ELEMENT__MAX_EXCLUSIVE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EMinInclusive> getMinInclusive() {
		return getContents().list(
				EConfML1Package.Literals.ESETTING_ELEMENT__MIN_INCLUSIVE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EMaxInclusive> getMaxInclusive() {
		return getContents().list(
				EConfML1Package.Literals.ESETTING_ELEMENT__MAX_INCLUSIVE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EMinLength> getMinLength() {
		return getContents().list(
				EConfML1Package.Literals.ESETTING_ELEMENT__MIN_LENGTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EMaxLength> getMaxLength() {
		return getContents().list(
				EConfML1Package.Literals.ESETTING_ELEMENT__MAX_LENGTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ELength> getLength() {
		return getContents().list(
				EConfML1Package.Literals.ESETTING_ELEMENT__LENGTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ETotalDigits> getTotalDigits() {
		return getContents().list(
				EConfML1Package.Literals.ESETTING_ELEMENT__TOTAL_DIGITS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EPattern> getPattern() {
		return getContents().list(
				EConfML1Package.Literals.ESETTING_ELEMENT__PATTERN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case EConfML1Package.ESETTING_ELEMENT__CONTENTS:
			return ((InternalEList<?>) getContents()).basicRemove(otherEnd,
					msgs);
		case EConfML1Package.ESETTING_ELEMENT__DESCRIPTIONS:
			return ((InternalEList<?>) getDescriptions()).basicRemove(otherEnd,
					msgs);
		case EConfML1Package.ESETTING_ELEMENT__LINKS:
			return ((InternalEList<?>) getLinks()).basicRemove(otherEnd, msgs);
		case EConfML1Package.ESETTING_ELEMENT__SETTINGS:
			return ((InternalEList<?>) getSettings()).basicRemove(otherEnd,
					msgs);
		case EConfML1Package.ESETTING_ELEMENT__ICONS:
			return ((InternalEList<?>) getIcons()).basicRemove(otherEnd, msgs);
		case EConfML1Package.ESETTING_ELEMENT__OPTIONS:
			return ((InternalEList<?>) getOptions())
					.basicRemove(otherEnd, msgs);
		case EConfML1Package.ESETTING_ELEMENT__PROPERTIES:
			return ((InternalEList<?>) getProperties()).basicRemove(otherEnd,
					msgs);
		case EConfML1Package.ESETTING_ELEMENT__MIN_EXCLUSIVE:
			return ((InternalEList<?>) getMinExclusive()).basicRemove(otherEnd,
					msgs);
		case EConfML1Package.ESETTING_ELEMENT__MAX_EXCLUSIVE:
			return ((InternalEList<?>) getMaxExclusive()).basicRemove(otherEnd,
					msgs);
		case EConfML1Package.ESETTING_ELEMENT__MIN_INCLUSIVE:
			return ((InternalEList<?>) getMinInclusive()).basicRemove(otherEnd,
					msgs);
		case EConfML1Package.ESETTING_ELEMENT__MAX_INCLUSIVE:
			return ((InternalEList<?>) getMaxInclusive()).basicRemove(otherEnd,
					msgs);
		case EConfML1Package.ESETTING_ELEMENT__MIN_LENGTH:
			return ((InternalEList<?>) getMinLength()).basicRemove(otherEnd,
					msgs);
		case EConfML1Package.ESETTING_ELEMENT__MAX_LENGTH:
			return ((InternalEList<?>) getMaxLength()).basicRemove(otherEnd,
					msgs);
		case EConfML1Package.ESETTING_ELEMENT__LENGTH:
			return ((InternalEList<?>) getLength()).basicRemove(otherEnd, msgs);
		case EConfML1Package.ESETTING_ELEMENT__TOTAL_DIGITS:
			return ((InternalEList<?>) getTotalDigits()).basicRemove(otherEnd,
					msgs);
		case EConfML1Package.ESETTING_ELEMENT__PATTERN:
			return ((InternalEList<?>) getPattern())
					.basicRemove(otherEnd, msgs);
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
		case EConfML1Package.ESETTING_ELEMENT__CONTENTS:
			if (coreType)
				return getContents();
			return ((FeatureMap.Internal) getContents()).getWrapper();
		case EConfML1Package.ESETTING_ELEMENT__DESCRIPTIONS:
			return getDescriptions();
		case EConfML1Package.ESETTING_ELEMENT__LINKS:
			return getLinks();
		case EConfML1Package.ESETTING_ELEMENT__SETTINGS:
			return getSettings();
		case EConfML1Package.ESETTING_ELEMENT__ICONS:
			return getIcons();
		case EConfML1Package.ESETTING_ELEMENT__REF:
			return getRef();
		case EConfML1Package.ESETTING_ELEMENT__READ_ONLY:
			return getReadOnly();
		case EConfML1Package.ESETTING_ELEMENT__RELEVANT:
			return getRelevant();
		case EConfML1Package.ESETTING_ELEMENT__REQUIRED:
			return getRequired();
		case EConfML1Package.ESETTING_ELEMENT__MAP_KEY:
			return getMapKey();
		case EConfML1Package.ESETTING_ELEMENT__MAP_VALUE:
			return getMapValue();
		case EConfML1Package.ESETTING_ELEMENT__NAME:
			return getName();
		case EConfML1Package.ESETTING_ELEMENT__CONSTRAINT:
			return getConstraint();
		case EConfML1Package.ESETTING_ELEMENT__OPTIONS:
			return getOptions();
		case EConfML1Package.ESETTING_ELEMENT__PROPERTIES:
			return getProperties();
		case EConfML1Package.ESETTING_ELEMENT__TYPE:
			return getType();
		case EConfML1Package.ESETTING_ELEMENT__MIN_OCCURS:
			return getMinOccurs();
		case EConfML1Package.ESETTING_ELEMENT__MAX_OCCURS:
			return getMaxOccurs();
		case EConfML1Package.ESETTING_ELEMENT__MIN_EXCLUSIVE:
			return getMinExclusive();
		case EConfML1Package.ESETTING_ELEMENT__MAX_EXCLUSIVE:
			return getMaxExclusive();
		case EConfML1Package.ESETTING_ELEMENT__MIN_INCLUSIVE:
			return getMinInclusive();
		case EConfML1Package.ESETTING_ELEMENT__MAX_INCLUSIVE:
			return getMaxInclusive();
		case EConfML1Package.ESETTING_ELEMENT__MIN_LENGTH:
			return getMinLength();
		case EConfML1Package.ESETTING_ELEMENT__MAX_LENGTH:
			return getMaxLength();
		case EConfML1Package.ESETTING_ELEMENT__LENGTH:
			return getLength();
		case EConfML1Package.ESETTING_ELEMENT__TOTAL_DIGITS:
			return getTotalDigits();
		case EConfML1Package.ESETTING_ELEMENT__PATTERN:
			return getPattern();
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
		case EConfML1Package.ESETTING_ELEMENT__CONTENTS:
			((FeatureMap.Internal) getContents()).set(newValue);
			return;
		case EConfML1Package.ESETTING_ELEMENT__DESCRIPTIONS:
			getDescriptions().clear();
			getDescriptions().addAll(
					(Collection<? extends EDescriptionElement>) newValue);
			return;
		case EConfML1Package.ESETTING_ELEMENT__LINKS:
			getLinks().clear();
			getLinks().addAll((Collection<? extends ELinkElement>) newValue);
			return;
		case EConfML1Package.ESETTING_ELEMENT__SETTINGS:
			getSettings().clear();
			getSettings().addAll(
					(Collection<? extends ESettingElement>) newValue);
			return;
		case EConfML1Package.ESETTING_ELEMENT__ICONS:
			getIcons().clear();
			getIcons().addAll((Collection<? extends EIconElement>) newValue);
			return;
		case EConfML1Package.ESETTING_ELEMENT__REF:
			setRef((String) newValue);
			return;
		case EConfML1Package.ESETTING_ELEMENT__READ_ONLY:
			setReadOnly((String) newValue);
			return;
		case EConfML1Package.ESETTING_ELEMENT__RELEVANT:
			setRelevant((String) newValue);
			return;
		case EConfML1Package.ESETTING_ELEMENT__REQUIRED:
			setRequired((String) newValue);
			return;
		case EConfML1Package.ESETTING_ELEMENT__MAP_KEY:
			setMapKey((String) newValue);
			return;
		case EConfML1Package.ESETTING_ELEMENT__MAP_VALUE:
			setMapValue((String) newValue);
			return;
		case EConfML1Package.ESETTING_ELEMENT__NAME:
			setName((String) newValue);
			return;
		case EConfML1Package.ESETTING_ELEMENT__CONSTRAINT:
			setConstraint((String) newValue);
			return;
		case EConfML1Package.ESETTING_ELEMENT__OPTIONS:
			getOptions().clear();
			getOptions()
					.addAll((Collection<? extends EOptionElement>) newValue);
			return;
		case EConfML1Package.ESETTING_ELEMENT__PROPERTIES:
			getProperties().clear();
			getProperties().addAll(
					(Collection<? extends EPropertyElement>) newValue);
			return;
		case EConfML1Package.ESETTING_ELEMENT__TYPE:
			setType((String) newValue);
			return;
		case EConfML1Package.ESETTING_ELEMENT__MIN_OCCURS:
			setMinOccurs((Integer) newValue);
			return;
		case EConfML1Package.ESETTING_ELEMENT__MAX_OCCURS:
			setMaxOccurs((Integer) newValue);
			return;
		case EConfML1Package.ESETTING_ELEMENT__MIN_EXCLUSIVE:
			getMinExclusive().clear();
			getMinExclusive().addAll(
					(Collection<? extends EMinExclusive>) newValue);
			return;
		case EConfML1Package.ESETTING_ELEMENT__MAX_EXCLUSIVE:
			getMaxExclusive().clear();
			getMaxExclusive().addAll(
					(Collection<? extends EMaxExclusive>) newValue);
			return;
		case EConfML1Package.ESETTING_ELEMENT__MIN_INCLUSIVE:
			getMinInclusive().clear();
			getMinInclusive().addAll(
					(Collection<? extends EMinInclusive>) newValue);
			return;
		case EConfML1Package.ESETTING_ELEMENT__MAX_INCLUSIVE:
			getMaxInclusive().clear();
			getMaxInclusive().addAll(
					(Collection<? extends EMaxInclusive>) newValue);
			return;
		case EConfML1Package.ESETTING_ELEMENT__MIN_LENGTH:
			getMinLength().clear();
			getMinLength().addAll((Collection<? extends EMinLength>) newValue);
			return;
		case EConfML1Package.ESETTING_ELEMENT__MAX_LENGTH:
			getMaxLength().clear();
			getMaxLength().addAll((Collection<? extends EMaxLength>) newValue);
			return;
		case EConfML1Package.ESETTING_ELEMENT__LENGTH:
			getLength().clear();
			getLength().addAll((Collection<? extends ELength>) newValue);
			return;
		case EConfML1Package.ESETTING_ELEMENT__TOTAL_DIGITS:
			getTotalDigits().clear();
			getTotalDigits().addAll(
					(Collection<? extends ETotalDigits>) newValue);
			return;
		case EConfML1Package.ESETTING_ELEMENT__PATTERN:
			getPattern().clear();
			getPattern().addAll((Collection<? extends EPattern>) newValue);
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
		case EConfML1Package.ESETTING_ELEMENT__CONTENTS:
			getContents().clear();
			return;
		case EConfML1Package.ESETTING_ELEMENT__DESCRIPTIONS:
			getDescriptions().clear();
			return;
		case EConfML1Package.ESETTING_ELEMENT__LINKS:
			getLinks().clear();
			return;
		case EConfML1Package.ESETTING_ELEMENT__SETTINGS:
			getSettings().clear();
			return;
		case EConfML1Package.ESETTING_ELEMENT__ICONS:
			getIcons().clear();
			return;
		case EConfML1Package.ESETTING_ELEMENT__REF:
			setRef(REF_EDEFAULT);
			return;
		case EConfML1Package.ESETTING_ELEMENT__READ_ONLY:
			setReadOnly(READ_ONLY_EDEFAULT);
			return;
		case EConfML1Package.ESETTING_ELEMENT__RELEVANT:
			setRelevant(RELEVANT_EDEFAULT);
			return;
		case EConfML1Package.ESETTING_ELEMENT__REQUIRED:
			setRequired(REQUIRED_EDEFAULT);
			return;
		case EConfML1Package.ESETTING_ELEMENT__MAP_KEY:
			setMapKey(MAP_KEY_EDEFAULT);
			return;
		case EConfML1Package.ESETTING_ELEMENT__MAP_VALUE:
			setMapValue(MAP_VALUE_EDEFAULT);
			return;
		case EConfML1Package.ESETTING_ELEMENT__NAME:
			setName(NAME_EDEFAULT);
			return;
		case EConfML1Package.ESETTING_ELEMENT__CONSTRAINT:
			setConstraint(CONSTRAINT_EDEFAULT);
			return;
		case EConfML1Package.ESETTING_ELEMENT__OPTIONS:
			getOptions().clear();
			return;
		case EConfML1Package.ESETTING_ELEMENT__PROPERTIES:
			getProperties().clear();
			return;
		case EConfML1Package.ESETTING_ELEMENT__TYPE:
			setType(TYPE_EDEFAULT);
			return;
		case EConfML1Package.ESETTING_ELEMENT__MIN_OCCURS:
			setMinOccurs(MIN_OCCURS_EDEFAULT);
			return;
		case EConfML1Package.ESETTING_ELEMENT__MAX_OCCURS:
			setMaxOccurs(MAX_OCCURS_EDEFAULT);
			return;
		case EConfML1Package.ESETTING_ELEMENT__MIN_EXCLUSIVE:
			getMinExclusive().clear();
			return;
		case EConfML1Package.ESETTING_ELEMENT__MAX_EXCLUSIVE:
			getMaxExclusive().clear();
			return;
		case EConfML1Package.ESETTING_ELEMENT__MIN_INCLUSIVE:
			getMinInclusive().clear();
			return;
		case EConfML1Package.ESETTING_ELEMENT__MAX_INCLUSIVE:
			getMaxInclusive().clear();
			return;
		case EConfML1Package.ESETTING_ELEMENT__MIN_LENGTH:
			getMinLength().clear();
			return;
		case EConfML1Package.ESETTING_ELEMENT__MAX_LENGTH:
			getMaxLength().clear();
			return;
		case EConfML1Package.ESETTING_ELEMENT__LENGTH:
			getLength().clear();
			return;
		case EConfML1Package.ESETTING_ELEMENT__TOTAL_DIGITS:
			getTotalDigits().clear();
			return;
		case EConfML1Package.ESETTING_ELEMENT__PATTERN:
			getPattern().clear();
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
		case EConfML1Package.ESETTING_ELEMENT__CONTENTS:
			return contents != null && !contents.isEmpty();
		case EConfML1Package.ESETTING_ELEMENT__DESCRIPTIONS:
			return !getDescriptions().isEmpty();
		case EConfML1Package.ESETTING_ELEMENT__LINKS:
			return !getLinks().isEmpty();
		case EConfML1Package.ESETTING_ELEMENT__SETTINGS:
			return !getSettings().isEmpty();
		case EConfML1Package.ESETTING_ELEMENT__ICONS:
			return !getIcons().isEmpty();
		case EConfML1Package.ESETTING_ELEMENT__REF:
			return REF_EDEFAULT == null ? ref != null : !REF_EDEFAULT
					.equals(ref);
		case EConfML1Package.ESETTING_ELEMENT__READ_ONLY:
			return READ_ONLY_EDEFAULT == null ? readOnly != null
					: !READ_ONLY_EDEFAULT.equals(readOnly);
		case EConfML1Package.ESETTING_ELEMENT__RELEVANT:
			return RELEVANT_EDEFAULT == null ? relevant != null
					: !RELEVANT_EDEFAULT.equals(relevant);
		case EConfML1Package.ESETTING_ELEMENT__REQUIRED:
			return REQUIRED_EDEFAULT == null ? required != null
					: !REQUIRED_EDEFAULT.equals(required);
		case EConfML1Package.ESETTING_ELEMENT__MAP_KEY:
			return MAP_KEY_EDEFAULT == null ? mapKey != null
					: !MAP_KEY_EDEFAULT.equals(mapKey);
		case EConfML1Package.ESETTING_ELEMENT__MAP_VALUE:
			return MAP_VALUE_EDEFAULT == null ? mapValue != null
					: !MAP_VALUE_EDEFAULT.equals(mapValue);
		case EConfML1Package.ESETTING_ELEMENT__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT
					.equals(name);
		case EConfML1Package.ESETTING_ELEMENT__CONSTRAINT:
			return CONSTRAINT_EDEFAULT == null ? constraint != null
					: !CONSTRAINT_EDEFAULT.equals(constraint);
		case EConfML1Package.ESETTING_ELEMENT__OPTIONS:
			return !getOptions().isEmpty();
		case EConfML1Package.ESETTING_ELEMENT__PROPERTIES:
			return !getProperties().isEmpty();
		case EConfML1Package.ESETTING_ELEMENT__TYPE:
			return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT
					.equals(type);
		case EConfML1Package.ESETTING_ELEMENT__MIN_OCCURS:
			return MIN_OCCURS_EDEFAULT == null ? minOccurs != null
					: !MIN_OCCURS_EDEFAULT.equals(minOccurs);
		case EConfML1Package.ESETTING_ELEMENT__MAX_OCCURS:
			return MAX_OCCURS_EDEFAULT == null ? maxOccurs != null
					: !MAX_OCCURS_EDEFAULT.equals(maxOccurs);
		case EConfML1Package.ESETTING_ELEMENT__MIN_EXCLUSIVE:
			return !getMinExclusive().isEmpty();
		case EConfML1Package.ESETTING_ELEMENT__MAX_EXCLUSIVE:
			return !getMaxExclusive().isEmpty();
		case EConfML1Package.ESETTING_ELEMENT__MIN_INCLUSIVE:
			return !getMinInclusive().isEmpty();
		case EConfML1Package.ESETTING_ELEMENT__MAX_INCLUSIVE:
			return !getMaxInclusive().isEmpty();
		case EConfML1Package.ESETTING_ELEMENT__MIN_LENGTH:
			return !getMinLength().isEmpty();
		case EConfML1Package.ESETTING_ELEMENT__MAX_LENGTH:
			return !getMaxLength().isEmpty();
		case EConfML1Package.ESETTING_ELEMENT__LENGTH:
			return !getLength().isEmpty();
		case EConfML1Package.ESETTING_ELEMENT__TOTAL_DIGITS:
			return !getTotalDigits().isEmpty();
		case EConfML1Package.ESETTING_ELEMENT__PATTERN:
			return !getPattern().isEmpty();
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
		if (baseClass == EObject.class) {
			switch (derivedFeatureID) {
			case EConfML1Package.ESETTING_ELEMENT__CONTENTS:
				return EConfML1Package.ECONTENTS__CONTENTS;
			default:
				return -1;
			}
		}
		if (baseClass == EDescriptionContainer.class) {
			switch (derivedFeatureID) {
			case EConfML1Package.ESETTING_ELEMENT__DESCRIPTIONS:
				return EConfML1Package.EDESCRIPTION_CONTAINER__DESCRIPTIONS;
			default:
				return -1;
			}
		}
		if (baseClass == ELinkContainer.class) {
			switch (derivedFeatureID) {
			case EConfML1Package.ESETTING_ELEMENT__LINKS:
				return EConfML1Package.ELINK_CONTAINER__LINKS;
			default:
				return -1;
			}
		}
		if (baseClass == ESettingTypeContainer.class) {
			switch (derivedFeatureID) {
			case EConfML1Package.ESETTING_ELEMENT__SETTINGS:
				return EConfML1Package.ESETTING_TYPE_CONTAINER__SETTINGS;
			default:
				return -1;
			}
		}
		if (baseClass == EIconContainer.class) {
			switch (derivedFeatureID) {
			case EConfML1Package.ESETTING_ELEMENT__ICONS:
				return EConfML1Package.EICON_CONTAINER__ICONS;
			default:
				return -1;
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
		if (baseClass == EObject.class) {
			switch (baseFeatureID) {
			case EConfML1Package.ECONTENTS__CONTENTS:
				return EConfML1Package.ESETTING_ELEMENT__CONTENTS;
			default:
				return -1;
			}
		}
		if (baseClass == EDescriptionContainer.class) {
			switch (baseFeatureID) {
			case EConfML1Package.EDESCRIPTION_CONTAINER__DESCRIPTIONS:
				return EConfML1Package.ESETTING_ELEMENT__DESCRIPTIONS;
			default:
				return -1;
			}
		}
		if (baseClass == ELinkContainer.class) {
			switch (baseFeatureID) {
			case EConfML1Package.ELINK_CONTAINER__LINKS:
				return EConfML1Package.ESETTING_ELEMENT__LINKS;
			default:
				return -1;
			}
		}
		if (baseClass == ESettingTypeContainer.class) {
			switch (baseFeatureID) {
			case EConfML1Package.ESETTING_TYPE_CONTAINER__SETTINGS:
				return EConfML1Package.ESETTING_ELEMENT__SETTINGS;
			default:
				return -1;
			}
		}
		if (baseClass == EIconContainer.class) {
			switch (baseFeatureID) {
			case EConfML1Package.EICON_CONTAINER__ICONS:
				return EConfML1Package.ESETTING_ELEMENT__ICONS;
			default:
				return -1;
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
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (contents: ");
		result.append(contents);
		result.append(", ref: ");
		result.append(ref);
		result.append(", readOnly: ");
		result.append(readOnly);
		result.append(", relevant: ");
		result.append(relevant);
		result.append(", required: ");
		result.append(required);
		result.append(", mapKey: ");
		result.append(mapKey);
		result.append(", mapValue: ");
		result.append(mapValue);
		result.append(", name: ");
		result.append(name);
		result.append(", constraint: ");
		result.append(constraint);
		result.append(", type: ");
		result.append(type);
		result.append(", minOccurs: ");
		result.append(minOccurs);
		result.append(", maxOccurs: ");
		result.append(maxOccurs);
		result.append(')');
		return result.toString();
	}

} //ESettingElementImpl
