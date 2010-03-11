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

package search.engine;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.search.core.engine.IModelSearchQuery;
import org.eclipse.emf.search.core.eval.IModelSearchQueryEvaluator;
import org.eclipse.emf.search.core.parameters.IModelSearchQueryParameters;
import org.eclipse.emf.search.core.results.IModelResultEntry;
import org.eclipse.emf.search.ecore.engine.EcoreMetaModelIntrospector;
import org.eclipse.emf.search.ecore.engine.EcoreModelSearchQuery;
import org.eclipse.emf.search.ecore.results.EcoreModelSearchResultEntry;
import org.eclipse.emf.search.ecore.utils.EcoreModelLoaderUtil;

import search.Activator;
import search.evaluators.ModelTextualModelSearchQueryEvaluator;
import search.l10n.Messages;

import com.nokia.tools.vct.confml.model.confml1.EConfML1Package;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Package;
import com.nokia.tools.vct.confml.model.xsd.EXSDFacetPackage;

/**
 * Gather all model search settings to run a specific query.
 * IMPROVEMENT: the name of the class and its file should include modelName
 * 
 */
public final class ModelSearchQuery extends EcoreModelSearchQuery {
	public final static String ConfML1_MODEL_SEARCH_IMAGE_PATH = "icons/esearch.gif"; //$NON-NLS-1$
	public final static String ConfML1_MODEL_SEARCH_RESULT_IMAGE_PATH = "icons/esearch.gif"; //$NON-NLS-1$

	final static class ConfML1SupportedElements {
		private static List<EClassifier> getConfML1EClassifiersLiterals() {
			List<EClassifier> eclassifiersLiteralsList = new ArrayList<EClassifier>();

			try {

				for (Object o : EConfML1Package.eINSTANCE.getEClassifiers()) {
					if (o instanceof ENamedElement) {
						eclassifiersLiteralsList.add((EClassifier) o);
					}
				}
				for (Object o : EConfML2Package.eINSTANCE.getEClassifiers()) {
					if (o instanceof ENamedElement) {
						eclassifiersLiteralsList.add((EClassifier) o);
					}
				}

				for (Object o : EXSDFacetPackage.eINSTANCE.getEClassifiers()) {
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
												.getString("ModelSearchQuery.ConfML1ClassifiersWalkErrorMessage"), t)); //$NON-NLS-1$
			}

			return eclassifiersLiteralsList;
		}

		public static List<EClassifier> getSupportedElements(
				List<? extends Object> participantEClassList) {
			ArrayList<EClassifier> definitiveMetaElementParticipantList = new ArrayList<EClassifier>();
			for (EClassifier eClass : getConfML1EClassifiersLiterals()) {
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
		return ConfML1_MODEL_SEARCH_IMAGE_PATH;
	}

	@Override
	public String getResultImagePath() {
		return ConfML1_MODEL_SEARCH_RESULT_IMAGE_PATH;
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
							ConfML1SupportedElements
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
							ConfML1SupportedElements
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
		//IMPROVEMENT: get the name of evalutar's class compound of modelName and string "TextualModelSearchQueryEvaluator"
		return evaluator != null ? evaluator
				: (evaluator = new ModelTextualModelSearchQueryEvaluator<IModelSearchQuery, Object>());
	}

	@Override
	public String getName() {
		switch (getKind()) {
		case NORMAL_TEXT:
			return Messages
					.getString("ConfML1ModelSearchQuery.NormalTextMessage"); //$NON-NLS-1$
		case CASE_SENSITIVE:
			return Messages
					.getString("ConfML1ModelSearchQuery.CaseSensitiveMessage"); //$NON-NLS-1$
		case REGULAR_EXPRESSION:
			return Messages
					.getString("ConfML1ModelSearchQuery.RegularExpressionMessage"); //$NON-NLS-1$
		}

		return Messages
				.getString("ConfML1ModelSearchQuery.DefaultSearchKindMessage"); //$NON-NLS-1$
	}
}
