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
package cenrep.util;

import cenrep.*;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import cenrep.Access;
import cenrep.AttributeAndDescription;
import cenrep.Bit;
import cenrep.CenrepPackage;
import cenrep.CommonAttrs;
import cenrep.Content;
import cenrep.Date;
import cenrep.Editor;
import cenrep.IAccessable;
import cenrep.IBackup;
import cenrep.IReadOnly;
import cenrep.Identification;
import cenrep.Key;
import cenrep.KeyRange;
import cenrep.Meta;
import cenrep.Owner;
import cenrep.Platform;
import cenrep.Product;
import cenrep.RVG;
import cenrep.Release;
import cenrep.Repository;
import cenrep.Status;
import cenrep.Value;
import cenrep.Version;

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
 * @see cenrep.CenrepPackage
 * @generated
 */
public class CenrepSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CenrepPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CenrepSwitch() {
		if (modelPackage == null) {
			modelPackage = CenrepPackage.eINSTANCE;
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
			case CenrepPackage.COMMON_ATTRS: {
				CommonAttrs commonAttrs = (CommonAttrs)theEObject;
				T result = caseCommonAttrs(commonAttrs);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CenrepPackage.META: {
				Meta meta = (Meta)theEObject;
				T result = caseMeta(meta);
				if (result == null) result = caseCommonAttrs(meta);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CenrepPackage.IDENTIFICATION: {
				Identification identification = (Identification)theEObject;
				T result = caseIdentification(identification);
				if (result == null) result = caseContent(identification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CenrepPackage.DATE: {
				Date date = (Date)theEObject;
				T result = caseDate(date);
				if (result == null) result = caseContent(date);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CenrepPackage.OWNER: {
				Owner owner = (Owner)theEObject;
				T result = caseOwner(owner);
				if (result == null) result = caseContent(owner);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CenrepPackage.EDITOR: {
				Editor editor = (Editor)theEObject;
				T result = caseEditor(editor);
				if (result == null) result = caseContent(editor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CenrepPackage.STATUS: {
				Status status = (Status)theEObject;
				T result = caseStatus(status);
				if (result == null) result = caseContent(status);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CenrepPackage.VERSION: {
				Version version = (Version)theEObject;
				T result = caseVersion(version);
				if (result == null) result = caseContent(version);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CenrepPackage.PLATFORM: {
				Platform platform = (Platform)theEObject;
				T result = casePlatform(platform);
				if (result == null) result = caseContent(platform);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CenrepPackage.PRODUCT: {
				Product product = (Product)theEObject;
				T result = caseProduct(product);
				if (result == null) result = caseContent(product);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CenrepPackage.RELEASE: {
				Release release = (Release)theEObject;
				T result = caseRelease(release);
				if (result == null) result = caseContent(release);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CenrepPackage.CONTENT: {
				Content content = (Content)theEObject;
				T result = caseContent(content);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CenrepPackage.REPOSITORY: {
				Repository repository = (Repository)theEObject;
				T result = caseRepository(repository);
				if (result == null) result = caseAttributeAndDescription(repository);
				if (result == null) result = caseIAccessable(repository);
				if (result == null) result = caseIBackup(repository);
				if (result == null) result = caseCommonAttrs(repository);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CenrepPackage.KEY: {
				Key key = (Key)theEObject;
				T result = caseKey(key);
				if (result == null) result = caseAttributeAndDescription(key);
				if (result == null) result = caseRVG(key);
				if (result == null) result = caseIReadOnly(key);
				if (result == null) result = caseIAccessable(key);
				if (result == null) result = caseIBackup(key);
				if (result == null) result = caseCommonAttrs(key);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CenrepPackage.KEY_RANGE: {
				KeyRange keyRange = (KeyRange)theEObject;
				T result = caseKeyRange(keyRange);
				if (result == null) result = caseAttributeAndDescription(keyRange);
				if (result == null) result = caseRVG(keyRange);
				if (result == null) result = caseIReadOnly(keyRange);
				if (result == null) result = caseIAccessable(keyRange);
				if (result == null) result = caseIBackup(keyRange);
				if (result == null) result = caseCommonAttrs(keyRange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CenrepPackage.ACCESS: {
				Access access = (Access)theEObject;
				T result = caseAccess(access);
				if (result == null) result = caseAttributeAndDescription(access);
				if (result == null) result = caseCommonAttrs(access);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CenrepPackage.VALUE: {
				Value value = (Value)theEObject;
				T result = caseValue(value);
				if (result == null) result = caseContent(value);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CenrepPackage.BIT: {
				Bit bit = (Bit)theEObject;
				T result = caseBit(bit);
				if (result == null) result = caseContent(bit);
				if (result == null) result = caseRVG(bit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CenrepPackage.RVG: {
				RVG rvg = (RVG)theEObject;
				T result = caseRVG(rvg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CenrepPackage.ATTRIBUTE_AND_DESCRIPTION: {
				AttributeAndDescription attributeAndDescription = (AttributeAndDescription)theEObject;
				T result = caseAttributeAndDescription(attributeAndDescription);
				if (result == null) result = caseCommonAttrs(attributeAndDescription);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CenrepPackage.IREAD_ONLY: {
				IReadOnly iReadOnly = (IReadOnly)theEObject;
				T result = caseIReadOnly(iReadOnly);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CenrepPackage.IACCESSABLE: {
				IAccessable iAccessable = (IAccessable)theEObject;
				T result = caseIAccessable(iAccessable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CenrepPackage.IBACKUP: {
				IBackup iBackup = (IBackup)theEObject;
				T result = caseIBackup(iBackup);
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
	 * Returns the result of interpreting the object as an instance of '<em>Meta</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Meta</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMeta(Meta object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentification(Identification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Date</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Date</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDate(Date object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Owner</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Owner</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOwner(Owner object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Editor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Editor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEditor(Editor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Status</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Status</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatus(Status object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Version</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Version</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVersion(Version object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Platform</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Platform</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlatform(Platform object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Product</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Product</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProduct(Product object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Release</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Release</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelease(Release object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Content</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Content</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContent(Content object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Repository</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Repository</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRepository(Repository object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Key</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Key</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseKey(Key object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Key Range</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Key Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseKeyRange(KeyRange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Access</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Access</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAccess(Access object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValue(Value object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBit(Bit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>RVG</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>RVG</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRVG(RVG object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute And Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute And Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeAndDescription(AttributeAndDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IRead Only</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IRead Only</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIReadOnly(IReadOnly object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IAccessable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IAccessable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIAccessable(IAccessable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IBackup</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IBackup</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIBackup(IBackup object) {
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

} //CenrepSwitch
