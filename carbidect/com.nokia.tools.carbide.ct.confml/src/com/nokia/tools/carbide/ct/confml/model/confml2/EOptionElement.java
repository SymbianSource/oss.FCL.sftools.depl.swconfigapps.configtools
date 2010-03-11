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
 * A representation of the model object '<em><b>EOption Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.EOptionElement#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.EOptionElement#getValue <em>Value</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.EOptionElement#getRelevant <em>Relevant</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.EOptionElement#getMap <em>Map</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getEOptionElement()
 * @model extendedMetaData="name='optionType' kind='elementOnly'"
 * @generated
 */
public interface EOptionElement extends ECommonAttrs, ELinkContainer,
		EDescriptionContainer, EIconContainer {
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
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getEOptionElement_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EOptionElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getEOptionElement_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EOptionElement#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

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
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getEOptionElement_Relevant()
	 * @model
	 * @generated
	 */
	String getRelevant();

	/**
	 * Sets the value of the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EOptionElement#getRelevant <em>Relevant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relevant</em>' attribute.
	 * @see #getRelevant()
	 * @generated
	 */
	void setRelevant(String value);

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
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getEOptionElement_Map()
	 * @model
	 * @generated
	 */
	String getMap();

	/**
	 * Sets the value of the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.EOptionElement#getMap <em>Map</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Map</em>' attribute.
	 * @see #getMap()
	 * @generated
	 */
	void setMap(String value);

} // EOptionElement
