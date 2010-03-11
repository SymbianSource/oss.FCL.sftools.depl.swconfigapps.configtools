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
 * Description: This file is part of com.nokia.tools.variant.resourcelibrary component.
 */

package com.nokia.tools.s60ct.resources.model.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.nokia.tools.s60ct.resources.model.ELibraryModelPackage;
import com.nokia.tools.s60ct.resources.model.ELibraryRoot;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Model Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.resources.model.impl.ELibraryRootImpl#getTempDirPath <em>Temp Dir Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ELibraryRootImpl extends ELibraryDirectoryImpl implements ELibraryRoot {
	/**
	 * The default value of the '{@link #getTempDirPath() <em>Temp Dir Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTempDirPath()
	 * @generated
	 * @ordered
	 */
	protected static final String TEMP_DIR_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTempDirPath() <em>Temp Dir Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTempDirPath()
	 * @generated
	 * @ordered
	 */
	protected String tempDirPath = TEMP_DIR_PATH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ELibraryRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ELibraryModelPackage.Literals.ELIBRARY_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTempDirPath() {
		return tempDirPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTempDirPath(String newTempDirPath) {
		String oldTempDirPath = tempDirPath;
		tempDirPath = newTempDirPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ELibraryModelPackage.ELIBRARY_ROOT__TEMP_DIR_PATH, oldTempDirPath, tempDirPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ELibraryModelPackage.ELIBRARY_ROOT__TEMP_DIR_PATH:
				return getTempDirPath();
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
			case ELibraryModelPackage.ELIBRARY_ROOT__TEMP_DIR_PATH:
				setTempDirPath((String)newValue);
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
			case ELibraryModelPackage.ELIBRARY_ROOT__TEMP_DIR_PATH:
				setTempDirPath(TEMP_DIR_PATH_EDEFAULT);
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
			case ELibraryModelPackage.ELIBRARY_ROOT__TEMP_DIR_PATH:
				return TEMP_DIR_PATH_EDEFAULT == null ? tempDirPath != null : !TEMP_DIR_PATH_EDEFAULT.equals(tempDirPath);
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
		result.append(" (tempDirPath: ");
		result.append(tempDirPath);
		result.append(')');
		return result.toString();
	}

} //ResourceModelRootImpl
