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
package com.nokia.s60ct.gui;

import java.net.URL;

import org.eclipse.emf.common.ui.action.WorkbenchWindowActionDelegate;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarContributionItem;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ContributionItemFactory;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

import com.nokia.s60ct.gui.filter.ReadOnlyFilter;
import com.nokia.s60ct.gui.views.AboutDialog;


public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

private final URL ICON_SAVE = (URL)S60CtEditorPlugin.INSTANCE.getImage("Save_enabled");
private final URL ICON_SAVE_DISABLED = (URL)S60CtEditorPlugin.INSTANCE.getImage("Save_disabled");

private final URL ICON_SAVE_AS = (URL)S60CtEditorPlugin.INSTANCE.getImage("Save_As_enabled");
private final URL ICON_SAVE_AS_DISABLED = (URL)S60CtEditorPlugin.INSTANCE.getImage("Save_As_disabled");

private final URL ICON_SAVE_ALL = (URL)S60CtEditorPlugin.INSTANCE.getImage("Save_All_enabled");
private final URL ICON_SAVE_ALL_DISABLED = (URL)S60CtEditorPlugin.INSTANCE.getImage("Save_All_disabled");

private final URL ICON_COPY = (URL)S60CtEditorPlugin.INSTANCE.getImage("Copy_enabled");
private final URL ICON_COPY_DISABLED = (URL)S60CtEditorPlugin.INSTANCE.getImage("Copy_disabled");

private final URL ICON_PASTE = (URL)S60CtEditorPlugin.INSTANCE.getImage("Paste_enabled");
private final URL ICON_PASTE_DISABLED = (URL)S60CtEditorPlugin.INSTANCE.getImage("Paste_disabled");

private final URL ICON_FIND = (URL)S60CtEditorPlugin.INSTANCE.getImage("Find_enabled");
private final URL ICON_FIND_DISABLED = (URL)S60CtEditorPlugin.INSTANCE.getImage("Find_disabled");

private static IAction save = null;
private static IAction saveAs = null;
private static IAction saveAll = null;

private static IAction copy = null;
private static IAction paste = null;

private static IAction find = null;
private static IAction findAgain = null;

	
	private static String getString(String key) {
		return S60CtEditorPlugin.INSTANCE.getString(key);
	}
	
	
	
	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
        
	}

    protected void makeActions(IWorkbenchWindow window) {
    	
    	save = ActionFactory.SAVE.create(window);
		save.setImageDescriptor(ImageDescriptor.createFromURL(ICON_SAVE));
		save.setDisabledImageDescriptor(ImageDescriptor.createFromURL(ICON_SAVE_DISABLED));
		
		saveAs = ActionFactory.SAVE_AS.create(window);
		saveAs.setImageDescriptor(ImageDescriptor.createFromURL(ICON_SAVE_AS));
		saveAs.setDisabledImageDescriptor(ImageDescriptor.createFromURL(ICON_SAVE_AS_DISABLED));
		
		saveAll = ActionFactory.SAVE_ALL.create(window);
		saveAll.setImageDescriptor(ImageDescriptor.createFromURL(ICON_SAVE_ALL));
		saveAll.setDisabledImageDescriptor(ImageDescriptor.createFromURL(ICON_SAVE_ALL_DISABLED));
		
		copy = ActionFactory.COPY.create(window);
		copy.setEnabled(true);
		copy.setImageDescriptor(ImageDescriptor.createFromURL(ICON_COPY));
		copy.setDisabledImageDescriptor(ImageDescriptor.createFromURL(ICON_COPY_DISABLED));
		
		paste = ActionFactory.PASTE.create(window);
		paste.setEnabled(true);
		paste.setImageDescriptor(ImageDescriptor.createFromURL(ICON_PASTE));
		paste.setDisabledImageDescriptor(ImageDescriptor.createFromURL(ICON_PASTE_DISABLED));
		
		find = ActionFactory.FIND.create(window);
		find.setEnabled(true);
		find.setImageDescriptor(ImageDescriptor.createFromURL(ICON_FIND));
		find.setDisabledImageDescriptor(ImageDescriptor.createFromURL(ICON_FIND_DISABLED));
		
		
    }
    
    protected void fillCoolBar(ICoolBarManager coolBar) {
    	
		IToolBarManager mng = new ToolBarManager(coolBar.getStyle());
		
		ToolBarContributionItem tbci = new ToolBarContributionItem(mng, "MainToolBar"); //without this the ID is null
		
		coolBar.add(tbci);
		
		mng.add(new GroupMarker(IWorkbenchActionConstants.NEW_GROUP));
		mng.add(new Separator());
		mng.add(new GroupMarker(IWorkbenchActionConstants.OPEN_EXT));
		mng.add(new Separator());
		mng.add(new GroupMarker(IWorkbenchActionConstants.SAVE_GROUP));
		mng.appendToGroup(IWorkbenchActionConstants.SAVE_GROUP, save);
		//mng.appendToGroup(IWorkbenchActionConstants.SAVE_GROUP, saveAs);
		mng.appendToGroup(IWorkbenchActionConstants.SAVE_GROUP, saveAll);
		mng.add(new Separator());
	
		//mng.add(new GroupMarker("Edit"));
		//mng.appendToGroup("Edit", copy);
		//mng.appendToGroup("Edit", paste);
		//mng.appendToGroup("Edit", find);
		//mng.add(new Separator());
		
		mng.add(new GroupMarker("Tools"));
		
    }

	protected void fillMenuBar(IMenuManager menuBar) {
    	IWorkbenchWindow window = getActionBarConfigurer().getWindowConfigurer().getWindow();
    	
    	menuBar.add(createCustomFileMenu(window));
    	menuBar.add(createEditMenu(window));
		//menuBar.add( createViewMenu( window ) );
		menuBar.add(createToolsMenu(window));
		menuBar.add(createWindowMenu(window));
		menuBar.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		menuBar.add(createHelpMenu(window));
	}
    
	protected IMenuManager createHelpMenu(IWorkbenchWindow window) {
		IMenuManager menu = new MenuManager(getString("_UI_Menu_Help_label"), IWorkbenchActionConstants.M_HELP);
		menu.add(new GroupMarker(IWorkbenchActionConstants.HELP_START));
		menu.add(new GroupMarker(IWorkbenchActionConstants.HELP_END));
		menu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		return menu;
	}
    
    protected IMenuManager createWindowMenu(IWorkbenchWindow window) {
    	IMenuManager menu = new MenuManager(getString("_UI_Menu_Window_label"),IWorkbenchActionConstants.M_WINDOW);

    	/* perspective menu */
    	IMenuManager openPerspective = new MenuManager("Open Perspective","perspective");
    	openPerspective.add(ActionFactory.OPEN_PERSPECTIVE_DIALOG.create(window));
    	menu.add(openPerspective);
    	
    	/* Show view menu item */
    	IMenuManager showView = new MenuManager("Show View", "view"); 
    	showView.add(ContributionItemFactory.VIEWS_SHORTLIST.create(window));
    	menu.add(showView);
    	menu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
    	
    	menu.add(ActionFactory.PREFERENCES.create(window));
    	
    	return menu;
    }
    
    protected IMenuManager createToolsMenu(IWorkbenchWindow window) {
    	IMenuManager menu = new MenuManager(getString("_UI_Menu_Tools_label"),"Tools");
    	menu.add(new GroupMarker("Generate"));
    	menu.add(new Separator());
    	menu.add(new GroupMarker("Validation"));
    	return menu;
    }
    
    protected IMenuManager createCustomFileMenu(IWorkbenchWindow window) {
    	IMenuManager menu = new MenuManager(getString("_UI_Menu_File_label"),"CustomFile"); //if the ID is "File" we automatically get the "Open File..." menu item
    	
    	IMenuManager newMenu = new MenuManager(getString("_UI_Menu_New_label"), "New"); 
    	newMenu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		
		IMenuManager openMenu = new MenuManager(getString("_UI_Menu_Open_label"),"Open");
		openMenu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		openMenu.add(new Separator("impl"));
		//add New
		menu.add(newMenu);
		menu.add(new Separator());
		//add Open
		menu.add(openMenu);
		menu.add(new Separator());
		
		addToMenuAndRegister(menu, ActionFactory.CLOSE.create(window));
		addToMenuAndRegister(menu, ActionFactory.CLOSE_ALL.create(window));
		menu.add(new Separator());
    	
		addToMenuAndRegister(menu, save);
		addToMenuAndRegister(menu, saveAs);
		addToMenuAndRegister(menu, saveAll);
		menu.add(new Separator());
		menu.add(new GroupMarker("ImportExport"));
		menu.add(new Separator());
		addToMenuAndRegister(menu, ActionFactory.QUIT.create(window));
		
    	return menu;
    }

    protected IMenuManager createEditMenu(IWorkbenchWindow window) {
		IMenuManager menu = new MenuManager(getString("_UI_Menu_Edit_label"),
		IWorkbenchActionConstants.M_EDIT);
		menu.add(new GroupMarker(IWorkbenchActionConstants.EDIT_START));
		//addToMenuAndRegister(menu, copy);
		//addToMenuAndRegister(menu, paste);
		//menu.add(new Separator());
		//addToMenuAndRegister(menu, find);
		menu.add(new GroupMarker(IWorkbenchActionConstants.EDIT_END));
		menu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		return menu;
	}
    
    
    protected IMenuManager createViewMenu( IWorkbenchWindow window )
    {
		IMenuManager menu = new MenuManager( getString( "_UI_Menu_View_label") , "view" );
		ViewROAction action = new ViewROAction();
		addToMenuAndRegister( menu, action );
    	return menu;
	}
    
    protected void addToMenuAndRegister(IMenuManager menuManager, IAction action) {
		menuManager.add(action);
		getActionBarConfigurer().registerGlobalAction(action);			
	}
    
    public static class AboutAction extends WorkbenchWindowActionDelegate {
		public void run(IAction action) {
			
			AboutDialog aboutDialog = new AboutDialog(getWindow().getShell());
			aboutDialog.open();
			
		}
	}
    
    public static class ViewROAction extends Action
    {
    	public ViewROAction()
    	{
    		super( getString( "_UI_Menu_View_ShowRO_label"), IAction.AS_CHECK_BOX );
    		this.setChecked( true );
    	}
    	
    	public void run()
    	{
    		ReadOnlyFilter.INSTANCE.setFiltering( !this.isChecked() );
    	}
    }
}
