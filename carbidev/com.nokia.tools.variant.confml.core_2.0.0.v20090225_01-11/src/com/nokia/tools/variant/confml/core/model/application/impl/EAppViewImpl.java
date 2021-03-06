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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.nokia.tools.variant.confml.core.model.application.EAppDescriptionContainer;
import com.nokia.tools.variant.confml.core.model.application.EAppGroup;
import com.nokia.tools.variant.confml.core.model.application.EAppIconContainer;
import com.nokia.tools.variant.confml.core.model.application.EAppNamedItem;
import com.nokia.tools.variant.confml.core.model.application.EAppView;
import com.nokia.tools.variant.confml.core.model.application.EApplicationPackage;
import com.nokia.tools.variant.confml.core.model.core.EConfmlRootPackage;
import com.nokia.tools.variant.confml.core.model.core.ESourceLocator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EApp View</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppViewImpl#getGroups <em>Groups</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppViewImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppViewImpl#getIconDescriptor <em>Icon Descriptor</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppViewImpl#getIconTitle <em>Icon Title</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppViewImpl#getIconURI <em>Icon URI</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppViewImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.variant.confml.core.model.application.impl.EAppViewImpl#getUri <em>Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EAppViewImpl extends EObjectImpl implements EAppView {
	/**
     * The cached value of the '{@link #getGroups() <em>Groups</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getGroups()
     * @generated
     * @ordered
     */
	protected EList<EAppGroup> groups;

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
     * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getUri()
     * @generated
     * @ordered
     */
	protected EList<URI> uri;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EAppViewImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return EApplicationPackage.Literals.EAPP_VIEW;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<EAppGroup> getGroups() {
        if (groups == null) {
            groups = new EObjectContainmentEList<EAppGroup>(EAppGroup.class, this, EApplicationPackage.EAPP_VIEW__GROUPS);
        }
        return groups;
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
            eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_VIEW__DESCRIPTION, oldDescription, description));
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
            eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_VIEW__ICON_DESCRIPTOR, oldIconDescriptor, iconDescriptor));
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
            eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_VIEW__ICON_TITLE, oldIconTitle, iconTitle));
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
            eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_VIEW__ICON_URI, oldIconURI, iconURI));
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
            eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_VIEW__NAME, oldName, name));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<URI> getUri() {
        if (uri == null) {
            uri = new EDataTypeUniqueEList<URI>(URI.class, this, EApplicationPackage.EAPP_VIEW__URI);
        }
        return uri;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case EApplicationPackage.EAPP_VIEW__GROUPS:
                return ((InternalEList<?>)getGroups()).basicRemove(otherEnd, msgs);
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
            case EApplicationPackage.EAPP_VIEW__GROUPS:
                return getGroups();
            case EApplicationPackage.EAPP_VIEW__DESCRIPTION:
                return getDescription();
            case EApplicationPackage.EAPP_VIEW__ICON_DESCRIPTOR:
                return getIconDescriptor();
            case EApplicationPackage.EAPP_VIEW__ICON_TITLE:
                return getIconTitle();
            case EApplicationPackage.EAPP_VIEW__ICON_URI:
                return getIconURI();
            case EApplicationPackage.EAPP_VIEW__NAME:
                return getName();
            case EApplicationPackage.EAPP_VIEW__URI:
                return getUri();
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
            case EApplicationPackage.EAPP_VIEW__GROUPS:
                getGroups().clear();
                getGroups().addAll((Collection<? extends EAppGroup>)newValue);
                return;
            case EApplicationPackage.EAPP_VIEW__DESCRIPTION:
                setDescription((String)newValue);
                return;
            case EApplicationPackage.EAPP_VIEW__ICON_DESCRIPTOR:
                setIconDescriptor(newValue);
                return;
            case EApplicationPackage.EAPP_VIEW__ICON_TITLE:
                setIconTitle((String)newValue);
                return;
            case EApplicationPackage.EAPP_VIEW__ICON_URI:
                setIconURI((URI)newValue);
                return;
            case EApplicationPackage.EAPP_VIEW__NAME:
                setName((String)newValue);
                return;
            case EApplicationPackage.EAPP_VIEW__URI:
                getUri().clear();
                getUri().addAll((Collection<? extends URI>)newValue);
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
            case EApplicationPackage.EAPP_VIEW__GROUPS:
                getGroups().clear();
                return;
            case EApplicationPackage.EAPP_VIEW__DESCRIPTION:
                setDescription(DESCRIPTION_EDEFAULT);
                return;
            case EApplicationPackage.EAPP_VIEW__ICON_DESCRIPTOR:
                setIconDescriptor(ICON_DESCRIPTOR_EDEFAULT);
                return;
            case EApplicationPackage.EAPP_VIEW__ICON_TITLE:
                setIconTitle(ICON_TITLE_EDEFAULT);
                return;
            case EApplicationPackage.EAPP_VIEW__ICON_URI:
                setIconURI(ICON_URI_EDEFAULT);
                return;
            case EApplicationPackage.EAPP_VIEW__NAME:
                setName(NAME_EDEFAULT);
                return;
            case EApplicationPackage.EAPP_VIEW__URI:
                getUri().clear();
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
            case EApplicationPackage.EAPP_VIEW__GROUPS:
                return groups != null && !groups.isEmpty();
            case EApplicationPackage.EAPP_VIEW__DESCRIPTION:
                return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
            case EApplicationPackage.EAPP_VIEW__ICON_DESCRIPTOR:
                return ICON_DESCRIPTOR_EDEFAULT == null ? iconDescriptor != null : !ICON_DESCRIPTOR_EDEFAULT.equals(iconDescriptor);
            case EApplicationPackage.EAPP_VIEW__ICON_TITLE:
                return ICON_TITLE_EDEFAULT == null ? iconTitle != null : !ICON_TITLE_EDEFAULT.equals(iconTitle);
            case EApplicationPackage.EAPP_VIEW__ICON_URI:
                return ICON_URI_EDEFAULT == null ? iconURI != null : !ICON_URI_EDEFAULT.equals(iconURI);
            case EApplicationPackage.EAPP_VIEW__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case EApplicationPackage.EAPP_VIEW__URI:
                return uri != null && !uri.isEmpty();
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
                case EApplicationPackage.EAPP_VIEW__DESCRIPTION: return EApplicationPackage.EAPP_DESCRIPTION_CONTAINER__DESCRIPTION;
                default: return -1;
            }
        }
        if (baseClass == EAppIconContainer.class) {
            switch (derivedFeatureID) {
                case EApplicationPackage.EAPP_VIEW__ICON_DESCRIPTOR: return EApplicationPackage.EAPP_ICON_CONTAINER__ICON_DESCRIPTOR;
                case EApplicationPackage.EAPP_VIEW__ICON_TITLE: return EApplicationPackage.EAPP_ICON_CONTAINER__ICON_TITLE;
                case EApplicationPackage.EAPP_VIEW__ICON_URI: return EApplicationPackage.EAPP_ICON_CONTAINER__ICON_URI;
                default: return -1;
            }
        }
        if (baseClass == EAppNamedItem.class) {
            switch (derivedFeatureID) {
                case EApplicationPackage.EAPP_VIEW__NAME: return EApplicationPackage.EAPP_NAMED_ITEM__NAME;
                default: return -1;
            }
        }
        if (baseClass == ESourceLocator.class) {
            switch (derivedFeatureID) {
                case EApplicationPackage.EAPP_VIEW__URI: return EConfmlRootPackage.ESOURCE_LOCATOR__URI;
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
                case EApplicationPackage.EAPP_DESCRIPTION_CONTAINER__DESCRIPTION: return EApplicationPackage.EAPP_VIEW__DESCRIPTION;
                default: return -1;
            }
        }
        if (baseClass == EAppIconContainer.class) {
            switch (baseFeatureID) {
                case EApplicationPackage.EAPP_ICON_CONTAINER__ICON_DESCRIPTOR: return EApplicationPackage.EAPP_VIEW__ICON_DESCRIPTOR;
                case EApplicationPackage.EAPP_ICON_CONTAINER__ICON_TITLE: return EApplicationPackage.EAPP_VIEW__ICON_TITLE;
                case EApplicationPackage.EAPP_ICON_CONTAINER__ICON_URI: return EApplicationPackage.EAPP_VIEW__ICON_URI;
                default: return -1;
            }
        }
        if (baseClass == EAppNamedItem.class) {
            switch (baseFeatureID) {
                case EApplicationPackage.EAPP_NAMED_ITEM__NAME: return EApplicationPackage.EAPP_VIEW__NAME;
                default: return -1;
            }
        }
        if (baseClass == ESourceLocator.class) {
            switch (baseFeatureID) {
                case EConfmlRootPackage.ESOURCE_LOCATOR__URI: return EApplicationPackage.EAPP_VIEW__URI;
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
        result.append(", uri: ");
        result.append(uri);
        result.append(')');
        return result.toString();
    }

} //EAppViewImpl
