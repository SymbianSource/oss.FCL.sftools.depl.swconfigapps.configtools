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
 * Description: This file is part of com.nokia.tools.vct.gcfml component.
 */

package com.nokia.tools.vct.gcfml.gcfmlmodel.impl;

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

import com.nokia.tools.vct.gcfml.gcfmlmodel.EFile;
import com.nokia.tools.vct.gcfml.gcfmlmodel.EGCFMLPackage;
import com.nokia.tools.vct.gcfml.gcfmlmodel.ESetting;
import com.nokia.tools.vct.gcfml.gcfmlmodel.EStylesheet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EFile</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.gcfml.gcfmlmodel.impl.EFileImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.vct.gcfml.gcfmlmodel.impl.EFileImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link com.nokia.tools.vct.gcfml.gcfmlmodel.impl.EFileImpl#getSetting <em>Setting</em>}</li>
 *   <li>{@link com.nokia.tools.vct.gcfml.gcfmlmodel.impl.EFileImpl#getStylesheet <em>Stylesheet</em>}</li>
 *   <li>{@link com.nokia.tools.vct.gcfml.gcfmlmodel.impl.EFileImpl#getLocation <em>Location</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EFileImpl extends EObjectImpl implements EFile {
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
	 * The default value of the '{@link #getTarget() <em>Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected String target = TARGET_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSetting() <em>Setting</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSetting()
	 * @generated
	 * @ordered
	 */
	protected EList<ESetting> setting;

	/**
	 * The cached value of the '{@link #getStylesheet() <em>Stylesheet</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStylesheet()
	 * @generated
	 * @ordered
	 */
	protected EStylesheet stylesheet;

	/**
	 * The default value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected String location = LOCATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EFileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EGCFMLPackage.Literals.EFILE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EGCFMLPackage.EFILE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(String newTarget) {
		String oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EGCFMLPackage.EFILE__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ESetting> getSetting() {
		if (setting == null) {
			setting = new EObjectContainmentEList<ESetting>(ESetting.class, this, EGCFMLPackage.EFILE__SETTING);
		}
		return setting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStylesheet getStylesheet() {
		return stylesheet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStylesheet(EStylesheet newStylesheet, NotificationChain msgs) {
		EStylesheet oldStylesheet = stylesheet;
		stylesheet = newStylesheet;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EGCFMLPackage.EFILE__STYLESHEET, oldStylesheet, newStylesheet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStylesheet(EStylesheet newStylesheet) {
		if (newStylesheet != stylesheet) {
			NotificationChain msgs = null;
			if (stylesheet != null)
				msgs = ((InternalEObject)stylesheet).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EGCFMLPackage.EFILE__STYLESHEET, null, msgs);
			if (newStylesheet != null)
				msgs = ((InternalEObject)newStylesheet).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EGCFMLPackage.EFILE__STYLESHEET, null, msgs);
			msgs = basicSetStylesheet(newStylesheet, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EGCFMLPackage.EFILE__STYLESHEET, newStylesheet, newStylesheet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocation(String newLocation) {
		String oldLocation = location;
		location = newLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EGCFMLPackage.EFILE__LOCATION, oldLocation, location));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EGCFMLPackage.EFILE__SETTING:
				return ((InternalEList<?>)getSetting()).basicRemove(otherEnd, msgs);
			case EGCFMLPackage.EFILE__STYLESHEET:
				return basicSetStylesheet(null, msgs);
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
			case EGCFMLPackage.EFILE__NAME:
				return getName();
			case EGCFMLPackage.EFILE__TARGET:
				return getTarget();
			case EGCFMLPackage.EFILE__SETTING:
				return getSetting();
			case EGCFMLPackage.EFILE__STYLESHEET:
				return getStylesheet();
			case EGCFMLPackage.EFILE__LOCATION:
				return getLocation();
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
			case EGCFMLPackage.EFILE__NAME:
				setName((String)newValue);
				return;
			case EGCFMLPackage.EFILE__TARGET:
				setTarget((String)newValue);
				return;
			case EGCFMLPackage.EFILE__SETTING:
				getSetting().clear();
				getSetting().addAll((Collection<? extends ESetting>)newValue);
				return;
			case EGCFMLPackage.EFILE__STYLESHEET:
				setStylesheet((EStylesheet)newValue);
				return;
			case EGCFMLPackage.EFILE__LOCATION:
				setLocation((String)newValue);
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
			case EGCFMLPackage.EFILE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EGCFMLPackage.EFILE__TARGET:
				setTarget(TARGET_EDEFAULT);
				return;
			case EGCFMLPackage.EFILE__SETTING:
				getSetting().clear();
				return;
			case EGCFMLPackage.EFILE__STYLESHEET:
				setStylesheet((EStylesheet)null);
				return;
			case EGCFMLPackage.EFILE__LOCATION:
				setLocation(LOCATION_EDEFAULT);
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
			case EGCFMLPackage.EFILE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EGCFMLPackage.EFILE__TARGET:
				return TARGET_EDEFAULT == null ? target != null : !TARGET_EDEFAULT.equals(target);
			case EGCFMLPackage.EFILE__SETTING:
				return setting != null && !setting.isEmpty();
			case EGCFMLPackage.EFILE__STYLESHEET:
				return stylesheet != null;
			case EGCFMLPackage.EFILE__LOCATION:
				return LOCATION_EDEFAULT == null ? location != null : !LOCATION_EDEFAULT.equals(location);
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
		result.append(", target: ");
		result.append(target);
		result.append(", location: ");
		result.append(location);
		result.append(')');
		return result.toString();
	}

} //EFileImpl
