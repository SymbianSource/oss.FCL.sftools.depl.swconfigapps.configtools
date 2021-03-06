/**
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
 * All rights reserved.
 * This component and the accompanying materials are made available
 * under the terms of "Eclipse Public License v1.0"
 * which accompanies this distribution, and is available
 * at the URL "http://www.eclipse.org/legal/epl-v10.html".
 * 
 * Initial Contributors:
 * Nokia Corporation - initial contribution.
 * 
 * Contributors:
 * 
 * Description:
 *
 * $Id$
 */
package com.nokia.tools.carbide.ct.confml.model.confml2;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ETarget Path Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.ETargetPathElement#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.ETargetPathElement#getReadOnly <em>Read Only</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.ETargetPathElement#getRequired <em>Required</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.ETargetPathElement#getMap <em>Map</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getETargetPathElement()
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
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getETargetPathElement_Constraint()
	 * @model
	 * @generated
	 */
	String getConstraint();

	/**
	 * Sets the value of the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ETargetPathElement#getConstraint <em>Constraint</em>}' attribute.
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
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getETargetPathElement_ReadOnly()
	 * @model
	 * @generated
	 */
	String getReadOnly();

	/**
	 * Sets the value of the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ETargetPathElement#getReadOnly <em>Read Only</em>}' attribute.
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
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getETargetPathElement_Required()
	 * @model
	 * @generated
	 */
	String getRequired();

	/**
	 * Sets the value of the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ETargetPathElement#getRequired <em>Required</em>}' attribute.
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
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getETargetPathElement_Map()
	 * @model
	 * @generated
	 */
	String getMap();

	/**
	 * Sets the value of the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ETargetPathElement#getMap <em>Map</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Map</em>' attribute.
	 * @see #getMap()
	 * @generated
	 */
	void setMap(String value);

} // ETargetPathElement
