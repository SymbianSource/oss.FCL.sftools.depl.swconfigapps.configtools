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
package search.ui.pages;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.search.core.internal.replace.provisional.ITransformation;
import org.eclipse.emf.search.core.internal.replace.provisional.NullModelSearchTransformation;
import org.eclipse.emf.search.core.engine.IModelSearchQuery;
import org.eclipse.emf.search.core.results.IModelResultEntry;
import org.eclipse.emf.search.ui.pages.AbstractModelSearchPage;

import search.replace.TextualReplaceTransformation;
import search.util.TextualFeaturesUtils;

public final class ModelSearchPage extends AbstractModelSearchPage {

	@Override
	protected String getModelSearchPageID() {
		return "search.ui.pages.CRMLModelModelSearchPageID"; //$NON-NLS-1$
	}

	public String getOccurenceLabel(IModelResultEntry entry) {
		return entry.getSource() instanceof EObject ? TextualFeaturesUtils
				.instance().getTextFromEStructuralFeatureIfAny(
						(EObject) entry.getSource()) : "ERROR"; //$NON-NLS-1$
	}

	@Override
	public ITransformation<EObject, IModelSearchQuery, String, String> getTransformation(
			EObject element, IModelSearchQuery query, String value) {
		return TextualFeaturesUtils.instance()
				.getTextFromEStructuralFeatureIfAny(element) != null ? new TextualReplaceTransformation(
				(EObject) element, query, value)
				: new NullModelSearchTransformation();
	}
}
