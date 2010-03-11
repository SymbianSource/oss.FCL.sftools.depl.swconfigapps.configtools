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
 * Description: This file is part of com.nokia.tools.vct.confml.editor.view component.
 */

package com.nokia.tools.vct.confml.editor.view.viewers;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.swt.graphics.Image;

import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.core.utils.FileUtils;
import com.nokia.tools.vct.common.ui.navigator.INavigatorLabelProvider;
import com.nokia.tools.vct.common.ui.utils.SWTUtil;
import com.nokia.tools.vct.confml.editor.view.vemodel.EDescriptionContainer;
import com.nokia.tools.vct.confml.editor.view.vemodel.EIconContainer;

/**
 * 
 * IMPROVEMENT implement workspace notification processing here or in content
 * provider...
 * 
 */
public class NavigatorViewerLabelProvider extends ViewTreeViewerLabelProvider
		implements INavigatorLabelProvider {

	static class ImageCacheEntry {
		Image image;
		String uri;
	}

	private Map<EIconContainer, ImageCacheEntry> imageCache = new LinkedHashMap<EIconContainer, ImageCacheEntry>();

	@Override
	public Image getImage(Object element) {
		if (element instanceof EIconContainer) {
			EIconContainer container = (EIconContainer) element;

			ImageCacheEntry entry = imageCache.get(container);
			if (entry == null) {
				entry = new ImageCacheEntry();
				entry.uri = container.getIconUri();
				entry.image = resolveImage(element, entry.uri);
				imageCache.put(container, entry);
			} else {
				if (!equals(entry.uri, container.getIconUri())) {
					if (entry.image != null) {
						entry.image.dispose();
						entry.image = null;
					}
					entry.uri = container.getIconUri();
					entry.image = resolveImage(element, entry.uri);
				}
			}

			return entry.image;
		} else {
			return null;
		}
	}

	Image resolveImage(Object element, String relative) {
		if (relative == null) {
			return null;
		}
		if (!(element instanceof EObject)) {
			return null;
		}
		Resource resource = ((EObject) element).eResource();
		URI uri = resource.getURI();
		IPath path = new Path(uri.toPlatformString(true));
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		EConfMLLayer variant = ConfMLCore.getLayer(file); // ConverterUtils.
															// getVariantContributor
															// (documentUri);

		if (variant == null) {
			return null;
		}

		URI docUri = URI.createURI(relative);
		docUri = variant.getDocumentMap().get(docUri);

		if (docUri == null) {
			return null;
		}

		ResourceSet resourceSet = resource.getResourceSet();
		URIConverter converter = resourceSet.getURIConverter();
		InputStream is = null;
		try {
			is = converter.createInputStream(docUri);
		} catch (IOException e) {
		}
		if (is != null) {
			try {
				Image image = new Image(SWTUtil.getStandardDisplay(),
						new BufferedInputStream(is));
				return image;
			} finally {
				FileUtils.closeStream(is);
			}

		}

		return null;
	}

	static boolean equals(String a, String b) {
		if (a == null) {
			return b == null;
		} else {
			return a.equals(b);
		}
	}

	public String getDescription(Object element) {
		if (element instanceof EDescriptionContainer) {
			return ((EDescriptionContainer) element).getDescriptionText();
		}
		return null;
	}

	public String getToolTipText(Object element) {
		if (element instanceof EDescriptionContainer) {
			return ((EDescriptionContainer) element).getDescriptionText();
		}
		return null;
	}

	@Override
	public void dispose() {
		for (ImageCacheEntry entry : imageCache.values()) {
			entry.image.dispose();
		}
		imageCache.clear();

		super.dispose();
	}
}
