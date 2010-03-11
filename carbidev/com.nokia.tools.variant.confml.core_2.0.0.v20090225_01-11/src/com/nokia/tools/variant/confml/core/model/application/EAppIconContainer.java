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
 * Interface for elements that may have an attached icon descriptor. Icons are
 * defined in a form of URIs relative to documentation root inside the
 * configuration project. This provides a capability to override icon without
 * changing the original reference, as documentation contents follows the same
 * rules as for the resource contents.
 * </p>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.EAppIconContainer#getIconDescriptor <em>Icon Descriptor</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.EAppIconContainer#getIconTitle <em>Icon Title</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.EAppIconContainer#getIconURI <em>Icon URI</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppIconContainer()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface EAppIconContainer extends EObject {
    /**
     * Returns the value of the '<em><b>Icon Descriptor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Icon Descriptor</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Icon Descriptor</em>' attribute.
     * @see #setIconDescriptor(Object)
     * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppIconContainer_IconDescriptor()
     * @model
     * @generated
     */
    Object getIconDescriptor();

    /**
     * Sets the value of the '{@link com.nokia.tools.variant.confml.core.model.application.EAppIconContainer#getIconDescriptor <em>Icon Descriptor</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @param value the new value of the '<em>Icon Descriptor</em>' attribute.
     * @see #getIconDescriptor()
     * @generated
     */
    void setIconDescriptor(Object value);

    /**
     * Returns the value of the '<em><b>Icon Title</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Icon Title</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Icon Title</em>' attribute.
     * @see #setIconTitle(String)
     * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppIconContainer_IconTitle()
     * @model
     * @generated
     */
    String getIconTitle();

    /**
     * Sets the value of the '{@link com.nokia.tools.variant.confml.core.model.application.EAppIconContainer#getIconTitle <em>Icon Title</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @param value the new value of the '<em>Icon Title</em>' attribute.
     * @see #getIconTitle()
     * @generated
     */
    void setIconTitle(String value);

    /**
     * Returns the value of the '<em><b>Icon URI</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * Get the URI of the icon resource relative to the documentation root root.
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Icon URI</em>' attribute.
     * @see #setIconURI(URI)
     * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppIconContainer_IconURI()
     * @model dataType="com.nokia.tools.variant.confml.core.model.core.Ecore_URI"
     * @generated
     */
    URI getIconURI();

    /**
     * Sets the value of the '{@link com.nokia.tools.variant.confml.core.model.application.EAppIconContainer#getIconURI <em>Icon URI</em>}' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * Set the URI of the icon resource relative to the documentation root
     * </p>
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Icon URI</em>' attribute.
     * @see #getIconURI()
     * @generated
     */
    void setIconURI(URI value);

} // EAppIconContainer
