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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.nokia.tools.vct.common.appmodel.EAppExpression;
import com.nokia.tools.vct.common.appmodel.EAppIconContainer;
import com.nokia.tools.vct.common.appmodel.EAppNamedItem;
import com.nokia.tools.vct.common.appmodel.EAppOptionContainer;
import com.nokia.tools.vct.common.appmodel.EAppProperty;
import com.nokia.tools.vct.common.appmodel.EAppPropertyContainer;
import com.nokia.tools.vct.common.appmodel.EAppSettingOption;
import com.nokia.tools.vct.common.appmodel.EAppSimpleType;
import com.nokia.tools.vct.common.appmodel.EAppTypeConstraints;
import com.nokia.tools.vct.common.appmodel.EAppValueType;
import com.nokia.tools.vct.common.appmodel.EApplicationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EApp Simple Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSimpleTypeImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSimpleTypeImpl#getIconDescriptor <em>Icon Descriptor</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSimpleTypeImpl#getIconTitle <em>Icon Title</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSimpleTypeImpl#getIconURI <em>Icon URI</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSimpleTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSimpleTypeImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSimpleTypeImpl#getMinInclusive <em>Min Inclusive</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSimpleTypeImpl#getMaxInclusive <em>Max Inclusive</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSimpleTypeImpl#getMinExclusive <em>Min Exclusive</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSimpleTypeImpl#getMaxExclusive <em>Max Exclusive</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSimpleTypeImpl#getMinLength <em>Min Length</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSimpleTypeImpl#getLength <em>Length</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSimpleTypeImpl#getMaxLength <em>Max Length</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSimpleTypeImpl#getTotalDigits <em>Total Digits</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSimpleTypeImpl#getPattern <em>Pattern</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSimpleTypeImpl#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSimpleTypeImpl#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSimpleTypeImpl#getRelevant <em>Relevant</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSimpleTypeImpl#isRequired <em>Required</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSimpleTypeImpl#isDeprecated <em>Deprecated</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSimpleTypeImpl#getOptions <em>Options</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSimpleTypeImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EAppSimpleTypeImpl extends EObjectImpl implements EAppSimpleType {
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
	 * The default value of the '{@link #getIconDescriptor() <em>Icon Descriptor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconDescriptor()
	 * @generated
	 * @ordered
	 */
	protected static final Object ICON_DESCRIPTOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIconDescriptor() <em>Icon Descriptor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconDescriptor()
	 * @generated
	 * @ordered
	 */
	protected Object iconDescriptor = ICON_DESCRIPTOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getIconTitle() <em>Icon Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String ICON_TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIconTitle() <em>Icon Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconTitle()
	 * @generated
	 * @ordered
	 */
	protected String iconTitle = ICON_TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getIconURI() <em>Icon URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconURI()
	 * @generated
	 * @ordered
	 */
	protected static final URI ICON_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIconURI() <em>Icon URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconURI()
	 * @generated
	 * @ordered
	 */
	protected URI iconURI = ICON_URI_EDEFAULT;

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
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<EAppProperty> properties;

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
	 * The default value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReadOnly()
	 * @generated
	 * @ordered
	 */
	protected static final boolean READ_ONLY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReadOnly()
	 * @generated
	 * @ordered
	 */
	protected boolean readOnly = READ_ONLY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConstraint() <em>Constraint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraint()
	 * @generated
	 * @ordered
	 */
	protected EAppExpression constraint;

	/**
	 * The cached value of the '{@link #getRelevant() <em>Relevant</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelevant()
	 * @generated
	 * @ordered
	 */
	protected EAppExpression relevant;

	/**
	 * The default value of the '{@link #isRequired() <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRequired()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REQUIRED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRequired() <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRequired()
	 * @generated
	 * @ordered
	 */
	protected boolean required = REQUIRED_EDEFAULT;

	/**
	 * The default value of the '{@link #isDeprecated() <em>Deprecated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeprecated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEPRECATED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDeprecated() <em>Deprecated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeprecated()
	 * @generated
	 * @ordered
	 */
	protected boolean deprecated = DEPRECATED_EDEFAULT;

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
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final EAppValueType TYPE_EDEFAULT = EAppValueType.STRING;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EAppValueType type = TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EAppSimpleTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EApplicationPackage.Literals.EAPP_SIMPLE_TYPE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SIMPLE_TYPE__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getIconDescriptor() {
		return iconDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIconDescriptor(Object newIconDescriptor) {
		Object oldIconDescriptor = iconDescriptor;
		iconDescriptor = newIconDescriptor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SIMPLE_TYPE__ICON_DESCRIPTOR, oldIconDescriptor, iconDescriptor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIconTitle() {
		return iconTitle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIconTitle(String newIconTitle) {
		String oldIconTitle = iconTitle;
		iconTitle = newIconTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SIMPLE_TYPE__ICON_TITLE, oldIconTitle, iconTitle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URI getIconURI() {
		return iconURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIconURI(URI newIconURI) {
		URI oldIconURI = iconURI;
		iconURI = newIconURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SIMPLE_TYPE__ICON_URI, oldIconURI, iconURI));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SIMPLE_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EAppProperty> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList<EAppProperty>(EAppProperty.class, this, EApplicationPackage.EAPP_SIMPLE_TYPE__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReadOnly() {
		return readOnly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReadOnly(boolean newReadOnly) {
		boolean oldReadOnly = readOnly;
		readOnly = newReadOnly;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SIMPLE_TYPE__READ_ONLY, oldReadOnly, readOnly));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAppExpression getConstraint() {
		return constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConstraint(EAppExpression newConstraint, NotificationChain msgs) {
		EAppExpression oldConstraint = constraint;
		constraint = newConstraint;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SIMPLE_TYPE__CONSTRAINT, oldConstraint, newConstraint);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstraint(EAppExpression newConstraint) {
		if (newConstraint != constraint) {
			NotificationChain msgs = null;
			if (constraint != null)
				msgs = ((InternalEObject)constraint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EApplicationPackage.EAPP_SIMPLE_TYPE__CONSTRAINT, null, msgs);
			if (newConstraint != null)
				msgs = ((InternalEObject)newConstraint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EApplicationPackage.EAPP_SIMPLE_TYPE__CONSTRAINT, null, msgs);
			msgs = basicSetConstraint(newConstraint, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SIMPLE_TYPE__CONSTRAINT, newConstraint, newConstraint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAppExpression getRelevant() {
		return relevant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRelevant(EAppExpression newRelevant, NotificationChain msgs) {
		EAppExpression oldRelevant = relevant;
		relevant = newRelevant;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SIMPLE_TYPE__RELEVANT, oldRelevant, newRelevant);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelevant(EAppExpression newRelevant) {
		if (newRelevant != relevant) {
			NotificationChain msgs = null;
			if (relevant != null)
				msgs = ((InternalEObject)relevant).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EApplicationPackage.EAPP_SIMPLE_TYPE__RELEVANT, null, msgs);
			if (newRelevant != null)
				msgs = ((InternalEObject)newRelevant).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EApplicationPackage.EAPP_SIMPLE_TYPE__RELEVANT, null, msgs);
			msgs = basicSetRelevant(newRelevant, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SIMPLE_TYPE__RELEVANT, newRelevant, newRelevant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRequired() {
		return required;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequired(boolean newRequired) {
		boolean oldRequired = required;
		required = newRequired;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SIMPLE_TYPE__REQUIRED, oldRequired, required));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDeprecated() {
		return deprecated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeprecated(boolean newDeprecated) {
		boolean oldDeprecated = deprecated;
		deprecated = newDeprecated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SIMPLE_TYPE__DEPRECATED, oldDeprecated, deprecated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EAppSettingOption> getOptions() {
		if (options == null) {
			options = new EObjectContainmentEList<EAppSettingOption>(EAppSettingOption.class, this, EApplicationPackage.EAPP_SIMPLE_TYPE__OPTIONS);
		}
		return options;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SIMPLE_TYPE__MIN_INCLUSIVE, oldMinInclusive, minInclusive));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SIMPLE_TYPE__MAX_INCLUSIVE, oldMaxInclusive, maxInclusive));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SIMPLE_TYPE__MIN_EXCLUSIVE, oldMinExclusive, minExclusive));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SIMPLE_TYPE__MAX_EXCLUSIVE, oldMaxExclusive, maxExclusive));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SIMPLE_TYPE__MIN_LENGTH, oldMinLength, minLength));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SIMPLE_TYPE__LENGTH, oldLength, length));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SIMPLE_TYPE__MAX_LENGTH, oldMaxLength, maxLength));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SIMPLE_TYPE__TOTAL_DIGITS, oldTotalDigits, totalDigits));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getPattern() {
		if (pattern == null) {
			pattern = new EDataTypeUniqueEList<String>(String.class, this, EApplicationPackage.EAPP_SIMPLE_TYPE__PATTERN);
		}
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAppValueType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(EAppValueType newType) {
		EAppValueType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SIMPLE_TYPE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EApplicationPackage.EAPP_SIMPLE_TYPE__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
			case EApplicationPackage.EAPP_SIMPLE_TYPE__CONSTRAINT:
				return basicSetConstraint(null, msgs);
			case EApplicationPackage.EAPP_SIMPLE_TYPE__RELEVANT:
				return basicSetRelevant(null, msgs);
			case EApplicationPackage.EAPP_SIMPLE_TYPE__OPTIONS:
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
			case EApplicationPackage.EAPP_SIMPLE_TYPE__DESCRIPTION:
				return getDescription();
			case EApplicationPackage.EAPP_SIMPLE_TYPE__ICON_DESCRIPTOR:
				return getIconDescriptor();
			case EApplicationPackage.EAPP_SIMPLE_TYPE__ICON_TITLE:
				return getIconTitle();
			case EApplicationPackage.EAPP_SIMPLE_TYPE__ICON_URI:
				return getIconURI();
			case EApplicationPackage.EAPP_SIMPLE_TYPE__NAME:
				return getName();
			case EApplicationPackage.EAPP_SIMPLE_TYPE__PROPERTIES:
				return getProperties();
			case EApplicationPackage.EAPP_SIMPLE_TYPE__MIN_INCLUSIVE:
				return getMinInclusive();
			case EApplicationPackage.EAPP_SIMPLE_TYPE__MAX_INCLUSIVE:
				return getMaxInclusive();
			case EApplicationPackage.EAPP_SIMPLE_TYPE__MIN_EXCLUSIVE:
				return getMinExclusive();
			case EApplicationPackage.EAPP_SIMPLE_TYPE__MAX_EXCLUSIVE:
				return getMaxExclusive();
			case EApplicationPackage.EAPP_SIMPLE_TYPE__MIN_LENGTH:
				return getMinLength();
			case EApplicationPackage.EAPP_SIMPLE_TYPE__LENGTH:
				return getLength();
			case EApplicationPackage.EAPP_SIMPLE_TYPE__MAX_LENGTH:
				return getMaxLength();
			case EApplicationPackage.EAPP_SIMPLE_TYPE__TOTAL_DIGITS:
				return getTotalDigits();
			case EApplicationPackage.EAPP_SIMPLE_TYPE__PATTERN:
				return getPattern();
			case EApplicationPackage.EAPP_SIMPLE_TYPE__READ_ONLY:
				return isReadOnly() ? Boolean.TRUE : Boolean.FALSE;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__CONSTRAINT:
				return getConstraint();
			case EApplicationPackage.EAPP_SIMPLE_TYPE__RELEVANT:
				return getRelevant();
			case EApplicationPackage.EAPP_SIMPLE_TYPE__REQUIRED:
				return isRequired() ? Boolean.TRUE : Boolean.FALSE;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__DEPRECATED:
				return isDeprecated() ? Boolean.TRUE : Boolean.FALSE;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__OPTIONS:
				return getOptions();
			case EApplicationPackage.EAPP_SIMPLE_TYPE__TYPE:
				return getType();
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
			case EApplicationPackage.EAPP_SIMPLE_TYPE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__ICON_DESCRIPTOR:
				setIconDescriptor(newValue);
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__ICON_TITLE:
				setIconTitle((String)newValue);
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__ICON_URI:
				setIconURI((URI)newValue);
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__NAME:
				setName((String)newValue);
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends EAppProperty>)newValue);
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__MIN_INCLUSIVE:
				setMinInclusive(newValue);
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__MAX_INCLUSIVE:
				setMaxInclusive(newValue);
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__MIN_EXCLUSIVE:
				setMinExclusive(newValue);
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__MAX_EXCLUSIVE:
				setMaxExclusive(newValue);
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__MIN_LENGTH:
				setMinLength((Integer)newValue);
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__LENGTH:
				setLength((Integer)newValue);
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__MAX_LENGTH:
				setMaxLength((Integer)newValue);
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__TOTAL_DIGITS:
				setTotalDigits((Integer)newValue);
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__PATTERN:
				getPattern().clear();
				getPattern().addAll((Collection<? extends String>)newValue);
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__READ_ONLY:
				setReadOnly(((Boolean)newValue).booleanValue());
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__CONSTRAINT:
				setConstraint((EAppExpression)newValue);
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__RELEVANT:
				setRelevant((EAppExpression)newValue);
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__REQUIRED:
				setRequired(((Boolean)newValue).booleanValue());
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__DEPRECATED:
				setDeprecated(((Boolean)newValue).booleanValue());
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__OPTIONS:
				getOptions().clear();
				getOptions().addAll((Collection<? extends EAppSettingOption>)newValue);
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__TYPE:
				setType((EAppValueType)newValue);
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
			case EApplicationPackage.EAPP_SIMPLE_TYPE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__ICON_DESCRIPTOR:
				setIconDescriptor(ICON_DESCRIPTOR_EDEFAULT);
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__ICON_TITLE:
				setIconTitle(ICON_TITLE_EDEFAULT);
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__ICON_URI:
				setIconURI(ICON_URI_EDEFAULT);
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__PROPERTIES:
				getProperties().clear();
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__MIN_INCLUSIVE:
				setMinInclusive(MIN_INCLUSIVE_EDEFAULT);
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__MAX_INCLUSIVE:
				setMaxInclusive(MAX_INCLUSIVE_EDEFAULT);
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__MIN_EXCLUSIVE:
				setMinExclusive(MIN_EXCLUSIVE_EDEFAULT);
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__MAX_EXCLUSIVE:
				setMaxExclusive(MAX_EXCLUSIVE_EDEFAULT);
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__MIN_LENGTH:
				setMinLength(MIN_LENGTH_EDEFAULT);
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__LENGTH:
				setLength(LENGTH_EDEFAULT);
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__MAX_LENGTH:
				setMaxLength(MAX_LENGTH_EDEFAULT);
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__TOTAL_DIGITS:
				setTotalDigits(TOTAL_DIGITS_EDEFAULT);
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__PATTERN:
				getPattern().clear();
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__READ_ONLY:
				setReadOnly(READ_ONLY_EDEFAULT);
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__CONSTRAINT:
				setConstraint((EAppExpression)null);
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__RELEVANT:
				setRelevant((EAppExpression)null);
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__REQUIRED:
				setRequired(REQUIRED_EDEFAULT);
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__DEPRECATED:
				setDeprecated(DEPRECATED_EDEFAULT);
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__OPTIONS:
				getOptions().clear();
				return;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__TYPE:
				setType(TYPE_EDEFAULT);
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
			case EApplicationPackage.EAPP_SIMPLE_TYPE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case EApplicationPackage.EAPP_SIMPLE_TYPE__ICON_DESCRIPTOR:
				return ICON_DESCRIPTOR_EDEFAULT == null ? iconDescriptor != null : !ICON_DESCRIPTOR_EDEFAULT.equals(iconDescriptor);
			case EApplicationPackage.EAPP_SIMPLE_TYPE__ICON_TITLE:
				return ICON_TITLE_EDEFAULT == null ? iconTitle != null : !ICON_TITLE_EDEFAULT.equals(iconTitle);
			case EApplicationPackage.EAPP_SIMPLE_TYPE__ICON_URI:
				return ICON_URI_EDEFAULT == null ? iconURI != null : !ICON_URI_EDEFAULT.equals(iconURI);
			case EApplicationPackage.EAPP_SIMPLE_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EApplicationPackage.EAPP_SIMPLE_TYPE__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case EApplicationPackage.EAPP_SIMPLE_TYPE__MIN_INCLUSIVE:
				return MIN_INCLUSIVE_EDEFAULT == null ? minInclusive != null : !MIN_INCLUSIVE_EDEFAULT.equals(minInclusive);
			case EApplicationPackage.EAPP_SIMPLE_TYPE__MAX_INCLUSIVE:
				return MAX_INCLUSIVE_EDEFAULT == null ? maxInclusive != null : !MAX_INCLUSIVE_EDEFAULT.equals(maxInclusive);
			case EApplicationPackage.EAPP_SIMPLE_TYPE__MIN_EXCLUSIVE:
				return MIN_EXCLUSIVE_EDEFAULT == null ? minExclusive != null : !MIN_EXCLUSIVE_EDEFAULT.equals(minExclusive);
			case EApplicationPackage.EAPP_SIMPLE_TYPE__MAX_EXCLUSIVE:
				return MAX_EXCLUSIVE_EDEFAULT == null ? maxExclusive != null : !MAX_EXCLUSIVE_EDEFAULT.equals(maxExclusive);
			case EApplicationPackage.EAPP_SIMPLE_TYPE__MIN_LENGTH:
				return MIN_LENGTH_EDEFAULT == null ? minLength != null : !MIN_LENGTH_EDEFAULT.equals(minLength);
			case EApplicationPackage.EAPP_SIMPLE_TYPE__LENGTH:
				return LENGTH_EDEFAULT == null ? length != null : !LENGTH_EDEFAULT.equals(length);
			case EApplicationPackage.EAPP_SIMPLE_TYPE__MAX_LENGTH:
				return MAX_LENGTH_EDEFAULT == null ? maxLength != null : !MAX_LENGTH_EDEFAULT.equals(maxLength);
			case EApplicationPackage.EAPP_SIMPLE_TYPE__TOTAL_DIGITS:
				return TOTAL_DIGITS_EDEFAULT == null ? totalDigits != null : !TOTAL_DIGITS_EDEFAULT.equals(totalDigits);
			case EApplicationPackage.EAPP_SIMPLE_TYPE__PATTERN:
				return pattern != null && !pattern.isEmpty();
			case EApplicationPackage.EAPP_SIMPLE_TYPE__READ_ONLY:
				return readOnly != READ_ONLY_EDEFAULT;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__CONSTRAINT:
				return constraint != null;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__RELEVANT:
				return relevant != null;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__REQUIRED:
				return required != REQUIRED_EDEFAULT;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__DEPRECATED:
				return deprecated != DEPRECATED_EDEFAULT;
			case EApplicationPackage.EAPP_SIMPLE_TYPE__OPTIONS:
				return options != null && !options.isEmpty();
			case EApplicationPackage.EAPP_SIMPLE_TYPE__TYPE:
				return type != TYPE_EDEFAULT;
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
		if (baseClass == EAppIconContainer.class) {
			switch (derivedFeatureID) {
				case EApplicationPackage.EAPP_SIMPLE_TYPE__ICON_DESCRIPTOR: return EApplicationPackage.EAPP_ICON_CONTAINER__ICON_DESCRIPTOR;
				case EApplicationPackage.EAPP_SIMPLE_TYPE__ICON_TITLE: return EApplicationPackage.EAPP_ICON_CONTAINER__ICON_TITLE;
				case EApplicationPackage.EAPP_SIMPLE_TYPE__ICON_URI: return EApplicationPackage.EAPP_ICON_CONTAINER__ICON_URI;
				default: return -1;
			}
		}
		if (baseClass == EAppNamedItem.class) {
			switch (derivedFeatureID) {
				case EApplicationPackage.EAPP_SIMPLE_TYPE__NAME: return EApplicationPackage.EAPP_NAMED_ITEM__NAME;
				default: return -1;
			}
		}
		if (baseClass == EAppPropertyContainer.class) {
			switch (derivedFeatureID) {
				case EApplicationPackage.EAPP_SIMPLE_TYPE__PROPERTIES: return EApplicationPackage.EAPP_PROPERTY_CONTAINER__PROPERTIES;
				default: return -1;
			}
		}
		if (baseClass == EAppTypeConstraints.class) {
			switch (derivedFeatureID) {
				case EApplicationPackage.EAPP_SIMPLE_TYPE__MIN_INCLUSIVE: return EApplicationPackage.EAPP_TYPE_CONSTRAINTS__MIN_INCLUSIVE;
				case EApplicationPackage.EAPP_SIMPLE_TYPE__MAX_INCLUSIVE: return EApplicationPackage.EAPP_TYPE_CONSTRAINTS__MAX_INCLUSIVE;
				case EApplicationPackage.EAPP_SIMPLE_TYPE__MIN_EXCLUSIVE: return EApplicationPackage.EAPP_TYPE_CONSTRAINTS__MIN_EXCLUSIVE;
				case EApplicationPackage.EAPP_SIMPLE_TYPE__MAX_EXCLUSIVE: return EApplicationPackage.EAPP_TYPE_CONSTRAINTS__MAX_EXCLUSIVE;
				case EApplicationPackage.EAPP_SIMPLE_TYPE__MIN_LENGTH: return EApplicationPackage.EAPP_TYPE_CONSTRAINTS__MIN_LENGTH;
				case EApplicationPackage.EAPP_SIMPLE_TYPE__LENGTH: return EApplicationPackage.EAPP_TYPE_CONSTRAINTS__LENGTH;
				case EApplicationPackage.EAPP_SIMPLE_TYPE__MAX_LENGTH: return EApplicationPackage.EAPP_TYPE_CONSTRAINTS__MAX_LENGTH;
				case EApplicationPackage.EAPP_SIMPLE_TYPE__TOTAL_DIGITS: return EApplicationPackage.EAPP_TYPE_CONSTRAINTS__TOTAL_DIGITS;
				case EApplicationPackage.EAPP_SIMPLE_TYPE__PATTERN: return EApplicationPackage.EAPP_TYPE_CONSTRAINTS__PATTERN;
				default: return -1;
			}
		}
		if (baseClass == EAppOptionContainer.class) {
			switch (derivedFeatureID) {
				case EApplicationPackage.EAPP_SIMPLE_TYPE__OPTIONS: return EApplicationPackage.EAPP_OPTION_CONTAINER__OPTIONS;
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
		if (baseClass == EAppIconContainer.class) {
			switch (baseFeatureID) {
				case EApplicationPackage.EAPP_ICON_CONTAINER__ICON_DESCRIPTOR: return EApplicationPackage.EAPP_SIMPLE_TYPE__ICON_DESCRIPTOR;
				case EApplicationPackage.EAPP_ICON_CONTAINER__ICON_TITLE: return EApplicationPackage.EAPP_SIMPLE_TYPE__ICON_TITLE;
				case EApplicationPackage.EAPP_ICON_CONTAINER__ICON_URI: return EApplicationPackage.EAPP_SIMPLE_TYPE__ICON_URI;
				default: return -1;
			}
		}
		if (baseClass == EAppNamedItem.class) {
			switch (baseFeatureID) {
				case EApplicationPackage.EAPP_NAMED_ITEM__NAME: return EApplicationPackage.EAPP_SIMPLE_TYPE__NAME;
				default: return -1;
			}
		}
		if (baseClass == EAppPropertyContainer.class) {
			switch (baseFeatureID) {
				case EApplicationPackage.EAPP_PROPERTY_CONTAINER__PROPERTIES: return EApplicationPackage.EAPP_SIMPLE_TYPE__PROPERTIES;
				default: return -1;
			}
		}
		if (baseClass == EAppTypeConstraints.class) {
			switch (baseFeatureID) {
				case EApplicationPackage.EAPP_TYPE_CONSTRAINTS__MIN_INCLUSIVE: return EApplicationPackage.EAPP_SIMPLE_TYPE__MIN_INCLUSIVE;
				case EApplicationPackage.EAPP_TYPE_CONSTRAINTS__MAX_INCLUSIVE: return EApplicationPackage.EAPP_SIMPLE_TYPE__MAX_INCLUSIVE;
				case EApplicationPackage.EAPP_TYPE_CONSTRAINTS__MIN_EXCLUSIVE: return EApplicationPackage.EAPP_SIMPLE_TYPE__MIN_EXCLUSIVE;
				case EApplicationPackage.EAPP_TYPE_CONSTRAINTS__MAX_EXCLUSIVE: return EApplicationPackage.EAPP_SIMPLE_TYPE__MAX_EXCLUSIVE;
				case EApplicationPackage.EAPP_TYPE_CONSTRAINTS__MIN_LENGTH: return EApplicationPackage.EAPP_SIMPLE_TYPE__MIN_LENGTH;
				case EApplicationPackage.EAPP_TYPE_CONSTRAINTS__LENGTH: return EApplicationPackage.EAPP_SIMPLE_TYPE__LENGTH;
				case EApplicationPackage.EAPP_TYPE_CONSTRAINTS__MAX_LENGTH: return EApplicationPackage.EAPP_SIMPLE_TYPE__MAX_LENGTH;
				case EApplicationPackage.EAPP_TYPE_CONSTRAINTS__TOTAL_DIGITS: return EApplicationPackage.EAPP_SIMPLE_TYPE__TOTAL_DIGITS;
				case EApplicationPackage.EAPP_TYPE_CONSTRAINTS__PATTERN: return EApplicationPackage.EAPP_SIMPLE_TYPE__PATTERN;
				default: return -1;
			}
		}
		if (baseClass == EAppOptionContainer.class) {
			switch (baseFeatureID) {
				case EApplicationPackage.EAPP_OPTION_CONTAINER__OPTIONS: return EApplicationPackage.EAPP_SIMPLE_TYPE__OPTIONS;
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
		result.append(", iconDescriptor: ");
		result.append(iconDescriptor);
		result.append(", iconTitle: ");
		result.append(iconTitle);
		result.append(", iconURI: ");
		result.append(iconURI);
		result.append(", name: ");
		result.append(name);
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
		result.append(", readOnly: ");
		result.append(readOnly);
		result.append(", required: ");
		result.append(required);
		result.append(", deprecated: ");
		result.append(deprecated);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //EAppSimpleTypeImpl
