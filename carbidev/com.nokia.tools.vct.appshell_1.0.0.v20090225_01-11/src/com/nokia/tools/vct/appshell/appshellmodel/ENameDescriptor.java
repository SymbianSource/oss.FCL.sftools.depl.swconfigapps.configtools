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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EName Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.ENameDescriptor#getTitleName <em>Title Name</em>}</li>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.ENameDescriptor#getShortName <em>Short Name</em>}</li>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.ENameDescriptor#getLongName <em>Long Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage#getENameDescriptor()
 * @model interface="true" abstract="true"
 *        extendedMetaData="name='nameDescriptorType' kind='empty'"
 * @generated
 */
public interface ENameDescriptor extends EObject {
	/**
	 * Returns the value of the '<em><b>Title Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title Name</em>' attribute.
	 * @see #setTitleName(String)
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage#getENameDescriptor_TitleName()
	 * @model extendedMetaData="name='title_name' kind='attribute'"
	 * @generated
	 */
	String getTitleName();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.appshell.appshellmodel.ENameDescriptor#getTitleName <em>Title Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title Name</em>' attribute.
	 * @see #getTitleName()
	 * @generated
	 */
	void setTitleName(String value);

	/**
	 * Returns the value of the '<em><b>Short Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Short Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Short Name</em>' attribute.
	 * @see #setShortName(String)
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage#getENameDescriptor_ShortName()
	 * @model extendedMetaData="name='short_name' kind='attribute'"
	 * @generated
	 */
	String getShortName();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.appshell.appshellmodel.ENameDescriptor#getShortName <em>Short Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Short Name</em>' attribute.
	 * @see #getShortName()
	 * @generated
	 */
	void setShortName(String value);

	/**
	 * Returns the value of the '<em><b>Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Long Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Long Name</em>' attribute.
	 * @see #setLongName(String)
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage#getENameDescriptor_LongName()
	 * @model extendedMetaData="name='long_name' kind='attribute'"
	 * @generated
	 */
	String getLongName();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.appshell.appshellmodel.ENameDescriptor#getLongName <em>Long Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Long Name</em>' attribute.
	 * @see #getLongName()
	 * @generated
	 */
	void setLongName(String value);

} // ENameDescriptor
