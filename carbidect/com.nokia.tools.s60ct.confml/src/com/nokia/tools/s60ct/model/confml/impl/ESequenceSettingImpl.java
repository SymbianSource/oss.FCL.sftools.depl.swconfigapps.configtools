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
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.nokia.tools.s60ct.model.confml.ConfmlPackage;
import com.nokia.tools.s60ct.model.confml.EItemSetting;
import com.nokia.tools.s60ct.model.confml.ESequenceSetting;
import com.nokia.tools.s60ct.model.confml.ESetting;
import com.nokia.tools.s60ct.model.confml.ESettingContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ESequence Setting</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESequenceSettingImpl#getSubTypes <em>Sub Types</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESequenceSettingImpl#getMinOccurs <em>Min Occurs</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESequenceSettingImpl#getMaxOccurs <em>Max Occurs</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESequenceSettingImpl#getItems <em>Items</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESequenceSettingImpl#getTemplate <em>Template</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESequenceSettingImpl#getMapKey <em>Map Key</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESequenceSettingImpl#getMapValue <em>Map Value</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESequenceSettingImpl#getVisibleSubSettings <em>Visible Sub Settings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ESequenceSettingImpl extends ESettingImpl implements ESequenceSetting {
	/**
	 * The cached value of the '{@link #getSubTypes() <em>Sub Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<ESetting> subTypes;

	/**
	 * The default value of the '{@link #getMinOccurs() <em>Min Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinOccurs()
	 * @generated
	 * @ordered
	 */
	protected static final Integer MIN_OCCURS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinOccurs() <em>Min Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinOccurs()
	 * @generated
	 * @ordered
	 */
	protected Integer minOccurs = MIN_OCCURS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxOccurs() <em>Max Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxOccurs()
	 * @generated
	 * @ordered
	 */
	protected static final Integer MAX_OCCURS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxOccurs() <em>Max Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxOccurs()
	 * @generated
	 * @ordered
	 */
	protected Integer maxOccurs = MAX_OCCURS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getItems() <em>Items</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItems()
	 * @generated
	 * @ordered
	 */
	protected EList<EItemSetting> items;

	/**
	 * The cached value of the '{@link #getTemplate() <em>Template</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplate()
	 * @generated
	 * @ordered
	 */
	protected EItemSetting template;

	/**
	 * The default value of the '{@link #getMapKey() <em>Map Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMapKey()
	 * @generated
	 * @ordered
	 */
	protected static final String MAP_KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMapKey() <em>Map Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMapKey()
	 * @generated
	 * @ordered
	 */
	protected String mapKey = MAP_KEY_EDEFAULT;

	/**
	 * The default value of the '{@link #getMapValue() <em>Map Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMapValue()
	 * @generated
	 * @ordered
	 */
	protected static final String MAP_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMapValue() <em>Map Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMapValue()
	 * @generated
	 * @ordered
	 */
	protected String mapValue = MAP_VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVisibleSubSettings() <em>Visible Sub Settings</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibleSubSettings()
	 * @generated
	 * @ordered
	 */
	protected EList<String> visibleSubSettings;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ESequenceSettingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfmlPackage.Literals.ESEQUENCE_SETTING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ESetting> getSubTypes() {
		if (subTypes == null) {
			subTypes = new EObjectContainmentEList<ESetting>(ESetting.class, this, ConfmlPackage.ESEQUENCE_SETTING__SUB_TYPES);
		}
		return subTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getMinOccurs() {
		return minOccurs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinOccurs(Integer newMinOccurs) {
		Integer oldMinOccurs = minOccurs;
		minOccurs = newMinOccurs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESEQUENCE_SETTING__MIN_OCCURS, oldMinOccurs, minOccurs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getMaxOccurs() {
		return maxOccurs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxOccurs(Integer newMaxOccurs) {
		Integer oldMaxOccurs = maxOccurs;
		maxOccurs = newMaxOccurs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESEQUENCE_SETTING__MAX_OCCURS, oldMaxOccurs, maxOccurs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EItemSetting> getItems() {
		if (items == null) {
			items = new EObjectContainmentEList<EItemSetting>(EItemSetting.class, this, ConfmlPackage.ESEQUENCE_SETTING__ITEMS);
		}
		return items;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EItemSetting getTemplate() {
		return template;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTemplate(EItemSetting newTemplate, NotificationChain msgs) {
		EItemSetting oldTemplate = template;
		template = newTemplate;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESEQUENCE_SETTING__TEMPLATE, oldTemplate, newTemplate);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemplate(EItemSetting newTemplate) {
		if (newTemplate != template) {
			NotificationChain msgs = null;
			if (template != null)
				msgs = ((InternalEObject)template).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfmlPackage.ESEQUENCE_SETTING__TEMPLATE, null, msgs);
			if (newTemplate != null)
				msgs = ((InternalEObject)newTemplate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfmlPackage.ESEQUENCE_SETTING__TEMPLATE, null, msgs);
			msgs = basicSetTemplate(newTemplate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESEQUENCE_SETTING__TEMPLATE, newTemplate, newTemplate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMapKey() {
		return mapKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMapKey(String newMapKey) {
		String oldMapKey = mapKey;
		mapKey = newMapKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESEQUENCE_SETTING__MAP_KEY, oldMapKey, mapKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMapValue() {
		return mapValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMapValue(String newMapValue) {
		String oldMapValue = mapValue;
		mapValue = newMapValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESEQUENCE_SETTING__MAP_VALUE, oldMapValue, mapValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getVisibleSubSettings() {
		if (visibleSubSettings == null) {
			visibleSubSettings = new EDataTypeUniqueEList<String>(String.class, this, ConfmlPackage.ESEQUENCE_SETTING__VISIBLE_SUB_SETTINGS);
		}
		return visibleSubSettings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfmlPackage.ESEQUENCE_SETTING__SUB_TYPES:
				return ((InternalEList<?>)getSubTypes()).basicRemove(otherEnd, msgs);
			case ConfmlPackage.ESEQUENCE_SETTING__ITEMS:
				return ((InternalEList<?>)getItems()).basicRemove(otherEnd, msgs);
			case ConfmlPackage.ESEQUENCE_SETTING__TEMPLATE:
				return basicSetTemplate(null, msgs);
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
			case ConfmlPackage.ESEQUENCE_SETTING__SUB_TYPES:
				return getSubTypes();
			case ConfmlPackage.ESEQUENCE_SETTING__MIN_OCCURS:
				return getMinOccurs();
			case ConfmlPackage.ESEQUENCE_SETTING__MAX_OCCURS:
				return getMaxOccurs();
			case ConfmlPackage.ESEQUENCE_SETTING__ITEMS:
				return getItems();
			case ConfmlPackage.ESEQUENCE_SETTING__TEMPLATE:
				return getTemplate();
			case ConfmlPackage.ESEQUENCE_SETTING__MAP_KEY:
				return getMapKey();
			case ConfmlPackage.ESEQUENCE_SETTING__MAP_VALUE:
				return getMapValue();
			case ConfmlPackage.ESEQUENCE_SETTING__VISIBLE_SUB_SETTINGS:
				return getVisibleSubSettings();
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
			case ConfmlPackage.ESEQUENCE_SETTING__SUB_TYPES:
				getSubTypes().clear();
				getSubTypes().addAll((Collection<? extends ESetting>)newValue);
				return;
			case ConfmlPackage.ESEQUENCE_SETTING__MIN_OCCURS:
				setMinOccurs((Integer)newValue);
				return;
			case ConfmlPackage.ESEQUENCE_SETTING__MAX_OCCURS:
				setMaxOccurs((Integer)newValue);
				return;
			case ConfmlPackage.ESEQUENCE_SETTING__ITEMS:
				getItems().clear();
				getItems().addAll((Collection<? extends EItemSetting>)newValue);
				return;
			case ConfmlPackage.ESEQUENCE_SETTING__TEMPLATE:
				setTemplate((EItemSetting)newValue);
				return;
			case ConfmlPackage.ESEQUENCE_SETTING__MAP_KEY:
				setMapKey((String)newValue);
				return;
			case ConfmlPackage.ESEQUENCE_SETTING__MAP_VALUE:
				setMapValue((String)newValue);
				return;
			case ConfmlPackage.ESEQUENCE_SETTING__VISIBLE_SUB_SETTINGS:
				getVisibleSubSettings().clear();
				getVisibleSubSettings().addAll((Collection<? extends String>)newValue);
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
			case ConfmlPackage.ESEQUENCE_SETTING__SUB_TYPES:
				getSubTypes().clear();
				return;
			case ConfmlPackage.ESEQUENCE_SETTING__MIN_OCCURS:
				setMinOccurs(MIN_OCCURS_EDEFAULT);
				return;
			case ConfmlPackage.ESEQUENCE_SETTING__MAX_OCCURS:
				setMaxOccurs(MAX_OCCURS_EDEFAULT);
				return;
			case ConfmlPackage.ESEQUENCE_SETTING__ITEMS:
				getItems().clear();
				return;
			case ConfmlPackage.ESEQUENCE_SETTING__TEMPLATE:
				setTemplate((EItemSetting)null);
				return;
			case ConfmlPackage.ESEQUENCE_SETTING__MAP_KEY:
				setMapKey(MAP_KEY_EDEFAULT);
				return;
			case ConfmlPackage.ESEQUENCE_SETTING__MAP_VALUE:
				setMapValue(MAP_VALUE_EDEFAULT);
				return;
			case ConfmlPackage.ESEQUENCE_SETTING__VISIBLE_SUB_SETTINGS:
				getVisibleSubSettings().clear();
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
			case ConfmlPackage.ESEQUENCE_SETTING__SUB_TYPES:
				return subTypes != null && !subTypes.isEmpty();
			case ConfmlPackage.ESEQUENCE_SETTING__MIN_OCCURS:
				return MIN_OCCURS_EDEFAULT == null ? minOccurs != null : !MIN_OCCURS_EDEFAULT.equals(minOccurs);
			case ConfmlPackage.ESEQUENCE_SETTING__MAX_OCCURS:
				return MAX_OCCURS_EDEFAULT == null ? maxOccurs != null : !MAX_OCCURS_EDEFAULT.equals(maxOccurs);
			case ConfmlPackage.ESEQUENCE_SETTING__ITEMS:
				return items != null && !items.isEmpty();
			case ConfmlPackage.ESEQUENCE_SETTING__TEMPLATE:
				return template != null;
			case ConfmlPackage.ESEQUENCE_SETTING__MAP_KEY:
				return MAP_KEY_EDEFAULT == null ? mapKey != null : !MAP_KEY_EDEFAULT.equals(mapKey);
			case ConfmlPackage.ESEQUENCE_SETTING__MAP_VALUE:
				return MAP_VALUE_EDEFAULT == null ? mapValue != null : !MAP_VALUE_EDEFAULT.equals(mapValue);
			case ConfmlPackage.ESEQUENCE_SETTING__VISIBLE_SUB_SETTINGS:
				return visibleSubSettings != null && !visibleSubSettings.isEmpty();
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
		if (baseClass == ESettingContainer.class) {
			switch (derivedFeatureID) {
				case ConfmlPackage.ESEQUENCE_SETTING__SUB_TYPES: return ConfmlPackage.ESETTING_CONTAINER__SUB_TYPES;
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
		if (baseClass == ESettingContainer.class) {
			switch (baseFeatureID) {
				case ConfmlPackage.ESETTING_CONTAINER__SUB_TYPES: return ConfmlPackage.ESEQUENCE_SETTING__SUB_TYPES;
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
		result.append(" (minOccurs: ");
		result.append(minOccurs);
		result.append(", maxOccurs: ");
		result.append(maxOccurs);
		result.append(", mapKey: ");
		result.append(mapKey);
		result.append(", mapValue: ");
		result.append(mapValue);
		result.append(", visibleSubSettings: ");
		result.append(visibleSubSettings);
		result.append(')');
		return result.toString();
	}

	@Override
	public void clearDirty() {
//		super.clearDirty();
	}

	@Override
	public boolean isDirty() {
		return true;
	}

	@Override
	public boolean isDefault() {
		return false;
	}

} //ESequenceSettingImpl
