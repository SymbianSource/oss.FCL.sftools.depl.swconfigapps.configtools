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
package com.nokia.tools.s60ct.confml.editor.tests;


import junit.framework.TestCase;

import com.nokia.tools.s60ct.model.confml.ConfmlFactory;
import com.nokia.tools.s60ct.model.confml.EFeature;
import com.nokia.tools.s60ct.model.confml.ESequenceSetting;
import com.nokia.tools.s60ct.model.confml.ESequenceValue;
import com.nokia.tools.s60ct.model.confml.ESetting;
import com.nokia.tools.s60ct.model.confml.ESettingValue;
import com.nokia.tools.s60ct.model.confml.ESimpleSetting;
import com.nokia.tools.s60ct.model.confml.ESimpleValue;
import com.nokia.tools.s60ct.model.confml.EValueEditorDocument;
import com.nokia.tools.s60ct.model.confml.View;
import com.nokia.tools.s60ct.model.confml.util.AppModel2EditorModelConverter;
import com.nokia.tools.vct.common.appmodel.EAppFeature;
import com.nokia.tools.vct.common.appmodel.EAppSequenceData;
import com.nokia.tools.vct.common.appmodel.EAppSequenceDataItem;
import com.nokia.tools.vct.common.appmodel.EAppSequenceType;
import com.nokia.tools.vct.common.appmodel.EAppSetting;
import com.nokia.tools.vct.common.appmodel.EAppSimpleData;
import com.nokia.tools.vct.common.appmodel.EAppSimpleType;
import com.nokia.tools.vct.common.appmodel.EAppValueType;
import com.nokia.tools.vct.common.appmodel.EApplicationFactory;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;

public class AppModel2EditorModelConverterTest extends TestCase {

	private EApplicationFactory factory;
	private EAppFeature appFeature;
	private EFeature eFeature;
	private String settingName;
	private String settingRef;
	private String settingValue;
	private AppModel2EditorModelConverter modelConverter;
	private EConfMLLayer layer;
	private String featureName;
	private String featureRef;
	private View view;
	
	@Override
	protected void setUp() throws Exception {
		factory = EApplicationFactory.eINSTANCE;
		featureName = "f1";
		featureRef = "f1";
		settingName = "setting1";
		settingRef = "s1";
		settingValue = "foo";
		modelConverter = AppModel2EditorModelConverter.getInstance();
		layer = factory.createEConfMLLayer();
		view = ConfmlFactory.eINSTANCE.createView();
		appFeature = factory.createEAppFeature();
		appFeature.setName(featureName);
		layer.getFeatures().put(featureRef, appFeature);
	}

	public void testCreateEditorModel() {
		EValueEditorDocument doc = modelConverter.createEditorModel(null,view);
		assertNull(doc);
	}

	public void testSequenceFeature() {
		String subSettingRef = "subref";
		String subSettingName = "subName";	
		int maxOccurs = 3;
		
		EAppSetting appSetting = factory.createEAppSetting();

		// create sequence type
		EAppSequenceType sequenceType = factory.createEAppSequenceType();
		sequenceType.setName(settingName);
		sequenceType.setMaxOccurs(maxOccurs);
		EAppSimpleType simpleType = factory.createEAppSimpleType();
		simpleType.setName(subSettingName);
		simpleType.setReadOnly(true);
		simpleType.setLength(10);
		simpleType.setType(EAppValueType.INTEGER);
		sequenceType.getTypeMap().put(subSettingRef, simpleType);

		// create sequence data
		EAppSequenceData sequenceData = factory.createEAppSequenceData();

		EAppSimpleData simpleData = factory.createEAppSimpleData();
		simpleData.setValue("1");

		EAppSequenceDataItem sequenceDataItem = factory
				.createEAppSequenceDataItem();
		sequenceDataItem.getSubSettings().put(subSettingRef, simpleData);
		sequenceData.getItems().add(sequenceDataItem);

		sequenceDataItem = factory
		.createEAppSequenceDataItem();
		sequenceDataItem.getSubSettings().put(subSettingRef, simpleData);
		
		
		sequenceData.setTemplate(sequenceDataItem);
		
		sequenceData.setTypeInfo(sequenceType);
		
		appSetting.setTypeInfo(sequenceType);
		appSetting.setValueInfo(sequenceData);

		// add setting to the EappFeature
		appFeature.getSettings().put(settingRef, appSetting);

		// verify m2m transformation
		EValueEditorDocument doc = modelConverter.createEditorModel(appFeature,view);
		eFeature = doc.getFeatures().get(0);
		
		assertEquals(featureName, eFeature.getName());
		assertEquals(1, eFeature.getSettings().size());

		ESetting eSetting = eFeature.getSettings().get(0);
		assertEquals(settingName, eSetting.getName());
		assertEquals(settingRef, eSetting.getRef());

		assertTrue("ESetting type must be sequence",
				eSetting instanceof ESequenceSetting);

		ESequenceSetting eSequenceType = (ESequenceSetting) eSetting;
		assertEquals(new Integer(maxOccurs), eSequenceType.getMaxOccurs());

		assertTrue("Subtypes mustn't be empty.",eSequenceType.getSubTypes().size()!=0);

		ESetting subSetting = eSequenceType.getSubTypes().get(0);
		assertTrue("Subtype must be simple type", subSetting instanceof ESimpleSetting);
		
		ESettingValue eSettingValue = eSetting.getValue();
		assertTrue(eSettingValue instanceof ESequenceValue);

//		ESequenceValue eSequenceValue = (ESequenceValue) eSettingValue;
//		assertFalse(
//				"There must be at least one ESequenceValueItem in the list.",
//				eSequenceValue.getItems().isEmpty());
//
//		ESequenceValueItem sequenceValueItem = eSequenceValue.getItems().get(0);
//		assertFalse("Subsetting must not be empty.", sequenceValueItem
//				.getSubSettings().isEmpty());
//		assertTrue("SequenceSetting value must have template item",
//				eSequenceValue.getTemplate() != null);
//		eSettingValue = sequenceValueItem.getSubSettings().get(0);
//		assertEquals(subSettingRef, eSettingValue.getRef());
//		assertNotNull(eSettingValue.getType());
	}

	public void testSimpleFeature() {
		EAppSetting appSetting = factory.createEAppSetting();
		EAppSimpleType settingType = factory.createEAppSimpleType();
		settingType.setName(settingName);
		settingType.setType(EAppValueType.STRING);
		EAppSimpleData settingData = factory.createEAppSimpleData();
		settingData.setValue(settingValue);
		appSetting.setTypeInfo(settingType);
		appSetting.setValueInfo(settingData);
		appFeature.getSettings().put(settingRef, appSetting);
		
		EValueEditorDocument doc = modelConverter.createEditorModel(appFeature,view);
		eFeature = doc.getFeatures().get(0);
		assertEquals(1, eFeature.getSettings().size()); // assure 1 setting
		ESetting eSetting = eFeature.getSettings().get(0);
		assertEquals(settingName, eSetting.getName());
		assertNotNull("ESetting should have defaul value", eSetting
				.getDefaultValue());
		assertNotNull("ESetting should have value", eSetting.getValue());
//		assertFalse(settingValue.equals(((ESimpleValue) eSetting.getDefaultValue())
//				.getValue()));
		assertEquals(settingValue, ((ESimpleValue) eSetting.getValue())
				.getValue());
	}

	public void testEmptyFeature() {
		EValueEditorDocument doc = modelConverter.createEditorModel(appFeature,view);
		eFeature = doc.getFeatures().get(0);
		assertEquals("f1", eFeature.getName());
		assertNotNull("feature ref should not be null", eFeature.getRef());
		assertTrue("No settings should exist under the feature ", eFeature
				.getSettings().isEmpty());
	}

}
