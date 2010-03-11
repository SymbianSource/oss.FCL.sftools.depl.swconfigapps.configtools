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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import cenrep.Bit;
import cenrep.CenrepPackage;
import cenrep.Key;
import cenrep.RVG;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cenrep.impl.BitImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link cenrep.impl.BitImpl#getGvalue <em>Gvalue</em>}</li>
 *   <li>{@link cenrep.impl.BitImpl#isRfs <em>Rfs</em>}</li>
 *   <li>{@link cenrep.impl.BitImpl#isState <em>State</em>}</li>
 *   <li>{@link cenrep.impl.BitImpl#getNumber <em>Number</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BitImpl extends ContentImpl implements Bit {
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
	 * The default value of the '{@link #isState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isState()
	 * @generated NOT
	 * @ordered 
	 */
	protected static final boolean STATE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isState()
	 * @generated
	 * @ordered
	 */
	protected boolean state = STATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_EDEFAULT = 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CenrepPackage.Literals.BIT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.BIT__REF, oldRef, ref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getGvalue() {
		//return gvalue!=null?gvalue:"false"; 
		return (String)gvalue; //fix for Ticket #109 Error in Bitmask key generating
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
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.BIT__GVALUE, oldGvalue, gvalue));
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
	 * @generated NOT
	 */
	public void setRfs(boolean newRfs) {
		Key key = (Key)this.eContainer();
		if(!key.isRfs())key.setRfs(newRfs);
		this.rfs=newRfs;
	}

	

	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isState() {
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(boolean newState) {
		boolean oldState = state;
		state = newState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.BIT__STATE, oldState, state));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getNumber() {
		if(getValue()!=null){
			if(getValue().compareTo("-9223372036854775807")==0)
				System.out.println("!");
			return Integer.valueOf(getValue());
		}
		return -1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setNumber(int newNumber) {
		setValue(String.valueOf(newNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean canGenerate() {
		return getGvalue()!=null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	String configuration = null;
	public void setGConf(String confName) {
		this.configuration = confName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	int prio=-1;
	public void setPriority(String prio) {
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
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getGPriority() {
		return prio;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CenrepPackage.BIT__REF:
				return getRef();
			case CenrepPackage.BIT__GVALUE:
				return getGvalue();
			case CenrepPackage.BIT__RFS:
				return isRfs() ? Boolean.TRUE : Boolean.FALSE;
			case CenrepPackage.BIT__STATE:
				return isState() ? Boolean.TRUE : Boolean.FALSE;
			case CenrepPackage.BIT__NUMBER:
				return new Integer(getNumber());
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CenrepPackage.BIT__REF:
				setRef((String)newValue);
				return;
			case CenrepPackage.BIT__GVALUE:
				setGvalue(newValue);
				return;
			case CenrepPackage.BIT__RFS:
				setRfs(((Boolean)newValue).booleanValue());
				return;
			case CenrepPackage.BIT__STATE:
				setState(((Boolean)newValue).booleanValue());
				return;
			case CenrepPackage.BIT__NUMBER:
				setNumber(((Integer)newValue).intValue());
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
			case CenrepPackage.BIT__REF:
				setRef(REF_EDEFAULT);
				return;
			case CenrepPackage.BIT__GVALUE:
				setGvalue(GVALUE_EDEFAULT);
				return;
			case CenrepPackage.BIT__RFS:
				setRfs(RFS_EDEFAULT);
				return;
			case CenrepPackage.BIT__STATE:
				setState(STATE_EDEFAULT);
				return;
			case CenrepPackage.BIT__NUMBER:
				setNumber(NUMBER_EDEFAULT);
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
			case CenrepPackage.BIT__REF:
				return REF_EDEFAULT == null ? ref != null : !REF_EDEFAULT.equals(ref);
			case CenrepPackage.BIT__GVALUE:
				return GVALUE_EDEFAULT == null ? gvalue != null : !GVALUE_EDEFAULT.equals(gvalue);
			case CenrepPackage.BIT__RFS:
				return rfs != RFS_EDEFAULT;
			case CenrepPackage.BIT__STATE:
				return state != STATE_EDEFAULT;
			case CenrepPackage.BIT__NUMBER:
				return getNumber() != NUMBER_EDEFAULT;
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
				case CenrepPackage.BIT__REF: return CenrepPackage.RVG__REF;
				case CenrepPackage.BIT__GVALUE: return CenrepPackage.RVG__GVALUE;
				case CenrepPackage.BIT__RFS: return CenrepPackage.RVG__RFS;
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
				case CenrepPackage.RVG__REF: return CenrepPackage.BIT__REF;
				case CenrepPackage.RVG__GVALUE: return CenrepPackage.BIT__GVALUE;
				case CenrepPackage.RVG__RFS: return CenrepPackage.BIT__RFS;
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
		result.append(", state: ");
		result.append(state);
		result.append(')');
		return result.toString();
	}

} //BitImpl
