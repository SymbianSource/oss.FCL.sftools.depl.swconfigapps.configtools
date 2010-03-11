/**
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
 * $Id$
 */
package com.nokia.tools.carbide.ct.confml.model.confml2;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EMeta Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaContainer#getMetas <em>Metas</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getEMetaContainer()
 * @model interface="true" abstract="true"
 *        extendedMetaData="name='groupContainerType' kind='elementOnly'"
 * @generated
 */
public interface EMetaContainer extends EContents {
	/**
	 * Returns the value of the '<em><b>Metas</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metas</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metas</em>' containment reference list.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getEMetaContainer_Metas()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='meta' namespace='##targetNamespace' group='#contents:0'"
	 * @generated
	 */
	EList<EMetaElement> getMetas();

} // EMetaContainer
