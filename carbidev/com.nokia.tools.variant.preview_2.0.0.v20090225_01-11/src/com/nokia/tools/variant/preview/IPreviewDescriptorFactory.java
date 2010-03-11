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
 * Description: This file is part of com.nokia.tools.variant.preview component.
 */

package com.nokia.tools.variant.preview;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.content.IContentDescription;

/**
 * Interface for preview descriptor construction.
 * 
 * This interface is used for providing pluggable extensions for preview
 * descriptor construction.
 * 
 */
public interface IPreviewDescriptorFactory {

	/**
	 * Factory method.
	 * 
	 * @param source
	 *            Content source for the preview
	 * @param description
	 *            Content description
	 * @return Preview descriptor (or <code>null</code>)
	 * 
	 * @see IPreviewDescriptor
	 */
	IPreviewDescriptor createPreviewDescriptor(IStorage source,
			IContentDescription description);
}
