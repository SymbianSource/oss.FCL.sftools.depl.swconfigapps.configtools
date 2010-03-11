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
 * A representation of the model object '<em><b>File System Entry Setting</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.FileSystemEntrySetting#isFile <em>File</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.FileSystemEntrySetting#getSourceFilePath <em>Source File Path</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.FileSystemEntrySetting#getTargetFilePath <em>Target File Path</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.FileSystemEntrySetting#getChosenOption <em>Chosen Option</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.FileSystemEntrySetting#getPattern <em>Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getFileSystemEntrySetting()
 * @model
 * @generated
 */
public interface FileSystemEntrySetting extends Setting {
	/**
	 * Returns the value of the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File</em>' attribute.
	 * @see #setFile(boolean)
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getFileSystemEntrySetting_File()
	 * @model
	 * @generated
	 */
	boolean isFile();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.FileSystemEntrySetting#isFile <em>File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File</em>' attribute.
	 * @see #isFile()
	 * @generated
	 */
	void setFile(boolean value);

	/**
	 * Returns the value of the '<em><b>Source File Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source File Path</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source File Path</em>' containment reference.
	 * @see #setSourceFilePath(FilePath)
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getFileSystemEntrySetting_SourceFilePath()
	 * @model containment="true"
	 * @generated
	 */
	FilePath getSourceFilePath();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.FileSystemEntrySetting#getSourceFilePath <em>Source File Path</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source File Path</em>' containment reference.
	 * @see #getSourceFilePath()
	 * @generated
	 */
	void setSourceFilePath(FilePath value);

	/**
	 * Returns the value of the '<em><b>Target File Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target File Path</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target File Path</em>' containment reference.
	 * @see #setTargetFilePath(FilePath)
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getFileSystemEntrySetting_TargetFilePath()
	 * @model containment="true"
	 * @generated
	 */
	FilePath getTargetFilePath();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.FileSystemEntrySetting#getTargetFilePath <em>Target File Path</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target File Path</em>' containment reference.
	 * @see #getTargetFilePath()
	 * @generated
	 */
	void setTargetFilePath(FilePath value);

	/**
	 * Returns the value of the '<em><b>Chosen Option</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Chosen Option</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chosen Option</em>' attribute.
	 * @see #setChosenOption(String)
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getFileSystemEntrySetting_ChosenOption()
	 * @model
	 * @generated
	 */
	String getChosenOption();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.FileSystemEntrySetting#getChosenOption <em>Chosen Option</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Chosen Option</em>' attribute.
	 * @see #getChosenOption()
	 * @generated
	 */
	void setChosenOption(String value);

	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' attribute.
	 * @see #setPattern(String)
	 * @see com.nokia.tools.s60ct.content.confml.ConfmlPackage#getFileSystemEntrySetting_Pattern()
	 * @model default=""
	 * @generated
	 */
	String getPattern();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.content.confml.FileSystemEntrySetting#getPattern <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern</em>' attribute.
	 * @see #getPattern()
	 * @generated
	 */
	void setPattern(String value);

} // FileSystemEntrySetting
