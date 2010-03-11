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
package com.nokia.tools.s60ct.confml.editor.properties;

import java.math.BigDecimal;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.nokia.tools.s60ct.build.builder.utils.SettingImplementationCollector;
import com.nokia.tools.s60ct.model.confml.EExtensionPolicy;
import com.nokia.tools.s60ct.model.confml.EFeature;
import com.nokia.tools.s60ct.model.confml.EProperty;
import com.nokia.tools.s60ct.model.confml.EResourceSetting;
import com.nokia.tools.s60ct.model.confml.EResourceValue;
import com.nokia.tools.s60ct.model.confml.ESequenceSetting;
import com.nokia.tools.s60ct.model.confml.ESequenceValue;
import com.nokia.tools.s60ct.model.confml.ESequenceValueItem;
import com.nokia.tools.s60ct.model.confml.ESetting;
import com.nokia.tools.s60ct.model.confml.ESettingValue;
import com.nokia.tools.s60ct.model.confml.ESettingValueType;
import com.nokia.tools.s60ct.model.confml.ESimpleSetting;
import com.nokia.tools.s60ct.model.confml.ESimpleValue;
import com.nokia.tools.s60ct.model.confml.presentation.ConfmlEditor;
import com.nokia.tools.vct.crml.crmodel.EBit;
import com.nokia.tools.vct.crml.crmodel.ECRMLDocumentRoot;
import com.nokia.tools.vct.crml.crmodel.EKey;
import com.nokia.tools.vct.crml.crmodel.EKeyRange;
import com.nokia.tools.vct.crml.crmodel.ERepository;
import com.nokia.tools.vct.gcfml.gcfmlmodel.EFile;


/**
 * This class provides control from the Editor part for the properties view.
 * With first display of properties, the components are created. The UI is build
 * according to setting's type and according to existence of the property, the
 * property is displayed or not. Description and Default value are visible all
 * the time, when setting is selected in the editor.
 * 
 * @author vilccjar
 * 
 */
public class SettingPropertySection extends TabControlPropertySection {
	private Section control;

	private StringFieldEditor settingDescription;
	private StringFieldEditor settingType;
	private StringFieldEditor absRef;
	private StringFieldEditor required;
	private StringFieldEditor relevant;
	private StringFieldEditor constraint;
	private StringFieldEditor property;
	private TableFieldEditor parentLayerValue;
	private StringFieldEditor range;
	private StringFieldEditor pattern;
	private StringFieldEditor totalDigits;
	private StringFieldEditor length;
	private StringFieldEditor notes;
	private final String NOT_AVAILABLE = "N/A";
	private final String EMPTY = "";
	private Adapter adapter;
	private ESetting setting;
	private String notesString = "";

	private static String INFINITY = "\u221E";

	public SettingPropertySection() {

	}

	@Override
	public void createControls(Composite parent,
			TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.setRemoveTabs(true);
		super.createControls(parent, tabbedPropertySheetPage);
	}

	private Composite mainComposite;
	private FormToolkit factory;
	private FormToolkit toolkit;
	private Composite content;
	private GridLayout gridLayout;
	private GridData gd;

	private class NotesObserver implements Observer
	{
		public void update(Observable o, Object arg)
		{
			String textFieldValue = notes.getTextValue();
			if (!notesString.equals(textFieldValue))
			{
				notesString = textFieldValue;
				setting.setNotes(textFieldValue);
				ConfmlEditor editor = (ConfmlEditor)getPart();
				editor.setDirty(true);
			}
		}
	}
	
	// private Composite topComposite;
	protected void createSpecificControls(Composite parent,
			TabbedPropertySheetPage tabbedPropertySheetPage) {
		parent.setLayoutData(new GridData(GridData.FILL_BOTH));

		factory = getWidgetFactory();
		factory.setBorderStyle(SWT.FLAT);

		toolkit = new FormToolkit(parent.getDisplay());
		control = toolkit.createSection(parent, Section.TITLE_BAR);
		content = toolkit.createComposite(control);
		control.setClient(content);
		content.setLayout(new GridLayout(1, false));

		// GridLayout and griddata for mainComposite
		gridLayout = new GridLayout(3, false);
		gridLayout.marginWidth = 0;
		gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = GridData.FILL;

		settingType = new StringFieldEditor(SWT.WRAP);
		settingType.setLabelText("Type: ");
		settingType.setEditable(false);

		absRef = new StringFieldEditor(SWT.WRAP);
		absRef.setLabelText("Reference: ");
		absRef.setEditable(false);

		
		required = new StringFieldEditor(SWT.WRAP);
		required.setLabelText("Required :");
		required.setEditable(false);
		
		relevant = new StringFieldEditor(SWT.WRAP);
		relevant.setLabelText("Relevant :");
		relevant.setEditable(false);
		
		constraint = new StringFieldEditor(SWT.WRAP);
		constraint.setLabelText("Constraint :");
		constraint.setEditable(false);
		
		property = new StringFieldEditor(SWT.WRAP);
		property.setLabelText("Property :");
		property.setEditable(false);
		
//		defaultValue = new StringFieldEditor(SWT.WRAP);
//		defaultValue.setLabelText("Original Value:");
//		defaultValue.setEditable(false);
		
		parentLayerValue = new TableFieldEditor(SWT.MULTI | SWT.FILL);
		parentLayerValue.setLabelText("\nPrevious Values:");
		parentLayerValue.setEditable(false);
		
		range = new StringFieldEditor(SWT.WRAP);
		range.setLabelText("Range:");
		range.setEditable(false);
		
		pattern = new StringFieldEditor(SWT.WRAP);
		pattern.setLabelText("Pattern:");
		pattern.setEditable(false);
		
		totalDigits = new StringFieldEditor(SWT.WRAP);
		totalDigits.setLabelText("Max. digits:");
		totalDigits.setEditable(false);
		
		length = new StringFieldEditor(SWT.WRAP);
		length.setLabelText("Length:");
		length.setEditable(false);

		notes = new StringFieldEditor(SWT.MULTI | SWT.WRAP | SWT.BORDER | SWT.V_SCROLL);
		notes.setLabelText("\nNotes:");
		notes.setEditable(true);
	}

	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		if (selection instanceof IStructuredSelection) {
			Object top = ((IStructuredSelection) selection).getFirstElement();
			if (top instanceof ESetting) {
				setting = (ESetting) top;
			} 
			else if (top instanceof ESimpleValue)
			{
				ESimpleValue simpleValue = (ESimpleValue)top;
				setting = simpleValue.getType();
			}
			else if (top instanceof EResourceValue)
			{
				EResourceValue resourceValue = (EResourceValue)top;
				setting = resourceValue.getType();
			}
			else
				setting = null;
		}
		//refresh();
	}

	
	@Override
	public void refresh() {
		if (setting != null) {
			setting.eAdapters().remove(adapter);
		}

		// dispose properties of the older selection
		if (mainComposite != null)
			mainComposite.dispose();

		mainComposite = toolkit.createComposite(content);
		mainComposite.setLayout(gridLayout);
		mainComposite.setLayoutData(gd);

		IStructuredSelection selection = (IStructuredSelection) getSelection();
		Object firstElement = null;
		
		if (selection != null) {
			firstElement = selection.getFirstElement();
			if (firstElement instanceof ESetting)
				setting = (ESetting) firstElement;
			else if (firstElement instanceof ESimpleValue)
			{
				ESimpleValue simpleValue = (ESimpleValue)firstElement;
				setting = simpleValue.getType();
			}
			else if (firstElement instanceof EResourceValue)
			{
				EResourceValue resourceValue = (EResourceValue)firstElement;
				setting = resourceValue.getType();
			}
		}
		
		if (setting != null)	
		{	
			ESettingValueType type = null;
			if (setting.getName() != null)
				control.setText(setting.getName());

			// common properties for all types of settings
			if (getTextWithoutSpecialChars(setting.getDescriptionText()) != null) {
				
				settingDescription = new StringFieldEditor( SWT.WRAP | SWT.MULTI);
				settingDescription.setLabelText("Description: ");
				settingDescription.setEditable(false);
				
				settingDescription.fillIntoGrid(mainComposite, 3, factory);
//				LayoutUtil.setHorizontalSpan(settingDescription
//						.getTextControl(), 3);
				settingDescription
						.setTextValue(getTextWithoutSpecialChars(setting
								.getDescriptionText()));
				//settingDescription.setLabelText(EMPTY);
			} else {
				
				settingDescription = new StringFieldEditor(SWT.WRAP);
				settingDescription.setLabelText("Description: ");
				settingDescription.setEditable(false);
				
				settingDescription.setLabelText("Description: ");
				settingDescription.setTextValue(NOT_AVAILABLE);
				settingDescription.fillIntoGrid(mainComposite, 3, factory);
			}

			settingType.fillIntoGrid(mainComposite, 3, factory);
			
			absRef.fillIntoGrid(mainComposite, 3, factory);
			
			if (setting.isRequired()) {
				required.setTextValue("Yes");
				required.fillIntoGrid(mainComposite, 3, factory);
			}

			if (setting.getRelevant()!= null && !setting.getRelevant().trim().equals("")) {
				relevant.setTextValue(setting.getRelevant());
				relevant.fillIntoGrid(mainComposite, 3, factory);
			}
			
			if (setting.getConstraint()!= null && !setting.getConstraint().trim().equals("")) {
				constraint.setTextValue(setting.getConstraint());
				constraint.fillIntoGrid(mainComposite, 3, factory);
			}
			
			if (setting.getProperties() != null && setting.getProperties().size()>0) {
				
				StringBuffer propertyString = new StringBuffer();
				
				for (EProperty prop : setting.getProperties())
				{
					String pName = prop.getName();
					String pValue = prop.getValue();
					String pUnit = prop.getUnit();
					propertyString.append(pName+": "+pValue+" "+pUnit+"\n");
					
				}
				property.setTextValue(propertyString.toString());
				property.fillIntoGrid(mainComposite, 3, factory);
			}
			
			absRef.setTextValue(setting.getRef());
			
			ESimpleSetting simpleSet = null;
			if (setting instanceof ESimpleSetting) {
				simpleSet = (ESimpleSetting) setting;
				type = simpleSet.getType();
				
				if (type != null && type.getName() != null)
				{
					settingType.setTextValue(type.getName());
					
				}

				ConfmlEditor editor = (ConfmlEditor)this.getPart();
				IEditorInput ei = editor.getEditorInput();
				if (ei instanceof URIEditorInput)
				{
					URIEditorInput uriei = (URIEditorInput)ei;
					List<String[]> previousValues = editor.getPreviousSettingValues(uriei.getURI(), setting);
					if (previousValues != null)
					{
						parentLayerValue.fillIntoGrid(mainComposite, 10, factory, previousValues.size());
						parentLayerValue.setTextValue(previousValues, control);
					}
				}
				else
				{
//					defaultValue.setTextValue(NOT_AVAILABLE);
					//parentLayerValue.setTextValue(NOT_AVAILABLE);
				}

			}

			EResourceSetting fileSet = null;
			if (setting instanceof EResourceSetting) {
				fileSet = (EResourceSetting) setting;
				
				//ESettingValue targetPath = fileSet.getValue();
				
				if (fileSet.getKind() != null && fileSet.getKind().getName() != null)
				{
					settingType.setTextValue(fileSet.getKind().getName());
				}
				
				//defaultValue.setTextValue(getFileDefaultValue(fileSet));
				
				ConfmlEditor editor = (ConfmlEditor)this.getPart();
				IEditorInput ei = editor.getEditorInput();
				if (ei instanceof URIEditorInput)
				{
					URIEditorInput uriei = (URIEditorInput)ei;
					List<String[]> previousValues = editor.getPreviousSettingValues(uriei.getURI(), setting);
					if (previousValues != null)
					{
						parentLayerValue.fillIntoGrid(mainComposite, 10, factory, previousValues.size());
						parentLayerValue.setTextValue(previousValues, control);
					}
				}
			}
			
			ESequenceSetting seqenceSet = null;
			if (setting instanceof ESequenceSetting) {
				seqenceSet = (ESequenceSetting) setting;
				
				settingType.setTextValue("SEQUENCE");
				buildSequenceUI(seqenceSet);
//				defaultValue.setTextValue(NOT_AVAILABLE);
			}

			if (type == null)
			{
				//(buildSequenceUI(seqenceSet);
			}
			else
			{
				switch (type.getValue()) {
				case ESettingValueType.INTEGER_VALUE:
					buildIntUI(simpleSet);
					break;
	
				case ESettingValueType.BOOLEAN_VALUE:
					buildBooleanUI(simpleSet);
					break;
	
				case ESettingValueType.DECIMAL_VALUE:
					buildRealUI(simpleSet);
					break;
	
				case ESettingValueType.STRING_VALUE:
					buildStringUI(simpleSet);
					break;
	
	//			case ESettingValueType.FILE_VALUE:
	//				buildFileUI(fileSet);
	//				break;
	//
	//			case ESettingValueType.FOLDER_VALUE:
	//				buildFileUI(fileSet);
	//				break;

	
//				case ESettingValueType.SELECTION_VALUE:
//					buildSelectionUI(simpleSet);
//					break;
	
	//			case ESettingValueType.MULTISELECTION_VALUE:
	//				buildMultiSelectionUI(simpleSet);
	//				break;
	
				default:
					buildIntUI(simpleSet);
					break;
				}
			}
			
			//implementation part:
			EObject impl = null;
			if (setting.eContainer() instanceof EFeature)
			{
				EFeature feature = (EFeature)setting.eContainer();
				String featureRef = feature.getRef();
				impl = SettingImplementationCollector.getImplementation(featureRef+"/"+setting.getRef());
				if (impl == null)
					impl = SettingImplementationCollector.getImplementation(featureRef+"/*");
			}
			else if (setting.eContainer() instanceof ESequenceSetting)
			{
				ESequenceSetting seqSet = (ESequenceSetting)setting.eContainer();
				
				EExtensionPolicy policy = ((ESequenceValue)seqSet.getValue()).getExtensionPolicy();
				
				int index = 0;
				
				if (policy.equals(EExtensionPolicy.APPEND))
					index = getSeqIndexAppend(seqSet, firstElement);
				if (policy.equals(EExtensionPolicy.PREFIX))
					index = getSeqIndexPrefix(seqSet, firstElement);
				if (policy.equals(EExtensionPolicy.REPLACE))
					index = getSeqIndexReplace(seqSet, firstElement);
				
				EFeature feature = (EFeature)seqSet.eContainer();
				String framePrefix = "@"+index+"/";
				String absRef = feature.getRef()+"/"+seqSet.getRef();
				
				impl = SettingImplementationCollector.getImplementation(framePrefix+absRef+"/"+setting.getRef());
				if (impl == null)
					impl = SettingImplementationCollector.getImplementation(absRef);
				if (impl == null)
					impl = SettingImplementationCollector.getImplementation(feature.getRef()+"/*");
			}

			if (impl != null)
			{
				StringFieldEditor implementation = new StringFieldEditor(SWT.WRAP | SWT.BOLD);
				implementation.setLabelText("\nImplementation:");
				implementation.setEditable(false);
				implementation.fillIntoGrid(mainComposite, 3, factory);
				
				if (impl instanceof EKey)
				{
					EKey key = (EKey)impl;
					doImplKey(key);
				}
				else if (impl instanceof EBit)
				{
					EBit bit = (EBit)impl;
					EKey key = (EKey)bit.eContainer();
					doImplBitmaskKey(key, bit);
				}
				else if (impl instanceof EKeyRange)
				{
					EKeyRange keyRange = (EKeyRange)impl;
					doImplKeyRange(keyRange);
				}
				else if (impl instanceof EFile) //gcfml file
				{
					EFile gcfmlFile = (EFile)impl;
					doImplGcfml(gcfmlFile);
				}
			}
			
		}

		
		notes.fillIntoGrid(mainComposite, 10,8, factory);
		if (setting.getNotes()!=null)
			notesString = setting.getNotes();
		else
			notesString = "";
		notes.setTextValue(notesString);
		notes.addObserver(new NotesObserver());
		
		control.getParent().getParent().layout(true, true);
		super.refresh();
	}

	
	private int getSeqIndexAppend(ESequenceSetting seqSet, Object element)
	{
		int index = 0;
		EList<ESequenceValueItem> defaultItems = ((ESequenceValue)seqSet.getDefaultValue()).getItems();
		
		boolean found = false;
		
		for (int i = 0 ; i < defaultItems.size() ; i++)
		{
			
			for (ESettingValue setVal : defaultItems.get(i).getSubSettings())
			{
				if (setVal.equals(element))
				{
					found = true;
					break;
				}
			}
			if (found)
				break;
			index++;
		}
		
		if (!found)
		{
			EList<ESequenceValueItem> items = ((ESequenceValue)seqSet.getValue()).getItems();
			for (int i = 0 ; i < items.size() ; i++)
			{
			
				for (ESettingValue setVal : items.get(i).getSubSettings())
				{
					if (setVal.equals(element))
					{
						found = true;
						break;
					}
				}
				if (found)
					break;
				index++;
			}
			if (!found)
			{
				//System.out.println("NOT FOUND");
			}
		}
		return index;
	}
	private int getSeqIndexPrefix(ESequenceSetting seqSet, Object element)
	{
		int index = 0;
		EList<ESequenceValueItem> defaultItems = ((ESequenceValue)seqSet.getValue()).getItems();
		
		boolean found = false;
		
		for (int i = 0 ; i < defaultItems.size() ; i++)
		{
			
			for (ESettingValue setVal : defaultItems.get(i).getSubSettings())
			{
				if (setVal.equals(element))
				{
					found = true;
					break;
				}
			}
			if (found)
				break;
			index++;
		}
		
		if (!found)
		{
			EList<ESequenceValueItem> items = ((ESequenceValue)seqSet.getDefaultValue()).getItems();
			for (int i = 0 ; i < items.size() ; i++)
			{
			
				for (ESettingValue setVal : items.get(i).getSubSettings())
				{
					if (setVal.equals(element))
					{
						found = true;
						break;
					}
				}
				if (found)
					break;
				index++;
			}
			if (!found)
			{
				//System.out.println("NOT FOUND");
			}
		}
		return index;
	}
	
	private int getSeqIndexReplace(ESequenceSetting seqSet, Object element)
	{
		int index = 0;
		EList<ESequenceValueItem> defaultItems = ((ESequenceValue)seqSet.getValue()).getItems();
		
		boolean found = false;
		
		for (int i = 0 ; i < defaultItems.size() ; i++)
		{
			
			for (ESettingValue setVal : defaultItems.get(i).getSubSettings())
			{
				if (setVal.equals(element))
				{
					found = true;
					break;
				}
			}
			if (found)
				break;
			index++;
		}
	
		return index;
	}
	
	private String getTextWithoutSpecialChars(String input) {
		String result = input;
		if (input != null) {
			result = result.replaceAll("[' ']+", " ");
			result = result.replaceAll("\t+", "");
			result = result.replaceAll("\r", "");
			result = result.replaceAll("\n+", "\n");
			result = result.replaceAll("\n ", "\n");
			return result;
		} else
			return null;
	}

//	private String getFileDefaultValue(FileSystemEntrySetting fileSet) {
//		String defaultResult = NOT_AVAILABLE;
//		String defaultSourcePath = fileSet.getDefaultSourcePath();
//		String defaultTargetPath = fileSet.getDefaultTargetPath();
//		if (defaultSourcePath != null && defaultTargetPath != null) {
//			defaultResult = (!fileSet.isSourcePathReadOnly() ? ("Source path:  "
//					+ defaultSourcePath + "\n") : "")
//					+ (!fileSet.isTargetPathReadOnly() ? ("Target path:  " + defaultTargetPath)
//							: "");
//			return defaultResult;
//		}
//		if (defaultTargetPath != null && !fileSet.isTargetPathReadOnly()) {
//			defaultResult = "Target path:  " + defaultTargetPath;
//		}
//		if (defaultSourcePath != null && !fileSet.isSourcePathReadOnly()) {
//			defaultResult = "Source path:  " + defaultSourcePath;
//		}
//		return defaultResult;
//	}

	private void buildIntUI(ESimpleSetting simpleSet) {
		String range2 = getRange(simpleSet);
		if (!range2.equals(NOT_AVAILABLE)) {
			range.fillIntoGrid(mainComposite, 3, factory);
			range.setTextValue(range2);
		}
		String pattern2 = getPattern(simpleSet);
		if (!pattern2.equals(EMPTY)) {
			pattern.setTextValue(pattern2);
			pattern.fillIntoGrid(mainComposite, 3, factory);
		}
		String totalDigits2 = getTotalDigits(simpleSet);
		if (!totalDigits2.equals(NOT_AVAILABLE)) {
			totalDigits.setTextValue(totalDigits2);
			totalDigits.fillIntoGrid(mainComposite, 3, factory);
		}

	}

	private void buildBooleanUI(ESimpleSetting simpleSet) {
		String pattern2 = getPattern(simpleSet);
		if (!pattern2.equals(EMPTY)) {
			pattern.setTextValue(pattern2);
			pattern.fillIntoGrid(mainComposite, 3, factory);
		}
	}

	private void buildRealUI(ESimpleSetting simpleSet) {
		String range2 = getRange(simpleSet);
		if (!range2.equals(NOT_AVAILABLE)) {
			range.fillIntoGrid(mainComposite, 3, factory);
			range.setTextValue(range2);
		}
		String pattern2 = getPattern(simpleSet);
		if (!pattern2.equals(EMPTY)) {
			pattern.setTextValue(pattern2);
			pattern.fillIntoGrid(mainComposite, 3, factory);
		}
	}

	private void buildStringUI(ESimpleSetting simpleSet) {
		String length2 = getLength(simpleSet);
		if (!length2.equals(NOT_AVAILABLE)) {
			length.fillIntoGrid(mainComposite, 3, factory);
			length.setTextValue(length2);
		}
		String pattern2 = getPattern(simpleSet);
		if (!pattern2.equals(EMPTY)) {
			pattern.setTextValue(pattern2);
			pattern.fillIntoGrid(mainComposite, 3, factory);
		}
	}

	// File or Folder
//	private void buildFileUI(FileSystemEntrySetting fileSet) {
//		String pattern2 = getPattern(fileSet);
//		if (!pattern2.equals(EMPTY)) {
//			pattern.setTextValue(pattern2);
//			pattern.fillIntoGrid(mainComposite, 3, factory);
//		}
//	}

	private void buildSequenceUI(ESequenceSetting sequenceSet) {
		String range2 = getRange(sequenceSet);
		if (!range2.equals(NOT_AVAILABLE)) {
			range.fillIntoGrid(mainComposite, 3, factory);
			range.setTextValue(range2);
		}
	}

//	private void buildSelectionUI(ESimpleSetting simpleSet) {
//		String defaultValue = ((ESimpleValue)simpleSet.getDefaultValue()).getValue();
//		if (defaultValue != null) {
//			EList<ESettingOption> options = simpleSet.getOptions();
//			for (ESettingOption option : options) {
//				if (((EOption)option).getValue().equals(defaultValue)) {
//					defaultValue = ((EOption)option).getName();
//					break;
//				}
//			}
//			this.defaultValue.setTextValue(defaultValue);
//		}
//	}

//	private void buildMultiSelectionUI(ESimpleSetting simpleSet) {
//		String defaultValue = simpleSet.getDefaultValue();
//
//		if (defaultValue != null) {
//			this.defaultValue.setTextValue(SettingValueUtils
//					.getValueConvertedToOptionNames(defaultValue, simpleSet
//							.getOption()));
//		}
//	}

	

	private String getRange(ESequenceSetting seqSetting) {
		String result = NOT_AVAILABLE;
		
		int minOccurs = -1;
		int maxOccurs = -1;
		
		if (seqSetting.getMinOccurs() != null)
			minOccurs = seqSetting.getMinOccurs().intValue();
		if (seqSetting.getMaxOccurs() != null)
			maxOccurs = seqSetting.getMaxOccurs().intValue();

		if (minOccurs <= 0 && maxOccurs <= 0)
			result = NOT_AVAILABLE;
		if (minOccurs <= 0 && maxOccurs > 0) {
			result = "max. " + maxOccurs;
			if (maxOccurs == 1)
				result = result + " sequence item";
			else
				result = result + " sequence items";
		}
		if (minOccurs > 0 && maxOccurs <= 0) {
			result = "min. " + minOccurs;
			if (minOccurs == 1)
				result = result + " sequence item";
			else
				result = result + " sequence items";
		}
		if (minOccurs > 0 && maxOccurs > 0) {
			result = minOccurs + " - " + maxOccurs + " sequence items";
		}
		return result;
	}

	private String getLength(ESimpleSetting simpleSetting) {
		String length = NOT_AVAILABLE;
		if (simpleSetting.getLength() != null && simpleSetting.getLength().intValue() != -1) {
			return String.valueOf(simpleSetting.getLength());
		}

		Integer minLength = simpleSetting.getMinLength();
		Integer maxLength = simpleSetting.getMaxLength();

		if (minLength != null && minLength.intValue() != -1) {
			if (minLength.intValue() == 1)
				length = "min. " + minLength.intValue() + " char";
			length = "min. " + minLength.intValue() + " characters";
		}

		if (maxLength != null && maxLength.intValue() != -1) {
			if (minLength != null && minLength.intValue() != -1)
				length = length + ", " + "max. " + maxLength.intValue()
						+ " characters";
			else
				length = "max. " + maxLength.intValue() + " characters";
			if (maxLength.intValue() == 1)
				length = "max. " + maxLength.intValue() + " char";
		}

		return length;
	}

	/**
	 * Return range according to the type of setting
	 * 
	 * @param simpleSetting
	 * @return
	 */

	
	private String getRange(ESimpleSetting simpleSetting) {
		String visibleRange = NOT_AVAILABLE;
		ESettingValueType settingType = simpleSetting.getType();

		if (settingType.getValue()==ESettingValueType.INTEGER_VALUE) {
			String minInclusive = simpleSetting.getMinInclusive();
			String maxInclusive = simpleSetting.getMaxInclusive();
			String minExclusive = simpleSetting.getMinExclusive();
			String maxExclusive = simpleSetting.getMaxExclusive();

			BigDecimal min = new BigDecimal(Integer.MIN_VALUE);
			BigDecimal max = new BigDecimal(Integer.MAX_VALUE);
			String minMark = EMPTY;
			String maxMark = EMPTY;

			if (minExclusive != null) {
				min = new BigDecimal(minExclusive);
				minMark = "(";
			}

			if (minInclusive != null) {
				min = new BigDecimal(minInclusive);
				if (minMark.contains("("))
					minMark.replace("(", "[");
				else
					minMark = "[";
			}

			if (maxExclusive != null) {
				max = new BigDecimal(maxExclusive);
				maxMark = ")";
			}

			if (maxInclusive != null) {
				max = new BigDecimal(maxInclusive);
				if (maxMark.contains(")"))
					maxMark.replace(")", "]");
				else
					maxMark = "]";
			}

			if (!EMPTY.equals(minMark) || !EMPTY.equals(maxMark)) {
				if (Integer.MIN_VALUE == min.intValue()
						&& Integer.MAX_VALUE != max.intValue())
					visibleRange = "(-" + INFINITY + "; " + max + maxMark;

				if (Integer.MIN_VALUE != min.intValue()
						&& Integer.MAX_VALUE == max.intValue())
					visibleRange = minMark + min + "; " + INFINITY + ")";

				if (Integer.MIN_VALUE != min.intValue()
						&& Integer.MAX_VALUE != max.intValue())
					visibleRange = minMark + min + "; " + max + maxMark;
			}

			return visibleRange;
		}

		if (settingType.getValue()==ESettingValueType.DECIMAL_VALUE) {
			String minInclusive = simpleSetting.getMinInclusive();
			String maxInclusive = simpleSetting.getMaxInclusive();
			String minExclusive = simpleSetting.getMinExclusive();
			String maxExclusive = simpleSetting.getMaxExclusive();

			BigDecimal min = new BigDecimal(Long.MIN_VALUE);
			BigDecimal max = new BigDecimal(Long.MAX_VALUE);
			String minMark = EMPTY;
			String maxMark = EMPTY;

			if (minExclusive != null) {
				min = new BigDecimal(minExclusive);
				minMark = "(";
			}

			if (minInclusive != null) {
				min = new BigDecimal(minInclusive);
				if (minMark.contains("("))
					minMark.replace("(", "[");
				else
					minMark = "[";
			}

			if (maxExclusive != null) {
				max = new BigDecimal(maxExclusive);
				maxMark = ")";
			}

			if (maxInclusive != null) {
				max = new BigDecimal(maxInclusive);
				if (maxMark.contains(")"))
					maxMark.replace(")", "]");
				else
					maxMark = "]";
			}

			if (!EMPTY.equals(minMark) || !EMPTY.equals(maxMark)) {
				if (Long.MIN_VALUE == min.longValue()
						&& Long.MAX_VALUE != max.longValue())
					visibleRange = "(-" + INFINITY + "; " + max + maxMark;

				if (Long.MIN_VALUE != min.longValue()
						&& Long.MAX_VALUE == max.longValue())
					visibleRange = minMark + min + "; " + INFINITY + ")";

				if (Long.MIN_VALUE != min.longValue()
						&& Long.MAX_VALUE != max.longValue())
					visibleRange = minMark + min + "; " + max + maxMark;
			}

			return visibleRange;
		}

		return visibleRange;
	}

	private String getTotalDigits(ESimpleSetting simpleSetting) {
		Integer totalDigits2 = simpleSetting.getTotalDigits();
		if (totalDigits2==null || totalDigits2.intValue() == -1)
			return NOT_AVAILABLE;

		return String.valueOf(totalDigits2.intValue());
	}

	private String getPattern(ESimpleSetting simpleSetting) {
		StringBuffer sb = new StringBuffer();
		for (String pattern : simpleSetting.getPattern())
		{
			sb.append(pattern+"\n");
		}
		return sb.toString();
	}

	private String getPattern(EResourceSetting fileSetting) {
		// miss in the model
		return EMPTY;
	}

	// private String maskNull(String value) {
	// if (value == null) {
	// return NOT_AVAILABLE;
	// }
	// return value;
	// }

	@Override
	public void dispose() {
		if (control != null) {
			control.dispose();
		}
		super.dispose();
	}

	private void doImplKey(EKey key)
	{
		StringFieldEditor cenrepKey = new StringFieldEditor(SWT.WRAP);
		cenrepKey.setLabelText("Simple Key: ");
		cenrepKey.setEditable(false);
		
		StringFieldEditor cenrepKeyType = new StringFieldEditor(SWT.WRAP);
		cenrepKeyType.setLabelText("Key Type: ");
		cenrepKeyType.setEditable(false);
		
		StringFieldEditor cenrepKeyUid = new StringFieldEditor(SWT.WRAP);
		cenrepKeyUid.setLabelText("Key Uid: ");
		cenrepKeyUid.setEditable(false);
		
		StringFieldEditor cenrepFile = new StringFieldEditor(SWT.WRAP);
		cenrepFile.setLabelText("CenRep File: ");
		cenrepFile.setEditable(false);
		
		StringFieldEditor cenrepUidValue = new StringFieldEditor(SWT.WRAP);
		cenrepUidValue.setLabelText("CenRep Uid Value: ");
		cenrepUidValue.setEditable(false);
		
		StringFieldEditor cenrepUidName = new StringFieldEditor(SWT.WRAP);
		cenrepUidName.setLabelText("CenRep Uid Name: ");
		cenrepUidName.setEditable(false);
	
		ECRMLDocumentRoot crml = null;
		if (key.eContainer() instanceof ERepository)
		{
			crml = (ECRMLDocumentRoot)key.eContainer().eContainer();
			//crml = (ECRMLDocumentRoot)key.eContainer().eContainer().eContainer();
		}
		else
		{
			ESequenceSetting seqSet = (ESequenceSetting)setting.eContainer();
			EFeature feature = (EFeature)seqSet.eContainer();
			String ref = feature.getRef()+"/"+seqSet.getRef();
			EKeyRange keyRange = (EKeyRange)SettingImplementationCollector.getImplementation(ref);
			crml = (ECRMLDocumentRoot)keyRange.eContainer().eContainer();
		}
		String uriString = crml.eResource().getURI().toPlatformString(true);
		
		cenrepFile.fillIntoGrid(mainComposite, 3, factory);
		cenrepFile.setTextValue(uriString);
		
		cenrepUidValue.fillIntoGrid(mainComposite, 3, factory);
		String uidValue = crml.getRepository().getUidValue();
		if (uidValue!=null)
			cenrepUidValue.setTextValue(uidValue);
		else
			cenrepUidValue.setTextValue(NOT_AVAILABLE);
		
		cenrepUidName.fillIntoGrid(mainComposite, 3, factory);
		String uidName = crml.getRepository().getUidName();
		if (uidName!=null)
			cenrepUidName.setTextValue(uidName);
		else
			cenrepUidName.setTextValue(NOT_AVAILABLE);

		cenrepKey.fillIntoGrid(mainComposite, 3, factory);
		cenrepKey.setTextValue(key.getName()+" ("+key.getRef()+")");
		
		cenrepKeyUid.fillIntoGrid(mainComposite, 3, factory);
		String cenrepkeyId = key.getIdent();
		if (cenrepkeyId != null)
			cenrepKeyUid.setTextValue(cenrepkeyId);
		else
			cenrepKeyUid.setTextValue(NOT_AVAILABLE);
		
		cenrepKeyType.fillIntoGrid(mainComposite, 3, factory);
		if (key.getType() != null)
			cenrepKeyType.setTextValue(key.getType().getName());
		else
			cenrepKeyType.setTextValue(NOT_AVAILABLE);
		
	}
	
	private void doImplBitmaskKey(EKey key, EBit bit)
	{
		StringFieldEditor cenrepKey = new StringFieldEditor(SWT.WRAP);
		cenrepKey.setLabelText("Bitmask Key: ");
		cenrepKey.setEditable(false);
		
		StringFieldEditor cenrepKeyType = new StringFieldEditor(SWT.WRAP);
		cenrepKeyType.setLabelText("Key Type: ");
		cenrepKeyType.setEditable(false);
		
		StringFieldEditor cenrepFile = new StringFieldEditor(SWT.WRAP);
		cenrepFile.setLabelText("CenRep File: ");
		cenrepFile.setEditable(false);
		
		StringFieldEditor cenrepUidValue = new StringFieldEditor(SWT.WRAP);
		cenrepUidValue.setLabelText("CenRep Uid Value: ");
		cenrepUidValue.setEditable(false);
		
		StringFieldEditor cenrepUidName = new StringFieldEditor(SWT.WRAP);
		cenrepUidName.setLabelText("CenRep Uid Name: ");
		cenrepUidName.setEditable(false);
	
		StringFieldEditor cenrepKeyBitNumber = new StringFieldEditor(SWT.WRAP);
		cenrepKeyBitNumber.setLabelText("Bit Number: ");
		cenrepKeyBitNumber.setEditable(false);
		
	
		ECRMLDocumentRoot crml = (ECRMLDocumentRoot)key.eContainer().eContainer();
		String uriString = crml.eResource().getURI().toPlatformString(true);
		
		cenrepFile.fillIntoGrid(mainComposite, 3, factory);
		cenrepFile.setTextValue(uriString);
		
		cenrepUidValue.fillIntoGrid(mainComposite, 3, factory);
		String uidValue = crml.getRepository().getUidValue();
		if (uidValue!=null)
			cenrepUidValue.setTextValue(uidValue);
		else
			cenrepUidValue.setTextValue(NOT_AVAILABLE);
		
		cenrepUidName.fillIntoGrid(mainComposite, 3, factory);
		String uidName = crml.getRepository().getUidName();
		if (uidName!=null)
			cenrepUidName.setTextValue(uidName);
		else
			cenrepUidName.setTextValue(NOT_AVAILABLE);

		cenrepKey.fillIntoGrid(mainComposite, 3, factory);
		cenrepKey.setTextValue(key.getName()+" ("+bit.getRef()+")");
		
		cenrepKeyBitNumber.fillIntoGrid(mainComposite, 3, factory);
		
		int bitIndex = key.getBits().indexOf(bit);
		
		cenrepKeyBitNumber.setTextValue(bitIndex+"");
		
		cenrepKeyType.fillIntoGrid(mainComposite, 3, factory);
		if (key.getType() != null)
			cenrepKeyType.setTextValue(key.getType().getName());
		else
			cenrepKeyType.setTextValue(NOT_AVAILABLE);
		
	}
	
	private void doImplGcfml(EFile gcfmlFile)
	{
		
		StringFieldEditor gcfmlFileLocation = new StringFieldEditor(SWT.WRAP);
		gcfmlFileLocation.setLabelText("GenConfml File: ");
		gcfmlFileLocation.setEditable(false);
		gcfmlFileLocation.fillIntoGrid(mainComposite, 3, factory);
		String fileLocation = gcfmlFile.getLocation();
		if (fileLocation!=null)
			gcfmlFileLocation.setTextValue(fileLocation);
		else
			gcfmlFileLocation.setTextValue(NOT_AVAILABLE);
		
		StringFieldEditor name = new StringFieldEditor(SWT.WRAP);
		name.setLabelText("Name: ");
		name.setEditable(false);
		name.fillIntoGrid(mainComposite, 3, factory);
		String fileName = gcfmlFile.getName();
		if (fileName!=null)
			name.setTextValue(fileName);
		else
			name.setTextValue(NOT_AVAILABLE);
		
		String target = gcfmlFile.getTarget();
		StringFieldEditor gcfmlTarget = new StringFieldEditor(SWT.WRAP);
		gcfmlTarget.setLabelText("Target: ");
		gcfmlTarget.setEditable(false);
		gcfmlTarget.fillIntoGrid(mainComposite, 3, factory);
		if (target!=null)
			gcfmlTarget.setTextValue(target);
		else
			gcfmlTarget.setTextValue(NOT_AVAILABLE);
		
	}
	
	private void doImplKeyRange(EKeyRange keyRange)
	{
		
		StringFieldEditor keyRangeFirstInt = new StringFieldEditor(SWT.WRAP);
		keyRangeFirstInt.setLabelText("First Int: ");
		keyRangeFirstInt.setEditable(false);
		
		StringFieldEditor keyRangeLastInt = new StringFieldEditor(SWT.WRAP);
		keyRangeLastInt.setLabelText("Last Int: ");
		keyRangeLastInt.setEditable(false);
		
		StringFieldEditor keyRangeFirstIndex = new StringFieldEditor(SWT.WRAP);
		keyRangeFirstIndex.setLabelText("First Index: ");
		keyRangeFirstIndex.setEditable(false);
		
		StringFieldEditor keyRangeIndexBits = new StringFieldEditor(SWT.WRAP);
		keyRangeIndexBits.setLabelText("Index Bits: ");
		keyRangeIndexBits.setEditable(false);

		StringFieldEditor cenrepFile = new StringFieldEditor(SWT.WRAP);
		cenrepFile.setLabelText("CenRep File: ");
		cenrepFile.setEditable(false);
		
		StringFieldEditor cenrepUidValue = new StringFieldEditor(SWT.WRAP);
		cenrepUidValue.setLabelText("CenRep Uid Value: ");
		cenrepUidValue.setEditable(false);
		
		StringFieldEditor cenrepUidName = new StringFieldEditor(SWT.WRAP);
		cenrepUidName.setLabelText("CenRep Uid Name: ");
		cenrepUidName.setEditable(false);
	
		ECRMLDocumentRoot crml = (ECRMLDocumentRoot)keyRange.eContainer().eContainer();
		
		String uriString = crml.eResource().getURI().toPlatformString(true);
		
		cenrepFile.fillIntoGrid(mainComposite, 3, factory);
		cenrepFile.setTextValue(uriString);
		
		cenrepUidValue.fillIntoGrid(mainComposite, 3, factory);
		String uidValue = crml.getRepository().getUidValue();
		if (uidValue!=null)
			cenrepUidValue.setTextValue(uidValue);
		else
			cenrepUidValue.setTextValue(NOT_AVAILABLE);
		
		cenrepUidName.fillIntoGrid(mainComposite, 3, factory);
		String uidName = crml.getRepository().getUidName();
		if (uidName!=null)
			cenrepUidName.setTextValue(uidName);
		else
			cenrepUidName.setTextValue(NOT_AVAILABLE);

		keyRangeFirstInt.fillIntoGrid(mainComposite, 3, factory);
		keyRangeFirstInt.setTextValue(keyRange.getFirstInt());
		
		keyRangeLastInt.fillIntoGrid(mainComposite, 3, factory);
		keyRangeLastInt.setTextValue(keyRange.getLastInt());
		
		keyRangeIndexBits.fillIntoGrid(mainComposite, 3, factory);
		keyRangeIndexBits.setTextValue(keyRange.getIndexBits());
		
		keyRangeFirstIndex.fillIntoGrid(mainComposite, 3, factory);
		keyRangeFirstIndex.setTextValue(keyRange.getFirstIndex());
		
	}
}
