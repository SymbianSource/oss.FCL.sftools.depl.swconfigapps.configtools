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
 * Description: This file is part of com.nokia.tools.variant.validation.ui component.
 */

package com.nokia.tools.variant.validation.ui.page;

import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.nokia.tools.variant.validation.core.ConfmlMarkerUtils;
import com.nokia.tools.variant.validation.core.ValidationCorePlugin;

public class ValidationPreferencePage extends PreferencePage implements
		IWorkbenchPreferencePage {

	private final String[][] levels = new String[][] { { "INFO", "INFO" },
			{ "WARNING", "WARNING" }, { "ERROR", "ERROR" } };

	private final String[][] types = new String[][] {
			{ ConfmlMarkerUtils.CONFML_PROBLEM_MARKER, "ConfML Validation Problem" },
 };

	private ComboFieldEditor[] combos;

	public ValidationPreferencePage() {
		setPreferenceStore(ValidationCorePlugin.getDefault().getPreferenceStore());
		combos = new ComboFieldEditor[types.length];
	}

	public ValidationPreferencePage(String title) {
		super(title);
	}

	public ValidationPreferencePage(String title, ImageDescriptor image) {
		super(title, image);
	}

	protected Control createContents(Composite parent) {

		Composite preferences = new Composite(parent, SWT.NONE);
		preferences.setLayout(new GridLayout(1, false));
		preferences.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		for (int i = 0; i < combos.length; i++) {
			combos[i] = new ComboFieldEditor(types[i][0], types[i][1], levels,
					preferences);
			combos[i].setPreferenceStore(ValidationCorePlugin.getDefault()
					.getPreferenceStore());
			combos[i].load();
		}
		return preferences;
	}

	public void init(IWorkbench workbench) {
		

	}

	public boolean performOk() {
		for (int i = 0; i < combos.length; i++) {
			combos[i].store();
		}
		try {
			ResourcesPlugin.getWorkspace().build(IncrementalProjectBuilder.FULL_BUILD, new NullProgressMonitor());
		} catch (CoreException ce) {
			ce.printStackTrace();
		}
		return super.performOk();
	}

	protected void performDefaults() {
		for (int i = 0; i < combos.length; i++) {
			combos[i].loadDefault();
		}
		try {
			ResourcesPlugin.getWorkspace().build(IncrementalProjectBuilder.FULL_BUILD, new NullProgressMonitor());
		} catch (CoreException ce) {
			ce.printStackTrace();
		}
		super.performDefaults();
	}

}
