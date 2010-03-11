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
 * Description: This file is part of com.nokia.tools.vct.confml component.
 */

package com.nokia.tools.vct.confml.model.confml2;

import com.nokia.tools.vct.confml.model.xsd.EPattern;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ETarget Path Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.ETargetPathElement#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.ETargetPathElement#getReadOnly <em>Read Only</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.ETargetPathElement#getRequired <em>Required</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.ETargetPathElement#getMap <em>Map</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.ETargetPathElement#getPattern <em>Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.confml.model.confml2.EConfML2Package#getETargetPathElement()
 * @model extendedMetaData="name='targetPathType' kind='elementOnly'"
 * @generated
 */
public interface ETargetPathElement extends ECommonAttrs,
		EDescriptionContainer, EIconContainer, ELinkContainer {

	/**
	 * Returns the value of the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint</em>' attribute.
	 * @see #setConstraint(String)
	 * @see com.nokia.tools.vct.confml.model.confml2.EConfML2Package#getETargetPathElement_Constraint()
	 * @model
	 * @generated
	 */
	String getConstraint();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.confml.model.confml2.ETargetPathElement#getConstraint <em>Constraint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint</em>' attribute.
	 * @see #getConstraint()
	 * @generated
	 */
	void setConstraint(String value);

	/**
	 * Returns the value of the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Read Only</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Read Only</em>' attribute.
	 * @see #setReadOnly(String)
	 * @see com.nokia.tools.vct.confml.model.confml2.EConfML2Package#getETargetPathElement_ReadOnly()
	 * @model
	 * @generated
	 */
	String getReadOnly();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.confml.model.confml2.ETargetPathElement#getReadOnly <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Read Only</em>' attribute.
	 * @see #getReadOnly()
	 * @generated
	 */
	void setReadOnly(String value);

	/**
	 * Returns the value of the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required</em>' attribute.
	 * @see #setRequired(String)
	 * @see com.nokia.tools.vct.confml.model.confml2.EConfML2Package#getETargetPathElement_Required()
	 * @model
	 * @generated
	 */
	String getRequired();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.confml.model.confml2.ETargetPathElement#getRequired <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required</em>' attribute.
	 * @see #getRequired()
	 * @generated
	 */
	void setRequired(String value);

	/**
	 * Returns the value of the '<em><b>Map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Map</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Map</em>' attribute.
	 * @see #setMap(String)
	 * @see com.nokia.tools.vct.confml.model.confml2.EConfML2Package#getETargetPathElement_Map()
	 * @model
	 * @generated
	 */
	String getMap();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.confml.model.confml2.ETargetPathElement#getMap <em>Map</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Map</em>' attribute.
	 * @see #getMap()
	 * @generated
	 */
	void setMap(String value);

	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.confml.model.xsd.EPattern}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' containment reference list.
	 * @see com.nokia.tools.vct.confml.model.confml2.EConfML2Package#getETargetPathElement_Pattern()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='pattern' namespace='http://www.w3.org/2001/XMLSchema' group='#contents:0'"
	 * @generated
	 */
	EList<EPattern> getPattern();
} // ETargetPathElement
