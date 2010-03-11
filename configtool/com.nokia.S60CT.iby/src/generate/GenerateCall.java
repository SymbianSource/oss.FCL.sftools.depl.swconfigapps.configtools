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

package generate;

import init.IBYPluginInitializer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.osgi.service.prefs.Preferences;

import com.nokia.s60ct.generate.GenerationReport;
import com.nokia.s60ct.interfaces.ISaveContent;

import constants.IS60CTCommonConstants;

public class GenerateCall implements ISaveContent {
	
	IBYGenerator generator=null;
	
	private static final String VARIANT_LOCATION_NODE="VARIANT";
	private static final String VARIANT_LOCATION_VAR="VAR";
	private String variantLocationVar=null;

	private String getVariantLocationVar(){
		if(variantLocationVar==null){
			IEclipsePreferences ePref= new ConfigurationScope().getNode(IS60CTCommonConstants.S60_PREFERENCES);
			Preferences pref=ePref.node(GenerateCall.VARIANT_LOCATION_NODE);
			variantLocationVar = pref.get(GenerateCall.VARIANT_LOCATION_VAR, "VARIANT");
		}
		return variantLocationVar;
	}
	
	public GenerationReport saveContent(Object object,String pluginID) {
		if(object == null)
			return new GenerationReport();
		GenerationReport report = generator.saveContent(object, pluginID);
		generator.reset();
		return report;
	}

	public Collection<Object> setRefValue(Map<String, Object> refToValue) 
	{
		List<Object> result = new ArrayList<Object>();
		try
		{
			generator = new IBYGenerator(IBYPluginInitializer.getINSTANCE().getIBYFiles(),
										 getVariantLocationVar());
			generator.setValues(refToValue);
			generator.reset();
			return result;
		}
		catch (Exception e)
		{
			return result;
		}
	}

	public String[] getSrcPlugin() {
		return generator.getSrcPlugin();
	}

	public GenerationReport getReport()
	{
		return null;
	}
	
	
}
