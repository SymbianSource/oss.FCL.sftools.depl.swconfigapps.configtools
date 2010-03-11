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
 * A representation of the model object '<em><b>EDescription Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.EDescriptionContainer#getDescriptionText <em>Description Text</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.EDescriptionContainer#getDescriptionUri <em>Description Uri</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.EDescriptionContainer#getDescriptionUriTitle <em>Description Uri Title</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage#getEDescriptionContainer()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface EDescriptionContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Description Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description Text</em>' attribute.
	 * @see #setDescriptionText(String)
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage#getEDescriptionContainer_DescriptionText()
	 * @model
	 * @generated
	 */
	String getDescriptionText();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EDescriptionContainer#getDescriptionText <em>Description Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description Text</em>' attribute.
	 * @see #getDescriptionText()
	 * @generated
	 */
	void setDescriptionText(String value);

	/**
	 * Returns the value of the '<em><b>Description Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description Uri</em>' attribute.
	 * @see #setDescriptionUri(String)
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage#getEDescriptionContainer_DescriptionUri()
	 * @model
	 * @generated
	 */
	String getDescriptionUri();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EDescriptionContainer#getDescriptionUri <em>Description Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description Uri</em>' attribute.
	 * @see #getDescriptionUri()
	 * @generated
	 */
	void setDescriptionUri(String value);

	/**
	 * Returns the value of the '<em><b>Description Uri Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description Uri Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description Uri Title</em>' attribute.
	 * @see #setDescriptionUriTitle(String)
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage#getEDescriptionContainer_DescriptionUriTitle()
	 * @model
	 * @generated
	 */
	String getDescriptionUriTitle();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EDescriptionContainer#getDescriptionUriTitle <em>Description Uri Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description Uri Title</em>' attribute.
	 * @see #getDescriptionUriTitle()
	 * @generated
	 */
	void setDescriptionUriTitle(String value);

} // EDescriptionContainer
