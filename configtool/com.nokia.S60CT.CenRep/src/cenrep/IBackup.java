/*
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
*/
package cenrep;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IBackup</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cenrep.IBackup#isBackup <em>Backup</em>}</li>
 * </ul>
 * </p>
 *
 * @see cenrep.CenrepPackage#getIBackup()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IBackup extends EObject {
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
	 * @see cenrep.CenrepPackage#getIBackup_Backup()
	 * @model
	 * @generated
	 */
	boolean isBackup();

	/**
	 * Sets the value of the '{@link cenrep.IBackup#isBackup <em>Backup</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Backup</em>' attribute.
	 * @see #isBackup()
	 * @generated
	 */
	void setBackup(boolean value);

} // IBackup
