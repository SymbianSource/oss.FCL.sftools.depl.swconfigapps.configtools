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

	public IModelSearchResult launchGlobalTextualcrmodelModelSearchQuery(
			String pattern, IModelSearchScope<Object, Resource> scope) {
		IModelSearchQuery q = buildTextualModelSearchQuery(pattern,
				com.nokia.tools.vct.crml.crmodel.ECRMLPackage.eINSTANCE
						.getEClassifiers(),
				ModelSearchQueryTextualExpressionEnum.NORMAL_TEXT, scope,
				"http://www.s60.com/xml/cenrep/1" //$NON-NLS-1$
		);
		q.run(new NullProgressMonitor());
		return q.getModelSearchResult();
	}

	//
	// REGEX
	//

	public IModelSearchResult launchGlobalRegexcrmodelModelSearchQuery(
			String pattern, IModelSearchScope<Object, Resource> scope) {
		IModelSearchQuery q = buildTextualModelSearchQuery(pattern,
				com.nokia.tools.vct.crml.crmodel.ECRMLPackage.eINSTANCE
						.getEClassifiers(),
				ModelSearchQueryTextualExpressionEnum.REGULAR_EXPRESSION,
				scope, "http://www.s60.com/xml/cenrep/1" //$NON-NLS-1$
		);
		q.run(new NullProgressMonitor());
		return q.getModelSearchResult();
	}

	//
	// CASE SENSITIVE
	//

	public IModelSearchResult launchGlobalCaseSensitivecrmodelModelSearchQuery(
			String pattern, IModelSearchScope<Object, Resource> scope) {
		IModelSearchQuery q = buildTextualModelSearchQuery(pattern,
				com.nokia.tools.vct.crml.crmodel.ECRMLPackage.eINSTANCE
						.getEClassifiers(),
				ModelSearchQueryTextualExpressionEnum.CASE_SENSITIVE, scope,
				"http://www.s60.com/xml/cenrep/1" //$NON-NLS-1$
		);
		q.run(new NullProgressMonitor());
		return q.getModelSearchResult();
	}

}
