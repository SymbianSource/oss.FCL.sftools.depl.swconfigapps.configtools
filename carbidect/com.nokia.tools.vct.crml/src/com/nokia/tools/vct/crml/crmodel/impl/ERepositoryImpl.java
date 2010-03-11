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
import com.nokia.tools.vct.crml.crmodel.EMeta;
import com.nokia.tools.vct.crml.crmodel.ERepository;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ERepository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.ERepositoryImpl#getAccess <em>Access</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.ERepositoryImpl#isBackup <em>Backup</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.ERepositoryImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.ERepositoryImpl#getUidName <em>Uid Name</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.ERepositoryImpl#getUidValue <em>Uid Value</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.ERepositoryImpl#getInitialisationFileVersion <em>Initialisation File Version</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.ERepositoryImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.ERepositoryImpl#isRfs <em>Rfs</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.ERepositoryImpl#getKey <em>Key</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.ERepositoryImpl#getMeta <em>Meta</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.ERepositoryImpl#getRangeKey <em>Range Key</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ERepositoryImpl extends EAttributeAndDescriptionImpl implements ERepository {
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
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getUidName() <em>Uid Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUidName()
	 * @generated
	 * @ordered
	 */
	protected static final String UID_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUidName() <em>Uid Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUidName()
	 * @generated
	 * @ordered
	 */
	protected String uidName = UID_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getUidValue() <em>Uid Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUidValue()
	 * @generated
	 * @ordered
	 */
	protected static final String UID_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUidValue() <em>Uid Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUidValue()
	 * @generated
	 * @ordered
	 */
	protected String uidValue = UID_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getInitialisationFileVersion() <em>Initialisation File Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialisationFileVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String INITIALISATION_FILE_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInitialisationFileVersion() <em>Initialisation File Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialisationFileVersion()
	 * @generated
	 * @ordered
	 */
	protected String initialisationFileVersion = INITIALISATION_FILE_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getOwner() <em>Owner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwner()
	 * @generated
	 * @ordered
	 */
	protected static final String OWNER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOwner() <em>Owner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwner()
	 * @generated
	 * @ordered
	 */
	protected String owner = OWNER_EDEFAULT;

	/**
	 * The default value of the '{@link #isRfs() <em>Rfs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRfs()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RFS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRfs() <em>Rfs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRfs()
	 * @generated
	 * @ordered
	 */
	protected boolean rfs = RFS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getKey() <em>Key</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
	protected EList<EKey> key;

	/**
	 * The cached value of the '{@link #getMeta() <em>Meta</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeta()
	 * @generated
	 * @ordered
	 */
	protected EMeta meta;

	/**
	 * The cached value of the '{@link #getRangeKey() <em>Range Key</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRangeKey()
	 * @generated
	 * @ordered
	 */
	protected EList<EKeyRange> rangeKey;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ERepositoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ECRMLPackage.Literals.EREPOSITORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EAccess> getAccess() {
		if (access == null) {
			access = new EObjectContainmentEList<EAccess>(EAccess.class, this, ECRMLPackage.EREPOSITORY__ACCESS);
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
			eNotify(new ENotificationImpl(this, Notification.SET, ECRMLPackage.EREPOSITORY__BACKUP, oldBackup, backup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECRMLPackage.EREPOSITORY__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUidName() {
		return uidName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUidName(String newUidName) {
		String oldUidName = uidName;
		uidName = newUidName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECRMLPackage.EREPOSITORY__UID_NAME, oldUidName, uidName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUidValue() {
		return uidValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUidValue(String newUidValue) {
		String oldUidValue = uidValue;
		uidValue = newUidValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECRMLPackage.EREPOSITORY__UID_VALUE, oldUidValue, uidValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInitialisationFileVersion() {
		return initialisationFileVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialisationFileVersion(String newInitialisationFileVersion) {
		String oldInitialisationFileVersion = initialisationFileVersion;
		initialisationFileVersion = newInitialisationFileVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECRMLPackage.EREPOSITORY__INITIALISATION_FILE_VERSION, oldInitialisationFileVersion, initialisationFileVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(String newOwner) {
		String oldOwner = owner;
		owner = newOwner;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECRMLPackage.EREPOSITORY__OWNER, oldOwner, owner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRfs() {
		return rfs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRfs(boolean newRfs) {
		boolean oldRfs = rfs;
		rfs = newRfs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECRMLPackage.EREPOSITORY__RFS, oldRfs, rfs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EKey> getKey() {
		if (key == null) {
			key = new EObjectContainmentEList<EKey>(EKey.class, this, ECRMLPackage.EREPOSITORY__KEY);
		}
		return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMeta getMeta() {
		return meta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMeta(EMeta newMeta, NotificationChain msgs) {
		EMeta oldMeta = meta;
		meta = newMeta;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ECRMLPackage.EREPOSITORY__META, oldMeta, newMeta);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeta(EMeta newMeta) {
		if (newMeta != meta) {
			NotificationChain msgs = null;
			if (meta != null)
				msgs = ((InternalEObject)meta).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ECRMLPackage.EREPOSITORY__META, null, msgs);
			if (newMeta != null)
				msgs = ((InternalEObject)newMeta).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ECRMLPackage.EREPOSITORY__META, null, msgs);
			msgs = basicSetMeta(newMeta, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECRMLPackage.EREPOSITORY__META, newMeta, newMeta));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EKeyRange> getRangeKey() {
		if (rangeKey == null) {
			rangeKey = new EObjectContainmentEList<EKeyRange>(EKeyRange.class, this, ECRMLPackage.EREPOSITORY__RANGE_KEY);
		}
		return rangeKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ECRMLPackage.EREPOSITORY__ACCESS:
				return ((InternalEList<?>)getAccess()).basicRemove(otherEnd, msgs);
			case ECRMLPackage.EREPOSITORY__KEY:
				return ((InternalEList<?>)getKey()).basicRemove(otherEnd, msgs);
			case ECRMLPackage.EREPOSITORY__META:
				return basicSetMeta(null, msgs);
			case ECRMLPackage.EREPOSITORY__RANGE_KEY:
				return ((InternalEList<?>)getRangeKey()).basicRemove(otherEnd, msgs);
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
			case ECRMLPackage.EREPOSITORY__ACCESS:
				return getAccess();
			case ECRMLPackage.EREPOSITORY__BACKUP:
				return isBackup() ? Boolean.TRUE : Boolean.FALSE;
			case ECRMLPackage.EREPOSITORY__VERSION:
				return getVersion();
			case ECRMLPackage.EREPOSITORY__UID_NAME:
				return getUidName();
			case ECRMLPackage.EREPOSITORY__UID_VALUE:
				return getUidValue();
			case ECRMLPackage.EREPOSITORY__INITIALISATION_FILE_VERSION:
				return getInitialisationFileVersion();
			case ECRMLPackage.EREPOSITORY__OWNER:
				return getOwner();
			case ECRMLPackage.EREPOSITORY__RFS:
				return isRfs() ? Boolean.TRUE : Boolean.FALSE;
			case ECRMLPackage.EREPOSITORY__KEY:
				return getKey();
			case ECRMLPackage.EREPOSITORY__META:
				return getMeta();
			case ECRMLPackage.EREPOSITORY__RANGE_KEY:
				return getRangeKey();
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
			case ECRMLPackage.EREPOSITORY__ACCESS:
				getAccess().clear();
				getAccess().addAll((Collection<? extends EAccess>)newValue);
				return;
			case ECRMLPackage.EREPOSITORY__BACKUP:
				setBackup(((Boolean)newValue).booleanValue());
				return;
			case ECRMLPackage.EREPOSITORY__VERSION:
				setVersion((String)newValue);
				return;
			case ECRMLPackage.EREPOSITORY__UID_NAME:
				setUidName((String)newValue);
				return;
			case ECRMLPackage.EREPOSITORY__UID_VALUE:
				setUidValue((String)newValue);
				return;
			case ECRMLPackage.EREPOSITORY__INITIALISATION_FILE_VERSION:
				setInitialisationFileVersion((String)newValue);
				return;
			case ECRMLPackage.EREPOSITORY__OWNER:
				setOwner((String)newValue);
				return;
			case ECRMLPackage.EREPOSITORY__RFS:
				setRfs(((Boolean)newValue).booleanValue());
				return;
			case ECRMLPackage.EREPOSITORY__KEY:
				getKey().clear();
				getKey().addAll((Collection<? extends EKey>)newValue);
				return;
			case ECRMLPackage.EREPOSITORY__META:
				setMeta((EMeta)newValue);
				return;
			case ECRMLPackage.EREPOSITORY__RANGE_KEY:
				getRangeKey().clear();
				getRangeKey().addAll((Collection<? extends EKeyRange>)newValue);
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
			case ECRMLPackage.EREPOSITORY__ACCESS:
				getAccess().clear();
				return;
			case ECRMLPackage.EREPOSITORY__BACKUP:
				setBackup(BACKUP_EDEFAULT);
				return;
			case ECRMLPackage.EREPOSITORY__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case ECRMLPackage.EREPOSITORY__UID_NAME:
				setUidName(UID_NAME_EDEFAULT);
				return;
			case ECRMLPackage.EREPOSITORY__UID_VALUE:
				setUidValue(UID_VALUE_EDEFAULT);
				return;
			case ECRMLPackage.EREPOSITORY__INITIALISATION_FILE_VERSION:
				setInitialisationFileVersion(INITIALISATION_FILE_VERSION_EDEFAULT);
				return;
			case ECRMLPackage.EREPOSITORY__OWNER:
				setOwner(OWNER_EDEFAULT);
				return;
			case ECRMLPackage.EREPOSITORY__RFS:
				setRfs(RFS_EDEFAULT);
				return;
			case ECRMLPackage.EREPOSITORY__KEY:
				getKey().clear();
				return;
			case ECRMLPackage.EREPOSITORY__META:
				setMeta((EMeta)null);
				return;
			case ECRMLPackage.EREPOSITORY__RANGE_KEY:
				getRangeKey().clear();
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
			case ECRMLPackage.EREPOSITORY__ACCESS:
				return access != null && !access.isEmpty();
			case ECRMLPackage.EREPOSITORY__BACKUP:
				return backup != BACKUP_EDEFAULT;
			case ECRMLPackage.EREPOSITORY__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case ECRMLPackage.EREPOSITORY__UID_NAME:
				return UID_NAME_EDEFAULT == null ? uidName != null : !UID_NAME_EDEFAULT.equals(uidName);
			case ECRMLPackage.EREPOSITORY__UID_VALUE:
				return UID_VALUE_EDEFAULT == null ? uidValue != null : !UID_VALUE_EDEFAULT.equals(uidValue);
			case ECRMLPackage.EREPOSITORY__INITIALISATION_FILE_VERSION:
				return INITIALISATION_FILE_VERSION_EDEFAULT == null ? initialisationFileVersion != null : !INITIALISATION_FILE_VERSION_EDEFAULT.equals(initialisationFileVersion);
			case ECRMLPackage.EREPOSITORY__OWNER:
				return OWNER_EDEFAULT == null ? owner != null : !OWNER_EDEFAULT.equals(owner);
			case ECRMLPackage.EREPOSITORY__RFS:
				return rfs != RFS_EDEFAULT;
			case ECRMLPackage.EREPOSITORY__KEY:
				return key != null && !key.isEmpty();
			case ECRMLPackage.EREPOSITORY__META:
				return meta != null;
			case ECRMLPackage.EREPOSITORY__RANGE_KEY:
				return rangeKey != null && !rangeKey.isEmpty();
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
		if (baseClass == EAccessContainer.class) {
			switch (derivedFeatureID) {
				case ECRMLPackage.EREPOSITORY__ACCESS: return ECRMLPackage.EACCESS_CONTAINER__ACCESS;
				default: return -1;
			}
		}
		if (baseClass == EBackup.class) {
			switch (derivedFeatureID) {
				case ECRMLPackage.EREPOSITORY__BACKUP: return ECRMLPackage.EBACKUP__BACKUP;
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
		if (baseClass == EAccessContainer.class) {
			switch (baseFeatureID) {
				case ECRMLPackage.EACCESS_CONTAINER__ACCESS: return ECRMLPackage.EREPOSITORY__ACCESS;
				default: return -1;
			}
		}
		if (baseClass == EBackup.class) {
			switch (baseFeatureID) {
				case ECRMLPackage.EBACKUP__BACKUP: return ECRMLPackage.EREPOSITORY__BACKUP;
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
		result.append(" (backup: ");
		result.append(backup);
		result.append(", version: ");
		result.append(version);
		result.append(", uidName: ");
		result.append(uidName);
		result.append(", uidValue: ");
		result.append(uidValue);
		result.append(", initialisationFileVersion: ");
		result.append(initialisationFileVersion);
		result.append(", owner: ");
		result.append(owner);
		result.append(", rfs: ");
		result.append(rfs);
		result.append(')');
		return result.toString();
	}

} //ERepositoryImpl
