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

package com.nokia.s60ct.cenrep.gui.perspective;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import views.CustomProblemsView;
import views.DescriptionView;
import views.OptionView;

import com.nokia.s60ct.cenrep.gui.view.AccessView;
import com.nokia.s60ct.cenrep.gui.view.BitmaskKeyView;
import com.nokia.s60ct.cenrep.gui.view.RangeKeyView;
import com.nokia.s60ct.cenrep.gui.view.SimpleKeyView;

public class DeveloperPerspective implements IPerspectiveFactory {
	
	public static final String ID = "configuration.definition.perspective.id";
	public static final String SETTING_EDITOR_VIEW_ID="com.nokia.S60CT.gui.SettingEditor";
	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		
		IFolderLayout top = layout.createFolder("top", IPageLayout.RIGHT, .20f, editorArea);
		IFolderLayout center = layout.createFolder("center", IPageLayout.BOTTOM, .40f, "top");
		IFolderLayout bottom = layout.createFolder("bottom", IPageLayout.BOTTOM, .50f, "center");
		
		IFolderLayout centerLeft = layout.createFolder("centerLeft", IPageLayout.LEFT, .70f, "center");

		top.addView(SETTING_EDITOR_VIEW_ID);
		
		centerLeft.addView(SimpleKeyView.ID);
		centerLeft.addView(BitmaskKeyView.ID);
		centerLeft.addView(RangeKeyView.ID);
		
		center.addView(AccessView.ID);
		center.addView(OptionView.ID);
		center.addView(DescriptionView.ID);
		
		bottom.addView(IPageLayout.ID_PROP_SHEET);
		bottom.addView(CustomProblemsView.ID);
		
		layout.addShowViewShortcut(SETTING_EDITOR_VIEW_ID);
		layout.addShowViewShortcut(OptionView.ID);
		layout.addShowViewShortcut(DescriptionView.ID);
		layout.addShowViewShortcut(AccessView.ID);
		
	}

}
