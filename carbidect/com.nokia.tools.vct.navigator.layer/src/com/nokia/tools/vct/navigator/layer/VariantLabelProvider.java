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
 * Description: This file is part of com.nokia.tools.vct.navigator.layer component.
 */

package com.nokia.tools.vct.navigator.layer;


import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.variant.confml.ui.ConfmlUI;
import com.nokia.tools.variant.confml.ui.IConfmlImages;
import com.nokia.tools.variant.confml.ui.views.ConfMLViewLabelProvider;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;


public class VariantLabelProvider extends LabelProvider {

	static final URI URI_CONFML = URI.createURI("confml/");
	static final URI URI_IMPLML = URI.createURI("implml/");
	static final URI URI_CONTENT = URI.createURI("content/");
	static final URI URI_DOC = URI.createURI("doc/");
	
	ConfMLViewLabelProvider provider;
	
	public VariantLabelProvider() {
		provider = new ConfMLViewLabelProvider();
	}
	
	@Override
	public String getText(Object element) {

		if (element instanceof IProject)
		{
			return provider.getText(element);
		}
		else if (element instanceof IResource) {
			return null;
		}
		
		return provider.getText(element);
	}
	
	@Override
	public Image getImage(Object element) {
		if (element instanceof IFolder) {
			final IFolder folder = (IFolder)element;
			TransactionalEditingDomain domain = ConfMLCore.getEditingDomain();
			try {
				Image result = TransactionUtil.runExclusive(domain, new RunnableWithResult.Impl<Image>() {
					public void run() {
						EConfigurationProject project;
						project = ConfMLCore.getProjectModel(folder.getProject());
						URI uri = URI.createPlatformResourceURI(folder.getFullPath().toPortableString(), true).appendSegment("");
						if (project != null) {
							List<URI> layers = new ArrayList<URI>(); 
							
							for  (EConfMLLayer layer : project.getLayers()) {
								URI layerURI = layer.getLayerURI();
								if (uri.equals(layerURI)) {
									Image image = ConfmlUI.getImage(IConfmlImages.FLD_PARENTS);
									setResult(image);
									return;
								}
								layers.add(layerURI);
							}
							
							for (URI layerURI: layers) {
								URI confmlURI = URI_CONFML.resolve(layerURI);
								if (uri.equals(confmlURI)) {
									Image image = ConfmlUI.getImage(IConfmlImages.FLD_CONFML);
									setResult(image);
									return;
								}
								URI implmlURI = URI_IMPLML.resolve(layerURI);
								if (uri.equals(implmlURI)) {
									Image image = ConfmlUI.getImage(IConfmlImages.FLD_IMPLML);
									setResult(image);
									return;
								}
								URI contentURI = URI_CONTENT.resolve(layerURI);
								if (uri.equals(contentURI)) {
									Image image = ConfmlUI.getImage(IConfmlImages.FLD_CONTENT);
									setResult(image);
									return;
								}
								URI docURI = URI_DOC.resolve(layerURI);
								if (uri.equals(docURI)) {
									Image image = ConfmlUI.getImage(IConfmlImages.FLD_NOTES);
									setResult(image);
									return;
								}
								
							}
						}
						setResult(null);
					}
				});
				
				return result;
				
			} catch (InterruptedException e) {
			}
			
			return null;
		} else if (element instanceof IProject) {
			final IProject project = (IProject)element;
			if (!project.isAccessible()) {
				return null;
			}
			
			TransactionalEditingDomain domain = ConfMLCore.getEditingDomain();
			try {
				Boolean result = TransactionUtil.runExclusive(domain, new RunnableWithResult.Impl<Boolean>() {
					public void run() {
						EConfigurationProject cp;
						cp = ConfMLCore.getProjectModel(project);
						setResult(cp != null);
					}
				});
				
				if (result) {
					return ConfmlUI.getImage(IConfmlImages.FLD_PROJECT);
				}
				
			} catch (InterruptedException e) {
			}
			
			return null;
		} else if (element instanceof IResource) {
			return null;
		} else {
			return provider.getImage(element);
		}
	}
}
