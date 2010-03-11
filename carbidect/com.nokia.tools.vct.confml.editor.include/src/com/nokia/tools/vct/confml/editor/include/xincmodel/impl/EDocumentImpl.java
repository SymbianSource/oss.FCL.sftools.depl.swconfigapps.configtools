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
 * Description: This file is part of com.nokia.tools.vct.confml.editor.include component.
 */

package com.nokia.tools.vct.confml.editor.include.xincmodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.nokia.tools.vct.confml.editor.include.xincmodel.EConfMLVersion;
import com.nokia.tools.vct.confml.editor.include.xincmodel.EDocument;
import com.nokia.tools.vct.confml.editor.include.xincmodel.EInclude;
import com.nokia.tools.vct.confml.editor.include.xincmodel.EProjectResource;
import com.nokia.tools.vct.confml.editor.include.xincmodel.EXincModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EDocument</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EDocumentImpl#getResources <em>Resources</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EDocumentImpl#getIncludes <em>Includes</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EDocumentImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EDocumentImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EDocumentImpl extends EObjectImpl implements EDocument {
	/**
	 * The cached value of the '{@link #getResources() <em>Resources</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResources()
	 * @generated
	 * @ordered
	 */
	protected EList<EProjectResource> resources;

	/**
	 * The cached value of the '{@link #getIncludes() <em>Includes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncludes()
	 * @generated
	 * @ordered
	 */
	protected EList<EInclude> includes;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final EConfMLVersion VERSION_EDEFAULT = EConfMLVersion.CONFML1;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected EConfMLVersion version = VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EDocumentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EXincModelPackage.Literals.EDOCUMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EProjectResource> getResources() {
		if (resources == null) {
			resources = new EObjectContainmentEList<EProjectResource>(EProjectResource.class, this, EXincModelPackage.EDOCUMENT__RESOURCES);
		}
		return resources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EInclude> getIncludes() {
		if (includes == null) {
			includes = new EObjectContainmentEList<EInclude>(EInclude.class, this, EXincModelPackage.EDOCUMENT__INCLUDES);
		}
		return includes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EConfMLVersion getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(EConfMLVersion newVersion) {
		EConfMLVersion oldVersion = version;
		version = newVersion == null ? VERSION_EDEFAULT : newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EXincModelPackage.EDOCUMENT__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EXincModelPackage.EDOCUMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EXincModelPackage.EDOCUMENT__RESOURCES:
				return ((InternalEList<?>)getResources()).basicRemove(otherEnd, msgs);
			case EXincModelPackage.EDOCUMENT__INCLUDES:
				return ((InternalEList<?>)getIncludes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EXincModelPackage.EDOCUMENT__RESOURCES:
				return getResources();
			case EXincModelPackage.EDOCUMENT__INCLUDES:
				return getIncludes();
			case EXincModelPackage.EDOCUMENT__VERSION:
				return getVersion();
			case EXincModelPackage.EDOCUMENT__NAME:
				return getName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EXincModelPackage.EDOCUMENT__INCLUDES:
				getIncludes().clear();
				getIncludes().addAll((Collection<? extends EInclude>)newValue);
				return;
			case EXincModelPackage.EDOCUMENT__VERSION:
				setVersion((EConfMLVersion)newValue);
				return;
			case EXincModelPackage.EDOCUMENT__NAME:
				setName((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EXincModelPackage.EDOCUMENT__INCLUDES:
				getIncludes().clear();
				return;
			case EXincModelPackage.EDOCUMENT__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case EXincModelPackage.EDOCUMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EXincModelPackage.EDOCUMENT__RESOURCES:
				return resources != null && !resources.isEmpty();
			case EXincModelPackage.EDOCUMENT__INCLUDES:
				return includes != null && !includes.isEmpty();
			case EXincModelPackage.EDOCUMENT__VERSION:
				return version != VERSION_EDEFAULT;
			case EXincModelPackage.EDOCUMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (version: ");
		result.append(version);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //EDocumentImpl
