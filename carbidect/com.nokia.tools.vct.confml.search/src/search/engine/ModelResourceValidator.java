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
 * Description: This file is part of com.nokia.tools.vct.confml.search component.
 */

package search.engine;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.search.core.resource.AbstractModelResourceValidator;

/**
 * Allows users to describe all the specific query search supported model editor extensions.
 */
public class ModelResourceValidator extends AbstractModelResourceValidator {
	public ModelResourceValidator() {

		addModelFileExtension("confml"); //$NON-NLS-1$

	}
	
	@Override
	public boolean hasSupportedModelFileExtension(URI uri) {
		
		boolean result = super.hasSupportedModelFileExtension(uri);
		return result;
	}
}
