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
 * Restore Factory Settings element descriptor.
 * </p>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppRfsInfo#isRfs <em>Rfs</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppRfsInfo()
 * @model
 * @generated
 */
public interface EAppRfsInfo extends EObject {
    /**
     * Returns the value of the '<em><b>Rfs</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * RFS attribute is usually defined for the type element and controls
     * whether or not the value is recovered from ROM during reset.
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Rfs</em>' attribute.
     * @see #setRfs(boolean)
     * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppRfsInfo_Rfs()
     * @model required="true"
     * @generated
     */
    boolean isRfs();

    /**
	 * Sets the value of the '{@link com.nokia.tools.vct.common.appmodel.EAppRfsInfo#isRfs <em>Rfs</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rfs</em>' attribute.
	 * @see #isRfs()
	 * @generated
	 */
    void setRfs(boolean value);

} // EAppRfsInfo
