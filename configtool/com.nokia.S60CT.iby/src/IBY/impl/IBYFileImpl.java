/*
* Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
* All rights reserved.
* This component and the accompanying materials are made available
* under the terms of "Eclipse Public License v1.0"
* which accompanies this distribution, and is available
* at the URL "http://www.eclipse.org/legal/epl-v10.html".
*
* Initial Contributors:
* Nokia Corporation - initial contribution.
*
* Contributors:
*
* Description:
*
*/
package IBY.impl;

import IBY.Entry;
import IBY.FileName;
import IBY.IBYFile;
import IBY.IBYPackage;
import IBY.Location;
import IBY.SrcPath;
import IBY.TargetPath;

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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>File</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link IBY.impl.IBYFileImpl#getName <em>Name</em>}</li>
 *   <li>{@link IBY.impl.IBYFileImpl#getLocationt <em>Locationt</em>}</li>
 *   <li>{@link IBY.impl.IBYFileImpl#getEntries <em>Entries</em>}</li>
 *   <li>{@link IBY.impl.IBYFileImpl#getFlag <em>Flag</em>}</li>
 *   <li>{@link IBY.impl.IBYFileImpl#isValidContent <em>Valid Content</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IBYFileImpl extends EObjectImpl implements IBYFile {
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
	 * The cached value of the '{@link #getLocationt() <em>Locationt</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocationt()
	 * @generated
	 * @ordered
	 */
	protected Location locationt;

	/**
	 * The cached value of the '{@link #getEntries() <em>Entries</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntries()
	 * @generated
	 * @ordered
	 */
	protected EList<Entry> entries;

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
	 * The default value of the '{@link #isValidContent() <em>Valid Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValidContent()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VALID_CONTENT_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IBYFileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IBYPackage.Literals.IBY_FILE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, IBYPackage.IBY_FILE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Location getLocationt() {
		return locationt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLocationt(Location newLocationt, NotificationChain msgs) {
		Location oldLocationt = locationt;
		locationt = newLocationt;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IBYPackage.IBY_FILE__LOCATIONT, oldLocationt, newLocationt);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocationt(Location newLocationt) {
		if (newLocationt != locationt) {
			NotificationChain msgs = null;
			if (locationt != null)
				msgs = ((InternalEObject)locationt).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IBYPackage.IBY_FILE__LOCATIONT, null, msgs);
			if (newLocationt != null)
				msgs = ((InternalEObject)newLocationt).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IBYPackage.IBY_FILE__LOCATIONT, null, msgs);
			msgs = basicSetLocationt(newLocationt, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IBYPackage.IBY_FILE__LOCATIONT, newLocationt, newLocationt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Entry> getEntries() {
		if (entries == null) {
			entries = new EObjectContainmentEList<Entry>(Entry.class, this, IBYPackage.IBY_FILE__ENTRIES);
		}
		return entries;
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
			eNotify(new ENotificationImpl(this, Notification.SET, IBYPackage.IBY_FILE__FLAG, oldFlag, flag));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isValidContent() {
		for(Entry entry : getEntries()){
			FileName fileName = entry.getFileName();
			TargetPath targetPath = entry.getTarget();
			SrcPath srcPath = entry.getSource();
			
			if(fileName.getFiles()==null&&fileName.getGvalue()==null)return false;
			if(targetPath.getGvalue()==null)return false;
			if(srcPath.getGvalue()==null)return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void reset() {
		for(Entry entry : getEntries()){
			FileName fileName = entry.getFileName();
			TargetPath targetPath = entry.getTarget();
			SrcPath srcPath = entry.getSource();
			
			fileName.setFiles(null);
			fileName.setGvalue(null);
			targetPath.setGvalue(null);
			srcPath.setGvalue(null);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IBYPackage.IBY_FILE__LOCATIONT:
				return basicSetLocationt(null, msgs);
			case IBYPackage.IBY_FILE__ENTRIES:
				return ((InternalEList<?>)getEntries()).basicRemove(otherEnd, msgs);
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
			case IBYPackage.IBY_FILE__NAME:
				return getName();
			case IBYPackage.IBY_FILE__LOCATIONT:
				return getLocationt();
			case IBYPackage.IBY_FILE__ENTRIES:
				return getEntries();
			case IBYPackage.IBY_FILE__FLAG:
				return getFlag();
			case IBYPackage.IBY_FILE__VALID_CONTENT:
				return isValidContent() ? Boolean.TRUE : Boolean.FALSE;
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
			case IBYPackage.IBY_FILE__NAME:
				setName((String)newValue);
				return;
			case IBYPackage.IBY_FILE__LOCATIONT:
				setLocationt((Location)newValue);
				return;
			case IBYPackage.IBY_FILE__ENTRIES:
				getEntries().clear();
				getEntries().addAll((Collection<? extends Entry>)newValue);
				return;
			case IBYPackage.IBY_FILE__FLAG:
				setFlag((String)newValue);
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
			case IBYPackage.IBY_FILE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case IBYPackage.IBY_FILE__LOCATIONT:
				setLocationt((Location)null);
				return;
			case IBYPackage.IBY_FILE__ENTRIES:
				getEntries().clear();
				return;
			case IBYPackage.IBY_FILE__FLAG:
				setFlag(FLAG_EDEFAULT);
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
			case IBYPackage.IBY_FILE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case IBYPackage.IBY_FILE__LOCATIONT:
				return locationt != null;
			case IBYPackage.IBY_FILE__ENTRIES:
				return entries != null && !entries.isEmpty();
			case IBYPackage.IBY_FILE__FLAG:
				return FLAG_EDEFAULT == null ? flag != null : !FLAG_EDEFAULT.equals(flag);
			case IBYPackage.IBY_FILE__VALID_CONTENT:
				return isValidContent() != VALID_CONTENT_EDEFAULT;
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

} //IBYFileImpl
