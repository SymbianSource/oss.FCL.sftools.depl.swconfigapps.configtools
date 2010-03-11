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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Theme File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.resources.model.ELibraryThemeFile#getValidationMessage <em>Validation Message</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.resources.model.ELibraryThemeFile#getCpfPlatformId <em>Cpf Platform Id</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.resources.model.ELibraryThemeFile#getThemePlatformId <em>Theme Platform Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.s60ct.resources.model.ELibraryModelPackage#getELibraryThemeFile()
 * @model
 * @generated
 */
public interface ELibraryThemeFile extends ELibraryFile {
	/**
	 * Returns the value of the '<em><b>Validation Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validation Message</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validation Message</em>' attribute.
	 * @see #setValidationMessage(String)
	 * @see com.nokia.tools.s60ct.resources.model.ELibraryModelPackage#getELibraryThemeFile_ValidationMessage()
	 * @model
	 * @generated
	 */
	String getValidationMessage();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.resources.model.ELibraryThemeFile#getValidationMessage <em>Validation Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validation Message</em>' attribute.
	 * @see #getValidationMessage()
	 * @generated
	 */
	void setValidationMessage(String value);

	/**
	 * Returns the value of the '<em><b>Cpf Platform Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cpf Platform Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cpf Platform Id</em>' attribute.
	 * @see #setCpfPlatformId(String)
	 * @see com.nokia.tools.s60ct.resources.model.ELibraryModelPackage#getELibraryThemeFile_CpfPlatformId()
	 * @model
	 * @generated
	 */
	String getCpfPlatformId();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.resources.model.ELibraryThemeFile#getCpfPlatformId <em>Cpf Platform Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cpf Platform Id</em>' attribute.
	 * @see #getCpfPlatformId()
	 * @generated
	 */
	void setCpfPlatformId(String value);

	/**
	 * Returns the value of the '<em><b>Theme Platform Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Theme Platform Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Theme Platform Id</em>' attribute.
	 * @see #setThemePlatformId(String)
	 * @see com.nokia.tools.s60ct.resources.model.ELibraryModelPackage#getELibraryThemeFile_ThemePlatformId()
	 * @model
	 * @generated
	 */
	String getThemePlatformId();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.resources.model.ELibraryThemeFile#getThemePlatformId <em>Theme Platform Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Theme Platform Id</em>' attribute.
	 * @see #getThemePlatformId()
	 * @generated
	 */
	void setThemePlatformId(String value);

} // ThemeFile
