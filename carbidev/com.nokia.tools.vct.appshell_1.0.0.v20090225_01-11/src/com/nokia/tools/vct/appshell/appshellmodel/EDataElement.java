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
 * A representation of the model object '<em><b>EData Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.EDataElement#getVersion <em>Version</em>}</li>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.EDataElement#getFolder <em>Folder</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage#getEDataElement()
 * @model extendedMetaData="name='dataType' kind='elementOnly'"
 * @generated
 */
public interface EDataElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage#getEDataElement_Version()
	 * @model required="true"
	 *        extendedMetaData="name='version' kind='attribute'"
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.appshell.appshellmodel.EDataElement#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Folder</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Folder</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Folder</em>' containment reference.
	 * @see #setFolder(EFolderElement)
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage#getEDataElement_Folder()
	 * @model containment="true"
	 *        extendedMetaData="name='folder' kind='element' namespace='##targetNamespace'"
	 * @generated
	 */
	EFolderElement getFolder();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.appshell.appshellmodel.EDataElement#getFolder <em>Folder</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Folder</em>' containment reference.
	 * @see #getFolder()
	 * @generated
	 */
	void setFolder(EFolderElement value);

} // EDataElement
