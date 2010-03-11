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
 * Description: This file is part of com.nokia.tools.variant.validation.ui component.
 */

package com.nokia.tools.variant.validation.ui.quickfix.resolution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.views.markers.WorkbenchMarkerResolution;

import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.vct.common.core.utils.ArrayUtils;
import com.nokia.tools.vct.confml.model.confml1.EDataElement;
import com.nokia.tools.vct.confml.model.confml1.EFeatureData;
import com.nokia.tools.vct.confml.model.confml1.EFeatureElement;
import com.nokia.tools.vct.confml.model.confml1.EMetaElement;
import com.nokia.tools.vct.confml.model.confml1.ERfsElement;
import com.nokia.tools.vct.confml.model.confml1.ESettingData;
import com.nokia.tools.vct.confml.model.confml1.ESettingElement;
import com.nokia.tools.vct.confml.model.confml1.EViewElement;

/**
 * Base class for marker resolution based on ConfML persistence model
 * 
 */
public abstract class ConfMLMarkerResolution extends WorkbenchMarkerResolution {

	private String label;
	private String description;
	private Image image;

	/**
	 * Initialize label, description and image for the processor
	 * 
	 * @param label
	 *            Quick fix label
	 * @param description
	 *            Description
	 * @param image
	 *            Image
	 */
	protected ConfMLMarkerResolution(String label, String description,
			Image image) {
		this.label = label;
		this.description = description;
		this.image = image;
	}

	/**
	 * Filter in markers that are attached to ConfML files and can be handled by
	 * the current processor.
	 * 
	 * @see WorkbenchMarkerResolution#findOtherMarkers(IMarker[])
	 * @see #canHandle(IMarker)
	 * @see #isConfmlFile(IResource)
	 */
	@Override
	public IMarker[] findOtherMarkers(IMarker[] markers) {
		List<IMarker> other = new ArrayList<IMarker>();
		// Ticket 3445 fixed: disabling this code
		//tissarit: restored functionality with added canRunMultiple() method
		
		 for (IMarker marker : markers) 
		 { 
			 if(isConfmlFile(marker.getResource()) && canHandle(marker) && canRunMultiple()) 
			 {
				 other.add(marker);
			 } 
		 }
		 
		return ArrayUtils.createCopy(IMarker.class, other);
	}

	/**
	 * User defined method for identifying if the given marker can be handled by
	 * the current processor
	 * 
	 * @param marker
	 *            Marker to check
	 * @return <code>true</code> if this processor supports given marker
	 */
	protected abstract boolean canHandle(IMarker marker);

	/**
	 * Method to verify if the given resource represents a ConfML file
	 * 
	 * @param resource
	 *            Resource to test
	 * @return <code>true</code> if the resource is IFile, exists and has ConfML
	 *         content type.
	 */
	protected boolean isConfmlFile(IResource resource) {
		if (!(resource instanceof IFile) || !resource.exists()) {
			return false;
		}
		IFile file = (IFile) resource;
		IContentDescription descr;
		try {
			descr = file.getContentDescription();
		} catch (CoreException e) {
			return false;
		}
		if (descr == null) {
			return false;
		}
		IContentType type = descr.getContentType();
		if (type == null || !type.isKindOf(ConfMLCore.CONFML_CONTENT_TYPE)) {
			return false;
		}
		return true;
	}

	public String getDescription() {
		return description;
	}

	public Image getImage() {
		return image;
	}

	public String getLabel() {
		return label;
	}

	public boolean canRunMultiple()
	{
		return false;
	}
	
	@Override
	public void run(final IMarker[] markers, IProgressMonitor monitor) {
		IWorkspaceRunnable action = new IWorkspaceRunnable() {
			public void run(IProgressMonitor monitor) throws CoreException {
				implRun(markers, monitor);
			}
		};
		try {
			ResourcesPlugin.getWorkspace().run(action,
					ResourcesPlugin.getWorkspace().getRoot(),
					IWorkspace.AVOID_UPDATE, monitor);
		} catch (CoreException e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * Same as {@link #run(IMarker)} but processes multiple markers at a time.
	 * 
	 * @param markers
	 *            Marker list to process
	 * @param monitor
	 *            Progress monitor
	 * @throws CoreException
	 */
	protected void implRun(IMarker[] markers, IProgressMonitor monitor)
			throws CoreException {

		Map<IFile, Resource> resources = new LinkedHashMap<IFile, Resource>();
		Set<IFile> modified = new HashSet<IFile>();
		for (IMarker marker : markers) {
			IFile file = (IFile) marker.getResource();
			if (resources.containsKey(file)) {
				continue;
			}
			Resource resource = loadModel(file);
			resources.put(file, resource);
		}

		if (prepare(markers, resources)) {

			for (IMarker marker : markers) {
				Resource resource = resources.get(marker.getResource());
				if (applyFix(marker, resource)) {
					modified.add((IFile) marker.getResource());
				}
			}

			for (Map.Entry<IFile, Resource> entry : resources.entrySet()) {
				if (modified.contains(entry.getKey())) {
					saveModel(entry.getKey(), entry.getValue());
				}
			}
		}
	}

	/**
	 * Method for preparing for the fix.
	 * 
	 * @param markers
	 *            All markers
	 * @param resources
	 *            Map of resources
	 */
	protected boolean prepare(IMarker[] markers,
			Map<IFile, Resource> resources) {
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public void run(IMarker marker) {
		if (!isConfmlFile(marker.getResource())) {
			return;
		}
		if (!canHandle(marker)) {
			return;
		}

		try {
			IFile file = (IFile) marker.getResource();
			Resource model = loadModel(file);

			if (prepare(new IMarker[] { marker }, Collections.singletonMap(
					file, model))) {
				if (applyFix(marker, model)) {
					saveModel(file, model);
				}
			}
		} catch (CoreException ex) {
		}
	}

	/**
	 * Helper method for finding matching feature data definitions.
	 * 
	 * @param resource
	 *            Persistence model
	 * @param featureId
	 *            Feature Id
	 * @return Matching feature data
	 */
	protected EFeatureData[] findFeatureDataDef(Resource resource,
			String featureId) {
		List<EFeatureData> result = new ArrayList<EFeatureData>();
		TreeIterator<Object> it = EcoreUtil.getAllContents(resource, false);
		while (it.hasNext()) {
			Object o = it.next();

			if (o instanceof EDataElement) {
				// ok - continue
			} else if (o instanceof ERfsElement) {
				it.prune();
			} else if (o instanceof EMetaElement) {
				it.prune();
			} else if (o instanceof EViewElement) {
				it.prune();
			} else if (o instanceof EFeatureElement) {
				it.prune();
			} else if (o instanceof EFeatureData) {
				EFeatureData featureData = (EFeatureData)o;
				if (featureId.equals(featureData.getRef())) {
					result.add(featureData);
				}
			}
		}

		
		return ArrayUtils.createCopy(EFeatureData.class, result);
	}

	/**
	 * Helper method for finding matching feature data definitions.
	 * 
	 * @param resource
	 *            Persistence model
	 * @param featureId
	 *            Feature Id
	 * @return Matching feature data
	 */
	protected com.nokia.tools.vct.confml.model.confml2.EFeatureData[] findFeatureDataDef2(Resource resource,
			String featureId) {
		List<com.nokia.tools.vct.confml.model.confml2.EFeatureData> result = new ArrayList<com.nokia.tools.vct.confml.model.confml2.EFeatureData>();
		TreeIterator<Object> it = EcoreUtil.getAllContents(resource, false);
		while (it.hasNext()) {
			Object o = it.next();

			if (o instanceof com.nokia.tools.vct.confml.model.confml2.EDataElement) {
				// ok - continue
			} else if (o instanceof com.nokia.tools.vct.confml.model.confml2.ERfsElement) {
				it.prune();
			} else if (o instanceof com.nokia.tools.vct.confml.model.confml2.EMetaElement) {
				it.prune();
			} else if (o instanceof com.nokia.tools.vct.confml.model.confml2.EViewElement) {
				it.prune();
			} else if (o instanceof com.nokia.tools.vct.confml.model.confml2.EFeatureElement) {
				it.prune();
			} else if (o instanceof com.nokia.tools.vct.confml.model.confml2.EFeatureData) {
				com.nokia.tools.vct.confml.model.confml2.EFeatureData featureData = (com.nokia.tools.vct.confml.model.confml2.EFeatureData)o;
				if (featureId.equals(featureData.getRef())) {
					result.add(featureData);
				}
			}
		}

		
		return ArrayUtils.createCopy(com.nokia.tools.vct.confml.model.confml2.EFeatureData.class, result);
	}

	/**
	 * Helper method for finding matching setting data definitions.
	 * 
	 * @param resource
	 *            Persistence model
	 * @param featureId
	 *            Feature Id
	 * @param settingId
	 *            Setting Id
	 * @return Matching setting data
	 */
	protected ESettingData[] findSettingDataDef(Resource resource,
			String featureId, String settingId) {
		EFeatureData[] source = findFeatureDataDef(resource, featureId);
		List<ESettingData> result = new ArrayList<ESettingData>();
		for (EFeatureData featureDataDef : source) {
			for (ESettingData settingDataDef : featureDataDef.getSettings()) {
				if (settingId.equals(settingDataDef.getRef())) {
					result.add(settingDataDef);
				}
			}
		}
		return ArrayUtils.createCopy(ESettingData.class, result);
	}

	/**
	 * Helper method for finding matching feature type definitions.
	 * 
	 * @param resource
	 *            Persistence model
	 * @param featureId
	 *            Feature Id
	 * @return Matching feature types
	 */
	protected EFeatureElement[] findFeatureTypeDef(Resource resource,
			String featureId) {
		List<EFeatureElement> result = new ArrayList<EFeatureElement>();
		TreeIterator<Object> it = EcoreUtil.getAllContents(resource, false);
		while (it.hasNext()) {
			Object o = it.next();

			if (o instanceof EDataElement) {
				it.prune();
			} else if (o instanceof ERfsElement) {
				it.prune();
			} else if (o instanceof EMetaElement) {
				it.prune();
			} else if (o instanceof EViewElement) {
				it.prune();
			} else if (o instanceof EFeatureElement) {
				if (featureId.equals(((EFeatureElement) o).getRef())) {
					result.add((EFeatureElement)o);
				}
				it.prune();
			}
		}

		return ArrayUtils.createCopy(EFeatureElement.class, result);
	}

	/**
	 * Helper method for finding matching feature type definitions.
	 * 
	 * @param resource
	 *            Persistence model
	 * @param featureId
	 *            Feature Id
	 * @return Matching feature types
	 */
	protected com.nokia.tools.vct.confml.model.confml2.EFeatureElement[] findFeatureTypeDef2(Resource resource,
			String featureId) {
		List<com.nokia.tools.vct.confml.model.confml2.EFeatureElement> result = new ArrayList<com.nokia.tools.vct.confml.model.confml2.EFeatureElement>();
		TreeIterator<Object> it = EcoreUtil.getAllContents(resource, false);
		while (it.hasNext()) {
			Object o = it.next();

			if (o instanceof com.nokia.tools.vct.confml.model.confml2.EDataElement) {
				it.prune();
			} else if (o instanceof com.nokia.tools.vct.confml.model.confml2.ERfsElement) {
				it.prune();
			} else if (o instanceof com.nokia.tools.vct.confml.model.confml2.EMetaElement) {
				it.prune();
			} else if (o instanceof com.nokia.tools.vct.confml.model.confml2.EViewElement) {
				it.prune();
			} else if (o instanceof com.nokia.tools.vct.confml.model.confml2.EFeatureElement) {
				if (featureId.equals(((com.nokia.tools.vct.confml.model.confml2.EFeatureElement) o).getRef())) {
					result.add((com.nokia.tools.vct.confml.model.confml2.EFeatureElement)o);
				}
				it.prune();
			}
		}

		return ArrayUtils.createCopy(com.nokia.tools.vct.confml.model.confml2.EFeatureElement.class, result);
	}

	/**
	 * Helper method for finding matching setting type definitions.
	 * 
	 * @param resource
	 *            Persistence model
	 * @param featureId
	 *            Feature Id
	 * @param settingId
	 *            Setting Id
	 * @return Matching setting types
	 */
	protected ESettingElement[] findSettingTypeDef(Resource resource,
			String featureId, String settingId) {
		List<ESettingElement> result = new ArrayList<ESettingElement>();
		EFeatureElement[] featureTypes = findFeatureTypeDef(resource, featureId);
		for (EFeatureElement featureElement: featureTypes) {
			for (ESettingElement settingElement: featureElement.getSettings()) {
				if (settingId.equals(settingElement.getRef())) {
					result.add(settingElement);
				}
			}
		}
		return ArrayUtils.createCopy(ESettingElement.class, result);
	}

	/**
	 * Helper method for finding matching setting type definitions.
	 * 
	 * @param resource
	 *            Persistence model
	 * @param featureId
	 *            Feature Id
	 * @param settingId
	 *            Setting Id
	 * @return Matching setting types
	 */
	protected com.nokia.tools.vct.confml.model.confml2.ESettingElement[] findSettingTypeDef2(Resource resource,
			String featureId, String settingId) {
		List<com.nokia.tools.vct.confml.model.confml2.ESettingElement> result = new ArrayList<com.nokia.tools.vct.confml.model.confml2.ESettingElement>();
		com.nokia.tools.vct.confml.model.confml2.EFeatureElement[] featureTypes = findFeatureTypeDef2(resource, featureId);
		for (com.nokia.tools.vct.confml.model.confml2.EFeatureElement featureElement: featureTypes) {
			for (com.nokia.tools.vct.confml.model.confml2.ESettingElement settingElement: featureElement.getSettings()) {
				if (settingId.equals(settingElement.getRef())) {
					result.add(settingElement);
				}
			}
		}
		return ArrayUtils.createCopy(com.nokia.tools.vct.confml.model.confml2.ESettingElement.class, result);
	}

	
	/**
	 * Helper method for finding matching setting reference definitions (for
	 * view).
	 * 
	 * @param resource
	 *            Persistence model
	 * @param featureId
	 *            Feature Id
	 * @param settingId
	 *            Setting Id
	 * @return Matching setting types
	 */
	protected ESettingElement[] findSettingReferenceDef(
			Resource resource, String featureId, String settingId) {
		String ref = featureId + "/"+settingId;
		
		List<ESettingElement> result = new ArrayList<ESettingElement>();
		TreeIterator<Object> it = EcoreUtil.getAllContents(resource, false);
		while (it.hasNext()) {
			Object o = it.next();

			if (o instanceof EDataElement) {
				it.prune();
			} else if (o instanceof ERfsElement) {
				it.prune();
			} else if (o instanceof EMetaElement) {
				it.prune();
			} else if (o instanceof EFeatureElement) {
				it.prune();
			} else if (o instanceof ESettingElement) {
				if (ref.equals(((ESettingElement) o).getRef())) {
					result.add((ESettingElement)o);
				}
			}
		}

		return ArrayUtils.createCopy(ESettingElement.class, result);
	}

	/**
	 * Helper method for model loading
	 * 
	 * @param file
	 *            Source file
	 * @return Persistence model
	 * @throws CoreException
	 */
	protected Resource loadModel(IFile file) throws CoreException {
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toPortableString(), true);
		Resource.Factory factory = Resource.Factory.Registry.INSTANCE.getFactory(uri);
		Resource resource = factory.createResource(uri);
		
		try {
			resource.load(null);
			return resource;
		} catch (IOException ex) {
			throw new WorkbenchException("Load error", ex);
		} finally {
		}
	}

	/**
	 * Helper method for serializing the model
	 * 
	 * @param file
	 *            Destination file
	 * @param resource
	 *            Persistence model
	 * @throws CoreException
	 */
	protected void saveModel(IFile file, Resource resource)
			throws CoreException {
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toPortableString(), true); 
		resource.setURI(uri);
		try {
			resource.save(null);
		} catch (IOException ex) {
			throw new WorkbenchException("Load error", ex);
		} finally {
		}
	}

	/**
	 * Implementation-specific method to apply the quick fix to the given
	 * resource model
	 * 
	 * @param marker
	 * @param resource
	 * @return
	 * @throws CoreException
	 */
	protected abstract boolean applyFix(IMarker marker, Resource resource)
			throws CoreException;

}
