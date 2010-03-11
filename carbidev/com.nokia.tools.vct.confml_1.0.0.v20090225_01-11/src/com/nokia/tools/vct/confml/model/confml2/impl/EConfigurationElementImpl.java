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
 * Description: This file is part of com.nokia.tools.vct.confml component.
 */

package com.nokia.tools.vct.confml.model.confml2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.nokia.tools.vct.confml.model.confml1.include.EInclude;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Package;
import com.nokia.tools.vct.confml.model.confml2.EConfigurationElement;
import com.nokia.tools.vct.confml.model.confml2.EContents;
import com.nokia.tools.vct.confml.model.confml2.EDataElement;
import com.nokia.tools.vct.confml.model.confml2.EDescriptionContainer;
import com.nokia.tools.vct.confml.model.confml2.EDescriptionElement;
import com.nokia.tools.vct.confml.model.confml2.EFeatureElement;
import com.nokia.tools.vct.confml.model.confml2.EIconContainer;
import com.nokia.tools.vct.confml.model.confml2.EIconElement;
import com.nokia.tools.vct.confml.model.confml2.ELinkContainer;
import com.nokia.tools.vct.confml.model.confml2.ELinkElement;
import com.nokia.tools.vct.confml.model.confml2.EMetaContainer;
import com.nokia.tools.vct.confml.model.confml2.EMetaElement;
import com.nokia.tools.vct.confml.model.confml2.ERfsElement;
import com.nokia.tools.vct.confml.model.confml2.EViewElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EConfiguration Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.EConfigurationElementImpl#getContents <em>Contents</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.EConfigurationElementImpl#getLinks <em>Links</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.EConfigurationElementImpl#getIcons <em>Icons</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.EConfigurationElementImpl#getDescriptions <em>Descriptions</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.EConfigurationElementImpl#getMetas <em>Metas</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.EConfigurationElementImpl#getConfigurations <em>Configurations</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.EConfigurationElementImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.EConfigurationElementImpl#getViews <em>Views</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.EConfigurationElementImpl#getData <em>Data</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.EConfigurationElementImpl#getRfs <em>Rfs</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.EConfigurationElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.EConfigurationElementImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.EConfigurationElementImpl#getIncludes <em>Includes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EConfigurationElementImpl extends ECommonAttrsImpl implements
		EConfigurationElement {
	/**
	 * The cached value of the '{@link #getContents() <em>Contents</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContents()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap contents;

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
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EConfigurationElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EConfML2Package.Literals.ECONFIGURATION_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getContents() {
		if (contents == null) {
			contents = new BasicFeatureMap(this,
					EConfML2Package.ECONFIGURATION_ELEMENT__CONTENTS);
		}
		return contents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ELinkElement> getLinks() {
		return getContents().list(
				EConfML2Package.Literals.ELINK_CONTAINER__LINKS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EIconElement> getIcons() {
		return getContents().list(
				EConfML2Package.Literals.EICON_CONTAINER__ICONS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EDescriptionElement> getDescriptions() {
		return getContents().list(
				EConfML2Package.Literals.EDESCRIPTION_CONTAINER__DESCRIPTIONS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EMetaElement> getMetas() {
		return getContents().list(
				EConfML2Package.Literals.EMETA_CONTAINER__METAS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EConfigurationElement> getConfigurations() {
		return getContents()
				.list(
						EConfML2Package.Literals.ECONFIGURATION_ELEMENT__CONFIGURATIONS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EFeatureElement> getFeatures() {
		return getContents().list(
				EConfML2Package.Literals.ECONFIGURATION_ELEMENT__FEATURES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EViewElement> getViews() {
		return getContents().list(
				EConfML2Package.Literals.ECONFIGURATION_ELEMENT__VIEWS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EDataElement> getData() {
		return getContents().list(
				EConfML2Package.Literals.ECONFIGURATION_ELEMENT__DATA);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ERfsElement> getRfs() {
		return getContents().list(
				EConfML2Package.Literals.ECONFIGURATION_ELEMENT__RFS);
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
			eNotify(new ENotificationImpl(this, Notification.SET,
					EConfML2Package.ECONFIGURATION_ELEMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					EConfML2Package.ECONFIGURATION_ELEMENT__VERSION,
					oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EInclude> getIncludes() {
		return getContents().list(
				EConfML2Package.Literals.ECONFIGURATION_ELEMENT__INCLUDES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case EConfML2Package.ECONFIGURATION_ELEMENT__CONTENTS:
			return ((InternalEList<?>) getContents()).basicRemove(otherEnd,
					msgs);
		case EConfML2Package.ECONFIGURATION_ELEMENT__LINKS:
			return ((InternalEList<?>) getLinks()).basicRemove(otherEnd, msgs);
		case EConfML2Package.ECONFIGURATION_ELEMENT__ICONS:
			return ((InternalEList<?>) getIcons()).basicRemove(otherEnd, msgs);
		case EConfML2Package.ECONFIGURATION_ELEMENT__DESCRIPTIONS:
			return ((InternalEList<?>) getDescriptions()).basicRemove(otherEnd,
					msgs);
		case EConfML2Package.ECONFIGURATION_ELEMENT__METAS:
			return ((InternalEList<?>) getMetas()).basicRemove(otherEnd, msgs);
		case EConfML2Package.ECONFIGURATION_ELEMENT__CONFIGURATIONS:
			return ((InternalEList<?>) getConfigurations()).basicRemove(
					otherEnd, msgs);
		case EConfML2Package.ECONFIGURATION_ELEMENT__FEATURES:
			return ((InternalEList<?>) getFeatures()).basicRemove(otherEnd,
					msgs);
		case EConfML2Package.ECONFIGURATION_ELEMENT__VIEWS:
			return ((InternalEList<?>) getViews()).basicRemove(otherEnd, msgs);
		case EConfML2Package.ECONFIGURATION_ELEMENT__DATA:
			return ((InternalEList<?>) getData()).basicRemove(otherEnd, msgs);
		case EConfML2Package.ECONFIGURATION_ELEMENT__RFS:
			return ((InternalEList<?>) getRfs()).basicRemove(otherEnd, msgs);
		case EConfML2Package.ECONFIGURATION_ELEMENT__INCLUDES:
			return ((InternalEList<?>) getIncludes()).basicRemove(otherEnd,
					msgs);
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
		case EConfML2Package.ECONFIGURATION_ELEMENT__CONTENTS:
			if (coreType)
				return getContents();
			return ((FeatureMap.Internal) getContents()).getWrapper();
		case EConfML2Package.ECONFIGURATION_ELEMENT__LINKS:
			return getLinks();
		case EConfML2Package.ECONFIGURATION_ELEMENT__ICONS:
			return getIcons();
		case EConfML2Package.ECONFIGURATION_ELEMENT__DESCRIPTIONS:
			return getDescriptions();
		case EConfML2Package.ECONFIGURATION_ELEMENT__METAS:
			return getMetas();
		case EConfML2Package.ECONFIGURATION_ELEMENT__CONFIGURATIONS:
			return getConfigurations();
		case EConfML2Package.ECONFIGURATION_ELEMENT__FEATURES:
			return getFeatures();
		case EConfML2Package.ECONFIGURATION_ELEMENT__VIEWS:
			return getViews();
		case EConfML2Package.ECONFIGURATION_ELEMENT__DATA:
			return getData();
		case EConfML2Package.ECONFIGURATION_ELEMENT__RFS:
			return getRfs();
		case EConfML2Package.ECONFIGURATION_ELEMENT__NAME:
			return getName();
		case EConfML2Package.ECONFIGURATION_ELEMENT__VERSION:
			return getVersion();
		case EConfML2Package.ECONFIGURATION_ELEMENT__INCLUDES:
			return getIncludes();
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
		case EConfML2Package.ECONFIGURATION_ELEMENT__CONTENTS:
			((FeatureMap.Internal) getContents()).set(newValue);
			return;
		case EConfML2Package.ECONFIGURATION_ELEMENT__LINKS:
			getLinks().clear();
			getLinks().addAll((Collection<? extends ELinkElement>) newValue);
			return;
		case EConfML2Package.ECONFIGURATION_ELEMENT__ICONS:
			getIcons().clear();
			getIcons().addAll((Collection<? extends EIconElement>) newValue);
			return;
		case EConfML2Package.ECONFIGURATION_ELEMENT__DESCRIPTIONS:
			getDescriptions().clear();
			getDescriptions().addAll(
					(Collection<? extends EDescriptionElement>) newValue);
			return;
		case EConfML2Package.ECONFIGURATION_ELEMENT__METAS:
			getMetas().clear();
			getMetas().addAll((Collection<? extends EMetaElement>) newValue);
			return;
		case EConfML2Package.ECONFIGURATION_ELEMENT__CONFIGURATIONS:
			getConfigurations().clear();
			getConfigurations().addAll(
					(Collection<? extends EConfigurationElement>) newValue);
			return;
		case EConfML2Package.ECONFIGURATION_ELEMENT__FEATURES:
			getFeatures().clear();
			getFeatures().addAll(
					(Collection<? extends EFeatureElement>) newValue);
			return;
		case EConfML2Package.ECONFIGURATION_ELEMENT__VIEWS:
			getViews().clear();
			getViews().addAll((Collection<? extends EViewElement>) newValue);
			return;
		case EConfML2Package.ECONFIGURATION_ELEMENT__DATA:
			getData().clear();
			getData().addAll((Collection<? extends EDataElement>) newValue);
			return;
		case EConfML2Package.ECONFIGURATION_ELEMENT__RFS:
			getRfs().clear();
			getRfs().addAll((Collection<? extends ERfsElement>) newValue);
			return;
		case EConfML2Package.ECONFIGURATION_ELEMENT__NAME:
			setName((String) newValue);
			return;
		case EConfML2Package.ECONFIGURATION_ELEMENT__VERSION:
			setVersion((String) newValue);
			return;
		case EConfML2Package.ECONFIGURATION_ELEMENT__INCLUDES:
			getIncludes().clear();
			getIncludes().addAll((Collection<? extends EInclude>) newValue);
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
		case EConfML2Package.ECONFIGURATION_ELEMENT__CONTENTS:
			getContents().clear();
			return;
		case EConfML2Package.ECONFIGURATION_ELEMENT__LINKS:
			getLinks().clear();
			return;
		case EConfML2Package.ECONFIGURATION_ELEMENT__ICONS:
			getIcons().clear();
			return;
		case EConfML2Package.ECONFIGURATION_ELEMENT__DESCRIPTIONS:
			getDescriptions().clear();
			return;
		case EConfML2Package.ECONFIGURATION_ELEMENT__METAS:
			getMetas().clear();
			return;
		case EConfML2Package.ECONFIGURATION_ELEMENT__CONFIGURATIONS:
			getConfigurations().clear();
			return;
		case EConfML2Package.ECONFIGURATION_ELEMENT__FEATURES:
			getFeatures().clear();
			return;
		case EConfML2Package.ECONFIGURATION_ELEMENT__VIEWS:
			getViews().clear();
			return;
		case EConfML2Package.ECONFIGURATION_ELEMENT__DATA:
			getData().clear();
			return;
		case EConfML2Package.ECONFIGURATION_ELEMENT__RFS:
			getRfs().clear();
			return;
		case EConfML2Package.ECONFIGURATION_ELEMENT__NAME:
			setName(NAME_EDEFAULT);
			return;
		case EConfML2Package.ECONFIGURATION_ELEMENT__VERSION:
			setVersion(VERSION_EDEFAULT);
			return;
		case EConfML2Package.ECONFIGURATION_ELEMENT__INCLUDES:
			getIncludes().clear();
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
		case EConfML2Package.ECONFIGURATION_ELEMENT__CONTENTS:
			return contents != null && !contents.isEmpty();
		case EConfML2Package.ECONFIGURATION_ELEMENT__LINKS:
			return !getLinks().isEmpty();
		case EConfML2Package.ECONFIGURATION_ELEMENT__ICONS:
			return !getIcons().isEmpty();
		case EConfML2Package.ECONFIGURATION_ELEMENT__DESCRIPTIONS:
			return !getDescriptions().isEmpty();
		case EConfML2Package.ECONFIGURATION_ELEMENT__METAS:
			return !getMetas().isEmpty();
		case EConfML2Package.ECONFIGURATION_ELEMENT__CONFIGURATIONS:
			return !getConfigurations().isEmpty();
		case EConfML2Package.ECONFIGURATION_ELEMENT__FEATURES:
			return !getFeatures().isEmpty();
		case EConfML2Package.ECONFIGURATION_ELEMENT__VIEWS:
			return !getViews().isEmpty();
		case EConfML2Package.ECONFIGURATION_ELEMENT__DATA:
			return !getData().isEmpty();
		case EConfML2Package.ECONFIGURATION_ELEMENT__RFS:
			return !getRfs().isEmpty();
		case EConfML2Package.ECONFIGURATION_ELEMENT__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT
					.equals(name);
		case EConfML2Package.ECONFIGURATION_ELEMENT__VERSION:
			return VERSION_EDEFAULT == null ? version != null
					: !VERSION_EDEFAULT.equals(version);
		case EConfML2Package.ECONFIGURATION_ELEMENT__INCLUDES:
			return !getIncludes().isEmpty();
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
		if (baseClass == EContents.class) {
			switch (derivedFeatureID) {
			case EConfML2Package.ECONFIGURATION_ELEMENT__CONTENTS:
				return EConfML2Package.ECONTENTS__CONTENTS;
			default:
				return -1;
			}
		}
		if (baseClass == ELinkContainer.class) {
			switch (derivedFeatureID) {
			case EConfML2Package.ECONFIGURATION_ELEMENT__LINKS:
				return EConfML2Package.ELINK_CONTAINER__LINKS;
			default:
				return -1;
			}
		}
		if (baseClass == EIconContainer.class) {
			switch (derivedFeatureID) {
			case EConfML2Package.ECONFIGURATION_ELEMENT__ICONS:
				return EConfML2Package.EICON_CONTAINER__ICONS;
			default:
				return -1;
			}
		}
		if (baseClass == EDescriptionContainer.class) {
			switch (derivedFeatureID) {
			case EConfML2Package.ECONFIGURATION_ELEMENT__DESCRIPTIONS:
				return EConfML2Package.EDESCRIPTION_CONTAINER__DESCRIPTIONS;
			default:
				return -1;
			}
		}
		if (baseClass == EMetaContainer.class) {
			switch (derivedFeatureID) {
			case EConfML2Package.ECONFIGURATION_ELEMENT__METAS:
				return EConfML2Package.EMETA_CONTAINER__METAS;
			default:
				return -1;
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
		if (baseClass == EContents.class) {
			switch (baseFeatureID) {
			case EConfML2Package.ECONTENTS__CONTENTS:
				return EConfML2Package.ECONFIGURATION_ELEMENT__CONTENTS;
			default:
				return -1;
			}
		}
		if (baseClass == ELinkContainer.class) {
			switch (baseFeatureID) {
			case EConfML2Package.ELINK_CONTAINER__LINKS:
				return EConfML2Package.ECONFIGURATION_ELEMENT__LINKS;
			default:
				return -1;
			}
		}
		if (baseClass == EIconContainer.class) {
			switch (baseFeatureID) {
			case EConfML2Package.EICON_CONTAINER__ICONS:
				return EConfML2Package.ECONFIGURATION_ELEMENT__ICONS;
			default:
				return -1;
			}
		}
		if (baseClass == EDescriptionContainer.class) {
			switch (baseFeatureID) {
			case EConfML2Package.EDESCRIPTION_CONTAINER__DESCRIPTIONS:
				return EConfML2Package.ECONFIGURATION_ELEMENT__DESCRIPTIONS;
			default:
				return -1;
			}
		}
		if (baseClass == EMetaContainer.class) {
			switch (baseFeatureID) {
			case EConfML2Package.EMETA_CONTAINER__METAS:
				return EConfML2Package.ECONFIGURATION_ELEMENT__METAS;
			default:
				return -1;
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
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (contents: ");
		result.append(contents);
		result.append(", name: ");
		result.append(name);
		result.append(", version: ");
		result.append(version);
		result.append(')');
		return result.toString();
	}

} //EConfigurationElementImpl
