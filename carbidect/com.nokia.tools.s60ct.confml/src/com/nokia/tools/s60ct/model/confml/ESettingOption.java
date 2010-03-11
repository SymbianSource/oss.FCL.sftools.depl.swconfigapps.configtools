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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ESetting Option</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESettingOption#getRelevant <em>Relevant</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESettingOption#getRelevantAST <em>Relevant AST</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESettingOption#isComputedRelevant <em>Computed Relevant</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESettingOption()
 * @model abstract="true"
 * @generated
 */
public interface ESettingOption extends EDescriptionContainer {
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
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESettingOption_Relevant()
	 * @model
	 * @generated
	 */
	String getRelevant();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESettingOption#getRelevant <em>Relevant</em>}' attribute.
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
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESettingOption_RelevantAST()
	 * @model
	 * @generated
	 */
	Object getRelevantAST();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESettingOption#getRelevantAST <em>Relevant AST</em>}' attribute.
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
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESettingOption_ComputedRelevant()
	 * @model default="true"
	 * @generated
	 */
	boolean isComputedRelevant();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESettingOption#isComputedRelevant <em>Computed Relevant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Computed Relevant</em>' attribute.
	 * @see #isComputedRelevant()
	 * @generated
	 */
	void setComputedRelevant(boolean value);

} // ESettingOption
