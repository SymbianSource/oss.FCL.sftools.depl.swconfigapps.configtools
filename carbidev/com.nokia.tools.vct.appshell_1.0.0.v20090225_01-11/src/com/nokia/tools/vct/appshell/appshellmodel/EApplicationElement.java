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
 * Description: This file is part of com.nokia.tools.vct.appshell component.
 */

package com.nokia.tools.vct.appshell.appshellmodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EApplication Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.EApplicationElement#getUid <em>Uid</em>}</li>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.EApplicationElement#getView <em>View</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage#getEApplicationElement()
 * @model extendedMetaData="name='applicationType' kind='empty'"
 * @generated
 */
public interface EApplicationElement extends ELockDescriptor, EIconDescriptor, EHideDescriptor, ENameDescriptor {
	/**
	 * Returns the value of the '<em><b>Uid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uid</em>' attribute.
	 * @see #setUid(String)
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage#getEApplicationElement_Uid()
	 * @model required="true"
	 *        extendedMetaData="name='uid' kind='attribute'"
	 * @generated
	 */
	String getUid();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.appshell.appshellmodel.EApplicationElement#getUid <em>Uid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uid</em>' attribute.
	 * @see #getUid()
	 * @generated
	 */
	void setUid(String value);

	/**
	 * Returns the value of the '<em><b>View</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>View</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>View</em>' attribute.
	 * @see #setView(String)
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage#getEApplicationElement_View()
	 * @model extendedMetaData="name='view' kind='attribute'"
	 * @generated
	 */
	String getView();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.appshell.appshellmodel.EApplicationElement#getView <em>View</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>View</em>' attribute.
	 * @see #getView()
	 * @generated
	 */
	void setView(String value);

} // EApplicationElement
