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
 * Description: This file is part of com.nokia.tools.variant.views component.
 */

package com.nokia.tools.variant.views.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.PropertySheet;

import com.nokia.tools.variant.views.actions.registry.ViewActionRegistry;

public class PropertiesViewAction implements IWorkbenchWindowActionDelegate {

	private String PROPERTY_VIEW_ID = "org.eclipse.ui.views.PropertySheet";
	
	private IAction action;
	
	private IPartListener partListener;
	
	public void dispose() {
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().removePartListener(partListener);
	}

	public void init(IWorkbenchWindow window) {
		partListener = new IPartListener() {

			public void partActivated(IWorkbenchPart part) {
				
			}

			public void partBroughtToTop(IWorkbenchPart part) {
				
			}

			public void partClosed(IWorkbenchPart part) {

				if (part instanceof PropertySheet) {
					
					PropertySheet propertiesView = (PropertySheet) part;
					String id = propertiesView.getViewSite().getId();					
					
					if(id.equals(PROPERTY_VIEW_ID)) {
						
						action.setChecked(false);
						
					}
					
				}
				
			}

			public void partDeactivated(IWorkbenchPart part) {
				
			}

			public void partOpened(IWorkbenchPart part) {
				
			}
			
		};
		
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().addPartListener(partListener);
	}

	public void run(IAction action) {
		
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
		IWorkbenchPage workbenchPage = workbenchWindow.getActivePage();
		
		if(action.isChecked()) {
			
			try {
				workbenchPage.showView(PROPERTY_VIEW_ID);
			} catch (PartInitException e) {
				e.printStackTrace();
			}
			
		} else {
			
			IViewPart viewPart = workbenchPage.findView(PROPERTY_VIEW_ID);
			workbenchWindow.getActivePage().hideView(viewPart);
			
		}
		
	}

	public void selectionChanged(IAction action, ISelection selection) {
		this.action = action;
		
		ViewActionRegistry viewActionRegistry = ViewActionRegistry.getInstance();
		viewActionRegistry.setAction(PROPERTY_VIEW_ID, action);
	}


}
