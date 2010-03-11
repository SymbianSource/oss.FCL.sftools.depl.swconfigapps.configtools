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
 * Description: This file is part of com.nokia.tools.vct.common.appmodel component.
 */

package com.nokia.tools.vct.common.appmodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EApp Setting Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppSettingType#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppSettingType#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppSettingType#getRelevant <em>Relevant</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppSettingType#isRequired <em>Required</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppSettingType#isDeprecated <em>Deprecated</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppSettingType()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface EAppSettingType extends EAppDescriptionContainer, EAppIconContainer, EAppNamedItem, EAppPropertyContainer, EAppTypeConstraints {
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
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppSettingType_ReadOnly()
	 * @model required="true"
	 * @generated
	 */
	boolean isReadOnly();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.common.appmodel.EAppSettingType#isReadOnly <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Read Only</em>' attribute.
	 * @see #isReadOnly()
	 * @generated
	 */
	void setReadOnly(boolean value);

	/**
	 * Returns the value of the '<em><b>Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint</em>' containment reference.
	 * @see #setConstraint(EAppExpression)
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppSettingType_Constraint()
	 * @model containment="true"
	 * @generated
	 */
	EAppExpression getConstraint();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.common.appmodel.EAppSettingType#getConstraint <em>Constraint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint</em>' containment reference.
	 * @see #getConstraint()
	 * @generated
	 */
	void setConstraint(EAppExpression value);

	/**
	 * Returns the value of the '<em><b>Relevant</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relevant</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relevant</em>' containment reference.
	 * @see #setRelevant(EAppExpression)
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppSettingType_Relevant()
	 * @model containment="true"
	 * @generated
	 */
	EAppExpression getRelevant();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.common.appmodel.EAppSettingType#getRelevant <em>Relevant</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relevant</em>' containment reference.
	 * @see #getRelevant()
	 * @generated
	 */
	void setRelevant(EAppExpression value);

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
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppSettingType_Required()
	 * @model required="true"
	 * @generated
	 */
	boolean isRequired();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.common.appmodel.EAppSettingType#isRequired <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required</em>' attribute.
	 * @see #isRequired()
	 * @generated
	 */
	void setRequired(boolean value);

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
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppSettingType_Deprecated()
	 * @model required="true"
	 * @generated
	 */
	boolean isDeprecated();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.common.appmodel.EAppSettingType#isDeprecated <em>Deprecated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deprecated</em>' attribute.
	 * @see #isDeprecated()
	 * @generated
	 */
	void setDeprecated(boolean value);

} // EAppSettingType
