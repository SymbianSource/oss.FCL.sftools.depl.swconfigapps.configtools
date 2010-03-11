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

import org.eclipse.emf.ecore.EObject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Leaf Setting Delegator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link configurationemf.LeafSettingDelegator#getLeafSetting <em>Leaf Setting</em>}</li>
 *   <li>{@link configurationemf.LeafSettingDelegator#getValue <em>Value</em>}</li>
 *   <li>{@link configurationemf.LeafSettingDelegator#getRef <em>Ref</em>}</li>
 *   <li>{@link configurationemf.LeafSettingDelegator#getType <em>Type</em>}</li>
 *   <li>{@link configurationemf.LeafSettingDelegator#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see configurationemf.ConfigurationemfPackage#getLeafSettingDelegator()
 * @model
 * @generated
 */
public interface LeafSettingDelegator extends EObject {
	/**
	 * Returns the value of the '<em><b>Leaf Setting</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Leaf Setting</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Leaf Setting</em>' reference.
	 * @see #setLeafSetting(LeafSetting)
	 * @see configurationemf.ConfigurationemfPackage#getLeafSettingDelegator_LeafSetting()
	 * @model
	 * @generated
	 */
	LeafSetting getLeafSetting();

	/**
	 * Sets the value of the '{@link configurationemf.LeafSettingDelegator#getLeafSetting <em>Leaf Setting</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Leaf Setting</em>' reference.
	 * @see #getLeafSetting()
	 * @generated
	 */
	void setLeafSetting(LeafSetting value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see configurationemf.ConfigurationemfPackage#getLeafSettingDelegator_Value()
	 * @model volatile="true"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link configurationemf.LeafSettingDelegator#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref</em>' reference.
	 * @see #setRef(Ref)
	 * @see configurationemf.ConfigurationemfPackage#getLeafSettingDelegator_Ref()
	 * @model resolveProxies="false"
	 * @generated
	 */
	Ref getRef();

	/**
	 * Sets the value of the '{@link configurationemf.LeafSettingDelegator#getRef <em>Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref</em>' reference.
	 * @see #getRef()
	 * @generated
	 */
	void setRef(Ref value);

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
	 * @see configurationemf.ConfigurationemfPackage#getLeafSettingDelegator_Type()
	 * @model changeable="false" volatile="true"
	 * @generated
	 */
	TYPE getType();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see configurationemf.ConfigurationemfPackage#getLeafSettingDelegator_Name()
	 * @model changeable="false" volatile="true"
	 * @generated
	 */
	String getName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean canModifyValue();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean canModifyAttribute();

} // LeafSettingDelegator
