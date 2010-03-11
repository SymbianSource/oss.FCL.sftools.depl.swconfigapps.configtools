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
package configurationemf.util;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.core.runtime.content.IContentTypeManager;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.URIConverterImpl;

public class ConfMLHelper {
	/**
	 * Determines the used encoding of the given ConfML file
	 * @param uri
	 * @return
	 */
	public static String determineCharset(URI uri) {
		URIConverter converter = new URIConverterImpl();
		String returnValue = null;
		try {
			InputStream inputStream = converter.createInputStream(uri);
			IContentTypeManager contentManager = Platform.getContentTypeManager();
			IContentDescription description = contentManager.getDescriptionFor(inputStream, null, IContentDescription.ALL);
			inputStream.close();
			returnValue = description.getCharset();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return returnValue;
	}
}
