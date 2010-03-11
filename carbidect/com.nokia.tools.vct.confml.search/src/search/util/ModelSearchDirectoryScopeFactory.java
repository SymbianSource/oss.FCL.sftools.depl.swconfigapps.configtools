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

package search.util;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.search.core.scope.IModelSearchScope;
import org.eclipse.emf.search.ecore.common.utils.file.EcoreModelSearchDirectoryScopeFactory;
import org.eclipse.emf.search.ecore.common.utils.file.EcoreModelSearchScopeFileSystemVisitor;

public class ModelSearchDirectoryScopeFactory extends
		EcoreModelSearchDirectoryScopeFactory {

	// shared ModelSearchScopeFactory instance
	private static ModelSearchDirectoryScopeFactory instance;

	/**
	 * Singleton access to the ModelSearchDirectoryScopeFactory instance.
	 * 
	 * @return New ModelSearchDirectoryScopeFactory instance or previously created one
	 */
	public static ModelSearchDirectoryScopeFactory getInstance() {
		return instance == null ? instance = new ModelSearchDirectoryScopeFactory()
				: instance;
	}

	@Override
	protected EcoreModelSearchScopeFileSystemVisitor getModelSearchFileSystemVisitor(
			IModelSearchScope<Object, Resource> scope) {
		return new ModelSearchScopeFileSystemVisitor(scope);
	}
}
