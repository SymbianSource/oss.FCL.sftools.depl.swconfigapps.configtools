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
 * A representation of the model object '<em><b>Referable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link configurationemf.Referable#getRef <em>Ref</em>}</li>
 *   <li>{@link configurationemf.Referable#getRefs <em>Refs</em>}</li>
 *   <li>{@link configurationemf.Referable#getRfsRefs <em>Rfs Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @see configurationemf.ConfigurationemfPackage#getReferable()
 * @model abstract="true"
 * @generated
 */
public interface Referable extends AttributeAndDesc {
	/**
	 * Returns the value of the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref</em>' attribute.
	 * @see #setRef(String)
	 * @see configurationemf.ConfigurationemfPackage#getReferable_Ref()
	 * @model
	 * @generated
	 */
	String getRef();

	/**
	 * Sets the value of the '{@link configurationemf.Referable#getRef <em>Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref</em>' attribute.
	 * @see #getRef()
	 * @generated
	 */
	void setRef(String value);

	/**
	 * Returns the value of the '<em><b>Refs</b></em>' reference list.
	 * The list contents are of type {@link configurationemf.Ref}.
	 * It is bidirectional and its opposite is '{@link configurationemf.Ref#getReferable <em>Referable</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refs</em>' reference list.
	 * @see configurationemf.ConfigurationemfPackage#getReferable_Refs()
	 * @see configurationemf.Ref#getReferable
	 * @model opposite="referable" resolveProxies="false" transient="true"
	 * @generated
	 */
	EList<Ref> getRefs();

	/**
	 * Returns the value of the '<em><b>Rfs Refs</b></em>' reference list.
	 * The list contents are of type {@link configurationemf.Ref}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rfs Refs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rfs Refs</em>' reference list.
	 * @see configurationemf.ConfigurationemfPackage#getReferable_RfsRefs()
	 * @model resolveProxies="false" transient="true"
	 * @generated
	 */
	EList<Ref> getRfsRefs();

} // Referable
