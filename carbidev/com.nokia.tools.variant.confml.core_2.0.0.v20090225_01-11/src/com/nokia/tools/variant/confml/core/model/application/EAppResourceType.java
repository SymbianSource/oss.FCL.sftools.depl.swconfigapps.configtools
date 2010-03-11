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
 * Type descriptor for resource (file/folder) settings. This descriptor is a
 * composite setting (i.e. structure) with fixed sub-items:
 * <ul>
 * <li><em>"localPath"</em> Local Path sub-element</li>
 * <li><em>"targetPath"</em> Target Path sub-element</li>
 *</ul>
 * </p>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.EAppResourceType#isFile <em>File</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.EAppResourceType#getLocalPath <em>Local Path</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.EAppResourceType#getTargetPath <em>Target Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppResourceType()
 * @model
 * @generated
 */
public interface EAppResourceType extends EAppCompositeType {
    /**
     * Returns the value of the '<em><b>File</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * The method is depreciated.
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>File</em>' attribute.
     * @see #setFile(boolean)
     * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppResourceType_File()
     * @model required="true"
     * @generated
     */
    boolean isFile();

    /**
     * Sets the value of the '{@link com.nokia.tools.variant.confml.core.model.application.EAppResourceType#isFile <em>File</em>}' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * The method is depreciated.
     * </p>
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>File</em>' attribute.
     * @see #isFile()
     * @generated
     */
    void setFile(boolean value);

    /**
     * Returns the value of the '<em><b>Local Path</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * Get the type descriptor for local path. This is equivalent to <code>
     * getTypeMap().get("localPath");
     * </code>
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Local Path</em>' reference.
     * @see #setLocalPath(EAppSettingType)
     * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppResourceType_LocalPath()
     * @model transient="true" volatile="true"
     * @generated
     */
    EAppSettingType getLocalPath();

    /**
     * Sets the value of the '{@link com.nokia.tools.variant.confml.core.model.application.EAppResourceType#getLocalPath <em>Local Path</em>}' reference.
     * <!-- begin-user-doc -->
     * <p>
     * Sets the type descriptor for local path. This is equivalent to <code>
     * getTypeMap().put("localPath", reference);
     * </code>
     * </p>
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Local Path</em>' reference.
     * @see #getLocalPath()
     * @generated
     */
    void setLocalPath(EAppSettingType value);

    /**
     * Returns the value of the '<em><b>Target Path</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * Get the type descriptor for the target path. This is equivalent to <code>
     * getTypeMap().get("targetPath");
     * </code>
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Target Path</em>' reference.
     * @see #setTargetPath(EAppSettingType)
     * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppResourceType_TargetPath()
     * @model transient="true" volatile="true"
     * @generated
     */
    EAppSettingType getTargetPath();

    /**
     * Sets the value of the '{@link com.nokia.tools.variant.confml.core.model.application.EAppResourceType#getTargetPath <em>Target Path</em>}' reference.
     * <!-- begin-user-doc -->
     * <p>
     * Sets the type descriptor for target path. This is equivalent to <code>
     * getTypeMap().put("targetPath", reference);
     * </code>
     * </p>
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Target Path</em>' reference.
     * @see #getTargetPath()
     * @generated
     */
    void setTargetPath(EAppSettingType value);

} // EAppResourceType
