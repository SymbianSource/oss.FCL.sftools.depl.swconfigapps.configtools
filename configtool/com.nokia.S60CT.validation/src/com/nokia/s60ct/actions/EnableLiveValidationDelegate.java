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
package com.nokia.s60ct.actions;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate2;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

import com.nokia.s60ct.messages.ValidationMessages;

import configurationemf.Feature;
import configurationemf.Setting;

public class EnableLiveValidationDelegate implements IActionDelegate2, IWorkbenchWindowActionDelegate,
		IViewActionDelegate {

	protected static final String MESSAGE_EXCEPTION = ValidationMessages.message_exception;
	protected Shell shell = null;
	protected IViewPart editor = null;
	protected Collection selectedEObjects = null;

	String title = ValidationMessages.EnableLiveValidationDelegate_title;
	
	public EnableLiveValidationDelegate() {
	}

	public void dispose() {
		// No-op

	}

	public void init(IAction action) {
		

	}

	public void runWithEvent(IAction action, Event event) {
		run(action);

	}

	public void run(IAction action) {
		for (Iterator i = selectedEObjects.iterator(); i.hasNext();) {
			EObject r = (EObject)i.next();
			
			if (!resourceHasAdapter(r)) {
				EContentAdapter liveValidationContentAdapter = new LiveValidationContentAdapter(this);
				r.eAdapters().add(liveValidationContentAdapter);
			}
		}

	}

	public void selectionChanged(IAction action, ISelection selection) {
		this.selectedEObjects = null;
		try {
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection structuredSelection = (IStructuredSelection) selection;
				this.selectedEObjects = structuredSelection.toList();
			}
		} catch (Exception e) {
			// Exceptions are not expected
			MessageDialog.openInformation(shell, title, MESSAGE_EXCEPTION);
			throw new RuntimeException(e);
		} finally {
			action.setEnabled((null != selectedEObjects));
		}
		
		for (Iterator i = selectedEObjects.iterator(); i.hasNext();) {
			Object o = i.next();
			if (!(o instanceof Feature)&&!(o instanceof Setting)) {
				action.setEnabled(false);
			} else if (resourceHasAdapter((EObject)o)) {
				action.setEnabled(false);
			}
		}

	}

	public void init(IViewPart view) {
		this.editor = view;
		if(view !=null)
			this.shell = view.getSite().getShell();

	}
	
	private boolean resourceHasAdapter(EObject r) {
		Collection adapters = r.eAdapters();
		for (Iterator j = adapters.iterator(); j.hasNext();) {
			Object o = j.next();
			if (o instanceof LiveValidationContentAdapter) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public void init(IWorkbenchWindow window)
	{
		
	}
}
