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

import generate.CenrepGenerator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import cenrep.Repository;

import com.nokia.s60ct.generate.GenerationReport;
import com.nokia.s60ct.interfaces.IContentCreator;

public class CenRepPlugin implements IContentCreator {

	private final static CenrepGenerator GENERATOR = new CenrepGenerator();
	private static CenRepPlugin INSTANCE;
	private Repository[] repos=null;
	
	public CenRepPlugin()
	{
		INSTANCE=this;
	}

	public Object generate()
	{
		return GENERATOR.generate();
	}
	
	public static final CenRepPlugin getInstance()
	{
		return INSTANCE;
	}

	public Collection setRefValue(Map<String, Object> refToValue)
	{
		Repository[] reps = getRepositories();
		if (reps == null) //in bundled project the GUI generate also calls this method.
			return new ArrayList();
		GENERATOR.setRepositories(reps);
		return GENERATOR.setRefValue(refToValue);
	}
	
	public void setRepositories(Repository[] repos)
	{
		this.repos = repos;
	}
	
	public Repository[] getRepositories()
	{
		return repos;
	}

	@Override
	public GenerationReport getReport()
	{
		return new GenerationReport();
	}

}
