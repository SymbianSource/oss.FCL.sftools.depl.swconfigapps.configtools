/*
* Copyright (c) 2007 Nokia Corporation and/or its subsidiary(-ies). 
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
package com.nokia.tools.s60ct.model.confml.util;

import com.nokia.tools.s60ct.model.confml.*;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.nokia.tools.s60ct.model.confml.ConfmlPackage;
import com.nokia.tools.s60ct.model.confml.ECompositeSetting;
import com.nokia.tools.s60ct.model.confml.ECompositeValue;
import com.nokia.tools.s60ct.model.confml.EDescriptionContainer;
import com.nokia.tools.s60ct.model.confml.EFeature;
import com.nokia.tools.s60ct.model.confml.EIconContainer;
import com.nokia.tools.s60ct.model.confml.EItemSetting;
import com.nokia.tools.s60ct.model.confml.ELinkContainer;
import com.nokia.tools.s60ct.model.confml.EOption;
import com.nokia.tools.s60ct.model.confml.EOptionMap;
import com.nokia.tools.s60ct.model.confml.EProperty;
import com.nokia.tools.s60ct.model.confml.EResourceLocator;
import com.nokia.tools.s60ct.model.confml.EResourceSetting;
import com.nokia.tools.s60ct.model.confml.EResourceValue;
import com.nokia.tools.s60ct.model.confml.ESequenceSetting;
import com.nokia.tools.s60ct.model.confml.ESequenceValue;
import com.nokia.tools.s60ct.model.confml.ESequenceValueItem;
import com.nokia.tools.s60ct.model.confml.ESetting;
import com.nokia.tools.s60ct.model.confml.ESettingContainer;
import com.nokia.tools.s60ct.model.confml.ESettingOption;
import com.nokia.tools.s60ct.model.confml.ESettingValue;
import com.nokia.tools.s60ct.model.confml.ESettingValueContainer;
import com.nokia.tools.s60ct.model.confml.ESimpleSetting;
import com.nokia.tools.s60ct.model.confml.ESimpleValue;
import com.nokia.tools.s60ct.model.confml.ESubSettingValue;

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
 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage
 * @generated
 */
public class ConfmlSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ConfmlPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfmlSwitch() {
		if (modelPackage == null) {
			modelPackage = ConfmlPackage.eINSTANCE;
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
			case ConfmlPackage.EFEATURE: {
				EFeature eFeature = (EFeature)theEObject;
				T result = caseEFeature(eFeature);
				if (result == null) result = caseEDescriptionContainer(eFeature);
				if (result == null) result = caseEIconContainer(eFeature);
				if (result == null) result = caseELinkContainer(eFeature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfmlPackage.ESETTING: {
				ESetting eSetting = (ESetting)theEObject;
				T result = caseESetting(eSetting);
				if (result == null) result = caseEDescriptionContainer(eSetting);
				if (result == null) result = caseEIconContainer(eSetting);
				if (result == null) result = caseELinkContainer(eSetting);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfmlPackage.ESETTING_OPTION: {
				ESettingOption eSettingOption = (ESettingOption)theEObject;
				T result = caseESettingOption(eSettingOption);
				if (result == null) result = caseEDescriptionContainer(eSettingOption);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfmlPackage.ESIMPLE_SETTING: {
				ESimpleSetting eSimpleSetting = (ESimpleSetting)theEObject;
				T result = caseESimpleSetting(eSimpleSetting);
				if (result == null) result = caseESetting(eSimpleSetting);
				if (result == null) result = caseEDescriptionContainer(eSimpleSetting);
				if (result == null) result = caseEIconContainer(eSimpleSetting);
				if (result == null) result = caseELinkContainer(eSimpleSetting);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfmlPackage.ESEQUENCE_SETTING: {
				ESequenceSetting eSequenceSetting = (ESequenceSetting)theEObject;
				T result = caseESequenceSetting(eSequenceSetting);
				if (result == null) result = caseESetting(eSequenceSetting);
				if (result == null) result = caseESettingContainer(eSequenceSetting);
				if (result == null) result = caseEDescriptionContainer(eSequenceSetting);
				if (result == null) result = caseEIconContainer(eSequenceSetting);
				if (result == null) result = caseELinkContainer(eSequenceSetting);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfmlPackage.EITEM_SETTING: {
				EItemSetting eItemSetting = (EItemSetting)theEObject;
				T result = caseEItemSetting(eItemSetting);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfmlPackage.ESUB_SETTING_VALUE: {
				ESubSettingValue eSubSettingValue = (ESubSettingValue)theEObject;
				T result = caseESubSettingValue(eSubSettingValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfmlPackage.EDESCRIPTION_CONTAINER: {
				EDescriptionContainer eDescriptionContainer = (EDescriptionContainer)theEObject;
				T result = caseEDescriptionContainer(eDescriptionContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfmlPackage.EICON_CONTAINER: {
				EIconContainer eIconContainer = (EIconContainer)theEObject;
				T result = caseEIconContainer(eIconContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfmlPackage.ERESOURCE_LOCATOR: {
				EResourceLocator eResourceLocator = (EResourceLocator)theEObject;
				T result = caseEResourceLocator(eResourceLocator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfmlPackage.ESETTING_VALUE: {
				ESettingValue eSettingValue = (ESettingValue)theEObject;
				T result = caseESettingValue(eSettingValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfmlPackage.ECOMPOSITE_SETTING: {
				ECompositeSetting eCompositeSetting = (ECompositeSetting)theEObject;
				T result = caseECompositeSetting(eCompositeSetting);
				if (result == null) result = caseESetting(eCompositeSetting);
				if (result == null) result = caseESettingContainer(eCompositeSetting);
				if (result == null) result = caseEDescriptionContainer(eCompositeSetting);
				if (result == null) result = caseEIconContainer(eCompositeSetting);
				if (result == null) result = caseELinkContainer(eCompositeSetting);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfmlPackage.ERESOURCE_SETTING: {
				EResourceSetting eResourceSetting = (EResourceSetting)theEObject;
				T result = caseEResourceSetting(eResourceSetting);
				if (result == null) result = caseECompositeSetting(eResourceSetting);
				if (result == null) result = caseESetting(eResourceSetting);
				if (result == null) result = caseESettingContainer(eResourceSetting);
				if (result == null) result = caseEDescriptionContainer(eResourceSetting);
				if (result == null) result = caseEIconContainer(eResourceSetting);
				if (result == null) result = caseELinkContainer(eResourceSetting);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfmlPackage.ESETTING_CONTAINER: {
				ESettingContainer eSettingContainer = (ESettingContainer)theEObject;
				T result = caseESettingContainer(eSettingContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfmlPackage.ESIMPLE_VALUE: {
				ESimpleValue eSimpleValue = (ESimpleValue)theEObject;
				T result = caseESimpleValue(eSimpleValue);
				if (result == null) result = caseESettingValue(eSimpleValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfmlPackage.ESEQUENCE_VALUE: {
				ESequenceValue eSequenceValue = (ESequenceValue)theEObject;
				T result = caseESequenceValue(eSequenceValue);
				if (result == null) result = caseESettingValue(eSequenceValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfmlPackage.ESEQUENCE_VALUE_ITEM: {
				ESequenceValueItem eSequenceValueItem = (ESequenceValueItem)theEObject;
				T result = caseESequenceValueItem(eSequenceValueItem);
				if (result == null) result = caseESettingValueContainer(eSequenceValueItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfmlPackage.ECOMPOSITE_VALUE: {
				ECompositeValue eCompositeValue = (ECompositeValue)theEObject;
				T result = caseECompositeValue(eCompositeValue);
				if (result == null) result = caseESettingValue(eCompositeValue);
				if (result == null) result = caseESettingValueContainer(eCompositeValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfmlPackage.ESETTING_VALUE_CONTAINER: {
				ESettingValueContainer eSettingValueContainer = (ESettingValueContainer)theEObject;
				T result = caseESettingValueContainer(eSettingValueContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfmlPackage.ERESOURCE_VALUE: {
				EResourceValue eResourceValue = (EResourceValue)theEObject;
				T result = caseEResourceValue(eResourceValue);
				if (result == null) result = caseECompositeValue(eResourceValue);
				if (result == null) result = caseESettingValue(eResourceValue);
				if (result == null) result = caseESettingValueContainer(eResourceValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfmlPackage.EPROPERTY: {
				EProperty eProperty = (EProperty)theEObject;
				T result = caseEProperty(eProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfmlPackage.ELINK_CONTAINER: {
				ELinkContainer eLinkContainer = (ELinkContainer)theEObject;
				T result = caseELinkContainer(eLinkContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfmlPackage.EOPTION_MAP: {
				EOptionMap eOptionMap = (EOptionMap)theEObject;
				T result = caseEOptionMap(eOptionMap);
				if (result == null) result = caseESettingOption(eOptionMap);
				if (result == null) result = caseEDescriptionContainer(eOptionMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfmlPackage.EOPTION: {
				EOption eOption = (EOption)theEObject;
				T result = caseEOption(eOption);
				if (result == null) result = caseESettingOption(eOption);
				if (result == null) result = caseEDescriptionContainer(eOption);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfmlPackage.EVALUE_EDITOR_DOCUMENT: {
				EValueEditorDocument eValueEditorDocument = (EValueEditorDocument)theEObject;
				T result = caseEValueEditorDocument(eValueEditorDocument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfmlPackage.PATTERN: {
				Pattern pattern = (Pattern)theEObject;
				T result = casePattern(pattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfmlPackage.VIEW: {
				View view = (View)theEObject;
				T result = caseView(view);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfmlPackage.EGROUP: {
				EGroup eGroup = (EGroup)theEObject;
				T result = caseEGroup(eGroup);
				if (result == null) result = caseEDescriptionContainer(eGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
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
	 * Returns the result of interpreting the object as an instance of '<em>ESetting Option</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ESetting Option</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseESettingOption(ESettingOption object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ESimple Setting</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ESimple Setting</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseESimpleSetting(ESimpleSetting object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ESequence Setting</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ESequence Setting</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseESequenceSetting(ESequenceSetting object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EItem Setting</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EItem Setting</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEItemSetting(EItemSetting object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ESub Setting Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ESub Setting Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseESubSettingValue(ESubSettingValue object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>ESetting Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ESetting Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseESettingValue(ESettingValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EComposite Setting</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EComposite Setting</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseECompositeSetting(ECompositeSetting object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EResource Setting</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EResource Setting</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEResourceSetting(EResourceSetting object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ESetting Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ESetting Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseESettingContainer(ESettingContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ESimple Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ESimple Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseESimpleValue(ESimpleValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ESequence Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ESequence Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseESequenceValue(ESequenceValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ESequence Value Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ESequence Value Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseESequenceValueItem(ESequenceValueItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EComposite Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EComposite Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseECompositeValue(ECompositeValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ESetting Value Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ESetting Value Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseESettingValueContainer(ESettingValueContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EResource Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EResource Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEResourceValue(EResourceValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EProperty</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EProperty</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEProperty(EProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ELink Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ELink Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseELinkContainer(ELinkContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EOption Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EOption Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEOptionMap(EOptionMap object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EOption</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EOption</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEOption(EOption object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EValue Editor Document</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EValue Editor Document</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEValueEditorDocument(EValueEditorDocument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePattern(Pattern object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseView(View object) {
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

} //ConfmlSwitch
