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

package com.nokia.tools.vct.validation.confml.constraints.data;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import com.nokia.tools.vct.common.appmodel.EAppFeature;
import com.nokia.tools.vct.common.appmodel.EAppResourceData;
import com.nokia.tools.vct.common.appmodel.EAppSequenceData;
import com.nokia.tools.vct.common.appmodel.EAppSetting;
import com.nokia.tools.vct.common.appmodel.EAppSettingData;
import com.nokia.tools.vct.common.appmodel.EAppSimpleData;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;
import com.nokia.tools.vct.common.core.utils.PlatformUtil;
import com.nokia.tools.vct.confml.model.confml1.ESettingElement;
import com.nokia.tools.vct.validation.confml.constraints.ConfMLUtils;

public class IsRequired extends AbstractModelConstraint {

	public IsRequired() {
		super();
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		
		if (ctx.getTarget() instanceof ESettingElement) {
			ESettingElement settingElement = (ESettingElement) ctx.getTarget();
			if (settingElement.getRequired()!=null)
			{
				String required = settingElement.getRequired();
				
				if (!required.equalsIgnoreCase("true"))
					return ctx.createSuccessStatus();
				
				String absRef = ConfMLUtils.getAbsoluteRef(settingElement);
				
				String[] segs = absRef.split("/");
				ResourceSet resourceSet = settingElement.eResource().getResourceSet();
				EConfigurationProject project = PlatformUtil.getAdapter(resourceSet, EConfigurationProject.class, false); 
				EConfMLLayer layer = project.getLastLayer();
				
				EAppFeature appFeature = layer.getFeatures().get(segs[0]);
				EAppSetting appSetting = appFeature.getSettings().get(segs[1]);
				if (appSetting != null)
				{
					EAppSettingData data = appSetting.getValueInfo();
					if (data instanceof EAppSimpleData)
					{
						EAppSimpleData sdata = (EAppSimpleData)data;
						if (sdata.getValue() == null)
							return ctx.createFailureStatus(absRef, "");
					}
					else if (data instanceof EAppSequenceData)
					{
						EAppSequenceData sdata = (EAppSequenceData)data;
						if (sdata.getItems() == null || sdata.getItems().size() < 1)
							return ctx.createFailureStatus(absRef, "");
					}
					else if (data instanceof EAppResourceData)
					{
						EAppResourceData rdata = (EAppResourceData)data;
						EAppSimpleData tPath = (EAppSimpleData)rdata.getTargetPath();
						EAppSimpleData lPath = (EAppSimpleData)rdata.getLocalPath();
						if (tPath.getValue() == null || lPath.getValue() == null)
							return ctx.createFailureStatus(absRef, "");
					}
				}
			}
			

		}
		else if (ctx.getTarget() instanceof com.nokia.tools.vct.confml.model.confml2.ESettingElement)
		{
			com.nokia.tools.vct.confml.model.confml2.ESettingElement settingElement = (com.nokia.tools.vct.confml.model.confml2.ESettingElement) ctx.getTarget();
			if (settingElement.getRequired()!=null)
			{
				String required = settingElement.getRequired();
				
				if (!required.equalsIgnoreCase("true"))
					return ctx.createSuccessStatus();
				
				String absRef = ConfMLUtils.getAbsoluteRef(settingElement);
				
				String[] segs = absRef.split("/");
				ResourceSet resourceSet = settingElement.eResource().getResourceSet();
				EConfigurationProject project = PlatformUtil.getAdapter(resourceSet, EConfigurationProject.class, false); 
				EConfMLLayer layer = project.getLastLayer();
				
				EAppFeature appFeature = layer.getFeatures().get(segs[0]);
				EAppSetting appSetting = appFeature.getSettings().get(segs[1]);
				if (appSetting != null)
				{
					EAppSettingData data = appSetting.getValueInfo();
					if (data instanceof EAppSimpleData)
					{
						EAppSimpleData sdata = (EAppSimpleData)data;
						if (sdata.getValue() == null)
							return ctx.createFailureStatus(absRef, "");
					}
					else if (data instanceof EAppSequenceData)
					{
						EAppSequenceData sdata = (EAppSequenceData)data;
						if (sdata.getItems() == null || sdata.getItems().size() < 1)
							return ctx.createFailureStatus(absRef, "");
					}
					else if (data instanceof EAppResourceData)
					{
						EAppResourceData rdata = (EAppResourceData)data;
						EAppSimpleData tPath = (EAppSimpleData)rdata.getTargetPath();
						EAppSimpleData lPath = (EAppSimpleData)rdata.getLocalPath();
						if (tPath.getValue() == null || lPath.getValue() == null)
							return ctx.createFailureStatus(absRef, "");
					}
				}
			}
		}
		
		return ctx.createSuccessStatus();
	}
}
