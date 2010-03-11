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
 * Description: This file is part of com.nokia.tools.vct.validation.confml component.
 */

package com.nokia.tools.vct.validation.confml.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import com.nokia.tools.vct.common.appmodel.EAppFeature;
import com.nokia.tools.vct.common.appmodel.EAppSetting;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;
import com.nokia.tools.vct.common.core.utils.PlatformUtil;
import com.nokia.tools.vct.confml.model.confml1.ESettingElement;

public class ReadOnlyViewSettingReference extends AbstractModelConstraint {

	public ReadOnlyViewSettingReference() {
		super();
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		String ref;
		ResourceSet resourceSet;
		if (ctx.getTarget() instanceof ESettingElement) {
			ESettingElement settingElement = (ESettingElement)ctx.getTarget();
			resourceSet = settingElement.eResource().getResourceSet();
			if (!ConfMLUtils.isGroupElementChild(settingElement)) {
				return ctx.createSuccessStatus();
			}
			
			ref = settingElement.getRef();
		} else if (ctx.getTarget() instanceof com.nokia.tools.vct.confml.model.confml2.ESettingElement) {
			com.nokia.tools.vct.confml.model.confml2.ESettingElement settingElement = (com.nokia.tools.vct.confml.model.confml2.ESettingElement)ctx.getTarget();
			resourceSet = settingElement.eResource().getResourceSet();
			if (!ConfMLUtils.isGroupElementChild(settingElement)) {
				return ctx.createSuccessStatus();
			}
			
			ref = settingElement.getRef();
			
		} else {
			throw new IllegalArgumentException();
		}
		
		if (ref == null || ref.trim().length() == 0) {
			return ctx.createSuccessStatus();
		}
		
		String[] segs = ref.split("/");
		if (segs.length < 2) {
			return ctx.createSuccessStatus();
		}
		if (segs.length > 2) {
			return ctx.createSuccessStatus();
		}
		String featureId = segs[0];
		
		EConfigurationProject project = PlatformUtil.getAdapter(resourceSet, EConfigurationProject.class, false); 
		EConfMLLayer layer = project.getLastLayer();
		
		EAppFeature appFeature = layer.getFeatures().get(featureId);
		if (appFeature == null) {
			return ctx.createSuccessStatus();
		}
		
		if (segs[1].equals("*")) {
			return ctx.createSuccessStatus();
		}

		EAppSetting appSetting = appFeature.getSettings().get(segs[1]);
		if (appSetting == null) {
			return ctx.createSuccessStatus();
		} else if (appSetting.getTypeInfo().isReadOnly()) {
				return ctx.createFailureStatus(ref);
		}
		return ctx.createSuccessStatus();
	}

}
