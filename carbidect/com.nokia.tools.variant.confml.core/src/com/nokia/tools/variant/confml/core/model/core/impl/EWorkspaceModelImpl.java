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

package com.nokia.tools.variant.confml.core.model.core.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.nokia.tools.variant.confml.core.model.core.EConfmlRootPackage;
import com.nokia.tools.variant.confml.core.model.core.EWorkspaceModel;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EWorkspace Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.core.impl.EWorkspaceModelImpl#getProjectMap <em>Project Map</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EWorkspaceModelImpl extends EObjectImpl implements EWorkspaceModel {
	/**
	 * The cached value of the '{@link #getProjectMap() <em>Project Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, EConfigurationProject> projectMap;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EWorkspaceModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EConfmlRootPackage.Literals.EWORKSPACE_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, EConfigurationProject> getProjectMap() {
		if (projectMap == null) {
			projectMap = new EcoreEMap<String,EConfigurationProject>(EConfmlRootPackage.Literals.EPROJECT_ENTRY, EProjectEntryImpl.class, this, EConfmlRootPackage.EWORKSPACE_MODEL__PROJECT_MAP);
		}
		return projectMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EConfmlRootPackage.EWORKSPACE_MODEL__PROJECT_MAP:
				return ((InternalEList<?>)getProjectMap()).basicRemove(otherEnd, msgs);
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
			case EConfmlRootPackage.EWORKSPACE_MODEL__PROJECT_MAP:
				if (coreType) return getProjectMap();
				else return getProjectMap().map();
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
			case EConfmlRootPackage.EWORKSPACE_MODEL__PROJECT_MAP:
				((EStructuralFeature.Setting)getProjectMap()).set(newValue);
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
			case EConfmlRootPackage.EWORKSPACE_MODEL__PROJECT_MAP:
				getProjectMap().clear();
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
			case EConfmlRootPackage.EWORKSPACE_MODEL__PROJECT_MAP:
				return projectMap != null && !projectMap.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EWorkspaceModelImpl
