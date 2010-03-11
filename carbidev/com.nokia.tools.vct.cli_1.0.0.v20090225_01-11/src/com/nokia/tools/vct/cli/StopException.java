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
 * Description: This file is part of com.nokia.tools.vct.cli component.
 */

package com.nokia.tools.vct.cli;

public class StopException extends Exception {
	
	/** serialization exception */
	private static final long serialVersionUID = 1L;

	private int exitCode;
	
	public StopException(int exitCode) {
		this.exitCode = exitCode;
	}
	
	public int getExitCode() {
		return exitCode;
	}
}
