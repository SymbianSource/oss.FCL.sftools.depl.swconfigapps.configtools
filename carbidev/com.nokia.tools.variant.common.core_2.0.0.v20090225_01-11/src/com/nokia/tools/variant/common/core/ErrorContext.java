/*
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
 * All rights reserved.
 * This component and the accompanying materials are made available
 * under the terms of "Eclipse Public License v1.0"
 * which accompanies this distribution, and is available
 * at the URL "http://www.eclipse.org/legal/epl-v10.html".
 * 
 * Initial Contributors:
 * Nokia Corporation - Initial contribution
 * 
 * Contributors:
 * 
 * Description: This file is part of com.nokia.tools.variant.common.core component.
 */

package com.nokia.tools.variant.common.core;

import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;

public class ErrorContext implements ISafeRunnable {

	private Plugin pluginId;
	private String error;

	public ErrorContext(Plugin caller, String error) {
		this.pluginId = caller;
		this.error = error;
	}

	public void handleException(Throwable exception) {
		pluginId.getLog().log(
				new Status(IStatus.WARNING, pluginId.getBundle()
						.getSymbolicName(), error, exception));

	}

	public void run() throws Exception {
	}

}
