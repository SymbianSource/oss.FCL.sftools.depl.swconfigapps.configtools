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
package com.nokia.s60ct.cenrep.gui.Actions;

import generate.CenrepGenerator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.swt.widgets.Display;

import cenrep.Repository;

import com.nokia.s60ct.cenrep.gui.editors.CRBrowser;
import com.nokia.s60ct.generate.GenerationReport;
import com.nokia.s60ct.interfaces.IContentCreator;

public class GenerateCall implements IContentCreator {
	
	static Display display = new Display();
	private CRBrowser editor=null;
	private final static CenrepGenerator GENERATOR = new CenrepGenerator();
	
	public GenerateCall(){
	}
	
	public Object generate() {
		return GENERATOR.generate();
	}
	
	public GenerationReport getReport()
	{
		return GENERATOR.getReport();
	}
	
	public Collection<Object> setRefValue(Map<String, Object> refToValue) {
		Repository[] reps = getOpenRepositories();
		if (reps != null){ //in bundled project the CLI generate also calls this method
			GENERATOR.setRepositories(reps);
			return GENERATOR.setRefValue(refToValue);
		}else
			return new ArrayList<Object>();
	}
	
	private Repository[] getOpenRepositories(){
		List<Repository> result = new ArrayList<Repository>();
		editor = CRBrowser.getCRBrowserEditor();
		if(editor!=null){
			ResourceSet rset = editor.getEditingDomain().getResourceSet();
			for(Resource resource : rset.getResources())
			{
				if(!resource.getContents().isEmpty())
					result.add((Repository)resource.getContents().get(0));
			}
			return result.toArray(new Repository[result.size()]);
		}
		return null;
	}

	
	
	
}
