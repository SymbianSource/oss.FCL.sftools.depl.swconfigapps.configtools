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
 * Description: This file is part of com.nokia.tools.variant.confml.core component.
 */

package com.nokia.tools.variant.confml.core.model.application;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * <p>
 * A representation of the model object '<em><b>Property</b></em>'.
 * </p>
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link #getName <em>Name</em>}</li>
 * <li>
 * {@link #getValue <em>Value</em>}</li>
 * <li>
 * {@link #getUnit <em>Unit</em>}</li>
 * </ul>
 * </p>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.EAppProperty#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.EAppProperty#getValue <em>Value</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.EAppProperty#getUnit <em>Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppProperty()
 * @model
 * @generated
 */
public interface EAppProperty extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppProperty_Name()
     * @model
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link com.nokia.tools.variant.confml.core.model.application.EAppProperty#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * Changes the value of the '<em><b>Name</b></em>' attribute.
     * </p>
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * Returns the value of the '<em><b>Value</b></em>' attribute.
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Value</em>' attribute.
     * @see #setValue(String)
     * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppProperty_Value()
     * @model
     * @generated
     */
    String getValue();

    /**
     * Sets the value of the '{@link com.nokia.tools.variant.confml.core.model.application.EAppProperty#getValue <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * Sets the value of the '<em><b>Value</b></em>' attribute.
     * </p>
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value</em>' attribute.
     * @see #getValue()
     * @generated
     */
    void setValue(String value);

    /**
     * Returns the value of the '<em><b>Unit</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * Returns the value of the '<em><b>Unit</b></em>' attribute.
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Unit</em>' attribute.
     * @see #setUnit(String)
     * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppProperty_Unit()
     * @model
     * @generated
     */
    String getUnit();

    /**
     * Sets the value of the '{@link com.nokia.tools.variant.confml.core.model.application.EAppProperty#getUnit <em>Unit</em>}' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * Returns the value of the '<em><b>Unit</b></em>' attribute.
     * </p>
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Unit</em>' attribute.
     * @see #getUnit()
     * @generated
     */
    void setUnit(String value);

} // EAppProperty
