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
package com.nokia.s60ct.cli;

import init.IBYPluginInitializer;
import interfaces.IPluginInitializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import variantdata.VariantData;
import IBY.IBYFile;
import cenrep.Repository;

import com.nokia.s60ct.generate.GenerateManager;
import com.nokia.s60ct.generate.PluginInit;

import configurationemf.ConfigurationemfFactory;
import configurationemf.RootConf;
import configurationemf.util.IVariantDataManager;
import configurationemf.util.VariantDataManager;

import com.nokia.s60ct.genconfml.GenConfMlPluginInitializer;
import com.nokia.tools.s60ct.javaversionchecker.JavaVersionChecker;

/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IApplication {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.IPlatformRunnable#run(java.lang.Object)
	 */
	
	private static final String pluginID = "com.nokia.S60CT.CLI";

	public static final String PLUGIN_INIT = "startup.initializer";
	public static final String PLUGIN_INIT_CLASS ="class";
	private static final String CONFML_EXTENSION = ".confml";
	
	//default mode args
	private String strConfmlFile = null;
	private String[] crmlFolders = null;
	private String strIbymlFile = null;
	private String strOutputFolder = null;
	
	//build mode args
	private String strMasterFileName = null;
	private String strMasterConfName = null;
	private String strConfmlLocation = null;
	private String strAddConfmlLocation = null;
	private String strIbyFile = "S60CenRep_variant.iby";
	private String strIbyFolder = "\\epoc32\\rom\\include";
	private String[] strCenrepFolders = new String[]{"\\epoc32\\data\\Z\\private\\10202BE9",
													  "\\epoc32\\RELEASE\\winscw\\UDEB\\Z\\private\\10202BE9",
													  "\\epoc32\\RELEASE\\winscw\\UREL\\Z\\private\\10202BE9"};
	
	final static String RFS_PATH = "\\epoc32\\data\\Z\\private\\100059C9\\";
	
	private String reportFile = null;
	
	private boolean noIby = false;
	
	private boolean cleanOutput = false;
	
	boolean argsOK = true;
	
	boolean ignoreValidationErrors = false;
		
	//modes
	private static final int DEFAULT_MODE = 0;
	private static final int BUILD_MODE = 1;
	private int mode = DEFAULT_MODE;
	
	private IResourceManager resourceManager = new ResourceManager();

	private IVariantDataManager variantDataManager = new VariantDataManager();

	private String vdFile=null; // VariantData path

	private boolean isSaveRequired=false;

	private boolean isImportChain=false;
	
	
	
	public Object start(IApplicationContext context) throws Exception
	{ 
		Map args = context.getArguments();
		
		String[] strArray = null;
		
		if (args == null)
		{
			argsOK = false;
		}
		else
		{
			Object[] obArray = args.values().toArray();
			strArray = (String[])obArray[0]; //args doesn't come here as key/value pairs, but in String[] 
			for (int i = 0 ; i < strArray.length ; i++)
			{
				if (strArray[i].equals("-build"))
				{
					mode = BUILD_MODE;
					return parseBuildModeArgs(strArray);
				}
			}
			mode = DEFAULT_MODE;
			return parseDefaultArgs(strArray);
		}
		return IApplication.EXIT_OK;
	}
	
	private Object parseDefaultArgs(String[] strArray)
	{
		try 
		{
			FileOutputStream errorStream = new FileOutputStream(new File("cli_error.log"));
			System.setErr(new PrintStream(errorStream));
			System.err.println("Log created: "+DateFormat.getInstance().format(Calendar.getInstance().getTime()));
		} catch (FileNotFoundException e) {
			System.out.println("Couldn't create error log");
		}
		
		try {
			if(!JavaVersionChecker.isCurrentJreSupported()){
				StringBuffer sb = new StringBuffer();
				sb.append("You are using not officially supported JRE: \n");
				sb.append(JavaVersionChecker.getCurrentVendorAndVersion());
				sb.append("\n\nOfficially supported JREs: \n");
				sb.append(JavaVersionChecker.getSupportedJreNames());
				System.out.println(sb.toString());
				System.err.println(sb.toString());
			}
		} catch (Exception e) {
			System.err.println("Failed to check is used Java version supported.");
		}
		
		if (strArray.length == 0)
		{
			printCLIUsage();
			return IApplication.EXIT_OK;
		}
		for (int i = 0 ; i < strArray.length ; i++)
		{
			try
			{
				if (strArray[i].equals("-master")) //-master <name and path of the master confml file>
				{//mandatory argument
					if (strArray[i+1].charAt(0)!= '-')
					{
						strConfmlFile = strArray[i+1];
					}
					else
					{
						argsOK = false;
						break;
					}
				}
				else if(strArray[i].equals("-vds"))
				{	
					if(strArray[i+1].equals("-save")){
						vdFile=strArray[i+2];
						isSaveRequired=true;
					}else{
						vdFile=strArray[i+1];
						isSaveRequired=false;
					}
					this.isImportChain=false;
				}
				else if(strArray[i].equals("-vdc"))
				{
					if(strArray[i+1].equals("-save")){
						vdFile=strArray[i+2];
						isSaveRequired=true;
					}else{
						vdFile=strArray[i+1];
						isSaveRequired=false;
					}
					this.isImportChain=true;
				}
				else if (strArray[i].equals("-impl")) //-impl <paths to implentation files>
				{//mandatory argument
					if (strArray[i+1].charAt(0)!= '-')
					{
						crmlFolders = getSemiColonSeparatedFolders(strArray[i+1]);
					}
					else
					{
						argsOK = false;
						break;
					}
				}
				else if (strArray[i].equals("-ibyml")) //-ibyml <path to ibyml file>
				{//not mandatory argument
					if (strArray[i+1].charAt(0)!= '-')
					{
						strIbymlFile = strArray[i+1];
					}
					else
					{
						argsOK = false;
						break;
					}
				}
				else if (strArray[i].equals("-output"))
				{//not mandatory argument
					if (strArray[i+1].charAt(0)!= '-')
					{
						strOutputFolder = strArray[i+1];
					}
					else
					{
						argsOK = false;
						break;
					}
				}
				else if (strArray[i].equals("-report"))
				{
					if (strArray[i+1].charAt(0)!= '-')
					{
						reportFile = strArray[i+1];
					}
					else
					{
						argsOK = false;
						break;
					}
				}
				else if (strArray[i].equals("-ignore_errors"))
				{
					ignoreValidationErrors = true;
				}
				else if (strArray[i].equals("-version"))
				{
					System.out.println(getVersionInfo());
					return IApplication.EXIT_OK;
				}
				else if (strArray[i].equals("-clean_output"))
				{	
					cleanOutput=true;
				}
			}
			catch (ArrayIndexOutOfBoundsException aioobe)
			{//unexpected end of arguments array
				argsOK = false;
				break;
			}
		}
		argsOK=false;
		
		if(canApplyVD()){
			applyVD();
			argsOK=true;
		}
		
		if(canGenerate()){
			return generate(); //generate in default mode
		}
		
		if (!argsOK)
		{
			printCLIUsage();
		}
		return IApplication.EXIT_OK;
		
	}

	
	
	private void applyVD() {
		VariantData vd = (VariantData)resourceManager.readResource(vdFile);
		RootConf rootConf = (RootConf)resourceManager.readResource(strConfmlFile);
		Map<String, String> vdMap = null;
		if(isImportChain)
			vdMap = variantDataManager.getChainVDMap(vd);
		else
			vdMap = variantDataManager.getSingleVDMap(vd);
		Set<String> problems = variantDataManager.importValues(rootConf,vdMap ,null);
		if(isSaveRequired)resourceManager.save(rootConf,null);
		
		if (problems!=null && !problems.isEmpty()) {
			for (String problem : problems) {
				System.out.println("Variant data import error: " + problem);
				System.err.println("Variant data import error: " + problem);
			}
		}
	}

	private boolean canApplyVD() {
		return strConfmlFile!=null && vdFile!=null;
	}

	private boolean canGenerate() {
		
		if (strConfmlFile==null)
		{
			System.out.println("\nInvalid arguments!\n");
			System.out.println("-master is mandatory argument");
			argsOK = false;
		}
		else if (crmlFolders==null)
		{
			System.out.println("\nInvalid arguments!\n");
			System.out.println("-impl is mandatory argument");
			argsOK = false;
		}
		
		return strConfmlFile!= null && crmlFolders != null;
		
	}
	
	private Object parseBuildModeArgs(String[] strArray)
	{
		try 
		{
			FileOutputStream errorStream = new FileOutputStream(new File("cli_build_error.log"));
			System.setErr(new PrintStream(errorStream));
			System.err.println("Log created: "+DateFormat.getInstance().format(Calendar.getInstance().getTime()));
		} catch (FileNotFoundException e) {
			System.out.println("Couldn't create error log");
		}
		
		try {
			if(!JavaVersionChecker.isCurrentJreSupported()){
				StringBuffer sb = new StringBuffer();
				sb.append("You are using not officially supported JRE: \n");
				sb.append(JavaVersionChecker.getCurrentVendorAndVersion());
				sb.append("\n\nOfficially supported JREs: \n");
				sb.append(JavaVersionChecker.getSupportedJreNames());
				System.out.println(sb.toString());
				System.err.println(sb.toString());
			}
		} catch (Exception e) {
			System.err.println("Failed to check is used Java version supported.");
		}
		
		if (strArray.length <= 1)
		{
			printCLIBuildUsage();
			return IApplication.EXIT_OK;
		}
		for (int i = 0 ; i < strArray.length ; i++)
		{
			try
			{
				if (strArray[i].equals("-master_conf"))  //master configuration name without .confml extension
				{
					if (strArray[i+1].charAt(0)!= '-')
					{
						strMasterConfName = strArray[i+1];
						if (strMasterConfName.endsWith(CONFML_EXTENSION))
						{
							strMasterConfName = strMasterConfName.substring(0, strMasterConfName.length()-CONFML_EXTENSION.length());
						}
						if (strMasterConfName.contains(File.pathSeparator)) //user entered file.
						{
							argsOK = false;
							break;
						}
						strMasterFileName = strMasterConfName+CONFML_EXTENSION;
					}
					else
					{
						argsOK = false;
						break;
					}
				}
				else if (strArray[i].equals("-confml"))
				{
					if (strArray[i+1].charAt(0)!= '-')
					{
						strConfmlLocation = strArray[i+1];
					}
					else
					{
						argsOK = false;
						break;
					}
				}
				else if (strArray[i].equals("-extra_confml"))
				{
					if (strArray[i+1].charAt(0)!= '-')
					{
						strAddConfmlLocation = strArray[i+1];
					}
					else
					{
						argsOK = false;
						break;
					}
				}
				else if (strArray[i].equals("-iby"))
				{
					if (strArray[i+1].charAt(0)!= '-')
					{
						String iby = strArray[i+1];
						
						try
						{
							strIbyFolder = iby.substring(0, iby.lastIndexOf(File.separator));
							strIbyFile = iby.substring(iby.lastIndexOf(File.separator)+1);
							if (!strIbyFile.endsWith(".iby"))
								strIbyFile = null;
						}
						catch (Exception e)
						{
							strIbyFolder = null;
							strIbyFile = null;
						}
					}
					else
					{
						argsOK = false;
						break;
					}
				}
				else if (strArray[i].equals("-no_iby"))
				{
					noIby = true;
				}
				else if (strArray[i].equals("-cenrep"))
				{
					if (strArray[i+1].charAt(0)!= '-')
					{
						strCenrepFolders = getSemiColonSeparatedFolders(strArray[i+1]);
					}
					else
					{
						argsOK = false;
						break;
					}
				}else if (strArray[i].equals("-impl")) //-impl <paths to implentation files>
				{//mandatory argument
					if (strArray[i+1].charAt(0)!= '-')
					{
						crmlFolders = getSemiColonSeparatedFolders(strArray[i+1]);
					}
					else
					{
						argsOK = false;
						break;
					}
				}
				else if (strArray[i].equals("-ignore_errors"))
				{
					ignoreValidationErrors = true;
				}
				else if (strArray[i].equals("-report"))
				{
					if (strArray[i+1].charAt(0)!= '-')
					{
						reportFile = strArray[i+1];
					}
					else
					{
						argsOK = false;
						break;
					}
				}
				else if (strArray[i].equals("-clean_output"))
				{	
					cleanOutput=true;
				}
				else if (strArray[i].equals("-version"))
				{
					System.out.println(getVersionInfo());
					return IApplication.EXIT_OK;
				}
			}
			catch (ArrayIndexOutOfBoundsException aioobe)
			{//unexpected end of arguments array
				argsOK = false;
				break;
			}
		}
		
		if (strMasterConfName == null)
		{
			System.out.println("\nInvalid arguments!\n");
			System.out.println("-master_conf is mandatory argument");
			argsOK = false;
		}
		else if (strMasterFileName == null) //shouldn't come here ever
		{
			System.out.println("\nInvalid arguments!\n");
			System.out.println("-master_conf is mandatory argument");
			argsOK = false;
		}
		else if (crmlFolders == null)
		{
			System.out.println("\nInvalid arguments!\n");
			System.out.println("-impl is mandatory argument");
			argsOK = false;
		}
		else if (strConfmlLocation == null)
		{
			System.out.println("\nInvalid arguments!\n");
			System.out.println("-confml is mandatory argument");
			argsOK = false;
		}
		else if ((strIbyFolder == null || strIbyFile == null) && !noIby)
		{
			System.out.println("\nInvalid arguments!\n");
			System.out.println("-iby argument is in wrong format.");
			System.out.println("Format must be \\path\\filename.iby");
			argsOK = false;
		}
		
		if (strAddConfmlLocation != null && argsOK)
			resourceManager.copyFiles(strAddConfmlLocation, strConfmlLocation, IResourceManager.CONFML);
		
		if (!argsOK)
		{
			printCLIBuildUsage();
			return IApplication.EXIT_OK;
		}
		
		buildConfiguration();
		if(strConfmlFile!=null)
			return generate(); //generate in build mode
		else return IApplication.EXIT_OK;
	}
	
	private String[] getSemiColonSeparatedFolders(String strFolders)
	{
		String[] folders = null;
		if (strFolders.indexOf(";") != -1)
		{//has several files or paths in one argument
			folders = strFolders.split(";");
		}
		else
		{
			folders = new String[]{strFolders};
		}
		return folders;
	}
	

	private void buildConfiguration()
	{
		//Create master configuration that includes all confml and copy it to confml location
		File confmlFolder = new File((new File(strConfmlLocation)).getAbsolutePath());
		if(confmlFolder.exists()&&confmlFolder.isDirectory()){
			RootConf masterConf = ConfigurationemfFactory.eINSTANCE.createRootConf();
			masterConf.setName(strMasterConfName);
			String masterFilePath = confmlFolder.toString()+File.separator+strMasterFileName;
			File masterFile = new File(masterFilePath);
			if (masterFile.exists()) //delete old master conf or it will cause loop
			{
				masterFile.delete();
			}
			
			RootConf[] basedOns = resourceManager.readAllResources(new String[]{(new File(strConfmlLocation)).getAbsolutePath()}, IResourceManager.CONFML);
			//sort to make it look nice in tree
			boolean sorted = true;
			do
			{
				sorted = true;
				for (int i = 0 ; i < basedOns.length-1 ; i++)
				{
					RootConf basedOn1 = basedOns[i];
					RootConf basedOn2 = basedOns[i+1];
					if (basedOn1.getName().compareToIgnoreCase(basedOn2.getName()) > 0)
					{
						sorted = false;
						basedOns[i] = basedOn2;
						basedOns[i+1] = basedOn1;
					}
				}
			}while (!sorted);
			
			for(RootConf basedOn : basedOns){
				masterConf.getInclude().add(basedOn);
			}
			resourceManager.save(masterConf, masterFilePath);
			strConfmlFile = masterFilePath;
			try {
				Thread.currentThread().sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private Object generate()
	{
		IPluginInitializer[] pluginInits = getPluginInitializers();
		for (int i = 0 ; i < pluginInits.length ; i++)
		{
			if (pluginInits[i] instanceof IBYPluginInitializer) //don't init, but load the files.
			{
				if  (mode == DEFAULT_MODE)//init this plugin only if in default mode.
				{
					if (!loadIBYMLs(pluginInits[i]))
					{
						return IApplication.EXIT_OK;
					}
				}		
			} else if (pluginInits[i] instanceof GenConfMlPluginInitializer) {
				((GenConfMlPluginInitializer) pluginInits[i]).init(crmlFolders);
			}
			else
			{
				pluginInits[i].init();
			}
		}
		
		Repository[] repos = resourceManager.readAllResources(crmlFolders, IResourceManager.CRML);
		CenRepPlugin.getInstance().setRepositories(repos);
		
		RootConf configuration = (RootConf)resourceManager.readResource(strConfmlFile);
		
		if(mode==BUILD_MODE)
		{
			PluginInit.getInstance().changePlugin("iby", new BuildIbyPlugin(strIbyFolder, strIbyFile,strCenrepFolders, noIby)); 
			
			if (cleanOutput) //cleaning for normal mode (cli) is done in loadIBYMLs()
			{
				resourceManager.cleanOutputFolders(strCenrepFolders);
				resourceManager.cleanOutputFolders(new String[]{strIbyFolder, RFS_PATH});
			}
		}

		GenerateManager.getInstance().setCLImode();
		Vector report = GenerateManager.getInstance().generateConfiguration(configuration, false, ignoreValidationErrors, repos);
		System.out.println("OK");
		if (reportFile != null)
			resourceManager.saveReportFile(report, reportFile);
		return IApplication.EXIT_OK;
	}


	private boolean loadIBYMLs(IPluginInitializer pluginInit)
	{
		String[] strIbymlFiles = null;

		if (strIbymlFile == null)
		{
			strIbymlFiles = crmlFolders;
		}
		else
		{
			if (strIbymlFile.indexOf(";") != -1)
			{//has several files or paths in one argument
				strIbymlFiles = strIbymlFile.split(";");
			}
			else
			{
				strIbymlFiles = new String[]{strIbymlFile};
			}
		}
		
		boolean ibyFilesFound = false;
		
		for (int j = 0 ; j < strIbymlFiles.length ; j++)
		{
			if (((IBYPluginInitializer)pluginInit).openIBYML(new File(strIbymlFiles[j])))
				ibyFilesFound = true;	
		}
		if (!ibyFilesFound)
		{
			System.err.println("\nERROR! No ibyml file found!\n");
			System.out.println("\nERROR! No ibyml file found!\n");
			return false; //NOK
		}
		if (strOutputFolder != null)
			((IBYPluginInitializer)pluginInit).setOutputLocation(strOutputFolder);
		
		if (cleanOutput)
		{
			if (strOutputFolder != null)
			{
				resourceManager.cleanOutputFolders(new String[]{strOutputFolder});
			}
			else
			{
				IBYFile[] files = ((IBYPluginInitializer)pluginInit).getIBYFiles();
				String[] folders = new String[files.length];
				for (int i = 0 ; i < files.length ; i++)
					folders[i] = files[i].getLocationt().toString();
				
				resourceManager.cleanOutputFolders(folders);
			}
		}
		
		return true; //OK
	}
	
	public void stop()
	{
		
	}
	
public IPluginInitializer[] getPluginInitializers()
	{
		IPluginInitializer[] plugin_inits = null;
		
		List<IPluginInitializer> listInitializers = new ArrayList<IPluginInitializer>();
		IExtension[] extensions = Platform.getExtensionRegistry().getExtensionPoint(PLUGIN_INIT).getExtensions();
		for(int i=0;i<extensions.length;i++){
			IConfigurationElement[] elements = extensions[i].getConfigurationElements();
			for(int j=0;j<elements.length;j++){
				IPluginInitializer pluginInitializer=null;
				try{
					pluginInitializer = (IPluginInitializer)elements[j].createExecutableExtension(PLUGIN_INIT_CLASS);
				}catch(Exception e){
					System.err.println(e.getMessage());
				}
				if(pluginInitializer!=null)listInitializers.add(pluginInitializer);
			}
		}
		plugin_inits=listInitializers.toArray(new IPluginInitializer[listInitializers.size()]);
		
		for (int i = 0 ; i < plugin_inits.length ; i++) //in some environments, this order might be different, but generate plugin should be always loaded before others.
		{
			Class pluginClass = plugin_inits[i].getClass();
			if (pluginClass.equals(com.nokia.s60ct.generate.PluginInit.class) && i != 0)
			{
				IPluginInitializer temp = plugin_inits[0];
				plugin_inits[0] = plugin_inits[i];
				plugin_inits[i] = temp;
				break;
			}
		}
		
		return plugin_inits;
	}
	
	private String getVersionInfo()
	{
		String toolName=(String)Platform.getBundle(pluginID).getHeaders().get("Bundle-ToolName");  
		String pluginVersion=(String)Platform.getBundle(pluginID).getHeaders().get("Bundle-ReleaseVersion");  	
		String pluginDate=(String)Platform.getBundle(pluginID).getHeaders().get("Bundle-Date");   
		String pluginRepositoryVersion=(String)Platform.getBundle(pluginID).getHeaders().get("Bundle-RepositoryVersion"); 
		String legalText ="Copyright (c) 2009 Nokia Corporation.\nAll rights reserved.";
		
		return "\n"+toolName+"\n"+pluginVersion+"\n"+pluginDate+" rev."+pluginRepositoryVersion+"\n\n"+legalText;
	}
	
	public void setVariantDataManager(IVariantDataManager vdmanager) {
		variantDataManager  = vdmanager;
		
	}

	public void setResourceManager(IResourceManager resourceManager2) {
		this.resourceManager = resourceManager2;
	}
	
	private void printCLIUsage()
	{
		System.out.println("\nUsage:\n");
		System.out.println("cli.cmd -master <file> -impl <dirs> [-output <dir>] [-ibyml <files|dirs>]"); 
		System.out.println("        [-vds|-vdc [-save] <path to VariantData.xml>] [-report <file>]");
		System.out.println("        [-ignore_errors] [-clean_output]\n\n");
		System.out.println("-master <file>		File name and path of the master confml file.\n");
		System.out.println("-impl <dirs>		Directories that contains implementation crml files");
		System.out.println("			separated by semicolons (;).\n");
		System.out.println("-output <dir>		Output folder of the cenreps. This overrides the");
		System.out.println("			location value in ibyml files.\n");
		System.out.println("-ibyml <files|dirs>	Ibyml files or directories separated by semicolons (;).");
		System.out.println("			If not given, ibyml file is expected to be in impl dir.\n");
		System.out.println("-vds <file> 		File name and path of the VariantData.xml file. Import"); 
		System.out.println("			single VariantData. Values are applied but not saved.\n");
		System.out.println("-vdc <file> 		File name and path of the VariantData.xml file. Import"); 
		System.out.println("			chain of VariantDatas. Values are applied but not saved.\n");
		System.out.println("-save 			Apply and save VariantData values.\n");
		System.out.println("-clean_output		Cleans output folder before generating.\n"); //this cannot be "-clean". It's some sort of eclipse internal argument and it's not passed to this Application class.
		System.out.println("-report <file>		File name and path of the report file.");
		System.out.println("			This file contains name and full path of every");
		System.out.println("			generated cenrep file.\n");
		System.out.println("-ignore_errors		Ignores validation errors and generates cenreps");
		System.out.println("			even if errors occur.\n");
	}
	
	private void printCLIBuildUsage()
	{
		System.out.println("\nUsage:\n");
		System.out.println("cli_build.cmd -master_conf <name> -impl <dir> -confml <dir> [-iby <file>]");
		System.out.println("              [-cenrep <dir>] [-extra_confml <dir>] [-report <file>]");
		System.out.println("              [-no_iby] [-ignore_errors] [-clean_output]\n\n");
		System.out.println("-master_conf <name>	Name of the master confml file (e.g. s60).\n");
		System.out.println("-impl <dirs>		Directories that contains implementation crml files");
		System.out.println("			separated by semicolons (;).\n");
		System.out.println("-confml <dir>		Directory that contains confml files.\n");
		System.out.println("-iby <file>		Name and full path of the generated iby file.");
		System.out.println("			If not specified, default file");
		System.out.println("			\\epoc32\\rom\\include\\S60CenRep_variant.iby");
		System.out.println("			will be used.\n");
		System.out.println("-no_iby			Don't generate iby files.\n");
		System.out.println("-cenrep <dir>		Output directory of the cenrep files. If not");
		System.out.println("			specified, cenreps will be generated to three");
		System.out.println("			default directories:");
		System.out.println("			\\epoc32\\data\\z\\private\\10202BE9");
		System.out.println("			\\epoc32\\RELEASE\\winscw\\UDEB\\Z\\private\\10202BE9");
		System.out.println("			\\epoc32\\RELEASE\\winscw\\UREL\\Z\\private\\10202BE9\n");
		System.out.println("-clean_output		Cleans output folders before generating. If output is"); //this cannot be "-clean". It's some sort of eclipse internal argument and it's not passed to this Application class.
		System.out.println("			not cleaned, the RFS file is merged with existing file.\n");
		System.out.println("-extra_confml <dir>	Directory that contains additional confml files.");
		System.out.println("			All confml files from this directory and all");
		System.out.println("			subdirectories are copied to <confml> directory.\n");
		System.out.println("-report <file>		File name and path of the report file.");
		System.out.println("			This file contains name and full path of every");
		System.out.println("			generated cenrep file.\n");
		System.out.println("-ignore_errors		Ignores validation errors and generates cenreps");
		System.out.println("			even if errors occur.\n");
	}
	
}
