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
package init;

import interfaces.IPluginInitializer;

import java.io.File;

import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.osgi.service.prefs.Preferences;

import constants.IS60CTCommonConstants;

public class CRPluginInitializer implements IPluginInitializer {
	
	//preferences file support
	private static final String CR_CONF_NODE="CenRep";
	private static final String CR_CONF_PATH="PATH";
	public CRPluginInitializer() {
		
	}

	public void init() {
		IEclipsePreferences ePref= new ConfigurationScope().getNode(IS60CTCommonConstants.S60_PREFERENCES);
		Preferences pref=ePref.node(CRPluginInitializer.CR_CONF_NODE);
		String[] paths = pref.get(CRPluginInitializer.CR_CONF_PATH, "").trim().split(File.pathSeparator);
		for(int i=0;i<paths.length;i++){
			File file=new File(paths[i]);
			openCRMLs(file);
					
		}
	}
	private void openCRMLs(File file){
//		ResourceSet resourceSet = DomainManager.instance().getEditingDomain().getResourceSet();
//		if(file.exists()){
//			if(file.isDirectory()){
//				String[] files=file.list();
//				for(int j=0;j<files.length;j++)openCRMLs(new File(file.getAbsolutePath()+File.separator+files[j]));
//			}else if(file.isFile()&&file.getAbsolutePath().endsWith(DomainManager.EMPTY_FILE_URL))
//				resourceSet.getResource(URI.createFileURI(file.getAbsolutePath()), true);
//		}
	}
}
