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

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.nokia.tools.variant.validation.ui.quickfix.QuickFixerSettingDefinition;
import com.nokia.tools.vct.confml.model.confml1.ESettingElement;

public class QuickFixChangeType extends ConfMLMarkerResolution {
	String value;
	String objectUri;

	public QuickFixChangeType(String label, String objectUri, 
			String value) {
		super(label, null, null);
		this.value = value;
		this.objectUri = objectUri;
	}

	@Override
	protected boolean applyFix(IMarker marker, Resource resource)
			throws CoreException {

		EObject object = resource.getEObject(objectUri);
		if (object instanceof ESettingElement) {
			ESettingElement type = (ESettingElement)object;
			if (type.getSettings().isEmpty()) {
				type.setType(value);
				return true;
			}
		}
		if (object instanceof com.nokia.tools.vct.confml.model.confml2.ESettingElement) {
			com.nokia.tools.vct.confml.model.confml2.ESettingElement type = (com.nokia.tools.vct.confml.model.confml2.ESettingElement)object;
			if (type.getSettings().isEmpty()) {
				type.setType(value);
				return true;
			}
		}
		return false;
	}

	@Override
	protected boolean canHandle(IMarker marker) {
		String msgId = marker.getAttribute("problemId", "");
		return msgId
				.equals(QuickFixerSettingDefinition.ID_MISSING_SETTING_TYPE)
				|| msgId
						.equals(QuickFixerSettingDefinition.ID_MISSING_SETTING_TYPE2);
	}
}
