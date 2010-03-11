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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> Typed interface for elements with literal
 * description. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppDescriptionContainer#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppDescriptionContainer()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface EAppDescriptionContainer extends EObject {
    /**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * Get object description
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppDescriptionContainer_Description()
	 * @model
	 * @generated
	 */
    String getDescription();

    /**
	 * Sets the value of the '{@link com.nokia.tools.vct.common.appmodel.EAppDescriptionContainer#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * Set object description
     * </p>
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
    void setDescription(String value);

} // EAppDescriptionContainer
