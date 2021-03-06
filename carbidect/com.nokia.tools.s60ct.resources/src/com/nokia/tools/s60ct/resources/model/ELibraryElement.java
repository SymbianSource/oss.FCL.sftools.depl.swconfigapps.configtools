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
 * Description: This file is part of com.nokia.tools.variant.resourcelibrary component.
 */

package com.nokia.tools.s60ct.resources.model;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.nokia.tools.s60ct.content.confml.Setting;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File System Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.resources.model.ELibraryElement#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.resources.model.ELibraryElement#getSettings <em>Settings</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.resources.model.ELibraryElement#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.resources.model.ELibraryElement#getNote <em>Note</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.resources.model.ELibraryElement#getTimestamp <em>Timestamp</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.resources.model.ELibraryElement#getPath2 <em>Path2</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.resources.model.ELibraryElement#isResourceFromTopLayer <em>Resource From Top Layer</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.s60ct.resources.model.ELibraryModelPackage#getELibraryElement()
 * @model abstract="true"
 * @generated
 */
public interface ELibraryElement extends EObject {
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
	 * @see com.nokia.tools.s60ct.resources.model.ELibraryModelPackage#getELibraryElement_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.resources.model.ELibraryElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Settings</b></em>' reference list.
	 * The list contents are of type {@link com.nokia.tools.variant.content.confml.Setting}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Settings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Settings</em>' reference list.
	 * @see com.nokia.tools.s60ct.resources.model.ELibraryModelPackage#getELibraryElement_Settings()
	 * @model
	 * @generated
	 */
	EList<Setting> getSettings();

	/**
	 * Returns the value of the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Read Only</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Read Only</em>' attribute.
	 * @see #setReadOnly(boolean)
	 * @see com.nokia.tools.s60ct.resources.model.ELibraryModelPackage#getELibraryElement_ReadOnly()
	 * @model
	 * @generated
	 */
	boolean isReadOnly();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.resources.model.ELibraryElement#isReadOnly <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Read Only</em>' attribute.
	 * @see #isReadOnly()
	 * @generated
	 */
	void setReadOnly(boolean value);

	/**
	 * Returns the value of the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Note</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Note</em>' attribute.
	 * @see #setNote(String)
	 * @see com.nokia.tools.s60ct.resources.model.ELibraryModelPackage#getELibraryElement_Note()
	 * @model
	 * @generated
	 */
	String getNote();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.resources.model.ELibraryElement#getNote <em>Note</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Note</em>' attribute.
	 * @see #getNote()
	 * @generated
	 */
	void setNote(String value);

	/**
	 * Returns the value of the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timestamp</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timestamp</em>' attribute.
	 * @see #setTimestamp(long)
	 * @see com.nokia.tools.s60ct.resources.model.ELibraryModelPackage#getELibraryElement_Timestamp()
	 * @model
	 * @generated
	 */
	long getTimestamp();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.resources.model.ELibraryElement#getTimestamp <em>Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timestamp</em>' attribute.
	 * @see #getTimestamp()
	 * @generated
	 */
	void setTimestamp(long value);

	/**
	 * Returns the value of the '<em><b>Path2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path2</em>' attribute.
	 * @see com.nokia.tools.s60ct.resources.model.ELibraryModelPackage#getELibraryElement_Path2()
	 * @model dataType="com.nokia.tools.variant.resourcelibrary.model.Eclipse_IPath" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	IPath getPath2();

	/**
	 * Returns the value of the '<em><b>Resource From Top Layer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource From Top Layer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource From Top Layer</em>' attribute.
	 * @see #setResourceFromTopLayer(boolean)
	 * @see com.nokia.tools.s60ct.resources.model.ELibraryModelPackage#getELibraryElement_ResourceFromTopLayer()
	 * @model
	 * @generated
	 */
	boolean isResourceFromTopLayer();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.resources.model.ELibraryElement#isResourceFromTopLayer <em>Resource From Top Layer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource From Top Layer</em>' attribute.
	 * @see #isResourceFromTopLayer()
	 * @generated
	 */
	void setResourceFromTopLayer(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */

	String getPath();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	@Deprecated
	String getFullPath();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	@Deprecated
	boolean delete();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	@Deprecated
	boolean move(ELibraryDirectory target);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	@Deprecated
	boolean copy(ELibraryDirectory target);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean touchedByReadonlySetting();

} // FileSystemElement
