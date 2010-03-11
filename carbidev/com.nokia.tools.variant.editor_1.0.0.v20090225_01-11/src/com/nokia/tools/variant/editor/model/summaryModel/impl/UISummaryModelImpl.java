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

package com.nokia.tools.variant.editor.model.summaryModel.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import com.nokia.tools.variant.editor.model.summaryModel.SummaryModelPackage;
import com.nokia.tools.variant.editor.model.summaryModel.UISummaryGroup;
import com.nokia.tools.variant.editor.model.summaryModel.UISummaryModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UI Summary Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.editor.model.summaryModel.impl.UISummaryModelImpl#getUiGroups <em>Ui Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UISummaryModelImpl extends EObjectImpl implements UISummaryModel {
	/**
	 * The cached value of the '{@link #getUiGroups() <em>Ui Groups</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUiGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<UISummaryGroup> uiGroups;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UISummaryModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SummaryModelPackage.Literals.UI_SUMMARY_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UISummaryGroup> getUiGroups() {
		if (uiGroups == null) {
			uiGroups = new EObjectResolvingEList<UISummaryGroup>(UISummaryGroup.class, this, SummaryModelPackage.UI_SUMMARY_MODEL__UI_GROUPS);
		}
		return uiGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SummaryModelPackage.UI_SUMMARY_MODEL__UI_GROUPS:
				return getUiGroups();
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
			case SummaryModelPackage.UI_SUMMARY_MODEL__UI_GROUPS:
				getUiGroups().clear();
				getUiGroups().addAll((Collection<? extends UISummaryGroup>)newValue);
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
			case SummaryModelPackage.UI_SUMMARY_MODEL__UI_GROUPS:
				getUiGroups().clear();
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
			case SummaryModelPackage.UI_SUMMARY_MODEL__UI_GROUPS:
				return uiGroups != null && !uiGroups.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //UISummaryModelImpl
