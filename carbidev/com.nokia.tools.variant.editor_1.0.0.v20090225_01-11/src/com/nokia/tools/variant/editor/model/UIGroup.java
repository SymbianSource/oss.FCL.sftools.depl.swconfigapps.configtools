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
 * Description: This file is part of com.nokia.tools.variant.editor component.
 */

package com.nokia.tools.variant.editor.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UI Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.editor.model.UIGroup#getUiSettings <em>Ui Settings</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.model.UIGroup#getTitle <em>Title</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.model.UIGroup#getSortingOrder <em>Sorting Order</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.model.UIGroup#getModel <em>Model</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.model.UIGroup#getUiGroups <em>Ui Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.variant.editor.model.UIModelPackage#getUIGroup()
 * @model
 * @generated
 */
public interface UIGroup extends EObject {
	/**
	 * Returns the value of the '<em><b>Ui Settings</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.variant.editor.model.UISetting}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ui Settings</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ui Settings</em>' containment reference list.
	 * @see com.nokia.tools.variant.editor.model.UIModelPackage#getUIGroup_UiSettings()
	 * @model containment="true"
	 * @generated
	 */
	EList<UISetting> getUiSettings();

	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see com.nokia.tools.variant.editor.model.UIModelPackage#getUIGroup_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.editor.model.UIGroup#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Sorting Order</b></em>' attribute.
	 * The literals are from the enumeration {@link com.nokia.tools.variant.editor.model.SortingOrder}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sorting Order</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sorting Order</em>' attribute.
	 * @see com.nokia.tools.variant.editor.model.SortingOrder
	 * @see #setSortingOrder(SortingOrder)
	 * @see com.nokia.tools.variant.editor.model.UIModelPackage#getUIGroup_SortingOrder()
	 * @model
	 * @generated
	 */
	SortingOrder getSortingOrder();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.editor.model.UIGroup#getSortingOrder <em>Sorting Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sorting Order</em>' attribute.
	 * @see com.nokia.tools.variant.editor.model.SortingOrder
	 * @see #getSortingOrder()
	 * @generated
	 */
	void setSortingOrder(SortingOrder value);

	/**
	 * Returns the value of the '<em><b>Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' attribute.
	 * @see #setModel(Object)
	 * @see com.nokia.tools.variant.editor.model.UIModelPackage#getUIGroup_Model()
	 * @model dataType="com.nokia.tools.variant.content.confml.Object"
	 * @generated
	 */
	Object getModel();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.editor.model.UIGroup#getModel <em>Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' attribute.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(Object value);

	/**
	 * Returns the value of the '<em><b>Ui Groups</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.variant.editor.model.UIGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ui Groups</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ui Groups</em>' containment reference list.
	 * @see com.nokia.tools.variant.editor.model.UIModelPackage#getUIGroup_UiGroups()
	 * @model containment="true"
	 * @generated
	 */
	EList<UIGroup> getUiGroups();

} // UIGroup
