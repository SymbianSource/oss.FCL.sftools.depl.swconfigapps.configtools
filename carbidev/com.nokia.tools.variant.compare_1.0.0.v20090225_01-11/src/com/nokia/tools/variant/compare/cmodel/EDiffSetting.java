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
 * A representation of the model object '<em><b>ESetting Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.EDiffSetting#getAbsRef <em>Abs Ref</em>}</li>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.EDiffSetting#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.EDiffSetting#isSourceDefault <em>Source Default</em>}</li>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.EDiffSetting#isTargetDefault <em>Target Default</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.variant.compare.cmodel.ECompareModelPackage#getEDiffSetting()
 * @model abstract="true"
 * @generated
 */
public interface EDiffSetting extends ECompareElement, ECheckableElement {
	/**
	 * Returns the value of the '<em><b>Abs Ref</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abs Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abs Ref</em>' attribute.
	 * @see #setAbsRef(String)
	 * @see com.nokia.tools.variant.compare.cmodel.ECompareModelPackage#getEDiffSetting_AbsRef()
	 * @model default=""
	 * @generated
	 */
	String getAbsRef();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.compare.cmodel.EDiffSetting#getAbsRef <em>Abs Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abs Ref</em>' attribute.
	 * @see #getAbsRef()
	 * @generated
	 */
	void setAbsRef(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.nokia.tools.variant.compare.cmodel.ECompareModelPackage#getEDiffSetting_Name()
	 * @model default=""
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.compare.cmodel.EDiffSetting#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Source Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Default</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Default</em>' attribute.
	 * @see #setSourceDefault(boolean)
	 * @see com.nokia.tools.variant.compare.cmodel.ECompareModelPackage#getEDiffSetting_SourceDefault()
	 * @model
	 * @generated
	 */
	boolean isSourceDefault();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.compare.cmodel.EDiffSetting#isSourceDefault <em>Source Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Default</em>' attribute.
	 * @see #isSourceDefault()
	 * @generated
	 */
	void setSourceDefault(boolean value);

	/**
	 * Returns the value of the '<em><b>Target Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Default</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Default</em>' attribute.
	 * @see #setTargetDefault(boolean)
	 * @see com.nokia.tools.variant.compare.cmodel.ECompareModelPackage#getEDiffSetting_TargetDefault()
	 * @model
	 * @generated
	 */
	boolean isTargetDefault();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.compare.cmodel.EDiffSetting#isTargetDefault <em>Target Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Default</em>' attribute.
	 * @see #isTargetDefault()
	 * @generated
	 */
	void setTargetDefault(boolean value);

} // ESettingRef
