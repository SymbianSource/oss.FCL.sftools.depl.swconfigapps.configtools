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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * <p>
 * Reference from the View's group into concrete setting.
 * </p>
 * <p>
 * The ConfML specification permits references of both features and individual
 * settings from the groups. The application model resolves feature references
 * into individual setting references preserving order of feature settings as
 * per feature type definition.
 * </p>
 * <p>
 * This object may have a name, description, options and properties defined and
 * these values should be used to override the default type information of the
 * target (resolved) setting.
 * </p>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppSettingRef#getResolved <em>Resolved</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppSettingRef#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppSettingRef#getSubSettingsRef <em>Sub Settings Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppSettingRef()
 * @model
 * @generated
 */
public interface EAppSettingRef extends EAppPropertyContainer, EAppOptionContainer, EAppDescriptionContainer, EAppTypeConstraints {
    /**
	 * Returns the value of the '<em><b>Resolved</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <p>
     * Returns the target (resolved) setting
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolved</em>' reference.
	 * @see #setResolved(EAppSetting)
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppSettingRef_Resolved()
	 * @model
	 * @generated
	 */
    EAppSetting getResolved();

    /**
	 * Sets the value of the '{@link com.nokia.tools.vct.common.appmodel.EAppSettingRef#getResolved <em>Resolved</em>}' reference.
	 * <!-- begin-user-doc -->
     * <p>
     * Sets the target (resolved) setting
     * </p>
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolved</em>' reference.
	 * @see #getResolved()
	 * @generated
	 */
    void setResolved(EAppSetting value);

    /**
     * <p>
     * Returns the name override
     * </p>
     * 
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppSettingRef_Name()
     * @model
     * @generated
     */
    String getName();

    /**
	 * Sets the value of the '{@link com.nokia.tools.vct.common.appmodel.EAppSettingRef#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * Sets the name override
     * </p>
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
    void setName(String value);

				/**
	 * Returns the value of the '<em><b>Sub Settings Ref</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Settings Ref</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Settings Ref</em>' attribute list.
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppSettingRef_SubSettingsRef()
	 * @model
	 * @generated
	 */
	EList<String> getSubSettingsRef();

} // EAppSettingRef
