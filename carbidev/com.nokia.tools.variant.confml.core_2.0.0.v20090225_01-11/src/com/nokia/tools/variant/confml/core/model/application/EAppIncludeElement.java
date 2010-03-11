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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * <p>
 * Entry of the layer or project inclusion chain. This entry provides
 * information regarding preprocessor inclusions during construction of the
 * application layer.
 * </p>
 * <p>
 * All the URIs are relative to the project root.
 * </p>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.EAppIncludeElement#getSource <em>Source</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.EAppIncludeElement#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppIncludeElement()
 * @model
 * @generated
 */
public interface EAppIncludeElement extends EObject {
    /**
     * Returns the value of the '<em><b>Source</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * Get the file from which the inclusion has started.
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Source</em>' attribute.
     * @see #setSource(URI)
     * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppIncludeElement_Source()
     * @model dataType="com.nokia.tools.variant.confml.core.model.core.Ecore_URI" required="true"
     * @generated
     */
    URI getSource();

    /**
     * Sets the value of the '{@link com.nokia.tools.variant.confml.core.model.application.EAppIncludeElement#getSource <em>Source</em>}' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * Set the file from which the inclusion has started.
     * </p>
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source</em>' attribute.
     * @see #getSource()
     * @generated
     */
    void setSource(URI value);

    /**
     * Returns the value of the '<em><b>Target</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * Get the file that has been included.
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Target</em>' attribute.
     * @see #setTarget(URI)
     * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppIncludeElement_Target()
     * @model dataType="com.nokia.tools.variant.confml.core.model.core.Ecore_URI" required="true"
     * @generated
     */
    URI getTarget();

    /**
     * <p>
     * Set the file that has been included.
     * </p>
     * 
     * @param value the new value of the '<em>Target</em>' attribute.
     * @see #getTarget()
     * @generated
     */
    void setTarget(URI value);

} // EAppIncludeElement
