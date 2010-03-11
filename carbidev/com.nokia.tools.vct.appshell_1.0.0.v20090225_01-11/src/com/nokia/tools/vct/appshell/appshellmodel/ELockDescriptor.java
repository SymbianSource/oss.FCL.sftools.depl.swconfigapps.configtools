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
 * A representation of the model object '<em><b>ELock Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.ELockDescriptor#getLockName <em>Lock Name</em>}</li>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.ELockDescriptor#getLockIcon <em>Lock Icon</em>}</li>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.ELockDescriptor#getLockDelete <em>Lock Delete</em>}</li>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.ELockDescriptor#getLockOrganize <em>Lock Organize</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage#getELockDescriptor()
 * @model interface="true" abstract="true"
 *        extendedMetaData="name='lockDescriptorType' kind='empty'"
 * @generated
 */
public interface ELockDescriptor extends EObject {
	/**
	 * Returns the value of the '<em><b>Lock Name</b></em>' attribute.
	 * The literals are from the enumeration {@link com.nokia.tools.vct.appshell.appshellmodel.EBooleanFlag}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lock Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lock Name</em>' attribute.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EBooleanFlag
	 * @see #setLockName(EBooleanFlag)
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage#getELockDescriptor_LockName()
	 * @model extendedMetaData="name='lock_name' kind='attribute'"
	 * @generated
	 */
	EBooleanFlag getLockName();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.appshell.appshellmodel.ELockDescriptor#getLockName <em>Lock Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lock Name</em>' attribute.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EBooleanFlag
	 * @see #getLockName()
	 * @generated
	 */
	void setLockName(EBooleanFlag value);

	/**
	 * Returns the value of the '<em><b>Lock Icon</b></em>' attribute.
	 * The literals are from the enumeration {@link com.nokia.tools.vct.appshell.appshellmodel.EBooleanFlag}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lock Icon</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lock Icon</em>' attribute.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EBooleanFlag
	 * @see #setLockIcon(EBooleanFlag)
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage#getELockDescriptor_LockIcon()
	 * @model extendedMetaData="name='lock_icon' kind='attribute'"
	 * @generated
	 */
	EBooleanFlag getLockIcon();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.appshell.appshellmodel.ELockDescriptor#getLockIcon <em>Lock Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lock Icon</em>' attribute.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EBooleanFlag
	 * @see #getLockIcon()
	 * @generated
	 */
	void setLockIcon(EBooleanFlag value);

	/**
	 * Returns the value of the '<em><b>Lock Delete</b></em>' attribute.
	 * The literals are from the enumeration {@link com.nokia.tools.vct.appshell.appshellmodel.EBooleanFlag}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lock Delete</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lock Delete</em>' attribute.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EBooleanFlag
	 * @see #setLockDelete(EBooleanFlag)
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage#getELockDescriptor_LockDelete()
	 * @model extendedMetaData="name='lock_delete' kind='attribute'"
	 * @generated
	 */
	EBooleanFlag getLockDelete();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.appshell.appshellmodel.ELockDescriptor#getLockDelete <em>Lock Delete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lock Delete</em>' attribute.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EBooleanFlag
	 * @see #getLockDelete()
	 * @generated
	 */
	void setLockDelete(EBooleanFlag value);

	/**
	 * Returns the value of the '<em><b>Lock Organize</b></em>' attribute.
	 * The literals are from the enumeration {@link com.nokia.tools.vct.appshell.appshellmodel.EBooleanFlag}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lock Organize</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lock Organize</em>' attribute.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EBooleanFlag
	 * @see #setLockOrganize(EBooleanFlag)
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage#getELockDescriptor_LockOrganize()
	 * @model extendedMetaData="name='lock_organize' kind='attribute'"
	 * @generated
	 */
	EBooleanFlag getLockOrganize();

	/**
	 * Sets the value of the '{@link com.nokia.tools.vct.appshell.appshellmodel.ELockDescriptor#getLockOrganize <em>Lock Organize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lock Organize</em>' attribute.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EBooleanFlag
	 * @see #getLockOrganize()
	 * @generated
	 */
	void setLockOrganize(EBooleanFlag value);

} // ELockDescriptor
