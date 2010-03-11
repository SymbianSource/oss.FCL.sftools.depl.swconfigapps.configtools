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
import com.nokia.tools.vct.crml.crmodel.EBit;
import com.nokia.tools.vct.crml.crmodel.ECRMLPackage;
import com.nokia.tools.vct.crml.crmodel.EKey;
import com.nokia.tools.vct.crml.crmodel.EKeyType;
import com.nokia.tools.vct.crml.crmodel.EReadOnly;
import com.nokia.tools.vct.crml.crmodel.ERefContainer;
import com.nokia.tools.vct.crml.crmodel.EValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EKey</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.EKeyImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.EKeyImpl#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.EKeyImpl#getAccess <em>Access</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.EKeyImpl#isBackup <em>Backup</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.EKeyImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.EKeyImpl#getIdent <em>Ident</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.EKeyImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.EKeyImpl#getValue <em>Value</em>}</li>
 *   <li>{@link com.nokia.tools.vct.crml.crmodel.impl.EKeyImpl#getBits <em>Bits</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EKeyImpl extends EAttributeAndDescriptionImpl implements EKey {
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
	 * The default value of the '{@link #getIdent() <em>Ident</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdent()
	 * @generated
	 * @ordered
	 */
	protected static final String IDENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdent() <em>Ident</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdent()
	 * @generated
	 * @ordered
	 */
	protected String ident = IDENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final EKeyType TYPE_EDEFAULT = EKeyType.INT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EKeyType type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected EList<EValue> value;

	/**
	 * The cached value of the '{@link #getBits() <em>Bits</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBits()
	 * @generated
	 * @ordered
	 */
	protected EList<EBit> bits;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EKeyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ECRMLPackage.Literals.EKEY;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ECRMLPackage.EKEY__REF, oldRef, ref));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ECRMLPackage.EKEY__READ_ONLY, oldReadOnly, readOnly));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EAccess> getAccess() {
		if (access == null) {
			access = new EObjectContainmentEList<EAccess>(EAccess.class, this, ECRMLPackage.EKEY__ACCESS);
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
			eNotify(new ENotificationImpl(this, Notification.SET, ECRMLPackage.EKEY__BACKUP, oldBackup, backup));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ECRMLPackage.EKEY__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdent() {
		return ident;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdent(String newIdent) {
		String oldIdent = ident;
		ident = newIdent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECRMLPackage.EKEY__IDENT, oldIdent, ident));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EKeyType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(EKeyType newType) {
		EKeyType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ECRMLPackage.EKEY__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EValue> getValue() {
		if (value == null) {
			value = new EObjectContainmentEList<EValue>(EValue.class, this, ECRMLPackage.EKEY__VALUE);
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EBit> getBits() {
		if (bits == null) {
			bits = new EObjectContainmentEList<EBit>(EBit.class, this, ECRMLPackage.EKEY__BITS);
		}
		return bits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ECRMLPackage.EKEY__ACCESS:
				return ((InternalEList<?>)getAccess()).basicRemove(otherEnd, msgs);
			case ECRMLPackage.EKEY__VALUE:
				return ((InternalEList<?>)getValue()).basicRemove(otherEnd, msgs);
			case ECRMLPackage.EKEY__BITS:
				return ((InternalEList<?>)getBits()).basicRemove(otherEnd, msgs);
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
			case ECRMLPackage.EKEY__REF:
				return getRef();
			case ECRMLPackage.EKEY__READ_ONLY:
				return isReadOnly() ? Boolean.TRUE : Boolean.FALSE;
			case ECRMLPackage.EKEY__ACCESS:
				return getAccess();
			case ECRMLPackage.EKEY__BACKUP:
				return isBackup() ? Boolean.TRUE : Boolean.FALSE;
			case ECRMLPackage.EKEY__NAME:
				return getName();
			case ECRMLPackage.EKEY__IDENT:
				return getIdent();
			case ECRMLPackage.EKEY__TYPE:
				return getType();
			case ECRMLPackage.EKEY__VALUE:
				return getValue();
			case ECRMLPackage.EKEY__BITS:
				return getBits();
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
			case ECRMLPackage.EKEY__REF:
				setRef((String)newValue);
				return;
			case ECRMLPackage.EKEY__READ_ONLY:
				setReadOnly(((Boolean)newValue).booleanValue());
				return;
			case ECRMLPackage.EKEY__ACCESS:
				getAccess().clear();
				getAccess().addAll((Collection<? extends EAccess>)newValue);
				return;
			case ECRMLPackage.EKEY__BACKUP:
				setBackup(((Boolean)newValue).booleanValue());
				return;
			case ECRMLPackage.EKEY__NAME:
				setName((String)newValue);
				return;
			case ECRMLPackage.EKEY__IDENT:
				setIdent((String)newValue);
				return;
			case ECRMLPackage.EKEY__TYPE:
				setType((EKeyType)newValue);
				return;
			case ECRMLPackage.EKEY__VALUE:
				getValue().clear();
				getValue().addAll((Collection<? extends EValue>)newValue);
				return;
			case ECRMLPackage.EKEY__BITS:
				getBits().clear();
				getBits().addAll((Collection<? extends EBit>)newValue);
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
			case ECRMLPackage.EKEY__REF:
				setRef(REF_EDEFAULT);
				return;
			case ECRMLPackage.EKEY__READ_ONLY:
				setReadOnly(READ_ONLY_EDEFAULT);
				return;
			case ECRMLPackage.EKEY__ACCESS:
				getAccess().clear();
				return;
			case ECRMLPackage.EKEY__BACKUP:
				setBackup(BACKUP_EDEFAULT);
				return;
			case ECRMLPackage.EKEY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ECRMLPackage.EKEY__IDENT:
				setIdent(IDENT_EDEFAULT);
				return;
			case ECRMLPackage.EKEY__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ECRMLPackage.EKEY__VALUE:
				getValue().clear();
				return;
			case ECRMLPackage.EKEY__BITS:
				getBits().clear();
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
			case ECRMLPackage.EKEY__REF:
				return REF_EDEFAULT == null ? ref != null : !REF_EDEFAULT.equals(ref);
			case ECRMLPackage.EKEY__READ_ONLY:
				return readOnly != READ_ONLY_EDEFAULT;
			case ECRMLPackage.EKEY__ACCESS:
				return access != null && !access.isEmpty();
			case ECRMLPackage.EKEY__BACKUP:
				return backup != BACKUP_EDEFAULT;
			case ECRMLPackage.EKEY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ECRMLPackage.EKEY__IDENT:
				return IDENT_EDEFAULT == null ? ident != null : !IDENT_EDEFAULT.equals(ident);
			case ECRMLPackage.EKEY__TYPE:
				return type != TYPE_EDEFAULT;
			case ECRMLPackage.EKEY__VALUE:
				return value != null && !value.isEmpty();
			case ECRMLPackage.EKEY__BITS:
				return bits != null && !bits.isEmpty();
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
				case ECRMLPackage.EKEY__REF: return ECRMLPackage.EREF_CONTAINER__REF;
				default: return -1;
			}
		}
		if (baseClass == EReadOnly.class) {
			switch (derivedFeatureID) {
				case ECRMLPackage.EKEY__READ_ONLY: return ECRMLPackage.EREAD_ONLY__READ_ONLY;
				default: return -1;
			}
		}
		if (baseClass == EAccessContainer.class) {
			switch (derivedFeatureID) {
				case ECRMLPackage.EKEY__ACCESS: return ECRMLPackage.EACCESS_CONTAINER__ACCESS;
				default: return -1;
			}
		}
		if (baseClass == EBackup.class) {
			switch (derivedFeatureID) {
				case ECRMLPackage.EKEY__BACKUP: return ECRMLPackage.EBACKUP__BACKUP;
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
				case ECRMLPackage.EREF_CONTAINER__REF: return ECRMLPackage.EKEY__REF;
				default: return -1;
			}
		}
		if (baseClass == EReadOnly.class) {
			switch (baseFeatureID) {
				case ECRMLPackage.EREAD_ONLY__READ_ONLY: return ECRMLPackage.EKEY__READ_ONLY;
				default: return -1;
			}
		}
		if (baseClass == EAccessContainer.class) {
			switch (baseFeatureID) {
				case ECRMLPackage.EACCESS_CONTAINER__ACCESS: return ECRMLPackage.EKEY__ACCESS;
				default: return -1;
			}
		}
		if (baseClass == EBackup.class) {
			switch (baseFeatureID) {
				case ECRMLPackage.EBACKUP__BACKUP: return ECRMLPackage.EKEY__BACKUP;
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
		result.append(", ident: ");
		result.append(ident);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //EKeyImpl
