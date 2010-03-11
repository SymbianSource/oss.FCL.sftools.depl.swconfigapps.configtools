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
 * Description: This file is part of com.nokia.tools.variant.compare component.
 */

package com.nokia.tools.variant.compare.builder;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.nokia.tools.variant.compare.cmodel.ECompareModelFactory;
import com.nokia.tools.variant.compare.cmodel.EDiffGroup;
import com.nokia.tools.variant.compare.cmodel.EDiffLocalPathSetting;
import com.nokia.tools.variant.compare.cmodel.EDiffMismatch;
import com.nokia.tools.variant.compare.cmodel.EDiffResourceSetting2;
import com.nokia.tools.variant.compare.cmodel.EDiffSequence;
import com.nokia.tools.variant.compare.cmodel.EDiffSequenceItem;
import com.nokia.tools.variant.compare.cmodel.EDiffSetting;
import com.nokia.tools.variant.compare.cmodel.EDiffSimple;
import com.nokia.tools.variant.compare.cmodel.EModelRoot;
import com.nokia.tools.variant.content.confml.FileSystemEntrySetting;
import com.nokia.tools.variant.content.confml.LeafGroup;
import com.nokia.tools.variant.content.confml.ParentGroup;
import com.nokia.tools.variant.content.confml.SequenceItem;
import com.nokia.tools.variant.content.confml.SequenceSetting;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.SimpleSetting;
import com.nokia.tools.variant.content.confml.View;
import com.nokia.tools.variant.editor.editors.ViewEditorModel;

public class CompareModelFactory {

	public EModelRoot build(ViewEditorModel source, ViewEditorModel target) {

		View targetView = target.getView();

		Map<String, Map<String, EDiffGroup>> group2Map = new LinkedHashMap<String, Map<String, EDiffGroup>>();
		Map<String, EDiffGroup> group1Map = new LinkedHashMap<String, EDiffGroup>();

		CompareUtil.populateGroupMaps(group1Map, group2Map, target.getView(),
				true);
		CompareUtil.populateGroupMaps(group1Map, group2Map, source.getView(),
				false);

		Map<String, Setting> sourceSettingMap = new LinkedHashMap<String, Setting>();
		Map<String, Setting> targetSettingMap = new LinkedHashMap<String, Setting>();

		CompareUtil.populateSettingMap(target.getView(), targetSettingMap);
		CompareUtil.populateSettingMap(source.getView(), sourceSettingMap);

		Set<String> targetInvisibleSettings = new HashSet<String>();
		for (Map.Entry<String, Setting> entry : targetSettingMap.entrySet()) {
			Setting setting = entry.getValue();
			if (!setting.isVisible()) {
				targetInvisibleSettings.add(setting.getAbsRef());
			}
		}

		// targetSettingMap.keySet().removeAll(targetReadOnly);
		// sourceSettingMap.keySet().removeAll(targetReadOnly);

		EModelRoot root = createGroupTree(group1Map, group2Map);

		Set<String> ignoredSettings = new HashSet<String>(targetInvisibleSettings);

		for (ParentGroup pgroup : targetView.getParentGroup()) {
			String pgroupName = pgroup.getName();
			handleTargetViewSettings(pgroup.getSettings(), targetSettingMap,
					sourceSettingMap, ignoredSettings, source, target,
					group1Map.get(pgroupName));

			for (LeafGroup lgroup : pgroup.getLeafGroup()) {
				String lgroupName = lgroup.getName();
				handleTargetViewSettings(lgroup.getSettings(),
						targetSettingMap, sourceSettingMap, ignoredSettings,
						source, target, group2Map.get(pgroupName).get(
								lgroupName));

			}
		}
		for (ParentGroup pgroup : source.getView().getParentGroup()) {
			String pgroupName = pgroup.getName();
			for (Setting setting : pgroup.getSettings()) {
				String absRef = setting.getAbsRef();
				if (ignoredSettings.contains(absRef)) {
					continue;
				}
				ignoredSettings.add(absRef);
				Setting sourceSetting = sourceSettingMap.get(absRef);
				EDiffSetting diff = null;
				diff = createDiff(sourceSetting);
				diff.setSourceObject(sourceSetting);
				diff.setExistsInSource(true);
				diff.setSourceDefault(((Setting) diff.getSourceObject())
						.isDefault());

				if (diff instanceof EDiffSimple) {
					EDiffSimple simple = (EDiffSimple) diff;
					if (diff.getSourceObject() instanceof SimpleSetting) {
						simple
								.setSourceValue(getSettingValue((SimpleSetting) diff
										.getSourceObject()));
					}
					// if (diff.getTargetObject() instanceof SimpleSetting)
					// {
					// simple.setTargetValue(getSettingValue((SimpleSetting)
					// diff.getTargetObject()));
					// }
				}

				EDiffGroup group = group1Map.get(pgroupName);

				group.getSettings().add(diff);

			}
			for (LeafGroup lgroup : pgroup.getLeafGroup()) {
				String lgroupName = lgroup.getName();
				for (Setting setting : lgroup.getSettings()) {
					String absRef = setting.getAbsRef();
					if (ignoredSettings.contains(absRef)) {
						continue;
					}
					ignoredSettings.add(absRef);
					Setting sourceSetting = sourceSettingMap.get(absRef);
					EDiffSetting diff = null;
					diff = createDiff(sourceSetting);
					diff.setSourceObject(sourceSetting);
					diff.setExistsInSource(true);
					diff.setSourceDefault(((Setting) diff.getSourceObject())
							.isDefault());

					if (diff instanceof EDiffSimple) {
						EDiffSimple simple = (EDiffSimple) diff;
						if (diff.getSourceObject() instanceof SimpleSetting) {
							simple
									.setSourceValue(getSettingValue((SimpleSetting) diff
											.getSourceObject()));
						}
						// if (diff.getTargetObject() instanceof SimpleSetting)
						// {
						// simple.setTargetValue(getSettingValue((SimpleSetting)
						// diff.getTargetObject()));
						// }
					}

					EDiffGroup group = group2Map.get(pgroupName)
							.get(lgroupName);
					group.getSettings().add(diff);

				}
			}
		}

		return root;
	}

	private String getSettingValue(Setting sourceSetting) {
		SimpleSetting simple = (SimpleSetting) sourceSetting;
		
		String choosenOption = simple.getChoosenOption();
		if (choosenOption != null) {
			return choosenOption;
		}
		return simple.isDefault() ? simple.getDefaultValue() : simple
				.getValue();
	}

	private boolean sameType(Setting sourceSetting, Setting targetSetting) {
		if (!sourceSetting.eClass().equals(targetSetting.eClass())) {
			return false;
		}
		if (sourceSetting instanceof SimpleSetting) {
			SimpleSetting s1 = (SimpleSetting) sourceSetting;
			SimpleSetting s2 = (SimpleSetting) targetSetting;

			return s1.getType().equals(s2.getType());
		}

		if (sourceSetting instanceof FileSystemEntrySetting) {
			FileSystemEntrySetting s1 = (FileSystemEntrySetting) sourceSetting;
			FileSystemEntrySetting s2 = (FileSystemEntrySetting) targetSetting;

			return s1.getType().equals(s2.getType());
		}

		// sequences always match...
		return true;
	}

	private EDiffMismatch createDiffSetting(Setting sourceSetting,
			Setting targetSetting) {
		ECompareModelFactory factory = ECompareModelFactory.eINSTANCE;
		EDiffMismatch result = factory.createEDiffMismatch();
		result.setSourceType(getTypeLiteral(sourceSetting));
		result.setTargetType(getTypeLiteral(targetSetting));
		result.setName(targetSetting.getName());
		result.setAbsRef(targetSetting.getAbsRef());
		return result;
	}

	private String getTypeLiteral(Setting sourceSetting) {
		if (sourceSetting instanceof SequenceSetting) {
			return "sequence";
		}
		if (sourceSetting instanceof FileSystemEntrySetting) {
			return "resource:" + sourceSetting.getType();
		}
		if (sourceSetting instanceof SimpleSetting) {
			return "simple:" + sourceSetting.getType();
		}

		return null;
	}

	private EDiffSetting createDiff(Setting setting) {
		ECompareModelFactory factory = ECompareModelFactory.eINSTANCE;
		EDiffSetting result;
		if (setting instanceof SimpleSetting) {
			SimpleSetting source = (SimpleSetting) setting;
			switch (source.getType()) {
			case SIMPLE_FILE:
			case SIMPLE_FOLDER:
				result = factory.createEDiffLocalPathSetting();
				break;
			default:
				result = factory.createEDiffSimple();
			}
		} else if (setting instanceof SequenceSetting) {
			result = factory.createEDiffSequence();
		} else if (setting instanceof FileSystemEntrySetting) {
			result = factory.createEDiffResourceSetting2();
		} else {
			throw new IllegalArgumentException();
		}
		result.setName(setting.getName());
		result.setAbsRef(setting.getAbsRef());

		return result;
	}

	private EModelRoot createGroupTree(Map<String, EDiffGroup> group1Map,
			Map<String, Map<String, EDiffGroup>> group2Map) {
		ECompareModelFactory factory = ECompareModelFactory.eINSTANCE;

		EModelRoot root = factory.createEModelRoot();

		for (Map.Entry<String, EDiffGroup> entry : group1Map.entrySet()) {
			root.getGroups().add(entry.getValue());
			Map<String, EDiffGroup> subgroups = group2Map.get(entry.getKey());
			for (Map.Entry<String, EDiffGroup> entry2 : subgroups.entrySet()) {
				entry.getValue().getGroups().add(entry2.getValue());
			}
		}

		return root;
	}

	private boolean compareSequences(EDiffSequence diff) {
		EObject sourceObject = diff.getSourceObject();
		EObject targetObject = diff.getTargetObject();
		if (sourceObject instanceof SequenceSetting
				&& targetObject instanceof SequenceSetting) {
			SequenceSetting sourceSequenceSetting = (SequenceSetting) sourceObject;
			SequenceSetting targetSequenceSetting = (SequenceSetting) targetObject;
			EList<SequenceItem> sourceSequenceItems = sourceSequenceSetting
					.getSequenceItem();
			EList<SequenceItem> targetSequenceItems = targetSequenceSetting
					.getSequenceItem();
			boolean compareLeafs = sourceSequenceItems.size() == targetSequenceItems
					.size();
			if (compareLeafs) {
				compareLeafs = compareLeafs(sourceSequenceItems,
						targetSequenceItems);
			}
			if (compareLeafs) {

				return true;
			} else {
				createLeafs(diff, sourceSequenceItems, targetSequenceItems);
			}
		}
		return false;

	}

	private boolean compareLeafs(EList<SequenceItem> sequenceItem,
			EList<SequenceItem> sequenceItem2) {
		for (SequenceItem sequenceItem3 : sequenceItem) {
			SequenceItem sequenceItem4 = sequenceItem2.get(sequenceItem
					.indexOf(sequenceItem3));
			EList<Setting> setting = sequenceItem3.getSetting();
			EList<Setting> setting2 = sequenceItem4.getSetting();
			for (Setting setting3 : setting) {
				Setting setting4 = setting2.get(setting.indexOf(setting3));
				if (!compareSimpleSetting(setting3, setting4)) {
					return false;
				}
				if (!compareFiles(setting3, setting4)) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean compareFiles(Setting setting3, Setting setting4) {
		if (setting3 instanceof FileSystemEntrySetting
				&& setting4 instanceof FileSystemEntrySetting) {
			FileSystemEntrySetting s = (FileSystemEntrySetting) setting3;
			FileSystemEntrySetting s2 = (FileSystemEntrySetting) setting4;
			String value = s.getSourceFilePath().getPath();
			String value2 = s2.getSourceFilePath().getPath();
			if (!compareValues(value, value2)) {
				return false;
			}
			String targetPath = s.getTargetFilePath().getPath();
			String targetPath2 = s2.getTargetFilePath().getPath();
			if (!compareValues(targetPath, targetPath2)) {
				return false;
			}
		}
		return true;

	}

	private boolean compareSimpleSetting(Setting setting3, Setting setting4) {
		if (setting3 instanceof SimpleSetting
				&& setting4 instanceof SimpleSetting) {
			SimpleSetting s = (SimpleSetting) setting3;
			SimpleSetting s2 = (SimpleSetting) setting4;
			String value = s.getValue();
			String value2 = s2.getValue();
			if (compareValues(value, value2)) {
				return true;
			}
			return false;
		}
		return true;
	}

	private boolean compareValues(String value, String value2) {
		if ((value == null && value2 == null)
				|| (value != null && value2 != null && value2.equals(value))
				|| (value != null && value.equals("") && value2 == null || value2 != null
						&& value2.equals("") && value == null)) {
			return true;
		}

		return false;
	}

	private void handleTargetViewSettings(List<Setting> settings,
			Map<String, Setting> targetSettingMap,
			Map<String, Setting> sourceSettingMap, Set<String> ignoredSettings,
			ViewEditorModel source, ViewEditorModel target, EDiffGroup group) {
		for (Setting setting : settings) {
			String absRef = setting.getAbsRef();
			if (!targetSettingMap.containsKey(absRef)) {
				// setting has been filtered out
				continue;
			}
			if (ignoredSettings.contains(absRef)) {
				continue;
			}
			ignoredSettings.add(absRef);
			Setting sourceSetting = sourceSettingMap.get(absRef);
			Setting targetSetting = targetSettingMap.get(absRef);

			EDiffSetting diff = null;
			if (targetSetting != null) {
				if (sourceSetting == null) {
					diff = createDiff(targetSetting);
					diff.setTargetObject(targetSetting);
					if (targetSetting instanceof SimpleSetting) {
						((EDiffSimple) diff)
								.setTargetValue(getSettingValue(targetSetting));
					}
				} else if (sameType(sourceSetting, targetSetting)) {
					diff = createDiff(targetSetting);
					diff.setSourceObject(sourceSetting);
					diff.setTargetObject(targetSetting);

					if (sourceSetting instanceof SimpleSetting) {
						String sourceValue = getSettingValue(sourceSetting);
						String targetValue = getSettingValue(targetSetting);
						if (CompareUtil.equal(sourceValue, targetValue)) {
							// if both are simple and equal, then ignore
							diff = null;
						} else {
							EDiffSimple diffSimple = (EDiffSimple) diff;
							diffSimple.setSourceValue(sourceValue);
							diffSimple.setTargetValue(targetValue);
						}
					} else if (sourceSetting instanceof SequenceSetting) {
						((EDiffSequence) diff)
								.setItemCount(((SequenceSetting) sourceSetting)
										.getSequenceItem().size());
						if (compareSequences((EDiffSequence) diff)) {
							diff = null;
						}
					} else if (sourceSetting instanceof FileSystemEntrySetting) {
						FileSystemEntrySetting sourceFile = (FileSystemEntrySetting) sourceSetting;
						FileSystemEntrySetting targetFile = (FileSystemEntrySetting) targetSetting;

						EDiffResourceSetting2 diffRes = (EDiffResourceSetting2) diff;

						if (!targetFile.getSourceFilePath().isPathReadOnly()) {
							EDiffLocalPathSetting diff2 = ECompareModelFactory.eINSTANCE
									.createEDiffLocalPathSetting();
							diff2.setExistsInSource(true);
							diff2.setExistsInTarget(true);
							diff2.setSourceObject(sourceFile);
							diff2.setTargetObject(targetFile);
							diff2.setSourceValue(CompareUtil
									.getActualPath(sourceFile
											.getSourceFilePath()));
							diff2.setTargetValue(CompareUtil
									.getActualPath(targetFile
											.getSourceFilePath()));
							diff2.setName("Local Path");
							diff2.setAbsRef(absRef + "/localPath");

							diff2.setEqualContent(CompareUtil.equalContent(
									source.getResourceModelRoot(), target
											.getResourceModelRoot(),
									sourceFile, targetFile));

							if (diff2.isEqualContent()
									&& CompareUtil.equal(
											diff2.getSourceValue(), diff2
													.getTargetValue())) {
								// filter out with equal local path and
								// conflict
								diff2 = null;
							}

							diffRes.setSourcePath(diff2);
						}
						if (!targetFile.getTargetFilePath().isPathReadOnly()) {
							EDiffSimple diff2 = ECompareModelFactory.eINSTANCE
									.createEDiffSimple();
							diff2.setExistsInSource(true);
							diff2.setExistsInTarget(true);
							diff2.setSourceObject(sourceFile);
							diff2.setTargetObject(targetFile);
							diff2.setSourceValue(CompareUtil
									.getActualPath(sourceFile
											.getTargetFilePath()));
							diff2.setTargetValue(CompareUtil
									.getActualPath(targetFile
											.getTargetFilePath()));

							diff2.setName("Target Path");
							diff2.setAbsRef(absRef + "/targetPath");

							if (CompareUtil.equal(diff2.getSourceValue(), diff2
									.getTargetValue())) {
								diff2 = null;
							}

							diffRes.setTargetPath(diff2);
						}

						if (diffRes.getSourcePath() == null
								&& diffRes.getTargetPath() == null) {
							// if both paths are filtered out, remove
							// the setting
							diff = null;
						}
					}
				} else {
					diff = createDiffSetting(sourceSetting, targetSetting);
					diff.setSourceObject(sourceSetting);
					diff.setTargetObject(targetSetting);
				}
			} else {
				// source setting only
				diff = createDiff(sourceSetting);
				diff.setSourceObject(sourceSetting);
				diff.setExistsInSource(true);
			}

			if (diff != null) {
				if (diff.getSourceObject() != null) {
					diff.setExistsInSource(true);
					diff.setSourceDefault(((Setting) diff.getSourceObject())
							.isDefault());
				}
				if (diff.getTargetObject() != null) {
					diff.setExistsInTarget(true);
					diff.setTargetDefault(((Setting) diff.getTargetObject())
							.isDefault());
				}
				if (diff instanceof EDiffSimple) {
					EDiffSimple simple = (EDiffSimple) diff;
					if (diff.getSourceObject() instanceof SimpleSetting) {
						simple
								.setSourceValue(getSettingValue((SimpleSetting) diff
										.getSourceObject()));
					}
					if (diff.getTargetObject() instanceof SimpleSetting) {
						simple
								.setTargetValue(getSettingValue((SimpleSetting) diff
										.getTargetObject()));
					}

				}

				group.getSettings().add(diff);
			}
		}
	}

	private void createLeafs(EDiffSequence sequenceSettingCdo,
			EList<SequenceItem> sequenceItem, EList<SequenceItem> sequenceItem2) {

		for (SequenceItem sequenceItem3 : sequenceItem2) {
			int indexOf = sequenceItem2.indexOf(sequenceItem3);
			if (sequenceItem.size() > indexOf) {
				SequenceItem sequenceItem4 = sequenceItem.get(indexOf);
				EList<Setting> setting = sequenceItem4.getSetting();
				EList<Setting> setting2 = sequenceItem3.getSetting();
				EDiffSequenceItem c = ECompareModelFactory.eINSTANCE
						.createEDiffSequenceItem();
				c.setSourceObject(sequenceItem4);
				c.setTargetObject(sequenceItem3);
				sequenceSettingCdo.getItems().add(c);

				for (int i = 0; i < setting.size(); i++) {
					Setting setting11 = setting.get(i);
					Setting setting22 = setting2.get(i);

					EDiffSetting diff = createDiff(setting22);
					diff.setSourceObject(setting11);
					diff.setTargetObject(setting22);
					if (diff instanceof EDiffSimple) {
						((EDiffSimple) diff)
								.setSourceValue(((SimpleSetting) setting11)
										.getValue());
						((EDiffSimple) diff)
								.setTargetValue(((SimpleSetting) setting22)
										.getValue());
					}
					c.getSettings().add(diff);

				}
			} else {
				EDiffSequenceItem c = ECompareModelFactory.eINSTANCE
						.createEDiffSequenceItem();
				c.setTargetObject(sequenceItem3);

				sequenceSettingCdo.getItems().add(c);

				EList<Setting> setting = sequenceItem3.getSetting();
				for (int i = 0; i < setting.size(); i++) {
					Setting setting11 = setting.get(i);
					EDiffSetting diff = createDiff(setting11);
					diff.setTargetObject(setting11);
					if (diff instanceof EDiffSimple) {
						((EDiffSimple) diff)
								.setTargetValue(((SimpleSetting) setting11)
										.getValue());
					}
					c.getSettings().add(diff);

				}
			}
		}
		int diff = sequenceItem.size() - sequenceItem2.size();
		if (diff > 0) {

			for (int j = sequenceItem2.size(); j < sequenceItem.size(); j++) {
				SequenceItem sequenceItem4 = sequenceItem.get(j);
				EList<Setting> setting = sequenceItem4.getSetting();
				EDiffSequenceItem c = ECompareModelFactory.eINSTANCE
						.createEDiffSequenceItem();
				c.setSourceObject(sequenceItem4);

				sequenceSettingCdo.getItems().add(c);

				for (int i = 0; i < setting.size(); i++) {
					Setting setting11 = setting.get(i);

					EDiffSetting diff2 = createDiff(setting11);
					diff2.setSourceObject(setting11);
					if (diff2 instanceof EDiffSimple) {
					((EDiffSimple) diff2)
							.setSourceValue(((SimpleSetting) setting11)
									.getValue());
					}
					c.getSettings().add(diff2);}
				
			}
		}
	}

}
