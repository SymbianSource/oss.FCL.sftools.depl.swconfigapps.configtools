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
package IBY;

import java.util.Map;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity2</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link IBY.Entity2#getPlugin <em>Plugin</em>}</li>
 *   <li>{@link IBY.Entity2#getFiles <em>Files</em>}</li>
 *   <li>{@link IBY.Entity2#getTargets <em>Targets</em>}</li>
 *   <li>{@link IBY.Entity2#getComments <em>Comments</em>}</li>
 *   <li>{@link IBY.Entity2#getEncodings <em>Encodings</em>}</li>
 * </ul>
 * </p>
 *
 * @see IBY.IBYPackage#getEntity2()
 * @model abstract="true"
 * @generated
 */
public interface Entity2 extends Entity {
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
	 * @see IBY.IBYPackage#getEntity2_Plugin()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getPlugin();

	/**
	 * Sets the value of the '{@link IBY.Entity2#getPlugin <em>Plugin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plugin</em>' attribute.
	 * @see #getPlugin()
	 * @generated
	 */
	void setPlugin(String value);

	/**
	 * Returns the value of the '<em><b>Files</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Files</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Files</em>' attribute.
	 * @see #setFiles(Map)
	 * @see IBY.IBYPackage#getEntity2_Files()
	 * @model transient="true"
	 * @generated
	 */
	Map<?, ?> getFiles();

	/**
	 * Sets the value of the '{@link IBY.Entity2#getFiles <em>Files</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Files</em>' attribute.
	 * @see #getFiles()
	 * @generated
	 */
	void setFiles(Map<?, ?> value);

	/**
	 * Returns the value of the '<em><b>Targets</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Targets</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Targets</em>' attribute.
	 * @see #setTargets(Map)
	 * @see IBY.IBYPackage#getEntity2_Targets()
	 * @model transient="true"
	 * @generated
	 */
	Map<?, ?> getTargets();

	/**
	 * Sets the value of the '{@link IBY.Entity2#getTargets <em>Targets</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Targets</em>' attribute.
	 * @see #getTargets()
	 * @generated
	 */
	void setTargets(Map<?, ?> value);

	/**
	 * Returns the value of the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comments</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comments</em>' attribute.
	 * @see #setComments(Map)
	 * @see IBY.IBYPackage#getEntity2_Comments()
	 * @model transient="true"
	 * @generated
	 */
	Map<?, ?> getComments();

	/**
	 * Sets the value of the '{@link IBY.Entity2#getComments <em>Comments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comments</em>' attribute.
	 * @see #getComments()
	 * @generated
	 */
	void setComments(Map<?, ?> value);

	/**
	 * Returns the value of the '<em><b>Encodings</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Encodings</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Encodings</em>' attribute.
	 * @see #setEncodings(Map)
	 * @see IBY.IBYPackage#getEntity2_Encodings()
	 * @model transient="true"
	 * @generated
	 */
	Map<?, ?> getEncodings();

	/**
	 * Sets the value of the '{@link IBY.Entity2#getEncodings <em>Encodings</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Encodings</em>' attribute.
	 * @see #getEncodings()
	 * @generated
	 */
	void setEncodings(Map<?, ?> value);

} // Entity2
