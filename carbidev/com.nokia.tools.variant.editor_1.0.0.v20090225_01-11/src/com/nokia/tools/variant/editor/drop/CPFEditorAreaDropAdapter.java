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

package com.nokia.tools.variant.editor.drop;

import java.io.File;

import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.internal.ide.EditorAreaDropAdapter;

import com.nokia.tools.variant.editor.actions.OpenCpfAction;

@SuppressWarnings("restriction")
public class CPFEditorAreaDropAdapter extends EditorAreaDropAdapter {
	public CPFEditorAreaDropAdapter(IWorkbenchWindow window) {
		super(window);

	}

	@Override
	public void drop(DropTargetEvent event) {
		String[] data = (String[]) FileTransfer.getInstance().nativeToJava(
				event.dataTypes[0]);

		for (String fileCpfPath : data) {
			if (fileCpfPath.toLowerCase().endsWith(".cpf")) {
				OpenCpfAction action = new OpenCpfAction();
				action.importProject(fileCpfPath);

			}
		}
	}

	public void dragEnter(DropTargetEvent event) {
//		if (checkFile(event.dataTypes[0])) {
		if (FileTransfer.getInstance().isSupportedType(event.dataTypes[0])){
			String[] data = (String[]) FileTransfer.getInstance().nativeToJava(
					event.dataTypes[0]);

			for (String fileCpfPath : data) {
				File cpfFile = new File(fileCpfPath);
				if (!(cpfFile.exists() && cpfFile.getPath().endsWith(".cpf"))) {
					return;
				}
			}
		}
		super.dragEnter(event);
	}

	boolean checkFile(Object object) {
		if (object == null || !(object instanceof String[])
				|| ((String[]) object).length == 0)
			return false;
		String[] strings = (String[]) object;
		for (int i = 0; i < strings.length; i++) {
			if (strings[i] == null || strings[i].length() == 0)
				return false;
		}
		return true;
	}

	public void dragOver(DropTargetEvent event) {
		if (FileTransfer.getInstance().isSupportedType(event.dataTypes[0])){
			String[] data = (String[]) FileTransfer.getInstance().nativeToJava(
					event.dataTypes[0]);

			for (String fileCpfPath : data) {
				File cpfFile = new File(fileCpfPath);
				if (!(cpfFile.exists() && cpfFile.getPath().endsWith(".cpf"))) {
					return;
				}
			}
		}
		super.dragOver(event);

	}

	public void dragOperationChanged(DropTargetEvent event) {
		String[] data = (String[]) FileTransfer.getInstance().nativeToJava(
				event.dataTypes[0]);

		for (String fileCpfPath : data) {
			File cpfFile = new File(fileCpfPath);
			if (!(cpfFile.exists() && cpfFile.getPath().endsWith(".cpf"))) {
				return;
			}
		}
		super.dragOperationChanged(event);
	}
}
