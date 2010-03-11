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
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import com.nokia.tools.vct.common.appmodel.EAppSequenceType;
import com.nokia.tools.vct.common.appmodel.EAppSettingType;
import com.nokia.tools.vct.common.appmodel.EAppSimpleType;
import com.nokia.tools.vct.confml.model.confml1.EFeatureData;
import com.nokia.tools.vct.confml.model.confml1.ESettingData;
import com.nokia.tools.vct.validation.confml.constraints.ConfMLUtils;

public class TooManySequences extends AbstractModelConstraint {

	public TooManySequences() {
		super();
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		String value = null;
		String typePath = null;
		EAppSimpleType appSimpleType = null;
		
		if (ctx.getTarget() instanceof ESettingData) {
			ESettingData settingData = (ESettingData) ctx.getTarget();
			StringBuilder tmp = new StringBuilder();
			EAppSettingType ptr = ConfMLUtils.findType(settingData, tmp);
			typePath = tmp.toString();
			if (ptr instanceof EAppSequenceType) {
				EAppSequenceType appSeqType = (EAppSequenceType)ptr;
				
				Integer maxOccurs = appSeqType.getMaxOccurs();
				if (maxOccurs!=null)
				{
					EFeatureData featureData = (EFeatureData)settingData.eContainer();
					if (featureData != null && featureData.getSettings() != null)
					{
						int numberOfSequences = featureData.getSettings().size(); 
						if (numberOfSequences>maxOccurs.intValue())	
							return ctx.createFailureStatus(typePath, maxOccurs);
					}
				}
			}
		}
		else if (ctx.getTarget() instanceof com.nokia.tools.vct.confml.model.confml2.ESettingData)
		{
			com.nokia.tools.vct.confml.model.confml2.ESettingData settingData = (com.nokia.tools.vct.confml.model.confml2.ESettingData) ctx.getTarget();
			StringBuilder tmp = new StringBuilder();
			EAppSettingType ptr = ConfMLUtils.findType(settingData, tmp);
			typePath = tmp.toString();
			if (ptr instanceof EAppSequenceType) {
				EAppSequenceType appSeqType = (EAppSequenceType)ptr;
				
				Integer maxOccurs = appSeqType.getMaxOccurs();
				if (maxOccurs!=null)
				{
					com.nokia.tools.vct.confml.model.confml2.EFeatureData featureData = (com.nokia.tools.vct.confml.model.confml2.EFeatureData)settingData.eContainer();
					if (featureData != null && featureData.getSettings() != null)
					{
						int numberOfSequences = featureData.getSettings().size(); 
						if (numberOfSequences>maxOccurs.intValue())	
							return ctx.createFailureStatus(typePath, maxOccurs);
					}
				}
			}
		}

		
		return ctx.createSuccessStatus();
	}
}
