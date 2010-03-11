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

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;

import com.nokia.tools.s60ct.confml.editor.ValueEditorInputAppFeature;
import com.nokia.tools.s60ct.model.confml.presentation.ConfmlEditor;
import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.vct.common.appmodel.EAppFeature;
import com.nokia.tools.vct.common.appmodel.EAppIncludeElement;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.appmodel.impl.EAppFeatureEntryImpl;
import com.nokia.tools.vct.confml.model.confml1.EConfMLDocument;
import com.nokia.tools.vct.confml.model.confml1.EConfigurationElement;
import com.nokia.tools.vct.confml.model.confml1.EDataElement;
import com.nokia.tools.vct.confml.model.confml1.EFeatureElement;
import com.nokia.tools.vct.confml.model.confml1.EViewElement;
import com.nokia.tools.vct.confml.model.confml1.include.EInclude;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Document;

/**
 * 
 */
public class OpenConfMLFeatureEditor implements IObjectActionDelegate {
	private ISelection selection;
	private IWorkbench workbench;

	public OpenConfMLFeatureEditor() {
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		workbench = targetPart.getSite().getWorkbenchWindow().getWorkbench();
	}

	public void run(IAction action) {
		if (selection == null) {
			return;
		}
		Object obj = ((IStructuredSelection) selection).getFirstElement();

		EAppFeature feature = (EAppFeature) obj;
		String editorId = getEditorId();
		URI uri;
		uri = searchDataFile(feature);
		if (uri == null) {
			uri = getDataConfMLFileURI(feature);
		}
		if (editorId != null && uri != null) {
			uri = uri.appendFragment(feature.getRef());
			openEditor(uri, feature, editorId);
		}
	}

	private URI searchDataFile(EAppFeature feature) {
		EConfMLLayer layer = (EConfMLLayer) feature.eContainer().eContainer();
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

	private void openEditor(URI uri, EAppFeature feature, String editorId) {
		IEditorDescriptor descriptor = workbench.getEditorRegistry()
				.findEditor(editorId);
		URIEditorInput input = new ValueEditorInputAppFeature(uri, feature);

		IWorkbenchPage activePage = workbench.getActiveWorkbenchWindow()
				.getActivePage();
		try {
			activePage.openEditor(input, descriptor.getId());
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}

	private String getEditorId() {
		return ConfmlEditor.CONFML_EDITOR_ID;
	}

	/**
	 * @param feature
	 * @return URI to layer root file
	 */
	private URI getDataConfMLFileURI(EAppFeature feature) {
		EAppFeatureEntryImpl entry = (EAppFeatureEntryImpl) feature
				.eContainer();
		EConfMLLayer layer = (EConfMLLayer) entry.eContainer();
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

	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}
}
