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

import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;

import com.nokia.tools.variant.common.ui.properties.fields.LabelFieldEditor;
import com.nokia.tools.variant.content.confml.Feature;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.editor.editors.CPFEditor;

public class HyperlinkFieldEditor extends LabelFieldEditor {

	private String textValue;
	private int style;
	private Hyperlink textControl;
	private Object content;

	public HyperlinkFieldEditor() {
		this(SWT.NONE);
	}

	public HyperlinkFieldEditor(int style) {
		this.style = style;
	}

	public HyperlinkFieldEditor(int style, Object content, String label) {
		this.style = style;
		this.content = content;

		if (label != null) {
			setLabelText(label);
		}

		if (content instanceof Setting) {
			Setting setting = (Setting) content;
			setTextValue(setting.getName());
		} else if (content instanceof Feature) {
			Feature feature = (Feature) content;
			setTextValue("Feature: " + feature.getName());
		}
	}

	public void setTextValue(String textValue) {
		this.textValue = textValue;
		if (canUseControl(textControl)) {
			textControl.setText(textValue);
		}
	}

	public String getTextValue() {
		return textValue;
	}

	@Override
	public void fillIntoGrid(Composite parent, int columns, FormToolkit toolkit) {
		super.fillIntoGrid(parent, 1, toolkit);

		textControl = createTextControl(parent, toolkit);
		GridData gridData = createLayoutDataForText(columns - 1);
		textControl.setLayoutData(gridData);

		setTooltipText();

		textControl.addHyperlinkListener(new IHyperlinkListener() {

			public void linkActivated(HyperlinkEvent e) {
				try {
					IWorkbenchPage activePage = PlatformUI.getWorkbench()
							.getActiveWorkbenchWindow().getActivePage();
					if (activePage != null) {
						IEditorPart activeEditor = activePage.getActiveEditor();
						if (activeEditor instanceof CPFEditor) {
							CPFEditor editor = (CPFEditor) activeEditor;

							if (content instanceof Setting) {
								editor.setSelection(new StructuredSelection(
										(Setting) content));
							} else if (content instanceof Feature) {
								editor.setSelection(new StructuredSelection(
										(Feature) content));
							}
						}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkExited(HyperlinkEvent e) {
			}

		});
	}

	private void setTooltipText() {
		String text = "";

		if (content instanceof Setting) {
			Setting setting = (Setting) content;
			text = "Setting ref:\n  " + setting.getAbsRef() + "\n";
			String description = setting.getDescription();
			if (description != null) {
				text += "Setting description:\n  "
						+ getWrappedText(description, 100) + "\n";
			} else {
				text += "Setting description:\n  " + "N/A" + "\n";
			}
			text += "Setting constraint:\n  "
					+ null2na(setting.getConstraint()) + "\n";
			text += "Setting relevant:\n  " + null2na(setting.getRelevant())
					+ "\n";
		} else if (content instanceof Feature) {
			Feature feature = (Feature) content;
			text = "Feature ref:\n  " + feature.getRef() + "\n";
			text += "Feature description:\n  "
					+ null2na(feature.getDescription()) + "\n";
			text += "Feature relevant:\n  " + null2na(feature.getRelevant())
					+ "\n";
		}

		textControl.setToolTipText(text);
	}
	
	private String getWrappedText(String text, int length) {
		if (text.length() < length)
			return text;

		StringBuilder stringBuilder = new StringBuilder(text);
		for (int i = length; i < stringBuilder.length(); i += 100) {
			stringBuilder.insert(i, "\n");
		}

		return stringBuilder.toString();
	}

	private String null2na(String text) {
		if (text == null) {
			return "N/A";
		} else {
			return text;
		}
	}

	public Hyperlink getTextControl() {
		return textControl;
	}

	protected Hyperlink createTextControl(Composite parent, FormToolkit toolkit) {
		Hyperlink control = toolkit.createHyperlink(parent, textValue, style);
		return control;
	}

	protected GridData createLayoutDataForText(int columns) {
		GridData gridData;
		// gridData = new GridData(SWT.NONE, SWT.NONE, false, false);
		if ((style & SWT.MULTI) != 0) {
			gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		} else {
			gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
		}
		gridData.horizontalSpan = columns;
		return gridData;
	}

	protected GridData createLayoutDataForLabel(int columns) {
		GridData data = super.createLayoutDataForLabel(columns);
		data.verticalAlignment = SWT.TOP;
		return data;
	}

	protected int getNumberOfControls() {
		return 2;
	}

	protected Control[] getControls() {
		return new Control[] { getTextControl(), getLabelControl() };
	}
}
