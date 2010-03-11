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

import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.nokia.tools.variant.confml.core.model.application.EConfigurationProject;
import com.nokia.tools.variant.content.confml.ConfmlFactory;
import com.nokia.tools.variant.content.confml.FilePath;
import com.nokia.tools.variant.content.confml.FileSystemEntrySetting;
import com.nokia.tools.variant.content.confml.Icon;
import com.nokia.tools.variant.content.confml.LeafGroup;
import com.nokia.tools.variant.content.confml.ParentGroup;
import com.nokia.tools.variant.content.confml.SequenceItem;
import com.nokia.tools.variant.content.confml.SequenceSetting;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.SimpleSetting;
import com.nokia.tools.variant.content.confml.View;
import com.nokia.tools.variant.content.confml.impl.OptionImpl;
import com.nokia.tools.variant.editor.summary.SummaryParentGroup;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Document;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Factory;
import com.nokia.tools.vct.confml.model.confml2.EConfigurationElement;
import com.nokia.tools.vct.confml.model.confml2.EDataElement;
import com.nokia.tools.vct.confml.model.confml2.EDescriptionElement;
import com.nokia.tools.vct.confml.model.confml2.EFeatureData;
import com.nokia.tools.vct.confml.model.confml2.EGroup;
import com.nokia.tools.vct.confml.model.confml2.EIconElement;
import com.nokia.tools.vct.confml.model.confml2.ESettingData;
import com.nokia.tools.vct.confml.model.confml2.ESettingElement;
import com.nokia.tools.vct.confml.model.confml2.EViewElement;

public class ViewModel2ConfML2PersistenceModelConvertor implements
		ViewModel2ConfMLPersistenceModelConvertor {
	/*
	 * (non-Javadoc)
	 * 
	 * @seecom.nokia.tools.variant.editor.model.convertor.
	 * ViewModel2ConfMLPersistenceModelConvertor#copyValues(confml.View,
	 * com.nokia
	 * .tools.variant.confml.core.model.application.EConfigurationProject,
	 * java.lang.String, org.eclipse.emf.common.util.URI)
	 */
	public void copyValues(View fromView,
			EConfigurationProject toVariantContributor, String toViewId,
			URI pathToSave) {

		ResourceSet resources = toVariantContributor.eResource()
				.getResourceSet();
		Resource resourceToSave = resources.getResource(pathToSave, true);
		if (resourceToSave == null) {
			EConfML2Document d = EConfML2Factory.eINSTANCE
					.createEConfML2Document();
			resourceToSave = resources.createResource(pathToSave);
			resourceToSave.getContents().add(d);
			resourceToSave.setModified(true);
		}

		// if (resourceToSave instanceof XMLResource) {
		// XMLResource xr = (XMLResource) resourceToSave;
		// Map<Object, Object> defaultSaveOptions = xr.getDefaultSaveOptions();
		// defaultSaveOptions.put(XMLResource.OPTION_SKIP_ESCAPE, Boolean.TRUE);
		// }

		if (resourceToSave.getContents().get(0) instanceof EConfML2Document) {
			EConfML2Document document = (EConfML2Document) resourceToSave
					.getContents().get(0);
			EConfigurationElement configuration = document.getConfiguration();
			if (configuration == null) {
				configuration = EConfML2Factory.eINSTANCE
						.createEConfigurationElement();
				document.setConfiguration(configuration);
			}
			EList<EDataElement> dataList = configuration.getData();// list of
			// <data>
			EDataElement data = null;// root <data>

			if (dataList.size() == 0) {// create root <data> if they don't exist
				// and add them to configuration
				data = EConfML2Factory.eINSTANCE.createEDataElement();
				dataList.add(data);
			} else {
				dataList.remove(0);
				data = EConfML2Factory.eINSTANCE.createEDataElement();
				dataList.add(data);
			}

			EList<Setting> viewSettings = fromView.getSharedSettingInstances();

			for (Setting setting : viewSettings) {
				if (setting instanceof SequenceSetting) {
					EList<SequenceItem> sequenceItems = ((SequenceSetting) setting)
							.getSequenceItem();
					for (SequenceItem sequenceItem : sequenceItems) {
						EList<Setting> subSettings = sequenceItem.getSetting();
						for (Setting subSetting : subSettings) {
							if (subSetting.isDirty()) {
								handleSequenceSetting(data, setting);
							}
						}
				
				
					}
				}

				if (!setting.isDefault()) {
					if (setting instanceof SimpleSetting) {

						SimpleSetting s = (SimpleSetting) setting;
						// check map reference
						String choosenOption = s.getChoosenOption();
						String value = s.getValue();

						// get FeatureData
						EFeatureData featureData = getFeatureDataForSetting(
								data, s.getFeatureRef());
						ESettingData settingData = getSettingData(featureData,
								s.getSettingRef());

						if (choosenOption != null && value != null) {
							value = value.replace(OptionImpl.OPTION_MAP_KEY,
									"[@key='");
							int i = value.lastIndexOf("\"]");
							if (i >= 0) {
								value = value.substring(0, i);
							}
							settingData.setMap(value.concat("']"));
						} else {
							settingData.setText(value);
						}

						// set last saved value
						s.setLastSavedInLastLayer(true);
						s.setLastSavedValue(value);

					} else if (setting instanceof SequenceSetting) {
						handleSequenceSetting(data, setting);
					} else if (setting instanceof FileSystemEntrySetting) {
						handleFileSetting(data, setting);
					}

				} else {
					if (setting instanceof SimpleSetting) {
						SimpleSetting s = (SimpleSetting) setting;
						s.setLastSavedInLastLayer(false);
						s.setLastSavedValue(s.getValue());
					} else if (setting instanceof FileSystemEntrySetting) {
						FileSystemEntrySetting s = (FileSystemEntrySetting) setting;
						// s.setLastSavedInLastLayer(false);
						// s.setLastSavedSourcePath(s.getSourcePath());
						// s.setLastSavedTargetPath(s.getTargetPath());
						s.getSourceFilePath().setLastSavedPath(
								s.getSourceFilePath().getPath());
						s.getTargetFilePath().setLastSavedPath(
								s.getTargetFilePath().getPath());
						s.getSourceFilePath().setLastSavedInLastLayer(false);
						s.getTargetFilePath().setLastSavedInLastLayer(false);

					}
				}
			}
		}
	}

	private static void handleFileSetting(EDataElement data, Setting setting) {
		FileSystemEntrySetting fileSetting = (FileSystemEntrySetting) setting;

		// get FeatureData
		EFeatureData featureData = getFeatureDataForSetting(data, fileSetting
				.getFeatureRef());
		ESettingData fileData = getSettingData(featureData, fileSetting
				.getSettingRef());
		fileData.getSettings().clear();

		if (!fileSetting.getSourceFilePath().isDefault()) {
			FilePath sourceFilePath = fileSetting.getSourceFilePath();

			sourceFilePath.setLastSavedInLastLayer(true);
			sourceFilePath.setLastSavedPath(sourceFilePath.getPath());

			// create localPath data for subsetting
			ESettingData localPathData = EConfML2Factory.eINSTANCE
					.createESettingData();
			localPathData.setRef("localPath");
			localPathData.setText(sourceFilePath.getPath());
			fileData.getSettings().add(localPathData);

		} else {
			fileSetting.getSourceFilePath().setLastSavedInLastLayer(false);
			fileSetting.getSourceFilePath().setLastSavedPath(
					fileSetting.getSourceFilePath().getPath());
		}

		if (!fileSetting.getTargetFilePath().isDefault()) {
			FilePath targetFilePath = fileSetting.getTargetFilePath();
			targetFilePath.setLastSavedPath(targetFilePath.getPath());
			// fileSetting.setLastSavedInLastLayer(true);
			targetFilePath.setLastSavedInLastLayer(true);

			// create targetPath data for subsetting
			ESettingData targetPathData = EConfML2Factory.eINSTANCE
					.createESettingData();
			targetPathData.setRef("targetPath");
			targetPathData.setText(targetFilePath.getPath());
			fileData.getSettings().add(targetPathData);

		} else {
			fileSetting.getTargetFilePath().setLastSavedInLastLayer(false);
			fileSetting.getTargetFilePath().setLastSavedPath(
					fileSetting.getTargetFilePath().getPath());
		}
	}

	private static void handleSequenceSetting(EDataElement data, Setting setting) {
		SequenceSetting ss = (SequenceSetting) setting;

		// get FeatureData
		EFeatureData featureData = getFeatureDataForSetting(data, ss
				.getFeatureRef());
		removeSequenceItemsData(featureData, ss.getSettingRef());

		// clear last saved data
		EList<SequenceItem> lastSavedStructure = ss.getLastSavedStructure();
		lastSavedStructure.clear();

		EList<SequenceItem> items = ss.getSequenceItem();
		for (SequenceItem item : items) {
			// create last saved item and add it to the list
			SequenceItem lastSavedItem = ConfmlFactory.eINSTANCE
					.createSequenceItem();
			lastSavedStructure.add((SequenceItem) EcoreUtil.copy(item));

			// create item data
			ESettingData sd = EConfML2Factory.eINSTANCE.createESettingData();
			sd.setRef(ss.getSettingRef());
			featureData.getSettings().add(sd);

			// create sub-setting data
			EList<Setting> subsettings = item.getSetting();
			for (Setting subsetting : subsettings) {
				if (subsetting instanceof SimpleSetting) {
					SimpleSetting simpleSubSetting = (SimpleSetting) subsetting;

					// create data for subsetting
					ESettingData ssd = EConfML2Factory.eINSTANCE
							.createESettingData();
					ssd.setRef(simpleSubSetting.getSettingRef());
					ssd.setText(simpleSubSetting.getValue());
					sd.getSettings().add(ssd);
				} else if (subsetting instanceof FileSystemEntrySetting) {
					FileSystemEntrySetting fileSetting = (FileSystemEntrySetting) subsetting;
					fileSetting.getSourceFilePath().setLastSavedPath(
							fileSetting.getSourceFilePath().getPath());
					fileSetting.getTargetFilePath().setLastSavedPath(
							fileSetting.getTargetFilePath().getPath());

					ESettingData fileData = EConfML2Factory.eINSTANCE
							.createESettingData();
					fileData.setRef(fileSetting.getSettingRef());

					// create localPath data for subsetting
					ESettingData localPathData = EConfML2Factory.eINSTANCE
							.createESettingData();
					localPathData.setRef("localPath");
					localPathData.setText(fileSetting.getSourceFilePath()
							.getPath());
					fileData.getSettings().add(localPathData);

					// create localPath data for subsetting
					ESettingData targetPathData = EConfML2Factory.eINSTANCE
							.createESettingData();
					targetPathData.setRef("targetPath");
					targetPathData.setText(fileSetting.getTargetFilePath()
							.getPath());
					fileData.getSettings().add(targetPathData);

					sd.getSettings().add(fileData);
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seecom.nokia.tools.variant.editor.model.convertor.
	 * ViewModel2ConfMLPersistenceModelConvertor
	 * #removeHiddenSettings(confml.View,
	 * com.nokia.tools.variant.confml.core.model
	 * .application.EConfigurationProject)
	 */
	public void removeHiddenSettings(View fromView, EConfigurationProject cp) {

		// view which will be modified by HideSettingsFromViewAction
		String name = cp.getDefaultView().getName();

		ResourceSet resourceSet = cp.eResource().getResourceSet();
		EList<Resource> resources = resourceSet.getResources();

		// searched view
		EViewElement searchedView = null;

		for (int i = 0; i < resources.size(); i++) {
			Resource resource = resources.get(i);
			EList<EObject> contents = resource.getContents();
			boolean found = false;
			for (EObject c : contents) {
				if (found) {
					break;
				}
				if (c instanceof EConfML2Document) {
					EConfML2Document document = (EConfML2Document) c;

					EList<EViewElement> views = document.getConfiguration()
							.getViews();
					for (EViewElement v : views) {
						if (v.getName().equals(name)) {
							searchedView = v;
							found = true;
							break;
						}
					}
				}
			}
		}

		// remove settings from groups
		if (searchedView != null) {
			// remove all groups
			searchedView.getGroups().clear();

			// create all groups again
			EList<ParentGroup> parentGroups = fromView.getParentGroup();
			for (ParentGroup pg : parentGroups) {
				if (pg instanceof SummaryParentGroup) {
					continue;
				}
				EGroup confmlPG = EConfML2Factory.eINSTANCE.createEGroup();
				confmlPG.setId(pg.getId());
				confmlPG.setName(pg.getName());
				EList<Icon> icons = pg.getIcon();
				EIconElement icon = EConfML2Factory.eINSTANCE
						.createEIconElement();
				if (icons.size() > 0) {
					Icon oldIcon = icons.get(0);
					icon.setHref(oldIcon.getFilePath());
				}
				confmlPG.getIcons().add(icon);
				EDescriptionElement desc = EConfML2Factory.eINSTANCE
						.createEDescriptionElement();
				desc.setDescription(pg.getDesc());
				confmlPG.getDescriptions().add(desc);
				searchedView.getGroups().add(confmlPG);
				EList<Setting> pgSettings = pg.getSettings();
				for (Setting s : pgSettings) {
					String absRef = s.getAbsRef();
					ESettingElement settingRef = EConfML2Factory.eINSTANCE
							.createESettingElement();
					settingRef.setRef(absRef);
					if (s.getNameOverride() != null) {
						settingRef.setName(s.getNameOverride());
					}
					if (s.getDescriptionOverride() != null) {
						settingRef.getDescriptions().clear();
						EDescriptionElement d = EConfML2Factory.eINSTANCE
								.createEDescriptionElement();
						d.setDescription(s.getDescriptionOverride());
						settingRef.getDescriptions().add(d);
					}

					confmlPG.getSettings().add(settingRef);
				}
				EList<LeafGroup> leafGroups = pg.getLeafGroup();
				for (LeafGroup lg : leafGroups) {
					EGroup confmlLG = EConfML2Factory.eINSTANCE.createEGroup();
					confmlLG.setId(lg.getId());
					confmlLG.setName(lg.getName());

					EDescriptionElement lgDesc = EConfML2Factory.eINSTANCE
							.createEDescriptionElement();
					lgDesc.setDescription(lg.getDesc());
					confmlLG.getDescriptions().add(lgDesc);

					confmlPG.getGroups().add(confmlLG);

					EList<Setting> settings = lg.getSettings();
					for (Setting s : settings) {
						String absRef = s.getAbsRef();
						ESettingElement settingRef = EConfML2Factory.eINSTANCE
								.createESettingElement();
						settingRef.setRef(absRef);

						if (s.getNameOverride() != null) {
							settingRef.setName(s.getNameOverride());
						}
						if (s.getDescriptionOverride() != null) {
							settingRef.getDescriptions().clear();
							EDescriptionElement d = EConfML2Factory.eINSTANCE
									.createEDescriptionElement();
							d.setDescription(s.getDescriptionOverride());
							settingRef.getDescriptions().add(d);
						}

						confmlLG.getSettings().add(settingRef);
					}

				}

			}
		}
	}

	private static EFeatureData getFeatureDataForSetting(EDataElement data,
			String featureRef) {
		EList<EFeatureData> featureDataList = data.getData();
		for (int i = 0; i < featureDataList.size(); i++) {
			EFeatureData fd = featureDataList.get(i);
			if (fd.getRef().equals(featureRef)) {
				return fd;
			}
		}
		EFeatureData fd = EConfML2Factory.eINSTANCE.createEFeatureData();
		fd.setRef(featureRef);
		data.getData().add(fd);
		return fd;
	}

	private static ESettingData getSettingData(EFeatureData featureData,
			String settingRef) {
		EList<ESettingData> settingsDataList = featureData.getSettings();
		for (int i = 0; i < settingsDataList.size(); i++) {
			ESettingData sd = settingsDataList.get(i);
			String ref = sd.getRef();

			if (ref.endsWith("*")) {
				Path p = new Path(ref);
				Path p2 = new Path(settingRef);
				ref = p.removeLastSegments(1).toString();
				settingRef = p2.removeLastSegments(1).toString();
			}
			if (sd.getRef().equals(settingRef)) {
				return sd;
			}
		}
		ESettingData sd = EConfML2Factory.eINSTANCE.createESettingData();
		sd.setRef(settingRef);
		featureData.getSettings().add(sd);
		return sd;
	}

	private static void removeSequenceItemsData(EFeatureData featureData,
			String settingRef) {
		EList<ESettingData> settingsDataList = featureData.getSettings();
		for (int i = settingsDataList.size() - 1; i >= 0; i--) {
			ESettingData sd = settingsDataList.get(i);
			if (sd.getRef().equals(settingRef)) {
				settingsDataList.remove(i);
			}
		}
	}

}
