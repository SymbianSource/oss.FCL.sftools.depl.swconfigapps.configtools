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
 * A representation of the model object '<em><b>Root Conf</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link configurationemf.RootConf#getSubConf <em>Sub Conf</em>}</li>
 *   <li>{@link configurationemf.RootConf#getInclude <em>Include</em>}</li>
 *   <li>{@link configurationemf.RootConf#getRoot <em>Root</em>}</li>
 *   <li>{@link configurationemf.RootConf#getRfs <em>Rfs</em>}</li>
 * </ul>
 * </p>
 *
 * @see configurationemf.ConfigurationemfPackage#getRootConf()
 * @model
 * @generated
 */
public interface RootConf extends Configuration {
	/**
	 * Returns the value of the '<em><b>Sub Conf</b></em>' containment reference list.
	 * The list contents are of type {@link configurationemf.SubConf}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Conf</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Conf</em>' containment reference list.
	 * @see configurationemf.ConfigurationemfPackage#getRootConf_SubConf()
	 * @model containment="true"
	 * @generated
	 */
	EList<SubConf> getSubConf();

	/**
	 * Returns the value of the '<em><b>Include</b></em>' reference list.
	 * The list contents are of type {@link configurationemf.RootConf}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Include</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Include</em>' reference list.
	 * @see configurationemf.ConfigurationemfPackage#getRootConf_Include()
	 * @model
	 * @generated
	 */
	EList<RootConf> getInclude();

	/**
	 * Returns the value of the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' reference.
	 * @see #setRoot(RootConf)
	 * @see configurationemf.ConfigurationemfPackage#getRootConf_Root()
	 * @model resolveProxies="false" transient="true"
	 * @generated
	 */
	RootConf getRoot();

	/**
	 * Sets the value of the '{@link configurationemf.RootConf#getRoot <em>Root</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root</em>' reference.
	 * @see #getRoot()
	 * @generated
	 */
	void setRoot(RootConf value);

	/**
	 * Returns the value of the '<em><b>Rfs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rfs</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rfs</em>' containment reference.
	 * @see #setRfs(Rfs)
	 * @see configurationemf.ConfigurationemfPackage#getRootConf_Rfs()
	 * @model containment="true"
	 * @generated
	 */
	Rfs getRfs();

	/**
	 * Sets the value of the '{@link configurationemf.RootConf#getRfs <em>Rfs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rfs</em>' containment reference.
	 * @see #getRfs()
	 * @generated
	 */
	void setRfs(Rfs value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Feature getFeatureByRef(String refFeature);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	int getLevel();

} // RootConf