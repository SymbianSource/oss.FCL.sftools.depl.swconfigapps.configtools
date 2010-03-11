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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Frame</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link configurationemf.Frame#getLeafSettings <em>Leaf Settings</em>}</li>
 *   <li>{@link configurationemf.Frame#getNumber <em>Number</em>}</li>
 *   <li>{@link configurationemf.Frame#isTemplate <em>Template</em>}</li>
 *   <li>{@link configurationemf.Frame#getTemplateOwner <em>Template Owner</em>}</li>
 *   <li>{@link configurationemf.Frame#getRef <em>Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see configurationemf.ConfigurationemfPackage#getFrame()
 * @model
 * @generated
 */
public interface Frame extends EObject {
	/**
	 * Returns the value of the '<em><b>Leaf Settings</b></em>' containment reference list.
	 * The list contents are of type {@link configurationemf.LeafSettingDelegator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Leaf Settings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Leaf Settings</em>' containment reference list.
	 * @see configurationemf.ConfigurationemfPackage#getFrame_LeafSettings()
	 * @model containment="true"
	 * @generated
	 */
	EList<LeafSettingDelegator> getLeafSettings();

	/**
	 * Returns the value of the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number</em>' attribute.
	 * @see configurationemf.ConfigurationemfPackage#getFrame_Number()
	 * @model changeable="false"
	 * @generated
	 */
	int getNumber();

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
	 * @see configurationemf.ConfigurationemfPackage#getFrame_Template()
	 * @model
	 * @generated
	 */
	boolean isTemplate();

	/**
	 * Sets the value of the '{@link configurationemf.Frame#isTemplate <em>Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template</em>' attribute.
	 * @see #isTemplate()
	 * @generated
	 */
	void setTemplate(boolean value);

	/**
	 * Returns the value of the '<em><b>Template Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template Owner</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template Owner</em>' reference.
	 * @see #setTemplateOwner(ParentSetting)
	 * @see configurationemf.ConfigurationemfPackage#getFrame_TemplateOwner()
	 * @model resolveProxies="false"
	 * @generated
	 */
	ParentSetting getTemplateOwner();

	/**
	 * Sets the value of the '{@link configurationemf.Frame#getTemplateOwner <em>Template Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template Owner</em>' reference.
	 * @see #getTemplateOwner()
	 * @generated
	 */
	void setTemplateOwner(ParentSetting value);

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
	 * @see configurationemf.ConfigurationemfPackage#getFrame_Ref()
	 * @model resolveProxies="false"
	 * @generated
	 */
	Ref getRef();

	/**
	 * Sets the value of the '{@link configurationemf.Frame#getRef <em>Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref</em>' reference.
	 * @see #getRef()
	 * @generated
	 */
	void setRef(Ref value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getConfName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isMyFrame();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addLeafSetting(LeafSetting leafSetting);

	void deleteLeafSetting(LeafSetting leafSetting);
	
} // Frame
