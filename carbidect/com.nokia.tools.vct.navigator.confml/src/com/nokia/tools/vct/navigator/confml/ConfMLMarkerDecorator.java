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

import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;

import com.nokia.tools.vct.confml.model.confml1.EConfML1Package;
import com.nokia.tools.vct.confml.model.confml1.include.EConfMLIncludePackage;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Package;
import com.nokia.tools.vct.confml.model.xsd.EXSDFacetPackage;

public class ConfMLMarkerDecorator implements ILightweightLabelDecorator {

	private ListenerList listeners;
	private ImageDescriptor errorDescriptor;
	private ImageDescriptor warningDescriptor;

	public ConfMLMarkerDecorator() {
		listeners = new ListenerList();

	}

	private void lasyInit() {
		if (errorDescriptor == null) {
			URL url = ConfmlNavigatorPlugin.getPlugin().getBundle().getEntry(
					"icons/full/ovr16/ErrorObject.gif");
			errorDescriptor = ImageDescriptor.createFromURL(url);
			url = ConfmlNavigatorPlugin.getPlugin().getBundle().getEntry(
					"icons/full/ovr16/WarningObject.gif");
			warningDescriptor = ImageDescriptor.createFromURL(url);
		}
	}

	public void decorate(Object element, IDecoration decoration) {
		lasyInit();
		if (element instanceof IResource) {
			int severity = -1;
			try {
				severity = ((IResource) element)
						.findMaxProblemSeverity(
								"com.nokia.tools.variant.validation.core.validationmarker",
								true, IResource.DEPTH_INFINITE);
			} catch (CoreException e) {
				// ignore
			}
			boolean hasError = severity == IMarker.SEVERITY_ERROR;
			boolean hasWarning = severity == IMarker.SEVERITY_WARNING;
			if (hasError) {
				decoration.addOverlay(errorDescriptor);
			} else if (hasWarning) {
				decoration.addOverlay(warningDescriptor);
			}

		} else if (element instanceof EObject) {
			EObject obj = (EObject) element;
			if (obj.eClass() == null) {
				return;
			}
			EPackage pack = obj.eClass().getEPackage();
			if (pack == null) {
				return;
			}
			if (pack.equals(EConfML1Package.eINSTANCE)) {
				// OK - ConfML v 1
			} else if (pack.equals(EConfML2Package.eINSTANCE)) {
				// OK - ConfML v 2
			} else if (pack.equals(EConfMLIncludePackage.eINSTANCE)) {
				// OK - XInclude elements
			} else if (pack.equals(EXSDFacetPackage.eINSTANCE)) {
				// OK - XML schema elements
			} else {
				return;
			}
			Resource resource = obj.eResource();
			URI uri = resource.getURI();
			IPath path = new Path(uri.toPlatformString(true));
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			if (!file.exists()) {
				return;
			}
			IMarker[] markers = {};
			try {
				markers = file
						.findMarkers(
								"com.nokia.tools.variant.validation.core.validationmarker",
								true, IResource.DEPTH_ZERO);
			} catch (CoreException e) {
				// ignore
			}

			if (hasErrorMarkers(obj, markers)) {
				decoration.addOverlay(errorDescriptor);
			} else if (hasWarningMarkers(obj, markers)) {
				decoration.addOverlay(warningDescriptor);
			}
		}
	}

	private boolean hasErrorMarkers(EObject object, IMarker[] markers) {
		return hasMarkers(object, markers, IMarker.SEVERITY_ERROR);
	}

	private boolean hasWarningMarkers(EObject object, IMarker[] markers) {
		return hasMarkers(object, markers, IMarker.SEVERITY_WARNING);
	}

	private boolean hasMarkers(EObject object, IMarker[] markers, int severity) {
		Set<String> marked = new HashSet<String>();
		for (IMarker marker : markers) {
			if (marker.getAttribute(IMarker.SEVERITY, 0) != severity) {
				continue;
			}
			String markerObjectURI = marker.getAttribute("objectUri", null);
			if (markerObjectURI != null) {
				marked.add(markerObjectURI);
			}
		}

		return hasMarkers(object, marked);
	}

	private boolean hasMarkers(EObject object, Set<String> marked) {
		String fragment = object.eResource().getURIFragment(object);
		if (marked.contains(fragment)) {
			return true;
		}
		for (EObject child : object.eContents()) {
			if (hasMarkers(child, marked)) {
				return true;
			}
		}
		return false;
	}

	public void addListener(ILabelProviderListener listener) {
		listeners.add(listener);
	}

	public void dispose() {
		listeners.clear();
	}

	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {
		listeners.remove(listener);
	}

}
