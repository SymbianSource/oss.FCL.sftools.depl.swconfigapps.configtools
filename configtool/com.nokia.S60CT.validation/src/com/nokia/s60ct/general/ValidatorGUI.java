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

import helpers.MarkerManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Preferences;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

import clientContext.GeneralValidationSelector;

import com.nokia.s60ct.generate.GenerateManager;
import com.nokia.s60ct.interfaces.IGenerateValidator;
import com.nokia.s60ct.messages.ValidationMessages;
import com.nokia.s60ct.quickfixers.QuickFixPopupDialog;
import com.nokia.s60ct.validation.Activator;

import configurationemf.Configuration;


public class ValidatorGUI extends Validator implements IGenerateValidator
{
	protected static Shell shell = null;
	private IBatchValidator validator;
	public ValidatorGUI()
	{
		GenerateManager.getInstance().registerValidator(this);
		//MarkerManager.getInstance().cleanProblems(); //not needed if persistent = false
	}
	
	
	
	@Override
	public boolean validateBeforeGenerate(Configuration conf, Object[] repos) {
		
		validate(getCRMLs(null), Collections.singletonList(conf), false);
		
		int numberOfErrors = MarkerManager.getInstance().getNumberOfErrors();
		
		if (numberOfErrors==0)
		{
			return true;
		}
		else
		{
			showProblemsView();
			String messagePrefix = "";
			if (numberOfErrors == 1)
				messagePrefix = "One error.";
			else
				messagePrefix = numberOfErrors+" errors.";
			
			boolean answer = MessageDialog.openQuestion(this.shell, "Validation Error", messagePrefix+" Are you sure that you want to continue generation. Result files might contain errors");
			return answer;
		}
	}
	
	private void showProblemsView()
	{
		try
		{
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(IPageLayout.ID_PROBLEM_VIEW);
		} 
		catch (PartInitException e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void validateAll()
	{
		validate(getCRMLs(null), getRootConfiguration(), true);
	}
	
	public void validateSelected(EObject obj)
	{
		validate(Collections.singletonList(obj), null, true);
	}
	
	private void validate(final Collection phase1collection, final Collection phase2collection, final boolean processStatus)
	{
		MarkerManager.getInstance().cleanProblems();
		showProblemsView();
		
		Display display = PlatformUI.getWorkbench().getDisplay();
		
		final Cursor cursorWait = new Cursor(display, SWT.CURSOR_WAIT);
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().setCursor(cursorWait);
		
		//Thread operationThread = new Thread() {
	        //public void run() {
	        	IBatchValidator validator = createBatchValidator();
	        	GeneralValidationSelector.SELECTOR = true;
	    		IStatus phase1Status = validator.validate(phase1collection); //normally crmls or single file.
	    		
	    		IStatus phase2Status = null;
	    		if (phase2collection != null)
	    			phase2Status = validator.validate(phase2collection); //normally confml
	    		if (processStatus)
	    			processStatus(MarkerManager.getInstance().getNumberOfErrors() + MarkerManager.getInstance().getNumberOfWarnings()); 
	        //}
	    //};
	    //operationThread.start();
	    		
	    GeneralValidationSelector.SELECTOR = false;
		final Cursor cursorArrow = new Cursor(display, SWT.CURSOR_ARROW);
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().setCursor(cursorArrow);
	   
		//get all the markers that have quick fixes available and show popup dialog
		IMarker[] quickFixMarkers = MarkerManager.getInstance().getQuickFixes();
		Preferences store = Activator.getDefault().getPluginPreferences();
		boolean dontShow = store.getBoolean("DISPLAY_QUICKFIX_DIALOG");
		if (quickFixMarkers!=null && !dontShow)
		{
			QuickFixPopupDialog popupDialog = new QuickFixPopupDialog(PlatformUI.getWorkbench().getDisplay().getActiveShell(), quickFixMarkers);
			popupDialog.displayDialog();		
			if(popupDialog.getCheckBoxStatus())
			{
				store.setValue("DISPLAY_QUICKFIX_DIALOG", true);
			}
		}
	}
	
	

	private void processStatus(final int problemCount) {
		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() { 
            public void run() {
            	if (problemCount == 0)
        		{
            		MessageDialog.openInformation(shell, ValidationMessages.BatchValidationDelegate_title, ValidationMessages.BatchValidationDelegate_successMessage);
        		}
            }
        });
	}

	private IBatchValidator createBatchValidator() {
		if(validator==null){
			validator = (IBatchValidator)ModelValidationService.getInstance()
			.newValidator(EvaluationMode.BATCH);
			//validator.setIncludeLiveConstraints(true);
		}
		return validator;
	}
	
}
