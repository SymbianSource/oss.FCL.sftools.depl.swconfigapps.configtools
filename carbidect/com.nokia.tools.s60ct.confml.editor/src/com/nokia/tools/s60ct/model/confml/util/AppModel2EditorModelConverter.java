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
package com.nokia.tools.s60ct.model.confml.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.nokia.tools.s60ct.build.builder.NotesBuilder;
import com.nokia.tools.s60ct.confml.editor.ConfmlEditorUtil;
import com.nokia.tools.s60ct.model.confml.ConfmlFactory;
import com.nokia.tools.s60ct.model.confml.EExtensionPolicy;
import com.nokia.tools.s60ct.model.confml.EFeature;
import com.nokia.tools.s60ct.model.confml.EGroup;
import com.nokia.tools.s60ct.model.confml.EOption;
import com.nokia.tools.s60ct.model.confml.EOptionMap;
import com.nokia.tools.s60ct.model.confml.EProperty;
import com.nokia.tools.s60ct.model.confml.EResourceKind;
import com.nokia.tools.s60ct.model.confml.EResourceSetting;
import com.nokia.tools.s60ct.model.confml.EResourceValue;
import com.nokia.tools.s60ct.model.confml.ESequenceSetting;
import com.nokia.tools.s60ct.model.confml.ESequenceValue;
import com.nokia.tools.s60ct.model.confml.ESequenceValueItem;
import com.nokia.tools.s60ct.model.confml.ESetting;
import com.nokia.tools.s60ct.model.confml.ESettingOption;
import com.nokia.tools.s60ct.model.confml.ESettingValue;
import com.nokia.tools.s60ct.model.confml.ESettingValueType;
import com.nokia.tools.s60ct.model.confml.ESimpleSetting;
import com.nokia.tools.s60ct.model.confml.ESimpleValue;
import com.nokia.tools.s60ct.model.confml.EValueEditorDocument;
import com.nokia.tools.s60ct.model.confml.View;
import com.nokia.tools.vct.common.appmodel.EAppExpression;
import com.nokia.tools.vct.common.appmodel.EAppFeature;
import com.nokia.tools.vct.common.appmodel.EAppGroup;
import com.nokia.tools.vct.common.appmodel.EAppProperty;
import com.nokia.tools.vct.common.appmodel.EAppResourceData;
import com.nokia.tools.vct.common.appmodel.EAppResourceType;
import com.nokia.tools.vct.common.appmodel.EAppSequenceData;
import com.nokia.tools.vct.common.appmodel.EAppSequenceDataItem;
import com.nokia.tools.vct.common.appmodel.EAppSequenceType;
import com.nokia.tools.vct.common.appmodel.EAppSetting;
import com.nokia.tools.vct.common.appmodel.EAppSettingData;
import com.nokia.tools.vct.common.appmodel.EAppSettingOption;
import com.nokia.tools.vct.common.appmodel.EAppSettingRef;
import com.nokia.tools.vct.common.appmodel.EAppSettingType;
import com.nokia.tools.vct.common.appmodel.EAppSimpleData;
import com.nokia.tools.vct.common.appmodel.EAppSimpleType;
import com.nokia.tools.vct.common.appmodel.EAppValueType;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;
import com.nokia.tools.vct.common.appmodel.ESourceLocator;
import com.nokia.tools.vct.common.appmodel.impl.EAppFeatureEntryImpl;
import com.nokia.tools.vct.common.appmodel.impl.EAppSequenceDataImpl;
import com.nokia.tools.vct.common.appmodel.impl.EAppSettingEntryImpl;
import com.nokia.tools.vct.common.confml.expressions.ConfMLExpressionsPlugin;
import com.nokia.tools.vct.confml.model.confml1.ESettingData;
import com.nokia.tools.vct.internal.common.confml.expressions.ConfmlExpressionEvaluator;
import com.nokia.tools.vct.internal.common.confml.expressions.ConfmlLexer;

public class AppModel2EditorModelConverter {

	private ConfmlFactory factory;
	private EConfMLLayer layer;
	private static AppModel2EditorModelConverter instance = null;
	//private EFeature eFeature = null;
	private View view = null;
	private List<EAppSettingRef> refinedSettingRefs = new ArrayList<EAppSettingRef>();
	
	
	Map<String, ESetting> absRef2SettingMap = new HashMap<String, ESetting>();
	List<EOption> notResolvedMapForOption = new ArrayList<EOption>();
	private List<EOption> optionsWithRelevant = new ArrayList<EOption>();
	
	public static AppModel2EditorModelConverter getInstance() {
		if (instance == null) {
			instance = new AppModel2EditorModelConverter();
		}
		return instance;
	}

	public EValueEditorDocument createEditorModel(EObject input, View view) {
		EValueEditorDocument ret = null;
		this.view = view;
		refinedSettingRefs.clear();
		if (input != null) {
			factory = ConfmlFactory.eINSTANCE;
			EValueEditorDocument document = factory.createEValueEditorDocument();
			if(input instanceof EAppFeature)
			{
				EAppFeature appFeature = (EAppFeature) input;
				
				//addFeatureFromView(document, appFeature, view);
				
				EFeature feat = addFeature(appFeature,null, false, null);	
				document.getFeatures().add(feat);
				adaptOptionMap(feat);
			}
			if(input instanceof EAppGroup)
			{
				EAppGroup appGroup = (EAppGroup) input;
				collectRefinedSettings(appGroup);
				adaptGroup(appGroup, document);
			}
			ret = document;
		}
		processRemainsOptions();
		processOptionsWithRelevant();
		
		return ret;
	}

	private void collectRefinedSettings(EAppGroup appGroup)
	{
		refinedSettingRefs.addAll(appGroup.getSettings());
		EList<EAppGroup> subGroups = appGroup.getGroups();
		for (int i = 0 ; i < subGroups.size() ; i++)
		{
			collectRefinedSettings(subGroups.get(i));
		}
	}
	
	
	
	private void adaptGroup(EAppGroup appGroup, EValueEditorDocument document)
	{
		Map<EAppFeature, List<String>> features = ConfmlEditorUtil.getFeatures(appGroup);
		Map<EAppSetting, EList<String>> visibleSubSettings = ConfmlEditorUtil.getVisibleSubSettings(appGroup);
		Set<EAppFeature> keySet = features.keySet();

//		TreeSet<EAppFeature> sortedSet = new TreeSet<EAppFeature>(new Comparator<EAppFeature>() {
//
//			public int compare(EAppFeature f1, EAppFeature f2) {
//				int retVal =  f1.getName().compareTo(f2.getName());
//				if (retVal==0)
//					return 1;
//				return retVal;
//			}
//			
//		});
		
//		sortedSet.addAll(keySet);

		EGroup group = factory.createEGroup();
		document.getGroups().add(group);
		
		group.setName(appGroup.getName());
		group.setDescriptionText(appGroup.getDescription());
		//icon mapping still missing. Icon not needed yet
		
		group.setSettingOrder(new BasicEList<String>());
		for (EAppSettingRef ref : appGroup.getSettings())
		{
			if (ref.getResolved()!=null && ref.getResolved().getRef()!=null)
				group.getSettingOrder().add(ref.getResolved().getRef());
		}
		
		for (EAppFeature appFeature : features.keySet()) {
			EFeature feat = addFeature(appFeature, features.get(appFeature), false, visibleSubSettings);
			//document.getFeatures().add(feat);
			group.getFeatures().add(feat);
			adaptOptionMap(feat);
		}
		
		EList<EAppGroup> subGroups = appGroup.getGroups();
		for (int i = 0 ; i < subGroups.size() ; i++)
		{
			adaptGroup(subGroups.get(i), document);
		}
	}
	
//	private void addFeatureFromView(EValueEditorDocument document, EAppFeature appFeature, View view) {
//		
//		EList<EFeature> allFeatures = view.getSharedFeatures();
//		for (int i = 0 ; i < allFeatures.size() ; i++)
//		{
//			if (allFeatures.get(i).getRef().equals(appFeature.getRef()))
//			{
//				document.getFeatures().add(allFeatures.get(i));
//				break;
//			}
//		}
//	}
	
	private EFeature addFeature(EAppFeature appFeature,List<String> incRefs, boolean useShared, Map<EAppSetting, EList<String>> visibleSubSettings) 
	{
		EFeature eFeature = null;
		
		//create new feature if it's not included in view
		String ref = appFeature.getRef();
		//boolean usingShared = false;

		if (useShared)
			for (EFeature sharedFeature: view.getSharedFeatures())
			{
				if (sharedFeature.getRef().equals(ref))
				{
					eFeature = sharedFeature;
					return eFeature;
				}
			}
		
		eFeature = factory.createEFeature();
	
		this.layer = (EConfMLLayer) appFeature.eContainer().eContainer();
		
		adaptFeature(eFeature, appFeature);
		
		boolean replaced = false;
		
		for (int i = 0 ; i < view.getSharedFeatures().size() ; i++)
		{
			EFeature f = view.getSharedFeatures().get(i);
			if (f.getRef().equals(ref))
			{
				view.getSharedFeatures().set(i, eFeature);
				replaced = true;
				break;
			}
		}
		if (!replaced)	
			view.getSharedFeatures().add(eFeature);
		
		addSettings(eFeature, appFeature,incRefs, visibleSubSettings);
		
		return eFeature;
	}

	private void addSettings(EFeature eFeature, EAppFeature appFeature, List<String> incRefs, Map<EAppSetting, EList<String>> visibleSubSettings) {
		EMap<String, EAppSetting> settings = appFeature.getSettings();
		Set<Entry<String, EAppSetting>> entrySet = settings.entrySet();
		
		if (incRefs != null) //shouldn't be sorted
		{
			for (int i = 0 ; i < incRefs.size() ; i++)
			{
				String ref = incRefs.get(i);
				for (Entry<String, EAppSetting> entry : entrySet)
				{
					if(entry.getKey().equals(ref)) 
					{
						EAppSetting appSetting = entry.getValue();
						EList<String> subSettingFilter = null;
						if (visibleSubSettings != null)
							subSettingFilter = visibleSubSettings.get(appSetting);
						
						ESetting eSetting = adaptSetting(eFeature, appSetting, entry.getKey(), subSettingFilter);
						eFeature.getSettings().add(eSetting);				
					}
				}
			}
		}
		else
		{
			TreeSet<Entry<String, EAppSetting>> sortedSet = new TreeSet<Entry<String, EAppSetting>>
			(new Comparator<Entry<String, EAppSetting>>() {

				public int compare(Entry<String, EAppSetting> e1, Entry<String, EAppSetting> e2) {
					EAppSettingType s1 = e1.getValue().getTypeInfo();
					EAppSettingType s2 = e2.getValue().getTypeInfo();
					
					int retVal =  s1.getName().compareTo(s2.getName());
					if (retVal==0)
						return 1;
					return retVal;
				}
				
			});
			sortedSet.addAll(entrySet);
			
			for (Entry<String, EAppSetting> entry : sortedSet) {
				EAppSetting appSetting = entry.getValue();
				ESetting eSetting = adaptSetting(eFeature, appSetting, entry.getKey(), null);
				eFeature.getSettings().add(eSetting);				
			}
		}
		
	}

	private void adaptFeature(EFeature feature, EAppFeature appFeature) {
		feature.setName(appFeature.getName());
		feature.setRef(appFeature.getRef());
		feature.setDescriptionText(appFeature.getDescription());
		EAppExpression r = appFeature.getRelevant();
		if (r != null && r.getLiteral()!=null) {
			feature.setRelevant(r.getLiteral());
			createRelevantFeature(r.getLiteral());
		}
	}

	private void createRelevantFeature(String relevant)
	{
	
		String[] refs = null;
		CommonTree tree = (CommonTree)ConfMLExpressionsPlugin.compileExpression(relevant);
		List<Token> settingRefTokens = ConfmlExpressionEvaluator.getSettingRefTokens(tree);
		for (int i = 0; i < settingRefTokens.size(); i++) {
			Token token = settingRefTokens.get(i);
			String absRef = token.getText();
			switch (token.getType()) {
			case ConfmlLexer.CURRENT_REF:
				break;
			case ConfmlLexer.FILE_PATH_REF:
				refs = absRef.split("/");
				break;
			case ConfmlLexer.SIBLING_REF:
				break;
			case ConfmlLexer.SUB_SETTING_REF:
				String[] parts = absRef.split("[/\\[\\]]");
				List<String> temp = new ArrayList<String>();
				for (int j = 0; j < parts.length; j++) {
					if (parts[j] != null && !parts[j].equals("")) {
						temp.add(parts[j]);
					}
				}
				refs = new String[temp.size()];
				for (int j = 0; j < temp.size(); j++) {
					refs[j] = temp.get(j);
				}
				break;

			case ConfmlLexer.TOP_LEVEL_SETTING_REF:
				refs = absRef.split("/");
				break;
			}
		}
		if (refs != null)
		{
			String featureRef = refs[0];
			
			EMap<String, EAppFeature> features = layer.getFeatures();
		
			EAppFeature appFeature = features.get(featureRef);
			
			if (appFeature != null)
			{
				addFeature(appFeature,null, true, null);	
			}
		}
	}
	
	private ESetting adaptSetting(EFeature eFeature, EAppSetting appSetting, String settingRef, EList<String> visibleSubSettings) {
		EAppSettingData appValue = appSetting.getValueInfo();
		EAppSettingType typeInfo = appSetting.getTypeInfo();

		String absRef = eFeature.getRef()+"/"+settingRef;
		
		for (ESetting sharedSetting: view.getSharedSettingInstances())
		{
			if (sharedSetting.getAbsRef().equals(absRef))
			{
				return sharedSetting;
			}
		}
		
		ESetting eSetting = null;
		if (typeInfo instanceof EAppSimpleType) {
			eSetting = factory.createESimpleSetting();
		} else if (typeInfo instanceof EAppSequenceType) {
			eSetting = factory.createESequenceSetting();
		} else if (typeInfo instanceof EAppResourceType) {
			eSetting = factory.createEResourceSetting();
		} else {
			//
		}
		
		if (eSetting != null) {
			
			adaptSettingType(eSetting, typeInfo, settingRef, visibleSubSettings); // 1. adapt type info
			
			adaptSettingValue(eFeature, eSetting, appValue); // 2. adapt value info
			
			loadNotes(appSetting, eSetting);
		}

		adaptRedefinedViewSettings(eSetting, appSetting);
		
		return eSetting;
	}

	private void adaptRedefinedViewSettings(ESetting setting, EAppSetting appSetting)
	{
		for (int i = 0 ; i < refinedSettingRefs.size() ; i++)
		{
			EAppSettingRef settingRef = refinedSettingRefs.get(i);
			if (settingRef.getResolved() == appSetting)
			{
				if (settingRef.getDescription()!=null)
					setting.setDescriptionText(settingRef.getDescription());
				if (settingRef.getName()!=null)
					setting.setName(settingRef.getName());
				
				if (setting instanceof ESimpleSetting)
				{
					ESimpleSetting s = (ESimpleSetting)setting;
					if (settingRef.getLength()!=null)
						s.setLength(settingRef.getLength());
					if (settingRef.getMaxExclusive()!=null)
						s.setMaxExclusive(settingRef.getMaxExclusive().toString());
					if (settingRef.getMaxInclusive()!=null)
						s.setMaxInclusive(settingRef.getMaxInclusive().toString());
					if (settingRef.getMinExclusive()!=null)
						s.setMinExclusive(settingRef.getMinExclusive().toString());
					if (settingRef.getMinInclusive()!=null)
						s.setMinInclusive(settingRef.getMinInclusive().toString());
					if (settingRef.getMinLength()!=null)
						s.setMinLength(settingRef.getMinLength());
					if (settingRef.getMaxLength()!=null)
						s.setMaxLength(settingRef.getMaxLength());
					if (settingRef.getPattern()!=null)
						s.getPattern().addAll(settingRef.getPattern());
					if (settingRef.getTotalDigits()!=null)
						s.setTotalDigits(settingRef.getTotalDigits());
					if (settingRef.getProperties()!=null)
					{
						EList<EAppProperty> properties = settingRef.getProperties();
						for (EAppProperty appProperty : properties)
						{
							EProperty property = factory.createEProperty();
							property.setName(appProperty.getName());
							property.setValue(appProperty.getValue());
							property.setUnit(appProperty.getUnit());
							s.getProperties().add(property);
						}
					}
					if (settingRef.getOptions()!=null && settingRef.getOptions().size() > 0)
					{
						adaptSettingOptions(s, settingRef.getOptions());
					}
					
				}
				else if (setting instanceof EResourceSetting)
				{
					EResourceSetting s = (EResourceSetting)setting;
					if (settingRef.getProperties()!=null)
					{
						EList<EAppProperty> properties = settingRef.getProperties();
						for (EAppProperty appProperty : properties)
						{
							EProperty property = factory.createEProperty();
							property.setName(appProperty.getName());
							property.setValue(appProperty.getValue());
							property.setUnit(appProperty.getUnit());
							s.getProperties().add(property);
						}
					}
				}
				else if (setting instanceof ESequenceSetting)
				{
					//?
				}
			}
		}
	}
	

	
	private void adaptSettingType(ESetting setting, EAppSettingType typeInfo,String settingRef, EList<String> visibleSubSettings)
	{
		setting.setRef(settingRef);
		String sid = ((EAppSettingEntryImpl) typeInfo.eContainer().eContainer())
				.getKey();
		String fid = ((EAppFeatureEntryImpl) typeInfo.eContainer().eContainer()
				.eContainer().eContainer()).getKey();

		String absRef = fid + "/" + sid;
		
		if (absRef2SettingMap.get(absRef) == null) {
			absRef2SettingMap.put(absRef, setting);
		} 
		
		adaptCommon(setting, typeInfo);
		
		if (typeInfo instanceof EAppSimpleType) {
			adaptSimpleSetting(setting, (EAppSimpleType) typeInfo);
		}
		else if (typeInfo instanceof EAppResourceType)
		{
			adaptResourceSetting(setting, (EAppResourceType) typeInfo);
		}
		else if (typeInfo instanceof EAppSequenceType) {
			// adapt sequence type
			EAppSequenceType appSequenceType = (EAppSequenceType) typeInfo;
			ESequenceSetting sequenceSettingType = (ESequenceSetting) setting;
			sequenceSettingType.setMinOccurs(appSequenceType.getMinOccurs());
			sequenceSettingType.setMaxOccurs(appSequenceType.getMaxOccurs());
			sequenceSettingType.setDescriptionText(appSequenceType.getDescription());
			sequenceSettingType.setMapKey(appSequenceType.getMapKey());
			sequenceSettingType.setMapValue(appSequenceType.getMapValue());
		
			EMap<String, EAppSettingType> typeMap = appSequenceType.getTypeMap();
			
			if (visibleSubSettings != null && visibleSubSettings.size()>0 && !visibleSubSettings.contains("*"))
			{
				sequenceSettingType.getVisibleSubSettings().addAll(visibleSubSettings);
				for (int i = 0 ; i < visibleSubSettings.size() ; i++)
				{
					String subRef = visibleSubSettings.get(i);
					EAppSettingType subSetting = typeMap.get(subRef);
					adaptSubSettingType(subRef, subSetting, sequenceSettingType);
				}
			}
			else
			{
				for (Entry<String, EAppSettingType> entry : typeMap) 
				{
					String subRef = entry.getKey();
					EAppSettingType subSetting = entry.getValue();
					adaptSubSettingType(subRef, subSetting, sequenceSettingType);
				}
			}
		}
	}

	private void adaptSubSettingType(String subRef, EAppSettingType subSetting, ESequenceSetting sequenceSettingType)
	{
		if (subSetting instanceof EAppSimpleType)
		{
			ESimpleSetting simpleSetting = factory.createESimpleSetting();
			adaptSimpleSetting(simpleSetting, (EAppSimpleType) subSetting);
			simpleSetting.setRef(subRef);
			adaptCommon(simpleSetting,subSetting);
			//inherit readonly
			simpleSetting.setReadOnly(sequenceSettingType.isReadOnly());
			sequenceSettingType.getSubTypes().add(simpleSetting);
			loadNotes(subSetting, simpleSetting);
			
		}
		else if (subSetting instanceof EAppResourceType)
		{
			EResourceSetting resourceSetting = factory.createEResourceSetting();
			adaptResourceSetting(resourceSetting, (EAppResourceType) subSetting);
			resourceSetting.setRef(subRef);
			adaptCommon(resourceSetting,subSetting);
			sequenceSettingType.getSubTypes().add(resourceSetting);
			loadNotes(subSetting, resourceSetting);
		}
	}
	
	private void adaptCommon(ESetting setting, EAppSettingType typeInfo) {
		
		if (typeInfo.getConstraint()!=null)
			setting.setConstraint(typeInfo.getConstraint().getLiteral());
		setting.setDeprecated(typeInfo.isDeprecated());
		setting.setDescriptionText(typeInfo.getDescription());
		if (typeInfo.getIconURI()!=null)
			setting.setIconUri(typeInfo.getIconURI().toFileString());
		setting.setIconUriTitle(typeInfo.getIconTitle());
		setting.setName(typeInfo.getName());
		setting.setReadOnly(typeInfo.isReadOnly());
		if (typeInfo.getRelevant()!=null && typeInfo.getRelevant().getLiteral()!=null)
		{
			setting.setRelevant(typeInfo.getRelevant().getLiteral());
			createRelevantFeature(typeInfo.getRelevant().getLiteral());
		}
		setting.setRequired(typeInfo.isRequired());
	}

	private void adaptSimpleSetting(ESetting simpleSetting,
			EAppSimpleType typeInfo) {
		EAppSimpleType simpleType = (EAppSimpleType) typeInfo;
		ESimpleSetting simpleSettingType = (ESimpleSetting) simpleSetting;

		EAppValueType type = simpleType.getType();

		simpleSettingType.setLength(simpleType.getLength());
		if (simpleType.getMaxExclusive()!=null)
			simpleSettingType.setMaxExclusive(simpleType.getMaxExclusive().toString());
		if (simpleType.getMinExclusive()!=null)
			simpleSettingType.setMinExclusive(simpleType.getMinExclusive().toString());
		if (simpleType.getMaxInclusive()!=null)
			simpleSettingType.setMaxInclusive(simpleType.getMaxInclusive().toString());
		if (simpleType.getMinInclusive()!=null)
			simpleSettingType.setMinInclusive(simpleType.getMinInclusive().toString());
		simpleSettingType.setMinLength(simpleType.getMinLength());
		simpleSettingType.setMaxLength(simpleType.getMaxLength());
		simpleSettingType.setRequired(simpleType.isRequired());
		simpleSettingType.getPattern().addAll(simpleType.getPattern());
		
		// ());
		// set all simple fields
		switch (type.getValue()) {
		case EAppValueType.INTEGER_VALUE:
			simpleSettingType.setType(ESettingValueType.INTEGER);
			break;
		case EAppValueType.STRING_VALUE:
			simpleSettingType.setType(ESettingValueType.STRING);
			break;
		case EAppValueType.BOOLEAN_VALUE:
			simpleSettingType.setType(ESettingValueType.BOOLEAN);
			break;
		case EAppValueType.SELECTION_VALUE:
			simpleSettingType.setType(ESettingValueType.SELECTION);
			break;
		case EAppValueType.MULTISELECTION_VALUE:
			simpleSettingType.setType(ESettingValueType.MULTISELECTION);
			break;
		case EAppValueType.LOCAL_FILE_VALUE:
			simpleSettingType.setType(ESettingValueType.FILE);
			break;
		case EAppValueType.LOCAL_FOLDER_VALUE:
			simpleSettingType.setType(ESettingValueType.FOLDER);
			break;
		case EAppValueType.DATE_VALUE:
			simpleSettingType.setType(ESettingValueType.DATE);
			break;
		case EAppValueType.DATETIME_VALUE:
			simpleSettingType.setType(ESettingValueType.DATETIME);
			break;
		case EAppValueType.TIME_VALUE:
			simpleSettingType.setType(ESettingValueType.TIME);
			break;
		case EAppValueType.DURATION_VALUE:
			simpleSettingType.setType(ESettingValueType.DURATION);
			break;
		case EAppValueType.DECIMAL_VALUE:
			simpleSettingType.setType(ESettingValueType.DECIMAL);
			break;
			
			
		default:
			simpleSettingType.setType(ESettingValueType.STRING);
			break;
		}
		
		EList<EAppProperty> properties = simpleType.getProperties();
		for (EAppProperty appProperty : properties)
		{
			EProperty property = factory.createEProperty();

			property.setName(appProperty.getName());
			property.setValue(appProperty.getValue());
			property.setUnit(appProperty.getUnit());
			simpleSetting.getProperties().add(property);
		}
		
		adaptSettingOptions(simpleSettingType, simpleType.getOptions());
	}


	
	private void adaptResourceSetting(ESetting resourceSetting, EAppResourceType typeInfo) {
			EResourceSetting resSettingType = (EResourceSetting) resourceSetting;
			
			if (typeInfo.isFile())
			{
				resSettingType.setKind(EResourceKind.FILE);
			}
			else
			{
				resSettingType.setKind(EResourceKind.FOLDER);
			}
			
			EAppSimpleType appTargetPath = (EAppSimpleType)typeInfo.getTargetPath();
			EAppSimpleType appLocalPath = (EAppSimpleType)typeInfo.getLocalPath();
			
			ESetting targetSetting = factory.createESimpleSetting();
			ESetting localSetting = factory.createESimpleSetting();
			
			resSettingType.setTargetPath(targetSetting);
			resSettingType.setLocalPath(localSetting);
			
			adaptSimpleSetting(resSettingType.getTargetPath(), appTargetPath);
			adaptSimpleSetting(resSettingType.getLocalPath(), appLocalPath);
			
			EList<EAppProperty> properties = typeInfo.getProperties();
			for (EAppProperty appProperty : properties)
			{
				EProperty property = factory.createEProperty();

				property.setName(appProperty.getName());
				property.setValue(appProperty.getValue());
				property.setUnit(appProperty.getUnit());
				resSettingType.getProperties().add(property);
			}
	}

	private void processRemainsOptions()
	{
		for (EOption option : notResolvedMapForOption) {
			String map = option.getMap();
			if (map == null) {
				continue;
			}
			ESetting notifier = absRef2SettingMap.get(map);
			if (notifier != null && notifier instanceof ESequenceSetting) {
				option.setMapSourceSetting((ESequenceSetting) notifier);
			}
		}

	}
	
	private void processOptionsWithRelevant() {
		for (EOption option : optionsWithRelevant) {
			EObject container = option.eContainer();
			if (container instanceof ESetting) {
				ESetting optionParent = (ESetting) container;
				Set<ESetting> optionRelevantSettings = ConfMLExpressionSettingUtil.getSettingsRefFromOptionRelevant(view, optionParent, option.getRelevant());
				for (ESetting relevantSetting : optionRelevantSettings) {
					EList<ESetting> optionDependencies = relevantSetting
							.getOptionDependencies();
					if (optionDependencies == null) {
						relevantSetting
								.setOptionDependencies(new BasicEList<ESetting>());
					}
					relevantSetting.getOptionDependencies().add(optionParent);

					if (optionParent.getDependencies() == null) {
						optionParent.setDependencies(new BasicEList<EObject>());
					}
					if (!optionParent.getDependencies().contains(
							relevantSetting)) {
						optionParent.getDependencies().add(relevantSetting);
					}
				}
			}
		}

	}
	
	private void adaptSettingOptions(ESimpleSetting simpleSetting,EList<EAppSettingOption> options)
	{
		for (EAppSettingOption option : options)
		{
			EOption settingOption = factory.createEOption();
			
			settingOption.setName(option.getName());
			settingOption.setValue(option.getLiteralValue());
			boolean replaced = false;
			for (int i = 0 ; i < simpleSetting.getOptions().size() ; i++)
			{
				EOption o = (EOption)simpleSetting.getOptions().get(i);
				if (o.getName()!=null && o.getName().equals(settingOption.getName()))
				{
					simpleSetting.getOptions().set(i, settingOption);
					replaced = true;
					break;
				}
			}
			
			if (!replaced)
				simpleSetting.getOptions().add(settingOption);
			
			EAppExpression relevant = option.getRelevant();
			if (relevant != null) {
				String literal = relevant.getLiteral();
				if (literal != null) {
					createRelevantFeature(literal);
					settingOption.setRelevant(literal);
					optionsWithRelevant.add(settingOption);
				}

			}
			String map = option.getRefValue();
			if (map != null) 
			{
				settingOption.setMap(map);
				createFeatureOfIDMapping(map);
			}
		}
	}

	private void createFeatureOfIDMapping(String map)
	{
		String featureRef = map.split("/")[0];
		EMap<String, EAppFeature> features = layer.getFeatures();
		
		EAppFeature appFeature = features.get(featureRef);
		
		if (appFeature != null)
		{
			addFeature(appFeature,null, true, null);	
		}
	}

//	private void dateTimeCorrection(EAppSimpleData data) {
//		
//		String dateTime = data.getValue();
//		
//		if (dateTime.length() > 10) {
//			if (dateTime.charAt(10) == '-') {
//				StringBuilder sb = new StringBuilder(dateTime);
//				sb.setCharAt(10, 'T');
//				dateTime = sb.toString();
//				data.setValue(dateTime);
//			} 
//		} 
//		//return dateTime;
//	}
	
	private void adaptSettingValue(EFeature eFeature, ESetting setting, EAppSettingData appValue) {
		if (appValue instanceof EAppSimpleData) {
			EAppSimpleData appSimpleData = (EAppSimpleData) appValue;
			ESimpleValue defaultValue = factory.createESimpleValue();
			ESimpleValue currentValue = factory.createESimpleValue();
			
			currentValue.setType(setting);
			currentValue.setRef(setting.getRef());
			
			if (appSimpleData.getValue()!= null)
			{
//				if (((ESimpleSetting)setting).getType().equals(ESettingValueType.DATETIME))
//					dateTimeCorrection(appSimpleData);
				
				currentValue.setValue(appSimpleData.getValue());
				currentValue.setMap(appSimpleData.getMap());
			}
			defaultValue.setType(setting);
			defaultValue.setRef(setting.getRef());
			
			EConfMLLayer parent = layer.getParent();
			EAppSetting parentSetting = ValueEditorUtil.getSettingFromLayer(parent,eFeature.getRef(),setting.getRef());
			
			if(parentSetting!=null) 
			{
				EAppSimpleData parentValue = (EAppSimpleData) parentSetting.getValueInfo();
				if (parentValue.getValue()!= null)
				{
//					if (((ESimpleSetting)setting).getType().equals(ESettingValueType.DATETIME))
//						dateTimeCorrection(parentValue);
					
					defaultValue.setValue(parentValue.getValue());
					
					defaultValue.setMap(parentValue.getMap());
				}
				else
				{
//					if (((ESimpleSetting)setting).getType().equals(ESettingValueType.DATETIME))
//						dateTimeCorrection(appSimpleData);
					
					defaultValue.setValue(appSimpleData.getValue());
					
					defaultValue.setMap(appSimpleData.getMap());
				}
			} 
			else 
			{
				defaultValue.setValue(null);
			}
			setting.setDefaultValue(defaultValue);
			setting.setValue(currentValue);

			
		} else if (appValue instanceof EAppSequenceData) {
			ESequenceValue defaultSeqValue = factory.createESequenceValue();
			ESequenceValue currentSeqValue = factory.createESequenceValue();
			createSequenceValue(eFeature, (ESequenceSetting) setting,
					(EAppSequenceData) appValue, defaultSeqValue,
					currentSeqValue);
			setting.setValue(currentSeqValue);
			setting.setDefaultValue(defaultSeqValue);
		}
		else if (appValue instanceof EAppResourceData)
		{
			EAppResourceData appResourceData = (EAppResourceData) appValue;
			EResourceValue defaultResourceValue = factory.createEResourceValue();
			EResourceValue currentResourceValue = factory.createEResourceValue();
			
			currentResourceValue.setType(setting);
			currentResourceValue.setRef(setting.getRef());
			
			EAppSimpleData appLocalPathData = (EAppSimpleData)appResourceData.getLocalPath();
			EAppSimpleData appTargetPathData = (EAppSimpleData)appResourceData.getTargetPath();
			
			
			if (appLocalPathData.getValue()!= null)
			{
				ESimpleValue localPathValue = factory.createESimpleValue();
				localPathValue.setType(setting);
				localPathValue.setValue(appLocalPathData.getValue());
				currentResourceValue.setLocalPath(localPathValue);
			}
			if (appTargetPathData.getValue()!= null)
			{
				ESimpleValue targetPathValue = factory.createESimpleValue();
				targetPathValue.setType(setting);
				targetPathValue.setValue(appTargetPathData.getValue());
				currentResourceValue.setTargetPath(targetPathValue);
			}
			
			defaultResourceValue.setType(setting);
			defaultResourceValue.setRef(setting.getRef());
			
			EConfMLLayer parent = layer.getParent();
			EAppSetting parentSetting = ValueEditorUtil.getSettingFromLayer(parent,eFeature.getRef(),setting.getRef());
			
			if(parentSetting!=null) 
			{
				EAppResourceData parentValue = (EAppResourceData) parentSetting.getValueInfo();
				EAppSimpleData appParentLocalPathData = (EAppSimpleData)parentValue.getLocalPath();
				EAppSimpleData appParentTargetPathData = (EAppSimpleData)parentValue.getTargetPath();
				
				if (appParentLocalPathData.getValue()!= null)
				{
					ESimpleValue localPathValue = factory.createESimpleValue();
					localPathValue.setType(setting);
					localPathValue.setValue(appParentLocalPathData.getValue());
					defaultResourceValue.setLocalPath(localPathValue);
				}
				else
				{
					ESimpleValue localPathValue = factory.createESimpleValue();
					localPathValue.setType(setting);
					localPathValue.setValue(appLocalPathData.getValue());
					defaultResourceValue.setLocalPath(localPathValue);
				}
				
				if (appParentTargetPathData.getValue()!= null)
				{
					ESimpleValue targetPathValue = factory.createESimpleValue();
					targetPathValue.setType(setting);
					targetPathValue.setValue(appParentTargetPathData.getValue());
					defaultResourceValue.setTargetPath(targetPathValue);
				}
				else
				{
					ESimpleValue targetPathValue = factory.createESimpleValue();
					targetPathValue.setType(setting);
					targetPathValue.setValue(appTargetPathData.getValue());
					defaultResourceValue.setTargetPath(targetPathValue);
				}
			} 
			else 
			{
				defaultResourceValue.setLocalPath(null);
				defaultResourceValue.setTargetPath(null);
			}
			setting.setDefaultValue(defaultResourceValue);
			setting.setValue(currentResourceValue);
		}
	}


	private void createSequenceValue(EFeature eFeature, ESequenceSetting setting,
			EAppSequenceData appSeqData, ESequenceValue defaultSeqValue,
			ESequenceValue currentSeqValue) {
		
		 String policy = "";
		
		 ESourceLocator locator = (ESourceLocator) appSeqData;	
		 //strange but here. Sometimes either locator or locator.eResource() is null.
		 if (locator==null)
		 {
			 System.out.println("locator==null");
			 return;
		 }
		 if (locator.eResource()==null)
		 {
			 System.out.println("locator.eResource()==null");
			 return;
		 }
		 ResourceSet rs = locator.eResource().getResourceSet();
		 
		 EAppSetting parentSetting = null;
		 
		 EList<URI> uris = locator.getUri();
		 String ref = "";
		 for  (int i = uris.size()-1 ; i >= 0 ; i--)
		 {
			 URI uri = uris.get(i); //last uri, last layer
			
			 EObject obj = rs.getEObject(uri, false);
			 if (obj instanceof ESettingData) 
			 {
				 ESettingData sdata = (ESettingData)obj;
				 policy = sdata.getExtensionPolicy();
				 ref = sdata.getRef();
			 } 
			 else if(obj instanceof
			 com.nokia.tools.vct.confml.model.confml2.ESettingData)
			 {
				 com.nokia.tools.vct.confml.model.confml2.ESettingData sdata = (com.nokia.tools.vct.confml.model.confml2.ESettingData)obj;
				 policy = sdata.getExtensionPolicy();
				 ref = sdata.getRef();
			 }
			 
			 if (policy != null && !policy.equals(""))
			 {
				if (policy.equalsIgnoreCase(EExtensionPolicy.APPEND.getName()))
			    	currentSeqValue.setExtensionPolicy(EExtensionPolicy.APPEND);
			    else if (policy.equalsIgnoreCase(EExtensionPolicy.PREFIX.getName()))
			    	currentSeqValue.setExtensionPolicy(EExtensionPolicy.PREFIX);
			    else if (policy.equalsIgnoreCase(EExtensionPolicy.REPLACE.getName()))
			    {
			    	currentSeqValue.setExtensionPolicy(EExtensionPolicy.REPLACE);
			    	if (ValueEditorUtil.isFromThisLayer(layer, uri))
			    	{
				    	EConfMLLayer parent = layer.getParent();
						parentSetting = ValueEditorUtil.getSettingFromLayer(parent,eFeature.getRef(),ref);
			    	}
			    }
				break;
			 }
		 } 
		 
		EAppSequenceDataItem appSeqTemplateItem = appSeqData.getTemplate();

		if (appSeqTemplateItem != null) {
			ESequenceValueItem eSeqTemplateItem = factory
					.createESequenceValueItem();

			URI uri = ValueEditorUtil
					.getSequenceItemLocationUri(appSeqTemplateItem);
			eSeqTemplateItem.setFrameLocationUri(uri);
			boolean fromThisLayer = ValueEditorUtil.isFromThisLayer(layer, uri);
			eSeqTemplateItem.setEditable(fromThisLayer);

			adaptSequenceValueItem(setting, appSeqTemplateItem,eSeqTemplateItem);
			
			if(fromThisLayer){
				currentSeqValue.setType(setting);
				currentSeqValue.setTemplate(eSeqTemplateItem);
			}else {
				defaultSeqValue.setType(setting);
				defaultSeqValue.setTemplate(eSeqTemplateItem);
			}
				
		}

		if (parentSetting != null)
		{
			for (EAppSequenceDataItem appSeqValItem : ((EAppSequenceDataImpl)parentSetting.getValueInfo()).getItems())
			{
				ESequenceValueItem eSeqValueItem = factory
				.createESequenceValueItem();
				URI uri = ValueEditorUtil.getSequenceItemLocationUri(appSeqValItem);
				eSeqValueItem.setFrameLocationUri(uri);
				eSeqValueItem.setEditable(false);
		
				adaptSequenceValueItem(setting, appSeqValItem, eSeqValueItem);
				defaultSeqValue.setType(setting);
				defaultSeqValue.getItems().add(eSeqValueItem);
			}		
		}
		
		for (EAppSequenceDataItem appSeqValItem : appSeqData.getItems()) {
			ESequenceValueItem eSeqValueItem = factory
					.createESequenceValueItem();

			URI uri = ValueEditorUtil.getSequenceItemLocationUri(appSeqValItem);
			eSeqValueItem.setFrameLocationUri(uri);
			boolean fromThisLayer = ValueEditorUtil.isFromThisLayer(layer, uri);
			eSeqValueItem.setEditable(fromThisLayer);

			adaptSequenceValueItem(setting, appSeqValItem, eSeqValueItem);
			if(fromThisLayer){
				currentSeqValue.setType(setting);
				currentSeqValue.getItems().add(eSeqValueItem);
			}else {
				defaultSeqValue.setType(setting);
				defaultSeqValue.getItems().add(eSeqValueItem);
			}
		}
		
	}

	private void adaptSequenceValueItem(ESequenceSetting setting,
			EAppSequenceDataItem appSeqValItem, ESequenceValueItem eSeqValueItem) {
		EMap<String, EAppSettingData> subSetMap = appSeqValItem
				.getSubSettings();

		// ESourceLocator locator = (ESourceLocator) appSeqValItem;
		//		
		// ResourceSet rs = locator.eResource().getResourceSet();
		// for (URI uri: locator.getUri()) {
		// EObject obj = rs.getEObject(uri, false);
		// if (obj instanceof ESettingData) {
		// ESettingData sdata = (ESettingData)obj;
		// } else if(obj instanceof
		// com.nokia.tools.vct.confml.model.confml2.ESettingData){
		//				
		// }
		// }

		for (Entry<String, EAppSettingData> entry : subSetMap) {
			String subRef = entry.getKey();
			
			Object o = entry.getValue();
			if (o instanceof EAppSimpleData)
			{
				EAppSimpleData simpleData = (EAppSimpleData) o;
				ESimpleValue simpleValue = factory.createESimpleValue();
				ESetting subSetting = getSubSetting(setting, subRef);
				simpleValue.setType(subSetting);
				simpleValue.setRef(subRef);
				simpleValue.setMap(simpleData.getMap());
				simpleValue.setValue(simpleData.getValue());
				eSeqValueItem.getSubSettings().add(simpleValue);
			}
			else
			{
				EAppResourceData resourceData = (EAppResourceData) o;
				EMap<String, EAppSettingData> resSetMap = resourceData.getSubSettings();
				
				//String resRef = entry.getKey();
				EAppSimpleData simpleData = (EAppSimpleData)resSetMap.get("localPath");
				
				EResourceValue resValue = factory.createEResourceValue();
				
				ESimpleValue localPathValue = factory.createESimpleValue();
				
				resValue.setLocalPath(localPathValue);
				
				//ESimpleValue simpleValue = factory.createESimpleValue();
				ESetting subSetting = getSubSetting(setting, subRef);
				
				resValue.setType(subSetting);
				resValue.setRef(subRef);
				
				if (simpleData.getValue()!= null)
				{
					//ESimpleValue localPathValue = factory.createESimpleValue();
					//localPathValue.setType(setting);
					localPathValue.setValue(simpleData.getValue());
					//defaultResourceValue.setLocalPath(localPathValue);
				}
				else
					localPathValue.setValue("");
				
				
				eSeqValueItem.getSubSettings().add(resValue);
				
			}
		}
	}

	private ESetting getSubSetting(ESequenceSetting setting, String subRef) {
		EList<ESetting> subTypes = setting.getSubTypes();
		for (ESetting subSetting : subTypes) {
			if (subSetting.getRef().equals(subRef)) {
				return subSetting;
			}
		}
		return null;
	}

	private void loadNotes(Object appObject, ESetting eSetting)
	{
		Map<Object, String> notesMap = NotesBuilder.getNotesBuilder().getNotes();
		if (notesMap.containsKey(appObject))
		{
			eSetting.setNotes(notesMap.get(appObject));
		}
	}
	
	public View createAllView(EConfigurationProject vc) {

		factory = ConfmlFactory.eINSTANCE;
		// result view
		View view = factory.createView();

		// feature information processing
		//createFeaturesForView(vc, view);
		
		//view.getSharedSettingInstances().addAll(absRef2SettingMap.values());
		//processRemainsOptions();
		//processOptionsWithRelevant(view);
		return view;


	}
	
	
//	private void createFeaturesForView(EConfigurationProject vc, View view) {
//		EMap<String, EAppFeature> features = vc.getLastLayer().getFeatures();
//		Set<String> featureRefSet = features.keySet();
//		Iterator<String> featureRefsIterator = featureRefSet.iterator();
//		while (featureRefsIterator.hasNext()) {
//			String nextFeatureRef = featureRefsIterator.next();
//			EAppFeature appFeature = features.get(nextFeatureRef);
//
//			eFeature = factory.createEFeature();
//			eFeature.setName(appFeature.getName());
//			eFeature.setRef(appFeature.getRef());
//			eFeature.setDescriptionText(appFeature.getDescription());
//			
//			this.layer = (EConfMLLayer) appFeature.eContainer().eContainer();
//			EAppExpression r = appFeature.getRelevant();
//			if (r != null) {
//				eFeature.setRelevant(r.getLiteral());
//			}
//			
//			view.getSharedFeatures().add(eFeature);
//			createSettingsForView(appFeature, view);	
//		}
//		adaptOptionMap(view);
//	}
	
	private void adaptOptionMap(EFeature feature)
	{
		for (ESetting setting : feature.getSettings())
		{
		 if (setting instanceof ESimpleSetting)
		 {	
			 adaptSimpleSettingOpionMap(setting, setting.getValue());
		 }
		 else if (setting instanceof ESequenceSetting)
		 {
			 ESequenceSetting ss = (ESequenceSetting)setting;
			 ESequenceValue ssDefVal = (ESequenceValue)ss.getDefaultValue();
			 
			 ESequenceValueItem templateItem = ssDefVal.getTemplate();
			 if (templateItem!=null)
			 {
				 EList<ESettingValue> templateValues = templateItem.getSubSettings();
			 
				 for (int i = 0 ; i < templateValues.size() ; i++)
				 {
					 ESettingValue templateValue = templateValues.get(i);
					 ESetting templateSetting = templateValue.getType();
					 if (templateSetting instanceof ESimpleSetting)
					 {
						 adaptSimpleSettingOpionMap(templateSetting, templateValue);
					 }
				 }
			 }
			 
			 ESequenceValue ssVal = (ESequenceValue)ss.getValue();
			 if (ssVal!=null)
			 {
				 EList<ESequenceValueItem> seqValItems = ssVal.getItems();
				 for (int i = 0 ; i < seqValItems.size() ; i++)
				 {
					 ESequenceValueItem seqValItem = seqValItems.get(i);
					 EList<ESettingValue> settingValues = seqValItem.getSubSettings();
					 for (int j = 0 ; j < settingValues.size() ; j++)
					 {
						 ESettingValue settingValue = settingValues.get(j);
						 ESetting subSetting = settingValue.getType();
						 if (subSetting instanceof ESimpleSetting)
						 {
							 adaptSimpleSettingOpionMap(subSetting, settingValue);
						 }
					 }
				 }
			 }
		 }
	   }
	}
	
	private void adaptSimpleSettingOpionMap(ESetting setting, ESettingValue settingValue)
	{
		ESimpleSetting ss = (ESimpleSetting)setting;
		for (ESettingOption option : ss.getOptions())
		{
			String map = ((EOption)option).getMap();
			if (map != null && !map.trim().equals("") && map.indexOf("/") != -1)
			{
				String mapFeatureRef = map.split("/")[0];
				String mapSettingRef = map.split("/")[1];
				
				for (EFeature f : view.getSharedFeatures())
				{
					if (f.getRef().equals(mapFeatureRef))
					{
						for (ESetting s : f.getSettings())
						{
							if (s.getRef().equals(mapSettingRef))
							{
								if (s instanceof ESequenceSetting) //should always be
								{
								  ((EOption)option).setMapSourceSetting((ESequenceSetting)s);
								   Map<String, EOptionMap> values = ((EOption)option).getOptionValues();
								   String v = ((ESimpleValue)settingValue).getMap();
								   for (Entry<String, EOptionMap> entry : values.entrySet())
								   {
										String key = entry.getKey();
										EOptionMap val = entry.getValue();
										String val2Save = val.getValue2Save();
										if (val2Save.equals(v))
										{
											settingValue.setChosenOption(entry.getValue().getMapValue());
											break;
										}
								   }
								}
							}
						}
					}
				}
			}
		}
	}
	
//	private void createSettingsForView(EFeature eFeature, EAppFeature appFeature, View view) {
//		
//		EMap<String, EAppSetting> settings = appFeature.getSettings();
//		Set<Entry<String, EAppSetting>> entrySet = settings.entrySet();
//		
//		for (Entry<String, EAppSetting> entry : entrySet)
//		{
//			EAppSetting appSetting = entry.getValue();
//			ESetting eSetting = adaptSetting(appSetting, entry.getKey());
//			eFeature.getSettings().add(eSetting);	
//			//view.getSharedSettingInstances().add(eSetting);
//		}
//	}
	
}
