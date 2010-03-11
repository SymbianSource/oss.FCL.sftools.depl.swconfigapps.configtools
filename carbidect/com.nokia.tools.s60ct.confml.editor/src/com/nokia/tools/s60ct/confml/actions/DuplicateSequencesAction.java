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
package com.nokia.tools.s60ct.confml.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.nokia.tools.s60ct.confml.commands.DuplicateSequencesCommand;
import com.nokia.tools.s60ct.confml.editor.Activator;
import com.nokia.tools.s60ct.confml.viewer.FeatureViewer;
import com.nokia.tools.s60ct.confml.widgets.BaseConfMLWidget;
import com.nokia.tools.s60ct.model.confml.ConfmlFactory;
import com.nokia.tools.s60ct.model.confml.ESequenceSetting;
import com.nokia.tools.s60ct.model.confml.ESequenceValue;
import com.nokia.tools.s60ct.model.confml.ESequenceValueItem;
import com.nokia.tools.s60ct.model.confml.ESimpleSetting;
import com.nokia.tools.s60ct.model.confml.presentation.ConfmlEditor;

public class DuplicateSequencesAction  extends  Action
{
	protected List<ESimpleSetting> selectedObjects = new ArrayList<ESimpleSetting>();
	protected FeatureViewer featureViewer;
	protected BaseConfMLWidget widget;
	protected ConfmlFactory factory = ConfmlFactory.eINSTANCE;
	protected IWorkbenchWindow window;
	protected EList<ESequenceValueItem> items = null;
	protected ESequenceValueItem item = null;
	protected ESequenceValue container = null;
	private ConfmlEditor editor;
	protected  ESequenceSetting setting = null;
	
	public DuplicateSequencesAction(FeatureViewer featureViewer, ConfmlEditor editor)
	{
		this.featureViewer = featureViewer;
		this.editor = editor;
	}
	
	public void setWidget(BaseConfMLWidget widget) 
	{
		this.widget = widget;
	}
	
	public void dispose() 
	{
		ISelectionService selectionService = window.getSelectionService();
		selectionService.removeSelectionListener(selectionChangeListener);
		featureViewer = null;
	}
	
	protected ISelectionListener selectionChangeListener = new ISelectionListener() 
	{

		public void selectionChanged(IWorkbenchPart part, ISelection selection) {
			setEnabled(false);
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection ss = (IStructuredSelection) selection;
				
				if (featureViewer == null)
				{
					IEditorPart activeEditor = window.getActivePage().getActiveEditor();
					if (activeEditor instanceof ConfmlEditor) 
					{
						ConfmlEditor confmlEditor = (ConfmlEditor) activeEditor;
						FeatureViewer fv = confmlEditor.getFeatureViewer();
						selection = fv.getSelection();
					}
				} 
				else 
				{ 
					selection = featureViewer.getSelection();
				}
				StructuredSelection structuredSelection  = (StructuredSelection) selection;
				Object o = structuredSelection.getFirstElement();
				if (o instanceof ESequenceValueItem)
				{
					ESequenceSetting selectedSequenceSetting = (ESequenceSetting)((ESequenceValueItem)o).eContainer().eContainer();
					item =  (ESequenceValueItem)o;
					container = (ESequenceValue) item.eContainer();
					items = container.getItems();
					if ( item == container.getTemplate() )
					{
						setting = selectedSequenceSetting;
						setEnabled(true);
					}
				}
			}
		}
	};

	
	
	public void init(IWorkbenchWindow window) 
	{
		this.window = window;
		ISelectionService selectionService = window.getSelectionService();
		selectionService.addSelectionListener(selectionChangeListener);
	}
	
	public void run() 
	{
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorPart activeEditor = page.getActiveEditor();
		if (activeEditor != null && activeEditor instanceof ConfmlEditor) 
		{
			editor = (ConfmlEditor) activeEditor;
			DuplicateSequencesCommand command = new DuplicateSequencesCommand(items, setting,editor);
			editor.getCommandStack().execute(command);
			featureViewer.refresh();
			featureViewer.relevantChange();
		}
		// Let's copy the sequences
	}
	

	public void selectionChanged(IAction action, ISelection selection) 
	{
	}
	
	public  String getText()
	{
		return "Duplicate Sequences";
		
	}

	public  String getId()
	{
		return "Duplicate Sequences";
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		if (super.getImageDescriptor() == null) {
			setImageDescriptor(Activator
					.getImageDescriptor("icons/resettodefault_16.png"));
		}
		ImageDescriptor imageDescriptor = super.getImageDescriptor();
		return imageDescriptor;
	}

	
	
}
