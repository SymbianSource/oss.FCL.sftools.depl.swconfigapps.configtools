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
 * Description: This file is part of com.nokia.tools.variant.views component.
 */

package com.nokia.tools.variant.views.errormodel;

import org.eclipse.emf.ecore.EObject;

import com.nokia.tools.variant.content.confml.Setting;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Error</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.views.errormodel.Error#getSetting <em>Setting</em>}</li>
 *   <li>{@link com.nokia.tools.variant.views.errormodel.Error#getDescription <em>Description</em>}</li>
 *   <li>{@link com.nokia.tools.variant.views.errormodel.Error#getLocation <em>Location</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.variant.views.errormodel.ErrormodelPackage#getError()
 * @model
 * @generated
 */
public interface Error extends EObject {
	/**
	 * Returns the value of the '<em><b>Setting</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Setting</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Setting</em>' reference.
	 * @see #setSetting(Setting)
	 * @see com.nokia.tools.variant.views.errormodel.ErrormodelPackage#getError_Setting()
	 * @model
	 * @generated
	 */
	Setting getSetting();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.views.errormodel.Error#getSetting <em>Setting</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Setting</em>' reference.
	 * @see #getSetting()
	 * @generated
	 */
	void setSetting(Setting value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see com.nokia.tools.variant.views.errormodel.ErrormodelPackage#getError_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.views.errormodel.Error#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(String)
	 * @see com.nokia.tools.variant.views.errormodel.ErrormodelPackage#getError_Location()
	 * @model
	 * @generated
	 */
	String getLocation();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.views.errormodel.Error#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(String value);

} // Error
