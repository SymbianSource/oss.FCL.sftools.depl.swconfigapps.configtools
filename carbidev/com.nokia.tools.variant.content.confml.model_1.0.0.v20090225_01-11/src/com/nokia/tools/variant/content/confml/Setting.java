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

package com.nokia.tools.variant.content.confml;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Setting</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.content.confml.Setting#getAbsRef <em>Abs Ref</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.Setting#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.Setting#getProperty <em>Property</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.Setting#getDescription <em>Description</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.Setting#getLeafGroup <em>Leaf Group</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.Setting#getType <em>Type</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.Setting#isRfsValue <em>Rfs Value</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.Setting#getFeatureName <em>Feature Name</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.Setting#getNote <em>Note</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.Setting#getRelevant <em>Relevant</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.Setting#isRequired <em>Required</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.Setting#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.Setting#isComputedRelevant <em>Computed Relevant</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.Setting#isComputedConstraint <em>Computed Constraint</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.Setting#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.Setting#isValueNull <em>Value Null</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.Setting#getNameOverride <em>Name Override</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.Setting#getDescriptionOverride <em>Description Override</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.Setting#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.Setting#getOption <em>Option</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.Setting#getParentGroup <em>Parent Group</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.Setting#getOptionDependencies <em>Option Dependencies</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.variant.content.confml.ConfmlPackage#getSetting()
 * @model
 * @generated
 */
public interface Setting extends EObject {
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
	 * @see com.nokia.tools.variant.content.confml.ConfmlPackage#getSetting_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.content.confml.Setting#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isDefault();

	/**
	 * Returns the value of the '<em><b>Abs Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abs Ref</em>' attribute.
	 * @see #setAbsRef(String)
	 * @see com.nokia.tools.variant.content.confml.ConfmlPackage#getSetting_AbsRef()
	 * @model
	 * @generated
	 */
	String getAbsRef();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.content.confml.Setting#getAbsRef <em>Abs Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abs Ref</em>' attribute.
	 * @see #getAbsRef()
	 * @generated
	 */
	void setAbsRef(String value);

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
	String getFeatureRef();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getSettingRef();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isVisible();

	/**
	 * Returns the value of the '<em><b>Property</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.variant.content.confml.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property</em>' containment reference list.
	 * @see com.nokia.tools.variant.content.confml.ConfmlPackage#getSetting_Property()
	 * @model containment="true"
	 * @generated
	 */
	EList<Property> getProperty();

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
	 * @see com.nokia.tools.variant.content.confml.ConfmlPackage#getSetting_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.content.confml.Setting#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Leaf Group</b></em>' reference list.
	 * The list contents are of type {@link com.nokia.tools.variant.content.confml.LeafGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Leaf Group</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Leaf Group</em>' reference list.
	 * @see com.nokia.tools.variant.content.confml.ConfmlPackage#getSetting_LeafGroup()
	 * @model
	 * @generated
	 */
	EList<LeafGroup> getLeafGroup();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link com.nokia.tools.variant.content.confml.TYPE}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see com.nokia.tools.variant.content.confml.TYPE
	 * @see #setType(TYPE)
	 * @see com.nokia.tools.variant.content.confml.ConfmlPackage#getSetting_Type()
	 * @model
	 * @generated
	 */
	TYPE getType();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.content.confml.Setting#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see com.nokia.tools.variant.content.confml.TYPE
	 * @see #getType()
	 * @generated
	 */
	void setType(TYPE value);

	/**
	 * Returns the value of the '<em><b>Rfs Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rfs Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rfs Value</em>' attribute.
	 * @see #setRfsValue(boolean)
	 * @see com.nokia.tools.variant.content.confml.ConfmlPackage#getSetting_RfsValue()
	 * @model id="true"
	 * @generated
	 */
	boolean isRfsValue();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.content.confml.Setting#isRfsValue <em>Rfs Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rfs Value</em>' attribute.
	 * @see #isRfsValue()
	 * @generated
	 */
	void setRfsValue(boolean value);

	/**
	 * Returns the value of the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Name</em>' attribute.
	 * @see #setFeatureName(String)
	 * @see com.nokia.tools.variant.content.confml.ConfmlPackage#getSetting_FeatureName()
	 * @model
	 * @generated
	 */
	String getFeatureName();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.content.confml.Setting#getFeatureName <em>Feature Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Name</em>' attribute.
	 * @see #getFeatureName()
	 * @generated
	 */
	void setFeatureName(String value);

	/**
	 * Returns the value of the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Note</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Note</em>' attribute.
	 * @see #setNote(String)
	 * @see com.nokia.tools.variant.content.confml.ConfmlPackage#getSetting_Note()
	 * @model
	 * @generated
	 */
	String getNote();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.content.confml.Setting#getNote <em>Note</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Note</em>' attribute.
	 * @see #getNote()
	 * @generated
	 */
	void setNote(String value);

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
	 * @see com.nokia.tools.variant.content.confml.ConfmlPackage#getSetting_Relevant()
	 * @model
	 * @generated
	 */
	String getRelevant();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.content.confml.Setting#getRelevant <em>Relevant</em>}' attribute.
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
	 * @see #setRequired(boolean)
	 * @see com.nokia.tools.variant.content.confml.ConfmlPackage#getSetting_Required()
	 * @model
	 * @generated
	 */
	boolean isRequired();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.content.confml.Setting#isRequired <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required</em>' attribute.
	 * @see #isRequired()
	 * @generated
	 */
	void setRequired(boolean value);

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
	 * @see com.nokia.tools.variant.content.confml.ConfmlPackage#getSetting_Constraint()
	 * @model
	 * @generated
	 */
	String getConstraint();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.content.confml.Setting#getConstraint <em>Constraint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint</em>' attribute.
	 * @see #getConstraint()
	 * @generated
	 */
	void setConstraint(String value);

	/**
	 * Returns the value of the '<em><b>Computed Relevant</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Computed Relevant</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Computed Relevant</em>' attribute.
	 * @see #setComputedRelevant(boolean)
	 * @see com.nokia.tools.variant.content.confml.ConfmlPackage#getSetting_ComputedRelevant()
	 * @model default="true"
	 * @generated
	 */
	boolean isComputedRelevant();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.content.confml.Setting#isComputedRelevant <em>Computed Relevant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Computed Relevant</em>' attribute.
	 * @see #isComputedRelevant()
	 * @generated
	 */
	void setComputedRelevant(boolean value);

	/**
	 * Returns the value of the '<em><b>Computed Constraint</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Computed Constraint</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Computed Constraint</em>' attribute.
	 * @see #setComputedConstraint(boolean)
	 * @see com.nokia.tools.variant.content.confml.ConfmlPackage#getSetting_ComputedConstraint()
	 * @model default="true"
	 * @generated
	 */
	boolean isComputedConstraint();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.content.confml.Setting#isComputedConstraint <em>Computed Constraint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Computed Constraint</em>' attribute.
	 * @see #isComputedConstraint()
	 * @generated
	 */
	void setComputedConstraint(boolean value);

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
	 * @see com.nokia.tools.variant.content.confml.ConfmlPackage#getSetting_ReadOnly()
	 * @model
	 * @generated
	 */
	boolean isReadOnly();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.content.confml.Setting#isReadOnly <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Read Only</em>' attribute.
	 * @see #isReadOnly()
	 * @generated
	 */
	void setReadOnly(boolean value);

	/**
	 * Returns the value of the '<em><b>Value Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Null</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Null</em>' attribute.
	 * @see #setValueNull(boolean)
	 * @see com.nokia.tools.variant.content.confml.ConfmlPackage#getSetting_ValueNull()
	 * @model
	 * @generated
	 */
	boolean isValueNull();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.content.confml.Setting#isValueNull <em>Value Null</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Null</em>' attribute.
	 * @see #isValueNull()
	 * @generated
	 */
	void setValueNull(boolean value);

	/**
	 * Returns the value of the '<em><b>Name Override</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name Override</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name Override</em>' attribute.
	 * @see #setNameOverride(String)
	 * @see com.nokia.tools.variant.content.confml.ConfmlPackage#getSetting_NameOverride()
	 * @model
	 * @generated
	 */
	String getNameOverride();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.content.confml.Setting#getNameOverride <em>Name Override</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name Override</em>' attribute.
	 * @see #getNameOverride()
	 * @generated
	 */
	void setNameOverride(String value);

	/**
	 * Returns the value of the '<em><b>Description Override</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description Override</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description Override</em>' attribute.
	 * @see #setDescriptionOverride(String)
	 * @see com.nokia.tools.variant.content.confml.ConfmlPackage#getSetting_DescriptionOverride()
	 * @model
	 * @generated
	 */
	String getDescriptionOverride();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.content.confml.Setting#getDescriptionOverride <em>Description Override</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description Override</em>' attribute.
	 * @see #getDescriptionOverride()
	 * @generated
	 */
	void setDescriptionOverride(String value);

	/**
	 * Returns the value of the '<em><b>Dependencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependencies</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependencies</em>' attribute.
	 * @see #setDependencies(EList)
	 * @see com.nokia.tools.variant.content.confml.ConfmlPackage#getSetting_Dependencies()
	 * @model many="false" transient="true"
	 * @generated
	 */
	EList<Object> getDependencies();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.content.confml.Setting#getDependencies <em>Dependencies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependencies</em>' attribute.
	 * @see #getDependencies()
	 * @generated
	 */
	void setDependencies(EList<Object> value);

	/**
	 * Returns the value of the '<em><b>Option</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.variant.content.confml.Option}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Option</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Option</em>' containment reference list.
	 * @see com.nokia.tools.variant.content.confml.ConfmlPackage#getSetting_Option()
	 * @model containment="true"
	 * @generated
	 */
	EList<Option> getOption();

	/**
	 * Returns the value of the '<em><b>Parent Group</b></em>' reference list.
	 * The list contents are of type {@link com.nokia.tools.variant.content.confml.ParentGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Group</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Group</em>' reference list.
	 * @see com.nokia.tools.variant.content.confml.ConfmlPackage#getSetting_ParentGroup()
	 * @model
	 * @generated
	 */
	EList<ParentGroup> getParentGroup();

	/**
	 * Returns the value of the '<em><b>Option Dependencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Option Dependencies</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Option Dependencies</em>' attribute.
	 * @see #setOptionDependencies(EList)
	 * @see com.nokia.tools.variant.content.confml.ConfmlPackage#getSetting_OptionDependencies()
	 * @model many="false" transient="true"
	 * @generated
	 */
	EList<Setting> getOptionDependencies();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.content.confml.Setting#getOptionDependencies <em>Option Dependencies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Option Dependencies</em>' attribute.
	 * @see #getOptionDependencies()
	 * @generated
	 */
	void setOptionDependencies(EList<Setting> value);

} // Setting
