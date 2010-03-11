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
 * Description: This file is part of com.nokia.tools.vct.confml component.
 */

package com.nokia.tools.vct.confml.model.confml1;

import com.nokia.tools.vct.confml.model.confml1.include.EInclude;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EGroup Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EGroupContainer#getGroups <em>Groups</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EGroupContainer#getIncludes <em>Includes</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.confml.model.confml1.EConfML1Package#getEGroupContainer()
 * @model interface="true" abstract="true"
 *        extendedMetaData="name='groupContainerType' kind='elementOnly'"
 * @generated
 */
public interface EGroupContainer extends ELinkContainer, EDescriptionContainer,
		EIconContainer {
	/**
	 * Returns the value of the '<em><b>Groups</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.confml.model.confml1.EGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Groups</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Groups</em>' containment reference list.
	 * @see com.nokia.tools.vct.confml.model.confml1.EConfML1Package#getEGroupContainer_Groups()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='group' namespace='##targetNamespace' group='#contents:0'"
	 * @generated
	 */
	EList<EGroup> getGroups();

	/**
	 * Returns the value of the '<em><b>Includes</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.confml.model.confml1.include.EInclude}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Includes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Includes</em>' containment reference list.
	 * @see com.nokia.tools.vct.confml.model.confml1.EConfML1Package#getEGroupContainer_Includes()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='include' namespace='http://www.w3.org/2001/XInclude' group='#contents:0'"
	 * @generated
	 */
	EList<EInclude> getIncludes();

} // EGroupContainer
