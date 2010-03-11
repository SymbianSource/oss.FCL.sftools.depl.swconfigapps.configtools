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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.nokia.tools.variant.confml.core.model.application.EConfMLLayer;
import com.nokia.tools.variant.confml.core.model.application.EConfigurationProject;
import com.nokia.tools.variant.content.confml.Feature;
import com.nokia.tools.variant.content.confml.FilePath;
import com.nokia.tools.variant.content.confml.FileSystemEntrySetting;
import com.nokia.tools.variant.content.confml.Group;
import com.nokia.tools.variant.content.confml.LeafGroup;
import com.nokia.tools.variant.content.confml.ParentGroup;
import com.nokia.tools.variant.content.confml.SequenceItem;
import com.nokia.tools.variant.content.confml.SequenceSetting;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.View;
import com.nokia.tools.variant.editor.adapters.NotifyAdapter;
import com.nokia.tools.variant.editor.adapters.SettingToErrorAdapter;
import com.nokia.tools.variant.editor.adapters.SettingToUISettingAdapter;
import com.nokia.tools.variant.editor.cpfInfo.CPFInformation;
import com.nokia.tools.variant.editor.editors.CPFEditor;
import com.nokia.tools.variant.editor.editors.ViewEditorModel;
import com.nokia.tools.variant.editor.listeners.AdapterRemovalDisposeListener;
import com.nokia.tools.variant.editor.model.UIGroup;
import com.nokia.tools.variant.editor.model.UIModel;
import com.nokia.tools.variant.editor.model.UIModelFactory;
import com.nokia.tools.variant.editor.model.UISetting;
import com.nokia.tools.variant.editor.model.summaryModel.SUMMARYTYPE;
import com.nokia.tools.variant.editor.model.summaryModel.SummaryModelFactory;
import com.nokia.tools.variant.editor.model.summaryModel.UIElement;
import com.nokia.tools.variant.editor.model.summaryModel.UISummaryGroup;
import com.nokia.tools.variant.editor.model.summaryModel.UISummaryModel;
import com.nokia.tools.variant.viewer.viewer.SettingsViewer;
import com.nokia.tools.variant.viewer.viewer.Type;
import com.nokia.tools.variant.views.errormodel.Error;
import com.nokia.tools.variant.views.errormodel.ErrorsRoot;

/**
 * Converts main model {@link View} to {@link UIModel}
 * 
 */
public class ViewModelToUIModelConvertor {

	private CPFEditor editor;

	public ViewModelToUIModelConvertor(CPFEditor editor) {
		this.editor = editor;
	}

	/**
	 * Creates {@link UIModel} from {@link Group}
	 * 
	 * @param group
	 * @return
	 */
	public UIModel createUIModel(Group group) {
		if (group instanceof ParentGroup) {
			return createUIModelForParentGroup((ParentGroup) group);
		}
		return createUIModelForLeafGroup((LeafGroup) group);

	}

	private UIModel createUIModelForLeafGroup(LeafGroup l) {
		UIModel root = UIModelFactory.eINSTANCE.createUIModel();
		EList<Setting> settings = l.getSettings();
		Map<String, UIGroup> groups = new LinkedHashMap<String, UIGroup>();
		Map<String, Feature> features = new HashMap<String, Feature>();
		View view = (View) l.eContainer().eContainer();
		for (Feature feature : view.getSharedFeatures()) {
			features.put(feature.getRef(), feature);
		}

		for (Setting setting : settings) {
			if (!setting.isComputedRelevant() || !setting.isVisible()) {
				// skip non-relevant setting
				continue;
			}

			String featureName = setting.getFeatureName();
			Feature feature = features.get(setting.getFeatureRef());

			String absRef = setting.getAbsRef();
			absRef = absRef.substring(0, absRef.indexOf("/"));
			UISetting uiSetting = createUISetting(setting);

			if (setting instanceof FileSystemEntrySetting) {
				createChildrenForFile(uiSetting, setting);
			}
			UIGroup group2 = groups.get(absRef);
			if (group2 != null) {
				group2.getUiSettings().add(uiSetting);
			} else {
				UIGroup group = UIModelFactory.eINSTANCE.createUIGroup();
				group.setTitle(featureName);
				group.getUiSettings().add(uiSetting);
				group.setModel(feature);
				groups.put(absRef, group);

			}
			if (setting instanceof SequenceSetting) {
				createSequenceItems(uiSetting, setting);
			}
		}
		Collection<UIGroup> values = groups.values();
		root.getUiGroups().addAll(values);
		groups.clear();
		return root;

	}

	private UIModel createUIModelForParentGroup(ParentGroup l) {
		UIModel root = UIModelFactory.eINSTANCE.createUIModel();
		EList<Setting> settings = l.getSettings();
		Map<String, UIGroup> groups = new LinkedHashMap<String, UIGroup>();
		Map<String, Feature> features = new HashMap<String, Feature>();
		View view = (View) l.eContainer();
		for (Feature feature : view.getSharedFeatures()) {
			features.put(feature.getRef(), feature);
		}

		for (Setting setting : settings) {

			if (!setting.isComputedRelevant() || !setting.isVisible()) {
				// skip non-relevant setting
				continue;
			}

			String featureName = setting.getFeatureName();
			Feature feature = features.get(setting.getFeatureRef());

			String absRef = setting.getAbsRef();
			absRef = absRef.substring(0, absRef.indexOf("/"));
			UISetting uiSetting = createUISetting(setting);

			if (setting instanceof FileSystemEntrySetting) {
				createChildrenForFile(uiSetting, setting);
			}
			UIGroup group2 = groups.get(absRef);
			if (group2 != null) {
				group2.getUiSettings().add(uiSetting);
			} else {
				UIGroup group = UIModelFactory.eINSTANCE.createUIGroup();
				group.setTitle(featureName);
				group.getUiSettings().add(uiSetting);
				group.setModel(feature);
				groups.put(absRef, group);

			}
			if (setting instanceof SequenceSetting) {
				createSequenceItems(uiSetting, setting);
			}
		}
		Collection<UIGroup> values = groups.values();
		root.getUiGroups().addAll(values);
		groups.clear();
		EList<LeafGroup> leafGroups = l.getLeafGroup();
		for (LeafGroup leafGroup : leafGroups) {
			UIGroup group = UIModelFactory.eINSTANCE.createUIGroup();
			group.setTitle(leafGroup.getName());
			group.setModel(leafGroup);
			root.getUiGroups().add(group);
			UIModel model = createUIModelForLeafGroup(leafGroup);
			EList<UIGroup> uiGroups = model.getUiGroups();
			group.getUiGroups().addAll(uiGroups);
		}
		return root;

	}

	private UISetting createUISetting(Setting setting) {

		UISetting uiSetting = UIModelFactory.eINSTANCE.createUISetting();
		uiSetting.setSetting(setting);
		addAdapterForSetting(setting, uiSetting);
		if (setting instanceof FileSystemEntrySetting) {
			FileSystemEntrySetting fileSetting = (FileSystemEntrySetting) setting;
			if (fileSetting.getSourceFilePath() != null
					&& !fileSetting.getSourceFilePath().isReadOnly()&& fileSetting.getSourceFilePath().isComputedRelevant()) {
				UISetting sourcePath = UIModelFactory.eINSTANCE
						.createUISetting();
				sourcePath.setSetting(fileSetting.getSourceFilePath());
				addAdapterForSetting(fileSetting.getSourceFilePath(),
						sourcePath);
				sourcePath.setData(Type.FILESOURCE);
				uiSetting.getChildren().add(sourcePath);
			}
			if (fileSetting.getTargetFilePath() != null
					&& !fileSetting.getTargetFilePath().isReadOnly()&& fileSetting.getTargetFilePath().isComputedRelevant()) {
				UISetting targetPath = UIModelFactory.eINSTANCE
						.createUISetting();
				targetPath.setSetting(fileSetting.getTargetFilePath());
				addAdapterForSetting(fileSetting.getTargetFilePath(),
						targetPath);
				targetPath.setData(Type.FILETARGET);
				uiSetting.getChildren().add(targetPath);

			}
			// createChildrenForFile(uiSetting, setting);
		}

		return uiSetting;
	}

	private void createSequenceItems(UISetting uiSetting, Setting setting) {
		SequenceSetting sequence = (SequenceSetting) setting;
		EList<SequenceItem> sequenceItems = sequence.getSequenceItem();
		for (int i = 0; i < sequenceItems.size(); i++) {
			createSequenceItem(uiSetting, sequenceItems.get(i), i);
		}

	}

	private void createSequenceItem(UISetting uiSetting,
			SequenceItem sequenceItem, int position) {
		UISetting uiSettingForItem = UIModelFactory.eINSTANCE.createUISetting();
		if (position <= uiSetting.getChildren().size()) {
			uiSetting.getChildren().add(position, uiSettingForItem);
		} else {
			uiSetting.getChildren().add(uiSettingForItem);
		}
		EList<Setting> subsetings = sequenceItem.getSetting();
		for (Setting simpleSetting : subsetings) {
			if (!simpleSetting.isComputedRelevant()
					|| !simpleSetting.isVisible()) {
				// skip non-relevant setting
				continue;
			}
			UISetting uiSubsetting = createUISetting(simpleSetting);
			uiSettingForItem.getChildren().add(uiSubsetting);
		}
	}

	private void addAdapterForSetting(Setting setting, UISetting uiSetting) {
		EList<Adapter> adapters = setting.eAdapters();
		Adapter adapter = EcoreUtil.getAdapter(adapters,
				SettingToUISettingAdapter.class);
		if (adapter != null) {
			adapters.remove(adapter);
			adapter = null;
		}
		Adapter o = new SettingToUISettingAdapter(setting, uiSetting, editor);
		adapters.add(o);

	}

	private void createChildrenForFile(UISetting uiSetting, Setting setting) {
		if (uiSetting.getChildren().size() > 0) {
			return;
		}
		FileSystemEntrySetting fileSetting = (FileSystemEntrySetting) setting;
		FilePath sourceFilePath = fileSetting.getSourceFilePath();
		if (sourceFilePath != null && !sourceFilePath.isPathReadOnly()&& sourceFilePath.isComputedRelevant()) {
			UISetting sourcePath = createUISetting(setting);
			sourcePath.setData(Type.FILESOURCE);
			uiSetting.getChildren().add(sourcePath);
		}
		FilePath targetFilePath = fileSetting.getTargetFilePath();
		if (targetFilePath != null && !targetFilePath.isPathReadOnly()&& targetFilePath.isComputedRelevant()) {
			UISetting targetPath = createUISetting(setting);
			targetPath.setData(Type.FILETARGET);
			uiSetting.getChildren().add(targetPath);
		}
	}

	/**
	 * Creates {@link UIGroup} from {@link Group}, UISettings are sorted
	 * according to errors(settings with errors are in the beginning)
	 * 
	 * @param l
	 *            Group which the {@link UIGroup} is created from
	 * @param errorsRoot
	 *            Root of errors model
	 * @return
	 */
	public UIGroup createErrorsForGroup(Group l, ErrorsRoot errorsRoot) {
		if (l instanceof ParentGroup) {
			return createErrorsForParentGroup((ParentGroup) l, errorsRoot);
		}
		return createErrorsForLeafGroup((LeafGroup) l, errorsRoot);
	}

	private UIGroup createErrorsForLeafGroup(LeafGroup l, ErrorsRoot errorsRoot) {
		UIGroup errorsGroup = UIModelFactory.eINSTANCE.createUIGroup();
		EList<UISetting> uiSettings = errorsGroup.getUiSettings();
		EList<Error> errors = errorsRoot.getErrors();
		List<Setting> list = new ArrayList<Setting>();
		for (Error error : errors) {
			Setting setting = error.getSetting();

			if (!setting.isComputedRelevant() || !setting.isVisible()) {
				// skip non-relevant subsetting
				continue;
			}

			if (setting.eContainer() instanceof FileSystemEntrySetting) {
				FileSystemEntrySetting container = (FileSystemEntrySetting) setting
						.eContainer();

				setting = container;

			}
			if (setting.eContainer() instanceof SequenceItem
					&& setting.eContainer().eContainer() instanceof SequenceSetting) {
				SequenceSetting container = (SequenceSetting) setting
						.eContainer().eContainer();

				setting = container;

			}

			EList<LeafGroup> leafGroup = setting.getLeafGroup();

			if (leafGroup.contains(l) && !list.contains(setting)) {

				createAndAddToList(uiSettings, setting);

				list.add(setting);

			}
		}
		EList<Setting> settings = l.getSettings();
		createSettings(uiSettings, list, settings);
		list.clear();
		return errorsGroup;
	}

	private UIGroup createErrorsForParentGroup(ParentGroup l,
			ErrorsRoot errorsRoot) {
		List<Setting> all = new ArrayList<Setting>();

		fillList(all, l.getSettings());
		EList<LeafGroup> leafGroup2 = l.getLeafGroup();
		for (LeafGroup leafGroup : leafGroup2) {
			fillList(all, leafGroup.getSettings());
		}
		UIGroup errorsGroup = UIModelFactory.eINSTANCE.createUIGroup();
		EList<UISetting> uiSettings = errorsGroup.getUiSettings();
		for (Setting setting : all) {
			createAndAddToList(uiSettings, setting);
		}

		return errorsGroup;
	}

	private void fillList(List<Setting> all, EList<Setting> settings3) {
		for (Setting setting : settings3) {
			if (!setting.isComputedRelevant() || !setting.isVisible()) {
				// // skip non-relevant subsetting
				continue;
			}
			if (!all.contains(setting)) {
				Adapter adapter = EcoreUtil.getAdapter(setting.eAdapters(),
						SettingToErrorAdapter.class);
				if (adapter != null) {
					all.add(0, setting);
				} else {
					TreeIterator<EObject> allContents = setting.eAllContents();

					while (allContents.hasNext()) {
						EObject next = allContents.next();
						Adapter nextAdapter = EcoreUtil.getAdapter(next
								.eAdapters(), SettingToErrorAdapter.class);
						if (nextAdapter instanceof SettingToErrorAdapter) {
							all.add(0, setting);

							break;
						}
					}
					if (!all.contains(setting)) {
						all.add(setting);
					}
				}
			}
		}
	}

	private void createSettings(EList<UISetting> uiSettings,
			List<Setting> list, EList<Setting> settings2) {
		for (Setting setting : settings2) {
			if (!setting.isComputedRelevant() || !setting.isVisible()) {
				// skip non-relevant subsetting
				continue;
			}
			if (!list.contains(setting)) {
				createAndAddToList(uiSettings, setting);

			}
		}
	}

	private void createAndAddToList(EList<UISetting> uiSettings, Setting setting) {
		UISetting createUISettings = createUISettings(setting);
		uiSettings.add(createUISettings);
	}

	private UISetting createUISettings(Setting setting) {
		UISetting uiSetting = createUISetting(setting);

		if (setting instanceof FileSystemEntrySetting) {
			createChildrenForFile(uiSetting, setting);
		}

		if (setting instanceof SequenceSetting) {
			createSequenceItems(uiSetting, setting);
		}
		return uiSetting;
	}

	/**
	 * Creates {@link UIGroup} from {@link Group}, UISettings are sorted
	 * according to setting dirty state(dirty settings are in the beginning)
	 * 
	 * @param group
	 * @return
	 */
	public UIGroup createDirtyForGroup(Group group) {
		if (group instanceof ParentGroup) {
			return createDirtyForParentGroup((ParentGroup) group);
		}
		return createDirtyForLeafGroup((LeafGroup) group);
	}

	private UIGroup createDirtyForLeafGroup(LeafGroup l) {
		UIGroup dirtyGroup = UIModelFactory.eINSTANCE.createUIGroup();
		EList<UISetting> uiSettings = dirtyGroup.getUiSettings();
		List<Setting> list = new ArrayList<Setting>();
		EList<Setting> settings = l.getSettings();
		for (Setting setting : settings) {
			if (!setting.isComputedRelevant() || !setting.isVisible()) {
				// skip non-relevant subsetting
				continue;
			}
			if (setting.isDirty()) {
				createAndAddToList(uiSettings, setting);
				list.add(setting);
			}
		}
		for (Setting setting : settings) {
			if (!list.contains(setting) && !setting.isReadOnly()) {
				createAndAddToList(uiSettings, setting);
			}
		}
		list.clear();
		return dirtyGroup;

	}

	private UIGroup createDirtyForParentGroup(ParentGroup l) {
		UIGroup dirtyGroup = UIModelFactory.eINSTANCE.createUIGroup();
		EList<UISetting> uiSettings = dirtyGroup.getUiSettings();
		List<Setting> list = new ArrayList<Setting>();
		EList<Setting> parentGroupSettings = l.getSettings();
		List<Setting> settings = new ArrayList<Setting>();
		settings.addAll(parentGroupSettings);

		EList<LeafGroup> leafGroups = l.getLeafGroup();
		for (LeafGroup leafGroup : leafGroups) {
			EList<Setting> leafGroupSettings = leafGroup.getSettings();
			settings.addAll(leafGroupSettings);
		}
		for (Setting setting : settings) {
			if (!setting.isComputedRelevant() || !setting.isVisible()) {
				// skip non-relevant subsetting
				continue;
			}
			if (setting.isDirty()) {
				createAndAddToList(uiSettings, setting);
				list.add(setting);
			}
		}
		for (Setting setting : settings) {
			if (!list.contains(setting) && !setting.isReadOnly()) {
				createAndAddToList(uiSettings, setting);
			}
		}
		list.clear();

		return dirtyGroup;

	}

	/**
	 * Creates {@link UIGroup} from {@link Group}, UISettings are sorted
	 * according to notes(settings with notes are in the beginning)
	 * 
	 * @param l
	 * @return
	 */
	public UIGroup createNotesForGroup(Group l) {
		if (l instanceof ParentGroup) {
			return createNotesForParentGroup((ParentGroup) l);
		}
		return createNotesForLeafGroup((LeafGroup) l);
	}

	private UIGroup createNotesForLeafGroup(LeafGroup l) {
		UIGroup notesGroup = UIModelFactory.eINSTANCE.createUIGroup();
		EList<UISetting> uiSettings = notesGroup.getUiSettings();
		List<Setting> list = new ArrayList<Setting>();
		EList<Setting> settings = l.getSettings();
		for (Setting setting : settings) {
			if (!setting.isComputedRelevant() || !setting.isVisible()) {
				// skip non-relevant subsetting
				continue;
			}
			if (setting.getNote() != null
					&& !setting.getNote().trim().equals("")) {

				UISetting uiSetting = createUISettings(setting);
				uiSettings.add(uiSetting);
				list.add(setting);
			}
		}
		for (Setting setting : settings) {
			if (!setting.isComputedRelevant() || setting.isReadOnly()) {
				// skip non-relevant subsetting
				continue;
			}
			if (!list.contains(setting)) {
				UISetting uiSetting = createUISettings(setting);
				uiSettings.add(uiSetting);
			}
		}
		list.clear();
		return notesGroup;

	}

	private UIGroup createNotesForParentGroup(ParentGroup l) {
		UIGroup notesGroup = UIModelFactory.eINSTANCE.createUIGroup();
		EList<UISetting> uiSettings = notesGroup.getUiSettings();
		List<Setting> list = new ArrayList<Setting>();
		List<Setting> settings = new ArrayList<Setting>();
		settings.addAll(l.getSettings());
		EList<LeafGroup> leafGroups = l.getLeafGroup();
		for (LeafGroup leafGroup : leafGroups) {
			settings.addAll(leafGroup.getSettings());

		}
		for (Setting setting : settings) {
			if (!setting.isComputedRelevant() || !setting.isVisible()) {
				// skip non-relevant subsetting
				continue;
			}
			if (setting.getNote() != null
					&& !setting.getNote().trim().equals("")) {

				UISetting uiSetting = createUISettings(setting);
				uiSettings.add(uiSetting);
				list.add(setting);
			}
		}
		for (Setting setting : settings) {
			if (!setting.isComputedRelevant() || setting.isReadOnly()) {
				// skip non-relevant subsetting
				continue;
			}
			if (!list.contains(setting)) {
				UISetting uiSetting = createUISettings(setting);
				uiSettings.add(uiSetting);
			}
		}
		list.clear();
		return notesGroup;

	}

	public UISummaryModel createUISummaryModel(LeafGroup leaf) {
		UISummaryModel summaryModelRoot = SummaryModelFactory.eINSTANCE
				.createUISummaryModel();
		Map<String, UISummaryGroup> groups = new LinkedHashMap<String, UISummaryGroup>();

		UISummaryGroup groupMetadata = SummaryModelFactory.eINSTANCE
				.createUISummaryGroup();
		groupMetadata.setTitle("Variant Details");
		ViewEditorModel viewEditorModel = editor.getViewEditorModel();
		groupMetadata.getUiElements().add(
				createUIMetadata(viewEditorModel.getCpfMetadata(),
						SUMMARYTYPE.NAME));
		groupMetadata.getUiElements().add(
				createUIMetadata(viewEditorModel.getCpfMetadata(),
						SUMMARYTYPE.PRODUCT));
		groupMetadata.getUiElements().add(
				createUIMetadata(viewEditorModel.getCpfMetadata(),
						SUMMARYTYPE.PLATFORM));
		groupMetadata.getUiElements().add(
				createUIMetadata(viewEditorModel.getCpfMetadata(),
						SUMMARYTYPE.RELEASE));
		groupMetadata.getUiElements().add(
				createUIMetadata(viewEditorModel.getCpfMetadata(),
						SUMMARYTYPE.DATE));
		groupMetadata.getUiElements().add(
				createUIMetadata(viewEditorModel.getCpfMetadata(),
						SUMMARYTYPE.VERSION));

		CPFInformation cpfMetadata = viewEditorModel.getCpfMetadata();
		if (cpfMetadata.getStatus() != null) {
			groupMetadata.getUiElements().add(
					createUIMetadata(cpfMetadata, SUMMARYTYPE.STATUS));
		}
		if (cpfMetadata.getTarget() != null) {
			groupMetadata.getUiElements().add(
					createUIMetadata(viewEditorModel.getCpfMetadata(),
							SUMMARYTYPE.TARGET));
		}
		if (cpfMetadata.getOrigin() != null) {
			groupMetadata.getUiElements().add(
					createUIMetadata(viewEditorModel.getCpfMetadata(),
							SUMMARYTYPE.ORIGIN));
		}

		groupMetadata.getUiElements().add(
				createUIMetadata(viewEditorModel.getCpfMetadata(),
						SUMMARYTYPE.CUSTOMER));
		groupMetadata.getUiElements().add(
				createUIMetadata(viewEditorModel.getCpfMetadata(),
						SUMMARYTYPE.OWNER));
		groupMetadata.getUiElements().add(
				createUIMetadata(viewEditorModel.getCpfMetadata(),
						SUMMARYTYPE.AUTHOR));
		groupMetadata.getUiElements().add(
				createUIMetadata(viewEditorModel.getCpfMetadata(),
						SUMMARYTYPE.DESCRIPTION));
		EConfigurationProject cp = editor.getProject();
		EConfMLLayer lastLayer = cp.getLastLayer();

		URI guidelinesURI = URI.createURI("doc/guidelines").resolve(
				lastLayer.getLayerURI());
		URI productImagesURI = URI.createURI("doc/productimages").resolve(
				lastLayer.getLayerURI());

		// if directory guidelines doesn't contain some file than Summary
		// element (for guidelines) will not be showed in Summary page
		// it's same for productimages
		int nrOfGuidelines = 0;
		int nrOfProductImages = 0;

		for (URI uri : lastLayer.getLayerFiles()) {
			if (uri.toString().contains(guidelinesURI.toString())) {
				nrOfGuidelines++;
			} else if (uri.toString().contains(productImagesURI.toString())) {
				nrOfProductImages++;
			}
		}

		if (nrOfGuidelines > 0) {
			UIElement elementGuideline = SummaryModelFactory.eINSTANCE
					.createUIElement();
			elementGuideline.setName("Customization Guideline");
			elementGuideline.setType(SUMMARYTYPE.GUIDELINE);
			groupMetadata.getUiElements().add(elementGuideline);
		}

		// only avr.txt from the last layer, not from any other layer
		URI avrURI = URI.createURI("doc/avr.txt").resolve(
				lastLayer.getLayerURI());
		if (lastLayer.getLayerFiles().contains(avrURI)) {
			UIElement avrElement = SummaryModelFactory.eINSTANCE
					.createUIElement();
			avrElement.setName("Additional Variation Requests");
			avrElement.setType(SUMMARYTYPE.AVR);
			avrElement.setValue("avr.txt");
			avrElement.setLastSavedValue("avr.txt");
			avrElement.setNote(viewEditorModel.getAvrProperty());
			addAdapterForMetadata(null, avrElement);
			groupMetadata.getUiElements().add(avrElement);
		}
		if (nrOfProductImages > 0) {
			UIElement elementProductImages = SummaryModelFactory.eINSTANCE
					.createUIElement();
			elementProductImages.setName("Product Images");
			elementProductImages.setType(SUMMARYTYPE.PRODUCTIMAGES);
			// groupMetadata.getUiElements().add(elementGuideline);
			groupMetadata.getUiElements().add(elementProductImages);
		}

		UISummaryGroup groupStatistics = SummaryModelFactory.eINSTANCE
				.createUISummaryGroup();
		groupStatistics.setTitle("Statistics");

		UIElement elementContents = SummaryModelFactory.eINSTANCE
				.createUIElement();
		elementContents.setName("Contents");
		elementContents.setType(SUMMARYTYPE.CONTENTS);

		UIElement elementHistory = SummaryModelFactory.eINSTANCE
				.createUIElement();
		elementHistory.setName("Change History");
		elementHistory.setType(SUMMARYTYPE.HISTORY);

		groupStatistics.getUiElements().add(elementContents);
		groupStatistics.getUiElements().add(elementHistory);

		groups.put(groupMetadata.getTitle(), groupMetadata);
		groups.put(groupStatistics.getTitle(), groupStatistics);

		Collection<UISummaryGroup> values = groups.values();
		summaryModelRoot.getUiGroups().addAll(values);

		return summaryModelRoot;

	}

	private UIElement createUIMetadata(CPFInformation cpfMetadata,
			SUMMARYTYPE type) {
		UIElement createUIElement = SummaryModelFactory.eINSTANCE
				.createUIElement();
		ViewEditorModel viewEditorModel = editor.getViewEditorModel();
		switch (type.getValue()) {
		case SUMMARYTYPE.NAME_VALUE:
			createUIElement.setName("CPF Title");
			String cpfFilePath = viewEditorModel.getCpfFilePath();
			if (cpfFilePath != null) {
				String substring = viewEditorModel.getCpfFilePath().substring(
						cpfFilePath.lastIndexOf("\\") + 1);
				createUIElement.setValue(substring);
			}
			break;
		case SUMMARYTYPE.PRODUCT_VALUE:
			createUIElement.setName("Product");
			createUIElement.setValue(cpfMetadata.getProduct());
			break;
		case SUMMARYTYPE.PLATFORM_VALUE:
			createUIElement.setName("Platform");
			createUIElement.setValue(cpfMetadata.getPlatform());
			break;
		case SUMMARYTYPE.RELEASE_VALUE:
			createUIElement.setName("Release");
			createUIElement.setValue(cpfMetadata.getRelease());
			break;
		case SUMMARYTYPE.DATE_VALUE:
			createUIElement.setName("Date");
			createUIElement.setValue(cpfMetadata.getDate());
			break;
		case SUMMARYTYPE.VERSION_VALUE:
			createUIElement.setName("Version");
			createUIElement.setValue(cpfMetadata.getVersion());
			break;
		case SUMMARYTYPE.CUSTOMER_VALUE:
			createUIElement.setName("Customer");
			createUIElement.setValue(cpfMetadata.getCustomer());
			break;
		case SUMMARYTYPE.OWNER_VALUE:
			createUIElement.setName("Owner");
			createUIElement.setValue(cpfMetadata.getOwner());
			break;
		case SUMMARYTYPE.AUTHOR_VALUE:
			createUIElement.setName("Author");
			createUIElement.setValue(cpfMetadata.getAuthor());
			break;
		case SUMMARYTYPE.DESCRIPTION_VALUE:
			createUIElement.setName("Description");
			createUIElement.setValue(cpfMetadata.getDescription());
			break;
		case SUMMARYTYPE.STATUS_VALUE:
			if (cpfMetadata.getStatus() != null) {
				createUIElement.setName("Status");
				createUIElement.setValue(cpfMetadata.getStatus());
			} else {
				return null;
			}
			break;
		case SUMMARYTYPE.TARGET_VALUE:
			if (cpfMetadata.getTarget() != null) {
				createUIElement.setName("Target");
				createUIElement.setValue(cpfMetadata.getTarget());
			} else {
				return null;
			}
			break;
		case SUMMARYTYPE.ORIGIN_VALUE:
			if (cpfMetadata.getOrigin() != null) {
				createUIElement.setName("Origin");
				createUIElement.setValue(cpfMetadata.getOrigin());
			} else {
				return null;
			}
			break;

		}

		if (createUIElement.getValue() == null)
			createUIElement.setValue("");

		// createUIElement.setDefaultValue(createUIElement.getValue());
		createUIElement.setLastSavedValue(createUIElement.getValue());

		if (createUIElement.getName() != null) {
			createUIElement.setType(type);
			addAdapterForMetadata(cpfMetadata, createUIElement);
		}

		return createUIElement;
	}

	private void addAdapterForMetadata(CPFInformation cpfMetadata,
			UIElement uiElement) {
		SettingsViewer settingsViewer = editor.getSettingsViewer();
		Adapter o = new NotifyAdapter(uiElement, settingsViewer);

		uiElement.eAdapters().add(o);
		settingsViewer.getControl().addDisposeListener(
				new AdapterRemovalDisposeListener(uiElement, o));
	}

}
