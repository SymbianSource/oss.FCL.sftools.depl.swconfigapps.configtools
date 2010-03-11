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
 * Description: This file is part of com.nokia.tools.variant.confml.core component.
 */

package com.nokia.tools.variant.confml.core.model.application.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.nokia.tools.variant.confml.core.model.application.EAppRfsInfo;
import com.nokia.tools.variant.confml.core.model.application.EApplicationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EApp Rfs Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppRfsInfoImpl#isRfs <em>Rfs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EAppRfsInfoImpl extends EObjectImpl implements EAppRfsInfo {
	/**
     * The default value of the '{@link #isRfs() <em>Rfs</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isRfs()
     * @generated
     * @ordered
     */
	protected static final boolean RFS_EDEFAULT = false;

	/**
     * The cached value of the '{@link #isRfs() <em>Rfs</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isRfs()
     * @generated
     * @ordered
     */
	protected boolean rfs = RFS_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EAppRfsInfoImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return EApplicationPackage.Literals.EAPP_RFS_INFO;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isRfs() {
        return rfs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setRfs(boolean newRfs) {
        boolean oldRfs = rfs;
        rfs = newRfs;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_RFS_INFO__RFS, oldRfs, rfs));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case EApplicationPackage.EAPP_RFS_INFO__RFS:
                return isRfs() ? Boolean.TRUE : Boolean.FALSE;
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
            case EApplicationPackage.EAPP_RFS_INFO__RFS:
                setRfs(((Boolean)newValue).booleanValue());
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
            case EApplicationPackage.EAPP_RFS_INFO__RFS:
                setRfs(RFS_EDEFAULT);
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
            case EApplicationPackage.EAPP_RFS_INFO__RFS:
                return rfs != RFS_EDEFAULT;
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
        result.append(" (rfs: ");
        result.append(rfs);
        result.append(')');
        return result.toString();
    }

} //EAppRfsInfoImpl
