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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.nokia.tools.vct.common.appmodel.EAppExpression;
import com.nokia.tools.vct.common.appmodel.EAppSettingOption;
import com.nokia.tools.vct.common.appmodel.EApplicationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EApp Setting Option</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSettingOptionImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSettingOptionImpl#getLiteralValue <em>Literal Value</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSettingOptionImpl#getRelevant <em>Relevant</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSettingOptionImpl#getRefValue <em>Ref Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EAppSettingOptionImpl extends EObjectImpl implements EAppSettingOption {
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
	 * The default value of the '{@link #getLiteralValue() <em>Literal Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLiteralValue()
	 * @generated
	 * @ordered
	 */
	protected static final String LITERAL_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLiteralValue() <em>Literal Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLiteralValue()
	 * @generated
	 * @ordered
	 */
	protected String literalValue = LITERAL_VALUE_EDEFAULT;

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
	 * The default value of the '{@link #getRefValue() <em>Ref Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefValue()
	 * @generated
	 * @ordered
	 */
	protected static final String REF_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRefValue() <em>Ref Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefValue()
	 * @generated
	 * @ordered
	 */
	protected String refValue = REF_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EAppSettingOptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EApplicationPackage.Literals.EAPP_SETTING_OPTION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SETTING_OPTION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteralValue() {
		return literalValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLiteralValue(String newLiteralValue) {
		String oldLiteralValue = literalValue;
		literalValue = newLiteralValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SETTING_OPTION__LITERAL_VALUE, oldLiteralValue, literalValue));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SETTING_OPTION__RELEVANT, oldRelevant, newRelevant);
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
				msgs = ((InternalEObject)relevant).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EApplicationPackage.EAPP_SETTING_OPTION__RELEVANT, null, msgs);
			if (newRelevant != null)
				msgs = ((InternalEObject)newRelevant).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EApplicationPackage.EAPP_SETTING_OPTION__RELEVANT, null, msgs);
			msgs = basicSetRelevant(newRelevant, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SETTING_OPTION__RELEVANT, newRelevant, newRelevant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRefValue() {
		return refValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefValue(String newRefValue) {
		String oldRefValue = refValue;
		refValue = newRefValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SETTING_OPTION__REF_VALUE, oldRefValue, refValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EApplicationPackage.EAPP_SETTING_OPTION__RELEVANT:
				return basicSetRelevant(null, msgs);
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
			case EApplicationPackage.EAPP_SETTING_OPTION__NAME:
				return getName();
			case EApplicationPackage.EAPP_SETTING_OPTION__LITERAL_VALUE:
				return getLiteralValue();
			case EApplicationPackage.EAPP_SETTING_OPTION__RELEVANT:
				return getRelevant();
			case EApplicationPackage.EAPP_SETTING_OPTION__REF_VALUE:
				return getRefValue();
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
			case EApplicationPackage.EAPP_SETTING_OPTION__NAME:
				setName((String)newValue);
				return;
			case EApplicationPackage.EAPP_SETTING_OPTION__LITERAL_VALUE:
				setLiteralValue((String)newValue);
				return;
			case EApplicationPackage.EAPP_SETTING_OPTION__RELEVANT:
				setRelevant((EAppExpression)newValue);
				return;
			case EApplicationPackage.EAPP_SETTING_OPTION__REF_VALUE:
				setRefValue((String)newValue);
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
			case EApplicationPackage.EAPP_SETTING_OPTION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EApplicationPackage.EAPP_SETTING_OPTION__LITERAL_VALUE:
				setLiteralValue(LITERAL_VALUE_EDEFAULT);
				return;
			case EApplicationPackage.EAPP_SETTING_OPTION__RELEVANT:
				setRelevant((EAppExpression)null);
				return;
			case EApplicationPackage.EAPP_SETTING_OPTION__REF_VALUE:
				setRefValue(REF_VALUE_EDEFAULT);
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
			case EApplicationPackage.EAPP_SETTING_OPTION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EApplicationPackage.EAPP_SETTING_OPTION__LITERAL_VALUE:
				return LITERAL_VALUE_EDEFAULT == null ? literalValue != null : !LITERAL_VALUE_EDEFAULT.equals(literalValue);
			case EApplicationPackage.EAPP_SETTING_OPTION__RELEVANT:
				return relevant != null;
			case EApplicationPackage.EAPP_SETTING_OPTION__REF_VALUE:
				return REF_VALUE_EDEFAULT == null ? refValue != null : !REF_VALUE_EDEFAULT.equals(refValue);
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
		result.append(", literalValue: ");
		result.append(literalValue);
		result.append(", refValue: ");
		result.append(refValue);
		result.append(')');
		return result.toString();
	}

} //EAppSettingOptionImpl
