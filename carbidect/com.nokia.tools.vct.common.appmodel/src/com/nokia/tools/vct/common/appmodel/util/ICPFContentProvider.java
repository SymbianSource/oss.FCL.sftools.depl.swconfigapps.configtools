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
 * Description: This file is part of com.nokia.tools.vct.common.appmodel component.
 */

package com.nokia.tools.vct.common.appmodel.util;

import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.core.runtime.CoreException;

/**
 * Direct data stream provider interface. This interface is intended to provide
 * unbuffered streams used for CPF data area access.
 */
public interface ICPFContentProvider {
	/**
	 * Create source stream
	 * 
	 * @return unbuffered data stream
	 * @throws CoreException
	 */
	InputStream createInputStream() throws CoreException;

	/**
	 * Create destination stream
	 * 
	 * @return unbuffered data stream
	 * @throws CoreException
	 */
	OutputStream createOutputStream() throws CoreException;
}
