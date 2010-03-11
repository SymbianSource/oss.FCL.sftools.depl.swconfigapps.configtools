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
 * A representation of the model object '<em><b>EEntry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.ibyml.ibymodel.EEntry#getSource <em>Source</em>}</li>
 *   <li>{@link com.nokia.tools.vct.ibyml.ibymodel.EEntry#getTarget <em>Target</em>}</li>
 *   <li>{@link com.nokia.tools.vct.ibyml.ibymodel.EEntry#getFileName <em>File Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.ibyml.ibymodel.EIBYModelPackage#getEEntry()
 * @model extendedMetaData="name='entryType' kind='elementOnly'"
 * @generated
 */
public interface EEntry extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' containment reference.
	 * @see #setSource(EEntity)
	 * @see com.nokia.tools.vct.ibyml.ibymodel.EIBYModelPackage#getEEntry_Source()
	 * @model containment="true"
	 *        extendedMetaData="name='source' kind='element' namespace='##targetNamespace'"
	 * @generated
	 */
	EEntity getSource();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.ibyml.ibymodel.EEntry#getSource <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(EEntity value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(EEntity)
	 * @see com.nokia.tools.vct.ibyml.ibymodel.EIBYModelPackage#getEEntry_Target()
	 * @model containment="true"
	 *        extendedMetaData="name='target' kind='element' namespace='##targetNamespace'"
	 * @generated
	 */
	EEntity getTarget();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.ibyml.ibymodel.EEntry#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(EEntity value);

	/**
	 * Returns the value of the '<em><b>File Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Name</em>' containment reference.
	 * @see #setFileName(EFileName)
	 * @see com.nokia.tools.vct.ibyml.ibymodel.EIBYModelPackage#getEEntry_FileName()
	 * @model containment="true"
	 *        extendedMetaData="name='fileName' kind='element' namespace='##targetNamespace'"
	 * @generated
	 */
	EFileName getFileName();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.ibyml.ibymodel.EEntry#getFileName <em>File Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Name</em>' containment reference.
	 * @see #getFileName()
	 * @generated
	 */
	void setFileName(EFileName value);

} // EEntry
