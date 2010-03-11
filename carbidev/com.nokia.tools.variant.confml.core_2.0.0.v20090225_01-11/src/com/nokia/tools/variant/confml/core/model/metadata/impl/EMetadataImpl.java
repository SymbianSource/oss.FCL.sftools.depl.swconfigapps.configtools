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

package com.nokia.tools.variant.confml.core.model.metadata.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.nokia.tools.variant.confml.core.model.metadata.EMetaComponent;
import com.nokia.tools.variant.confml.core.model.metadata.EMetaProperty;
import com.nokia.tools.variant.confml.core.model.metadata.EMetadata;
import com.nokia.tools.variant.confml.core.model.metadata.EMetadataPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EMetadata</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.metadata.impl.EMetadataImpl#getComponents <em>Components</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.metadata.impl.EMetadataImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EMetadataImpl extends EObjectImpl implements EMetadata {
	/**
     * The cached value of the '{@link #getComponents() <em>Components</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getComponents()
     * @generated
     * @ordered
     */
	protected EList<EMetaComponent> components;

	/**
     * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getProperties()
     * @generated
     * @ordered
     */
	protected EList<EMetaProperty> properties;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EMetadataImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return EMetadataPackage.Literals.EMETADATA;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<EMetaComponent> getComponents() {
        if (components == null) {
            components = new EObjectContainmentEList<EMetaComponent>(EMetaComponent.class, this, EMetadataPackage.EMETADATA__COMPONENTS);
        }
        return components;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<EMetaProperty> getProperties() {
        if (properties == null) {
            properties = new EObjectContainmentEList<EMetaProperty>(EMetaProperty.class, this, EMetadataPackage.EMETADATA__PROPERTIES);
        }
        return properties;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case EMetadataPackage.EMETADATA__COMPONENTS:
                return ((InternalEList<?>)getComponents()).basicRemove(otherEnd, msgs);
            case EMetadataPackage.EMETADATA__PROPERTIES:
                return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
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
            case EMetadataPackage.EMETADATA__COMPONENTS:
                return getComponents();
            case EMetadataPackage.EMETADATA__PROPERTIES:
                return getProperties();
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
            case EMetadataPackage.EMETADATA__COMPONENTS:
                getComponents().clear();
                getComponents().addAll((Collection<? extends EMetaComponent>)newValue);
                return;
            case EMetadataPackage.EMETADATA__PROPERTIES:
                getProperties().clear();
                getProperties().addAll((Collection<? extends EMetaProperty>)newValue);
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
            case EMetadataPackage.EMETADATA__COMPONENTS:
                getComponents().clear();
                return;
            case EMetadataPackage.EMETADATA__PROPERTIES:
                getProperties().clear();
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
            case EMetadataPackage.EMETADATA__COMPONENTS:
                return components != null && !components.isEmpty();
            case EMetadataPackage.EMETADATA__PROPERTIES:
                return properties != null && !properties.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //EMetadataImpl
