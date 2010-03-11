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
 * Description: This file is part of com.nokia.tools.vct.ibyml component.
 */

package com.nokia.tools.vct.ibyml.ibymodel.impl;

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

import com.nokia.tools.vct.ibyml.ibymodel.EEntity;
import com.nokia.tools.vct.ibyml.ibymodel.EEntry;
import com.nokia.tools.vct.ibyml.ibymodel.EIBYFile;
import com.nokia.tools.vct.ibyml.ibymodel.EIBYModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EIBY File</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.ibyml.ibymodel.impl.EIBYFileImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.vct.ibyml.ibymodel.impl.EIBYFileImpl#getFlag <em>Flag</em>}</li>
 *   <li>{@link com.nokia.tools.vct.ibyml.ibymodel.impl.EIBYFileImpl#getEntries <em>Entries</em>}</li>
 *   <li>{@link com.nokia.tools.vct.ibyml.ibymodel.impl.EIBYFileImpl#getLocations <em>Locations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EIBYFileImpl extends EObjectImpl implements EIBYFile {
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
	 * The default value of the '{@link #getFlag() <em>Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFlag()
	 * @generated
	 * @ordered
	 */
	protected static final String FLAG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFlag() <em>Flag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFlag()
	 * @generated
	 * @ordered
	 */
	protected String flag = FLAG_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEntries() <em>Entries</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntries()
	 * @generated
	 * @ordered
	 */
	protected EList<EEntry> entries;

	/**
	 * The cached value of the '{@link #getLocations() <em>Locations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocations()
	 * @generated
	 * @ordered
	 */
	protected EList<EEntity> locations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EIBYFileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EIBYModelPackage.Literals.EIBY_FILE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EIBYModelPackage.EIBY_FILE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlag(String newFlag) {
		String oldFlag = flag;
		flag = newFlag;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EIBYModelPackage.EIBY_FILE__FLAG, oldFlag, flag));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EEntry> getEntries() {
		if (entries == null) {
			entries = new EObjectContainmentEList<EEntry>(EEntry.class, this, EIBYModelPackage.EIBY_FILE__ENTRIES);
		}
		return entries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EEntity> getLocations() {
		if (locations == null) {
			locations = new EObjectContainmentEList<EEntity>(EEntity.class, this, EIBYModelPackage.EIBY_FILE__LOCATIONS);
		}
		return locations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EIBYModelPackage.EIBY_FILE__ENTRIES:
				return ((InternalEList<?>)getEntries()).basicRemove(otherEnd, msgs);
			case EIBYModelPackage.EIBY_FILE__LOCATIONS:
				return ((InternalEList<?>)getLocations()).basicRemove(otherEnd, msgs);
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
			case EIBYModelPackage.EIBY_FILE__NAME:
				return getName();
			case EIBYModelPackage.EIBY_FILE__FLAG:
				return getFlag();
			case EIBYModelPackage.EIBY_FILE__ENTRIES:
				return getEntries();
			case EIBYModelPackage.EIBY_FILE__LOCATIONS:
				return getLocations();
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
			case EIBYModelPackage.EIBY_FILE__NAME:
				setName((String)newValue);
				return;
			case EIBYModelPackage.EIBY_FILE__FLAG:
				setFlag((String)newValue);
				return;
			case EIBYModelPackage.EIBY_FILE__ENTRIES:
				getEntries().clear();
				getEntries().addAll((Collection<? extends EEntry>)newValue);
				return;
			case EIBYModelPackage.EIBY_FILE__LOCATIONS:
				getLocations().clear();
				getLocations().addAll((Collection<? extends EEntity>)newValue);
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
			case EIBYModelPackage.EIBY_FILE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EIBYModelPackage.EIBY_FILE__FLAG:
				setFlag(FLAG_EDEFAULT);
				return;
			case EIBYModelPackage.EIBY_FILE__ENTRIES:
				getEntries().clear();
				return;
			case EIBYModelPackage.EIBY_FILE__LOCATIONS:
				getLocations().clear();
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
			case EIBYModelPackage.EIBY_FILE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EIBYModelPackage.EIBY_FILE__FLAG:
				return FLAG_EDEFAULT == null ? flag != null : !FLAG_EDEFAULT.equals(flag);
			case EIBYModelPackage.EIBY_FILE__ENTRIES:
				return entries != null && !entries.isEmpty();
			case EIBYModelPackage.EIBY_FILE__LOCATIONS:
				return locations != null && !locations.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", flag: ");
		result.append(flag);
		result.append(')');
		return result.toString();
	}

} //EIBYFileImpl
