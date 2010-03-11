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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.nokia.tools.vct.common.appmodel.EAppExpression;
import com.nokia.tools.vct.common.appmodel.EAppFeature;
import com.nokia.tools.vct.common.appmodel.EAppIconContainer;
import com.nokia.tools.vct.common.appmodel.EAppNamedItem;
import com.nokia.tools.vct.common.appmodel.EAppSetting;
import com.nokia.tools.vct.common.appmodel.EApplicationPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>EApp Feature</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppFeatureImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppFeatureImpl#getIconDescriptor <em>Icon Descriptor</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppFeatureImpl#getIconTitle <em>Icon Title</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppFeatureImpl#getIconURI <em>Icon URI</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppFeatureImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppFeatureImpl#getSettings <em>Settings</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppFeatureImpl#getRelevant <em>Relevant</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.impl.EAppFeatureImpl#getRef <em>Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EAppFeatureImpl extends EObjectImpl implements EAppFeature {
    /**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
    protected static final String DESCRIPTION_EDEFAULT = null;

    /**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
    protected String description = DESCRIPTION_EDEFAULT;

    /**
	 * The default value of the '{@link #getIconDescriptor() <em>Icon Descriptor</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @see #getIconDescriptor()
	 * @generated
	 * @ordered
	 */
    protected static final Object ICON_DESCRIPTOR_EDEFAULT = null;

    /**
	 * The cached value of the '{@link #getIconDescriptor() <em>Icon Descriptor</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @see #getIconDescriptor()
	 * @generated
	 * @ordered
	 */
    protected Object iconDescriptor = ICON_DESCRIPTOR_EDEFAULT;

    /**
	 * The default value of the '{@link #getIconTitle() <em>Icon Title</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getIconTitle()
	 * @generated
	 * @ordered
	 */
    protected static final String ICON_TITLE_EDEFAULT = null;

    /**
	 * The cached value of the '{@link #getIconTitle() <em>Icon Title</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getIconTitle()
	 * @generated
	 * @ordered
	 */
    protected String iconTitle = ICON_TITLE_EDEFAULT;

    /**
	 * The default value of the '{@link #getIconURI() <em>Icon URI</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getIconURI()
	 * @generated
	 * @ordered
	 */
    protected static final URI ICON_URI_EDEFAULT = null;

    /**
	 * The cached value of the '{@link #getIconURI() <em>Icon URI</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getIconURI()
	 * @generated
	 * @ordered
	 */
    protected URI iconURI = ICON_URI_EDEFAULT;

    /**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
    protected static final String NAME_EDEFAULT = null;

    /**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
    protected String name = NAME_EDEFAULT;

    /**
	 * The cached value of the '{@link #getSettings() <em>Settings</em>}' map.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSettings()
	 * @generated
	 * @ordered
	 */
    protected EMap<String, EAppSetting> settings;

    /**
	 * The cached value of the '{@link #getRelevant() <em>Relevant</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRelevant()
	 * @generated
	 * @ordered
	 */
    protected EAppExpression relevant;

    /**
     * The default value of the '{@link #getRef() <em>Ref</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getRef()
     * @generated
     * @ordered
     */
    protected static final String REF_EDEFAULT = "";

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected EAppFeatureImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return EApplicationPackage.Literals.EAPP_FEATURE;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public String getDescription() {
		return description;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_FEATURE__DESCRIPTION, oldDescription, description));
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public Object getIconDescriptor() {
		return iconDescriptor;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public void setIconDescriptor(Object newIconDescriptor) {
		Object oldIconDescriptor = iconDescriptor;
		iconDescriptor = newIconDescriptor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_FEATURE__ICON_DESCRIPTOR, oldIconDescriptor, iconDescriptor));
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public String getIconTitle() {
		return iconTitle;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public void setIconTitle(String newIconTitle) {
		String oldIconTitle = iconTitle;
		iconTitle = newIconTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_FEATURE__ICON_TITLE, oldIconTitle, iconTitle));
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public URI getIconURI() {
		return iconURI;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public void setIconURI(URI newIconURI) {
		URI oldIconURI = iconURI;
		iconURI = newIconURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_FEATURE__ICON_URI, oldIconURI, iconURI));
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EMap<String, EAppSetting> getSettings() {
		if (settings == null) {
			settings = new EcoreEMap<String,EAppSetting>(EApplicationPackage.Literals.EAPP_SETTING_ENTRY, EAppSettingEntryImpl.class, this, EApplicationPackage.EAPP_FEATURE__SETTINGS);
		}
		return settings;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EAppExpression getRelevant() {
		return relevant;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetRelevant(EAppExpression newRelevant,
            NotificationChain msgs) {
		EAppExpression oldRelevant = relevant;
		relevant = newRelevant;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_FEATURE__RELEVANT, oldRelevant, newRelevant);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public void setRelevant(EAppExpression newRelevant) {
		if (newRelevant != relevant) {
			NotificationChain msgs = null;
			if (relevant != null)
				msgs = ((InternalEObject)relevant).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EApplicationPackage.EAPP_FEATURE__RELEVANT, null, msgs);
			if (newRelevant != null)
				msgs = ((InternalEObject)newRelevant).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EApplicationPackage.EAPP_FEATURE__RELEVANT, null, msgs);
			msgs = basicSetRelevant(newRelevant, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_FEATURE__RELEVANT, newRelevant, newRelevant));
	}

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public String getRef() {
        EObject container = eContainer();
        if (container instanceof EAppFeatureEntryImpl) {
            return ((EAppFeatureEntryImpl) container).getKey();
        }
        return null;
    }

    /**
     * <!-- begin-user-doc -->
     * <p>
     * Use attached expression for evaluation.
     * </p>
     * <!-- end-user-doc -->
     */
    public boolean computeRelevant() {
        EAppExpression expr = getRelevant();
        if (expr == null) {
            return true;
        }

        return expr.computeBoolean(eContainer().eContainer(), this);
    }

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public String getName() {
		return name;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EApplicationPackage.EAPP_FEATURE__NAME, oldName, name));
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd,
            int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EApplicationPackage.EAPP_FEATURE__SETTINGS:
				return ((InternalEList<?>)getSettings()).basicRemove(otherEnd, msgs);
			case EApplicationPackage.EAPP_FEATURE__RELEVANT:
				return basicSetRelevant(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EApplicationPackage.EAPP_FEATURE__DESCRIPTION:
				return getDescription();
			case EApplicationPackage.EAPP_FEATURE__ICON_DESCRIPTOR:
				return getIconDescriptor();
			case EApplicationPackage.EAPP_FEATURE__ICON_TITLE:
				return getIconTitle();
			case EApplicationPackage.EAPP_FEATURE__ICON_URI:
				return getIconURI();
			case EApplicationPackage.EAPP_FEATURE__NAME:
				return getName();
			case EApplicationPackage.EAPP_FEATURE__SETTINGS:
				if (coreType) return getSettings();
				else return getSettings().map();
			case EApplicationPackage.EAPP_FEATURE__RELEVANT:
				return getRelevant();
			case EApplicationPackage.EAPP_FEATURE__REF:
				return getRef();
		}
		return super.eGet(featureID, resolve, coreType);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EApplicationPackage.EAPP_FEATURE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case EApplicationPackage.EAPP_FEATURE__ICON_DESCRIPTOR:
				setIconDescriptor(newValue);
				return;
			case EApplicationPackage.EAPP_FEATURE__ICON_TITLE:
				setIconTitle((String)newValue);
				return;
			case EApplicationPackage.EAPP_FEATURE__ICON_URI:
				setIconURI((URI)newValue);
				return;
			case EApplicationPackage.EAPP_FEATURE__NAME:
				setName((String)newValue);
				return;
			case EApplicationPackage.EAPP_FEATURE__SETTINGS:
				((EStructuralFeature.Setting)getSettings()).set(newValue);
				return;
			case EApplicationPackage.EAPP_FEATURE__RELEVANT:
				setRelevant((EAppExpression)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public void eUnset(int featureID) {
		switch (featureID) {
			case EApplicationPackage.EAPP_FEATURE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case EApplicationPackage.EAPP_FEATURE__ICON_DESCRIPTOR:
				setIconDescriptor(ICON_DESCRIPTOR_EDEFAULT);
				return;
			case EApplicationPackage.EAPP_FEATURE__ICON_TITLE:
				setIconTitle(ICON_TITLE_EDEFAULT);
				return;
			case EApplicationPackage.EAPP_FEATURE__ICON_URI:
				setIconURI(ICON_URI_EDEFAULT);
				return;
			case EApplicationPackage.EAPP_FEATURE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EApplicationPackage.EAPP_FEATURE__SETTINGS:
				getSettings().clear();
				return;
			case EApplicationPackage.EAPP_FEATURE__RELEVANT:
				setRelevant((EAppExpression)null);
				return;
		}
		super.eUnset(featureID);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EApplicationPackage.EAPP_FEATURE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case EApplicationPackage.EAPP_FEATURE__ICON_DESCRIPTOR:
				return ICON_DESCRIPTOR_EDEFAULT == null ? iconDescriptor != null : !ICON_DESCRIPTOR_EDEFAULT.equals(iconDescriptor);
			case EApplicationPackage.EAPP_FEATURE__ICON_TITLE:
				return ICON_TITLE_EDEFAULT == null ? iconTitle != null : !ICON_TITLE_EDEFAULT.equals(iconTitle);
			case EApplicationPackage.EAPP_FEATURE__ICON_URI:
				return ICON_URI_EDEFAULT == null ? iconURI != null : !ICON_URI_EDEFAULT.equals(iconURI);
			case EApplicationPackage.EAPP_FEATURE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EApplicationPackage.EAPP_FEATURE__SETTINGS:
				return settings != null && !settings.isEmpty();
			case EApplicationPackage.EAPP_FEATURE__RELEVANT:
				return relevant != null;
			case EApplicationPackage.EAPP_FEATURE__REF:
				return REF_EDEFAULT == null ? getRef() != null : !REF_EDEFAULT.equals(getRef());
		}
		return super.eIsSet(featureID);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == EAppIconContainer.class) {
			switch (derivedFeatureID) {
				case EApplicationPackage.EAPP_FEATURE__ICON_DESCRIPTOR: return EApplicationPackage.EAPP_ICON_CONTAINER__ICON_DESCRIPTOR;
				case EApplicationPackage.EAPP_FEATURE__ICON_TITLE: return EApplicationPackage.EAPP_ICON_CONTAINER__ICON_TITLE;
				case EApplicationPackage.EAPP_FEATURE__ICON_URI: return EApplicationPackage.EAPP_ICON_CONTAINER__ICON_URI;
				default: return -1;
			}
		}
		if (baseClass == EAppNamedItem.class) {
			switch (derivedFeatureID) {
				case EApplicationPackage.EAPP_FEATURE__NAME: return EApplicationPackage.EAPP_NAMED_ITEM__NAME;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == EAppIconContainer.class) {
			switch (baseFeatureID) {
				case EApplicationPackage.EAPP_ICON_CONTAINER__ICON_DESCRIPTOR: return EApplicationPackage.EAPP_FEATURE__ICON_DESCRIPTOR;
				case EApplicationPackage.EAPP_ICON_CONTAINER__ICON_TITLE: return EApplicationPackage.EAPP_FEATURE__ICON_TITLE;
				case EApplicationPackage.EAPP_ICON_CONTAINER__ICON_URI: return EApplicationPackage.EAPP_FEATURE__ICON_URI;
				default: return -1;
			}
		}
		if (baseClass == EAppNamedItem.class) {
			switch (baseFeatureID) {
				case EApplicationPackage.EAPP_NAMED_ITEM__NAME: return EApplicationPackage.EAPP_FEATURE__NAME;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
		result.append(')');
		return result.toString();
	}

} // EAppFeatureImpl
