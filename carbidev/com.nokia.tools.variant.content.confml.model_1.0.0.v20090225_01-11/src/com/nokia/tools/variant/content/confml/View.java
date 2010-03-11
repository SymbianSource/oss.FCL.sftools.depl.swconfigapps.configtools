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
 * Description: This file is part of com.nokia.tools.variant.content.confml.model component.
 */

package com.nokia.tools.variant.content.confml;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.content.confml.View#getParentGroup <em>Parent Group</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.View#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.View#getIcon <em>Icon</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.View#getSharedSettingInstances <em>Shared Setting Instances</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.View#getSharedFeatures <em>Shared Features</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.variant.content.confml.ConfmlPackage#getView()
 * @model
 * @generated
 */
public interface View extends EObject {
	/**
	 * Returns the value of the '<em><b>Parent Group</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.variant.content.confml.ParentGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Group</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Group</em>' containment reference list.
	 * @see com.nokia.tools.variant.content.confml.ConfmlPackage#getView_ParentGroup()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParentGroup> getParentGroup();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.nokia.tools.variant.content.confml.ConfmlPackage#getView_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.content.confml.View#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Icon</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.variant.content.confml.Icon}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon</em>' containment reference list.
	 * @see com.nokia.tools.variant.content.confml.ConfmlPackage#getView_Icon()
	 * @model containment="true"
	 * @generated
	 */
	EList<Icon> getIcon();

	/**
	 * Returns the value of the '<em><b>Shared Setting Instances</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.variant.content.confml.Setting}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shared Setting Instances</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shared Setting Instances</em>' containment reference list.
	 * @see com.nokia.tools.variant.content.confml.ConfmlPackage#getView_SharedSettingInstances()
	 * @model containment="true"
	 * @generated
	 */
	EList<Setting> getSharedSettingInstances();

	/**
	 * Returns the value of the '<em><b>Shared Features</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.variant.content.confml.Feature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shared Features</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shared Features</em>' containment reference list.
	 * @see com.nokia.tools.variant.content.confml.ConfmlPackage#getView_SharedFeatures()
	 * @model containment="true"
	 * @generated
	 */
	EList<Feature> getSharedFeatures();

} // View
