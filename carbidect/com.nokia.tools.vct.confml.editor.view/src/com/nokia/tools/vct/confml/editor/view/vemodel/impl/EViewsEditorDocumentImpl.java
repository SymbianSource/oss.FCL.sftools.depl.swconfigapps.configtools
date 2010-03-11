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
 * Description: This file is part of com.nokia.tools.vct.confml.editor.view component.
 */

package com.nokia.tools.vct.confml.editor.view.vemodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.nokia.tools.vct.confml.editor.view.vemodel.EFeature;
import com.nokia.tools.vct.confml.editor.view.vemodel.EView;
import com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage;
import com.nokia.tools.vct.confml.editor.view.vemodel.EViewsEditorDocument;
import java.util.Collection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EDocument Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewsEditorDocumentImpl#getViews <em>Views</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewsEditorDocumentImpl#getUseCount <em>Use Count</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewsEditorDocumentImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewsEditorDocumentImpl#getAllViews <em>All Views</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EViewsEditorDocumentImpl extends EObjectImpl implements EViewsEditorDocument {
	/**
	 * The cached value of the '{@link #getViews() <em>Views</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViews()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, EView> views;

	/**
	 * The default value of the '{@link #getUseCount() <em>Use Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUseCount()
	 * @generated
	 * @ordered
	 */
	protected static final int USE_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getUseCount() <em>Use Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUseCount()
	 * @generated
	 * @ordered
	 */
	protected int useCount = USE_COUNT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, EFeature> features;

	/**
	 * The cached value of the '{@link #getAllViews() <em>All Views</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllViews()
	 * @generated
	 * @ordered
	 */
	protected EList<EView> allViews;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EViewsEditorDocumentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EViewEditorPackage.Literals.EVIEWS_EDITOR_DOCUMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, EView> getViews() {
		if (views == null) {
			views = new EcoreEMap<String,EView>(EViewEditorPackage.Literals.EVIEW_ENTRY, EViewEntryImpl.class, this, EViewEditorPackage.EVIEWS_EDITOR_DOCUMENT__VIEWS);
		}
		return views;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getUseCount() {
		return useCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUseCount(int newUseCount) {
		int oldUseCount = useCount;
		useCount = newUseCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EViewEditorPackage.EVIEWS_EDITOR_DOCUMENT__USE_COUNT, oldUseCount, useCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, EFeature> getFeatures() {
		if (features == null) {
			features = new EcoreEMap<String,EFeature>(EViewEditorPackage.Literals.EFEATURE_ENTRY, EFeatureEntryImpl.class, this, EViewEditorPackage.EVIEWS_EDITOR_DOCUMENT__FEATURES);
		}
		return features;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EView> getAllViews() {
		if (allViews == null) {
			allViews = new EObjectContainmentEList<EView>(EView.class, this, EViewEditorPackage.EVIEWS_EDITOR_DOCUMENT__ALL_VIEWS);
		}
		return allViews;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EViewEditorPackage.EVIEWS_EDITOR_DOCUMENT__VIEWS:
				return ((InternalEList<?>)getViews()).basicRemove(otherEnd, msgs);
			case EViewEditorPackage.EVIEWS_EDITOR_DOCUMENT__FEATURES:
				return ((InternalEList<?>)getFeatures()).basicRemove(otherEnd, msgs);
			case EViewEditorPackage.EVIEWS_EDITOR_DOCUMENT__ALL_VIEWS:
				return ((InternalEList<?>)getAllViews()).basicRemove(otherEnd, msgs);
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
			case EViewEditorPackage.EVIEWS_EDITOR_DOCUMENT__VIEWS:
				if (coreType) return getViews();
				else return getViews().map();
			case EViewEditorPackage.EVIEWS_EDITOR_DOCUMENT__USE_COUNT:
				return new Integer(getUseCount());
			case EViewEditorPackage.EVIEWS_EDITOR_DOCUMENT__FEATURES:
				if (coreType) return getFeatures();
				else return getFeatures().map();
			case EViewEditorPackage.EVIEWS_EDITOR_DOCUMENT__ALL_VIEWS:
				return getAllViews();
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
			case EViewEditorPackage.EVIEWS_EDITOR_DOCUMENT__VIEWS:
				((EStructuralFeature.Setting)getViews()).set(newValue);
				return;
			case EViewEditorPackage.EVIEWS_EDITOR_DOCUMENT__USE_COUNT:
				setUseCount(((Integer)newValue).intValue());
				return;
			case EViewEditorPackage.EVIEWS_EDITOR_DOCUMENT__FEATURES:
				((EStructuralFeature.Setting)getFeatures()).set(newValue);
				return;
			case EViewEditorPackage.EVIEWS_EDITOR_DOCUMENT__ALL_VIEWS:
				getAllViews().clear();
				getAllViews().addAll((Collection<? extends EView>)newValue);
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
			case EViewEditorPackage.EVIEWS_EDITOR_DOCUMENT__VIEWS:
				getViews().clear();
				return;
			case EViewEditorPackage.EVIEWS_EDITOR_DOCUMENT__USE_COUNT:
				setUseCount(USE_COUNT_EDEFAULT);
				return;
			case EViewEditorPackage.EVIEWS_EDITOR_DOCUMENT__FEATURES:
				getFeatures().clear();
				return;
			case EViewEditorPackage.EVIEWS_EDITOR_DOCUMENT__ALL_VIEWS:
				getAllViews().clear();
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
			case EViewEditorPackage.EVIEWS_EDITOR_DOCUMENT__VIEWS:
				return views != null && !views.isEmpty();
			case EViewEditorPackage.EVIEWS_EDITOR_DOCUMENT__USE_COUNT:
				return useCount != USE_COUNT_EDEFAULT;
			case EViewEditorPackage.EVIEWS_EDITOR_DOCUMENT__FEATURES:
				return features != null && !features.isEmpty();
			case EViewEditorPackage.EVIEWS_EDITOR_DOCUMENT__ALL_VIEWS:
				return allViews != null && !allViews.isEmpty();
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
		result.append(" (useCount: ");
		result.append(useCount);
		result.append(')');
		return result.toString();
	}

} //EDocumentRootImpl
