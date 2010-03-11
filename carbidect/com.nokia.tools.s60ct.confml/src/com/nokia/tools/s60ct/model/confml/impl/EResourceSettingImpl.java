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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.nokia.tools.s60ct.model.confml.ConfmlPackage;
import com.nokia.tools.s60ct.model.confml.EResourceKind;
import com.nokia.tools.s60ct.model.confml.EResourceSetting;
import com.nokia.tools.s60ct.model.confml.EResourceValue;
import com.nokia.tools.s60ct.model.confml.ESetting;
import com.nokia.tools.s60ct.model.confml.ESimpleValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EResource Setting</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.EResourceSettingImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.EResourceSettingImpl#getLocalPath <em>Local Path</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.EResourceSettingImpl#getTargetPath <em>Target Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EResourceSettingImpl extends ECompositeSettingImpl implements EResourceSetting {
	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final EResourceKind KIND_EDEFAULT = EResourceKind.FILE;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected EResourceKind kind = KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLocalPath() <em>Local Path</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalPath()
	 * @generated
	 * @ordered
	 */
	protected ESetting localPath;

	/**
	 * The cached value of the '{@link #getTargetPath() <em>Target Path</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetPath()
	 * @generated
	 * @ordered
	 */
	protected ESetting targetPath;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EResourceSettingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfmlPackage.Literals.ERESOURCE_SETTING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EResourceKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(EResourceKind newKind) {
		EResourceKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ERESOURCE_SETTING__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESetting getLocalPath() {
		if (localPath != null && localPath.eIsProxy()) {
			InternalEObject oldLocalPath = (InternalEObject)localPath;
			localPath = (ESetting)eResolveProxy(oldLocalPath);
			if (localPath != oldLocalPath) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfmlPackage.ERESOURCE_SETTING__LOCAL_PATH, oldLocalPath, localPath));
			}
		}
		return localPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESetting basicGetLocalPath() {
		return localPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalPath(ESetting newLocalPath) {
		ESetting oldLocalPath = localPath;
		localPath = newLocalPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ERESOURCE_SETTING__LOCAL_PATH, oldLocalPath, localPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESetting getTargetPath() {
		if (targetPath != null && targetPath.eIsProxy()) {
			InternalEObject oldTargetPath = (InternalEObject)targetPath;
			targetPath = (ESetting)eResolveProxy(oldTargetPath);
			if (targetPath != oldTargetPath) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfmlPackage.ERESOURCE_SETTING__TARGET_PATH, oldTargetPath, targetPath));
			}
		}
		return targetPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESetting basicGetTargetPath() {
		return targetPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetPath(ESetting newTargetPath) {
		ESetting oldTargetPath = targetPath;
		targetPath = newTargetPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ERESOURCE_SETTING__TARGET_PATH, oldTargetPath, targetPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfmlPackage.ERESOURCE_SETTING__KIND:
				return getKind();
			case ConfmlPackage.ERESOURCE_SETTING__LOCAL_PATH:
				if (resolve) return getLocalPath();
				return basicGetLocalPath();
			case ConfmlPackage.ERESOURCE_SETTING__TARGET_PATH:
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
			case ConfmlPackage.ERESOURCE_SETTING__KIND:
				setKind((EResourceKind)newValue);
				return;
			case ConfmlPackage.ERESOURCE_SETTING__LOCAL_PATH:
				setLocalPath((ESetting)newValue);
				return;
			case ConfmlPackage.ERESOURCE_SETTING__TARGET_PATH:
				setTargetPath((ESetting)newValue);
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
			case ConfmlPackage.ERESOURCE_SETTING__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case ConfmlPackage.ERESOURCE_SETTING__LOCAL_PATH:
				setLocalPath((ESetting)null);
				return;
			case ConfmlPackage.ERESOURCE_SETTING__TARGET_PATH:
				setTargetPath((ESetting)null);
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
			case ConfmlPackage.ERESOURCE_SETTING__KIND:
				return kind != KIND_EDEFAULT;
			case ConfmlPackage.ERESOURCE_SETTING__LOCAL_PATH:
				return localPath != null;
			case ConfmlPackage.ERESOURCE_SETTING__TARGET_PATH:
				return targetPath != null;
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
		result.append(" (kind: ");
		result.append(kind);
		result.append(')');
		return result.toString();
	}
	
	@Override
	public boolean isDirty() {
		EResourceValue currentValue = (EResourceValue) getValue();
		EResourceValue defaultValue = (EResourceValue) getDefaultValue();
		if (currentValue == null || currentValue.getLocalPath() == null) {
			return false;			
		} else if ((defaultValue == null || defaultValue.getLocalPath() == null) 
				&& isModified()) {
			return true;		
		} 
		else if (((ESimpleValue)defaultValue.getLocalPath()).getValue() ==null)
		{
			return true;
		}
		else if (((ESimpleValue)currentValue.getLocalPath()).getValue().compareTo(((ESimpleValue)defaultValue.getLocalPath()).getValue()) != 0
				&& isModified()) {				
			return true;
		} if (((ESimpleValue)currentValue.getLocalPath()).getValue().compareTo(((ESimpleValue)defaultValue.getLocalPath()).getValue()) == 0
				&& isModified()) {				
			return true;
		} else {
			return false;				
		}
	}
	
	@Override
	public boolean isDefault() {
		EResourceValue resourceValue = (EResourceValue) getValue();
		
		if (resourceValue == null || resourceValue.getLocalPath()==null)
			return true;
		String value = ((ESimpleValue)resourceValue.getLocalPath()).getValue();
		
		EResourceValue defaultResourceValue = (EResourceValue) getDefaultValue();
		String defaultValue = null;
		if (defaultResourceValue.getLocalPath()!=null)
			defaultValue = ((ESimpleValue)defaultResourceValue.getLocalPath()).getValue();
		else
			return true;
		
		if( value!=null && defaultValue!=null && value != defaultValue)
		{
			return false;
		} 
		else 
		{
			return true;
		}
	}
	
	@Override
	public void clearDirty() {
		setModified(false);
	}
	

} //EResourceSettingImpl
