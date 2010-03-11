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
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * <p>
 * Typed interface for objects that are permitted to contain view groups.
 * </p>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.EAppGroupContainer#getGroups <em>Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppGroupContainer()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface EAppGroupContainer extends EObject {
    /**
     * Returns the value of the '<em><b>Groups</b></em>' containment reference list.
     * The list contents are of type {@link com.nokia.tools.variant.confml.core.model.application.EAppGroup}.
     * <!-- begin-user-doc -->
     * <p>
     * Return a list of contained sub-groups
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Groups</em>' containment reference list.
     * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppGroupContainer_Groups()
     * @model containment="true"
     * @generated
     */
    EList<EAppGroup> getGroups();

} // EAppGroupContainer
