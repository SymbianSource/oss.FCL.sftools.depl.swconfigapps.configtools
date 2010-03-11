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

/**
 * <!-- begin-user-doc -->
 * <p>
 * A representation of the model object for sequence data. Sequence data
 * contains a list of sequence items and optional template item.
 * </p>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppSequenceData#getItems <em>Items</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppSequenceData#getTemplate <em>Template</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppSequenceData()
 * @model
 * @generated
 */
public interface EAppSequenceData extends EAppSettingData {
    /**
	 * Returns the value of the '<em><b>Items</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.common.appmodel.EAppSequenceDataItem}.
	 * <!-- begin-user-doc -->
     * <p>
     * Get the containment sequence items list.
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Items</em>' containment reference list.
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppSequenceData_Items()
	 * @model containment="true"
	 * @generated
	 */
    EList<EAppSequenceDataItem> getItems();

    /**
	 * Returns the value of the '<em><b>Template</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <p>
     * Get the sequence template.
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Template</em>' containment reference.
	 * @see #setTemplate(EAppSequenceDataItem)
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppSequenceData_Template()
	 * @model containment="true"
	 * @generated
	 */
    EAppSequenceDataItem getTemplate();

    /**
	 * Sets the value of the '{@link com.nokia.tools.vct.common.appmodel.EAppSequenceData#getTemplate <em>Template</em>}' containment reference.
	 * <!-- begin-user-doc --> Set the sequence template. <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template</em>' containment reference.
	 * @see #getTemplate()
	 * @generated
	 */
    void setTemplate(EAppSequenceDataItem value);

} // EAppSequenceData
