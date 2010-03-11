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

package search.factories;

import org.eclipse.emf.search.core.engine.AbstractModelSearchQuery;
import org.eclipse.emf.search.core.factories.IModelSearchQueryFactory;
import org.eclipse.emf.search.core.parameters.IModelSearchQueryParameters;

import search.engine.ModelSearchQuery;

/**
 * Wraps ModelSearchQuery creation.
 */
public class ModelSearchQueryFactory implements IModelSearchQueryFactory {
	private static ModelSearchQueryFactory instance;

	public ModelSearchQueryFactory() {
	}

	public static ModelSearchQueryFactory getInstance() {
		return instance == null ? instance = new ModelSearchQueryFactory()
				: instance;
	}

	public AbstractModelSearchQuery createModelSearchQuery(String expr,
			IModelSearchQueryParameters p) {
		return new ModelSearchQuery(expr, p);
	}
}
