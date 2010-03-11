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
 * Description: This file is part of com.nokia.tools.variant.editor component.
 */

package com.nokia.tools.variant.editor.cpfInfo;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CPF</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.editor.cpfInfo.CPF#getCpfInfo <em>Cpf Info</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.variant.editor.cpfInfo.CpfInfoPackage#getCPF()
 * @model
 * @generated
 */
public interface CPF extends EObject {
	/**
	 * Returns the value of the '<em><b>Cpf Info</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cpf Info</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cpf Info</em>' reference.
	 * @see #setCpfInfo(CPFInformation)
	 * @see com.nokia.tools.variant.editor.cpfInfo.CpfInfoPackage#getCPF_CpfInfo()
	 * @model required="true"
	 * @generated
	 */
	CPFInformation getCpfInfo();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.editor.cpfInfo.CPF#getCpfInfo <em>Cpf Info</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cpf Info</em>' reference.
	 * @see #getCpfInfo()
	 * @generated
	 */
	void setCpfInfo(CPFInformation value);

} // CPF
