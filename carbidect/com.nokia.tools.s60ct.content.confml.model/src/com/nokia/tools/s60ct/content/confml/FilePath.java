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
 * Description: This file is part of com.nokia.tools.variant.content.confml.model component.
 */

package com.nokia.tools.s60ct.content.confml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File Path</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.FilePath#getPath <em>Path</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.FilePath#getLastSavedPath <em>Last Saved Path</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.FilePath#getDefaultPath <em>Default Path</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.FilePath#isPathReadOnly <em>Path Read Only</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.FilePath#getPathNameOverride <em>Path Name Override</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.FilePath#getPathDescriptionOverride <em>Path Description Override</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.FilePath#getParent <em>Parent</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.FilePath#isContainedInLastLayer <em>Contained In Last Layer</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.FilePath#isLastSavedInLastLayer <em>Last Saved In Last Layer</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getFilePath()
 * @model
 * @generated
 */
public interface FilePath extends FileSystemEntrySetting {
	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getFilePath_Path()
	 * @model
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.FilePath#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

	/**
	 * Returns the value of the '<em><b>Last Saved Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Saved Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Saved Path</em>' attribute.
	 * @see #setLastSavedPath(String)
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getFilePath_LastSavedPath()
	 * @model
	 * @generated
	 */
	String getLastSavedPath();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.FilePath#getLastSavedPath <em>Last Saved Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Saved Path</em>' attribute.
	 * @see #getLastSavedPath()
	 * @generated
	 */
	void setLastSavedPath(String value);

	/**
	 * Returns the value of the '<em><b>Default Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Path</em>' attribute.
	 * @see #setDefaultPath(String)
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getFilePath_DefaultPath()
	 * @model
	 * @generated
	 */
	String getDefaultPath();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.FilePath#getDefaultPath <em>Default Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Path</em>' attribute.
	 * @see #getDefaultPath()
	 * @generated
	 */
	void setDefaultPath(String value);

	/**
	 * Returns the value of the '<em><b>Path Read Only</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path Read Only</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path Read Only</em>' attribute.
	 * @see #setPathReadOnly(boolean)
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getFilePath_PathReadOnly()
	 * @model default="false"
	 * @generated
	 */
	boolean isPathReadOnly();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.FilePath#isPathReadOnly <em>Path Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path Read Only</em>' attribute.
	 * @see #isPathReadOnly()
	 * @generated
	 */
	void setPathReadOnly(boolean value);

	/**
	 * Returns the value of the '<em><b>Path Name Override</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path Name Override</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path Name Override</em>' attribute.
	 * @see #setPathNameOverride(String)
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getFilePath_PathNameOverride()
	 * @model
	 * @generated
	 */
	String getPathNameOverride();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.FilePath#getPathNameOverride <em>Path Name Override</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path Name Override</em>' attribute.
	 * @see #getPathNameOverride()
	 * @generated
	 */
	void setPathNameOverride(String value);

	/**
	 * Returns the value of the '<em><b>Path Description Override</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path Description Override</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path Description Override</em>' attribute.
	 * @see #setPathDescriptionOverride(String)
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getFilePath_PathDescriptionOverride()
	 * @model
	 * @generated
	 */
	String getPathDescriptionOverride();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.FilePath#getPathDescriptionOverride <em>Path Description Override</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path Description Override</em>' attribute.
	 * @see #getPathDescriptionOverride()
	 * @generated
	 */
	void setPathDescriptionOverride(String value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(FileSystemEntrySetting)
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getFilePath_Parent()
	 * @model
	 * @generated
	 */
	FileSystemEntrySetting getParent();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.FilePath#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(FileSystemEntrySetting value);

	/**
	 * Returns the value of the '<em><b>Contained In Last Layer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contained In Last Layer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contained In Last Layer</em>' attribute.
	 * @see #setContainedInLastLayer(boolean)
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getFilePath_ContainedInLastLayer()
	 * @model
	 * @generated
	 */
	boolean isContainedInLastLayer();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.FilePath#isContainedInLastLayer <em>Contained In Last Layer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contained In Last Layer</em>' attribute.
	 * @see #isContainedInLastLayer()
	 * @generated
	 */
	void setContainedInLastLayer(boolean value);

	/**
	 * Returns the value of the '<em><b>Last Saved In Last Layer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Saved In Last Layer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Saved In Last Layer</em>' attribute.
	 * @see #setLastSavedInLastLayer(boolean)
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getFilePath_LastSavedInLastLayer()
	 * @model
	 * @generated
	 */
	boolean isLastSavedInLastLayer();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.FilePath#isLastSavedInLastLayer <em>Last Saved In Last Layer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Saved In Last Layer</em>' attribute.
	 * @see #isLastSavedInLastLayer()
	 * @generated
	 */
	void setLastSavedInLastLayer(boolean value);

} // FilePath
