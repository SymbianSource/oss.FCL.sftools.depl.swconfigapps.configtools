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
 * A representation of the model object '<em><b>EResource Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.EResourceValue#getLocalPath <em>Local Path</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.EResourceValue#getTargetPath <em>Target Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getEResourceValue()
 * @model
 * @generated
 */
public interface EResourceValue extends ECompositeValue {
	/**
	 * Returns the value of the '<em><b>Local Path</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Path</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Path</em>' reference.
	 * @see #setLocalPath(ESettingValue)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getEResourceValue_LocalPath()
	 * @model
	 * @generated
	 */
	ESettingValue getLocalPath();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.EResourceValue#getLocalPath <em>Local Path</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Path</em>' reference.
	 * @see #getLocalPath()
	 * @generated
	 */
	void setLocalPath(ESettingValue value);

	/**
	 * Returns the value of the '<em><b>Target Path</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Path</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Path</em>' reference.
	 * @see #setTargetPath(ESettingValue)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getEResourceValue_TargetPath()
	 * @model
	 * @generated
	 */
	ESettingValue getTargetPath();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.EResourceValue#getTargetPath <em>Target Path</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Path</em>' reference.
	 * @see #getTargetPath()
	 * @generated
	 */
	void setTargetPath(ESettingValue value);

} // EResourceValue
