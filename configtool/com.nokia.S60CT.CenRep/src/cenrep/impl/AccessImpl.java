/*
* Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
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
package cenrep.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import cenrep.ACCESS_TYPE;
import cenrep.Access;
import cenrep.CenrepPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Access</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cenrep.impl.AccessImpl#getType <em>Type</em>}</li>
 *   <li>{@link cenrep.impl.AccessImpl#getCapabilities <em>Capabilities</em>}</li>
 *   <li>{@link cenrep.impl.AccessImpl#getSid <em>Sid</em>}</li>
 *   <li>{@link cenrep.impl.AccessImpl#getStrFormat <em>Str Format</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AccessImpl extends AttributeAndDescriptionImpl implements Access {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated NOT
	 * @ordered
	 */
	protected static final ACCESS_TYPE TYPE_EDEFAULT = ACCESS_TYPE.ND;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected ACCESS_TYPE type = TYPE_EDEFAULT;

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
	 * The default value of the '{@link #getStrFormat() <em>Str Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStrFormat()
	 * @generated
	 * @ordered
	 */
	protected static final String STR_FORMAT_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AccessImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CenrepPackage.Literals.ACCESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ACCESS_TYPE getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(ACCESS_TYPE newType) {
		ACCESS_TYPE oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.ACCESS__TYPE, oldType, type));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.ACCESS__CAPABILITIES, oldCapabilities, capabilities));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.ACCESS__SID, oldSid, sid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	static final String CAP_RD ="cap_rd";
	static final String CAP_WR ="cap_wr";
	static final String SID_RD ="sid_rd";
	static final String SID_WR ="sid_wr";
	public String getStrFormat() {
		String result="";
		if(getType()==ACCESS_TYPE.READ){
			if(getSid()!=null)
				result+=SID_RD+"="+getSid()+" ";
			if(getCapabilities()!=null)
				result+=CAP_RD+"="+this.getCapabilities();
		}else if(getType()==ACCESS_TYPE.WRITE){
			if(getCapabilities()!=null&&getCapabilities().length()!=0)
				result+=CAP_WR+"="+this.getCapabilities();
			if(getSid()!=null)
				result+=" "+SID_WR+"="+getSid();
		}
		return result.trim().replaceAll("AlwaysPass", "alwayspass");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CenrepPackage.ACCESS__TYPE:
				return getType();
			case CenrepPackage.ACCESS__CAPABILITIES:
				return getCapabilities();
			case CenrepPackage.ACCESS__SID:
				return getSid();
			case CenrepPackage.ACCESS__STR_FORMAT:
				return getStrFormat();
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
			case CenrepPackage.ACCESS__TYPE:
				setType((ACCESS_TYPE)newValue);
				return;
			case CenrepPackage.ACCESS__CAPABILITIES:
				setCapabilities((String)newValue);
				return;
			case CenrepPackage.ACCESS__SID:
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
			case CenrepPackage.ACCESS__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case CenrepPackage.ACCESS__CAPABILITIES:
				setCapabilities(CAPABILITIES_EDEFAULT);
				return;
			case CenrepPackage.ACCESS__SID:
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
			case CenrepPackage.ACCESS__TYPE:
				return type != TYPE_EDEFAULT;
			case CenrepPackage.ACCESS__CAPABILITIES:
				return CAPABILITIES_EDEFAULT == null ? capabilities != null : !CAPABILITIES_EDEFAULT.equals(capabilities);
			case CenrepPackage.ACCESS__SID:
				return SID_EDEFAULT == null ? sid != null : !SID_EDEFAULT.equals(sid);
			case CenrepPackage.ACCESS__STR_FORMAT:
				return STR_FORMAT_EDEFAULT == null ? getStrFormat() != null : !STR_FORMAT_EDEFAULT.equals(getStrFormat());
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
	
	
	
} //AccessImpl