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

package com.nokia.tools.vct.internal.common.appmodel.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;

import com.nokia.tools.vct.common.appmodel.util.ICPFContentProvider;
import com.nokia.tools.vct.internal.common.appmodel.AppModelPlugin;

public class FileContentProvider implements ICPFContentProvider, IAdaptable {
	private File file;

	public FileContentProvider(File file) {
		this.file = file;
	}

	public InputStream createInputStream() throws CoreException {
		try {
			return new FileInputStream(file);
		} catch (FileNotFoundException e) {
			IStatus status = new Status(IStatus.ERROR,
					AppModelPlugin.PLUGIN_ID, "Source file does not exist", e);
			throw new CoreException(status);
		}
	}

	public OutputStream createOutputStream() throws CoreException {
		try {
			return new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			IStatus status = new Status(IStatus.ERROR,
					AppModelPlugin.PLUGIN_ID, "Source points to a directory", e);
			throw new CoreException(status);
		}
	}

	public File getFile() {
		return file;
	}

	public URI getURI() {
		return URI.createFileURI(file.getAbsolutePath());
	}

	@SuppressWarnings("unchecked")
	public Object getAdapter(Class adapter) {
		if (adapter == ICPFContentProvider.class) {
			return this;
		}
		if (adapter == File.class) {
			return file;
		}
		return null;
	}
}
