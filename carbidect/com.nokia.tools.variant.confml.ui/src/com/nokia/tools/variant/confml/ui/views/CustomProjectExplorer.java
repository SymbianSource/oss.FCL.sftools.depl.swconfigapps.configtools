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

import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.navigator.CommonViewer;
import org.eclipse.ui.navigator.INavigatorFilterService;

import com.nokia.tools.variant.confml.ui.ConfmlUI;
import com.nokia.tools.variant.confml.ui.IConfmlImages;
import com.nokia.tools.variant.confml.ui.filtering.ConfigurationFilter;

public class CustomProjectExplorer extends CommonNavigator {

	
	private ConfigurationFilter resPatFilter = null;
	protected Text filterText = null;
	protected String initialText = "";
	private Button clearButton;
	
	private boolean ignoreModify = false;
	
	public CustomProjectExplorer()
	{
		// TODO Auto-generated constructor stub
	}

	public void createPartControl(Composite aParent)
	{
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginWidth = 0;
		gridLayout.marginTop = -5;
		
		GridData gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.grabExcessVerticalSpace = true;
		gd.horizontalAlignment = GridData.FILL;
		gd.verticalAlignment = GridData.FILL;
		gd.verticalIndent = 0;
		
		
		aParent.setLayout(gridLayout);
		aParent.setLayoutData(gd);

		Composite filterComposite = new Composite(aParent, SWT.NONE);
		
		GridLayout filterGridLayout = new GridLayout(2, false);
		filterGridLayout.marginWidth = 0;
		filterComposite.setLayout(filterGridLayout);
		filterGridLayout.marginRight = 4;
		
		GridData fgd = new GridData();
		fgd.grabExcessHorizontalSpace = true;
		fgd.heightHint = 25;
		fgd.horizontalIndent = 2;
		fgd.grabExcessVerticalSpace = false;
		fgd.horizontalAlignment = GridData.FILL;
		fgd.verticalAlignment = GridData.BEGINNING;
		
		filterComposite.setLayoutData(fgd);
		
		createFilterText(filterComposite);
		clearButton = new Button(filterComposite, SWT.PUSH);
		
		clearButton.setEnabled(false);
		
		GridData bgd = new GridData();
		bgd.heightHint = 20;
		bgd.widthHint = 20;
		bgd.verticalAlignment = GridData.BEGINNING;
		
		clearButton.setLayoutData(bgd);
		filterText.setLayoutData(fgd);
		clearButton.setToolTipText("Clear filter text");
		clearButton.setImage(ConfmlUI.getImage(IConfmlImages.DELETE));
		
		clearButton.addSelectionListener(new SelectionListener()
		{
			public void widgetDefaultSelected(SelectionEvent e) 
			{
				clearText();
			}
			public void widgetSelected(SelectionEvent e)
			{
				clearText();
			}
		});
		
		super.createPartControl(aParent);
		
		CommonViewer viewer = getCommonViewer();
		
		viewer.getTree().setLayoutData(gd);
		
		INavigatorFilterService filterService = viewer
		.getNavigatorContentService().getFilterService();
		
		ViewerFilter[] activeFilters = filterService.getVisibleFilters(false);
		
		for (int i = 0 ; i < activeFilters.length ; i++)
		{
			if (activeFilters[i] instanceof ConfigurationFilter)
			{
				resPatFilter = (ConfigurationFilter)activeFilters[i];
			}
		}
	}
	

	@Override
	protected CommonViewer createCommonViewer(Composite parent) {
		CustomViewer aViewer = new CustomViewer(getViewSite().getId(), parent,
				SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		initListeners(aViewer);
		//aViewer.getNavigatorContentService().restoreState(memento);
		return aViewer;
	}

	protected void createFilterText(Composite parent) 
	{
		filterText = new Text(parent, SWT.SINGLE | SWT.BORDER);
		filterText.setText("<type filter text>");
		filterText.addFocusListener(new FocusAdapter() 
		{
			public void focusGained(FocusEvent e)
			{
				Display display = filterText.getDisplay();
				display.asyncExec(new Runnable()
				{
					public void run()
					{
						if (!filterText.isDisposed())
						{
							filterText.selectAll();
						}
					}
				});
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				super.focusLost(e);
				if (filterText.getText().equals(""))
				{
					ignoreModify = true;
					filterText.setText("<type filter text>");
					ignoreModify = false;
				}
			}
			
			
		});

		filterText.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e) 
			{
				boolean hasItems = getCommonViewer().getTree().getItemCount() > 0;
				if (hasItems && e.keyCode == SWT.ARROW_DOWN)
				{
					getCommonViewer().getTree().setFocus();
				} 
				else if (e.character == SWT.CR)
				{
					return;
				}
			}
		});

		filterText.addModifyListener(new ModifyListener() 
		{
			public void modifyText(ModifyEvent e) 
			{
				if (!ignoreModify)
					textChanged();
			}
		});

	}


	protected void clearText() 
	{
		setFilterText(""); 
		//textChanged();
	}

	protected void setFilterText(String string) 
	{
		if (filterText != null) 
		{
			filterText.setText(string);
		}
	}

	
	protected void textChanged() 
	{
		String text = filterText.getText();
		if (text.equals(""))
			clearButton.setEnabled(false);
		else
			clearButton.setEnabled(true);
		resPatFilter.setPatterns(new String[]{text});
		getCommonViewer().refresh();
	}
	
}
