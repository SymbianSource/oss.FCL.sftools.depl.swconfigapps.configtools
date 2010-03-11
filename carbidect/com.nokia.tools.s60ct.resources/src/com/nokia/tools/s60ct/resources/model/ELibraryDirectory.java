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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Directory</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.resources.model.ELibraryDirectory#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.s60ct.resources.model.ELibraryModelPackage#getELibraryDirectory()
 * @model
 * @generated
 */
public interface ELibraryDirectory extends ELibraryElement {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.s60ct.resources.model.ELibraryElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see com.nokia.tools.s60ct.resources.model.ELibraryModelPackage#getELibraryDirectory_Children()
	 * @model containment="true"
	 * @generated
	 */
	EList<ELibraryElement> getChildren();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ELibraryElement getChild(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model childUnique="false"
	 * @generated
	 */
	boolean addChild(ELibraryElement child);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	int getSize();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean deleteOnFileSystem();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model pathDataType="com.nokia.tools.variant.resourcelibrary.model.Eclipse_IPath" pathRequired="true"
	 * @generated
	 */
	ELibraryElement findChild(IPath path);

} // Directory
