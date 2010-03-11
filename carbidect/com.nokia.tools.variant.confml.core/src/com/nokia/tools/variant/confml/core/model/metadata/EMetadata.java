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

package com.nokia.tools.variant.confml.core.model.metadata;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EMetadata</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.metadata.EMetadata#getComponents <em>Components</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.metadata.EMetadata#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.variant.confml.core.model.metadata.EMetadataPackage#getEMetadata()
 * @model extendedMetaData="name='metadata' kind='elementOnly' namespace='##targetNamespace'"
 * @generated
 */
public interface EMetadata extends EObject {
	/**
	 * Returns the value of the '<em><b>Components</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.variant.confml.core.model.metadata.EMetaComponent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Components</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Components</em>' containment reference list.
	 * @see com.nokia.tools.variant.confml.core.model.metadata.EMetadataPackage#getEMetadata_Components()
	 * @model containment="true"
	 *        extendedMetaData="name='component' kind='element' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<EMetaComponent> getComponents();

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.variant.confml.core.model.metadata.EMetaProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see com.nokia.tools.variant.confml.core.model.metadata.EMetadataPackage#getEMetadata_Properties()
	 * @model containment="true"
	 *        extendedMetaData="name='property' kind='element' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<EMetaProperty> getProperties();

} // EMetadata
