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

package com.nokia.tools.variant.resourcelibrary.model;

import java.io.InputStream;

import org.eclipse.core.runtime.content.IContentDescription;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.resourcelibrary.model.File#getSize <em>Size</em>}</li>
 *   <li>{@link com.nokia.tools.variant.resourcelibrary.model.File#getContentDescription <em>Content Description</em>}</li>
 *   <li>{@link com.nokia.tools.variant.resourcelibrary.model.File#getDefaultResource <em>Default Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.variant.resourcelibrary.model.resourcesPackage#getFile()
 * @model
 * @generated
 */
public interface File extends FileSystemElement {
	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(long)
	 * @see com.nokia.tools.variant.resourcelibrary.model.resourcesPackage#getFile_Size()
	 * @model
	 * @generated
	 */
	long getSize();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.resourcelibrary.model.File#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(long value);

	/**
	 * Returns the value of the '<em><b>Content Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content Description</em>' attribute.
	 * @see com.nokia.tools.variant.resourcelibrary.model.resourcesPackage#getFile_ContentDescription()
	 * @model dataType="com.nokia.tools.variant.resourcelibrary.model.IContentDescription" transient="true" changeable="false"
	 * @generated
	 */
	IContentDescription getContentDescription();

	/**
	 * Returns the value of the '<em><b>Default Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Resource</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Resource</em>' attribute.
	 * @see #setDefaultResource(java.io.File)
	 * @see com.nokia.tools.variant.resourcelibrary.model.resourcesPackage#getFile_DefaultResource()
	 * @model dataType="com.nokia.tools.variant.resourcelibrary.model.JAVA_IO_FILE"
	 * @generated
	 */
	java.io.File getDefaultResource();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.resourcelibrary.model.File#getDefaultResource <em>Default Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Resource</em>' attribute.
	 * @see #getDefaultResource()
	 * @generated
	 */
	void setDefaultResource(java.io.File value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="com.nokia.tools.variant.resourcelibrary.model.InputStream"
	 * @generated
	 */
	InputStream getInputStream();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void recomputeContentDescription();

} // File
