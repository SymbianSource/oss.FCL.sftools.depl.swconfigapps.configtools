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

package com.nokia.tools.vct.internal.common.secure.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

import com.nokia.tools.vct.internal.common.secure.ui.editor.KeyManagerEditor;
import com.nokia.tools.vct.internal.common.secure.ui.editor.KeyManagerEditorInput;

public class OpenKeyManagerHandler extends AbstractHandler implements IHandler {

	public OpenKeyManagerHandler() {
		super();
	}
	
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchPage page = HandlerUtil
				.getActiveWorkbenchWindowChecked(event).getActivePage();

		IEditorReference[] refs = page.findEditors(null,
				KeyManagerEditor.EDITOR_ID, IWorkbenchPage.MATCH_ID);
		IEditorPart editor = null;
		if (refs.length > 0) {
			editor = refs[0].getEditor(true);
			page.activate(editor);
		}

		if (editor == null) {
			try {
				editor = page.openEditor(KeyManagerEditorInput.INSTANCE,
						KeyManagerEditor.EDITOR_ID, true);
			} catch (PartInitException e) {
				throw new ExecutionException("Can not open Key Manager", e);
			}
		}

		return null;
	}

}
