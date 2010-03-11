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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Theme File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.resourcelibrary.model.ThemeFile#getValidationMessage <em>Validation Message</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.variant.resourcelibrary.model.resourcesPackage#getThemeFile()
 * @model
 * @generated
 */
public interface ThemeFile extends File {
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
	 * @see com.nokia.tools.variant.resourcelibrary.model.resourcesPackage#getThemeFile_ValidationMessage()
	 * @model
	 * @generated
	 */
	String getValidationMessage();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.resourcelibrary.model.ThemeFile#getValidationMessage <em>Validation Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validation Message</em>' attribute.
	 * @see #getValidationMessage()
	 * @generated
	 */
	void setValidationMessage(String value);

} // ThemeFile
