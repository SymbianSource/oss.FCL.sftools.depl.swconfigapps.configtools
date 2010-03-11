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

import com.nokia.tools.carbide.ct.confml.model.xsd.ELength;
import com.nokia.tools.carbide.ct.confml.model.xsd.EMaxExclusive;
import com.nokia.tools.carbide.ct.confml.model.xsd.EMaxInclusive;
import com.nokia.tools.carbide.ct.confml.model.xsd.EMaxLength;
import com.nokia.tools.carbide.ct.confml.model.xsd.EMinExclusive;
import com.nokia.tools.carbide.ct.confml.model.xsd.EMinInclusive;
import com.nokia.tools.carbide.ct.confml.model.xsd.EMinLength;
import com.nokia.tools.carbide.ct.confml.model.xsd.EPattern;
import com.nokia.tools.carbide.ct.confml.model.xsd.ETotalDigits;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ESetting Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getRef <em>Ref</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getReadOnly <em>Read Only</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getRelevant <em>Relevant</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getRequired <em>Required</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getMapKey <em>Map Key</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getMapValue <em>Map Value</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getOptions <em>Options</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getProperties <em>Properties</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getType <em>Type</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getMinOccurs <em>Min Occurs</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getMaxOccurs <em>Max Occurs</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getMinExclusive <em>Min Exclusive</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getMaxExclusive <em>Max Exclusive</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getMinInclusive <em>Min Inclusive</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getMaxInclusive <em>Max Inclusive</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getMinLength <em>Min Length</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getMaxLength <em>Max Length</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getLength <em>Length</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getTotalDigits <em>Total Digits</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getPattern <em>Pattern</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getLocalPath <em>Local Path</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getTargetPath <em>Target Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getESettingElement()
 * @model extendedMetaData="name='settingType' kind='elementOnly'"
 * @generated
 */
public interface ESettingElement extends ECommonAttrs, EDescriptionContainer,
		ELinkContainer, ESettingTypeContainer, EIconContainer {
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
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getESettingElement_Ref()
	 * @model required="true"
	 *        extendedMetaData="kind='attribute' name='ref'"
	 * @generated
	 */
	String getRef();

	/**
	 * Sets the value of the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getRef <em>Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref</em>' attribute.
	 * @see #getRef()
	 * @generated
	 */
	void setRef(String value);

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
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getESettingElement_ReadOnly()
	 * @model
	 * @generated
	 */
	String getReadOnly();

	/**
	 * Sets the value of the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getReadOnly <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Read Only</em>' attribute.
	 * @see #getReadOnly()
	 * @generated
	 */
	void setReadOnly(String value);

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
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getESettingElement_Relevant()
	 * @model
	 * @generated
	 */
	String getRelevant();

	/**
	 * Sets the value of the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getRelevant <em>Relevant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relevant</em>' attribute.
	 * @see #getRelevant()
	 * @generated
	 */
	void setRelevant(String value);

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
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getESettingElement_Required()
	 * @model
	 * @generated
	 */
	String getRequired();

	/**
	 * Sets the value of the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getRequired <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required</em>' attribute.
	 * @see #getRequired()
	 * @generated
	 */
	void setRequired(String value);

	/**
	 * Returns the value of the '<em><b>Map Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Map Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Map Key</em>' attribute.
	 * @see #setMapKey(String)
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getESettingElement_MapKey()
	 * @model
	 * @generated
	 */
	String getMapKey();

	/**
	 * Sets the value of the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getMapKey <em>Map Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Map Key</em>' attribute.
	 * @see #getMapKey()
	 * @generated
	 */
	void setMapKey(String value);

	/**
	 * Returns the value of the '<em><b>Map Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Map Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Map Value</em>' attribute.
	 * @see #setMapValue(String)
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getESettingElement_MapValue()
	 * @model
	 * @generated
	 */
	String getMapValue();

	/**
	 * Sets the value of the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getMapValue <em>Map Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Map Value</em>' attribute.
	 * @see #getMapValue()
	 * @generated
	 */
	void setMapValue(String value);

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
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getESettingElement_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getESettingElement_Constraint()
	 * @model
	 * @generated
	 */
	String getConstraint();

	/**
	 * Sets the value of the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getConstraint <em>Constraint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint</em>' attribute.
	 * @see #getConstraint()
	 * @generated
	 */
	void setConstraint(String value);

	/**
	 * Returns the value of the '<em><b>Options</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.carbide.ct.confml.model.confml2.EOptionElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Options</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Options</em>' containment reference list.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getESettingElement_Options()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='option' namespace='##targetNamespace' group='#contents:0'"
	 * @generated
	 */
	EList<EOptionElement> getOptions();

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.carbide.ct.confml.model.confml2.EPropertyElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getESettingElement_Properties()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='property' namespace='##targetNamespace' group='#contents:0'"
	 * @generated
	 */
	EList<EPropertyElement> getProperties();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getESettingElement_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Min Occurs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Occurs</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Occurs</em>' attribute.
	 * @see #setMinOccurs(Integer)
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getESettingElement_MinOccurs()
	 * @model
	 * @generated
	 */
	Integer getMinOccurs();

	/**
	 * Sets the value of the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getMinOccurs <em>Min Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Occurs</em>' attribute.
	 * @see #getMinOccurs()
	 * @generated
	 */
	void setMinOccurs(Integer value);

	/**
	 * Returns the value of the '<em><b>Max Occurs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Occurs</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Occurs</em>' attribute.
	 * @see #setMaxOccurs(Integer)
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getESettingElement_MaxOccurs()
	 * @model
	 * @generated
	 */
	Integer getMaxOccurs();

	/**
	 * Sets the value of the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getMaxOccurs <em>Max Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Occurs</em>' attribute.
	 * @see #getMaxOccurs()
	 * @generated
	 */
	void setMaxOccurs(Integer value);

	/**
	 * Returns the value of the '<em><b>Min Exclusive</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.carbide.ct.confml.model.xsd.EMinExclusive}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Exclusive</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Exclusive</em>' containment reference list.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getESettingElement_MinExclusive()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='minExclusive' namespace='http://www.w3.org/2001/XMLSchema' group='#contents:0'"
	 * @generated
	 */
	EList<EMinExclusive> getMinExclusive();

	/**
	 * Returns the value of the '<em><b>Max Exclusive</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.carbide.ct.confml.model.xsd.EMaxExclusive}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Exclusive</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Exclusive</em>' containment reference list.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getESettingElement_MaxExclusive()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='maxExclusive' namespace='http://www.w3.org/2001/XMLSchema' group='#contents:0'"
	 * @generated
	 */
	EList<EMaxExclusive> getMaxExclusive();

	/**
	 * Returns the value of the '<em><b>Min Inclusive</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.carbide.ct.confml.model.xsd.EMinInclusive}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Inclusive</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Inclusive</em>' containment reference list.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getESettingElement_MinInclusive()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='minInclusive' namespace='http://www.w3.org/2001/XMLSchema' group='#contents:0'"
	 * @generated
	 */
	EList<EMinInclusive> getMinInclusive();

	/**
	 * Returns the value of the '<em><b>Max Inclusive</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.carbide.ct.confml.model.xsd.EMaxInclusive}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Inclusive</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Inclusive</em>' containment reference list.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getESettingElement_MaxInclusive()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='maxInclusive' namespace='http://www.w3.org/2001/XMLSchema' group='#contents:0'"
	 * @generated
	 */
	EList<EMaxInclusive> getMaxInclusive();

	/**
	 * Returns the value of the '<em><b>Min Length</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.carbide.ct.confml.model.xsd.EMinLength}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Length</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Length</em>' containment reference list.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getESettingElement_MinLength()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='minLength' namespace='http://www.w3.org/2001/XMLSchema' group='#contents:0'"
	 * @generated
	 */
	EList<EMinLength> getMinLength();

	/**
	 * Returns the value of the '<em><b>Max Length</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.carbide.ct.confml.model.xsd.EMaxLength}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Length</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Length</em>' containment reference list.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getESettingElement_MaxLength()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='maxLength' namespace='http://www.w3.org/2001/XMLSchema' group='#contents:0'"
	 * @generated
	 */
	EList<EMaxLength> getMaxLength();

	/**
	 * Returns the value of the '<em><b>Length</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.carbide.ct.confml.model.xsd.ELength}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Length</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Length</em>' containment reference list.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getESettingElement_Length()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='length' namespace='http://www.w3.org/2001/XMLSchema' group='#contents:0'"
	 * @generated
	 */
	EList<ELength> getLength();

	/**
	 * Returns the value of the '<em><b>Total Digits</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.carbide.ct.confml.model.xsd.ETotalDigits}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Digits</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Digits</em>' containment reference list.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getESettingElement_TotalDigits()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='totalDigits' namespace='http://www.w3.org/2001/XMLSchema' group='#contents:0'"
	 * @generated
	 */
	EList<ETotalDigits> getTotalDigits();

	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.carbide.ct.confml.model.xsd.EPattern}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' containment reference list.
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getESettingElement_Pattern()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='pattern' namespace='http://www.w3.org/2001/XMLSchema' group='#contents:0'"
	 * @generated
	 */
	EList<EPattern> getPattern();

	/**
	 * Returns the value of the '<em><b>Local Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Path</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Path</em>' containment reference.
	 * @see #setLocalPath(ELocalPathElement)
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getESettingElement_LocalPath()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='localPath' namespace='##targetNamespace' group='#contents:0'"
	 * @generated
	 */
	ELocalPathElement getLocalPath();

	/**
	 * Sets the value of the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getLocalPath <em>Local Path</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Path</em>' containment reference.
	 * @see #getLocalPath()
	 * @generated
	 */
	void setLocalPath(ELocalPathElement value);

	/**
	 * Returns the value of the '<em><b>Target Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Path</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Path</em>' containment reference.
	 * @see #setTargetPath(ETargetPathElement)
	 * @see com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package#getESettingElement_TargetPath()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='targetPath' namespace='##targetNamespace' group='#contents:0'"
	 * @generated
	 */
	ETargetPathElement getTargetPath();

	/**
	 * Sets the value of the '{@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingElement#getTargetPath <em>Target Path</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Path</em>' containment reference.
	 * @see #getTargetPath()
	 * @generated
	 */
	void setTargetPath(ETargetPathElement value);

} // ESettingElement
