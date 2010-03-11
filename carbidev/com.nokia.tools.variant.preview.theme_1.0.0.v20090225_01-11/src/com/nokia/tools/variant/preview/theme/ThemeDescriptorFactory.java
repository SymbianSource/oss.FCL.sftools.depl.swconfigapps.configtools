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
 * Description: This file is part of com.nokia.tools.variant.preview.theme component.
 */

package com.nokia.tools.variant.preview.theme;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.content.IContentDescription;

import com.nokia.tools.variant.preview.IPreviewDescriptor;
import com.nokia.tools.variant.preview.IPreviewDescriptorFactory;
import com.nokia.tools.variant.preview.UnsupportedContentDescriptor;

public class ThemeDescriptorFactory implements IPreviewDescriptorFactory {

	public IPreviewDescriptor createPreviewDescriptor(IStorage source,
			IContentDescription description) {
		try {
			return new ThemeDescriptor(source);
		} catch (Exception ex) {
			ThemePreviewPlugin.logError("Failed to construct theme preview descriptor",
					ex);
			return new UnsupportedContentDescriptor(null);
		}
	}

}
