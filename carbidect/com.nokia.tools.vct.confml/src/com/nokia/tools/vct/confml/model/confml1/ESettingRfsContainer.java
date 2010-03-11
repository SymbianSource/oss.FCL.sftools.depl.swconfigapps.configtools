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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ESetting Rfs Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.ESettingRfsContainer#getSettings <em>Settings</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.confml.model.confml1.EConfML1Package#getESettingRfsContainer()
 * @model interface="true" abstract="true"
 *        extendedMetaData="name='settingRfsContainerType' kind='elementOnly'"
 * @generated
 */
public interface ESettingRfsContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Settings</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.confml.model.confml1.ESettingRfs}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Settings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Settings</em>' containment reference list.
	 * @see com.nokia.tools.vct.confml.model.confml1.EConfML1Package#getESettingRfsContainer_Settings()
	 * @model containment="true"
	 *        extendedMetaData="name='rfsDataType' kind='elementWildcard'"
	 * @generated
	 */
	EList<ESettingRfs> getSettings();

} // ESettingRfsContainer
