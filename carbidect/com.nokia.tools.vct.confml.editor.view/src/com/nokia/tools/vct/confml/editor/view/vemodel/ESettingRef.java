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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ESetting Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getFeatureId <em>Feature Id</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getSettingId <em>Setting Id</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getTarget <em>Target</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getMinInclusive <em>Min Inclusive</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getMaxInclusive <em>Max Inclusive</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getMinExclusive <em>Min Exclusive</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getMaxExclusive <em>Max Exclusive</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getLength <em>Length</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getMaxLength <em>Max Length</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getMinLength <em>Min Length</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getPatterns <em>Patterns</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getOptions <em>Options</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage#getESettingRef()
 * @model
 * @generated
 */
public interface ESettingRef extends EDescriptionContainer {
	/**
	 * Returns the value of the '<em><b>Feature Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Id</em>' attribute.
	 * @see #setFeatureId(String)
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage#getESettingRef_FeatureId()
	 * @model required="true"
	 * @generated
	 */
	String getFeatureId();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getFeatureId <em>Feature Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Id</em>' attribute.
	 * @see #getFeatureId()
	 * @generated
	 */
	void setFeatureId(String value);

	/**
	 * Returns the value of the '<em><b>Setting Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Setting Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Setting Id</em>' attribute.
	 * @see #setSettingId(String)
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage#getESettingRef_SettingId()
	 * @model required="true"
	 * @generated
	 */
	String getSettingId();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getSettingId <em>Setting Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Setting Id</em>' attribute.
	 * @see #getSettingId()
	 * @generated
	 */
	void setSettingId(String value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ERefTarget#getRefs <em>Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(ERefTarget)
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage#getESettingRef_Target()
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.ERefTarget#getRefs
	 * @model opposite="refs"
	 * @generated
	 */
	ERefTarget getTarget();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(ERefTarget value);

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
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage#getESettingRef_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Min Inclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Inclusive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Inclusive</em>' attribute.
	 * @see #setMinInclusive(String)
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage#getESettingRef_MinInclusive()
	 * @model
	 * @generated
	 */
	String getMinInclusive();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getMinInclusive <em>Min Inclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Inclusive</em>' attribute.
	 * @see #getMinInclusive()
	 * @generated
	 */
	void setMinInclusive(String value);

	/**
	 * Returns the value of the '<em><b>Max Inclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Inclusive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Inclusive</em>' attribute.
	 * @see #setMaxInclusive(String)
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage#getESettingRef_MaxInclusive()
	 * @model
	 * @generated
	 */
	String getMaxInclusive();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getMaxInclusive <em>Max Inclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Inclusive</em>' attribute.
	 * @see #getMaxInclusive()
	 * @generated
	 */
	void setMaxInclusive(String value);

	/**
	 * Returns the value of the '<em><b>Min Exclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Exclusive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Exclusive</em>' attribute.
	 * @see #setMinExclusive(String)
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage#getESettingRef_MinExclusive()
	 * @model
	 * @generated
	 */
	String getMinExclusive();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getMinExclusive <em>Min Exclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Exclusive</em>' attribute.
	 * @see #getMinExclusive()
	 * @generated
	 */
	void setMinExclusive(String value);

	/**
	 * Returns the value of the '<em><b>Max Exclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Exclusive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Exclusive</em>' attribute.
	 * @see #setMaxExclusive(String)
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage#getESettingRef_MaxExclusive()
	 * @model
	 * @generated
	 */
	String getMaxExclusive();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getMaxExclusive <em>Max Exclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Exclusive</em>' attribute.
	 * @see #getMaxExclusive()
	 * @generated
	 */
	void setMaxExclusive(String value);

	/**
	 * Returns the value of the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Length</em>' attribute.
	 * @see #setLength(String)
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage#getESettingRef_Length()
	 * @model
	 * @generated
	 */
	String getLength();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getLength <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Length</em>' attribute.
	 * @see #getLength()
	 * @generated
	 */
	void setLength(String value);

	/**
	 * Returns the value of the '<em><b>Max Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Length</em>' attribute.
	 * @see #setMaxLength(String)
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage#getESettingRef_MaxLength()
	 * @model
	 * @generated
	 */
	String getMaxLength();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getMaxLength <em>Max Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Length</em>' attribute.
	 * @see #getMaxLength()
	 * @generated
	 */
	void setMaxLength(String value);

	/**
	 * Returns the value of the '<em><b>Min Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Length</em>' attribute.
	 * @see #setMinLength(String)
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage#getESettingRef_MinLength()
	 * @model
	 * @generated
	 */
	String getMinLength();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getMinLength <em>Min Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Length</em>' attribute.
	 * @see #getMinLength()
	 * @generated
	 */
	void setMinLength(String value);

	/**
	 * Returns the value of the '<em><b>Patterns</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Patterns</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Patterns</em>' attribute.
	 * @see #setPatterns(String)
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage#getESettingRef_Patterns()
	 * @model
	 * @generated
	 */
	String getPatterns();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef#getPatterns <em>Patterns</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Patterns</em>' attribute.
	 * @see #getPatterns()
	 * @generated
	 */
	void setPatterns(String value);

	/**
	 * Returns the value of the '<em><b>Options</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.confml.editor.view.vemodel.ERefOption}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Options</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Options</em>' containment reference list.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage#getESettingRef_Options()
	 * @model containment="true"
	 * @generated
	 */
	EList<ERefOption> getOptions();

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.confml.editor.view.vemodel.ERefProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage#getESettingRef_Properties()
	 * @model containment="true"
	 * @generated
	 */
	EList<ERefProperty> getProperties();

} // ESettingRef
