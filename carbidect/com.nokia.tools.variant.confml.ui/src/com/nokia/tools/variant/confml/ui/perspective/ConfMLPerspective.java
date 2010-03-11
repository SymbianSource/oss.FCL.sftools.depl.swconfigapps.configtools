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

package com.nokia.tools.variant.confml.ui.perspective;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.navigator.resources.ProjectExplorer;

/**
 * Generic perspective factory for ConfML operations
 * 
 */
public class ConfMLPerspective implements IPerspectiveFactory {

	/** Perspective ID */
	public static final String PERSPECTIVE_ID = "com.nokia.tools.variant.confml.ui.ConfML";

	/**
	 * @see IPerspectiveFactory#createInitialLayout(IPageLayout)
	 */
	public void createInitialLayout(IPageLayout layout) {
		// Get the editor area.
		String editorArea = layout.getEditorArea();

		IFolderLayout topLeft = layout.createFolder("topLeft",
				IPageLayout.LEFT, 0.25f, editorArea);
		topLeft.addView(ProjectExplorer.VIEW_ID);

		IFolderLayout topRight = layout.createFolder("topRight", IPageLayout.RIGHT, 0.7f, editorArea);
		topRight.addView(IPageLayout.ID_OUTLINE);
		
//		IFolderLayout bottomLeft = layout.createFolder("bottomLeft",
//				IPageLayout.BOTTOM, 0.50f, "topLeft");
//		bottomLeft.addView(IPageLayout.ID_OUTLINE);

		IFolderLayout bottom = layout.createFolder("bottom",
				IPageLayout.BOTTOM, 0.8f, editorArea);
		bottom.addView(IPageLayout.ID_PROP_SHEET);
		bottom.addPlaceholder(IPageLayout.ID_BOOKMARKS);
		bottom.addPlaceholder(IPageLayout.ID_TASK_LIST);
		// bottom.addView(IPageLayout.ID_TASK_LIST);
		// bottom.addView(IPageLayout.ID_BOOKMARKS);
		bottom.addView(IPageLayout.ID_PROBLEM_VIEW);
		bottom.addView("com.nokia.tools.s60ct.confml.editor.notesView");
	}

}
