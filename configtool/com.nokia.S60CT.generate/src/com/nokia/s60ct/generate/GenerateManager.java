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
package com.nokia.s60ct.generate;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;

import com.nokia.s60ct.interfaces.IContentCreator;
import com.nokia.s60ct.interfaces.IGenerateValidator;
import com.nokia.s60ct.interfaces.IPlugin;
import com.nokia.s60ct.interfaces.ISaveContent;

import configurationemf.Configuration;
import configurationemf.RootConf;
import configurationemf.Setting;
import configurationemf.util.PrioritisedConfigurationList;
import constants.IS60CTCommonConstants;


public class GenerateManager {

	private static GenerateManager INSTANCE;

	private PluginInit pluginInit=null;
	private Vector reports = new Vector(3);
	private IGenerateValidator validator = null;
	List<IPlugin> generateCalls = new ArrayList<IPlugin>();
	private static boolean cliMode = false;

	protected GenerateManager(){
		pluginInit = PluginInit.getInstance();
		this.generateCalls.addAll(Arrays.asList(pluginInit.getAllPlugins()));
	}

	public static GenerateManager getInstance()
	{
		if (INSTANCE==null)
			INSTANCE = new GenerateManager();
		return INSTANCE;
	}

	// prepare implementation object for validation
	// return implementation objects that got values
	public Collection<Object> getImplementations(Setting setting){
		Map<String,Object> refValue = new HashMap<String, Object>();
		refValue.put(","+String.valueOf(0)+","+setting.getAbsRef(), setting.getGValue());
		refValue.put(","+String.valueOf(0)+","+IPlugin.RFS_PREFIX+setting.getAbsRef(), setting.isRfs());
		List<Object> result = setRefValue(refValue);
		return result;
	}

	public void registerValidator(IGenerateValidator validator)
	{
		this.validator = validator;
	}

	private List<Object> setRefValue(Map<String, Object> refValue) {
		List<Object> result = new ArrayList<Object>();
		for(IPlugin generator : generateCalls){
			if(generator!=null){
				result.addAll(generator.setRefValue(refValue));
			}
		}
		return result;
	}

	public void reset(Collection<Object> implementation){

	}


	/*
	 * generate configuration, return problems
	 */
	public Vector generateConfiguration(RootConf conf, boolean cleanOutput)//for GUI
	{
		return generateConfiguration(conf, cleanOutput, false, null);
	}

	public Vector generateConfiguration(RootConf conf, boolean cleanOutput, boolean ignoreValidationErrors, Object[] repos){ //for CLI
		//Vector reports = new Vector(3);
		boolean okToContinue = true;
		
		if (validator != null) 
		{
			okToContinue = validator.validateBeforeGenerate(conf, repos);
		}
		if (okToContinue || ignoreValidationErrors)
		{
			Map<String, Object> refValue = this.getRefValue(conf);
			this.setRefValue(refValue);
			this.generateAll(cleanOutput);
			for (int i = 0; i < reports.size(); i++) {
				GenerationReport report = (GenerationReport) reports.get(i);
				if (report != null) logReport(report);
			}
			return this.reports;
		}
		else
		{
			System.out.println("No cenreps generated!");
			System.out.println("Use argument -ignore_errors to generate cenreps.");
		}

		return null;
	}

	private void logErrors(GenerationReport.Error[] errors)
	{
		for (GenerationReport.Error error : errors) {
			if (error != null) {
				System.err.println("Error: " + error.getErrorTitle());
			}
		}
	}

	private void logFiles(GenerationReport.GeneratedFile[] files)
	{
		for (GenerationReport.GeneratedFile file : files) {
			if (file != null) {
				System.out.println("Generated " + file.getRelativePath() + "\\" + file.getFileName());
			}
		}
	}

	/**
	 * @param report
	 */
	private void logReport(GenerationReport report) {
		GenerationReport.Error[] errors = report.getErrors(GenerationReport.TYPE_CENREP);
		if (errors != null) logErrors(errors);
		errors = report.getErrors(GenerationReport.TYPE_IBY);
		if (errors != null) logErrors(errors);
		errors = report.getErrors(GenerationReport.TYPE_GENCONFML);
		if (errors != null) logErrors(errors);
		GenerationReport.GeneratedFile[] files = report.getGeneratedFiles(GenerationReport.TYPE_CENREP);
		if (files != null) logFiles(files);
		files = report.getGeneratedFiles(GenerationReport.TYPE_IBY);
		if (files != null) logFiles(files);
		files = report.getGeneratedFiles(GenerationReport.TYPE_GENCONFML);
		if (files != null) logFiles(files);
	}

	private void generateAll(boolean cleanOutput){
		if(cleanOutput)
			cleanOutputFolder();

		reports.removeAllElements();
		generateCalls.addAll(Arrays.asList(pluginInit.getAllPlugins()));
		List<IPlugin> invalidGenerateCalls = new ArrayList<IPlugin>();

		for(IContentCreator contentCreatot : pluginInit.getContentCreators()){
			String generator_id = pluginInit.findPluginID(contentCreatot);
			ISaveContent[] saveContentPlugins = pluginInit.getSaveContentPlugins(generator_id);
			Object content = contentCreatot.generate();
			reports.add(contentCreatot.getReport());
			for(ISaveContent saveContent : saveContentPlugins){
				reports.add(saveContent.saveContent(content,generator_id));
			}
		}
	}

	public void setCLImode()
	{
		cliMode = true;
	}
	
	public static String[] getOutputFolders()
	{
		if (cliMode)
		{
			return null;
		}
		else
		{	//for GUI
			IEclipsePreferences ePref= new ConfigurationScope().getNode(IS60CTCommonConstants.S60_PREFERENCES);
			String outputFolders = ePref.get(IS60CTCommonConstants.USER_OUTPUT_FOLDER, "");
			String[] userOutput = outputFolders.split(";"); 
			return userOutput;
		}
	}
	
	public static String[] getCleanedOutputFolders()
	{
		IEclipsePreferences ePref= new ConfigurationScope().getNode(IS60CTCommonConstants.S60_PREFERENCES);
		String outputFolders = ePref.get(IS60CTCommonConstants.USER_OUTPUT_FOLDER, "");
		if (outputFolders.equals(""))
		{
			outputFolders = ePref.get(IS60CTCommonConstants.IBY_OUTPUT_FOLDER, "");
		}
		String[] userOutput = outputFolders.split(";"); 
		return userOutput;
	}
	
	private void cleanOutputFolder() {
		String[] output = getCleanedOutputFolders();

		for (int i = 0; i < output.length; i++) {
			File f = new File(output[i]);
			deleteDir(f);
		}
	}

	public static boolean deleteDir(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i=0; i<children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}

		// The directory is now empty so delete it
		return dir.delete();
	} 

	private final Map<String,Object> getRefValue(RootConf rootConf){
		
		PrioritisedConfigurationList prioritisedConfigurationList = PrioritisedConfigurationList.getPrioritisedConfigurationList();
		List<Configuration> listOfConfs = prioritisedConfigurationList.getPrioritisedConfigurations(rootConf);
		
		
		Map<String,Object> result = new HashMap<String, Object>();
		for(Iterator<Setting>iSetting=rootConf.getAllSettings().iterator();iSetting.hasNext();){
			Setting setting = iSetting.next();
			RootConf conf = setting.getGConf(); //configuration where gValue is defined
			if(conf==null)continue;//gValue does not exist
			String absRef = setting.getAbsRef();
			String confName = null;
			String confLevel = "0";
			if(!conf.getInclude().isEmpty()){//if master
				confName=conf.getName();
				confLevel=listOfConfs.size() - listOfConfs.indexOf(conf)+"";
			}else if(conf.getRoot()!=null){
				confName = conf.getRoot().getName();
				confLevel =listOfConfs.size() - listOfConfs.indexOf(conf.getRoot())+"";
			}
			
			
			confName=confName==null?"":confName.replaceAll(" ", "");
			result.put(confName+","+confLevel+","+absRef, setting.getGValue());
			result.put(confName+","+confLevel+","+IPlugin.RFS_PREFIX+absRef, setting.isRfs());
		}
		return result;
	}

}
