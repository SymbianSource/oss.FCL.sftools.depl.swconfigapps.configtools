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
 * Description: This file is part of com.nokia.tools.carbide.validation.core component.
 */

package com.nokia.tools.carbide.validation.core;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.SafeRunner;

public class ConfmlMarkerUtils {
	/** Category ID attribute name */
	public static final String CATEGORY_ID = "categoryId";
	/** Problem ID attribute name */
	public static final String PROBLEM_ID = "problemId";

	private static final String PLUGIN_ID = "com.nokia.tools.carbide.validation.core";

	public static final String CONFML_PROBLEM_MARKER = PLUGIN_ID
			+ ".validationmarker";

	
	

	private static final String[] MARKER_ATTRS = { IMarker.MESSAGE,
			IMarker.SEVERITY, IMarker.LOCATION, IMarker.SOURCE_ID,
			CATEGORY_ID, IMarker.LINE_NUMBER, IMarker.CHAR_START,
			IMarker.CHAR_END, PROBLEM_ID };

	public static IMarker createMarker(IResource resource, String message,
			MessageLocation targetObject, String markerType,
			ValidationStatus status, MarkerCategory category, int problemId)
			throws CoreException {
		if (!resource.exists()) {
			return null;
		}

		IMarker m = resource.createMarker(markerType);

		int severity;
		switch (status) {
		case ERROR:
		case FATAL_ERROR:
			severity = IMarker.SEVERITY_ERROR;
			break;
		case WARNING:
			severity = IMarker.SEVERITY_WARNING;
			break;
		case INFO:
			severity = IMarker.SEVERITY_INFO;
			break;
		default:
			severity = IMarker.SEVERITY_ERROR;
		}

		String location = targetObject.getLocation();
		String sourceId = "CONFML";
		Integer categoryId = category.getCategoryValue();
		Integer charStart = targetObject.getCharStart() == -1 ? null
				: targetObject.getCharStart();
		Integer charEnd = targetObject.getCharEnd() == -1 ? null : targetObject
				.getCharEnd();
		Integer line = targetObject.getLineNumber() == -1 ? null : targetObject
				.getLineNumber();

		Object[] values = { message, severity, location, sourceId,
				categoryId.toString(), line, charStart, charEnd, problemId };
		m.setAttributes(MARKER_ATTRS, values);

		return m;
	}

	public static void createMessageMarker(IProject project,
			final ValidationMessage message) {
		final IResource resource;
		if (message.getLocation() != null) {
			IResource tmp = message.getLocation().getResource();
			resource = tmp != null ? tmp : project;
		} else {
			resource = project;
		}
		SafeRunner.run(new ISafeRunnable() {
			public void run() throws Exception {
				createMarker(resource, message.getMessage(), message
						.getLocation(), message.getType(), message
						.getSeverity(), message.getCategory(), message.getId());
			}

			public void handleException(Throwable exception) {
				ValidationCorePlugin.logError("Build exception", exception);
			}
		});
	}
}
