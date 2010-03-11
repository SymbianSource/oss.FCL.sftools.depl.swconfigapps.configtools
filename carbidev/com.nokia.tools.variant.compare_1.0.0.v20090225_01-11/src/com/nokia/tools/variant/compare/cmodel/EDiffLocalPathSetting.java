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
 * A representation of the model object '<em><b>EDiff Local Path Setting</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.EDiffLocalPathSetting#getUri <em>Uri</em>}</li>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.EDiffLocalPathSetting#isEqualContent <em>Equal Content</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.variant.compare.cmodel.ECompareModelPackage#getEDiffLocalPathSetting()
 * @model
 * @generated
 */
public interface EDiffLocalPathSetting extends EDiffSimple {
	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(String)
	 * @see com.nokia.tools.variant.compare.cmodel.ECompareModelPackage#getEDiffLocalPathSetting_Uri()
	 * @model
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.compare.cmodel.EDiffLocalPathSetting#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

	/**
	 * Returns the value of the '<em><b>Equal Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Equal Content</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Equal Content</em>' attribute.
	 * @see #setEqualContent(boolean)
	 * @see com.nokia.tools.variant.compare.cmodel.ECompareModelPackage#getEDiffLocalPathSetting_EqualContent()
	 * @model
	 * @generated
	 */
	boolean isEqualContent();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.compare.cmodel.EDiffLocalPathSetting#isEqualContent <em>Equal Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Equal Content</em>' attribute.
	 * @see #isEqualContent()
	 * @generated
	 */
	void setEqualContent(boolean value);

} // EDiffLocalPathSetting
