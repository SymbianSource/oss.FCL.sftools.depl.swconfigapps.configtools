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
 * A representation of the model object '<em><b>Release Attr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link configurationemf.ReleaseAttr#getFirstRelease <em>First Release</em>}</li>
 *   <li>{@link configurationemf.ReleaseAttr#getLastRelease <em>Last Release</em>}</li>
 * </ul>
 * </p>
 *
 * @see configurationemf.ConfigurationemfPackage#getReleaseAttr()
 * @model abstract="true"
 * @generated
 */
public interface ReleaseAttr extends EObject {
	/**
	 * Returns the value of the '<em><b>First Release</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Release</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Release</em>' attribute.
	 * @see #setFirstRelease(String)
	 * @see configurationemf.ConfigurationemfPackage#getReleaseAttr_FirstRelease()
	 * @model
	 * @generated
	 */
	String getFirstRelease();

	/**
	 * Sets the value of the '{@link configurationemf.ReleaseAttr#getFirstRelease <em>First Release</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Release</em>' attribute.
	 * @see #getFirstRelease()
	 * @generated
	 */
	void setFirstRelease(String value);

	/**
	 * Returns the value of the '<em><b>Last Release</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Release</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Release</em>' attribute.
	 * @see #setLastRelease(String)
	 * @see configurationemf.ConfigurationemfPackage#getReleaseAttr_LastRelease()
	 * @model
	 * @generated
	 */
	String getLastRelease();

	/**
	 * Sets the value of the '{@link configurationemf.ReleaseAttr#getLastRelease <em>Last Release</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Release</em>' attribute.
	 * @see #getLastRelease()
	 * @generated
	 */
	void setLastRelease(String value);

} // ReleaseAttr