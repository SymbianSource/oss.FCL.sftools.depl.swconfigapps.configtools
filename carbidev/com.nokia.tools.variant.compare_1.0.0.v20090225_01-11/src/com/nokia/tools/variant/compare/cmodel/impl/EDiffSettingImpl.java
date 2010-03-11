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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.nokia.tools.variant.compare.cmodel.ECheckableElement;
import com.nokia.tools.variant.compare.cmodel.ECompareModelPackage;
import com.nokia.tools.variant.compare.cmodel.EDiffSetting;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EDiff Setting</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.impl.EDiffSettingImpl#isExistsInSource <em>Exists In Source</em>}</li>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.impl.EDiffSettingImpl#isExistsInTarget <em>Exists In Target</em>}</li>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.impl.EDiffSettingImpl#getSourceObject <em>Source Object</em>}</li>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.impl.EDiffSettingImpl#getTargetObject <em>Target Object</em>}</li>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.impl.EDiffSettingImpl#isChecked <em>Checked</em>}</li>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.impl.EDiffSettingImpl#getAbsRef <em>Abs Ref</em>}</li>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.impl.EDiffSettingImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.impl.EDiffSettingImpl#isSourceDefault <em>Source Default</em>}</li>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.impl.EDiffSettingImpl#isTargetDefault <em>Target Default</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class EDiffSettingImpl extends EObjectImpl implements EDiffSetting {
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
	 * The default value of the '{@link #isChecked() <em>Checked</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isChecked()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CHECKED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isChecked() <em>Checked</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isChecked()
	 * @generated
	 * @ordered
	 */
	protected boolean checked = CHECKED_EDEFAULT;

	/**
	 * The default value of the '{@link #getAbsRef() <em>Abs Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbsRef()
	 * @generated
	 * @ordered
	 */
	protected static final String ABS_REF_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getAbsRef() <em>Abs Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbsRef()
	 * @generated
	 * @ordered
	 */
	protected String absRef = ABS_REF_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";

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
	 * The default value of the '{@link #isSourceDefault() <em>Source Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSourceDefault()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SOURCE_DEFAULT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSourceDefault() <em>Source Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSourceDefault()
	 * @generated
	 * @ordered
	 */
	protected boolean sourceDefault = SOURCE_DEFAULT_EDEFAULT;

	/**
	 * The default value of the '{@link #isTargetDefault() <em>Target Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTargetDefault()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TARGET_DEFAULT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTargetDefault() <em>Target Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTargetDefault()
	 * @generated
	 * @ordered
	 */
	protected boolean targetDefault = TARGET_DEFAULT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EDiffSettingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ECompareModelPackage.Literals.EDIFF_SETTING;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ECompareModelPackage.EDIFF_SETTING__EXISTS_IN_SOURCE, oldExistsInSource, existsInSource));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ECompareModelPackage.EDIFF_SETTING__EXISTS_IN_TARGET, oldExistsInTarget, existsInTarget));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ECompareModelPackage.EDIFF_SETTING__SOURCE_OBJECT, oldSourceObject, sourceObject));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ECompareModelPackage.EDIFF_SETTING__SOURCE_OBJECT, oldSourceObject, sourceObject));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ECompareModelPackage.EDIFF_SETTING__TARGET_OBJECT, oldTargetObject, targetObject));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ECompareModelPackage.EDIFF_SETTING__TARGET_OBJECT, oldTargetObject, targetObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isChecked() {
		return checked;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChecked(boolean newChecked) {
		boolean oldChecked = checked;
		checked = newChecked;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECompareModelPackage.EDIFF_SETTING__CHECKED, oldChecked, checked));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAbsRef() {
		return absRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbsRef(String newAbsRef) {
		String oldAbsRef = absRef;
		absRef = newAbsRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECompareModelPackage.EDIFF_SETTING__ABS_REF, oldAbsRef, absRef));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ECompareModelPackage.EDIFF_SETTING__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSourceDefault() {
		return sourceDefault;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceDefault(boolean newSourceDefault) {
		boolean oldSourceDefault = sourceDefault;
		sourceDefault = newSourceDefault;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECompareModelPackage.EDIFF_SETTING__SOURCE_DEFAULT, oldSourceDefault, sourceDefault));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTargetDefault() {
		return targetDefault;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetDefault(boolean newTargetDefault) {
		boolean oldTargetDefault = targetDefault;
		targetDefault = newTargetDefault;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECompareModelPackage.EDIFF_SETTING__TARGET_DEFAULT, oldTargetDefault, targetDefault));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ECompareModelPackage.EDIFF_SETTING__EXISTS_IN_SOURCE:
				return isExistsInSource() ? Boolean.TRUE : Boolean.FALSE;
			case ECompareModelPackage.EDIFF_SETTING__EXISTS_IN_TARGET:
				return isExistsInTarget() ? Boolean.TRUE : Boolean.FALSE;
			case ECompareModelPackage.EDIFF_SETTING__SOURCE_OBJECT:
				if (resolve) return getSourceObject();
				return basicGetSourceObject();
			case ECompareModelPackage.EDIFF_SETTING__TARGET_OBJECT:
				if (resolve) return getTargetObject();
				return basicGetTargetObject();
			case ECompareModelPackage.EDIFF_SETTING__CHECKED:
				return isChecked() ? Boolean.TRUE : Boolean.FALSE;
			case ECompareModelPackage.EDIFF_SETTING__ABS_REF:
				return getAbsRef();
			case ECompareModelPackage.EDIFF_SETTING__NAME:
				return getName();
			case ECompareModelPackage.EDIFF_SETTING__SOURCE_DEFAULT:
				return isSourceDefault() ? Boolean.TRUE : Boolean.FALSE;
			case ECompareModelPackage.EDIFF_SETTING__TARGET_DEFAULT:
				return isTargetDefault() ? Boolean.TRUE : Boolean.FALSE;
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
			case ECompareModelPackage.EDIFF_SETTING__EXISTS_IN_SOURCE:
				setExistsInSource(((Boolean)newValue).booleanValue());
				return;
			case ECompareModelPackage.EDIFF_SETTING__EXISTS_IN_TARGET:
				setExistsInTarget(((Boolean)newValue).booleanValue());
				return;
			case ECompareModelPackage.EDIFF_SETTING__SOURCE_OBJECT:
				setSourceObject((EObject)newValue);
				return;
			case ECompareModelPackage.EDIFF_SETTING__TARGET_OBJECT:
				setTargetObject((EObject)newValue);
				return;
			case ECompareModelPackage.EDIFF_SETTING__CHECKED:
				setChecked(((Boolean)newValue).booleanValue());
				return;
			case ECompareModelPackage.EDIFF_SETTING__ABS_REF:
				setAbsRef((String)newValue);
				return;
			case ECompareModelPackage.EDIFF_SETTING__NAME:
				setName((String)newValue);
				return;
			case ECompareModelPackage.EDIFF_SETTING__SOURCE_DEFAULT:
				setSourceDefault(((Boolean)newValue).booleanValue());
				return;
			case ECompareModelPackage.EDIFF_SETTING__TARGET_DEFAULT:
				setTargetDefault(((Boolean)newValue).booleanValue());
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
			case ECompareModelPackage.EDIFF_SETTING__EXISTS_IN_SOURCE:
				setExistsInSource(EXISTS_IN_SOURCE_EDEFAULT);
				return;
			case ECompareModelPackage.EDIFF_SETTING__EXISTS_IN_TARGET:
				setExistsInTarget(EXISTS_IN_TARGET_EDEFAULT);
				return;
			case ECompareModelPackage.EDIFF_SETTING__SOURCE_OBJECT:
				setSourceObject((EObject)null);
				return;
			case ECompareModelPackage.EDIFF_SETTING__TARGET_OBJECT:
				setTargetObject((EObject)null);
				return;
			case ECompareModelPackage.EDIFF_SETTING__CHECKED:
				setChecked(CHECKED_EDEFAULT);
				return;
			case ECompareModelPackage.EDIFF_SETTING__ABS_REF:
				setAbsRef(ABS_REF_EDEFAULT);
				return;
			case ECompareModelPackage.EDIFF_SETTING__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ECompareModelPackage.EDIFF_SETTING__SOURCE_DEFAULT:
				setSourceDefault(SOURCE_DEFAULT_EDEFAULT);
				return;
			case ECompareModelPackage.EDIFF_SETTING__TARGET_DEFAULT:
				setTargetDefault(TARGET_DEFAULT_EDEFAULT);
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
			case ECompareModelPackage.EDIFF_SETTING__EXISTS_IN_SOURCE:
				return existsInSource != EXISTS_IN_SOURCE_EDEFAULT;
			case ECompareModelPackage.EDIFF_SETTING__EXISTS_IN_TARGET:
				return existsInTarget != EXISTS_IN_TARGET_EDEFAULT;
			case ECompareModelPackage.EDIFF_SETTING__SOURCE_OBJECT:
				return sourceObject != null;
			case ECompareModelPackage.EDIFF_SETTING__TARGET_OBJECT:
				return targetObject != null;
			case ECompareModelPackage.EDIFF_SETTING__CHECKED:
				return checked != CHECKED_EDEFAULT;
			case ECompareModelPackage.EDIFF_SETTING__ABS_REF:
				return ABS_REF_EDEFAULT == null ? absRef != null : !ABS_REF_EDEFAULT.equals(absRef);
			case ECompareModelPackage.EDIFF_SETTING__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ECompareModelPackage.EDIFF_SETTING__SOURCE_DEFAULT:
				return sourceDefault != SOURCE_DEFAULT_EDEFAULT;
			case ECompareModelPackage.EDIFF_SETTING__TARGET_DEFAULT:
				return targetDefault != TARGET_DEFAULT_EDEFAULT;
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
		if (baseClass == ECheckableElement.class) {
			switch (derivedFeatureID) {
				case ECompareModelPackage.EDIFF_SETTING__CHECKED: return ECompareModelPackage.ECHECKABLE_ELEMENT__CHECKED;
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
		if (baseClass == ECheckableElement.class) {
			switch (baseFeatureID) {
				case ECompareModelPackage.ECHECKABLE_ELEMENT__CHECKED: return ECompareModelPackage.EDIFF_SETTING__CHECKED;
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
		result.append(", checked: ");
		result.append(checked);
		result.append(", absRef: ");
		result.append(absRef);
		result.append(", name: ");
		result.append(name);
		result.append(", sourceDefault: ");
		result.append(sourceDefault);
		result.append(", targetDefault: ");
		result.append(targetDefault);
		result.append(')');
		return result.toString();
	}

} //EDiffSettingImpl
