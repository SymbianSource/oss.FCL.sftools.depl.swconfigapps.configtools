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
/**
 * 
 */
package com.nokia.s60ct.gui.views;

import java.util.Iterator;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.ICellEditorListener;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreeViewer;

import configurationemf.Configuration;
import configurationemf.ConfigurationemfPackage;
import configurationemf.Feature;
import configurationemf.Group;
import configurationemf.Project;
import configurationemf.Setting;
import configurationemf.View;


public class FeatureTreeListener 
	implements IDoubleClickListener,ICellModifier,ICellEditorListener {
	
	TreeViewer viewer=null;
	boolean modify=false;
	Object sObject=null;
	
	public void applyEditorValue() {
		TextCellEditor cellEditor = (TextCellEditor)viewer.getCellEditors()[0];
		
		Command command=null;
		if(sObject instanceof Configuration)
			command = SetCommand.create(Project.instance().getEditingDomain(), sObject, 
				ConfigurationemfPackage.eINSTANCE.getConfiguration_Name(), cellEditor.getValue());
		else if (sObject instanceof Feature)
			command = SetCommand.create(Project.instance().getEditingDomain(), sObject,
				ConfigurationemfPackage.eINSTANCE.getFeature_Name(),cellEditor.getValue());
		else if (sObject instanceof View)
			command = SetCommand.create(Project.instance().getEditingDomain(), sObject,
					ConfigurationemfPackage.eINSTANCE.getView_Name(),cellEditor.getValue());
		else if (sObject instanceof Group)
			command = SetCommand.create(Project.instance().getEditingDomain(), sObject,
					ConfigurationemfPackage.eINSTANCE.getGroup_Name(),cellEditor.getValue());
		else if (sObject instanceof Setting)
			command = SetCommand.create(Project.instance().getEditingDomain(), sObject,
					ConfigurationemfPackage.eINSTANCE.getSetting_Name(),cellEditor.getValue());
		if(command!=null)
			Project.instance().getEditingDomain().getCommandStack().execute(command);
		
		
	}

	public void cancelEditor() {
		//do nothing
		
	}

	public void editorValueChanged(boolean oldValidState, boolean newValidState) {
		//do nothing
		
	}

	
	
	public void doubleClick(DoubleClickEvent event) {
		viewer = (TreeViewer)event.getSource();
		modify=true;
		processSelection(viewer.getSelection());
		
	}
	
	public boolean canModify(Object element, String property) {
		
		
		return modify&&Project.instance().isEditableElement((EObject)element);
	}

	public Object getValue(Object element, String property) {
		
		String text = ((AdapterFactoryLabelProvider)viewer.getLabelProvider()).getText(element);
		return text;
	}

	public void modify(Object element, String property, Object value) {
		modify=false;
	}
	
	
	
	protected void processSelection(ISelection selection){
		if(selection instanceof IStructuredSelection) {
	           IStructuredSelection structuredSelection = (IStructuredSelection)selection;
	           for (Iterator iterator = structuredSelection.iterator(); iterator.hasNext();)
	               callEditor(iterator.next());
	           
	           
	       }
	}
	
	protected void callEditor(Object object){
		sObject = object;
		viewer.editElement(object,0);
		modify=false;
	}
	
}
