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
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;

import com.nokia.tools.carbide.ct.confml.ui.editors.ConfMLMultiPageEditorPart;
import com.nokia.tools.s60ct.confml.viewer.FeatureViewer;
import com.nokia.tools.s60ct.model.confml.EFeature;
import com.nokia.tools.s60ct.model.confml.EResourceSetting;
import com.nokia.tools.s60ct.model.confml.EResourceValue;
import com.nokia.tools.s60ct.model.confml.ESequenceSetting;
import com.nokia.tools.s60ct.model.confml.ESetting;
import com.nokia.tools.s60ct.model.confml.ESimpleSetting;
import com.nokia.tools.s60ct.model.confml.ESimpleValue;
import com.nokia.tools.s60ct.model.confml.presentation.ConfmlEditor;
import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.vct.common.appmodel.EAppFeature;
import com.nokia.tools.vct.common.appmodel.EAppSetting;
import com.nokia.tools.vct.common.appmodel.EAppSettingData;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;

public class OpenConfmlAction extends Action {

	private List<ESetting> selectedObjects = new ArrayList<ESetting>();
	FeatureViewer featureViewer;

	private IWorkbenchWindow window;

	public OpenConfmlAction(FeatureViewer featureViewer) {
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
				openEditor(confmlEditor, selectedObjects.get(0));
			}
		} 
		else 
		{ // RUN from popup menu - action has settingsViewer set by
			// constructor
			ISelection selection = featureViewer.getSelection();
			takeSettingsFromSelection(selection);
			openEditor(featureViewer.getEditor(), selectedObjects.get(0));
		}
	}

	private void openEditor(IEditorPart activeEditor, Object element)
	{
		ESetting setting = null;
		if (element instanceof ESetting)
		{
			setting = (ESetting)element;
		}
			
		URIEditorInput editorInput = (URIEditorInput)activeEditor.getEditorInput();
		String uri = editorInput.getURI().toPlatformString(true);
		
		Path path = new Path(uri);
		IFile iFile = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		
		URI finalUri = getURI(iFile.getProject(), setting);
		
		Path finalPath = new Path(finalUri.toPlatformString(true));
		IFile finalFile = ResourcesPlugin.getWorkspace().getRoot().getFile(finalPath);
		
		try 
		{
			IEditorDescriptor editorDesc = IDE.getEditorDescriptor(finalFile);
			ConfMLMultiPageEditorPart editor = (ConfMLMultiPageEditorPart)IDE.openEditor(window.getActivePage(), finalFile, editorDesc.getId());
			editor.setSelectionToRef(setting.getRef());
		}
		catch (PartInitException e) 
		{
			e.printStackTrace();
		}
	}

    private URI getURI(IProject project, ESetting setting) {
		
		String featureRef;
		EObject cont = setting.eContainer();
		if(cont instanceof EFeature) {
			featureRef = ((EFeature)setting.eContainer()).getRef();			
		} else {
			featureRef = ((EFeature)cont.eContainer()).getRef();
		}
		
		EConfigurationProject configurationProject = ConfMLCore
				.getProjectModel(project);

		if (configurationProject == null)
			return null;
		
		EList<EConfMLLayer> layers = configurationProject.getLayers();
		
		for (int i = 0 ; i < layers.size() ; i++)
		{
			EConfMLLayer layer = layers.get(i);
			EMap<String, EAppFeature> featureMap = layer.getFeatures();
			if (featureMap.containsKey(featureRef))
			{
				EAppFeature originalFeature = featureMap.get(featureRef);			
				EMap<String, EAppSetting> settingMap = originalFeature.getSettings();
				EAppSetting appSetting = null;
				if (cont instanceof ESequenceSetting)
				{
					ESequenceSetting ss = (ESequenceSetting)cont;
					appSetting = settingMap.get(ss.getRef());
				}
				else
				{
					appSetting = settingMap.get(setting.getRef());
				}
				if (appSetting == null)
					continue;	
				EAppSettingData settingData = appSetting.getValueInfo();
				return settingData.getUri().get(0);	
			}
		}
		return null;
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
		return "Open in ConfML Editor";
	}

	@Override
	public String getId() {
		return "Open in ConfML Editor";
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
				
				return true;					
				
			}
			if (object instanceof ESimpleValue) {
				
				return true;					
				
			}
			else if (object instanceof EResourceSetting) {
				
				return true;					
				
			}
		}
		return false;
	}
}
