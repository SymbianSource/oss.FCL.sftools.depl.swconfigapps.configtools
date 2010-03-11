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
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EDocument Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.EViewsEditorDocument#getViews <em>Views</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.EViewsEditorDocument#getUseCount <em>Use Count</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.EViewsEditorDocument#getFeatures <em>Features</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.EViewsEditorDocument#getAllViews <em>All Views</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage#getEViewsEditorDocument()
 * @model
 * @generated
 */
public interface EViewsEditorDocument extends EObject {
	/**
	 * Returns the value of the '<em><b>Views</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link com.nokia.tools.vct.confml.editor.view.vemodel.EView},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Views</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Views</em>' map.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage#getEViewsEditorDocument_Views()
	 * @model mapType="com.nokia.tools.vct.confml.editor.view.vemodel.EViewEntry<org.eclipse.emf.ecore.EString, com.nokia.tools.vct.confml.editor.view.vemodel.EView>"
	 * @generated
	 */
	EMap<String, EView> getViews();

	/**
	 * Returns the value of the '<em><b>Use Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Count</em>' attribute.
	 * @see #setUseCount(int)
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage#getEViewsEditorDocument_UseCount()
	 * @model required="true" transient="true"
	 * @generated
	 */
	int getUseCount();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.EViewsEditorDocument#getUseCount <em>Use Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Count</em>' attribute.
	 * @see #getUseCount()
	 * @generated
	 */
	void setUseCount(int value);

	/**
	 * Returns the value of the '<em><b>Features</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link com.nokia.tools.vct.confml.editor.view.vemodel.EFeature},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' map.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage#getEViewsEditorDocument_Features()
	 * @model mapType="com.nokia.tools.vct.confml.editor.view.vemodel.EFeatureEntry<org.eclipse.emf.ecore.EString, com.nokia.tools.vct.confml.editor.view.vemodel.EFeature>"
	 * @generated
	 */
	EMap<String, EFeature> getFeatures();

	/**
	 * Returns the value of the '<em><b>All Views</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.confml.editor.view.vemodel.EView}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Views</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Views</em>' containment reference list.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage#getEViewsEditorDocument_AllViews()
	 * @model containment="true"
	 * @generated
	 */
	EList<EView> getAllViews();

} // EDocumentRoot
