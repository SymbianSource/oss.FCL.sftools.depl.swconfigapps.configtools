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
package com.nokia.tools.variant.resourcelibrary.model.impl;

import com.nokia.tools.variant.resourcelibrary.model.ThemeFile;
import com.nokia.tools.variant.resourcelibrary.model.resourcesPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Theme File</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.resourcelibrary.model.impl.ThemeFileImpl#getValidationMessage <em>Validation Message</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ThemeFileImpl extends FileImpl implements ThemeFile {
	/**
	 * The default value of the '{@link #getValidationMessage() <em>Validation Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidationMessage()
	 * @generated
	 * @ordered
	 */
	protected static final String VALIDATION_MESSAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValidationMessage() <em>Validation Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidationMessage()
	 * @generated
	 * @ordered
	 */
	protected String validationMessage = VALIDATION_MESSAGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ThemeFileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return resourcesPackage.Literals.THEME_FILE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValidationMessage() {
		return validationMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValidationMessage(String newValidationMessage) {
		String oldValidationMessage = validationMessage;
		validationMessage = newValidationMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, resourcesPackage.THEME_FILE__VALIDATION_MESSAGE, oldValidationMessage, validationMessage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case resourcesPackage.THEME_FILE__VALIDATION_MESSAGE:
				return getValidationMessage();
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
			case resourcesPackage.THEME_FILE__VALIDATION_MESSAGE:
				setValidationMessage((String)newValue);
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
			case resourcesPackage.THEME_FILE__VALIDATION_MESSAGE:
				setValidationMessage(VALIDATION_MESSAGE_EDEFAULT);
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
			case resourcesPackage.THEME_FILE__VALIDATION_MESSAGE:
				return VALIDATION_MESSAGE_EDEFAULT == null ? validationMessage != null : !VALIDATION_MESSAGE_EDEFAULT.equals(validationMessage);
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
		result.append(" (validationMessage: ");
		result.append(validationMessage);
		result.append(')');
		return result.toString();
	}

} //ThemeFileImpl
