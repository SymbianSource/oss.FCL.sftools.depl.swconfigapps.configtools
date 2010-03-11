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
 * Description: This file is part of com.nokia.tools.variant.compare component.
 */

package com.nokia.tools.variant.compare.cmodel.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.nokia.tools.variant.compare.cmodel.ECheckableElement;
import com.nokia.tools.variant.compare.cmodel.ECompareElement;
import com.nokia.tools.variant.compare.cmodel.ECompareModelPackage;
import com.nokia.tools.variant.compare.cmodel.EDiffGroup;
import com.nokia.tools.variant.compare.cmodel.EDiffLocalPathSetting;
import com.nokia.tools.variant.compare.cmodel.EDiffMismatch;
import com.nokia.tools.variant.compare.cmodel.EDiffResourceSetting2;
import com.nokia.tools.variant.compare.cmodel.EDiffSequence;
import com.nokia.tools.variant.compare.cmodel.EDiffSequenceItem;
import com.nokia.tools.variant.compare.cmodel.EDiffSetting;
import com.nokia.tools.variant.compare.cmodel.EDiffSettingContainer;
import com.nokia.tools.variant.compare.cmodel.EDiffSimple;
import com.nokia.tools.variant.compare.cmodel.EGroupContainer;
import com.nokia.tools.variant.compare.cmodel.EModelRoot;

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
 * @see com.nokia.tools.variant.compare.cmodel.ECompareModelPackage
 * @generated
 */
public class ECompareModelSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ECompareModelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ECompareModelSwitch() {
		if (modelPackage == null) {
			modelPackage = ECompareModelPackage.eINSTANCE;
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
			case ECompareModelPackage.EDIFF_SETTING_CONTAINER: {
				EDiffSettingContainer eDiffSettingContainer = (EDiffSettingContainer)theEObject;
				T result = caseEDiffSettingContainer(eDiffSettingContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ECompareModelPackage.EGROUP_CONTAINER: {
				EGroupContainer eGroupContainer = (EGroupContainer)theEObject;
				T result = caseEGroupContainer(eGroupContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ECompareModelPackage.ECOMPARE_ELEMENT: {
				ECompareElement eCompareElement = (ECompareElement)theEObject;
				T result = caseECompareElement(eCompareElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ECompareModelPackage.EMODEL_ROOT: {
				EModelRoot eModelRoot = (EModelRoot)theEObject;
				T result = caseEModelRoot(eModelRoot);
				if (result == null) result = caseEGroupContainer(eModelRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ECompareModelPackage.EDIFF_GROUP: {
				EDiffGroup eDiffGroup = (EDiffGroup)theEObject;
				T result = caseEDiffGroup(eDiffGroup);
				if (result == null) result = caseECompareElement(eDiffGroup);
				if (result == null) result = caseEGroupContainer(eDiffGroup);
				if (result == null) result = caseEDiffSettingContainer(eDiffGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ECompareModelPackage.EDIFF_SETTING: {
				EDiffSetting eDiffSetting = (EDiffSetting)theEObject;
				T result = caseEDiffSetting(eDiffSetting);
				if (result == null) result = caseECompareElement(eDiffSetting);
				if (result == null) result = caseECheckableElement(eDiffSetting);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ECompareModelPackage.EDIFF_SIMPLE: {
				EDiffSimple eDiffSimple = (EDiffSimple)theEObject;
				T result = caseEDiffSimple(eDiffSimple);
				if (result == null) result = caseEDiffSetting(eDiffSimple);
				if (result == null) result = caseECompareElement(eDiffSimple);
				if (result == null) result = caseECheckableElement(eDiffSimple);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ECompareModelPackage.EDIFF_SEQUENCE: {
				EDiffSequence eDiffSequence = (EDiffSequence)theEObject;
				T result = caseEDiffSequence(eDiffSequence);
				if (result == null) result = caseEDiffSetting(eDiffSequence);
				if (result == null) result = caseECompareElement(eDiffSequence);
				if (result == null) result = caseECheckableElement(eDiffSequence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ECompareModelPackage.EDIFF_RESOURCE_SETTING2: {
				EDiffResourceSetting2 eDiffResourceSetting2 = (EDiffResourceSetting2)theEObject;
				T result = caseEDiffResourceSetting2(eDiffResourceSetting2);
				if (result == null) result = caseEDiffSetting(eDiffResourceSetting2);
				if (result == null) result = caseECompareElement(eDiffResourceSetting2);
				if (result == null) result = caseECheckableElement(eDiffResourceSetting2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ECompareModelPackage.EDIFF_LOCAL_PATH_SETTING: {
				EDiffLocalPathSetting eDiffLocalPathSetting = (EDiffLocalPathSetting)theEObject;
				T result = caseEDiffLocalPathSetting(eDiffLocalPathSetting);
				if (result == null) result = caseEDiffSimple(eDiffLocalPathSetting);
				if (result == null) result = caseEDiffSetting(eDiffLocalPathSetting);
				if (result == null) result = caseECompareElement(eDiffLocalPathSetting);
				if (result == null) result = caseECheckableElement(eDiffLocalPathSetting);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ECompareModelPackage.EDIFF_MISMATCH: {
				EDiffMismatch eDiffMismatch = (EDiffMismatch)theEObject;
				T result = caseEDiffMismatch(eDiffMismatch);
				if (result == null) result = caseEDiffSetting(eDiffMismatch);
				if (result == null) result = caseECompareElement(eDiffMismatch);
				if (result == null) result = caseECheckableElement(eDiffMismatch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ECompareModelPackage.ECHECKABLE_ELEMENT: {
				ECheckableElement eCheckableElement = (ECheckableElement)theEObject;
				T result = caseECheckableElement(eCheckableElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ECompareModelPackage.EDIFF_SEQUENCE_ITEM: {
				EDiffSequenceItem eDiffSequenceItem = (EDiffSequenceItem)theEObject;
				T result = caseEDiffSequenceItem(eDiffSequenceItem);
				if (result == null) result = caseECompareElement(eDiffSequenceItem);
				if (result == null) result = caseEDiffSettingContainer(eDiffSequenceItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EModel Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EModel Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEModelRoot(EModelRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EDiff Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EDiff Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEDiffGroup(EDiffGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EDiff Setting</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EDiff Setting</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEDiffSetting(EDiffSetting object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>ECompare Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ECompare Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseECompareElement(ECompareElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EDiff Simple</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EDiff Simple</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEDiffSimple(EDiffSimple object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EDiff Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EDiff Sequence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEDiffSequence(EDiffSequence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EDiff Setting Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EDiff Setting Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEDiffSettingContainer(EDiffSettingContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EDiff Resource Setting2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EDiff Resource Setting2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEDiffResourceSetting2(EDiffResourceSetting2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EDiff Local Path Setting</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EDiff Local Path Setting</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEDiffLocalPathSetting(EDiffLocalPathSetting object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EDiff Mismatch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EDiff Mismatch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEDiffMismatch(EDiffMismatch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ECheckable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ECheckable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseECheckableElement(ECheckableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EDiff Sequence Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EDiff Sequence Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEDiffSequenceItem(EDiffSequenceItem object) {
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

} //ECompareModelSwitch
