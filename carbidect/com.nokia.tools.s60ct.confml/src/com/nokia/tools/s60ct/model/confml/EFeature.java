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
package com.nokia.tools.s60ct.model.confml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EFeature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.EFeature#getSettings <em>Settings</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.EFeature#getRef <em>Ref</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.EFeature#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.EFeature#getRelevant <em>Relevant</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.EFeature#getRelevantAST <em>Relevant AST</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.EFeature#isComputedRelevant <em>Computed Relevant</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getEFeature()
 * @model
 * @generated
 */
public interface EFeature extends EDescriptionContainer, EIconContainer, ELinkContainer {
	/**
	 * Returns the value of the '<em><b>Settings</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.s60ct.model.confml.ESetting}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Settings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Settings</em>' containment reference list.
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getEFeature_Settings()
	 * @model containment="true"
	 * @generated
	 */
	EList<ESetting> getSettings();

	/**
	 * Returns the value of the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref</em>' attribute.
	 * @see #setRef(String)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getEFeature_Ref()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getRef();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.EFeature#getRef <em>Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref</em>' attribute.
	 * @see #getRef()
	 * @generated
	 */
	void setRef(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getEFeature_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.EFeature#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relevant</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relevant</em>' attribute.
	 * @see #setRelevant(String)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getEFeature_Relevant()
	 * @model
	 * @generated
	 */
	String getRelevant();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.EFeature#getRelevant <em>Relevant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relevant</em>' attribute.
	 * @see #getRelevant()
	 * @generated
	 */
	void setRelevant(String value);

	/**
	 * Returns the value of the '<em><b>Relevant AST</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relevant AST</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relevant AST</em>' attribute.
	 * @see #setRelevantAST(Object)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getEFeature_RelevantAST()
	 * @model
	 * @generated
	 */
	Object getRelevantAST();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.EFeature#getRelevantAST <em>Relevant AST</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relevant AST</em>' attribute.
	 * @see #getRelevantAST()
	 * @generated
	 */
	void setRelevantAST(Object value);

	/**
	 * Returns the value of the '<em><b>Computed Relevant</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Computed Relevant</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Computed Relevant</em>' attribute.
	 * @see #setComputedRelevant(boolean)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getEFeature_ComputedRelevant()
	 * @model default="true"
	 * @generated
	 */
	boolean isComputedRelevant();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.EFeature#isComputedRelevant <em>Computed Relevant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Computed Relevant</em>' attribute.
	 * @see #isComputedRelevant()
	 * @generated
	 */
	void setComputedRelevant(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	View getView();

} // EFeature
