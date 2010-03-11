/*
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
*/
package configurationemf;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Setting</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link configurationemf.Setting#getName <em>Name</em>}</li>
 *   <li>{@link configurationemf.Setting#getType <em>Type</em>}</li>
 *   <li>{@link configurationemf.Setting#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link configurationemf.Setting#getRelevant <em>Relevant</em>}</li>
 *   <li>{@link configurationemf.Setting#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link configurationemf.Setting#getRequired <em>Required</em>}</li>
 *   <li>{@link configurationemf.Setting#getOption <em>Option</em>}</li>
 *   <li>{@link configurationemf.Setting#getProperty <em>Property</em>}</li>
 *   <li>{@link configurationemf.Setting#getMinLength <em>Min Length</em>}</li>
 *   <li>{@link configurationemf.Setting#getMaxLength <em>Max Length</em>}</li>
 *   <li>{@link configurationemf.Setting#getLength <em>Length</em>}</li>
 *   <li>{@link configurationemf.Setting#getMaxInclusive <em>Max Inclusive</em>}</li>
 *   <li>{@link configurationemf.Setting#getMaxExclusive <em>Max Exclusive</em>}</li>
 *   <li>{@link configurationemf.Setting#getMinExclusive <em>Min Exclusive</em>}</li>
 *   <li>{@link configurationemf.Setting#getPattern <em>Pattern</em>}</li>
 *   <li>{@link configurationemf.Setting#getMinInclusive <em>Min Inclusive</em>}</li>
 *   <li>{@link configurationemf.Setting#getTotalDigits <em>Total Digits</em>}</li>
 *   <li>{@link configurationemf.Setting#getLink <em>Link</em>}</li>
 *   <li>{@link configurationemf.Setting#getIcon <em>Icon</em>}</li>
 *   <li>{@link configurationemf.Setting#getBoolOptions <em>Bool Options</em>}</li>
 *   <li>{@link configurationemf.Setting#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link configurationemf.Setting#getCurrentValue <em>Current Value</em>}</li>
 *   <li>{@link configurationemf.Setting#getTopValue <em>Top Value</em>}</li>
 *   <li>{@link configurationemf.Setting#getCurrentConf <em>Current Conf</em>}</li>
 *   <li>{@link configurationemf.Setting#getDefaultConf <em>Default Conf</em>}</li>
 *   <li>{@link configurationemf.Setting#isRo <em>Ro</em>}</li>
 *   <li>{@link configurationemf.Setting#getPossibleValue <em>Possible Value</em>}</li>
 *   <li>{@link configurationemf.Setting#getCurrentType <em>Current Type</em>}</li>
 *   <li>{@link configurationemf.Setting#isValueChangeble <em>Value Changeble</em>}</li>
 *   <li>{@link configurationemf.Setting#isRfs <em>Rfs</em>}</li>
 * </ul>
 * </p>
 *
 * @see configurationemf.ConfigurationemfPackage#getSetting()
 * @model abstract="true"
 * @generated
 */
public interface Setting extends Referable {
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
	 * @see configurationemf.ConfigurationemfPackage#getSetting_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link configurationemf.Setting#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link configurationemf.TYPE}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see configurationemf.TYPE
	 * @see #setType(TYPE)
	 * @see configurationemf.ConfigurationemfPackage#getSetting_Type()
	 * @model
	 * @generated
	 */
	TYPE getType();

	/**
	 * Sets the value of the '{@link configurationemf.Setting#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see configurationemf.TYPE
	 * @see #getType()
	 * @generated
	 */
	void setType(TYPE value);

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
	 * @see configurationemf.ConfigurationemfPackage#getSetting_Constraint()
	 * @model
	 * @generated
	 */
	String getConstraint();

	/**
	 * Sets the value of the '{@link configurationemf.Setting#getConstraint <em>Constraint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint</em>' attribute.
	 * @see #getConstraint()
	 * @generated
	 */
	void setConstraint(String value);

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
	 * @see configurationemf.ConfigurationemfPackage#getSetting_Relevant()
	 * @model
	 * @generated
	 */
	String getRelevant();

	/**
	 * Sets the value of the '{@link configurationemf.Setting#getRelevant <em>Relevant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relevant</em>' attribute.
	 * @see #getRelevant()
	 * @generated
	 */
	void setRelevant(String value);

	/**
	 * Returns the value of the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Read Only</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Read Only</em>' attribute.
	 * @see #setReadOnly(boolean)
	 * @see configurationemf.ConfigurationemfPackage#getSetting_ReadOnly()
	 * @model
	 * @generated
	 */
	boolean isReadOnly();

	/**
	 * Sets the value of the '{@link configurationemf.Setting#isReadOnly <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Read Only</em>' attribute.
	 * @see #isReadOnly()
	 * @generated
	 */
	void setReadOnly(boolean value);

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
	 * @see configurationemf.ConfigurationemfPackage#getSetting_Required()
	 * @model
	 * @generated
	 */
	String getRequired();

	/**
	 * Sets the value of the '{@link configurationemf.Setting#getRequired <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required</em>' attribute.
	 * @see #getRequired()
	 * @generated
	 */
	void setRequired(String value);

	/**
	 * Returns the value of the '<em><b>Option</b></em>' containment reference list.
	 * The list contents are of type {@link configurationemf.Option}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Option</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Option</em>' containment reference list.
	 * @see configurationemf.ConfigurationemfPackage#getSetting_Option()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Option> getOption();

	/**
	 * Returns the value of the '<em><b>Property</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property</em>' containment reference.
	 * @see #setProperty(Property)
	 * @see configurationemf.ConfigurationemfPackage#getSetting_Property()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Property getProperty();

	/**
	 * Sets the value of the '{@link configurationemf.Setting#getProperty <em>Property</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property</em>' containment reference.
	 * @see #getProperty()
	 * @generated
	 */
	void setProperty(Property value);

	/**
	 * Returns the value of the '<em><b>Min Length</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Length</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Length</em>' containment reference.
	 * @see #setMinLength(MinLength)
	 * @see configurationemf.ConfigurationemfPackage#getSetting_MinLength()
	 * @model containment="true" required="true"
	 * @generated
	 */
	MinLength getMinLength();

	/**
	 * Sets the value of the '{@link configurationemf.Setting#getMinLength <em>Min Length</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Length</em>' containment reference.
	 * @see #getMinLength()
	 * @generated
	 */
	void setMinLength(MinLength value);

	/**
	 * Returns the value of the '<em><b>Max Length</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Length</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Length</em>' containment reference.
	 * @see #setMaxLength(MaxLength)
	 * @see configurationemf.ConfigurationemfPackage#getSetting_MaxLength()
	 * @model containment="true" required="true"
	 * @generated
	 */
	MaxLength getMaxLength();

	/**
	 * Sets the value of the '{@link configurationemf.Setting#getMaxLength <em>Max Length</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Length</em>' containment reference.
	 * @see #getMaxLength()
	 * @generated
	 */
	void setMaxLength(MaxLength value);

	/**
	 * Returns the value of the '<em><b>Length</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Length</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Length</em>' containment reference.
	 * @see #setLength(Length)
	 * @see configurationemf.ConfigurationemfPackage#getSetting_Length()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Length getLength();

	/**
	 * Sets the value of the '{@link configurationemf.Setting#getLength <em>Length</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Length</em>' containment reference.
	 * @see #getLength()
	 * @generated
	 */
	void setLength(Length value);

	/**
	 * Returns the value of the '<em><b>Max Inclusive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Inclusive</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Inclusive</em>' containment reference.
	 * @see #setMaxInclusive(MaxInclusive)
	 * @see configurationemf.ConfigurationemfPackage#getSetting_MaxInclusive()
	 * @model containment="true" required="true"
	 * @generated
	 */
	MaxInclusive getMaxInclusive();

	/**
	 * Sets the value of the '{@link configurationemf.Setting#getMaxInclusive <em>Max Inclusive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Inclusive</em>' containment reference.
	 * @see #getMaxInclusive()
	 * @generated
	 */
	void setMaxInclusive(MaxInclusive value);

	/**
	 * Returns the value of the '<em><b>Max Exclusive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Exclusive</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Exclusive</em>' containment reference.
	 * @see #setMaxExclusive(MaxExclusive)
	 * @see configurationemf.ConfigurationemfPackage#getSetting_MaxExclusive()
	 * @model containment="true" required="true"
	 * @generated
	 */
	MaxExclusive getMaxExclusive();

	/**
	 * Sets the value of the '{@link configurationemf.Setting#getMaxExclusive <em>Max Exclusive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Exclusive</em>' containment reference.
	 * @see #getMaxExclusive()
	 * @generated
	 */
	void setMaxExclusive(MaxExclusive value);

	/**
	 * Returns the value of the '<em><b>Min Exclusive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Exclusive</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Exclusive</em>' containment reference.
	 * @see #setMinExclusive(MinExclusive)
	 * @see configurationemf.ConfigurationemfPackage#getSetting_MinExclusive()
	 * @model containment="true" required="true"
	 * @generated
	 */
	MinExclusive getMinExclusive();

	/**
	 * Sets the value of the '{@link configurationemf.Setting#getMinExclusive <em>Min Exclusive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Exclusive</em>' containment reference.
	 * @see #getMinExclusive()
	 * @generated
	 */
	void setMinExclusive(MinExclusive value);

	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' containment reference.
	 * @see #setPattern(Pattern)
	 * @see configurationemf.ConfigurationemfPackage#getSetting_Pattern()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Pattern getPattern();

	/**
	 * Sets the value of the '{@link configurationemf.Setting#getPattern <em>Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern</em>' containment reference.
	 * @see #getPattern()
	 * @generated
	 */
	void setPattern(Pattern value);

	/**
	 * Returns the value of the '<em><b>Min Inclusive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Inclusive</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Inclusive</em>' containment reference.
	 * @see #setMinInclusive(MinInclusive)
	 * @see configurationemf.ConfigurationemfPackage#getSetting_MinInclusive()
	 * @model containment="true" required="true"
	 * @generated
	 */
	MinInclusive getMinInclusive();

	/**
	 * Sets the value of the '{@link configurationemf.Setting#getMinInclusive <em>Min Inclusive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Inclusive</em>' containment reference.
	 * @see #getMinInclusive()
	 * @generated
	 */
	void setMinInclusive(MinInclusive value);

	/**
	 * Returns the value of the '<em><b>Total Digits</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Digits</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Digits</em>' containment reference.
	 * @see #setTotalDigits(TotalDigits)
	 * @see configurationemf.ConfigurationemfPackage#getSetting_TotalDigits()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TotalDigits getTotalDigits();

	/**
	 * Sets the value of the '{@link configurationemf.Setting#getTotalDigits <em>Total Digits</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Digits</em>' containment reference.
	 * @see #getTotalDigits()
	 * @generated
	 */
	void setTotalDigits(TotalDigits value);

	/**
	 * Returns the value of the '<em><b>Link</b></em>' containment reference list.
	 * The list contents are of type {@link configurationemf.Link}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link</em>' containment reference list.
	 * @see configurationemf.ConfigurationemfPackage#getSetting_Link()
	 * @model containment="true"
	 * @generated
	 */
	EList<Link> getLink();

	/**
	 * Returns the value of the '<em><b>Icon</b></em>' containment reference list.
	 * The list contents are of type {@link configurationemf.Icon}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon</em>' containment reference list.
	 * @see configurationemf.ConfigurationemfPackage#getSetting_Icon()
	 * @model containment="true"
	 * @generated
	 */
	EList<Icon> getIcon();

	/**
	 * Returns the value of the '<em><b>Bool Options</b></em>' reference list.
	 * The list contents are of type {@link configurationemf.Option}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bool Options</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bool Options</em>' reference list.
	 * @see configurationemf.ConfigurationemfPackage#getSetting_BoolOptions()
	 * @model lower="2" upper="2" transient="true" changeable="false" volatile="true"
	 * @generated
	 */
	EList<Option> getBoolOptions();

	/**
	 * Returns the value of the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Value</em>' attribute.
	 * @see configurationemf.ConfigurationemfPackage#getSetting_DefaultValue()
	 * @model transient="true" changeable="false" volatile="true"
	 * @generated
	 */
	String getDefaultValue();

	

	/**
	 * Returns the value of the '<em><b>Current Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Value</em>' attribute.
	 * @see #setCurrentValue(String)
	 * @see configurationemf.ConfigurationemfPackage#getSetting_CurrentValue()
	 * @model transient="true" volatile="true"
	 * @generated
	 */
	String getCurrentValue();

	/**
	 * Sets the value of the '{@link configurationemf.Setting#getCurrentValue <em>Current Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Value</em>' attribute.
	 * @see #getCurrentValue()
	 * @generated
	 */
	void setCurrentValue(String value);

	/**
	 * Returns the value of the '<em><b>Top Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Top Value</em>' attribute.
	 * @see configurationemf.ConfigurationemfPackage#getSetting_TopValue()
	 * @model transient="true" changeable="false" volatile="true"
	 * @generated
	 */
	String getTopValue();

	/**
	 * Returns the value of the '<em><b>Current Conf</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current Conf</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Conf</em>' reference.
	 * @see configurationemf.ConfigurationemfPackage#getSetting_CurrentConf()
	 * @model transient="true" changeable="false"
	 * @generated
	 */
	Configuration getCurrentConf();

	/**
	 * Returns the value of the '<em><b>Default Conf</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Conf</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Conf</em>' reference.
	 * @see configurationemf.ConfigurationemfPackage#getSetting_DefaultConf()
	 * @model transient="true" changeable="false"
	 * @generated
	 */
	Configuration getDefaultConf();

	/**
	 * Returns the value of the '<em><b>Ro</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ro</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ro</em>' attribute.
	 * @see configurationemf.ConfigurationemfPackage#getSetting_Ro()
	 * @model transient="true" changeable="false" volatile="true"
	 * @generated
	 */
	boolean isRo();

	/**
	 * Returns the value of the '<em><b>Possible Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Possible Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Possible Value</em>' attribute.
	 * @see configurationemf.ConfigurationemfPackage#getSetting_PossibleValue()
	 * @model many="false" transient="true" changeable="false" volatile="true"
	 * @generated NOT
	 */
	EList<String> getPossibleValue();

	/**
	 * Returns the value of the '<em><b>Current Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Type</em>' attribute.
	 * @see #setCurrentType(String)
	 * @see configurationemf.ConfigurationemfPackage#getSetting_CurrentType()
	 * @model transient="true" volatile="true"
	 * @generated
	 */
	String getCurrentType();

	/**
	 * Sets the value of the '{@link configurationemf.Setting#getCurrentType <em>Current Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Type</em>' attribute.
	 * @see #getCurrentType()
	 * @generated
	 */
	void setCurrentType(String value);

	/**
	 * Returns the value of the '<em><b>Value Changeble</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Changeble</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Changeble</em>' attribute.
	 * @see configurationemf.ConfigurationemfPackage#getSetting_ValueChangeble()
	 * @model transient="true" changeable="false" volatile="true"
	 * @generated
	 */
	boolean isValueChangeble();

	/**
	 * Returns the value of the '<em><b>Rfs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rfs</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rfs</em>' attribute.
	 * @see #setRfs(boolean)
	 * @see configurationemf.ConfigurationemfPackage#getSetting_Rfs()
	 * @model transient="true" volatile="true"
	 * @generated
	 */
	boolean isRfs();

	/**
	 * Sets the value of the '{@link configurationemf.Setting#isRfs <em>Rfs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rfs</em>' attribute.
	 * @see #isRfs()
	 * @generated
	 */
	void setRfs(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String getConfValue(Configuration configuration);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String getUserValue(String systemValue);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String getSystemValue(String userValue);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setConfRfs(boolean rfs, RootConf rootConf);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated NOT
	 */
	Object getGValue();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	RootConf getGConf();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getAbsRef();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setConfValue(String value, Configuration conf);

	void addSetting(Setting setting);
	void removeSetting(Setting setting);
} // Setting