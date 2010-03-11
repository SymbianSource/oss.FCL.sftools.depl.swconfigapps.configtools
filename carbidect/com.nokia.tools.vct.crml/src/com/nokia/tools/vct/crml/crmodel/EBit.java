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
 * Description: This file is part of com.nokia.tools.vct.crml component.
 */

package com.nokia.tools.vct.crml.crmodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EBit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.EBit#isState <em>State</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getEBit()
 * @model extendedMetaData="name='bitType' kind='simple'"
 * @generated
 */
public interface EBit extends EContent, ERefContainer {
	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see #setState(boolean)
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getEBit_State()
	 * @model id="true"
	 *        extendedMetaData="name='value' kind='attribute'"
	 * @generated
	 */
	boolean isState();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.crml.crmodel.EBit#isState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see #isState()
	 * @generated
	 */
	void setState(boolean value);

} // EBit
