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
 * A setting is a root object for accessing setting type and data information.
 * Settings always belong to features
 * </p>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.EAppSetting#getRfsInfo <em>Rfs Info</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.EAppSetting#getTypeInfo <em>Type Info</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.EAppSetting#getValueInfo <em>Value Info</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.EAppSetting#getRef <em>Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppSetting()
 * @model
 * @generated
 */
public interface EAppSetting extends EObject {
    /**
     * Returns the value of the '<em><b>Value Info</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * Get data descriptor for the given setting.
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Value Info</em>' containment reference.
     * @see #setValueInfo(EAppSettingData)
     * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppSetting_ValueInfo()
     * @model containment="true" required="true"
     * @generated
     */
    EAppSettingData getValueInfo();

    /**
     * Sets the value of the '{@link com.nokia.tools.variant.confml.core.model.application.EAppSetting#getValueInfo <em>Value Info</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * Set data descriptor for the given setting.
     * </p>
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value Info</em>' containment reference.
     * @see #getValueInfo()
     * @generated
     */
    void setValueInfo(EAppSettingData value);

    /**
     * Returns the value of the '<em><b>Ref</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * Get '<em>Ref</em>' attribute.
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ref</em>' attribute.
     * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppSetting_Ref()
     * @model transient="true" changeable="false" volatile="true" derived="true"
     * @generated
     */
    String getRef();

    /**
     * Returns the value of the '<em><b>Rfs Info</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * Get RFS descriptor for the given setting.
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Rfs Info</em>' containment reference.
     * @see #setRfsInfo(EAppRfsInfo)
     * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppSetting_RfsInfo()
     * @model containment="true" required="true"
     * @generated
     */
    EAppRfsInfo getRfsInfo();

    /**
     * Sets the value of the '{@link com.nokia.tools.variant.confml.core.model.application.EAppSetting#getRfsInfo <em>Rfs Info</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * Sets RFS descriptor for the given setting.
     * </p>
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Rfs Info</em>' containment reference.
     * @see #getRfsInfo()
     * @generated
     */
    void setRfsInfo(EAppRfsInfo value);

    /**
     * Returns the value of the '<em><b>Type Info</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type Info</em>' reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type Info</em>' containment reference.
     * @see #setTypeInfo(EAppSettingType)
     * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppSetting_TypeInfo()
     * @model containment="true" required="true"
     * @generated
     */
    EAppSettingType getTypeInfo();

    /**
     * Sets the value of the '{@link com.nokia.tools.variant.confml.core.model.application.EAppSetting#getTypeInfo <em>Type Info</em>}' containment reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @param value the new value of the '<em>Type Info</em>' containment reference.
     * @see #getTypeInfo()
     * @generated
     */
    void setTypeInfo(EAppSettingType value);

} // EAppSetting
