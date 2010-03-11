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
package search.ui.handlers;

import java.util.Arrays;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.search.ui.handlers.AbstractModelElementEditorSelectionHandler;
import org.eclipse.ui.IEditorPart;

import com.nokia.tools.vct.ibyml.ibymodel.presentation.EIBYModelEditor;

/**
 * Defines entity responsible of editor selection handling.
 * 
 * In other words users defines here how the search double clicked result will be handled in 
 * terms of corresponding editor selection.
 *  
 */
public class EditorSelectionHandler extends
		AbstractModelElementEditorSelectionHandler {

	public boolean isCompatibleModelElementEditorSelectionHandler(
			IEditorPart part) {
		return (part instanceof EIBYModelEditor);
	}

	public IStatus handleOpenTreeEditorWithSelection(IEditorPart part,
			Object selection) {

		if (part instanceof EIBYModelEditor) {
			((EIBYModelEditor) part).setSelectionToViewer(Arrays
					.asList(new Object[] { selection }));
			return Status.OK_STATUS;
		}

		return Status.CANCEL_STATUS;
	}

	@Override
	protected String getNsURI() {
		return ""; //  user to return appropriate nsURI
	}
}
