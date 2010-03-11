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

import com.nokia.tools.vct.common.appmodel.EAppResourceType;
import com.nokia.tools.vct.common.appmodel.EAppSettingType;
import com.nokia.tools.vct.common.appmodel.EAppSimpleType;
import com.nokia.tools.vct.confml.model.confml1.ESettingData;
import com.nokia.tools.vct.validation.confml.constraints.ConfMLUtils;

public class InvalidFile extends AbstractModelConstraint {

	public InvalidFile() {
		super();
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		
		String value = null;
		String typePath = null;
		EAppResourceType appResourceType = null;
		EAppSimpleType appSimpleType = null;
		String ref = null;
		
		if (ctx.getTarget() instanceof ESettingData)
		{
			//IMPROVEMENT: is this needed for confml v1?
		}
		else if (ctx.getTarget() instanceof com.nokia.tools.vct.confml.model.confml2.ESettingData)
		{
			com.nokia.tools.vct.confml.model.confml2.ESettingData settingData = (com.nokia.tools.vct.confml.model.confml2.ESettingData) ctx.getTarget();
			StringBuilder tmp = new StringBuilder();
			EAppSettingType ptr = ConfMLUtils.findType(settingData, tmp);
			typePath = tmp.toString();
			if (ptr instanceof EAppResourceType)
			{
				for (com.nokia.tools.vct.confml.model.confml2.ESettingData setting : settingData.getSettings())
				{
					appResourceType = (EAppResourceType)ptr;
					ref = setting.getRef();
					value = setting.getText();
					//System.out.println(typePath+": "+ ref+"="+value);
					if (ref.equals("localPath"))
						appSimpleType = (EAppSimpleType)appResourceType.getLocalPath();
					else if (ref.equals("targetPath"))
						appSimpleType = (EAppSimpleType)appResourceType.getTargetPath();
					
					if (value !=null)
					{
						if (value.equals("") && typePath.split("/").length==3)
							return ctx.createSuccessStatus();
						
						//appResourceType.isFile();
//						if (value.indexOf("\\")!=-1)
//								return ctx.createFailureStatus(typePath, value);
						
						//IMPROVEMENT: anything else to validate.
						
						IStatus commonStatus = null;
						commonStatus = CommonConstraints.length(ctx, typePath, appSimpleType.getLength(), value);
						if (commonStatus!=null)
							return commonStatus;
						commonStatus = CommonConstraints.minLength(ctx, typePath, appSimpleType.getMinLength(), value);
						if (commonStatus!=null)
							return commonStatus;
						commonStatus = CommonConstraints.maxLength(ctx, typePath, appSimpleType.getMaxLength(), value);
						if (commonStatus!=null)
							return commonStatus;
						commonStatus = CommonConstraints.pattern(ctx, typePath, appSimpleType.getPattern(), value);
						if (commonStatus!=null)
							return commonStatus;
					}
				}
			}
		}
		return ctx.createSuccessStatus();
	}

}
