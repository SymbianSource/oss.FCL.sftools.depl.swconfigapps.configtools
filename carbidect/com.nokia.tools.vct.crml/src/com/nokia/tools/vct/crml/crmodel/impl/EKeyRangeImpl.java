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
 * Description: This file is part of com.nokia.tools.vct.crml component.
 */

package com.nokia.tools.vct.crml.crmodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.nokia.tools.vct.crml.crmodel.EAccess;
import com.nokia.tools.vct.crml.crmodel.EAccessContainer;
import com.nokia.tools.vct.crml.crmodel.EBackup;
import com.nokia.tools.vct.crml.crmodel.ECRMLPackage;
import com.nokia.tools.vct.crml.crmodel.EKey;
import com.nokia.tools.vct.crml.crmodel.EKeyRange;
import com.nokia.tools.vct.crml.crmodel.EReadOnly;
import com.nokia.tools.vct.crml.crmodel.ERefContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EKey Range</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.EKeyRangeImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.EKeyRangeImpl#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.EKeyRangeImpl#getAccess <em>Access</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.EKeyRangeImpl#isBackup <em>Backup</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.EKeyRangeImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.EKeyRangeImpl#getInt <em>Int</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.EKeyRangeImpl#getFirstInt <em>First Int</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.EKeyRangeImpl#getLastInt <em>Last Int</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.EKeyRangeImpl#getIndexBits <em>Index Bits</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.EKeyRangeImpl#getFirstIndex <em>First Index</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.EKeyRangeImpl#getCountInt <em>Count Int</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.EKeyRangeImpl#getKeys <em>Keys</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EKeyRangeImpl extends EAttributeAndDescriptionImpl implements EKeyRange {
	/**
	 * The default value of the '{@link #getRef() <em>Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRef()
	 * @generated
	 * @ordered
	 */
	protected static final String REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRef() <em>Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRef()
	 * @generated
	 * @ordered
	 */
	protected String ref = REF_EDEFAULT;

	/**
	 * The default value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReadOnly()
	 * @generated
	 * @ordered
	 */
	protected static final boolean READ_ONLY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReadOnly()
	 * @generated
	 * @ordered
	 */
	protected boolean readOnly = READ_ONLY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAccess() <em>Access</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccess()
	 * @generated
	 * @ordered
	 */
	protected EList<EAccess> access;

	/**
	 * The default value of the '{@link #isBackup() <em>Backup</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBackup()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BACKUP_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isBackup() <em>Backup</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBackup()
	 * @generated
	 * @ordered
	 */
	protected boolean backup = BACKUP_EDEFAULT;

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
	 * The default value of the '{@link #getInt() <em>Int</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInt()
	 * @generated
	 * @ordered
	 */
	protected static final String INT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInt() <em>Int</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInt()
	 * @generated
	 * @ordered
	 */
	protected String int_ = INT_EDEFAULT;

	/**
	 * The default value of the '{@link #getFirstInt() <em>First Int</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstInt()
	 * @generated
	 * @ordered
	 */
	protected static final String FIRST_INT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFirstInt() <em>First Int</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstInt()
	 * @generated
	 * @ordered
	 */
	protected String firstInt = FIRST_INT_EDEFAULT;

	/**
	 * The default value of the '{@link #getLastInt() <em>Last Int</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastInt()
	 * @generated
	 * @ordered
	 */
	protected static final String LAST_INT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastInt() <em>Last Int</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastInt()
	 * @generated
	 * @ordered
	 */
	protected String lastInt = LAST_INT_EDEFAULT;

	/**
	 * The default value of the '{@link #getIndexBits() <em>Index Bits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexBits()
	 * @generated
	 * @ordered
	 */
	protected static final String INDEX_BITS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIndexBits() <em>Index Bits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexBits()
	 * @generated
	 * @ordered
	 */
	protected String indexBits = INDEX_BITS_EDEFAULT;

	/**
	 * The default value of the '{@link #getFirstIndex() <em>First Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstIndex()
	 * @generated
	 * @ordered
	 */
	protected static final String FIRST_INDEX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFirstIndex() <em>First Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstIndex()
	 * @generated
	 * @ordered
	 */
	protected String firstIndex = FIRST_INDEX_EDEFAULT;

	/**
	 * The default value of the '{@link #getCountInt() <em>Count Int</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCountInt()
	 * @generated
	 * @ordered
	 */
	protected static final String COUNT_INT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCountInt() <em>Count Int</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCountInt()
	 * @generated
	 * @ordered
	 */
	protected String countInt = COUNT_INT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getKeys() <em>Keys</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeys()
	 * @generated
	 * @ordered
	 */
	protected EList<EKey> keys;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EKeyRangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ECRMLPackage.Literals.EKEY_RANGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRef() {
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRef(String newRef) {
		String oldRef = ref;
		ref = newRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECRMLPackage.EKEY_RANGE__REF, oldRef, ref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReadOnly() {
		return readOnly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReadOnly(boolean newReadOnly) {
		boolean oldReadOnly = readOnly;
		readOnly = newReadOnly;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECRMLPackage.EKEY_RANGE__READ_ONLY, oldReadOnly, readOnly));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EAccess> getAccess() {
		if (access == null) {
			access = new EObjectContainmentEList<EAccess>(EAccess.class, this, ECRMLPackage.EKEY_RANGE__ACCESS);
		}
		return access;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBackup() {
		return backup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBackup(boolean newBackup) {
		boolean oldBackup = backup;
		backup = newBackup;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECRMLPackage.EKEY_RANGE__BACKUP, oldBackup, backup));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ECRMLPackage.EKEY_RANGE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInt() {
		return int_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInt(String newInt) {
		String oldInt = int_;
		int_ = newInt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECRMLPackage.EKEY_RANGE__INT, oldInt, int_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFirstInt() {
		return firstInt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstInt(String newFirstInt) {
		String oldFirstInt = firstInt;
		firstInt = newFirstInt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECRMLPackage.EKEY_RANGE__FIRST_INT, oldFirstInt, firstInt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLastInt() {
		return lastInt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastInt(String newLastInt) {
		String oldLastInt = lastInt;
		lastInt = newLastInt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECRMLPackage.EKEY_RANGE__LAST_INT, oldLastInt, lastInt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIndexBits() {
		return indexBits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndexBits(String newIndexBits) {
		String oldIndexBits = indexBits;
		indexBits = newIndexBits;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECRMLPackage.EKEY_RANGE__INDEX_BITS, oldIndexBits, indexBits));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFirstIndex() {
		return firstIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstIndex(String newFirstIndex) {
		String oldFirstIndex = firstIndex;
		firstIndex = newFirstIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECRMLPackage.EKEY_RANGE__FIRST_INDEX, oldFirstIndex, firstIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCountInt() {
		return countInt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCountInt(String newCountInt) {
		String oldCountInt = countInt;
		countInt = newCountInt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECRMLPackage.EKEY_RANGE__COUNT_INT, oldCountInt, countInt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EKey> getKeys() {
		if (keys == null) {
			keys = new EObjectContainmentEList<EKey>(EKey.class, this, ECRMLPackage.EKEY_RANGE__KEYS);
		}
		return keys;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ECRMLPackage.EKEY_RANGE__ACCESS:
				return ((InternalEList<?>)getAccess()).basicRemove(otherEnd, msgs);
			case ECRMLPackage.EKEY_RANGE__KEYS:
				return ((InternalEList<?>)getKeys()).basicRemove(otherEnd, msgs);
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
			case ECRMLPackage.EKEY_RANGE__REF:
				return getRef();
			case ECRMLPackage.EKEY_RANGE__READ_ONLY:
				return isReadOnly() ? Boolean.TRUE : Boolean.FALSE;
			case ECRMLPackage.EKEY_RANGE__ACCESS:
				return getAccess();
			case ECRMLPackage.EKEY_RANGE__BACKUP:
				return isBackup() ? Boolean.TRUE : Boolean.FALSE;
			case ECRMLPackage.EKEY_RANGE__NAME:
				return getName();
			case ECRMLPackage.EKEY_RANGE__INT:
				return getInt();
			case ECRMLPackage.EKEY_RANGE__FIRST_INT:
				return getFirstInt();
			case ECRMLPackage.EKEY_RANGE__LAST_INT:
				return getLastInt();
			case ECRMLPackage.EKEY_RANGE__INDEX_BITS:
				return getIndexBits();
			case ECRMLPackage.EKEY_RANGE__FIRST_INDEX:
				return getFirstIndex();
			case ECRMLPackage.EKEY_RANGE__COUNT_INT:
				return getCountInt();
			case ECRMLPackage.EKEY_RANGE__KEYS:
				return getKeys();
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
			case ECRMLPackage.EKEY_RANGE__REF:
				setRef((String)newValue);
				return;
			case ECRMLPackage.EKEY_RANGE__READ_ONLY:
				setReadOnly(((Boolean)newValue).booleanValue());
				return;
			case ECRMLPackage.EKEY_RANGE__ACCESS:
				getAccess().clear();
				getAccess().addAll((Collection<? extends EAccess>)newValue);
				return;
			case ECRMLPackage.EKEY_RANGE__BACKUP:
				setBackup(((Boolean)newValue).booleanValue());
				return;
			case ECRMLPackage.EKEY_RANGE__NAME:
				setName((String)newValue);
				return;
			case ECRMLPackage.EKEY_RANGE__INT:
				setInt((String)newValue);
				return;
			case ECRMLPackage.EKEY_RANGE__FIRST_INT:
				setFirstInt((String)newValue);
				return;
			case ECRMLPackage.EKEY_RANGE__LAST_INT:
				setLastInt((String)newValue);
				return;
			case ECRMLPackage.EKEY_RANGE__INDEX_BITS:
				setIndexBits((String)newValue);
				return;
			case ECRMLPackage.EKEY_RANGE__FIRST_INDEX:
				setFirstIndex((String)newValue);
				return;
			case ECRMLPackage.EKEY_RANGE__COUNT_INT:
				setCountInt((String)newValue);
				return;
			case ECRMLPackage.EKEY_RANGE__KEYS:
				getKeys().clear();
				getKeys().addAll((Collection<? extends EKey>)newValue);
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
			case ECRMLPackage.EKEY_RANGE__REF:
				setRef(REF_EDEFAULT);
				return;
			case ECRMLPackage.EKEY_RANGE__READ_ONLY:
				setReadOnly(READ_ONLY_EDEFAULT);
				return;
			case ECRMLPackage.EKEY_RANGE__ACCESS:
				getAccess().clear();
				return;
			case ECRMLPackage.EKEY_RANGE__BACKUP:
				setBackup(BACKUP_EDEFAULT);
				return;
			case ECRMLPackage.EKEY_RANGE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ECRMLPackage.EKEY_RANGE__INT:
				setInt(INT_EDEFAULT);
				return;
			case ECRMLPackage.EKEY_RANGE__FIRST_INT:
				setFirstInt(FIRST_INT_EDEFAULT);
				return;
			case ECRMLPackage.EKEY_RANGE__LAST_INT:
				setLastInt(LAST_INT_EDEFAULT);
				return;
			case ECRMLPackage.EKEY_RANGE__INDEX_BITS:
				setIndexBits(INDEX_BITS_EDEFAULT);
				return;
			case ECRMLPackage.EKEY_RANGE__FIRST_INDEX:
				setFirstIndex(FIRST_INDEX_EDEFAULT);
				return;
			case ECRMLPackage.EKEY_RANGE__COUNT_INT:
				setCountInt(COUNT_INT_EDEFAULT);
				return;
			case ECRMLPackage.EKEY_RANGE__KEYS:
				getKeys().clear();
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
			case ECRMLPackage.EKEY_RANGE__REF:
				return REF_EDEFAULT == null ? ref != null : !REF_EDEFAULT.equals(ref);
			case ECRMLPackage.EKEY_RANGE__READ_ONLY:
				return readOnly != READ_ONLY_EDEFAULT;
			case ECRMLPackage.EKEY_RANGE__ACCESS:
				return access != null && !access.isEmpty();
			case ECRMLPackage.EKEY_RANGE__BACKUP:
				return backup != BACKUP_EDEFAULT;
			case ECRMLPackage.EKEY_RANGE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ECRMLPackage.EKEY_RANGE__INT:
				return INT_EDEFAULT == null ? int_ != null : !INT_EDEFAULT.equals(int_);
			case ECRMLPackage.EKEY_RANGE__FIRST_INT:
				return FIRST_INT_EDEFAULT == null ? firstInt != null : !FIRST_INT_EDEFAULT.equals(firstInt);
			case ECRMLPackage.EKEY_RANGE__LAST_INT:
				return LAST_INT_EDEFAULT == null ? lastInt != null : !LAST_INT_EDEFAULT.equals(lastInt);
			case ECRMLPackage.EKEY_RANGE__INDEX_BITS:
				return INDEX_BITS_EDEFAULT == null ? indexBits != null : !INDEX_BITS_EDEFAULT.equals(indexBits);
			case ECRMLPackage.EKEY_RANGE__FIRST_INDEX:
				return FIRST_INDEX_EDEFAULT == null ? firstIndex != null : !FIRST_INDEX_EDEFAULT.equals(firstIndex);
			case ECRMLPackage.EKEY_RANGE__COUNT_INT:
				return COUNT_INT_EDEFAULT == null ? countInt != null : !COUNT_INT_EDEFAULT.equals(countInt);
			case ECRMLPackage.EKEY_RANGE__KEYS:
				return keys != null && !keys.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ERefContainer.class) {
			switch (derivedFeatureID) {
				case ECRMLPackage.EKEY_RANGE__REF: return ECRMLPackage.EREF_CONTAINER__REF;
				default: return -1;
			}
		}
		if (baseClass == EReadOnly.class) {
			switch (derivedFeatureID) {
				case ECRMLPackage.EKEY_RANGE__READ_ONLY: return ECRMLPackage.EREAD_ONLY__READ_ONLY;
				default: return -1;
			}
		}
		if (baseClass == EAccessContainer.class) {
			switch (derivedFeatureID) {
				case ECRMLPackage.EKEY_RANGE__ACCESS: return ECRMLPackage.EACCESS_CONTAINER__ACCESS;
				default: return -1;
			}
		}
		if (baseClass == EBackup.class) {
			switch (derivedFeatureID) {
				case ECRMLPackage.EKEY_RANGE__BACKUP: return ECRMLPackage.EBACKUP__BACKUP;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ERefContainer.class) {
			switch (baseFeatureID) {
				case ECRMLPackage.EREF_CONTAINER__REF: return ECRMLPackage.EKEY_RANGE__REF;
				default: return -1;
			}
		}
		if (baseClass == EReadOnly.class) {
			switch (baseFeatureID) {
				case ECRMLPackage.EREAD_ONLY__READ_ONLY: return ECRMLPackage.EKEY_RANGE__READ_ONLY;
				default: return -1;
			}
		}
		if (baseClass == EAccessContainer.class) {
			switch (baseFeatureID) {
				case ECRMLPackage.EACCESS_CONTAINER__ACCESS: return ECRMLPackage.EKEY_RANGE__ACCESS;
				default: return -1;
			}
		}
		if (baseClass == EBackup.class) {
			switch (baseFeatureID) {
				case ECRMLPackage.EBACKUP__BACKUP: return ECRMLPackage.EKEY_RANGE__BACKUP;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (ref: ");
		result.append(ref);
		result.append(", readOnly: ");
		result.append(readOnly);
		result.append(", backup: ");
		result.append(backup);
		result.append(", name: ");
		result.append(name);
		result.append(", int: ");
		result.append(int_);
		result.append(", firstInt: ");
		result.append(firstInt);
		result.append(", lastInt: ");
		result.append(lastInt);
		result.append(", indexBits: ");
		result.append(indexBits);
		result.append(", firstIndex: ");
		result.append(firstIndex);
		result.append(", countInt: ");
		result.append(countInt);
		result.append(')');
		return result.toString();
	}

} //EKeyRangeImpl
