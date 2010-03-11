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
 * Description: This file is part of com.nokia.tools.vct.ibyml component.
 */

package com.nokia.tools.vct.ibyml.ibymodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.nokia.tools.vct.ibyml.ibymodel.EEntity;
import com.nokia.tools.vct.ibyml.ibymodel.EEntry;
import com.nokia.tools.vct.ibyml.ibymodel.EFileName;
import com.nokia.tools.vct.ibyml.ibymodel.EIBYModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EEntry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.ibyml.ibymodel.impl.EEntryImpl#getSource <em>Source</em>}</li>
 *   <li>{@link com.nokia.tools.vct.ibyml.ibymodel.impl.EEntryImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link com.nokia.tools.vct.ibyml.ibymodel.impl.EEntryImpl#getFileName <em>File Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EEntryImpl extends EObjectImpl implements EEntry {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected EEntity source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected EEntity target;

	/**
	 * The cached value of the '{@link #getFileName() <em>File Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileName()
	 * @generated
	 * @ordered
	 */
	protected EFileName fileName;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EIBYModelPackage.Literals.EENTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEntity getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(EEntity newSource, NotificationChain msgs) {
		EEntity oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EIBYModelPackage.EENTRY__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(EEntity newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EIBYModelPackage.EENTRY__SOURCE, null, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EIBYModelPackage.EENTRY__SOURCE, null, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EIBYModelPackage.EENTRY__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEntity getTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(EEntity newTarget, NotificationChain msgs) {
		EEntity oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EIBYModelPackage.EENTRY__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(EEntity newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EIBYModelPackage.EENTRY__TARGET, null, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EIBYModelPackage.EENTRY__TARGET, null, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EIBYModelPackage.EENTRY__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EFileName getFileName() {
		return fileName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFileName(EFileName newFileName, NotificationChain msgs) {
		EFileName oldFileName = fileName;
		fileName = newFileName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EIBYModelPackage.EENTRY__FILE_NAME, oldFileName, newFileName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFileName(EFileName newFileName) {
		if (newFileName != fileName) {
			NotificationChain msgs = null;
			if (fileName != null)
				msgs = ((InternalEObject)fileName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EIBYModelPackage.EENTRY__FILE_NAME, null, msgs);
			if (newFileName != null)
				msgs = ((InternalEObject)newFileName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EIBYModelPackage.EENTRY__FILE_NAME, null, msgs);
			msgs = basicSetFileName(newFileName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EIBYModelPackage.EENTRY__FILE_NAME, newFileName, newFileName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EIBYModelPackage.EENTRY__SOURCE:
				return basicSetSource(null, msgs);
			case EIBYModelPackage.EENTRY__TARGET:
				return basicSetTarget(null, msgs);
			case EIBYModelPackage.EENTRY__FILE_NAME:
				return basicSetFileName(null, msgs);
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
			case EIBYModelPackage.EENTRY__SOURCE:
				return getSource();
			case EIBYModelPackage.EENTRY__TARGET:
				return getTarget();
			case EIBYModelPackage.EENTRY__FILE_NAME:
				return getFileName();
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
			case EIBYModelPackage.EENTRY__SOURCE:
				setSource((EEntity)newValue);
				return;
			case EIBYModelPackage.EENTRY__TARGET:
				setTarget((EEntity)newValue);
				return;
			case EIBYModelPackage.EENTRY__FILE_NAME:
				setFileName((EFileName)newValue);
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
			case EIBYModelPackage.EENTRY__SOURCE:
				setSource((EEntity)null);
				return;
			case EIBYModelPackage.EENTRY__TARGET:
				setTarget((EEntity)null);
				return;
			case EIBYModelPackage.EENTRY__FILE_NAME:
				setFileName((EFileName)null);
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
			case EIBYModelPackage.EENTRY__SOURCE:
				return source != null;
			case EIBYModelPackage.EENTRY__TARGET:
				return target != null;
			case EIBYModelPackage.EENTRY__FILE_NAME:
				return fileName != null;
		}
		return super.eIsSet(featureID);
	}

} //EEntryImpl
