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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.nokia.tools.s60ct.model.confml.ConfmlPackage;
import com.nokia.tools.s60ct.model.confml.ESequenceValueItem;
import com.nokia.tools.s60ct.model.confml.ESettingValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ESequence Value Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESequenceValueItemImpl#getSubSettings <em>Sub Settings</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESequenceValueItemImpl#isEditable <em>Editable</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESequenceValueItemImpl#getFrameLocationUri <em>Frame Location Uri</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESequenceValueItemImpl#isRemoved <em>Removed</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ESequenceValueItemImpl extends EObjectImpl implements ESequenceValueItem {
	/**
	 * The cached value of the '{@link #getSubSettings() <em>Sub Settings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubSettings()
	 * @generated
	 * @ordered
	 */
	protected EList<ESettingValue> subSettings;

	/**
	 * The default value of the '{@link #isEditable() <em>Editable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEditable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EDITABLE_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isEditable() <em>Editable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEditable()
	 * @generated
	 * @ordered
	 */
	protected boolean editable = EDITABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFrameLocationUri() <em>Frame Location Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrameLocationUri()
	 * @generated
	 * @ordered
	 */
	protected static final URI FRAME_LOCATION_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFrameLocationUri() <em>Frame Location Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrameLocationUri()
	 * @generated
	 * @ordered
	 */
	protected URI frameLocationUri = FRAME_LOCATION_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #isRemoved() <em>Removed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRemoved()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REMOVED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRemoved() <em>Removed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRemoved()
	 * @generated
	 * @ordered
	 */
	protected boolean removed = REMOVED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ESequenceValueItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfmlPackage.Literals.ESEQUENCE_VALUE_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ESettingValue> getSubSettings() {
		if (subSettings == null) {
			subSettings = new EObjectContainmentEList<ESettingValue>(ESettingValue.class, this, ConfmlPackage.ESEQUENCE_VALUE_ITEM__SUB_SETTINGS);
		}
		return subSettings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEditable() {
		return editable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEditable(boolean newEditable) {
		boolean oldEditable = editable;
		editable = newEditable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESEQUENCE_VALUE_ITEM__EDITABLE, oldEditable, editable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URI getFrameLocationUri() {
		return frameLocationUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrameLocationUri(URI newFrameLocationUri) {
		URI oldFrameLocationUri = frameLocationUri;
		frameLocationUri = newFrameLocationUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESEQUENCE_VALUE_ITEM__FRAME_LOCATION_URI, oldFrameLocationUri, frameLocationUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRemoved() {
		return removed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemoved(boolean newRemoved) {
		boolean oldRemoved = removed;
		removed = newRemoved;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESEQUENCE_VALUE_ITEM__REMOVED, oldRemoved, removed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfmlPackage.ESEQUENCE_VALUE_ITEM__SUB_SETTINGS:
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
			case ConfmlPackage.ESEQUENCE_VALUE_ITEM__SUB_SETTINGS:
				return getSubSettings();
			case ConfmlPackage.ESEQUENCE_VALUE_ITEM__EDITABLE:
				return isEditable() ? Boolean.TRUE : Boolean.FALSE;
			case ConfmlPackage.ESEQUENCE_VALUE_ITEM__FRAME_LOCATION_URI:
				return getFrameLocationUri();
			case ConfmlPackage.ESEQUENCE_VALUE_ITEM__REMOVED:
				return isRemoved() ? Boolean.TRUE : Boolean.FALSE;
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
			case ConfmlPackage.ESEQUENCE_VALUE_ITEM__SUB_SETTINGS:
				getSubSettings().clear();
				getSubSettings().addAll((Collection<? extends ESettingValue>)newValue);
				return;
			case ConfmlPackage.ESEQUENCE_VALUE_ITEM__EDITABLE:
				setEditable(((Boolean)newValue).booleanValue());
				return;
			case ConfmlPackage.ESEQUENCE_VALUE_ITEM__FRAME_LOCATION_URI:
				setFrameLocationUri((URI)newValue);
				return;
			case ConfmlPackage.ESEQUENCE_VALUE_ITEM__REMOVED:
				setRemoved(((Boolean)newValue).booleanValue());
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
			case ConfmlPackage.ESEQUENCE_VALUE_ITEM__SUB_SETTINGS:
				getSubSettings().clear();
				return;
			case ConfmlPackage.ESEQUENCE_VALUE_ITEM__EDITABLE:
				setEditable(EDITABLE_EDEFAULT);
				return;
			case ConfmlPackage.ESEQUENCE_VALUE_ITEM__FRAME_LOCATION_URI:
				setFrameLocationUri(FRAME_LOCATION_URI_EDEFAULT);
				return;
			case ConfmlPackage.ESEQUENCE_VALUE_ITEM__REMOVED:
				setRemoved(REMOVED_EDEFAULT);
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
			case ConfmlPackage.ESEQUENCE_VALUE_ITEM__SUB_SETTINGS:
				return subSettings != null && !subSettings.isEmpty();
			case ConfmlPackage.ESEQUENCE_VALUE_ITEM__EDITABLE:
				return editable != EDITABLE_EDEFAULT;
			case ConfmlPackage.ESEQUENCE_VALUE_ITEM__FRAME_LOCATION_URI:
				return FRAME_LOCATION_URI_EDEFAULT == null ? frameLocationUri != null : !FRAME_LOCATION_URI_EDEFAULT.equals(frameLocationUri);
			case ConfmlPackage.ESEQUENCE_VALUE_ITEM__REMOVED:
				return removed != REMOVED_EDEFAULT;
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
		result.append(" (editable: ");
		result.append(editable);
		result.append(", frameLocationUri: ");
		result.append(frameLocationUri);
		result.append(", removed: ");
		result.append(removed);
		result.append(')');
		return result.toString();
	}

} //ESequenceValueItemImpl
