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

package com.nokia.s60ct.cenrep.gui;

import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;


public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	private String getString(String key) {
		return CenRepPlugin.INSTANCE.getString(key);
	}
	
    public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
    }

    protected void makeActions(IWorkbenchWindow window) {
    }

    protected void fillMenuBar(IMenuManager menuBar) {
    	IWorkbenchWindow window = getActionBarConfigurer().getWindowConfigurer().getWindow();
		menuBar.add(createFileMenu(window));
		menuBar.add(createEditMenu(window));
		MenuManager fileMenu = new MenuManager("&File","_file_");
    	
		MenuManager newMenu = new MenuManager("&New...", "_new_");
    	MenuManager openMenu = new MenuManager("&Open...", "_new_");
    	MenuManager viewMenu = new MenuManager("&View","_new_");
    	fileMenu.add(newMenu);
    	fileMenu.add(openMenu);
    	fileMenu.add(viewMenu);
    	menuBar.add(fileMenu);
   	
    }
    
    protected IMenuManager createFileMenu(IWorkbenchWindow window) {
    	IMenuManager menu = new MenuManager(getString("_UI_Menu_File_label"),
    			IWorkbenchActionConstants.M_FILE);
    	menu.add(new GroupMarker(IWorkbenchActionConstants.FILE_START));
    	
    	IMenuManager newMenu = new MenuManager(getString("_UI_Menu_New_label"), "new"); 
		newMenu.add(new Separator("impl"));
    	newMenu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		
    	IMenuManager openMenu = new MenuManager(getString("_UI_Menu_Open_label"),"open");
    	openMenu.add(new Separator("impl"));
    	
		menu.add(newMenu);
		menu.add(new Separator());
		menu.add(openMenu);
		menu.add(new Separator());
		
		menu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		menu.add(new Separator());
		menu.add(new Separator());
		menu.add(new Separator());
		addToMenuAndRegister(menu, ActionFactory.QUIT.create(window));
		menu.add(new GroupMarker(IWorkbenchActionConstants.FILE_END));
    	return menu;
       	
    }
    
    protected IMenuManager createEditMenu(IWorkbenchWindow window) {
    	IMenuManager menu = new MenuManager(getString("_UI_Menu_Edit_label"),
    			IWorkbenchActionConstants.M_EDIT);
    			menu.add(new GroupMarker(IWorkbenchActionConstants.EDIT_START));
    			menu.add(new GroupMarker(IWorkbenchActionConstants.EDIT_END));
    			menu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
    			menu.add(new Separator());
    			menu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
    			
    			return menu;
    }
    
    
    
    protected void addToMenuAndRegister(IMenuManager menuManager, IAction action) {
		menuManager.add(action);
		getActionBarConfigurer().registerGlobalAction(action);			
	}

}
