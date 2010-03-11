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
package search.factories;

import org.eclipse.emf.search.core.factories.IModelSearchQueryParametersFactory;
import org.eclipse.emf.search.core.parameters.AbstractModelSearchQueryParameters;
import org.eclipse.emf.search.core.parameters.IModelSearchQueryParameters;

/**
 * Wraps ModelSearchQueryParameters creation.
 */
public class ModelSearchQueryParametersFactory implements
		IModelSearchQueryParametersFactory {
	private static ModelSearchQueryParametersFactory instance;

	public ModelSearchQueryParametersFactory() {
	}

	public static ModelSearchQueryParametersFactory getInstance() {
		return instance == null ? instance = new ModelSearchQueryParametersFactory()
				: instance;
	}

	protected final class ModelSearchQueryParameters extends
			AbstractModelSearchQueryParameters {
		public String getModelSearchEngineID() {
			return "search.IBYMLModelSearchEngine"; //$NON-NLS-1$
		}
	}

	public IModelSearchQueryParameters createSearchQueryParameters() {
		return new ModelSearchQueryParameters();
	}
}
