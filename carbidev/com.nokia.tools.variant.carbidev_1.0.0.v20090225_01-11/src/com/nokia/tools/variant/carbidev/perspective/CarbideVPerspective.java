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
 * Description: This file is part of com.nokia.tools.variant.carbidev component.
 */

package com.nokia.tools.variant.carbidev.perspective;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import com.nokia.tools.variant.preview.ui.PreviewView;
import com.nokia.tools.variant.resourcelibrary.views.ResourceLibraryView;
import com.nokia.tools.variant.views.changesview.ChangesView;
import com.nokia.tools.variant.views.errorview.ErrorsView;
import com.nokia.tools.variant.views.notesview.NotesView;
import com.nokia.tools.variant.views.searchresultsview.SearchResultsView;

/**
 * Default perspective for Carbide.V, v.2.
 *
 */
public class CarbideVPerspective implements IPerspectiveFactory {

	public static final String PERSPECTIVE_ID = "com.nokia.tools.variant.carbidev.perspective";
	private String PROPERTY_VIEW_ID = "org.eclipse.ui.views.PropertySheet";

	public void createInitialLayout(IPageLayout layout) {

		String editorArea = layout.getEditorArea();

		layout.addView(PreviewView.VIEW_ID, IPageLayout.RIGHT, 0.73f,
				editorArea);

		layout.addView(PROPERTY_VIEW_ID, IPageLayout.TOP, 0.35f,
				PreviewView.VIEW_ID);

		layout.addView(ResourceLibraryView.ID, IPageLayout.BOTTOM, 0.45f,
				PreviewView.VIEW_ID);

		IFolderLayout bottom = layout.createFolder("bottom",
				IPageLayout.BOTTOM, 0.75f, editorArea);
		
		bottom.addView(ErrorsView.VIEW_ID);
		bottom.addView(NotesView.VIEW_ID);
		bottom.addView(ChangesView.VIEW_ID);
		bottom.addView(SearchResultsView.VIEW_ID);
		
	}

}
