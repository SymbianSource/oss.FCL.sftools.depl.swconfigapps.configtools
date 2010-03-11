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
 * A representation of the model object '<em><b>Resource Model Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.resourcelibrary.model.ResourceModelRoot#getTempDirPath <em>Temp Dir Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.variant.resourcelibrary.model.resourcesPackage#getResourceModelRoot()
 * @model
 * @generated
 */
public interface ResourceModelRoot extends Directory {
	/**
	 * Returns the value of the '<em><b>Temp Dir Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Temp Dir Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Temp Dir Path</em>' attribute.
	 * @see #setTempDirPath(String)
	 * @see com.nokia.tools.variant.resourcelibrary.model.resourcesPackage#getResourceModelRoot_TempDirPath()
	 * @model
	 * @generated
	 */
	String getTempDirPath();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.resourcelibrary.model.ResourceModelRoot#getTempDirPath <em>Temp Dir Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Temp Dir Path</em>' attribute.
	 * @see #getTempDirPath()
	 * @generated
	 */
	void setTempDirPath(String value);

} // ResourceModelRoot
