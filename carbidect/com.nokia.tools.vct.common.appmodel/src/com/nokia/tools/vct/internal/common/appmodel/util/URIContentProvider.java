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

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;

import com.nokia.tools.vct.common.appmodel.util.ICPFContentProvider;
import com.nokia.tools.vct.internal.common.appmodel.AppModelPlugin;

public class URIContentProvider implements ICPFContentProvider,
		IAdaptable {
	private URIConverter converter;
	private URI uri;
	private Map<?, ?> options;

	public URIContentProvider(URI uri) {
		this(new ExtensibleURIConverterImpl(), uri, null);
	}

	public URIContentProvider(URIConverter converter, URI uri,
			Map<?, ?> options) {
		this.converter = converter;
		this.uri = uri;
		this.options = options;
	}

	public InputStream createInputStream() throws CoreException {
		try {
			return converter.createInputStream(uri, options);
		} catch (IOException e) {
			IStatus status = new Status(IStatus.ERROR,
					AppModelPlugin.PLUGIN_ID, "Can not open file", e);
			throw new CoreException(status);
		}
	}

	public OutputStream createOutputStream() throws CoreException {
		try {
			return converter.createOutputStream(uri, options);
		} catch (IOException e) {
			IStatus status = new Status(IStatus.ERROR,
					AppModelPlugin.PLUGIN_ID, "Can not open file", e);
			throw new CoreException(status);
		}
	}

	public URI getUri() {
		return uri;
	}

	public URIConverter getURIConverter() {
		return converter;
	}

	@SuppressWarnings("unchecked")
	public Object getAdapter(Class adapter) {
		if (adapter == ICPFContentProvider.class) {
			return this;
		}
		return null;
	}
}
