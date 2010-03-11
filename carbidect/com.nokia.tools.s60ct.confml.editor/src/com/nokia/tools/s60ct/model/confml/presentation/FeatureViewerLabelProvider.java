/*
* Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
* All rights reserved.
* This component and the accompanying materials are made available
* under the terms of "Eclipse Public License v1.0"
* which accompanies this distribution, and is available
* at the URL "http://www.eclipse.org/legal/epl-v10.html".
*
* Initial Contributors:
* Nokia Corporation - initial contribution.
*
* Contributors:
*
* Description:
*
*/
package com.nokia.tools.s60ct.model.confml.presentation;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

import com.nokia.tools.s60ct.confml.editor.validation.EResult;
import com.nokia.tools.s60ct.confml.editor.validation.IResult;
import com.nokia.tools.s60ct.confml.editor.validation.SettingsValidator;
import com.nokia.tools.s60ct.confml.editor.validation.ValidationResult;
import com.nokia.tools.s60ct.confml.viewer.ISettingsLabelProvider;
import com.nokia.tools.s60ct.confml.widgets.WidgetOption;
import com.nokia.tools.s60ct.confml.widgets.WidgetOptions;
import com.nokia.tools.s60ct.model.confml.EFeature;
import com.nokia.tools.s60ct.model.confml.EGroup;
import com.nokia.tools.s60ct.model.confml.EOption;
import com.nokia.tools.s60ct.model.confml.EOptionMap;
import com.nokia.tools.s60ct.model.confml.EResourceSetting;
import com.nokia.tools.s60ct.model.confml.EResourceValue;
import com.nokia.tools.s60ct.model.confml.ESequenceSetting;
import com.nokia.tools.s60ct.model.confml.ESequenceValueItem;
import com.nokia.tools.s60ct.model.confml.ESetting;
import com.nokia.tools.s60ct.model.confml.ESettingOption;
import com.nokia.tools.s60ct.model.confml.ESettingValue;
import com.nokia.tools.s60ct.model.confml.ESettingValueType;
import com.nokia.tools.s60ct.model.confml.ESimpleSetting;
import com.nokia.tools.s60ct.model.confml.ESimpleValue;
import com.nokia.tools.s60ct.model.confml.util.ConfMLExpressionEvaluationUtil;
import com.nokia.tools.s60ct.model.confml.util.UISettingType;
import com.nokia.tools.s60ct.resources.model.ELibraryRoot;

public class FeatureViewerLabelProvider implements ISettingsLabelProvider {

	private ELibraryRoot modelRoot;
	
	public FeatureViewerLabelProvider(ELibraryRoot modelRoot) {
		this.modelRoot = modelRoot;
	}
	
	public Image getImage(Object element) {
		return null;
	}

	public String getText(Object element) {
		if(element instanceof EFeature) {
			EFeature feature = (EFeature) element;
			return feature.getName();
		} else if(element instanceof ESetting) {
			ESetting setting = (ESetting) element;
			return setting.getName();
		} else if(element instanceof EGroup) {
			EGroup group = (EGroup) element;
			return group.getName();
		} else if(element instanceof ESequenceValueItem) {
			return "frame";
		} else if(element instanceof ESimpleValue) {
			
			ESimpleValue simSet = (ESimpleValue)element;
			if (simSet.getType()==null)
				return null;
			String name = simSet.getType().getName();
			return name;
//			return "simple value";
			
		}
		else if(element instanceof EResourceValue) {
				
			EResourceValue resVal = (EResourceValue)element;
			String name = resVal.getType().getName();
			return name;	
		}
		 else {
			return "Not implemented";
		}
	}

	public WidgetOptions getOptions(Object element) {		
		
		Set<WidgetOption> optionsSet = new LinkedHashSet<WidgetOption>();
		//WidgetOptions mapOptions = null;// new HashMap<String, String>();
		
		if(element instanceof ESimpleSetting) 
		{
			ESimpleSetting eSetting = (ESimpleSetting) element;
			processOptions(eSetting, optionsSet);
			return new WidgetOptions(optionsSet, eSetting.getType());
		} 
		else if(element instanceof ESimpleValue)
		{
			ESimpleValue simVal = (ESimpleValue)element;
			ESimpleSetting type = (ESimpleSetting) simVal.getType();
			processOptions(type,optionsSet);
			return new WidgetOptions(optionsSet, type.getType());
		}
		else if(element instanceof EResourceValue)
		{
			EResourceValue resVal = (EResourceValue)element;
			EResourceSetting type = (EResourceSetting) resVal.getType();
			System.out.println("unimplemented type EResourceValue in getOptions");
//			processOptions(type,optionsSet);
//			return new WidgetOptions(optionsSet, type.getType());
		}
		else if(element instanceof EResourceSetting)
		{
			EResourceSetting rSetting = (EResourceSetting)element;
			if (rSetting.getValue() != null && rSetting.getValue() instanceof EResourceValue)
			{
				EResourceValue resVal = (EResourceValue)rSetting.getValue();
				EResourceSetting type = (EResourceSetting) resVal.getType();
				System.out.println("unimplemented type EResourceValue in getOptions");
				//processOptions(type,optionsSet);
				//return new WidgetOptions(optionsSet, type.getType());
			}
		}
		else
		{
			System.out.println("unimplemented type in getOptions");
		}
		return null;
	}

	private void processOptions(ESimpleSetting simple, Set<WidgetOption> optionsSet) {
		EList<ESettingOption> options = simple.getOptions();

		for (ESettingOption option : options) 
		{
			Map<String, EOptionMap> optionValues = ((EOption)option).getOptionValues();
			String relevant = option.getRelevant();
			if (relevant == null || "".equals(relevant)	|| ConfMLExpressionEvaluationUtil
							.evaluateOptionRelevant(option)) 
			{
				processOption(optionsSet, (EOption)option, optionValues, relevant, simple);

			}
		}

	}
	
	private void processOption(Set<WidgetOption> optionsSet, EOption option,
			Map<String, EOptionMap> optionValues, String relevant, ESimpleSetting setting) 
	{

		if (option.getMap() != null && optionValues != null) {
			Set<String> keySet = optionValues.keySet();
			for (String name : keySet) {
				EOptionMap value = optionValues.get(name);
				if (setting.getType() == ESettingValueType.MULTISELECTION)
				{
					WidgetOption widgetOption = new WidgetOption(name, value
							.getValue2Save(), relevant, value.getMapValue());
					isOptionSelected(setting, value.getValue2Save(),
							widgetOption);
					optionsSet.add(widgetOption);
				} 
				else 
				{
					ValidationResult result = SettingsValidator	.validateOptionForSetting(setting, name, modelRoot);
					validateRelevantsForOption(optionsSet, option, relevant,setting, name, value, result);
				}
			}
		} else {
			String value = option.getValue();
			String name = option.getName();
			if (name != null && !"".equals(name)) {

				if (setting.getType() == ESettingValueType.MULTISELECTION) {
					WidgetOption widgetOption = new WidgetOption(name, value,
							relevant, null);
					isOptionSelected(setting, value, widgetOption);
					optionsSet.add(widgetOption);
				} else {
					ValidationResult result = SettingsValidator
							.validateOptionForSetting(setting, value, modelRoot);
					if (setting.getType() == ESettingValueType.MULTISELECTION
							|| result.getResult().size() > 0) {
						if (result.getResult().contains(EResult.VALID)
								|| result.getResult().contains(
										EResult.NON_RELEVANT_DEPENDENCIES)) {
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
	
	private void validateRelevantsForOption(Set<WidgetOption> optionsSet,
			EOption option, String relevant, ESetting setting, String name,
			EOptionMap value, ValidationResult result) {
		List<IResult> resultList = result.getResult();
		if (!resultList.contains(EResult.VALID)
				&& !resultList.contains(EResult.NON_RELEVANT_DEPENDENCIES)) {
			return;
		}

		ESequenceSetting mapSourceSetting = option.getMapSourceSetting();
		if (mapSourceSetting != null) {
			if (mapSourceSetting.isComputedRelevant()) {
				resultList.add(EResult.VALID);
				String mapValue = mapSourceSetting.getMapValue();
				
				EList<ESetting> subSettings = mapSourceSetting.getSubTypes();
				
				for (ESetting subSetting : subSettings)
				{
					if (!subSetting.isComputedRelevant()
							&& subSetting.getRef().equals(mapValue)) {
						if (subSetting instanceof ESimpleSetting) {
							ESimpleSetting simpleSetting = (ESimpleSetting) subSetting;
							String simpleSettingValue = ((ESimpleValue)simpleSetting).getValue();
							if (simpleSettingValue != null
									&& simpleSettingValue.equals(name)) {
								resultList.remove(EResult.VALID);
								break;
							}
						} else if (subSetting instanceof EResourceSetting) {

							String filePath = ((ESimpleValue)((EResourceSetting) subSetting).getLocalPath().getValue()).getValue() ;//	.getPath();
							if (filePath != null && filePath.equals(name)) {
								resultList.remove(EResult.VALID);
								break;
							}

						}
					}
				}

			} else {
				resultList.remove(EResult.VALID);
			}
		}

		if (resultList.size() > 0) {

			if (resultList.contains(EResult.VALID)) {
				WidgetOption widgetOption = new WidgetOption(name, value
						.getValue2Save(), relevant, value.getMapValue());
				isOptionSelected(setting, value.getValue2Save(), widgetOption);
				optionsSet.add(widgetOption);
			}
		}
	}
	
	private void isOptionSelected(ESetting setting, String value,
			WidgetOption widgetOption) {
		if (setting instanceof ESimpleSetting) {
			ESimpleSetting simpleSetting = (ESimpleSetting) setting;
			if (simpleSetting.getValue()!=null)
			{
				String choosenOption = ((ESimpleValue)simpleSetting.getValue()).getValue();
				if (value != null && value.equals(choosenOption)) {
					widgetOption.setSelected(true);
				}
			}
		} 
//		else if (setting instanceof EResourceSetting) {
//			EResourceSetting filePath = (EResourceSetting) setting;
//			String choosenOption = filePath.getPath();
//			if (value != null && value.equals(choosenOption)) {
//				widgetOption.setSelected(true);
//			}
//		}
	}
	
	//old 
//	private void parseOptions(ESimpleSetting eSetting, Map<String, String> mapOptions) {
//		EList<ESettingOption> options = eSetting.getOptions();
//		for (ESettingOption option : options) {
//			EOption eOption = (EOption) option;
//			
//			mapOptions.put(eOption.getName(), eOption.getValue());
//		}
//	}

	public UISettingType getType(Object element) {
		if(element instanceof ESetting) {
			ESetting eSetting = (ESetting) element;
			if(eSetting instanceof ESimpleSetting) {
				ESimpleSetting ssetting = (ESimpleSetting) eSetting;
				ESettingValueType valueType = ssetting.getType();
				
				switch (valueType.getValue()) {
					case ESettingValueType.BOOLEAN_VALUE:
						return UISettingType.BOOLEAN;
					case ESettingValueType.DATE_VALUE:
						return UISettingType.DATE;
					case ESettingValueType.DATETIME_VALUE:
						return UISettingType.DATETIME;
					case ESettingValueType.DURATION_VALUE:
						return UISettingType.DURATION;
					case ESettingValueType.TIME_VALUE:
						return UISettingType.TIME;
					case ESettingValueType.STRING_VALUE:					
						return UISettingType.STRING;
					case ESettingValueType.INTEGER_VALUE:
						return UISettingType.INT;
					case ESettingValueType.MULTISELECTION_VALUE:
						return UISettingType.MULTISELECTION;
					case ESettingValueType.SELECTION_VALUE:
						return UISettingType.SELECTION;
					case ESettingValueType.FILE_VALUE:
						return UISettingType.FILE;
					case ESettingValueType.FOLDER_VALUE:
						return UISettingType.FOLDER;
					case ESettingValueType.DECIMAL_VALUE:
						return UISettingType.REAL;
				default:
					break;
				}
			}
			
			if (element instanceof EResourceSetting)
			{
				return UISettingType.FILE;
		
			}
			
			if(eSetting instanceof ESequenceSetting) {
				return UISettingType.SEQUENCE;
			}
		}
		else
		{
			if (element instanceof ESettingValue)
			{
				ESettingValue eSetVal = (ESettingValue)element;
				return getType(eSetVal.getType());
//				return UISettingType.STRING;
			}
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
