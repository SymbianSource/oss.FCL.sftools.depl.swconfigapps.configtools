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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.nokia.tools.s60ct.model.confml.ConfmlPackage;
import com.nokia.tools.s60ct.model.confml.EExtensionPolicy;
import com.nokia.tools.s60ct.model.confml.ESequenceValue;
import com.nokia.tools.s60ct.model.confml.ESequenceValueItem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ESequence Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESequenceValueImpl#getTemplate <em>Template</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESequenceValueImpl#getItems <em>Items</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESequenceValueImpl#getExtensionPolicy <em>Extension Policy</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ESequenceValueImpl extends ESettingValueImpl implements ESequenceValue {
	/**
	 * The cached value of the '{@link #getTemplate() <em>Template</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplate()
	 * @generated
	 * @ordered
	 */
	protected ESequenceValueItem template;

	/**
	 * The cached value of the '{@link #getItems() <em>Items</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItems()
	 * @generated
	 * @ordered
	 */
	protected EList<ESequenceValueItem> items;

	/**
	 * The default value of the '{@link #getExtensionPolicy() <em>Extension Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensionPolicy()
	 * @generated
	 * @ordered
	 */
	protected static final EExtensionPolicy EXTENSION_POLICY_EDEFAULT = EExtensionPolicy.REPLACE;

	/**
	 * The cached value of the '{@link #getExtensionPolicy() <em>Extension Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensionPolicy()
	 * @generated
	 * @ordered
	 */
	protected EExtensionPolicy extensionPolicy = EXTENSION_POLICY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ESequenceValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfmlPackage.Literals.ESEQUENCE_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESequenceValueItem getTemplate() {
		return template;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTemplate(ESequenceValueItem newTemplate, NotificationChain msgs) {
		ESequenceValueItem oldTemplate = template;
		template = newTemplate;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESEQUENCE_VALUE__TEMPLATE, oldTemplate, newTemplate);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemplate(ESequenceValueItem newTemplate) {
		if (newTemplate != template) {
			NotificationChain msgs = null;
			if (template != null)
				msgs = ((InternalEObject)template).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfmlPackage.ESEQUENCE_VALUE__TEMPLATE, null, msgs);
			if (newTemplate != null)
				msgs = ((InternalEObject)newTemplate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfmlPackage.ESEQUENCE_VALUE__TEMPLATE, null, msgs);
			msgs = basicSetTemplate(newTemplate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESEQUENCE_VALUE__TEMPLATE, newTemplate, newTemplate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ESequenceValueItem> getItems() {
		if (items == null) {
			items = new EObjectContainmentEList<ESequenceValueItem>(ESequenceValueItem.class, this, ConfmlPackage.ESEQUENCE_VALUE__ITEMS);
		}
		return items;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EExtensionPolicy getExtensionPolicy() {
		return extensionPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtensionPolicy(EExtensionPolicy newExtensionPolicy) {
		EExtensionPolicy oldExtensionPolicy = extensionPolicy;
		extensionPolicy = newExtensionPolicy == null ? EXTENSION_POLICY_EDEFAULT : newExtensionPolicy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESEQUENCE_VALUE__EXTENSION_POLICY, oldExtensionPolicy, extensionPolicy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfmlPackage.ESEQUENCE_VALUE__TEMPLATE:
				return basicSetTemplate(null, msgs);
			case ConfmlPackage.ESEQUENCE_VALUE__ITEMS:
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
			case ConfmlPackage.ESEQUENCE_VALUE__TEMPLATE:
				return getTemplate();
			case ConfmlPackage.ESEQUENCE_VALUE__ITEMS:
				return getItems();
			case ConfmlPackage.ESEQUENCE_VALUE__EXTENSION_POLICY:
				return getExtensionPolicy();
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
			case ConfmlPackage.ESEQUENCE_VALUE__TEMPLATE:
				setTemplate((ESequenceValueItem)newValue);
				return;
			case ConfmlPackage.ESEQUENCE_VALUE__ITEMS:
				getItems().clear();
				getItems().addAll((Collection<? extends ESequenceValueItem>)newValue);
				return;
			case ConfmlPackage.ESEQUENCE_VALUE__EXTENSION_POLICY:
				setExtensionPolicy((EExtensionPolicy)newValue);
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
			case ConfmlPackage.ESEQUENCE_VALUE__TEMPLATE:
				setTemplate((ESequenceValueItem)null);
				return;
			case ConfmlPackage.ESEQUENCE_VALUE__ITEMS:
				getItems().clear();
				return;
			case ConfmlPackage.ESEQUENCE_VALUE__EXTENSION_POLICY:
				setExtensionPolicy(EXTENSION_POLICY_EDEFAULT);
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
			case ConfmlPackage.ESEQUENCE_VALUE__TEMPLATE:
				return template != null;
			case ConfmlPackage.ESEQUENCE_VALUE__ITEMS:
				return items != null && !items.isEmpty();
			case ConfmlPackage.ESEQUENCE_VALUE__EXTENSION_POLICY:
				return extensionPolicy != EXTENSION_POLICY_EDEFAULT;
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
		result.append(" (extensionPolicy: ");
		result.append(extensionPolicy);
		result.append(')');
		return result.toString();
	}

} //ESequenceValueImpl
