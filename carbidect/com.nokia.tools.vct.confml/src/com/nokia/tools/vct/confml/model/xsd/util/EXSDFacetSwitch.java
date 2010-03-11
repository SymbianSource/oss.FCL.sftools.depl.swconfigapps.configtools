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
 * Description: This file is part of com.nokia.tools.vct.confml component.
 */

package com.nokia.tools.vct.confml.model.xsd.util;

import com.nokia.tools.vct.confml.model.xsd.*;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.nokia.tools.vct.confml.model.xsd.EFacet;
import com.nokia.tools.vct.confml.model.xsd.ELength;
import com.nokia.tools.vct.confml.model.xsd.EMaxExclusive;
import com.nokia.tools.vct.confml.model.xsd.EMaxInclusive;
import com.nokia.tools.vct.confml.model.xsd.EMaxLength;
import com.nokia.tools.vct.confml.model.xsd.EMinExclusive;
import com.nokia.tools.vct.confml.model.xsd.EMinInclusive;
import com.nokia.tools.vct.confml.model.xsd.EMinLength;
import com.nokia.tools.vct.confml.model.xsd.ENumFacet;
import com.nokia.tools.vct.confml.model.xsd.EPattern;
import com.nokia.tools.vct.confml.model.xsd.ETotalDigits;
import com.nokia.tools.vct.confml.model.xsd.EXSDFacetPackage;

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
 * @see com.nokia.tools.vct.confml.model.xsd.EXSDFacetPackage
 * @generated
 */
public class EXSDFacetSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EXSDFacetPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EXSDFacetSwitch() {
		if (modelPackage == null) {
			modelPackage = EXSDFacetPackage.eINSTANCE;
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
		} else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch(
					eSuperTypes.get(0), theEObject);
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
		case EXSDFacetPackage.EFACET: {
			EFacet eFacet = (EFacet) theEObject;
			T result = caseEFacet(eFacet);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EXSDFacetPackage.ENUM_FACET: {
			ENumFacet eNumFacet = (ENumFacet) theEObject;
			T result = caseENumFacet(eNumFacet);
			if (result == null)
				result = caseEFacet(eNumFacet);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EXSDFacetPackage.EMIN_INCLUSIVE: {
			EMinInclusive eMinInclusive = (EMinInclusive) theEObject;
			T result = caseEMinInclusive(eMinInclusive);
			if (result == null)
				result = caseEFacet(eMinInclusive);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EXSDFacetPackage.EMIN_EXCLUSIVE: {
			EMinExclusive eMinExclusive = (EMinExclusive) theEObject;
			T result = caseEMinExclusive(eMinExclusive);
			if (result == null)
				result = caseEFacet(eMinExclusive);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EXSDFacetPackage.EMAX_INCLUSIVE: {
			EMaxInclusive eMaxInclusive = (EMaxInclusive) theEObject;
			T result = caseEMaxInclusive(eMaxInclusive);
			if (result == null)
				result = caseEFacet(eMaxInclusive);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EXSDFacetPackage.EMAX_EXCLUSIVE: {
			EMaxExclusive eMaxExclusive = (EMaxExclusive) theEObject;
			T result = caseEMaxExclusive(eMaxExclusive);
			if (result == null)
				result = caseEFacet(eMaxExclusive);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EXSDFacetPackage.ELENGTH: {
			ELength eLength = (ELength) theEObject;
			T result = caseELength(eLength);
			if (result == null)
				result = caseENumFacet(eLength);
			if (result == null)
				result = caseEFacet(eLength);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EXSDFacetPackage.EMIN_LENGTH: {
			EMinLength eMinLength = (EMinLength) theEObject;
			T result = caseEMinLength(eMinLength);
			if (result == null)
				result = caseENumFacet(eMinLength);
			if (result == null)
				result = caseEFacet(eMinLength);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EXSDFacetPackage.EMAX_LENGTH: {
			EMaxLength eMaxLength = (EMaxLength) theEObject;
			T result = caseEMaxLength(eMaxLength);
			if (result == null)
				result = caseENumFacet(eMaxLength);
			if (result == null)
				result = caseEFacet(eMaxLength);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EXSDFacetPackage.ETOTAL_DIGITS: {
			ETotalDigits eTotalDigits = (ETotalDigits) theEObject;
			T result = caseETotalDigits(eTotalDigits);
			if (result == null)
				result = caseENumFacet(eTotalDigits);
			if (result == null)
				result = caseEFacet(eTotalDigits);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EXSDFacetPackage.EPATTERN: {
			EPattern ePattern = (EPattern) theEObject;
			T result = caseEPattern(ePattern);
			if (result == null)
				result = caseEFacet(ePattern);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EFacet</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EFacet</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEFacet(EFacet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ENum Facet</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ENum Facet</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseENumFacet(ENumFacet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EMin Inclusive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EMin Inclusive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEMinInclusive(EMinInclusive object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EMin Exclusive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EMin Exclusive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEMinExclusive(EMinExclusive object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EMax Inclusive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EMax Inclusive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEMaxInclusive(EMaxInclusive object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EMax Exclusive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EMax Exclusive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEMaxExclusive(EMaxExclusive object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ELength</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ELength</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseELength(ELength object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EMin Length</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EMin Length</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEMinLength(EMinLength object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EMax Length</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EMax Length</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEMaxLength(EMaxLength object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ETotal Digits</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ETotal Digits</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseETotalDigits(ETotalDigits object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EPattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EPattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEPattern(EPattern object) {
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

} //EXSDFacetSwitch
