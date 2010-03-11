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
package com.nokia.tools.s60ct.report.dialog;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import com.nokia.tools.s60ct.report.ReportPlugin;
import com.nokia.tools.s60ct.report.generator.ReportGenerator;
import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.vct.common.appmodel.EAppFeature;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.DialogField;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.IDialogFieldListener;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.IStringButtonAdapter;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.LayoutUtil;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.SelectionButtonDialogField;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.StringButtonDialogField;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.StringDialogField;

public class ReportDialog extends TitleAreaDialog implements IDialogFieldListener, IStringButtonAdapter {

	public static final String PROP_FILE_PATH = "filePath";
	// private static final String PROP_FILTER = "filter";
	// private static final String PROP_KEYWORD = "keyword";
	private int filter = 0;
	private IPreferenceStore iPreferenceStore;
	private StringButtonDialogField filepathField;
	private StringDialogField keywordField;
	private SelectionButtonDialogField openBrowserField;
	private SelectionButtonDialogField showDescField;
	private SelectionButtonDialogField showGroupingField;
	private SelectionButtonDialogField displayAsTable;
	private SelectionButtonDialogField textSettings;
	private SelectionButtonDialogField notesSettings;
	private SelectionButtonDialogField nonDefSettings;
	private SelectionButtonDialogField allSettings;
	private SelectionButtonDialogField errorsSettings;

	private Image titleImage;
	private Image shellImage;

	public ReportDialog(Shell parentShell) {
		super(parentShell);
		iPreferenceStore = ReportPlugin.getDefault().getPreferenceStore();
		setTitle("Create Report");
		titleImage = ReportPlugin.getImage(ReportPlugin.IMAGE_REPORT_EXP);
		shellImage = ReportPlugin.getImage(ReportPlugin.IMAGE_REPORT_TLB);
		setTitleImage(titleImage);
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setImage(shellImage);
		newShell.setText("Create Report");
	}

	@Override
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		setTitle("Create Report");
		setMessage("Create report of the currently open CPF file with the following information.");

		Shell active = Display.getCurrent().getActiveShell();
		
		if (active != null) {
			Point size = getShell().computeSize(SWT.DEFAULT, SWT.DEFAULT, true);
			Point activeSize = active.getSize();
			getShell().setLocation((activeSize.x - size.x) / 2, (activeSize.y - size.y) / 2);
		}

		return contents;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		// loadDialogSettings();
		if (iPreferenceStore.getString(PROP_FILE_PATH).contains("Untitled")) {
			iPreferenceStore.putValue(PROP_FILE_PATH, generateUntitledName());
		}
		final int numColumns = 5;
		final Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(initGridLayout(new GridLayout(numColumns, false), true));
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		filepathField = new StringButtonDialogField(this);
		filepathField.setLabelText("Report name");
		filepathField.setButtonLabel("Save as...");
		filepathField.doFillIntoGrid(composite, numColumns);
		filepathField.setText(iPreferenceStore.getString(PROP_FILE_PATH));
		LayoutUtil.setHorizontalSpan(filepathField.getTextControl(composite), 3);
		LayoutUtil.setHorizontalGrabbing(filepathField.getTextControl(composite));

		DialogField.createEmptySpace(composite, numColumns);
		new Label(composite, SWT.NONE).setText("Options");

		displayAsTable = new SelectionButtonDialogField(SWT.CHECK);
		displayAsTable.setLabelText("Display as a table");
		displayAsTable.setDialogFieldListener(this);
		displayAsTable.doFillIntoGrid(composite, numColumns - 1);
		displayAsTable.setSelection(true);
		new Label(composite, SWT.NONE);

		showGroupingField = new SelectionButtonDialogField(SWT.CHECK);
		showGroupingField.setLabelText("Show grouping of Settings");
		showGroupingField.setDialogFieldListener(this);
		showGroupingField.doFillIntoGrid(composite, numColumns - 1);
		showGroupingField.setSelection(true);
		new Label(composite, SWT.NONE);

		showDescField = new SelectionButtonDialogField(SWT.CHECK);
		showDescField.setLabelText("Show descriptions");
		showDescField.setDialogFieldListener(this);
		showDescField.doFillIntoGrid(composite, numColumns - 1);
		showDescField.setSelection(true);
		new Label(composite, SWT.NONE);

		openBrowserField = new SelectionButtonDialogField(SWT.CHECK);
		openBrowserField.setLabelText("Open report directly in default browser");
		openBrowserField.setDialogFieldListener(this);
		openBrowserField.doFillIntoGrid(composite, numColumns - 1);
		openBrowserField.setSelection(true);
		DialogField.createEmptySpace(composite, numColumns);
		new Label(composite, SWT.NONE).setText("Contents");

		allSettings = new SelectionButtonDialogField(SWT.RADIO);
		allSettings.setLabelText("All Settings");
		allSettings.setDialogFieldListener(this);
		allSettings.doFillIntoGrid(composite, numColumns - 1);
		new Label(composite, SWT.NONE);

//		nonDefSettings = new SelectionButtonDialogField(SWT.RADIO);
//		nonDefSettings.setLabelText("Settings with non-default values");
//		nonDefSettings.setDialogFieldListener(this);
//		nonDefSettings.doFillIntoGrid(composite, numColumns - 1);
//		new Label(composite, SWT.NONE);

//		notesSettings = new SelectionButtonDialogField(SWT.RADIO);
//		notesSettings.setLabelText("Settings with Notes");
//		notesSettings.setDialogFieldListener(this);
//		notesSettings.doFillIntoGrid(composite, numColumns - 1);
//		new Label(composite, SWT.NONE);
//
//		errorsSettings = new SelectionButtonDialogField(SWT.RADIO);
//		errorsSettings.setLabelText("Settings with validation errors");
//		errorsSettings.setDialogFieldListener(this);
//		errorsSettings.doFillIntoGrid(composite, numColumns - 1);
//		new Label(composite, SWT.NONE);
//
//		textSettings = new SelectionButtonDialogField(SWT.RADIO);
//		textSettings.setLabelText("Settings matching keyword(s)");
//		textSettings.setDialogFieldListener(this);
//		textSettings.doFillIntoGrid(composite, 1);
//		keywordField = new StringDialogField();
//		keywordField.setLabelText(" ");
//		keywordField.setDialogFieldListener(this);
//		keywordField.doFillIntoGrid(composite, 3);
//		Control text = keywordField.getTextControl(composite);
//		GridData gd = (GridData) text.getLayoutData();
//		PixelConverter conv = new PixelConverter(text);
//		gd.minimumWidth = conv.convertWidthInCharsToPixels(50)
//				+ conv.convertHorizontalDLUsToPixels(2);
//		gd.grabExcessHorizontalSpace = true;
//		LayoutUtil
//				.setHorizontalGrabbing(keywordField.getTextControl(composite));
//		LayoutUtil.setHorizontalSpan(keywordField.getTextControl(composite), 2);

		if (filepathField.getText() == "") {
			filepathField.setText(generateCustomName());
		}
		setLoadedButtonSelection(filter);
		return composite;
	}

	private void setLoadedButtonSelection(int filter) {
		allSettings.setSelection((filter & ReportGenerator.ALL) != 0);
		//displayAsTable.setSelection((filter & ReportGenerator.TO_TABLE) != 0);
		//nonDefSettings.setSelection((filter & ReportGenerator.NON_DEFAULT) != 0);
		//notesSettings.setSelection((filter & ReportGenerator.WITH_NOTES) != 0);
		//textSettings.setSelection((filter & ReportGenerator.TEXT_FILTER) != 0);
		showGroupingField.setSelection((filter & ReportGenerator.BY_GROUP) != 0);
		showDescField.setSelection((filter & ReportGenerator.DESCRIPTION) != 0);
		openBrowserField.setSelection((filter & ReportGenerator.OPEN) != 0);
	}

	/**
	 * This method generates Untitle name to file path in report dialog
	 */
	private String generateUntitledName() {
		int number = 1;
		String editorPath = ReportPlugin.getSelectedProject().getLocation().toOSString();

		File file = new File(editorPath);
		String filePath;
		do {
			filePath = file.getPath() + File.separator + "Untitled_" + number + ".html";
			file = new File(filePath);
			number++;
		} while (file.exists());
		return filePath;
	}

	private String generateCustomName() {
		String inputPath = filepathField.getText();
		String outputPath;
		if (inputPath.lastIndexOf(File.separator) < 0) {
			if (inputPath == "") {
				outputPath = generateUntitledName();
			} else {
				String editorPath = ReportPlugin.getSelectedProject().getLocation().toOSString();
				File file = new File(editorPath);
				outputPath = file.getAbsolutePath()	+ File.separator + inputPath + ".html";
			}
		} else {
			String checkPath = generateUntitledName();
			if ((new File(checkPath).getParent().equals(new File(inputPath).getParent()))) {
				if (inputPath.substring(inputPath.lastIndexOf(File.separator) + 1).matches("Untitled_(\\d+).html")) {
					outputPath = generateUntitledName();
				} else {
					outputPath = checkExtension(inputPath);
				}
			} else {
				outputPath = checkExtension(inputPath);
			}
		}
		iPreferenceStore.putValue(PROP_FILE_PATH, outputPath);
		return outputPath;
	}

	private void generateReport() {
		try {//ML
//			View project = getProject();
			
			EConfMLLayer layer =  getLastLayer();
			
			//if (project instanceof View) { //ML

//				View view = project;
				
				System.out.println("Creating ReportGenerator!"); //ML 
				ReportGenerator rg = new ReportGenerator();
				System.out.println("Creating ReportGenerator DONE"); //ML
				rg.setKeyword(((filter & ReportGenerator.TEXT_FILTER) != 0) ? keywordField.getText() : null); //ML
				String report = rg.generate(layer, filter, iPreferenceStore.getString(PROP_FILE_PATH));
				
				if (report != null) {
					File f = new File(iPreferenceStore.getString(PROP_FILE_PATH));

					try {
						FileOutputStream fo = new FileOutputStream(f);
						fo.write(report.getBytes());
						fo.close();

						if ((filter & 64) == 0) {
							MessageDialog.openInformation(getShell(), "Report created", "Report was successfully created to your specified location.");
						}

						if (rg.canOpen(filter)) {
							try {
								Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + f);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					} catch (IOException e) {
						MessageDialog.openInformation(getShell(), "File not found",	"File can not be opened.");
					}
				} else {
					MessageDialog.openWarning(getShell(), "Report not created",	"Report was not created, because no setting meets given criteria.");
				}
				// storeDialogSettings();
				
				
				ReportPlugin.getSelectedProject().refreshLocal(IResource.DEPTH_ONE, null);
//		} //ML
		} catch (Exception e) {//ML
			e.printStackTrace();
		}
		
	
		
		
	}

	// private void loadDialogSettings() {
	// String storedFilter = iPreferenceStore.getString(PROP_FILTER);
	// if (storedFilter != null) {
	// try {
	// filter = Integer.valueOf(storedFilter);
	// } catch (NumberFormatException nfe) {
	// }
	// }
	// }
	//
	// private void loadTexts() {
	// String text = iPreferenceStore.getString(PROP_FILE_PATH);
	// if (text != null && filepathField != null) {
	// filepathField.setText(text);
	// }
	// text = iPreferenceStore.getString(PROP_KEYWORD);
	// if (text != null && keywordField != null) {
	// keywordField.setText(text);
	// }
	// }
	//
	// private void storeDialogSettings() {
	// iPreferenceStore.putValue(PROP_FILE_PATH, filepathField.getText());
	// iPreferenceStore.putValue(PROP_KEYWORD, keywordField.getText());
	// iPreferenceStore.putValue(PROP_FILTER, Integer.toString(filter));
	// }

//	private View getProject() {
//		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
//		
//		if (activePage != null) {
//			IEditorPart activeEditor = activePage.getActiveEditor();
//
//			if (activeEditor != null) {
//				Object adapter = activePage.getActiveEditor().getAdapter(View.class);
//
//				if ((adapter != null) && (adapter instanceof View)) {
//					return (View) adapter;
//				}
//			}
//		}
//		return null;
//	}

	private EConfMLLayer getLastLayer() {
		
		IProject selectedProject = ReportPlugin.getSelectedProject();
		EConfigurationProject configurationProject = ConfMLCore.getProjectModel(selectedProject);

		if (configurationProject == null)
			return null;
		EConfMLLayer lastLayer = configurationProject.getLastLayer();
		return lastLayer;
	}
	
	private GridLayout initGridLayout(GridLayout layout, boolean margins) {
		layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
		layout.verticalSpacing = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
		if (margins) {
			layout.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
			layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
		} else {
			layout.marginWidth = 0;
			layout.marginHeight = 0;
		}
		return layout;
	}

	@Override
	protected Control createButtonBar(Composite parent) {
		Control buttonBar = super.createButtonBar(parent);
		return buttonBar;
	}

	@Override
	protected void okPressed() {
		String currentPath = checkExtension(filepathField.getText());
		iPreferenceStore.putValue(PROP_FILE_PATH, currentPath);
		generateReport();
		super.okPressed();
	}

	public void dialogFieldChanged(DialogField field) {
		if (field == allSettings) {
			filter = allSettings.isSelected() ? filter | ReportGenerator.ALL : filter ^ ReportGenerator.ALL;
		} else if (field == nonDefSettings) {
			filter = nonDefSettings.isSelected() ? filter | ReportGenerator.NON_DEFAULT : filter ^ ReportGenerator.NON_DEFAULT;
		} else if (field == notesSettings) {
			filter = notesSettings.isSelected() ? filter | ReportGenerator.WITH_NOTES : filter ^ ReportGenerator.WITH_NOTES;
		} else if (field == errorsSettings) {
			filter = errorsSettings.isSelected() ? filter | ReportGenerator.WITH_ERRORS : filter ^ ReportGenerator.WITH_ERRORS;
		} else if (field == textSettings) {
			filter = textSettings.isSelected() ? filter	| ReportGenerator.TEXT_FILTER : filter ^ ReportGenerator.TEXT_FILTER;
			if (textSettings.isSelected()) {
				if (!keywordField.getTextControl(null).isFocusControl()) {
					keywordField.setFocus();
				}
			}
		} else if (field == displayAsTable) {
			filter = displayAsTable.isSelected() ? filter | ReportGenerator.TO_TABLE : filter ^ ReportGenerator.TO_TABLE;
		} else if (field == showGroupingField) {
			filter = showGroupingField.isSelected() ? filter | ReportGenerator.BY_GROUP : filter ^ ReportGenerator.BY_GROUP;
		} else if (field == showDescField) {
			filter = showDescField.isSelected() ? filter | ReportGenerator.DESCRIPTION : filter	^ ReportGenerator.DESCRIPTION;
		} else if (field == openBrowserField) {
			filter = openBrowserField.isSelected() ? filter | ReportGenerator.OPEN : filter ^ ReportGenerator.OPEN;
		} else if (field == keywordField) {
			textSettings.setSelection(true);
			allSettings.setSelection(false);
			nonDefSettings.setSelection(false);
			notesSettings.setSelection(false);
		}
	}

	private String checkExtension(String fileName) {
		int index = fileName.lastIndexOf(".");
		if (index != -1) {
			String extension = fileName.substring(index);
			if (extension != null && (extension.equalsIgnoreCase(".html"))) {
				return fileName;
			} else {
				return fileName.substring(0, index).concat(".html");
			}
		}
		if (fileName == "") {
			return generateUntitledName();
		} else {
			return (fileName.concat(".html"));
		}

	}

	public void changeControlPressed(DialogField field) {
		if (field == filepathField) {
			FileDialog dialog = new FileDialog(ReportDialog.this.getShell(), SWT.SAVE);
			dialog.setFilterNames(new String[] { "Single Web Page (*.html)" });
			dialog.setFilterExtensions(new String[] { "*.html;*.htm" });
			String editorPath = ReportPlugin.getSelectedProject().getLocation().toOSString();
			File file = new File(editorPath);
			dialog.setFilterPath(file.getAbsolutePath());
			if (filepathField.getText() == "") {
				dialog.setFileName(iPreferenceStore.getString(PROP_FILE_PATH));
			} else {
				dialog.setFileName(filepathField.getText());
			}
			String fileName = dialog.open();
			filepathField.setText(checkExtension(fileName));
			iPreferenceStore.setValue(PROP_FILE_PATH, fileName);
		}
	}
}
