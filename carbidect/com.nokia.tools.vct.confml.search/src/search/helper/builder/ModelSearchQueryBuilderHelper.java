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

package search.helper.builder;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.search.core.engine.IModelSearchQuery;
import org.eclipse.emf.search.core.parameters.IModelSearchQueryParameters;
import org.eclipse.emf.search.core.scope.IModelSearchScope;
import org.eclipse.emf.search.ecore.regex.ModelSearchQueryTextualExpressionEnum;

import search.evaluators.ModelTextualModelSearchQueryEvaluator;
import search.factories.ModelSearchQueryFactory;
import search.factories.ModelSearchQueryParametersFactory;

public class ModelSearchQueryBuilderHelper extends
		AbstractTextualModelSearchQueryBuilderHelper

{

	private static ModelSearchQueryBuilderHelper instance;

	// Singleton
	public static ModelSearchQueryBuilderHelper getInstance() {
		return instance == null ? instance = new ModelSearchQueryBuilderHelper()
				: instance;
	}

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

	public IModelSearchQuery buildGlobalTextualconfml1ModelSearchQuery(
			String expr, IModelSearchScope<Object, Resource> scope) {
		return buildTextualModelSearchQuery(
				expr,
				com.nokia.tools.vct.confml.model.confml1.EConfML1Package.eINSTANCE
						.getEClassifiers(),
				ModelSearchQueryTextualExpressionEnum.NORMAL_TEXT, scope,
				"http://www.s60.com/xml/confml/1" //$NON-NLS-1$
		);
	}

	public IModelSearchQuery buildGlobalTextualconfml2ModelSearchQuery(
			String expr, IModelSearchScope<Object, Resource> scope) {
		return buildTextualModelSearchQuery(
				expr,
				com.nokia.tools.vct.confml.model.confml2.EConfML2Package.eINSTANCE
						.getEClassifiers(),
				ModelSearchQueryTextualExpressionEnum.NORMAL_TEXT, scope,
				"http://www.s60.com/xml/confml/2" //$NON-NLS-1$
		);
	}

	public IModelSearchQuery buildGlobalTextualxsdModelSearchQuery(String expr,
			IModelSearchScope<Object, Resource> scope) {
		return buildTextualModelSearchQuery(expr,
				com.nokia.tools.vct.confml.model.xsd.EXSDFacetPackage.eINSTANCE
						.getEClassifiers(),
				ModelSearchQueryTextualExpressionEnum.NORMAL_TEXT, scope,
				"http://www.w3.org/2001/XMLSchema" //$NON-NLS-1$
		);
	}

	public IModelSearchQuery buildGlobalRegexconfml1ModelSearchQuery(
			String expr, IModelSearchScope<Object, Resource> scope) {
		return buildTextualModelSearchQuery(
				expr,
				com.nokia.tools.vct.confml.model.confml1.EConfML1Package.eINSTANCE
						.getEClassifiers(),
				ModelSearchQueryTextualExpressionEnum.REGULAR_EXPRESSION,
				scope, "http://www.s60.com/xml/confml/1" //$NON-NLS-1$
		);
	}

	public IModelSearchQuery buildGlobalRegexconfml2ModelSearchQuery(
			String expr, IModelSearchScope<Object, Resource> scope) {
		return buildTextualModelSearchQuery(
				expr,
				com.nokia.tools.vct.confml.model.confml2.EConfML2Package.eINSTANCE
						.getEClassifiers(),
				ModelSearchQueryTextualExpressionEnum.REGULAR_EXPRESSION,
				scope, "http://www.s60.com/xml/confml/2" //$NON-NLS-1$
		);
	}

	public IModelSearchQuery buildGlobalRegexxsdModelSearchQuery(String expr,
			IModelSearchScope<Object, Resource> scope) {
		return buildTextualModelSearchQuery(expr,
				com.nokia.tools.vct.confml.model.xsd.EXSDFacetPackage.eINSTANCE
						.getEClassifiers(),
				ModelSearchQueryTextualExpressionEnum.REGULAR_EXPRESSION,
				scope, "http://www.w3.org/2001/XMLSchema" //$NON-NLS-1$
		);
	}

	public IModelSearchQuery buildGlobalCaseSensitiveconfml1ModelSearchQuery(
			String expr, IModelSearchScope<Object, Resource> scope) {
		return buildTextualModelSearchQuery(
				expr,
				com.nokia.tools.vct.confml.model.confml1.EConfML1Package.eINSTANCE
						.getEClassifiers(),
				ModelSearchQueryTextualExpressionEnum.CASE_SENSITIVE, scope,
				"http://www.s60.com/xml/confml/1" //$NON-NLS-1$
		);
	}

	public IModelSearchQuery buildGlobalCaseSensitiveconfml2ModelSearchQuery(
			String expr, IModelSearchScope<Object, Resource> scope) {
		return buildTextualModelSearchQuery(
				expr,
				com.nokia.tools.vct.confml.model.confml2.EConfML2Package.eINSTANCE
						.getEClassifiers(),
				ModelSearchQueryTextualExpressionEnum.CASE_SENSITIVE, scope,
				"http://www.s60.com/xml/confml/2" //$NON-NLS-1$
		);
	}

	public IModelSearchQuery buildGlobalCaseSensitivexsdModelSearchQuery(
			String expr, IModelSearchScope<Object, Resource> scope) {
		return buildTextualModelSearchQuery(expr,
				com.nokia.tools.vct.confml.model.xsd.EXSDFacetPackage.eINSTANCE
						.getEClassifiers(),
				ModelSearchQueryTextualExpressionEnum.CASE_SENSITIVE, scope,
				"http://www.w3.org/2001/XMLSchema" //$NON-NLS-1$
		);
	}

	public IModelSearchQuery buildGlobalTextualModelSearchQuery(String pattern,
			IModelSearchScope<Object, Resource> scope, String nsURI) {

		if (nsURI.equals("http://www.s60.com/xml/confml/1")) { //$NON-NLS-1$
			return buildGlobalTextualconfml1ModelSearchQuery(pattern, scope);
		}
		if (nsURI.equals("http://www.s60.com/xml/confml/2")) { //$NON-NLS-1$
			return buildGlobalTextualconfml2ModelSearchQuery(pattern, scope);
		}

		if (nsURI.equals("http://www.w3.org/2001/XMLSchema")) { //$NON-NLS-1$
			return buildGlobalTextualxsdModelSearchQuery(pattern, scope);
		}

		return null;
	}

	public IModelSearchQuery buildGlobalRegexModelSearchQuery(String pattern,
			IModelSearchScope<Object, Resource> scope, String nsURI) {

		if (nsURI.equals("http://www.s60.com/xml/confml/1")) { //$NON-NLS-1$
			return buildGlobalRegexconfml1ModelSearchQuery(pattern, scope);
		}
		if (nsURI.equals("http://www.s60.com/xml/confml/2")) { //$NON-NLS-1$
			return buildGlobalRegexconfml2ModelSearchQuery(pattern, scope);
		}

		if (nsURI.equals("http://www.w3.org/2001/XMLSchema")) { //$NON-NLS-1$
			return buildGlobalRegexxsdModelSearchQuery(pattern, scope);
		}

		return null;
	}

	public IModelSearchQuery buildGlobalCaseSensitiveModelSearchQuery(
			String pattern, IModelSearchScope<Object, Resource> scope,
			String nsURI) {

		if (nsURI.equals("http://www.s60.com/xml/confml/1")) { //$NON-NLS-1$
			return buildGlobalCaseSensitiveconfml1ModelSearchQuery(pattern,
					scope);
		}
		if (nsURI.equals("http://www.s60.com/xml/confml/2")) { //$NON-NLS-1$
			return buildGlobalCaseSensitiveconfml2ModelSearchQuery(pattern,
					scope);
		}

		if (nsURI.equals("http://www.w3.org/2001/XMLSchema")) { //$NON-NLS-1$
			return buildGlobalCaseSensitivexsdModelSearchQuery(pattern, scope);
		}

		return null;
	}
}
