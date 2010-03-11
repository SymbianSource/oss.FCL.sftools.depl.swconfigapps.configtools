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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UI Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.editor.model.summaryModel.UIElement#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.model.summaryModel.UIElement#getType <em>Type</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.model.summaryModel.UIElement#getLastSavedValue <em>Last Saved Value</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.model.summaryModel.UIElement#getValue <em>Value</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.model.summaryModel.UIElement#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.model.summaryModel.UIElement#getNote <em>Note</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.variant.editor.model.summaryModel.SummaryModelPackage#getUIElement()
 * @model
 * @generated
 */
public interface UIElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.nokia.tools.variant.editor.model.summaryModel.SummaryModelPackage#getUIElement_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.editor.model.summaryModel.UIElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link com.nokia.tools.variant.editor.model.summaryModel.SUMMARYTYPE}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see com.nokia.tools.variant.editor.model.summaryModel.SUMMARYTYPE
	 * @see #setType(SUMMARYTYPE)
	 * @see com.nokia.tools.variant.editor.model.summaryModel.SummaryModelPackage#getUIElement_Type()
	 * @model
	 * @generated
	 */
	SUMMARYTYPE getType();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.editor.model.summaryModel.UIElement#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see com.nokia.tools.variant.editor.model.summaryModel.SUMMARYTYPE
	 * @see #getType()
	 * @generated
	 */
	void setType(SUMMARYTYPE value);

	/**
	 * Returns the value of the '<em><b>Last Saved Value</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Saved Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Saved Value</em>' attribute.
	 * @see #setLastSavedValue(String)
	 * @see com.nokia.tools.variant.editor.model.summaryModel.SummaryModelPackage#getUIElement_LastSavedValue()
	 * @model default=""
	 * @generated
	 */
	String getLastSavedValue();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.editor.model.summaryModel.UIElement#getLastSavedValue <em>Last Saved Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Saved Value</em>' attribute.
	 * @see #getLastSavedValue()
	 * @generated
	 */
	void setLastSavedValue(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see com.nokia.tools.variant.editor.model.summaryModel.SummaryModelPackage#getUIElement_Value()
	 * @model default=""
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.editor.model.summaryModel.UIElement#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Value</em>' attribute.
	 * @see #setDefaultValue(String)
	 * @see com.nokia.tools.variant.editor.model.summaryModel.SummaryModelPackage#getUIElement_DefaultValue()
	 * @model
	 * @generated
	 */
	String getDefaultValue();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.editor.model.summaryModel.UIElement#getDefaultValue <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Value</em>' attribute.
	 * @see #getDefaultValue()
	 * @generated
	 */
	void setDefaultValue(String value);

	/**
	 * Returns the value of the '<em><b>Note</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Note</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Note</em>' attribute.
	 * @see #setNote(String)
	 * @see com.nokia.tools.variant.editor.model.summaryModel.SummaryModelPackage#getUIElement_Note()
	 * @model default=""
	 * @generated
	 */
	String getNote();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.editor.model.summaryModel.UIElement#getNote <em>Note</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Note</em>' attribute.
	 * @see #getNote()
	 * @generated
	 */
	void setNote(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isDirty();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isDefault();

} // UIElement
