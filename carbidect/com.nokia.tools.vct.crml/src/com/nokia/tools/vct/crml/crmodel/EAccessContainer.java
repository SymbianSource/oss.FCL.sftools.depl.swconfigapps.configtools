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
 * Description: This file is part of com.nokia.tools.vct.crml component.
 */

package com.nokia.tools.vct.crml.crmodel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EAccess Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.EAccessContainer#getAccess <em>Access</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getEAccessContainer()
 * @model interface="true" abstract="true"
 *        extendedMetaData="name='accessibleType' kind='elementOnly'"
 * @generated
 */
public interface EAccessContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Access</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.crml.crmodel.EAccess}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Access</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Access</em>' containment reference list.
	 * @see com.nokia.tools.vct.crml.crmodel.ECRMLPackage#getEAccessContainer_Access()
	 * @model containment="true"
	 *        extendedMetaData="name='access' namespace='##targetNamespace' kind='element'"
	 * @generated
	 */
	EList<EAccess> getAccess();

} // EAccessContainer
