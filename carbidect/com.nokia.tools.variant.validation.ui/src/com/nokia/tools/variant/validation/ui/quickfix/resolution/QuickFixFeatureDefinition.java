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

import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.InputDialog;

import com.nokia.tools.variant.validation.ui.quickfix.QuickFixerFeatureDefinition;
import com.nokia.tools.vct.confml.model.confml1.EConfML1Factory;
import com.nokia.tools.vct.confml.model.confml1.EDescriptionElement;
import com.nokia.tools.vct.confml.model.confml1.EFeatureElement;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Factory;

public class QuickFixFeatureDefinition extends ConfMLMarkerResolution {
	private String objectUri;
	private String problemId;
	private String value;

	public QuickFixFeatureDefinition(String label, String objectUri,
			String problemId) {
		super(label, null, null);
		this.objectUri = problemId;
		this.problemId = problemId;
	}

	@Override
	protected boolean applyFix(IMarker marker, Resource resource)
			throws CoreException {
		EObject object = resource.getEObject(objectUri);
		if (object instanceof EFeatureElement) {
			EFeatureElement type = (EFeatureElement) object;
			if (QuickFixerFeatureDefinition.ID_MISSING_FEATURE_NAME
					.equals(problemId)) {
				type.setName(value);
				return true;
			}
			if (QuickFixerFeatureDefinition.ID_MISSING_FEATURE_DESCRIPTION
					.equals(problemId)) {
				EDescriptionElement element = EConfML1Factory.eINSTANCE
						.createEDescriptionElement();
				element.setDescription(value);
				type.getDescriptions().clear();
				type.getDescriptions().add(element);
				return true;
			}
		}
		if (object instanceof com.nokia.tools.vct.confml.model.confml2.EFeatureElement) {
			com.nokia.tools.vct.confml.model.confml2.EFeatureElement type = (com.nokia.tools.vct.confml.model.confml2.EFeatureElement) object;
			if (QuickFixerFeatureDefinition.ID_MISSING_FEATURE_NAME2
					.equals(problemId)) {
				type.setName(value);
				return true;
			}
			if (QuickFixerFeatureDefinition.ID_MISSING_FEATURE_DESCRIPTION2
					.equals(problemId)) {
				com.nokia.tools.vct.confml.model.confml2.EDescriptionElement element = EConfML2Factory.eINSTANCE
						.createEDescriptionElement();
				element.setDescription(value);
				type.getDescriptions().clear();
				type.getDescriptions().add(element);
				return true;
			}

		}

		return false;
	}

	@Override
	protected boolean prepare(IMarker[] markers, Map<IFile, Resource> resources) {

		InputDialog dialog = new InputDialog(null, "Quick fix dialog",
				getLabel(), "", null);

		if (dialog.open() == Dialog.OK) {
			this.value = dialog.getValue();
		}
		return this.value != null && this.value.length() > 0;
	}

	@Override
	protected boolean canHandle(IMarker marker) {
		String msgId = marker.getAttribute("problemId", "");
		return msgId.equals(problemId);
	}

}
