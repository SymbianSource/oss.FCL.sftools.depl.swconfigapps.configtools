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
 * A representation of the model object '<em><b>View</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link configurationemf.View#getName <em>Name</em>}</li>
 *   <li>{@link configurationemf.View#getConf <em>Conf</em>}</li>
 *   <li>{@link configurationemf.View#getMeta <em>Meta</em>}</li>
 *   <li>{@link configurationemf.View#getParentGroup <em>Parent Group</em>}</li>
 *   <li>{@link configurationemf.View#getLink <em>Link</em>}</li>
 *   <li>{@link configurationemf.View#getIcon <em>Icon</em>}</li>
 *   <li>{@link configurationemf.View#isReadOnly <em>Read Only</em>}</li>
 * </ul>
 * </p>
 *
 * @see configurationemf.ConfigurationemfPackage#getView()
 * @model
 * @generated
 */
public interface View extends AttributeAndDesc {
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
	 * @see configurationemf.ConfigurationemfPackage#getView_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link configurationemf.View#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Conf</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link configurationemf.Configuration#getView <em>View</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conf</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conf</em>' container reference.
	 * @see #setConf(Configuration)
	 * @see configurationemf.ConfigurationemfPackage#getView_Conf()
	 * @see configurationemf.Configuration#getView
	 * @model opposite="View" required="true"
	 * @generated
	 */
	Configuration getConf();

	/**
	 * Sets the value of the '{@link configurationemf.View#getConf <em>Conf</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conf</em>' container reference.
	 * @see #getConf()
	 * @generated
	 */
	void setConf(Configuration value);

	/**
	 * Returns the value of the '<em><b>Meta</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta</em>' containment reference.
	 * @see #setMeta(Meta)
	 * @see configurationemf.ConfigurationemfPackage#getView_Meta()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Meta getMeta();

	/**
	 * Sets the value of the '{@link configurationemf.View#getMeta <em>Meta</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta</em>' containment reference.
	 * @see #getMeta()
	 * @generated
	 */
	void setMeta(Meta value);

	/**
	 * Returns the value of the '<em><b>Parent Group</b></em>' containment reference list.
	 * The list contents are of type {@link configurationemf.ParentGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Group</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Group</em>' containment reference list.
	 * @see configurationemf.ConfigurationemfPackage#getView_ParentGroup()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ParentGroup> getParentGroup();

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
	 * @see configurationemf.ConfigurationemfPackage#getView_Link()
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
	 * @see configurationemf.ConfigurationemfPackage#getView_Icon()
	 * @model containment="true"
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
	 * @see configurationemf.ConfigurationemfPackage#getView_ReadOnly()
	 * @model transient="true" changeable="false" volatile="true"
	 * @generated
	 */
	boolean isReadOnly();

} // View