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

import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.FileTransfer;

import com.nokia.tools.variant.editor.actions.OpenCpfAction;

public class DropListener extends DropTargetAdapter {
	public static DropListener instance = new DropListener();

	@Override
	public void dragEnter(DropTargetEvent event) {
		String[] data = (String[]) FileTransfer.getInstance().nativeToJava(
				event.dataTypes[0]);
		File cpffile = new File(data[0]);
		if (cpffile.exists() && cpffile.getPath().endsWith(".cpf")) {
			event.detail = DND.DROP_COPY;
		} else {
			event.detail = DND.DROP_NONE;
		}

	}

	@Override
	public void dropAccept(DropTargetEvent event) {
		String[] data = (String[]) FileTransfer.getInstance().nativeToJava(
				event.dataTypes[0]);
		OpenCpfAction action = new OpenCpfAction();
		action.importProject(data[0]);
		super.dropAccept(event);
	}

}
