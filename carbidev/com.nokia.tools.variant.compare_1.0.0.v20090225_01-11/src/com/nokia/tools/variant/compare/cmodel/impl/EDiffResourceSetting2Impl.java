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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.nokia.tools.variant.compare.cmodel.ECompareModelPackage;
import com.nokia.tools.variant.compare.cmodel.EDiffLocalPathSetting;
import com.nokia.tools.variant.compare.cmodel.EDiffResourceSetting2;
import com.nokia.tools.variant.compare.cmodel.EDiffSimple;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EDiff Resource Setting2</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.impl.EDiffResourceSetting2Impl#getSourcePath <em>Source Path</em>}</li>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.impl.EDiffResourceSetting2Impl#getTargetPath <em>Target Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EDiffResourceSetting2Impl extends EDiffSettingImpl implements EDiffResourceSetting2 {
	/**
	 * The cached value of the '{@link #getSourcePath() <em>Source Path</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourcePath()
	 * @generated
	 * @ordered
	 */
	protected EDiffLocalPathSetting sourcePath;

	/**
	 * The cached value of the '{@link #getTargetPath() <em>Target Path</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetPath()
	 * @generated
	 * @ordered
	 */
	protected EDiffSimple targetPath;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EDiffResourceSetting2Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ECompareModelPackage.Literals.EDIFF_RESOURCE_SETTING2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDiffLocalPathSetting getSourcePath() {
		return sourcePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourcePath(EDiffLocalPathSetting newSourcePath, NotificationChain msgs) {
		EDiffLocalPathSetting oldSourcePath = sourcePath;
		sourcePath = newSourcePath;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ECompareModelPackage.EDIFF_RESOURCE_SETTING2__SOURCE_PATH, oldSourcePath, newSourcePath);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourcePath(EDiffLocalPathSetting newSourcePath) {
		if (newSourcePath != sourcePath) {
			NotificationChain msgs = null;
			if (sourcePath != null)
				msgs = ((InternalEObject)sourcePath).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ECompareModelPackage.EDIFF_RESOURCE_SETTING2__SOURCE_PATH, null, msgs);
			if (newSourcePath != null)
				msgs = ((InternalEObject)newSourcePath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ECompareModelPackage.EDIFF_RESOURCE_SETTING2__SOURCE_PATH, null, msgs);
			msgs = basicSetSourcePath(newSourcePath, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECompareModelPackage.EDIFF_RESOURCE_SETTING2__SOURCE_PATH, newSourcePath, newSourcePath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDiffSimple getTargetPath() {
		return targetPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetPath(EDiffSimple newTargetPath, NotificationChain msgs) {
		EDiffSimple oldTargetPath = targetPath;
		targetPath = newTargetPath;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ECompareModelPackage.EDIFF_RESOURCE_SETTING2__TARGET_PATH, oldTargetPath, newTargetPath);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetPath(EDiffSimple newTargetPath) {
		if (newTargetPath != targetPath) {
			NotificationChain msgs = null;
			if (targetPath != null)
				msgs = ((InternalEObject)targetPath).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ECompareModelPackage.EDIFF_RESOURCE_SETTING2__TARGET_PATH, null, msgs);
			if (newTargetPath != null)
				msgs = ((InternalEObject)newTargetPath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ECompareModelPackage.EDIFF_RESOURCE_SETTING2__TARGET_PATH, null, msgs);
			msgs = basicSetTargetPath(newTargetPath, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECompareModelPackage.EDIFF_RESOURCE_SETTING2__TARGET_PATH, newTargetPath, newTargetPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ECompareModelPackage.EDIFF_RESOURCE_SETTING2__SOURCE_PATH:
				return basicSetSourcePath(null, msgs);
			case ECompareModelPackage.EDIFF_RESOURCE_SETTING2__TARGET_PATH:
				return basicSetTargetPath(null, msgs);
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
			case ECompareModelPackage.EDIFF_RESOURCE_SETTING2__SOURCE_PATH:
				return getSourcePath();
			case ECompareModelPackage.EDIFF_RESOURCE_SETTING2__TARGET_PATH:
				return getTargetPath();
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
			case ECompareModelPackage.EDIFF_RESOURCE_SETTING2__SOURCE_PATH:
				setSourcePath((EDiffLocalPathSetting)newValue);
				return;
			case ECompareModelPackage.EDIFF_RESOURCE_SETTING2__TARGET_PATH:
				setTargetPath((EDiffSimple)newValue);
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
			case ECompareModelPackage.EDIFF_RESOURCE_SETTING2__SOURCE_PATH:
				setSourcePath((EDiffLocalPathSetting)null);
				return;
			case ECompareModelPackage.EDIFF_RESOURCE_SETTING2__TARGET_PATH:
				setTargetPath((EDiffSimple)null);
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
			case ECompareModelPackage.EDIFF_RESOURCE_SETTING2__SOURCE_PATH:
				return sourcePath != null;
			case ECompareModelPackage.EDIFF_RESOURCE_SETTING2__TARGET_PATH:
				return targetPath != null;
		}
		return super.eIsSet(featureID);
	}

} //EDiffResourceSetting2Impl
