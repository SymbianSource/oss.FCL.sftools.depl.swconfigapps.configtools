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
 * Description: This file is part of com.nokia.tools.vct.navigator.ibyml component.
 */

package com.nokia.tools.vct.navigator.ibyml;
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
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;

import com.nokia.tools.vct.common.ui.utils.SWTUtil;
import com.nokia.tools.vct.ibyml.ibymodel.EEntity;
import com.nokia.tools.vct.ibyml.ibymodel.EEntry;
import com.nokia.tools.vct.ibyml.ibymodel.EIBYDocument;
import com.nokia.tools.vct.ibyml.ibymodel.EIBYFile;

public class CrmlContentProvider implements ITreeContentProvider {

	/**
	 * This listens for workspace changes. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	final IResourceChangeListener resourceChangeListener = new IResourceChangeListener() {

		public void resourceChanged(IResourceChangeEvent event) {
			IResourceDelta delta = event.getDelta();

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
								if ("ibyml".equals(ext)) {
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
							if (viewer != null && !viewer.getControl().isDisposed()) {
								if (viewer instanceof StructuredViewer) {
									viewer.getControl().setRedraw(false);
									try {
										for (IFile file : files) {
											((StructuredViewer) viewer)
													.refresh(file);
										}
									} finally {
										viewer.getControl().setRedraw(true);
									}

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

	public CrmlContentProvider() {
		resourceSet = new ResourceSetImpl();
		List<URIHandler> handlers = new ArrayList<URIHandler>();
		handlers.add(new PlatformResourceURIHandlerImpl());
		resourceSet.setURIConverter(new ExtensibleURIConverterImpl(handlers,
				ContentHandler.Registry.INSTANCE.contentHandlers()));
	}

	public Object[] getChildren(Object parentElement) {
		ArrayList<EObject> result = new ArrayList<EObject>();
		if (parentElement instanceof IFile) {
			Resource crmlResource = null;
			IFile file = (IFile) parentElement;
			String path = file.getFullPath().toPortableString();
			URI uri = URI.createPlatformResourceURI(path, true);
			crmlResource = resourceSet.createResource(uri);
			try {
				crmlResource.load(null);
			} catch (Exception e) {
				e.printStackTrace();
				crmlResource = null;
			} finally {
			}

			if (crmlResource != null) {
				result.addAll(crmlResource.getContents());
			}

		} else if (parentElement instanceof EIBYDocument) {
			EIBYDocument obj = (EIBYDocument) parentElement;
			result.add(obj.getRoot());
		} else if (parentElement instanceof EIBYFile) {
			EIBYFile obj = (EIBYFile) parentElement;
			result.addAll(obj.getEntries());
			// result.addAll(obj.getLocations());
		} else if (parentElement instanceof EEntry) {
		} else if (parentElement instanceof EEntity) {
		}
		return result.toArray();
	}

	public Object getParent(Object element) {
		if (element instanceof EObject) {
			EObject parent = ((EObject) element).eContainer();
			if (parent != null) {
				return parent;
			}
			Resource resource = ((EObject) element).eResource();
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
