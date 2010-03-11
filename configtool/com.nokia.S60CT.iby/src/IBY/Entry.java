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
package IBY;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link IBY.Entry#getSource <em>Source</em>}</li>
 *   <li>{@link IBY.Entry#getTarget <em>Target</em>}</li>
 *   <li>{@link IBY.Entry#getFileName <em>File Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see IBY.IBYPackage#getEntry()
 * @model
 * @generated
 */
public interface Entry extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' containment reference.
	 * @see #setSource(SrcPath)
	 * @see IBY.IBYPackage#getEntry_Source()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	SrcPath getSource();

	/**
	 * Sets the value of the '{@link IBY.Entry#getSource <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(SrcPath value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(TargetPath)
	 * @see IBY.IBYPackage#getEntry_Target()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	TargetPath getTarget();

	/**
	 * Sets the value of the '{@link IBY.Entry#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(TargetPath value);

	/**
	 * Returns the value of the '<em><b>File Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Name</em>' containment reference.
	 * @see #setFileName(FileName)
	 * @see IBY.IBYPackage#getEntry_FileName()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	FileName getFileName();

	/**
	 * Sets the value of the '{@link IBY.Entry#getFileName <em>File Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Name</em>' containment reference.
	 * @see #getFileName()
	 * @generated
	 */
	void setFileName(FileName value);

} // Entry
