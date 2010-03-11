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

package com.nokia.tools.vct.confml.editor.view.actions;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import com.nokia.tools.variant.confml.ui.ConfmlUI;
import com.nokia.tools.variant.confml.ui.editors.EditorUtils;
import com.nokia.tools.vct.confml.editor.view.ViewsEditor;
import com.nokia.tools.vct.confml.editor.view.vemodel.EView;

public class OpenConfMLViewEditor extends Action {

	private ViewsEditor editor;
	
	public OpenConfMLViewEditor(ViewsEditor editor)
	{
		this.editor = editor;
		setText("Open View Editor");
	}
	
	public void run() {

		IStructuredSelection selection = (IStructuredSelection) editor
		.getViewTv().getSelection();
		
		if (!(selection instanceof IStructuredSelection) || selection == null) {
			return;
		}
		Object obj = ((IStructuredSelection) selection).getFirstElement();

		String editorId = null;
		URI uri = null;
		if (obj instanceof EView) 
		{
			uri = URI.createPlatformResourceURI(((EView)obj).getFileURI(), false);
		}
		if (uri != null) {
			uri = uri.trimFragment();
			editorId = ConfmlUI.VIEW_EDITOR_ID;
			EditorUtils.openEditor(uri, editorId);
		}
	}

}
