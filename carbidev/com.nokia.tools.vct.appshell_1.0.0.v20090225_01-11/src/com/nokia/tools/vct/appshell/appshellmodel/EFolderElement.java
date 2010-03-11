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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.FeatureMap;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EFolder Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.EFolderElement#getContents <em>Contents</em>}</li>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.EFolderElement#getDefault <em>Default</em>}</li>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.EFolderElement#getApplicationGroupName <em>Application Group Name</em>}</li>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.EFolderElement#getApplications <em>Applications</em>}</li>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.EFolderElement#getFolders <em>Folders</em>}</li>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.EFolderElement#getUrls <em>Urls</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage#getEFolderElement()
 * @model extendedMetaData="name='folderType' kind='elementOnly'"
 * @generated
 */
public interface EFolderElement extends ELockDescriptor, EIconDescriptor, EHideDescriptor, ENameDescriptor {
	/**
	 * Returns the value of the '<em><b>Contents</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contents</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contents</em>' attribute list.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage#getEFolderElement_Contents()
	 * @model dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='contents:0'"
	 * @generated
	 */
	FeatureMap getContents();

	/**
	 * Returns the value of the '<em><b>Default</b></em>' attribute.
	 * The literals are from the enumeration {@link com.nokia.tools.vct.appshell.appshellmodel.EBooleanFlag}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default</em>' attribute.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EBooleanFlag
	 * @see #setDefault(EBooleanFlag)
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage#getEFolderElement_Default()
	 * @model extendedMetaData="name='default' kind='attribute'"
	 * @generated
	 */
	EBooleanFlag getDefault();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.appshell.appshellmodel.EFolderElement#getDefault <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' attribute.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EBooleanFlag
	 * @see #getDefault()
	 * @generated
	 */
	void setDefault(EBooleanFlag value);

	/**
	 * Returns the value of the '<em><b>Application Group Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Application Group Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Application Group Name</em>' attribute.
	 * @see #setApplicationGroupName(String)
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage#getEFolderElement_ApplicationGroupName()
	 * @model extendedMetaData="name='applicationgroup_name' kind='attribute'"
	 * @generated
	 */
	String getApplicationGroupName();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.appshell.appshellmodel.EFolderElement#getApplicationGroupName <em>Application Group Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Application Group Name</em>' attribute.
	 * @see #getApplicationGroupName()
	 * @generated
	 */
	void setApplicationGroupName(String value);

	/**
	 * Returns the value of the '<em><b>Applications</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.appshell.appshellmodel.EApplicationElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applications</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Applications</em>' containment reference list.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage#getEFolderElement_Applications()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="name='application' kind='element' namespace='##targetNamespace' group='#contents:0'"
	 * @generated
	 */
	EList<EApplicationElement> getApplications();

	/**
	 * Returns the value of the '<em><b>Folders</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.appshell.appshellmodel.EFolderElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Folders</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Folders</em>' containment reference list.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage#getEFolderElement_Folders()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="name='folder' kind='element' namespace='##targetNamespace' group='#contents:0'"
	 * @generated
	 */
	EList<EFolderElement> getFolders();

	/**
	 * Returns the value of the '<em><b>Urls</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.appshell.appshellmodel.EURLElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Urls</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Urls</em>' containment reference list.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage#getEFolderElement_Urls()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="name='url' kind='element' namespace='##targetNamespace' group='#contents:0'"
	 * @generated
	 */
	EList<EURLElement> getUrls();

} // EFolderElement
