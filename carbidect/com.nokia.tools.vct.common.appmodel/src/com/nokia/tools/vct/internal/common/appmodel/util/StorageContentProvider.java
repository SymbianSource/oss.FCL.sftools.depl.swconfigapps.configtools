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

import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;

import com.nokia.tools.vct.common.appmodel.util.ICPFContentProvider;

public class StorageContentProvider implements ICPFContentProvider,
		IAdaptable {
	private IStorage storage;

	public StorageContentProvider(IStorage storage) {
		this.storage = storage;
	}

	public InputStream createInputStream() throws CoreException {
		return storage.getContents();
	}

	public OutputStream createOutputStream() throws CoreException {
		throw new UnsupportedOperationException();
	}

	@SuppressWarnings("unchecked")
	public Object getAdapter(Class adapter) {
		if (adapter == ICPFContentProvider.class) {
			return this;
		}
		if (adapter == IStorage.class) {
			return storage;
		}
		return null;
	}

	public IStorage getStorage() {
		return storage;
	}
}
