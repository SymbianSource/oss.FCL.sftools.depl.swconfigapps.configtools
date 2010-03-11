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
 * A representation of the model object '<em><b>EHide Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.EHideDescriptor#getHideChangeSkin <em>Hide Change Skin</em>}</li>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.EHideDescriptor#getHideMemDetails <em>Hide Mem Details</em>}</li>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.EHideDescriptor#getHideDownload <em>Hide Download</em>}</li>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.EHideDescriptor#getHideAnimatedIcons <em>Hide Animated Icons</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage#getEHideDescriptor()
 * @model interface="true" abstract="true"
 *        extendedMetaData="name='hideDescriptorType' kind='empty'"
 * @generated
 */
public interface EHideDescriptor extends EObject {
	/**
	 * Returns the value of the '<em><b>Hide Change Skin</b></em>' attribute.
	 * The literals are from the enumeration {@link com.nokia.tools.vct.appshell.appshellmodel.EBooleanFlag}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hide Change Skin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hide Change Skin</em>' attribute.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EBooleanFlag
	 * @see #setHideChangeSkin(EBooleanFlag)
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage#getEHideDescriptor_HideChangeSkin()
	 * @model extendedMetaData="name='hide_change_skin' kind='attribute'"
	 * @generated
	 */
	EBooleanFlag getHideChangeSkin();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.appshell.appshellmodel.EHideDescriptor#getHideChangeSkin <em>Hide Change Skin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hide Change Skin</em>' attribute.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EBooleanFlag
	 * @see #getHideChangeSkin()
	 * @generated
	 */
	void setHideChangeSkin(EBooleanFlag value);

	/**
	 * Returns the value of the '<em><b>Hide Mem Details</b></em>' attribute.
	 * The literals are from the enumeration {@link com.nokia.tools.vct.appshell.appshellmodel.EBooleanFlag}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hide Mem Details</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hide Mem Details</em>' attribute.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EBooleanFlag
	 * @see #setHideMemDetails(EBooleanFlag)
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage#getEHideDescriptor_HideMemDetails()
	 * @model extendedMetaData="name='hide_mem_details' kind='attribute'"
	 * @generated
	 */
	EBooleanFlag getHideMemDetails();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.appshell.appshellmodel.EHideDescriptor#getHideMemDetails <em>Hide Mem Details</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hide Mem Details</em>' attribute.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EBooleanFlag
	 * @see #getHideMemDetails()
	 * @generated
	 */
	void setHideMemDetails(EBooleanFlag value);

	/**
	 * Returns the value of the '<em><b>Hide Download</b></em>' attribute.
	 * The literals are from the enumeration {@link com.nokia.tools.vct.appshell.appshellmodel.EBooleanFlag}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hide Download</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hide Download</em>' attribute.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EBooleanFlag
	 * @see #setHideDownload(EBooleanFlag)
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage#getEHideDescriptor_HideDownload()
	 * @model extendedMetaData="name='hide_download' kind='attribute'"
	 * @generated
	 */
	EBooleanFlag getHideDownload();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.appshell.appshellmodel.EHideDescriptor#getHideDownload <em>Hide Download</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hide Download</em>' attribute.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EBooleanFlag
	 * @see #getHideDownload()
	 * @generated
	 */
	void setHideDownload(EBooleanFlag value);

	/**
	 * Returns the value of the '<em><b>Hide Animated Icons</b></em>' attribute.
	 * The literals are from the enumeration {@link com.nokia.tools.vct.appshell.appshellmodel.EBooleanFlag}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hide Animated Icons</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hide Animated Icons</em>' attribute.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EBooleanFlag
	 * @see #setHideAnimatedIcons(EBooleanFlag)
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage#getEHideDescriptor_HideAnimatedIcons()
	 * @model extendedMetaData="name='hide_animated_icons' kind='attribute'"
	 * @generated
	 */
	EBooleanFlag getHideAnimatedIcons();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.appshell.appshellmodel.EHideDescriptor#getHideAnimatedIcons <em>Hide Animated Icons</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hide Animated Icons</em>' attribute.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EBooleanFlag
	 * @see #getHideAnimatedIcons()
	 * @generated
	 */
	void setHideAnimatedIcons(EBooleanFlag value);

} // EHideDescriptor
