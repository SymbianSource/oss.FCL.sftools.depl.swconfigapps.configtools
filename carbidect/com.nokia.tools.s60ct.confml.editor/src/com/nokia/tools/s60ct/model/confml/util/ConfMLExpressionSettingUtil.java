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

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.nokia.tools.s60ct.model.confml.EFeature;
import com.nokia.tools.s60ct.model.confml.ESequenceSetting;
import com.nokia.tools.s60ct.model.confml.ESetting;
import com.nokia.tools.s60ct.model.confml.View;
import com.nokia.tools.vct.common.confml.expressions.ConfMLExpressionsPlugin;

/**
 * Parses setting refs from relevant and constraint attributes of confml setting and feature.
 * 
 */
public class ConfMLExpressionSettingUtil {

	/**
	 * Parses settings ref from relevant attribute of the setting
	 * 
	 * @param setting
	 * @return
	 */
	public static Set<ESetting> getSettingsRefFromRelevant(ESetting setting) {
		String relevant = setting.getRelevant();
		if (relevant != null && !relevant.equals("")) {
			Object ast = ConfMLExpressionsPlugin.compileExpression(relevant);
			List<Object> setttingReferences = ConfMLExpressionsPlugin.getSetttingReferences(ast,
					ConfMLExpressionEvaluationUtil.confmlValuesProvider, setting.getView(), setting);
			Set<ESetting> settingRefs = new HashSet<ESetting>();
			for (int i = 0 ; i < setttingReferences.size() ; i++) {
				Object object = setttingReferences.get(i);
				if (object instanceof ESetting) {
					settingRefs.add((ESetting) object);
				}
			}
			
			return settingRefs;
		}
		return new HashSet<ESetting>();
	}

	/**
	 * Parses settings ref from relevant attribute of the setting
	 * @param view 
	 * 
	 * @param setting
	 * @return
	 */
	public static Set<ESetting> getSettingsRefFromOptionRelevant(View view, ESetting setting,String relevant) {
		if (relevant != null && !relevant.equals("")) {
			Object ast = ConfMLExpressionsPlugin.compileExpression(relevant);
			List<Object> setttingReferences = ConfMLExpressionsPlugin.getSetttingReferences(ast,
					ConfMLExpressionEvaluationUtil.confmlValuesProvider, view, setting);
			Set<ESetting> settingRefs = new HashSet<ESetting>();
			for (int i = 0 ; i < setttingReferences.size() ; i++) {
				Object object = setttingReferences.get(i);
				if (object instanceof ESetting) {
					settingRefs.add((ESetting) object);
				}
			}
			
			return settingRefs;
		}
		return new HashSet<ESetting>();
	}
	
	/**
	 * Parses settings ref from constraint attribute of the setting
	 * 
	 * @param setting
	 * @param expression
	 * @return
	 */
	public static Set<ESetting> getSettingsRefFromConstraint(ESetting setting) {
		String constraint = setting.getConstraint();
		if (constraint != null && !constraint.equals("")) {
			Object ast = ConfMLExpressionsPlugin.compileExpression(constraint);
			List<Object> setttingReferences = ConfMLExpressionsPlugin.getSetttingReferences(ast,
					ConfMLExpressionEvaluationUtil.confmlValuesProvider, setting.getView(), setting);
			Set<ESetting> settingRefs = new HashSet<ESetting>();
			for (int i = 0 ; i < setttingReferences.size() ; i++) {
				Object object = setttingReferences.get(i);
				if (object instanceof ESetting) {
					settingRefs.add((ESetting) object);
				}
			}
			
			return settingRefs;
		}

		return new HashSet<ESetting>();
	}
	
	/**
	 * Parses settings ref from relevant attribute of the feature
	 * 
	 * @param setting
	 * @return
	 */
	public static Set<ESetting> getSettingsRefFromRelevant(EFeature feature) {
		String relevant = feature.getRelevant();
		if (relevant != null && !relevant.equals("")) {
			Object ast = ConfMLExpressionsPlugin.compileExpression(relevant);
			List<Object> setttingReferences = ConfMLExpressionsPlugin.getSetttingReferences(ast,
					ConfMLExpressionEvaluationUtil.confmlValuesProvider, feature.getView(), feature);
			Set<ESetting> settingRefs = new HashSet<ESetting>();
			for (int i = 0 ; i < setttingReferences.size() ; i++) {
				Object object = setttingReferences.get(i);
				if (object instanceof ESetting) {
					settingRefs.add((ESetting) object);
				}
			}
			
			return settingRefs;
		}
		return new HashSet<ESetting>();
	}
	

	public static void setSettingDependencies(View view, ESetting setting) {
		Set<ESetting> constraint = getSettingsRefFromConstraint(setting);
		constraint.addAll(getSettingsRefFromRelevant(setting));
		for (ESetting set : constraint) {
			for (ESetting s : view.getSharedSettingInstances()) {
				if (s instanceof ESequenceSetting) {
					handleSettingDependency(setting, set, s);
					ESequenceSetting ss = (ESequenceSetting)s;
					EList<ESetting> settings = ss.getSubTypes();	
					for (ESetting subSetting : settings) {
						handleSettingDependency(setting, set, subSetting);
					}
					
				} 
				else 
				{
					handleSettingDependency(setting, set, s);
				}
			}
		}
	}

	private static void handleSettingDependency(ESetting handled, ESetting constraint, ESetting searched) {
		
		if (searched.getAbsRef().equals(constraint.getAbsRef()) && !handled.getAbsRef().equals(constraint.getAbsRef())) {
			EList<EObject> dependencies = searched.getDependencies();
			if (dependencies == null) {
				dependencies = new BasicEList<EObject>();
				dependencies.add(handled);
				searched.setDependencies(dependencies);
			} else {
				Iterator<EObject> it = dependencies.iterator();
				boolean found = false;
				while (it.hasNext()) {
					Object next = it.next();
					if (next instanceof ESetting) {
						ESetting nextSetting = (ESetting) next;
						if (nextSetting.getAbsRef().equals(handled.getAbsRef())) {
							found = true;
						}
					}
				}
				if (found == false) {
					dependencies.add(handled);
					searched.setDependencies(dependencies);
				}
			}
		}
	}

	public static void setSettingDependencies(View view, EFeature feature) {
		Set<ESetting> constraint = getSettingsRefFromRelevant(feature);
		for (ESetting set : constraint) {
			for (ESetting s : view.getSharedSettingInstances()) {
				if (s instanceof ESequenceSetting) {
					handleFeatureDependency(feature, set, s);
					EList<ESetting> settings = ((ESequenceSetting) s).getSubTypes();
					for (ESetting subSetting : settings) {
						handleFeatureDependency(feature, set, subSetting);
					}
				} 
				else 
				{
					handleFeatureDependency(feature, set, s);
				}
			}
		}
	}

	private static void handleFeatureDependency(EFeature feature, ESetting constraint, ESetting searched) {
		if (searched.getAbsRef().equals(constraint.getAbsRef())) {
			EList<EObject> dependencies = searched.getDependencies();
			if (dependencies == null) {
				dependencies = new BasicEList<EObject>();
				dependencies.add(feature);
				searched.setDependencies(dependencies);
			} else {
				Iterator<EObject> it = dependencies.iterator();
				boolean found = false;
				while (it.hasNext()) {
					Object next = it.next();
					if (next instanceof EFeature) {
						EFeature f = (EFeature) next;
						if (f.getRef().equals(feature.getRef())) {
							found = true;
						}
					}
				}
				if (found == false) {
					dependencies.add(feature);
					searched.setDependencies(dependencies);
				}
			}
		}
	}
}
