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
 * Description: This file is part of com.nokia.tools.vct.common.appmodel component.
 */

package com.nokia.tools.vct.common.appmodel;


/**
 * <!-- begin-user-doc --> Abstract data instance for a setting. The data object
 * is always linked to the type information. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppSettingData#getTypeInfo <em>Type Info</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppSettingData()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface EAppSettingData extends ESourceLocator {

    /**
     * Returns the value of the '<em><b>Type Info</b></em>' reference. <!--
     * begin-user-doc -->
     * <p>
     * Get type information regarding this data instance.
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Type Info</em>' reference.
     * @see #setTypeInfo(EAppSettingType)
     * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppSettingData_TypeInfo()
     * @model required="true"
     * @generated
     */
    EAppSettingType getTypeInfo();

    /**
     * <p>
     * Sets type information regarding this data instance.
     * </p>
     * 
     * @param value the new value of the '<em>Type Info</em>' reference.
     * @see #getTypeInfo()
     * @generated
     */
    void setTypeInfo(EAppSettingType value);

    /**
	 * <!-- begin-user-doc --> Compute if this data item is relevant.
     * <p>
     * This method uses the expression evaluator attached to the type
     * information
     * </p>
     * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
    boolean computeRelevant();

    /**
	 * <!-- begin-user-doc --> Compute if this data item is valid.
     * <p>
     * This method uses the expression evaluator attached to the type
     * information
     * </p>
     * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
    boolean computeConstraint();
} // EAppSettingData
