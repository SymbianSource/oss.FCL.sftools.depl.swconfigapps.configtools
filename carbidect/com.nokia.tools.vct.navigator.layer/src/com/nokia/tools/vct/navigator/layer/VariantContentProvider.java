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
import java.util.Map;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.variant.confml.ui.views.ConfMLNavigator;
import com.nokia.tools.vct.common.appmodel.EAppFeature;
import com.nokia.tools.vct.common.appmodel.EAppGroup;
import com.nokia.tools.vct.common.appmodel.EAppGroupContainer;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;
import com.nokia.tools.vct.common.ui.utils.SWTUtil;

public class VariantContentProvider implements ITreeContentProvider {

	class Listener extends ResourceSetListenerImpl {
		@Override
		public boolean isPostcommitOnly() {
			return true;
		}
		
		
		
//		@Override
//		public NotificationFilter getFilter()
//		{
//			return NotificationFilter.RESOURCE_LOADED; //filters out some of the unwanted ResourceSetChangeEvents.
//		}

		@Override
		public void resourceSetChanged(final ResourceSetChangeEvent event) {

			if (event.getNotifications().size() == 1)
			{
				return; //no need to refresh on this one...	
			}
			
			SWTUtil.getStandardDisplay().asyncExec(new Runnable() {
				public void run() {
					if (viewer != null)
					{
						System.out.println("\n*** REFRESH ***\n");
						viewer.refresh();
					}
				}
			});
		}
	}
	
	private Viewer viewer;
	private TransactionalEditingDomain domain;
	private ResourceSetListener listener = new Listener();

	public VariantContentProvider() {
		domain = ConfMLCore.getEditingDomain();
	}

	public Object[] getChildren(final Object parentElement) {
		try {
			return TransactionUtil.runExclusive(domain, new RunnableWithResult.Impl<Object[]>() {
				public void run() {
					ArrayList<Object> result = new ArrayList<Object>();
					if (parentElement instanceof IProject) {
						EConfigurationProject project = null;
						project = ConfMLCore.getProjectModel((IProject)parentElement);
						if (project != null) {
							result.add(new ConfMLNavigator.Features(project.getLastLayer()));
							result.add(new ConfMLNavigator.Views(project.getLastLayer()));
						}
					} else if (parentElement instanceof IFolder) {
						IFolder folder = (IFolder)parentElement;
						EConfigurationProject project;
						project = ConfMLCore.getProjectModel(folder.getProject());
						URI uri = URI.createPlatformResourceURI(folder.getFullPath().toPortableString(), true);
						if (project != null) {
							for  (EConfMLLayer layer : project.getLayers()) {
								URI layerURI = layer.getLayerURI();
								if (uri.equals(layerURI)) {
									result.add(new ConfMLNavigator.Features(layer));
									result.add(new ConfMLNavigator.Views(layer));
									break;
								}
							}
						}
					} else if (parentElement instanceof EConfigurationProject) {
						EConfigurationProject project = (EConfigurationProject)parentElement;
						if (project.getLastLayer() != null) {
							result.addAll(project.getLastLayer().getFeatures().values());
							result.addAll(project.getLastLayer().getViews().values());
						}
					} else if (parentElement instanceof EConfMLLayer) {
						result.addAll(((EConfMLLayer) parentElement).getFeatures().values());
						result.addAll(((EConfMLLayer) parentElement).getViews().values());
					} else if (parentElement instanceof EAppFeature) {
						EAppFeature obj = (EAppFeature) parentElement;
						result.addAll(obj.getSettings().values());
					} else if (parentElement instanceof EAppGroupContainer) {
						EAppGroupContainer obj = (EAppGroupContainer) parentElement;
						result.addAll(obj.getGroups());
						if(parentElement instanceof EAppGroup) {
							EAppGroup ag = (EAppGroup) parentElement;
							result.addAll(ag.getSettings());
						}
					} else if (parentElement instanceof ConfMLNavigator.Features) {
						EConfMLLayer layer = ((ConfMLNavigator.Features) parentElement).getParent();
						if (layer != null) {
							result.addAll(layer.getFeatures().values());
						}
					} else if (parentElement instanceof ConfMLNavigator.Views) {
						EConfMLLayer layer = ((ConfMLNavigator.Views) parentElement).getParent();
						if (layer != null) {
							result.addAll(layer.getViews().values());
						}
					}
					setResult(result.toArray());
				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
			return new Object[0];
		}
		
	}

	public Object getParent(final Object element) {
		try {
			return TransactionUtil.runExclusive(domain, new RunnableWithResult.Impl<Object>() {
				public void run() {
					if (element instanceof EObject) {
						EObject obj = (EObject)element;
						EObject parent = obj.eContainer();
						if (parent instanceof Map.Entry) {
							setResult(parent.eContainer());
						} else if (parent != null) {
							setResult(parent);
						}
					}
				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		}

		
	}

	public boolean hasChildren(Object element) {
		if (element instanceof IProject) {
			IProject project = (IProject)element;
			if (!project.isAccessible()) {
				return false;
			}
			EConfigurationProject cp = ConfMLCore.getProjectModel(project);
			return cp != null;
		} else if (element instanceof IResource) {
			return false;
		} else if (element instanceof EObject) {
			return getChildren(element).length > 0;
		}else if (element instanceof ConfMLNavigator.Features) {
			EConfMLLayer layer = ((ConfMLNavigator.Features) element).getParent();
			return layer != null && !layer.getFeatures().isEmpty();
		} else if (element instanceof ConfMLNavigator.Views) {
			EConfMLLayer layer = ((ConfMLNavigator.Views) element).getParent();
			return layer != null && !layer.getViews().isEmpty();
		}

		return true;
	}

	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	public void dispose() {
		domain.removeResourceSetListener(listener);
		viewer = null;
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		domain.removeResourceSetListener(listener);
		this.viewer = viewer;
		if (viewer != null) {
			domain.addResourceSetListener(listener);
		}
	}

}
