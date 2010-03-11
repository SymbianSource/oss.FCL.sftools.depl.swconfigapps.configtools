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

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;

import com.nokia.tools.s60ct.model.confml.ConfmlFactory;
import com.nokia.tools.s60ct.model.confml.ConfmlPackage;
import com.nokia.tools.s60ct.model.confml.EItemSetting;
import com.nokia.tools.s60ct.model.confml.EOption;
import com.nokia.tools.s60ct.model.confml.EOptionMap;
import com.nokia.tools.s60ct.model.confml.ESequenceSetting;
import com.nokia.tools.s60ct.model.confml.ESequenceValue;
import com.nokia.tools.s60ct.model.confml.ESequenceValueItem;
import com.nokia.tools.s60ct.model.confml.ESetting;
import com.nokia.tools.s60ct.model.confml.ESettingOption;
import com.nokia.tools.s60ct.model.confml.ESettingValue;
import com.nokia.tools.s60ct.model.confml.ESimpleSetting;
import com.nokia.tools.s60ct.model.confml.ESimpleValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EOption</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.EOptionImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.EOptionImpl#getValue <em>Value</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.EOptionImpl#getMap <em>Map</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.EOptionImpl#getMapSourceSetting <em>Map Source Setting</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.EOptionImpl#getOptionValues <em>Option Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EOptionImpl extends ESettingOptionImpl implements EOption {
	
	
	/**
	 * Map for simple store of keys like feature1\setting1\[key='1'] and their
	 * values stored in sequences like 'value1'.
	 */
	private Map<String, String> values;

	private Map<String, String> mapValues;
	public static final String OPTION_MAP_KEY = "[@key='";
	public static final boolean SHOW_MAP_KEY = false;
	
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMap() <em>Map</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMap()
	 * @generated
	 * @ordered
	 */
	protected static final String MAP_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getMap() <em>Map</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMap()
	 * @generated
	 * @ordered
	 */
	protected String map = MAP_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMapSourceSetting() <em>Map Source Setting</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMapSourceSetting()
	 * @generated
	 * @ordered
	 */
	protected ESequenceSetting mapSourceSetting;

	/**
	 * The cached value of the '{@link #getOptionValues() <em>Option Values</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptionValues()
	 * @generated
	 * @ordered
	 */
	protected Map<String, EOptionMap> optionValues;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EOptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfmlPackage.Literals.EOPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.EOPTION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.EOPTION__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMap() {
		return map;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMap(String newMap) {
		String oldMap = map;
		map = newMap;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.EOPTION__MAP, oldMap, map));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESequenceSetting getMapSourceSetting() {
		if (mapSourceSetting != null && mapSourceSetting.eIsProxy()) {
			InternalEObject oldMapSourceSetting = (InternalEObject)mapSourceSetting;
			mapSourceSetting = (ESequenceSetting)eResolveProxy(oldMapSourceSetting);
			if (mapSourceSetting != oldMapSourceSetting) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfmlPackage.EOPTION__MAP_SOURCE_SETTING, oldMapSourceSetting, mapSourceSetting));
			}
		}
		return mapSourceSetting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESequenceSetting basicGetMapSourceSetting() {
		return mapSourceSetting;
	}


	/**
	 * Fill option map with values gathered from related sequences.
	 * 
	 * @param parent
	 */
	private void fillMapOptions() {
		ESetting parent = (ESetting) eContainer;
		if (parent == null) {
			return;
		}
		values = new HashMap<String, String>();
		mapValues = new HashMap<String, String>();
		Map<String, EOptionMap> newOptionsMap = new LinkedHashMap<String, EOptionMap>();
		if (mapSourceSetting != null) {
			String mapKey = null;
			String mapValue = null;
			// swapped because we need to show mapKey in the ui (currently
			// mapValue is some magic number)
			if (SHOW_MAP_KEY) {
				mapValue = mapSourceSetting.getMapKey();
				mapKey = mapSourceSetting.getMapValue();
			} else {
				mapKey = mapSourceSetting.getMapKey();
				mapValue = mapSourceSetting.getMapValue();
			}
			EList<ESequenceValueItem> allItems = new BasicEList<ESequenceValueItem>();
			
			//EList<ESetting> sequenceItems = mapSourceSetting.getSubTypes();
			//EList<EItemSetting> items = mapSourceSetting.getItems();
			ESequenceValue seqVal = (ESequenceValue)mapSourceSetting.getValue();
			ESequenceValue defVal = (ESequenceValue)mapSourceSetting.getDefaultValue();
			allItems.addAll(seqVal.getItems());
			allItems.addAll(defVal.getItems());
			
			for (ESequenceValueItem svi : allItems) {
				
				EList<ESettingValue> settingValues = svi.getSubSettings();
				String key = null, value = null, absRef = null;
				for (ESettingValue settingValue : settingValues)
				{
					//String key = null, value = null, absRef = null;
					
					ESetting setting = settingValue.getType();
					
					if (setting.isReadOnly()) {
						continue;
					}
					absRef = setting.getAbsRef();
					if (setting instanceof ESimpleSetting) 
					{
						if (setting.getRef().equals(mapKey)) 
						{
							key = ((ESimpleValue)settingValue).getValue();
						}
						if (setting.getRef().equals(mapValue)) 
						{
							value = ((ESimpleValue)settingValue).getValue();
						}
					} 
	//				else if (setting instanceof EResourceSetting) 
	//				{
	//					FilePath sourceFilePath = ((EResourceSetting) setting).getSourceFilePath();
	//					if (setting.getRef().equals(mapKey)) {
	//						if (sourceFilePath != null) {
	//							key = sourceFilePath.getPath();
	//						} else if (setting instanceof FilePath) {
	//							key = ((FilePath) setting).getPath();
	//						}
	//					}
	//					if (setting.getRef().equals(mapValue)) {
	//						if (setting instanceof FilePath) {
	//							value = ((FilePath) setting).getPath();
	//						} else if (setting instanceof FileSystemEntrySetting) {
	//							if (sourceFilePath != null) {
	//								value = sourceFilePath.getPath();
	//							}
	//						}
	//					}
	//				}
					
					if (key != null) {
						  //.substring(0, absRef.lastIndexOf('/'));
						//String value2Save = "map=\""+absRef+OPTION_MAP_KEY+key+"']\"";
						String value2Save = absRef.concat(OPTION_MAP_KEY).concat(key)
						.concat("']");
	
						if (value == null) {
							value = "";
						}
						if (SHOW_MAP_KEY) {
							value = value.trim();
							value2Save = value2Save.replace(key, value);
						}
						EOptionMap optionMapEntry = ConfmlFactory.eINSTANCE.createEOptionMap();
						optionMapEntry.setValue2Save(value2Save);
						optionMapEntry.setMapValue(value);
						newOptionsMap.put(key, optionMapEntry);
						mapValues.put(key, value);
						values.put(value2Save, key);
						
						if (parent instanceof ESimpleSetting) {
							ESimpleSetting simple = (ESimpleSetting) parent;
							if (simple.getValue() != null
									&& value2Save.equals(simple.getValue())) {
								simple.getValue().setChosenOption(value);
							}
						} 
						
	//					else if (parent instanceof FilePath) {
	//						FilePath path = (FilePath) parent;
	//						if (path.getPath() != null
	//								&& value2Save.equals(path.getPath())) {
	//							path.setChosenOption(key);
	//						}
	//					}
					}
				}
			}

		}
		setOptionValues(newOptionsMap);
	}

	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setMapSourceSetting(ESequenceSetting newMapSourceSetting) {
		ESequenceSetting oldMapSourceSetting = mapSourceSetting;
		mapSourceSetting = newMapSourceSetting;
		mapSourceSetting.eAdapters().add(new SequenceContentAdapter());
		fillMapOptions();
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ConfmlPackage.EOPTION__MAP_SOURCE_SETTING,
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
					EOptionMap optionValue = optionValues.get(notification
							.getOldValue());

					if (eContainer instanceof ESimpleSetting) {
						ESimpleSetting parent = (ESimpleSetting) eContainer;
						if (optionValue != null
								&& optionValue.getValue2Save().equals(
										parent.getValue())) {
							// set new Value
							updateValue = true;
						}
					} 
//					else if (eContainer instanceof FilePath) {
//						FilePath parent = (FilePath) eContainer;
//						if (optionValue != null
//								&& optionValue.getValue2Save().equals(
//										parent.getPath())) {
//							// set new Value
//							updateValue = true;
//						}
//					}
				}
				if (eContainer instanceof ESetting
						&& notification.getOldStringValue() != null
						&& notification.getNewStringValue() != null
						|| notification.getEventType() == Notification.REMOVE
						|| notification.getEventType() == Notification.ADD
						|| notification.getEventType() == Notification.SET) {
					fillMapOptions();
				}
				if (eContainer instanceof ESimpleSetting) {
					ESimpleSetting parent = (ESimpleSetting) eContainer;
					ESettingValue sv = parent.getValue();
					String choosenOption = null;
					if (sv != null)
						choosenOption = parent.getValue().getChosenOption();
					if (choosenOption != null && !parentContainsOptionKey(parent, choosenOption)) {
						parent.getValue().setChosenOption(null);
					}
				} 
//				else if (eContainer instanceof FilePath) {
//					FilePath path = (FilePath) eContainer;
//					String chosenOption = path.getChosenOption();
//					if (chosenOption != null
//							&& !optionValues.containsKey(chosenOption)) {
//						path.setChosenOption(null);
//					}
//				}
				if (updateValue) {
					if (eContainer instanceof ESimpleSetting) {
						ESimpleSetting parent = (ESimpleSetting) eContainer;
						((ESimpleValue)parent.getValue()).setValue(optionValues.get(
								notification.getNewValue()).getValue2Save());
						parent.getValue().setChosenOption(notification.getNewStringValue());

					} 
//					else if (eContainer instanceof FilePath) {
//						FilePath parent = (FilePath) eContainer;
//						parent.setPath(optionValues.get(
//								notification.getNewValue()).getValue2Save());
//						parent
//								.setChosenOption(notification
//										.getNewStringValue());
//					}
				}
			}
		}

		private boolean parentContainsOptionKey(ESetting parent, String key) {
			for (ESettingOption option : ((ESimpleSetting)parent).getOptions()) {
				Map<String, EOptionMap> parentOptionValues = ((EOption)option).getOptionValues();
				if (parentOptionValues != null
						&& parentOptionValues.containsKey(key)) {
					return true;
				}
			}
			return false;
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<String, EOptionMap> getOptionValues() {
		return optionValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOptionValues(Map<String, EOptionMap> newOptionValues) {
		Map<String, EOptionMap> oldOptionValues = optionValues;
		optionValues = newOptionValues;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.EOPTION__OPTION_VALUES, oldOptionValues, optionValues));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getMapValue(String key) {
		if (mapValues != null) {
			return mapValues.get(key);
		} else {
			return null;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfmlPackage.EOPTION__NAME:
				return getName();
			case ConfmlPackage.EOPTION__VALUE:
				return getValue();
			case ConfmlPackage.EOPTION__MAP:
				return getMap();
			case ConfmlPackage.EOPTION__MAP_SOURCE_SETTING:
				if (resolve) return getMapSourceSetting();
				return basicGetMapSourceSetting();
			case ConfmlPackage.EOPTION__OPTION_VALUES:
				return getOptionValues();
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
			case ConfmlPackage.EOPTION__NAME:
				setName((String)newValue);
				return;
			case ConfmlPackage.EOPTION__VALUE:
				setValue((String)newValue);
				return;
			case ConfmlPackage.EOPTION__MAP:
				setMap((String)newValue);
				return;
			case ConfmlPackage.EOPTION__MAP_SOURCE_SETTING:
				setMapSourceSetting((ESequenceSetting)newValue);
				return;
			case ConfmlPackage.EOPTION__OPTION_VALUES:
				setOptionValues((Map<String, EOptionMap>)newValue);
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
			case ConfmlPackage.EOPTION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ConfmlPackage.EOPTION__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case ConfmlPackage.EOPTION__MAP:
				setMap(MAP_EDEFAULT);
				return;
			case ConfmlPackage.EOPTION__MAP_SOURCE_SETTING:
				setMapSourceSetting((ESequenceSetting)null);
				return;
			case ConfmlPackage.EOPTION__OPTION_VALUES:
				setOptionValues((Map<String, EOptionMap>)null);
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
			case ConfmlPackage.EOPTION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ConfmlPackage.EOPTION__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case ConfmlPackage.EOPTION__MAP:
				return MAP_EDEFAULT == null ? map != null : !MAP_EDEFAULT.equals(map);
			case ConfmlPackage.EOPTION__MAP_SOURCE_SETTING:
				return mapSourceSetting != null;
			case ConfmlPackage.EOPTION__OPTION_VALUES:
				return optionValues != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", value: ");
		result.append(value);
		result.append(", map: ");
		result.append(map);
		result.append(", optionValues: ");
		result.append(optionValues);
		result.append(')');
		return result.toString();
	}

} //EOptionImpl
