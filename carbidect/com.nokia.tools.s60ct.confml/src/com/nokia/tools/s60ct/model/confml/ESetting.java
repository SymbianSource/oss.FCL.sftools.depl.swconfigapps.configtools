/*
* Copyright (c) 2007 Nokia Corporation and/or its subsidiary(-ies). 
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
package com.nokia.tools.s60ct.model.confml;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ESetting</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESetting#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESetting#getRef <em>Ref</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESetting#getRfs <em>Rfs</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESetting#getValue <em>Value</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESetting#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESetting#getDefaultRfs <em>Default Rfs</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESetting#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESetting#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESetting#getRelevant <em>Relevant</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESetting#isRequired <em>Required</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESetting#getProperties <em>Properties</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESetting#isDeprecated <em>Deprecated</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESetting#isModified <em>Modified</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESetting#isSetdefault <em>Setdefault</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESetting#isComputedRelevant <em>Computed Relevant</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESetting#isComputedConstraint <em>Computed Constraint</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESetting#getRelevantAST <em>Relevant AST</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESetting#getConstraintAST <em>Constraint AST</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESetting#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESetting#getOptionDependencies <em>Option Dependencies</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESetting#isValueNull <em>Value Null</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.ESetting#getNotes <em>Notes</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESetting()
 * @model abstract="true"
 * @generated
 */
public interface ESetting extends EDescriptionContainer, EIconContainer, ELinkContainer {
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
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESetting_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESetting#getName <em>Name</em>}' attribute.
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
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESetting_Ref()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getRef();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESetting#getRef <em>Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref</em>' attribute.
	 * @see #getRef()
	 * @generated
	 */
	void setRef(String value);

	/**
	 * Returns the absolute ref.
	 * @generated NOT
	 */
	public String getAbsRef();
	
	
	/**
	 * Returns the absolute ref.
	 * @generated NOT
	 */
	public String getFeatureRef();
	
	/**
	 * Returns the value of the '<em><b>Rfs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rfs</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rfs</em>' attribute.
	 * @see #setRfs(Boolean)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESetting_Rfs()
	 * @model
	 * @generated
	 */
	Boolean getRfs();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESetting#getRfs <em>Rfs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rfs</em>' attribute.
	 * @see #getRfs()
	 * @generated
	 */
	void setRfs(Boolean value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(ESettingValue)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESetting_Value()
	 * @model containment="true"
	 * @generated
	 */
	ESettingValue getValue();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESetting#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(ESettingValue value);

	/**
	 * Returns the value of the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Value</em>' containment reference.
	 * @see #setDefaultValue(ESettingValue)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESetting_DefaultValue()
	 * @model containment="true"
	 * @generated
	 */
	ESettingValue getDefaultValue();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESetting#getDefaultValue <em>Default Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Value</em>' containment reference.
	 * @see #getDefaultValue()
	 * @generated
	 */
	void setDefaultValue(ESettingValue value);

	/**
	 * Returns the value of the '<em><b>Default Rfs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Rfs</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Rfs</em>' attribute.
	 * @see #setDefaultRfs(Boolean)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESetting_DefaultRfs()
	 * @model required="true"
	 * @generated
	 */
	Boolean getDefaultRfs();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESetting#getDefaultRfs <em>Default Rfs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Rfs</em>' attribute.
	 * @see #getDefaultRfs()
	 * @generated
	 */
	void setDefaultRfs(Boolean value);

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
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESetting_ReadOnly()
	 * @model
	 * @generated
	 */
	boolean isReadOnly();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESetting#isReadOnly <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Read Only</em>' attribute.
	 * @see #isReadOnly()
	 * @generated
	 */
	void setReadOnly(boolean value);

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
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESetting_Constraint()
	 * @model
	 * @generated
	 */
	String getConstraint();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESetting#getConstraint <em>Constraint</em>}' attribute.
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
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESetting_Relevant()
	 * @model
	 * @generated
	 */
	String getRelevant();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESetting#getRelevant <em>Relevant</em>}' attribute.
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
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESetting_Required()
	 * @model
	 * @generated
	 */
	boolean isRequired();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESetting#isRequired <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required</em>' attribute.
	 * @see #isRequired()
	 * @generated
	 */
	void setRequired(boolean value);

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.s60ct.model.confml.EProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESetting_Properties()
	 * @model containment="true"
	 * @generated
	 */
	EList<EProperty> getProperties();

	/**
	 * Returns the value of the '<em><b>Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deprecated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deprecated</em>' attribute.
	 * @see #setDeprecated(boolean)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESetting_Deprecated()
	 * @model
	 * @generated
	 */
	boolean isDeprecated();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESetting#isDeprecated <em>Deprecated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deprecated</em>' attribute.
	 * @see #isDeprecated()
	 * @generated
	 */
	void setDeprecated(boolean value);

	/**
	 * Returns the value of the '<em><b>Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modified</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modified</em>' attribute.
	 * @see #setModified(boolean)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESetting_Modified()
	 * @model
	 * @generated
	 */
	boolean isModified();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESetting#isModified <em>Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Modified</em>' attribute.
	 * @see #isModified()
	 * @generated
	 */
	void setModified(boolean value);

	/**
	 * Returns the value of the '<em><b>Setdefault</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Setdefault</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Setdefault</em>' attribute.
	 * @see #setSetdefault(boolean)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESetting_Setdefault()
	 * @model
	 * @generated
	 */
	boolean isSetdefault();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESetting#isSetdefault <em>Setdefault</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Setdefault</em>' attribute.
	 * @see #isSetdefault()
	 * @generated
	 */
	void setSetdefault(boolean value);

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
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESetting_ComputedRelevant()
	 * @model default="true"
	 * @generated
	 */
	boolean isComputedRelevant();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESetting#isComputedRelevant <em>Computed Relevant</em>}' attribute.
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
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESetting_ComputedConstraint()
	 * @model default="true"
	 * @generated
	 */
	boolean isComputedConstraint();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESetting#isComputedConstraint <em>Computed Constraint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Computed Constraint</em>' attribute.
	 * @see #isComputedConstraint()
	 * @generated
	 */
	void setComputedConstraint(boolean value);

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
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESetting_RelevantAST()
	 * @model
	 * @generated
	 */
	Object getRelevantAST();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESetting#getRelevantAST <em>Relevant AST</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relevant AST</em>' attribute.
	 * @see #getRelevantAST()
	 * @generated
	 */
	void setRelevantAST(Object value);

	/**
	 * Returns the value of the '<em><b>Constraint AST</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint AST</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint AST</em>' attribute.
	 * @see #setConstraintAST(Object)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESetting_ConstraintAST()
	 * @model
	 * @generated
	 */
	Object getConstraintAST();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESetting#getConstraintAST <em>Constraint AST</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint AST</em>' attribute.
	 * @see #getConstraintAST()
	 * @generated
	 */
	void setConstraintAST(Object value);

	/**
	 * Returns the value of the '<em><b>Dependencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependencies</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependencies</em>' attribute.
	 * @see #setDependencies(EList)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESetting_Dependencies()
	 * @model many="false" transient="true"
	 * @generated
	 */
	EList<EObject> getDependencies();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESetting#getDependencies <em>Dependencies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependencies</em>' attribute.
	 * @see #getDependencies()
	 * @generated
	 */
	void setDependencies(EList<EObject> value);

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
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESetting_OptionDependencies()
	 * @model many="false" transient="true"
	 * @generated
	 */
	EList<ESetting> getOptionDependencies();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESetting#getOptionDependencies <em>Option Dependencies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Option Dependencies</em>' attribute.
	 * @see #getOptionDependencies()
	 * @generated
	 */
	void setOptionDependencies(EList<ESetting> value);

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
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESetting_ValueNull()
	 * @model
	 * @generated
	 */
	boolean isValueNull();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESetting#isValueNull <em>Value Null</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Null</em>' attribute.
	 * @see #isValueNull()
	 * @generated
	 */
	void setValueNull(boolean value);

	/**
	 * Returns the value of the '<em><b>Notes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Notes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Notes</em>' attribute.
	 * @see #setNotes(String)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getESetting_Notes()
	 * @model
	 * @generated
	 */
	String getNotes();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.ESetting#getNotes <em>Notes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Notes</em>' attribute.
	 * @see #getNotes()
	 * @generated
	 */
	void setNotes(String value);

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
	 * @model
	 * @generated
	 */
	void clearDirty();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isDefault();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	View getView();

} // ESetting
