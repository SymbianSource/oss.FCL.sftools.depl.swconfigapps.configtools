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
 * Description: This file is part of com.nokia.tools.variant.editor component.
 */

package com.nokia.tools.s60ct.model.confml.util;


import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.nokia.tools.s60ct.model.confml.EFeature;
import com.nokia.tools.s60ct.model.confml.EResourceSetting;
import com.nokia.tools.s60ct.model.confml.ESequenceSetting;
import com.nokia.tools.s60ct.model.confml.ESetting;
import com.nokia.tools.s60ct.model.confml.ESettingOption;
import com.nokia.tools.s60ct.model.confml.ESimpleSetting;
import com.nokia.tools.s60ct.model.confml.ESimpleValue;
import com.nokia.tools.s60ct.model.confml.View;
import com.nokia.tools.vct.common.confml.expressions.ConfMLExpressionsPlugin;
import com.nokia.tools.vct.common.confml.expressions.IConfMLSettingValuesProvider;

/**
 * Evaluates relevant and constraint attributes of confml setting and in future
 * also relevant attribute of confml feature
 * 
 */
public class ConfMLExpressionEvaluationUtil {

	public static final IConfMLSettingValuesProvider confmlValuesProvider = new IConfMLSettingValuesProvider() {

		public String getValue(Object object) {
			if (object instanceof ESimpleSetting) {
				ESimpleSetting simple = (ESimpleSetting) object;
				return ((ESimpleValue)simple.getValue()).getValue();
			} 
			else if (object instanceof EResourceSetting)
			{
				EResourceSetting resSetting = (EResourceSetting)object;
				((ESimpleValue)resSetting.getTargetPath().getValue()).getValue();
			}
			else
			{
				System.out.println("Unimplemented type in getValue");
			}

			return null;
		}

		public Object getSubItem(Object object, int index) {
			if (object instanceof ESequenceSetting) {
				ESequenceSetting ss = (ESequenceSetting) object;
				EList<ESetting> settings = ss.getSubTypes();
				return settings.get(index - 1);
				//EList<SequenceItem> sequenceItems = ss.getSequenceItem();
				//return sequenceItems.get(index - 1);
			}
			return null;
		}

		public Object getSubItem(Object object, String ref) {
			if (object instanceof View) 
			{
				View view = (View) object;
				EList<EFeature> sharedFeatures = view.getSharedFeatures();
				for (int i = 0; i < sharedFeatures.size(); i++) {
					EFeature feature = sharedFeatures.get(i);
					if (ref.equals(feature.getRef())) {
						return feature;
					}
				}
			} 
		    else if (object instanceof EFeature)
			{
				EFeature feature = (EFeature) object;
				String featureRef = feature.getRef();
				//View view = feature.getView();
				String absRef = featureRef + "/" + ref;
				//EList<ESetting> sharedSettingInstances = view.getSharedSettingInstances();
				EList<ESetting> sharedSettingInstances = feature.getSettings();
				for (int i = 0; i < sharedSettingInstances.size(); i++) {
					ESetting setting = sharedSettingInstances.get(i);
					if (setting.getAbsRef().equals(absRef)) {
						return setting;
					}
				}
			} 
		    else
		    {
		    	System.out.println("Unimplemented type in getSubItem");
		    }
			return null;
		}

		public Object getParentItem(Object object) {
			if (object instanceof EObject) {
				EObject eobject = (EObject) object;
				EObject container = eobject.eContainer();
				if (eobject instanceof ESetting) {
					ESetting s = (ESetting) eobject;
					String featureRef = s.getAbsRef().split("/")[0];
					if (container instanceof View)
					{
						View view = (View) container;
						EList<EFeature> sharedFeatures = view
								.getSharedFeatures();
						for (int i = 0; i < sharedFeatures.size(); i++) {
							EFeature feature = sharedFeatures.get(i);
							if (feature.getRef().equals(featureRef)) {
								return feature;
							}
						}
					} 
					else 
					{
						return container;
					}
				} else {
					return container;
				}
			}
			return null;
		}
	};

	public static boolean evaluateSettingRelevant(ESetting setting) {
		if (setting.getRelevant() == null || setting.getRelevant().equals("")) {
			return true;
		}
		// System.out.println(setting.getRelevant());
		Object relevantAST = setting.getRelevantAST();
		if (relevantAST == null) {// precompute AST
			relevantAST = ConfMLExpressionsPlugin.compileExpression(setting
					.getRelevant());
			setting.setRelevantAST(relevantAST);
		}

		return ConfMLExpressionsPlugin.evaluateBooleanExpression(
				relevantAST, confmlValuesProvider, setting.getView(), setting);
	}

//	public static boolean evaluateSettingConstraint(ESetting setting) {
//		if (setting.getConstraint() == null
//				|| setting.getConstraint().equals("")) {
//			return true;
//		}
//		// System.out.println(setting.getConstraint());
//		Object constraintAST = setting.getConstraintAST();
//		if (constraintAST == null) {// precompute AST
//			constraintAST = ConfMLExpressionsPlugin.compileExpression(setting
//					.getConstraint());
//			setting.setConstraintAST(constraintAST);
//		}
//
//		return ConfMLExpressionsPlugin.evaluateBooleanExpression(
//				constraintAST, confmlValuesProvider, setting
//						.getView(), setting);
//	}

	public static boolean evaluateFeatureRelevant(EFeature feature) {
		if (feature.getRelevant() == null || feature.getRelevant().equals("")) {
			return true;
		}
		// System.out.println(feature.getRelevant());

		Object relevantAST = feature.getRelevantAST();
		if (relevantAST == null) {// precompute AST
			relevantAST = ConfMLExpressionsPlugin.compileExpression(feature
					.getRelevant());
			feature.setRelevantAST(relevantAST);
		}

		return ConfMLExpressionsPlugin.evaluateBooleanExpression(relevantAST,
				confmlValuesProvider, feature.getView(), feature);
	}

	/**
	 * Method computes relevant expression for given option.
	 * 
	 * @param option
	 * @return true whether evaluation passed otherwise result is false
	 */
	public static boolean evaluateOptionRelevant(ESettingOption option) {
		if (option.getRelevant() == null || option.getRelevant().equals("")) {
			option.setComputedRelevant(true);
			return true;
		}
		// System.out.println(setting.getRelevant());
		Object relevantAST = option.getRelevantAST();
		if (relevantAST == null) {// precompute AST
			relevantAST = ConfMLExpressionsPlugin.compileExpression(option
					.getRelevant());
			if (relevantAST == null) {
				option.setComputedRelevant(false);
				return false;
			}
			option.setRelevantAST(relevantAST);
		}

		if (relevantAST == null) {
			option.setComputedRelevant(false);
			return false;
		}

		EObject parent = option.eContainer();
		if (parent instanceof ESetting)
		{
			boolean retVal = ConfMLExpressionsPlugin.evaluateBooleanExpression(
					relevantAST, confmlValuesProvider,((ESetting) parent).getView(), parent);
			option.setComputedRelevant(retVal);
			return retVal;
		} 
		else
		{
			option.setComputedRelevant(false);
			return false;
		}
	}

}
