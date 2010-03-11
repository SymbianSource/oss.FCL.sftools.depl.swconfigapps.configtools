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
 * Description: This file is part of com.nokia.tools.vct.appshell component.
 */

package com.nokia.tools.vct.appshell.parts.misc;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;

import com.nokia.tools.variant.common.core.utils.FileUtils;
import com.nokia.tools.vct.appshell.AppshellPlugin;

public class ApplicationIdMap {

	private Map<String, String> applicationIdMap;

	public ApplicationIdMap() {
		applicationIdMap = new HashMap<String, String>();

		Properties p = new Properties();
		URL url = AppshellPlugin.getPlugin().getBundle().getEntry(
				"data/appshellapplications.properties");
		InputStream is = null;
		try {
			is = url.openStream();
			p.load(is);
		} catch (Exception ex) {
		} finally {
			FileUtils.closeStream(is);
		}
		mergeProperties(p);
	}

	private void mergeProperties(Properties p) {
		for (Map.Entry<Object, Object> entry : p.entrySet()) {
			String key = (String) entry.getKey();
			key = key.toLowerCase();
			String value = (String) entry.getValue();
			applicationIdMap.put(key, value);
		}
	}

	public void load(ResourceSet resourceSet, URI uri) {
		URIConverter converter = resourceSet.getURIConverter();
		InputStream is = null;
		Properties p = new Properties();
		try {
			is = converter.createInputStream(uri);
			p.load(is);
		} catch (IOException ex) {
		} finally {
			FileUtils.closeStream(is);
		}
		mergeProperties(p);
	}

	public String getApplicationName(String applicationId) {
		return applicationIdMap.get(applicationId.toLowerCase());
	}
}
