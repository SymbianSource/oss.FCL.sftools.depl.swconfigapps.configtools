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

package com.nokia.tools.variant.content.confml.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;

import com.nokia.tools.variant.content.confml.ConfmlFactory;
import com.nokia.tools.variant.content.confml.ConfmlPackage;
import com.nokia.tools.variant.content.confml.FilePath;
import com.nokia.tools.variant.content.confml.FileSystemEntrySetting;
import com.nokia.tools.variant.content.confml.Option;
import com.nokia.tools.variant.content.confml.OptionMapEntry;
import com.nokia.tools.variant.content.confml.SequenceItem;
import com.nokia.tools.variant.content.confml.SequenceSetting;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.SimpleSetting;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Option</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.content.confml.impl.OptionImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.impl.OptionImpl#getValue <em>Value</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.impl.OptionImpl#getRelevant <em>Relevant</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.impl.OptionImpl#getMap <em>Map</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.impl.OptionImpl#getMapSourceSetting <em>Map Source Setting</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.impl.OptionImpl#getOptionValues <em>Option Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OptionImpl extends EObjectImpl implements Option {
	public static final String OPTION_MAP_KEY = "[key=\"";

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRelevant() <em>Relevant</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRelevant()
	 * @generated
	 * @ordered
	 */
	protected static final String RELEVANT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRelevant() <em>Relevant</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRelevant()
	 * @generated
	 * @ordered
	 */
	protected String relevant = RELEVANT_EDEFAULT;

	/**
	 * The default value of the '{@link #getMap() <em>Map</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMap()
	 * @generated
	 * @ordered
	 */
	protected static final String MAP_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getMap() <em>Map</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMap()
	 * @generated
	 * @ordered
	 */
	protected String map = MAP_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMapSourceSetting() <em>Map Source Setting</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getMapSourceSetting()
	 * @generated
	 * @ordered
	 */
	protected SequenceSetting mapSourceSetting;

	/**
	 * The cached value of the '{@link #getOptionValues() <em>Option Values</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getOptionValues()
	 * @generated
	 * @ordered
	 */
	protected Map<String, OptionMapEntry> optionValues;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected OptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfmlPackage.Literals.OPTION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.OPTION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.OPTION__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getRelevant() {
		return relevant;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelevant(String newRelevant) {
		String oldRelevant = relevant;
		relevant = newRelevant;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.OPTION__RELEVANT, oldRelevant, relevant));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getMap() {
		return map;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMap(String newMap) {
		String oldMap = map;
		map = newMap;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.OPTION__MAP, oldMap, map));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceSetting getMapSourceSetting() {
		if (mapSourceSetting != null && mapSourceSetting.eIsProxy()) {
			InternalEObject oldMapSourceSetting = (InternalEObject)mapSourceSetting;
			mapSourceSetting = (SequenceSetting)eResolveProxy(oldMapSourceSetting);
			if (mapSourceSetting != oldMapSourceSetting) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfmlPackage.OPTION__MAP_SOURCE_SETTING, oldMapSourceSetting, mapSourceSetting));
			}
		}
		return mapSourceSetting;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceSetting basicGetMapSourceSetting() {
		return mapSourceSetting;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setMapSourceSetting(SequenceSetting newMapSourceSetting) {
		SequenceSetting oldMapSourceSetting = mapSourceSetting;
		mapSourceSetting = newMapSourceSetting;
		mapSourceSetting.eAdapters().add(new SequenceContentAdapter());
		fillMapOptions();
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ConfmlPackage.OPTION__MAP_SOURCE_SETTING,
					oldMapSourceSetting, mapSourceSetting));
	}

	/**
	 * Adapter handles situation when sequences are changed and option map
	 * should be changed also.
	 * 
	 */
	private class SequenceContentAdapter extends EContentAdapter {
		@Override
		public void notifyChanged(Notification notification) {
			super.notifyChanged(notification);

			if (notification.getNewStringValue() != null
					|| notification.getOldStringValue() != null) {
				boolean updateValue = false;
				if (notification.getOldStringValue() != null
						&& notification.getNewStringValue() != null
						&& optionValues != null) {
					OptionMapEntry optionValue = optionValues.get(notification
							.getOldValue());

					if (eContainer instanceof SimpleSetting) {
						SimpleSetting parent = (SimpleSetting) eContainer;
						if (optionValue != null
								&& optionValue.getValue2Save().equals(parent.getValue())) {
							// set new Value
							updateValue = true;
						}
					} else if (eContainer instanceof FilePath) {
						FilePath parent = (FilePath) eContainer;
						if (optionValue != null
								&& optionValue.getValue2Save().equals(parent.getPath())) {
							// set new Value
							updateValue = true;
						}
					}
				}
				if (eContainer instanceof Setting
						&& notification.getOldStringValue() != null
						&& notification.getNewStringValue() != null
						|| notification.getEventType() == Notification.REMOVE
						|| notification.getEventType() == Notification.ADD
						|| notification.getEventType() == Notification.SET) {
					fillMapOptions();
				}
				if (eContainer instanceof SimpleSetting) {
					SimpleSetting parent = (SimpleSetting) eContainer;
					String choosenOption = parent.getChoosenOption();
					if (choosenOption != null
							&& !parentContainsOptionKey(parent, choosenOption)) {
						parent.setChoosenOption(null);
					}
				} else if (eContainer instanceof FilePath) {
					FilePath path = (FilePath) eContainer;
					String choosenOption = path.getChoosenOption();
					if (choosenOption != null
							&& !optionValues.containsKey(choosenOption)) {
						path.setChoosenOption(null);
					}
				}
				if (updateValue) {
					if (eContainer instanceof SimpleSetting) {
						SimpleSetting parent = (SimpleSetting) eContainer;
						parent.setValue(optionValues.get(notification
								.getNewValue()).getValue2Save());
						parent.setChoosenOption(notification
								.getNewStringValue());

					} else if (eContainer instanceof FilePath) {
						FilePath parent = (FilePath) eContainer;
						parent.setPath(optionValues.get(notification
								.getNewValue()).getValue2Save());
						parent.setChoosenOption(notification
								.getNewStringValue());
					}
				}
			}
		}

		private boolean parentContainsOptionKey(Setting parent, String key) {
			for (Option option : parent.getOption()) {
				Map<String, OptionMapEntry> parentOptionValues = option.getOptionValues();
				if (parentOptionValues!=null && parentOptionValues.containsKey(key)) {
					return true;
				}
			}
			return false;
		}
	}

	/**
	 * Map for simple store of keys like feature1\setting1\[key='1'] and their
	 * values stored in sequences like 'value1'.
	 */
	private Map<String, String> values;

	private Map<String, String> mapValues;

	public String getMapValue(String key){
		return mapValues.get(key);
	}
	/**
	 * Fill option map with values gathered from related sequences.
	 * 
	 * @param parent
	 */
	private void fillMapOptions() {
		Setting parent = (Setting)eContainer;
		values = new HashMap<String, String>();
		mapValues = new HashMap<String,String>();
		Map<String, OptionMapEntry> newOptionsMap = new LinkedHashMap<String, OptionMapEntry>();
		if (mapSourceSetting != null) {
			String mapKey = mapSourceSetting.getMapKey();
			String mapValue = mapSourceSetting.getMapValue();
			EList<SequenceItem> sequenceItems = mapSourceSetting
					.getSequenceItem();
			for (SequenceItem sequenceItem : sequenceItems) {
				EList<Setting> settings = sequenceItem.getSetting();
				String key = null,value = null, absRef = null;
				for (Setting setting : settings) {
					if (!setting.isVisible()) {
						continue;
					}
					absRef = setting.getAbsRef();
					if (setting instanceof SimpleSetting) {
						if (setting.getSettingRef().equals(mapKey)) {
							key = ((SimpleSetting) setting).getValue();
						}
						if (setting.getSettingRef().equals(mapValue)) {
							value = ((SimpleSetting) setting).getValue();
						}
					} else if (setting instanceof FileSystemEntrySetting) {
						if (setting.getSettingRef().equals(mapKey)) {
							key = ((FileSystemEntrySetting) setting)
									.getSourceFilePath().getPath();
						}
						if (setting.getSettingRef().equals(mapValue)) {
							value = ((FilePath) setting).getPath();
						}
					}
				}
				if (key != null) {

					String ref = absRef.substring(0, absRef.lastIndexOf('/'));
					String value2Save = ref.concat(OPTION_MAP_KEY).concat(key).concat("\"]");
					OptionMapEntry optionMapEntry = ConfmlFactory.eINSTANCE.createOptionMapEntry();
					optionMapEntry.setValue2Save(value2Save);
					optionMapEntry.setMapValue(value);
					newOptionsMap.put(key, optionMapEntry);
					mapValues.put(key, value);
					values.put(value2Save, key);
					if (parent instanceof SimpleSetting) {
						SimpleSetting simple = (SimpleSetting) parent;
						if (simple.getValue() != null
								&& value2Save.equals(simple.getValue())) {
							simple.setChoosenOption(key);
						}
					} else if (parent instanceof FilePath) {
						FilePath path = (FilePath) parent;
						if (path.getPath() != null
								&& value2Save.equals(path.getPath())) {
							path.setChoosenOption(key);
						}
					}
				}
			}
		}
		setOptionValues(newOptionsMap);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Map<String, OptionMapEntry> getOptionValues() {
		return optionValues;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setOptionValues(Map<String, OptionMapEntry> newOptionValues) {
		Map<String, OptionMapEntry> oldOptionValues = optionValues;
		optionValues = newOptionValues;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.OPTION__OPTION_VALUES, oldOptionValues, optionValues));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfmlPackage.OPTION__NAME:
				return getName();
			case ConfmlPackage.OPTION__VALUE:
				return getValue();
			case ConfmlPackage.OPTION__RELEVANT:
				return getRelevant();
			case ConfmlPackage.OPTION__MAP:
				return getMap();
			case ConfmlPackage.OPTION__MAP_SOURCE_SETTING:
				if (resolve) return getMapSourceSetting();
				return basicGetMapSourceSetting();
			case ConfmlPackage.OPTION__OPTION_VALUES:
				return getOptionValues();
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
			case ConfmlPackage.OPTION__NAME:
				setName((String)newValue);
				return;
			case ConfmlPackage.OPTION__VALUE:
				setValue((String)newValue);
				return;
			case ConfmlPackage.OPTION__RELEVANT:
				setRelevant((String)newValue);
				return;
			case ConfmlPackage.OPTION__MAP:
				setMap((String)newValue);
				return;
			case ConfmlPackage.OPTION__MAP_SOURCE_SETTING:
				setMapSourceSetting((SequenceSetting)newValue);
				return;
			case ConfmlPackage.OPTION__OPTION_VALUES:
				setOptionValues((Map<String, OptionMapEntry>)newValue);
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
			case ConfmlPackage.OPTION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ConfmlPackage.OPTION__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case ConfmlPackage.OPTION__RELEVANT:
				setRelevant(RELEVANT_EDEFAULT);
				return;
			case ConfmlPackage.OPTION__MAP:
				setMap(MAP_EDEFAULT);
				return;
			case ConfmlPackage.OPTION__MAP_SOURCE_SETTING:
				setMapSourceSetting((SequenceSetting)null);
				return;
			case ConfmlPackage.OPTION__OPTION_VALUES:
				setOptionValues((Map<String, OptionMapEntry>)null);
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
			case ConfmlPackage.OPTION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ConfmlPackage.OPTION__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case ConfmlPackage.OPTION__RELEVANT:
				return RELEVANT_EDEFAULT == null ? relevant != null : !RELEVANT_EDEFAULT.equals(relevant);
			case ConfmlPackage.OPTION__MAP:
				return MAP_EDEFAULT == null ? map != null : !MAP_EDEFAULT.equals(map);
			case ConfmlPackage.OPTION__MAP_SOURCE_SETTING:
				return mapSourceSetting != null;
			case ConfmlPackage.OPTION__OPTION_VALUES:
				return optionValues != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", value: ");
		result.append(value);
		result.append(", relevant: ");
		result.append(relevant);
		result.append(", map: ");
		result.append(map);
		result.append(", optionValues: ");
		result.append(optionValues);
		result.append(')');
		return result.toString();
	}

} // OptionImpl
