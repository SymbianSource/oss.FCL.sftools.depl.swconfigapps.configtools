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
 * Description: This file is part of com.nokia.tools.variant.resourcelibrary component.
 */

package com.nokia.tools.variant.resourcelibrary.model.impl;

import java.io.File;
import java.util.Collection;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.resourcelibrary.model.Directory;
import com.nokia.tools.variant.resourcelibrary.model.FileSystemElement;
import com.nokia.tools.variant.resourcelibrary.model.ResourceModelRoot;
import com.nokia.tools.variant.resourcelibrary.model.resourcesPackage;


/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>File System Element</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.resourcelibrary.model.impl.FileSystemElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.variant.resourcelibrary.model.impl.FileSystemElementImpl#getSettings <em>Settings</em>}</li>
 *   <li>{@link com.nokia.tools.variant.resourcelibrary.model.impl.FileSystemElementImpl#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link com.nokia.tools.variant.resourcelibrary.model.impl.FileSystemElementImpl#getNote <em>Note</em>}</li>
 *   <li>{@link com.nokia.tools.variant.resourcelibrary.model.impl.FileSystemElementImpl#getTimestamp <em>Timestamp</em>}</li>
 *   <li>{@link com.nokia.tools.variant.resourcelibrary.model.impl.FileSystemElementImpl#getPath2 <em>Path2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class FileSystemElementImpl extends EObjectImpl implements
		FileSystemElement {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSettings() <em>Settings</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSettings()
	 * @generated
	 * @ordered
	 */
	protected EList<Setting> settings;

	/**
	 * The default value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isReadOnly()
	 * @generated
	 * @ordered
	 */
	protected static final boolean READ_ONLY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isReadOnly()
	 * @generated
	 * @ordered
	 */
	protected boolean readOnly = READ_ONLY_EDEFAULT;

	/**
	 * The default value of the '{@link #getNote() <em>Note</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNote()
	 * @generated
	 * @ordered
	 */
	protected static final String NOTE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNote() <em>Note</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNote()
	 * @generated
	 * @ordered
	 */
	protected String note = NOTE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimestamp() <em>Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimestamp()
	 * @generated
	 * @ordered
	 */
	protected static final long TIMESTAMP_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getTimestamp() <em>Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimestamp()
	 * @generated
	 * @ordered
	 */
	protected long timestamp = TIMESTAMP_EDEFAULT;

	/**
	 * The default value of the '{@link #getPath2() <em>Path2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath2()
	 * @generated
	 * @ordered
	 */
	protected static final IPath PATH2_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected FileSystemElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return resourcesPackage.Literals.FILE_SYSTEM_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, resourcesPackage.FILE_SYSTEM_ELEMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Setting> getSettings() {
		if (settings == null) {
			settings = new EObjectResolvingEList<Setting>(Setting.class, this, resourcesPackage.FILE_SYSTEM_ELEMENT__SETTINGS);
		}
		return settings;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReadOnly() {
		return readOnly;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setReadOnly(boolean newReadOnly) {
		boolean oldReadOnly = readOnly;
		readOnly = newReadOnly;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, resourcesPackage.FILE_SYSTEM_ELEMENT__READ_ONLY, oldReadOnly, readOnly));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNote() {
		return note;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNote(String newNote) {
		String oldNote = note;
		note = newNote;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, resourcesPackage.FILE_SYSTEM_ELEMENT__NOTE, oldNote, note));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getTimestamp() {
		return timestamp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimestamp(long newTimestamp) {
		long oldTimestamp = timestamp;
		timestamp = newTimestamp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, resourcesPackage.FILE_SYSTEM_ELEMENT__TIMESTAMP, oldTimestamp, timestamp));
	}

	/**
	 * Compute path
	 */
	public IPath getPath2() {
		if (this instanceof ResourceModelRoot) {
			return Path.EMPTY;
		}

		if (this.eContainer() instanceof FileSystemElement) {
			return ((FileSystemElement)eContainer()).getPath2().append(getName());
		}
		
		throw new IllegalStateException("The path is not available when the object is outside model root");
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 */
	public String getPath() {
		return getPath2().toOSString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	@Deprecated
	public String getFullPath() {
		if (this instanceof ResourceModelRoot) {
			return ((ResourceModelRoot) this).getTempDirPath();
		} else if (eContainer != null
				&& eContainer instanceof FileSystemElement) {
			FileSystemElement parent = (FileSystemElement) eContainer;
			if (name != null) {
				String pPath = parent.getFullPath();
				if (pPath != null) {
					return pPath.concat(File.separator).concat(name);
				} else {
					return name;
				}
			} else {
				return null;
			}

		}
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	@Deprecated
	public boolean delete() {
		if (eContainer !=null && eContainer instanceof Directory){
			return ((Directory)eContainer()).getChildren().remove(this);
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 */
	@Deprecated
	public boolean move(Directory target) {
		return target.addChild(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Deprecated
	public boolean copy(Directory target) {
		
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * Computes if this element is toughed by readOnly setting, so it cannot be deleted and modified.
	 */
	public boolean touchedByReadonlySetting() {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case resourcesPackage.FILE_SYSTEM_ELEMENT__NAME:
				return getName();
			case resourcesPackage.FILE_SYSTEM_ELEMENT__SETTINGS:
				return getSettings();
			case resourcesPackage.FILE_SYSTEM_ELEMENT__READ_ONLY:
				return isReadOnly() ? Boolean.TRUE : Boolean.FALSE;
			case resourcesPackage.FILE_SYSTEM_ELEMENT__NOTE:
				return getNote();
			case resourcesPackage.FILE_SYSTEM_ELEMENT__TIMESTAMP:
				return new Long(getTimestamp());
			case resourcesPackage.FILE_SYSTEM_ELEMENT__PATH2:
				return getPath2();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case resourcesPackage.FILE_SYSTEM_ELEMENT__NAME:
				setName((String)newValue);
				return;
			case resourcesPackage.FILE_SYSTEM_ELEMENT__SETTINGS:
				getSettings().clear();
				getSettings().addAll((Collection<? extends Setting>)newValue);
				return;
			case resourcesPackage.FILE_SYSTEM_ELEMENT__READ_ONLY:
				setReadOnly(((Boolean)newValue).booleanValue());
				return;
			case resourcesPackage.FILE_SYSTEM_ELEMENT__NOTE:
				setNote((String)newValue);
				return;
			case resourcesPackage.FILE_SYSTEM_ELEMENT__TIMESTAMP:
				setTimestamp(((Long)newValue).longValue());
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case resourcesPackage.FILE_SYSTEM_ELEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case resourcesPackage.FILE_SYSTEM_ELEMENT__SETTINGS:
				getSettings().clear();
				return;
			case resourcesPackage.FILE_SYSTEM_ELEMENT__READ_ONLY:
				setReadOnly(READ_ONLY_EDEFAULT);
				return;
			case resourcesPackage.FILE_SYSTEM_ELEMENT__NOTE:
				setNote(NOTE_EDEFAULT);
				return;
			case resourcesPackage.FILE_SYSTEM_ELEMENT__TIMESTAMP:
				setTimestamp(TIMESTAMP_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case resourcesPackage.FILE_SYSTEM_ELEMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case resourcesPackage.FILE_SYSTEM_ELEMENT__SETTINGS:
				return settings != null && !settings.isEmpty();
			case resourcesPackage.FILE_SYSTEM_ELEMENT__READ_ONLY:
				return readOnly != READ_ONLY_EDEFAULT;
			case resourcesPackage.FILE_SYSTEM_ELEMENT__NOTE:
				return NOTE_EDEFAULT == null ? note != null : !NOTE_EDEFAULT.equals(note);
			case resourcesPackage.FILE_SYSTEM_ELEMENT__TIMESTAMP:
				return timestamp != TIMESTAMP_EDEFAULT;
			case resourcesPackage.FILE_SYSTEM_ELEMENT__PATH2:
				return PATH2_EDEFAULT == null ? getPath2() != null : !PATH2_EDEFAULT.equals(getPath2());
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", readOnly: ");
		result.append(readOnly);
		result.append(", note: ");
		result.append(note);
		result.append(", timestamp: ");
		result.append(timestamp);
		result.append(')');
		return result.toString();
	}

} // FileSystemElementImpl
