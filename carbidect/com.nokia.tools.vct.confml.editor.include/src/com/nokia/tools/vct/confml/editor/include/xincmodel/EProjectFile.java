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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EProject File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.confml.editor.include.xincmodel.EProjectFile#getResource <em>Resource</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.include.xincmodel.EProjectFile#getIncluded <em>Included</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.include.xincmodel.EProjectFile#getVersion <em>Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EXincModelPackage#getEProjectFile()
 * @model
 * @generated
 */
public interface EProjectFile extends EProjectResource {
	/**
	 * Returns the value of the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource</em>' attribute.
	 * @see #setResource(Resource)
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EXincModelPackage#getEProjectFile_Resource()
	 * @model transient="true"
	 * @generated
	 */
	Resource getResource();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.EProjectFile#getResource <em>Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource</em>' attribute.
	 * @see #getResource()
	 * @generated
	 */
	void setResource(Resource value);

	/**
	 * Returns the value of the '<em><b>Included</b></em>' reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.confml.editor.include.xincmodel.EInclude}.
	 * It is bidirectional and its opposite is '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.EInclude#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Included</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Included</em>' reference list.
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EXincModelPackage#getEProjectFile_Included()
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EInclude#getTarget
	 * @model opposite="target" transient="true" changeable="false"
	 * @generated
	 */
	EList<EInclude> getIncluded();

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * The literals are from the enumeration {@link com.nokia.tools.vct.confml.editor.include.xincmodel.EConfMLVersion}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EConfMLVersion
	 * @see #setVersion(EConfMLVersion)
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EXincModelPackage#getEProjectFile_Version()
	 * @model
	 * @generated
	 */
	EConfMLVersion getVersion();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.EProjectFile#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EConfMLVersion
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(EConfMLVersion value);

} // EProjectFile
