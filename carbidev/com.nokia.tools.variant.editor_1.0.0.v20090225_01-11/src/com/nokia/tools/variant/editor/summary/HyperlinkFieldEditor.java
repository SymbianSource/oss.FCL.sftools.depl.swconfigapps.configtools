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

package com.nokia.tools.variant.editor.summary;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;

import com.nokia.tools.variant.common.ui.properties.fields.LabelFieldEditor;

public class HyperlinkFieldEditor extends LabelFieldEditor{
	

	private String textValue;
	private int style;
	private Hyperlink textControl;
	private String showView;
	
	public HyperlinkFieldEditor() {
		this(SWT.NONE);
	}
	
	public HyperlinkFieldEditor(int style) {
		this.style = style;
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
//		if ((style & SWT.MULTI) != 0) {
//			gridData.minimumHeight = new PixelConverter(parent).convertHeightInCharsToPixels(4);
//		}
	//	gridData.widthHint = 200;
		textControl.setLayoutData(gridData);
		
		if(showView!=null){
		textControl.addHyperlinkListener(new IHyperlinkListener(){

			public void linkActivated(HyperlinkEvent e) {
				try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(showView);
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
		
		
//		textControl.addModifyListener(new ModifyListener() {
//			public void modifyText(ModifyEvent e) {
//				textValue = textControl.getText();
//				setChanged();
//				notifyObservers();
//			}
//		});
	}
	public void setShowedView(String viewId){
		this.showView = viewId;
	}
	
	public Hyperlink getTextControl() {
		return textControl;
	}
	
	protected Hyperlink createTextControl(Composite parent, FormToolkit toolkit) {
		Hyperlink control = toolkit.createHyperlink(parent, textValue, style);
		//control.setEditable(editable);
		return control;
	}
	
	protected GridData createLayoutDataForText(int columns) {
		GridData gridData;
		gridData = new GridData(SWT.NONE, SWT.NONE, false, false);
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
		return new Control[] {getTextControl(), getLabelControl()};
	}
	
	//private boolean editable = true;
	
//	public void setEditable(boolean flag) {
//		this.editable = flag;
//		if (canUseControl(textControl)) {
//			textControl.setEditable(flag);
//		}
//	}
}
