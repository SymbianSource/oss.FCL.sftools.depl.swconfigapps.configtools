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
 * Description: This file is part of com.nokia.tools.vct.gcfml component.
 */

package com.nokia.tools.vct.gcfml.gcfmlmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EGCFMLDocumentRoot#getFile <em>File</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.EGCFMLPackage#getEGCFMLDocumentRoot()
 * @model
 * @generated
 */
public interface EGCFMLDocumentRoot extends EObject {
	/**
	 * Returns the value of the '<em><b>File</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File</em>' containment reference.
	 * @see #setFile(EFile)
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.EGCFMLPackage#getEGCFMLDocumentRoot_File()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EFile getFile();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EGCFMLDocumentRoot#getFile <em>File</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File</em>' containment reference.
	 * @see #getFile()
	 * @generated
	 */
	void setFile(EFile value);

} // EGCFMLDocumentRoot
