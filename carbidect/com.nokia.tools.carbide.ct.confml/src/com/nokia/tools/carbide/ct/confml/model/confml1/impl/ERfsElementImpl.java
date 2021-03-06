/**
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
 * $Id$
 */
package com.nokia.tools.carbide.ct.confml.model.confml1.impl;

import com.nokia.tools.carbide.ct.confml.model.confml1.EConfML1Package;
import com.nokia.tools.carbide.ct.confml.model.confml1.EFeatureRfs;
import com.nokia.tools.carbide.ct.confml.model.confml1.ERfsElement;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ERfs Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml1.impl.ERfsElementImpl#getRfs <em>Rfs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ERfsElementImpl extends EObjectImpl implements ERfsElement {
	/**
	 * The cached value of the '{@link #getRfs() <em>Rfs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRfs()
	 * @generated
	 * @ordered
	 */
	protected EList<EFeatureRfs> rfs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ERfsElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EConfML1Package.Literals.ERFS_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EFeatureRfs> getRfs() {
		if (rfs == null) {
			rfs = new EObjectContainmentEList<EFeatureRfs>(EFeatureRfs.class,
					this, EConfML1Package.ERFS_ELEMENT__RFS);
		}
		return rfs;
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
		case EConfML1Package.ERFS_ELEMENT__RFS:
			return ((InternalEList<?>) getRfs()).basicRemove(otherEnd, msgs);
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
		case EConfML1Package.ERFS_ELEMENT__RFS:
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
		case EConfML1Package.ERFS_ELEMENT__RFS:
			getRfs().clear();
			getRfs().addAll((Collection<? extends EFeatureRfs>) newValue);
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
		case EConfML1Package.ERFS_ELEMENT__RFS:
			getRfs().clear();
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
		case EConfML1Package.ERFS_ELEMENT__RFS:
			return rfs != null && !rfs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ERfsElementImpl
