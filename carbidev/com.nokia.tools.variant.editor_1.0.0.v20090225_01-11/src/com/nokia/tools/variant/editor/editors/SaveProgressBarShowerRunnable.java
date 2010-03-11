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

package com.nokia.tools.variant.editor.editors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.widgets.Display;

import com.nokia.tools.variant.common.ui.utils.ProgressBarShower;

public class SaveProgressBarShowerRunnable implements Runnable {

	private IProgressMonitor monitor;
	private ProgressBarShower s;
	private CPFEditor editor;

	public SaveProgressBarShowerRunnable(ProgressBarShower s,
			IProgressMonitor monitor, CPFEditor editor) {
		this.monitor = monitor;
		this.s = s;
		this.editor = editor;
	}

	public void run() {

		Display.getDefault().syncExec(new Runnable() {

			public void run() {

				try {
					ViewEditorModel viewEditorModel = editor
							.getViewEditorModel();
					ModelSaver.save(editor.getProject(), monitor,
							viewEditorModel.getCpfFilePath(), editor.getView(),
							editor.getSavePath(), s, viewEditorModel
									.getCpfMetadata(), viewEditorModel, editor
									.getSummaryModelroot());
				} catch (Exception e) {

					e.printStackTrace();
				}
				editor.getCommandStack().markSaveLocation();

				editor.setStructuralCommandsSaveLocation(editor
						.getStructuralCommands());
				editor.updateDirtyState(false, false);

			}

		});

	}

}
