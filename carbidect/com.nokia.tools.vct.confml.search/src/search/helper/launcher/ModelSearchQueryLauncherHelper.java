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

package search.helper.launcher;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.search.core.engine.IModelSearchQuery;
import org.eclipse.emf.search.core.results.IModelSearchResult;
import org.eclipse.emf.search.core.scope.IModelSearchScope;
import org.eclipse.emf.search.ecore.helper.launcher.EcoreModelSearchQueryLauncherHelper;
import org.eclipse.emf.search.ecore.regex.ModelSearchQueryTextualExpressionEnum;

public class ModelSearchQueryLauncherHelper extends
		EcoreModelSearchQueryLauncherHelper

{

	private static ModelSearchQueryLauncherHelper instance;

	// Singleton
	public static ModelSearchQueryLauncherHelper getInstance() {
		return instance == null ? instance = new ModelSearchQueryLauncherHelper()
				: instance;
	}

	//
	// NORMAL TEXT
	//

	public IModelSearchResult launchGlobalTextualconfml1ModelSearchQuery(
			String pattern, IModelSearchScope<Object, Resource> scope) {
		IModelSearchQuery q = buildTextualModelSearchQuery(
				pattern,
				com.nokia.tools.vct.confml.model.confml1.EConfML1Package.eINSTANCE
						.getEClassifiers(),
				ModelSearchQueryTextualExpressionEnum.NORMAL_TEXT, scope,
				"http://www.s60.com/xml/confml/1" //$NON-NLS-1$
		);
		q.run(new NullProgressMonitor());
		return q.getModelSearchResult();
	}

	public IModelSearchResult launchGlobalTextualconfml2ModelSearchQuery(
			String pattern, IModelSearchScope<Object, Resource> scope) {
		IModelSearchQuery q = buildTextualModelSearchQuery(
				pattern,
				com.nokia.tools.vct.confml.model.confml2.EConfML2Package.eINSTANCE
						.getEClassifiers(),
				ModelSearchQueryTextualExpressionEnum.NORMAL_TEXT, scope,
				"http://www.s60.com/xml/confml/2" //$NON-NLS-1$
		);
		q.run(new NullProgressMonitor());
		return q.getModelSearchResult();
	}

	public IModelSearchResult launchGlobalTextualxsdModelSearchQuery(
			String pattern, IModelSearchScope<Object, Resource> scope) {
		IModelSearchQuery q = buildTextualModelSearchQuery(pattern,
				com.nokia.tools.vct.confml.model.xsd.EXSDFacetPackage.eINSTANCE
						.getEClassifiers(),
				ModelSearchQueryTextualExpressionEnum.NORMAL_TEXT, scope,
				"http://www.w3.org/2001/XMLSchema" //$NON-NLS-1$
		);
		q.run(new NullProgressMonitor());
		return q.getModelSearchResult();
	}

	//
	// REGEX
	//

	public IModelSearchResult launchGlobalRegexconfml1ModelSearchQuery(
			String pattern, IModelSearchScope<Object, Resource> scope) {
		IModelSearchQuery q = buildTextualModelSearchQuery(
				pattern,
				com.nokia.tools.vct.confml.model.confml1.EConfML1Package.eINSTANCE
						.getEClassifiers(),
				ModelSearchQueryTextualExpressionEnum.REGULAR_EXPRESSION,
				scope, "http://www.s60.com/xml/confml/1" //$NON-NLS-1$
		);
		q.run(new NullProgressMonitor());
		return q.getModelSearchResult();
	}

	public IModelSearchResult launchGlobalRegexconfml2ModelSearchQuery(
			String pattern, IModelSearchScope<Object, Resource> scope) {
		IModelSearchQuery q = buildTextualModelSearchQuery(
				pattern,
				com.nokia.tools.vct.confml.model.confml2.EConfML2Package.eINSTANCE
						.getEClassifiers(),
				ModelSearchQueryTextualExpressionEnum.REGULAR_EXPRESSION,
				scope, "http://www.s60.com/xml/confml/2" //$NON-NLS-1$
		);
		q.run(new NullProgressMonitor());
		return q.getModelSearchResult();
	}

	public IModelSearchResult launchGlobalRegexxsdModelSearchQuery(
			String pattern, IModelSearchScope<Object, Resource> scope) {
		IModelSearchQuery q = buildTextualModelSearchQuery(pattern,
				com.nokia.tools.vct.confml.model.xsd.EXSDFacetPackage.eINSTANCE
						.getEClassifiers(),
				ModelSearchQueryTextualExpressionEnum.REGULAR_EXPRESSION,
				scope, "http://www.w3.org/2001/XMLSchema" //$NON-NLS-1$
		);
		q.run(new NullProgressMonitor());
		return q.getModelSearchResult();
	}

	//
	// CASE SENSITIVE
	//

	public IModelSearchResult launchGlobalCaseSensitiveconfml1ModelSearchQuery(
			String pattern, IModelSearchScope<Object, Resource> scope) {
		IModelSearchQuery q = buildTextualModelSearchQuery(
				pattern,
				com.nokia.tools.vct.confml.model.confml1.EConfML1Package.eINSTANCE
						.getEClassifiers(),
				ModelSearchQueryTextualExpressionEnum.CASE_SENSITIVE, scope,
				"http://www.s60.com/xml/confml/1" //$NON-NLS-1$
		);
		q.run(new NullProgressMonitor());
		return q.getModelSearchResult();
	}

	public IModelSearchResult launchGlobalCaseSensitiveconfml2ModelSearchQuery(
			String pattern, IModelSearchScope<Object, Resource> scope) {
		IModelSearchQuery q = buildTextualModelSearchQuery(
				pattern,
				com.nokia.tools.vct.confml.model.confml2.EConfML2Package.eINSTANCE
						.getEClassifiers(),
				ModelSearchQueryTextualExpressionEnum.CASE_SENSITIVE, scope,
				"http://www.s60.com/xml/confml/2" //$NON-NLS-1$
		);
		q.run(new NullProgressMonitor());
		return q.getModelSearchResult();
	}

	public IModelSearchResult launchGlobalCaseSensitivexsdModelSearchQuery(
			String pattern, IModelSearchScope<Object, Resource> scope) {
		IModelSearchQuery q = buildTextualModelSearchQuery(pattern,
				com.nokia.tools.vct.confml.model.xsd.EXSDFacetPackage.eINSTANCE
						.getEClassifiers(),
				ModelSearchQueryTextualExpressionEnum.CASE_SENSITIVE, scope,
				"http://www.w3.org/2001/XMLSchema" //$NON-NLS-1$
		);
		q.run(new NullProgressMonitor());
		return q.getModelSearchResult();
	}

}
