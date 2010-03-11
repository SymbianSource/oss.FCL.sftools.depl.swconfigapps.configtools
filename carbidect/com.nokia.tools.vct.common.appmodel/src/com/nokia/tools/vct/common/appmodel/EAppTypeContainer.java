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
 * <!-- begin-user-doc --> Model object for composite types as sequences and
 * resources. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppTypeContainer#getTypeMap <em>Type Map</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppTypeContainer()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface EAppTypeContainer extends EObject {
    /**
	 * Returns the value of the '<em><b>Type Map</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link com.nokia.tools.vct.common.appmodel.EAppSettingType},
	 * <!-- begin-user-doc -->
     * <p>
     * Returns the value of the '<em><b>Type Map</b></em>' map. The key is of
     * type {@link String} and presents the sub-setting reference, and the value
     * is of type {@link EAppSettingType} and contains the sub-setting type
     * descriptor.
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Map</em>' map.
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppTypeContainer_TypeMap()
	 * @model mapType="com.nokia.tools.vct.common.appmodel.EAppSettingTypeEntry<org.eclipse.emf.ecore.EString, com.nokia.tools.vct.common.appmodel.EAppSettingType>"
	 * @generated
	 */
    EMap<String, EAppSettingType> getTypeMap();

} // EAppTypeContainer
