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
import com.nokia.tools.carbide.ct.confml.model.confml1.ESettingData;
import com.nokia.tools.carbide.ct.confml.model.confml1.ESettingDataContainer;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ESetting Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml1.impl.ESettingDataImpl#getSettings <em>Settings</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml1.impl.ESettingDataImpl#getTemplate <em>Template</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml1.impl.ESettingDataImpl#getExtensionPolicy <em>Extension Policy</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml1.impl.ESettingDataImpl#getValue <em>Value</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml1.impl.ESettingDataImpl#getText <em>Text</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ESettingDataImpl extends ERefNamedElementImpl implements
		ESettingData {
	/**
	 * The cached value of the '{@link #getSettings() <em>Settings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSettings()
	 * @generated
	 * @ordered
	 */
	protected EList<ESettingData> settings;

	/**
	 * The default value of the '{@link #getTemplate() <em>Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplate()
	 * @generated
	 * @ordered
	 */
	protected static final String TEMPLATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTemplate() <em>Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplate()
	 * @generated
	 * @ordered
	 */
	protected String template = TEMPLATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getExtensionPolicy() <em>Extension Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensionPolicy()
	 * @generated
	 * @ordered
	 */
	protected static final String EXTENSION_POLICY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExtensionPolicy() <em>Extension Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensionPolicy()
	 * @generated
	 * @ordered
	 */
	protected String extensionPolicy = EXTENSION_POLICY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap value;

	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ESettingDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EConfML1Package.Literals.ESETTING_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ESettingData> getSettings() {
		if (settings == null) {
			settings = new EObjectContainmentEList<ESettingData>(
					ESettingData.class, this,
					EConfML1Package.ESETTING_DATA__SETTINGS);
		}
		return settings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTemplate() {
		return template;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemplate(String newTemplate) {
		String oldTemplate = template;
		template = newTemplate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					EConfML1Package.ESETTING_DATA__TEMPLATE, oldTemplate,
					template));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExtensionPolicy() {
		return extensionPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtensionPolicy(String newExtensionPolicy) {
		String oldExtensionPolicy = extensionPolicy;
		extensionPolicy = newExtensionPolicy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					EConfML1Package.ESETTING_DATA__EXTENSION_POLICY,
					oldExtensionPolicy, extensionPolicy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getValue() {
		if (value == null) {
			value = new BasicFeatureMap(this,
					EConfML1Package.ESETTING_DATA__VALUE);
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText() {
		return (String) getValue().get(
				EConfML1Package.Literals.ESETTING_DATA__TEXT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setText(String newText) {
		((FeatureMap.Internal) getValue()).set(
				EConfML1Package.Literals.ESETTING_DATA__TEXT, newText);
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
		case EConfML1Package.ESETTING_DATA__SETTINGS:
			return ((InternalEList<?>) getSettings()).basicRemove(otherEnd,
					msgs);
		case EConfML1Package.ESETTING_DATA__VALUE:
			return ((InternalEList<?>) getValue()).basicRemove(otherEnd, msgs);
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
		case EConfML1Package.ESETTING_DATA__SETTINGS:
			return getSettings();
		case EConfML1Package.ESETTING_DATA__TEMPLATE:
			return getTemplate();
		case EConfML1Package.ESETTING_DATA__EXTENSION_POLICY:
			return getExtensionPolicy();
		case EConfML1Package.ESETTING_DATA__VALUE:
			if (coreType)
				return getValue();
			return ((FeatureMap.Internal) getValue()).getWrapper();
		case EConfML1Package.ESETTING_DATA__TEXT:
			return getText();
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
		case EConfML1Package.ESETTING_DATA__SETTINGS:
			getSettings().clear();
			getSettings().addAll((Collection<? extends ESettingData>) newValue);
			return;
		case EConfML1Package.ESETTING_DATA__TEMPLATE:
			setTemplate((String) newValue);
			return;
		case EConfML1Package.ESETTING_DATA__EXTENSION_POLICY:
			setExtensionPolicy((String) newValue);
			return;
		case EConfML1Package.ESETTING_DATA__VALUE:
			((FeatureMap.Internal) getValue()).set(newValue);
			return;
		case EConfML1Package.ESETTING_DATA__TEXT:
			setText((String) newValue);
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
		case EConfML1Package.ESETTING_DATA__SETTINGS:
			getSettings().clear();
			return;
		case EConfML1Package.ESETTING_DATA__TEMPLATE:
			setTemplate(TEMPLATE_EDEFAULT);
			return;
		case EConfML1Package.ESETTING_DATA__EXTENSION_POLICY:
			setExtensionPolicy(EXTENSION_POLICY_EDEFAULT);
			return;
		case EConfML1Package.ESETTING_DATA__VALUE:
			getValue().clear();
			return;
		case EConfML1Package.ESETTING_DATA__TEXT:
			setText(TEXT_EDEFAULT);
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
		case EConfML1Package.ESETTING_DATA__SETTINGS:
			return settings != null && !settings.isEmpty();
		case EConfML1Package.ESETTING_DATA__TEMPLATE:
			return TEMPLATE_EDEFAULT == null ? template != null
					: !TEMPLATE_EDEFAULT.equals(template);
		case EConfML1Package.ESETTING_DATA__EXTENSION_POLICY:
			return EXTENSION_POLICY_EDEFAULT == null ? extensionPolicy != null
					: !EXTENSION_POLICY_EDEFAULT.equals(extensionPolicy);
		case EConfML1Package.ESETTING_DATA__VALUE:
			return value != null && !value.isEmpty();
		case EConfML1Package.ESETTING_DATA__TEXT:
			return TEXT_EDEFAULT == null ? getText() != null : !TEXT_EDEFAULT
					.equals(getText());
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
		if (baseClass == ESettingDataContainer.class) {
			switch (derivedFeatureID) {
			case EConfML1Package.ESETTING_DATA__SETTINGS:
				return EConfML1Package.ESETTING_DATA_CONTAINER__SETTINGS;
			default:
				return -1;
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
		if (baseClass == ESettingDataContainer.class) {
			switch (baseFeatureID) {
			case EConfML1Package.ESETTING_DATA_CONTAINER__SETTINGS:
				return EConfML1Package.ESETTING_DATA__SETTINGS;
			default:
				return -1;
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
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (template: ");
		result.append(template);
		result.append(", extensionPolicy: ");
		result.append(extensionPolicy);
		result.append(", value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //ESettingDataImpl
