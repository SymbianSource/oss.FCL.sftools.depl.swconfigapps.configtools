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
package com.nokia.s60ct.quickfixers;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.views.markers.internal.Util;

public class QuickFixPopupDialog extends MessageDialog {

	private boolean checkboxStatus;
	private IMarker[] markers = null;
	private CheckboxTableViewer markersTable;
	Object[] checkedElements = null;
	
	public QuickFixPopupDialog(Shell parentShell, IMarker[] markers) {
		super(parentShell, "Quick fixes availeble", null,
		"Validation errors/warnings have quick fixes available.\nSelect items that you want to fix automatically.", 
		MessageDialog.INFORMATION, new String[] { "Fix",
                IDialogConstants.CANCEL_LABEL }, 0);
		this.markers = markers;
		checkedElements = markers;
	
	}

	@Override
	protected Point getInitialSize() {
		return new Point(800,300);
	}

	@Override
	protected Control createCustomArea(Composite parent) {
		Composite control = new Composite(parent, SWT.NONE);
		FillLayout  tableLayout = new FillLayout();
		control.setLayout(tableLayout);
		control.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		Composite comp = new Composite(parent,SWT.NONE);
		GridLayout gridLayout = new GridLayout(2,false);
		comp.setLayout(gridLayout);
	
		createMarkerTable(control);

		Button checkbox = new Button(comp,SWT.CHECK);
		checkbox.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				checkboxStatus = ((Button)e.getSource()).getSelection();
				
			}
			
		});
		Label label = new Label(comp,SWT.NONE);
		label.setText("Don't ask again");

		return control;
	}
	
	public boolean getCheckBoxStatus() {
		return checkboxStatus;
	}
	
	
	private void createMarkerTable(Composite control) {
		markersTable = CheckboxTableViewer.newCheckList(control, SWT.BORDER
				| SWT.V_SCROLL | SWT.CENTER);

		createTableColumns();

		markersTable.setContentProvider(new IStructuredContentProvider() {

			public void dispose() {

			}

			public Object[] getElements(Object inputElement) {
				
				return markers;
			}

			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {

			}
		});

		markersTable.setLabelProvider(new ITableLabelProvider() 
		{
			public Image getColumnImage(Object element, int columnIndex) {
				if (columnIndex == 0)
					return Util.getImage(((IMarker) element).getAttribute(
							IMarker.SEVERITY, -1));
				return null;
			}

			public String getColumnText(Object element, int columnIndex) {
				
				IMarker marker = (IMarker) element;
				if (columnIndex == 0)
				{
					try {
						return (String)marker.getAttribute(IMarker.MESSAGE);
					} catch (CoreException e) {
						e.printStackTrace();
					}
					return null;
				}
				else if (columnIndex == 1)
				{
					return IDE.getMarkerHelpRegistry().getResolutions(marker)[0].getLabel();
				}
				else
					return null;
			}

			public void addListener(ILabelProviderListener listener) {
				// do nothing

			}

			public void dispose() {
				// do nothing

			}

			public boolean isLabelProperty(Object element, String property) {
				return false;
			}

			public void removeListener(ILabelProviderListener listener) {
				// do nothing

			}
		});

		markersTable.addCheckStateListener(new ICheckStateListener() {
			
			public void checkStateChanged(CheckStateChangedEvent event) {
				checkedElements = markersTable.getCheckedElements();
				if (event.getChecked() == true) {
					setComplete(true);
				} else {
					setComplete(markersTable.getCheckedElements().length > 0);
				}

			}
		});

		markersTable.setInput(this);
		markersTable.setAllChecked(true);
	
		
	}
	
	private void createTableColumns() {
		TableLayout layout = new TableLayout();

		Table table = markersTable.getTable();
		table.setLayout(layout);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		
		
		layout.addColumnData(new ColumnWeightData(70, true));
		TableColumn tc2 = new TableColumn(table, SWT.NONE, 0);
		tc2.setText("Quick Fix");
		
		layout.addColumnData(new ColumnWeightData(30, true));
		TableColumn tc1 = new TableColumn(table, SWT.NONE, 0);
		tc1.setText("Problem");
		
	}

	protected void setComplete(boolean complete) {
		getButton(IDialogConstants.OK_ID).setEnabled(complete);

	}
	
	
	public void displayDialog() {
		int answer = open();
		if (answer == IDialogConstants.OK_ID)
		{
			for (int i = 0 ; i < checkedElements.length ; i++)
			{
				IMarker marker = (IMarker)checkedElements[i];
				IMarkerResolution[] resolutions = IDE.getMarkerHelpRegistry().getResolutions(marker);
				for (int j = 0 ; j < resolutions.length ; j++)
				{
					resolutions[j].run(marker);
				}
			}
		}
	}
}



