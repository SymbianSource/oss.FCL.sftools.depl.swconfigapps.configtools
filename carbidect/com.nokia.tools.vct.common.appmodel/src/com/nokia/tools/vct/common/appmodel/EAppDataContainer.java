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

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * <p>
 * Interface for holding contained set of named setting data elements.
 * </p>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppDataContainer#getSubSettings <em>Sub Settings</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppDataContainer()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface EAppDataContainer extends EObject {
    /**
	 * Returns the value of the '<em><b>Sub Settings</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link com.nokia.tools.vct.common.appmodel.EAppSettingData},
	 * <!-- begin-user-doc -->
     * <p>
     * Get the contained list of sub-settings data elements ({@link EMap}
     * interface). The key is of type {@link java.lang.String}, and the value is
     * of type {@link EAppSettingData}
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Settings</em>' map.
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppDataContainer_SubSettings()
	 * @model mapType="com.nokia.tools.vct.common.appmodel.EAppSubSettingDataEntry<org.eclipse.emf.ecore.EString, com.nokia.tools.vct.common.appmodel.EAppSettingData>"
	 * @generated
	 */
    EMap<String, EAppSettingData> getSubSettings();

} // EAppDataContainer
