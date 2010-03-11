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
 * Description: This file is part of com.nokia.tools.vct.confml.editor.view component.
 */

package com.nokia.tools.vct.confml.editor.view.vemodel.util;

import com.nokia.tools.vct.confml.editor.view.vemodel.*;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.nokia.tools.vct.confml.editor.view.vemodel.EDescriptionContainer;
import com.nokia.tools.vct.confml.editor.view.vemodel.EFeature;
import com.nokia.tools.vct.confml.editor.view.vemodel.EGroup;
import com.nokia.tools.vct.confml.editor.view.vemodel.EGroupContainer;
import com.nokia.tools.vct.confml.editor.view.vemodel.EIconContainer;
import com.nokia.tools.vct.confml.editor.view.vemodel.ERefOption;
import com.nokia.tools.vct.confml.editor.view.vemodel.ERefProperty;
import com.nokia.tools.vct.confml.editor.view.vemodel.ERefTarget;
import com.nokia.tools.vct.confml.editor.view.vemodel.EResourceLocator;
import com.nokia.tools.vct.confml.editor.view.vemodel.ESetting;
import com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef;
import com.nokia.tools.vct.confml.editor.view.vemodel.EView;
import com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage;
import com.nokia.tools.vct.confml.editor.view.vemodel.EViewsEditorDocument;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage
 * @generated
 */
public class EViewEditorSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EViewEditorPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EViewEditorSwitch() {
		if (modelPackage == null) {
			modelPackage = EViewEditorPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case EViewEditorPackage.EVIEWS_EDITOR_DOCUMENT: {
				EViewsEditorDocument eViewsEditorDocument = (EViewsEditorDocument)theEObject;
				T result = caseEViewsEditorDocument(eViewsEditorDocument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EViewEditorPackage.EVIEW: {
				EView eView = (EView)theEObject;
				T result = caseEView(eView);
				if (result == null) result = caseEDescriptionContainer(eView);
				if (result == null) result = caseEIconContainer(eView);
				if (result == null) result = caseEGroupEntry(eView);
				if (result == null) result = caseEGroupContainer(eView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EViewEditorPackage.EGROUP: {
				EGroup eGroup = (EGroup)theEObject;
				T result = caseEGroup(eGroup);
				if (result == null) result = caseEDescriptionContainer(eGroup);
				if (result == null) result = caseEIconContainer(eGroup);
				if (result == null) result = caseEGroupEntry(eGroup);
				if (result == null) result = caseEGroupContainer(eGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EViewEditorPackage.EGROUP_CONTAINER: {
				EGroupContainer eGroupContainer = (EGroupContainer)theEObject;
				T result = caseEGroupContainer(eGroupContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EViewEditorPackage.ESETTING_REF: {
				ESettingRef eSettingRef = (ESettingRef)theEObject;
				T result = caseESettingRef(eSettingRef);
				if (result == null) result = caseEDescriptionContainer(eSettingRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EViewEditorPackage.EFEATURE: {
				EFeature eFeature = (EFeature)theEObject;
				T result = caseEFeature(eFeature);
				if (result == null) result = caseEDescriptionContainer(eFeature);
				if (result == null) result = caseEResourceLocator(eFeature);
				if (result == null) result = caseERefTarget(eFeature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EViewEditorPackage.ESETTING_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<String, ESetting> eSettingEntry = (Map.Entry<String, ESetting>)theEObject;
				T result = caseESettingEntry(eSettingEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EViewEditorPackage.EDESCRIPTION_CONTAINER: {
				EDescriptionContainer eDescriptionContainer = (EDescriptionContainer)theEObject;
				T result = caseEDescriptionContainer(eDescriptionContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EViewEditorPackage.EICON_CONTAINER: {
				EIconContainer eIconContainer = (EIconContainer)theEObject;
				T result = caseEIconContainer(eIconContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EViewEditorPackage.ERESOURCE_LOCATOR: {
				EResourceLocator eResourceLocator = (EResourceLocator)theEObject;
				T result = caseEResourceLocator(eResourceLocator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EViewEditorPackage.EREF_TARGET: {
				ERefTarget eRefTarget = (ERefTarget)theEObject;
				T result = caseERefTarget(eRefTarget);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EViewEditorPackage.EFEATURE_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<String, EFeature> eFeatureEntry = (Map.Entry<String, EFeature>)theEObject;
				T result = caseEFeatureEntry(eFeatureEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EViewEditorPackage.ESETTING: {
				ESetting eSetting = (ESetting)theEObject;
				T result = caseESetting(eSetting);
				if (result == null) result = caseEDescriptionContainer(eSetting);
				if (result == null) result = caseEResourceLocator(eSetting);
				if (result == null) result = caseERefTarget(eSetting);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EViewEditorPackage.EVIEW_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<String, EView> eViewEntry = (Map.Entry<String, EView>)theEObject;
				T result = caseEViewEntry(eViewEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EViewEditorPackage.EREF_PROPERTY: {
				ERefProperty eRefProperty = (ERefProperty)theEObject;
				T result = caseERefProperty(eRefProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EViewEditorPackage.EREF_OPTION: {
				ERefOption eRefOption = (ERefOption)theEObject;
				T result = caseERefOption(eRefOption);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EViewEditorPackage.EGROUP_ENTRY: {
				EGroupEntry eGroupEntry = (EGroupEntry)theEObject;
				T result = caseEGroupEntry(eGroupEntry);
				if (result == null) result = caseEGroupContainer(eGroupEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EViews Editor Document</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EViews Editor Document</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEViewsEditorDocument(EViewsEditorDocument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EView</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EView</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEView(EView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EGroup</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EGroup</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEGroup(EGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EGroup Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EGroup Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEGroupContainer(EGroupContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ESetting Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ESetting Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseESettingRef(ESettingRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EFeature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EFeature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEFeature(EFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ESetting Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ESetting Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseESettingEntry(Map.Entry<String, ESetting> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EDescription Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EDescription Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEDescriptionContainer(EDescriptionContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EIcon Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EIcon Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEIconContainer(EIconContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EResource Locator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EResource Locator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEResourceLocator(EResourceLocator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ERef Target</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ERef Target</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseERefTarget(ERefTarget object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EFeature Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EFeature Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEFeatureEntry(Map.Entry<String, EFeature> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ESetting</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ESetting</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseESetting(ESetting object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EView Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EView Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEViewEntry(Map.Entry<String, EView> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ERef Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ERef Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseERefProperty(ERefProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ERef Option</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ERef Option</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseERefOption(ERefOption object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EGroup Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EGroup Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEGroupEntry(EGroupEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //EViewEditorSwitch
