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
 * Description: This file is part of com.nokia.tools.variant.content.confml.model component.
 */

package com.nokia.tools.s60ct.content.confml;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.Feature#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.Feature#getRef <em>Ref</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.Feature#getRelevant <em>Relevant</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.Feature#getDescription <em>Description</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.Feature#getIconTitle <em>Icon Title</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.Feature#getIconDescriptor <em>Icon Descriptor</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.Feature#getIconURI <em>Icon URI</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.Feature#isComputedRelevant <em>Computed Relevant</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.Feature#getRelevantAST <em>Relevant AST</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getFeature()
 * @model
 * @generated
 */
public interface Feature extends EObject {
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
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getFeature_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.Feature#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref</em>' attribute.
	 * @see #setRef(String)
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getFeature_Ref()
	 * @model
	 * @generated
	 */
	String getRef();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.Feature#getRef <em>Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref</em>' attribute.
	 * @see #getRef()
	 * @generated
	 */
	void setRef(String value);

	/**
	 * Returns the value of the '<em><b>Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relevant</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relevant</em>' attribute.
	 * @see #setRelevant(String)
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getFeature_Relevant()
	 * @model
	 * @generated
	 */
	String getRelevant();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.Feature#getRelevant <em>Relevant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relevant</em>' attribute.
	 * @see #getRelevant()
	 * @generated
	 */
	void setRelevant(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getFeature_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.Feature#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Icon Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon Title</em>' attribute.
	 * @see #setIconTitle(String)
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getFeature_IconTitle()
	 * @model
	 * @generated
	 */
	String getIconTitle();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.Feature#getIconTitle <em>Icon Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon Title</em>' attribute.
	 * @see #getIconTitle()
	 * @generated
	 */
	void setIconTitle(String value);

	/**
	 * Returns the value of the '<em><b>Icon Descriptor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon Descriptor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon Descriptor</em>' attribute.
	 * @see #setIconDescriptor(Object)
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getFeature_IconDescriptor()
	 * @model dataType="com.nokia.tools.variant.content.confml.Object"
	 * @generated
	 */
	Object getIconDescriptor();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.Feature#getIconDescriptor <em>Icon Descriptor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon Descriptor</em>' attribute.
	 * @see #getIconDescriptor()
	 * @generated
	 */
	void setIconDescriptor(Object value);

	/**
	 * Returns the value of the '<em><b>Icon URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon URI</em>' attribute.
	 * @see #setIconURI(URI)
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getFeature_IconURI()
	 * @model dataType="com.nokia.tools.variant.content.confml.URI"
	 * @generated
	 */
	URI getIconURI();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.Feature#getIconURI <em>Icon URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon URI</em>' attribute.
	 * @see #getIconURI()
	 * @generated
	 */
	void setIconURI(URI value);

	/**
	 * Returns the value of the '<em><b>Computed Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Computed Relevant</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Computed Relevant</em>' attribute.
	 * @see #setComputedRelevant(boolean)
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getFeature_ComputedRelevant()
	 * @model
	 * @generated
	 */
	boolean isComputedRelevant();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.Feature#isComputedRelevant <em>Computed Relevant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Computed Relevant</em>' attribute.
	 * @see #isComputedRelevant()
	 * @generated
	 */
	void setComputedRelevant(boolean value);

	/**
	 * Returns the value of the '<em><b>Relevant AST</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relevant AST</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relevant AST</em>' attribute.
	 * @see #setRelevantAST(Object)
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getFeature_RelevantAST()
	 * @model dataType="com.nokia.tools.variant.content.confml.Object"
	 * @generated
	 */
	Object getRelevantAST();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.Feature#getRelevantAST <em>Relevant AST</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relevant AST</em>' attribute.
	 * @see #getRelevantAST()
	 * @generated
	 */
	void setRelevantAST(Object value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	View getView();

} // Feature
