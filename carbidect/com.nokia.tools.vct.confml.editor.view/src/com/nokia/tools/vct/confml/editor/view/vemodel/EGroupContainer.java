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
 * Description: This file is part of com.nokia.tools.vct.confml.editor.view component.
 */

package com.nokia.tools.vct.confml.editor.view.vemodel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EGroup Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.EGroupContainer#getGroupsAndViews <em>Groups And Views</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage#getEGroupContainer()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface EGroupContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Groups And Views</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.confml.editor.view.vemodel.EGroupEntry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Groups And Views</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Groups And Views</em>' containment reference list.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage#getEGroupContainer_GroupsAndViews()
	 * @model containment="true"
	 * @generated
	 */
	EList<EGroupEntry> getGroupsAndViews();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" many="false"
	 * @NOT generated
	 */
	EList<EGroup> getGroups();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" many="false"
	 * @NOT generated
	 */
	EList<EView> getIncludeViews();

} // EGroupContainer
