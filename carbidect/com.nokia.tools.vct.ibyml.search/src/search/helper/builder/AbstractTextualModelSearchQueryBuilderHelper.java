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

package search.helper.builder;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.search.core.engine.IModelSearchQuery;
import org.eclipse.emf.search.core.parameters.IModelSearchQueryParameters;
import org.eclipse.emf.search.core.scope.IModelSearchScope;

import org.eclipse.emf.search.ecore.helper.builder.AbstractEcoreTextualModelSearchQueryBuilderHelper;
import org.eclipse.emf.search.ecore.regex.ModelSearchQueryTextualExpressionEnum;

import search.evaluators.ModelTextualModelSearchQueryEvaluator;
import search.factories.ModelSearchQueryFactory;
import search.factories.ModelSearchQueryParametersFactory;

public abstract class AbstractTextualModelSearchQueryBuilderHelper extends
		AbstractEcoreTextualModelSearchQueryBuilderHelper {

	protected IModelSearchQueryParameters createParameters(
			IModelSearchScope<Object, Resource> scope,
			List<? extends Object> participants,
			ModelSearchQueryTextualExpressionEnum textualExpression) {

		IModelSearchQueryParameters parameters = ModelSearchQueryParametersFactory
				.getInstance().createSearchQueryParameters();

		parameters
				.setEvaluator(new ModelTextualModelSearchQueryEvaluator<IModelSearchQuery, Object>());
		parameters.setParticipantElements(participants);
		parameters.setScope(scope);

		initTextualQueryParametersFromPatternKind(parameters, textualExpression);

		return parameters;
	}

	protected IModelSearchQuery createQuery(String pattern,
			IModelSearchQueryParameters parameters) {

		return ModelSearchQueryFactory.getInstance().createModelSearchQuery(
				pattern, parameters);
	}
}
