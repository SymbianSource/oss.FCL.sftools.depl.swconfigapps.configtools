/**
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
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
 * $Id$
 */
package com.nokia.tools.carbide.ct.confml.model.confml1;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ESetting Rfs</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml1.ESettingRfs#getRfs <em>Rfs</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.carbide.ct.confml.model.confml1.EConfML1Package#getESettingRfs()
 * @model extendedMetaData="name='ESettingRfs' kind='simple'"
 * @generated
 */
public interface ESettingRfs extends ERefNamedElement {
	/**
	 * Returns the value of the '<em><b>Rfs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rfs</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rfs</em>' attribute.
	 * @see #setRfs(String)
	 * @see com.nokia.tools.carbide.ct.confml.model.confml1.EConfML1Package#getESettingRfs_Rfs()
	 * @model extendedMetaData="name='rfs' kind='simple'"
	 * @generated
	 */
	String getRfs();

	/**
	 * Sets the value of the '{@link com.nokia.tools.carbide.ct.confml.model.confml1.ESettingRfs#getRfs <em>Rfs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rfs</em>' attribute.
	 * @see #getRfs()
	 * @generated
	 */
	void setRfs(String value);

} // ESettingRfs
