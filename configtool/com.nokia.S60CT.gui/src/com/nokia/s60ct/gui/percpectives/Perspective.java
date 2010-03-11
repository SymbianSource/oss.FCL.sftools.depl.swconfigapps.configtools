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

package com.nokia.s60ct.gui.percpectives;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.IViewDescriptor;

import views.CustomProblemsView;
import views.DescriptionView;

import com.nokia.s60ct.gui.views.SettingEditorView;

public class Perspective implements IPerspectiveFactory {
	
	public static final String ID ="variant.creation.perspectie.id";
	
	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(true);
		
		String editorArea = layout.getEditorArea();
		IViewDescriptor viewDescriptor = PlatformUI.getWorkbench().getViewRegistry().find("cpf.navigator");
		if(viewDescriptor!=null){
			IFolderLayout left = layout.createFolder("left", IPageLayout.LEFT, .20f, editorArea);
			left.addView("cpf.navigator");
			try{
				viewDescriptor.createView();
			}catch(CoreException e){
				System.out.println(e.getMessage());
			}
		}
		
		IFolderLayout top = layout.createFolder("top", IPageLayout.RIGHT, .20f, editorArea);
		IFolderLayout center = layout.createFolder("center", IPageLayout.BOTTOM, .70f, "top");
		IFolderLayout centerLeft = layout.createFolder("centerleft", IPageLayout.LEFT, .70f, "center");
		
		top.addView(SettingEditorView.ID);
		
		center.addView(DescriptionView.ID);
		centerLeft.addView(IPageLayout.ID_PROP_SHEET);
		centerLeft.addView(CustomProblemsView.ID);
		centerLeft.addPlaceholder(IPageLayout.ID_PROGRESS_VIEW);
		
		layout.addShowViewShortcut(SettingEditorView.ID);
		layout.addShowViewShortcut(DescriptionView.ID);
	}
	
}
