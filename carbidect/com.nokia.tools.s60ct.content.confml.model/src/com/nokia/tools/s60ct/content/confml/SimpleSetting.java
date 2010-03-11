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

import java.math.BigInteger;
import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Setting</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#getValue <em>Value</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#getLastSavedValue <em>Last Saved Value</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#getMinLength <em>Min Length</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#getMaxLength <em>Max Length</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#getLength <em>Length</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#getPattern <em>Pattern</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#getTotalDigits <em>Total Digits</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#getMaxExclusive <em>Max Exclusive</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#getMinExclusive <em>Min Exclusive</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#getMaxInclusive <em>Max Inclusive</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#getMinInclusive <em>Min Inclusive</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#isContainedInLastLayer <em>Contained In Last Layer</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#isLastSavedInLastLayer <em>Last Saved In Last Layer</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#getChosenOption <em>Chosen Option</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getSimpleSetting()
 * @model
 * @generated
 */
public interface SimpleSetting extends Setting {
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
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getSimpleSetting_DefaultValue()
	 * @model
	 * @generated
	 */
	String getDefaultValue();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#getDefaultValue <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Value</em>' attribute.
	 * @see #getDefaultValue()
	 * @generated
	 */
	void setDefaultValue(String value);

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
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getSimpleSetting_Value()
	 * @model default=""
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Last Saved Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Saved Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Saved Value</em>' attribute.
	 * @see #setLastSavedValue(String)
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getSimpleSetting_LastSavedValue()
	 * @model
	 * @generated
	 */
	String getLastSavedValue();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#getLastSavedValue <em>Last Saved Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Saved Value</em>' attribute.
	 * @see #getLastSavedValue()
	 * @generated
	 */
	void setLastSavedValue(String value);

	/**
	 * Returns the value of the '<em><b>Min Length</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Length</em>' attribute.
	 * @see #setMinLength(BigInteger)
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getSimpleSetting_MinLength()
	 * @model default="-1"
	 * @generated
	 */
	BigInteger getMinLength();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#getMinLength <em>Min Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Length</em>' attribute.
	 * @see #getMinLength()
	 * @generated
	 */
	void setMinLength(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Max Length</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Length</em>' attribute.
	 * @see #setMaxLength(BigInteger)
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getSimpleSetting_MaxLength()
	 * @model default="-1"
	 * @generated
	 */
	BigInteger getMaxLength();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#getMaxLength <em>Max Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Length</em>' attribute.
	 * @see #getMaxLength()
	 * @generated
	 */
	void setMaxLength(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Length</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Length</em>' attribute.
	 * @see #setLength(BigInteger)
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getSimpleSetting_Length()
	 * @model default="-1"
	 * @generated
	 */
	BigInteger getLength();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#getLength <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Length</em>' attribute.
	 * @see #getLength()
	 * @generated
	 */
	void setLength(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Max Inclusive</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Inclusive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Inclusive</em>' reference.
	 * @see #setMaxInclusive(MaxInclusive)
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getSimpleSetting_MaxInclusive()
	 * @model
	 * @generated
	 */
	MaxInclusive getMaxInclusive();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#getMaxInclusive <em>Max Inclusive</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Inclusive</em>' reference.
	 * @see #getMaxInclusive()
	 * @generated
	 */
	void setMaxInclusive(MaxInclusive value);

	/**
	 * Returns the value of the '<em><b>Max Exclusive</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Exclusive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Exclusive</em>' reference.
	 * @see #setMaxExclusive(MaxExclusive)
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getSimpleSetting_MaxExclusive()
	 * @model
	 * @generated
	 */
	MaxExclusive getMaxExclusive();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#getMaxExclusive <em>Max Exclusive</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Exclusive</em>' reference.
	 * @see #getMaxExclusive()
	 * @generated
	 */
	void setMaxExclusive(MaxExclusive value);

	/**
	 * Returns the value of the '<em><b>Min Inclusive</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Inclusive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Inclusive</em>' reference.
	 * @see #setMinInclusive(MinInclusive)
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getSimpleSetting_MinInclusive()
	 * @model
	 * @generated
	 */
	MinInclusive getMinInclusive();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#getMinInclusive <em>Min Inclusive</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Inclusive</em>' reference.
	 * @see #getMinInclusive()
	 * @generated
	 */
	void setMinInclusive(MinInclusive value);

	/**
	 * Returns the value of the '<em><b>Contained In Last Layer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contained In Last Layer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contained In Last Layer</em>' attribute.
	 * @see #setContainedInLastLayer(boolean)
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getSimpleSetting_ContainedInLastLayer()
	 * @model
	 * @generated
	 */
	boolean isContainedInLastLayer();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#isContainedInLastLayer <em>Contained In Last Layer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contained In Last Layer</em>' attribute.
	 * @see #isContainedInLastLayer()
	 * @generated
	 */
	void setContainedInLastLayer(boolean value);

	/**
	 * Returns the value of the '<em><b>Last Saved In Last Layer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Saved In Last Layer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Saved In Last Layer</em>' attribute.
	 * @see #setLastSavedInLastLayer(boolean)
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getSimpleSetting_LastSavedInLastLayer()
	 * @model
	 * @generated
	 */
	boolean isLastSavedInLastLayer();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#isLastSavedInLastLayer <em>Last Saved In Last Layer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Saved In Last Layer</em>' attribute.
	 * @see #isLastSavedInLastLayer()
	 * @generated
	 */
	void setLastSavedInLastLayer(boolean value);

	/**
	 * Returns the value of the '<em><b>Chosen Option</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Chosen Option</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chosen Option</em>' attribute.
	 * @see #setChosenOption(String)
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getSimpleSetting_ChosenOption()
	 * @model
	 * @generated
	 */
	String getChosenOption();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#getChosenOption <em>Chosen Option</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Chosen Option</em>' attribute.
	 * @see #getChosenOption()
	 * @generated
	 */
	void setChosenOption(String value);

	/**
	 * Returns the value of the '<em><b>Min Exclusive</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Exclusive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Exclusive</em>' reference.
	 * @see #setMinExclusive(MinExclusive)
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getSimpleSetting_MinExclusive()
	 * @model
	 * @generated
	 */
	MinExclusive getMinExclusive();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#getMinExclusive <em>Min Exclusive</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Exclusive</em>' reference.
	 * @see #getMinExclusive()
	 * @generated
	 */
	void setMinExclusive(MinExclusive value);

	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' attribute list.
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getSimpleSetting_Pattern()
	 * @model default=""
	 * @generated
	 */
	EList<String> getPattern();

	/**
	 * Returns the value of the '<em><b>Total Digits</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Digits</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Digits</em>' attribute.
	 * @see #setTotalDigits(BigInteger)
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getSimpleSetting_TotalDigits()
	 * @model default="-1"
	 * @generated
	 */
	BigInteger getTotalDigits();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.SimpleSetting#getTotalDigits <em>Total Digits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Digits</em>' attribute.
	 * @see #getTotalDigits()
	 * @generated
	 */
	void setTotalDigits(BigInteger value);

} // SimpleSetting
