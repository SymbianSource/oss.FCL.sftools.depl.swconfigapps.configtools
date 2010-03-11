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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.nokia.tools.vct.common.appmodel.EAppExpression;
import com.nokia.tools.vct.common.appmodel.EAppSequenceData;
import com.nokia.tools.vct.common.appmodel.EAppSequenceDataItem;
import com.nokia.tools.vct.common.appmodel.EAppSettingType;
import com.nokia.tools.vct.common.appmodel.EApplicationPackage;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EApp Sequence Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSequenceDataImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSequenceDataImpl#getTypeInfo <em>Type Info</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSequenceDataImpl#getItems <em>Items</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppSequenceDataImpl#getTemplate <em>Template</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EAppSequenceDataImpl extends EObjectImpl implements EAppSequenceData {
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
	 * The cached value of the '{@link #getItems() <em>Items</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItems()
	 * @generated
	 * @ordered
	 */
	protected EList<EAppSequenceDataItem> items;

	/**
	 * The cached value of the '{@link #getTemplate() <em>Template</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplate()
	 * @generated
	 * @ordered
	 */
	protected EAppSequenceDataItem template;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EAppSequenceDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EApplicationPackage.Literals.EAPP_SEQUENCE_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<URI> getUri() {
		if (uri == null) {
			uri = new EDataTypeUniqueEList<URI>(URI.class, this, EApplicationPackage.EAPP_SEQUENCE_DATA__URI);
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EApplicationPackage.EAPP_SEQUENCE_DATA__TYPE_INFO, oldTypeInfo, typeInfo));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SEQUENCE_DATA__TYPE_INFO, oldTypeInfo, typeInfo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EAppSequenceDataItem> getItems() {
		if (items == null) {
			items = new EObjectContainmentEList<EAppSequenceDataItem>(EAppSequenceDataItem.class, this, EApplicationPackage.EAPP_SEQUENCE_DATA__ITEMS);
		}
		return items;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAppSequenceDataItem getTemplate() {
		return template;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTemplate(EAppSequenceDataItem newTemplate, NotificationChain msgs) {
		EAppSequenceDataItem oldTemplate = template;
		template = newTemplate;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SEQUENCE_DATA__TEMPLATE, oldTemplate, newTemplate);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemplate(EAppSequenceDataItem newTemplate) {
		if (newTemplate != template) {
			NotificationChain msgs = null;
			if (template != null)
				msgs = ((InternalEObject)template).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EApplicationPackage.EAPP_SEQUENCE_DATA__TEMPLATE, null, msgs);
			if (newTemplate != null)
				msgs = ((InternalEObject)newTemplate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EApplicationPackage.EAPP_SEQUENCE_DATA__TEMPLATE, null, msgs);
			msgs = basicSetTemplate(newTemplate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_SEQUENCE_DATA__TEMPLATE, newTemplate, newTemplate));
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
			case EApplicationPackage.EAPP_SEQUENCE_DATA__ITEMS:
				return ((InternalEList<?>)getItems()).basicRemove(otherEnd, msgs);
			case EApplicationPackage.EAPP_SEQUENCE_DATA__TEMPLATE:
				return basicSetTemplate(null, msgs);
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
			case EApplicationPackage.EAPP_SEQUENCE_DATA__URI:
				return getUri();
			case EApplicationPackage.EAPP_SEQUENCE_DATA__TYPE_INFO:
				if (resolve) return getTypeInfo();
				return basicGetTypeInfo();
			case EApplicationPackage.EAPP_SEQUENCE_DATA__ITEMS:
				return getItems();
			case EApplicationPackage.EAPP_SEQUENCE_DATA__TEMPLATE:
				return getTemplate();
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
			case EApplicationPackage.EAPP_SEQUENCE_DATA__URI:
				getUri().clear();
				getUri().addAll((Collection<? extends URI>)newValue);
				return;
			case EApplicationPackage.EAPP_SEQUENCE_DATA__TYPE_INFO:
				setTypeInfo((EAppSettingType)newValue);
				return;
			case EApplicationPackage.EAPP_SEQUENCE_DATA__ITEMS:
				getItems().clear();
				getItems().addAll((Collection<? extends EAppSequenceDataItem>)newValue);
				return;
			case EApplicationPackage.EAPP_SEQUENCE_DATA__TEMPLATE:
				setTemplate((EAppSequenceDataItem)newValue);
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
			case EApplicationPackage.EAPP_SEQUENCE_DATA__URI:
				getUri().clear();
				return;
			case EApplicationPackage.EAPP_SEQUENCE_DATA__TYPE_INFO:
				setTypeInfo((EAppSettingType)null);
				return;
			case EApplicationPackage.EAPP_SEQUENCE_DATA__ITEMS:
				getItems().clear();
				return;
			case EApplicationPackage.EAPP_SEQUENCE_DATA__TEMPLATE:
				setTemplate((EAppSequenceDataItem)null);
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
			case EApplicationPackage.EAPP_SEQUENCE_DATA__URI:
				return uri != null && !uri.isEmpty();
			case EApplicationPackage.EAPP_SEQUENCE_DATA__TYPE_INFO:
				return typeInfo != null;
			case EApplicationPackage.EAPP_SEQUENCE_DATA__ITEMS:
				return items != null && !items.isEmpty();
			case EApplicationPackage.EAPP_SEQUENCE_DATA__TEMPLATE:
				return template != null;
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
		result.append(')');
		return result.toString();
	}

} //EAppSequenceDataImpl
