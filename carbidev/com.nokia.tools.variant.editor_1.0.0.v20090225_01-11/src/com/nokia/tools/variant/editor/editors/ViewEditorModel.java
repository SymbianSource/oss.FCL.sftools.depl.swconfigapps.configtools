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
 * Description: This file is part of com.nokia.tools.variant.editor component.
 */

package com.nokia.tools.variant.editor.editors;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import com.nokia.tools.variant.common.core.utils.FileUtils;
import com.nokia.tools.variant.confml.core.model.application.EConfigurationProject;
import com.nokia.tools.variant.content.confml.View;
import com.nokia.tools.variant.editor.cpfInfo.CPFInformation;
import com.nokia.tools.variant.editor.model.convertor.CPFInformationConvertor;
import com.nokia.tools.variant.editor.model.convertor.ViewModel2ConfMLPersistenceModelConvertor;
import com.nokia.tools.variant.editor.model.summaryModel.History;
import com.nokia.tools.variant.resourcelibrary.model.ResourceModelRoot;

/**
 * 
 * Container object carrying all necessary models and other information about
 * edited CPF file.
 * 
 */
public class ViewEditorModel {
	// private String name;
	// private IPersistableElement persistable;
	// private ImageDescriptor imageDescriptor;
	// private String toolTipText;
	private View view;
	private EConfigurationProject vContributor;
	private String cpfFilePath;
	private String confmlPath;
	private ResourceModelRoot rModelRoot;
	private ResourceModelRoot productImagesRoot;
	private ResourceModelRoot guidelinesRoot;
	private String avrProperty;
	private CPFInformation cpfMetadata;
	private ViewModel2ConfMLPersistenceModelConvertor viewConvertor;
	private CPFInformationConvertor cpfInformationConvertor;
	private File tempDefaultResourceLibraryFilesDir;
	private List<File> temporaryDirsToRemove = new ArrayList<File>();

	public List<File> getTemporaryDirsToRemove() {
		return temporaryDirsToRemove;
	}

	private List listOfOpenedEditorParts = new ArrayList();

	public List getListOfOpenedEditorParts() {
		return listOfOpenedEditorParts;
	}

	public void setListOfOpenedEditorParts(List listOfOpenedEditorParts) {
		this.listOfOpenedEditorParts = listOfOpenedEditorParts;
	}

	public File getTempDefaultResourceLibraryFilesDir() {
		return tempDefaultResourceLibraryFilesDir;
	}

	public void setTempDefaultResourceLibraryFilesDir(
			File tempDefaultResourceLibraryFilesDir) {
		this.tempDefaultResourceLibraryFilesDir = tempDefaultResourceLibraryFilesDir;
	}

	public CPFInformationConvertor getCpfInformationConvertor() {
		return cpfInformationConvertor;
	}

	public void setCpfInformationConvertor(
			CPFInformationConvertor cpfInformationConvertor) {
		this.cpfInformationConvertor = cpfInformationConvertor;
	}

	private History history;

	// public boolean exists() {
	//		
	// return false;
	// }
	//
	// public ImageDescriptor getImageDescriptor() {
	//		
	// return imageDescriptor;
	// }
	//
	// public String getName() {
	//		
	// return name;
	// }
	//
	// public IPersistableElement getPersistable() {
	//		
	// return persistable;
	// }
	//
	// public String getToolTipText() {
	//		
	// return toolTipText;
	// }
	//
	// @SuppressWarnings("unchecked")
	// public Object getAdapter(Class adapter) {
	//	
	// return null;
	// }

	// public void setToolTipText(String toolTipText) {
	// this.toolTipText = toolTipText;
	// }
	//
	// public void setName(String name) {
	// this.name = name;
	// }
	//
	// public void setPersistable(IPersistableElement persistable) {
	// this.persistable = persistable;
	// }

	public ViewModel2ConfMLPersistenceModelConvertor getViewConvertor() {
		return viewConvertor;
	}

	public void setViewConvertor(
			ViewModel2ConfMLPersistenceModelConvertor viewConvertor) {
		this.viewConvertor = viewConvertor;
	}

	public void setView(View view) {
		this.view = view;
	}

	public View getView() {
		return view;
	}

	public void setConfmlPath(String confmlPath) {
		this.confmlPath = confmlPath;

	}

	public String getConfmlPath() {
		return confmlPath;

	}

	public void setCpfFilePath(String cpfFilePath) {
		this.cpfFilePath = cpfFilePath;
	}

	public String getCpfFilePath() {
		return cpfFilePath;
	}

	public void setVariantContributor(EConfigurationProject vContributor) {
		this.vContributor = vContributor;
	}

	public EConfigurationProject getVariantContributor() {
		return vContributor;
	}

	public void setResourceModelRoot(ResourceModelRoot resourceModelRoot) {
		this.rModelRoot = resourceModelRoot;
	}

	public ResourceModelRoot getResourceModelRoot() {
		return rModelRoot;
	}

	public void setProductImagesRoot(ResourceModelRoot productImagesRoot) {
		this.productImagesRoot = productImagesRoot;
	}

	public ResourceModelRoot getProductImagesRoot() {
		return productImagesRoot;
	}

	public void setGuidelinesRoot(ResourceModelRoot guidelinesRoot) {
		this.guidelinesRoot = guidelinesRoot;
	}

	public ResourceModelRoot getGuidelinesRoot() {
		return guidelinesRoot;
	}

	public void setCpfMetadata(CPFInformation cpfMetadata) {
		this.cpfMetadata = cpfMetadata;
	}

	public CPFInformation getCpfMetadata() {
		return cpfMetadata;
	}

	public History getHistory() {
		return history;
	}

	public void setHistory(History history) {
		this.history = history;
	}

	public String getAvrProperty() {
		return avrProperty;
	}

	public void setAvrProperty(String avrProperty) {
		this.avrProperty = avrProperty;
	}

	/**
	 * Disposes all its elements and associated resources with it.
	 */
	public void dispose() {
		if (rModelRoot != null) {
			removeAllListenersFromResourceLibraryModel(rModelRoot);
			rModelRoot.deleteOnFileSystem();
		}
		rModelRoot = null;

		if (productImagesRoot != null) {
			removeAllListenersFromResourceLibraryModel(productImagesRoot);
			productImagesRoot.deleteOnFileSystem();
		}
		productImagesRoot = null;

		if (guidelinesRoot != null) {
			removeAllListenersFromResourceLibraryModel(guidelinesRoot);
			guidelinesRoot.deleteOnFileSystem();
		}
		guidelinesRoot = null;

		view = null;
		vContributor = null;
		cpfFilePath = null;
		confmlPath = null;
		avrProperty = null;
		cpfMetadata = null;
		viewConvertor = null;
		cpfInformationConvertor = null;

		// remove all default resources (files) from Resource library
		if (tempDefaultResourceLibraryFilesDir != null) {
			FileUtils.deleteDirectory(tempDefaultResourceLibraryFilesDir);
			tempDefaultResourceLibraryFilesDir = null;
		}
		listOfOpenedEditorParts = null;
		history = null;
	}

	/**
	 * Removes all attached listeners from all elements in the
	 * resourceLibraryModelRoot
	 * 
	 * @param resourceLibraryModelRoot
	 *            root of resource library model
	 */
	private void removeAllListenersFromResourceLibraryModel(
			ResourceModelRoot resourceLibraryModelRoot) {
		if (resourceLibraryModelRoot == null) {
			return;
		}

		TreeIterator<EObject> allElementsInModel = resourceLibraryModelRoot
				.eAllContents();
		while (allElementsInModel.hasNext()) {
			EObject element = allElementsInModel.next();
			element.eAdapters().clear();
		}
	}

}
