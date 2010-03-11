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
 * <!-- begin-user-doc -->
 * <p>
 * Interface for objects with "name" attribute. ConfML specification does not
 * define ways for using this attribute. In most of the cases the attribute is
 * used by UI tools for user assistance, in some other this value is silently
 * ignored. 
 * </p>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppNamedItem#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppNamedItem()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface EAppNamedItem extends EObject {
    /**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * Get the object name.
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppNamedItem_Name()
	 * @model
	 * @generated
	 */
    String getName();

    /**
	 * Sets the value of the '{@link com.nokia.tools.vct.common.appmodel.EAppNamedItem#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> Set the object name. <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
    void setName(String value);

} // EAppNamedItem
