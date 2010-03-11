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

package com.nokia.tools.s60ct.model.confml.util;

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

import com.nokia.tools.s60ct.confml.editor.validation.EResult;
import com.nokia.tools.s60ct.confml.editor.validation.SettingsValidator;
import com.nokia.tools.s60ct.confml.editor.validation.ValidationResult;
import com.nokia.tools.s60ct.model.confml.EFeature;
import com.nokia.tools.s60ct.model.confml.EItemSetting;
import com.nokia.tools.s60ct.model.confml.EOption;
import com.nokia.tools.s60ct.model.confml.EResourceSetting;
import com.nokia.tools.s60ct.model.confml.ESequenceSetting;
import com.nokia.tools.s60ct.model.confml.ESetting;
import com.nokia.tools.s60ct.model.confml.ESettingOption;
import com.nokia.tools.s60ct.model.confml.ESimpleSetting;
import com.nokia.tools.s60ct.model.confml.ESubSettingValue;
import com.nokia.tools.s60ct.model.confml.View;
import com.nokia.tools.s60ct.model.confml.presentation.ConfmlEditor;
import com.nokia.tools.s60ct.resources.model.ELibraryRoot;


public class SettingEvaluator {

	public static boolean reevaluateRelevantForSettings(View view,
			List<ESetting> settings) {
		boolean relevantChange = false;
		List<String> groupFeatureRefs = new ArrayList<String>();
		// settings which are non-relevant because of feature relevant
		// computation
		Set<ESetting> filteredSettings = new HashSet<ESetting>();

		Map<String, List<ESetting>> m = new HashMap<String, List<ESetting>>();
		EList<EFeature> sharedFeatures = view.getSharedFeatures();
		for (EFeature f : sharedFeatures) {
			m.put(f.getRef(), new ArrayList<ESetting>());
		}

		int size = settings.size();
		for (int i = 0; i < size; i++) {
			ESetting setting = settings.get(i);
			String featureRef = setting.getFeatureRef();
			List<ESetting> list = m.get(featureRef);
			list.add(setting);
		}

		// check features' relevant change
		int featuresSize = sharedFeatures.size();
		for (int i = 0; i < featuresSize; i++) {
			EFeature feature = sharedFeatures.get(i);
			boolean featureRelevant = ConfMLExpressionEvaluationUtil
					.evaluateFeatureRelevant(feature);
			feature.setComputedRelevant(featureRelevant);

			if (!featureRelevant) {
				List<ESetting> list = m.get(feature.getRef());
				for (ESetting s : list) {
					filteredSettings.add(s);
				}
			}
		}

		// check LeafGroup's settings relevant change
		for (ESetting setting : view.getSharedSettingInstances()) {
//			if (!groupFeatureRefs.contains(setting.getFeatureRef())) {
//				continue;
//			}

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
				//break;
			}

			if (isComputedRelevant != setting.isComputedRelevant()) {
				if (settings.contains(setting)) {
					relevantChange = true;
					//break;
				}
			}

			//evaluate options
			if (setting instanceof ESimpleSetting) 
			{
				ESimpleSetting ss = (ESimpleSetting)setting;
				for (ESettingOption option: ss.getOptions())
				{
					boolean oldRelevant = option.isComputedRelevant();
					boolean relevant = ConfMLExpressionEvaluationUtil.evaluateOptionRelevant(option);
					if (oldRelevant!=relevant)
					{
						relevantChange = true;
						break;
					}
				}
			}
			else if (setting instanceof EResourceSetting) 
			{
				EResourceSetting resSetting = (EResourceSetting)setting;
				//System.out.println("Unimplemented EResourceSetting type in reevaluateRelevantForSettings");
				//EResourceSetting doesn't have options!!!
			}

			
			if (setting instanceof ESequenceSetting) 
			{
				ESequenceSetting ss = (ESequenceSetting) setting;

				EList<ESetting> sequenceItems = ss.getSubTypes();
				int itemsCount = sequenceItems.size();
				for (int i = 0; i < itemsCount; i++) {
					
					ESetting subsetting = sequenceItems.get(i);
					boolean relevant = ConfMLExpressionEvaluationUtil
							.evaluateSettingRelevant(subsetting);
					if (relevant != subsetting.isComputedRelevant()) {
						//if (settings.contains(setting)) 
							relevantChange = true;
						subsetting.setComputedRelevant(relevant);
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
		List<EFeature> featuresInView = view.getSharedFeatures();
		for (EFeature feature : featuresInView) {
			boolean computedRelevant = ConfMLExpressionEvaluationUtil
					.evaluateFeatureRelevant(feature);
			if (computedRelevant != feature.isComputedRelevant()) {
				feature.setComputedRelevant(computedRelevant);
				relevantChange = true;
			}
			if (computeDependencies) {
				ConfMLExpressionSettingUtil.setSettingDependencies(view,
						feature);
			}
		}
		Map<String, EFeature> settingRefFeatureMap = new HashMap<String, EFeature>();
		EList<EFeature> sharedFeatures = view.getSharedFeatures();
		for (int i = 0; i < sharedFeatures.size(); i++) {
			settingRefFeatureMap.put(sharedFeatures.get(i).getRef(),
					sharedFeatures.get(i));
		}
		for (ESetting setting : view.getSharedSettingInstances()) {
			// Top level setting evaluation
			boolean evaluateSettingRelevant = ConfMLExpressionEvaluationUtil
					.evaluateSettingRelevant(setting);
			// find feature for setting and its computed relevant

			EFeature feature = settingRefFeatureMap.get(setting.getFeatureRef());

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


			if (setting instanceof ESequenceSetting) 
			{
				System.out.println("Unimplemented type ESequenceSetting in initRelevantForWholeModel");
				
				ESequenceSetting ss = (ESequenceSetting) setting;
				EList<EItemSetting> sequenceItems = ss.getItems();
				for (int i = 0; i < sequenceItems.size(); i++) {
					EItemSetting si = sequenceItems.get(i);

					// sub settings
					EList<ESubSettingValue> subsettings = si.getSubSettings();

					for (int j = 0; j < subsettings.size(); j++) {
						ESubSettingValue subsetting = subsettings.get(j);

//						boolean relevant = ConfMLExpressionEvaluationUtil
//								.evaluateSettingRelevant(subsetting);
//						if (subsetting.isComputedRelevant() != relevant) {
//							subsetting.setComputedRelevant(relevant);
//							relevantChange = true;
//						}
//						if (computeDependencies) {
//							ConfMLExpressionSettingUtil.setSettingDependencies(
//
//							view, subsetting);
//						}
					}
				}
			}
			else if (setting instanceof EResourceSetting) 
			{
				System.out.println("Unimplemented type EResourceSetting in initRelevantForWholeModel");
//				EResourceSetting fileSystemEntrySetting = (EResourceSetting) setting;
//				FilePath sourceFilePath = fileSystemEntrySetting
//						.getSourceFilePath();
//				FilePath targetFilePath = fileSystemEntrySetting
//						.getTargetFilePath();
//				if (sourceFilePath != null) {
//					boolean relevant = ConfMLExpressionEvaluationUtil
//							.evaluateSettingRelevant(sourceFilePath);
//					if (sourceFilePath.isComputedRelevant() != relevant) {
//						sourceFilePath.setComputedRelevant(relevant);
//						relevantChange = true;
//					}
//				}
//				if (targetFilePath != null) {
//					boolean relevant = ConfMLExpressionEvaluationUtil
//							.evaluateSettingRelevant(targetFilePath);
//					if (targetFilePath.isComputedRelevant() != relevant) {
//						targetFilePath.setComputedRelevant(relevant);
//						relevantChange = true;
//					}
//				}
			}
		}
		return relevantChange;
	}

//	public static void validateConstraintAttributeForAllSettings(View view,
//			Object errorsRoot, ELibraryRoot rsm, ConfmlEditor cpfEditor) {
//		EList<ESetting> sharedSettingInstances = view
//				.getSharedSettingInstances();
//		for (int i = 0; i < sharedSettingInstances.size(); i++) {
//			ESetting setting = sharedSettingInstances.get(i);
//
//			if (setting instanceof EResourceSetting) {
//				// top level setting constraint validation
//
//				boolean isConstraintValid = ConfMLExpressionEvaluationUtil
//						.evaluateSettingConstraint(setting);
//				if (setting.isComputedConstraint() != isConstraintValid) {
//					setting.setComputedConstraint(isConstraintValid);
//				}
//
////				FilePath sourceFilePath = ((EResourceSetting) setting)
////						.getSourceFilePath();
////				isConstraintValid = ConfMLExpressionEvaluationUtil
////						.evaluateSettingConstraint(sourceFilePath);
////				if (isConstraintValid != sourceFilePath.isComputedConstraint()) {
////					sourceFilePath.setComputedConstraint(isConstraintValid);
////				}
////				if (errorsRoot != null && cpfEditor != null) {
////					updateErrorModelForSetting(errorsRoot, rsm, sourceFilePath, cpfEditor);
////				}
////
////				FilePath targetFilePath = ((EResourceSetting) setting)
////						.getTargetFilePath();
////				isConstraintValid = ConfMLExpressionEvaluationUtil
////						.evaluateSettingConstraint(targetFilePath);
////				if (targetFilePath.isComputedConstraint() != isConstraintValid) {
////					targetFilePath.setComputedConstraint(isConstraintValid);
////				}
////				
////				if (errorsRoot != null && cpfEditor != null) {
////					updateErrorModelForSetting(errorsRoot, rsm, targetFilePath, cpfEditor);
////				}
//
//				// updateErrorModelForSetting(errorsRoot, rsm, setting,
//				// cpfEditor);
//			} else {
//				// top level setting constraint validation
//				boolean isConstraintValid = ConfMLExpressionEvaluationUtil
//						.evaluateSettingConstraint(setting);
//				if (setting.isComputedConstraint() != isConstraintValid) {
//					setting.setComputedConstraint(isConstraintValid);
//				}
//				if (errorsRoot != null && cpfEditor != null) 
//				{
//					System.out.println("updateErrorModelForSetting or create error marker of something...");
//					//updateErrorModelForSetting(errorsRoot, rsm, setting, cpfEditor);
//				}
//			}
//			if (setting instanceof ESequenceSetting) {
//				// subsetting validation
////				ESequenceSetting ss = (ESequenceSetting) setting;
////
////				EList<SequenceItem> items = ss.getSequenceItem();
////				for (int j = 0; j < items.size(); j++) {
////					SequenceItem si = items.get(j);
////					EList<ESetting> subsettings = si.getSetting();
////					for (int k = 0; k < subsettings.size(); k++) {
////						ESetting subsetting = subsettings.get(k);
////
////						if (subsetting instanceof EResourceSetting) {
////							FilePath sourceFilePath = ((EResourceSetting) subsetting)
////									.getSourceFilePath();
////							boolean cc = ConfMLExpressionEvaluationUtil
////									.evaluateSettingConstraint(sourceFilePath);
////							if (sourceFilePath.isComputedConstraint() != cc) {
////								sourceFilePath.setComputedConstraint(cc);
////							}
////							if (errorsRoot != null && cpfEditor != null) {
////								updateErrorModelForSetting(errorsRoot, rsm, sourceFilePath, cpfEditor);
////							}
////
////							FilePath targetFilePath = ((EResourceSetting) subsetting)
////									.getTargetFilePath();
////							cc = ConfMLExpressionEvaluationUtil
////									.evaluateSettingConstraint(targetFilePath);
////							if (targetFilePath.isComputedConstraint() != cc) {
////								targetFilePath.setComputedConstraint(cc);
////							}
////							if (errorsRoot != null && cpfEditor != null) {
////								updateErrorModelForSetting(errorsRoot, rsm, targetFilePath, cpfEditor);
////							}
////						}
////
////						else {
////							boolean cc = ConfMLExpressionEvaluationUtil
////									.evaluateSettingConstraint(subsetting);
////							if (subsetting.isComputedConstraint() != cc) {
////								subsetting.setComputedConstraint(cc);
////							}
////							if (errorsRoot != null && cpfEditor != null) {
////								updateErrorModelForSetting(errorsRoot, rsm, subsetting, cpfEditor);
////							}
////						}
////					}
////
////				}
//			}
//
//		}
//	}

//	public static void validateConstraintAttributeForSequenceItem(
//			SequenceItem si, Object errorsRoot, ELibraryRoot rsm,
//			ConfmlEditor cpfEditor) {
//		EList<ESetting> subsettings = si.getSetting();
//		for (int k = 0; k < subsettings.size(); k++) {
//			ESetting subsetting = subsettings.get(k);
//			boolean cc = ConfMLExpressionEvaluationUtil
//					.evaluateSettingConstraint(subsetting);
//			subsetting.setComputedConstraint(cc);
//			updateErrorModelForSetting(errorsRoot, rsm, subsetting, cpfEditor);
//		}
//	}

//	private static void updateErrorModelForSetting(Object errorsRoot,
//			ELibraryRoot rsm, ESetting setting, ConfmlEditor cpfEditor) {
//		if (!setting.isVisible()) {
//			return;
//		}
//
//		Error error = getErrorForSetting(setting);
//
//		ValidationResult result = SettingsValidator.validateConstraint(setting);
//		if (result.getResult().contains(EResult.VALID)) {
//			result = SettingsValidator.validateRelevantDependencies(setting);
//		}
//		if (error != null) {
//			if (!error.getErrorType().equals(ErrorType.CONSTRAINT)
//					&& !error.getErrorType().equals(
//							ErrorType.NON_RELEVANT_DEPENDENCIES)) {
//				return;
//			}
//		}
//		UISetting uisetting = cpfEditor.getUISetting(setting);
//
//		if (result.getResult().contains(EResult.VALID)) {
//			if (error != null) {
//				errorsRoot.getErrors().remove(error);
//				EList<Adapter> adapters = setting.eAdapters();
//				Adapter adapter = EcoreUtil.getAdapter(adapters,
//						SettingToErrorAdapter.class);
//				if (adapter != null) {
//					adapters.remove(adapter);
//				}
//				if (uisetting != null) {
//					EList<UISetting> children = uisetting.getChildren();
//					if (setting instanceof EResourceSetting
//							&& children.size() > 0) {
//
//						cpfEditor.getSettingsViewer().removeError(
//								children.get(0));
//
//					} else {
//						cpfEditor.getSettingsViewer().removeError(uisetting);
//
//					}
//				}
//			}
//		} else {
//			if (error == null) {
//				error = ErrormodelFactory.eINSTANCE.createError();
//				setting.eAdapters().add(new SettingToErrorAdapter(error));
//				error.setSetting(setting);
//				error.setDescription(result.getValidationMessage());
//				if (result.getResult().contains(EResult.CONSTRAINT_FAILED)) {
//					error.setErrorType(ErrorType.CONSTRAINT);
//				} else if (result.getResult().contains(
//						EResult.NON_RELEVANT_DEPENDENCIES)) {
//					error.setErrorType(ErrorType.NON_RELEVANT_DEPENDENCIES);
//				}
//				error.setLocation(getLocationFromSetting(setting));
//				errorsRoot.getErrors().add(error);
//			} else {
//				error.setSetting(setting);
//				error.setDescription(result.getValidationMessage());
//				error.setLocation(getLocationFromSetting(setting));
//			}
//			if (uisetting != null) {
//				EList<UISetting> children = uisetting.getChildren();
//				if (setting instanceof EResourceSetting
//						&& children.size() > 0) {
//
//					cpfEditor.getSettingsViewer().createError(children.get(0),
//							error.getDescription());
//
//				} else {
//					cpfEditor.getSettingsViewer().createError(uisetting,
//							error.getDescription());
//				}
//			}
//		}
//	}

//	private static String getLocationFromSetting(ESetting setting) {
//		String location = "";
//		if (setting.getLeafGroup().size() > 0) {
//			LeafGroup leafGroup = setting.getLeafGroup().get(0);
//			EObject container = leafGroup.eContainer();
//			if (container instanceof ParentGroup) {
//				ParentGroup parentGroup = (ParentGroup) container;
//				location = parentGroup.getName() + " - " + leafGroup.getName();
//			}
//		} else if ((setting.eContainer() != null)
//				&& (setting.eContainer().eContainer() instanceof ESequenceSetting)) {
//			ESequenceSetting sequenceSetting = (ESequenceSetting) setting
//					.eContainer().eContainer();
//			if (sequenceSetting.getLeafGroup().size() > 0) {
//				LeafGroup leafGroup = sequenceSetting.getLeafGroup().get(0);
//				EObject container = leafGroup.eContainer();
//				if (container instanceof ParentGroup) {
//					ParentGroup parentGroup = (ParentGroup) container;
//					location = parentGroup.getName() + " - "
//							+ leafGroup.getName();
//				}
//			}
//		}
//		return location;
//	}

//	private static Error getErrorForSetting(ESetting setting) {
//		Adapter adapter = EcoreUtil.getAdapter(setting.eAdapters(),
//				SettingToErrorAdapter.class);
//		if (adapter instanceof SettingToErrorAdapter) {
//			SettingToErrorAdapter settingToErrorAdapter = (SettingToErrorAdapter) adapter;
//			return settingToErrorAdapter.getError();
//		}
//		return null;
//	}
}
