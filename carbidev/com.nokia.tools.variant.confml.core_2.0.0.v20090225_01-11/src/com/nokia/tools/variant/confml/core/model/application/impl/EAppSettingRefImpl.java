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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.nokia.tools.variant.confml.core.model.application.EAppDescriptionContainer;
import com.nokia.tools.variant.confml.core.model.application.EAppOptionContainer;
import com.nokia.tools.variant.confml.core.model.application.EAppProperty;
import com.nokia.tools.variant.confml.core.model.application.EAppSetting;
import com.nokia.tools.variant.confml.core.model.application.EAppSettingOption;
import com.nokia.tools.variant.confml.core.model.application.EAppSettingRef;
import com.nokia.tools.variant.confml.core.model.application.EApplicationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EApp Setting Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppSettingRefImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppSettingRefImpl#getOptions <em>Options</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppSettingRefImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppSettingRefImpl#getResolved <em>Resolved</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppSettingRefImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EAppSettingRefImpl extends EObjectImpl implements EAppSettingRef {
	/**
     * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getProperties()
     * @generated
     * @ordered
     */
	protected EList<EAppProperty> properties;
	/**
     * The cached value of the '{@link #getOptions() <em>Options</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getOptions()
     * @generated
     * @ordered
     */
	protected EList<EAppSettingOption> options;
	/**
     * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getDescription()
     * @generated
     * @ordered
     */
	protected static final String DESCRIPTION_EDEFAULT = null;
	/**
     * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getDescription()
     * @generated
     * @ordered
     */
	protected String description = DESCRIPTION_EDEFAULT;
	/**
     * The cached value of the '{@link #getResolved() <em>Resolved</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getResolved()
     * @generated
     * @ordered
     */
	protected EAppSetting resolved;
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
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EAppSettingRefImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return EApplicationPackage.Literals.EAPP_SETTING_REF;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<EAppProperty> getProperties() {
        if (properties == null) {
            properties = new EObjectContainmentEList<EAppProperty>(EAppProperty.class, this, EApplicationPackage.EAPP_SETTING_REF__PROPERTIES);
        }
        return properties;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<EAppSettingOption> getOptions() {
        if (options == null) {
            options = new EObjectContainmentEList<EAppSettingOption>(EAppSettingOption.class, this, EApplicationPackage.EAPP_SETTING_REF__OPTIONS);
        }
        return options;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAppSetting getResolved() {
        if (resolved != null && resolved.eIsProxy()) {
            InternalEObject oldResolved = (InternalEObject)resolved;
            resolved = (EAppSetting)eResolveProxy(oldResolved);
            if (resolved != oldResolved) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, EApplicationPackage.EAPP_SETTING_REF__RESOLVED, oldResolved, resolved));
            }
        }
        return resolved;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAppSetting basicGetResolved() {
        return resolved;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setResolved(EAppSetting newResolved) {
        EAppSetting oldResolved = resolved;
        resolved = newResolved;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SETTING_REF__RESOLVED, oldResolved, resolved));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getDescription() {
        return description;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setDescription(String newDescription) {
        String oldDescription = description;
        description = newDescription;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SETTING_REF__DESCRIPTION, oldDescription, description));
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
            eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SETTING_REF__NAME, oldName, name));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case EApplicationPackage.EAPP_SETTING_REF__PROPERTIES:
                return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
            case EApplicationPackage.EAPP_SETTING_REF__OPTIONS:
                return ((InternalEList<?>)getOptions()).basicRemove(otherEnd, msgs);
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
            case EApplicationPackage.EAPP_SETTING_REF__PROPERTIES:
                return getProperties();
            case EApplicationPackage.EAPP_SETTING_REF__OPTIONS:
                return getOptions();
            case EApplicationPackage.EAPP_SETTING_REF__DESCRIPTION:
                return getDescription();
            case EApplicationPackage.EAPP_SETTING_REF__RESOLVED:
                if (resolve) return getResolved();
                return basicGetResolved();
            case EApplicationPackage.EAPP_SETTING_REF__NAME:
                return getName();
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
            case EApplicationPackage.EAPP_SETTING_REF__PROPERTIES:
                getProperties().clear();
                getProperties().addAll((Collection<? extends EAppProperty>)newValue);
                return;
            case EApplicationPackage.EAPP_SETTING_REF__OPTIONS:
                getOptions().clear();
                getOptions().addAll((Collection<? extends EAppSettingOption>)newValue);
                return;
            case EApplicationPackage.EAPP_SETTING_REF__DESCRIPTION:
                setDescription((String)newValue);
                return;
            case EApplicationPackage.EAPP_SETTING_REF__RESOLVED:
                setResolved((EAppSetting)newValue);
                return;
            case EApplicationPackage.EAPP_SETTING_REF__NAME:
                setName((String)newValue);
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
            case EApplicationPackage.EAPP_SETTING_REF__PROPERTIES:
                getProperties().clear();
                return;
            case EApplicationPackage.EAPP_SETTING_REF__OPTIONS:
                getOptions().clear();
                return;
            case EApplicationPackage.EAPP_SETTING_REF__DESCRIPTION:
                setDescription(DESCRIPTION_EDEFAULT);
                return;
            case EApplicationPackage.EAPP_SETTING_REF__RESOLVED:
                setResolved((EAppSetting)null);
                return;
            case EApplicationPackage.EAPP_SETTING_REF__NAME:
                setName(NAME_EDEFAULT);
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
            case EApplicationPackage.EAPP_SETTING_REF__PROPERTIES:
                return properties != null && !properties.isEmpty();
            case EApplicationPackage.EAPP_SETTING_REF__OPTIONS:
                return options != null && !options.isEmpty();
            case EApplicationPackage.EAPP_SETTING_REF__DESCRIPTION:
                return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
            case EApplicationPackage.EAPP_SETTING_REF__RESOLVED:
                return resolved != null;
            case EApplicationPackage.EAPP_SETTING_REF__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
        if (baseClass == EAppOptionContainer.class) {
            switch (derivedFeatureID) {
                case EApplicationPackage.EAPP_SETTING_REF__OPTIONS: return EApplicationPackage.EAPP_OPTION_CONTAINER__OPTIONS;
                default: return -1;
            }
        }
        if (baseClass == EAppDescriptionContainer.class) {
            switch (derivedFeatureID) {
                case EApplicationPackage.EAPP_SETTING_REF__DESCRIPTION: return EApplicationPackage.EAPP_DESCRIPTION_CONTAINER__DESCRIPTION;
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
        if (baseClass == EAppOptionContainer.class) {
            switch (baseFeatureID) {
                case EApplicationPackage.EAPP_OPTION_CONTAINER__OPTIONS: return EApplicationPackage.EAPP_SETTING_REF__OPTIONS;
                default: return -1;
            }
        }
        if (baseClass == EAppDescriptionContainer.class) {
            switch (baseFeatureID) {
                case EApplicationPackage.EAPP_DESCRIPTION_CONTAINER__DESCRIPTION: return EApplicationPackage.EAPP_SETTING_REF__DESCRIPTION;
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
        result.append(" (description: ");
        result.append(description);
        result.append(", name: ");
        result.append(name);
        result.append(')');
        return result.toString();
    }

} //EAppSettingRefImpl
