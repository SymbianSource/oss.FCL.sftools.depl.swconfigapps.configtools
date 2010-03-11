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
 * Description: This file is part of com.nokia.tools.vct.confml component.
 */

package com.nokia.tools.vct.confml.model.confml2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.nokia.tools.vct.confml.model.confml2.EConfML2Package;
import com.nokia.tools.vct.confml.model.confml2.ESettingRfs;
import com.nokia.tools.vct.confml.model.confml2.ESettingRfsContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ESetting Rfs</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.ESettingRfsImpl#getSettings <em>Settings</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.ESettingRfsImpl#getRfs <em>Rfs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ESettingRfsImpl extends ERefNamedElementImpl implements
		ESettingRfs {
	/**
	 * The cached value of the '{@link #getSettings() <em>Settings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSettings()
	 * @generated
	 * @ordered
	 */
	protected EList<ESettingRfs> settings;

	/**
	 * The default value of the '{@link #getRfs() <em>Rfs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRfs()
	 * @generated
	 * @ordered
	 */
	protected static final String RFS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRfs() <em>Rfs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRfs()
	 * @generated
	 * @ordered
	 */
	protected String rfs = RFS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ESettingRfsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EConfML2Package.Literals.ESETTING_RFS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ESettingRfs> getSettings() {
		if (settings == null) {
			settings = new EObjectContainmentEList<ESettingRfs>(
					ESettingRfs.class, this,
					EConfML2Package.ESETTING_RFS__SETTINGS);
		}
		return settings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRfs() {
		return rfs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRfs(String newRfs) {
		String oldRfs = rfs;
		rfs = newRfs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					EConfML2Package.ESETTING_RFS__RFS, oldRfs, rfs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case EConfML2Package.ESETTING_RFS__SETTINGS:
			return ((InternalEList<?>) getSettings()).basicRemove(otherEnd,
					msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case EConfML2Package.ESETTING_RFS__SETTINGS:
			return getSettings();
		case EConfML2Package.ESETTING_RFS__RFS:
			return getRfs();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case EConfML2Package.ESETTING_RFS__SETTINGS:
			getSettings().clear();
			getSettings().addAll((Collection<? extends ESettingRfs>) newValue);
			return;
		case EConfML2Package.ESETTING_RFS__RFS:
			setRfs((String) newValue);
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
		case EConfML2Package.ESETTING_RFS__SETTINGS:
			getSettings().clear();
			return;
		case EConfML2Package.ESETTING_RFS__RFS:
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
		case EConfML2Package.ESETTING_RFS__SETTINGS:
			return settings != null && !settings.isEmpty();
		case EConfML2Package.ESETTING_RFS__RFS:
			return RFS_EDEFAULT == null ? rfs != null : !RFS_EDEFAULT
					.equals(rfs);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ESettingRfsContainer.class) {
			switch (derivedFeatureID) {
			case EConfML2Package.ESETTING_RFS__SETTINGS:
				return EConfML2Package.ESETTING_RFS_CONTAINER__SETTINGS;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ESettingRfsContainer.class) {
			switch (baseFeatureID) {
			case EConfML2Package.ESETTING_RFS_CONTAINER__SETTINGS:
				return EConfML2Package.ESETTING_RFS__SETTINGS;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (rfs: ");
		result.append(rfs);
		result.append(')');
		return result.toString();
	}

} //ESettingRfsImpl
