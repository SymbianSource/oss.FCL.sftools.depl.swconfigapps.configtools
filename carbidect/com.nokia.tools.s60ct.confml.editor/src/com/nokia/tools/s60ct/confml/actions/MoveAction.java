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

import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.nokia.tools.s60ct.confml.commands.SetSequenceCommand;
import com.nokia.tools.s60ct.confml.editor.Activator;
import com.nokia.tools.s60ct.confml.viewer.FeatureViewer;
import com.nokia.tools.s60ct.model.confml.ConfmlFactory;
import com.nokia.tools.s60ct.model.confml.ESequenceValue;
import com.nokia.tools.s60ct.model.confml.ESequenceValueItem;
import com.nokia.tools.s60ct.model.confml.ESimpleSetting;
import com.nokia.tools.s60ct.model.confml.presentation.ConfmlEditor;

public abstract class MoveAction extends Action{

	protected List<ESimpleSetting> selectedObjects = new ArrayList<ESimpleSetting>();
	protected FeatureViewer featureViewer;

	protected ConfmlFactory factory = ConfmlFactory.eINSTANCE;
	protected IWorkbenchWindow window;
	protected EList<ESequenceValueItem> items = null;
	protected ESequenceValueItem item = null;
	protected ESequenceValue container = null;
	private ConfmlEditor editor;
	
	public MoveAction(FeatureViewer featureViewer, ConfmlEditor editor) 
	{
		this.featureViewer = featureViewer;
		this.editor = editor;
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
				ESimpleSetting setting = null;
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
				if ( o instanceof ESequenceValueItem)
				{
					item =  (ESequenceValueItem)o;
					container = (ESequenceValue) item.eContainer();
					items = container.getItems();
					
					Iterator iterator = items.iterator();
					int index = 1;
					while (iterator.hasNext())
					{
						ESequenceValueItem current = (ESequenceValueItem) iterator.next();
						if (current.isEditable())
						{
							if (item == current && container.getTemplate() != item && index < items.size() && getText().equals("Move Down"))
							{
								setEnabled(true);
							}
							else if (item == current && container.getTemplate() != item && index > 1 && getText().equals("Move Up"))
							{
								setEnabled(true);
							}
						}
						
						index++;
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
		
		CommandStack cs = (CommandStack) PlatformUI.getWorkbench()
		.getActiveWorkbenchWindow().getActivePage().getActiveEditor()
		.getAdapter(CommandStack.class);

		
		ESequenceValueItem source = item;
		ESequenceValueItem target = null;
		ESequenceValueItem placeHolder1 = factory.createESequenceValueItem();
		ESequenceValueItem placeHolder2 = factory.createESequenceValueItem();
		
		
			
		
			for (int index = 0; index < items.size(); index++)
			{
				ESequenceValueItem current = (ESequenceValueItem) items.get(index);
				if (current == source)
				{
					
					if (getId().equals("Move Down") )
					{
						source = items.get(index);
						items.set(index, placeHolder1);
						target = items.get(index+1);
						items.set(index+1, placeHolder2);
						
						SetSequenceCommand set4 = new SetSequenceCommand(target,items,index);
						editor.getCommandStack().execute(set4);

						SetSequenceCommand set3 = new SetSequenceCommand(source,items,index+1);
						editor.getCommandStack().execute(set3);
						
						break;
					}
					else
					{
						target = items.get(index-1);
						items.set(index-1, placeHolder1);
						source = items.get(index);
						items.set(index, placeHolder2);
						
						SetSequenceCommand set3 = new SetSequenceCommand(source,items,index-1);
						editor.getCommandStack().execute(set3);
						
						SetSequenceCommand set4 = new SetSequenceCommand(target,items,index);
						editor.getCommandStack().execute(set4);
						
						break;
					}
				}
			}
			
			
				
		featureViewer.refresh();
	}


	public void selectionChanged(IAction action, ISelection selection) 
	{
	}


	@Override
	public abstract String getText();

	@Override
	public abstract String getId();

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
