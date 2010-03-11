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
 * Description: This file is part of com.nokia.tools.vct.ibyml component.
 */

package com.nokia.tools.vct.ibyml.ibymodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EEntity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.ibyml.ibymodel.EEntity#getRef <em>Ref</em>}</li>
 *   <li>{@link com.nokia.tools.vct.ibyml.ibymodel.EEntity#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.ibyml.ibymodel.EIBYModelPackage#getEEntity()
 * @model extendedMetaData="name='entityType' kind='empty'"
 * @generated
 */
public interface EEntity extends EObject {
	/**
	 * Returns the value of the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref</em>' attribute.
	 * @see #setRef(String)
	 * @see com.nokia.tools.vct.ibyml.ibymodel.EIBYModelPackage#getEEntity_Ref()
	 * @model extendedMetaData="name='ref' kind='attribute'"
	 * @generated
	 */
	String getRef();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.ibyml.ibymodel.EEntity#getRef <em>Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref</em>' attribute.
	 * @see #getRef()
	 * @generated
	 */
	void setRef(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see com.nokia.tools.vct.ibyml.ibymodel.EIBYModelPackage#getEEntity_Value()
	 * @model extendedMetaData="name='value' kind='attribute'"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.ibyml.ibymodel.EEntity#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // EEntity
