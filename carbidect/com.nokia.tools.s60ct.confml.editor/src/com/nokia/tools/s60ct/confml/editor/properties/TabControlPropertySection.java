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
package com.nokia.tools.s60ct.confml.editor.properties;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.internal.views.properties.tabbed.view.TabbedPropertyComposite;
import org.eclipse.ui.internal.views.properties.tabbed.view.TabbedPropertyList;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * Class is used to ommit tab section of tabbed property view.
 * Classes that normally creates the property section can extend this class
 *  and implement its method createSpecificControl(...)
 * 
 * @author borekmic
 *
 */
public abstract class TabControlPropertySection extends AbstractPropertySection {

	Composite leftTab;
	ScrolledComposite scrolledComposite;
	boolean removeTabs;
	
	/**
	 * Must be called by subclass
	 */
	public void createControls(Composite parent,
			TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		TabbedPropertyComposite pageComposite = (TabbedPropertyComposite)tabbedPropertySheetPage.getControl();
		TabbedPropertyList list = pageComposite.getList();
		leftTab = list.getParent();
		
		pageComposite.setVisible(false);

		scrolledComposite = pageComposite.getScrolledComposite();
		FormData layoutData = (FormData) scrolledComposite.getLayoutData();
		if(removeTabs){
			layoutData.left = new FormAttachment(0);
		}
		else{
			layoutData.left.control = leftTab ;
		}
		scrolledComposite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_CYAN));
		//pageComposite.layout(false, true);
		
		/**
		 * calls method implemented by subclass (to populate parent composite)
		 */
		createSpecificControls(parent, tabbedPropertySheetPage);
		
		pageComposite.layout(true, true);
		pageComposite.setVisible(true);
		
	}
	 /**
	  * Is called by createControls method. 
	  * Supposed to be used by subclass to populate parent Composite by own content
	  * @param parent
	  * @param tabbedPropertySheetPage
	  */
	protected abstract void createSpecificControls(Composite parent,
			TabbedPropertySheetPage tabbedPropertySheetPage);
	
	/**
	 * Selects whether to remove Tab section.
	 * !! It must be called before createControls(...) is called !!
	 * @param remove
	 */
	public void setRemoveTabs(boolean remove){
		removeTabs = remove;
	}
	
	/**
	 * Moves refresh call to superclass.
	 */
	public void refresh() {
		super.refresh();
	}
	
	/**
	 * Cleans up the mess in the tabbed properties view
	 */
	public void dispose() {
		if(!scrolledComposite.isDisposed()){
			FormData layoutData = (FormData) scrolledComposite.getLayoutData();
			//layoutData.left.control = leftTab ; //!removeTabs ?  null : leftTab ;
			if(removeTabs){
				layoutData.left.control = leftTab ;
			}
			scrolledComposite.layout(true, true);
		}
		super.dispose();
	}
}
