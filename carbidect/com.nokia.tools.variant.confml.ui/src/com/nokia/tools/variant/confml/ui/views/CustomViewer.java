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
package com.nokia.tools.variant.confml.ui.views;

import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.TypedListener;
import org.eclipse.ui.navigator.CommonViewer;
import org.eclipse.ui.navigator.CommonViewerSorter;

import com.nokia.tools.variant.confml.ui.views.ConfMLNavigator.Features;
import com.nokia.tools.variant.confml.ui.views.ConfMLNavigator.Views;
import com.nokia.tools.vct.common.appmodel.EAppFeature;
import com.nokia.tools.vct.common.appmodel.EAppGroup;
import com.nokia.tools.vct.common.appmodel.EAppSetting;
import com.nokia.tools.vct.common.appmodel.EAppView;

public class CustomViewer extends CommonViewer {

	public CustomViewer(String viewerId, Composite parent, int style) {
		super(viewerId, parent, style);
	}

	@Override
	public void refresh() 
	{
		if (this.isBusy())
			return;
		TreeItem selectedItem = null;
		String selectedItemText = null;
		if (getTree().getSelectionCount()==1)
		{
			selectedItem = getTree().getSelection()[0];
			Object data = selectedItem.getData();
			if (data instanceof Features || data instanceof Views || data instanceof EAppView 
			|| data instanceof EAppGroup || data instanceof EAppFeature || data instanceof EAppSetting)
			{
				selectedItemText = selectedItem.getText();
				selectedItem = null;
			}
		}
		
		Object[] expandedObjects = getExpandedElements();
		
		super.refresh();

		setExpandedElements(expandedObjects);
	
		for (int i = 0 ; i < expandedObjects.length ; i++)
		{
			Object o = expandedObjects[i];	
			if (o instanceof Features)
			{
				TreeItem[] treeItems = getTree().getItems();
				recursiveExpand(treeItems, "All Features");
			}
			else if (o instanceof Views)
			{
				TreeItem[] treeItems = getTree().getItems();
				recursiveExpand(treeItems, "Views");
			}
			else if (o instanceof EAppView)
			{
				EAppView view =(EAppView)o;
				TreeItem[] treeItems = getTree().getItems();
				recursiveExpand(treeItems, view.getName());
			}
			else if (o instanceof EAppGroup)
			{
				EAppGroup group =(EAppGroup)o;
				TreeItem[] treeItems = getTree().getItems();
				recursiveExpand(treeItems, group.getName());
			}
		}
		if (selectedItem!=null)
		{
			getTree().setSelection(selectedItem);
			getTree().showItem(selectedItem);
		}
		else if (selectedItemText != null)
		{
			TreeItem[] treeItems = getTree().getItems();
			recursiveSelectItem(treeItems, selectedItemText);
		}
	}
	
	private boolean recursiveSelectItem(TreeItem[] treeItems, String text)
	{
		for (int j = 0 ; j < treeItems.length ; j++)
		{
			final TreeItem item = treeItems[j];
			if (item.getText().equals(text))
			{
				getTree().setSelection(item);
				getTree().showItem(item);
				return true;
			}
			if (recursiveSelectItem(item.getItems(), text))
				return true;
		}
		return false;
	}
	
	private void recursiveExpand(TreeItem[] treeItems, String s)
	{
		for (int j = 0 ; j < treeItems.length ; j++)
		{
			final TreeItem item = treeItems[j];
			if (item.getText().equals(s))
			{
				item.setExpanded(true);
				Listener[] listeners = getTree().getListeners(SWT.Expand);
				for (int i = 0 ; i < listeners.length ; i++)
				{
					if (listeners[i] instanceof TypedListener)
					{
						TypedListener tl = (TypedListener)listeners[i];
						Event e = new Event();
						e.item = item;
						e.type = SWT.Expand;
						e.widget = getTree();
						tl.handleEvent(e);
					}
				}
				return;
			}
			recursiveExpand(item.getItems(), s);
		}
	}
	
	public void setSorter(ViewerSorter sorter) {
//		if (sorter != null && sorter instanceof CommonViewerSorter) {
//			
//			((CommonViewerSorter) sorter).setContentService(contentService);
//		}
		
		CustomSorter customSorter = new CustomSorter();
		customSorter.setContentService(getNavigatorContentService());
		super.setSorter(customSorter);
	}

}
