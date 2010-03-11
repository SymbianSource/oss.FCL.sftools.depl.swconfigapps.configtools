package com.nokia.tools.carbidect.cone.core.internal.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.nokia.tools.carbidect.cone.core.ConeCore;
import com.nokia.tools.carbidect.cone.core.actions.IConeActionArgumentConstants;
import com.nokia.tools.carbidect.cone.core.actions.IConeActionConfiguration;

public class ConeActionConfiguration implements IConeActionConfiguration {
	private Map<String,String> arguments = null;
	
	public ConeActionConfiguration() {
		arguments = new HashMap<String, String>();
	}
	
	public void setArgumentValue(String name, String value) {
		arguments.put(name, value);
	}
	
	public String getArgumentValue(String name) {
		return arguments.get(name);
	}
	
	public String getConfiguration() {
		return arguments.get(IConeActionArgumentConstants.CONFIGURATION);
	}

	public void setConfiguration(String configuration) {
		arguments.put(IConeActionArgumentConstants.CONFIGURATION, configuration);
	}
	
	public String getStorage() {
		return arguments.get(IConeActionArgumentConstants.STORAGE);
	}


	public void setStorage(String storage) {
		arguments.put(IConeActionArgumentConstants.STORAGE, addQuotesAround(storage));
	}

	private String addQuotesAround(String value) {
		return "\""+value+"\"";
	}

	public void addArgumentWithNoValue(String argument) {
		arguments.put(argument, null);
	}

	public List<String> parseArguments() {
		List<String> args = new ArrayList<String>();
		
		Set<String> keySet = arguments.keySet();
		for (String key : keySet) {
			String value = arguments.get(key);
			if(value!=null) {
				args.add(key+"="+value);
			} else {
				args.add(key);
			}
		}
		return args;
	}

	public void setVerbose(int verbose) {
		arguments.put(IConeActionArgumentConstants.VERBOSE, String.valueOf(verbose));
	}
	
	public void setLayer(int layer)
	{
		if (layer==0)
			addArgumentWithNoValue(IConeActionArgumentConstants.ALL_LAYERS);
		else
			setArgumentValue(IConeActionArgumentConstants.LAYER, ""+layer);
	}
	
	public void setTarget(int target) {
		String[] allTargets = ConeCore.getConeTargetsList();
		String selection = allTargets[target];
		if("rofs2".equalsIgnoreCase(selection)) 
		{
			//addArgumentWithNoValue(IConeActionArgumentConstants.ALL_LAYERS);
		} 
		else if ("rofs3".equalsIgnoreCase(selection)) 
		{
			//setArgumentValue(IConeActionArgumentConstants.LAYER, "-1");
		} 
		else if ("uda".equalsIgnoreCase(selection))
		{
			addArgumentWithNoValue(IConeActionArgumentConstants.TAG_TARGET_UDA);			
		} else {}
	}

	public void setOutput(String output) {
		arguments.put(IConeActionArgumentConstants.OUTPUT_FOLDER, addQuotesAround(output));
	}

	public void setLog(String log) {
		arguments.put(IConeActionArgumentConstants.LOG_FILE, addQuotesAround(log));
	}
}
