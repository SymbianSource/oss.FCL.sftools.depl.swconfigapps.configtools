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
 * Description: This file is part of com.nokia.tools.vct.confml.editor.include component.
 */

package com.nokia.tools.vct.confml.editor.include.xincmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EInclude</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.confml.editor.include.xincmodel.EInclude#getHref <em>Href</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.include.xincmodel.EInclude#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EXincModelPackage#getEInclude()
 * @model
 * @generated
 */
public interface EInclude extends EObject {
	/**
	 * Returns the value of the '<em><b>Href</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Href</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Href</em>' attribute.
	 * @see #setHref(String)
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EXincModelPackage#getEInclude_Href()
	 * @model
	 * @generated
	 */
	String getHref();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.EInclude#getHref <em>Href</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Href</em>' attribute.
	 * @see #getHref()
	 * @generated
	 */
	void setHref(String value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.EProjectFile#getIncluded <em>Included</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(EProjectFile)
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EXincModelPackage#getEInclude_Target()
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EProjectFile#getIncluded
	 * @model opposite="included" transient="true"
	 * @generated
	 */
	EProjectFile getTarget();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.EInclude#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(EProjectFile value);

} // EInclude
