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

package com.nokia.tools.vct.internal.common.secure.ui.fields;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;

import com.nokia.tools.vct.common.ui.wizards.dialogfields.DialogField;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.IDialogFieldListener;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.IStringButtonAdapter;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.LayoutUtil;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.StringButtonDialogField;

public class ImportKeysFieldGroup extends Observable implements
		IDialogFieldListener, IStringButtonAdapter {

	private StringButtonDialogField sourceFileField;
	List<String> selectedFiles = new ArrayList<String>();

	public ImportKeysFieldGroup() {
		sourceFileField = new StringButtonDialogField(this);

		sourceFileField.setLabelText("Destination:");

		sourceFileField.setDialogFieldListener(this);
	}

	public void fillIntoGrid(Composite parent, int columns) {
		sourceFileField.doFillIntoGrid(parent, columns);
		LayoutUtil.setHorizontalGrabbing(sourceFileField.getTextControl(null));
	}

	public void dialogFieldChanged(DialogField field) {
		setChanged();
		notifyObservers();
	}

	public void changeControlPressed(DialogField field) {
		if (field == sourceFileField) {
			FileDialog dialog = new FileDialog(Display.getCurrent()
					.getActiveShell(), SWT.OPEN | SWT.MULTI);
			dialog.setFilterExtensions(new String[] { "*.p12; *.cer", "*.p12",
					"*.cer" });
			dialog.setFilterNames(new String[] { "All supported (*.p12,*.cer)",
					"Personal Information Exchange (*.p12)",
					"Certificate File (.cer)" });
			String result = dialog.open();
			if (result != null) {

				StringBuffer buf = new StringBuffer();
				String[] files = dialog.getFileNames();
				for (int i = 0, n = files.length; i < n; i++) {
					selectedFiles.add(dialog.getFilterPath()
							+ File.separatorChar + files[i]);
					buf.append(dialog.getFilterPath());
					if (buf.charAt(buf.length() - 1) != File.separatorChar) {
						buf.append(File.separatorChar);
					}
					buf.append(files[i]);
					if (i + 1 < files.length)
						buf.append("; ");
				}
				sourceFileField.setText(buf.toString());
			}
		}
	}

	public List<String> getSourceFile() {
		return selectedFiles;
	}

}
