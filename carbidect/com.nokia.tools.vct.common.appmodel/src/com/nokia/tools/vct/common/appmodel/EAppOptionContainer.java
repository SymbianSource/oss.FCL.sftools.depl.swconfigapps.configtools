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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * <p>
 * Interface for elements with {@link EAppSettingOption} descriptors.
 * </p>
 * <p>
 * Setting type definitions and view setting references may contain a list of
 * options.
 * </p>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppOptionContainer#getOptions <em>Options</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppOptionContainer()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface EAppOptionContainer extends EObject {
    /**
	 * Returns the value of the '<em><b>Options</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.common.appmodel.EAppSettingOption}.
	 * <!-- begin-user-doc -->
     * <p>
     * Get the containment list of option element.
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Options</em>' containment reference list.
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppOptionContainer_Options()
	 * @model containment="true"
	 * @generated
	 */
    EList<EAppSettingOption> getOptions();

} // EAppOptionContainer
