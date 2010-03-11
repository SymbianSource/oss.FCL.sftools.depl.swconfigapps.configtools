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
package com.nokia.s60ct.gui.actions;

import java.io.File;
import java.util.Iterator;
import java.util.Vector;

import org.eclipse.core.runtime.Preferences;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowPulldownDelegate;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.PluginActionCoolBarContributionItem;

import com.nokia.s60ct.generate.GenerateManager;
import com.nokia.s60ct.gui.Activator;
import com.nokia.s60ct.gui.editors.ConfigurationBrowser;
import com.nokia.s60ct.gui.preferences.PreferenceConstants;
import com.nokia.s60ct.gui.views.CleanDialog;
import com.nokia.s60ct.gui.views.ReportDialog;

import configurationemf.RootConf;

public class GenerateAll implements IObjectActionDelegate, IWorkbenchWindowPulldownDelegate {
	
	static final String POPUP_ACTION = "com.nokia.S60CT.generate.popupAction";
	static final String MENU_ACTION = "com.nokia.S60CT.generate.menuAction";
	
	RootConf rootConf = null;

	private static Vector editors = new Vector();
	
	private MenuSelectionListener selectionListener = new MenuSelectionListener();
	private boolean cleanOutput;

	private static Menu menu;
	
	private static ToolItem generateToolButton = null; //Dropdown menu must be clicked first or this remains null

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {

	}

	public void run(IAction action)
	{
		Preferences store = Activator.getDefault().getPluginPreferences();
		boolean dontShow = store.getBoolean(PreferenceConstants.DISPLAY_CLEANUP_DIALOG);
		if(!dontShow)
		{
			String outputFolder = GenerateManager.getCleanedOutputFolders()[0];
			File folder = new File(outputFolder);
			if (folder.exists())
			{
				Shell activeShell = PlatformUI.getWorkbench().getDisplay().getActiveShell();
				CleanDialog cleanDialog = new CleanDialog(activeShell, outputFolder);
				cleanOutput = cleanDialog.displayDialog();			
				if(cleanDialog.getCheckBoxStatus())
				{
					store.setValue(PreferenceConstants.DISPLAY_CLEANUP_DIALOG, true);
				
				}
			}		
		} 
		else 
		{
			cleanOutput=true;
		}
		
//		return;
		if (action.getId().equals(POPUP_ACTION))
		{
			generateConfiguration(this.rootConf, cleanOutput);
		}
		else if (action.getId().equals(MENU_ACTION))
		{
			findConfigurationBrowser();
			
			EList<Resource> resources = ((ConfigurationBrowser)editors.elementAt(0)).getEditingDomain().getResourceSet().getResources();
			if (!resources.isEmpty())
			{
				if (!resources.get(0).getContents().isEmpty())
				{
					Object rootConf = resources.get(0).getContents().get(0);
					if(rootConf instanceof RootConf && ((RootConf)rootConf).getRoot()==null)
					{
						generateConfiguration((RootConf)rootConf, cleanOutput);
					}
				}
			}
		}
	}

	private void generateConfiguration(RootConf rootConf, boolean cleanOutput) {
		
		Display display = PlatformUI.getWorkbench().getDisplay();
		
		final Cursor cursorWait = new Cursor(display, SWT.CURSOR_WAIT);
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().setCursor(cursorWait);
		
		Vector reports = GenerateManager.getInstance().generateConfiguration(rootConf, cleanOutput);
		if (reports != null)
			new ReportDialog(Display.getCurrent(), reports);
		sortEditors((RootConf)rootConf);
		
		final Cursor cursorArrow = new Cursor(display, SWT.CURSOR_ARROW);
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().setCursor(cursorArrow);
	}

	
	
	public void selectionChanged(IAction action, ISelection selection)
	{
		findConfigurationBrowser();
		if (editors.size() > 0)
			action.setEnabled(true);
		else
		{
			action.setEnabled(false);
			if (generateToolButton!= null)
				generateToolButton.setToolTipText("Generate All...");
		}
		
		if(selection instanceof IStructuredSelection) 
		{  
			IStructuredSelection structedSelection = (IStructuredSelection)selection;  
			for (Iterator iterator = structedSelection.iterator(); iterator.hasNext();)
			{  
				Object object =  iterator.next();  
                if(object instanceof RootConf)  
                {  
                    RootConf rc = (RootConf)object;  
                    boolean rootConfFound = false;  
                    do //find the root configuration  
                      {  
                         if (rc.getRoot()==null)  
                             {  
                                      this.rootConf= rc;   
                                      rootConfFound = true;  
                              }  
                              else  
                              {  
                                      rc = rc.getRoot();  
                              }  
                      }while (!rootConfFound);  
                  }    
             } 
		}
	}
	
	
	private void findConfigurationBrowser()
	{
		try
		{
			Vector tempList = new Vector();
			IWorkbenchPage[] pages = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPages();
			for(IWorkbenchPage page : pages)
			{
				for(IEditorReference eref :page.getEditorReferences())
				{
					if(eref.getId().compareTo(ConfigurationBrowser.ID)==0)
					{
						ConfigurationBrowser tempListCB = (ConfigurationBrowser)eref.getEditor(true);
						if (tempListCB == null)
							continue;
						tempList.add(tempListCB);
						boolean found = false;
						for (int j = 0 ; j < editors.size() ; j++)
						{
							ConfigurationBrowser editorListCB = (ConfigurationBrowser)editors.elementAt(j);
							if (editorListCB!= null && editorListCB.equals(tempListCB))
							{
								found = true;
								break;
							}
						}
						if (!found)
							editors.addElement(tempListCB);
					}
				}
			}
			for (int i = 0 ; i < editors.size() ; i++)
			{
				ConfigurationBrowser editorListCB = (ConfigurationBrowser)editors.elementAt(i);
				boolean found = false;
				for (int j = 0 ; j < tempList.size() ; j++)
				{
					ConfigurationBrowser tempListCB = (ConfigurationBrowser)tempList.elementAt(j);
					if (editorListCB.equals(tempListCB))
					{
						found = true;
						break;
					}
				}
				if (!found)
					editors.removeElementAt(i);
			}
		}
		catch (java.lang.IllegalStateException ise)
		{
			
		}
	}
	
	private void sortEditors(RootConf firstRootConf)
	{
		if (editors.size()==1)
			return;
		
		for (int i = 0 ; i < editors.size() ; i++)
		{
			EList<Resource> resources = ((ConfigurationBrowser)editors.elementAt(i)).getEditingDomain().getResourceSet().getResources();
			if (!resources.isEmpty())
			{
				if (!resources.get(0).getContents().isEmpty())
				{
					Object rc = resources.get(0).getContents().get(0);
					if(rc instanceof RootConf)
					{
						RootConf rootConf = (RootConf)rc;
						if (rootConf.equals(firstRootConf))
						{
							if (generateToolButton!= null)
								generateToolButton.setToolTipText("Generate All... ("+rootConf.getName()+")"); //same text could be also in Tools menu
							if (1==0)
								return;
							Object o = editors.elementAt(i);
							editors.removeElementAt(i);
							editors.add(0, o);
						}
					}
				}
			}
		}
	}
	
	@Override
	public Menu getMenu(Control parent)
	{
		findConfigurationBrowser();
		menu = new Menu(parent);
		
		if (generateToolButton==null)
		{//find the generate all tool bar button so we can update the tool tip.
			ToolBar tb = (ToolBar)parent;
			for (ToolItem item : tb.getItems())
			{
				Object data = item.getData();
				if (data instanceof PluginActionCoolBarContributionItem)
				{
					if (((PluginActionCoolBarContributionItem)data).getId().equals("com.nokia.S60CT.generate.menuAction"))
						generateToolButton = item;
				}
			}
		}
		
		for (int i = 0 ; i < editors.size() ; i++)
		{
			EList<Resource> resources = ((ConfigurationBrowser)editors.elementAt(i)).getEditingDomain().getResourceSet().getResources();
			if (!resources.isEmpty())
			{
				if (!resources.get(0).getContents().isEmpty())
				{
					Object rootConf = resources.get(0).getContents().get(0);
					if(rootConf instanceof RootConf && ((RootConf)rootConf).getRoot()==null)
					{
						MenuItem generateMenuItem = new MenuItem(menu, SWT.NULL);
						generateMenuItem.setText(((RootConf)rootConf).getName());
						generateMenuItem.addSelectionListener(selectionListener);
						generateMenuItem.setData((RootConf)rootConf);
						if (i==0)
							generateToolButton.setToolTipText("Generate All... ("+((RootConf)rootConf).getName()+")"); //same text could be also in Tools menu
					}
				}
			}
		}
		return menu;
	}

	@Override
	public void dispose()
	{
		
	}

	@Override
	public void init(IWorkbenchWindow window)
	{
		
	}
	
	
	private class MenuSelectionListener implements SelectionListener 
	{
		public void widgetDefaultSelected(SelectionEvent e)
		{
		}

		public void widgetSelected(SelectionEvent e)
		{
			MenuItem item = (MenuItem)e.widget;

			if (item != null)
			{
				RootConf rootConf = (RootConf)item.getData();
				generateConfiguration((RootConf)rootConf, cleanOutput);
			}
		}
	}

}
