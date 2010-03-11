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
 * Description: This file is part of com.nokia.tools.variant.confml.core component.
 */

package com.nokia.tools.variant.confml.core.model.application.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.nokia.tools.variant.confml.core.model.application.EAppCompositeData;
import com.nokia.tools.variant.confml.core.model.application.EAppDataContainer;
import com.nokia.tools.variant.confml.core.model.application.EAppExpression;
import com.nokia.tools.variant.confml.core.model.application.EAppSettingData;
import com.nokia.tools.variant.confml.core.model.application.EAppSettingType;
import com.nokia.tools.variant.confml.core.model.application.EApplicationPackage;
import com.nokia.tools.variant.confml.core.model.application.EConfMLLayer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EApp Composite Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppCompositeDataImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppCompositeDataImpl#getTypeInfo <em>Type Info</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppCompositeDataImpl#getSubSettings <em>Sub Settings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class EAppCompositeDataImpl extends EObjectImpl implements EAppCompositeData {
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
     * The cached value of the '{@link #getSubSettings() <em>Sub Settings</em>}' map.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSubSettings()
     * @generated
     * @ordered
     */
	protected EMap<String, EAppSettingData> subSettings;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EAppCompositeDataImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return EApplicationPackage.Literals.EAPP_COMPOSITE_DATA;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<URI> getUri() {
        if (uri == null) {
            uri = new EDataTypeUniqueEList<URI>(URI.class, this, EApplicationPackage.EAPP_COMPOSITE_DATA__URI);
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, EApplicationPackage.EAPP_COMPOSITE_DATA__TYPE_INFO, oldTypeInfo, typeInfo));
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
            eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_COMPOSITE_DATA__TYPE_INFO, oldTypeInfo, typeInfo));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EMap<String, EAppSettingData> getSubSettings() {
        if (subSettings == null) {
            subSettings = new EcoreEMap<String,EAppSettingData>(EApplicationPackage.Literals.EAPP_SUB_SETTING_DATA_ENTRY, EAppSubSettingDataEntryImpl.class, this, EApplicationPackage.EAPP_COMPOSITE_DATA__SUB_SETTINGS);
        }
        return subSettings;
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case EApplicationPackage.EAPP_COMPOSITE_DATA__SUB_SETTINGS:
                return ((InternalEList<?>)getSubSettings()).basicRemove(otherEnd, msgs);
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
            case EApplicationPackage.EAPP_COMPOSITE_DATA__URI:
                return getUri();
            case EApplicationPackage.EAPP_COMPOSITE_DATA__TYPE_INFO:
                if (resolve) return getTypeInfo();
                return basicGetTypeInfo();
            case EApplicationPackage.EAPP_COMPOSITE_DATA__SUB_SETTINGS:
                if (coreType) return getSubSettings();
                else return getSubSettings().map();
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
            case EApplicationPackage.EAPP_COMPOSITE_DATA__URI:
                getUri().clear();
                getUri().addAll((Collection<? extends URI>)newValue);
                return;
            case EApplicationPackage.EAPP_COMPOSITE_DATA__TYPE_INFO:
                setTypeInfo((EAppSettingType)newValue);
                return;
            case EApplicationPackage.EAPP_COMPOSITE_DATA__SUB_SETTINGS:
                ((EStructuralFeature.Setting)getSubSettings()).set(newValue);
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
            case EApplicationPackage.EAPP_COMPOSITE_DATA__URI:
                getUri().clear();
                return;
            case EApplicationPackage.EAPP_COMPOSITE_DATA__TYPE_INFO:
                setTypeInfo((EAppSettingType)null);
                return;
            case EApplicationPackage.EAPP_COMPOSITE_DATA__SUB_SETTINGS:
                getSubSettings().clear();
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
            case EApplicationPackage.EAPP_COMPOSITE_DATA__URI:
                return uri != null && !uri.isEmpty();
            case EApplicationPackage.EAPP_COMPOSITE_DATA__TYPE_INFO:
                return typeInfo != null;
            case EApplicationPackage.EAPP_COMPOSITE_DATA__SUB_SETTINGS:
                return subSettings != null && !subSettings.isEmpty();
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
        if (baseClass == EAppDataContainer.class) {
            switch (derivedFeatureID) {
                case EApplicationPackage.EAPP_COMPOSITE_DATA__SUB_SETTINGS: return EApplicationPackage.EAPP_DATA_CONTAINER__SUB_SETTINGS;
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
        if (baseClass == EAppDataContainer.class) {
            switch (baseFeatureID) {
                case EApplicationPackage.EAPP_DATA_CONTAINER__SUB_SETTINGS: return EApplicationPackage.EAPP_COMPOSITE_DATA__SUB_SETTINGS;
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
        result.append(" (uri: ");
        result.append(uri);
        result.append(')');
        return result.toString();
    }

} //EAppCompositeDataImpl
