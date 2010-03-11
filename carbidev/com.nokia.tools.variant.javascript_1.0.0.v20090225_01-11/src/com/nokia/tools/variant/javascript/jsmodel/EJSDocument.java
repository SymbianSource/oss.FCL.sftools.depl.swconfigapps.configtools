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
 * Description: This file is part of com.nokia.tools.variant.javascript component.
 */
package com.nokia.tools.variant.javascript.jsmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EJS Document</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.javascript.jsmodel.EJSDocument#getScript <em>Script</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.variant.javascript.jsmodel.EJSModelPackage#getEJSDocument()
 * @model
 * @generated
 */
public interface EJSDocument extends EObject {
    /**
     * Returns the value of the '<em><b>Script</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Script</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Script</em>' attribute.
     * @see #setScript(String)
     * @see com.nokia.tools.variant.javascript.jsmodel.EJSModelPackage#getEJSDocument_Script()
     * @model required="true"
     * @generated
     */
    String getScript();

    /**
     * Sets the value of the '{@link com.nokia.tools.variant.javascript.jsmodel.EJSDocument#getScript <em>Script</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Script</em>' attribute.
     * @see #getScript()
     * @generated
     */
    void setScript(String value);

} // EJSDocument
