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
 * Description: This file is part of com.nokia.tools.vct.confml.editor.view component.
 */

package com.nokia.tools.vct.confml.editor.view.vemodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EIcon Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.EIconContainer#getIconUri <em>Icon Uri</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.EIconContainer#getIconUriTitle <em>Icon Uri Title</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage#getEIconContainer()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface EIconContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Icon Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon Uri</em>' attribute.
	 * @see #setIconUri(String)
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage#getEIconContainer_IconUri()
	 * @model
	 * @generated
	 */
	String getIconUri();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EIconContainer#getIconUri <em>Icon Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon Uri</em>' attribute.
	 * @see #getIconUri()
	 * @generated
	 */
	void setIconUri(String value);

	/**
	 * Returns the value of the '<em><b>Icon Uri Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon Uri Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon Uri Title</em>' attribute.
	 * @see #setIconUriTitle(String)
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage#getEIconContainer_IconUriTitle()
	 * @model
	 * @generated
	 */
	String getIconUriTitle();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EIconContainer#getIconUriTitle <em>Icon Uri Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon Uri Title</em>' attribute.
	 * @see #getIconUriTitle()
	 * @generated
	 */
	void setIconUriTitle(String value);

} // EIconContainer
