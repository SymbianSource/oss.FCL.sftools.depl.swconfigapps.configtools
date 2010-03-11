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
 * Description: This file is part of com.nokia.tools.variant.content.confml.model component.
 */

package com.nokia.tools.s60ct.content.confml.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.nokia.tools.s60ct.content.confml.ConfmlPackage;
import com.nokia.tools.s60ct.content.confml.FileSystemEntrySetting;
import com.nokia.tools.s60ct.content.confml.SequenceItem;
import com.nokia.tools.s60ct.content.confml.SequenceSetting;
import com.nokia.tools.s60ct.content.confml.Setting;
import com.nokia.tools.s60ct.content.confml.SimpleSetting;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Sequence Setting</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SequenceSettingImpl#getDefaultStructure <em>Default Structure</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SequenceSettingImpl#getTemplate <em>Template</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SequenceSettingImpl#getSequenceItem <em>Sequence Item</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SequenceSettingImpl#getMinOccurs <em>Min Occurs</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SequenceSettingImpl#getMaxOccurs <em>Max Occurs</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SequenceSettingImpl#getLastSavedStructure <em>Last Saved Structure</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SequenceSettingImpl#getMapKey <em>Map Key</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SequenceSettingImpl#getMapValue <em>Map Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SequenceSettingImpl extends SettingImpl implements SequenceSetting {
	private boolean isDefault;
	/**
	 * The cached value of the '{@link #getDefaultStructure()
	 * <em>Default Structure</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDefaultStructure()
	 * @generated
	 * @ordered
	 */
	protected EList<SequenceItem> defaultStructure;

	/**
	 * The cached value of the '{@link #getTemplate() <em>Template</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTemplate()
	 * @generated
	 * @ordered
	 */
	protected SequenceItem template;

	/**
	 * The cached value of the '{@link #getSequenceItem() <em>Sequence Item</em>}' containment reference list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getSequenceItem()
	 * @generated
	 * @ordered
	 */
	protected EList<SequenceItem> sequenceItem;

	/**
	 * The default value of the '{@link #getMinOccurs() <em>Min Occurs</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMinOccurs()
	 * @generated
	 * @ordered
	 */
	protected static final int MIN_OCCURS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMinOccurs() <em>Min Occurs</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMinOccurs()
	 * @generated
	 * @ordered
	 */
	protected int minOccurs = MIN_OCCURS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxOccurs() <em>Max Occurs</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMaxOccurs()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_OCCURS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxOccurs() <em>Max Occurs</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMaxOccurs()
	 * @generated
	 * @ordered
	 */
	protected int maxOccurs = MAX_OCCURS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLastSavedStructure()
	 * <em>Last Saved Structure</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLastSavedStructure()
	 * @generated
	 * @ordered
	 */
	protected EList<SequenceItem> lastSavedStructure;

	/**
	 * The default value of the '{@link #getMapKey() <em>Map Key</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMapKey()
	 * @generated
	 * @ordered
	 */
	protected static final String MAP_KEY_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getMapKey() <em>Map Key</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMapKey()
	 * @generated
	 * @ordered
	 */
	protected String mapKey = MAP_KEY_EDEFAULT;
	/**
	 * The default value of the '{@link #getMapValue() <em>Map Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMapValue()
	 * @generated
	 * @ordered
	 */
	protected static final String MAP_VALUE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getMapValue() <em>Map Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMapValue()
	 * @generated
	 * @ordered
	 */
	protected String mapValue = MAP_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected SequenceSettingImpl() {
		super();
		eAdapters().add(new EContentAdapter() {
			@Override
			public void notifyChanged(Notification notification) {
				if (notification.getFeatureID(Setting.class) == ConfmlPackage.SETTING__COMPUTED_CONSTRAINT
						|| notification.getFeatureID(Setting.class) == ConfmlPackage.SETTING__COMPUTED_RELEVANT) {
					return;
				}
				isDefault = computeDefault();
				super.notifyChanged(notification);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfmlPackage.Literals.SEQUENCE_SETTING;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SequenceItem> getDefaultStructure() {
		if (defaultStructure == null) {
			defaultStructure = new EObjectContainmentEList<SequenceItem>(SequenceItem.class, this, ConfmlPackage.SEQUENCE_SETTING__DEFAULT_STRUCTURE);
		}
		return defaultStructure;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceItem getTemplate() {
		return template;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTemplate(SequenceItem newTemplate,
			NotificationChain msgs) {
		SequenceItem oldTemplate = template;
		template = newTemplate;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfmlPackage.SEQUENCE_SETTING__TEMPLATE, oldTemplate, newTemplate);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemplate(SequenceItem newTemplate) {
		if (newTemplate != template) {
			NotificationChain msgs = null;
			if (template != null)
				msgs = ((InternalEObject)template).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfmlPackage.SEQUENCE_SETTING__TEMPLATE, null, msgs);
			if (newTemplate != null)
				msgs = ((InternalEObject)newTemplate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfmlPackage.SEQUENCE_SETTING__TEMPLATE, null, msgs);
			msgs = basicSetTemplate(newTemplate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.SEQUENCE_SETTING__TEMPLATE, newTemplate, newTemplate));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SequenceItem> getSequenceItem() {
		if (sequenceItem == null) {
			sequenceItem = new EObjectContainmentEList<SequenceItem>(SequenceItem.class, this, ConfmlPackage.SEQUENCE_SETTING__SEQUENCE_ITEM);
		}
		return sequenceItem;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getMinOccurs() {
		return minOccurs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinOccurs(int newMinOccurs) {
		int oldMinOccurs = minOccurs;
		minOccurs = newMinOccurs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.SEQUENCE_SETTING__MIN_OCCURS, oldMinOccurs, minOccurs));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxOccurs() {
		return maxOccurs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxOccurs(int newMaxOccurs) {
		int oldMaxOccurs = maxOccurs;
		maxOccurs = newMaxOccurs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.SEQUENCE_SETTING__MAX_OCCURS, oldMaxOccurs, maxOccurs));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SequenceItem> getLastSavedStructure() {
		if (lastSavedStructure == null) {
			lastSavedStructure = new EObjectContainmentEList<SequenceItem>(SequenceItem.class, this, ConfmlPackage.SEQUENCE_SETTING__LAST_SAVED_STRUCTURE);
		}
		return lastSavedStructure;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getMapKey() {
		return mapKey;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMapKey(String newMapKey) {
		String oldMapKey = mapKey;
		mapKey = newMapKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.SEQUENCE_SETTING__MAP_KEY, oldMapKey, mapKey));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getMapValue() {
		return mapValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMapValue(String newMapValue) {
		String oldMapValue = mapValue;
		mapValue = newMapValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.SEQUENCE_SETTING__MAP_VALUE, oldMapValue, mapValue));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean computeDefault() {
		EList<SequenceItem> defaultStructure = getDefaultStructure();
		EList<SequenceItem> sequenceItem = getSequenceItem();
		if (!(defaultStructure.size() == sequenceItem.size())) {
			return false;
		}
		for (int i = 0; i < defaultStructure.size(); i++) {
			SequenceItem defaultItem = defaultStructure.get(i);
			SequenceItem item = sequenceItem.get(i);
			EList<Setting> defaultItemSetting = defaultItem.getSetting();
			EList<Setting> itemSetting = item.getSetting();
			for (int j = 0; j < defaultItemSetting.size(); j++) {
				Setting defaultSetting = defaultItemSetting.get(j);
				Setting setting = itemSetting.get(j);
				if (setting instanceof SimpleSetting) {
					SimpleSetting defaultSimpleSetting = (SimpleSetting) defaultSetting;
					SimpleSetting simpleSetting = (SimpleSetting) setting;
					if (defaultSimpleSetting.getValue() == null
							&& simpleSetting.getValue() != null
							|| defaultSimpleSetting.getValue() != null
							&& simpleSetting.getValue() == null) {
						return false;
					}
					if (defaultSimpleSetting.getValue() == null) {
						if (null != simpleSetting.getValue()) {
							return false;
						}
					} else if (!defaultSimpleSetting.getValue().equals(
							simpleSetting.getValue())) {
						return false;
					}
				} else if (setting instanceof FileSystemEntrySetting) {
					FileSystemEntrySetting defaultSimpleSetting = (FileSystemEntrySetting) defaultSetting;
					FileSystemEntrySetting simpleSetting = (FileSystemEntrySetting) setting;
					String defaultSourcePath = defaultSimpleSetting
							.getSourceFilePath().getPath();
					String sourcePath = simpleSetting.getSourceFilePath()
							.getPath();
					if (defaultSourcePath == null && sourcePath != null
							|| defaultSourcePath != null && sourcePath == null) {
						return false;
					}

					if (defaultSourcePath != null
							&& !defaultSourcePath.equals(sourcePath)) {
						return false;
					}
					String defaultTargetPath = defaultSimpleSetting
							.getTargetFilePath().getPath();
					String targetPath = simpleSetting.getTargetFilePath()
							.getPath();
					if (defaultTargetPath == null && targetPath != null
							|| defaultTargetPath != null && targetPath == null) {
						return false;
					}
					if (defaultTargetPath != null
							&& !defaultTargetPath.equals(targetPath)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfmlPackage.SEQUENCE_SETTING__DEFAULT_STRUCTURE:
				return ((InternalEList<?>)getDefaultStructure()).basicRemove(otherEnd, msgs);
			case ConfmlPackage.SEQUENCE_SETTING__TEMPLATE:
				return basicSetTemplate(null, msgs);
			case ConfmlPackage.SEQUENCE_SETTING__SEQUENCE_ITEM:
				return ((InternalEList<?>)getSequenceItem()).basicRemove(otherEnd, msgs);
			case ConfmlPackage.SEQUENCE_SETTING__LAST_SAVED_STRUCTURE:
				return ((InternalEList<?>)getLastSavedStructure()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfmlPackage.SEQUENCE_SETTING__DEFAULT_STRUCTURE:
				return getDefaultStructure();
			case ConfmlPackage.SEQUENCE_SETTING__TEMPLATE:
				return getTemplate();
			case ConfmlPackage.SEQUENCE_SETTING__SEQUENCE_ITEM:
				return getSequenceItem();
			case ConfmlPackage.SEQUENCE_SETTING__MIN_OCCURS:
				return new Integer(getMinOccurs());
			case ConfmlPackage.SEQUENCE_SETTING__MAX_OCCURS:
				return new Integer(getMaxOccurs());
			case ConfmlPackage.SEQUENCE_SETTING__LAST_SAVED_STRUCTURE:
				return getLastSavedStructure();
			case ConfmlPackage.SEQUENCE_SETTING__MAP_KEY:
				return getMapKey();
			case ConfmlPackage.SEQUENCE_SETTING__MAP_VALUE:
				return getMapValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConfmlPackage.SEQUENCE_SETTING__DEFAULT_STRUCTURE:
				getDefaultStructure().clear();
				getDefaultStructure().addAll((Collection<? extends SequenceItem>)newValue);
				return;
			case ConfmlPackage.SEQUENCE_SETTING__TEMPLATE:
				setTemplate((SequenceItem)newValue);
				return;
			case ConfmlPackage.SEQUENCE_SETTING__SEQUENCE_ITEM:
				getSequenceItem().clear();
				getSequenceItem().addAll((Collection<? extends SequenceItem>)newValue);
				return;
			case ConfmlPackage.SEQUENCE_SETTING__MIN_OCCURS:
				setMinOccurs(((Integer)newValue).intValue());
				return;
			case ConfmlPackage.SEQUENCE_SETTING__MAX_OCCURS:
				setMaxOccurs(((Integer)newValue).intValue());
				return;
			case ConfmlPackage.SEQUENCE_SETTING__LAST_SAVED_STRUCTURE:
				getLastSavedStructure().clear();
				getLastSavedStructure().addAll((Collection<? extends SequenceItem>)newValue);
				return;
			case ConfmlPackage.SEQUENCE_SETTING__MAP_KEY:
				setMapKey((String)newValue);
				return;
			case ConfmlPackage.SEQUENCE_SETTING__MAP_VALUE:
				setMapValue((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ConfmlPackage.SEQUENCE_SETTING__DEFAULT_STRUCTURE:
				getDefaultStructure().clear();
				return;
			case ConfmlPackage.SEQUENCE_SETTING__TEMPLATE:
				setTemplate((SequenceItem)null);
				return;
			case ConfmlPackage.SEQUENCE_SETTING__SEQUENCE_ITEM:
				getSequenceItem().clear();
				return;
			case ConfmlPackage.SEQUENCE_SETTING__MIN_OCCURS:
				setMinOccurs(MIN_OCCURS_EDEFAULT);
				return;
			case ConfmlPackage.SEQUENCE_SETTING__MAX_OCCURS:
				setMaxOccurs(MAX_OCCURS_EDEFAULT);
				return;
			case ConfmlPackage.SEQUENCE_SETTING__LAST_SAVED_STRUCTURE:
				getLastSavedStructure().clear();
				return;
			case ConfmlPackage.SEQUENCE_SETTING__MAP_KEY:
				setMapKey(MAP_KEY_EDEFAULT);
				return;
			case ConfmlPackage.SEQUENCE_SETTING__MAP_VALUE:
				setMapValue(MAP_VALUE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ConfmlPackage.SEQUENCE_SETTING__DEFAULT_STRUCTURE:
				return defaultStructure != null && !defaultStructure.isEmpty();
			case ConfmlPackage.SEQUENCE_SETTING__TEMPLATE:
				return template != null;
			case ConfmlPackage.SEQUENCE_SETTING__SEQUENCE_ITEM:
				return sequenceItem != null && !sequenceItem.isEmpty();
			case ConfmlPackage.SEQUENCE_SETTING__MIN_OCCURS:
				return minOccurs != MIN_OCCURS_EDEFAULT;
			case ConfmlPackage.SEQUENCE_SETTING__MAX_OCCURS:
				return maxOccurs != MAX_OCCURS_EDEFAULT;
			case ConfmlPackage.SEQUENCE_SETTING__LAST_SAVED_STRUCTURE:
				return lastSavedStructure != null && !lastSavedStructure.isEmpty();
			case ConfmlPackage.SEQUENCE_SETTING__MAP_KEY:
				return MAP_KEY_EDEFAULT == null ? mapKey != null : !MAP_KEY_EDEFAULT.equals(mapKey);
			case ConfmlPackage.SEQUENCE_SETTING__MAP_VALUE:
				return MAP_VALUE_EDEFAULT == null ? mapValue != null : !MAP_VALUE_EDEFAULT.equals(mapValue);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
		result.append(')');
		return result.toString();
	}

	@Override
	/*
	 * @generated NOT
	 */
	public boolean isDefault() {
		return isDefault;
	}

	@Override
	/*
	 * @generated NOT
	 */
	public boolean isDirty() {

		EList<SequenceItem> lastSavedStructure = getLastSavedStructure();
		EList<SequenceItem> sequenceItem = getSequenceItem();
		if (!(lastSavedStructure.size() == sequenceItem.size())) {
			return true;
		}
		return false;
	}

}
