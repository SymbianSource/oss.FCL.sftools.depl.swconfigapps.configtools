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
 * Description: This file is part of com.nokia.tools.vct.navigator.confml component.
 */

package com.nokia.tools.vct.navigator.confml;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.resource.impl.PlatformResourceURIHandlerImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;

import com.nokia.tools.vct.common.ui.utils.SWTUtil;
import com.nokia.tools.vct.confml.model.confml1.EConfMLDocument;
import com.nokia.tools.vct.confml.model.confml1.EConfigurationElement;
import com.nokia.tools.vct.confml.model.confml1.EDataElement;
import com.nokia.tools.vct.confml.model.confml1.EFeatureRfs;
import com.nokia.tools.vct.confml.model.confml1.EGroupContainer;
import com.nokia.tools.vct.confml.model.confml1.ERfsElement;
import com.nokia.tools.vct.confml.model.confml1.ESettingDataContainer;
import com.nokia.tools.vct.confml.model.confml1.ESettingTypeContainer;
import com.nokia.tools.vct.confml.model.confml1.util.EConfML1ResourceFactoryImpl;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Document;

public class ConfmlContentProvider implements ITreeContentProvider {

	/**
	 * This listens for workspace changes. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	final IResourceChangeListener resourceChangeListener = new IResourceChangeListener() {

		public void resourceChanged(IResourceChangeEvent event) {
			IResourceDelta delta = event.getDelta();
			if (delta == null) {
				return;
			}

			try {
				final List<IFile> files = new ArrayList<IFile>();

				class ResourceDeltaVisitor implements IResourceDeltaVisitor {
					public boolean visit(IResourceDelta delta) {
						if (delta.getResource().getType() == IResource.FILE) {
							if (delta.getKind() == IResourceDelta.REMOVED
									|| delta.getKind() == IResourceDelta.CHANGED
									&& delta.getFlags() != IResourceDelta.MARKERS) {
								String ext = delta.getFullPath()
										.getFileExtension();
								if ("confml".equals(ext)) {
									files.add((IFile) delta.getResource());
								}
							}
						}

						return true;
					}
				}

				ResourceDeltaVisitor visitor = new ResourceDeltaVisitor();
				delta.accept(visitor);

				if (!files.isEmpty()) {
					SWTUtil.getStandardDisplay().asyncExec(new Runnable() {
						public void run() {
							if (viewer != null
									&& !viewer.getControl().isDisposed()) {
								if (viewer instanceof TreeViewer) {
									((TreeViewer)viewer).refresh(true);
								} else {
									viewer.refresh();
								}
							}
						}
					});

				}

			} catch (CoreException exception) {
				exception.printStackTrace();
			}
		}
	};

	private ResourceSet resourceSet;
	private Viewer viewer;

	public ConfmlContentProvider() {
		resourceSet = new ResourceSetImpl();
		List<URIHandler> handlers = new ArrayList<URIHandler>();
		handlers.add(new PlatformResourceURIHandlerImpl());
		resourceSet.setURIConverter(new ExtensibleURIConverterImpl(handlers,
				ContentHandler.Registry.INSTANCE.contentHandlers()));
	}

	public Object[] getChildren(Object parentElement) {
		ArrayList<EObject> result = new ArrayList<EObject>();
		if (parentElement instanceof IFile) {
			Resource resource = null;
			IFile file = (IFile) parentElement;
			String path = file.getFullPath().toPortableString();
			URI uri = URI.createPlatformResourceURI(path, true);
			EConfML1ResourceFactoryImpl factory = new EConfML1ResourceFactoryImpl();
			resource = factory.createResource(uri);
			Resource old = resourceSet.getResource(uri, false);
			if (old != null) {
				resourceSet.getResources().remove(old);
			}
			resourceSet.getResources().add(resource);
			try {
				resource.load(null);
			} catch (Exception e) {
				// e.printStackTrace();
				// resource = null;
			} finally {
			}

			if (resource != null) {
				result.addAll(resource.getContents());
			}
		} else if (parentElement instanceof EConfMLDocument) {
			EConfigurationElement ce = ((EConfMLDocument) parentElement).getConfiguration(); 
			result.add(ce);
		} else if (parentElement instanceof EConfML2Document) {
			com.nokia.tools.vct.confml.model.confml2.EConfigurationElement ce = ((EConfML2Document) parentElement).getConfiguration(); 
			result.add(ce);
		} else if (parentElement instanceof EConfigurationElement) {
			EConfigurationElement obj = (EConfigurationElement) parentElement;
			result.addAll(obj.getConfigurations());
			result.addAll(obj.getFeatures());
			for (EDataElement data : obj.getData()) {
				result.addAll(data.getData());
			}
			for (ERfsElement rfs : obj.getRfs()) {
				result.addAll(rfs.getRfs());
			}
			result.addAll(obj.getViews());
			result.addAll(obj.getIncludes());
		} else if (parentElement instanceof com.nokia.tools.vct.confml.model.confml2.EConfigurationElement) {
			com.nokia.tools.vct.confml.model.confml2.EConfigurationElement obj = (com.nokia.tools.vct.confml.model.confml2.EConfigurationElement) parentElement;
			result.addAll(obj.getConfigurations());
			result.addAll(obj.getFeatures());
			for (com.nokia.tools.vct.confml.model.confml2.EDataElement data : obj.getData()) {
				result.addAll(data.getData());
			}
			for (com.nokia.tools.vct.confml.model.confml2.ERfsElement rfs : obj.getRfs()) {
				result.addAll(rfs.getRfs());
			}
			result.addAll(obj.getViews());
			result.addAll(obj.getIncludes());
		} else if (parentElement instanceof ESettingTypeContainer) {
			ESettingTypeContainer obj = (ESettingTypeContainer) parentElement;
			result.addAll(obj.getSettings());
		} else if (parentElement instanceof ESettingDataContainer) {
			ESettingDataContainer obj = (ESettingDataContainer) parentElement;
			result.addAll(obj.getSettings());
		} else if (parentElement instanceof EFeatureRfs) {
			EFeatureRfs obj = (EFeatureRfs) parentElement;
			result.addAll(obj.getSettings());
		} else if (parentElement instanceof EGroupContainer) {
			EGroupContainer obj = (EGroupContainer) parentElement;
			result.addAll(obj.getGroups());
		} else if (parentElement instanceof com.nokia.tools.vct.confml.model.confml2.ESettingTypeContainer) {
			com.nokia.tools.vct.confml.model.confml2.ESettingTypeContainer obj = (com.nokia.tools.vct.confml.model.confml2.ESettingTypeContainer) parentElement;
			result.addAll(obj.getSettings());
		} else if (parentElement instanceof com.nokia.tools.vct.confml.model.confml2.ESettingDataContainer) {
			com.nokia.tools.vct.confml.model.confml2.ESettingDataContainer obj = (com.nokia.tools.vct.confml.model.confml2.ESettingDataContainer) parentElement;
			result.addAll(obj.getSettings());
		} else if (parentElement instanceof com.nokia.tools.vct.confml.model.confml2.EFeatureRfs) {
			com.nokia.tools.vct.confml.model.confml2.EFeatureRfs obj = (com.nokia.tools.vct.confml.model.confml2.EFeatureRfs) parentElement;
			result.addAll(obj.getSettings());
		} else if (parentElement instanceof com.nokia.tools.vct.confml.model.confml2.EGroupContainer) {
			com.nokia.tools.vct.confml.model.confml2.EGroupContainer obj = (com.nokia.tools.vct.confml.model.confml2.EGroupContainer) parentElement;
			result.addAll(obj.getGroups());
		}
		return result.toArray();
	}

	public Object getParent(Object element) {
		if (element instanceof EObject) {
			EObject obj = (EObject) element;
			EObject parent = obj.eContainer();
			if (parent instanceof EDataElement || parent instanceof ERfsElement) {
				return parent.eContainer();
			} else if (parent instanceof com.nokia.tools.vct.confml.model.confml2.EDataElement
					|| parent instanceof com.nokia.tools.vct.confml.model.confml2.ERfsElement) {
				return parent.eContainer();
			} else if (parent != null) {
				return parent;
			}
			Resource resource = obj.eResource();
			if (resource != null) {
				String path = resource.getURI().toPlatformString(true);
				return ResourcesPlugin.getWorkspace().getRoot().getFile(
						new Path(path));
			}
		}
		return null;
	}

	public boolean hasChildren(Object element) {
		if (element instanceof IFile) {
			return true;
		} else if (element instanceof EObject) {
			return getChildren(element).length > 0;
		}

		return true;
	}

	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	public void dispose() {
		viewer = null;
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(
				resourceChangeListener);
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(
				resourceChangeListener);
		this.viewer = viewer;
		if (viewer != null) {
			ResourcesPlugin.getWorkspace().addResourceChangeListener(
					resourceChangeListener);
		}
	}

}
