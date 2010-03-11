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

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

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
import cenrep.Key;
import cenrep.KeyRange;
import cenrep.Meta;
import cenrep.Repository;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Repository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cenrep.impl.RepositoryImpl#getAccess <em>Access</em>}</li>
 *   <li>{@link cenrep.impl.RepositoryImpl#getReadAccess <em>Read Access</em>}</li>
 *   <li>{@link cenrep.impl.RepositoryImpl#getWriteAccess <em>Write Access</em>}</li>
 *   <li>{@link cenrep.impl.RepositoryImpl#getGAccess <em>GAccess</em>}</li>
 *   <li>{@link cenrep.impl.RepositoryImpl#isBackup <em>Backup</em>}</li>
 *   <li>{@link cenrep.impl.RepositoryImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link cenrep.impl.RepositoryImpl#getUidName <em>Uid Name</em>}</li>
 *   <li>{@link cenrep.impl.RepositoryImpl#getUidValue <em>Uid Value</em>}</li>
 *   <li>{@link cenrep.impl.RepositoryImpl#getInitialisationFileVersion <em>Initialisation File Version</em>}</li>
 *   <li>{@link cenrep.impl.RepositoryImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link cenrep.impl.RepositoryImpl#isRfs <em>Rfs</em>}</li>
 *   <li>{@link cenrep.impl.RepositoryImpl#getKey <em>Key</em>}</li>
 *   <li>{@link cenrep.impl.RepositoryImpl#getMeta <em>Meta</em>}</li>
 *   <li>{@link cenrep.impl.RepositoryImpl#getSimpleKeys <em>Simple Keys</em>}</li>
 *   <li>{@link cenrep.impl.RepositoryImpl#getBitmaskKeys <em>Bitmask Keys</em>}</li>
 *   <li>{@link cenrep.impl.RepositoryImpl#getRangeKey <em>Range Key</em>}</li>
 *   <li>{@link cenrep.impl.RepositoryImpl#getFileName <em>File Name</em>}</li>
 *   <li>{@link cenrep.impl.RepositoryImpl#getProblems <em>Problems</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RepositoryImpl extends AttributeAndDescriptionImpl implements Repository {
	
	private final static String LINE_SEPARATOR = System.getProperty("line.separator");
	
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
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated NOT
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = "1";

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
	protected EList<Key> key;

	/**
	 * The cached value of the '{@link #getMeta() <em>Meta</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeta()
	 * @generated
	 * @ordered
	 */
	protected Meta meta;

	/**
	 * The cached value of the '{@link #getRangeKey() <em>Range Key</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRangeKey()
	 * @generated
	 * @ordered
	 */
	protected EList<KeyRange> rangeKey;

	/**
	 * The default value of the '{@link #getFileName() <em>File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileName()
	 * @generated
	 * @ordered
	 */
	protected static final String FILE_NAME_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getProblems() <em>Problems</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProblems()
	 * @generated
	 * @ordered
	 */
	protected static final String PROBLEMS_EDEFAULT = null;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RepositoryImpl() {
		super();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CenrepPackage.Literals.REPOSITORY;
	}

	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	public List sortKeys(){
		List<Key> sortedKeys = new ArrayList<Key>();
		sortedKeys.addAll(key);
		
		for(KeyRange range : getRangeKey()) sortedKeys.addAll(range.getGKeys());
		
		Collections.sort(sortedKeys, new Comparator<Key>(){
			public int compare(Key arg0, Key arg1) {
				int radix =16;
				Key key0 = (Key)arg0;
				Key key1 = (Key)arg1;
				String ident0 = key0.getIdent();
				String ident1 = key1.getIdent();
				if(ident0==null)return -1;
				else if(ident1==null)return 1;
				
				ident0=ident0.replaceAll("0x", "");
				ident1=ident1.replaceAll("0x", "");
				ident0="00000000".substring(0,8-ident0.length())+ident0;
				ident1="00000000".substring(0,8-ident1.length())+ident1;
				String upper0=ident0.substring(0, 4);
				String lower0 = ident0.substring(4,ident0.length());
				String upper1 = ident1.substring(0, 4);
				String lower1 = ident1.substring(4,ident1.length());
				if(!upper0.equals(upper1))
					return Integer.valueOf(upper0, radix).compareTo(Integer.valueOf(upper1, radix));
				else return Integer.valueOf(lower0, radix).compareTo(Integer.valueOf(lower1, radix));
				
			}
		});
		return sortedKeys;
//		return getKey();
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
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.REPOSITORY__VERSION, oldVersion, version));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.REPOSITORY__UID_NAME, oldUidName, uidName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.REPOSITORY__UID_VALUE, oldUidValue, uidValue));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.REPOSITORY__INITIALISATION_FILE_VERSION, oldInitialisationFileVersion, initialisationFileVersion));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.REPOSITORY__OWNER, oldOwner, owner));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.REPOSITORY__BACKUP, oldBackup, backup));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.REPOSITORY__RFS, oldRfs, rfs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Key> getKey() {
		if (key == null) {
			key = new EObjectContainmentEList<Key>(Key.class, this, CenrepPackage.REPOSITORY__KEY);
		}
		return key;
	}

	public List getKey(String release){
		List result = new ArrayList();
		for(Iterator iKey=this.getKey().iterator();iKey.hasNext();){
			Key aKey = (Key)iKey.next();
			result.add(aKey);
		}
		return result;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Meta getMeta() {
		if (meta != null && meta.eIsProxy()) {
			InternalEObject oldMeta = (InternalEObject)meta;
			meta = (Meta)eResolveProxy(oldMeta);
			if (meta != oldMeta) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CenrepPackage.REPOSITORY__META, oldMeta, meta));
			}
		}
		return meta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Meta basicGetMeta() {
		return meta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeta(Meta newMeta) {
		Meta oldMeta = meta;
		meta = newMeta;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.REPOSITORY__META, oldMeta, meta));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Access> getAccess() {
		if (access == null) {
			access = new EObjectContainmentEList<Access>(Access.class, this, CenrepPackage.REPOSITORY__ACCESS);
		}
		return access;
	}

	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList getSimpleKeys() {
		EList<Key> simpleKeys=null;
		if(simpleKeys==null){
			simpleKeys = new BasicEList<Key>();
			for(Iterator<Key>iKey=this.getKey().iterator();iKey.hasNext();){
				Key key = iKey.next();
				if(key.isSimpleKey())simpleKeys.add(key);
			}
		}
		return simpleKeys;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList getBitmaskKeys() {
		EList<Key> bitmaskKeys=null;
		if(bitmaskKeys==null){
			bitmaskKeys = new BasicEList<Key>();
			for(Iterator<Key>iKey=this.getKey().iterator();iKey.hasNext();){
				Key key = iKey.next();
				if(key.isBitmaskKey())bitmaskKeys.add(key);
			}
		}
		return bitmaskKeys;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<KeyRange> getRangeKey() {
		if (rangeKey == null) {
			rangeKey = new EObjectContainmentEList<KeyRange>(KeyRange.class, this, CenrepPackage.REPOSITORY__RANGE_KEY);
		}
		return rangeKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getFileName() {
		String fileName = getUidValue().replaceFirst("0x", "").replaceFirst("0X", "")+".txt";
		String folderName = null;
		int prio = Integer.MAX_VALUE;
		for(Key key: getKey()){
			if(key.getGPriority()<prio){
				prio = key.getGPriority();
				folderName = key.getFolder();
			}
		}
		if(folderName!=null)
			return folderName+File.separator+fileName;
		else
			return fileName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getProblems() {
		String report="Problem with "+getFileName()+LINE_SEPARATOR;
		for(Key key : (EList<Key>)this.getKey()){
			if(!key.canGenerate()) {
				report+="Key "+key.getIdent()+" cannot be generated"+LINE_SEPARATOR;
				key.canGenerate();
			}
		}
		
		return report;
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
	 * @generated NOT
	 */
	public String getGAccess() {
		String result="";
		Access rAccess = this.getReadAccess();
		Access wAccess = this.getWriteAccess();
		boolean runtime = true;
		
		Access rKeysAccess = getKeysRAccess();
		
		if(rAccess!=null){
			result+=rAccess.getStrFormat()+" ";
			runtime=false;
		}
		if(wAccess!=null){
			result+=wAccess.getStrFormat();
		}
		
		if(this.getKey().isEmpty()&&result.trim().compareTo("cap_rd=alwayspass")==0)result="";
		return result.length()==0?"":" "+result.trim();
	}

	
	Access getKeysRAccess(){
		Access result = null;
		boolean failed = false;
		for(Key key : this.getKey()){
			Access temp = key.getReadAccess();
			if(!failed){
				if(result==null)result=temp;
				else if(temp!=null)failed = result.getStrFormat().compareTo(temp.getStrFormat())!=0;
			}
		}
		return !failed?result:null;
	}
	
	Access getKeysWAccess(){
		Access result = null;
		boolean failed = false;
		for(Key key : this.getKey()){
			Access temp = key.getWriteAccess();
			if(!failed){
				if(result==null)result=temp;
				else if(temp!=null)failed = result.getStrFormat().compareTo(temp.getStrFormat())!=0;
			}
		}
		return !failed?result:null;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean canGenerate() {
		for(Key key : (EList<Key>)this.getKey()){
			if(!key.canGenerate())return false;
		}
		return getUidValue()!=null;
	}

	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CenrepPackage.REPOSITORY__ACCESS:
				return ((InternalEList<?>)getAccess()).basicRemove(otherEnd, msgs);
			case CenrepPackage.REPOSITORY__KEY:
				return ((InternalEList<?>)getKey()).basicRemove(otherEnd, msgs);
			case CenrepPackage.REPOSITORY__RANGE_KEY:
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
			case CenrepPackage.REPOSITORY__ACCESS:
				return getAccess();
			case CenrepPackage.REPOSITORY__READ_ACCESS:
				return getReadAccess();
			case CenrepPackage.REPOSITORY__WRITE_ACCESS:
				return getWriteAccess();
			case CenrepPackage.REPOSITORY__GACCESS:
				return getGAccess();
			case CenrepPackage.REPOSITORY__BACKUP:
				return isBackup() ? Boolean.TRUE : Boolean.FALSE;
			case CenrepPackage.REPOSITORY__VERSION:
				return getVersion();
			case CenrepPackage.REPOSITORY__UID_NAME:
				return getUidName();
			case CenrepPackage.REPOSITORY__UID_VALUE:
				return getUidValue();
			case CenrepPackage.REPOSITORY__INITIALISATION_FILE_VERSION:
				return getInitialisationFileVersion();
			case CenrepPackage.REPOSITORY__OWNER:
				return getOwner();
			case CenrepPackage.REPOSITORY__RFS:
				return isRfs() ? Boolean.TRUE : Boolean.FALSE;
			case CenrepPackage.REPOSITORY__KEY:
				return getKey();
			case CenrepPackage.REPOSITORY__META:
				if (resolve) return getMeta();
				return basicGetMeta();
			case CenrepPackage.REPOSITORY__SIMPLE_KEYS:
				return getSimpleKeys();
			case CenrepPackage.REPOSITORY__BITMASK_KEYS:
				return getBitmaskKeys();
			case CenrepPackage.REPOSITORY__RANGE_KEY:
				return getRangeKey();
			case CenrepPackage.REPOSITORY__FILE_NAME:
				return getFileName();
			case CenrepPackage.REPOSITORY__PROBLEMS:
				return getProblems();
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
			case CenrepPackage.REPOSITORY__ACCESS:
				getAccess().clear();
				getAccess().addAll((Collection<? extends Access>)newValue);
				return;
			case CenrepPackage.REPOSITORY__READ_ACCESS:
				setReadAccess((Access)newValue);
				return;
			case CenrepPackage.REPOSITORY__WRITE_ACCESS:
				setWriteAccess((Access)newValue);
				return;
			case CenrepPackage.REPOSITORY__BACKUP:
				setBackup(((Boolean)newValue).booleanValue());
				return;
			case CenrepPackage.REPOSITORY__VERSION:
				setVersion((String)newValue);
				return;
			case CenrepPackage.REPOSITORY__UID_NAME:
				setUidName((String)newValue);
				return;
			case CenrepPackage.REPOSITORY__UID_VALUE:
				setUidValue((String)newValue);
				return;
			case CenrepPackage.REPOSITORY__INITIALISATION_FILE_VERSION:
				setInitialisationFileVersion((String)newValue);
				return;
			case CenrepPackage.REPOSITORY__OWNER:
				setOwner((String)newValue);
				return;
			case CenrepPackage.REPOSITORY__RFS:
				setRfs(((Boolean)newValue).booleanValue());
				return;
			case CenrepPackage.REPOSITORY__KEY:
				getKey().clear();
				getKey().addAll((Collection<? extends Key>)newValue);
				return;
			case CenrepPackage.REPOSITORY__META:
				setMeta((Meta)newValue);
				return;
			case CenrepPackage.REPOSITORY__BITMASK_KEYS:
				getBitmaskKeys().clear();
				getBitmaskKeys().addAll((Collection<? extends Key>)newValue);
				return;
			case CenrepPackage.REPOSITORY__RANGE_KEY:
				getRangeKey().clear();
				getRangeKey().addAll((Collection<? extends KeyRange>)newValue);
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
			case CenrepPackage.REPOSITORY__ACCESS:
				getAccess().clear();
				return;
			case CenrepPackage.REPOSITORY__READ_ACCESS:
				setReadAccess((Access)null);
				return;
			case CenrepPackage.REPOSITORY__WRITE_ACCESS:
				setWriteAccess((Access)null);
				return;
			case CenrepPackage.REPOSITORY__BACKUP:
				setBackup(BACKUP_EDEFAULT);
				return;
			case CenrepPackage.REPOSITORY__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case CenrepPackage.REPOSITORY__UID_NAME:
				setUidName(UID_NAME_EDEFAULT);
				return;
			case CenrepPackage.REPOSITORY__UID_VALUE:
				setUidValue(UID_VALUE_EDEFAULT);
				return;
			case CenrepPackage.REPOSITORY__INITIALISATION_FILE_VERSION:
				setInitialisationFileVersion(INITIALISATION_FILE_VERSION_EDEFAULT);
				return;
			case CenrepPackage.REPOSITORY__OWNER:
				setOwner(OWNER_EDEFAULT);
				return;
			case CenrepPackage.REPOSITORY__RFS:
				setRfs(RFS_EDEFAULT);
				return;
			case CenrepPackage.REPOSITORY__KEY:
				getKey().clear();
				return;
			case CenrepPackage.REPOSITORY__META:
				setMeta((Meta)null);
				return;
			case CenrepPackage.REPOSITORY__BITMASK_KEYS:
				getBitmaskKeys().clear();
				return;
			case CenrepPackage.REPOSITORY__RANGE_KEY:
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
			case CenrepPackage.REPOSITORY__ACCESS:
				return access != null && !access.isEmpty();
			case CenrepPackage.REPOSITORY__READ_ACCESS:
				return getReadAccess() != null;
			case CenrepPackage.REPOSITORY__WRITE_ACCESS:
				return getWriteAccess() != null;
			case CenrepPackage.REPOSITORY__GACCESS:
				return GACCESS_EDEFAULT == null ? getGAccess() != null : !GACCESS_EDEFAULT.equals(getGAccess());
			case CenrepPackage.REPOSITORY__BACKUP:
				return backup != BACKUP_EDEFAULT;
			case CenrepPackage.REPOSITORY__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case CenrepPackage.REPOSITORY__UID_NAME:
				return UID_NAME_EDEFAULT == null ? uidName != null : !UID_NAME_EDEFAULT.equals(uidName);
			case CenrepPackage.REPOSITORY__UID_VALUE:
				return UID_VALUE_EDEFAULT == null ? uidValue != null : !UID_VALUE_EDEFAULT.equals(uidValue);
			case CenrepPackage.REPOSITORY__INITIALISATION_FILE_VERSION:
				return INITIALISATION_FILE_VERSION_EDEFAULT == null ? initialisationFileVersion != null : !INITIALISATION_FILE_VERSION_EDEFAULT.equals(initialisationFileVersion);
			case CenrepPackage.REPOSITORY__OWNER:
				return OWNER_EDEFAULT == null ? owner != null : !OWNER_EDEFAULT.equals(owner);
			case CenrepPackage.REPOSITORY__RFS:
				return rfs != RFS_EDEFAULT;
			case CenrepPackage.REPOSITORY__KEY:
				return key != null && !key.isEmpty();
			case CenrepPackage.REPOSITORY__META:
				return meta != null;
			case CenrepPackage.REPOSITORY__SIMPLE_KEYS:
				return !getSimpleKeys().isEmpty();
			case CenrepPackage.REPOSITORY__BITMASK_KEYS:
				return !getBitmaskKeys().isEmpty();
			case CenrepPackage.REPOSITORY__RANGE_KEY:
				return rangeKey != null && !rangeKey.isEmpty();
			case CenrepPackage.REPOSITORY__FILE_NAME:
				return FILE_NAME_EDEFAULT == null ? getFileName() != null : !FILE_NAME_EDEFAULT.equals(getFileName());
			case CenrepPackage.REPOSITORY__PROBLEMS:
				return PROBLEMS_EDEFAULT == null ? getProblems() != null : !PROBLEMS_EDEFAULT.equals(getProblems());
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
		if (baseClass == IAccessable.class) {
			switch (derivedFeatureID) {
				case CenrepPackage.REPOSITORY__ACCESS: return CenrepPackage.IACCESSABLE__ACCESS;
				case CenrepPackage.REPOSITORY__READ_ACCESS: return CenrepPackage.IACCESSABLE__READ_ACCESS;
				case CenrepPackage.REPOSITORY__WRITE_ACCESS: return CenrepPackage.IACCESSABLE__WRITE_ACCESS;
				case CenrepPackage.REPOSITORY__GACCESS: return CenrepPackage.IACCESSABLE__GACCESS;
				default: return -1;
			}
		}
		if (baseClass == IBackup.class) {
			switch (derivedFeatureID) {
				case CenrepPackage.REPOSITORY__BACKUP: return CenrepPackage.IBACKUP__BACKUP;
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
		if (baseClass == IAccessable.class) {
			switch (baseFeatureID) {
				case CenrepPackage.IACCESSABLE__ACCESS: return CenrepPackage.REPOSITORY__ACCESS;
				case CenrepPackage.IACCESSABLE__READ_ACCESS: return CenrepPackage.REPOSITORY__READ_ACCESS;
				case CenrepPackage.IACCESSABLE__WRITE_ACCESS: return CenrepPackage.REPOSITORY__WRITE_ACCESS;
				case CenrepPackage.IACCESSABLE__GACCESS: return CenrepPackage.REPOSITORY__GACCESS;
				default: return -1;
			}
		}
		if (baseClass == IBackup.class) {
			switch (baseFeatureID) {
				case CenrepPackage.IBACKUP__BACKUP: return CenrepPackage.REPOSITORY__BACKUP;
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

	
} //RepositoryImpl