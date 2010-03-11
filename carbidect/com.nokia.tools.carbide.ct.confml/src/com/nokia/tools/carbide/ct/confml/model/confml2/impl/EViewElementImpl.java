/**
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
 * All rights reserved.
 * This component and the accompanying materials are made available
 * under the terms of "Eclipse Public License v1.0"
 * which accompanies this distribution, and is available
 * at the URL "http://www.eclipse.org/legal/epl-v10.html".
 * 
 * Initial Contributors:
 * Nokia Corporation - initial contribution.
 * 
 * Contributors:
 * 
 * Description:
 *
 * $Id$
 */
package com.nokia.tools.carbide.ct.confml.model.confml2.impl;

import com.nokia.tools.carbide.ct.confml.model.confml2.EConfML2Package;
import com.nokia.tools.carbide.ct.confml.model.confml2.EContents;
import com.nokia.tools.carbide.ct.confml.model.confml2.EDescriptionContainer;
import com.nokia.tools.carbide.ct.confml.model.confml2.EDescriptionElement;
import com.nokia.tools.carbide.ct.confml.model.confml2.EGroup;
import com.nokia.tools.carbide.ct.confml.model.confml2.EGroupContainer;
import com.nokia.tools.carbide.ct.confml.model.confml2.EIconContainer;
import com.nokia.tools.carbide.ct.confml.model.confml2.EIconElement;
import com.nokia.tools.carbide.ct.confml.model.confml2.ELinkContainer;
import com.nokia.tools.carbide.ct.confml.model.confml2.ELinkElement;
import com.nokia.tools.carbide.ct.confml.model.confml2.EMetaContainer;
import com.nokia.tools.carbide.ct.confml.model.confml2.EMetaElement;
import com.nokia.tools.carbide.ct.confml.model.confml2.EViewElement;

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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EView Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.EViewElementImpl#getContents <em>Contents</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.EViewElementImpl#getLinks <em>Links</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.EViewElementImpl#getDescriptions <em>Descriptions</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.EViewElementImpl#getIcons <em>Icons</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.EViewElementImpl#getGroups <em>Groups</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.EViewElementImpl#getMetas <em>Metas</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.confml.model.confml2.impl.EViewElementImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EViewElementImpl extends ECommonAttrsImpl implements EViewElement {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EViewElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EConfML2Package.Literals.EVIEW_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getContents() {
		if (contents == null) {
			contents = new BasicFeatureMap(this,
					EConfML2Package.EVIEW_ELEMENT__CONTENTS);
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
	public EList<EDescriptionElement> getDescriptions() {
		return getContents().list(
				EConfML2Package.Literals.EDESCRIPTION_CONTAINER__DESCRIPTIONS);
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
	public EList<EGroup> getGroups() {
		return getContents().list(
				EConfML2Package.Literals.EGROUP_CONTAINER__GROUPS);
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
					EConfML2Package.EVIEW_ELEMENT__NAME, oldName, name));
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
		case EConfML2Package.EVIEW_ELEMENT__CONTENTS:
			return ((InternalEList<?>) getContents()).basicRemove(otherEnd,
					msgs);
		case EConfML2Package.EVIEW_ELEMENT__LINKS:
			return ((InternalEList<?>) getLinks()).basicRemove(otherEnd, msgs);
		case EConfML2Package.EVIEW_ELEMENT__DESCRIPTIONS:
			return ((InternalEList<?>) getDescriptions()).basicRemove(otherEnd,
					msgs);
		case EConfML2Package.EVIEW_ELEMENT__ICONS:
			return ((InternalEList<?>) getIcons()).basicRemove(otherEnd, msgs);
		case EConfML2Package.EVIEW_ELEMENT__GROUPS:
			return ((InternalEList<?>) getGroups()).basicRemove(otherEnd, msgs);
		case EConfML2Package.EVIEW_ELEMENT__METAS:
			return ((InternalEList<?>) getMetas()).basicRemove(otherEnd, msgs);
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
		case EConfML2Package.EVIEW_ELEMENT__CONTENTS:
			if (coreType)
				return getContents();
			return ((FeatureMap.Internal) getContents()).getWrapper();
		case EConfML2Package.EVIEW_ELEMENT__LINKS:
			return getLinks();
		case EConfML2Package.EVIEW_ELEMENT__DESCRIPTIONS:
			return getDescriptions();
		case EConfML2Package.EVIEW_ELEMENT__ICONS:
			return getIcons();
		case EConfML2Package.EVIEW_ELEMENT__GROUPS:
			return getGroups();
		case EConfML2Package.EVIEW_ELEMENT__METAS:
			return getMetas();
		case EConfML2Package.EVIEW_ELEMENT__NAME:
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
		case EConfML2Package.EVIEW_ELEMENT__CONTENTS:
			((FeatureMap.Internal) getContents()).set(newValue);
			return;
		case EConfML2Package.EVIEW_ELEMENT__LINKS:
			getLinks().clear();
			getLinks().addAll((Collection<? extends ELinkElement>) newValue);
			return;
		case EConfML2Package.EVIEW_ELEMENT__DESCRIPTIONS:
			getDescriptions().clear();
			getDescriptions().addAll(
					(Collection<? extends EDescriptionElement>) newValue);
			return;
		case EConfML2Package.EVIEW_ELEMENT__ICONS:
			getIcons().clear();
			getIcons().addAll((Collection<? extends EIconElement>) newValue);
			return;
		case EConfML2Package.EVIEW_ELEMENT__GROUPS:
			getGroups().clear();
			getGroups().addAll((Collection<? extends EGroup>) newValue);
			return;
		case EConfML2Package.EVIEW_ELEMENT__METAS:
			getMetas().clear();
			getMetas().addAll((Collection<? extends EMetaElement>) newValue);
			return;
		case EConfML2Package.EVIEW_ELEMENT__NAME:
			setName((String) newValue);
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
		case EConfML2Package.EVIEW_ELEMENT__CONTENTS:
			getContents().clear();
			return;
		case EConfML2Package.EVIEW_ELEMENT__LINKS:
			getLinks().clear();
			return;
		case EConfML2Package.EVIEW_ELEMENT__DESCRIPTIONS:
			getDescriptions().clear();
			return;
		case EConfML2Package.EVIEW_ELEMENT__ICONS:
			getIcons().clear();
			return;
		case EConfML2Package.EVIEW_ELEMENT__GROUPS:
			getGroups().clear();
			return;
		case EConfML2Package.EVIEW_ELEMENT__METAS:
			getMetas().clear();
			return;
		case EConfML2Package.EVIEW_ELEMENT__NAME:
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
		case EConfML2Package.EVIEW_ELEMENT__CONTENTS:
			return contents != null && !contents.isEmpty();
		case EConfML2Package.EVIEW_ELEMENT__LINKS:
			return !getLinks().isEmpty();
		case EConfML2Package.EVIEW_ELEMENT__DESCRIPTIONS:
			return !getDescriptions().isEmpty();
		case EConfML2Package.EVIEW_ELEMENT__ICONS:
			return !getIcons().isEmpty();
		case EConfML2Package.EVIEW_ELEMENT__GROUPS:
			return !getGroups().isEmpty();
		case EConfML2Package.EVIEW_ELEMENT__METAS:
			return !getMetas().isEmpty();
		case EConfML2Package.EVIEW_ELEMENT__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT
					.equals(name);
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
			case EConfML2Package.EVIEW_ELEMENT__CONTENTS:
				return EConfML2Package.ECONTENTS__CONTENTS;
			default:
				return -1;
			}
		}
		if (baseClass == ELinkContainer.class) {
			switch (derivedFeatureID) {
			case EConfML2Package.EVIEW_ELEMENT__LINKS:
				return EConfML2Package.ELINK_CONTAINER__LINKS;
			default:
				return -1;
			}
		}
		if (baseClass == EDescriptionContainer.class) {
			switch (derivedFeatureID) {
			case EConfML2Package.EVIEW_ELEMENT__DESCRIPTIONS:
				return EConfML2Package.EDESCRIPTION_CONTAINER__DESCRIPTIONS;
			default:
				return -1;
			}
		}
		if (baseClass == EIconContainer.class) {
			switch (derivedFeatureID) {
			case EConfML2Package.EVIEW_ELEMENT__ICONS:
				return EConfML2Package.EICON_CONTAINER__ICONS;
			default:
				return -1;
			}
		}
		if (baseClass == EGroupContainer.class) {
			switch (derivedFeatureID) {
			case EConfML2Package.EVIEW_ELEMENT__GROUPS:
				return EConfML2Package.EGROUP_CONTAINER__GROUPS;
			default:
				return -1;
			}
		}
		if (baseClass == EMetaContainer.class) {
			switch (derivedFeatureID) {
			case EConfML2Package.EVIEW_ELEMENT__METAS:
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
				return EConfML2Package.EVIEW_ELEMENT__CONTENTS;
			default:
				return -1;
			}
		}
		if (baseClass == ELinkContainer.class) {
			switch (baseFeatureID) {
			case EConfML2Package.ELINK_CONTAINER__LINKS:
				return EConfML2Package.EVIEW_ELEMENT__LINKS;
			default:
				return -1;
			}
		}
		if (baseClass == EDescriptionContainer.class) {
			switch (baseFeatureID) {
			case EConfML2Package.EDESCRIPTION_CONTAINER__DESCRIPTIONS:
				return EConfML2Package.EVIEW_ELEMENT__DESCRIPTIONS;
			default:
				return -1;
			}
		}
		if (baseClass == EIconContainer.class) {
			switch (baseFeatureID) {
			case EConfML2Package.EICON_CONTAINER__ICONS:
				return EConfML2Package.EVIEW_ELEMENT__ICONS;
			default:
				return -1;
			}
		}
		if (baseClass == EGroupContainer.class) {
			switch (baseFeatureID) {
			case EConfML2Package.EGROUP_CONTAINER__GROUPS:
				return EConfML2Package.EVIEW_ELEMENT__GROUPS;
			default:
				return -1;
			}
		}
		if (baseClass == EMetaContainer.class) {
			switch (baseFeatureID) {
			case EConfML2Package.EMETA_CONTAINER__METAS:
				return EConfML2Package.EVIEW_ELEMENT__METAS;
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
		result.append(')');
		return result.toString();
	}

} //EViewElementImpl
