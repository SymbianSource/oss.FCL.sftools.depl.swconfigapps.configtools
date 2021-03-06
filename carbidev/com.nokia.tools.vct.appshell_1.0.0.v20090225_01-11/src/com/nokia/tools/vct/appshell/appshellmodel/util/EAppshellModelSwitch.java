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
 * Description: This file is part of com.nokia.tools.vct.appshell component.
 */

package com.nokia.tools.vct.appshell.appshellmodel.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.nokia.tools.vct.appshell.appshellmodel.EApplicationElement;
import com.nokia.tools.vct.appshell.appshellmodel.EAppshellDocument;
import com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage;
import com.nokia.tools.vct.appshell.appshellmodel.EDataElement;
import com.nokia.tools.vct.appshell.appshellmodel.EFolderElement;
import com.nokia.tools.vct.appshell.appshellmodel.EHideDescriptor;
import com.nokia.tools.vct.appshell.appshellmodel.EIconDescriptor;
import com.nokia.tools.vct.appshell.appshellmodel.ELockDescriptor;
import com.nokia.tools.vct.appshell.appshellmodel.ENameDescriptor;
import com.nokia.tools.vct.appshell.appshellmodel.EURLElement;

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
 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage
 * @generated
 */
public class EAppshellModelSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EAppshellModelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAppshellModelSwitch() {
		if (modelPackage == null) {
			modelPackage = EAppshellModelPackage.eINSTANCE;
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
			case EAppshellModelPackage.EAPPSHELL_DOCUMENT: {
				EAppshellDocument eAppshellDocument = (EAppshellDocument)theEObject;
				T result = caseEAppshellDocument(eAppshellDocument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EAppshellModelPackage.EFOLDER_ELEMENT: {
				EFolderElement eFolderElement = (EFolderElement)theEObject;
				T result = caseEFolderElement(eFolderElement);
				if (result == null) result = caseELockDescriptor(eFolderElement);
				if (result == null) result = caseEIconDescriptor(eFolderElement);
				if (result == null) result = caseEHideDescriptor(eFolderElement);
				if (result == null) result = caseENameDescriptor(eFolderElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EAppshellModelPackage.EAPPLICATION_ELEMENT: {
				EApplicationElement eApplicationElement = (EApplicationElement)theEObject;
				T result = caseEApplicationElement(eApplicationElement);
				if (result == null) result = caseELockDescriptor(eApplicationElement);
				if (result == null) result = caseEIconDescriptor(eApplicationElement);
				if (result == null) result = caseEHideDescriptor(eApplicationElement);
				if (result == null) result = caseENameDescriptor(eApplicationElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EAppshellModelPackage.EURL_ELEMENT: {
				EURLElement eurlElement = (EURLElement)theEObject;
				T result = caseEURLElement(eurlElement);
				if (result == null) result = caseELockDescriptor(eurlElement);
				if (result == null) result = caseEIconDescriptor(eurlElement);
				if (result == null) result = caseEHideDescriptor(eurlElement);
				if (result == null) result = caseENameDescriptor(eurlElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EAppshellModelPackage.EDATA_ELEMENT: {
				EDataElement eDataElement = (EDataElement)theEObject;
				T result = caseEDataElement(eDataElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EAppshellModelPackage.ELOCK_DESCRIPTOR: {
				ELockDescriptor eLockDescriptor = (ELockDescriptor)theEObject;
				T result = caseELockDescriptor(eLockDescriptor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EAppshellModelPackage.EICON_DESCRIPTOR: {
				EIconDescriptor eIconDescriptor = (EIconDescriptor)theEObject;
				T result = caseEIconDescriptor(eIconDescriptor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EAppshellModelPackage.EHIDE_DESCRIPTOR: {
				EHideDescriptor eHideDescriptor = (EHideDescriptor)theEObject;
				T result = caseEHideDescriptor(eHideDescriptor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EAppshellModelPackage.ENAME_DESCRIPTOR: {
				ENameDescriptor eNameDescriptor = (ENameDescriptor)theEObject;
				T result = caseENameDescriptor(eNameDescriptor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EAppshell Document</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EAppshell Document</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEAppshellDocument(EAppshellDocument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EFolder Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EFolder Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEFolderElement(EFolderElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EApplication Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EApplication Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEApplicationElement(EApplicationElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EURL Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EURL Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEURLElement(EURLElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EData Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EData Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEDataElement(EDataElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ELock Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ELock Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseELockDescriptor(ELockDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EIcon Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EIcon Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEIconDescriptor(EIconDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EHide Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EHide Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEHideDescriptor(EHideDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EName Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EName Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseENameDescriptor(ENameDescriptor object) {
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

} //EAppshellModelSwitch
