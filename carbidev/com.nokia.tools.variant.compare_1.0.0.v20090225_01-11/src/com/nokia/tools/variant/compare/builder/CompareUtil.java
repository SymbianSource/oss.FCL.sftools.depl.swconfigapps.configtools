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

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.nokia.tools.variant.common.core.utils.FileUtils;
import com.nokia.tools.variant.compare.cmodel.ECompareModelFactory;
import com.nokia.tools.variant.compare.cmodel.EDiffGroup;
import com.nokia.tools.variant.confml.core.model.application.EAppFeature;
import com.nokia.tools.variant.confml.core.model.application.EAppGroup;
import com.nokia.tools.variant.confml.core.model.application.EAppSetting;
import com.nokia.tools.variant.confml.core.model.application.EAppSettingData;
import com.nokia.tools.variant.confml.core.model.application.EAppSettingRef;
import com.nokia.tools.variant.confml.core.model.application.EAppSimpleData;
import com.nokia.tools.variant.confml.core.model.application.EAppView;
import com.nokia.tools.variant.confml.core.model.application.EApplicationFactory;
import com.nokia.tools.variant.confml.core.model.application.EConfMLLayer;
import com.nokia.tools.variant.confml.core.model.application.EConfigurationProject;
import com.nokia.tools.variant.confml.internal.core.application.AppModelFactory;
import com.nokia.tools.variant.content.confml.FilePath;
import com.nokia.tools.variant.content.confml.FileSystemEntrySetting;
import com.nokia.tools.variant.content.confml.LeafGroup;
import com.nokia.tools.variant.content.confml.ParentGroup;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.View;
import com.nokia.tools.variant.editor.editors.ViewEditorModel;
import com.nokia.tools.variant.editor.model.convertor.ConfmlApplicationModel2ViewModelConvertor;
import com.nokia.tools.variant.resourcelibrary.model.ResourceModelRoot;

public class CompareUtil {

	public static ViewEditorModel createSyntheticModel(
			ViewEditorModel targetModel, URI confMLURI) {
		ViewEditorModel result = new ViewEditorModel();
		EConfigurationProject configurationProject = EApplicationFactory.eINSTANCE
				.createEConfigurationProject();
		configurationProject.setRootConfml(confMLURI);
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource confResource = new ResourceImpl(URI.createURI("cpf:///"
				+ confMLURI.toString()));
		resourceSet.getResources().add(confResource);
		Map<String, Resource> viewMap = new HashMap<String, Resource>();
		Set<URI> visited = new HashSet<URI>();
		URI layerURI = URI.createURI("./").resolve(confMLURI);

		EConfMLLayer parent = (EConfMLLayer) EcoreUtil.copy(targetModel
				.getVariantContributor().getLastLayer());
		parent.setParent(null);
		for (Map.Entry<String, EAppFeature> featureEntry : parent.getFeatures()) {
			EAppFeature appFeature = featureEntry.getValue();
			for (Map.Entry<String, EAppSetting> settingEntry : appFeature
					.getSettings()) {
				EAppSetting appSetting = settingEntry.getValue();
				appSetting.setValueInfo(null);
			}
		}
		parent.getViews().clear();
		configurationProject.getLayers().add(parent);

		EConfMLLayer layer = new AppModelFactory().populateConfMLLayer(
				resourceSet, layerURI, confMLURI, visited, parent, viewMap);
		configurationProject.getLayers().add(layer);

		for (Map.Entry<String, EAppFeature> featureEntry : layer.getFeatures()) {
			EAppFeature appFeature = featureEntry.getValue();
			for (Iterator<Map.Entry<String, EAppSetting>> settingEntryIterator = appFeature
					.getSettings().iterator(); settingEntryIterator.hasNext();) {
				Map.Entry<String, EAppSetting> settingEntry = settingEntryIterator
						.next();
				EAppSetting appSetting = settingEntry.getValue();
				EAppSettingData data = (EAppSettingData) appSetting
						.getValueInfo();
				if (data == null) {
					settingEntryIterator.remove();
				} else if (data instanceof EAppSimpleData) {
					if (((EAppSimpleData) data).getValue() == null) {
						settingEntryIterator.remove();
					}
				}
			}
		}

		EAppView appView = EApplicationFactory.eINSTANCE.createEAppView();
		appView.setName("Source Data File");
		EAppGroup group1 = EApplicationFactory.eINSTANCE.createEAppGroup();
		group1.setName("Imported Settings");
		appView.getGroups().add(group1);
		EAppGroup group2 = EApplicationFactory.eINSTANCE.createEAppGroup();
		group2.setName("Unmatched Settings");
		group1.getGroups().add(group2);
		for (Map.Entry<String, EAppFeature> featureEntry : layer.getFeatures()) {
			EAppFeature appFeature = featureEntry.getValue();
			for (Map.Entry<String, EAppSetting> settingEntry : appFeature
					.getSettings()) {
				EAppSetting appSetting = settingEntry.getValue();
				EAppSettingRef appSettingRef = EApplicationFactory.eINSTANCE
						.createEAppSettingRef();
				appSettingRef.setResolved(appSetting);
				group2.getSettings().add(appSettingRef);
			}
		}

		layer.getViews().put("Source Data File", appView);
		View sourceView = new ConfmlApplicationModel2ViewModelConvertor()
				.convert(configurationProject);
		result.setView(sourceView);
		result.setVariantContributor(configurationProject);
		return result;
	}

	static void populateGroupMaps(Map<String, EDiffGroup> group1Map,
			Map<String, Map<String, EDiffGroup>> group2Map, View view,
			boolean target) {
		ECompareModelFactory factory = ECompareModelFactory.eINSTANCE;
		for (ParentGroup pg : view.getParentGroup()) {
			String group1Name = pg.getName();
			EDiffGroup group1 = group1Map.get(group1Name);
			if (group1 == null) {
				group1 = factory.createEDiffGroup();
				group1.setName(group1Name);
				group1Map.put(group1Name, group1);
			}
			if (target) {
				group1.setExistsInTarget(true);
				group1.setTargetObject(pg);
			} else {
				group1.setExistsInSource(true);
				group1.setSourceObject(pg);
			}

			Map<String, EDiffGroup> subgroups = group2Map.get(group1Name);
			if (subgroups == null) {
				subgroups = new LinkedHashMap<String, EDiffGroup>();
				group2Map.put(group1Name, subgroups);
			}

			for (LeafGroup lg : pg.getLeafGroup()) {
				String group2Name = lg.getName();
				EDiffGroup sgroup = subgroups.get(group2Name);
				if (sgroup == null) {
					sgroup = factory.createEDiffGroup();
					sgroup.setName(group2Name);
					subgroups.put(group2Name, sgroup);
				}
				if (target) {
					sgroup.setExistsInTarget(true);
					sgroup.setTargetObject(pg);
				} else {
					sgroup.setExistsInSource(true);
					sgroup.setSourceObject(pg);
				}
			}
		}
	}

	static void populateSettingMap(View view, Map<String, Setting> settingMap) {
		EList<Setting> sharedSettingInstances = view
				.getSharedSettingInstances();
		for (Setting setting : sharedSettingInstances) {
			settingMap.put(setting.getAbsRef(), setting);
		}

	}

	static boolean equal(String sourceValue, String targetValue) {
		return (sourceValue == null && targetValue == null)
				|| (sourceValue != null && sourceValue.equals(targetValue));
	}

	static boolean equalContent(ResourceModelRoot sourceRoot,
			ResourceModelRoot targetRoot, FileSystemEntrySetting sourceFile,
			FileSystemEntrySetting targetFile) {
		String sourceFilePath = getActualPath(sourceFile.getSourceFilePath());
		String targetFilePath = getActualPath(targetFile.getSourceFilePath());
		if (sourceFilePath == null && targetFilePath == null) {
			return true;
		}
		if (sourceFilePath == null || targetFilePath == null) {
			return false;
		}
		if (sourceRoot == null) {
			return targetRoot == null;
		}

		File sourceTempDir = new File(sourceRoot.getTempDirPath());
		File targetTempDir = new File(targetRoot.getTempDirPath());
		File sourceFileFile = new File(sourceTempDir, sourceFilePath);
		File targetFileFile = new File(targetTempDir, sourceFilePath);

		if (!sourceFileFile.exists() && !targetFileFile.exists()) {
			return true;
		}
		if (!sourceFileFile.exists() || !targetFileFile.exists()) {
			return false;
		}
		if (sourceFileFile.isDirectory() && targetFileFile.isDirectory()) {
			// IMPROVEMENT compare directories
			return true;
		}
		if (sourceFileFile.isDirectory() || targetFileFile.isDirectory()) {
			return false;
		}
		return FileUtils.compareByContent(sourceFileFile, targetFileFile);
	}

	static String getActualPath(FilePath setting) {
		return setting.isDefault() ? setting.getDefaultPath() : setting
				.getPath();
	}
}
