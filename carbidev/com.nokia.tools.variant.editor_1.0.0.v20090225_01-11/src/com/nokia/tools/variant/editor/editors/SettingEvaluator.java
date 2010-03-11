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

package com.nokia.tools.variant.editor.editors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.nokia.tools.variant.content.confml.Feature;
import com.nokia.tools.variant.content.confml.FilePath;
import com.nokia.tools.variant.content.confml.FileSystemEntrySetting;
import com.nokia.tools.variant.content.confml.LeafGroup;
import com.nokia.tools.variant.content.confml.ParentGroup;
import com.nokia.tools.variant.content.confml.SequenceItem;
import com.nokia.tools.variant.content.confml.SequenceSetting;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.SimpleSetting;
import com.nokia.tools.variant.content.confml.View;
import com.nokia.tools.variant.editor.adapters.SettingToErrorAdapter;
import com.nokia.tools.variant.editor.model.UISetting;
import com.nokia.tools.variant.editor.validation.SettingsValidator;
import com.nokia.tools.variant.resourcelibrary.model.ResourceModelRoot;
import com.nokia.tools.variant.viewer.validation.EResult;
import com.nokia.tools.variant.viewer.validation.ValidationResult;
import com.nokia.tools.variant.views.errormodel.Error;
import com.nokia.tools.variant.views.errormodel.ErrormodelFactory;
import com.nokia.tools.variant.views.errormodel.ErrorsRoot;

public class SettingEvaluator {

	public static boolean reevaluateRelevantForSettings(View view,
			List<Setting> settings) {
		boolean relevantChange = false;
		List<String> groupFeatureRefs = new ArrayList<String>();
		// settings which are non-relevant because of feature relevant
		// computation
		Set<Setting> filteredSettings = new HashSet<Setting>();

		Map<String, List<Setting>> m = new HashMap<String, List<Setting>>();
		EList<Feature> sharedFeatures = view.getSharedFeatures();
		for (Feature f : sharedFeatures) {
			m.put(f.getRef(), new ArrayList<Setting>());
		}

		int size = settings.size();
		for (int i = 0; i < size; i++) {
			Setting setting = settings.get(i);
			String featureRef = setting.getFeatureRef();
			List<Setting> list = m.get(featureRef);
			list.add(setting);
		}

		// check features' relevant change
		int featuresSize = sharedFeatures.size();
		for (int i = 0; i < featuresSize; i++) {
			Feature feature = sharedFeatures.get(i);
			boolean featureRelevant = ConfMLExpressionEvaluationUtil
					.evaluateFeatureRelevantValid(feature);
			feature.setComputedRelevant(featureRelevant);

			if (!featureRelevant) {
				List<Setting> list = m.get(feature.getRef());
				for (Setting s : list) {
					filteredSettings.add(s);
				}
			}

		}

		// check LeafGroup's settings relevant change
		for (Setting setting : view.getSharedSettingInstances()) {
			if (!groupFeatureRefs.contains(setting.getFeatureRef())) {
				continue;
			}

			boolean isComputedRelevant = setting.isComputedRelevant();

			// Top level setting evaluation
			boolean evaluateSettingRelevant = ConfMLExpressionEvaluationUtil
					.evaluateSettingRelevant(setting);

			boolean relevantBecauseOfFeature = !filteredSettings
					.contains(setting);
			boolean value = evaluateSettingRelevant && relevantBecauseOfFeature;
			if (setting.isComputedRelevant() != value) {
				setting.setComputedRelevant(value);
				relevantChange = true;
			}

			if (isComputedRelevant != setting.isComputedRelevant()) {
				if (settings.contains(setting)) {
					relevantChange = true;
				}
			}

			// sequence item evaluation
			if (setting instanceof SequenceSetting) {
				SequenceSetting ss = (SequenceSetting) setting;

				EList<SequenceItem> sequenceItems = ss.getSequenceItem();
				int itemsCount = sequenceItems.size();
				for (int i = 0; i < itemsCount; i++) {
					SequenceItem si = sequenceItems.get(i);

					// sub settings
					EList<Setting> subsettings = si.getSetting();

					int subsettingsCount = subsettings.size();
					for (int j = 0; j < subsettingsCount; j++) {
						Setting subsetting = subsettings.get(j);

						boolean relevant = ConfMLExpressionEvaluationUtil
								.evaluateSettingRelevant(subsetting);
						if (relevant != subsetting.isComputedRelevant()) {
							if (settings.contains(setting)) {
								relevantChange = true;
							}
							subsetting.setComputedRelevant(relevant);
						}

					}
				}
			}
		}

		return relevantChange;
	}

	/**
	 * Initializes relevant computation for a whole view model.
	 * 
	 * @param view
	 *            containing all settings and features
	 * @return 
	 */
	public static boolean initRelevantForWholeModel(View view,
			boolean computeDependencies) {
		boolean relevantChange = false;
		// filer settings which has their's feature filtered
		// check features in LeafGroup
		List<Feature> featuresInView = view.getSharedFeatures();
		for (Feature feature : featuresInView) {
			boolean computedRelevant = ConfMLExpressionEvaluationUtil
					.evaluateFeatureRelevantValid(feature);
			if (computedRelevant != feature.isComputedRelevant()) {
				feature.setComputedRelevant(computedRelevant);
				relevantChange = true;
			}
			if (computeDependencies) {
				ConfMLExpressionSettingUtil.setSettingDependencies(view,
						feature);
			}
		}
		Map<String, Feature> settingRefFeatureMap = new HashMap<String, Feature>();
		EList<Feature> sharedFeatures = view.getSharedFeatures();
		for (int i = 0; i < sharedFeatures.size(); i++) {
			settingRefFeatureMap.put(sharedFeatures.get(i).getRef(),
					sharedFeatures.get(i));
		}
		for (Setting setting : view.getSharedSettingInstances()) {
			// Top level setting evaluation
			boolean evaluateSettingRelevant = ConfMLExpressionEvaluationUtil
					.evaluateSettingRelevant(setting);
			// find feature for setting and its computed relevant

			Feature feature = settingRefFeatureMap.get(setting.getFeatureRef());

			if (feature != null) {
				evaluateSettingRelevant = evaluateSettingRelevant
						&& feature.isComputedRelevant();
			}
			if (setting.isComputedRelevant() != evaluateSettingRelevant) {
				setting.setComputedRelevant(evaluateSettingRelevant);
				relevantChange = true;
			}
			if (computeDependencies) {
				ConfMLExpressionSettingUtil.setSettingDependencies(view,
						setting);
			}

			// sequence item evaluation
			if (setting instanceof SequenceSetting) {
				SequenceSetting ss = (SequenceSetting) setting;

				EList<SequenceItem> sequenceItems = ss.getSequenceItem();
				for (int i = 0; i < sequenceItems.size(); i++) {
					SequenceItem si = sequenceItems.get(i);

					// sub settings
					EList<Setting> subsettings = si.getSetting();

					for (int j = 0; j < subsettings.size(); j++) {
						Setting subsetting = subsettings.get(j);

						boolean relevant = ConfMLExpressionEvaluationUtil
								.evaluateSettingRelevant(subsetting);
						if (subsetting.isComputedRelevant() != relevant) {
							subsetting.setComputedRelevant(relevant);
							relevantChange = true;
						}
						if (computeDependencies) {
							ConfMLExpressionSettingUtil.setSettingDependencies(

							view, subsetting);
						}
					}
				}
			}
			if (setting instanceof FileSystemEntrySetting) {
				FileSystemEntrySetting fileSystemEntrySetting = (FileSystemEntrySetting) setting;
				FilePath sourceFilePath = fileSystemEntrySetting
						.getSourceFilePath();
				FilePath targetFilePath = fileSystemEntrySetting
						.getTargetFilePath();
				if (sourceFilePath != null) {
					boolean relevant = ConfMLExpressionEvaluationUtil
							.evaluateSettingRelevant(sourceFilePath);
					if (sourceFilePath.isComputedRelevant() != relevant) {
						sourceFilePath.setComputedRelevant(relevant);
						relevantChange = true;
					}
				}
				if (targetFilePath != null) {
					boolean relevant = ConfMLExpressionEvaluationUtil
							.evaluateSettingRelevant(targetFilePath);
					if (targetFilePath.isComputedRelevant() != relevant) {
						targetFilePath.setComputedRelevant(relevant);
						relevantChange = true;
					}
				}
			}
		}
		return relevantChange;
	}

	public static void validateConstraintAttributeForAllSettings(View view,
			ErrorsRoot errorsRoot, ResourceModelRoot rsm, CPFEditor cpfEditor) {
		EList<Setting> sharedSettingInstances = view
				.getSharedSettingInstances();
		for (int i = 0; i < sharedSettingInstances.size(); i++) {
			Setting setting = sharedSettingInstances.get(i);

			if (setting instanceof FileSystemEntrySetting) {
				// top level setting constraint validation
				
				boolean isConstraintValid = ConfMLExpressionEvaluationUtil
						.evaluateSettingConstraintValid(setting);
				if (setting.isComputedConstraint() != isConstraintValid) {
					setting.setComputedConstraint(isConstraintValid);
				}
				
				
				FilePath sourceFilePath = ((FileSystemEntrySetting) setting)
						.getSourceFilePath();
				 isConstraintValid = ConfMLExpressionEvaluationUtil
						.evaluateSettingConstraintValid(sourceFilePath);
				if (isConstraintValid != sourceFilePath.isComputedConstraint()) {
					sourceFilePath.setComputedConstraint(isConstraintValid);
				}
				updateErrorModelForSetting(errorsRoot, rsm, sourceFilePath,
						cpfEditor);

				FilePath targetFilePath = ((FileSystemEntrySetting) setting)
						.getTargetFilePath();
				isConstraintValid = ConfMLExpressionEvaluationUtil
						.evaluateSettingConstraintValid(targetFilePath);
				if (targetFilePath.isComputedConstraint() != isConstraintValid) {
					targetFilePath.setComputedConstraint(isConstraintValid);
				}
				updateErrorModelForSetting(errorsRoot, rsm, targetFilePath,
						cpfEditor);


				//updateErrorModelForSetting(errorsRoot, rsm, setting, cpfEditor);
			} else {
				// top level setting constraint validation
				boolean isConstraintValid = ConfMLExpressionEvaluationUtil
						.evaluateSettingConstraintValid(setting);
				if (setting.isComputedConstraint() != isConstraintValid) {
					setting.setComputedConstraint(isConstraintValid);
				}
				updateErrorModelForSetting(errorsRoot, rsm, setting, cpfEditor);
			}
			if (setting instanceof SequenceSetting) {
				// subsetting validation
				SequenceSetting ss = (SequenceSetting) setting;

				EList<SequenceItem> items = ss.getSequenceItem();
				for (int j = 0; j < items.size(); j++) {
					SequenceItem si = items.get(j);
					EList<Setting> subsettings = si.getSetting();
					for (int k = 0; k < subsettings.size(); k++) {
						Setting subsetting = subsettings.get(k);

						if (subsetting instanceof FileSystemEntrySetting) {
							FilePath sourceFilePath = ((FileSystemEntrySetting) subsetting)
									.getSourceFilePath();
							boolean cc = ConfMLExpressionEvaluationUtil
									.evaluateSettingConstraintValid(sourceFilePath);
							if (sourceFilePath.isComputedConstraint() != cc) {
								sourceFilePath.setComputedConstraint(cc);
							}
							updateErrorModelForSetting(errorsRoot, rsm,
									sourceFilePath, cpfEditor);

							FilePath targetFilePath = ((FileSystemEntrySetting) subsetting)
									.getTargetFilePath();
							cc = ConfMLExpressionEvaluationUtil
									.evaluateSettingConstraintValid(targetFilePath);
							if (targetFilePath.isComputedConstraint() != cc) {
								targetFilePath.setComputedConstraint(cc);
							}
							updateErrorModelForSetting(errorsRoot, rsm,
									targetFilePath, cpfEditor);
						}

						else {
							boolean cc = ConfMLExpressionEvaluationUtil
									.evaluateSettingConstraintValid(subsetting);
							if (subsetting.isComputedConstraint() != cc) {
								subsetting.setComputedConstraint(cc);
							}
							updateErrorModelForSetting(errorsRoot, rsm,
									subsetting, cpfEditor);
						}
					}

				}
			}

		}
	}

	public static void validateConstraintAttributeForSequenceItem(
			SequenceItem si, ErrorsRoot errorsRoot, ResourceModelRoot rsm,
			CPFEditor cpfEditor) {
		EList<Setting> subsettings = si.getSetting();
		for (int k = 0; k < subsettings.size(); k++) {
			Setting subsetting = subsettings.get(k);
			boolean cc = ConfMLExpressionEvaluationUtil
					.evaluateSettingConstraintValid(subsetting);
			subsetting.setComputedConstraint(cc);
			updateErrorModelForSetting(errorsRoot, rsm, subsetting, cpfEditor);
		}
	}

	private static void updateErrorModelForSetting(ErrorsRoot errorsRoot,
			ResourceModelRoot rsm, Setting setting, CPFEditor cpfEditor) {
		if (!setting.isVisible()) {
			return;
		}

		String value = null;
		if (setting instanceof SimpleSetting) {
			value = ((SimpleSetting) setting).getValue();
		}
		if (setting instanceof FilePath) {
			value = ((FilePath) setting).getPath();
		}

		ValidationResult result = SettingsValidator.validateConstraint(setting
			);
		Error error = getErrorForSetting(setting);
		if (error != null) {
			if (error.getDescription() != null
					&& !error.getDescription().toLowerCase().contains(
							"constraint")) {
				return;
			}
		}
		UISetting uisetting = cpfEditor.getUISetting(setting);
		
	
		if (result.getResult().contains(EResult.VALID)) {
			if (error != null) {
				errorsRoot.getErrors().remove(error);
				EList<Adapter> adapters = setting.eAdapters();
				Adapter adapter = EcoreUtil.getAdapter(adapters,
						SettingToErrorAdapter.class);
				if (adapter != null) {
					adapters.remove(adapter);
				}
				if (uisetting != null) {
					EList<UISetting> children = uisetting.getChildren();
					if (setting instanceof FileSystemEntrySetting&&children.size() > 0) {

							cpfEditor.getSettingsViewer().removeError(
									children.get(0));

					} else {
						cpfEditor.getSettingsViewer().removeError(uisetting);

					}
				}
			}
		} else {
			if (error == null) {
				error = ErrormodelFactory.eINSTANCE.createError();
				setting.eAdapters().add(new SettingToErrorAdapter(error));
				error.setSetting(setting);
				error.setDescription(result.getValidationMessage());
				error.setLocation(getLocationFromSetting(setting));
				errorsRoot.getErrors().add(error);
			} else {
				error.setSetting(setting);
				error.setDescription(result.getValidationMessage());
				error.setLocation(getLocationFromSetting(setting));
			}
			if (uisetting != null) {
				EList<UISetting> children = uisetting.getChildren();
				if (setting instanceof FileSystemEntrySetting&&children.size() > 0) {

						cpfEditor.getSettingsViewer().createError(
								children.get(0), error.getDescription());


				} else {
					cpfEditor.getSettingsViewer().createError(uisetting,
							error.getDescription());
				}
			}
		}
	}

	private static String getLocationFromSetting(Setting setting) {
		String location = "";
		if (setting.getLeafGroup().size() > 0) {
			LeafGroup leafGroup = setting.getLeafGroup().get(0);
			EObject container = leafGroup.eContainer();
			if (container instanceof ParentGroup) {
				ParentGroup parentGroup = (ParentGroup) container;
				location = parentGroup.getName() + " - " + leafGroup.getName();
			}
		} else if ((setting.eContainer() != null)
				&& (setting.eContainer().eContainer() instanceof SequenceSetting)) {
			SequenceSetting sequenceSetting = (SequenceSetting) setting
					.eContainer().eContainer();
			if (sequenceSetting.getLeafGroup().size() > 0) {
				LeafGroup leafGroup = sequenceSetting.getLeafGroup().get(0);
				EObject container = leafGroup.eContainer();
				if (container instanceof ParentGroup) {
					ParentGroup parentGroup = (ParentGroup) container;
					location = parentGroup.getName() + " - "
							+ leafGroup.getName();
				}
			}
		}
		return location;
	}

	private static Error getErrorForSetting(Setting setting) {
		Adapter adapter = EcoreUtil.getAdapter(setting.eAdapters(),
				SettingToErrorAdapter.class);
		if (adapter instanceof SettingToErrorAdapter) {
			SettingToErrorAdapter settingToErrorAdapter = (SettingToErrorAdapter) adapter;
			return settingToErrorAdapter.getError();
		}
		return null;
	}
}
