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

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

import com.nokia.tools.variant.content.confml.FilePath;
import com.nokia.tools.variant.content.confml.Option;
import com.nokia.tools.variant.content.confml.OptionMapEntry;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.SimpleSetting;
import com.nokia.tools.variant.content.confml.TYPE;
import com.nokia.tools.variant.editor.model.UIGroup;
import com.nokia.tools.variant.editor.model.UISetting;
import com.nokia.tools.variant.editor.validation.SettingsValidator;
import com.nokia.tools.variant.resourcelibrary.model.ResourceModelRoot;
import com.nokia.tools.variant.viewer.validation.EResult;
import com.nokia.tools.variant.viewer.validation.ValidationResult;
import com.nokia.tools.variant.viewer.viewer.ISettingsLabelProvider;
import com.nokia.tools.variant.viewer.viewer.Type;
import com.nokia.tools.variant.viewer.widgets.WidgetOption;
import com.nokia.tools.variant.viewer.widgets.WidgetOptions;
import com.nokia.tools.variant.viewer.widgets.WidgetOptions.SettingType;

/**
 * This provider is used to map the UIModel into text strings displayable in the
 * SettingsViewer widgets in the Value Editor. The provider has method
 * getText(Object element) that returns name of group or setting.
 */
public class EditorViewerLabelProvider implements ISettingsLabelProvider {

	private ResourceModelRoot modelRoot;

	public EditorViewerLabelProvider(ResourceModelRoot modelRoot) {
		this.modelRoot = modelRoot;
	}

	public Image getImage(Object element) {

		return null;
	}

	public String getText(Object element) {
		if (element instanceof UIGroup) {
			String title = ((UIGroup) element).getTitle();
			return title;
		}
		if (element instanceof UISetting) {
			UISetting ui = (UISetting) element;
			Setting setting = ui.getSetting();
			if (setting == null) {
				return "";
			}
			return setting.getName();
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

	public Type getType(Object element) {
		if (element instanceof UISetting) {
			UISetting ui = (UISetting) element;
			Setting setting = ui.getSetting();
			if (setting == null) {
				return Type.ITEM;
			}
			TYPE type = setting.getType();
			if (ui.getData() instanceof Type) {
				return (Type) ui.getData();
			}

			if (type.equals(TYPE.STRING)) {
				return Type.STRING;
			}
			if (type.equals(TYPE.SIMPLE_FILE)) {
				return Type.SIMPLE_FILE;
			}
			if (type.equals(TYPE.DATE_TIME)) {
				return Type.DATE_TIME;
			}
			if (type.equals(TYPE.SIMPLE_FOLDER)) {
				return Type.SIMPLE_FILE;
			}

			if (type.equals(TYPE.SELECTION)) {
				return Type.SELECTION;
			}
			if (type.equals(TYPE.MULTISELECTION)) {
				return Type.MULTISELECTION;
			}
			if (type.equals(TYPE.BOOLEAN)) {
				return Type.BOOLEAN;
			}
			if (type.equals(TYPE.FILE)||type.equals(TYPE.FILESOURCE)||type.equals(TYPE.FILETARGET)) {
				return Type.FILE;
			}
			if (type.equals(TYPE.SEQUENCE)) {
				return Type.SEQUENCE;
			}
			if (type.equals(TYPE.DATE)) {
				return Type.DATE;
			}
			if (type.equals(TYPE.TIME)) {
				return Type.TIME;
			}
			if (type.equals(TYPE.DURATION)) {
				return Type.DURATION;
			}

		}
		if (element instanceof UIGroup) {

			return Type.TITLE;

		}

		return Type.INT;
	}

	/**
	 * Method returns widget options for given object which has to be instance
	 * of <code>com.nokia.tools.variant.editor.model.UISetting</code>.
	 */
	public WidgetOptions getOptions(Object object) {

		if (object instanceof UISetting) {
			Set<WidgetOption> optionsSet = new LinkedHashSet<WidgetOption>();
			UISetting ui = (UISetting) object;
			Setting setting = ui.getSetting();
			if (setting instanceof Setting) {
				Setting simple = (Setting) setting;
				processOptions(simple, optionsSet);
				return new WidgetOptions(optionsSet, convertType(setting.getType()));
			}
			
		}
		return null;
	}

	private SettingType convertType(TYPE type) {
		if (type == TYPE.BOOLEAN) {
			return SettingType.BOOLEAN;
		} else if (type == TYPE.DATE) {
			return SettingType.DATE;
		} else if (type == TYPE.DATE_TIME) {
			return SettingType.DATE_TIME;
		} else if (type == TYPE.DURATION) {
			return SettingType.DURATION;
		} else if ((type == TYPE.FILE)||(type == TYPE.FILESOURCE)||((type == TYPE.FILETARGET))) {
			return SettingType.FILE;
		} else if (type == TYPE.FOLDER) {
			return SettingType.FOLDER;
		} else if (type == TYPE.INT) {
			return SettingType.INT;
		} else if (type == TYPE.MULTISELECTION) {
			return SettingType.MULTISELECTION;
		} else if (type == TYPE.REAL) {
			return SettingType.REAL;
		} else if (type == TYPE.SELECTION) {
			return SettingType.SELECTION;
		} else if (type == TYPE.SEQUENCE) {
			return SettingType.SEQUENCE;
		} else if (type == TYPE.SIMPLE_FILE) {
			return SettingType.SIMPLE_FILE;
		} else if (type == TYPE.STRING) {
			return SettingType.STRING;
		} else if (type == TYPE.TIME) {
			return SettingType.TIME;
		}
		return null;
	}

	/**
	 * Method adds to set of options new widget options, which passed validation
	 * and are relevant.
	 * 
	 * @param simple
	 * @param optionsSet
	 */
	private void processOptions(Setting simple, Set<WidgetOption> optionsSet) {
		EList<Option> options = simple.getOption();

		for (Option option : options) {
			Map<String, OptionMapEntry> optionValues = option.getOptionValues();
			String relevant = option.getRelevant();
			if (relevant == null
					|| "".equals(relevant)
					|| ConfMLExpressionEvaluationUtil.evaluateSetting(simple,
							relevant)) {
				processOption(optionsSet, option, optionValues, relevant,
						simple);

			}
		}
	}

	/**
	 * Method adds to set of options new widget options, which passed
	 * validation.
	 * 
	 * @param optionsSet
	 * @param option
	 * @param optionValues
	 * @param relevant
	 * @param setting
	 */
	private void processOption(Set<WidgetOption> optionsSet, Option option,
			Map<String, OptionMapEntry> optionValues, String relevant,
			Setting setting) {

		if (option.getMap() != null && optionValues != null) {
			Set<String> keySet = optionValues.keySet();
			for (String name : keySet) {
				OptionMapEntry value = optionValues.get(name);
				if (setting.getType() == TYPE.MULTISELECTION) {
					WidgetOption widgetOption = new WidgetOption(name, value
							.getValue2Save(), relevant, value.getMapValue());
					isOptionSelected(setting, value.getValue2Save(),
							widgetOption);
					optionsSet.add(widgetOption);
				} else {
					ValidationResult result = SettingsValidator
							.validateOptionForSetting(setting, name, modelRoot);
					if (result.getResult().size() > 0) {
						if (result.getResult().contains(EResult.VALID)) {
							WidgetOption widgetOption = new WidgetOption(name,
									value.getValue2Save(), relevant, value
											.getMapValue());
							isOptionSelected(setting, value.getValue2Save(),
									widgetOption);
							optionsSet.add(widgetOption);
						}
					}
				}
			}
		} else {
			String value = option.getValue();
			String name = option.getName();
			if (name != null && !"".equals(name)) {

				if (setting.getType() == TYPE.MULTISELECTION) {
					WidgetOption widgetOption = new WidgetOption(name, value,
							relevant, null);
					isOptionSelected(setting, value, widgetOption);
					optionsSet.add(widgetOption);
				} else {
					ValidationResult result = SettingsValidator
							.validateOptionForSetting(setting, value, modelRoot);
					if (setting.getType() == TYPE.MULTISELECTION
							|| result.getResult().size() > 0) {
						if (result.getResult().contains(EResult.VALID)) {
							WidgetOption widgetOption = new WidgetOption(option
									.getName(), value, relevant, null);
							isOptionSelected(setting, value, widgetOption);
							optionsSet.add(widgetOption);
						}
					}
				}
			}
		}
	}

	private void isOptionSelected(Setting setting, String value,
			WidgetOption widgetOption) {
		if (setting instanceof SimpleSetting) {
			SimpleSetting simpleSetting = (SimpleSetting) setting;
			String choosenOption = simpleSetting.getValue();
			if (value != null && value.equals(choosenOption)) {
				widgetOption.setSelected(true);
			}
		} else if (setting instanceof FilePath) {
			FilePath filePath = (FilePath) setting;
			String choosenOption = filePath.getPath();
			if (value != null && value.equals(choosenOption)) {
				widgetOption.setSelected(true);
			}
		}
	}

	public void doUpdate(Object element) {
		if (element instanceof UISetting){
			
			UISetting uiSetting = (UISetting) element;
			Setting setting = uiSetting.getSetting();
			EList<Setting> optionDependencies = setting.getOptionDependencies();
			
			
		}
	}

}
