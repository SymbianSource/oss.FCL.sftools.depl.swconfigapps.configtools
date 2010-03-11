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
package configurationemf.validation;

import helpers.MarkerManager;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import variantdata.util.ElementRefParser;
import configurationemf.Configuration;
import configurationemf.Data;
import configurationemf.Feature;
import configurationemf.LeafSetting;
import configurationemf.ParentSetting;
import configurationemf.Ref;
import configurationemf.RootConf;
import configurationemf.Setting;

public class ConfigurationMissingSetting extends AbstractModelConstraint {

	private MultiStatus multiStatus = null;
	private boolean basedOnFound = false;
	private IValidationContext ctx;
	
	public ConfigurationMissingSetting() {
	}
		@Override
		public IStatus validate(IValidationContext ctx) {
			
			this.ctx = ctx;
			multiStatus = new MultiStatus("com.nokia.S60CT.validation.confml", IStatus.ERROR, "multiStatus", null);
			Configuration conf = (Configuration)ctx.getTarget();
			Data data = conf.getData();
			if (data!=null)
			{	
				checkFeature(data, conf);
				if (multiStatus.getChildren().length==0)
					return ctx.createSuccessStatus();
				else
					return multiStatus;
			}
			return ctx.createSuccessStatus();
		}
		
		private void checkFeature(Data data, Configuration conf)
		{
			for (Ref dataFeatureRef : data.getRef())
			{
				boolean found = false;
				for (Feature feature : conf.getFeature())
				{
					if (feature.getRef().equals(dataFeatureRef.getName()))
					{
						found = true;
						checkSetting(dataFeatureRef, conf);
						break;
					}
				}
				if (!found) //not found, but the feature ref might refer to based-on configuration.
				{
					basedOnFound = false;
					searchFromBasedOn(dataFeatureRef, conf);
					if (!basedOnFound)
					{
						multiStatus.add(MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(conf), "Configuration "+ElementRefParser.getName(conf)+" contains data element that has reference to non-existing feature. Ref: "+dataFeatureRef.getName()));
					}
				}
			}
		}
		
		private void searchFromBasedOn(Ref dataFeatureRef, Configuration conf)
		{
			if (basedOnFound)
				return;
			RootConf rc = (RootConf)conf;
			for (RootConf basedOnConf : rc.getInclude())
			{
				for (Feature feature : basedOnConf.getFeature())
				{
					if (feature.getRef().equals(dataFeatureRef.getName()))
					{
						basedOnFound = true;
						checkSetting(dataFeatureRef, conf);
						return;
					}
				}
				searchFromBasedOn(dataFeatureRef, basedOnConf);
			}
		}
		
		private void checkSetting(Ref dataFeatureRef, Configuration conf)
		{
			//check setting refs
			for (Ref dataSettingRef :dataFeatureRef.getRef())
			{
				boolean found = false;
				for (Setting setting : conf.getAllSettings())
				{
					if (setting.getRef().equals(dataSettingRef.getName()))
					{
						found = true;
						checkLeafSetting(dataSettingRef, conf);
						break;
					}
				}
				if (!found)
				{
					multiStatus.add(MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(conf), "Configuration "+ElementRefParser.getName(conf)+" contains data element that has reference to non-existing setting. Ref: "+dataSettingRef.getName()));
				}
			}	
		}
		
		private void checkLeafSetting(Ref dataSettingRef, Configuration conf)
		{
			for (Ref dataLeafSettingRef : dataSettingRef.getRef())
			{
				boolean found = false;
				for (Setting setting : conf.getAllSettings())
				{
					if (setting instanceof ParentSetting)
					{
						ParentSetting ps = (ParentSetting)setting;
						for (LeafSetting leafSetting : ps.getLeafSetting())
						{
							if (leafSetting.getRef().equals(dataLeafSettingRef.getName()))
							{
								found = true;
								return;
							}
						}
					}
				}
				if (!found)
				{
					multiStatus.add(MarkerManager.getInstance().addProblem(ctx, ElementRefParser.getName(conf), "Configuration "+ElementRefParser.getName(conf)+" contains data element that has reference to non-existing sequence setting. Ref: "+dataLeafSettingRef.getName()));
				}
			}
		}
}

