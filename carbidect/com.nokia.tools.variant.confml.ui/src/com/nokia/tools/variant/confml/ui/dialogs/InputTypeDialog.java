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
 * Description: This file is part of com.nokia.tools.variant.confml.ui component.
 */

package com.nokia.tools.variant.confml.ui.dialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

import com.nokia.tools.vct.common.ui.dialogs.SimpleDialogWindow;

public class InputTypeDialog extends SimpleDialogWindow {

	private String label;
	private final String[] settingType = {"int", "real", "string", "boolean",  "selection",
			"multiSelection",  "folder", "sequence"};

	private String value;

	public InputTypeDialog(Shell parent, String label) {
		super(parent, "Quick fix dialog");
		this.label=label;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite comp = (Composite) super.createDialogArea(parent);
		Label l = new Label(comp, SWT.NONE);
		l.setText(label);

		Button[] radios = new Button[settingType.length];

		Listener radioGroup = new Listener() {
			public void handleEvent(Event event) {
				value = ((Button) event.widget).getText();
			}
		};

		for (int i = 0; i < settingType.length; i++) {
			radios[i] = new Button(comp, SWT.RADIO);
			radios[i].setText(settingType[i]);
			radios[i].addListener(SWT.Selection, radioGroup);
		}

		return comp;
	}

	public String getValue() {
		return value;
	}

}
