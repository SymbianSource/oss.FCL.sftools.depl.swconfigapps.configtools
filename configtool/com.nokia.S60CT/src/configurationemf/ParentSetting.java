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


import java.util.List;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parent Setting</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link configurationemf.ParentSetting#getLeafSetting <em>Leaf Setting</em>}</li>
 *   <li>{@link configurationemf.ParentSetting#getFrames <em>Frames</em>}</li>
 *   <li>{@link configurationemf.ParentSetting#getTemplate <em>Template</em>}</li>
 *   <li>{@link configurationemf.ParentSetting#getCurrentExtensionPolicy <em>Current Extension Policy</em>}</li>
 *   <li>{@link configurationemf.ParentSetting#getMinOccurs <em>Min Occurs</em>}</li>
 *   <li>{@link configurationemf.ParentSetting#getMaxOccurs <em>Max Occurs</em>}</li>
 * </ul>
 * </p>
 *
 * @see configurationemf.ConfigurationemfPackage#getParentSetting()
 * @model
 * @generated
 */
public interface ParentSetting extends Setting {
	
	public LeafSetting getLeafSettingByRef(String ref);
	
	/**
	 * Returns the value of the '<em><b>Leaf Setting</b></em>' containment reference list.
	 * The list contents are of type {@link configurationemf.LeafSetting}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Leaf Setting</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Leaf Setting</em>' containment reference list.
	 * @see configurationemf.ConfigurationemfPackage#getParentSetting_LeafSetting()
	 * @model containment="true"
	 * @generated
	 */
	EList<LeafSetting> getLeafSetting();

	/**
	 * Returns the value of the '<em><b>Frames</b></em>' containment reference list.
	 * The list contents are of type {@link configurationemf.Frame}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Frames</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Frames</em>' containment reference list.
	 * @see configurationemf.ConfigurationemfPackage#getParentSetting_Frames()
	 * @model containment="true" transient="true"
	 * @generated
	 */
	EList<Frame> getFrames();

	/**
	 * Returns the value of the '<em><b>Template</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template</em>' containment reference.
	 * @see configurationemf.ConfigurationemfPackage#getParentSetting_Template()
	 * @model containment="true" transient="true" changeable="false"
	 * @generated
	 */
	Frame getTemplate();

	/**
	 * Returns the value of the '<em><b>Current Extension Policy</b></em>' attribute.
	 * The literals are from the enumeration {@link configurationemf.EXTENSION_POLICY}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current Extension Policy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Extension Policy</em>' attribute.
	 * @see configurationemf.EXTENSION_POLICY
	 * @see #setCurrentExtensionPolicy(EXTENSION_POLICY)
	 * @see configurationemf.ConfigurationemfPackage#getParentSetting_CurrentExtensionPolicy()
	 * @model transient="true" volatile="true"
	 * @generated
	 */
	EXTENSION_POLICY getCurrentExtensionPolicy();

	/**
	 * Sets the value of the '{@link configurationemf.ParentSetting#getCurrentExtensionPolicy <em>Current Extension Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Extension Policy</em>' attribute.
	 * @see configurationemf.EXTENSION_POLICY
	 * @see #getCurrentExtensionPolicy()
	 * @generated
	 */
	void setCurrentExtensionPolicy(EXTENSION_POLICY value);

	/**
	 * Returns the value of the '<em><b>Min Occurs</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Occurs</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Occurs</em>' attribute.
	 * @see #setMinOccurs(int)
	 * @see configurationemf.ConfigurationemfPackage#getParentSetting_MinOccurs()
	 * @model default="-1"
	 * @generated
	 */
	int getMinOccurs();

	/**
	 * Sets the value of the '{@link configurationemf.ParentSetting#getMinOccurs <em>Min Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Occurs</em>' attribute.
	 * @see #getMinOccurs()
	 * @generated
	 */
	void setMinOccurs(int value);

	/**
	 * Returns the value of the '<em><b>Max Occurs</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Occurs</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Occurs</em>' attribute.
	 * @see #setMaxOccurs(int)
	 * @see configurationemf.ConfigurationemfPackage#getParentSetting_MaxOccurs()
	 * @model default="-1"
	 * @generated
	 */
	int getMaxOccurs();

	/**
	 * Sets the value of the '{@link configurationemf.ParentSetting#getMaxOccurs <em>Max Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Occurs</em>' attribute.
	 * @see #getMaxOccurs()
	 * @generated
	 */
	void setMaxOccurs(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addFrame();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated NOT
	 */
	void addFrame(Frame newFrame);
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean canAddFrame();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void removeFrame(Frame frame);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean canRemoveFrame(Frame frame);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean canSetExtPolicy(EXTENSION_POLICY policy);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated NOT
	 */
	List getMyCurrentFrames();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void makeEmptySequence();
	
	void makeNotEmptySequence();

} // ParentSetting