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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.nokia.tools.variant.confml.core.model.application.EAppCompositeType;
import com.nokia.tools.variant.confml.core.model.application.EAppDescriptionContainer;
import com.nokia.tools.variant.confml.core.model.application.EAppExpression;
import com.nokia.tools.variant.confml.core.model.application.EAppIconContainer;
import com.nokia.tools.variant.confml.core.model.application.EAppNamedItem;
import com.nokia.tools.variant.confml.core.model.application.EAppProperty;
import com.nokia.tools.variant.confml.core.model.application.EAppPropertyContainer;
import com.nokia.tools.variant.confml.core.model.application.EAppSettingType;
import com.nokia.tools.variant.confml.core.model.application.EApplicationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EApp Composite Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppCompositeTypeImpl#getTypeMap <em>Type Map</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppCompositeTypeImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppCompositeTypeImpl#getIconDescriptor <em>Icon Descriptor</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppCompositeTypeImpl#getIconTitle <em>Icon Title</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppCompositeTypeImpl#getIconURI <em>Icon URI</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppCompositeTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppCompositeTypeImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppCompositeTypeImpl#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppCompositeTypeImpl#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppCompositeTypeImpl#getRelevant <em>Relevant</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppCompositeTypeImpl#isRequired <em>Required</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppCompositeTypeImpl#isDeprecated <em>Deprecated</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class EAppCompositeTypeImpl extends EObjectImpl implements EAppCompositeType {
	/**
     * The cached value of the '{@link #getTypeMap() <em>Type Map</em>}' map.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTypeMap()
     * @generated
     * @ordered
     */
	protected EMap<String, EAppSettingType> typeMap;

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
     * The default value of the '{@link #getIconDescriptor() <em>Icon Descriptor</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getIconDescriptor()
     * @generated
     * @ordered
     */
	protected static final Object ICON_DESCRIPTOR_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getIconDescriptor() <em>Icon Descriptor</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getIconDescriptor()
     * @generated
     * @ordered
     */
	protected Object iconDescriptor = ICON_DESCRIPTOR_EDEFAULT;

	/**
     * The default value of the '{@link #getIconTitle() <em>Icon Title</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getIconTitle()
     * @generated
     * @ordered
     */
	protected static final String ICON_TITLE_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getIconTitle() <em>Icon Title</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getIconTitle()
     * @generated
     * @ordered
     */
	protected String iconTitle = ICON_TITLE_EDEFAULT;

	/**
     * The default value of the '{@link #getIconURI() <em>Icon URI</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getIconURI()
     * @generated
     * @ordered
     */
	protected static final URI ICON_URI_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getIconURI() <em>Icon URI</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getIconURI()
     * @generated
     * @ordered
     */
	protected URI iconURI = ICON_URI_EDEFAULT;

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
     * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getProperties()
     * @generated
     * @ordered
     */
	protected EList<EAppProperty> properties;

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
     * The cached value of the '{@link #getConstraint() <em>Constraint</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getConstraint()
     * @generated
     * @ordered
     */
	protected EAppExpression constraint;

	/**
     * The cached value of the '{@link #getRelevant() <em>Relevant</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getRelevant()
     * @generated
     * @ordered
     */
	protected EAppExpression relevant;

	/**
     * The default value of the '{@link #isRequired() <em>Required</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isRequired()
     * @generated
     * @ordered
     */
	protected static final boolean REQUIRED_EDEFAULT = false;

	/**
     * The cached value of the '{@link #isRequired() <em>Required</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isRequired()
     * @generated
     * @ordered
     */
	protected boolean required = REQUIRED_EDEFAULT;

	/**
     * The default value of the '{@link #isDeprecated() <em>Deprecated</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isDeprecated()
     * @generated
     * @ordered
     */
	protected static final boolean DEPRECATED_EDEFAULT = false;

	/**
     * The cached value of the '{@link #isDeprecated() <em>Deprecated</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isDeprecated()
     * @generated
     * @ordered
     */
	protected boolean deprecated = DEPRECATED_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EAppCompositeTypeImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return EApplicationPackage.Literals.EAPP_COMPOSITE_TYPE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EMap<String, EAppSettingType> getTypeMap() {
        if (typeMap == null) {
            typeMap = new EcoreEMap<String,EAppSettingType>(EApplicationPackage.Literals.EAPP_SETTING_TYPE_ENTRY, EAppSettingTypeEntryImpl.class, this, EApplicationPackage.EAPP_COMPOSITE_TYPE__TYPE_MAP);
        }
        return typeMap;
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
            eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_COMPOSITE_TYPE__DESCRIPTION, oldDescription, description));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Object getIconDescriptor() {
        return iconDescriptor;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setIconDescriptor(Object newIconDescriptor) {
        Object oldIconDescriptor = iconDescriptor;
        iconDescriptor = newIconDescriptor;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_COMPOSITE_TYPE__ICON_DESCRIPTOR, oldIconDescriptor, iconDescriptor));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getIconTitle() {
        return iconTitle;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setIconTitle(String newIconTitle) {
        String oldIconTitle = iconTitle;
        iconTitle = newIconTitle;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_COMPOSITE_TYPE__ICON_TITLE, oldIconTitle, iconTitle));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public URI getIconURI() {
        return iconURI;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setIconURI(URI newIconURI) {
        URI oldIconURI = iconURI;
        iconURI = newIconURI;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_COMPOSITE_TYPE__ICON_URI, oldIconURI, iconURI));
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
            eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_COMPOSITE_TYPE__NAME, oldName, name));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<EAppProperty> getProperties() {
        if (properties == null) {
            properties = new EObjectContainmentEList<EAppProperty>(EAppProperty.class, this, EApplicationPackage.EAPP_COMPOSITE_TYPE__PROPERTIES);
        }
        return properties;
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
            eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_COMPOSITE_TYPE__READ_ONLY, oldReadOnly, readOnly));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAppExpression getConstraint() {
        return constraint;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetConstraint(EAppExpression newConstraint, NotificationChain msgs) {
        EAppExpression oldConstraint = constraint;
        constraint = newConstraint;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_COMPOSITE_TYPE__CONSTRAINT, oldConstraint, newConstraint);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setConstraint(EAppExpression newConstraint) {
        if (newConstraint != constraint) {
            NotificationChain msgs = null;
            if (constraint != null)
                msgs = ((InternalEObject)constraint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EApplicationPackage.EAPP_COMPOSITE_TYPE__CONSTRAINT, null, msgs);
            if (newConstraint != null)
                msgs = ((InternalEObject)newConstraint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EApplicationPackage.EAPP_COMPOSITE_TYPE__CONSTRAINT, null, msgs);
            msgs = basicSetConstraint(newConstraint, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_COMPOSITE_TYPE__CONSTRAINT, newConstraint, newConstraint));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAppExpression getRelevant() {
        return relevant;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetRelevant(EAppExpression newRelevant, NotificationChain msgs) {
        EAppExpression oldRelevant = relevant;
        relevant = newRelevant;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_COMPOSITE_TYPE__RELEVANT, oldRelevant, newRelevant);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setRelevant(EAppExpression newRelevant) {
        if (newRelevant != relevant) {
            NotificationChain msgs = null;
            if (relevant != null)
                msgs = ((InternalEObject)relevant).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EApplicationPackage.EAPP_COMPOSITE_TYPE__RELEVANT, null, msgs);
            if (newRelevant != null)
                msgs = ((InternalEObject)newRelevant).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EApplicationPackage.EAPP_COMPOSITE_TYPE__RELEVANT, null, msgs);
            msgs = basicSetRelevant(newRelevant, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_COMPOSITE_TYPE__RELEVANT, newRelevant, newRelevant));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isRequired() {
        return required;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setRequired(boolean newRequired) {
        boolean oldRequired = required;
        required = newRequired;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_COMPOSITE_TYPE__REQUIRED, oldRequired, required));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isDeprecated() {
        return deprecated;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setDeprecated(boolean newDeprecated) {
        boolean oldDeprecated = deprecated;
        deprecated = newDeprecated;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_COMPOSITE_TYPE__DEPRECATED, oldDeprecated, deprecated));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__TYPE_MAP:
                return ((InternalEList<?>)getTypeMap()).basicRemove(otherEnd, msgs);
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__PROPERTIES:
                return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__CONSTRAINT:
                return basicSetConstraint(null, msgs);
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__RELEVANT:
                return basicSetRelevant(null, msgs);
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
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__TYPE_MAP:
                if (coreType) return getTypeMap();
                else return getTypeMap().map();
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__DESCRIPTION:
                return getDescription();
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__ICON_DESCRIPTOR:
                return getIconDescriptor();
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__ICON_TITLE:
                return getIconTitle();
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__ICON_URI:
                return getIconURI();
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__NAME:
                return getName();
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__PROPERTIES:
                return getProperties();
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__READ_ONLY:
                return isReadOnly() ? Boolean.TRUE : Boolean.FALSE;
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__CONSTRAINT:
                return getConstraint();
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__RELEVANT:
                return getRelevant();
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__REQUIRED:
                return isRequired() ? Boolean.TRUE : Boolean.FALSE;
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__DEPRECATED:
                return isDeprecated() ? Boolean.TRUE : Boolean.FALSE;
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
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__TYPE_MAP:
                ((EStructuralFeature.Setting)getTypeMap()).set(newValue);
                return;
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__DESCRIPTION:
                setDescription((String)newValue);
                return;
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__ICON_DESCRIPTOR:
                setIconDescriptor(newValue);
                return;
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__ICON_TITLE:
                setIconTitle((String)newValue);
                return;
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__ICON_URI:
                setIconURI((URI)newValue);
                return;
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__NAME:
                setName((String)newValue);
                return;
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__PROPERTIES:
                getProperties().clear();
                getProperties().addAll((Collection<? extends EAppProperty>)newValue);
                return;
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__READ_ONLY:
                setReadOnly(((Boolean)newValue).booleanValue());
                return;
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__CONSTRAINT:
                setConstraint((EAppExpression)newValue);
                return;
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__RELEVANT:
                setRelevant((EAppExpression)newValue);
                return;
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__REQUIRED:
                setRequired(((Boolean)newValue).booleanValue());
                return;
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__DEPRECATED:
                setDeprecated(((Boolean)newValue).booleanValue());
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
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__TYPE_MAP:
                getTypeMap().clear();
                return;
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__DESCRIPTION:
                setDescription(DESCRIPTION_EDEFAULT);
                return;
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__ICON_DESCRIPTOR:
                setIconDescriptor(ICON_DESCRIPTOR_EDEFAULT);
                return;
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__ICON_TITLE:
                setIconTitle(ICON_TITLE_EDEFAULT);
                return;
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__ICON_URI:
                setIconURI(ICON_URI_EDEFAULT);
                return;
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__NAME:
                setName(NAME_EDEFAULT);
                return;
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__PROPERTIES:
                getProperties().clear();
                return;
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__READ_ONLY:
                setReadOnly(READ_ONLY_EDEFAULT);
                return;
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__CONSTRAINT:
                setConstraint((EAppExpression)null);
                return;
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__RELEVANT:
                setRelevant((EAppExpression)null);
                return;
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__REQUIRED:
                setRequired(REQUIRED_EDEFAULT);
                return;
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__DEPRECATED:
                setDeprecated(DEPRECATED_EDEFAULT);
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
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__TYPE_MAP:
                return typeMap != null && !typeMap.isEmpty();
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__DESCRIPTION:
                return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__ICON_DESCRIPTOR:
                return ICON_DESCRIPTOR_EDEFAULT == null ? iconDescriptor != null : !ICON_DESCRIPTOR_EDEFAULT.equals(iconDescriptor);
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__ICON_TITLE:
                return ICON_TITLE_EDEFAULT == null ? iconTitle != null : !ICON_TITLE_EDEFAULT.equals(iconTitle);
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__ICON_URI:
                return ICON_URI_EDEFAULT == null ? iconURI != null : !ICON_URI_EDEFAULT.equals(iconURI);
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__PROPERTIES:
                return properties != null && !properties.isEmpty();
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__READ_ONLY:
                return readOnly != READ_ONLY_EDEFAULT;
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__CONSTRAINT:
                return constraint != null;
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__RELEVANT:
                return relevant != null;
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__REQUIRED:
                return required != REQUIRED_EDEFAULT;
            case EApplicationPackage.EAPP_COMPOSITE_TYPE__DEPRECATED:
                return deprecated != DEPRECATED_EDEFAULT;
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
        if (baseClass == EAppDescriptionContainer.class) {
            switch (derivedFeatureID) {
                case EApplicationPackage.EAPP_COMPOSITE_TYPE__DESCRIPTION: return EApplicationPackage.EAPP_DESCRIPTION_CONTAINER__DESCRIPTION;
                default: return -1;
            }
        }
        if (baseClass == EAppIconContainer.class) {
            switch (derivedFeatureID) {
                case EApplicationPackage.EAPP_COMPOSITE_TYPE__ICON_DESCRIPTOR: return EApplicationPackage.EAPP_ICON_CONTAINER__ICON_DESCRIPTOR;
                case EApplicationPackage.EAPP_COMPOSITE_TYPE__ICON_TITLE: return EApplicationPackage.EAPP_ICON_CONTAINER__ICON_TITLE;
                case EApplicationPackage.EAPP_COMPOSITE_TYPE__ICON_URI: return EApplicationPackage.EAPP_ICON_CONTAINER__ICON_URI;
                default: return -1;
            }
        }
        if (baseClass == EAppNamedItem.class) {
            switch (derivedFeatureID) {
                case EApplicationPackage.EAPP_COMPOSITE_TYPE__NAME: return EApplicationPackage.EAPP_NAMED_ITEM__NAME;
                default: return -1;
            }
        }
        if (baseClass == EAppPropertyContainer.class) {
            switch (derivedFeatureID) {
                case EApplicationPackage.EAPP_COMPOSITE_TYPE__PROPERTIES: return EApplicationPackage.EAPP_PROPERTY_CONTAINER__PROPERTIES;
                default: return -1;
            }
        }
        if (baseClass == EAppSettingType.class) {
            switch (derivedFeatureID) {
                case EApplicationPackage.EAPP_COMPOSITE_TYPE__READ_ONLY: return EApplicationPackage.EAPP_SETTING_TYPE__READ_ONLY;
                case EApplicationPackage.EAPP_COMPOSITE_TYPE__CONSTRAINT: return EApplicationPackage.EAPP_SETTING_TYPE__CONSTRAINT;
                case EApplicationPackage.EAPP_COMPOSITE_TYPE__RELEVANT: return EApplicationPackage.EAPP_SETTING_TYPE__RELEVANT;
                case EApplicationPackage.EAPP_COMPOSITE_TYPE__REQUIRED: return EApplicationPackage.EAPP_SETTING_TYPE__REQUIRED;
                case EApplicationPackage.EAPP_COMPOSITE_TYPE__DEPRECATED: return EApplicationPackage.EAPP_SETTING_TYPE__DEPRECATED;
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
        if (baseClass == EAppDescriptionContainer.class) {
            switch (baseFeatureID) {
                case EApplicationPackage.EAPP_DESCRIPTION_CONTAINER__DESCRIPTION: return EApplicationPackage.EAPP_COMPOSITE_TYPE__DESCRIPTION;
                default: return -1;
            }
        }
        if (baseClass == EAppIconContainer.class) {
            switch (baseFeatureID) {
                case EApplicationPackage.EAPP_ICON_CONTAINER__ICON_DESCRIPTOR: return EApplicationPackage.EAPP_COMPOSITE_TYPE__ICON_DESCRIPTOR;
                case EApplicationPackage.EAPP_ICON_CONTAINER__ICON_TITLE: return EApplicationPackage.EAPP_COMPOSITE_TYPE__ICON_TITLE;
                case EApplicationPackage.EAPP_ICON_CONTAINER__ICON_URI: return EApplicationPackage.EAPP_COMPOSITE_TYPE__ICON_URI;
                default: return -1;
            }
        }
        if (baseClass == EAppNamedItem.class) {
            switch (baseFeatureID) {
                case EApplicationPackage.EAPP_NAMED_ITEM__NAME: return EApplicationPackage.EAPP_COMPOSITE_TYPE__NAME;
                default: return -1;
            }
        }
        if (baseClass == EAppPropertyContainer.class) {
            switch (baseFeatureID) {
                case EApplicationPackage.EAPP_PROPERTY_CONTAINER__PROPERTIES: return EApplicationPackage.EAPP_COMPOSITE_TYPE__PROPERTIES;
                default: return -1;
            }
        }
        if (baseClass == EAppSettingType.class) {
            switch (baseFeatureID) {
                case EApplicationPackage.EAPP_SETTING_TYPE__READ_ONLY: return EApplicationPackage.EAPP_COMPOSITE_TYPE__READ_ONLY;
                case EApplicationPackage.EAPP_SETTING_TYPE__CONSTRAINT: return EApplicationPackage.EAPP_COMPOSITE_TYPE__CONSTRAINT;
                case EApplicationPackage.EAPP_SETTING_TYPE__RELEVANT: return EApplicationPackage.EAPP_COMPOSITE_TYPE__RELEVANT;
                case EApplicationPackage.EAPP_SETTING_TYPE__REQUIRED: return EApplicationPackage.EAPP_COMPOSITE_TYPE__REQUIRED;
                case EApplicationPackage.EAPP_SETTING_TYPE__DEPRECATED: return EApplicationPackage.EAPP_COMPOSITE_TYPE__DEPRECATED;
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
        result.append(", iconDescriptor: ");
        result.append(iconDescriptor);
        result.append(", iconTitle: ");
        result.append(iconTitle);
        result.append(", iconURI: ");
        result.append(iconURI);
        result.append(", name: ");
        result.append(name);
        result.append(", readOnly: ");
        result.append(readOnly);
        result.append(", required: ");
        result.append(required);
        result.append(", deprecated: ");
        result.append(deprecated);
        result.append(')');
        return result.toString();
    }

} //EAppCompositeTypeImpl
