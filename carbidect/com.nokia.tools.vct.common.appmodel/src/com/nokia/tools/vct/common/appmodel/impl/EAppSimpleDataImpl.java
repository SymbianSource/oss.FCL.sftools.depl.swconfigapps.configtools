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
 * Description: This file is part of com.nokia.tools.vct.common.appmodel component.
 */

package com.nokia.tools.vct.common.appmodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import com.nokia.tools.vct.common.appmodel.EAppExpression;
import com.nokia.tools.vct.common.appmodel.EAppSettingType;
import com.nokia.tools.vct.common.appmodel.EAppSimpleData;
import com.nokia.tools.vct.common.appmodel.EApplicationPackage;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EApp Simple Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSimpleDataImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSimpleDataImpl#getTypeInfo <em>Type Info</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSimpleDataImpl#getValue <em>Value</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSimpleDataImpl#getMap <em>Map</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EAppSimpleDataImpl extends EObjectImpl implements EAppSimpleData {
	/**
	 * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected EList<URI> uri;

	/**
	 * The cached value of the '{@link #getTypeInfo() <em>Type Info</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeInfo()
	 * @generated
	 * @ordered
	 */
	protected EAppSettingType typeInfo;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMap() <em>Map</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMap()
	 * @generated
	 * @ordered
	 */
	protected static final String MAP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMap() <em>Map</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMap()
	 * @generated
	 * @ordered
	 */
	protected String map = MAP_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EAppSimpleDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EApplicationPackage.Literals.EAPP_SIMPLE_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<URI> getUri() {
		if (uri == null) {
			uri = new EDataTypeUniqueEList<URI>(URI.class, this, EApplicationPackage.EAPP_SIMPLE_DATA__URI);
		}
		return uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAppSettingType getTypeInfo() {
		if (typeInfo != null && typeInfo.eIsProxy()) {
			InternalEObject oldTypeInfo = (InternalEObject)typeInfo;
			typeInfo = (EAppSettingType)eResolveProxy(oldTypeInfo);
			if (typeInfo != oldTypeInfo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EApplicationPackage.EAPP_SIMPLE_DATA__TYPE_INFO, oldTypeInfo, typeInfo));
			}
		}
		return typeInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAppSettingType basicGetTypeInfo() {
		return typeInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeInfo(EAppSettingType newTypeInfo) {
		EAppSettingType oldTypeInfo = typeInfo;
		typeInfo = newTypeInfo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SIMPLE_DATA__TYPE_INFO, oldTypeInfo, typeInfo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SIMPLE_DATA__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMap() {
		return map;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMap(String newMap) {
		String oldMap = map;
		map = newMap;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SIMPLE_DATA__MAP, oldMap, map));
	}

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    public boolean computeRelevant() {
        EAppSettingType typeInfo = getTypeInfo();
        if (typeInfo == null) {
            return false;
        }
        EAppExpression expr = typeInfo.getRelevant();
        if (expr == null) {
            return false;
        }
        EObject root = this;
        while (true) {
            if (root.eContainer() == null) {
                break;
            }
            root = root.eContainer();
            if (root instanceof EConfMLLayer) {
                break;
            }
        }
        
        return expr.computeBoolean(root, this);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    public boolean computeConstraint() {
        EAppSettingType typeInfo = getTypeInfo();
        if (typeInfo == null) {
            return false;
        }
        EAppExpression expr = typeInfo.getConstraint();
        if (expr == null) {
            return false;
        }
        EObject root = this;
        while (true) {
            if (root.eContainer() == null) {
                break;
            }
            root = root.eContainer();
            if (root instanceof EConfMLLayer) {
                break;
            }
        }
        
        return expr.computeBoolean(root, this);
    }

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EApplicationPackage.EAPP_SIMPLE_DATA__URI:
				return getUri();
			case EApplicationPackage.EAPP_SIMPLE_DATA__TYPE_INFO:
				if (resolve) return getTypeInfo();
				return basicGetTypeInfo();
			case EApplicationPackage.EAPP_SIMPLE_DATA__VALUE:
				return getValue();
			case EApplicationPackage.EAPP_SIMPLE_DATA__MAP:
				return getMap();
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
			case EApplicationPackage.EAPP_SIMPLE_DATA__URI:
				getUri().clear();
				getUri().addAll((Collection<? extends URI>)newValue);
				return;
			case EApplicationPackage.EAPP_SIMPLE_DATA__TYPE_INFO:
				setTypeInfo((EAppSettingType)newValue);
				return;
			case EApplicationPackage.EAPP_SIMPLE_DATA__VALUE:
				setValue((String)newValue);
				return;
			case EApplicationPackage.EAPP_SIMPLE_DATA__MAP:
				setMap((String)newValue);
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
			case EApplicationPackage.EAPP_SIMPLE_DATA__URI:
				getUri().clear();
				return;
			case EApplicationPackage.EAPP_SIMPLE_DATA__TYPE_INFO:
				setTypeInfo((EAppSettingType)null);
				return;
			case EApplicationPackage.EAPP_SIMPLE_DATA__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case EApplicationPackage.EAPP_SIMPLE_DATA__MAP:
				setMap(MAP_EDEFAULT);
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
			case EApplicationPackage.EAPP_SIMPLE_DATA__URI:
				return uri != null && !uri.isEmpty();
			case EApplicationPackage.EAPP_SIMPLE_DATA__TYPE_INFO:
				return typeInfo != null;
			case EApplicationPackage.EAPP_SIMPLE_DATA__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case EApplicationPackage.EAPP_SIMPLE_DATA__MAP:
				return MAP_EDEFAULT == null ? map != null : !MAP_EDEFAULT.equals(map);
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
		result.append(" (uri: ");
		result.append(uri);
		result.append(", value: ");
		result.append(value);
		result.append(", map: ");
		result.append(map);
		result.append(')');
		return result.toString();
	}

} //EAppSimpleDataImpl
