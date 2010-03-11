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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.nokia.tools.vct.gcfml.gcfmlmodel.EGCFMLPackage;
import com.nokia.tools.vct.gcfml.gcfmlmodel.EOutput;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EOutput</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.gcfml.gcfmlmodel.impl.EOutputImpl#getMethod <em>Method</em>}</li>
 *   <li>{@link com.nokia.tools.vct.gcfml.gcfmlmodel.impl.EOutputImpl#getEncoding <em>Encoding</em>}</li>
 *   <li>{@link com.nokia.tools.vct.gcfml.gcfmlmodel.impl.EOutputImpl#getIndent <em>Indent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EOutputImpl extends EObjectImpl implements EOutput {
	/**
	 * The default value of the '{@link #getMethod() <em>Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethod()
	 * @generated
	 * @ordered
	 */
	protected static final String METHOD_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getMethod() <em>Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethod()
	 * @generated
	 * @ordered
	 */
	protected String method = METHOD_EDEFAULT;
	/**
	 * The default value of the '{@link #getEncoding() <em>Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEncoding()
	 * @generated
	 * @ordered
	 */
	protected static final String ENCODING_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getEncoding() <em>Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEncoding()
	 * @generated
	 * @ordered
	 */
	protected String encoding = ENCODING_EDEFAULT;

	/**
	 * The default value of the '{@link #getIndent() <em>Indent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndent()
	 * @generated
	 * @ordered
	 */
	protected static final String INDENT_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getIndent() <em>Indent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndent()
	 * @generated
	 * @ordered
	 */
	protected String indent = INDENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EOutputImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EGCFMLPackage.Literals.EOUTPUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMethod(String newMethod) {
		String oldMethod = method;
		method = newMethod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EGCFMLPackage.EOUTPUT__METHOD, oldMethod, method));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEncoding() {
		return encoding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEncoding(String newEncoding) {
		String oldEncoding = encoding;
		encoding = newEncoding;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EGCFMLPackage.EOUTPUT__ENCODING, oldEncoding, encoding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIndent() {
		return indent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndent(String newIndent) {
		String oldIndent = indent;
		indent = newIndent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EGCFMLPackage.EOUTPUT__INDENT, oldIndent, indent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EGCFMLPackage.EOUTPUT__METHOD:
				return getMethod();
			case EGCFMLPackage.EOUTPUT__ENCODING:
				return getEncoding();
			case EGCFMLPackage.EOUTPUT__INDENT:
				return getIndent();
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
			case EGCFMLPackage.EOUTPUT__METHOD:
				setMethod((String)newValue);
				return;
			case EGCFMLPackage.EOUTPUT__ENCODING:
				setEncoding((String)newValue);
				return;
			case EGCFMLPackage.EOUTPUT__INDENT:
				setIndent((String)newValue);
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
			case EGCFMLPackage.EOUTPUT__METHOD:
				setMethod(METHOD_EDEFAULT);
				return;
			case EGCFMLPackage.EOUTPUT__ENCODING:
				setEncoding(ENCODING_EDEFAULT);
				return;
			case EGCFMLPackage.EOUTPUT__INDENT:
				setIndent(INDENT_EDEFAULT);
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
			case EGCFMLPackage.EOUTPUT__METHOD:
				return METHOD_EDEFAULT == null ? method != null : !METHOD_EDEFAULT.equals(method);
			case EGCFMLPackage.EOUTPUT__ENCODING:
				return ENCODING_EDEFAULT == null ? encoding != null : !ENCODING_EDEFAULT.equals(encoding);
			case EGCFMLPackage.EOUTPUT__INDENT:
				return INDENT_EDEFAULT == null ? indent != null : !INDENT_EDEFAULT.equals(indent);
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
		result.append(" (method: ");
		result.append(method);
		result.append(", encoding: ");
		result.append(encoding);
		result.append(", indent: ");
		result.append(indent);
		result.append(')');
		return result.toString();
	}

} //EOutputImpl
