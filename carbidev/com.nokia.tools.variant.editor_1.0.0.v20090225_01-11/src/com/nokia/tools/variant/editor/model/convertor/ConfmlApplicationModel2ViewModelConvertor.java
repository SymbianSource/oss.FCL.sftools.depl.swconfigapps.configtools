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

package com.nokia.tools.variant.editor.model.convertor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.nokia.tools.variant.confml.core.model.application.EAppCompositeType;
import com.nokia.tools.variant.confml.core.model.application.EAppExpression;
import com.nokia.tools.variant.confml.core.model.application.EAppFeature;
import com.nokia.tools.variant.confml.core.model.application.EAppGroup;
import com.nokia.tools.variant.confml.core.model.application.EAppIncludeElement;
import com.nokia.tools.variant.confml.core.model.application.EAppProperty;
import com.nokia.tools.variant.confml.core.model.application.EAppResourceData;
import com.nokia.tools.variant.confml.core.model.application.EAppResourceType;
import com.nokia.tools.variant.confml.core.model.application.EAppSequenceData;
import com.nokia.tools.variant.confml.core.model.application.EAppSequenceDataItem;
import com.nokia.tools.variant.confml.core.model.application.EAppSequenceType;
import com.nokia.tools.variant.confml.core.model.application.EAppSetting;
import com.nokia.tools.variant.confml.core.model.application.EAppSettingData;
import com.nokia.tools.variant.confml.core.model.application.EAppSettingOption;
import com.nokia.tools.variant.confml.core.model.application.EAppSettingRef;
import com.nokia.tools.variant.confml.core.model.application.EAppSettingType;
import com.nokia.tools.variant.confml.core.model.application.EAppSimpleData;
import com.nokia.tools.variant.confml.core.model.application.EAppSimpleType;
import com.nokia.tools.variant.confml.core.model.application.EAppValueType;
import com.nokia.tools.variant.confml.core.model.application.EAppView;
import com.nokia.tools.variant.confml.core.model.application.EConfMLLayer;
import com.nokia.tools.variant.confml.core.model.application.EConfigurationProject;
import com.nokia.tools.variant.confml.core.model.application.impl.EAppFeatureEntryImpl;
import com.nokia.tools.variant.confml.core.model.application.impl.EAppSettingEntryImpl;
import com.nokia.tools.variant.confml.core.model.application.impl.EAppSettingTypeEntryImpl;
import com.nokia.tools.variant.content.confml.ConfmlFactory;
import com.nokia.tools.variant.content.confml.Feature;
import com.nokia.tools.variant.content.confml.FilePath;
import com.nokia.tools.variant.content.confml.FileSystemEntrySetting;
import com.nokia.tools.variant.content.confml.Icon;
import com.nokia.tools.variant.content.confml.LeafGroup;
import com.nokia.tools.variant.content.confml.MaxExclusive;
import com.nokia.tools.variant.content.confml.MaxInclusive;
import com.nokia.tools.variant.content.confml.MinExclusive;
import com.nokia.tools.variant.content.confml.MinInclusive;
import com.nokia.tools.variant.content.confml.Option;
import com.nokia.tools.variant.content.confml.ParentGroup;
import com.nokia.tools.variant.content.confml.Property;
import com.nokia.tools.variant.content.confml.SequenceItem;
import com.nokia.tools.variant.content.confml.SequenceSetting;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.SimpleSetting;
import com.nokia.tools.variant.content.confml.TYPE;
import com.nokia.tools.variant.content.confml.View;
import com.nokia.tools.variant.content.confml.impl.OptionImpl;
import com.nokia.tools.variant.content.confml.util.SettingValueUtils;
import com.nokia.tools.variant.editor.editors.ConfMLExpressionSettingUtil;
import com.nokia.tools.variant.editor.summary.SummaryLeafGroup;
import com.nokia.tools.variant.editor.summary.SummaryParentGroup;

/**
 * This class is intended to be used for conversion of confml data from
 * VariantProject to View and back. Convertor is one purpose thing, which is
 * used especially for Carbide.V user interface.
 * 
 */
public class ConfmlApplicationModel2ViewModelConvertor {

	Map<String, Setting> absRef2SettingMap = new HashMap<String, Setting>();
	List<Option> notResolvedMapForOption = new ArrayList<Option>();
	private List<Option> optionsWithRelevant = new ArrayList<Option>();

	/**
	 * Converts values from EVariantProject to View.
	 * 
	 * @param vc
	 *            source of the conversion
	 * @param confmlViewId
	 *            is id of the confml view on which basis will be constructed
	 *            <code>View</code> of UI model
	 * 
	 * @return creates Confml view based on the values acquired from all layers
	 *         of the <code>vp</code> and view id on which it should be based
	 *         on.
	 */
	public View convert(EConfigurationProject vc) {

		// result view
		View view = ConfmlFactory.eINSTANCE.createView();

		// feature information processing
		createFeaturesForView(vc, view);

		EMap<String, EAppView> views = vc.getLastLayer().getViews();

		EList<EConfMLLayer> layers = vc.getLayers();
		int numLayers = layers.size();
		EConfMLLayer defaultValuesLayer = null;
		if (numLayers >= 2) {// default layer exists
			defaultValuesLayer = layers.get(numLayers - 2);
		}

		Set<EAppSetting> layerDefinedSettings = layerDefinedSettings(vc
				.getLastLayer());

		if (views.size() > 0) {

			EAppView appView = vc.getDefaultView();
			view.setName(appView.getName());
			createGroupsForSummary(view);
			EList<EAppGroup> groups = appView.getGroups();
			for (EAppGroup appGroup : groups) {
				ParentGroup parentGroup = createParentGroup(view, appGroup);
				EList<EAppSettingRef> appGroupSettings = appGroup.getSettings();
				for (EAppSettingRef appSettingRef : appGroupSettings) {
					convertSetting(absRef2SettingMap, defaultValuesLayer,
							layerDefinedSettings, parentGroup, appSettingRef);
				}
				EList<EAppGroup> subGroups = appGroup.getGroups();
				for (EAppGroup subGroup : subGroups) {
					LeafGroup createLeafGroup = createLeafGroup(parentGroup,
							subGroup);
					EList<EAppSettingRef> settings = subGroup.getSettings();
					for (EAppSettingRef appSettingRef : settings) {
						convertSetting(absRef2SettingMap, defaultValuesLayer,
								layerDefinedSettings, createLeafGroup,
								appSettingRef);
					}

				}

			}
			view.getSharedSettingInstances().addAll(absRef2SettingMap.values());
			processRemainsOptions();
			processOptionsWithRelevant(view);
			view.getSharedSettingInstances().addAll(
					getInvisibleSettings(vc, absRef2SettingMap,
							defaultValuesLayer, layerDefinedSettings).values());
			absRef2SettingMap.clear();
			absRef2SettingMap = null;
			
			
			return view;

		}
		processRemainsOptions();
		// processOptionsWithRelevant();
		absRef2SettingMap.clear();
		absRef2SettingMap = null;
		return null;
	}

	/**
	 * Check settings which is not in any group.
	 * 
	 * @param vc
	 * @param visibleSettings
	 * @return
	 */
	private Map<String, Setting> getInvisibleSettings(EConfigurationProject vc,
			Map<String, Setting> visibleSettings,
			EConfMLLayer defaultValuesLayer,
			Set<EAppSetting> layerDefinedSettings) {
		Map<String, Setting> invisibleSettings = new HashMap<String, Setting>();
		EMap<String, EAppFeature> features = vc.getLastLayer().getFeatures();
		for (Entry<String, EAppFeature> entry : features) {
			EMap<String, EAppSetting> settings = entry.getValue().getSettings();
			for (Entry<String, EAppSetting> entry2 : settings) {
				Setting setting = visibleSettings.get(entry.getKey() + "/"
						+ entry2.getKey());
				if (setting == null) {
					convertSetting(invisibleSettings, defaultValuesLayer,
							layerDefinedSettings, entry2.getValue());
				}
			}
		}
		return invisibleSettings;
	}

	private void processOptionsWithRelevant(View view) {
		for (Option option : optionsWithRelevant) {
			EObject container = option.eContainer();
			if (container instanceof Setting) {
				Setting optionParent = (Setting) container;
				Set<Setting> optionRelevantSettings = ConfMLExpressionSettingUtil
						.getSettingsRefFromOptionRelevant(view, optionParent,
								option.getRelevant());
				for (Setting relevantSetting : optionRelevantSettings) {
					EList<Setting> optionDependencies = relevantSetting
							.getOptionDependencies();
					if (optionDependencies == null) {
						relevantSetting
								.setOptionDependencies(new BasicEList<Setting>());
					}
					relevantSetting.getOptionDependencies().add(optionParent);
				}
			}
		}

	}

	private void processRemainsOptions() {
		for (Option option : notResolvedMapForOption) {
			// if (setting instanceof SimpleSetting) {
			// Option option = optionsMap.get(setting);
			Setting notifier = absRef2SettingMap.get(option.getMap());
			if (notifier != null && notifier instanceof SequenceSetting) {
				option.setMapSourceSetting((SequenceSetting) notifier);
			}
			// }
		}

	}

	/**
	 * Creates features from configuration project and ads them to view
	 * 
	 * @param vc
	 *            configuration project, contains application model and
	 *            persistence model
	 * @param view
	 *            view from view model which is converted from vc
	 */
	private void createFeaturesForView(EConfigurationProject vc, View view) {
		EMap<String, EAppFeature> features = vc.getLastLayer().getFeatures();
		Set<String> featureRefSet = features.keySet();
		Iterator<String> featureRefsIterator = featureRefSet.iterator();
		while (featureRefsIterator.hasNext()) {
			String nextFeatureRef = featureRefsIterator.next();
			EAppFeature appFeature = features.get(nextFeatureRef);

			Feature f = ConfmlFactory.eINSTANCE.createFeature();
			f.setName(appFeature.getName());
			f.setRef(nextFeatureRef);
			f.setDescription(appFeature.getDescription());
			f.setIconURI(appFeature.getIconURI());
			EAppExpression r = appFeature.getRelevant();
			if (r != null) {
				f.setRelevant(r.getLiteral());
			}
			view.getSharedFeatures().add(f);
		}
	}

	/**
	 * Creates view model setting from appSettingRef and ads it to
	 * createLeafgroup (view LeafGroup)
	 * 
	 * @param absRef2SettingMap
	 *            used to put created settings to ensure there is only one with
	 *            a absRef(works like setting id)
	 * @param defaultValuesLayer
	 *            Layer from application model , where we get default values
	 *            from
	 * @param layerDefinedSettings
	 *            application model settings defined in last layer
	 * @param createLeafGroup
	 *            view model LeafGroup, created from application model
	 * @param appSettingRef
	 *            "setting representation" in application model view
	 */

	private void convertSetting(Map<String, Setting> absRef2SettingMap,
			EConfMLLayer defaultValuesLayer,
			Set<EAppSetting> layerDefinedSettings, LeafGroup createLeafGroup,
			EAppSettingRef appSettingRef) {
		EAppSetting resolved = appSettingRef.getResolved();

		String overridenName = appSettingRef.getName();
		String description = appSettingRef.getDescription();

		if (resolved != null) {
			// setting exists in application model
			EAppSettingData data = resolved.getValueInfo();
			EAppSettingType type = resolved.getTypeInfo();
			String sid = ((EAppSettingEntryImpl) type.eContainer().eContainer())
					.getKey();
			String fid = ((EAppFeatureEntryImpl) type.eContainer().eContainer()
					.eContainer().eContainer()).getKey();

			String absRef = fid + "/" + sid;
			Setting s = null;
			if ((s = absRef2SettingMap.get(absRef)) != null) {
				// setting already exist and we use that one
				// shared instance of it
				createLeafGroup.getSettings().add(s);
				s.getLeafGroup().add(createLeafGroup);
			} else {
				// create shared instance of Setting and add it
				// to the LeafGroup
				if (type instanceof EAppSequenceType) {
					s = handleSequence(defaultValuesLayer, resolved, data,
							type, fid);
				} else if (type instanceof EAppResourceType) {
					s = handleFile(defaultValuesLayer, layerDefinedSettings,
							resolved, data, type, fid, absRef);

				} else if (type instanceof EAppSimpleType) {

					s = handleSimpleSetting(defaultValuesLayer,
							layerDefinedSettings, resolved, data, type, fid);
				} else if (type instanceof EAppCompositeType) {
					// only file above
				}

				// add Setting to LeafGroup
				createLeafGroup.getSettings().add(s);
				EObject e = type;
				while (!(e instanceof EAppFeature)) {
					e = e.eContainer();
				}
				EAppFeature feature = (EAppFeature) e;
				s.setFeatureName(feature.getName());
				s.getLeafGroup().add(createLeafGroup);
				// add Setting to absRef2SettingMap
				absRef2SettingMap.put(absRef, s);
				s.setAbsRef(absRef);
			}

			if (overridenName != null) {
				s.setName(overridenName);
				s.setNameOverride(overridenName);
			}
			if (description != null) {
				s.setDescription(description);
				s.setDescriptionOverride(description);
			}
		}
	}

	private void convertSetting(Map<String, Setting> absRef2SettingMap,
			EConfMLLayer defaultValuesLayer,
			Set<EAppSetting> layerDefinedSettings, EAppSetting resolved) {
		if (resolved != null) {
			// setting exists in application model
			EAppSettingData data = resolved.getValueInfo();
			EAppSettingType type = resolved.getTypeInfo();
			String sid = ((EAppSettingEntryImpl) type.eContainer().eContainer())
					.getKey();
			String fid = ((EAppFeatureEntryImpl) type.eContainer().eContainer()
					.eContainer().eContainer()).getKey();

			String overridenName = resolved.getRef();
			String description = type.getDescription();

			String absRef = fid + "/" + sid;
			Setting s = null;
			if ((s = absRef2SettingMap.get(absRef)) != null) {
				// setting already exist and we use that one
				// shared instance of it
			} else {
				// create shared instance of Setting and add it
				// to the LeafGroup
				if (type instanceof EAppSequenceType) {
					s = handleSequence(defaultValuesLayer, resolved, data,
							type, fid);
				} else if (type instanceof EAppResourceType) {
					s = handleFile(defaultValuesLayer, layerDefinedSettings,
							resolved, data, type, fid, absRef);

				} else if (type instanceof EAppSimpleType) {

					s = handleSimpleSetting(defaultValuesLayer,
							layerDefinedSettings, resolved, data, type, fid);
				} else if (type instanceof EAppCompositeType) {
					// only file above
				}

				EObject e = type;
				while (!(e instanceof EAppFeature)) {
					e = e.eContainer();
				}
				EAppFeature feature = (EAppFeature) e;
				s.setFeatureName(feature.getName());
				// add Setting to absRef2SettingMap
				absRef2SettingMap.put(absRef, s);
				s.setAbsRef(absRef);
			}

			if (overridenName != null) {
				s.setName(overridenName);
				s.setNameOverride(overridenName);
			}
			if (description != null) {
				s.setDescription(description);
				s.setDescriptionOverride(description);
			}
		}
	}

	/**
	 * Creates view model setting from appSettingRef and ads it to parentGroup
	 * (view ParentGroup)
	 * 
	 * @param absRef2SettingMap
	 *            used to put created settings to ensure there is only one with
	 *            a absRef(works like setting id)
	 * @param defaultValuesLayer
	 *            Layer from application model , where we get default values
	 *            from
	 * @param layerDefinedSettings
	 *            application model settings defined in last layer
	 * @param parentGroup
	 *            view model ParentGroup, created from application model
	 * @param appSettingRef
	 *            "setting representation" in application model view
	 */

	private void convertSetting(Map<String, Setting> absRef2SettingMap,
			EConfMLLayer defaultValuesLayer,
			Set<EAppSetting> layerDefinedSettings, ParentGroup parentGroup,
			EAppSettingRef appSettingRef) {
		EAppSetting resolved = appSettingRef.getResolved();

		String name = appSettingRef.getName();
		String description = appSettingRef.getDescription();

		if (resolved != null) {
			// setting exists in application model
			EAppSettingData data = resolved.getValueInfo();
			EAppSettingType type = resolved.getTypeInfo();
			String sid = ((EAppSettingEntryImpl) type.eContainer().eContainer())
					.getKey();
			String fid = ((EAppFeatureEntryImpl) type.eContainer().eContainer()
					.eContainer().eContainer()).getKey();

			String absRef = fid + "/" + sid;
			Setting s = null;
			if ((s = absRef2SettingMap.get(absRef)) != null) {
				// setting already exist and we use that one
				// shared instance of it
				parentGroup.getSettings().add(s);
				s.getParentGroup().add(parentGroup);
			} else {
				// create shared instance of Setting and add it
				// to the LeafGroup
				if (type instanceof EAppSequenceType) {
					s = handleSequence(defaultValuesLayer, resolved, data,
							type, fid);
				} else if (type instanceof EAppResourceType) {
					s = handleFile(defaultValuesLayer, layerDefinedSettings,
							resolved, data, type, fid, absRef);

				} else if (type instanceof EAppSimpleType) {

					s = handleSimpleSetting(defaultValuesLayer,
							layerDefinedSettings, resolved, data, type, fid);
				} else if (type instanceof EAppCompositeType) {
					// only file above
				}

				// add Setting to LeafGroup
				parentGroup.getSettings().add(s);
				EObject e = type;
				while (!(e instanceof EAppFeature)) {
					e = e.eContainer();
				}
				EAppFeature feature = (EAppFeature) e;
				s.setFeatureName(feature.getName());
				s.getParentGroup().add(parentGroup);
				// add Setting to absRef2SettingMap
				absRef2SettingMap.put(absRef, s);
				s.setAbsRef(absRef);
			}

			if (name != null) {
				s.setName(name);
				s.setNameOverride(name);
			}
			if (description != null) {
				s.setDescription(description);
				s.setDescriptionOverride(description);
			}
		}
	}

	/**
	 * Creates simple setting (from view model), sets its default value and
	 * containedInLastLayer attribute
	 * 
	 * @param defaultValuesLayer
	 *            Layer from application model, where default values are stored
	 * @param layerDefinedSettings
	 *            application model settings defined in last layer
	 * @param resolved
	 *            setting from application model
	 * @param data
	 *            contains values in application model
	 * @param type
	 *            contains other setting attributes
	 * @param fid
	 *            id of feature
	 * @return
	 */
	private Setting handleSimpleSetting(EConfMLLayer defaultValuesLayer,
			Set<EAppSetting> layerDefinedSettings, EAppSetting resolved,
			EAppSettingData data, EAppSettingType type, String fid) {
		Setting s;
		s = createSimpleSetting(data, type);

		if (layerDefinedSettings.contains(resolved)) {
			((SimpleSetting) s).setContainedInLastLayer(true);
			((SimpleSetting) s).setLastSavedInLastLayer(true);
		} else {
			((SimpleSetting) s).setContainedInLastLayer(false);
			((SimpleSetting) s).setLastSavedInLastLayer(false);
		}

		// simple type data
		if (defaultValuesLayer != null) {
			String ref = resolved.getRef();
			EAppFeature defaultFeature = defaultValuesLayer.getFeatures().get(
					fid);
			if (defaultFeature != null) {
				EAppSetting defaultSetting = defaultFeature.getSettings().get(
						ref);
				if (defaultSetting != null) {
					EAppSettingType defaultType = defaultSetting.getTypeInfo();
					EAppSettingData defaultValue = defaultSetting
							.getValueInfo();

					SimpleSetting defaultSimpleSetting = createSimpleSetting(
							defaultValue, defaultType);
					if (s != null && s instanceof SimpleSetting
							&& defaultSimpleSetting != null) {
						String defaultSimpleValue = defaultSimpleSetting
								.getValue();

						defaultSimpleValue = handleBooleanDefaultValue(
								defaultSimpleSetting, defaultSimpleValue);

						((SimpleSetting) s).setDefaultValue(defaultSimpleValue);
					}
				}
			}
		}
		return s;
	}

	/**
	 * We have to support booleans defined differently like 1,0 or TRUE,FALSE or
	 * standard true,false
	 * 
	 * @param defaultSimpleSetting
	 * @param defaultSimpleValue
	 * @return
	 */
	private String handleBooleanDefaultValue(
			SimpleSetting defaultSimpleSetting, String defaultSimpleValue) {
		if (defaultSimpleSetting.getType().equals(TYPE.BOOLEAN)) {
			if (defaultSimpleSetting.getValue() == null
					|| "".equals(defaultSimpleValue)) {
				return null;// ) {defaultSimpleValue = "false";
			} else if (defaultSimpleSetting.getValue().equalsIgnoreCase("0")) {
				defaultSimpleValue = "false";
			} else if (defaultSimpleSetting.getValue().equalsIgnoreCase("1")) {
				defaultSimpleValue = "true";
			} else if (defaultSimpleSetting.getValue()
					.equalsIgnoreCase("false")) {
				defaultSimpleValue = "false";
			} else if (defaultSimpleSetting.getValue().equalsIgnoreCase("true")) {
				defaultSimpleValue = "true";
			}
		}
		return defaultSimpleValue;
	}

	/**
	 * Create the file setting, fill in default values
	 * 
	 * @param defaultValuesLayer
	 * @param layerDefinedSettings
	 * @param resolved
	 * @param data
	 *            contains values in application model
	 * @param type
	 *            contains other setting attributes
	 * @param fid
	 *            id of feature
	 * @param absRef
	 *            absRes of the setting , which will be created, it is used like
	 *            an id
	 * @return
	 */
	private Setting handleFile(EConfMLLayer defaultValuesLayer,
			Set<EAppSetting> layerDefinedSettings, EAppSetting resolved,
			EAppSettingData data, EAppSettingType type, String fid,
			String absRef) {
		Setting s;
		s = createFileSetting(data, type, absRef);
		if (layerDefinedSettings.contains(resolved)) {
			((FileSystemEntrySetting) s).getSourceFilePath()
					.setContainedInLastLayer(true);
			((FileSystemEntrySetting) s).getTargetFilePath()
					.setContainedInLastLayer(true);
			((FileSystemEntrySetting) s).getSourceFilePath()
					.setLastSavedInLastLayer(true);
			((FileSystemEntrySetting) s).getTargetFilePath()
					.setLastSavedInLastLayer(true);
		}

		else {
			((FileSystemEntrySetting) s).getSourceFilePath()
					.setContainedInLastLayer(false);
			((FileSystemEntrySetting) s).getTargetFilePath()
					.setContainedInLastLayer(false);
			((FileSystemEntrySetting) s).getSourceFilePath()
					.setLastSavedInLastLayer(false);
			((FileSystemEntrySetting) s).getTargetFilePath()
					.setLastSavedInLastLayer(false);
		}

		// file default data
		if (defaultValuesLayer != null) {
			String ref = resolved.getRef();
			EAppFeature defaultFeature = defaultValuesLayer.getFeatures().get(
					fid);
			if (defaultFeature != null) {
				EAppSetting defaultSetting = defaultFeature.getSettings().get(
						ref);
				if (defaultSetting != null) {
					EAppSettingType defaultType = defaultSetting.getTypeInfo();
					EAppSettingData defaultValue = defaultSetting
							.getValueInfo();

					FileSystemEntrySetting defaultFileSetting = createFileSetting(
							defaultValue, defaultType, absRef);
					if (s != null && s instanceof FileSystemEntrySetting
							&& defaultFileSetting != null) {
						((FileSystemEntrySetting) s).getSourceFilePath()
								.setDefaultPath(
										defaultFileSetting.getSourceFilePath()
												.getPath());
						((FileSystemEntrySetting) s).getSourceFilePath()
								.setDefaultPath(
										(defaultFileSetting.getSourceFilePath()
												.getPath()));
						((FileSystemEntrySetting) s).getTargetFilePath()
								.setDefaultPath(
										defaultFileSetting.getTargetFilePath()
												.getPath());
						((FileSystemEntrySetting) s).getTargetFilePath()
								.setDefaultPath(
										(defaultFileSetting.getTargetFilePath()
												.getPath()));

						FilePath targetFilePath = ((FileSystemEntrySetting) s)
								.getTargetFilePath();
						FilePath sourceFilePath = ((FileSystemEntrySetting) s)
								.getSourceFilePath();

						if (targetFilePath.getPath() == null) {
							targetFilePath.setPath(defaultFileSetting
									.getTargetFilePath().getPath());
							targetFilePath.setLastSavedPath(defaultFileSetting
									.getTargetFilePath().getPath());
							targetFilePath.setLastSavedInLastLayer(false);
							targetFilePath.setContainedInLastLayer(false);
						}
						if (sourceFilePath.getPath() == null) {
							sourceFilePath.setPath(defaultFileSetting
									.getSourceFilePath().getPath());
							sourceFilePath.setLastSavedPath(defaultFileSetting
									.getSourceFilePath().getPath());
							sourceFilePath.setLastSavedInLastLayer(false);
							sourceFilePath.setContainedInLastLayer(false);

						}

					}
				}
			}
		}
		return s;
	}

	/**
	 * Creates sequence setting and fills its default structure, which is used
	 * to recognize if setting is default
	 * 
	 * @param defaultValuesLayer
	 *            Layer where we get default values from
	 * @param resolved
	 *            application model setting
	 * @param data
	 *            contains values in application model
	 * @param type
	 *            contains other setting attributes
	 * @param fid
	 *            id of feature
	 * @return
	 */
	private Setting handleSequence(EConfMLLayer defaultValuesLayer,
			EAppSetting resolved, EAppSettingData data, EAppSettingType type,
			String fid) {
		Setting s;
		EAppSequenceType t = (EAppSequenceType) type;
		EAppSequenceData d = (EAppSequenceData) data;
		s = createSequenceSetting(d, t);

		// sequence default data
		if (defaultValuesLayer != null) {
			String ref = resolved.getRef();
			EAppFeature defaultFeature = defaultValuesLayer.getFeatures().get(
					fid);
			if (defaultFeature != null) {
				EAppSetting defaultSetting = defaultFeature.getSettings().get(
						ref);
				if (defaultSetting != null) {
					EAppSettingType defaultType = defaultSetting.getTypeInfo();
					EAppSettingData defaultValue = defaultSetting
							.getValueInfo();

					if (s instanceof SequenceSetting) {
						// setting was created, let´s fill the default structure
						SequenceSetting defaultSequenceSetting = createSequenceSetting(
								(EAppSequenceData) defaultValue,
								(EAppSequenceType) defaultType);
						if (defaultSequenceSetting != null) {
							((SequenceSetting) s).getDefaultStructure().addAll(
									((Collection<SequenceItem>) EcoreUtil
											.copyAll(defaultSequenceSetting
													.getSequenceItem())));
						}
					}
				}
			}
		}
		return s;
	}

	private void createGroupsForSummary(View view) {
		ParentGroup parentGroup = new SummaryParentGroup();
		view.getParentGroup().add(parentGroup);
		LeafGroup leafGroup = new SummaryLeafGroup(
				SummaryLeafGroup.TypeGroup.TITLE);
		parentGroup.getLeafGroup().add(leafGroup);
		leafGroup = new SummaryLeafGroup(SummaryLeafGroup.TypeGroup.ERRORS);
		parentGroup.getLeafGroup().add(leafGroup);
		leafGroup = new SummaryLeafGroup(SummaryLeafGroup.TypeGroup.NOTES);
		parentGroup.getLeafGroup().add(leafGroup);
		leafGroup = new SummaryLeafGroup(SummaryLeafGroup.TypeGroup.CHANGES);
		parentGroup.getLeafGroup().add(leafGroup);

	}

	private SequenceSetting createSequenceSetting(EAppSequenceData d,
			EAppSequenceType t) {

		SequenceSetting ss = convertSequenceType(t);
		ss.setReadOnly(t.isReadOnly());
		ss.setMapKey(t.getMapKey());
		ss.setMapValue(t.getMapValue());
		EMap<String, EAppSettingType> subsettingTypeMap = t.getTypeMap();

		// traversing application model
		if (d != null) {
			EList<EAppSequenceDataItem> sequenceItemsData = d.getItems();
			for (int i = 0; i < sequenceItemsData.size(); i++) {// for each item
				// confml ui model
				ss.getSequenceItem().add(
						createSequenceItem(subsettingTypeMap, sequenceItemsData
								.get(i)));
			}

			EAppSequenceDataItem template = d.getTemplate();

			if (template != null) {
				ss.setTemplate(createSequenceItem(subsettingTypeMap, template));
			} else {
				EMap<String, EAppSettingType> typeMap = t.getTypeMap();
				ss.setTemplate(createEmptySequenceItem(typeMap));
			}

		}
		Collection<SequenceItem> copyAll = EcoreUtil.copyAll(ss
				.getSequenceItem());

		ss.getLastSavedStructure().addAll(copyAll);
		return ss;
	}

	private SequenceItem createEmptySequenceItem(
			EMap<String, EAppSettingType> typeMap) {
		SequenceItem si = ConfmlFactory.eINSTANCE.createSequenceItem();
		for (int i = 0; i < typeMap.size(); i++) {
			EAppSettingType value = typeMap.get(i).getValue();
			Setting setting = createEmptySetting(value);

			if (setting != null) {
				si.getSetting().add(setting);
			}

		}
		return si;
	}

	private SequenceItem createSequenceItem(
			EMap<String, EAppSettingType> subsettingTypeMap,
			EAppSequenceDataItem sequenceItemsData) {
		SequenceItem si = ConfmlFactory.eINSTANCE.createSequenceItem();
		// traversing application model

		EMap<String, EAppSettingData> subSettingsData = sequenceItemsData
				.getSubSettings();
		for (int j = 0; j < subSettingsData.size(); j++) {// for
			// each
			// sub
			// -setting
			// data
			EAppSettingData ssd = subSettingsData.get(j).getValue();
			String subSettingRef = subSettingsData.get(j).getKey();
			if (ssd instanceof EAppSimpleData) {
				// confml ui model
				SimpleSetting subsetting = createSimpleSetting(ssd,
						subsettingTypeMap.get(subSettingRef));
				si.getSetting().add(subsetting);
				String absRef = subsetting.getAbsRef();
				String substring = absRef.substring(0, absRef.lastIndexOf('/'));
				absRef = substring + "/" + subSettingRef;
				subsetting.setAbsRef(absRef);
			} else if (ssd instanceof EAppResourceData) {
				EAppSettingType type = subsettingTypeMap.get(subSettingRef);
				Setting subsetting = createFileSetting(ssd, type,
						findAbsRef(type));
				si.getSetting().add(subsetting);
			}

		}
		return si;
	}

	private SequenceSetting convertSequenceType(EAppSequenceType t) {
		String description = t.getDescription();

		Integer maxOccurs = t.getMaxOccurs();
		Integer minOccurs = t.getMinOccurs();
		String sname = t.getName();

		// create UI SequenceSetting
		SequenceSetting ss = ConfmlFactory.eINSTANCE.createSequenceSetting();
		ss.setType(TYPE.SEQUENCE);

		ss.setRequired(t.isRequired());

		if (description != null) {
			ss.setDescription(description);
		}
		if (maxOccurs != null) {
			ss.setMaxOccurs(maxOccurs);
		}
		if (minOccurs != null) {
			ss.setMinOccurs(minOccurs);
		}
		ss.setName(sname);

		EAppExpression c = t.getConstraint();
		if (c != null) {
			String constraint = c.getLiteral();
			ss.setConstraint(constraint);
		}

		EAppExpression r = t.getRelevant();
		if (r != null) {
			String relevant = r.getLiteral();
			ss.setRelevant(relevant);
		}

		return ss;
	}

	private FileSystemEntrySetting createFileSetting(EAppSettingData data,
			EAppSettingType type, String absRef) {

		if (type instanceof EAppResourceType
				&& data instanceof EAppResourceData) {
			EAppResourceData resourceData = (EAppResourceData) data;
			EAppSimpleData appSimpleData = (EAppSimpleData) resourceData
					.getLocalPath();
			String sourcePath = appSimpleData.getValue();

			EAppSimpleData appSimpleData1 = (EAppSimpleData) resourceData
					.getTargetPath();

			String targetPath = appSimpleData1.getValue();

			FileSystemEntrySetting fileSetting = createFileSetting(
					(EAppResourceType) type, absRef, sourcePath, targetPath);
			FilePath sourceFilePath = fileSetting.getSourceFilePath();
			EAppSettingType localPath = ((EAppResourceType) type)
					.getLocalPath();
			if (sourceFilePath != null) {
				addOptions(sourceFilePath, ((EAppSimpleType) localPath)
						.getOptions());
			}

			return fileSetting;
		} else {
			return null;
		}
	}

	private FileSystemEntrySetting createFileSetting(EAppResourceType fileType,
			String absRef, String sourcePath, String targetPath) {

		FileSystemEntrySetting fileSetting = ConfmlFactory.eINSTANCE
				.createFileSystemEntrySetting();
		fileSetting.setFile(fileType.isFile());
		fileSetting.setAbsRef(absRef);
		// refactoring FileSystemSettingEntry
		FilePath sourceFilePath = ConfmlFactory.eINSTANCE.createFilePath();
		FilePath targetFilePath = ConfmlFactory.eINSTANCE.createFilePath();
		sourceFilePath.setParent(fileSetting);
		targetFilePath.setParent(fileSetting);
		sourceFilePath.setType(TYPE.FILESOURCE);
		targetFilePath.setType(TYPE.FILETARGET);
		sourceFilePath.setAbsRef(absRef);
		targetFilePath.setAbsRef(absRef);
		fileSetting.setSourceFilePath(sourceFilePath);
		fileSetting.setTargetFilePath(targetFilePath);

		if (fileType.isRequired()) {
			sourceFilePath.setRequired(true);
			targetFilePath.setRequired(true);
		} else {
			sourceFilePath.setRequired(fileType.getLocalPath().isRequired());
			targetFilePath.setRequired(fileType.getTargetPath().isRequired());
		}
		if (fileType.getLocalPath() instanceof EAppSimpleType) {
			EList<String> pattern = ((EAppSimpleType) fileType.getLocalPath())
					.getPattern();
			if (pattern.size() > 0)
				sourceFilePath.setPattern(pattern.get(0));
		}
		if (fileType.getTargetPath() instanceof EAppSimpleType) {
			EList<String> pattern = ((EAppSimpleType) fileType.getTargetPath())
					.getPattern();
			if (pattern.size() > 0)
				targetFilePath.setPattern(pattern.get(0));
		}

		EAppExpression c0 = fileType.getConstraint();
		if (c0 != null) {
			String constraint = c0.getLiteral();
			fileSetting.setConstraint(constraint);
		}

		EAppExpression c = fileType.getLocalPath().getConstraint();
		if (c != null) {
			String constraint = c.getLiteral();
			sourceFilePath.setConstraint(constraint);

		}

		EAppExpression c2 = fileType.getTargetPath().getConstraint();
		if (c2 != null) {
			String constraint = c2.getLiteral();
			targetFilePath.setConstraint(constraint);

		}

		EAppExpression r = fileType.getRelevant();
		if (r != null) {
			String relevant = r.getLiteral();
			fileSetting.setRelevant(relevant);
		}

		EAppExpression r1 = fileType.getLocalPath().getRelevant();
		if (r1 != null) {
			String relevant = r1.getLiteral();
			sourceFilePath.setRelevant(relevant);
		}
		EAppExpression r2 = fileType.getTargetPath().getRelevant();
		if (r2 != null) {
			String relevant = r2.getLiteral();
			targetFilePath.setRelevant(relevant);
		}

		if (fileType.isReadOnly()) {
			sourceFilePath.setPathReadOnly(true);
			targetFilePath.setPathReadOnly(true);
		} else {
			sourceFilePath
					.setPathReadOnly(fileType.getLocalPath().isReadOnly());
			targetFilePath.setPathReadOnly(fileType.getTargetPath()
					.isReadOnly());
		}

		if (fileType.getLocalPath().getDescription() == null) {
			sourceFilePath.setDescription(fileType.getDescription());
		} else {
			sourceFilePath.setDescription(fileType.getLocalPath()
					.getDescription());
		}

		if (fileType.getTargetPath().getDescription() == null) {
			targetFilePath.setDescription(fileType.getDescription());
		} else {
			targetFilePath.setDescription(fileType.getTargetPath()
					.getDescription());
		}

		// if not exist name for setting, use ref as name

		if (fileType.getName() != null) {
			fileSetting.setName(fileType.getName());
		} else {

			EObject container = fileType.eContainer().eContainer();
			if (container instanceof EAppSettingEntryImpl) {
				EAppSettingEntryImpl impl = (EAppSettingEntryImpl) container;
				fileSetting.setName(impl.getTypedKey());
			}
		}
		fileSetting.setRequired(fileType.isRequired());
		fileSetting.setReadOnly(fileType.isReadOnly());
		fileSetting.setType(TYPE.FILE);
		// if (sourcePath == null) {
		// fileSetting.setValueNull(true);
		// }

		sourceFilePath.setPath(sourcePath);
		targetFilePath.setPath(targetPath);

		sourceFilePath.setLastSavedPath(sourcePath);
		targetFilePath.setLastSavedPath(targetPath);

		sourceFilePath.setValueNull((sourcePath == null) ? true : false);
		targetFilePath.setValueNull((targetPath == null) ? true : false);

		fileSetting.setDescription(fileType.getDescription());

		EList<EAppProperty> properties = fileType.getProperties();
		for (EAppProperty appProperty : properties) {
			Property property = ConfmlFactory.eINSTANCE.createProperty();

			property.setName(appProperty.getName());
			property.setValue(appProperty.getValue());
			property.setUnit(appProperty.getUnit());

			fileSetting.getProperty().add(property);
		}

		return fileSetting;

	}

	private Setting createEmptySetting(EAppSettingType type) {

		if (type instanceof EAppSimpleType) {
			return createSimpleSetting((EAppSimpleType) type, "");
		} else if (type instanceof EAppResourceType) {
			FileSystemEntrySetting file = createFileSetting(
					(EAppResourceType) type, findAbsRef(type), "", "");
			file.eAdapters().add(new Adapter() {

				public Notifier getTarget() {

					return null;
				}

				public boolean isAdapterForType(Object type) {

					return false;
				}

				public void notifyChanged(Notification notification) {
					System.out.println(notification);

				}

				public void setTarget(Notifier newTarget) {

				}
			});
			return file;
		}
		return null;
	}

	private String findAbsRef(EObject obj) {
		if (obj instanceof EAppSettingEntryImpl) {
			return (findAbsRef(obj.eContainer()).concat("/")
					.concat(((EAppSettingEntryImpl) obj).getKey()));
		} else if (obj instanceof EAppSettingTypeEntryImpl) {
			return (findAbsRef(obj.eContainer()).concat("/")
					.concat(((EAppSettingTypeEntryImpl) obj).getKey()));
		} else if (obj instanceof EAppFeatureEntryImpl) {
			return ((EAppFeatureEntryImpl) obj).getKey();
		} else {
			return findAbsRef(obj.eContainer());
		}

	}

	private SimpleSetting createSimpleSetting(EAppSettingData data,
			EAppSettingType type) {

		String value = null;
		if (data instanceof EAppSimpleData && type instanceof EAppSimpleType) {
			EAppSimpleData simpleData = (EAppSimpleData) data;
			// data.ChangeableLabelFieldEditor
			String map = simpleData.getMap();
			if (map != null) {
				map = map.replace("[@key=\'", OptionImpl.OPTION_MAP_KEY)
						.replace("']", "").concat("\"]");
				int index = map.lastIndexOf("'");
				if (index > 0) {
					map = map.substring(0, index);
				}
			}
			// confml v2
			if (map != null) {
				value = map;
			}
			// confml v1
			else {
				value = simpleData.getValue();
			}

			return createSimpleSetting((EAppSimpleType) type, value);
		}
		return null;
	}

	private SimpleSetting createSimpleSetting(EAppSimpleType simpleType,
			String value) {
		// SORT value for multiselection
		if (simpleType.getType().getValue() == TYPE.MULTISELECTION_VALUE) {
			value = SettingValueUtils.sortMultiSelectionValue(value);
		}

		SimpleSetting simpleSetting = ConfmlFactory.eINSTANCE
				.createSimpleSetting();
		simpleSetting.setReadOnly(simpleType.isReadOnly());
		simpleSetting.setRequired(simpleType.isRequired());

		EAppExpression c = simpleType.getConstraint();
		if (c != null) {
			String constraint = c.getLiteral();
			simpleSetting.setConstraint(constraint);
		}

		EAppExpression r = simpleType.getRelevant();
		if (r != null) {
			String relevant = r.getLiteral();
			simpleSetting.setRelevant(relevant);
		}

		EObject container = simpleType.eContainer().eContainer().eContainer()
				.eContainer();
		if (container instanceof EAppFeatureEntryImpl) {
			String fid = ((EAppFeatureEntryImpl) container).getKey();
			String sid = ((EAppSettingEntryImpl) simpleType.eContainer()
					.eContainer()).getKey();
			simpleSetting.setAbsRef(fid + "/" + sid);
		} else if (container instanceof EAppSettingEntryImpl) {
			String fid = ((EAppFeatureEntryImpl) container.eContainer()
					.eContainer()).getKey();
			String sid = ((EAppSettingEntryImpl) container).getKey();
			String ssid = ((EAppSettingTypeEntryImpl) simpleType.eContainer())
					.getKey();
			simpleSetting.setAbsRef(fid + "/" + sid + "/" + ssid);
		}
		String simpleTypeName = simpleType.getName();
		simpleSetting.setName(simpleTypeName);
		
		EList<EAppSettingOption> options = simpleType.getOptions();

		addOptions(simpleSetting, options);
		
		if (value != null) {
			simpleSetting.setValue(value);
			simpleSetting.setLastSavedValue(value);
		} else {
			simpleSetting.setValueNull(true);
		}
		simpleSetting.setDescription(simpleType.getDescription());
		EAppValueType typeOfSimpleType = simpleType.getType();
		if (typeOfSimpleType != null) {
			int value2 = typeOfSimpleType.getValue();
			if (value2 == EAppValueType.DECIMAL_VALUE) {
				simpleSetting.setType(TYPE.REAL);
			}
			if (value2 == EAppValueType.STRING_VALUE) {
				simpleSetting.setType(TYPE.STRING);
			}
			if (value2 == EAppValueType.INTEGER_VALUE) {
				simpleSetting.setType(TYPE.INT);
			}
			if (value2 == EAppValueType.BOOLEAN_VALUE) {
				simpleSetting.setType(TYPE.BOOLEAN);
				if (simpleSetting.getValue() == null
						|| "".equals(simpleSetting.getValue())) {
					simpleSetting.setValue(null);
					simpleSetting.setValueNull(true);
					simpleSetting.setLastSavedValue(simpleSetting.getValue());
				} else if (simpleSetting.getValue().equalsIgnoreCase("0")) {
					simpleSetting.setValue("false");
					simpleSetting.setLastSavedValue(simpleSetting.getValue());
				} else if (simpleSetting.getValue().equalsIgnoreCase("1")) {
					simpleSetting.setValue("true");
					simpleSetting.setLastSavedValue(simpleSetting.getValue());
				} else if (simpleSetting.getValue().equalsIgnoreCase("false")) {
					simpleSetting.setValue("false");
					simpleSetting.setLastSavedValue(simpleSetting.getValue());
				} else if (simpleSetting.getValue().equalsIgnoreCase("true")) {
					simpleSetting.setValue("true");
					simpleSetting.setLastSavedValue(simpleSetting.getValue());
				}
			}
			if (value2 == EAppValueType.SELECTION_VALUE) {
				simpleSetting.setType(TYPE.SELECTION);
			}
			if (value2 == EAppValueType.MULTISELECTION_VALUE) {
				simpleSetting.setType(TYPE.MULTISELECTION);
			}
			if (value2 == EAppValueType.DATE_VALUE) {
				simpleSetting.setType(TYPE.DATE);
			}
			if (value2 == EAppValueType.DATETIME_VALUE) {
				simpleSetting.setType(TYPE.DATE_TIME);
			}
			if (value2 == EAppValueType.TIME_VALUE) {
				simpleSetting.setType(TYPE.TIME);
			}
			if (value2 == EAppValueType.DURATION_VALUE) {
				simpleSetting.setType(TYPE.DURATION);
			}
			if (value2 == EAppValueType.LOCAL_FILE_VALUE) {
				simpleSetting.setType(TYPE.SIMPLE_FILE);
			}
			if (value2 == EAppValueType.LOCAL_FOLDER_VALUE) {
				simpleSetting.setType(TYPE.SIMPLE_FOLDER);
			}
			if (value != null) {
				if (simpleSetting.getType() == TYPE.DATE_TIME) {
					simpleSetting.setValue(dateTimeCorrection(value));
					simpleSetting.setLastSavedValue(dateTimeCorrection(value));
				}
			} else {
				simpleSetting.setValueNull(true);
			}
		}

		if (simpleSetting.getType() != TYPE.DATE
				&& simpleSetting.getType() != TYPE.DATE_TIME
				&& simpleSetting.getType() != TYPE.TIME
				&& simpleSetting.getType() != TYPE.DURATION) {

			// min(max)Inclusive, min(max)Exclusive
			if (simpleType.getMinInclusive() != null) {
				BigDecimal minIncValue = (BigDecimal) simpleType
						.getMinInclusive();
				MinInclusive minInclusive = ConfmlFactory.eINSTANCE
						.createMinInclusive();
				minInclusive.setValue(minIncValue);
				simpleSetting.setMinInclusive(minInclusive);
			}

			if (simpleType.getMaxInclusive() != null) {
				BigDecimal maxIncValue = (BigDecimal) simpleType
						.getMaxInclusive();
				MaxInclusive maxInclusive = ConfmlFactory.eINSTANCE
						.createMaxInclusive();
				maxInclusive.setValue(maxIncValue);
				simpleSetting.setMaxInclusive(maxInclusive);
			}

			if (simpleType.getMinExclusive() != null) {
				BigDecimal minExclValue = (BigDecimal) simpleType
						.getMinExclusive();
				MinExclusive minExclusive = ConfmlFactory.eINSTANCE
						.createMinExclusive();
				minExclusive.setValue(minExclValue);
				simpleSetting.setMinExclusive(minExclusive);
			}

			if (simpleType.getMaxExclusive() != null) {
				BigDecimal maxExclValue = (BigDecimal) simpleType
						.getMaxExclusive();
				MaxExclusive maxExclusive = ConfmlFactory.eINSTANCE
						.createMaxExclusive();
				maxExclusive.setValue(maxExclValue);
				simpleSetting.setMaxExclusive(maxExclusive);
			}

			// min, max length
			if (simpleType.getLength() != null) {
				simpleSetting.setLength(BigInteger.valueOf(simpleType
						.getLength()));
			}

			if (simpleType.getMinLength() != null) {
				simpleSetting.setMinLength(BigInteger.valueOf(simpleType
						.getMinLength()));
			}

			if (simpleType.getMaxLength() != null) {
				simpleSetting.setMaxLength(BigInteger.valueOf(simpleType
						.getMaxLength()));
			}

			// pattern
			if (simpleType.getPattern().size() > 0) {
				String pattern = simpleType.getPattern().get(0);
				simpleSetting.setPattern(pattern);
			}

			// total digits
			if (simpleType.getTotalDigits() != null) {
				simpleSetting.setTotalDigits(BigInteger.valueOf(simpleType
						.getTotalDigits()));
			}
		}

		if (simpleSetting.getType() == TYPE.DATE
				|| simpleSetting.getType() == TYPE.DATE_TIME
				|| simpleSetting.getType() == TYPE.TIME
				|| simpleSetting.getType() == TYPE.DURATION) {

			// min(max)Inclusive, min(max)Exclusive
			if (simpleType.getMinInclusive() != null) {
				Object minIncValue = simpleType.getMinInclusive();
				MinInclusive minInclusive = ConfmlFactory.eINSTANCE
						.createMinInclusive();
				minInclusive.setValue(minIncValue);
				simpleSetting.setMinInclusive(minInclusive);
			}

			if (simpleType.getMaxInclusive() != null) {
				Object maxIncValue = simpleType.getMaxInclusive();
				MaxInclusive maxInclusive = ConfmlFactory.eINSTANCE
						.createMaxInclusive();
				maxInclusive.setValue(maxIncValue);
				simpleSetting.setMaxInclusive(maxInclusive);
			}

			if (simpleType.getMinExclusive() != null) {
				Object minExclValue = simpleType.getMinExclusive();
				MinExclusive minExclusive = ConfmlFactory.eINSTANCE
						.createMinExclusive();
				minExclusive.setValue(minExclValue);
				simpleSetting.setMinExclusive(minExclusive);
			}

			if (simpleType.getMaxExclusive() != null) {
				Object maxExclValue = simpleType.getMaxExclusive();
				MaxExclusive maxExclusive = ConfmlFactory.eINSTANCE
						.createMaxExclusive();
				maxExclusive.setValue(maxExclValue);
				simpleSetting.setMaxExclusive(maxExclusive);
			}

			// pattern
			if (simpleType.getPattern().size() > 0) {
				String pattern = simpleType.getPattern().get(0);
				simpleSetting.setPattern(pattern);
			}
		}

		EList<EAppProperty> properties = simpleType.getProperties();
		for (EAppProperty appProperty : properties) {
			Property property = ConfmlFactory.eINSTANCE.createProperty();

			property.setName(appProperty.getName());
			property.setValue(appProperty.getValue());
			property.setUnit(appProperty.getUnit());

			simpleSetting.getProperty().add(property);
		}

		return simpleSetting;
	}

	private void addOptions(Setting simpleSetting,
			EList<EAppSettingOption> options) {
		for (EAppSettingOption appSettingOption : options) {
			String literalValue = appSettingOption.getLiteralValue();
			String name = appSettingOption.getName();
			Option option = ConfmlFactory.eINSTANCE.createOption();
			option.setName(name);
			option.setValue(literalValue);
			EAppExpression relevant = appSettingOption.getRelevant();
			if (relevant != null) {
				String literal = relevant.getLiteral();
				if (literal != null) {
					option.setRelevant(literal);
					optionsWithRelevant.add(option);
				}

			}
			String map = appSettingOption.getRefValue();
			if (map != null) {
				option.setMap(map);
				Setting setting = absRef2SettingMap.get(map);
				if (setting != null && setting instanceof SequenceSetting) {
					option.setMapSourceSetting((SequenceSetting) setting);
				} else {
					notResolvedMapForOption.add(option);
				}
			}
			simpleSetting.getOption().add(option);
		}
	}

	private String dateTimeCorrection(String dateTime) {
		String correctedDateTime;
		if (dateTime.length() > 10) {
			if (dateTime.charAt(10) == '-') {
				StringBuilder sb = new StringBuilder(dateTime);
				sb.setCharAt(10, 'T');
				correctedDateTime = sb.toString();
			} else {
				correctedDateTime = dateTime;
			}
		} else {
			correctedDateTime = dateTime;
		}
		return correctedDateTime;
	}

	@SuppressWarnings("unused")
	private class SettingOptionAdapter extends EContentAdapter {
		private Notifier notifier;

		public SettingOptionAdapter(Notifier notifier) {
			this.notifier = notifier;
		}

		@Override
		public void notifyChanged(Notification notification) {
			notifier.eNotify(notification);
			super.notifyChanged(notification);
		}
	}

	private LeafGroup createLeafGroup(ParentGroup parentGroup,
			EAppGroup subGroup) {
		LeafGroup createLeafGroup = ConfmlFactory.eINSTANCE.createLeafGroup();
		parentGroup.getLeafGroup().add(createLeafGroup);
		createLeafGroup.setName(subGroup.getName());
		createLeafGroup.setDesc(subGroup.getDescription());
		URI subGroupIconUri = subGroup.getIconURI();

		if (subGroupIconUri != null) {
			String title = subGroup.getIconTitle();
			Icon icon = ConfmlFactory.eINSTANCE.createIcon();
			createLeafGroup.getIcon().add(icon);
			icon.setFilePath(subGroupIconUri.toString());
			icon.setTitle(title);

		}
		return createLeafGroup;
	}

	private ParentGroup createParentGroup(View view, EAppGroup appGroup) {
		ParentGroup parentGroup = ConfmlFactory.eINSTANCE.createParentGroup();
		view.getParentGroup().add(parentGroup);
		String parentGroupName = appGroup.getName();
		String parentGroupDesc = appGroup.getDescription();
		URI iconUri = appGroup.getIconURI();
		String iconTitle = appGroup.getIconTitle();
		parentGroup.setName(parentGroupName);
		parentGroup.setDesc(parentGroupDesc);
		if (iconUri != null) {
			Icon parentGroupIcon = ConfmlFactory.eINSTANCE.createIcon();
			parentGroupIcon.setFilePath(iconUri.toString());
			parentGroupIcon.setTitle(iconTitle);
			parentGroup.getIcon().add(parentGroupIcon);
		}
		return parentGroup;
	}

	public Set<EAppSetting> layerDefinedSettings(EConfMLLayer layer) {
		Set<EAppSetting> setSettings = new HashSet<EAppSetting>();
		Set<URI> layerFiles = new HashSet<URI>();
		layerFiles.add(layer.getRootConfml());
		for (EAppIncludeElement include : layer.getIncludes()) {
			layerFiles.add(include.getTarget());
		}
		for (Map.Entry<String, EAppFeature> featureEntry : layer.getFeatures()) {
			EAppFeature appFeature = featureEntry.getValue();
			for (Map.Entry<String, EAppSetting> settingEntry : appFeature
					.getSettings()) {
				EAppSetting setting = settingEntry.getValue();
				for (URI uri : setting.getValueInfo().getUri()) {
					uri = uri.trimFragment();
					if (layerFiles.contains(uri)) {
						setSettings.add(setting);
						break;
					}
				}
			}
		}
		return setSettings;
	}
}
