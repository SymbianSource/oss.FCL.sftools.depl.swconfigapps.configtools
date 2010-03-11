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
package search.evaluators;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.search.core.engine.IModelSearchQuery;
import org.eclipse.emf.search.ecore.engine.EcoreModelSearchQuery;
import org.eclipse.emf.search.ecore.evaluators.EcoreTextualModelSearchQueryEvaluator;
import org.eclipse.emf.search.ecore.regex.ModelSearchQueryTextualExpressionEnum;
import org.eclipse.emf.search.ecore.regex.ModelSearchQueryTextualExpressionMatchingHelper;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.ETypedElement;

import search.util.TextualFeaturesUtils;

import search.l10n.Messages;

public final class ModelTextualModelSearchQueryEvaluator<Q extends IModelSearchQuery, T>
		extends EcoreTextualModelSearchQueryEvaluator<Q, T> {

	@Override
	public List<?> eval(Q query, T target, boolean notification) {
		List<Object> results = new ArrayList<Object>();
		if (query instanceof EcoreModelSearchQuery) {
			ModelSearchQueryTextualExpressionEnum kind = ((EcoreModelSearchQuery) query)
					.getKind();
			String text = query.getQueryExpression();
			text = (text == "" && kind == ModelSearchQueryTextualExpressionEnum.NORMAL_TEXT) ? "*" : text; //$NON-NLS-1$ //$NON-NLS-2$

			// discriminating according to participant meta elements selection
			for (Object o : query.getValidParticipantMetaElements()) {
				// In order to avoid duplicate results, the current element should be contained 
				// by the current resource
				if (target instanceof Resource) {
					if (o instanceof EObject) {
						Resource r = ((EObject) o).eResource();
						if (r instanceof Resource
								&& r.getURI().equals(
										((Resource) target).getURI())) {
							EObject eObj = (EObject) o;
							if (TextualFeaturesUtils.instance()
									.getTextFromEStructuralFeatureIfAny(eObj) != null) {
								for (ETypedElement elem : TextualFeaturesUtils
										.instance()
										.getOwnedETypedElementsFromEObject(eObj)) {
									String elementName = TextualFeaturesUtils
											.instance()
											.getTextFromETypedElement(eObj,
													elem);
									if (elementName != null
											&& ModelSearchQueryTextualExpressionMatchingHelper
													.getInstance().lookAt(
															elementName, text,
															kind)) {
										results.add(query
												.processSearchResultMatching(
														target, eObj,
														notification));
									}
								}
							}
						}
					}
				}
			}
		}
		return results;
	}

	@Override
	public String getLabel() {
		return Messages
				.getString("ModelTextualModelSearchQueryEvaluator.Label"); //$NON-NLS-1$
	}
}
