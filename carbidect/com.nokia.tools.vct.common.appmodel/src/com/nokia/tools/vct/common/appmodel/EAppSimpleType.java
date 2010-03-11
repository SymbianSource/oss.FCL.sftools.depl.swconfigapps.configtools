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
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>EApp Simple Type</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppSimpleType#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppSimpleType()
 * @model
 * @generated
 */
public interface EAppSimpleType extends EAppSettingType, EAppOptionContainer {
    /**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link com.nokia.tools.vct.common.appmodel.EAppValueType}.
	 * <!-- begin-user-doc -->
     * <p>
     * Returns the value of the '<em><b>Type</b></em>' attribute. The literals
     * are from the enumeration
     * {@link com.nokia.tools.vct.common.appmodel.EAppValueType}
     * .
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see com.nokia.tools.vct.common.appmodel.EAppValueType
	 * @see #setType(EAppValueType)
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppSimpleType_Type()
	 * @model required="true"
	 * @generated
	 */
    EAppValueType getType();

    /**
	 * Sets the value of the '{@link com.nokia.tools.vct.common.appmodel.EAppSimpleType#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see com.nokia.tools.vct.common.appmodel.EAppValueType
	 * @see #getType()
	 * @generated
	 */
    void setType(EAppValueType value);

} // EAppSimpleType
