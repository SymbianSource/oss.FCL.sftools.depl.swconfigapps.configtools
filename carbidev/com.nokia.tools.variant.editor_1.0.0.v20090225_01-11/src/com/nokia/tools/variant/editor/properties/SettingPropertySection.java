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

package com.nokia.tools.variant.editor.properties;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.xml.datatype.DatatypeConstants;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.xml.type.internal.XMLCalendar;
import org.eclipse.emf.ecore.xml.type.internal.XMLDuration;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.nokia.tools.variant.common.ui.properties.AutoSizePropertySection;
import com.nokia.tools.variant.common.ui.properties.fields.ChangeableLabelFieldEditor;
import com.nokia.tools.variant.common.ui.properties.fields.StringFieldEditor;
import com.nokia.tools.variant.common.ui.wizards.dialogfields.LayoutUtil;
import com.nokia.tools.variant.content.confml.ConfmlPackage;
import com.nokia.tools.variant.content.confml.FilePath;
import com.nokia.tools.variant.content.confml.FileSystemEntrySetting;
import com.nokia.tools.variant.content.confml.MaxExclusive;
import com.nokia.tools.variant.content.confml.MaxInclusive;
import com.nokia.tools.variant.content.confml.MinExclusive;
import com.nokia.tools.variant.content.confml.MinInclusive;
import com.nokia.tools.variant.content.confml.Option;
import com.nokia.tools.variant.content.confml.Property;
import com.nokia.tools.variant.content.confml.SequenceSetting;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.SimpleSetting;
import com.nokia.tools.variant.content.confml.TYPE;
import com.nokia.tools.variant.content.confml.impl.OptionImpl;
import com.nokia.tools.variant.content.confml.impl.SequenceItemImpl;
import com.nokia.tools.variant.content.confml.util.SettingValueUtils;
import com.nokia.tools.variant.editor.actions.CopyAction;
import com.nokia.tools.variant.editor.actions.CutAction;
import com.nokia.tools.variant.editor.actions.DeleteAction;
import com.nokia.tools.variant.editor.actions.PasteAction;
import com.nokia.tools.variant.editor.editors.ConfMLExpressionSettingUtil;

/**
 * This class provides control from the Editor part for the properties view.
 * With first display of properties, the components are created. The UI is build
 * according to setting's type and according to existence of the property, the
 * property is displayed or not. Description and Default value are visible all
 * the time, when setting is selected in the editor.
 * 
 */
public class SettingPropertySection extends AutoSizePropertySection {

	private Composite control;
	private Section section;
	private Adapter adapter;
	private Setting setting;

	private static String INFINITY = "\u221E";
	private final String NOT_AVAILABLE = "N/A";
	private final String EMPTY = "";

	private static final int NUM_COLUMNS = 2;
	
	private CutAction cutAction;
	private CopyAction copyAction;
	private PasteAction pasteAction;
	private DeleteAction deleteAction;

	private ChangeableLabelFieldEditor settingDescription;
	private ChangeableLabelFieldEditor required;
	private ChangeableLabelFieldEditor defaultValue;
	private ChangeableLabelFieldEditor range;
	private ChangeableLabelFieldEditor pattern;
	private ChangeableLabelFieldEditor totalDigits;
	private ChangeableLabelFieldEditor length;
	private StringFieldEditor notes;
	private HyperlinkFieldEditor dependsOn;
	private HyperlinkFieldEditor dependencies;

	// file and graphic properties
	private ChangeableLabelFieldEditor type;
	private ChangeableLabelFieldEditor maxBits;
	private ChangeableLabelFieldEditor maxWidth;
	private ChangeableLabelFieldEditor maxHeight;
	private ChangeableLabelFieldEditor minWidth;
	private ChangeableLabelFieldEditor minHeight;
	private ChangeableLabelFieldEditor width;
	private ChangeableLabelFieldEditor height;
	private ChangeableLabelFieldEditor maxColor;

	private ChangeableLabelFieldEditor maxFileSize;
	private ChangeableLabelFieldEditor recommendedFileSize;

	// label constants for properties
	final String TYPE_LABEL = "Allowed type:";
	final String MAX_BITS_LABEL = "Max. bits:";
	final String MAX_WIDTH_LABEL = "Max. width:";
	final String MAX_HEIGHT_LABEL = "Max. height:";
	final String MIN_WIDTH_LABEL = "Min. width:";
	final String MIN_HEIGHT_LABEL = "Min. height:";
	final String WIDTH_LABEL = "Width:";
	final String HEIGHT_LABEL = "Height:";
	final String MAX_COLOR_LABEL = "Max. color:";

	final String MAX_FILE_SIZE_LABEL = "Max. file size:";
	final String RECOMMENDED_FILE_SIZE_LABEL = "Recommended file size:";

	private Composite mainComposite;
	private FormToolkit toolkit;
	
	// private Composite topComposite;
	protected void createSpecificControls(Composite parent,
			TabbedPropertySheetPage tabbedPropertySheetPage) {

		toolkit = new FormToolkit(parent.getDisplay());
		toolkit.setBorderStyle(SWT.NULL);
		control = toolkit.createComposite(parent);
		GridLayout layout = new GridLayout(1, false);
		layout.marginHeight = layout.marginWidth = 0;
		control.setLayout(layout);
		section = toolkit.createSection(control, Section.TITLE_BAR);
		section.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));	
	}
		
	private void createActions(Object control) {
		ViewPart findView = (ViewPart) PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().findView(
						"org.eclipse.ui.views.PropertySheet");

		cutAction = new CutAction(control);
		((CutAction) cutAction).init();
		findView.getViewSite().getActionBars().setGlobalActionHandler(
				ActionFactory.CUT.getId(), cutAction);

		copyAction = new CopyAction(control);
		((CopyAction) copyAction).init();
		findView.getViewSite().getActionBars().setGlobalActionHandler(
				ActionFactory.COPY.getId(), copyAction);

		pasteAction = new PasteAction(control);
		((PasteAction) pasteAction).init();
		findView.getViewSite().getActionBars().setGlobalActionHandler(
				ActionFactory.PASTE.getId(), pasteAction);

		deleteAction = new DeleteAction(control);
		((DeleteAction) deleteAction).init();
		findView.getViewSite().getActionBars().setGlobalActionHandler(
				ActionFactory.DELETE.getId(), deleteAction);
	}

	@Override
	protected void doRefresh() {
		if (setting != null) {
			if (setting instanceof FilePath) {
				((FilePath) setting).getParent().eAdapters().remove(adapter);
			} else {
				setting.eAdapters().remove(adapter);
			}
		}
		// dispose properties of the older selection
		if (mainComposite != null)
			mainComposite.dispose();

		settingDescription = new ChangeableLabelFieldEditor();
		settingDescription.setLabelText("Description: " + NOT_AVAILABLE);
		required = new ChangeableLabelFieldEditor(SWT.WRAP);
		required.setLabelText("Required value:");
		defaultValue = new ChangeableLabelFieldEditor(SWT.WRAP);
		defaultValue.setLabelText("Default Value:");
		range = new ChangeableLabelFieldEditor(SWT.WRAP);
		range.setLabelText("Range:");
		pattern = new ChangeableLabelFieldEditor(SWT.WRAP);
		pattern.setLabelText("Pattern:");
		totalDigits = new ChangeableLabelFieldEditor(SWT.WRAP);
		totalDigits.setLabelText("Max. digits:");
		length = new ChangeableLabelFieldEditor(SWT.WRAP);
		length.setLabelText("Length:");

		notes = new StringFieldEditor(SWT.MULTI | SWT.WRAP | SWT.BORDER
				| SWT.V_SCROLL);
		notes.setLabelText("Notes:");
		notes.setEditable(true);

		mainComposite = toolkit.createComposite(control);
		GridData gd = new GridData(SWT.FILL, SWT.TOP, true, false);
		gd.horizontalIndent = 5;
		mainComposite.setLayoutData(gd);
		GridLayout gridLayout = new GridLayout(NUM_COLUMNS, false);
		mainComposite.setLayout(gridLayout);

		IStructuredSelection selection = (IStructuredSelection) getSelection();
		Object firstElement = null;
		if (selection != null) {
			firstElement = selection.getFirstElement();
		}
		if (firstElement instanceof Setting) {
			setting = (Setting) firstElement;

			if (setting.getName() != null) {
				section.setText(setting.getName());
			} else {
				section.setText("");
			}

			// common properties for all types of settings
			if (getTextWithoutSpecialChars(setting.getDescription()) != null) {
				StyledText text = new StyledText(mainComposite, SWT.MULTI
						| SWT.WRAP | SWT.FLAT);
				text.setText(setting.getDescription());
				text.getCaret().setVisible(false);
				// toolkit.createText(mainComposite,
				// getTextWithoutSpecialChars(setting.getDescription()),
				// SWT.MULTI | SWT.WRAP | SWT.FLAT);
				text.setEditable(false);// description is not-editable field
				GridData textData = new GridData(SWT.FILL, SWT.TOP, true,
						false, NUM_COLUMNS, 1);
				text.setLayoutData(textData);
			} else {
				settingDescription.setLabelText("Description: ");
				settingDescription.setTextValue(NOT_AVAILABLE);
				settingDescription.fillIntoGrid(mainComposite, NUM_COLUMNS,
						toolkit);
			}

			defaultValue.fillIntoGrid(mainComposite, NUM_COLUMNS, toolkit);
			if (setting.isRequired()) {
				required.setTextValue("Yes");
				required.fillIntoGrid(mainComposite, NUM_COLUMNS, toolkit);
			}

			SimpleSetting simpleSet = null;
			if (setting instanceof SimpleSetting) {
				simpleSet = (SimpleSetting) setting;
				String defaultValue2 = simpleSet.getDefaultValue();

				if (defaultValue2 != null) {
					if (defaultValue2.contains(OptionImpl.OPTION_MAP_KEY)) {
						String defaultOptionValue = defaultValue2
								.substring(defaultValue2
										.indexOf(OptionImpl.OPTION_MAP_KEY)
										+ OptionImpl.OPTION_MAP_KEY.length());
						int i = defaultOptionValue.lastIndexOf("\"]");
						if (i >= 0) {
							defaultValue2 = defaultOptionValue.substring(0, i);
						}
					}
					if (simpleSet.getType().equals(TYPE.DURATION)
							&& defaultValue2 != "") {
						defaultValue
								.setTextValue(getParsedString(new XMLDuration(
										defaultValue2)));
					} else {
						defaultValue.setTextValue(defaultValue2);
					}
				} else
					defaultValue.setTextValue(NOT_AVAILABLE);

				if (TYPE.SIMPLE_FILE.equals(simpleSet.getType())) {
					EList<Property> properties = simpleSet.getProperty();
					for (Property property : properties) {
						displayFileProperty(property);
					}
				}

			}
			FileSystemEntrySetting fileSet = null;
			if (setting instanceof FilePath) {
				fileSet = (FileSystemEntrySetting) setting;
				defaultValue
						.setTextValue(getFileDefaultValue((FilePath) fileSet));

			} else if (setting instanceof FileSystemEntrySetting) {
				fileSet = (FileSystemEntrySetting) setting;
			}

			SequenceSetting seqenceSet = null;
			if (setting instanceof SequenceSetting) {
				seqenceSet = (SequenceSetting) setting;
				defaultValue.setTextValue(NOT_AVAILABLE);
			}

			TYPE settingType = setting.getType();

			switch (settingType) {
			case INT:
				buildIntUI(simpleSet);
				break;

			case BOOLEAN:
				buildBooleanUI(simpleSet);
				break;

			case REAL:
				buildRealUI(simpleSet);
				break;

			case STRING:
				buildStringUI(simpleSet);
				break;

			case FILESOURCE:
			case FILETARGET:
				buildFileUI(fileSet);
				break;

			case FOLDER:
				buildFileUI(fileSet);
				break;

			case SEQUENCE:
				buildSequenceUI(seqenceSet);
				break;

			case SELECTION:
				buildSelectionUI(simpleSet);
				break;

			case MULTISELECTION:
				buildMultiSelectionUI(simpleSet);
				break;

			default:
				buildIntUI(simpleSet);
				break;
			}
			if (!(setting.eContainer() instanceof SequenceItemImpl)) {
				addNoteField();
			}

			
			
			createDependencies(setting);
			
			if (setting instanceof FilePath) {
				if (setting.getType() == TYPE.FILESOURCE) {
					Setting parent = ((FilePath) setting).getParent();
					createDependencies(parent);
				}
			}
		}			
	}

	private String getTextWithoutSpecialChars(String input) {
		String result = input;
		if (input != null) {
			result = result.replaceAll("[' ']+", " ");
			result = result.replaceAll("\t+", "");
			result = result.replaceAll("\r", "");
			result = result.replaceAll("\n ", "\n");
			result = result.replaceAll("\n+", "\n");
			return result;
		} else
			return null;
	}

	private String getFileDefaultValue(FilePath fileSet) {
		FilePath sourceFilePath = fileSet.getParent().getSourceFilePath();
		FilePath targetFilePath = fileSet.getParent().getTargetFilePath();
		String defaultResult = NOT_AVAILABLE;
		String defaultSourcePath = sourceFilePath.getDefaultPath();
		String defaultTargetPath = targetFilePath.getDefaultPath();
		if (defaultSourcePath != null && defaultTargetPath != null) {
			defaultResult = (!sourceFilePath.isPathReadOnly() ? ("Source path:  "
					+ defaultSourcePath + "\n")
					: "")
					+ (!targetFilePath.isPathReadOnly() ? ("Target path:  " + defaultTargetPath)
							: "");
			return defaultResult;
		}
		if (defaultTargetPath != null && !targetFilePath.isPathReadOnly()) {
			defaultResult = "Target path:  " + defaultTargetPath;
		}
		if (defaultSourcePath != null && !sourceFilePath.isPathReadOnly()) {
			defaultResult = "Source path:  " + defaultSourcePath;
		}
		return defaultResult;
	}

	private void buildIntUI(SimpleSetting simpleSet) {
		String range2 = getRange(simpleSet);
		if (!range2.equals(NOT_AVAILABLE)) {
			range.fillIntoGrid(mainComposite, NUM_COLUMNS, toolkit);
			range.setTextValue(range2);
		}
		String pattern2 = getPattern(simpleSet);
		if (!pattern2.equals(EMPTY)) {
			pattern.setTextValue(pattern2);
			pattern.fillIntoGrid(mainComposite, NUM_COLUMNS, toolkit);
		}
		String totalDigits2 = getTotalDigits(simpleSet);
		if (!totalDigits2.equals(NOT_AVAILABLE)) {
			totalDigits.setTextValue(totalDigits2);
			totalDigits.fillIntoGrid(mainComposite, NUM_COLUMNS, toolkit);
		}

	}

	private void buildBooleanUI(SimpleSetting simpleSet) {
		String pattern2 = getPattern(simpleSet);
		if (!pattern2.equals(EMPTY)) {
			pattern.setTextValue(pattern2);
			pattern.fillIntoGrid(mainComposite, NUM_COLUMNS, toolkit);
		}
	}

	private void buildRealUI(SimpleSetting simpleSet) {
		String range2 = getRange(simpleSet);
		if (!range2.equals(NOT_AVAILABLE)) {
			range.fillIntoGrid(mainComposite, NUM_COLUMNS, toolkit);
			range.setTextValue(range2);
		}
		String pattern2 = getPattern(simpleSet);
		if (!pattern2.equals(EMPTY)) {
			pattern.setTextValue(pattern2);
			pattern.fillIntoGrid(mainComposite, NUM_COLUMNS, toolkit);
		}
	}

	private void buildStringUI(SimpleSetting simpleSet) {
		String length2 = getLength(simpleSet);
		if (!length2.equals(NOT_AVAILABLE)) {
			length.fillIntoGrid(mainComposite, NUM_COLUMNS, toolkit);
			length.setTextValue(length2);
		}
		String pattern2 = getPattern(simpleSet);
		if (!pattern2.equals(EMPTY)) {
			pattern.setTextValue(pattern2);
			pattern.fillIntoGrid(mainComposite, NUM_COLUMNS, toolkit);
		}
	}

	// File or Folder
	private void buildFileUI(Setting fileSet) {
		String pattern2 = getPattern(fileSet);
		if (!pattern2.equals(EMPTY)) {
			pattern.setTextValue(pattern2);
			pattern.fillIntoGrid(mainComposite, NUM_COLUMNS, toolkit);
		}
		EList<Property> properties = fileSet.getProperty();
		for (Property property : properties) {
			displayFileProperty(property);
		}
	}

	/**
	 * Display property for file elements. List of properties is available here
	 * - {@link FileProperty}.
	 * 
	 * @param property
	 */
	private void displayFileProperty(Property property) {
		String propertyName = property.getName();
		String propertyValue = property.getValue();
		String propertyUnit = property.getUnit();

		if (propertyName == null) {
			return;
		}

		if (propertyName.equals(FileProperty.TYPE_PROPERTY)) {
			type = new ChangeableLabelFieldEditor(SWT.WRAP);
			type.setLabelText(TYPE_LABEL);
			type.setTextValue(propertyValue);
			type.fillIntoGrid(mainComposite, NUM_COLUMNS, toolkit);

		} else if (propertyName.equals(FileProperty.MAX_BITS_PROPERTY)) {
			maxBits = new ChangeableLabelFieldEditor(SWT.WRAP);
			maxBits.setLabelText(MAX_BITS_LABEL);
			maxBits.setTextValue(propertyValue + " " + propertyUnit);
			maxBits.fillIntoGrid(mainComposite, NUM_COLUMNS, toolkit);

		} else if (propertyName.equals(FileProperty.MAX_WIDTH_PROPERTY)) {
			maxWidth = new ChangeableLabelFieldEditor(SWT.WRAP);
			maxWidth.setLabelText(MAX_WIDTH_LABEL);
			maxWidth.setTextValue(propertyValue + " " + propertyUnit);
			maxWidth.fillIntoGrid(mainComposite, NUM_COLUMNS, toolkit);

		} else if (propertyName.equals(FileProperty.MAX_HEIGHT_PROPERTY)) {
			maxHeight = new ChangeableLabelFieldEditor(SWT.WRAP);
			maxHeight.setLabelText(MAX_HEIGHT_LABEL);
			maxHeight.setTextValue(propertyValue + " " + propertyUnit);
			maxHeight.fillIntoGrid(mainComposite, NUM_COLUMNS, toolkit);

		} else if (propertyName.equals(FileProperty.MIN_WIDTH_PROPERTY)) {
			minWidth = new ChangeableLabelFieldEditor(SWT.WRAP);
			minWidth.setLabelText(MIN_WIDTH_LABEL);
			minWidth.setTextValue(propertyValue + " " + propertyUnit);
			minWidth.fillIntoGrid(mainComposite, NUM_COLUMNS, toolkit);

		} else if (propertyName.equals(FileProperty.MIN_HEIGHT_PROPERTY)) {
			minHeight = new ChangeableLabelFieldEditor(SWT.WRAP);
			minHeight.setLabelText(MIN_HEIGHT_LABEL);
			minHeight.setTextValue(propertyValue + " " + propertyUnit);
			minHeight.fillIntoGrid(mainComposite, NUM_COLUMNS, toolkit);

		} else if (propertyName.equals(FileProperty.WIDTH_PROPERTY)) {
			width = new ChangeableLabelFieldEditor(SWT.WRAP);
			width.setLabelText(WIDTH_LABEL);
			width.setTextValue(propertyValue + " " + propertyUnit);
			width.fillIntoGrid(mainComposite, NUM_COLUMNS, toolkit);

		} else if (propertyName.equals(FileProperty.HEIGHT_PROPERTY)) {
			height = new ChangeableLabelFieldEditor(SWT.WRAP);
			height.setLabelText(HEIGHT_LABEL);
			height.setTextValue(propertyValue + " " + propertyUnit);
			height.fillIntoGrid(mainComposite, NUM_COLUMNS, toolkit);

		} else if (propertyName.equals(FileProperty.MAX_COLOR_PROPERTY)) {
			maxColor = new ChangeableLabelFieldEditor(SWT.WRAP);
			maxColor.setLabelText(MAX_COLOR_LABEL);
			maxColor.setTextValue(propertyValue);
			maxColor.fillIntoGrid(mainComposite, NUM_COLUMNS, toolkit);

		} else if (propertyName.equals(FileProperty.MAX_FILE_SIZE_PROPERTY)) {
			maxFileSize = new ChangeableLabelFieldEditor(SWT.WRAP);
			maxFileSize.setLabelText(MAX_FILE_SIZE_LABEL);
			maxFileSize.setTextValue(propertyValue + " " + propertyUnit);
			maxFileSize.fillIntoGrid(mainComposite, NUM_COLUMNS, toolkit);

		} else if (propertyName
				.equals(FileProperty.RECOMMENDED_FILE_SIZE_PROPERTY)) {
			recommendedFileSize = new ChangeableLabelFieldEditor(SWT.WRAP);
			recommendedFileSize.setLabelText(RECOMMENDED_FILE_SIZE_LABEL);
			recommendedFileSize
					.setTextValue(propertyValue + " " + propertyUnit);
			recommendedFileSize.fillIntoGrid(mainComposite, NUM_COLUMNS,
					toolkit);
		}
	}

	private void buildSequenceUI(SequenceSetting sequenceSet) {
		String range2 = getRange(sequenceSet);
		if (!range2.equals(NOT_AVAILABLE)) {
			range.fillIntoGrid(mainComposite, NUM_COLUMNS, toolkit);
			range.setTextValue(range2);
		}
	}

	private void buildSelectionUI(SimpleSetting simpleSet) {
		String defaultValue = simpleSet.getDefaultValue();
		if (defaultValue != null) {
			EList<Option> options = simpleSet.getOption();
			for (Option option : options) {
				if (option.getValue().equals(defaultValue)) {
					defaultValue = option.getName();
					break;
				}
			}
			this.defaultValue.setTextValue(defaultValue);
		}
	}

	private void buildMultiSelectionUI(SimpleSetting simpleSet) {
		String defaultValue = simpleSet.getDefaultValue();

		if (defaultValue != null) {
			this.defaultValue.setTextValue(SettingValueUtils
					.getValueConvertedToOptionNames(defaultValue, simpleSet
							.getOption()));
		}
	}

	private void addNoteField() {
		if (setting != null) {
			String note = setting.getNote();
			notes.setTextValue(note == null ? "" : note);
		}
		notes.fillIntoGrid(mainComposite, NUM_COLUMNS, toolkit);
		
		createActions(notes);
		
		MenuManager mm = new MenuManager();
		mm.addMenuListener(new MenuListener(notes.getTextControl()));
		mm.setRemoveAllWhenShown(true);
		Menu menu = mm.createContextMenu(notes.getTextControl());
		notes.getTextControl().setMenu(menu);
		
		
		notes.getLabelControl().setLayoutData(
				new GridData(SWT.FILL, SWT.TOP, true, false, NUM_COLUMNS, 1));
		// notes.getTextControl().setLayoutData(new GridData(SWT.FILL, SWT.TOP,
		// true, false, NUM_COLUMNS, 1));
		//		
		// LayoutUtil.setHorizontalSpan(notes.getLabelControl(), NUM_COLUMNS);
		LayoutUtil.setHorizontalSpan(notes.getTextControl(), NUM_COLUMNS);
		IWorkbenchPart activeEditor = getPart();
		final Text textControl = notes.getTextControl();
		final NoteTextBoxListener textBoxListener = new NoteTextBoxListener(
				textControl, setting, activeEditor);
		textControl.addListener(SWT.KeyDown, textBoxListener);
		textControl.addListener(SWT.FocusOut, textBoxListener);
		textControl.addListener(SWT.Dispose, textBoxListener);
		textControl.addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {
				textControl.removeDisposeListener(this);
				textControl.removeListener(SWT.FocusOut, textBoxListener);
				textControl.removeListener(SWT.KeyDown, textBoxListener);
				textControl.removeListener(SWT.Dispose, textBoxListener);
			}

		});

		adapter = new AdapterImpl() {

			public void notifyChanged(Notification notification) {
				if (notification.getEventType() == Notification.REMOVING_ADAPTER) {
					return;
				}
				if (!(notification.getFeatureID(Setting.class) == ConfmlPackage.SEQUENCE_SETTING__NOTE)) {
					return;
				}
				String newValue = notification.getNewStringValue();
				if (newValue == null) {
					newValue = "";
				}
				if (!newValue.equals(notes.getTextValue())) {
					notes.setTextValue(newValue);
				}

			}

		};
		if (setting instanceof FilePath) {
			((FilePath) setting).getParent().eAdapters().add(adapter);
		} else {
			setting.eAdapters().add(adapter);
		}

	}

	private String getRange(SequenceSetting seqSetting) {
		String result = NOT_AVAILABLE;
		int minOccurs = seqSetting.getMinOccurs();
		int maxOccurs = seqSetting.getMaxOccurs();

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

	private String getLength(SimpleSetting simpleSetting) {
		String length = NOT_AVAILABLE;
		if (simpleSetting.getLength().intValue() != -1) {
			return String.valueOf(simpleSetting.getLength());
		}

		BigInteger minLength = simpleSetting.getMinLength();
		BigInteger maxLength = simpleSetting.getMaxLength();

		if (minLength.intValue() != -1) {
			if (minLength.intValue() == 1)
				length = "min. " + minLength.intValue() + " char";
			length = "min. " + minLength.intValue() + " characters";
		}

		if (maxLength.intValue() != -1) {
			if (minLength.intValue() != -1)
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

	private String getRange(SimpleSetting simpleSetting) {
		String visibleRange = NOT_AVAILABLE;
		TYPE settingType = simpleSetting.getType();

		if (TYPE.INT.equals(settingType)) {
			MinInclusive minInclusive = simpleSetting.getMinInclusive();
			MaxInclusive maxInclusive = simpleSetting.getMaxInclusive();
			MinExclusive minExclusive = simpleSetting.getMinExclusive();
			MaxExclusive maxExclusive = simpleSetting.getMaxExclusive();

			BigDecimal min = new BigDecimal(Integer.MIN_VALUE);
			BigDecimal max = new BigDecimal(Integer.MAX_VALUE);
			String minMark = EMPTY;
			String maxMark = EMPTY;

			if (minExclusive != null) {
				min = (BigDecimal) minExclusive.getValue();
				minMark = "(";
			}

			if (minInclusive != null) {
				min = (BigDecimal) minInclusive.getValue();
				if (minMark.contains("("))
					minMark.replace("(", "[");
				else
					minMark = "[";
			}

			if (maxExclusive != null) {
				max = (BigDecimal) maxExclusive.getValue();
				maxMark = ")";
			}

			if (maxInclusive != null) {
				max = (BigDecimal) maxInclusive.getValue();
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

		if (TYPE.REAL.equals(settingType)) {
			MinInclusive minInclusive = simpleSetting.getMinInclusive();
			MaxInclusive maxInclusive = simpleSetting.getMaxInclusive();
			MinExclusive minExclusive = simpleSetting.getMinExclusive();
			MaxExclusive maxExclusive = simpleSetting.getMaxExclusive();

			BigDecimal min = new BigDecimal(Long.MIN_VALUE);
			BigDecimal max = new BigDecimal(Long.MAX_VALUE);
			String minMark = EMPTY;
			String maxMark = EMPTY;

			if (minExclusive != null) {
				min = (BigDecimal) minExclusive.getValue();
				minMark = "(";
			}

			if (minInclusive != null) {
				min = (BigDecimal) minInclusive.getValue();
				if (minMark.contains("("))
					minMark.replace("(", "[");
				else
					minMark = "[";
			}

			if (maxExclusive != null) {
				max = (BigDecimal) maxExclusive.getValue();
				maxMark = ")";
			}

			if (maxInclusive != null) {
				max = (BigDecimal) maxInclusive.getValue();
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

		if (TYPE.DATE.equals(settingType) || TYPE.DATE_TIME.equals(settingType)
				|| TYPE.TIME.equals(settingType)) {
			MinInclusive minInclusive = simpleSetting.getMinInclusive();
			MaxInclusive maxInclusive = simpleSetting.getMaxInclusive();
			MinExclusive minExclusive = simpleSetting.getMinExclusive();
			MaxExclusive maxExclusive = simpleSetting.getMaxExclusive();
			XMLCalendar min = null;
			XMLCalendar max = null;

			if (TYPE.DATE.equals(settingType)) {
				min = new XMLCalendar("1970-01-01", XMLCalendar.DATE);
				max = new XMLCalendar("2099-12-31", XMLCalendar.DATE);
			} else if (TYPE.DATE_TIME.equals(settingType)) {
				min = new XMLCalendar("1970-01-01T00:00:00Z",
						XMLCalendar.DATETIME);
				max = new XMLCalendar("2099-12-31T23:59:59Z",
						XMLCalendar.DATETIME);
			} else if (TYPE.TIME.equals(settingType)) {
				min = new XMLCalendar("00:00:00+00:00", XMLCalendar.TIME);
				max = new XMLCalendar("23:59:59+00:00", XMLCalendar.TIME);
			}

			XMLCalendar minValue = min;
			XMLCalendar maxValue = max;

			String minMark = EMPTY;
			String maxMark = EMPTY;

			if (minExclusive != null) {
				min = (XMLCalendar) minExclusive.getValue();
				minMark = "(";
			}

			if (minInclusive != null) {
				min = (XMLCalendar) minInclusive.getValue();
				if (minMark.contains("("))
					minMark.replace("(", "[");
				else
					minMark = "[";
			}

			if (maxExclusive != null) {
				max = (XMLCalendar) maxExclusive.getValue();
				maxMark = ")";
			}

			if (maxInclusive != null) {
				max = (XMLCalendar) maxInclusive.getValue();
				if (maxMark.contains(")"))
					maxMark.replace(")", "]");
				else
					maxMark = "]";
			}

			if (!EMPTY.equals(minMark) || !EMPTY.equals(maxMark)) {
				if (minValue.equals(min) && !maxValue.equals(max))
					visibleRange = "(-" + INFINITY + "; " + max + maxMark;

				if (!minValue.equals(min) && maxValue.equals(max))
					visibleRange = minMark + min + "; " + INFINITY + ")";

				if (!minValue.equals(min) && !maxValue.equals(max))
					visibleRange = minMark + min + "; " + max + maxMark;
			}

			return visibleRange;
		}

		if (TYPE.DURATION.equals(settingType)) {
			MinInclusive minInclusive = simpleSetting.getMinInclusive();
			MaxInclusive maxInclusive = simpleSetting.getMaxInclusive();
			MinExclusive minExclusive = simpleSetting.getMinExclusive();
			MaxExclusive maxExclusive = simpleSetting.getMaxExclusive();
			XMLDuration min = null;
			XMLDuration max = null;

			XMLDuration minValue = min;
			XMLDuration maxValue = max;

			String minMark = EMPTY;
			String maxMark = EMPTY;

			if (minExclusive != null) {
				min = (XMLDuration) minExclusive.getValue();
				minMark = "(";
			}

			if (minInclusive != null) {
				min = (XMLDuration) minInclusive.getValue();
				if (minMark.contains("("))
					minMark.replace("(", "[");
				else
					minMark = "[";
			}

			if (maxExclusive != null) {
				max = (XMLDuration) maxExclusive.getValue();
				maxMark = ")";
			}

			if (maxInclusive != null) {
				max = (XMLDuration) maxInclusive.getValue();
				if (maxMark.contains(")"))
					maxMark.replace(")", "]");
				else
					maxMark = "]";
			}

			if (!EMPTY.equals(minMark) || !EMPTY.equals(maxMark)) {
				if (minValue == min && maxValue != max)

					visibleRange = "max " + getParsedString(max);
				// visibleRange = "(-" + INFINITY + "; " + max + maxMark;

				if (minValue != min && maxValue == max)
					visibleRange = "min " + getParsedString(min);

				// visibleRange = minMark + min + "; " + INFINITY + ")";

				if (minValue != min && maxValue != max)
					visibleRange = "from " + getParsedString(min) + "\nto "
							+ getParsedString(max);
				// visibleRange = minMark + min + "; " + max + maxMark;
			}

			return visibleRange;
		}

		return visibleRange;
	}

	private String getParsedString(XMLDuration dur) {
		Number years = dur.getField(DatatypeConstants.YEARS);
		Number months = dur.getField(DatatypeConstants.MONTHS);
		Number days = dur.getField(DatatypeConstants.DAYS);
		Number hours = dur.getField(DatatypeConstants.HOURS);
		Number minutes = dur.getField(DatatypeConstants.MINUTES);
		Number seconds = dur.getField(DatatypeConstants.SECONDS);
		String returnedString = "";
		if (years != null && years.intValue() > 0)
			returnedString = returnedString.concat(years.intValue() + "Y ");
		if (months != null && months.intValue() > 0)
			returnedString = returnedString.concat(months.intValue() + "M ");
		if (days != null && days.intValue() > 0)
			returnedString = returnedString.concat(days.intValue() + "D ");
		if (hours != null && hours.intValue() > 0)
			returnedString = returnedString.concat(hours.intValue() + "h ");
		if (minutes != null && minutes.intValue() > 0)
			returnedString = returnedString.concat(minutes.intValue() + "m ");
		if (seconds != null && seconds.doubleValue() > 0)
			returnedString = returnedString.concat(seconds.doubleValue() + "s");
		return returnedString;
	}

	private String getTotalDigits(SimpleSetting simpleSetting) {
		BigInteger totalDigits2 = simpleSetting.getTotalDigits();
		if (totalDigits2.intValue() == -1)
			return NOT_AVAILABLE;

		return String.valueOf(totalDigits2.intValue());
	}

	private String getPattern(SimpleSetting simpleSetting) {
		return simpleSetting.getPattern();
	}

	private String getPattern(Setting fileSetting) {
		if (fileSetting instanceof FilePath)
			return ((FilePath) fileSetting).getPattern();
		return EMPTY;
	}
	
	private void createDependencies(Setting setting) {
		Set<Setting> settings = ConfMLExpressionSettingUtil
				.getSettingsRefFromRelevant(setting);
		settings.addAll(ConfMLExpressionSettingUtil
				.getSettingsRefFromConstraint(setting));
		if (!settings.isEmpty()) {
			Iterator<Setting> it = settings.iterator();
			dependsOn = new HyperlinkFieldEditor(SWT.WRAP, it.next(),
					"Depends on: ");
			dependsOn.fillIntoGrid(mainComposite, NUM_COLUMNS, toolkit);

			while (it.hasNext()) {
				dependsOn = new HyperlinkFieldEditor(SWT.WRAP, it.next(), null);
				dependsOn.fillIntoGrid(mainComposite, NUM_COLUMNS, toolkit);
			}
		}

		if (setting.getDependencies() != null
				&& !setting.getDependencies().isEmpty()) {
			List<Object> depend = setting.getDependencies();
			Iterator<Object> it = depend.iterator();
			dependencies = new HyperlinkFieldEditor(SWT.WRAP, it.next(),
					"Settings depending on this: ");
			dependencies.fillIntoGrid(mainComposite, NUM_COLUMNS, toolkit);

			while (it.hasNext()) {
				dependencies = new HyperlinkFieldEditor(SWT.WRAP, it.next(),
						null);
				dependencies.fillIntoGrid(mainComposite, NUM_COLUMNS, toolkit);
			}
		}
	}
	
	
	class MenuListener implements IMenuListener {
		private Control parent;

		public MenuListener(Control parent) {
			this.parent = parent;
		}

		public void menuAboutToShow(IMenuManager menu) {
			contextMenuAboutToShow(menu, parent);
		}
		protected void contextMenuAboutToShow(IMenuManager menu, Control parent) {			
			menu.add(new Separator());
			menu.add(cutAction);
			menu.add(copyAction);
			menu.add(pasteAction);
			menu.add(deleteAction);
			menu.add(new Separator());						
		}
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
	}
	
}
