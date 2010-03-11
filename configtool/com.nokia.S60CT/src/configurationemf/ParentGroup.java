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
 * A representation of the model object '<em><b>Parent Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link configurationemf.ParentGroup#getLeafGroup <em>Leaf Group</em>}</li>
 * </ul>
 * </p>
 *
 * @see configurationemf.ConfigurationemfPackage#getParentGroup()
 * @model
 * @generated
 */
public interface ParentGroup extends Group {
	/**
	 * Returns the value of the '<em><b>Leaf Group</b></em>' containment reference list.
	 * The list contents are of type {@link configurationemf.LeafGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Leaf Group</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Leaf Group</em>' containment reference list.
	 * @see configurationemf.ConfigurationemfPackage#getParentGroup_LeafGroup()
	 * @model containment="true"
	 * @generated
	 */
	EList<LeafGroup> getLeafGroup();

} // ParentGroup