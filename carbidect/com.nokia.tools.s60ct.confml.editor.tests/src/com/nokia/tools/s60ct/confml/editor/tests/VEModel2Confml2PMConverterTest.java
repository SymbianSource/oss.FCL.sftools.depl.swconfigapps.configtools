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

import java.io.File;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.nokia.tools.s60ct.confml.editor.converter.VEModel2ConfML2PMConverter;
import com.nokia.tools.s60ct.model.confml.ConfmlFactory;
import com.nokia.tools.s60ct.model.confml.EFeature;
import com.nokia.tools.s60ct.model.confml.ESequenceValue;
import com.nokia.tools.s60ct.model.confml.ESequenceValueItem;
import com.nokia.tools.s60ct.model.confml.ESetting;
import com.nokia.tools.s60ct.model.confml.ESimpleValue;
import com.nokia.tools.s60ct.model.confml.EValueEditorDocument;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Document;
import com.nokia.tools.vct.confml.model.confml2.EConfigurationElement;
import com.nokia.tools.vct.confml.model.confml2.EDataElement;
import com.nokia.tools.vct.confml.model.confml2.EFeatureData;
import com.nokia.tools.vct.confml.model.confml2.util.EConfML2ResourceFactoryImpl;

public class VEModel2Confml2PMConverterTest extends TestCase {

	private VEModel2ConfML2PMConverter converter;
	private ConfmlFactory factory;

	@Override
	public void setUp() throws Exception {
		converter = new VEModel2ConfML2PMConverter();
		factory = ConfmlFactory.eINSTANCE;
	}

	public void testNullIsConvertedToNull() throws Exception {
		Object values = converter.createPMData(null);
		assertNull(values);
	}

	public void testEFeatureWithSimpleSetting() throws Exception {
		EValueEditorDocument document = factory.createEValueEditorDocument();
		EFeature feature = factory.createEFeature();
		document.getFeatures().add(feature);
		feature.setName("featureName");
		feature.setRef("f1");

		List<Object> values;

		ESetting eSetting = factory.createESimpleSetting();
		eSetting.setRef("s1");
		feature.getSettings().add(eSetting);

		ESimpleValue simpleValue = factory.createESimpleValue();
		simpleValue.setValue("value1");
		eSetting.setDefaultValue(simpleValue);

		simpleValue = factory.createESimpleValue();
		simpleValue.setValue("value2");
		eSetting.setValue(simpleValue);
		eSetting.setModified(true);

		values = converter.createPMData(document);
		assertNotNull(values);
		assertFalse(values.isEmpty());
		assertTrue(values.get(0) instanceof EFeatureData);
		EFeatureData featureData = (EFeatureData) values.get(0);
		assertEquals("f1", featureData.getRef());
		assertEquals(1, featureData.getSettings().size());

//		ResourceSet rs = new ResourceSetImpl();
//
//		Resource resource = createResource(rs);
//
//		converter.mergePMDataWithResource(resource, values);
//		resource.save(Collections.EMPTY_MAP);
	}

	public void testEFeatureWithSequenceSetting() throws Exception {
		String featureRef = "f1";
		String settingRef = "ss";

		EFeature feature = factory.createEFeature();
		feature.setRef(featureRef);
		ESetting eSetting = factory.createESequenceSetting();
		eSetting.setRef(settingRef);
		feature.getSettings().add(eSetting);

		ESequenceValue sequenceValue = factory.createESequenceValue();
		sequenceValue.setRef(settingRef);

		addItems(sequenceValue);

		eSetting.setValue(sequenceValue);

		ResourceSet rs = new ResourceSetImpl();

		Resource resource = createResource(rs);

		converter.mergeItemsWithResource(resource, sequenceValue.getItems(),
				featureRef, settingRef);

		// verify that the resource contains required items
		EConfML2Document document = (EConfML2Document) resource.getContents()
				.get(0);
		EConfigurationElement configuration = document.getConfiguration();
		EList<EDataElement> data = configuration.getData();
		assertFalse("There must be data element in the configuration", data
				.isEmpty());
		EFeatureData fData = null;
		for (EDataElement dataElement : data) {
			EList<EFeatureData> featureDatas = dataElement.getData();
			for (EFeatureData featureData : featureDatas) {
				if (featureData.getRef().equals(featureRef)) {
					fData = featureData;
					break;
				}
			}
		}
		assertNotNull("FeatureData is missing", fData);
		assertTrue("Required number of settingData not created", fData
				.getSettings().size() >= 2);
//		resource.save(Collections.EMPTY_MAP);
	}

	private Resource createResource(ResourceSet rs) {
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				"confml", new EConfML2ResourceFactoryImpl());
		URI uri = URI.createFileURI(new File("sequencetest2.confml")
				.getAbsolutePath());
		Resource resource;
		try {
			resource = rs.getResource(uri, true);
		} catch (Exception e) {
			resource = rs.getResource(uri, false);
		}
		return resource;
	}

	private void addItems(ESequenceValue sequenceValue) {
		URI uri = URI.createURI("platform:/resource/some");
		ESequenceValueItem sequenceValueItem = factory
				.createESequenceValueItem();

		addSimpleValue(sequenceValueItem, "s1", "value1");
		addSimpleValue(sequenceValueItem, "s2", "value2");
		sequenceValueItem.setFrameLocationUri(uri);
		sequenceValue.getItems().add(sequenceValueItem);

		sequenceValueItem = factory.createESequenceValueItem();

		addSimpleValue(sequenceValueItem, "s1", "value3");
		addSimpleValue(sequenceValueItem, "s2", "value4");
		sequenceValueItem.setFrameLocationUri(uri);
		sequenceValue.getItems().add(sequenceValueItem);

		sequenceValueItem = factory.createESequenceValueItem();

		addSimpleValue(sequenceValueItem, "s1", "value_t");
		addSimpleValue(sequenceValueItem, "s2", "value_t");
		sequenceValue.setTemplate(sequenceValueItem);
	}

	private void addSimpleValue(ESequenceValueItem sequenceValueItem,
			String ref, String value) {
		ESimpleValue simpleValue = factory.createESimpleValue();
		simpleValue.setRef(ref);
		simpleValue.setValue(value);
		sequenceValueItem.getSubSettings().add(simpleValue);
	}

}
