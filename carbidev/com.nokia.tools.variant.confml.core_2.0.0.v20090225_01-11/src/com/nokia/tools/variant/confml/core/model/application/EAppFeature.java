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

import org.eclipse.emf.common.util.EMap;

/**
 * <!-- begin-user-doc -->
 * <p>
 * Feature container for application model. This element contains
 * feature-specific type information and provides access to settings defined in
 * the feature's scope.
 * </p>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.EAppFeature#getSettings <em>Settings</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.EAppFeature#getRelevant <em>Relevant</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.EAppFeature#getRef <em>Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppFeature()
 * @model
 * @generated
 */
public interface EAppFeature extends EAppDescriptionContainer,
        EAppIconContainer, EAppNamedItem {
    /**
     * Returns the value of the '<em><b>Settings</b></em>' map.
     * The key is of type {@link java.lang.String},
     * and the value is of type {@link com.nokia.tools.variant.confml.core.model.application.EAppSetting},
     * <!-- begin-user-doc -->
     * <p>
     * Get access of named settings within current feature. The returned list of
     * map entries contain {@link String setting REF} as a key and setting
     * container as a value. List is sorted according to type declaration inside
     * ConfML
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Settings</em>' map.
     * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppFeature_Settings()
     * @model mapType="com.nokia.tools.variant.confml.core.model.application.EAppSettingEntry<org.eclipse.emf.ecore.EString, com.nokia.tools.variant.confml.core.model.application.EAppSetting>"
     * @generated
     */
    EMap<String, EAppSetting> getSettings();

    /**
     * Returns the value of the '<em><b>Relevant</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * Get expression evaluator for "relevant" attribute.
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Relevant</em>' containment reference.
     * @see #setRelevant(EAppExpression)
     * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppFeature_Relevant()
     * @model containment="true"
     * @generated
     */
    EAppExpression getRelevant();

    /**
     * Sets the value of the '{@link com.nokia.tools.variant.confml.core.model.application.EAppFeature#getRelevant <em>Relevant</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * Set expression evaluator for "relevant" attribute.
     * </p>
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Relevant</em>' containment reference.
     * @see #getRelevant()
     * @generated
     */
    void setRelevant(EAppExpression value);

    /**
     * <p>
     * Calculate REF attribute of the feature. This attribute is available only
     * when feature is properly contained to ConfML layer.
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Ref</em>' attribute.
     * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppFeature_Ref()
     * @model default="" transient="true" changeable="false" volatile="true"
     * @generated
     */
    String getRef();

    /**
    /**
     * <!-- begin-user-doc --> Compute if this data item is relevant.
     * <p>
     * This method uses the expression evaluator
     * </p>
     * <!-- end-user-doc -->
     * 
     * @model
     * @generated
     */
    boolean computeRelevant();

} // EAppFeature
