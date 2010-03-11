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

package com.nokia.tools.variant.editor.model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.nokia.tools.variant.editor.model.SortingOrder;
import com.nokia.tools.variant.editor.model.UIGroup;
import com.nokia.tools.variant.editor.model.UIModelPackage;
import com.nokia.tools.variant.editor.model.UISetting;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UI Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.editor.model.impl.UIGroupImpl#getUiSettings <em>Ui Settings</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.model.impl.UIGroupImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.model.impl.UIGroupImpl#getSortingOrder <em>Sorting Order</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.model.impl.UIGroupImpl#getModel <em>Model</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.model.impl.UIGroupImpl#getUiGroups <em>Ui Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UIGroupImpl extends EObjectImpl implements UIGroup {
	/**
	 * The cached value of the '{@link #getUiSettings() <em>Ui Settings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUiSettings()
	 * @generated
	 * @ordered
	 */
	protected EList<UISetting> uiSettings;

	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_EDEFAULT;
	/**
	 * The default value of the '{@link #getSortingOrder() <em>Sorting Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSortingOrder()
	 * @generated
	 * @ordered
	 */
	protected static final SortingOrder SORTING_ORDER_EDEFAULT = SortingOrder.ASCENDING;
	/**
	 * The cached value of the '{@link #getSortingOrder() <em>Sorting Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSortingOrder()
	 * @generated
	 * @ordered
	 */
	protected SortingOrder sortingOrder = SORTING_ORDER_EDEFAULT;

	/**
	 * The default value of the '{@link #getModel() <em>Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
	protected static final Object MODEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModel() <em>Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
	protected Object model = MODEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUiGroups() <em>Ui Groups</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUiGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<UIGroup> uiGroups;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UIGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UIModelPackage.Literals.UI_GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UISetting> getUiSettings() {
		if (uiSettings == null) {
			uiSettings = new EObjectContainmentEList<UISetting>(UISetting.class, this, UIModelPackage.UI_GROUP__UI_SETTINGS);
		}
		return uiSettings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitle(String newTitle) {
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UIModelPackage.UI_GROUP__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SortingOrder getSortingOrder() {
		return sortingOrder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSortingOrder(SortingOrder newSortingOrder) {
		SortingOrder oldSortingOrder = sortingOrder;
		sortingOrder = newSortingOrder == null ? SORTING_ORDER_EDEFAULT : newSortingOrder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UIModelPackage.UI_GROUP__SORTING_ORDER, oldSortingOrder, sortingOrder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getModel() {
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModel(Object newModel) {
		Object oldModel = model;
		model = newModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UIModelPackage.UI_GROUP__MODEL, oldModel, model));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UIGroup> getUiGroups() {
		if (uiGroups == null) {
			uiGroups = new EObjectContainmentEList<UIGroup>(UIGroup.class, this, UIModelPackage.UI_GROUP__UI_GROUPS);
		}
		return uiGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UIModelPackage.UI_GROUP__UI_SETTINGS:
				return ((InternalEList<?>)getUiSettings()).basicRemove(otherEnd, msgs);
			case UIModelPackage.UI_GROUP__UI_GROUPS:
				return ((InternalEList<?>)getUiGroups()).basicRemove(otherEnd, msgs);
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
			case UIModelPackage.UI_GROUP__UI_SETTINGS:
				return getUiSettings();
			case UIModelPackage.UI_GROUP__TITLE:
				return getTitle();
			case UIModelPackage.UI_GROUP__SORTING_ORDER:
				return getSortingOrder();
			case UIModelPackage.UI_GROUP__MODEL:
				return getModel();
			case UIModelPackage.UI_GROUP__UI_GROUPS:
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
			case UIModelPackage.UI_GROUP__UI_SETTINGS:
				getUiSettings().clear();
				getUiSettings().addAll((Collection<? extends UISetting>)newValue);
				return;
			case UIModelPackage.UI_GROUP__TITLE:
				setTitle((String)newValue);
				return;
			case UIModelPackage.UI_GROUP__SORTING_ORDER:
				setSortingOrder((SortingOrder)newValue);
				return;
			case UIModelPackage.UI_GROUP__MODEL:
				setModel(newValue);
				return;
			case UIModelPackage.UI_GROUP__UI_GROUPS:
				getUiGroups().clear();
				getUiGroups().addAll((Collection<? extends UIGroup>)newValue);
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
			case UIModelPackage.UI_GROUP__UI_SETTINGS:
				getUiSettings().clear();
				return;
			case UIModelPackage.UI_GROUP__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case UIModelPackage.UI_GROUP__SORTING_ORDER:
				setSortingOrder(SORTING_ORDER_EDEFAULT);
				return;
			case UIModelPackage.UI_GROUP__MODEL:
				setModel(MODEL_EDEFAULT);
				return;
			case UIModelPackage.UI_GROUP__UI_GROUPS:
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
			case UIModelPackage.UI_GROUP__UI_SETTINGS:
				return uiSettings != null && !uiSettings.isEmpty();
			case UIModelPackage.UI_GROUP__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case UIModelPackage.UI_GROUP__SORTING_ORDER:
				return sortingOrder != SORTING_ORDER_EDEFAULT;
			case UIModelPackage.UI_GROUP__MODEL:
				return MODEL_EDEFAULT == null ? model != null : !MODEL_EDEFAULT.equals(model);
			case UIModelPackage.UI_GROUP__UI_GROUPS:
				return uiGroups != null && !uiGroups.isEmpty();
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
		result.append(" (title: ");
		result.append(title);
		result.append(", sortingOrder: ");
		result.append(sortingOrder);
		result.append(", model: ");
		result.append(model);
		result.append(')');
		return result.toString();
	}

} //UIGroupImpl
