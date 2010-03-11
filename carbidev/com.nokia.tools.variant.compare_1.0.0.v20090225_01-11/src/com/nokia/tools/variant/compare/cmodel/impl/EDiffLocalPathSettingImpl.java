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
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.nokia.tools.variant.compare.cmodel.ECompareModelPackage;
import com.nokia.tools.variant.compare.cmodel.EDiffLocalPathSetting;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EDiff Local Path Setting</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.impl.EDiffLocalPathSettingImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.impl.EDiffLocalPathSettingImpl#isEqualContent <em>Equal Content</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EDiffLocalPathSettingImpl extends EDiffSimpleImpl implements EDiffLocalPathSetting {
	/**
	 * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected String uri = URI_EDEFAULT;

	/**
	 * The default value of the '{@link #isEqualContent() <em>Equal Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEqualContent()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EQUAL_CONTENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEqualContent() <em>Equal Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEqualContent()
	 * @generated
	 * @ordered
	 */
	protected boolean equalContent = EQUAL_CONTENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EDiffLocalPathSettingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ECompareModelPackage.Literals.EDIFF_LOCAL_PATH_SETTING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUri(String newUri) {
		String oldUri = uri;
		uri = newUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECompareModelPackage.EDIFF_LOCAL_PATH_SETTING__URI, oldUri, uri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEqualContent() {
		return equalContent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEqualContent(boolean newEqualContent) {
		boolean oldEqualContent = equalContent;
		equalContent = newEqualContent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECompareModelPackage.EDIFF_LOCAL_PATH_SETTING__EQUAL_CONTENT, oldEqualContent, equalContent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ECompareModelPackage.EDIFF_LOCAL_PATH_SETTING__URI:
				return getUri();
			case ECompareModelPackage.EDIFF_LOCAL_PATH_SETTING__EQUAL_CONTENT:
				return isEqualContent() ? Boolean.TRUE : Boolean.FALSE;
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
			case ECompareModelPackage.EDIFF_LOCAL_PATH_SETTING__URI:
				setUri((String)newValue);
				return;
			case ECompareModelPackage.EDIFF_LOCAL_PATH_SETTING__EQUAL_CONTENT:
				setEqualContent(((Boolean)newValue).booleanValue());
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
			case ECompareModelPackage.EDIFF_LOCAL_PATH_SETTING__URI:
				setUri(URI_EDEFAULT);
				return;
			case ECompareModelPackage.EDIFF_LOCAL_PATH_SETTING__EQUAL_CONTENT:
				setEqualContent(EQUAL_CONTENT_EDEFAULT);
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
			case ECompareModelPackage.EDIFF_LOCAL_PATH_SETTING__URI:
				return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
			case ECompareModelPackage.EDIFF_LOCAL_PATH_SETTING__EQUAL_CONTENT:
				return equalContent != EQUAL_CONTENT_EDEFAULT;
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
		result.append(" (uri: ");
		result.append(uri);
		result.append(", equalContent: ");
		result.append(equalContent);
		result.append(')');
		return result.toString();
	}

} //EDiffLocalPathSettingImpl
