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
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;

import com.nokia.tools.carbide.ct.crml.ui.editors.CRMLMultiPageEditorPart;
import com.nokia.tools.s60ct.build.builder.utils.SettingImplementationCollector;
import com.nokia.tools.s60ct.confml.viewer.FeatureViewer;
import com.nokia.tools.s60ct.model.confml.EExtensionPolicy;
import com.nokia.tools.s60ct.model.confml.EFeature;
import com.nokia.tools.s60ct.model.confml.EResourceSetting;
import com.nokia.tools.s60ct.model.confml.EResourceValue;
import com.nokia.tools.s60ct.model.confml.ESequenceSetting;
import com.nokia.tools.s60ct.model.confml.ESequenceValue;
import com.nokia.tools.s60ct.model.confml.ESequenceValueItem;
import com.nokia.tools.s60ct.model.confml.ESetting;
import com.nokia.tools.s60ct.model.confml.ESettingValue;
import com.nokia.tools.s60ct.model.confml.ESimpleSetting;
import com.nokia.tools.s60ct.model.confml.ESimpleValue;
import com.nokia.tools.s60ct.model.confml.presentation.ConfmlEditor;
import com.nokia.tools.vct.crml.crmodel.EBit;
import com.nokia.tools.vct.crml.crmodel.ECRMLDocumentRoot;
import com.nokia.tools.vct.crml.crmodel.EKey;
import com.nokia.tools.vct.crml.crmodel.EKeyRange;
import com.nokia.tools.vct.gcfml.gcfmlmodel.EFile;

public class OpenImplementationAction extends Action {

	private List<ESetting> selectedObjects = new ArrayList<ESetting>();
	FeatureViewer featureViewer;

	private IWorkbenchWindow window;

	public OpenImplementationAction(FeatureViewer featureViewer) {
		this.featureViewer = featureViewer;
	}

	public void dispose() {
		ISelectionService selectionService = window.getSelectionService();
		selectionService.removeSelectionListener(selectionChangeListener);
		featureViewer = null;
	}

	private ISelectionListener selectionChangeListener = new ISelectionListener() {

		public void selectionChanged(IWorkbenchPart part, ISelection selection) {
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection ss = (IStructuredSelection) selection;
				Boolean enabled = shouldBeEnabled(ss);
				setEnabled(!enabled);
				setEnabled(enabled);
			}
		}
	};

	public void init(IWorkbenchWindow window) {
		this.window = window;
		ISelectionService selectionService = window.getSelectionService();
		selectionService.addSelectionListener(selectionChangeListener);
	}

	public void run() {
		if (featureViewer == null) {// RUN from global toolbar - action
			// acquires settingsViewer from active
			// editor
			IEditorPart activeEditor = window.getActivePage().getActiveEditor();
			if (activeEditor instanceof ConfmlEditor) {
				ConfmlEditor confmlEditor = (ConfmlEditor) activeEditor;
				FeatureViewer fv = confmlEditor.getFeatureViewer();
				ISelection selection = fv.getSelection();
				takeSettingsFromSelection(selection);
				IStructuredSelection ss = (IStructuredSelection) selection;
				openEditor(confmlEditor, selectedObjects.get(0), ss.getFirstElement());
			}
		} 
		else 
		{ // RUN from popup menu - action has settingsViewer set by
			// constructor
			ISelection selection = featureViewer.getSelection();
			takeSettingsFromSelection(selection);
			IStructuredSelection ss = (IStructuredSelection) selection;
			openEditor(featureViewer.getEditor(), selectedObjects.get(0), ss.getFirstElement());
		}
	}

	private void openEditor(IEditorPart activeEditor, Object element, Object firstElement)
	{
		ESetting setting = null;
		if (element instanceof ESetting)
		{
			setting = (ESetting)element;
		}
			
		URI uri = getURI(setting, firstElement);
		
		Path path = new Path(uri.toPlatformString(true));
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		
		try 
		{
			IEditorDescriptor editorDesc = IDE.getEditorDescriptor(file);
			IEditorPart editor = IDE.openEditor(window.getActivePage(), file, editorDesc.getId());
			if (editor instanceof CRMLMultiPageEditorPart)
			{
				CRMLMultiPageEditorPart crmlEditor = (CRMLMultiPageEditorPart)editor;
				crmlEditor.setSelectionToRef(setting.getRef());
			}
		}
		catch (PartInitException e) 
		{
			e.printStackTrace();
		}
	}

    private URI getURI(ESetting setting, Object firstElement)
    {
		EObject impl = null;
		if (setting.eContainer() instanceof EFeature)
		{
			EFeature feature = (EFeature)setting.eContainer();
			String featureRef = feature.getRef();
			impl = SettingImplementationCollector.getImplementation(featureRef+"/"+setting.getRef());
			if (impl == null)
				impl = SettingImplementationCollector.getImplementation(featureRef+"/*");
		}
		else if (setting.eContainer() instanceof ESequenceSetting)
		{
			ESequenceSetting seqSet = (ESequenceSetting)setting.eContainer();
			
			EExtensionPolicy policy = ((ESequenceValue)seqSet.getValue()).getExtensionPolicy();
			
			int index = 0;
			
			if (policy.equals(EExtensionPolicy.APPEND))
				index = getSeqIndexAppend(seqSet, firstElement);
			if (policy.equals(EExtensionPolicy.PREFIX))
				index = getSeqIndexPrefix(seqSet, firstElement);
			if (policy.equals(EExtensionPolicy.REPLACE))
				index = getSeqIndexReplace(seqSet, firstElement);
			
			EFeature feature = (EFeature)seqSet.eContainer();
			String framePrefix = "@"+index+"/";
			String absRef = feature.getRef()+"/"+seqSet.getRef();
			
			impl = SettingImplementationCollector.getImplementation(framePrefix+absRef+"/"+setting.getRef());
			if (impl == null)
				impl = SettingImplementationCollector.getImplementation(absRef);
			if (impl == null)
				impl = SettingImplementationCollector.getImplementation(feature.getRef()+"/*");
		}
		
		if (impl==null)
			return null;

		if (impl instanceof EKey || impl instanceof EBit || impl instanceof EKeyRange)
		{
			ECRMLDocumentRoot crml = getCrmlDocRoot(impl);
			return crml.eResource().getURI();
		}
		else if (impl instanceof EFile) //gcfml file
		{
			EFile gcfmlFile = (EFile)impl;
			String loc = gcfmlFile.getLocation();
			return URI.createPlatformResourceURI(loc, true);
		}
		else
		{
			System.out.println("Unknown implementation");
		}
		
		
		return null;
	}
	
    private ECRMLDocumentRoot getCrmlDocRoot(EObject o)
    {
    	if (o.eContainer() instanceof ECRMLDocumentRoot)
    	{
    		return (ECRMLDocumentRoot)o.eContainer();
    	}
    	else
    	{
    		return getCrmlDocRoot(o.eContainer());
    	}
    }
    
	public void selectionChanged(IAction action, ISelection selection) {
		takeSettingsFromSelection(selection);
		setEnabled(selectedObjects.size() == 0);
		setEnabled(selectedObjects.size() > 0);
	}

	private void takeSettingsFromSelection(ISelection selection) {
		selectedObjects.clear();
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection ss = (IStructuredSelection) selection;
			List<?> list = ss.toList();
			selectedObjects = new ArrayList<ESetting>();
			for (int i = 0; i < list.size(); i++) {
				Object o = list.get(i);
				if (o instanceof ESimpleSetting) {
					ESimpleSetting setting = (ESimpleSetting) o;
					selectedObjects.add(setting);
				}
				else if (o instanceof EResourceSetting)
				{
					EResourceSetting setting = (EResourceSetting)o;
					selectedObjects.add(setting);
				}
				else if (o instanceof ESimpleValue)
				{
					ESimpleValue sVal = (ESimpleValue)o;
					selectedObjects.add(sVal.getType());
				}
				else if (o instanceof EResourceValue)
				{
					EResourceValue resVal =(EResourceValue)o;
					selectedObjects.add(resVal.getLocalPath().getType());
				}
			}
		}
	}

	@Override
	public String getText() {
		return "Open Implementation";
	}

	@Override
	public String getId() {
		return "Open Implementation";
	}

//	@Override
//	public ImageDescriptor getImageDescriptor() {
//		if (super.getImageDescriptor() == null) {
//			setImageDescriptor(Activator
//					.getImageDescriptor("icons/resettodefault_16.png"));
//		}
//		ImageDescriptor imageDescriptor = super.getImageDescriptor();
//		return imageDescriptor;
//	}

	private boolean shouldBeEnabled(IStructuredSelection ss) {
		List<?> list = ss.toList();
		for (Object object : list) {
			if (object instanceof ESimpleSetting) {
				
				URI uri = getURI((ESimpleSetting)object, ss.getFirstElement());
				if (uri!=null)
					return true;					
				
			}
			if (object instanceof ESimpleValue) {
				
				URI uri = getURI(((ESimpleValue)object).getType(), ss.getFirstElement());
				if (uri!=null)
					return true;				
			}
			else if (object instanceof EResourceSetting) {
				
				URI uri = getURI(((EResourceSetting)object).getLocalPath(), ss.getFirstElement());
				if (uri!=null)
					return true;			
			}
		}
		return false;
	}
	
	private int getSeqIndexAppend(ESequenceSetting seqSet, Object element)
	{
		int index = 0;
		EList<ESequenceValueItem> defaultItems = ((ESequenceValue)seqSet.getDefaultValue()).getItems();
		
		boolean found = false;
		
		for (int i = 0 ; i < defaultItems.size() ; i++)
		{
			
			for (ESettingValue setVal : defaultItems.get(i).getSubSettings())
			{
				if (setVal.equals(element))
				{
					found = true;
					break;
				}
			}
			if (found)
				break;
			index++;
		}
		
		if (!found)
		{
			EList<ESequenceValueItem> items = ((ESequenceValue)seqSet.getValue()).getItems();
			for (int i = 0 ; i < items.size() ; i++)
			{
			
				for (ESettingValue setVal : items.get(i).getSubSettings())
				{
					if (setVal.equals(element))
					{
						found = true;
						break;
					}
				}
				if (found)
					break;
				index++;
			}
			if (!found)
			{
				//System.out.println("NOT FOUND");
			}
		}
		return index;
	}
	private int getSeqIndexPrefix(ESequenceSetting seqSet, Object element)
	{
		int index = 0;
		EList<ESequenceValueItem> defaultItems = ((ESequenceValue)seqSet.getValue()).getItems();
		
		boolean found = false;
		
		for (int i = 0 ; i < defaultItems.size() ; i++)
		{
			
			for (ESettingValue setVal : defaultItems.get(i).getSubSettings())
			{
				if (setVal.equals(element))
				{
					found = true;
					break;
				}
			}
			if (found)
				break;
			index++;
		}
		
		if (!found)
		{
			EList<ESequenceValueItem> items = ((ESequenceValue)seqSet.getDefaultValue()).getItems();
			for (int i = 0 ; i < items.size() ; i++)
			{
			
				for (ESettingValue setVal : items.get(i).getSubSettings())
				{
					if (setVal.equals(element))
					{
						found = true;
						break;
					}
				}
				if (found)
					break;
				index++;
			}
			if (!found)
			{
				//System.out.println("NOT FOUND");
			}
		}
		return index;
	}
	
	private int getSeqIndexReplace(ESequenceSetting seqSet, Object element)
	{
		int index = 0;
		EList<ESequenceValueItem> defaultItems = ((ESequenceValue)seqSet.getValue()).getItems();
		
		boolean found = false;
		
		for (int i = 0 ; i < defaultItems.size() ; i++)
		{
			
			for (ESettingValue setVal : defaultItems.get(i).getSubSettings())
			{
				if (setVal.equals(element))
				{
					found = true;
					break;
				}
			}
			if (found)
				break;
			index++;
		}
	
		return index;
	}
	
}
