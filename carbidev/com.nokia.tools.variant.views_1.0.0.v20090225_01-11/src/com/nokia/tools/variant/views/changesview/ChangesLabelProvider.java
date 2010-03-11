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
 * Description: This file is part of com.nokia.tools.variant.views component.
 */

package com.nokia.tools.variant.views.changesview;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import com.nokia.tools.variant.content.confml.FilePath;
import com.nokia.tools.variant.content.confml.FileSystemEntrySetting;
import com.nokia.tools.variant.content.confml.LeafGroup;
import com.nokia.tools.variant.content.confml.Option;
import com.nokia.tools.variant.content.confml.ParentGroup;
import com.nokia.tools.variant.content.confml.SequenceSetting;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.SimpleSetting;
import com.nokia.tools.variant.content.confml.TYPE;
import com.nokia.tools.variant.content.confml.impl.OptionImpl;
import com.nokia.tools.variant.content.confml.util.SettingValueUtils;

/**
 * Label provider for the table viewer located in the changes view.
 * 
 * @see ChangesViewPage
 * @see ChangesContentProvider
 */
public class ChangesLabelProvider implements ITableLabelProvider {

	public Image getColumnImage(Object element, int columnIndex) {
		
		return null;
	}

	public String getColumnText(Object element, int columnIndex) {
		Setting setting = (Setting) element;
		switch (columnIndex) {
		case 0:
			if (setting instanceof FilePath) {
				FilePath fileSetting = (FilePath) setting;
				FileSystemEntrySetting parent = fileSetting.getParent();
				if (fileSetting.equals(parent.getTargetFilePath())) {
					return fileSetting.getName() + " - Location in Phone";
				}

			}
			return setting.getName();
		case 1:
			if (setting instanceof FilePath) {
				FilePath filePath = ((FilePath) setting);
				if (TYPE.SELECTION.equals(setting.getType())) {
					String value = filePath.getPath();
					EList<Option> options = filePath.getOption();
					for (Option option : options) {
						if (option.getValue().equals(value))
							return option.getName();
					}
				} else if (TYPE.MULTISELECTION.equals(setting.getType())) {
					return SettingValueUtils.getValueConvertedToOptionNames(
							filePath.getPath(), filePath.getOption());
				}

				return filePath.getPath();
			} else if (setting instanceof SequenceSetting) {
				return "Sequence Setting";
			} else if (setting instanceof SimpleSetting) {
				SimpleSetting simpleSet = (SimpleSetting) setting;
				if (TYPE.SELECTION.equals(setting.getType())) {
					String value = simpleSet.getValue();
					EList<Option> options = simpleSet.getOption();
					for (Option option : options) {
						if (option.getValue().equals(value))
							return option.getName();
					}
				} else if (TYPE.MULTISELECTION.equals(setting.getType())) {
					return SettingValueUtils.getValueConvertedToOptionNames(
							simpleSet.getValue(), simpleSet.getOption());
				}
				String choosenOption = simpleSet.getChoosenOption();

				if (choosenOption != null && !"".equals(choosenOption)) {
					return choosenOption;
				}

				return simpleSet.getValue();
			}

		case 2:
			if (setting instanceof FilePath) {
				FilePath filePath = ((FilePath) setting);
				if (TYPE.SELECTION.equals(setting.getType())) {
					String value = filePath.getDefaultPath();
					EList<Option> options = filePath.getOption();
					for (Option option : options) {
						if (option.getValue().equals(value))
							return option.getName();
					}
				} else if (TYPE.MULTISELECTION.equals(setting.getType())) {
					return SettingValueUtils.getValueConvertedToOptionNames(
							filePath.getDefaultPath(), filePath.getOption());
				}

				return filePath.getDefaultPath();
			} else if (setting instanceof SequenceSetting) {
				return "Press double-click to show the setting in the editor.";
			} else if (setting instanceof SimpleSetting) {
				SimpleSetting simpleSet = (SimpleSetting) setting;
				if (TYPE.SELECTION.equals(setting.getType())) {
					String value = simpleSet.getDefaultValue();
					EList<Option> options = simpleSet.getOption();
					for (Option option : options) {
						if (option.getValue().equals(value))
							return option.getName();
					}
				} else if (TYPE.MULTISELECTION.equals(setting.getType())) {
					return SettingValueUtils.getValueConvertedToOptionNames(
							simpleSet.getDefaultValue(), simpleSet.getOption());
				}
				String defaultValue = simpleSet.getDefaultValue();

				if (defaultValue != null
						&& defaultValue.contains(OptionImpl.OPTION_MAP_KEY)) {
					defaultValue = defaultValue.substring(defaultValue
							.indexOf(OptionImpl.OPTION_MAP_KEY)
							+ OptionImpl.OPTION_MAP_KEY.length());
					int i = defaultValue.lastIndexOf("\"]");
					if (i >= 0) {
						defaultValue = defaultValue.substring(0, i);
					}
					return defaultValue;
				}
				return simpleSet.getDefaultValue();
			}
		case 3:
			String location = "";
			if (setting.getLeafGroup().size() > 0) {
				LeafGroup leafGroup = setting.getLeafGroup().get(0);
				EObject container = leafGroup.eContainer();
				if (container instanceof ParentGroup) {
					ParentGroup parentGroup = (ParentGroup) container;
					location = parentGroup.getName() + " - "
							+ leafGroup.getName();
				}
			} else if (setting.eContainer().eContainer() instanceof SequenceSetting) {
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
			} else if (setting.getParentGroup().size() > 0) {
				ParentGroup parentGroup = setting.getParentGroup().get(0);
				location = parentGroup.getName();
			}
			return location;
		}
		return null;
	}

	public void addListener(ILabelProviderListener listener) {
		

	}

	public void dispose() {
		

	}

	public boolean isLabelProperty(Object element, String property) {
		
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {
		

	}

}
