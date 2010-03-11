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
 * Description: This file is part of com.nokia.tools.vct.crml component.
 */

package com.nokia.tools.vct.crml.crmodel.util;

import com.nokia.tools.vct.crml.crmodel.*;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.nokia.tools.vct.crml.crmodel.CommonAttrs;
import com.nokia.tools.vct.crml.crmodel.EAccess;
import com.nokia.tools.vct.crml.crmodel.EAccessContainer;
import com.nokia.tools.vct.crml.crmodel.EAttributeAndDescription;
import com.nokia.tools.vct.crml.crmodel.EBackup;
import com.nokia.tools.vct.crml.crmodel.EBit;
import com.nokia.tools.vct.crml.crmodel.ECRMLDocumentRoot;
import com.nokia.tools.vct.crml.crmodel.ECRMLPackage;
import com.nokia.tools.vct.crml.crmodel.EContent;
import com.nokia.tools.vct.crml.crmodel.EKey;
import com.nokia.tools.vct.crml.crmodel.EKeyRange;
import com.nokia.tools.vct.crml.crmodel.EMeta;
import com.nokia.tools.vct.crml.crmodel.EReadOnly;
import com.nokia.tools.vct.crml.crmodel.ERefContainer;
import com.nokia.tools.vct.crml.crmodel.ERepository;
import com.nokia.tools.vct.crml.crmodel.EValue;

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
 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage
 * @generated
 */
public class ECRMLSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ECRMLPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ECRMLSwitch() {
		if (modelPackage == null) {
			modelPackage = ECRMLPackage.eINSTANCE;
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
			case ECRMLPackage.COMMON_ATTRS: {
				CommonAttrs commonAttrs = (CommonAttrs)theEObject;
				T result = caseCommonAttrs(commonAttrs);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ECRMLPackage.EMETA: {
				EMeta eMeta = (EMeta)theEObject;
				T result = caseEMeta(eMeta);
				if (result == null) result = caseCommonAttrs(eMeta);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ECRMLPackage.ECONTENT: {
				EContent eContent = (EContent)theEObject;
				T result = caseEContent(eContent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ECRMLPackage.EREPOSITORY: {
				ERepository eRepository = (ERepository)theEObject;
				T result = caseERepository(eRepository);
				if (result == null) result = caseEAttributeAndDescription(eRepository);
				if (result == null) result = caseEAccessContainer(eRepository);
				if (result == null) result = caseEBackup(eRepository);
				if (result == null) result = caseCommonAttrs(eRepository);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ECRMLPackage.EKEY: {
				EKey eKey = (EKey)theEObject;
				T result = caseEKey(eKey);
				if (result == null) result = caseEAttributeAndDescription(eKey);
				if (result == null) result = caseERefContainer(eKey);
				if (result == null) result = caseEReadOnly(eKey);
				if (result == null) result = caseEAccessContainer(eKey);
				if (result == null) result = caseEBackup(eKey);
				if (result == null) result = caseCommonAttrs(eKey);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ECRMLPackage.EKEY_RANGE: {
				EKeyRange eKeyRange = (EKeyRange)theEObject;
				T result = caseEKeyRange(eKeyRange);
				if (result == null) result = caseEAttributeAndDescription(eKeyRange);
				if (result == null) result = caseERefContainer(eKeyRange);
				if (result == null) result = caseEReadOnly(eKeyRange);
				if (result == null) result = caseEAccessContainer(eKeyRange);
				if (result == null) result = caseEBackup(eKeyRange);
				if (result == null) result = caseCommonAttrs(eKeyRange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ECRMLPackage.EACCESS: {
				EAccess eAccess = (EAccess)theEObject;
				T result = caseEAccess(eAccess);
				if (result == null) result = caseEAttributeAndDescription(eAccess);
				if (result == null) result = caseCommonAttrs(eAccess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ECRMLPackage.EVALUE: {
				EValue eValue = (EValue)theEObject;
				T result = caseEValue(eValue);
				if (result == null) result = caseEContent(eValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ECRMLPackage.EBIT: {
				EBit eBit = (EBit)theEObject;
				T result = caseEBit(eBit);
				if (result == null) result = caseEContent(eBit);
				if (result == null) result = caseERefContainer(eBit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ECRMLPackage.EREF_CONTAINER: {
				ERefContainer eRefContainer = (ERefContainer)theEObject;
				T result = caseERefContainer(eRefContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ECRMLPackage.EATTRIBUTE_AND_DESCRIPTION: {
				EAttributeAndDescription eAttributeAndDescription = (EAttributeAndDescription)theEObject;
				T result = caseEAttributeAndDescription(eAttributeAndDescription);
				if (result == null) result = caseCommonAttrs(eAttributeAndDescription);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ECRMLPackage.EREAD_ONLY: {
				EReadOnly eReadOnly = (EReadOnly)theEObject;
				T result = caseEReadOnly(eReadOnly);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ECRMLPackage.EACCESS_CONTAINER: {
				EAccessContainer eAccessContainer = (EAccessContainer)theEObject;
				T result = caseEAccessContainer(eAccessContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ECRMLPackage.EBACKUP: {
				EBackup eBackup = (EBackup)theEObject;
				T result = caseEBackup(eBackup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ECRMLPackage.ECRML_DOCUMENT_ROOT: {
				ECRMLDocumentRoot ecrmlDocumentRoot = (ECRMLDocumentRoot)theEObject;
				T result = caseECRMLDocumentRoot(ecrmlDocumentRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Common Attrs</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Common Attrs</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommonAttrs(CommonAttrs object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EMeta</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EMeta</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEMeta(EMeta object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EContent</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EContent</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEContent(EContent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ERepository</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ERepository</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseERepository(ERepository object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EKey</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EKey</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEKey(EKey object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EKey Range</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EKey Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEKeyRange(EKeyRange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EAccess</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EAccess</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEAccess(EAccess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EValue</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EValue</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEValue(EValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EBit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EBit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEBit(EBit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ERef Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ERef Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseERefContainer(ERefContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EAttribute And Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EAttribute And Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEAttributeAndDescription(EAttributeAndDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ERead Only</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ERead Only</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEReadOnly(EReadOnly object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EAccess Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EAccess Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEAccessContainer(EAccessContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EBackup</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EBackup</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEBackup(EBackup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Document Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseECRMLDocumentRoot(ECRMLDocumentRoot object) {
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

} //ECRMLSwitch
