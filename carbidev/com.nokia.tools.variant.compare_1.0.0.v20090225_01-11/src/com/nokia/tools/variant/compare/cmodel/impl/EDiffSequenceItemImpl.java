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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.nokia.tools.variant.compare.cmodel.ECompareModelPackage;
import com.nokia.tools.variant.compare.cmodel.EDiffSequenceItem;
import com.nokia.tools.variant.compare.cmodel.EDiffSetting;
import com.nokia.tools.variant.compare.cmodel.EDiffSettingContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EDiff Sequence Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.impl.EDiffSequenceItemImpl#isExistsInSource <em>Exists In Source</em>}</li>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.impl.EDiffSequenceItemImpl#isExistsInTarget <em>Exists In Target</em>}</li>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.impl.EDiffSequenceItemImpl#getSourceObject <em>Source Object</em>}</li>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.impl.EDiffSequenceItemImpl#getTargetObject <em>Target Object</em>}</li>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.impl.EDiffSequenceItemImpl#getSettings <em>Settings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EDiffSequenceItemImpl extends EObjectImpl implements EDiffSequenceItem {
	/**
	 * The default value of the '{@link #isExistsInSource() <em>Exists In Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExistsInSource()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXISTS_IN_SOURCE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExistsInSource() <em>Exists In Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExistsInSource()
	 * @generated
	 * @ordered
	 */
	protected boolean existsInSource = EXISTS_IN_SOURCE_EDEFAULT;

	/**
	 * The default value of the '{@link #isExistsInTarget() <em>Exists In Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExistsInTarget()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXISTS_IN_TARGET_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExistsInTarget() <em>Exists In Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExistsInTarget()
	 * @generated
	 * @ordered
	 */
	protected boolean existsInTarget = EXISTS_IN_TARGET_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSourceObject() <em>Source Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceObject()
	 * @generated
	 * @ordered
	 */
	protected EObject sourceObject;

	/**
	 * The cached value of the '{@link #getTargetObject() <em>Target Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetObject()
	 * @generated
	 * @ordered
	 */
	protected EObject targetObject;

	/**
	 * The cached value of the '{@link #getSettings() <em>Settings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSettings()
	 * @generated
	 * @ordered
	 */
	protected EList<EDiffSetting> settings;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EDiffSequenceItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ECompareModelPackage.Literals.EDIFF_SEQUENCE_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExistsInSource() {
		return existsInSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExistsInSource(boolean newExistsInSource) {
		boolean oldExistsInSource = existsInSource;
		existsInSource = newExistsInSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECompareModelPackage.EDIFF_SEQUENCE_ITEM__EXISTS_IN_SOURCE, oldExistsInSource, existsInSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExistsInTarget() {
		return existsInTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExistsInTarget(boolean newExistsInTarget) {
		boolean oldExistsInTarget = existsInTarget;
		existsInTarget = newExistsInTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECompareModelPackage.EDIFF_SEQUENCE_ITEM__EXISTS_IN_TARGET, oldExistsInTarget, existsInTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getSourceObject() {
		if (sourceObject != null && sourceObject.eIsProxy()) {
			InternalEObject oldSourceObject = (InternalEObject)sourceObject;
			sourceObject = eResolveProxy(oldSourceObject);
			if (sourceObject != oldSourceObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ECompareModelPackage.EDIFF_SEQUENCE_ITEM__SOURCE_OBJECT, oldSourceObject, sourceObject));
			}
		}
		return sourceObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetSourceObject() {
		return sourceObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceObject(EObject newSourceObject) {
		EObject oldSourceObject = sourceObject;
		sourceObject = newSourceObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECompareModelPackage.EDIFF_SEQUENCE_ITEM__SOURCE_OBJECT, oldSourceObject, sourceObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getTargetObject() {
		if (targetObject != null && targetObject.eIsProxy()) {
			InternalEObject oldTargetObject = (InternalEObject)targetObject;
			targetObject = eResolveProxy(oldTargetObject);
			if (targetObject != oldTargetObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ECompareModelPackage.EDIFF_SEQUENCE_ITEM__TARGET_OBJECT, oldTargetObject, targetObject));
			}
		}
		return targetObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetTargetObject() {
		return targetObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetObject(EObject newTargetObject) {
		EObject oldTargetObject = targetObject;
		targetObject = newTargetObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECompareModelPackage.EDIFF_SEQUENCE_ITEM__TARGET_OBJECT, oldTargetObject, targetObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EDiffSetting> getSettings() {
		if (settings == null) {
			settings = new EObjectContainmentEList<EDiffSetting>(EDiffSetting.class, this, ECompareModelPackage.EDIFF_SEQUENCE_ITEM__SETTINGS);
		}
		return settings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ECompareModelPackage.EDIFF_SEQUENCE_ITEM__SETTINGS:
				return ((InternalEList<?>)getSettings()).basicRemove(otherEnd, msgs);
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
			case ECompareModelPackage.EDIFF_SEQUENCE_ITEM__EXISTS_IN_SOURCE:
				return isExistsInSource() ? Boolean.TRUE : Boolean.FALSE;
			case ECompareModelPackage.EDIFF_SEQUENCE_ITEM__EXISTS_IN_TARGET:
				return isExistsInTarget() ? Boolean.TRUE : Boolean.FALSE;
			case ECompareModelPackage.EDIFF_SEQUENCE_ITEM__SOURCE_OBJECT:
				if (resolve) return getSourceObject();
				return basicGetSourceObject();
			case ECompareModelPackage.EDIFF_SEQUENCE_ITEM__TARGET_OBJECT:
				if (resolve) return getTargetObject();
				return basicGetTargetObject();
			case ECompareModelPackage.EDIFF_SEQUENCE_ITEM__SETTINGS:
				return getSettings();
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
			case ECompareModelPackage.EDIFF_SEQUENCE_ITEM__EXISTS_IN_SOURCE:
				setExistsInSource(((Boolean)newValue).booleanValue());
				return;
			case ECompareModelPackage.EDIFF_SEQUENCE_ITEM__EXISTS_IN_TARGET:
				setExistsInTarget(((Boolean)newValue).booleanValue());
				return;
			case ECompareModelPackage.EDIFF_SEQUENCE_ITEM__SOURCE_OBJECT:
				setSourceObject((EObject)newValue);
				return;
			case ECompareModelPackage.EDIFF_SEQUENCE_ITEM__TARGET_OBJECT:
				setTargetObject((EObject)newValue);
				return;
			case ECompareModelPackage.EDIFF_SEQUENCE_ITEM__SETTINGS:
				getSettings().clear();
				getSettings().addAll((Collection<? extends EDiffSetting>)newValue);
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
			case ECompareModelPackage.EDIFF_SEQUENCE_ITEM__EXISTS_IN_SOURCE:
				setExistsInSource(EXISTS_IN_SOURCE_EDEFAULT);
				return;
			case ECompareModelPackage.EDIFF_SEQUENCE_ITEM__EXISTS_IN_TARGET:
				setExistsInTarget(EXISTS_IN_TARGET_EDEFAULT);
				return;
			case ECompareModelPackage.EDIFF_SEQUENCE_ITEM__SOURCE_OBJECT:
				setSourceObject((EObject)null);
				return;
			case ECompareModelPackage.EDIFF_SEQUENCE_ITEM__TARGET_OBJECT:
				setTargetObject((EObject)null);
				return;
			case ECompareModelPackage.EDIFF_SEQUENCE_ITEM__SETTINGS:
				getSettings().clear();
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
			case ECompareModelPackage.EDIFF_SEQUENCE_ITEM__EXISTS_IN_SOURCE:
				return existsInSource != EXISTS_IN_SOURCE_EDEFAULT;
			case ECompareModelPackage.EDIFF_SEQUENCE_ITEM__EXISTS_IN_TARGET:
				return existsInTarget != EXISTS_IN_TARGET_EDEFAULT;
			case ECompareModelPackage.EDIFF_SEQUENCE_ITEM__SOURCE_OBJECT:
				return sourceObject != null;
			case ECompareModelPackage.EDIFF_SEQUENCE_ITEM__TARGET_OBJECT:
				return targetObject != null;
			case ECompareModelPackage.EDIFF_SEQUENCE_ITEM__SETTINGS:
				return settings != null && !settings.isEmpty();
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
		if (baseClass == EDiffSettingContainer.class) {
			switch (derivedFeatureID) {
				case ECompareModelPackage.EDIFF_SEQUENCE_ITEM__SETTINGS: return ECompareModelPackage.EDIFF_SETTING_CONTAINER__SETTINGS;
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
		if (baseClass == EDiffSettingContainer.class) {
			switch (baseFeatureID) {
				case ECompareModelPackage.EDIFF_SETTING_CONTAINER__SETTINGS: return ECompareModelPackage.EDIFF_SEQUENCE_ITEM__SETTINGS;
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
		result.append(" (existsInSource: ");
		result.append(existsInSource);
		result.append(", existsInTarget: ");
		result.append(existsInTarget);
		result.append(')');
		return result.toString();
	}

} //EDiffSequenceItemImpl
