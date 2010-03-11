/*
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
*/
package configurationemf.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import configurationemf.Configuration;
import configurationemf.ConfigurationemfFactory;
import configurationemf.ConfigurationemfPackage;
import configurationemf.Data;
import configurationemf.Feature;
import configurationemf.Icon;
import configurationemf.Length;
import configurationemf.Link;
import configurationemf.MaxExclusive;
import configurationemf.MaxInclusive;
import configurationemf.MaxLength;
import configurationemf.MinExclusive;
import configurationemf.MinInclusive;
import configurationemf.MinLength;
import configurationemf.Option;
import configurationemf.ParentSetting;
import configurationemf.Pattern;
import configurationemf.Property;
import configurationemf.Ref;
import configurationemf.Referable;
import configurationemf.Rfs;
import configurationemf.RootConf;
import configurationemf.Setting;
import configurationemf.TYPE;
import configurationemf.TotalDigits;
import configurationemf.util.PrioritisedConfigurationList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Setting</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link configurationemf.impl.SettingImpl#getName <em>Name</em>}</li>
 *   <li>{@link configurationemf.impl.SettingImpl#getType <em>Type</em>}</li>
 *   <li>{@link configurationemf.impl.SettingImpl#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link configurationemf.impl.SettingImpl#getRelevant <em>Relevant</em>}</li>
 *   <li>{@link configurationemf.impl.SettingImpl#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link configurationemf.impl.SettingImpl#getRequired <em>Required</em>}</li>
 *   <li>{@link configurationemf.impl.SettingImpl#getOption <em>Option</em>}</li>
 *   <li>{@link configurationemf.impl.SettingImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link configurationemf.impl.SettingImpl#getMinLength <em>Min Length</em>}</li>
 *   <li>{@link configurationemf.impl.SettingImpl#getMaxLength <em>Max Length</em>}</li>
 *   <li>{@link configurationemf.impl.SettingImpl#getLength <em>Length</em>}</li>
 *   <li>{@link configurationemf.impl.SettingImpl#getMaxInclusive <em>Max Inclusive</em>}</li>
 *   <li>{@link configurationemf.impl.SettingImpl#getMaxExclusive <em>Max Exclusive</em>}</li>
 *   <li>{@link configurationemf.impl.SettingImpl#getMinExclusive <em>Min Exclusive</em>}</li>
 *   <li>{@link configurationemf.impl.SettingImpl#getPattern <em>Pattern</em>}</li>
 *   <li>{@link configurationemf.impl.SettingImpl#getMinInclusive <em>Min Inclusive</em>}</li>
 *   <li>{@link configurationemf.impl.SettingImpl#getTotalDigits <em>Total Digits</em>}</li>
 *   <li>{@link configurationemf.impl.SettingImpl#getLink <em>Link</em>}</li>
 *   <li>{@link configurationemf.impl.SettingImpl#getIcon <em>Icon</em>}</li>
 *   <li>{@link configurationemf.impl.SettingImpl#getBoolOptions <em>Bool Options</em>}</li>
 *   <li>{@link configurationemf.impl.SettingImpl#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link configurationemf.impl.SettingImpl#getCurrentValue <em>Current Value</em>}</li>
 *   <li>{@link configurationemf.impl.SettingImpl#getTopValue <em>Top Value</em>}</li>
 *   <li>{@link configurationemf.impl.SettingImpl#getCurrentConf <em>Current Conf</em>}</li>
 *   <li>{@link configurationemf.impl.SettingImpl#getDefaultConf <em>Default Conf</em>}</li>
 *   <li>{@link configurationemf.impl.SettingImpl#isRo <em>Ro</em>}</li>
 *   <li>{@link configurationemf.impl.SettingImpl#getPossibleValue <em>Possible Value</em>}</li>
 *   <li>{@link configurationemf.impl.SettingImpl#getCurrentType <em>Current Type</em>}</li>
 *   <li>{@link configurationemf.impl.SettingImpl#isValueChangeble <em>Value Changeble</em>}</li>
 *   <li>{@link configurationemf.impl.SettingImpl#isRfs <em>Rfs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SettingImpl extends ReferableImpl implements Setting {
	
	
	private static EList booleanOptions=null;
	private Map<Configuration, Ref> confRefMap=new HashMap<Configuration, Ref>();
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
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated NOT
	 * @ordered
	 */
	protected static final TYPE TYPE_EDEFAULT = TYPE.UNDEFINED;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected TYPE type = TYPE_EDEFAULT;

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
	 * The cached value of the '{@link #getOption() <em>Option</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOption()
	 * @generated
	 * @ordered
	 */
	protected EList<Option> option;

	/**
	 * The cached value of the '{@link #getProperty() <em>Property</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected Property property;

	/**
	 * The cached value of the '{@link #getMinLength() <em>Min Length</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinLength()
	 * @generated
	 * @ordered
	 */
	protected MinLength minLength;

	/**
	 * The cached value of the '{@link #getMaxLength() <em>Max Length</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxLength()
	 * @generated
	 * @ordered
	 */
	protected MaxLength maxLength;

	/**
	 * The cached value of the '{@link #getLength() <em>Length</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
	protected Length length;

	/**
	 * The cached value of the '{@link #getMaxInclusive() <em>Max Inclusive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxInclusive()
	 * @generated
	 * @ordered
	 */
	protected MaxInclusive maxInclusive;

	/**
	 * The cached value of the '{@link #getMaxExclusive() <em>Max Exclusive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxExclusive()
	 * @generated
	 * @ordered
	 */
	protected MaxExclusive maxExclusive;

	/**
	 * The cached value of the '{@link #getMinExclusive() <em>Min Exclusive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinExclusive()
	 * @generated
	 * @ordered
	 */
	protected MinExclusive minExclusive;

	/**
	 * The cached value of the '{@link #getPattern() <em>Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected Pattern pattern;

	/**
	 * The cached value of the '{@link #getMinInclusive() <em>Min Inclusive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinInclusive()
	 * @generated
	 * @ordered
	 */
	protected MinInclusive minInclusive;

	/**
	 * The cached value of the '{@link #getTotalDigits() <em>Total Digits</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalDigits()
	 * @generated
	 * @ordered
	 */
	protected TotalDigits totalDigits;

	/**
	 * The cached value of the '{@link #getLink() <em>Link</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink()
	 * @generated
	 * @ordered
	 */
	protected EList<Link> link;

	/**
	 * The cached value of the '{@link #getIcon() <em>Icon</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon()
	 * @generated
	 * @ordered
	 */
	protected EList<Icon> icon;

	/**
	 * The default value of the '{@link #getDefaultValue() <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_VALUE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getCurrentValue() <em>Current Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentValue()
	 * @generated
	 * @ordered
	 */
	protected static final String CURRENT_VALUE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getTopValue() <em>Top Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTopValue()
	 * @generated
	 * @ordered
	 */
	protected static final String TOP_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCurrentConf() <em>Current Conf</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentConf()
	 * @generated
	 * @ordered
	 */
	protected Configuration currentConf;

	/**
	 * The cached value of the '{@link #getDefaultConf() <em>Default Conf</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultConf()
	 * @generated
	 * @ordered
	 */
	protected Configuration defaultConf;

	/**
	 * The default value of the '{@link #isRo() <em>Ro</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRo()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RO_EDEFAULT = false;
	/**
	 * The default value of the '{@link #getCurrentType() <em>Current Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentType()
	 * @generated NOT
	 * @ordered
	 */
	protected static final String CURRENT_TYPE_EDEFAULT = TYPE_EDEFAULT.getLiteral();
	/**
	 * The default value of the '{@link #isValueChangeble() <em>Value Changeble</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValueChangeble()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VALUE_CHANGEBLE_EDEFAULT = false;
	/**
	 * The default value of the '{@link #isRfs() <em>Rfs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRfs()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RFS_EDEFAULT = false;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected SettingImpl() {
		super();
		this.eAdapters().add(selfAdapter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationemfPackage.Literals.SETTING;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.SETTING__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TYPE getType() {
		
		Configuration defaultConf = this.getDefaultConf();
		
		if (defaultConf!=null && defaultConf.isReadOnly()) //show undefined type as integer to variant engineer
		{
			if (type.getValue()==TYPE.UNDEFINED_VALUE)
			{
				return TYPE.INT;
			}	
		}

		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(TYPE newType) {
		TYPE oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.SETTING__TYPE, oldType, type));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.SETTING__CONSTRAINT, oldConstraint, constraint));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.SETTING__RELEVANT, oldRelevant, relevant));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.SETTING__READ_ONLY, oldReadOnly, readOnly));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.SETTING__REQUIRED, oldRequired, required));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Option> getOption() {
		if (option == null) {
			option = new EObjectContainmentEList<Option>(Option.class, this, ConfigurationemfPackage.SETTING__OPTION);
		}
		return option;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getProperty() {
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProperty(Property newProperty, NotificationChain msgs) {
		Property oldProperty = property;
		property = newProperty;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.SETTING__PROPERTY, oldProperty, newProperty);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperty(Property newProperty) {
		if (newProperty != property) {
			NotificationChain msgs = null;
			if (property != null)
				msgs = ((InternalEObject)property).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.SETTING__PROPERTY, null, msgs);
			if (newProperty != null)
				msgs = ((InternalEObject)newProperty).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.SETTING__PROPERTY, null, msgs);
			msgs = basicSetProperty(newProperty, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.SETTING__PROPERTY, newProperty, newProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MinLength getMinLength() {
		return minLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMinLength(MinLength newMinLength, NotificationChain msgs) {
		MinLength oldMinLength = minLength;
		minLength = newMinLength;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.SETTING__MIN_LENGTH, oldMinLength, newMinLength);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinLength(MinLength newMinLength) {
		if (newMinLength != minLength) {
			NotificationChain msgs = null;
			if (minLength != null)
				msgs = ((InternalEObject)minLength).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.SETTING__MIN_LENGTH, null, msgs);
			if (newMinLength != null)
				msgs = ((InternalEObject)newMinLength).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.SETTING__MIN_LENGTH, null, msgs);
			msgs = basicSetMinLength(newMinLength, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.SETTING__MIN_LENGTH, newMinLength, newMinLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MaxLength getMaxLength() {
		return maxLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMaxLength(MaxLength newMaxLength, NotificationChain msgs) {
		MaxLength oldMaxLength = maxLength;
		maxLength = newMaxLength;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.SETTING__MAX_LENGTH, oldMaxLength, newMaxLength);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxLength(MaxLength newMaxLength) {
		if (newMaxLength != maxLength) {
			NotificationChain msgs = null;
			if (maxLength != null)
				msgs = ((InternalEObject)maxLength).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.SETTING__MAX_LENGTH, null, msgs);
			if (newMaxLength != null)
				msgs = ((InternalEObject)newMaxLength).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.SETTING__MAX_LENGTH, null, msgs);
			msgs = basicSetMaxLength(newMaxLength, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.SETTING__MAX_LENGTH, newMaxLength, newMaxLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Length getLength() {
		return length;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLength(Length newLength, NotificationChain msgs) {
		Length oldLength = length;
		length = newLength;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.SETTING__LENGTH, oldLength, newLength);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLength(Length newLength) {
		if (newLength != length) {
			NotificationChain msgs = null;
			if (length != null)
				msgs = ((InternalEObject)length).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.SETTING__LENGTH, null, msgs);
			if (newLength != null)
				msgs = ((InternalEObject)newLength).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.SETTING__LENGTH, null, msgs);
			msgs = basicSetLength(newLength, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.SETTING__LENGTH, newLength, newLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MaxInclusive getMaxInclusive() {
		return maxInclusive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMaxInclusive(MaxInclusive newMaxInclusive, NotificationChain msgs) {
		MaxInclusive oldMaxInclusive = maxInclusive;
		maxInclusive = newMaxInclusive;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.SETTING__MAX_INCLUSIVE, oldMaxInclusive, newMaxInclusive);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxInclusive(MaxInclusive newMaxInclusive) {
		if (newMaxInclusive != maxInclusive) {
			NotificationChain msgs = null;
			if (maxInclusive != null)
				msgs = ((InternalEObject)maxInclusive).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.SETTING__MAX_INCLUSIVE, null, msgs);
			if (newMaxInclusive != null)
				msgs = ((InternalEObject)newMaxInclusive).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.SETTING__MAX_INCLUSIVE, null, msgs);
			msgs = basicSetMaxInclusive(newMaxInclusive, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.SETTING__MAX_INCLUSIVE, newMaxInclusive, newMaxInclusive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MaxExclusive getMaxExclusive() {
		return maxExclusive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMaxExclusive(MaxExclusive newMaxExclusive, NotificationChain msgs) {
		MaxExclusive oldMaxExclusive = maxExclusive;
		maxExclusive = newMaxExclusive;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.SETTING__MAX_EXCLUSIVE, oldMaxExclusive, newMaxExclusive);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxExclusive(MaxExclusive newMaxExclusive) {
		if (newMaxExclusive != maxExclusive) {
			NotificationChain msgs = null;
			if (maxExclusive != null)
				msgs = ((InternalEObject)maxExclusive).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.SETTING__MAX_EXCLUSIVE, null, msgs);
			if (newMaxExclusive != null)
				msgs = ((InternalEObject)newMaxExclusive).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.SETTING__MAX_EXCLUSIVE, null, msgs);
			msgs = basicSetMaxExclusive(newMaxExclusive, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.SETTING__MAX_EXCLUSIVE, newMaxExclusive, newMaxExclusive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MinExclusive getMinExclusive() {
		return minExclusive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMinExclusive(MinExclusive newMinExclusive, NotificationChain msgs) {
		MinExclusive oldMinExclusive = minExclusive;
		minExclusive = newMinExclusive;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.SETTING__MIN_EXCLUSIVE, oldMinExclusive, newMinExclusive);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinExclusive(MinExclusive newMinExclusive) {
		if (newMinExclusive != minExclusive) {
			NotificationChain msgs = null;
			if (minExclusive != null)
				msgs = ((InternalEObject)minExclusive).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.SETTING__MIN_EXCLUSIVE, null, msgs);
			if (newMinExclusive != null)
				msgs = ((InternalEObject)newMinExclusive).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.SETTING__MIN_EXCLUSIVE, null, msgs);
			msgs = basicSetMinExclusive(newMinExclusive, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.SETTING__MIN_EXCLUSIVE, newMinExclusive, newMinExclusive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern getPattern() {
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPattern(Pattern newPattern, NotificationChain msgs) {
		Pattern oldPattern = pattern;
		pattern = newPattern;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.SETTING__PATTERN, oldPattern, newPattern);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPattern(Pattern newPattern) {
		if (newPattern != pattern) {
			NotificationChain msgs = null;
			if (pattern != null)
				msgs = ((InternalEObject)pattern).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.SETTING__PATTERN, null, msgs);
			if (newPattern != null)
				msgs = ((InternalEObject)newPattern).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.SETTING__PATTERN, null, msgs);
			msgs = basicSetPattern(newPattern, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.SETTING__PATTERN, newPattern, newPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MinInclusive getMinInclusive() {
		return minInclusive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMinInclusive(MinInclusive newMinInclusive, NotificationChain msgs) {
		MinInclusive oldMinInclusive = minInclusive;
		minInclusive = newMinInclusive;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.SETTING__MIN_INCLUSIVE, oldMinInclusive, newMinInclusive);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinInclusive(MinInclusive newMinInclusive) {
		if (newMinInclusive != minInclusive) {
			NotificationChain msgs = null;
			if (minInclusive != null)
				msgs = ((InternalEObject)minInclusive).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.SETTING__MIN_INCLUSIVE, null, msgs);
			if (newMinInclusive != null)
				msgs = ((InternalEObject)newMinInclusive).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.SETTING__MIN_INCLUSIVE, null, msgs);
			msgs = basicSetMinInclusive(newMinInclusive, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.SETTING__MIN_INCLUSIVE, newMinInclusive, newMinInclusive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TotalDigits getTotalDigits() {
		return totalDigits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTotalDigits(TotalDigits newTotalDigits, NotificationChain msgs) {
		TotalDigits oldTotalDigits = totalDigits;
		totalDigits = newTotalDigits;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.SETTING__TOTAL_DIGITS, oldTotalDigits, newTotalDigits);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalDigits(TotalDigits newTotalDigits) {
		if (newTotalDigits != totalDigits) {
			NotificationChain msgs = null;
			if (totalDigits != null)
				msgs = ((InternalEObject)totalDigits).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.SETTING__TOTAL_DIGITS, null, msgs);
			if (newTotalDigits != null)
				msgs = ((InternalEObject)newTotalDigits).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.SETTING__TOTAL_DIGITS, null, msgs);
			msgs = basicSetTotalDigits(newTotalDigits, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.SETTING__TOTAL_DIGITS, newTotalDigits, newTotalDigits));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Link> getLink() {
		if (link == null) {
			link = new EObjectContainmentEList<Link>(Link.class, this, ConfigurationemfPackage.SETTING__LINK);
		}
		return link;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Icon> getIcon() {
		if (icon == null) {
			icon = new EObjectContainmentEList<Icon>(Icon.class, this, ConfigurationemfPackage.SETTING__ICON);
		}
		return icon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList getBoolOptions() {
		if(this.getType()!=null&&this.getType().equals(TYPE.BOOLEAN)){
			if(booleanOptions==null){
				booleanOptions = new BasicEList();
				Option oTrue = ConfigurationemfFactory.eINSTANCE.createOption();
				Option oFalse = ConfigurationemfFactory.eINSTANCE.createOption();
				oTrue.setName("On");
				oTrue.setValue("true");
				oFalse.setName("Off");
				oFalse.setValue("false");
				booleanOptions.add(oTrue);
				booleanOptions.add(oFalse);
			}
			return booleanOptions;
		}
		return new BasicEList();
	}

	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getDefaultValue() {
		return getConfValue(getDefaultConf());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract String getAbsRef();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setConfValue(String value, Configuration conf) {
		Ref featureRef = getCreateFeatureRef(conf);
		Ref myRefInConf=null;//to be found
		for(Ref ref : featureRef.getRef()){
			try
			{
				if(ref.getName().compareTo(this.getRef())==0)
					myRefInConf=ref;
			}
			catch (NullPointerException npe)
			{
				System.out.println(npe);
				return;
			}
		}
		if(myRefInConf==null){
			myRefInConf=createRef(featureRef, getRefs());//ConfigurationemfFactory.eINSTANCE.createRef();
		}
		myRefInConf.setValue(value);
		getHierarchy();
	}

	public Ref getCreateFeatureRef(Configuration conf){
		Ref theRef = null;
		Feature myFeature = (Feature)this.eContainer();
		Data data = conf.getData();
		if(data==null){
			data = ConfigurationemfFactory.eINSTANCE.createData();
			conf.setData(data);
		}
		for(Ref tRef : data.getRef()){
			if(tRef.getName().compareTo(myFeature.getRef())==0)
				theRef=tRef;
		}
		if(theRef==null){
			theRef=ConfigurationemfFactory.eINSTANCE.createRef();
			theRef.setName(myFeature.getRef());
			data.getRef().add(theRef);
			myFeature.getRefs().add(theRef);
		}
			
		return theRef;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	private Ref _currentRef=null;
	public String getCurrentValue() {
		return getConfValue(getCurrentConf());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setCurrentValue(String newCurrentValue) {
		if(newCurrentValue==CURRENT_VALUE_EDEFAULT || newCurrentValue==""){
				if(_currentRef==null){
					Configuration conf = this.getCurrentConf();
					Data data=conf.getData();
					String[] refs = this.getAbsRef().split("/");
					for(int i=0;i<refs.length;i++){
						if(i==0)
							_currentRef=getMatchingRef(data.getRef(), refs[i]);
						else
							_currentRef=getMatchingRef(_currentRef.getRef(), refs[i]);
					}
				}
				
				String oldValue=this.getCurrentValue();
				if (_currentRef!=null)
				{
					_currentRef.setValue("");
					if (eNotificationRequired())
						eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.SETTING__CURRENT_VALUE, oldValue, newCurrentValue));
					removeEmptyRef(_currentRef);
				}
			_currentRef=null;
			
		}else{
			if(_currentRef==null){

				Ref featureRef = this.getCreateFeatureRef(this.getCurrentConf());
				
				for(Ref stRef:featureRef.getRef()){
					if(stRef.getAbsRef().compareTo(this.getAbsRef())==0){
						_currentRef=stRef;
						break;
					}
				}
				if(_currentRef==null){
					_currentRef = ConfigurationemfFactory.eINSTANCE.createRef();
					_currentRef.setName(this.getRef());
				}
				
				featureRef.getRef().add(_currentRef);
				this.getRefs().add(_currentRef);			
			}
			
			if(this.getType()==TYPE.STRING && newCurrentValue.compareTo("\"\"")==0){
				newCurrentValue="";
			}
			String oldValue=this.getCurrentValue();
			_currentRef.setValue(newCurrentValue);
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.SETTING__CURRENT_VALUE, oldValue, newCurrentValue));
		
		}
		getHierarchy();
	}

	private Ref getMatchingRef(EList<Ref> listOfRefs, String ref){
		for(Ref refMatch:listOfRefs){
			if(refMatch.getName().compareTo(ref)==0)
				return refMatch;
		}
		return null;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getTopValue() {
		String topValue=getDefaultValue();
		Configuration conf = this.getCurrentConf();
		PrioritisedConfigurationList prioritisedConfigurationList = PrioritisedConfigurationList.getPrioritisedConfigurationList();
		List<Configuration> listOfConfs = prioritisedConfigurationList.getPrioritisedConfigurations((RootConf)conf);
		for (Configuration configuration : listOfConfs) {
			if(confRefMap.containsKey(configuration))
				topValue = getConfValue(configuration);//confRefMap.get(configuration).getValue();
		}
		
		return topValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Configuration getCurrentConf() {
		if(currentConf==null){
			RootConf conf=(RootConf)this.getDefaultConf();
			while(conf!=null&&conf.getRoot()!=null)
				conf=conf.getRoot();
			currentConf = conf;
		}
		return currentConf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Configuration basicGetCurrentConf() {
		return currentConf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract Configuration getDefaultConf();
	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Configuration basicGetDefaultConf() {
		return defaultConf;
	}

	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract boolean isRo();
/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<String> getPossibleValue() {
		EList<String> result = new BasicEList<String>();
		for(Iterator<Option>iOption=this.getOption().iterator();iOption.hasNext();){
			Option op=iOption.next();
			result.add(op.getName());
		}
		for(Iterator<Option>iOption=this.getBoolOptions().iterator();iOption.hasNext();){
			Option op=iOption.next();
			result.add(op.getName());
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getCurrentType() {
		return this.getType().getLiteral();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setCurrentType(String newCurrentType) {
		this.setType(TYPE.get(newCurrentType));
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isValueChangeble() {
		return !isRo()||!isReadOnly();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isRfs() {
		RootConf conf = (RootConf)getDefaultConf();
		boolean rfs = false;
		while(conf!=null){
			Ref rfsRef = getRfsRef(conf);
			if(rfsRef!=null)
				rfs=Boolean.parseBoolean(rfsRef.getValue());
			conf=conf.getRoot();
		}
		return rfs;
	}
	private Map<RootConf, Ref> rfsHierarchy=null;
	private Ref getRfsRef(RootConf conf){
		if(rfsHierarchy==null){
			rfsHierarchy=new HashMap<RootConf, Ref>();
			for(Iterator<Ref> iRef=getRfsRefs().iterator();iRef.hasNext();){
				Ref ref = iRef.next();
				rfsHierarchy.put((RootConf)ref.getConfiguration(),ref);
			}
		}
		return rfsHierarchy.get(conf);
	}
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setRfs(boolean newRfs) {
		setConfRfs(newRfs, (RootConf)getCurrentConf());
	}

	//	{
//		EObject parent = this.eContainer();
//		if(Feature.class.isInstance(parent))return ((Feature)parent).isReadOnly();
//		else if(Setting.class.isInstance(parent))return ((Setting)parent).isRo();
//		else if(View.class.isInstance(parent))return ((View)parent).isReadOnly();
//		return false;
//	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getConfValue(Configuration configuration) {
		Map<Configuration, Ref> confRefMap=getHierarchy();
		if(confRefMap.size()==0) return null;
		Ref ref=confRefMap.get(configuration);
		String value = ref!=null?ref.getValue():null; 
		if(value!=null && value.equals("") && this.getType()!=TYPE.STRING)
			value=null;
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getUserValue(String systemValue) {
		for(Iterator<Option>iOption=this.getOption().iterator();iOption.hasNext();){
			Option op = iOption.next();
			if(op.getValue()!=null&&op.getValue().equals(systemValue))return op.getName();
		}
		for(Iterator<Option>iOption=this.getBoolOptions().iterator();iOption.hasNext();){
			Option op = iOption.next();
			if(op.getValue()!=null&&op.getValue().equals(systemValue))return op.getName();
		}
		return systemValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSystemValue(String userValue) {
		for(Iterator<Option>iOption=this.getOption().iterator();iOption.hasNext();){
			Option op = iOption.next();
			if(op.getName()!=null&&op.getName().equals(userValue))return op.getValue();
		}
		for(Iterator<Option>iOption=this.getBoolOptions().iterator();iOption.hasNext();){
			Option op = iOption.next();
			if(op.getName()!=null&&op.getName().equals(userValue))return op.getValue();
		}
		return userValue;
	}

	protected Ref createRef(Ref parentRef, List<Ref> refs){
		Ref ref = ConfigurationemfFactory.eINSTANCE.createRef();
		ref.setName(getRef());
		parentRef.getRef().add(ref);
		refs.add(ref);
		return ref;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setConfRfs(boolean newRfs, RootConf rootConf) {
		Ref theRef = getRfsRef(rootConf);
		if(theRef==null){
			theRef=ConfigurationemfFactory.eINSTANCE.createRef();
			theRef.setName(this.getRef());
			EObject parent = this.eContainer();
			Ref theParentRef = null;
			while(!RootConf.class.isInstance(parent)){
				if(Referable.class.isInstance(parent)){
					Referable referable = (Referable)parent;
					for(Ref ref :referable.getRfsRefs()){
						if(ref.getConfiguration().equals(rootConf)){
							theParentRef=ref;
							break;
						}
					}
					if(theParentRef==null){
						theParentRef=ConfigurationemfFactory.eINSTANCE.createRef();
						theParentRef.setName(referable.getRef());
						referable.getRfsRefs().add(theParentRef);
					}
					theParentRef.getRef().add(theRef);
					
				}
				parent=parent.eContainer();
			}
			Rfs rfs = rootConf.getRfs();
			if(rfs==null){
				rfs=ConfigurationemfFactory.eINSTANCE.createRfs();
				rootConf.setRfs(rfs);
			}
			rfs.getRef().add(theParentRef);
			this.getRfsRefs().add(theRef);
			rfsHierarchy.put(rootConf, theRef);
		}
		theRef.setValue(String.valueOf(newRfs));
	}

	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object getGValue() {
		return getTopValue();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public RootConf getGConf() {
		PrioritisedConfigurationList prioritisedConfigurationList = PrioritisedConfigurationList.getPrioritisedConfigurationList();
		List<Configuration> listOfConfs = prioritisedConfigurationList.getPrioritisedConfigurations((RootConf)getCurrentConf());
		for (int i=listOfConfs.size()-1;i>=0;i--) {
			Configuration configuration = listOfConfs.get(i);
			String value1=getConfValue(configuration);
			if(value1!=null/*&&value1.length()!=0*/)
				return (RootConf)configuration;
		}
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigurationemfPackage.SETTING__OPTION:
				return ((InternalEList<?>)getOption()).basicRemove(otherEnd, msgs);
			case ConfigurationemfPackage.SETTING__PROPERTY:
				return basicSetProperty(null, msgs);
			case ConfigurationemfPackage.SETTING__MIN_LENGTH:
				return basicSetMinLength(null, msgs);
			case ConfigurationemfPackage.SETTING__MAX_LENGTH:
				return basicSetMaxLength(null, msgs);
			case ConfigurationemfPackage.SETTING__LENGTH:
				return basicSetLength(null, msgs);
			case ConfigurationemfPackage.SETTING__MAX_INCLUSIVE:
				return basicSetMaxInclusive(null, msgs);
			case ConfigurationemfPackage.SETTING__MAX_EXCLUSIVE:
				return basicSetMaxExclusive(null, msgs);
			case ConfigurationemfPackage.SETTING__MIN_EXCLUSIVE:
				return basicSetMinExclusive(null, msgs);
			case ConfigurationemfPackage.SETTING__PATTERN:
				return basicSetPattern(null, msgs);
			case ConfigurationemfPackage.SETTING__MIN_INCLUSIVE:
				return basicSetMinInclusive(null, msgs);
			case ConfigurationemfPackage.SETTING__TOTAL_DIGITS:
				return basicSetTotalDigits(null, msgs);
			case ConfigurationemfPackage.SETTING__LINK:
				return ((InternalEList<?>)getLink()).basicRemove(otherEnd, msgs);
			case ConfigurationemfPackage.SETTING__ICON:
				return ((InternalEList<?>)getIcon()).basicRemove(otherEnd, msgs);
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
			case ConfigurationemfPackage.SETTING__NAME:
				return getName();
			case ConfigurationemfPackage.SETTING__TYPE:
				return getType();
			case ConfigurationemfPackage.SETTING__CONSTRAINT:
				return getConstraint();
			case ConfigurationemfPackage.SETTING__RELEVANT:
				return getRelevant();
			case ConfigurationemfPackage.SETTING__READ_ONLY:
				return isReadOnly() ? Boolean.TRUE : Boolean.FALSE;
			case ConfigurationemfPackage.SETTING__REQUIRED:
				return getRequired();
			case ConfigurationemfPackage.SETTING__OPTION:
				return getOption();
			case ConfigurationemfPackage.SETTING__PROPERTY:
				return getProperty();
			case ConfigurationemfPackage.SETTING__MIN_LENGTH:
				return getMinLength();
			case ConfigurationemfPackage.SETTING__MAX_LENGTH:
				return getMaxLength();
			case ConfigurationemfPackage.SETTING__LENGTH:
				return getLength();
			case ConfigurationemfPackage.SETTING__MAX_INCLUSIVE:
				return getMaxInclusive();
			case ConfigurationemfPackage.SETTING__MAX_EXCLUSIVE:
				return getMaxExclusive();
			case ConfigurationemfPackage.SETTING__MIN_EXCLUSIVE:
				return getMinExclusive();
			case ConfigurationemfPackage.SETTING__PATTERN:
				return getPattern();
			case ConfigurationemfPackage.SETTING__MIN_INCLUSIVE:
				return getMinInclusive();
			case ConfigurationemfPackage.SETTING__TOTAL_DIGITS:
				return getTotalDigits();
			case ConfigurationemfPackage.SETTING__LINK:
				return getLink();
			case ConfigurationemfPackage.SETTING__ICON:
				return getIcon();
			case ConfigurationemfPackage.SETTING__BOOL_OPTIONS:
				return getBoolOptions();
			case ConfigurationemfPackage.SETTING__DEFAULT_VALUE:
				return getDefaultValue();
			case ConfigurationemfPackage.SETTING__CURRENT_VALUE:
				return getCurrentValue();
			case ConfigurationemfPackage.SETTING__TOP_VALUE:
				return getTopValue();
			case ConfigurationemfPackage.SETTING__CURRENT_CONF:
				if (resolve) return getCurrentConf();
				return basicGetCurrentConf();
			case ConfigurationemfPackage.SETTING__DEFAULT_CONF:
				if (resolve) return getDefaultConf();
				return basicGetDefaultConf();
			case ConfigurationemfPackage.SETTING__RO:
				return isRo() ? Boolean.TRUE : Boolean.FALSE;
			case ConfigurationemfPackage.SETTING__POSSIBLE_VALUE:
				return getPossibleValue();
			case ConfigurationemfPackage.SETTING__CURRENT_TYPE:
				return getCurrentType();
			case ConfigurationemfPackage.SETTING__VALUE_CHANGEBLE:
				return isValueChangeble() ? Boolean.TRUE : Boolean.FALSE;
			case ConfigurationemfPackage.SETTING__RFS:
				return isRfs() ? Boolean.TRUE : Boolean.FALSE;
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
			case ConfigurationemfPackage.SETTING__NAME:
				setName((String)newValue);
				return;
			case ConfigurationemfPackage.SETTING__TYPE:
				setType((TYPE)newValue);
				return;
			case ConfigurationemfPackage.SETTING__CONSTRAINT:
				setConstraint((String)newValue);
				return;
			case ConfigurationemfPackage.SETTING__RELEVANT:
				setRelevant((String)newValue);
				return;
			case ConfigurationemfPackage.SETTING__READ_ONLY:
				setReadOnly(((Boolean)newValue).booleanValue());
				return;
			case ConfigurationemfPackage.SETTING__REQUIRED:
				setRequired((String)newValue);
				return;
			case ConfigurationemfPackage.SETTING__OPTION:
				getOption().clear();
				getOption().addAll((Collection<? extends Option>)newValue);
				return;
			case ConfigurationemfPackage.SETTING__PROPERTY:
				setProperty((Property)newValue);
				return;
			case ConfigurationemfPackage.SETTING__MIN_LENGTH:
				setMinLength((MinLength)newValue);
				return;
			case ConfigurationemfPackage.SETTING__MAX_LENGTH:
				setMaxLength((MaxLength)newValue);
				return;
			case ConfigurationemfPackage.SETTING__LENGTH:
				setLength((Length)newValue);
				return;
			case ConfigurationemfPackage.SETTING__MAX_INCLUSIVE:
				setMaxInclusive((MaxInclusive)newValue);
				return;
			case ConfigurationemfPackage.SETTING__MAX_EXCLUSIVE:
				setMaxExclusive((MaxExclusive)newValue);
				return;
			case ConfigurationemfPackage.SETTING__MIN_EXCLUSIVE:
				setMinExclusive((MinExclusive)newValue);
				return;
			case ConfigurationemfPackage.SETTING__PATTERN:
				setPattern((Pattern)newValue);
				return;
			case ConfigurationemfPackage.SETTING__MIN_INCLUSIVE:
				setMinInclusive((MinInclusive)newValue);
				return;
			case ConfigurationemfPackage.SETTING__TOTAL_DIGITS:
				setTotalDigits((TotalDigits)newValue);
				return;
			case ConfigurationemfPackage.SETTING__LINK:
				getLink().clear();
				getLink().addAll((Collection<? extends Link>)newValue);
				return;
			case ConfigurationemfPackage.SETTING__ICON:
				getIcon().clear();
				getIcon().addAll((Collection<? extends Icon>)newValue);
				return;
			case ConfigurationemfPackage.SETTING__CURRENT_VALUE:
				setCurrentValue((String)newValue);
				return;
			case ConfigurationemfPackage.SETTING__CURRENT_TYPE:
				setCurrentType((String)newValue);
				return;
			case ConfigurationemfPackage.SETTING__RFS:
				setRfs(((Boolean)newValue).booleanValue());
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
			case ConfigurationemfPackage.SETTING__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ConfigurationemfPackage.SETTING__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ConfigurationemfPackage.SETTING__CONSTRAINT:
				setConstraint(CONSTRAINT_EDEFAULT);
				return;
			case ConfigurationemfPackage.SETTING__RELEVANT:
				setRelevant(RELEVANT_EDEFAULT);
				return;
			case ConfigurationemfPackage.SETTING__READ_ONLY:
				setReadOnly(READ_ONLY_EDEFAULT);
				return;
			case ConfigurationemfPackage.SETTING__REQUIRED:
				setRequired(REQUIRED_EDEFAULT);
				return;
			case ConfigurationemfPackage.SETTING__OPTION:
				getOption().clear();
				return;
			case ConfigurationemfPackage.SETTING__PROPERTY:
				setProperty((Property)null);
				return;
			case ConfigurationemfPackage.SETTING__MIN_LENGTH:
				setMinLength((MinLength)null);
				return;
			case ConfigurationemfPackage.SETTING__MAX_LENGTH:
				setMaxLength((MaxLength)null);
				return;
			case ConfigurationemfPackage.SETTING__LENGTH:
				setLength((Length)null);
				return;
			case ConfigurationemfPackage.SETTING__MAX_INCLUSIVE:
				setMaxInclusive((MaxInclusive)null);
				return;
			case ConfigurationemfPackage.SETTING__MAX_EXCLUSIVE:
				setMaxExclusive((MaxExclusive)null);
				return;
			case ConfigurationemfPackage.SETTING__MIN_EXCLUSIVE:
				setMinExclusive((MinExclusive)null);
				return;
			case ConfigurationemfPackage.SETTING__PATTERN:
				setPattern((Pattern)null);
				return;
			case ConfigurationemfPackage.SETTING__MIN_INCLUSIVE:
				setMinInclusive((MinInclusive)null);
				return;
			case ConfigurationemfPackage.SETTING__TOTAL_DIGITS:
				setTotalDigits((TotalDigits)null);
				return;
			case ConfigurationemfPackage.SETTING__LINK:
				getLink().clear();
				return;
			case ConfigurationemfPackage.SETTING__ICON:
				getIcon().clear();
				return;
			case ConfigurationemfPackage.SETTING__CURRENT_VALUE:
				setCurrentValue(CURRENT_VALUE_EDEFAULT);
				return;
			case ConfigurationemfPackage.SETTING__CURRENT_TYPE:
				setCurrentType(CURRENT_TYPE_EDEFAULT);
				return;
			case ConfigurationemfPackage.SETTING__RFS:
				setRfs(RFS_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ConfigurationemfPackage.SETTING__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ConfigurationemfPackage.SETTING__TYPE:
				return true ;//type != TYPE_EDEFAULT;
			case ConfigurationemfPackage.SETTING__CONSTRAINT:
				return CONSTRAINT_EDEFAULT == null ? constraint != null : !CONSTRAINT_EDEFAULT.equals(constraint);
			case ConfigurationemfPackage.SETTING__RELEVANT:
				return RELEVANT_EDEFAULT == null ? relevant != null : !RELEVANT_EDEFAULT.equals(relevant);
			case ConfigurationemfPackage.SETTING__READ_ONLY:
				return readOnly != READ_ONLY_EDEFAULT;
			case ConfigurationemfPackage.SETTING__REQUIRED:
				return REQUIRED_EDEFAULT == null ? required != null : !REQUIRED_EDEFAULT.equals(required);
			case ConfigurationemfPackage.SETTING__OPTION:
				return option != null && !option.isEmpty();
			case ConfigurationemfPackage.SETTING__PROPERTY:
				return property != null;
			case ConfigurationemfPackage.SETTING__MIN_LENGTH:
				return minLength != null;
			case ConfigurationemfPackage.SETTING__MAX_LENGTH:
				return maxLength != null;
			case ConfigurationemfPackage.SETTING__LENGTH:
				return length != null;
			case ConfigurationemfPackage.SETTING__MAX_INCLUSIVE:
				return maxInclusive != null;
			case ConfigurationemfPackage.SETTING__MAX_EXCLUSIVE:
				return maxExclusive != null;
			case ConfigurationemfPackage.SETTING__MIN_EXCLUSIVE:
				return minExclusive != null;
			case ConfigurationemfPackage.SETTING__PATTERN:
				return pattern != null;
			case ConfigurationemfPackage.SETTING__MIN_INCLUSIVE:
				return minInclusive != null;
			case ConfigurationemfPackage.SETTING__TOTAL_DIGITS:
				return totalDigits != null;
			case ConfigurationemfPackage.SETTING__LINK:
				return link != null && !link.isEmpty();
			case ConfigurationemfPackage.SETTING__ICON:
				return icon != null && !icon.isEmpty();
			case ConfigurationemfPackage.SETTING__BOOL_OPTIONS:
				return !getBoolOptions().isEmpty();
			case ConfigurationemfPackage.SETTING__DEFAULT_VALUE:
				return DEFAULT_VALUE_EDEFAULT == null ? getDefaultValue() != null : !DEFAULT_VALUE_EDEFAULT.equals(getDefaultValue());
			case ConfigurationemfPackage.SETTING__CURRENT_VALUE:
				return CURRENT_VALUE_EDEFAULT == null ? getCurrentValue() != null : !CURRENT_VALUE_EDEFAULT.equals(getCurrentValue());
			case ConfigurationemfPackage.SETTING__TOP_VALUE:
				return TOP_VALUE_EDEFAULT == null ? getTopValue() != null : !TOP_VALUE_EDEFAULT.equals(getTopValue());
			case ConfigurationemfPackage.SETTING__CURRENT_CONF:
				return currentConf != null;
			case ConfigurationemfPackage.SETTING__DEFAULT_CONF:
				return defaultConf != null;
			case ConfigurationemfPackage.SETTING__RO:
				return isRo() != RO_EDEFAULT;
			case ConfigurationemfPackage.SETTING__POSSIBLE_VALUE:
				return getPossibleValue() != null;
			case ConfigurationemfPackage.SETTING__CURRENT_TYPE:
				return CURRENT_TYPE_EDEFAULT == null ? getCurrentType() != null : !CURRENT_TYPE_EDEFAULT.equals(getCurrentType());
			case ConfigurationemfPackage.SETTING__VALUE_CHANGEBLE:
				return isValueChangeble() != VALUE_CHANGEBLE_EDEFAULT;
			case ConfigurationemfPackage.SETTING__RFS:
				return isRfs() != RFS_EDEFAULT;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", type: ");
		result.append(type);
		result.append(", constraint: ");
		result.append(constraint);
		result.append(", relevant: ");
		result.append(relevant);
		result.append(", readOnly: ");
		result.append(readOnly);
		result.append(", required: ");
		result.append(required);
		result.append(')');
		return result.toString();
	}

	public Map<Configuration, Ref> getHierarchy(){
		confRefMap.clear();
		if(confRefMap.size()==0){
			for(Iterator itrRef=this.getRefs().iterator(); itrRef.hasNext();){
				Ref ref=(Ref)itrRef.next();
				confRefMap.put(ref.getConfiguration(), ref);
			}
		}
		return confRefMap;
	}
	
	private Ref getChildRef(Configuration conf, Ref parentRef){
		for(Iterator itrRef=parentRef.getRef().iterator(); itrRef.hasNext();){
			Ref ref=(Ref)itrRef.next(); 
			if(ref.getConfiguration()== conf)
				return ref;
		}
		
		return null;
	}
	
	public void addSetting(Setting setting){
		Map<Configuration, Ref> confRefs=getHierarchy();
		Set<Configuration> allConfs= confRefs.keySet();
		for(Iterator<Configuration> itrConfig=allConfs.iterator();itrConfig.hasNext();){
			Configuration conf=itrConfig.next();
			Ref ref=confRefs.get(conf);
			String value=ref.getValue();
			ref.eAdapters().clear();
			this.getRefs().remove(ref);
			this.setConfValue(value, conf);
			
			confRefs.remove(conf);
		}
		getHierarchy();
	}
	public void removeSetting(Setting setting){
		for(Ref sRef : setting.getRefs()){
			Ref fRef = (Ref)sRef.eContainer();
			fRef.getRef().remove(sRef);
			this.getRefs().remove(sRef);
			if(fRef.getRef().isEmpty()){
				Data data = (Data)fRef.eContainer();
				data.getRef().remove(fRef);
				if(data.getRef().isEmpty())
					((RootConf)data.eContainer()).setData(null);
			}
			
		}
	}

	private void removeEmptyRef(Ref sRef){
		if(ref==null)return;
		Ref fRef = (Ref)sRef.eContainer();
		fRef.getRef().remove(sRef);
		this.getRefs().remove(sRef);
		sRef=null;
	}
	//Adapter
	
	Adapter selfAdapter = new AdapterImpl(){
		public void notifyChanged(Notification notification) {
			SettingImpl.this.notifyChanged(notification);
		}
	};
	
	protected void notifyChanged(Notification notification) {
		Object notifier = notification.getNotifier();
		Setting currentSetting=(Setting)notification.getNotifier();
		if(notifier instanceof ParentSetting){
			switch (notification.getFeatureID(ParentSetting.class)) {
			 case ConfigurationemfPackage.SETTING__REF:
				 String newRef=(String)notification.getNewValue();
				 updateRefs(newRef);
				 break;
			 case ConfigurationemfPackage.PARENT_SETTING__LEAF_SETTING:
				 Setting addSetting = (Setting)notification.getNewValue();
				 Setting removeSetting = (Setting)notification.getOldValue();
				 switch(notification.getEventType()){
					case(Notification.ADD):
						currentSetting.addSetting(addSetting);							
						break;
					case(Notification.REMOVE):
						currentSetting.removeSetting(removeSetting);
						break;
				 }
				 break;
			}
		}
	}
	
	private void updateRefs(String newRef){
		for(Ref  ref : this.getRefs())
			 ref.setName(newRef);
		for(Ref ref : this.getRfsRefs())
			ref.setName(newRef);
	}
	
} //SettingImpl