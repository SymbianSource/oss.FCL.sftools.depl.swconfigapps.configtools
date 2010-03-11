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
 * Description: This file is part of com.nokia.tools.variant.editor component.
 */

package com.nokia.tools.variant.editor.properties;

import com.nokia.tools.variant.content.confml.Property;

/**
 * These constants are names for graphic and file properties {@link Property}. 
 * 
 */

public interface FileProperty {
	// graphics
	final String TYPE_PROPERTY = "type";
	final String MAX_BITS_PROPERTY = "maxBits";
	final String MAX_WIDTH_PROPERTY = "maxWidth";
	final String MAX_HEIGHT_PROPERTY = "maxHeight";
	final String MIN_WIDTH_PROPERTY = "minWidth";
	final String MIN_HEIGHT_PROPERTY = "minHeight";
	final String WIDTH_PROPERTY = "width";
	final String HEIGHT_PROPERTY = "height";
	final String MAX_COLOR_PROPERTY = "maxColor";

	// file
	final String MAX_FILE_SIZE_PROPERTY = "maxFileSize";
	final String RECOMMENDED_FILE_SIZE_PROPERTY = "recommendedFileSize";
}
