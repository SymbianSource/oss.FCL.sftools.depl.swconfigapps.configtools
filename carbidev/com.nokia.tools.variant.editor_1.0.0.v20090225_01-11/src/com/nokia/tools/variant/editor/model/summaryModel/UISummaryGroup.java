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

package com.nokia.tools.variant.editor.model.summaryModel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UI Summary Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.editor.model.summaryModel.UISummaryGroup#getTitle <em>Title</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.model.summaryModel.UISummaryGroup#getUiElements <em>Ui Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.variant.editor.model.summaryModel.SummaryModelPackage#getUISummaryGroup()
 * @model
 * @generated
 */
public interface UISummaryGroup extends EObject {
	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see com.nokia.tools.variant.editor.model.summaryModel.SummaryModelPackage#getUISummaryGroup_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.editor.model.summaryModel.UISummaryGroup#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Ui Elements</b></em>' reference list.
	 * The list contents are of type {@link com.nokia.tools.variant.editor.model.summaryModel.UIElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ui Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ui Elements</em>' reference list.
	 * @see com.nokia.tools.variant.editor.model.summaryModel.SummaryModelPackage#getUISummaryGroup_UiElements()
	 * @model
	 * @generated
	 */
	EList<UIElement> getUiElements();

} // UISummaryGroup
