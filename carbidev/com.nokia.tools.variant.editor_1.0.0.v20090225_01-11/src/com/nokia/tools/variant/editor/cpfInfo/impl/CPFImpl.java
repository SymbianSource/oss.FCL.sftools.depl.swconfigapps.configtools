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
 * Description: This file is part of com.nokia.tools.variant.editor component.
 */

package com.nokia.tools.variant.editor.cpfInfo.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.nokia.tools.variant.editor.cpfInfo.CPF;
import com.nokia.tools.variant.editor.cpfInfo.CPFInformation;
import com.nokia.tools.variant.editor.cpfInfo.CpfInfoPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CPF</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.editor.cpfInfo.impl.CPFImpl#getCpfInfo <em>Cpf Info</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CPFImpl extends EObjectImpl implements CPF {
	/**
	 * The cached value of the '{@link #getCpfInfo() <em>Cpf Info</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpfInfo()
	 * @generated
	 * @ordered
	 */
	protected CPFInformation cpfInfo;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CPFImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CpfInfoPackage.Literals.CPF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CPFInformation getCpfInfo() {
		if (cpfInfo != null && cpfInfo.eIsProxy()) {
			InternalEObject oldCpfInfo = (InternalEObject)cpfInfo;
			cpfInfo = (CPFInformation)eResolveProxy(oldCpfInfo);
			if (cpfInfo != oldCpfInfo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CpfInfoPackage.CPF__CPF_INFO, oldCpfInfo, cpfInfo));
			}
		}
		return cpfInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CPFInformation basicGetCpfInfo() {
		return cpfInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCpfInfo(CPFInformation newCpfInfo) {
		CPFInformation oldCpfInfo = cpfInfo;
		cpfInfo = newCpfInfo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CpfInfoPackage.CPF__CPF_INFO, oldCpfInfo, cpfInfo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CpfInfoPackage.CPF__CPF_INFO:
				if (resolve) return getCpfInfo();
				return basicGetCpfInfo();
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
			case CpfInfoPackage.CPF__CPF_INFO:
				setCpfInfo((CPFInformation)newValue);
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
			case CpfInfoPackage.CPF__CPF_INFO:
				setCpfInfo((CPFInformation)null);
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
			case CpfInfoPackage.CPF__CPF_INFO:
				return cpfInfo != null;
		}
		return super.eIsSet(featureID);
	}

} //CPFImpl
