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
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ESetting Value Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESettingValueContainer#getSubSettings <em>Sub Settings</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESettingValueContainer()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ESettingValueContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Sub Settings</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.s60ct.model.confml.ESettingValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Settings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Settings</em>' containment reference list.
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESettingValueContainer_SubSettings()
	 * @model containment="true"
	 * @generated
	 */
	EList<ESettingValue> getSubSettings();

} // ESettingValueContainer
