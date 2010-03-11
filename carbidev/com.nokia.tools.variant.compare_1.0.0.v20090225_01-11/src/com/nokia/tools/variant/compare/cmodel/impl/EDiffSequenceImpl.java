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
 * Description: This file is part of com.nokia.tools.variant.compare component.
 */

package com.nokia.tools.variant.compare.cmodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.nokia.tools.variant.compare.cmodel.ECompareModelPackage;
import com.nokia.tools.variant.compare.cmodel.EDiffSequence;
import com.nokia.tools.variant.compare.cmodel.EDiffSequenceItem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EDiff Sequence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.impl.EDiffSequenceImpl#getItemCount <em>Item Count</em>}</li>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.impl.EDiffSequenceImpl#getItems <em>Items</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EDiffSequenceImpl extends EDiffSettingImpl implements EDiffSequence {
	/**
	 * The default value of the '{@link #getItemCount() <em>Item Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItemCount()
	 * @generated
	 * @ordered
	 */
	protected static final int ITEM_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getItemCount() <em>Item Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItemCount()
	 * @generated
	 * @ordered
	 */
	protected int itemCount = ITEM_COUNT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getItems() <em>Items</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItems()
	 * @generated
	 * @ordered
	 */
	protected EList<EDiffSequenceItem> items;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EDiffSequenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ECompareModelPackage.Literals.EDIFF_SEQUENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getItemCount() {
		return itemCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setItemCount(int newItemCount) {
		int oldItemCount = itemCount;
		itemCount = newItemCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECompareModelPackage.EDIFF_SEQUENCE__ITEM_COUNT, oldItemCount, itemCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EDiffSequenceItem> getItems() {
		if (items == null) {
			items = new EObjectContainmentEList<EDiffSequenceItem>(EDiffSequenceItem.class, this, ECompareModelPackage.EDIFF_SEQUENCE__ITEMS);
		}
		return items;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ECompareModelPackage.EDIFF_SEQUENCE__ITEMS:
				return ((InternalEList<?>)getItems()).basicRemove(otherEnd, msgs);
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
			case ECompareModelPackage.EDIFF_SEQUENCE__ITEM_COUNT:
				return new Integer(getItemCount());
			case ECompareModelPackage.EDIFF_SEQUENCE__ITEMS:
				return getItems();
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
			case ECompareModelPackage.EDIFF_SEQUENCE__ITEM_COUNT:
				setItemCount(((Integer)newValue).intValue());
				return;
			case ECompareModelPackage.EDIFF_SEQUENCE__ITEMS:
				getItems().clear();
				getItems().addAll((Collection<? extends EDiffSequenceItem>)newValue);
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
			case ECompareModelPackage.EDIFF_SEQUENCE__ITEM_COUNT:
				setItemCount(ITEM_COUNT_EDEFAULT);
				return;
			case ECompareModelPackage.EDIFF_SEQUENCE__ITEMS:
				getItems().clear();
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
			case ECompareModelPackage.EDIFF_SEQUENCE__ITEM_COUNT:
				return itemCount != ITEM_COUNT_EDEFAULT;
			case ECompareModelPackage.EDIFF_SEQUENCE__ITEMS:
				return items != null && !items.isEmpty();
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
		result.append(" (itemCount: ");
		result.append(itemCount);
		result.append(')');
		return result.toString();
	}

} //EDiffSequenceImpl
