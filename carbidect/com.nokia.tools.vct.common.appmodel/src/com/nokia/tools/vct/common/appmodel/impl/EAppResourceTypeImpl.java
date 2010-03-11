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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.nokia.tools.vct.common.appmodel.EAppResourceType;
import com.nokia.tools.vct.common.appmodel.EAppSettingType;
import com.nokia.tools.vct.common.appmodel.EApplicationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EApp Resource Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppResourceTypeImpl#isFile <em>File</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppResourceTypeImpl#getLocalPath <em>Local Path</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppResourceTypeImpl#getTargetPath <em>Target Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EAppResourceTypeImpl extends EAppCompositeTypeImpl implements EAppResourceType {
    
    static final String LOCAL_PATH_ID = "localPath";
    static final String TARGET_PATH_ID = "targetPath";
    
	/**
	 * The default value of the '{@link #isFile() <em>File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFile()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FILE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFile() <em>File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFile()
	 * @generated
	 * @ordered
	 */
	protected boolean file = FILE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EAppResourceTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EApplicationPackage.Literals.EAPP_RESOURCE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFile() {
		return file;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFile(boolean newFile) {
		boolean oldFile = file;
		file = newFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_RESOURCE_TYPE__FILE, oldFile, file));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAppSettingType getLocalPath() {
		EAppSettingType localPath = basicGetLocalPath();
		return localPath != null && localPath.eIsProxy() ? (EAppSettingType)eResolveProxy((InternalEObject)localPath) : localPath;
	}

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     */
	public EAppSettingType basicGetLocalPath() {
	    return getTypeMap().get(LOCAL_PATH_ID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     */
	public void setLocalPath(EAppSettingType newLocalPath) {
	    getTypeMap().put(LOCAL_PATH_ID, newLocalPath);
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAppSettingType getTargetPath() {
		EAppSettingType targetPath = basicGetTargetPath();
		return targetPath != null && targetPath.eIsProxy() ? (EAppSettingType)eResolveProxy((InternalEObject)targetPath) : targetPath;
	}

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     */
	public EAppSettingType basicGetTargetPath() {
        return getTypeMap().get(TARGET_PATH_ID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     */
	public void setTargetPath(EAppSettingType newTargetPath) {
        getTypeMap().put(TARGET_PATH_ID, newTargetPath);
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EApplicationPackage.EAPP_RESOURCE_TYPE__FILE:
				return isFile() ? Boolean.TRUE : Boolean.FALSE;
			case EApplicationPackage.EAPP_RESOURCE_TYPE__LOCAL_PATH:
				if (resolve) return getLocalPath();
				return basicGetLocalPath();
			case EApplicationPackage.EAPP_RESOURCE_TYPE__TARGET_PATH:
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
			case EApplicationPackage.EAPP_RESOURCE_TYPE__FILE:
				setFile(((Boolean)newValue).booleanValue());
				return;
			case EApplicationPackage.EAPP_RESOURCE_TYPE__LOCAL_PATH:
				setLocalPath((EAppSettingType)newValue);
				return;
			case EApplicationPackage.EAPP_RESOURCE_TYPE__TARGET_PATH:
				setTargetPath((EAppSettingType)newValue);
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
			case EApplicationPackage.EAPP_RESOURCE_TYPE__FILE:
				setFile(FILE_EDEFAULT);
				return;
			case EApplicationPackage.EAPP_RESOURCE_TYPE__LOCAL_PATH:
				setLocalPath((EAppSettingType)null);
				return;
			case EApplicationPackage.EAPP_RESOURCE_TYPE__TARGET_PATH:
				setTargetPath((EAppSettingType)null);
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
			case EApplicationPackage.EAPP_RESOURCE_TYPE__FILE:
				return file != FILE_EDEFAULT;
			case EApplicationPackage.EAPP_RESOURCE_TYPE__LOCAL_PATH:
				return basicGetLocalPath() != null;
			case EApplicationPackage.EAPP_RESOURCE_TYPE__TARGET_PATH:
				return basicGetTargetPath() != null;
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
		result.append(" (file: ");
		result.append(file);
		result.append(')');
		return result.toString();
	}

} //EAppResourceTypeImpl
