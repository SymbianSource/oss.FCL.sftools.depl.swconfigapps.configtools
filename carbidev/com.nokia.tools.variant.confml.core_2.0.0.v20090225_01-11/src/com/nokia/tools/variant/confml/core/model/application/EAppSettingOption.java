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
 * <!-- begin-user-doc --> Setting type option element as per ConfML
 * specification (union from v1 and v2). <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.EAppSettingOption#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.EAppSettingOption#getLiteralValue <em>Literal Value</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.EAppSettingOption#getRelevant <em>Relevant</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.EAppSettingOption#getRefValue <em>Ref Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppSettingOption()
 * @model
 * @generated
 */
public interface EAppSettingOption extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppSettingOption_Name()
     * @model required="true"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link com.nokia.tools.variant.confml.core.model.application.EAppSettingOption#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * Sets the value of the '<em><b>Name</b></em>' attribute.
     * </p>
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Literal Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * Returns the value of the '<em><b>Literal Value</b></em>' attribute.
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Literal Value</em>' attribute.
     * @see #setLiteralValue(String)
     * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppSettingOption_LiteralValue()
     * @model
     * @generated
     */
    String getLiteralValue();

    /**
     * Sets the value of the '{@link com.nokia.tools.variant.confml.core.model.application.EAppSettingOption#getLiteralValue <em>Literal Value</em>}' attribute.
     * <!-- begin-user-doc --> Sets the value of the '
     * {@link com.nokia.tools.variant.confml.core.model.application.EAppSettingOption#getLiteralValue
     * <em>Literal Value</em>}' attribute. <!-- end-user-doc -->
     * @param value the new value of the '<em>Literal Value</em>' attribute.
     * @see #getLiteralValue()
     * @generated
     */
    void setLiteralValue(String value);

    /**
     * Returns the value of the '<em><b>Relevant</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * Returns the value of the '<em><b>Relevant</b></em>' containment
     * reference.
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Relevant</em>' containment reference.
     * @see #setRelevant(EAppExpression)
     * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppSettingOption_Relevant()
     * @model containment="true"
     * @generated
     */
    EAppExpression getRelevant();

    /**
     * Sets the value of the '{@link com.nokia.tools.variant.confml.core.model.application.EAppSettingOption#getRelevant <em>Relevant</em>}' containment reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @param value the new value of the '<em>Relevant</em>' containment reference.
     * @see #getRelevant()
     * @generated
     */
    void setRelevant(EAppExpression value);

    /**
     * Returns the value of the '<em><b>Ref Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * Returns the value of the '<em><b>Ref</b></em>' attribute.
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ref Value</em>' attribute.
     * @see #setRefValue(String)
     * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppSettingOption_RefValue()
     * @model
     * @generated
     */
    String getRefValue();

    /**
     * Sets the value of the '{@link com.nokia.tools.variant.confml.core.model.application.EAppSettingOption#getRefValue <em>Ref Value</em>}' attribute.
     * <!-- begin-user-doc --> Sets the value of the '
     * {@link com.nokia.tools.variant.confml.core.model.application.EAppSettingOption#getRefValue
     * <em>Ref Value</em>}' attribute. <!-- end-user-doc -->
     * @param value the new value of the '<em>Ref Value</em>' attribute.
     * @see #getRefValue()
     * @generated
     */
    void setRefValue(String value);

} // EAppSettingOption
