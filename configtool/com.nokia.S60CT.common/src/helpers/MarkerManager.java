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
package helpers;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.validation.IValidationContext;

import constants.IS60CTCommonConstants;

/**
 * Handles marker creation and indexing
 * 
 *
 */
public class MarkerManager {

	private static MarkerManager instance = null;

	// key = <eObject+EStructuralFeature>, value = ERROR, WARNING
	
	private Map<EObject, Integer> entries = new HashMap<EObject, Integer>();
	public static final String FRAGMENT = "fragment";
	public static final String URL = "url";
	public static final String EXTRA_INFO = "extrainfo";
	public static final String FEATURE_ID = "featureId"; // must be integer (can be parsed to int)
	public static final String MARKER_ID = "com.nokia.S60CT.validation.confml";
	public static final String MARKER_EXTERNAL_ID = "com.nokia.S60CT.external.error";
	private Vector quickFixMarkers = new Vector(10);
	private int numberOfErrors = 0;
	private int numberOfWarnings = 0;
	
	public MarkerManager() {
		if (instance == null) instance = this;
	}
	
	/**
	 * Returns singleton instance
	 * @return MarkerManager
	 */
	public static MarkerManager getInstance() {
		if (instance == null) {
			instance = new MarkerManager();
		}
		return instance;
	}

	/**
	 * Create validation error and add it to problems view
	 * @param ctx Validation context interface
	 * @param location Location of error
	 * @param message Error message
	 */
	public IStatus addProblem(IValidationContext ctx, String location, String message) {
		return addProblem(ctx, location, -1, message, null, null, false, "");
	}
	
	public IStatus addWarning(IValidationContext ctx, String location, String message) {
		return addProblem(ctx, location, -1, message, null, null, true, "");
	}
	
	public IStatus addProblem(IValidationContext ctx, String location, String message, String wikiPageURL) {
		return addProblem(ctx, location, -1, message, wikiPageURL, null, false, "");
	}
	
	public IStatus addProblem(IValidationContext ctx, String location, String message, String wikiPageURL, String sourceID, String extraInfo) {
		return addProblem(ctx, location, -1, message, wikiPageURL, sourceID, false, extraInfo);
	}

	public IStatus addProblem(IValidationContext ctx, String location, int structuralFeatureId, String message) {
		return addProblem(ctx, location, structuralFeatureId, message, null, null, false, "");
	}

		
	/**
	 * Create validation error and add it to problems view
	 * @param ctx Validation context interface
	 * @param location Location of error
	 * @param message Error message
	 * @param URL URL of the validation rule.
	 */
	public IStatus addProblem(IValidationContext ctx, String location, int featureId, String message, String wikiPageURL, String sourceID, boolean warning, String extraInfo)
	{	// Create validation failure
		IStatus status = ctx.createFailureStatus(new Object[]{message});
		
		// Create problem view error
		try {
			EObject obj = ctx.getTarget();
			if (obj == null || obj.eResource() == null) return status;
			String uri = obj.eResource().getURI().toString();
			String fragment = obj.eResource().getURIFragment(obj);
			
			if (featureId < 0 && ctx.getFeature() != null) {
				featureId = ctx.getFeature().getFeatureID();
			}

			// Get file from project
			IFile file = DefaultProject.getDefaultProject().getFile(new Path(obj.eResource().getURI().lastSegment()));
			if (file != null) {
				if (!file.exists()) {
					// File not yet part of project, add it
					file.createLink(new Path(obj.eResource().getURI().path()), IResource.ALLOW_MISSING_LOCAL, null);
				}
				IMarker marker = file.createMarker(MARKER_ID);
				if (marker != null && marker.exists()) {
					if (!warning) 
					{
						switch (status.getSeverity()) {
							case IStatus.ERROR:
								marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
								numberOfErrors++;
								break;
							case IStatus.WARNING:
								marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_WARNING);
								numberOfWarnings++;
								break;
							case IStatus.CANCEL:
							case IStatus.INFO:
							case IStatus.OK:
								marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
								break;
						}
						addProblemStatus(status.getSeverity(), obj);
					}
					else
					{//manually created warning marker
						marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_WARNING);
						numberOfWarnings++;
						addProblemStatus(status.WARNING, obj);
					}
						
					marker.setAttribute(IMarker.LOCATION, location);
					marker.setAttribute(IMarker.MESSAGE, status.getMessage());
					if (sourceID!=null)
					{//quick fixes available. Notify user
						marker.setAttribute(IMarker.SOURCE_ID, sourceID);
						quickFixMarkers.add(marker);
					}
					marker.setAttribute(IMarker.BOOKMARK, wikiPageURL);
					marker.setAttribute(URL, uri);
					marker.setAttribute(FRAGMENT, fragment);
					marker.setAttribute(EXTRA_INFO, extraInfo);
					if (featureId >= 0) {
						marker.setAttribute(FEATURE_ID, featureId);
					}
					
				}
			} else {
				System.out.println("Couldn't get file " + obj.eResource().getURI().lastSegment() + " from DefaultProject"); 
			}
		} catch (CoreException exception) {
				EcorePlugin.INSTANCE.log(exception);
		}
		// Return validation problem
		return status;
	}
	
	
	public void addExternalProblem(EObject obj, IFile file, String location, int featureId, String message, boolean error, boolean warning)
	{
		try {
			String uri = file.getLocationURI().getPath();
			String fragment = file.getLocationURI().getFragment();
			if (file != null) {
				
				IMarker marker = file.createMarker(MARKER_EXTERNAL_ID);
				int severity = -1;
				if (marker != null && marker.exists()) {
					if (error)
					{
							marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
							numberOfErrors++;
							severity = IStatus.ERROR;
					}
					else if (warning)
					{
							marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_WARNING);
							numberOfWarnings++;
							severity = IStatus.WARNING;
					}	
					marker.setAttribute(IMarker.LOCATION, location);
					marker.setAttribute(IMarker.SOURCE_ID, "");
					marker.setAttribute(IMarker.MESSAGE, ExceptionMessageConverter.convertMessage(message));
					marker.setAttribute(URL, uri);
					marker.setAttribute(FRAGMENT, fragment);
					marker.setAttribute(IMarker.BOOKMARK, null);
					if (featureId >= 0) {
						marker.setAttribute(FEATURE_ID, featureId);
					}
					
					addProblemStatus(severity, obj);
				}
			} 
		} catch (CoreException exception) {
				EcorePlugin.INSTANCE.log(exception);
		}
	}
	
	/**
	 * Retrieves marker status for object
	 * @param object EObject
	 * @return Marker IStatus severity
	 */
	public int getProblemStatus(Object object) {
		EObject eObj = (EObject) object;
		Integer status = entries.get(eObj);
		if (status == null) status = IStatus.OK;
		return status;
	}
	
	private void addProblemStatus(int status, EObject obj)
	{
		// Add to table
		if (!entries.containsKey(obj) || (entries.containsKey(obj) && (entries.get(obj)).intValue() < status))
		{
			entries.put(obj, new Integer(status));
			obj = obj.eContainer(); // Parent too
			if (obj != null) 
				addProblemStatus(status, obj);
		}
	}
	
	public void deleteResourceMarkerS(EList<Resource> resources)
	{
		try 
		{
			IMarker[] markers = ResourcesPlugin.getWorkspace().getRoot().getProject(IS60CTCommonConstants.DEFAULT_PROJECT).findMarkers(MARKER_ID, true, IResource.DEPTH_INFINITE);
			deleteMarker(markers, resources);
			IMarker[] externalMarkers = ResourcesPlugin.getWorkspace().getRoot().getProject(IS60CTCommonConstants.DEFAULT_PROJECT).findMarkers(MARKER_EXTERNAL_ID, true, IResource.DEPTH_INFINITE);
			deleteMarker(externalMarkers, resources);
		} 
		catch (CoreException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void deleteMarker(IMarker[] markers, EList<Resource> resources)
	{
		for (int i = 0 ; i < markers.length ; i++)
		{
			IResource markerRes = markers[i].getResource();
			String markerURI = markerRes.getLocation().lastSegment();
			for (Resource res : resources)
			{
				String resURI = res.getURI().lastSegment();
				if (resURI.equals(markerURI))
				{
					try {
						markers[i].delete();
					} catch (CoreException e) {
						// Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}
	
	public void cleanProblems() {
		try {
			ResourcesPlugin.getWorkspace().getRoot().getProject(IS60CTCommonConstants.DEFAULT_PROJECT).deleteMarkers(MARKER_ID, true, IResource.DEPTH_INFINITE);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
			EcorePlugin.INSTANCE.log(exception);
		}
		entries.clear();
		numberOfErrors = 0;
		numberOfWarnings = 0;
		quickFixMarkers.removeAllElements();
	}
	
	public int getNumberOfErrors()
	{
		return numberOfErrors;
	}
	public int getNumberOfWarnings()
	{
		return numberOfWarnings;
	}
	
	public IMarker[] getQuickFixes()
	{
		if (quickFixMarkers.size()==0)
		{
			return null;
		}
		else
		{
			IMarker[] markers = new IMarker[quickFixMarkers.size()];
			
			for (int i = 0 ; i < quickFixMarkers.size() ; i++)
			{
				markers[i] = (IMarker)quickFixMarkers.elementAt(i);
			}
			return markers;
		}
	}
	
}
