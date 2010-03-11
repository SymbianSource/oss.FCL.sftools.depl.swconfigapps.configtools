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
package cenrep.impl;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import cenrep.ACCESS_TYPE;
import cenrep.Access;
import cenrep.CenrepPackage;
import cenrep.IAccessable;
import cenrep.IBackup;
import cenrep.IReadOnly;
import cenrep.Key;
import cenrep.KeyRange;
import cenrep.RVG;
import cenrep.util.KeyRangeManager;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Key Range</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cenrep.impl.KeyRangeImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link cenrep.impl.KeyRangeImpl#getGvalue <em>Gvalue</em>}</li>
 *   <li>{@link cenrep.impl.KeyRangeImpl#isRfs <em>Rfs</em>}</li>
 *   <li>{@link cenrep.impl.KeyRangeImpl#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link cenrep.impl.KeyRangeImpl#getAccess <em>Access</em>}</li>
 *   <li>{@link cenrep.impl.KeyRangeImpl#getReadAccess <em>Read Access</em>}</li>
 *   <li>{@link cenrep.impl.KeyRangeImpl#getWriteAccess <em>Write Access</em>}</li>
 *   <li>{@link cenrep.impl.KeyRangeImpl#getGAccess <em>GAccess</em>}</li>
 *   <li>{@link cenrep.impl.KeyRangeImpl#isBackup <em>Backup</em>}</li>
 *   <li>{@link cenrep.impl.KeyRangeImpl#getName <em>Name</em>}</li>
 *   <li>{@link cenrep.impl.KeyRangeImpl#getInt <em>Int</em>}</li>
 *   <li>{@link cenrep.impl.KeyRangeImpl#getFirstInt <em>First Int</em>}</li>
 *   <li>{@link cenrep.impl.KeyRangeImpl#getLastInt <em>Last Int</em>}</li>
 *   <li>{@link cenrep.impl.KeyRangeImpl#getIndexBits <em>Index Bits</em>}</li>
 *   <li>{@link cenrep.impl.KeyRangeImpl#getFirstIndex <em>First Index</em>}</li>
 *   <li>{@link cenrep.impl.KeyRangeImpl#getCountInt <em>Count Int</em>}</li>
 *   <li>{@link cenrep.impl.KeyRangeImpl#getKeys <em>Keys</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class KeyRangeImpl extends AttributeAndDescriptionImpl implements KeyRange {
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
	 * The default value of the '{@link #getGvalue() <em>Gvalue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGvalue()
	 * @generated
	 * @ordered
	 */
	protected static final Object GVALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGvalue() <em>Gvalue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGvalue()
	 * @generated
	 * @ordered
	 */
	protected Object gvalue = GVALUE_EDEFAULT;

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
	protected EList<Access> access;

	/**
	 * The default value of the '{@link #getGAccess() <em>GAccess</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGAccess()
	 * @generated
	 * @ordered
	 */
	protected static final String GACCESS_EDEFAULT = null;

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
	protected EList<Key> keys;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected KeyRangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CenrepPackage.Literals.KEY_RANGE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.KEY_RANGE__REF, oldRef, ref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getGvalue() {
		return gvalue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGvalue(Object newGvalue) {
		Object oldGvalue = gvalue;
		gvalue = newGvalue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.KEY_RANGE__GVALUE, oldGvalue, gvalue));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.KEY_RANGE__RFS, oldRfs, rfs));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.KEY_RANGE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.KEY_RANGE__INT, oldInt, int_));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.KEY_RANGE__FIRST_INT, oldFirstInt, firstInt));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.KEY_RANGE__LAST_INT, oldLastInt, lastInt));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.KEY_RANGE__INDEX_BITS, oldIndexBits, indexBits));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.KEY_RANGE__FIRST_INDEX, oldFirstIndex, firstIndex));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.KEY_RANGE__COUNT_INT, oldCountInt, countInt));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.KEY_RANGE__READ_ONLY, oldReadOnly, readOnly));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.KEY_RANGE__BACKUP, oldBackup, backup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Key> getKeys() {
		if (keys == null) {
			keys = new EObjectContainmentEList<Key>(Key.class, this, CenrepPackage.KEY_RANGE__KEYS);
		}
		return keys;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Key> getGKeys() {
		EList<Key> gKeys = new BasicEList<Key>();
		//1. validate range
		if(KeyRangeManager.INSTANCE.isRangeValid(this)){
			if(getGvalue()!=null&&getGvalue() instanceof Object[][]){
				Object[][] gValue = (Object[][])getGvalue();
				for(int fix=1;fix<gValue[0].length;fix++){
					Key[] keys = KeyRangeManager.INSTANCE.createKeysIndex(this,fix-1);
					KeyRangeManager.INSTANCE.setKeyGValues(keys, gValue, fix);
					gKeys.addAll(Arrays.asList(keys));
				}
				Key countKey = KeyRangeManager.INSTANCE.createCountKey(this, gValue[0].length-1);
				if(countKey!=null){
					gKeys.add(countKey);
				}
			}
		}
		return gKeys;
	}

	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Access> getAccess() {
		if (access == null) {
			access = new EObjectContainmentEList<Access>(Access.class, this, CenrepPackage.KEY_RANGE__ACCESS);
		}
		return access;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Access getReadAccess() {
		for(Access access : this.getAccess()){
			if(access.getType()==ACCESS_TYPE.READ)
				return access;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setReadAccess(Access newReadAccess) {
		newReadAccess.setType(ACCESS_TYPE.READ);
		Access currentRAccess = getReadAccess();
		if(currentRAccess!=null)
			getAccess().remove(currentRAccess);
		this.getAccess().add(newReadAccess);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Access getWriteAccess() {
		for(Access access : this.getAccess()){
			if(access.getType()==ACCESS_TYPE.WRITE)
				return access;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setWriteAccess(Access newWriteAccess) {
		newWriteAccess.setType(ACCESS_TYPE.WRITE);
		Access currentWAccess = getWriteAccess();
		if(currentWAccess!=null)
			getAccess().remove(currentWAccess);
		this.getAccess().add(newWriteAccess);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGAccess() {
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean canGenerate() {
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setGConf(String confName) {
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setPriority(String prio) {
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getFolder() {
		return "test";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getGPriority() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CenrepPackage.KEY_RANGE__ACCESS:
				return ((InternalEList<?>)getAccess()).basicRemove(otherEnd, msgs);
			case CenrepPackage.KEY_RANGE__KEYS:
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
			case CenrepPackage.KEY_RANGE__REF:
				return getRef();
			case CenrepPackage.KEY_RANGE__GVALUE:
				return getGvalue();
			case CenrepPackage.KEY_RANGE__RFS:
				return isRfs() ? Boolean.TRUE : Boolean.FALSE;
			case CenrepPackage.KEY_RANGE__READ_ONLY:
				return isReadOnly() ? Boolean.TRUE : Boolean.FALSE;
			case CenrepPackage.KEY_RANGE__ACCESS:
				return getAccess();
			case CenrepPackage.KEY_RANGE__READ_ACCESS:
				return getReadAccess();
			case CenrepPackage.KEY_RANGE__WRITE_ACCESS:
				return getWriteAccess();
			case CenrepPackage.KEY_RANGE__GACCESS:
				return getGAccess();
			case CenrepPackage.KEY_RANGE__BACKUP:
				return isBackup() ? Boolean.TRUE : Boolean.FALSE;
			case CenrepPackage.KEY_RANGE__NAME:
				return getName();
			case CenrepPackage.KEY_RANGE__INT:
				return getInt();
			case CenrepPackage.KEY_RANGE__FIRST_INT:
				return getFirstInt();
			case CenrepPackage.KEY_RANGE__LAST_INT:
				return getLastInt();
			case CenrepPackage.KEY_RANGE__INDEX_BITS:
				return getIndexBits();
			case CenrepPackage.KEY_RANGE__FIRST_INDEX:
				return getFirstIndex();
			case CenrepPackage.KEY_RANGE__COUNT_INT:
				return getCountInt();
			case CenrepPackage.KEY_RANGE__KEYS:
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
			case CenrepPackage.KEY_RANGE__REF:
				setRef((String)newValue);
				return;
			case CenrepPackage.KEY_RANGE__GVALUE:
				setGvalue(newValue);
				return;
			case CenrepPackage.KEY_RANGE__RFS:
				setRfs(((Boolean)newValue).booleanValue());
				return;
			case CenrepPackage.KEY_RANGE__READ_ONLY:
				setReadOnly(((Boolean)newValue).booleanValue());
				return;
			case CenrepPackage.KEY_RANGE__ACCESS:
				getAccess().clear();
				getAccess().addAll((Collection<? extends Access>)newValue);
				return;
			case CenrepPackage.KEY_RANGE__READ_ACCESS:
				setReadAccess((Access)newValue);
				return;
			case CenrepPackage.KEY_RANGE__WRITE_ACCESS:
				setWriteAccess((Access)newValue);
				return;
			case CenrepPackage.KEY_RANGE__BACKUP:
				setBackup(((Boolean)newValue).booleanValue());
				return;
			case CenrepPackage.KEY_RANGE__NAME:
				setName((String)newValue);
				return;
			case CenrepPackage.KEY_RANGE__INT:
				setInt((String)newValue);
				return;
			case CenrepPackage.KEY_RANGE__FIRST_INT:
				setFirstInt((String)newValue);
				return;
			case CenrepPackage.KEY_RANGE__LAST_INT:
				setLastInt((String)newValue);
				return;
			case CenrepPackage.KEY_RANGE__INDEX_BITS:
				setIndexBits((String)newValue);
				return;
			case CenrepPackage.KEY_RANGE__FIRST_INDEX:
				setFirstIndex((String)newValue);
				return;
			case CenrepPackage.KEY_RANGE__COUNT_INT:
				setCountInt((String)newValue);
				return;
			case CenrepPackage.KEY_RANGE__KEYS:
				getKeys().clear();
				getKeys().addAll((Collection<? extends Key>)newValue);
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
			case CenrepPackage.KEY_RANGE__REF:
				setRef(REF_EDEFAULT);
				return;
			case CenrepPackage.KEY_RANGE__GVALUE:
				setGvalue(GVALUE_EDEFAULT);
				return;
			case CenrepPackage.KEY_RANGE__RFS:
				setRfs(RFS_EDEFAULT);
				return;
			case CenrepPackage.KEY_RANGE__READ_ONLY:
				setReadOnly(READ_ONLY_EDEFAULT);
				return;
			case CenrepPackage.KEY_RANGE__ACCESS:
				getAccess().clear();
				return;
			case CenrepPackage.KEY_RANGE__READ_ACCESS:
				setReadAccess((Access)null);
				return;
			case CenrepPackage.KEY_RANGE__WRITE_ACCESS:
				setWriteAccess((Access)null);
				return;
			case CenrepPackage.KEY_RANGE__BACKUP:
				setBackup(BACKUP_EDEFAULT);
				return;
			case CenrepPackage.KEY_RANGE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CenrepPackage.KEY_RANGE__INT:
				setInt(INT_EDEFAULT);
				return;
			case CenrepPackage.KEY_RANGE__FIRST_INT:
				setFirstInt(FIRST_INT_EDEFAULT);
				return;
			case CenrepPackage.KEY_RANGE__LAST_INT:
				setLastInt(LAST_INT_EDEFAULT);
				return;
			case CenrepPackage.KEY_RANGE__INDEX_BITS:
				setIndexBits(INDEX_BITS_EDEFAULT);
				return;
			case CenrepPackage.KEY_RANGE__FIRST_INDEX:
				setFirstIndex(FIRST_INDEX_EDEFAULT);
				return;
			case CenrepPackage.KEY_RANGE__COUNT_INT:
				setCountInt(COUNT_INT_EDEFAULT);
				return;
			case CenrepPackage.KEY_RANGE__KEYS:
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
			case CenrepPackage.KEY_RANGE__REF:
				return REF_EDEFAULT == null ? ref != null : !REF_EDEFAULT.equals(ref);
			case CenrepPackage.KEY_RANGE__GVALUE:
				return GVALUE_EDEFAULT == null ? gvalue != null : !GVALUE_EDEFAULT.equals(gvalue);
			case CenrepPackage.KEY_RANGE__RFS:
				return rfs != RFS_EDEFAULT;
			case CenrepPackage.KEY_RANGE__READ_ONLY:
				return readOnly != READ_ONLY_EDEFAULT;
			case CenrepPackage.KEY_RANGE__ACCESS:
				return access != null && !access.isEmpty();
			case CenrepPackage.KEY_RANGE__READ_ACCESS:
				return getReadAccess() != null;
			case CenrepPackage.KEY_RANGE__WRITE_ACCESS:
				return getWriteAccess() != null;
			case CenrepPackage.KEY_RANGE__GACCESS:
				return GACCESS_EDEFAULT == null ? getGAccess() != null : !GACCESS_EDEFAULT.equals(getGAccess());
			case CenrepPackage.KEY_RANGE__BACKUP:
				return backup != BACKUP_EDEFAULT;
			case CenrepPackage.KEY_RANGE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CenrepPackage.KEY_RANGE__INT:
				return INT_EDEFAULT == null ? int_ != null : !INT_EDEFAULT.equals(int_);
			case CenrepPackage.KEY_RANGE__FIRST_INT:
				return FIRST_INT_EDEFAULT == null ? firstInt != null : !FIRST_INT_EDEFAULT.equals(firstInt);
			case CenrepPackage.KEY_RANGE__LAST_INT:
				return LAST_INT_EDEFAULT == null ? lastInt != null : !LAST_INT_EDEFAULT.equals(lastInt);
			case CenrepPackage.KEY_RANGE__INDEX_BITS:
				return INDEX_BITS_EDEFAULT == null ? indexBits != null : !INDEX_BITS_EDEFAULT.equals(indexBits);
			case CenrepPackage.KEY_RANGE__FIRST_INDEX:
				return FIRST_INDEX_EDEFAULT == null ? firstIndex != null : !FIRST_INDEX_EDEFAULT.equals(firstIndex);
			case CenrepPackage.KEY_RANGE__COUNT_INT:
				return COUNT_INT_EDEFAULT == null ? countInt != null : !COUNT_INT_EDEFAULT.equals(countInt);
			case CenrepPackage.KEY_RANGE__KEYS:
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
		if (baseClass == RVG.class) {
			switch (derivedFeatureID) {
				case CenrepPackage.KEY_RANGE__REF: return CenrepPackage.RVG__REF;
				case CenrepPackage.KEY_RANGE__GVALUE: return CenrepPackage.RVG__GVALUE;
				case CenrepPackage.KEY_RANGE__RFS: return CenrepPackage.RVG__RFS;
				default: return -1;
			}
		}
		if (baseClass == IReadOnly.class) {
			switch (derivedFeatureID) {
				case CenrepPackage.KEY_RANGE__READ_ONLY: return CenrepPackage.IREAD_ONLY__READ_ONLY;
				default: return -1;
			}
		}
		if (baseClass == IAccessable.class) {
			switch (derivedFeatureID) {
				case CenrepPackage.KEY_RANGE__ACCESS: return CenrepPackage.IACCESSABLE__ACCESS;
				case CenrepPackage.KEY_RANGE__READ_ACCESS: return CenrepPackage.IACCESSABLE__READ_ACCESS;
				case CenrepPackage.KEY_RANGE__WRITE_ACCESS: return CenrepPackage.IACCESSABLE__WRITE_ACCESS;
				case CenrepPackage.KEY_RANGE__GACCESS: return CenrepPackage.IACCESSABLE__GACCESS;
				default: return -1;
			}
		}
		if (baseClass == IBackup.class) {
			switch (derivedFeatureID) {
				case CenrepPackage.KEY_RANGE__BACKUP: return CenrepPackage.IBACKUP__BACKUP;
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
		if (baseClass == RVG.class) {
			switch (baseFeatureID) {
				case CenrepPackage.RVG__REF: return CenrepPackage.KEY_RANGE__REF;
				case CenrepPackage.RVG__GVALUE: return CenrepPackage.KEY_RANGE__GVALUE;
				case CenrepPackage.RVG__RFS: return CenrepPackage.KEY_RANGE__RFS;
				default: return -1;
			}
		}
		if (baseClass == IReadOnly.class) {
			switch (baseFeatureID) {
				case CenrepPackage.IREAD_ONLY__READ_ONLY: return CenrepPackage.KEY_RANGE__READ_ONLY;
				default: return -1;
			}
		}
		if (baseClass == IAccessable.class) {
			switch (baseFeatureID) {
				case CenrepPackage.IACCESSABLE__ACCESS: return CenrepPackage.KEY_RANGE__ACCESS;
				case CenrepPackage.IACCESSABLE__READ_ACCESS: return CenrepPackage.KEY_RANGE__READ_ACCESS;
				case CenrepPackage.IACCESSABLE__WRITE_ACCESS: return CenrepPackage.KEY_RANGE__WRITE_ACCESS;
				case CenrepPackage.IACCESSABLE__GACCESS: return CenrepPackage.KEY_RANGE__GACCESS;
				default: return -1;
			}
		}
		if (baseClass == IBackup.class) {
			switch (baseFeatureID) {
				case CenrepPackage.IBACKUP__BACKUP: return CenrepPackage.KEY_RANGE__BACKUP;
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
		result.append(", gvalue: ");
		result.append(gvalue);
		result.append(", rfs: ");
		result.append(rfs);
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

} //KeyRangeImpl
