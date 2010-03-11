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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import com.nokia.tools.vct.common.appmodel.EAppResourceData;
import com.nokia.tools.vct.common.appmodel.EAppSettingData;
import com.nokia.tools.vct.common.appmodel.EApplicationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EApp Resource Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppResourceDataImpl#getLocalPath <em>Local Path</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppResourceDataImpl#getTargetPath <em>Target Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EAppResourceDataImpl extends EAppCompositeDataImpl implements EAppResourceData {
    
    static final String LOCAL_PATH_ID = "localPath";
    static final String TARGET_PATH_ID = "targetPath";
    
    
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EAppResourceDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EApplicationPackage.Literals.EAPP_RESOURCE_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAppSettingData getLocalPath() {
		EAppSettingData localPath = basicGetLocalPath();
		return localPath != null && localPath.eIsProxy() ? (EAppSettingData)eResolveProxy((InternalEObject)localPath) : localPath;
	}

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     */
	public EAppSettingData basicGetLocalPath() {
	    return getSubSettings().get(LOCAL_PATH_ID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     */
	public void setLocalPath(EAppSettingData newLocalPath) {
        getSubSettings().put(LOCAL_PATH_ID, newLocalPath);
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAppSettingData getTargetPath() {
		EAppSettingData targetPath = basicGetTargetPath();
		return targetPath != null && targetPath.eIsProxy() ? (EAppSettingData)eResolveProxy((InternalEObject)targetPath) : targetPath;
	}

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     */
	public EAppSettingData basicGetTargetPath() {
        return getSubSettings().get(TARGET_PATH_ID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     */
	public void setTargetPath(EAppSettingData newTargetPath) {
        getSubSettings().put(TARGET_PATH_ID, newTargetPath);
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EApplicationPackage.EAPP_RESOURCE_DATA__LOCAL_PATH:
				if (resolve) return getLocalPath();
				return basicGetLocalPath();
			case EApplicationPackage.EAPP_RESOURCE_DATA__TARGET_PATH:
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
			case EApplicationPackage.EAPP_RESOURCE_DATA__LOCAL_PATH:
				setLocalPath((EAppSettingData)newValue);
				return;
			case EApplicationPackage.EAPP_RESOURCE_DATA__TARGET_PATH:
				setTargetPath((EAppSettingData)newValue);
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
			case EApplicationPackage.EAPP_RESOURCE_DATA__LOCAL_PATH:
				setLocalPath((EAppSettingData)null);
				return;
			case EApplicationPackage.EAPP_RESOURCE_DATA__TARGET_PATH:
				setTargetPath((EAppSettingData)null);
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
			case EApplicationPackage.EAPP_RESOURCE_DATA__LOCAL_PATH:
				return basicGetLocalPath() != null;
			case EApplicationPackage.EAPP_RESOURCE_DATA__TARGET_PATH:
				return basicGetTargetPath() != null;
		}
		return super.eIsSet(featureID);
	}

} //EAppResourceDataImpl
