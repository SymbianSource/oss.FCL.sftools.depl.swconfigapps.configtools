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

package com.nokia.tools.variant.confml.core.model.core;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

import com.nokia.tools.variant.confml.core.model.application.EConfigurationProject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EWorkspace Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.core.EWorkspaceModel#getProjectMap <em>Project Map</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.variant.confml.core.model.core.EConfmlRootPackage#getEWorkspaceModel()
 * @model
 * @generated
 */
public interface EWorkspaceModel extends EObject {
	/**
     * Returns the value of the '<em><b>Project Map</b></em>' map.
     * The key is of type {@link java.lang.String},
     * and the value is of type {@link com.nokia.tools.variant.confml.core.model.application.EConfigurationProject},
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Project Map</em>' map.
     * @see com.nokia.tools.variant.confml.core.model.core.EConfmlRootPackage#getEWorkspaceModel_ProjectMap()
     * @model mapType="com.nokia.tools.variant.confml.core.model.core.EProjectEntry<org.eclipse.emf.ecore.EString, com.nokia.tools.variant.confml.core.model.application.EConfigurationProject>"
     * @generated
     */
	EMap<String, EConfigurationProject> getProjectMap();

} // EWorkspaceModel
