/*
* Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
* All rights reserved.
* This component and the accompanying materials are made available
* under the terms of "Eclipse Public License v1.0"
* which accompanies this distribution, and is available
* at the URL "http://www.eclipse.org/legal/epl-v10.html".
*
* Initial Contributors:
* Nokia Corporation - initial contribution.
*
* Contributors:
*
* Description:
*
*/
package variantdata;

import org.eclipse.emf.common.util.EList;

import configurationemf.Data;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variant Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link variantdata.VariantData#getInclude <em>Include</em>}</li>
 * </ul>
 * </p>
 *
 * @see variantdata.VariantDataPackage#getVariantData()
 * @model
 * @generated
 */
public interface VariantData extends Data {
	/**
	 * Returns the value of the '<em><b>Include</b></em>' reference list.
	 * The list contents are of type {@link variantdata.VariantData}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Include</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Include</em>' reference list.
	 * @see variantdata.VariantDataPackage#getVariantData_Include()
	 * @model
	 * @generated
	 */
	EList<VariantData> getInclude();

} // VariantData
