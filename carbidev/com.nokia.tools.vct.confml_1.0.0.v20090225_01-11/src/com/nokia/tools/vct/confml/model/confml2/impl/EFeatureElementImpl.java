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

import com.nokia.tools.vct.confml.model.confml2.EConfML2Package;
import com.nokia.tools.vct.confml.model.confml2.EContents;
import com.nokia.tools.vct.confml.model.confml2.EDescriptionContainer;
import com.nokia.tools.vct.confml.model.confml2.EDescriptionElement;
import com.nokia.tools.vct.confml.model.confml2.EFeatureElement;
import com.nokia.tools.vct.confml.model.confml2.EIconContainer;
import com.nokia.tools.vct.confml.model.confml2.EIconElement;
import com.nokia.tools.vct.confml.model.confml2.ELinkContainer;
import com.nokia.tools.vct.confml.model.confml2.ELinkElement;
import com.nokia.tools.vct.confml.model.confml2.ESettingElement;
import com.nokia.tools.vct.confml.model.confml2.ESettingTypeContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EFeature Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.EFeatureElementImpl#getContents <em>Contents</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.EFeatureElementImpl#getDescriptions <em>Descriptions</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.EFeatureElementImpl#getLinks <em>Links</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.EFeatureElementImpl#getSettings <em>Settings</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.EFeatureElementImpl#getIcons <em>Icons</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.EFeatureElementImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.EFeatureElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.EFeatureElementImpl#getRelevant <em>Relevant</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EFeatureElementImpl extends ECommonAttrsImpl implements
		EFeatureElement {
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
	 * The default value of the '{@link #getRef() <em>Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRef()
	 * @generated
	 * @ordered
	 */
	protected static final String REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRef() <em>Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRef()
	 * @generated
	 * @ordered
	 */
	protected String ref = REF_EDEFAULT;

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
	 * The default value of the '{@link #getRelevant() <em>Relevant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelevant()
	 * @generated
	 * @ordered
	 */
	protected static final String RELEVANT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRelevant() <em>Relevant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelevant()
	 * @generated
	 * @ordered
	 */
	protected String relevant = RELEVANT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EFeatureElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EConfML2Package.Literals.EFEATURE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getContents() {
		if (contents == null) {
			contents = new BasicFeatureMap(this,
					EConfML2Package.EFEATURE_ELEMENT__CONTENTS);
		}
		return contents;
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
	public EList<ELinkElement> getLinks() {
		return getContents().list(
				EConfML2Package.Literals.ELINK_CONTAINER__LINKS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ESettingElement> getSettings() {
		return getContents().list(
				EConfML2Package.Literals.ESETTING_TYPE_CONTAINER__SETTINGS);
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
	public String getRef() {
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRef(String newRef) {
		String oldRef = ref;
		ref = newRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					EConfML2Package.EFEATURE_ELEMENT__REF, oldRef, ref));
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
					EConfML2Package.EFEATURE_ELEMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRelevant() {
		return relevant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelevant(String newRelevant) {
		String oldRelevant = relevant;
		relevant = newRelevant;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					EConfML2Package.EFEATURE_ELEMENT__RELEVANT, oldRelevant,
					relevant));
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
		case EConfML2Package.EFEATURE_ELEMENT__CONTENTS:
			return ((InternalEList<?>) getContents()).basicRemove(otherEnd,
					msgs);
		case EConfML2Package.EFEATURE_ELEMENT__DESCRIPTIONS:
			return ((InternalEList<?>) getDescriptions()).basicRemove(otherEnd,
					msgs);
		case EConfML2Package.EFEATURE_ELEMENT__LINKS:
			return ((InternalEList<?>) getLinks()).basicRemove(otherEnd, msgs);
		case EConfML2Package.EFEATURE_ELEMENT__SETTINGS:
			return ((InternalEList<?>) getSettings()).basicRemove(otherEnd,
					msgs);
		case EConfML2Package.EFEATURE_ELEMENT__ICONS:
			return ((InternalEList<?>) getIcons()).basicRemove(otherEnd, msgs);
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
		case EConfML2Package.EFEATURE_ELEMENT__CONTENTS:
			if (coreType)
				return getContents();
			return ((FeatureMap.Internal) getContents()).getWrapper();
		case EConfML2Package.EFEATURE_ELEMENT__DESCRIPTIONS:
			return getDescriptions();
		case EConfML2Package.EFEATURE_ELEMENT__LINKS:
			return getLinks();
		case EConfML2Package.EFEATURE_ELEMENT__SETTINGS:
			return getSettings();
		case EConfML2Package.EFEATURE_ELEMENT__ICONS:
			return getIcons();
		case EConfML2Package.EFEATURE_ELEMENT__REF:
			return getRef();
		case EConfML2Package.EFEATURE_ELEMENT__NAME:
			return getName();
		case EConfML2Package.EFEATURE_ELEMENT__RELEVANT:
			return getRelevant();
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
		case EConfML2Package.EFEATURE_ELEMENT__CONTENTS:
			((FeatureMap.Internal) getContents()).set(newValue);
			return;
		case EConfML2Package.EFEATURE_ELEMENT__DESCRIPTIONS:
			getDescriptions().clear();
			getDescriptions().addAll(
					(Collection<? extends EDescriptionElement>) newValue);
			return;
		case EConfML2Package.EFEATURE_ELEMENT__LINKS:
			getLinks().clear();
			getLinks().addAll((Collection<? extends ELinkElement>) newValue);
			return;
		case EConfML2Package.EFEATURE_ELEMENT__SETTINGS:
			getSettings().clear();
			getSettings().addAll(
					(Collection<? extends ESettingElement>) newValue);
			return;
		case EConfML2Package.EFEATURE_ELEMENT__ICONS:
			getIcons().clear();
			getIcons().addAll((Collection<? extends EIconElement>) newValue);
			return;
		case EConfML2Package.EFEATURE_ELEMENT__REF:
			setRef((String) newValue);
			return;
		case EConfML2Package.EFEATURE_ELEMENT__NAME:
			setName((String) newValue);
			return;
		case EConfML2Package.EFEATURE_ELEMENT__RELEVANT:
			setRelevant((String) newValue);
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
		case EConfML2Package.EFEATURE_ELEMENT__CONTENTS:
			getContents().clear();
			return;
		case EConfML2Package.EFEATURE_ELEMENT__DESCRIPTIONS:
			getDescriptions().clear();
			return;
		case EConfML2Package.EFEATURE_ELEMENT__LINKS:
			getLinks().clear();
			return;
		case EConfML2Package.EFEATURE_ELEMENT__SETTINGS:
			getSettings().clear();
			return;
		case EConfML2Package.EFEATURE_ELEMENT__ICONS:
			getIcons().clear();
			return;
		case EConfML2Package.EFEATURE_ELEMENT__REF:
			setRef(REF_EDEFAULT);
			return;
		case EConfML2Package.EFEATURE_ELEMENT__NAME:
			setName(NAME_EDEFAULT);
			return;
		case EConfML2Package.EFEATURE_ELEMENT__RELEVANT:
			setRelevant(RELEVANT_EDEFAULT);
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
		case EConfML2Package.EFEATURE_ELEMENT__CONTENTS:
			return contents != null && !contents.isEmpty();
		case EConfML2Package.EFEATURE_ELEMENT__DESCRIPTIONS:
			return !getDescriptions().isEmpty();
		case EConfML2Package.EFEATURE_ELEMENT__LINKS:
			return !getLinks().isEmpty();
		case EConfML2Package.EFEATURE_ELEMENT__SETTINGS:
			return !getSettings().isEmpty();
		case EConfML2Package.EFEATURE_ELEMENT__ICONS:
			return !getIcons().isEmpty();
		case EConfML2Package.EFEATURE_ELEMENT__REF:
			return REF_EDEFAULT == null ? ref != null : !REF_EDEFAULT
					.equals(ref);
		case EConfML2Package.EFEATURE_ELEMENT__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT
					.equals(name);
		case EConfML2Package.EFEATURE_ELEMENT__RELEVANT:
			return RELEVANT_EDEFAULT == null ? relevant != null
					: !RELEVANT_EDEFAULT.equals(relevant);
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
			case EConfML2Package.EFEATURE_ELEMENT__CONTENTS:
				return EConfML2Package.ECONTENTS__CONTENTS;
			default:
				return -1;
			}
		}
		if (baseClass == EDescriptionContainer.class) {
			switch (derivedFeatureID) {
			case EConfML2Package.EFEATURE_ELEMENT__DESCRIPTIONS:
				return EConfML2Package.EDESCRIPTION_CONTAINER__DESCRIPTIONS;
			default:
				return -1;
			}
		}
		if (baseClass == ELinkContainer.class) {
			switch (derivedFeatureID) {
			case EConfML2Package.EFEATURE_ELEMENT__LINKS:
				return EConfML2Package.ELINK_CONTAINER__LINKS;
			default:
				return -1;
			}
		}
		if (baseClass == ESettingTypeContainer.class) {
			switch (derivedFeatureID) {
			case EConfML2Package.EFEATURE_ELEMENT__SETTINGS:
				return EConfML2Package.ESETTING_TYPE_CONTAINER__SETTINGS;
			default:
				return -1;
			}
		}
		if (baseClass == EIconContainer.class) {
			switch (derivedFeatureID) {
			case EConfML2Package.EFEATURE_ELEMENT__ICONS:
				return EConfML2Package.EICON_CONTAINER__ICONS;
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
				return EConfML2Package.EFEATURE_ELEMENT__CONTENTS;
			default:
				return -1;
			}
		}
		if (baseClass == EDescriptionContainer.class) {
			switch (baseFeatureID) {
			case EConfML2Package.EDESCRIPTION_CONTAINER__DESCRIPTIONS:
				return EConfML2Package.EFEATURE_ELEMENT__DESCRIPTIONS;
			default:
				return -1;
			}
		}
		if (baseClass == ELinkContainer.class) {
			switch (baseFeatureID) {
			case EConfML2Package.ELINK_CONTAINER__LINKS:
				return EConfML2Package.EFEATURE_ELEMENT__LINKS;
			default:
				return -1;
			}
		}
		if (baseClass == ESettingTypeContainer.class) {
			switch (baseFeatureID) {
			case EConfML2Package.ESETTING_TYPE_CONTAINER__SETTINGS:
				return EConfML2Package.EFEATURE_ELEMENT__SETTINGS;
			default:
				return -1;
			}
		}
		if (baseClass == EIconContainer.class) {
			switch (baseFeatureID) {
			case EConfML2Package.EICON_CONTAINER__ICONS:
				return EConfML2Package.EFEATURE_ELEMENT__ICONS;
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
		result.append(", ref: ");
		result.append(ref);
		result.append(", name: ");
		result.append(name);
		result.append(", relevant: ");
		result.append(relevant);
		result.append(')');
		return result.toString();
	}

} //EFeatureElementImpl
