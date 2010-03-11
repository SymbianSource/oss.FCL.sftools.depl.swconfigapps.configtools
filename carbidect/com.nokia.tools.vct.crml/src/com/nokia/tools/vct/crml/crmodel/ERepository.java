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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ERepository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.ERepository#getVersion <em>Version</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.ERepository#getUidName <em>Uid Name</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.ERepository#getUidValue <em>Uid Value</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.ERepository#getInitialisationFileVersion <em>Initialisation File Version</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.ERepository#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.ERepository#isRfs <em>Rfs</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.ERepository#getKey <em>Key</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.ERepository#getMeta <em>Meta</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.ERepository#getRangeKey <em>Range Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getERepository()
 * @model extendedMetaData="name='repository' kind='elementOnly'"
 * @generated
 */
public interface ERepository extends EAttributeAndDescription, EAccessContainer, EBackup {
	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getERepository_Version()
	 * @model
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.crml.crmodel.ERepository#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Uid Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uid Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uid Name</em>' attribute.
	 * @see #setUidName(String)
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getERepository_UidName()
	 * @model
	 * @generated
	 */
	String getUidName();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.crml.crmodel.ERepository#getUidName <em>Uid Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uid Name</em>' attribute.
	 * @see #getUidName()
	 * @generated
	 */
	void setUidName(String value);

	/**
	 * Returns the value of the '<em><b>Uid Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uid Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uid Value</em>' attribute.
	 * @see #setUidValue(String)
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getERepository_UidValue()
	 * @model
	 * @generated
	 */
	String getUidValue();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.crml.crmodel.ERepository#getUidValue <em>Uid Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uid Value</em>' attribute.
	 * @see #getUidValue()
	 * @generated
	 */
	void setUidValue(String value);

	/**
	 * Returns the value of the '<em><b>Initialisation File Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initialisation File Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initialisation File Version</em>' attribute.
	 * @see #setInitialisationFileVersion(String)
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getERepository_InitialisationFileVersion()
	 * @model
	 * @generated
	 */
	String getInitialisationFileVersion();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.crml.crmodel.ERepository#getInitialisationFileVersion <em>Initialisation File Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialisation File Version</em>' attribute.
	 * @see #getInitialisationFileVersion()
	 * @generated
	 */
	void setInitialisationFileVersion(String value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' attribute.
	 * @see #setOwner(String)
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getERepository_Owner()
	 * @model
	 * @generated
	 */
	String getOwner();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.crml.crmodel.ERepository#getOwner <em>Owner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' attribute.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(String value);

	/**
	 * Returns the value of the '<em><b>Rfs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rfs</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rfs</em>' attribute.
	 * @see #setRfs(boolean)
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getERepository_Rfs()
	 * @model
	 * @generated
	 */
	boolean isRfs();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.crml.crmodel.ERepository#isRfs <em>Rfs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rfs</em>' attribute.
	 * @see #isRfs()
	 * @generated
	 */
	void setRfs(boolean value);

	/**
	 * Returns the value of the '<em><b>Key</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.crml.crmodel.EKey}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key</em>' containment reference list.
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getERepository_Key()
	 * @model containment="true"
	 *        extendedMetaData="name='key' namespace='##targetNamespace' kind='element'"
	 * @generated
	 */
	EList<EKey> getKey();

	/**
	 * Returns the value of the '<em><b>Meta</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta</em>' containment reference.
	 * @see #setMeta(EMeta)
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getERepository_Meta()
	 * @model containment="true"
	 *        extendedMetaData="name='meta' namespace='##targetNamespace' kind='element'"
	 * @generated
	 */
	EMeta getMeta();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.crml.crmodel.ERepository#getMeta <em>Meta</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta</em>' containment reference.
	 * @see #getMeta()
	 * @generated
	 */
	void setMeta(EMeta value);

	/**
	 * Returns the value of the '<em><b>Range Key</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.crml.crmodel.EKeyRange}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Range Key</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Range Key</em>' containment reference list.
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getERepository_RangeKey()
	 * @model containment="true"
	 *        extendedMetaData="name='keyRange' kind='element' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<EKeyRange> getRangeKey();

} // ERepository
