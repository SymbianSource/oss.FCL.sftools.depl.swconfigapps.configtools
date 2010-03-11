/*
* Copyright (c) 2007 Nokia Corporation and/or its subsidiary(-ies). 
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
package com.nokia.tools.s60ct.model.confml.impl;

import com.nokia.tools.s60ct.model.confml.ConfmlPackage;
import com.nokia.tools.s60ct.model.confml.EFeature;
import com.nokia.tools.s60ct.model.confml.EGroup;
import com.nokia.tools.s60ct.model.confml.EValueEditorDocument;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EValue Editor Document</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.EValueEditorDocumentImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.EValueEditorDocumentImpl#getGroups <em>Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EValueEditorDocumentImpl extends EObjectImpl implements EValueEditorDocument {
	/**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<EFeature> features;

	/**
	 * The cached value of the '{@link #getGroups() <em>Groups</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<EGroup> groups;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EValueEditorDocumentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfmlPackage.Literals.EVALUE_EDITOR_DOCUMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @NOT generated
	 */
	public EList<EFeature> getFeatures() {
		
		if (getGroups().isEmpty())
		{
			if (features == null) {
				features = new EObjectResolvingEList<EFeature>(EFeature.class, this, ConfmlPackage.EVALUE_EDITOR_DOCUMENT__FEATURES);
			}
			return features;
		}
		else
		{
			EList<EFeature> allFeatures = new BasicEList<EFeature>();
			for (EGroup groups : getGroups())
			{
				allFeatures.addAll(groups.getFeatures());
			}
			return allFeatures;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EGroup> getGroups() {
		if (groups == null) {
			groups = new EObjectResolvingEList<EGroup>(EGroup.class, this, ConfmlPackage.EVALUE_EDITOR_DOCUMENT__GROUPS);
		}
		return groups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfmlPackage.EVALUE_EDITOR_DOCUMENT__FEATURES:
				return getFeatures();
			case ConfmlPackage.EVALUE_EDITOR_DOCUMENT__GROUPS:
				return getGroups();
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
			case ConfmlPackage.EVALUE_EDITOR_DOCUMENT__FEATURES:
				getFeatures().clear();
				getFeatures().addAll((Collection<? extends EFeature>)newValue);
				return;
			case ConfmlPackage.EVALUE_EDITOR_DOCUMENT__GROUPS:
				getGroups().clear();
				getGroups().addAll((Collection<? extends EGroup>)newValue);
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
			case ConfmlPackage.EVALUE_EDITOR_DOCUMENT__FEATURES:
				getFeatures().clear();
				return;
			case ConfmlPackage.EVALUE_EDITOR_DOCUMENT__GROUPS:
				getGroups().clear();
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
			case ConfmlPackage.EVALUE_EDITOR_DOCUMENT__FEATURES:
				return features != null && !features.isEmpty();
			case ConfmlPackage.EVALUE_EDITOR_DOCUMENT__GROUPS:
				return groups != null && !groups.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EValueEditorDocumentImpl
