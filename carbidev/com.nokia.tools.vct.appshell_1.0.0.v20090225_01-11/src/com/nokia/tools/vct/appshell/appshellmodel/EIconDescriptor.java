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
 * A representation of the model object '<em><b>EIcon Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.EIconDescriptor#getIconFile <em>Icon File</em>}</li>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.EIconDescriptor#getM3gIconFile <em>M3g Icon File</em>}</li>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.EIconDescriptor#getIconId <em>Icon Id</em>}</li>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.EIconDescriptor#getMaskId <em>Mask Id</em>}</li>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.EIconDescriptor#getIconSkinMajorId <em>Icon Skin Major Id</em>}</li>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.EIconDescriptor#getIconSkinMinorId <em>Icon Skin Minor Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage#getEIconDescriptor()
 * @model interface="true" abstract="true"
 *        extendedMetaData="name='iconDescriptorType' kind='empty'"
 * @generated
 */
public interface EIconDescriptor extends EObject {
	/**
	 * Returns the value of the '<em><b>Icon File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon File</em>' attribute.
	 * @see #setIconFile(String)
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage#getEIconDescriptor_IconFile()
	 * @model extendedMetaData="name='icon_file' kind='attribute'"
	 * @generated
	 */
	String getIconFile();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.appshell.appshellmodel.EIconDescriptor#getIconFile <em>Icon File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon File</em>' attribute.
	 * @see #getIconFile()
	 * @generated
	 */
	void setIconFile(String value);

	/**
	 * Returns the value of the '<em><b>M3g Icon File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>M3g Icon File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>M3g Icon File</em>' attribute.
	 * @see #setM3gIconFile(String)
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage#getEIconDescriptor_M3gIconFile()
	 * @model extendedMetaData="name='m3g_icon_file' kind='attribute'"
	 * @generated
	 */
	String getM3gIconFile();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.appshell.appshellmodel.EIconDescriptor#getM3gIconFile <em>M3g Icon File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>M3g Icon File</em>' attribute.
	 * @see #getM3gIconFile()
	 * @generated
	 */
	void setM3gIconFile(String value);

	/**
	 * Returns the value of the '<em><b>Icon Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon Id</em>' attribute.
	 * @see #setIconId(String)
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage#getEIconDescriptor_IconId()
	 * @model extendedMetaData="name='icon_id' kind='attribute'"
	 * @generated
	 */
	String getIconId();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.appshell.appshellmodel.EIconDescriptor#getIconId <em>Icon Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon Id</em>' attribute.
	 * @see #getIconId()
	 * @generated
	 */
	void setIconId(String value);

	/**
	 * Returns the value of the '<em><b>Mask Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mask Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mask Id</em>' attribute.
	 * @see #setMaskId(String)
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage#getEIconDescriptor_MaskId()
	 * @model extendedMetaData="name='mask_id' kind='attribute'"
	 * @generated
	 */
	String getMaskId();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.appshell.appshellmodel.EIconDescriptor#getMaskId <em>Mask Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mask Id</em>' attribute.
	 * @see #getMaskId()
	 * @generated
	 */
	void setMaskId(String value);

	/**
	 * Returns the value of the '<em><b>Icon Skin Major Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon Skin Major Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon Skin Major Id</em>' attribute.
	 * @see #setIconSkinMajorId(String)
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage#getEIconDescriptor_IconSkinMajorId()
	 * @model extendedMetaData="name='icon_skin_major_id' kind='attribute'"
	 * @generated
	 */
	String getIconSkinMajorId();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.appshell.appshellmodel.EIconDescriptor#getIconSkinMajorId <em>Icon Skin Major Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon Skin Major Id</em>' attribute.
	 * @see #getIconSkinMajorId()
	 * @generated
	 */
	void setIconSkinMajorId(String value);

	/**
	 * Returns the value of the '<em><b>Icon Skin Minor Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon Skin Minor Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon Skin Minor Id</em>' attribute.
	 * @see #setIconSkinMinorId(String)
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage#getEIconDescriptor_IconSkinMinorId()
	 * @model extendedMetaData="name='icon_skin_minor_id' kind='attribute'"
	 * @generated
	 */
	String getIconSkinMinorId();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.appshell.appshellmodel.EIconDescriptor#getIconSkinMinorId <em>Icon Skin Minor Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon Skin Minor Id</em>' attribute.
	 * @see #getIconSkinMinorId()
	 * @generated
	 */
	void setIconSkinMinorId(String value);

} // EIconDescriptor
