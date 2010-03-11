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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.dnd.DropTargetListener;

import com.nokia.tools.carbide.ct.ui.overview.Feature;
import com.nokia.tools.s60ct.confml.commands.ChangeSettingValueCommand;
import com.nokia.tools.s60ct.confml.commands.SetExtensionPolicyCommand;
import com.nokia.tools.s60ct.confml.viewer.IValuesContentProvider;
import com.nokia.tools.s60ct.model.confml.ConfmlFactory;
import com.nokia.tools.s60ct.model.confml.EExtensionPolicy;
import com.nokia.tools.s60ct.model.confml.EFeature;
import com.nokia.tools.s60ct.model.confml.EGroup;
import com.nokia.tools.s60ct.model.confml.EResourceSetting;
import com.nokia.tools.s60ct.model.confml.EResourceValue;
import com.nokia.tools.s60ct.model.confml.ESequenceSetting;
import com.nokia.tools.s60ct.model.confml.ESequenceValue;
import com.nokia.tools.s60ct.model.confml.ESequenceValueItem;
import com.nokia.tools.s60ct.model.confml.ESetting;
import com.nokia.tools.s60ct.model.confml.ESettingValue;
import com.nokia.tools.s60ct.model.confml.ESimpleSetting;
import com.nokia.tools.s60ct.model.confml.ESimpleValue;
import com.nokia.tools.s60ct.model.confml.EValueEditorDocument;

public class FeatureViewerContentProvider implements IValuesContentProvider {

	private CommandStack stack;
	private ConfmlEditor editor;

	public FeatureViewerContentProvider(CommandStack stack, ConfmlEditor editor) {
		this.stack = stack;
		this.editor = editor;
	}

	public void contributeToToolBar(IToolBarManager manager, Object element) {
	}

	public DropTargetListener getDropTargetListener(Object child) {
		return null;
	}

	public String getValue(Object element) {
		
		if (element instanceof ESetting)
		{
			if (element instanceof ESimpleSetting)
			{
				ESimpleSetting ss = (ESimpleSetting)element;
				String chosenOption = ss.getValue().getChosenOption();
				if (chosenOption != null && !"".equals(chosenOption)) {
					return chosenOption;
				}
			}
			ESetting setting = (ESetting) element;
			ESettingValue currentValue = setting.getValue();
			if (currentValue instanceof ESimpleValue) {
				return ((ESimpleValue) currentValue).getValue();
			} else if (currentValue instanceof ESequenceValue) {
				ESequenceValue seqVal = (ESequenceValue)currentValue;
				return seqVal.getExtensionPolicy().getName();

			} else if (currentValue instanceof EResourceValue) {
				EResourceValue resVal = (EResourceValue)currentValue;
				if (resVal.getLocalPath()!=null)
				{
					return ((ESimpleValue)resVal.getLocalPath()).getValue();
				}
				return "";
			} else {
				return "";
			}
		} else if (element instanceof ESimpleValue) {
			ESimpleValue simpleValue = (ESimpleValue) element;
			ESimpleSetting ss = (ESimpleSetting)simpleValue.getType();
			String chosenOption = simpleValue.getChosenOption();
			if (chosenOption != null && !"".equals(chosenOption)) {
				return chosenOption;
			}
			
			return simpleValue.getValue();
		}
		else if (element instanceof ESequenceValue) 
		{
			return "huuhaa";
		} 
		else if (element instanceof EResourceValue) 
		{
			EResourceValue resVal = (EResourceValue)element;
			if (resVal.getLocalPath()!=null)
			{
				return ((ESimpleValue)resVal.getLocalPath()).getValue();
			}
			return "";
		} 
		else if (element instanceof ESequenceValueItem)
		{
			
			return "ESequenceValueItem huuhaa";
		}
		else 
		{
			return "foo";
		}
	}

	public boolean hasNote(Object element) {
		return false;
	}

	public boolean isDefault(Object element) {
		
		
		if (element instanceof ESetting)
		{
			ESetting setting = (ESetting) element;
			ESettingValue setVal = setting.getValue();
			if (setVal instanceof ESimpleValue)
			{
				ESimpleSetting ss = (ESimpleSetting) setting;
				return ss.isDefault();
			}
			if (setVal instanceof EResourceValue)
			{
				EResourceSetting rs = (EResourceSetting) setting;
				return rs.isDefault();
			}
			else if (setVal instanceof ESequenceValue)
			{
				//ESequenceValue seqVal = (ESequenceValue) setVal;
				//return seqVal.getType().isDefault();
				return true; // Sequence items do not have default value, so return true always
			}
		}
		if (element instanceof ESimpleValue) {
			ESimpleValue currentValue = (ESimpleValue) element;
			return currentValue.getType().isDefault();
		}
		if (element instanceof EResourceValue) {
			EResourceValue currentValue = (EResourceValue) element;
			return currentValue.getType().isDefault();
		}
		if (element instanceof ESequenceValueItem) {
			return true; // Sequence items do not have default value, so return true always
		}
		
		
		if (element instanceof EResourceSetting)
		{
			EResourceSetting resourceSetting = (EResourceSetting) element;
			EResourceValue resVal = (EResourceValue) resourceSetting.getValue();
			if (resVal != null)
			{
				//fix this
				return true;
				//return resVal.
			}
			else
			{
				return true;
			}
		}
		
		return false;
	}

	public boolean isDirty(Object element) {
		ESetting setting = (ESetting) element;
		ESimpleValue currentValue = (ESimpleValue) setting.getValue();
		ESimpleValue defaultValue = (ESimpleValue) setting.getDefaultValue();
		if (currentValue == null || defaultValue == null
				|| currentValue.getValue() == null
				|| defaultValue.getValue() == null) {
			return true;
		}
		if (currentValue.getValue().compareTo(defaultValue.getValue()) != 0) {
			return true;
		}

		return false;
	}

	public void valueChanged(String newValue, Object element) {
		if(element instanceof ESimpleSetting)
		{
			ESimpleSetting setting = (ESimpleSetting) element;
			ChangeSettingValueCommand changeSettingValueCommand = new ChangeSettingValueCommand(
					(ESimpleValue)setting.getValue(), newValue);
			stack.execute(changeSettingValueCommand);
			//editor.handleErrors(setting, newValue);
			
		} 
		else if(element instanceof ESimpleValue)
		{
			
			ESimpleValue settingValue = (ESimpleValue) element;
			ChangeSettingValueCommand changeSettingValueCommand = new ChangeSettingValueCommand(
					settingValue, newValue);
			stack.execute(changeSettingValueCommand);
			
		}
		else if (element instanceof ESequenceValue)
		{
			EExtensionPolicy policy = null;
			
			if (newValue.equalsIgnoreCase(EExtensionPolicy.REPLACE.getName()))
			{
				policy =  EExtensionPolicy.REPLACE;
			}
			if (newValue.equalsIgnoreCase(EExtensionPolicy.APPEND.getName()))
			{
				policy =  EExtensionPolicy.APPEND;
			}
			if (newValue.equalsIgnoreCase(EExtensionPolicy.PREFIX.getName()))
			{
				policy =  EExtensionPolicy.PREFIX;
			}
			ESequenceValue seqvalue = (ESequenceValue)element;
			SetExtensionPolicyCommand command = new SetExtensionPolicyCommand(seqvalue,policy);
			stack.execute(command);
			//editor.doSave(null);
		}
		else if (element instanceof EResourceSetting)
		{
			EResourceSetting resSetting = (EResourceSetting)element;
			EResourceValue resVal = (EResourceValue)resSetting.getValue();

			if (resVal.getLocalPath()==null)
			{
				resVal.setLocalPath(ConfmlFactory.eINSTANCE.createESimpleValue());
			}
			
			ChangeSettingValueCommand changeSettingValueCommand = new ChangeSettingValueCommand(
					(ESimpleValue)resVal.getLocalPath(), newValue);
			stack.execute(changeSettingValueCommand);
			//editor.handleErrors(resSetting, newValue);
		}
		else if (element instanceof EResourceValue)
		{
			EResourceValue resVal = (EResourceValue)element;
		
			if (resVal.getLocalPath()==null)
			{
				resVal.setLocalPath(ConfmlFactory.eINSTANCE.createESimpleValue());
			}
			
			ChangeSettingValueCommand changeSettingValueCommand = new ChangeSettingValueCommand(
					(ESimpleValue)resVal.getLocalPath(), newValue);
			stack.execute(changeSettingValueCommand);
		}
	}

	public Object[] getChildren(Object parentElement) {
		return getElements(parentElement);
	}

	public Object getParent(Object element) {
		if (element instanceof EObject) {
			return ((EObject) element).eContainer();
		}
		return null;
	}

	public boolean hasChildren(Object element) {
		return false;
	}

	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof EValueEditorDocument) {
			EValueEditorDocument doc = (EValueEditorDocument) inputElement;
			if (doc.getGroups().isEmpty())
				return doc.getFeatures().toArray();
			else
				return doc.getGroups().toArray();
		} else if (inputElement instanceof EFeature) {
			EFeature efeature = (EFeature) inputElement;
			return efeature.getSettings().toArray();
		} else if (inputElement instanceof EGroup){
			EGroup group = (EGroup)inputElement;
			List<ESetting> tempList = new ArrayList<ESetting>();
			
			for (String settingOrder : group.getSettingOrder())
			{
				boolean found = false;
				for (EFeature feature : group.getFeatures())
				{
					for (ESetting setting : feature.getSettings())
					{
						if (setting.getRef().equals(settingOrder))
						{
							tempList.add(setting);
							found = true;
							break;
						}
					}
					if (found)
						break;
				}
			}
			return tempList.toArray();
			
		}else if (inputElement instanceof ESetting) {
			ESetting eSetting = (ESetting) inputElement;
			if (eSetting instanceof ESequenceSetting) {
				ESequenceSetting eSeqSet = (ESequenceSetting) eSetting;

				ESequenceValue eSeqVal = (ESequenceValue) eSeqSet.getValue();
				ESequenceValue eSeqDef = (ESequenceValue) eSeqSet.getDefaultValue();
				List<ESequenceValueItem> tempList = new ArrayList<ESequenceValueItem>();
				
				if(eSeqVal.getTemplate()!=null) {					
					tempList.add(eSeqVal.getTemplate());
				}
				if(eSeqDef.getTemplate()!=null) {
					tempList.add(eSeqDef.getTemplate());
				}
				for (ESequenceValueItem item : eSeqVal.getItems()) {
					if(!item.isRemoved()) {
						tempList.add(item);						
					}
				}
				
				
				if (eSeqVal.getExtensionPolicy().getValue()==EExtensionPolicy.APPEND_VALUE)
				{
					tempList.addAll(1, eSeqDef.getItems());
				}
				else if (eSeqVal.getExtensionPolicy().getValue()==EExtensionPolicy.PREFIX_VALUE)
				{
					tempList.addAll(eSeqDef.getItems());
				}
				else if (eSeqVal.getExtensionPolicy().getValue()==EExtensionPolicy.REPLACE_VALUE && eSeqVal.getItems().size()==0)
				{
					tempList.addAll(eSeqDef.getItems());
				}
				return tempList.toArray();
				// return sType.getSubTypes().toArray();
			} else if (eSetting instanceof EResourceSetting) {
				return new Object[] {};
			} else {
				return new Object[] {};
			}
		} else if (inputElement instanceof ESequenceValueItem) {
			ESequenceValueItem eSeqValItem = (ESequenceValueItem) inputElement;

			return eSeqValItem.getSubSettings().toArray();
		} else {
			return new Object[] {};			
		}
	}

	public void dispose() {
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}
}
