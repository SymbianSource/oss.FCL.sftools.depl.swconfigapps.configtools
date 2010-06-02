/*
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
 * All rights reserved.
 * This component and the accompanying materials are made available
 * under the terms of the License "Eclipse Public License v1.0"
 * which accompanies this distribution, and is available
 * at the URL "http://www.eclipse.org/legal/epl-v10.html".
 * 
 * Initial Contributors:
 * Nokia Corporation - Initial contribution
 * 
 * Contributors:
 * 
 * Description: This file is part of com.nokia.tools.variant.preview component.
 */

package com.nokia.tools.variant.internal.preview;

import java.io.File;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.core.runtime.content.IContentTypeManager;

import com.nokia.tools.variant.common.core.utils.PlatformUtil;
import com.nokia.tools.variant.preview.IPreviewDescriptor;
import com.nokia.tools.variant.preview.IPreviewDescriptorFactory;
import com.nokia.tools.variant.preview.UnsupportedContentDescriptor;

/**
 * Adapter factory for handling the preview support for IStorage (and IFile)
 * element
 * 
 */
public class IStoragePreviewAdapterFactory implements IAdapterFactory {

	/** Adapter types */
	static final Class<?>[] adapters = { IPreviewDescriptor.class };

	@SuppressWarnings("unchecked")
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (!(adaptableObject instanceof IStorage)) {
			return null;
		}
		if (!adapterType.equals(IPreviewDescriptor.class)) {
			return null;
		}
		IContentTypeManager ctManager = Platform.getContentTypeManager();
		IContentDescription descr = null;
		IContentType sourceCT = null;
		try {
			if (adaptableObject instanceof IFile) {
				descr = ((IFile) adaptableObject).getContentDescription();
			} else {
				IStorage storage = (IStorage) adaptableObject;
				descr = PlatformUtil.getAdapter(storage,
						IContentDescription.class, false);
				if (descr == null) {
					InputStream contents = storage.getContents();
					descr = ctManager.getDescriptionFor(contents, storage
							.getName(), IContentDescription.ALL);
					if (contents != null) {
						contents.close();
					}
				}
			}
		} catch (Exception e) {
			// ignore
			descr = null;
			// e.printStackTrace();
		}
		if (descr != null) {
			sourceCT = descr.getContentType();
		}
		if (sourceCT == null) {
			if (adaptableObject instanceof IStorage) {
				IStorage storage = (IStorage) adaptableObject;
				IPath fullPath = storage.getFullPath();
				File f = new File(fullPath.toString());
				return new UnsupportedContentDescriptor(f);
			}
		}

		IConfigurationElement[] extensions = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(
						"com.nokia.tools.variant.preview.contentpreview");
		for (IConfigurationElement el : extensions) {
			String name = el.getName();
			if (!name.equals("descriptorFactory")) {
				continue;
			}
			for (IConfigurationElement ctb : el
					.getChildren("contentTypeBinding")) {
				String ctid = ctb.getAttribute("contentTypeId");
				if (ctid == null) {
					continue;
				}
				IContentType ct = ctManager.getContentType(ctid);
				if (ct == null) {
					continue;
				}

				if (!sourceCT.isKindOf(ct)) {
					continue;
				}
				Object ext;
				try {
					ext = el.createExecutableExtension("class");
				} catch (CoreException e) {
					ext = null;
				}
				if (!(ext instanceof IPreviewDescriptorFactory)) {
					continue;
				}
				return ((IPreviewDescriptorFactory) ext)
						.createPreviewDescriptor((IStorage) adaptableObject,
								descr);
			}
		}

		File f = null;
		if (adaptableObject instanceof IStorage) {
			IStorage storage = (IStorage) adaptableObject;
			IPath fullPath = storage.getFullPath();
			f = new File(fullPath.toString());
			return new UnsupportedContentDescriptor(f);
		}

		return new UnsupportedContentDescriptor(f);
	}

	public Class<?>[] getAdapterList() {
		return adapters.clone();
	}
}
