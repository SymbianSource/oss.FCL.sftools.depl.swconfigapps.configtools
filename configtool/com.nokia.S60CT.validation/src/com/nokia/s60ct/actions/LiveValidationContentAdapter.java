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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.service.ILiveValidator;
import org.eclipse.emf.validation.service.ModelValidationService;

public class LiveValidationContentAdapter extends EContentAdapter {
	
	private final EnableLiveValidationDelegate actionDelegate;
	private ILiveValidator validator = null;
	
	LiveValidationContentAdapter(EnableLiveValidationDelegate delegate) {
		actionDelegate = delegate;
	}

	public void notifyChanged(final Notification notification) {
		super.notifyChanged(notification);
		
		actionDelegate.shell.getDisplay().asyncExec(new Runnable() {
			public void run() {
				if (validator == null) {
					validator = (ILiveValidator) ModelValidationService
							.getInstance().newValidator(EvaluationMode.LIVE);
				}
				
//				CSelector.running = true;
				
				IStatus status = validator.validate(notification);
				
				if (!status.isOK()) {
					if (status.isMultiStatus()) {
						status = status.getChildren()[0];
					}
					
//					MessageDialog.openError(LiveValidationContentAdapter.this.actionDelegate.shell,LiveValidationContentAdapter.this.actionDelegate.title,status.getMessage());
				}
				
//				CSelector.running = false;
			}
		});
	}
}
