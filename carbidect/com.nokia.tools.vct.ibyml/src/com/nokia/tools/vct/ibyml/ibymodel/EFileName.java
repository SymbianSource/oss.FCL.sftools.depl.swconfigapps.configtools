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
 * Description: This file is part of com.nokia.tools.vct.ibyml component.
 */

package com.nokia.tools.vct.ibyml.ibymodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EFile Name</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.ibyml.ibymodel.EFileName#getPlugin <em>Plugin</em>}</li>
 *   <li>{@link com.nokia.tools.vct.ibyml.ibymodel.EFileName#getEncoding <em>Encoding</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.ibyml.ibymodel.EIBYModelPackage#getEFileName()
 * @model extendedMetaData="name='fileNameType' kind='empty'"
 * @generated
 */
public interface EFileName extends EEntity {
	/**
	 * Returns the value of the '<em><b>Plugin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plugin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plugin</em>' attribute.
	 * @see #setPlugin(String)
	 * @see com.nokia.tools.vct.ibyml.ibymodel.EIBYModelPackage#getEFileName_Plugin()
	 * @model extendedMetaData="name='plugin' kind='attribute'"
	 * @generated
	 */
	String getPlugin();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.ibyml.ibymodel.EFileName#getPlugin <em>Plugin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plugin</em>' attribute.
	 * @see #getPlugin()
	 * @generated
	 */
	void setPlugin(String value);

	/**
	 * Returns the value of the '<em><b>Encoding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Encoding</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Encoding</em>' attribute.
	 * @see #setEncoding(String)
	 * @see com.nokia.tools.vct.ibyml.ibymodel.EIBYModelPackage#getEFileName_Encoding()
	 * @model extendedMetaData="name='encoding' kind='attribute'"
	 * @generated
	 */
	String getEncoding();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.ibyml.ibymodel.EFileName#getEncoding <em>Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Encoding</em>' attribute.
	 * @see #getEncoding()
	 * @generated
	 */
	void setEncoding(String value);

} // EFileName
