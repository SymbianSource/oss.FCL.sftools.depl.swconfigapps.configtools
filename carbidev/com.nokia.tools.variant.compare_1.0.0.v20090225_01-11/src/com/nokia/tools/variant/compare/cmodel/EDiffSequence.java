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
 * Description: This file is part of com.nokia.tools.variant.compare component.
 */

package com.nokia.tools.variant.compare.cmodel;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ESequence Setting</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.EDiffSequence#getItemCount <em>Item Count</em>}</li>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.EDiffSequence#getItems <em>Items</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.variant.compare.cmodel.ECompareModelPackage#getEDiffSequence()
 * @model
 * @generated
 */
public interface EDiffSequence extends EDiffSetting {

	/**
	 * Returns the value of the '<em><b>Item Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Item Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Item Count</em>' attribute.
	 * @see #setItemCount(int)
	 * @see com.nokia.tools.variant.compare.cmodel.ECompareModelPackage#getEDiffSequence_ItemCount()
	 * @model
	 * @generated
	 */
	int getItemCount();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.compare.cmodel.EDiffSequence#getItemCount <em>Item Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Item Count</em>' attribute.
	 * @see #getItemCount()
	 * @generated
	 */
	void setItemCount(int value);

	/**
	 * Returns the value of the '<em><b>Items</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.variant.compare.cmodel.EDiffSequenceItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Items</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Items</em>' containment reference list.
	 * @see com.nokia.tools.variant.compare.cmodel.ECompareModelPackage#getEDiffSequence_Items()
	 * @model containment="true"
	 * @generated
	 */
	EList<EDiffSequenceItem> getItems();

} // ESequenceSetting
