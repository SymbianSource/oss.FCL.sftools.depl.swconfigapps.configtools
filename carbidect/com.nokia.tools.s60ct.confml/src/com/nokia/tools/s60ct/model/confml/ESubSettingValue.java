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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ESub Setting Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESubSettingValue#getSimpleSetting <em>Simple Setting</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESubSettingValue()
 * @model
 * @generated
 */
public interface ESubSettingValue extends EObject {
	/**
	 * Returns the value of the '<em><b>Simple Setting</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Setting</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Setting</em>' reference.
	 * @see #setSimpleSetting(ESimpleSetting)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESubSettingValue_SimpleSetting()
	 * @model
	 * @generated
	 */
	ESimpleSetting getSimpleSetting();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESubSettingValue#getSimpleSetting <em>Simple Setting</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Setting</em>' reference.
	 * @see #getSimpleSetting()
	 * @generated
	 */
	void setSimpleSetting(ESimpleSetting value);

} // ESubSettingValue
