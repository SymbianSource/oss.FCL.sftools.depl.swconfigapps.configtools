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

package com.nokia.tools.variant.editor.adapters;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.nokia.tools.variant.content.confml.ConfmlPackage;
import com.nokia.tools.variant.content.confml.FilePath;
import com.nokia.tools.variant.content.confml.FileSystemEntrySetting;
import com.nokia.tools.variant.content.confml.SequenceItem;
import com.nokia.tools.variant.content.confml.SequenceSetting;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.TYPE;
import com.nokia.tools.variant.editor.editors.CPFEditor;
import com.nokia.tools.variant.editor.editors.SettingEvaluator;
import com.nokia.tools.variant.editor.model.UISetting;
import com.nokia.tools.variant.resourcelibrary.model.FileSystemElement;
import com.nokia.tools.variant.resourcelibrary.model.ResourceModelRoot;
import com.nokia.tools.variant.resourcelibrary.resources.ResourceUtil;
import com.nokia.tools.variant.viewer.viewer.SettingsViewer;

/**
 * Used to update element in viewer and also to get UISetting from Setting
 * 
 */
public class SettingToUISettingAdapter implements Adapter {
	private Setting setting;
	private UISetting uiSetting;
	private CPFEditor editor;
	private int index;
	/**
	 * Constructs a SettingToUISettingAdapter.
	 * 
	 * @param setting
	 * @param uiSetting
	 * @param editor
	 */
	public SettingToUISettingAdapter(Setting setting, UISetting uiSetting,
			CPFEditor editor) {
		this.setting = setting;
		this.uiSetting = uiSetting;
		this.editor = editor;
	}

	public Notifier getTarget() {

		return null;
	}

	/**
	 * Returns whether the adapter is of the given type.
	 * 
	 * @param type
	 *            the type.
	 * @return whether the adapter is of the given type.
	 * @see AdapterFactory#isFactoryForType
	 */
	public boolean isAdapterForType(Object type) {
		if (type == SettingToUISettingAdapter.class) {
			return true;
		}
		return false;
	}

	/**
	 * Notifies that a change to some feature has occurred.
	 * 
	 * @param notification
	 *            a description of the change.
	 */
	public void notifyChanged(Notification notification) {
		if (notification.getEventType() == Notification.REMOVING_ADAPTER) {
			return;
		}
		if (notification.getFeatureID(Setting.class) == ConfmlPackage.SIMPLE_SETTING__VALUE
				|| notification.getFeatureID(Setting.class) == ConfmlPackage.FILE_PATH__PATH
				|| notification.getNewValue() instanceof SequenceItem
				|| notification.getNewValue() instanceof Setting
				|| notification.getNewValue() == null
				|| notification.getFeatureID(Setting.class) == ConfmlPackage.SIMPLE_SETTING__NOTE
				|| notification.getFeatureID(Setting.class) == ConfmlPackage.SETTING__VALUE_NULL
		/*
		 * || notification.getFeatureID(Setting.class) ==
		 * ConfmlPackage.SIMPLE_SETTING__OPTIONS_MAP
		 */) {

			SettingsViewer settingsViewer = editor.getSettingsViewer();
			if (getUiSetting().getSetting() instanceof FileSystemEntrySetting) {
				EList<UISetting> children = getUiSetting().getChildren();
				for (UISetting setting2 : children) {
					settingsViewer.update(setting2, null);
				}

				updateResourceLibraryModel(notification.getOldStringValue(),
						notification.getNewStringValue());
			}
			if (notification.getNewValue() instanceof SequenceItem) {
				SettingEvaluator.validateConstraintAttributeForSequenceItem(
						(SequenceItem) notification.getNewValue(), editor
								.getErrorsRoot(), editor.getViewEditorModel()
								.getResourceModelRoot(), editor);
			}
			if (setting.getType() == TYPE.SIMPLE_FILE
					|| setting.getType() == TYPE.SIMPLE_FOLDER) {
				updateResourceLibraryModel(notification.getOldStringValue(),
						notification.getNewStringValue());
			}

			settingsViewer.update(getUiSetting(), null);
			EList<Setting> optionDependencies = setting.getOptionDependencies();
			if (optionDependencies != null) {
				for (Setting setting : optionDependencies) {
					UISetting findUiSetting = findUiSetting(setting);
					if (findUiSetting != null) {
						settingsViewer.update(findUiSetting, null);
					}
				}
			}
			EObject eContainer = setting.eContainer();
			while (eContainer != null
					&& !(eContainer instanceof SequenceSetting)) {
				eContainer = eContainer.eContainer();
			}

			if (eContainer instanceof SequenceSetting) {
				SequenceSetting sequenceSetting = (SequenceSetting) eContainer;
				UISetting element = editor.getUISetting(sequenceSetting);
				settingsViewer.update(element, null);
				EList<UISetting> children = element.getChildren();
				for (UISetting child : children) {
					settingsViewer.update(child, null);
					EList<UISetting> children2 = child.getChildren();
					for (UISetting child2 : children2) {
						// for file setting v.2
						EList<UISetting> children3 = child2.getChildren();
						if (children3.size() > 0) {
							for (UISetting child3 : children3) {
								settingsViewer.update(child3, null);
							}
						} else {
							settingsViewer.update(child2, null);
						}
					}
				}

			}

		}
	}

	public void setTarget(Notifier newTarget) {

	}

	/**
	 * Search for UISetting via list of setting adapters.
	 * 
	 * @param Setting
	 *            to search in.
	 * @return an UISetting from the list of setting adapters or null.
	 */
	private UISetting findUiSetting(Setting setting) {
		EList<Adapter> adapters = setting.eAdapters();
		Adapter adapter = EcoreUtil.getAdapter(adapters,
				SettingToUISettingAdapter.class);
		if (adapter instanceof SettingToUISettingAdapter) {
			UISetting uiSetting2 = ((SettingToUISettingAdapter) adapter)
					.getUiSetting();
			return uiSetting2;
		}
		return null;
	}

	public UISetting getUiSetting() {

		return uiSetting;
	}

	/**
	 * When file setting value is changed, then the setting is added/removed
	 * from list of referenced setting.
	 */
	private void updateResourceLibraryModel(String oldValue, String newValue) {
		ResourceModelRoot resourceModelRoot = editor.getViewEditorModel()
				.getResourceModelRoot();
		FileSystemElement oldFileElement = ResourceUtil.getFileSystemElement(
				resourceModelRoot, oldValue);
		FileSystemElement newFileElement = ResourceUtil.getFileSystemElement(
				resourceModelRoot, newValue);

		Setting currentSet = setting;
		if (setting instanceof FilePath) {
			currentSet = ((FilePath) setting).getParent();
		}

		if (oldFileElement != null) {
			oldFileElement.getSettings().remove(currentSet);
		}
		if (newFileElement != null) {
			newFileElement.getSettings().add(currentSet);
		}
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	
}
