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
package com.nokia.tools.s60ct.confml.editor.converter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.nokia.tools.s60ct.model.confml.EFeature;
import com.nokia.tools.s60ct.model.confml.EResourceSetting;
import com.nokia.tools.s60ct.model.confml.EResourceValue;
import com.nokia.tools.s60ct.model.confml.ESequenceValue;
import com.nokia.tools.s60ct.model.confml.ESequenceValueItem;
import com.nokia.tools.s60ct.model.confml.ESetting;
import com.nokia.tools.s60ct.model.confml.ESettingValue;
import com.nokia.tools.s60ct.model.confml.ESimpleSetting;
import com.nokia.tools.s60ct.model.confml.ESimpleValue;
import com.nokia.tools.s60ct.model.confml.EValueEditorDocument;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Document;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Factory;
import com.nokia.tools.vct.confml.model.confml2.EConfigurationElement;
import com.nokia.tools.vct.confml.model.confml2.EDataElement;
import com.nokia.tools.vct.confml.model.confml2.EFeatureData;
import com.nokia.tools.vct.confml.model.confml2.ELocalPathElement;
import com.nokia.tools.vct.confml.model.confml2.ESettingData;
import com.nokia.tools.vct.confml.model.confml2.ETargetPathElement;

public class VEModel2ConfML2PMConverter extends VEModel2ConfMLPMConverter {
	private class Item {
		private boolean removed = false;
		private String fragment;
		private ESettingData settingData;

		public boolean isRemoved() {
			return removed;
		}
		public String getFragment() {
			return fragment;
		}
		public ESettingData getSettingData() {
			return settingData;
		}
		public Item(boolean rem, String frag, ESettingData sdata) {
			this.removed = rem;
			this.fragment = frag;
			this.settingData = sdata;
		}
	}

	EConfML2Factory factory = null;

	public VEModel2ConfML2PMConverter() {
		factory = EConfML2Factory.eINSTANCE;
	}

	public List<Object> createPMData(EValueEditorDocument editorModel) {
		boolean modified = false;
		if (editorModel == null) {
			return null;
		}
		List<Object> featureDatas = new ArrayList<Object>();
		EList<EFeature> features = editorModel.getFeatures();
		for (EFeature eFeature : features) {
			EFeatureData featureData = factory.createEFeatureData();
			featureData.setRef(eFeature.getRef());
			for (ESetting setting : eFeature.getSettings()) {
				if(!setting.isSetdefault()) {
					if (!setting.isDirty())
						continue;					
				}
				ESettingValue value = setting.getValue();
				if (value instanceof ESimpleValue) {
					setSimpleValue(featureData, setting, setting
							.getRef());
					setting.clearDirty();
					setting.setSetdefault(false);
					modified = true;
				}
				else if (value instanceof EResourceValue)
				{
					setResourceValue(featureData, setting, setting
							.getRef());
					setting.clearDirty();
					setting.setSetdefault(false);
					modified = true;
				}
			}
			featureDatas.add(featureData);
		}
		if(!modified) {
			return null;
		}
		return featureDatas;
	}

	private void setSimpleValue(EFeatureData featureData, ESetting setting,
			String ref) {
		ESimpleSetting sSetting = (ESimpleSetting) setting;
		ESimpleValue currentValue = (ESimpleValue) sSetting.getValue();
		ESimpleValue defaultValue = (ESimpleValue) sSetting.getDefaultValue();
		ESettingData settingData = factory.createESettingData();
		String choosenOption = currentValue.getChosenOption();
		settingData.setRef(ref);
		
		if(sSetting.isSetdefault() && currentValue.getTrueValue().equals(defaultValue.getTrueValue())) {
			settingData.setText(null);
		} 
		else
		{
			if (choosenOption != null)
			{
				String mapValue = currentValue.getMap();
				settingData.setMap(mapValue);
				settingData.setText("");
			}
			else
				settingData.setText(currentValue.getTrueValue());			
		}
		
		featureData.getSettings().add(settingData);
	}
	
	private void setResourceValue(EFeatureData featureData, ESetting setting,
			String ref) {
		EResourceSetting rSetting = (EResourceSetting)setting;
		EResourceValue currentValue = (EResourceValue) rSetting.getValue();
		EResourceValue defaultValue = (EResourceValue) rSetting.getDefaultValue();
		ESettingData settingData = factory.createESettingData();

		ESettingData localPathData = factory.createESettingData();
		localPathData.setRef("localPath");
		//ESettingData targetPathData = factory.createESettingData();
		//targetPathData.setRef("targetPath");
		
		settingData.getSettings().add(localPathData);
		//settingData.getSettings().add(targetPathData);
		
		settingData.setRef(ref);
		if(rSetting.isSetdefault() && ((ESimpleValue)currentValue.getLocalPath()).getValue().equals(((ESimpleValue)defaultValue.getLocalPath()).getValue())) {
			localPathData.setText(null);
			settingData.setText(null);
		} else {
			localPathData.setText(((ESimpleValue)currentValue.getLocalPath()).getValue());	
			settingData.setText("");
		}

		featureData.getSettings().add(settingData);
	}
	

	public void mergePMDataWithResource(Resource resource, List<Object> featureDataObjects) {		
		EList<EObject> contents = resource.getContents();
		
		EConfML2Document document = (EConfML2Document) contents
		.get(0);
		
		EConfigurationElement configuration = document.getConfiguration();
		EList<EDataElement> dataList = configuration.getData();// list
		// of
		if (dataList.isEmpty()) {
			dataList.add(EConfML2Factory.eINSTANCE.createEDataElement());
		}
		EDataElement data = dataList.get(0);
		for (Object featureDataObject : featureDataObjects) {
			EFeatureData featureData = (EFeatureData) featureDataObject;

			EFeatureData existingFeatureData = getFeatureData(data, featureData
					.getRef());
			if (existingFeatureData == null) {
				EList<ESettingData> settings = featureData.getSettings();
				for (Iterator<ESettingData> iter = settings.iterator(); iter
						.hasNext();) {
					ESettingData settingData = iter.next();
					if(settingData.getValue().size()==0) {
						iter.remove();
					}
				}
				if(settings.size()!=0) {
					data.getData().add(featureData);					
				}
			} else {
				mergeFeatureDatas(existingFeatureData, featureData);
			}
		}
	}

	private void mergeFeatureDatas(EFeatureData existingFeatureData,
			EFeatureData featureData) {
		EList<ESettingData> newSettings = featureData.getSettings();
		for (Iterator<ESettingData> iterator = newSettings.iterator(); iterator
		.hasNext();) {
			ESettingData settingData = iterator.next();

			String ref = settingData.getRef();
			ESettingData existingSetting = settingExistsInFeatureData(
					existingFeatureData, ref);

			if (existingSetting != null) {
				existingFeatureData.getSettings().remove(existingSetting);
			}
			iterator.remove();
			if(settingData.getValue().size()!=0) {
				existingFeatureData.getSettings().add(settingData);				
			}
		}
		if(existingFeatureData.getSettings().size()==0) {
			EDataElement data = (EDataElement) existingFeatureData.eContainer();
			data.getData().remove(existingFeatureData);
		}
	}

	private ESettingData settingExistsInFeatureData(
			EFeatureData existingFeatureData, String ref) {
		for (ESettingData settingData : existingFeatureData.getSettings()) {
			if (settingData.getRef().equals(ref)) {
				return settingData;
			}
		}
		return null;
	}

	private EFeatureData getFeatureData(EDataElement data, String ref) {
		for (EFeatureData featureData : data.getData()) {
			if (featureData.getRef().equals(ref))
				return featureData;
		}
		return null;
	}
	
	public void mergeItemsWithResource(Resource resource,
			List<ESequenceValueItem> items, String featureRef, String settingRef) {
		List<Item> persistenceItems = new ArrayList<Item>();
		//step 1. create new items and preserve the extension policy
		boolean policyAdded = false;
		for(ESequenceValueItem item: items) {
			URI frameLocationUri = item.getFrameLocationUri();
			String fragment = frameLocationUri.fragment();

			String newExtPolicy = ((ESequenceValue)item.eContainer()).getExtensionPolicy().getLiteral().toLowerCase();
			
			ESettingData pData = createSettingData(item, settingRef);
			Item pItem = new Item(item.isRemoved(),fragment,pData);
//			if(fragment!=null && !fragment.equals("")) {
//			ESettingData pFrame = (ESettingData) resource.getEObject(fragment);
//			String oldExtPolicy = pFrame.getExtensionPolicy();
//			if((pFrame != null)&&(oldExtPolicy!=null)) {
//				if (newExtPolicy.equals(oldExtPolicy))
//					pData.setExtensionPolicy(new String(pFrame.getExtensionPolicy()));
//				else
//					pData.setExtensionPolicy(newExtPolicy);
//			}
//			
//		}
			if (!policyAdded)
			{
				pData.setExtensionPolicy(newExtPolicy);
				policyAdded = true;
			}
			persistenceItems.add(pItem);
		}
		arrangeSequenceDataFrames(persistenceItems);
		//step 2. remove all existing frames in the resource
		EFeatureData featureData=cleanResource(resource, featureRef, settingRef);

		//step 3. add new all settingData under given featureData
		for (Item pItem : persistenceItems) {
			if(!pItem.isRemoved()) {
				featureData.getSettings().add(pItem.getSettingData());					
			}
			}
		
		if (featureData.getSettings().size()==0)
		{//last removed. Remove also empty feature data
			EDataElement data = (EDataElement)featureData.eContainer();
			data.getData().remove(featureData);
			featureData = null;
		}
		
	}



	private EFeatureData cleanResource(Resource resource, String featureRef,
			String settingRef) {
		EFeatureData ftData=null;
		EList<EObject> contents = resource.getContents();
		if(contents.isEmpty()) {
			return prepareResource(resource, featureRef);
		}
		EConfML2Document document = (EConfML2Document) contents.get(0);
		EConfigurationElement configuration = document.getConfiguration();
		
		if (configuration.getData().isEmpty()) {
			EDataElement data = factory.createEDataElement();
			configuration.getData().add(data);
		}
		for (EDataElement data : configuration.getData()) {
			for(EFeatureData featureData :data.getData()) {
				if(featureData.getRef().equals(featureRef)) {
					EList<ESettingData> settings = featureData.getSettings();
					for (Iterator<ESettingData> settingDatas = settings.iterator(); settingDatas
					.hasNext();) {
						ESettingData settingData = settingDatas
						.next();
						if(settingData.getRef().equals(settingRef)) {
							settingDatas.remove();
						}

					}
					if(ftData==null)
						ftData=featureData;
				}
			}
		}
		if(ftData == null) {
			ftData = factory.createEFeatureData();
			ftData.setRef(featureRef);
			configuration.getData().get(0).getData().add(ftData);
		}	
		return ftData;
	}
	/**
	 * Prepare an empty resource
	 * @param resource
	 * @param featureRef
	 * @return
	 */
	private EFeatureData prepareResource(Resource resource, String featureRef) {
		EConfML2Document document = factory.createEConfML2Document();
		EConfigurationElement config = factory.createEConfigurationElement();
		config.setName("data");
		EDataElement data = factory.createEDataElement();
		EFeatureData featureData = factory.createEFeatureData();
		featureData.setRef(featureRef);
		data.getData().add(featureData);
		config.getData().add(data);
		document.setConfiguration(config);
		resource.getContents().add(document);
		return featureData;
	}

	/**
	 * arranges frames so that the frame with ex policy is the first in
	 * the list
	 * @param pItems
	 */
	private void arrangeSequenceDataFrames(
			List<Item> pItems) {
		if(pItems.isEmpty()) {
			return;
		}
		Item epFrame = null;
		for (Item item : pItems) {
			if(item.getSettingData().getExtensionPolicy()!=null) {
				epFrame = item;
				break;
			}
		}
		if((epFrame!=null)&&(pItems.indexOf(epFrame)!=0)) {
			Item setEpForThis = pItems.get(0);
			ESettingData settingData = setEpForThis.getSettingData();
			settingData.setExtensionPolicy(epFrame.getSettingData().getExtensionPolicy());
			epFrame.getSettingData().setExtensionPolicy(null);
		} 
//		else {
//			epFrame = pItems.get(0);
//			epFrame.getSettingData().setExtensionPolicy("append");
//		}
	}

	private ESettingData createSettingData(ESequenceValueItem item, String ref) {
		ESettingData pFrame = factory.createESettingData();
		pFrame.setRef(ref);
		for (ESettingValue subSetting : item.getSubSettings()) {
			ESettingData settingData = factory.createESettingData();
			if (subSetting instanceof ESimpleValue)
			{
				ESimpleValue simpleValue = (ESimpleValue) subSetting;
				
				String choosenOption = simpleValue.getChosenOption();
				
				if (choosenOption != null)
				{
					String mapValue = simpleValue.getMap();
					settingData.setMap(mapValue);
					settingData.setText("");
				}
				else
					settingData.setText(simpleValue.getTrueValue());		
				
				settingData.setRef(subSetting.getRef());
			}
			else if (subSetting instanceof EResourceValue)
			{
				ESettingData localPathData = factory.createESettingData();
				localPathData.setRef("localPath");
				
				EResourceValue resSetting = (EResourceValue) subSetting;
//				settingData.setText(resSetting.getValue());
				settingData.setRef(subSetting.getRef());
				settingData.getSettings().add(localPathData);
				localPathData.setText(((ESimpleValue)resSetting.getLocalPath()).getValue());	
				settingData.setText("");
			}
			pFrame.getSettings().add(settingData);
		}
		return pFrame;
	}
}
