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
 * Description: This file is part of com.nokia.tools.vct.ibyml component.
 */

package com.nokia.tools.vct.ibyml.ibymodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EIBY Document</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.ibyml.ibymodel.EIBYDocument#getRoot <em>Root</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.ibyml.ibymodel.EIBYModelPackage#getEIBYDocument()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface EIBYDocument extends EObject {
	/**
	 * Returns the value of the '<em><b>Root</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' containment reference.
	 * @see #setRoot(EIBYFile)
	 * @see com.nokia.tools.vct.ibyml.ibymodel.EIBYModelPackage#getEIBYDocument_Root()
	 * @model containment="true"
	 *        extendedMetaData="name='ibyfile' kind='element' namespace='##targetNamespace'"
	 * @generated
	 */
	EIBYFile getRoot();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.ibyml.ibymodel.EIBYDocument#getRoot <em>Root</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root</em>' containment reference.
	 * @see #getRoot()
	 * @generated
	 */
	void setRoot(EIBYFile value);

} // EIBYDocument
