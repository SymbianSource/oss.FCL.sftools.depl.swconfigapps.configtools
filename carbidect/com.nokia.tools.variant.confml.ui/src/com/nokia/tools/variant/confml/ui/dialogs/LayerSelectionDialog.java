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
 * Description: This file is part of com.nokia.tools.variant.confml.ui component.
 */

package com.nokia.tools.variant.confml.ui.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.internal.misc.StringMatcher;

import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.variant.confml.ui.ConfmlUI;
import com.nokia.tools.variant.confml.ui.IConfmlImages;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;
import com.nokia.tools.vct.common.ui.dialogs.SimpleDialogWindow;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.DialogField;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.IDialogFieldListener;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.IListAdapter;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.LayoutUtil;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.ListDialogField;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.PathDialogField;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.ListDialogField.ColumnsDescription;

public class LayerSelectionDialog extends SimpleDialogWindow {

	private static final String TYPE_FILTER_TEXT = "type filter text";
	private static final String SELECT_CONF_ML_LAYER = "Select ConfMl Layer";
	private Object selected; 
	
	public Object getSelected() {
		return selected;
	}

	private Table table;
	private TableViewer viewer;
	private String filterText;

	public LayerSelectionDialog(Shell parent) {
		super(parent, "ConfML Layer Selection");
	}


	@Override
	protected Control createDialogArea(Composite parent) {
		Composite comp = (Composite) super.createDialogArea(parent);
		//comps Layout is GridLayout
		
		createFilter(comp);

		ListDialogField ldf = new ListDialogField(new ListAdapter(), null , new TableLableProvider() );
		
		String[]columnNames = {/*"Layer Name", "Layer ID"*/};
		ldf.setTableColumns(new ColumnsDescription(columnNames, false));
		
		ldf.doFillIntoGrid(comp, 3);
		viewer = ldf.getTableViewer();
		viewer.getTable().setHeaderVisible(false);
		
		List<EConfigurationProject> projects = new ArrayList<EConfigurationProject>();
		IProject[] tmp = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for (IProject project: tmp) {
			EConfigurationProject cp = ConfMLCore.getProjectModel(project);
			if (cp != null) {
				projects.add(cp);
			}
		}
		
		viewer.setInput(projects);

		ldf.setContentProvider(new ArrayContentProvider(){
			
			public Object[] getElements(Object inputElement) {
				if (inputElement instanceof List) {
					List<EConfigurationProject> inputProjects = (List<EConfigurationProject>) inputElement;
					List<Object> filtered =  new ArrayList<Object>();
					if (filterText != null && !filterText.equals(TYPE_FILTER_TEXT)){
						for (EConfigurationProject project : inputProjects) {
//							if(project.getConfiguration().getId().toLowerCase().contains(filterText.toLowerCase())){
//								filtered.add(project);
//							}
							filterText = filterText + "*";
							StringMatcher matcher = new StringMatcher(filterText, true, false);
							if(matcher.match(project.getName().toLowerCase())){
								filtered.add(project);
							}
						}
						return filtered.toArray();
					}
					return super.getElements(inputElement);
				}
				return null;
			}
		});
		
		
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.grabExcessHorizontalSpace = true;
		gd.widthHint = 320;
		gd.verticalIndent = 0;
		
		viewer.getTable().getParent().setLayoutData(gd);
		
		gd = new GridData();
		gd.heightHint = 300;
	//	viewer.getTable().getParent().getParent().setLayoutData(gd);

		return comp;
	}


	private void createFilter(Composite comp) {
		final PathDialogField dialogField = new PathDialogField();
		dialogField.setLabelText(SELECT_CONF_ML_LAYER);
		dialogField.doFillIntoGrid(comp, 2);

		LayoutUtil.setHorizontalGrabbing(dialogField.getTextControl(null));
		LayoutUtil.setHorizontalIndent(dialogField.getTextControl(null), 0);
		dialogField.setText(TYPE_FILTER_TEXT);

		dialogField.setDialogFieldListener(new IDialogFieldListener() {

			public void dialogFieldChanged(DialogField field) {
				setFilterText(dialogField.getText());

			}

		});
		dialogField.getTextControl(null).addFocusListener(new FocusAdapter() {
			
			public void focusGained(FocusEvent e) {
			
				Display display = dialogField.getTextControl(null).getDisplay();
				display.asyncExec(new Runnable() {
					public void run() {
						if(dialogField.getText().equals(TYPE_FILTER_TEXT)){
							dialogField.getTextControl(null).selectAll();
						
						}
					}
				});
			}
		});
	}
	
	public void setFilterText(String filterText) {
		IStructuredSelection selection = (IStructuredSelection) viewer
				.getSelection();
		if (!selection.isEmpty()
				&& selection.getFirstElement() instanceof EConfMLLayer) {
			EObject container = (EObject) selection.getFirstElement();
			while (container != null
					&& !(container instanceof EConfigurationProject)) {
				container = container.eContainer();
			}
			selection = new StructuredSelection(container);
		}
		if (!(selection.size() > 0
				&& (new Path(filterText)).segment(0) != null && ((LabelProvider) viewer
				.getLabelProvider()).getText(selection.getFirstElement())
				.toLowerCase().contains(
						(new Path(filterText)).segment(0).toString()
								.toLowerCase()))) {
			this.filterText = filterText;
			viewer.refresh();
//			if (!filterText.trim().equals("")	&&!filterText.equals(TYPE_FILTER_TEXT)) {
//				viewer.expandAll();
//			}
		}

	}
	
	class TableLableProvider extends LabelProvider implements ITableLabelProvider{

		public Image getColumnImage(Object element, int columnIndex) {
			if(element instanceof EConfigurationProject){
				 return ConfmlUI.getImage(IConfmlImages.FLD_PROJECT);
			}
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			if(element instanceof EConfigurationProject){
				EConfigurationProject project = (EConfigurationProject)element;
			
				switch (columnIndex){
				case 0:
					return project.getName() + " (ver: " + project.getVersion() + ")";
				}
			}
			return null;
		}
		
	}
	
	class ListAdapter implements IListAdapter{

		public void customButtonPressed(ListDialogField field, int index) {
			
			
		}

		public void doubleClicked(ListDialogField field) {
			
			
		}

		public void selectionChanged(ListDialogField field) {
			if(field.getSelectedElements().size() > 0)
				selected = field.getSelectedElements().get(0);
			
		}
		
	}

}
