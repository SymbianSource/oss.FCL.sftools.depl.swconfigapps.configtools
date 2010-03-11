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

package com.nokia.tools.carbide.validation.core.validators;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.osgi.framework.Version;

import com.nokia.tools.carbide.validation.core.ConfmlMarkerUtils;
import com.nokia.tools.carbide.validation.core.MarkerCategory;
import com.nokia.tools.carbide.validation.core.MessageLocation;
import com.nokia.tools.carbide.validation.core.ValidationContext;
import com.nokia.tools.carbide.validation.core.ValidationMessage;
import com.nokia.tools.carbide.validation.core.ValidationResult;


/**
 * Validation class for checking the project settings/structure consistency
 * 
 */
public class ConfmlProjectValidator implements IValidator {

	static final Pattern LAYER_ID_PATTERN = Pattern.compile("\\w+(\\.\\w+)*");

	public ValidationResult validate(ValidationContext context,
			IProgressMonitor monitor) throws CoreException {
		monitor.beginTask("Validating ConfML Layer Information", 150);
		try {
			final ValidationResult result = new ValidationResult();
			ValidationResult intermediate;
			boolean fatal = false;

			intermediate = updateProjectMetadata(context,
					new SubProgressMonitor(monitor, 50));
			result.merge(intermediate);
			fatal |= intermediate.isFatal();

			if (!fatal) {
				intermediate = updateProjectDependencies(context,
						new SubProgressMonitor(monitor, 50));
				result.merge(intermediate);
				fatal |= intermediate.isFatal();
			}

			return result;
		} finally {
			monitor.done();
		}
	}

	protected ValidationResult updateProjectMetadata(ValidationContext context,
			IProgressMonitor monitor) throws CoreException {
		monitor.beginTask("Checking layer metadata", 100);
		final ValidationResult result = new ValidationResult();

		try {
			monitor.worked(30);

			MessageLocation metaLoc = new MessageLocation(context.getProject(),
					"metadata");

			IFile file = context.getProject().getFile(".metadata");
			if (!file.exists()) {
				// FATAL - stop
				ValidationMessage message = new ValidationMessage(3, metaLoc,
						ConfmlMarkerUtils.CONFML_PROBLEM_MARKER,
						MarkerCategory.LAYER);
				result.addMessage(message);
				return result;
			}
			

			

//			if (!isValidLayerId(metadata.getId())) {
//				// FATAL - continue
//				ValidationMessage message = new ValidationMessage(5, metaLoc,
//						ConfmlMarkerUtils.CONFML_PROBLEM_MARKER,
//						MarkerCategory.LAYER);
//				result.addMessage(message);
//			}
			
			/*
			 * if (!isValidLayerVersion(metadata.getVersion())) { // FATAL -
			 * continue ValidationMessage message = new ValidationMessage(
			 * ValidationStatus.FATAL_ERROR,
			 * "Layer does not have a valid version", metaLoc,
			 * ConfmlMarkerUtils.CONFML_PROBLEM_MARKER, MarkerCategory.LAYER);
			 * result.addMessage(message); }
			 */

			int confmls = 0;
			int implmls = 0;
			int contents = 0;
			int metas = 0;
			int others = 0;

			Set<IPath> paths = new HashSet<IPath>();
			Set<IPath> marked = new HashSet<IPath>();


			if (confmls == 0) {
				ValidationMessage message = new ValidationMessage(9, metaLoc,
						ConfmlMarkerUtils.CONFML_PROBLEM_MARKER,
						MarkerCategory.LAYER);
				result.addMessage(message);
			}
			if (contents == 0) {
				ValidationMessage message = new ValidationMessage(10, metaLoc,
						ConfmlMarkerUtils.CONFML_PROBLEM_MARKER,
						MarkerCategory.LAYER);
				result.addMessage(message);
			}
			if (metas == 0) {
				ValidationMessage message = new ValidationMessage(11, metaLoc,
						ConfmlMarkerUtils.CONFML_PROBLEM_MARKER,
						MarkerCategory.LAYER);
				result.addMessage(message);
			}


			return result;
		} finally {
			monitor.done();
		}
	}

	static Version getVersion(String value) {
		if (value == null) {
			return null;
		}
		try {
			return new Version(value);
		} catch (Exception ex) {
			return null;
		}
	}

	static boolean isValidLayerId(String id) {
		if (id == null || id.trim().length() == 0) {
			return false;
		} else {
			return LAYER_ID_PATTERN.matcher(id.trim()).matches();
		}
	}

	static boolean isValidLayerName(String name) {
		if (name == null || name.trim().length() == 0) {
			return false;
		} else {
			return true;
		}
	}

	static boolean isValidLayerVersion(String name) {
		if (name == null || name.trim().length() == 0) {
			return false;
		} else {

			try {
				new Version(name);
				return true;
			} catch (Exception ex) {
				return false;
			}
		}
	}

	protected ValidationResult updateProjectDependencies(
			ValidationContext context, IProgressMonitor monitor)
			throws CoreException {
		ValidationResult result = new ValidationResult();


		/*
		 * for (ELayerReference parent : context.getMetadata().getParents()) {
		 * Version minVersion = getVersion(parent.getMinimumVersion()); Version
		 * maxVersion = getVersion(parent.getMaximumVersion());
		 * 
		 * EVariantContributor match = ContributorUtils.findMatch(ConfMLCore
		 * .getRootModel().getProjects(), parent.getId(), minVersion,
		 * maxVersion); if (match == null) { match =
		 * ContributorUtils.findMatch(ConfMLCore.getRootModel() .getBundles(),
		 * parent.getId(), minVersion, maxVersion); } if (match == null) { //
		 * FATAL - can not resolve dependency ValidationMessage message = new
		 * ValidationMessage( ValidationStatus.FATAL_ERROR,
		 * "Can not resolve dependency: " + parent.getId(), new
		 * MessageLocation(context.getProject(), "metadata"),
		 * ConfmlMarkerUtils.CONFML_PROBLEM_MARKER, MarkerCategory.LAYER);
		 * result.addMessage(message); } else { context.getParents().add(match);
		 * } }
		 */
		return result;
	}
}
