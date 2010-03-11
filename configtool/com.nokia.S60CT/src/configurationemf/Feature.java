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
 * A representation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link configurationemf.Feature#getName <em>Name</em>}</li>
 *   <li>{@link configurationemf.Feature#getRelevant <em>Relevant</em>}</li>
 *   <li>{@link configurationemf.Feature#getConf <em>Conf</em>}</li>
 *   <li>{@link configurationemf.Feature#getParentSetting <em>Parent Setting</em>}</li>
 *   <li>{@link configurationemf.Feature#getLink <em>Link</em>}</li>
 *   <li>{@link configurationemf.Feature#getIcon <em>Icon</em>}</li>
 *   <li>{@link configurationemf.Feature#isReadOnly <em>Read Only</em>}</li>
 * </ul>
 * </p>
 *
 * @see configurationemf.ConfigurationemfPackage#getFeature()
 * @model
 * @generated
 */
public interface Feature extends Referable {
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
	 * @see configurationemf.ConfigurationemfPackage#getFeature_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link configurationemf.Feature#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @see configurationemf.ConfigurationemfPackage#getFeature_Relevant()
	 * @model
	 * @generated
	 */
	String getRelevant();

	/**
	 * Sets the value of the '{@link configurationemf.Feature#getRelevant <em>Relevant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relevant</em>' attribute.
	 * @see #getRelevant()
	 * @generated
	 */
	void setRelevant(String value);

	/**
	 * Returns the value of the '<em><b>Conf</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link configurationemf.Configuration#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conf</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conf</em>' container reference.
	 * @see #setConf(Configuration)
	 * @see configurationemf.ConfigurationemfPackage#getFeature_Conf()
	 * @see configurationemf.Configuration#getFeature
	 * @model opposite="Feature" required="true"
	 * @generated
	 */
	Configuration getConf();

	/**
	 * Sets the value of the '{@link configurationemf.Feature#getConf <em>Conf</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conf</em>' container reference.
	 * @see #getConf()
	 * @generated
	 */
	void setConf(Configuration value);

	/**
	 * Returns the value of the '<em><b>Parent Setting</b></em>' containment reference list.
	 * The list contents are of type {@link configurationemf.ParentSetting}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Setting</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Setting</em>' containment reference list.
	 * @see configurationemf.ConfigurationemfPackage#getFeature_ParentSetting()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ParentSetting> getParentSetting();

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
	 * @see configurationemf.ConfigurationemfPackage#getFeature_Link()
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
	 * @see configurationemf.ConfigurationemfPackage#getFeature_Icon()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Icon> getIcon();

	/**
	 * Returns the value of the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Read Only</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Read Only</em>' attribute.
	 * @see configurationemf.ConfigurationemfPackage#getFeature_ReadOnly()
	 * @model transient="true" changeable="false" volatile="true"
	 * @generated
	 */
	boolean isReadOnly();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ParentSetting getSettingByRef(String refSetting);

	

} // Feature