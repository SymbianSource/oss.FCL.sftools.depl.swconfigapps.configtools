/*
* Copyright (c) 2007 Nokia Corporation and/or its subsidiary(-ies). 
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
package com.nokia.tools.s60ct.model.confml.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import com.nokia.tools.s60ct.model.confml.ConfmlPackage;
import com.nokia.tools.s60ct.model.confml.EResourceValue;
import com.nokia.tools.s60ct.model.confml.ESettingValue;
import org.eclipse.emf.common.notify.Notification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EResource Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.EResourceValueImpl#getLocalPath <em>Local Path</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.EResourceValueImpl#getTargetPath <em>Target Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EResourceValueImpl extends ECompositeValueImpl implements EResourceValue {
	/**
	 * The cached value of the '{@link #getLocalPath() <em>Local Path</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalPath()
	 * @generated
	 * @ordered
	 */
	protected ESettingValue localPath;
	/**
	 * The cached value of the '{@link #getTargetPath() <em>Target Path</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetPath()
	 * @generated
	 * @ordered
	 */
	protected ESettingValue targetPath;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EResourceValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfmlPackage.Literals.ERESOURCE_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESettingValue getLocalPath() {
		if (localPath != null && localPath.eIsProxy()) {
			InternalEObject oldLocalPath = (InternalEObject)localPath;
			localPath = (ESettingValue)eResolveProxy(oldLocalPath);
			if (localPath != oldLocalPath) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfmlPackage.ERESOURCE_VALUE__LOCAL_PATH, oldLocalPath, localPath));
			}
		}
		return localPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESettingValue basicGetLocalPath() {
		return localPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalPath(ESettingValue newLocalPath) {
		ESettingValue oldLocalPath = localPath;
		localPath = newLocalPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ERESOURCE_VALUE__LOCAL_PATH, oldLocalPath, localPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESettingValue getTargetPath() {
		if (targetPath != null && targetPath.eIsProxy()) {
			InternalEObject oldTargetPath = (InternalEObject)targetPath;
			targetPath = (ESettingValue)eResolveProxy(oldTargetPath);
			if (targetPath != oldTargetPath) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfmlPackage.ERESOURCE_VALUE__TARGET_PATH, oldTargetPath, targetPath));
			}
		}
		return targetPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESettingValue basicGetTargetPath() {
		return targetPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetPath(ESettingValue newTargetPath) {
		ESettingValue oldTargetPath = targetPath;
		targetPath = newTargetPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ERESOURCE_VALUE__TARGET_PATH, oldTargetPath, targetPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfmlPackage.ERESOURCE_VALUE__LOCAL_PATH:
				if (resolve) return getLocalPath();
				return basicGetLocalPath();
			case ConfmlPackage.ERESOURCE_VALUE__TARGET_PATH:
				if (resolve) return getTargetPath();
				return basicGetTargetPath();
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
			case ConfmlPackage.ERESOURCE_VALUE__LOCAL_PATH:
				setLocalPath((ESettingValue)newValue);
				return;
			case ConfmlPackage.ERESOURCE_VALUE__TARGET_PATH:
				setTargetPath((ESettingValue)newValue);
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
			case ConfmlPackage.ERESOURCE_VALUE__LOCAL_PATH:
				setLocalPath((ESettingValue)null);
				return;
			case ConfmlPackage.ERESOURCE_VALUE__TARGET_PATH:
				setTargetPath((ESettingValue)null);
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
			case ConfmlPackage.ERESOURCE_VALUE__LOCAL_PATH:
				return localPath != null;
			case ConfmlPackage.ERESOURCE_VALUE__TARGET_PATH:
				return targetPath != null;
		}
		return super.eIsSet(featureID);
	}

} //EResourceValueImpl
