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
package search.engine;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.search.core.engine.IModelSearchQuery;
import org.eclipse.emf.search.core.eval.IModelSearchQueryEvaluator;
import org.eclipse.emf.search.core.parameters.IModelSearchQueryParameters;
import org.eclipse.emf.search.core.results.IModelResultEntry;
import org.eclipse.emf.search.ecore.engine.EcoreMetaModelIntrospector;
import org.eclipse.emf.search.ecore.engine.EcoreModelSearchQuery;
import org.eclipse.emf.search.ecore.results.EcoreModelSearchResultEntry;
import org.eclipse.emf.search.ecore.utils.EcoreModelLoaderUtil;

import search.Activator;
import search.l10n.Messages;
import search.evaluators.ModelTextualModelSearchQueryEvaluator;

import com.nokia.tools.vct.crml.crmodel.ECRMLPackage;

/**
 * Gather all model search settings to run a specific query.
 * - the name of the class and its file should include modelName
 * 
 */
public final class ModelSearchQuery extends EcoreModelSearchQuery {
	public final static String CRMLModel_MODEL_SEARCH_IMAGE_PATH = "icons/esearch.gif"; //$NON-NLS-1$
	public final static String CRMLModel_MODEL_SEARCH_RESULT_IMAGE_PATH = "icons/esearch.gif"; //$NON-NLS-1$

	final static class CRMLModelSupportedElements {
		private static List<EClassifier> getCRMLModelEClassifiersLiterals() {
			List<EClassifier> eclassifiersLiteralsList = new ArrayList<EClassifier>();

			try {

				for (Object o : ECRMLPackage.eINSTANCE.getEClassifiers()) {
					if (o instanceof ENamedElement) {
						eclassifiersLiteralsList.add((EClassifier) o);
					}
				}

			} catch (Throwable t) {
				Activator
						.getDefault()
						.getLog()
						.log(
								new Status(
										IStatus.ERROR,
										Activator.PLUGIN_ID,
										0,
										Messages
												.getString("ModelSearchQuery.CRMLModelClassifiersWalkErrorMessage"), t)); //$NON-NLS-1$
			}

			return eclassifiersLiteralsList;
		}

		public static List<EClassifier> getSupportedElements(
				List<? extends Object> participantEClassList) {
			ArrayList<EClassifier> definitiveMetaElementParticipantList = new ArrayList<EClassifier>();
			for (EClassifier eClass : getCRMLModelEClassifiersLiterals()) {
				if (participantEClassList.contains(eClass)) {
					definitiveMetaElementParticipantList.add(eClass);
				}
			}
			return definitiveMetaElementParticipantList;
		}
	}

	public ModelSearchQuery(String expr, IModelSearchQueryParameters parameters) {
		super(expr, parameters);
	}

	@Override
	public String getQueryImagePath() {
		return CRMLModel_MODEL_SEARCH_IMAGE_PATH;
	}

	@Override
	public String getResultImagePath() {
		return CRMLModel_MODEL_SEARCH_RESULT_IMAGE_PATH;
	}

	@Override
	public String getBundleSymbolicName() {
		return Activator.getDefault().getBundle().getSymbolicName();
	}

	@Override
	public IStatus search(Object resource, boolean notify) {
		try {
			EObject root = EcoreModelLoaderUtil.openFile(resource, false);

			validParticipantMetaElements = EcoreMetaModelIntrospector
					.discriminateValidMetaElements((EObject) root,
							CRMLModelSupportedElements
									.getSupportedElements(participantElements));

			((IModelSearchQueryEvaluator<IModelSearchQuery, Object>) getEvaluator())
					.eval(this, resource, notify);
		} catch (Exception e) {
			return Status.CANCEL_STATUS;
		}
		return Status.OK_STATUS;
	}

	public IStatus search(Object resource, boolean notify,
			IProgressMonitor monitor) {
		try {
			if (monitor.isCanceled()) {
				return Status.CANCEL_STATUS;
			}

			EObject root = EcoreModelLoaderUtil.openFile(resource, false);

			if (monitor.isCanceled()) {
				return Status.CANCEL_STATUS;
			}

			validParticipantMetaElements = EcoreMetaModelIntrospector
					.discriminateValidMetaElements((EObject) root,
							CRMLModelSupportedElements
									.getSupportedElements(participantElements));

			if (monitor.isCanceled()) {
				return Status.CANCEL_STATUS;
			}

			((IModelSearchQueryEvaluator<IModelSearchQuery, Object>) getEvaluator())
					.eval(this, resource, notify);

			monitor.setTaskName(getLabel());

			if (monitor.isCanceled()) {
				return Status.CANCEL_STATUS;
			}
		} catch (Exception e) {
			return Status.CANCEL_STATUS;
		}
		return Status.OK_STATUS;
	}

	// Recursively build EObject containment hierarchy
	private IModelResultEntry buildSearchResultEntryHierarchy(
			IModelResultEntry intermediate, Object resource, EObject current,
			EObject leaf) {
		if (current instanceof EObject) {
			IModelResultEntry entryContainer = new EcoreModelSearchResultEntry(
					null, resource, current, false);
			entryContainer.addChildren(intermediate);
			intermediate.setParent(entryContainer);
			return buildSearchResultEntryHierarchy(entryContainer, resource,
					current.eContainer(), leaf);
		} else {
			return intermediate;
		}
	}

	@Override
	public IModelSearchQueryEvaluator<IModelSearchQuery, ?> getEvaluator() {
		evaluator = getModelSearchParameters().getEvaluator();
		//get the name of evalutar's class compound of modelName and string "TextualModelSearchQueryEvaluator"
		return evaluator != null ? evaluator
				: (evaluator = new ModelTextualModelSearchQueryEvaluator<IModelSearchQuery, Object>());
	}

	@Override
	public String getName() {
		switch (getKind()) {
		case NORMAL_TEXT:
			return Messages
					.getString("CRMLModelModelSearchQuery.NormalTextMessage"); //$NON-NLS-1$
		case CASE_SENSITIVE:
			return Messages
					.getString("CRMLModelModelSearchQuery.CaseSensitiveMessage"); //$NON-NLS-1$
		case REGULAR_EXPRESSION:
			return Messages
					.getString("CRMLModelModelSearchQuery.RegularExpressionMessage"); //$NON-NLS-1$
		}

		return Messages
				.getString("CRMLModelModelSearchQuery.DefaultSearchKindMessage"); //$NON-NLS-1$
	}
}
