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
 * Description: This file is part of com.nokia.tools.vct.confml.editor.view component.
 */

package com.nokia.tools.vct.confml.editor.view.vemodel.impl;

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

import com.nokia.tools.vct.confml.editor.view.vemodel.ERefOption;
import com.nokia.tools.vct.confml.editor.view.vemodel.ERefProperty;
import com.nokia.tools.vct.confml.editor.view.vemodel.ERefTarget;
import com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef;
import com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ESetting Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.ESettingRefImpl#getDescriptionText <em>Description Text</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.ESettingRefImpl#getDescriptionUri <em>Description Uri</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.ESettingRefImpl#getDescriptionUriTitle <em>Description Uri Title</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.ESettingRefImpl#getFeatureId <em>Feature Id</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.ESettingRefImpl#getSettingId <em>Setting Id</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.ESettingRefImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.ESettingRefImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.ESettingRefImpl#getMinInclusive <em>Min Inclusive</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.ESettingRefImpl#getMaxInclusive <em>Max Inclusive</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.ESettingRefImpl#getMinExclusive <em>Min Exclusive</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.ESettingRefImpl#getMaxExclusive <em>Max Exclusive</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.ESettingRefImpl#getLength <em>Length</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.ESettingRefImpl#getMaxLength <em>Max Length</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.ESettingRefImpl#getMinLength <em>Min Length</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.ESettingRefImpl#getPatterns <em>Patterns</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.ESettingRefImpl#getOptions <em>Options</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.ESettingRefImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ESettingRefImpl extends EObjectImpl implements ESettingRef {
	/**
	 * The default value of the '{@link #getDescriptionText() <em>Description Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptionText()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescriptionText() <em>Description Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptionText()
	 * @generated
	 * @ordered
	 */
	protected String descriptionText = DESCRIPTION_TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescriptionUri() <em>Description Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptionUri()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescriptionUri() <em>Description Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptionUri()
	 * @generated
	 * @ordered
	 */
	protected String descriptionUri = DESCRIPTION_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescriptionUriTitle() <em>Description Uri Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptionUriTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_URI_TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescriptionUriTitle() <em>Description Uri Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptionUriTitle()
	 * @generated
	 * @ordered
	 */
	protected String descriptionUriTitle = DESCRIPTION_URI_TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFeatureId() <em>Feature Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureId()
	 * @generated
	 * @ordered
	 */
	protected static final String FEATURE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFeatureId() <em>Feature Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureId()
	 * @generated
	 * @ordered
	 */
	protected String featureId = FEATURE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getSettingId() <em>Setting Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSettingId()
	 * @generated
	 * @ordered
	 */
	protected static final String SETTING_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSettingId() <em>Setting Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSettingId()
	 * @generated
	 * @ordered
	 */
	protected String settingId = SETTING_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected ERefTarget target;

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
	 * The default value of the '{@link #getLength() <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
	protected static final String LENGTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLength() <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
	protected String length = LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxLength() <em>Max Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxLength()
	 * @generated
	 * @ordered
	 */
	protected static final String MAX_LENGTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxLength() <em>Max Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxLength()
	 * @generated
	 * @ordered
	 */
	protected String maxLength = MAX_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinLength() <em>Min Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinLength()
	 * @generated
	 * @ordered
	 */
	protected static final String MIN_LENGTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinLength() <em>Min Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinLength()
	 * @generated
	 * @ordered
	 */
	protected String minLength = MIN_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getPatterns() <em>Patterns</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPatterns()
	 * @generated
	 * @ordered
	 */
	protected static final String PATTERNS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPatterns() <em>Patterns</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPatterns()
	 * @generated
	 * @ordered
	 */
	protected String patterns = PATTERNS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOptions() <em>Options</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptions()
	 * @generated
	 * @ordered
	 */
	protected EList<ERefOption> options;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<ERefProperty> properties;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ESettingRefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EViewEditorPackage.Literals.ESETTING_REF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescriptionText() {
		return descriptionText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescriptionText(String newDescriptionText) {
		String oldDescriptionText = descriptionText;
		descriptionText = newDescriptionText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EViewEditorPackage.ESETTING_REF__DESCRIPTION_TEXT, oldDescriptionText, descriptionText));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescriptionUri() {
		return descriptionUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescriptionUri(String newDescriptionUri) {
		String oldDescriptionUri = descriptionUri;
		descriptionUri = newDescriptionUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EViewEditorPackage.ESETTING_REF__DESCRIPTION_URI, oldDescriptionUri, descriptionUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescriptionUriTitle() {
		return descriptionUriTitle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescriptionUriTitle(String newDescriptionUriTitle) {
		String oldDescriptionUriTitle = descriptionUriTitle;
		descriptionUriTitle = newDescriptionUriTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EViewEditorPackage.ESETTING_REF__DESCRIPTION_URI_TITLE, oldDescriptionUriTitle, descriptionUriTitle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFeatureId() {
		return featureId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureId(String newFeatureId) {
		String oldFeatureId = featureId;
		featureId = newFeatureId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EViewEditorPackage.ESETTING_REF__FEATURE_ID, oldFeatureId, featureId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSettingId() {
		return settingId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSettingId(String newSettingId) {
		String oldSettingId = settingId;
		settingId = newSettingId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EViewEditorPackage.ESETTING_REF__SETTING_ID, oldSettingId, settingId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ERefTarget getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (ERefTarget)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EViewEditorPackage.ESETTING_REF__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ERefTarget basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(ERefTarget newTarget, NotificationChain msgs) {
		ERefTarget oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EViewEditorPackage.ESETTING_REF__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(ERefTarget newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, EViewEditorPackage.EREF_TARGET__REFS, ERefTarget.class, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, EViewEditorPackage.EREF_TARGET__REFS, ERefTarget.class, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EViewEditorPackage.ESETTING_REF__TARGET, newTarget, newTarget));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EViewEditorPackage.ESETTING_REF__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EViewEditorPackage.ESETTING_REF__MIN_INCLUSIVE, oldMinInclusive, minInclusive));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EViewEditorPackage.ESETTING_REF__MAX_INCLUSIVE, oldMaxInclusive, maxInclusive));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EViewEditorPackage.ESETTING_REF__MIN_EXCLUSIVE, oldMinExclusive, minExclusive));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EViewEditorPackage.ESETTING_REF__MAX_EXCLUSIVE, oldMaxExclusive, maxExclusive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLength() {
		return length;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLength(String newLength) {
		String oldLength = length;
		length = newLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EViewEditorPackage.ESETTING_REF__LENGTH, oldLength, length));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaxLength() {
		return maxLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxLength(String newMaxLength) {
		String oldMaxLength = maxLength;
		maxLength = newMaxLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EViewEditorPackage.ESETTING_REF__MAX_LENGTH, oldMaxLength, maxLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMinLength() {
		return minLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinLength(String newMinLength) {
		String oldMinLength = minLength;
		minLength = newMinLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EViewEditorPackage.ESETTING_REF__MIN_LENGTH, oldMinLength, minLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPatterns() {
		return patterns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPatterns(String newPatterns) {
		String oldPatterns = patterns;
		patterns = newPatterns;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EViewEditorPackage.ESETTING_REF__PATTERNS, oldPatterns, patterns));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ERefOption> getOptions() {
		if (options == null) {
			options = new EObjectContainmentEList<ERefOption>(ERefOption.class, this, EViewEditorPackage.ESETTING_REF__OPTIONS);
		}
		return options;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ERefProperty> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList<ERefProperty>(ERefProperty.class, this, EViewEditorPackage.ESETTING_REF__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EViewEditorPackage.ESETTING_REF__TARGET:
				if (target != null)
					msgs = ((InternalEObject)target).eInverseRemove(this, EViewEditorPackage.EREF_TARGET__REFS, ERefTarget.class, msgs);
				return basicSetTarget((ERefTarget)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EViewEditorPackage.ESETTING_REF__TARGET:
				return basicSetTarget(null, msgs);
			case EViewEditorPackage.ESETTING_REF__OPTIONS:
				return ((InternalEList<?>)getOptions()).basicRemove(otherEnd, msgs);
			case EViewEditorPackage.ESETTING_REF__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
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
			case EViewEditorPackage.ESETTING_REF__DESCRIPTION_TEXT:
				return getDescriptionText();
			case EViewEditorPackage.ESETTING_REF__DESCRIPTION_URI:
				return getDescriptionUri();
			case EViewEditorPackage.ESETTING_REF__DESCRIPTION_URI_TITLE:
				return getDescriptionUriTitle();
			case EViewEditorPackage.ESETTING_REF__FEATURE_ID:
				return getFeatureId();
			case EViewEditorPackage.ESETTING_REF__SETTING_ID:
				return getSettingId();
			case EViewEditorPackage.ESETTING_REF__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case EViewEditorPackage.ESETTING_REF__NAME:
				return getName();
			case EViewEditorPackage.ESETTING_REF__MIN_INCLUSIVE:
				return getMinInclusive();
			case EViewEditorPackage.ESETTING_REF__MAX_INCLUSIVE:
				return getMaxInclusive();
			case EViewEditorPackage.ESETTING_REF__MIN_EXCLUSIVE:
				return getMinExclusive();
			case EViewEditorPackage.ESETTING_REF__MAX_EXCLUSIVE:
				return getMaxExclusive();
			case EViewEditorPackage.ESETTING_REF__LENGTH:
				return getLength();
			case EViewEditorPackage.ESETTING_REF__MAX_LENGTH:
				return getMaxLength();
			case EViewEditorPackage.ESETTING_REF__MIN_LENGTH:
				return getMinLength();
			case EViewEditorPackage.ESETTING_REF__PATTERNS:
				return getPatterns();
			case EViewEditorPackage.ESETTING_REF__OPTIONS:
				return getOptions();
			case EViewEditorPackage.ESETTING_REF__PROPERTIES:
				return getProperties();
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
			case EViewEditorPackage.ESETTING_REF__DESCRIPTION_TEXT:
				setDescriptionText((String)newValue);
				return;
			case EViewEditorPackage.ESETTING_REF__DESCRIPTION_URI:
				setDescriptionUri((String)newValue);
				return;
			case EViewEditorPackage.ESETTING_REF__DESCRIPTION_URI_TITLE:
				setDescriptionUriTitle((String)newValue);
				return;
			case EViewEditorPackage.ESETTING_REF__FEATURE_ID:
				setFeatureId((String)newValue);
				return;
			case EViewEditorPackage.ESETTING_REF__SETTING_ID:
				setSettingId((String)newValue);
				return;
			case EViewEditorPackage.ESETTING_REF__TARGET:
				setTarget((ERefTarget)newValue);
				return;
			case EViewEditorPackage.ESETTING_REF__NAME:
				setName((String)newValue);
				return;
			case EViewEditorPackage.ESETTING_REF__MIN_INCLUSIVE:
				setMinInclusive((String)newValue);
				return;
			case EViewEditorPackage.ESETTING_REF__MAX_INCLUSIVE:
				setMaxInclusive((String)newValue);
				return;
			case EViewEditorPackage.ESETTING_REF__MIN_EXCLUSIVE:
				setMinExclusive((String)newValue);
				return;
			case EViewEditorPackage.ESETTING_REF__MAX_EXCLUSIVE:
				setMaxExclusive((String)newValue);
				return;
			case EViewEditorPackage.ESETTING_REF__LENGTH:
				setLength((String)newValue);
				return;
			case EViewEditorPackage.ESETTING_REF__MAX_LENGTH:
				setMaxLength((String)newValue);
				return;
			case EViewEditorPackage.ESETTING_REF__MIN_LENGTH:
				setMinLength((String)newValue);
				return;
			case EViewEditorPackage.ESETTING_REF__PATTERNS:
				setPatterns((String)newValue);
				return;
			case EViewEditorPackage.ESETTING_REF__OPTIONS:
				getOptions().clear();
				getOptions().addAll((Collection<? extends ERefOption>)newValue);
				return;
			case EViewEditorPackage.ESETTING_REF__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends ERefProperty>)newValue);
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
			case EViewEditorPackage.ESETTING_REF__DESCRIPTION_TEXT:
				setDescriptionText(DESCRIPTION_TEXT_EDEFAULT);
				return;
			case EViewEditorPackage.ESETTING_REF__DESCRIPTION_URI:
				setDescriptionUri(DESCRIPTION_URI_EDEFAULT);
				return;
			case EViewEditorPackage.ESETTING_REF__DESCRIPTION_URI_TITLE:
				setDescriptionUriTitle(DESCRIPTION_URI_TITLE_EDEFAULT);
				return;
			case EViewEditorPackage.ESETTING_REF__FEATURE_ID:
				setFeatureId(FEATURE_ID_EDEFAULT);
				return;
			case EViewEditorPackage.ESETTING_REF__SETTING_ID:
				setSettingId(SETTING_ID_EDEFAULT);
				return;
			case EViewEditorPackage.ESETTING_REF__TARGET:
				setTarget((ERefTarget)null);
				return;
			case EViewEditorPackage.ESETTING_REF__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EViewEditorPackage.ESETTING_REF__MIN_INCLUSIVE:
				setMinInclusive(MIN_INCLUSIVE_EDEFAULT);
				return;
			case EViewEditorPackage.ESETTING_REF__MAX_INCLUSIVE:
				setMaxInclusive(MAX_INCLUSIVE_EDEFAULT);
				return;
			case EViewEditorPackage.ESETTING_REF__MIN_EXCLUSIVE:
				setMinExclusive(MIN_EXCLUSIVE_EDEFAULT);
				return;
			case EViewEditorPackage.ESETTING_REF__MAX_EXCLUSIVE:
				setMaxExclusive(MAX_EXCLUSIVE_EDEFAULT);
				return;
			case EViewEditorPackage.ESETTING_REF__LENGTH:
				setLength(LENGTH_EDEFAULT);
				return;
			case EViewEditorPackage.ESETTING_REF__MAX_LENGTH:
				setMaxLength(MAX_LENGTH_EDEFAULT);
				return;
			case EViewEditorPackage.ESETTING_REF__MIN_LENGTH:
				setMinLength(MIN_LENGTH_EDEFAULT);
				return;
			case EViewEditorPackage.ESETTING_REF__PATTERNS:
				setPatterns(PATTERNS_EDEFAULT);
				return;
			case EViewEditorPackage.ESETTING_REF__OPTIONS:
				getOptions().clear();
				return;
			case EViewEditorPackage.ESETTING_REF__PROPERTIES:
				getProperties().clear();
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
			case EViewEditorPackage.ESETTING_REF__DESCRIPTION_TEXT:
				return DESCRIPTION_TEXT_EDEFAULT == null ? descriptionText != null : !DESCRIPTION_TEXT_EDEFAULT.equals(descriptionText);
			case EViewEditorPackage.ESETTING_REF__DESCRIPTION_URI:
				return DESCRIPTION_URI_EDEFAULT == null ? descriptionUri != null : !DESCRIPTION_URI_EDEFAULT.equals(descriptionUri);
			case EViewEditorPackage.ESETTING_REF__DESCRIPTION_URI_TITLE:
				return DESCRIPTION_URI_TITLE_EDEFAULT == null ? descriptionUriTitle != null : !DESCRIPTION_URI_TITLE_EDEFAULT.equals(descriptionUriTitle);
			case EViewEditorPackage.ESETTING_REF__FEATURE_ID:
				return FEATURE_ID_EDEFAULT == null ? featureId != null : !FEATURE_ID_EDEFAULT.equals(featureId);
			case EViewEditorPackage.ESETTING_REF__SETTING_ID:
				return SETTING_ID_EDEFAULT == null ? settingId != null : !SETTING_ID_EDEFAULT.equals(settingId);
			case EViewEditorPackage.ESETTING_REF__TARGET:
				return target != null;
			case EViewEditorPackage.ESETTING_REF__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EViewEditorPackage.ESETTING_REF__MIN_INCLUSIVE:
				return MIN_INCLUSIVE_EDEFAULT == null ? minInclusive != null : !MIN_INCLUSIVE_EDEFAULT.equals(minInclusive);
			case EViewEditorPackage.ESETTING_REF__MAX_INCLUSIVE:
				return MAX_INCLUSIVE_EDEFAULT == null ? maxInclusive != null : !MAX_INCLUSIVE_EDEFAULT.equals(maxInclusive);
			case EViewEditorPackage.ESETTING_REF__MIN_EXCLUSIVE:
				return MIN_EXCLUSIVE_EDEFAULT == null ? minExclusive != null : !MIN_EXCLUSIVE_EDEFAULT.equals(minExclusive);
			case EViewEditorPackage.ESETTING_REF__MAX_EXCLUSIVE:
				return MAX_EXCLUSIVE_EDEFAULT == null ? maxExclusive != null : !MAX_EXCLUSIVE_EDEFAULT.equals(maxExclusive);
			case EViewEditorPackage.ESETTING_REF__LENGTH:
				return LENGTH_EDEFAULT == null ? length != null : !LENGTH_EDEFAULT.equals(length);
			case EViewEditorPackage.ESETTING_REF__MAX_LENGTH:
				return MAX_LENGTH_EDEFAULT == null ? maxLength != null : !MAX_LENGTH_EDEFAULT.equals(maxLength);
			case EViewEditorPackage.ESETTING_REF__MIN_LENGTH:
				return MIN_LENGTH_EDEFAULT == null ? minLength != null : !MIN_LENGTH_EDEFAULT.equals(minLength);
			case EViewEditorPackage.ESETTING_REF__PATTERNS:
				return PATTERNS_EDEFAULT == null ? patterns != null : !PATTERNS_EDEFAULT.equals(patterns);
			case EViewEditorPackage.ESETTING_REF__OPTIONS:
				return options != null && !options.isEmpty();
			case EViewEditorPackage.ESETTING_REF__PROPERTIES:
				return properties != null && !properties.isEmpty();
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
		result.append(" (descriptionText: ");
		result.append(descriptionText);
		result.append(", descriptionUri: ");
		result.append(descriptionUri);
		result.append(", descriptionUriTitle: ");
		result.append(descriptionUriTitle);
		result.append(", featureId: ");
		result.append(featureId);
		result.append(", settingId: ");
		result.append(settingId);
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
		result.append(", length: ");
		result.append(length);
		result.append(", maxLength: ");
		result.append(maxLength);
		result.append(", minLength: ");
		result.append(minLength);
		result.append(", patterns: ");
		result.append(patterns);
		result.append(')');
		return result.toString();
	}

} //ESettingRefImpl
