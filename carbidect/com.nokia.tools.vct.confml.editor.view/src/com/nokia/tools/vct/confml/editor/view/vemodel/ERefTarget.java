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
 * Description: This file is part of com.nokia.tools.vct.confml.editor.view component.
 */

package com.nokia.tools.vct.confml.editor.view.vemodel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ERef Target</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.ERefTarget#getRefs <em>Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage#getERefTarget()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ERefTarget extends EObject {
	/**
	 * Returns the value of the '<em><b>Refs</b></em>' reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef}.
	 * It is bidirectional and its opposite is '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refs</em>' reference list.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage#getERefTarget_Refs()
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<ESettingRef> getRefs();

} // ERefTarget
