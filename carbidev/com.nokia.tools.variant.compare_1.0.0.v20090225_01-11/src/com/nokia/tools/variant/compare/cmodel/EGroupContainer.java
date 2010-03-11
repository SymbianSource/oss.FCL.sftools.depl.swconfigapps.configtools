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
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EGroup Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.EGroupContainer#getGroups <em>Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.variant.compare.cmodel.ECompareModelPackage#getEGroupContainer()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface EGroupContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Groups</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.variant.compare.cmodel.EDiffGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Groups</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Groups</em>' containment reference list.
	 * @see com.nokia.tools.variant.compare.cmodel.ECompareModelPackage#getEGroupContainer_Groups()
	 * @model containment="true"
	 * @generated
	 */
	EList<EDiffGroup> getGroups();

} // EGroupContainer
