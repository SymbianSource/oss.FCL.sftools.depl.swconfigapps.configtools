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
import com.nokia.tools.s60ct.resources.model.ELibraryThemeFile;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Theme File</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.resources.model.impl.ELibraryThemeFileImpl#getValidationMessage <em>Validation Message</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.resources.model.impl.ELibraryThemeFileImpl#getCpfPlatformId <em>Cpf Platform Id</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.resources.model.impl.ELibraryThemeFileImpl#getThemePlatformId <em>Theme Platform Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ELibraryThemeFileImpl extends ELibraryFileImpl implements ELibraryThemeFile {
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
	 * The default value of the '{@link #getCpfPlatformId() <em>Cpf Platform Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpfPlatformId()
	 * @generated
	 * @ordered
	 */
	protected static final String CPF_PLATFORM_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCpfPlatformId() <em>Cpf Platform Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpfPlatformId()
	 * @generated
	 * @ordered
	 */
	protected String cpfPlatformId = CPF_PLATFORM_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getThemePlatformId() <em>Theme Platform Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThemePlatformId()
	 * @generated
	 * @ordered
	 */
	protected static final String THEME_PLATFORM_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getThemePlatformId() <em>Theme Platform Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThemePlatformId()
	 * @generated
	 * @ordered
	 */
	protected String themePlatformId = THEME_PLATFORM_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ELibraryThemeFileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ELibraryModelPackage.Literals.ELIBRARY_THEME_FILE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ELibraryModelPackage.ELIBRARY_THEME_FILE__VALIDATION_MESSAGE, oldValidationMessage, validationMessage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCpfPlatformId() {
		return cpfPlatformId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCpfPlatformId(String newCpfPlatformId) {
		String oldCpfPlatformId = cpfPlatformId;
		cpfPlatformId = newCpfPlatformId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ELibraryModelPackage.ELIBRARY_THEME_FILE__CPF_PLATFORM_ID, oldCpfPlatformId, cpfPlatformId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getThemePlatformId() {
		return themePlatformId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThemePlatformId(String newThemePlatformId) {
		String oldThemePlatformId = themePlatformId;
		themePlatformId = newThemePlatformId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ELibraryModelPackage.ELIBRARY_THEME_FILE__THEME_PLATFORM_ID, oldThemePlatformId, themePlatformId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ELibraryModelPackage.ELIBRARY_THEME_FILE__VALIDATION_MESSAGE:
				return getValidationMessage();
			case ELibraryModelPackage.ELIBRARY_THEME_FILE__CPF_PLATFORM_ID:
				return getCpfPlatformId();
			case ELibraryModelPackage.ELIBRARY_THEME_FILE__THEME_PLATFORM_ID:
				return getThemePlatformId();
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
			case ELibraryModelPackage.ELIBRARY_THEME_FILE__VALIDATION_MESSAGE:
				setValidationMessage((String)newValue);
				return;
			case ELibraryModelPackage.ELIBRARY_THEME_FILE__CPF_PLATFORM_ID:
				setCpfPlatformId((String)newValue);
				return;
			case ELibraryModelPackage.ELIBRARY_THEME_FILE__THEME_PLATFORM_ID:
				setThemePlatformId((String)newValue);
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
			case ELibraryModelPackage.ELIBRARY_THEME_FILE__VALIDATION_MESSAGE:
				setValidationMessage(VALIDATION_MESSAGE_EDEFAULT);
				return;
			case ELibraryModelPackage.ELIBRARY_THEME_FILE__CPF_PLATFORM_ID:
				setCpfPlatformId(CPF_PLATFORM_ID_EDEFAULT);
				return;
			case ELibraryModelPackage.ELIBRARY_THEME_FILE__THEME_PLATFORM_ID:
				setThemePlatformId(THEME_PLATFORM_ID_EDEFAULT);
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
			case ELibraryModelPackage.ELIBRARY_THEME_FILE__VALIDATION_MESSAGE:
				return VALIDATION_MESSAGE_EDEFAULT == null ? validationMessage != null : !VALIDATION_MESSAGE_EDEFAULT.equals(validationMessage);
			case ELibraryModelPackage.ELIBRARY_THEME_FILE__CPF_PLATFORM_ID:
				return CPF_PLATFORM_ID_EDEFAULT == null ? cpfPlatformId != null : !CPF_PLATFORM_ID_EDEFAULT.equals(cpfPlatformId);
			case ELibraryModelPackage.ELIBRARY_THEME_FILE__THEME_PLATFORM_ID:
				return THEME_PLATFORM_ID_EDEFAULT == null ? themePlatformId != null : !THEME_PLATFORM_ID_EDEFAULT.equals(themePlatformId);
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
		result.append(", cpfPlatformId: ");
		result.append(cpfPlatformId);
		result.append(", themePlatformId: ");
		result.append(themePlatformId);
		result.append(')');
		return result.toString();
	}

} //ThemeFileImpl
