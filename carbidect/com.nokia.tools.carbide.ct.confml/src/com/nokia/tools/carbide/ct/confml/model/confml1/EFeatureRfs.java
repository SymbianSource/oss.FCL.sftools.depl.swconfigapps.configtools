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
package com.nokia.tools.carbide.ct.confml.model.confml1;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EFeature Rfs</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml1.EFeatureRfs#getSettings <em>Settings</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.carbide.ct.confml.model.confml1.EConfML1Package#getEFeatureRfs()
 * @model extendedMetaData="name='EFeatureRfs' kind='elementOnly'"
 * @generated
 */
public interface EFeatureRfs extends ERefNamedElement {
	/**
	 * Returns the value of the '<em><b>Settings</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.carbide.ct.confml.model.confml1.ESettingRfs}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Settings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Settings</em>' containment reference list.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml1.EConfML1Package#getEFeatureRfs_Settings()
	 * @model containment="true"
	 * @generated
	 */
	EList<ESettingRfs> getSettings();

} // EFeatureRfs
