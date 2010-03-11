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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EConfiguration Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EConfigurationProject#getLayers <em>Layers</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EConfigurationProject#getLastLayer <em>Last Layer</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EConfigurationProject#getRootConfml <em>Root Confml</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EConfigurationProject#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EConfigurationProject#getStorage <em>Storage</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EConfigurationProject#getConfVersion <em>Conf Version</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EConfigurationProject#getDefaultView <em>Default View</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EConfigurationProject#isSettingHidden <em>Setting Hidden</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEConfigurationProject()
 * @model
 * @generated
 */
public interface EConfigurationProject extends EAppMetadata {
	/**
	 * Returns the value of the '<em><b>Layers</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.common.appmodel.EConfMLLayer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layers</em>' containment reference list.
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEConfigurationProject_Layers()
	 * @model containment="true"
	 * @generated
	 */
	EList<EConfMLLayer> getLayers();

	/**
	 * Returns the value of the '<em><b>Last Layer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Layer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Layer</em>' reference.
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEConfigurationProject_LastLayer()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EConfMLLayer getLastLayer();

	/**
	 * Returns the value of the '<em><b>Root Confml</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Confml</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root Confml</em>' attribute.
	 * @see #setRootConfml(URI)
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEConfigurationProject_RootConfml()
	 * @model dataType="com.nokia.tools.vct.common.appmodel.Ecore_URI"
	 * @generated
	 */
	URI getRootConfml();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.common.appmodel.EConfigurationProject#getRootConfml <em>Root Confml</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root Confml</em>' attribute.
	 * @see #getRootConfml()
	 * @generated
	 */
	void setRootConfml(URI value);

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
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEConfigurationProject_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.common.appmodel.EConfigurationProject#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Storage</b></em>' attribute.
	 * The literals are from the enumeration {@link com.nokia.tools.vct.common.appmodel.EStorageClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Storage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Storage</em>' attribute.
	 * @see com.nokia.tools.vct.common.appmodel.EStorageClass
	 * @see #setStorage(EStorageClass)
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEConfigurationProject_Storage()
	 * @model required="true"
	 * @generated
	 */
	EStorageClass getStorage();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.common.appmodel.EConfigurationProject#getStorage <em>Storage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Storage</em>' attribute.
	 * @see com.nokia.tools.vct.common.appmodel.EStorageClass
	 * @see #getStorage()
	 * @generated
	 */
	void setStorage(EStorageClass value);

	/**
	 * Returns the value of the '<em><b>Conf Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conf Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conf Version</em>' attribute.
	 * @see #setConfVersion(String)
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEConfigurationProject_ConfVersion()
	 * @model
	 * @generated
	 */
	String getConfVersion();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.common.appmodel.EConfigurationProject#getConfVersion <em>Conf Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conf Version</em>' attribute.
	 * @see #getConfVersion()
	 * @generated
	 */
	void setConfVersion(String value);

	/**
	 * Returns the value of the '<em><b>Default View</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default View</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default View</em>' reference.
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEConfigurationProject_DefaultView()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EAppView getDefaultView();

	/**
	 * Returns the value of the '<em><b>Setting Hidden</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Setting Hidden</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Setting Hidden</em>' attribute.
	 * @see #setSettingHidden(boolean)
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEConfigurationProject_SettingHidden()
	 * @model
	 * @generated
	 */
	boolean isSettingHidden();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.common.appmodel.EConfigurationProject#isSettingHidden <em>Setting Hidden</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Setting Hidden</em>' attribute.
	 * @see #isSettingHidden()
	 * @generated
	 */
	void setSettingHidden(boolean value);

} // EConfigurationProject
