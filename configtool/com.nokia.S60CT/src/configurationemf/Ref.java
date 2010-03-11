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
 * A representation of the model object '<em><b>Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link configurationemf.Ref#getName <em>Name</em>}</li>
 *   <li>{@link configurationemf.Ref#getRef <em>Ref</em>}</li>
 *   <li>{@link configurationemf.Ref#getReferable <em>Referable</em>}</li>
 *   <li>{@link configurationemf.Ref#isTemplate <em>Template</em>}</li>
 *   <li>{@link configurationemf.Ref#getExtensionPolicy <em>Extension Policy</em>}</li>
 *   <li>{@link configurationemf.Ref#isEmpty <em>Empty</em>}</li>
 * </ul>
 * </p>
 *
 * @see configurationemf.ConfigurationemfPackage#getRef()
 * @model
 * @generated
 */
public interface Ref extends Content {
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
	 * @see configurationemf.ConfigurationemfPackage#getRef_Name()
	 * @model transient="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link configurationemf.Ref#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Ref</b></em>' containment reference list.
	 * The list contents are of type {@link configurationemf.Ref}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref</em>' containment reference list.
	 * @see configurationemf.ConfigurationemfPackage#getRef_Ref()
	 * @model containment="true"
	 * @generated
	 */
	EList<Ref> getRef();

	/**
	 * Returns the value of the '<em><b>Referable</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link configurationemf.Referable#getRefs <em>Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referable</em>' reference.
	 * @see #setReferable(Referable)
	 * @see configurationemf.ConfigurationemfPackage#getRef_Referable()
	 * @see configurationemf.Referable#getRefs
	 * @model opposite="refs" transient="true"
	 * @generated
	 */
	Referable getReferable();

	/**
	 * Sets the value of the '{@link configurationemf.Ref#getReferable <em>Referable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referable</em>' reference.
	 * @see #getReferable()
	 * @generated
	 */
	void setReferable(Referable value);

	/**
	 * Returns the value of the '<em><b>Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template</em>' attribute.
	 * @see #setTemplate(boolean)
	 * @see configurationemf.ConfigurationemfPackage#getRef_Template()
	 * @model
	 * @generated
	 */
	boolean isTemplate();

	/**
	 * Sets the value of the '{@link configurationemf.Ref#isTemplate <em>Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template</em>' attribute.
	 * @see #isTemplate()
	 * @generated
	 */
	void setTemplate(boolean value);

	/**
	 * Returns the value of the '<em><b>Extension Policy</b></em>' attribute.
	 * The literals are from the enumeration {@link configurationemf.EXTENSION_POLICY}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension Policy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension Policy</em>' attribute.
	 * @see configurationemf.EXTENSION_POLICY
	 * @see #setExtensionPolicy(EXTENSION_POLICY)
	 * @see configurationemf.ConfigurationemfPackage#getRef_ExtensionPolicy()
	 * @model
	 * @generated
	 */
	EXTENSION_POLICY getExtensionPolicy();

	/**
	 * Sets the value of the '{@link configurationemf.Ref#getExtensionPolicy <em>Extension Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension Policy</em>' attribute.
	 * @see configurationemf.EXTENSION_POLICY
	 * @see #getExtensionPolicy()
	 * @generated
	 */
	void setExtensionPolicy(EXTENSION_POLICY value);

	/**
	 * Returns the value of the '<em><b>Empty</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Empty</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Empty</em>' attribute.
	 * @see #setEmpty(boolean)
	 * @see configurationemf.ConfigurationemfPackage#getRef_Empty()
	 * @model
	 * @generated
	 */
	boolean isEmpty();

	/**
	 * Sets the value of the '{@link configurationemf.Ref#isEmpty <em>Empty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Empty</em>' attribute.
	 * @see #isEmpty()
	 * @generated
	 */
	void setEmpty(boolean value);

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
	 * @model kind="operation"
	 * @generated
	 */
	Configuration getConfiguration();

	public Ref giveChildRef(String refString);

} // Ref