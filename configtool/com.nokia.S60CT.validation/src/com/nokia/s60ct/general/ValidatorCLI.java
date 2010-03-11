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
package com.nokia.s60ct.general;

import helpers.DefaultProject;
import helpers.MarkerManager;

import java.util.Vector;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ModelValidationService;

import clientContext.GeneralValidationSelector;

import com.nokia.s60ct.generate.GenerateManager;
import com.nokia.s60ct.interfaces.IGenerateValidator;

import configurationemf.Configuration;

public class ValidatorCLI extends Validator implements IGenerateValidator
{

	public ValidatorCLI()
	{
		GenerateManager.getInstance().registerValidator(this);
		//MarkerManager.getInstance().cleanProblems();
	}
	
	
	@Override
	public boolean validateBeforeGenerate(Configuration conf, Object[] repos) {
		IBatchValidator validator = (IBatchValidator)ModelValidationService.getInstance()
		.newValidator(EvaluationMode.BATCH);
		//validator.setIncludeLiveConstraints(true);
		
		GeneralValidationSelector.SELECTOR = true;
		Vector crmlCollection = new Vector(repos.length);
		for (int i = 0 ; i < repos.length ; i++)
			crmlCollection.add(repos[i]);
		//IStatus crmlStatus = validator.validate(filterCRMLCollection(conf, crmlCollection)); //with filter, the validation error count is different than in GUI
		IStatus crmlStatus = validator.validate(crmlCollection);
		Vector confmlCollection = new Vector(1);
		confmlCollection.add(conf);
		IStatus confmlStatus = validator.validate(confmlCollection);
		GeneralValidationSelector.SELECTOR = false;
		int numberOfErrors = MarkerManager.getInstance().getNumberOfErrors();
		
		// Print out problems
		IProject project = DefaultProject.getDefaultProject();
		
		int errors = MarkerManager.getInstance().getNumberOfErrors();
		
		try {
			for (IMarker marker : project.findMarkers(null, true, IResource.DEPTH_INFINITE)) {
				Integer code = (Integer) marker.getAttribute(IMarker.SEVERITY);
				String severity = "UNKNOWN";
				if (code != null) {
					if (code.equals(IMarker.SEVERITY_ERROR)) 
						severity = "ERROR";
					else if (code.equals(IMarker.SEVERITY_WARNING)) 
						severity = "WARNING";
					else if (code.equals(IMarker.SEVERITY_INFO)) 
						severity = "INFO";
				}
				System.err.println(severity + ": " + marker.getResource().getName() + ": " + marker.getAttribute(IMarker.MESSAGE));
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		String message = "";
		if (errors == 1)
			message = "One validation error.";
		else
			message = errors + " validation errors.";
		System.err.println(message);
		System.out.println(message);
		
		if (numberOfErrors==0)
			return true;
		else
			return false;
	}

	
	
}

