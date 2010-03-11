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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EBackup</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.EBackup#isBackup <em>Backup</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getEBackup()
 * @model interface="true" abstract="true"
 *        extendedMetaData="name='backupType' kind='elementOnly'"
 * @generated
 */
public interface EBackup extends EObject {
	/**
	 * Returns the value of the '<em><b>Backup</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Backup</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Backup</em>' attribute.
	 * @see #setBackup(boolean)
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getEBackup_Backup()
	 * @model
	 * @generated
	 */
	boolean isBackup();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.crml.crmodel.EBackup#isBackup <em>Backup</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Backup</em>' attribute.
	 * @see #isBackup()
	 * @generated
	 */
	void setBackup(boolean value);

} // EBackup
