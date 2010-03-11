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
 * A representation of the model object '<em><b>EDescription Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.EDescriptionContainer#getDescriptions <em>Descriptions</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getEDescriptionContainer()
 * @model interface="true" abstract="true"
 *        extendedMetaData="name='descriptionContainerType' kind='elementOnly'"
 * @generated
 */
public interface EDescriptionContainer extends EContents {
	/**
	 * Returns the value of the '<em><b>Descriptions</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.carbide.ct.confml.model.confml2.EDescriptionElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Descriptions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptions</em>' containment reference list.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getEDescriptionContainer_Descriptions()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='desc' namespace='##targetNamespace' group='#contents:0'"
	 * @generated
	 */
	EList<EDescriptionElement> getDescriptions();

} // EDescriptionContainer
