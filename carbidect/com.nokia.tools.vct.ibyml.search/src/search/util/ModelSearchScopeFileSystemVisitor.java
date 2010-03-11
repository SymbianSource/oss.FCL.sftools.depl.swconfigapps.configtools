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
package search.util;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.search.core.scope.IModelSearchScope;
import org.eclipse.emf.search.ecore.common.utils.file.EcoreModelSearchScopeFileSystemVisitor;
import java.io.File;

public class ModelSearchScopeFileSystemVisitor extends
		EcoreModelSearchScopeFileSystemVisitor {

	public ModelSearchScopeFileSystemVisitor(
			IModelSearchScope<Object, Resource> scope) {
		super(scope);
	}

	protected boolean isParticipantCurrentSearchEngineValid(File f) {
		if (f instanceof File && f.canRead() && f.exists() && !f.isHidden()) {

			if (f.getName().endsWith(".ibyml")) { //$NON-NLS-1$
				return true;
			}

		}
		return false;
	}
}
