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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>ESource Locator</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.ESourceLocator#getUri <em>Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getESourceLocator()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ESourceLocator extends EObject {
	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute list. The list
	 * contents are of type {@link org.eclipse.emf.common.util.URI}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri</em>' attribute list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Uri</em>' attribute list.
	 * @see com.nokia.tools.variant.confml.core.model.core.EConfmlRootPackage#getESourceLocator_Uri()
	 * @model 
	 *        dataType="com.nokia.tools.variant.confml.core.model.core.Ecore_URI"
	 * @generated
	 */
	EList<URI> getUri();

} // ESourceLocator
