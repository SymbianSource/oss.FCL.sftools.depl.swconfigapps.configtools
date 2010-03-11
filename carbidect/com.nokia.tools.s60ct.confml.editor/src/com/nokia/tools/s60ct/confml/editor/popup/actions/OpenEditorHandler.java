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
package com.nokia.tools.s60ct.confml.editor.popup.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

import com.nokia.tools.s60ct.confml.editor.ConfmlEditorUtil;
import com.nokia.tools.s60ct.confml.editor.ValueEditorInputAppFeature;
import com.nokia.tools.s60ct.confml.editor.ValueEditorInputAppGroup;
import com.nokia.tools.s60ct.confml.viewer.FeatureViewer;
import com.nokia.tools.s60ct.model.confml.presentation.ConfmlEditor;
import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.variant.confml.ui.ConfmlUI;
import com.nokia.tools.variant.confml.ui.editors.EditorUtils;
import com.nokia.tools.vct.common.appmodel.EAppFeature;
import com.nokia.tools.vct.common.appmodel.EAppGroup;
import com.nokia.tools.vct.common.appmodel.EAppIncludeElement;
import com.nokia.tools.vct.common.appmodel.EAppNamedItem;
import com.nokia.tools.vct.common.appmodel.EAppView;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.core.utils.ArrayUtils;
import com.nokia.tools.vct.confml.model.confml1.EConfMLDocument;
import com.nokia.tools.vct.confml.model.confml1.EConfigurationElement;
import com.nokia.tools.vct.confml.model.confml1.EDataElement;
import com.nokia.tools.vct.confml.model.confml1.EFeatureElement;
import com.nokia.tools.vct.confml.model.confml1.EViewElement;
import com.nokia.tools.vct.confml.model.confml1.include.EInclude;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Document;

public class OpenEditorHandler implements IHandler {

	private IWorkbenchWindow window;

	public void addHandlerListener(IHandlerListener handlerListener) {}

	public void dispose() {}

	public void externalExecute(Object element, IWorkbenchWindow extWindow, String ref)
	{
		if(element instanceof EAppFeature)
		{
			window = extWindow;
			URI uri;
			EAppFeature feature = (EAppFeature) element;			
			String editorId = getEditorId();
			EConfMLLayer layer = getLayer(feature);
			uri = searchDataFile(layer);
			if (uri == null) {
				uri = getDataConfMLFileURI(layer);
			}
			if (editorId != null && uri != null) {
				uri = uri.appendFragment(feature.getRef());
				URIEditorInput input = new ValueEditorInputAppFeature(uri, feature);
				IEditorPart editor = openEditor(input, editorId);
				if (editor instanceof ConfmlEditor)
				{
					ConfmlEditor confmlEditor = (ConfmlEditor)editor;
					((FeatureViewer)confmlEditor.getViewer()).setSelectionToRef(ref);
				}
			}
		}
	}
	
	public Object execute(ExecutionEvent event) throws ExecutionException {

		window = HandlerUtil.getActiveWorkbenchWindow(event);

		ISelection sel = HandlerUtil.getCurrentSelection(event);
			
		Object element = null;
		
		if (sel instanceof ITreeSelection)
		{
			ITreeSelection ts = (ITreeSelection) sel;
			element = ts.getFirstElement();
		}
		else if (sel instanceof StructuredSelection)
		{
			StructuredSelection ss = (StructuredSelection)sel;
			 element = ss.getFirstElement();
		}

		if(element instanceof EAppFeature) {
			URI uri;
			EAppFeature feature = (EAppFeature) element;			
			String editorId = getEditorId();
			EConfMLLayer layer = getLayer(feature);
			uri = searchDataFile(layer);
			if (uri == null) {
				uri = getDataConfMLFileURI(layer);
			}
			if (editorId != null && uri != null) {
				uri = uri.appendFragment(feature.getRef());
				URIEditorInput input = new ValueEditorInputAppFeature(uri, feature);
				openEditor(input, editorId);
			}
		} else if(element instanceof EAppGroup) {
			EAppGroup group = (EAppGroup) element;
			
			EConfMLLayer layer = getLayer(group);
			String editorId = getEditorId();
			
			URI baseUri = searchDataFile(layer);
			if (baseUri == null) {
				baseUri = getDataConfMLFileURI(layer);
			}
			
			URI uri = baseUri.appendFragment(getGroupFragment(group));
			URIEditorInput input = new ValueEditorInputAppGroup(uri,group);
			
			openEditor(input, editorId);
		} else if(element instanceof EAppView){
			URI uri = ArrayUtils.getLast(((EAppView) element).getUri());
			if (uri != null) {
				uri = uri.trimFragment();
				String editorId = ConfmlUI.VIEW_EDITOR_ID;
				EditorUtils.openEditor(uri, editorId);
			}
		} else {}

		return null;

	}

	public boolean isEnabled() {
		return true;
	}

	public boolean isHandled() {
		return true;
	}

	public void removeHandlerListener(IHandlerListener handlerListener) {
	}

	private String getGroupFragment(EAppGroup group) {
		StringBuilder sb = new StringBuilder();
		sb.append("@");
		List<String> names = new ArrayList<String>();
		names.add(group.getName());
		EObject container = group.eContainer();
		for(;;) {
			EAppNamedItem named = (EAppNamedItem) container;
			names.add(named.getName());
			if(container == null) {
				break;
			} else if(container instanceof EAppView) {
				break;
			} else {
				container = container.eContainer();				
			}
		}
		for (int i = names.size()-1; i >= 0; i--) {
			sb.append(ConfmlEditorUtil.escapeSpaces(names.get(i)));
			if(i!=0) {
				sb.append("/");
			}
		}
		return sb.toString();
	}
	
	private IEditorPart openEditor(URIEditorInput input, String editorId) {
		IEditorDescriptor descriptor = window.getWorkbench().getEditorRegistry()
		.findEditor(editorId);

		IWorkbenchPage activePage = window.getActivePage();
		try 
		{
			return activePage.openEditor(input, descriptor.getId());
		} catch (PartInitException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	private URI getDataConfMLFileURI(EConfMLLayer layer) {
		URI layerURI = layer.getLayerURI();
		String uriAsString = layerURI.toString();
		if (uriAsString.endsWith("/")) {
			uriAsString = uriAsString.substring(0, uriAsString.length() - 1);
		}
		layerURI = URI.createURI(uriAsString);
		URI dataFileUri = layerURI.appendSegments(new String[] { "confml",
		"data" });
		return dataFileUri.appendFileExtension("confml");
	}

	private String getEditorId() {
		return ConfmlEditor.CONFML_EDITOR_ID;
	}

	private EConfMLLayer getLayer(EObject eo) {
		if(eo instanceof EAppFeature) {
			EAppFeature f = (EAppFeature) eo;
			return (EConfMLLayer) f.eContainer().eContainer();
		}
		if(eo instanceof EAppGroup) {
			EAppGroup g = (EAppGroup) eo;
			return getLayer(g);
		}
		return null;
	}

	private EConfMLLayer getLayer(EAppGroup group) {
		EObject container = group.eContainer();
		while((container !=null) && !(container instanceof EConfMLLayer)) {
			container = container.eContainer();
		}		
		return (EConfMLLayer) container;
	}

	private URI searchDataFile(EConfMLLayer layer) {
		TransactionalEditingDomain domain = ConfMLCore.getEditingDomain();
		List<URI> candidateResources = new ArrayList<URI>();
		ResourceSet rs = domain.getResourceSet();

		EList<EAppIncludeElement> includes = layer.getIncludes();
		for (int i = includes.size() - 1; i >= 0; i--) {
			URI target = includes.get(i).getTarget();
			if (containsOnlyDataSection(rs.getResource(target, false))) {
				candidateResources.add(target);
			}
		}
		if (!candidateResources.isEmpty()) {
			return candidateResources.get(0);
		}
		return null;
	}

	private boolean containsOnlyDataSection(Resource resource) {
		if (resource == null || resource.getContents().isEmpty()) {
			return false;
		}
		EObject root = resource.getContents().get(0);
		if (root instanceof EConfMLDocument) {
			EConfMLDocument doc = (EConfMLDocument) root;
			EConfigurationElement conf = doc.getConfiguration();
			EList<EDataElement> data = conf.getData();
			EList<EFeatureElement> features = conf.getFeatures();
			EList<EInclude> includes = conf.getIncludes();
			EList<EViewElement> views = conf.getViews();
			if (!data.isEmpty() && features.isEmpty() && includes.isEmpty()
					&& views.isEmpty()) {
				return true;
			}
		} else if (root instanceof EConfML2Document) {
			EConfML2Document doc2 = (EConfML2Document) root; 
			com.nokia.tools.vct.confml.model.confml2.EConfigurationElement conf2 = doc2.getConfiguration();
			EList<com.nokia.tools.vct.confml.model.confml2.EDataElement> data = conf2.getData();
			EList<com.nokia.tools.vct.confml.model.confml2.EFeatureElement> features = conf2.getFeatures();
			EList<EInclude> includes = conf2.getIncludes();
			EList<com.nokia.tools.vct.confml.model.confml2.EViewElement> views = conf2.getViews();
			if (!data.isEmpty() && features.isEmpty() && includes.isEmpty()
					&& views.isEmpty()) {
				return true;
			}

		}
		return false;
	}

}
