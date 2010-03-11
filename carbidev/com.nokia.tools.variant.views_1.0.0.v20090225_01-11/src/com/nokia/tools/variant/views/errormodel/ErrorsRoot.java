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
 * Description: This file is part of com.nokia.tools.variant.views component.
 */

package com.nokia.tools.variant.views.errormodel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Errors Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.views.errormodel.ErrorsRoot#getErrors <em>Errors</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.variant.views.errormodel.ErrormodelPackage#getErrorsRoot()
 * @model
 * @generated
 */
public interface ErrorsRoot extends EObject {
	/**
	 * Returns the value of the '<em><b>Errors</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.variant.views.errormodel.Error}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Errors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Errors</em>' containment reference list.
	 * @see com.nokia.tools.variant.views.errormodel.ErrormodelPackage#getErrorsRoot_Errors()
	 * @model containment="true"
	 * @generated
	 */
	EList<com.nokia.tools.variant.views.errormodel.Error> getErrors();

} // ErrorsRoot
