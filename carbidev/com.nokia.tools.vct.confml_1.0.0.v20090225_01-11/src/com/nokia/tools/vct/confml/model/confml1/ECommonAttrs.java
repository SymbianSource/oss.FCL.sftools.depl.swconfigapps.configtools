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
 * Description: This file is part of com.nokia.tools.vct.confml component.
 */

package com.nokia.tools.vct.confml.model.confml1;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * <p>
 * Generic type interface for XML objects with ID attribute
 * </p>
 * <!-- end-user-doc -->
 * 
 * @see com.nokia.tools.vct.confml.model.confml1.EConfML1Package#getECommonAttrs()
 * @model extendedMetaData="name='commonAttrsType' kind='elementOnly'"
 * @generated
 */
public interface ECommonAttrs extends EObject {
    /**
     * <!-- begin-user-doc -->
     * <p>
     * Get the value of ID attribute.
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>ID</em>' attribute.
     * @see #setId(String)
     * @see com.nokia.tools.vct.confml.model.confml1.EConfML1Package#getECommonAttrs_Id()
     * @model extendedMetaData="kind='attribute' name='id'"
     * @generated
     */
    String getId();

    /**
     * <!-- begin-user-doc -->
     * <p>
     * Set the value of ID attribute.
     * </p>
     * <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>ID</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(String value);

} // ECommonAttrs
