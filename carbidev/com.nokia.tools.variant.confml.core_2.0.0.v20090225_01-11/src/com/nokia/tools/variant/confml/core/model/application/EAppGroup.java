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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * <p>
 * A representation of the view group definition.
 * </p>
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link #getName()} <em>Group Name</em></li>
 * <li>{@link #getDescription()} <em>Description</em></li>
 * <li>{@link #getIconURI()} <em>Attached Icon</em></li>
 * <li>{@link #getSettings()} <em>Setting References</em></li>
 * <li>{@link #getGroups()} <em>Child Groups</em></li>
 * </ul>
 * </p>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.EAppGroup#getSettings <em>Settings</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppGroup()
 * @model
 * @generated
 */
public interface EAppGroup extends EAppGroupContainer,
        EAppDescriptionContainer, EAppIconContainer, EAppNamedItem {
    /**
     * Returns the value of the '<em><b>Settings</b></em>' containment reference list.
     * The list contents are of type {@link com.nokia.tools.variant.confml.core.model.application.EAppSettingRef}.
     * <!-- begin-user-doc -->
     * <p>
     * Get resolved setting references for this group. Each feature reference in
     * the ConfML is resolved as a list of actual setting references.
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Settings</em>' containment reference list.
     * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppGroup_Settings()
     * @model containment="true"
     * @generated
     */
    EList<EAppSettingRef> getSettings();

} // EAppGroup
