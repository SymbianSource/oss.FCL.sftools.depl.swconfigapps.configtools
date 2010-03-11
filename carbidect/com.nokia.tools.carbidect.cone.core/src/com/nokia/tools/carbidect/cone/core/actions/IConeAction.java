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
package com.nokia.tools.carbidect.cone.core.actions;

import java.io.OutputStream;

import org.eclipse.core.runtime.IProgressMonitor;


public interface IConeAction {
	/**
	 * @return
	 */
	public abstract String getActionName();

	/**
	 * @return
	 */
	public abstract IConeActionConfiguration getActionConfigiration();

	/**
	 * @param outputStream
	 * @param monitor
	 * @return
	 */
	public abstract int run(OutputStream outputStream, IProgressMonitor monitor);

	/**
	 * @param pathToConeCmd
	 */
	public abstract void setUsedConeTool(String pathToConeCmd);

	/**
	 * @return
	 */
	public abstract String getUsedConeTool();
}
