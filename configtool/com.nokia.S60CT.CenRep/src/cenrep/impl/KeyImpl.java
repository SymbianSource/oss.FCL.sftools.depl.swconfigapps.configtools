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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import cenrep.ACCESS_TYPE;
import cenrep.Access;
import cenrep.Bit;
import cenrep.CenrepPackage;
import cenrep.IAccessable;
import cenrep.IBackup;
import cenrep.IReadOnly;
import cenrep.Key;
import cenrep.KeyRange;
import cenrep.RVG;
import cenrep.TYPE;
import cenrep.Value;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Key</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cenrep.impl.KeyImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link cenrep.impl.KeyImpl#getGvalue <em>Gvalue</em>}</li>
 *   <li>{@link cenrep.impl.KeyImpl#isRfs <em>Rfs</em>}</li>
 *   <li>{@link cenrep.impl.KeyImpl#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link cenrep.impl.KeyImpl#getAccess <em>Access</em>}</li>
 *   <li>{@link cenrep.impl.KeyImpl#getReadAccess <em>Read Access</em>}</li>
 *   <li>{@link cenrep.impl.KeyImpl#getWriteAccess <em>Write Access</em>}</li>
 *   <li>{@link cenrep.impl.KeyImpl#getGAccess <em>GAccess</em>}</li>
 *   <li>{@link cenrep.impl.KeyImpl#isBackup <em>Backup</em>}</li>
 *   <li>{@link cenrep.impl.KeyImpl#getName <em>Name</em>}</li>
 *   <li>{@link cenrep.impl.KeyImpl#getIdent <em>Ident</em>}</li>
 *   <li>{@link cenrep.impl.KeyImpl#getType <em>Type</em>}</li>
 *   <li>{@link cenrep.impl.KeyImpl#getValue <em>Value</em>}</li>
 *   <li>{@link cenrep.impl.KeyImpl#getBits <em>Bits</em>}</li>
 *   <li>{@link cenrep.impl.KeyImpl#isBitmaskKey <em>Bitmask Key</em>}</li>
 *   <li>{@link cenrep.impl.KeyImpl#isSimpleKey <em>Simple Key</em>}</li>
 *   <li>{@link cenrep.impl.KeyImpl#getShortIdent <em>Short Ident</em>}</li>
 *   <li>{@link cenrep.impl.KeyImpl#getStrType <em>Str Type</em>}</li>
 *   <li>{@link cenrep.impl.KeyImpl#isDecFormat <em>Dec Format</em>}</li>
 *   <li>{@link cenrep.impl.KeyImpl#isHexFormat <em>Hex Format</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class KeyImpl extends AttributeAndDescriptionImpl implements Key {
	
	
	private static final String ZERO_X = "0x";
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
	private static final String SHORT_IDENT_PATTERN = "0x0{0,7}";
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
	protected static final TYPE TYPE_EDEFAULT = TYPE.INT;
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected TYPE type = TYPE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected EList<Value> value;
	/**
	 * The cached value of the '{@link #getBits() <em>Bits</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBits()
	 * @generated
	 * @ordered
	 */
	protected EList<Bit> bits;
	/**
	 * The default value of the '{@link #isBitmaskKey() <em>Bitmask Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBitmaskKey()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BITMASK_KEY_EDEFAULT = false;
	/**
	 * The default value of the '{@link #isSimpleKey() <em>Simple Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSimpleKey()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SIMPLE_KEY_EDEFAULT = false;
	/**
	 * The default value of the '{@link #getShortIdent() <em>Short Ident</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShortIdent()
	 * @generated
	 * @ordered
	 */
	protected static final String SHORT_IDENT_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getStrType() <em>Str Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStrType()
	 * @generated
	 * @ordered
	 */
	protected static final String STR_TYPE_EDEFAULT = null;
	/**
	 * The default value of the '{@link #isDecFormat() <em>Dec Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDecFormat()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEC_FORMAT_EDEFAULT = false;
	/**
	 * The default value of the '{@link #isHexFormat() <em>Hex Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHexFormat()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HEX_FORMAT_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	protected KeyImpl() {
		super();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CenrepPackage.Literals.KEY;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.KEY__REF, oldRef, ref));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.KEY__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.KEY__IDENT, oldIdent, ident));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TYPE getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(TYPE newType) {
		TYPE oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.KEY__TYPE, oldType, type));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.KEY__READ_ONLY, oldReadOnly, readOnly));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.KEY__BACKUP, oldBackup, backup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getGvalue() {
		if(gvalue!=null){
			try
			{
				if(getType().equals(TYPE.STRING)||getType().equals(TYPE.STRING8))
					return "\""+gvalue+"\"";
				else 
					return (String)gvalue;
			}
			catch (ClassCastException cce)
			{
				return null;
			}
		}
		else if(!getBits().isEmpty()){
			double result = calculateBitmask();
			if(isDecFormat())
				return String.valueOf((int)result);
			else{
				String str =Integer.toHexString((int)result).toUpperCase();
				if(str.length()<BYTE_SIZE&&str.length()%(BYTE_SIZE/2)>0)
					str=String.copyValueOf(BINARY_ZERO,0,BYTE_SIZE-str.length()%8)+str;
				return str;
			}
		}
		return null;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGvalue(Object newGvalue) {
		
		if (newGvalue instanceof String)
		{
			Object oldGvalue = gvalue;
			gvalue = newGvalue;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.KEY__GVALUE, oldGvalue, gvalue));
		}
		else
		{
			gvalue = null;
		}
		
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
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.KEY__RFS, oldRfs, rfs));
	}
	private static final char[] BINARY_ZERO = new char[]{'0','0','0','0','0','0','0','0'};
	private static final int BYTE_SIZE=8;
	private double calculateBitmask() {
		double result = 0;
		for(Bit bit : (EList<Bit>)getBits())
			if(((String)bit.getGvalue()).compareTo("true")==0 || ((String)bit.getGvalue()).compareTo("1")==0)
				result=result+Math.pow(2,(double)bit.getNumber()-1);
		return result;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Access> getAccess() {
		if (access == null) {
			access = new EObjectContainmentEList<Access>(Access.class, this, CenrepPackage.KEY__ACCESS);
		}
		return access;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Value> getValue() {
		if (value == null) {
			value = new EObjectContainmentEList<Value>(Value.class, this, CenrepPackage.KEY__VALUE);
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Bit> getBits() {
		if (bits == null) {
			bits = new EObjectContainmentEList<Bit>(Bit.class, this, CenrepPackage.KEY__BITS);
		}
		return bits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isBitmaskKey() {
		return !getBits().isEmpty();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBitmaskKey(boolean newBitmaskKey) {
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isSimpleKey() {
		return !isBitmaskKey();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimpleKey(boolean newSimpleKey) {
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getShortIdent() {
		String result = getIdent();
		if(result!=null){
			result=result.replaceAll(SHORT_IDENT_PATTERN, ZERO_X);
			
			if(result.endsWith(ZERO_X))
				result=result+"0";
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setShortIdent(String newShortIdent) {
		setIdent(newShortIdent);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getStrType() {
		return getType().getLiteral();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isDecFormat() {
		return getType().equals(TYPE.INT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHexFormat() {
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Access getReadAccess() {
		if(eContainer!=null&&eContainer instanceof KeyRange)
			return ((KeyRange)eContainer).getReadAccess();
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
		if(eContainer!=null&&eContainer instanceof KeyRange){
			((KeyRange)eContainer).setReadAccess(newReadAccess);
		}else{
			newReadAccess.setType(ACCESS_TYPE.READ);
			Access currentRAccess = getReadAccess();
			if(currentRAccess!=null)
				getAccess().remove(currentRAccess);
			this.getAccess().add(newReadAccess);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Access getWriteAccess() {
		if(eContainer!=null&&eContainer instanceof KeyRange)
			return ((KeyRange)eContainer).getWriteAccess();
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
		if(eContainer!=null&&eContainer instanceof KeyRange){
			((KeyRange)eContainer).setWriteAccess(newWriteAccess);
		}else{
			newWriteAccess.setType(ACCESS_TYPE.WRITE);
			Access currentWAccess = getWriteAccess();
			if(currentWAccess!=null)
				getAccess().remove(currentWAccess);
			this.getAccess().add(newWriteAccess);
		}
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
		if(rAccess!=null){
			result+=rAccess.getStrFormat()+" ";
		}
		if(wAccess!=null){
			String wAstr =wAccess.getStrFormat();
			if(this.isReadOnly())wAstr="cap_wr=alwaysfail";
			result+=wAstr;
		}else
			if(this.isReadOnly())result+="cap_wr=alwaysfail";
		
		
		return result.length()==0?"":" "+result.trim();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getErrors() {
		String result="";
		if(this.getRef()!=REF_EDEFAULT&&this.getGvalue()==GVALUE_EDEFAULT)
			result=this.getRef()+" has no value"+"\n";
		else{
//			for(Iterator<BitFlag>iBF=this.getBits().iterator();iBF.hasNext();){
//				BitFlag bf = iBF.next();
//				boolean defined = false;
//				for(Iterator<Value>iValue=bf.getValues().iterator();iValue.hasNext()&&!defined;)
//					defined=iValue.next().getGvalue()!=GVALUE_EDEFAULT;
//				if(!defined)
//					result=result+bf.getRef()+" has no value"+"\n";
//			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean canGenerate() {
		if(isSimpleKey())return getIdent()!=null&&gvalue!=null;
		else if(isBitmaskKey()){
			for(Bit bit : (EList<Bit>)this.getBits())
				if(!bit.canGenerate())return false;
			return true;
		}
		return false;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	String configuration =null;
	public void setGConf(String confName) {
		if(isBitmaskKey()&&confName==null){
			for(Bit bit : this.getBits())
				bit.setGConf(null);
		}
		configuration=confName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	int prio =-1;
	public void setPriority(String prio) {
		if(isBitmaskKey()&&prio==null){
			for(Bit bit : this.getBits())
				bit.setPriority(null);
		}
		if(prio!=null)
			this.prio = Integer.valueOf(prio);
		else this.prio=-1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getFolder() {
		if(this.isBitmaskKey()){
			String bitConf = null;
			int bitPrio=Integer.MAX_VALUE;
			for(Bit bit : this.getBits()){
				if(bit.getGPriority()<bitPrio){
					bitPrio=bit.getGPriority();
					bitConf=bit.getFolder();
				}
			}
			return bitConf;
			
		}else return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getGPriority() {
		if(this.isBitmaskKey()){
			int bitPrio=Integer.MAX_VALUE;
			for(Bit bit : this.getBits()){
				if(bit.getGPriority()<bitPrio)
					bitPrio=bit.getGPriority();
			}
			return bitPrio;
		}else return prio;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CenrepPackage.KEY__ACCESS:
				return ((InternalEList<?>)getAccess()).basicRemove(otherEnd, msgs);
			case CenrepPackage.KEY__VALUE:
				return ((InternalEList<?>)getValue()).basicRemove(otherEnd, msgs);
			case CenrepPackage.KEY__BITS:
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
			case CenrepPackage.KEY__REF:
				return getRef();
			case CenrepPackage.KEY__GVALUE:
				return getGvalue();
			case CenrepPackage.KEY__RFS:
				return isRfs() ? Boolean.TRUE : Boolean.FALSE;
			case CenrepPackage.KEY__READ_ONLY:
				return isReadOnly() ? Boolean.TRUE : Boolean.FALSE;
			case CenrepPackage.KEY__ACCESS:
				return getAccess();
			case CenrepPackage.KEY__READ_ACCESS:
				return getReadAccess();
			case CenrepPackage.KEY__WRITE_ACCESS:
				return getWriteAccess();
			case CenrepPackage.KEY__GACCESS:
				return getGAccess();
			case CenrepPackage.KEY__BACKUP:
				return isBackup() ? Boolean.TRUE : Boolean.FALSE;
			case CenrepPackage.KEY__NAME:
				return getName();
			case CenrepPackage.KEY__IDENT:
				return getIdent();
			case CenrepPackage.KEY__TYPE:
				return getType();
			case CenrepPackage.KEY__VALUE:
				return getValue();
			case CenrepPackage.KEY__BITS:
				return getBits();
			case CenrepPackage.KEY__BITMASK_KEY:
				return isBitmaskKey() ? Boolean.TRUE : Boolean.FALSE;
			case CenrepPackage.KEY__SIMPLE_KEY:
				return isSimpleKey() ? Boolean.TRUE : Boolean.FALSE;
			case CenrepPackage.KEY__SHORT_IDENT:
				return getShortIdent();
			case CenrepPackage.KEY__STR_TYPE:
				return getStrType();
			case CenrepPackage.KEY__DEC_FORMAT:
				return isDecFormat() ? Boolean.TRUE : Boolean.FALSE;
			case CenrepPackage.KEY__HEX_FORMAT:
				return isHexFormat() ? Boolean.TRUE : Boolean.FALSE;
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
			case CenrepPackage.KEY__REF:
				setRef((String)newValue);
				return;
			case CenrepPackage.KEY__GVALUE:
				setGvalue(newValue);
				return;
			case CenrepPackage.KEY__RFS:
				setRfs(((Boolean)newValue).booleanValue());
				return;
			case CenrepPackage.KEY__READ_ONLY:
				setReadOnly(((Boolean)newValue).booleanValue());
				return;
			case CenrepPackage.KEY__ACCESS:
				getAccess().clear();
				getAccess().addAll((Collection<? extends Access>)newValue);
				return;
			case CenrepPackage.KEY__READ_ACCESS:
				setReadAccess((Access)newValue);
				return;
			case CenrepPackage.KEY__WRITE_ACCESS:
				setWriteAccess((Access)newValue);
				return;
			case CenrepPackage.KEY__BACKUP:
				setBackup(((Boolean)newValue).booleanValue());
				return;
			case CenrepPackage.KEY__NAME:
				setName((String)newValue);
				return;
			case CenrepPackage.KEY__IDENT:
				setIdent((String)newValue);
				return;
			case CenrepPackage.KEY__TYPE:
				setType((TYPE)newValue);
				return;
			case CenrepPackage.KEY__VALUE:
				getValue().clear();
				getValue().addAll((Collection<? extends Value>)newValue);
				return;
			case CenrepPackage.KEY__BITS:
				getBits().clear();
				getBits().addAll((Collection<? extends Bit>)newValue);
				return;
			case CenrepPackage.KEY__BITMASK_KEY:
				setBitmaskKey(((Boolean)newValue).booleanValue());
				return;
			case CenrepPackage.KEY__SIMPLE_KEY:
				setSimpleKey(((Boolean)newValue).booleanValue());
				return;
			case CenrepPackage.KEY__SHORT_IDENT:
				setShortIdent((String)newValue);
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
			case CenrepPackage.KEY__REF:
				setRef(REF_EDEFAULT);
				return;
			case CenrepPackage.KEY__GVALUE:
				setGvalue(GVALUE_EDEFAULT);
				return;
			case CenrepPackage.KEY__RFS:
				setRfs(RFS_EDEFAULT);
				return;
			case CenrepPackage.KEY__READ_ONLY:
				setReadOnly(READ_ONLY_EDEFAULT);
				return;
			case CenrepPackage.KEY__ACCESS:
				getAccess().clear();
				return;
			case CenrepPackage.KEY__READ_ACCESS:
				setReadAccess((Access)null);
				return;
			case CenrepPackage.KEY__WRITE_ACCESS:
				setWriteAccess((Access)null);
				return;
			case CenrepPackage.KEY__BACKUP:
				setBackup(BACKUP_EDEFAULT);
				return;
			case CenrepPackage.KEY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CenrepPackage.KEY__IDENT:
				setIdent(IDENT_EDEFAULT);
				return;
			case CenrepPackage.KEY__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case CenrepPackage.KEY__VALUE:
				getValue().clear();
				return;
			case CenrepPackage.KEY__BITS:
				getBits().clear();
				return;
			case CenrepPackage.KEY__BITMASK_KEY:
				setBitmaskKey(BITMASK_KEY_EDEFAULT);
				return;
			case CenrepPackage.KEY__SIMPLE_KEY:
				setSimpleKey(SIMPLE_KEY_EDEFAULT);
				return;
			case CenrepPackage.KEY__SHORT_IDENT:
				setShortIdent(SHORT_IDENT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CenrepPackage.KEY__REF:
				return REF_EDEFAULT == null ? ref != null : !REF_EDEFAULT.equals(ref);
			case CenrepPackage.KEY__GVALUE:
				return GVALUE_EDEFAULT == null ? gvalue != null : !GVALUE_EDEFAULT.equals(gvalue);
			case CenrepPackage.KEY__RFS:
				return rfs != RFS_EDEFAULT;
			case CenrepPackage.KEY__READ_ONLY:
				return readOnly != READ_ONLY_EDEFAULT;
			case CenrepPackage.KEY__ACCESS:
				return access != null && !access.isEmpty();
			case CenrepPackage.KEY__READ_ACCESS:
				return getReadAccess() != null;
			case CenrepPackage.KEY__WRITE_ACCESS:
				return getWriteAccess() != null;
			case CenrepPackage.KEY__GACCESS:
				return GACCESS_EDEFAULT == null ? getGAccess() != null : !GACCESS_EDEFAULT.equals(getGAccess());
			case CenrepPackage.KEY__BACKUP:
				return backup != BACKUP_EDEFAULT;
			case CenrepPackage.KEY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CenrepPackage.KEY__IDENT:
				return IDENT_EDEFAULT == null ? ident != null : !IDENT_EDEFAULT.equals(ident);
			case CenrepPackage.KEY__TYPE:
				return true;//type != TYPE_EDEFAULT;
			case CenrepPackage.KEY__VALUE:
				return value != null && !value.isEmpty();
			case CenrepPackage.KEY__BITS:
				return bits != null && !bits.isEmpty();
			case CenrepPackage.KEY__BITMASK_KEY:
				return isBitmaskKey() != BITMASK_KEY_EDEFAULT;
			case CenrepPackage.KEY__SIMPLE_KEY:
				return isSimpleKey() != SIMPLE_KEY_EDEFAULT;
			case CenrepPackage.KEY__SHORT_IDENT:
				return SHORT_IDENT_EDEFAULT == null ? getShortIdent() != null : !SHORT_IDENT_EDEFAULT.equals(getShortIdent());
			case CenrepPackage.KEY__STR_TYPE:
				return STR_TYPE_EDEFAULT == null ? getStrType() != null : !STR_TYPE_EDEFAULT.equals(getStrType());
			case CenrepPackage.KEY__DEC_FORMAT:
				return isDecFormat() != DEC_FORMAT_EDEFAULT;
			case CenrepPackage.KEY__HEX_FORMAT:
				return isHexFormat() != HEX_FORMAT_EDEFAULT;
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
				case CenrepPackage.KEY__REF: return CenrepPackage.RVG__REF;
				case CenrepPackage.KEY__GVALUE: return CenrepPackage.RVG__GVALUE;
				case CenrepPackage.KEY__RFS: return CenrepPackage.RVG__RFS;
				default: return -1;
			}
		}
		if (baseClass == IReadOnly.class) {
			switch (derivedFeatureID) {
				case CenrepPackage.KEY__READ_ONLY: return CenrepPackage.IREAD_ONLY__READ_ONLY;
				default: return -1;
			}
		}
		if (baseClass == IAccessable.class) {
			switch (derivedFeatureID) {
				case CenrepPackage.KEY__ACCESS: return CenrepPackage.IACCESSABLE__ACCESS;
				case CenrepPackage.KEY__READ_ACCESS: return CenrepPackage.IACCESSABLE__READ_ACCESS;
				case CenrepPackage.KEY__WRITE_ACCESS: return CenrepPackage.IACCESSABLE__WRITE_ACCESS;
				case CenrepPackage.KEY__GACCESS: return CenrepPackage.IACCESSABLE__GACCESS;
				default: return -1;
			}
		}
		if (baseClass == IBackup.class) {
			switch (derivedFeatureID) {
				case CenrepPackage.KEY__BACKUP: return CenrepPackage.IBACKUP__BACKUP;
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
				case CenrepPackage.RVG__REF: return CenrepPackage.KEY__REF;
				case CenrepPackage.RVG__GVALUE: return CenrepPackage.KEY__GVALUE;
				case CenrepPackage.RVG__RFS: return CenrepPackage.KEY__RFS;
				default: return -1;
			}
		}
		if (baseClass == IReadOnly.class) {
			switch (baseFeatureID) {
				case CenrepPackage.IREAD_ONLY__READ_ONLY: return CenrepPackage.KEY__READ_ONLY;
				default: return -1;
			}
		}
		if (baseClass == IAccessable.class) {
			switch (baseFeatureID) {
				case CenrepPackage.IACCESSABLE__ACCESS: return CenrepPackage.KEY__ACCESS;
				case CenrepPackage.IACCESSABLE__READ_ACCESS: return CenrepPackage.KEY__READ_ACCESS;
				case CenrepPackage.IACCESSABLE__WRITE_ACCESS: return CenrepPackage.KEY__WRITE_ACCESS;
				case CenrepPackage.IACCESSABLE__GACCESS: return CenrepPackage.KEY__GACCESS;
				default: return -1;
			}
		}
		if (baseClass == IBackup.class) {
			switch (baseFeatureID) {
				case CenrepPackage.IBACKUP__BACKUP: return CenrepPackage.KEY__BACKUP;
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
		result.append(", ident: ");
		result.append(ident);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //KeyImpl