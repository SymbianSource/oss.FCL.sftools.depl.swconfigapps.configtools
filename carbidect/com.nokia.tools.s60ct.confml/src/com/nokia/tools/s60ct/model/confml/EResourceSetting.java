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
 * A representation of the model object '<em><b>EResource Setting</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.EResourceSetting#getKind <em>Kind</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.EResourceSetting#getLocalPath <em>Local Path</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.EResourceSetting#getTargetPath <em>Target Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getEResourceSetting()
 * @model
 * @generated
 */
public interface EResourceSetting extends ECompositeSetting {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link com.nokia.tools.s60ct.model.confml.EResourceKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see com.nokia.tools.s60ct.model.confml.EResourceKind
	 * @see #setKind(EResourceKind)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getEResourceSetting_Kind()
	 * @model required="true"
	 * @generated
	 */
	EResourceKind getKind();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.EResourceSetting#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see com.nokia.tools.s60ct.model.confml.EResourceKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(EResourceKind value);

	/**
	 * Returns the value of the '<em><b>Local Path</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Path</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Path</em>' reference.
	 * @see #setLocalPath(ESetting)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getEResourceSetting_LocalPath()
	 * @model
	 * @generated
	 */
	ESetting getLocalPath();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.EResourceSetting#getLocalPath <em>Local Path</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Path</em>' reference.
	 * @see #getLocalPath()
	 * @generated
	 */
	void setLocalPath(ESetting value);

	/**
	 * Returns the value of the '<em><b>Target Path</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Path</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Path</em>' reference.
	 * @see #setTargetPath(ESetting)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getEResourceSetting_TargetPath()
	 * @model
	 * @generated
	 */
	ESetting getTargetPath();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.EResourceSetting#getTargetPath <em>Target Path</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Path</em>' reference.
	 * @see #getTargetPath()
	 * @generated
	 */
	void setTargetPath(ESetting value);

} // EResourceSetting
