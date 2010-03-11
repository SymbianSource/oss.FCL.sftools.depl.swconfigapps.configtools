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
 * Description: This file is part of com.nokia.tools.vct.crml component.
 */

package com.nokia.tools.vct.crml.crmodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.nokia.tools.vct.crml.crmodel.EAccess;
import com.nokia.tools.vct.crml.crmodel.EAccessType;
import com.nokia.tools.vct.crml.crmodel.ECRMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EAccess</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.EAccessImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.EAccessImpl#getCapabilities <em>Capabilities</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.EAccessImpl#getSid <em>Sid</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EAccessImpl extends EAttributeAndDescriptionImpl implements EAccess {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final EAccessType TYPE_EDEFAULT = EAccessType.ND;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EAccessType type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCapabilities() <em>Capabilities</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapabilities()
	 * @generated
	 * @ordered
	 */
	protected static final String CAPABILITIES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCapabilities() <em>Capabilities</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapabilities()
	 * @generated
	 * @ordered
	 */
	protected String capabilities = CAPABILITIES_EDEFAULT;

	/**
	 * The default value of the '{@link #getSid() <em>Sid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSid()
	 * @generated
	 * @ordered
	 */
	protected static final String SID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSid() <em>Sid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSid()
	 * @generated
	 * @ordered
	 */
	protected String sid = SID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EAccessImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ECRMLPackage.Literals.EACCESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAccessType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(EAccessType newType) {
		EAccessType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECRMLPackage.EACCESS__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCapabilities() {
		return capabilities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilities(String newCapabilities) {
		String oldCapabilities = capabilities;
		capabilities = newCapabilities;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECRMLPackage.EACCESS__CAPABILITIES, oldCapabilities, capabilities));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSid() {
		return sid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSid(String newSid) {
		String oldSid = sid;
		sid = newSid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECRMLPackage.EACCESS__SID, oldSid, sid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ECRMLPackage.EACCESS__TYPE:
				return getType();
			case ECRMLPackage.EACCESS__CAPABILITIES:
				return getCapabilities();
			case ECRMLPackage.EACCESS__SID:
				return getSid();
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
			case ECRMLPackage.EACCESS__TYPE:
				setType((EAccessType)newValue);
				return;
			case ECRMLPackage.EACCESS__CAPABILITIES:
				setCapabilities((String)newValue);
				return;
			case ECRMLPackage.EACCESS__SID:
				setSid((String)newValue);
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
			case ECRMLPackage.EACCESS__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ECRMLPackage.EACCESS__CAPABILITIES:
				setCapabilities(CAPABILITIES_EDEFAULT);
				return;
			case ECRMLPackage.EACCESS__SID:
				setSid(SID_EDEFAULT);
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
			case ECRMLPackage.EACCESS__TYPE:
				return type != TYPE_EDEFAULT;
			case ECRMLPackage.EACCESS__CAPABILITIES:
				return CAPABILITIES_EDEFAULT == null ? capabilities != null : !CAPABILITIES_EDEFAULT.equals(capabilities);
			case ECRMLPackage.EACCESS__SID:
				return SID_EDEFAULT == null ? sid != null : !SID_EDEFAULT.equals(sid);
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
		result.append(" (type: ");
		result.append(type);
		result.append(", capabilities: ");
		result.append(capabilities);
		result.append(", sid: ");
		result.append(sid);
		result.append(')');
		return result.toString();
	}

} //EAccessImpl
