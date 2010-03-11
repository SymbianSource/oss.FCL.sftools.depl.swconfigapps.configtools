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

import java.util.List;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cenrep.Repository#getVersion <em>Version</em>}</li>
 *   <li>{@link cenrep.Repository#getUidName <em>Uid Name</em>}</li>
 *   <li>{@link cenrep.Repository#getUidValue <em>Uid Value</em>}</li>
 *   <li>{@link cenrep.Repository#getInitialisationFileVersion <em>Initialisation File Version</em>}</li>
 *   <li>{@link cenrep.Repository#getOwner <em>Owner</em>}</li>
 *   <li>{@link cenrep.Repository#isRfs <em>Rfs</em>}</li>
 *   <li>{@link cenrep.Repository#getKey <em>Key</em>}</li>
 *   <li>{@link cenrep.Repository#getMeta <em>Meta</em>}</li>
 *   <li>{@link cenrep.Repository#getSimpleKeys <em>Simple Keys</em>}</li>
 *   <li>{@link cenrep.Repository#getBitmaskKeys <em>Bitmask Keys</em>}</li>
 *   <li>{@link cenrep.Repository#getRangeKey <em>Range Key</em>}</li>
 *   <li>{@link cenrep.Repository#getFileName <em>File Name</em>}</li>
 *   <li>{@link cenrep.Repository#getProblems <em>Problems</em>}</li>
 * </ul>
 * </p>
 *
 * @see cenrep.CenrepPackage#getRepository()
 * @model
 * @generated
 */
public interface Repository extends AttributeAndDescription, IAccessable, IBackup {
	/*
	 * sort keys by Key Int in ascending order
	 */
	List sortKeys();
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
	 * @see cenrep.CenrepPackage#getRepository_Version()
	 * @model
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link cenrep.Repository#getVersion <em>Version</em>}' attribute.
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
	 * @see cenrep.CenrepPackage#getRepository_UidName()
	 * @model
	 * @generated
	 */
	String getUidName();

	/**
	 * Sets the value of the '{@link cenrep.Repository#getUidName <em>Uid Name</em>}' attribute.
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
	 * @see cenrep.CenrepPackage#getRepository_UidValue()
	 * @model
	 * @generated
	 */
	String getUidValue();

	/**
	 * Sets the value of the '{@link cenrep.Repository#getUidValue <em>Uid Value</em>}' attribute.
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
	 * @see cenrep.CenrepPackage#getRepository_InitialisationFileVersion()
	 * @model
	 * @generated
	 */
	String getInitialisationFileVersion();

	/**
	 * Sets the value of the '{@link cenrep.Repository#getInitialisationFileVersion <em>Initialisation File Version</em>}' attribute.
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
	 * @see cenrep.CenrepPackage#getRepository_Owner()
	 * @model
	 * @generated
	 */
	String getOwner();

	/**
	 * Sets the value of the '{@link cenrep.Repository#getOwner <em>Owner</em>}' attribute.
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
	 * @see cenrep.CenrepPackage#getRepository_Rfs()
	 * @model
	 * @generated
	 */
	boolean isRfs();
	/**
	 * Sets the value of the '{@link cenrep.Repository#isRfs <em>Rfs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rfs</em>' attribute.
	 * @see #isRfs()
	 * @generated
	 */
	void setRfs(boolean value);
	/**
	 * Returns the value of the '<em><b>Key</b></em>' containment reference list.
	 * The list contents are of type {@link cenrep.Key}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key</em>' containment reference list.
	 * @see cenrep.CenrepPackage#getRepository_Key()
	 * @model containment="true"
	 * @generated
	 */
	EList<Key> getKey();
	
	List getKey(String release);
	
	/**
	 * Returns the value of the '<em><b>Meta</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta</em>' reference.
	 * @see #setMeta(Meta)
	 * @see cenrep.CenrepPackage#getRepository_Meta()
	 * @model
	 * @generated
	 */
	Meta getMeta();

	/**
	 * Sets the value of the '{@link cenrep.Repository#getMeta <em>Meta</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta</em>' reference.
	 * @see #getMeta()
	 * @generated
	 */
	void setMeta(Meta value);

	/**
	 * Returns the value of the '<em><b>Simple Keys</b></em>' reference list.
	 * The list contents are of type {@link cenrep.Key}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Keys</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Keys</em>' reference list.
	 * @see cenrep.CenrepPackage#getRepository_SimpleKeys()
	 * @model transient="true" changeable="false" volatile="true"
	 * @generated
	 */
	EList<Key> getSimpleKeys();
	/**
	 * Returns the value of the '<em><b>Bitmask Keys</b></em>' reference list.
	 * The list contents are of type {@link cenrep.Key}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bitmask Keys</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bitmask Keys</em>' reference list.
	 * @see cenrep.CenrepPackage#getRepository_BitmaskKeys()
	 * @model transient="true" volatile="true"
	 * @generated
	 */
	EList<Key> getBitmaskKeys();
	/**
	 * Returns the value of the '<em><b>Range Key</b></em>' containment reference list.
	 * The list contents are of type {@link cenrep.KeyRange}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Range Key</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Range Key</em>' containment reference list.
	 * @see cenrep.CenrepPackage#getRepository_RangeKey()
	 * @model containment="true"
	 * @generated
	 */
	EList<KeyRange> getRangeKey();
	/**
	 * Returns the value of the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Name</em>' attribute.
	 * @see cenrep.CenrepPackage#getRepository_FileName()
	 * @model transient="true" changeable="false" volatile="true"
	 * @generated
	 */
	String getFileName();
	/**
	 * Returns the value of the '<em><b>Problems</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Problems</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Problems</em>' attribute.
	 * @see cenrep.CenrepPackage#getRepository_Problems()
	 * @model transient="true" changeable="false" volatile="true"
	 * @generated
	 */
	String getProblems();
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean canGenerate();

} // Repository