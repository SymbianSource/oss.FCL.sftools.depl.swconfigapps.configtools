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

/**
 * <!-- begin-user-doc -->
 * <p>
 * Model object for data section of the "resource" type of ConfML settings.
 * </p>
 * <p>
 * In ConfML v1 the settings contain only local path, and target path is always
 * empty.
 * </p>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.EAppResourceData#getLocalPath <em>Local Path</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.EAppResourceData#getTargetPath <em>Target Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppResourceData()
 * @model
 * @generated
 */
public interface EAppResourceData extends EAppCompositeData {
    /**
     * Returns the value of the '<em><b>Local Path</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * Get the reference of the '<em><b>Local Path</b></em>' sub-setting data.
     * This is a helper method and is equivalent to:
     * <code>getSubSettings().get("localPath").</code>
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Local Path</em>' reference.
     * @see #setLocalPath(EAppSettingData)
     * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppResourceData_LocalPath()
     * @model transient="true" volatile="true"
     * @generated
     */
    EAppSettingData getLocalPath();

    /**
     * Sets the value of the '{@link com.nokia.tools.variant.confml.core.model.application.EAppResourceData#getLocalPath <em>Local Path</em>}' reference.
     * <!-- begin-user-doc -->
     * <p>
     * Set the reference of the '<em><b>Local Path</b></em>' sub-setting data.
     * This is a helper method and is equivalent to:
     * <code>getSubSettings().put("localPath", reference).</code>
     * </p>
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Local Path</em>' reference.
     * @see #getLocalPath()
     * @generated
     */
    void setLocalPath(EAppSettingData value);

    /**
     * Returns the value of the '<em><b>Target Path</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * Get the reference of the '<em><b>Target Path</b></em>' sub-setting data.
     * This is a helper method and is equivalent to:
     * <code>getSubSettings().get("targetPath").</code>
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Target Path</em>' reference.
     * @see #setTargetPath(EAppSettingData)
     * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppResourceData_TargetPath()
     * @model transient="true" volatile="true"
     * @generated
     */
    EAppSettingData getTargetPath();

    /**
     * Sets the value of the '{@link com.nokia.tools.variant.confml.core.model.application.EAppResourceData#getTargetPath <em>Target Path</em>}' reference.
     * <!-- begin-user-doc -->
     * <p>
     * Set the reference of the '<em><b>Target Path</b></em>' sub-setting data.
     * This is a helper method and is equivalent to:
     * <code>getSubSettings().put("targetPath", reference).</code>
     * </p>
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Target Path</em>' reference.
     * @see #getTargetPath()
     * @generated
     */
    void setTargetPath(EAppSettingData value);

} // EAppResourceData
