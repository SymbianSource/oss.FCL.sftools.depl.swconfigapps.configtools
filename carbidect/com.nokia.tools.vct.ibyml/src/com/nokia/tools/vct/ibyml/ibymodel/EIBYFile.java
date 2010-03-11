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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EIBY File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.ibyml.ibymodel.EIBYFile#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.vct.ibyml.ibymodel.EIBYFile#getFlag <em>Flag</em>}</li>
 *   <li>{@link com.nokia.tools.vct.ibyml.ibymodel.EIBYFile#getEntries <em>Entries</em>}</li>
 *   <li>{@link com.nokia.tools.vct.ibyml.ibymodel.EIBYFile#getLocations <em>Locations</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.ibyml.ibymodel.EIBYModelPackage#getEIBYFile()
 * @model extendedMetaData="name='ibyFileType' kind='elementOnly'"
 * @generated
 */
public interface EIBYFile extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.nokia.tools.vct.ibyml.ibymodel.EIBYModelPackage#getEIBYFile_Name()
	 * @model extendedMetaData="name='name' kind='attribute'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.ibyml.ibymodel.EIBYFile#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Flag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flag</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flag</em>' attribute.
	 * @see #setFlag(String)
	 * @see com.nokia.tools.vct.ibyml.ibymodel.EIBYModelPackage#getEIBYFile_Flag()
	 * @model extendedMetaData="name='flag' kind='attribute'"
	 * @generated
	 */
	String getFlag();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.ibyml.ibymodel.EIBYFile#getFlag <em>Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flag</em>' attribute.
	 * @see #getFlag()
	 * @generated
	 */
	void setFlag(String value);

	/**
	 * Returns the value of the '<em><b>Entries</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.ibyml.ibymodel.EEntry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entries</em>' containment reference list.
	 * @see com.nokia.tools.vct.ibyml.ibymodel.EIBYModelPackage#getEIBYFile_Entries()
	 * @model containment="true"
	 *        extendedMetaData="name='entry' kind='element' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<EEntry> getEntries();

	/**
	 * Returns the value of the '<em><b>Locations</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.ibyml.ibymodel.EEntity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Locations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Locations</em>' containment reference list.
	 * @see com.nokia.tools.vct.ibyml.ibymodel.EIBYModelPackage#getEIBYFile_Locations()
	 * @model containment="true"
	 *        extendedMetaData="name='location' kind='element' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<EEntity> getLocations();

} // EIBYFile
