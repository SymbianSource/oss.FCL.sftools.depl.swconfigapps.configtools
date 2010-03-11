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
 * Description: This file is part of com.nokia.tools.variant.resourcelibrary component.
 */

package com.nokia.tools.variant.resourcelibrary.views;

import java.io.InputStream;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.content.IContentDescription;

import com.nokia.tools.variant.resourcelibrary.model.File;
import com.nokia.tools.variant.resourcelibrary.model.FileSystemElement;

public class ResourceStorage implements IStorage {

	private FileSystemElement file;

	public ResourceStorage(FileSystemElement fse) {
		this.file = fse;
	}

	public InputStream getContents() throws CoreException {
		if (file instanceof File) {
			return ((File) file).getInputStream();
		} else {
			return null;
		}
	}

	public IPath getFullPath() {
		return file.getPath2();
	}

	public String getName() {
		return file.getName();
	}

	public boolean isReadOnly() {
		return file.isReadOnly();
	}

	@SuppressWarnings("unchecked")
	public Object getAdapter(Class adapter) {
		if (adapter == FileSystemElement.class) {
			return file;
		}
		if (adapter == IContentDescription.class) {
			return getContentDescription();
		}
		return null;
	}

	public FileSystemElement getFileSystemElement() {
		return file;
	}

	public IContentDescription getContentDescription() {
		if (file instanceof File) {
			return ((File) file).getContentDescription();
		} else {
			return null;
		}
	}
}
