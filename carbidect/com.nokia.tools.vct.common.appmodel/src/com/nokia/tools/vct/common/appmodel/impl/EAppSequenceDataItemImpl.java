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
 * Description: This file is part of com.nokia.tools.vct.common.appmodel component.
 */

package com.nokia.tools.vct.common.appmodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.nokia.tools.vct.common.appmodel.EAppSequenceDataItem;
import com.nokia.tools.vct.common.appmodel.EAppSettingData;
import com.nokia.tools.vct.common.appmodel.EApplicationPackage;
import com.nokia.tools.vct.common.appmodel.ESourceLocator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EApp Sequence Data Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSequenceDataItemImpl#getSubSettings <em>Sub Settings</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSequenceDataItemImpl#getUri <em>Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EAppSequenceDataItemImpl extends EObjectImpl implements EAppSequenceDataItem {
	/**
	 * The cached value of the '{@link #getSubSettings() <em>Sub Settings</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubSettings()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, EAppSettingData> subSettings;

	/**
	 * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected EList<URI> uri;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EAppSequenceDataItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EApplicationPackage.Literals.EAPP_SEQUENCE_DATA_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, EAppSettingData> getSubSettings() {
		if (subSettings == null) {
			subSettings = new EcoreEMap<String,EAppSettingData>(EApplicationPackage.Literals.EAPP_SUB_SETTING_DATA_ENTRY, EAppSubSettingDataEntryImpl.class, this, EApplicationPackage.EAPP_SEQUENCE_DATA_ITEM__SUB_SETTINGS);
		}
		return subSettings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<URI> getUri() {
		if (uri == null) {
			uri = new EDataTypeUniqueEList<URI>(URI.class, this, EApplicationPackage.EAPP_SEQUENCE_DATA_ITEM__URI);
		}
		return uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EApplicationPackage.EAPP_SEQUENCE_DATA_ITEM__SUB_SETTINGS:
				return ((InternalEList<?>)getSubSettings()).basicRemove(otherEnd, msgs);
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
			case EApplicationPackage.EAPP_SEQUENCE_DATA_ITEM__SUB_SETTINGS:
				if (coreType) return getSubSettings();
				else return getSubSettings().map();
			case EApplicationPackage.EAPP_SEQUENCE_DATA_ITEM__URI:
				return getUri();
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
			case EApplicationPackage.EAPP_SEQUENCE_DATA_ITEM__SUB_SETTINGS:
				((EStructuralFeature.Setting)getSubSettings()).set(newValue);
				return;
			case EApplicationPackage.EAPP_SEQUENCE_DATA_ITEM__URI:
				getUri().clear();
				getUri().addAll((Collection<? extends URI>)newValue);
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
			case EApplicationPackage.EAPP_SEQUENCE_DATA_ITEM__SUB_SETTINGS:
				getSubSettings().clear();
				return;
			case EApplicationPackage.EAPP_SEQUENCE_DATA_ITEM__URI:
				getUri().clear();
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
			case EApplicationPackage.EAPP_SEQUENCE_DATA_ITEM__SUB_SETTINGS:
				return subSettings != null && !subSettings.isEmpty();
			case EApplicationPackage.EAPP_SEQUENCE_DATA_ITEM__URI:
				return uri != null && !uri.isEmpty();
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
		if (baseClass == ESourceLocator.class) {
			switch (derivedFeatureID) {
				case EApplicationPackage.EAPP_SEQUENCE_DATA_ITEM__URI: return EApplicationPackage.ESOURCE_LOCATOR__URI;
				default: return -1;
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
		if (baseClass == ESourceLocator.class) {
			switch (baseFeatureID) {
				case EApplicationPackage.ESOURCE_LOCATOR__URI: return EApplicationPackage.EAPP_SEQUENCE_DATA_ITEM__URI;
				default: return -1;
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
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (uri: ");
		result.append(uri);
		result.append(')');
		return result.toString();
	}

} //EAppSequenceDataItemImpl
