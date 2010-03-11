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
 * A representation of the model object '<em><b>ESimple Setting</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.EDiffSimple#getSourceValue <em>Source Value</em>}</li>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.EDiffSimple#getTargetValue <em>Target Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.variant.compare.cmodel.ECompareModelPackage#getEDiffSimple()
 * @model
 * @generated
 */
public interface EDiffSimple extends EDiffSetting {
	/**
	 * Returns the value of the '<em><b>Source Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Value</em>' attribute.
	 * @see #setSourceValue(String)
	 * @see com.nokia.tools.variant.compare.cmodel.ECompareModelPackage#getEDiffSimple_SourceValue()
	 * @model
	 * @generated
	 */
	String getSourceValue();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.compare.cmodel.EDiffSimple#getSourceValue <em>Source Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Value</em>' attribute.
	 * @see #getSourceValue()
	 * @generated
	 */
	void setSourceValue(String value);

	/**
	 * Returns the value of the '<em><b>Target Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Value</em>' attribute.
	 * @see #setTargetValue(String)
	 * @see com.nokia.tools.variant.compare.cmodel.ECompareModelPackage#getEDiffSimple_TargetValue()
	 * @model
	 * @generated
	 */
	String getTargetValue();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.compare.cmodel.EDiffSimple#getTargetValue <em>Target Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Value</em>' attribute.
	 * @see #getTargetValue()
	 * @generated
	 */
	void setTargetValue(String value);

} // ESimpleSetting
