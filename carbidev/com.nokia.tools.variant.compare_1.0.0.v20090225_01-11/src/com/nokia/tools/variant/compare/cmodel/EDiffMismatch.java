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

package com.nokia.tools.variant.compare.cmodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EDiff Mismatch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.EDiffMismatch#getSourceType <em>Source Type</em>}</li>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.EDiffMismatch#getTargetType <em>Target Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.variant.compare.cmodel.ECompareModelPackage#getEDiffMismatch()
 * @model
 * @generated
 */
public interface EDiffMismatch extends EDiffSetting {
	/**
	 * Returns the value of the '<em><b>Source Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Type</em>' attribute.
	 * @see #setSourceType(String)
	 * @see com.nokia.tools.variant.compare.cmodel.ECompareModelPackage#getEDiffMismatch_SourceType()
	 * @model
	 * @generated
	 */
	String getSourceType();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.compare.cmodel.EDiffMismatch#getSourceType <em>Source Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Type</em>' attribute.
	 * @see #getSourceType()
	 * @generated
	 */
	void setSourceType(String value);

	/**
	 * Returns the value of the '<em><b>Target Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Type</em>' attribute.
	 * @see #setTargetType(String)
	 * @see com.nokia.tools.variant.compare.cmodel.ECompareModelPackage#getEDiffMismatch_TargetType()
	 * @model
	 * @generated
	 */
	String getTargetType();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.compare.cmodel.EDiffMismatch#getTargetType <em>Target Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Type</em>' attribute.
	 * @see #getTargetType()
	 * @generated
	 */
	void setTargetType(String value);

} // EDiffMismatch
