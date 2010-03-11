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

import com.nokia.tools.variant.resourcelibrary.views.ResourceLibraryView;
import com.nokia.tools.variant.views.actions.registry.ViewActionRegistry;

public class ResourcesViewAction implements IWorkbenchWindowActionDelegate {

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

				if (part instanceof ResourceLibraryView) {
					
					ResourceLibraryView resourceLibraryView = (ResourceLibraryView) part;
					String id = resourceLibraryView.getViewSite().getId();					
					
					if(id.equals(ResourceLibraryView.ID)) {
						
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
				workbenchPage.showView(ResourceLibraryView.ID);
			} catch (PartInitException e) {
				e.printStackTrace();
			}
			
		} else {
			
			IViewPart viewPart = workbenchPage.findView(ResourceLibraryView.ID);
			workbenchWindow.getActivePage().hideView(viewPart);
			
		}
		
	}

	public void selectionChanged(IAction action, ISelection selection) {
		this.action = action;
		
		ViewActionRegistry viewActionRegistry = ViewActionRegistry.getInstance();
		viewActionRegistry.setAction(ResourceLibraryView.ID, action);
	}


}
