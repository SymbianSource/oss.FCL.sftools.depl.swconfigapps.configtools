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
import com.nokia.tools.vct.confml.model.confml2.EIconContainer;
import com.nokia.tools.vct.confml.model.confml2.EIconElement;
import com.nokia.tools.vct.confml.model.confml2.ELinkContainer;
import com.nokia.tools.vct.confml.model.confml2.ELinkElement;
import com.nokia.tools.vct.confml.model.confml2.ELocalPathElement;
import com.nokia.tools.vct.confml.model.xsd.EPattern;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ELocal Path Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.ELocalPathElementImpl#getContents <em>Contents</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.ELocalPathElementImpl#getDescriptions <em>Descriptions</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.ELocalPathElementImpl#getIcons <em>Icons</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.ELocalPathElementImpl#getLinks <em>Links</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.ELocalPathElementImpl#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.ELocalPathElementImpl#getReadOnly <em>Read Only</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.ELocalPathElementImpl#getRequired <em>Required</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.ELocalPathElementImpl#getMap <em>Map</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.ELocalPathElementImpl#getPattern <em>Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ELocalPathElementImpl extends ECommonAttrsImpl implements
		ELocalPathElement {
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
	 * The default value of the '{@link #getConstraint() <em>Constraint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraint()
	 * @generated
	 * @ordered
	 */
	protected static final String CONSTRAINT_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getConstraint() <em>Constraint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraint()
	 * @generated
	 * @ordered
	 */
	protected String constraint = CONSTRAINT_EDEFAULT;
	/**
	 * The default value of the '{@link #getReadOnly() <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReadOnly()
	 * @generated
	 * @ordered
	 */
	protected static final String READ_ONLY_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getReadOnly() <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReadOnly()
	 * @generated
	 * @ordered
	 */
	protected String readOnly = READ_ONLY_EDEFAULT;
	/**
	 * The default value of the '{@link #getRequired() <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequired()
	 * @generated
	 * @ordered
	 */
	protected static final String REQUIRED_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getRequired() <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequired()
	 * @generated
	 * @ordered
	 */
	protected String required = REQUIRED_EDEFAULT;
	/**
	 * The default value of the '{@link #getMap() <em>Map</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMap()
	 * @generated
	 * @ordered
	 */
	protected static final String MAP_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getMap() <em>Map</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMap()
	 * @generated
	 * @ordered
	 */
	protected String map = MAP_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ELocalPathElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EConfML2Package.Literals.ELOCAL_PATH_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getContents() {
		if (contents == null) {
			contents = new BasicFeatureMap(this,
					EConfML2Package.ELOCAL_PATH_ELEMENT__CONTENTS);
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
	public EList<EIconElement> getIcons() {
		return getContents().list(
				EConfML2Package.Literals.EICON_CONTAINER__ICONS);
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
	public String getConstraint() {
		return constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstraint(String newConstraint) {
		String oldConstraint = constraint;
		constraint = newConstraint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					EConfML2Package.ELOCAL_PATH_ELEMENT__CONSTRAINT,
					oldConstraint, constraint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReadOnly() {
		return readOnly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReadOnly(String newReadOnly) {
		String oldReadOnly = readOnly;
		readOnly = newReadOnly;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					EConfML2Package.ELOCAL_PATH_ELEMENT__READ_ONLY,
					oldReadOnly, readOnly));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRequired() {
		return required;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequired(String newRequired) {
		String oldRequired = required;
		required = newRequired;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					EConfML2Package.ELOCAL_PATH_ELEMENT__REQUIRED, oldRequired,
					required));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMap() {
		return map;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMap(String newMap) {
		String oldMap = map;
		map = newMap;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					EConfML2Package.ELOCAL_PATH_ELEMENT__MAP, oldMap, map));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EPattern> getPattern() {
		return getContents().list(
				EConfML2Package.Literals.ELOCAL_PATH_ELEMENT__PATTERN);
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
		case EConfML2Package.ELOCAL_PATH_ELEMENT__CONTENTS:
			return ((InternalEList<?>) getContents()).basicRemove(otherEnd,
					msgs);
		case EConfML2Package.ELOCAL_PATH_ELEMENT__DESCRIPTIONS:
			return ((InternalEList<?>) getDescriptions()).basicRemove(otherEnd,
					msgs);
		case EConfML2Package.ELOCAL_PATH_ELEMENT__ICONS:
			return ((InternalEList<?>) getIcons()).basicRemove(otherEnd, msgs);
		case EConfML2Package.ELOCAL_PATH_ELEMENT__LINKS:
			return ((InternalEList<?>) getLinks()).basicRemove(otherEnd, msgs);
		case EConfML2Package.ELOCAL_PATH_ELEMENT__PATTERN:
			return ((InternalEList<?>) getPattern())
					.basicRemove(otherEnd, msgs);
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
		case EConfML2Package.ELOCAL_PATH_ELEMENT__CONTENTS:
			if (coreType)
				return getContents();
			return ((FeatureMap.Internal) getContents()).getWrapper();
		case EConfML2Package.ELOCAL_PATH_ELEMENT__DESCRIPTIONS:
			return getDescriptions();
		case EConfML2Package.ELOCAL_PATH_ELEMENT__ICONS:
			return getIcons();
		case EConfML2Package.ELOCAL_PATH_ELEMENT__LINKS:
			return getLinks();
		case EConfML2Package.ELOCAL_PATH_ELEMENT__CONSTRAINT:
			return getConstraint();
		case EConfML2Package.ELOCAL_PATH_ELEMENT__READ_ONLY:
			return getReadOnly();
		case EConfML2Package.ELOCAL_PATH_ELEMENT__REQUIRED:
			return getRequired();
		case EConfML2Package.ELOCAL_PATH_ELEMENT__MAP:
			return getMap();
		case EConfML2Package.ELOCAL_PATH_ELEMENT__PATTERN:
			return getPattern();
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
		case EConfML2Package.ELOCAL_PATH_ELEMENT__CONTENTS:
			((FeatureMap.Internal) getContents()).set(newValue);
			return;
		case EConfML2Package.ELOCAL_PATH_ELEMENT__DESCRIPTIONS:
			getDescriptions().clear();
			getDescriptions().addAll(
					(Collection<? extends EDescriptionElement>) newValue);
			return;
		case EConfML2Package.ELOCAL_PATH_ELEMENT__ICONS:
			getIcons().clear();
			getIcons().addAll((Collection<? extends EIconElement>) newValue);
			return;
		case EConfML2Package.ELOCAL_PATH_ELEMENT__LINKS:
			getLinks().clear();
			getLinks().addAll((Collection<? extends ELinkElement>) newValue);
			return;
		case EConfML2Package.ELOCAL_PATH_ELEMENT__CONSTRAINT:
			setConstraint((String) newValue);
			return;
		case EConfML2Package.ELOCAL_PATH_ELEMENT__READ_ONLY:
			setReadOnly((String) newValue);
			return;
		case EConfML2Package.ELOCAL_PATH_ELEMENT__REQUIRED:
			setRequired((String) newValue);
			return;
		case EConfML2Package.ELOCAL_PATH_ELEMENT__MAP:
			setMap((String) newValue);
			return;
		case EConfML2Package.ELOCAL_PATH_ELEMENT__PATTERN:
			getPattern().clear();
			getPattern().addAll((Collection<? extends EPattern>) newValue);
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
		case EConfML2Package.ELOCAL_PATH_ELEMENT__CONTENTS:
			getContents().clear();
			return;
		case EConfML2Package.ELOCAL_PATH_ELEMENT__DESCRIPTIONS:
			getDescriptions().clear();
			return;
		case EConfML2Package.ELOCAL_PATH_ELEMENT__ICONS:
			getIcons().clear();
			return;
		case EConfML2Package.ELOCAL_PATH_ELEMENT__LINKS:
			getLinks().clear();
			return;
		case EConfML2Package.ELOCAL_PATH_ELEMENT__CONSTRAINT:
			setConstraint(CONSTRAINT_EDEFAULT);
			return;
		case EConfML2Package.ELOCAL_PATH_ELEMENT__READ_ONLY:
			setReadOnly(READ_ONLY_EDEFAULT);
			return;
		case EConfML2Package.ELOCAL_PATH_ELEMENT__REQUIRED:
			setRequired(REQUIRED_EDEFAULT);
			return;
		case EConfML2Package.ELOCAL_PATH_ELEMENT__MAP:
			setMap(MAP_EDEFAULT);
			return;
		case EConfML2Package.ELOCAL_PATH_ELEMENT__PATTERN:
			getPattern().clear();
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
		case EConfML2Package.ELOCAL_PATH_ELEMENT__CONTENTS:
			return contents != null && !contents.isEmpty();
		case EConfML2Package.ELOCAL_PATH_ELEMENT__DESCRIPTIONS:
			return !getDescriptions().isEmpty();
		case EConfML2Package.ELOCAL_PATH_ELEMENT__ICONS:
			return !getIcons().isEmpty();
		case EConfML2Package.ELOCAL_PATH_ELEMENT__LINKS:
			return !getLinks().isEmpty();
		case EConfML2Package.ELOCAL_PATH_ELEMENT__CONSTRAINT:
			return CONSTRAINT_EDEFAULT == null ? constraint != null
					: !CONSTRAINT_EDEFAULT.equals(constraint);
		case EConfML2Package.ELOCAL_PATH_ELEMENT__READ_ONLY:
			return READ_ONLY_EDEFAULT == null ? readOnly != null
					: !READ_ONLY_EDEFAULT.equals(readOnly);
		case EConfML2Package.ELOCAL_PATH_ELEMENT__REQUIRED:
			return REQUIRED_EDEFAULT == null ? required != null
					: !REQUIRED_EDEFAULT.equals(required);
		case EConfML2Package.ELOCAL_PATH_ELEMENT__MAP:
			return MAP_EDEFAULT == null ? map != null : !MAP_EDEFAULT
					.equals(map);
		case EConfML2Package.ELOCAL_PATH_ELEMENT__PATTERN:
			return !getPattern().isEmpty();
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
			case EConfML2Package.ELOCAL_PATH_ELEMENT__CONTENTS:
				return EConfML2Package.ECONTENTS__CONTENTS;
			default:
				return -1;
			}
		}
		if (baseClass == EDescriptionContainer.class) {
			switch (derivedFeatureID) {
			case EConfML2Package.ELOCAL_PATH_ELEMENT__DESCRIPTIONS:
				return EConfML2Package.EDESCRIPTION_CONTAINER__DESCRIPTIONS;
			default:
				return -1;
			}
		}
		if (baseClass == EIconContainer.class) {
			switch (derivedFeatureID) {
			case EConfML2Package.ELOCAL_PATH_ELEMENT__ICONS:
				return EConfML2Package.EICON_CONTAINER__ICONS;
			default:
				return -1;
			}
		}
		if (baseClass == ELinkContainer.class) {
			switch (derivedFeatureID) {
			case EConfML2Package.ELOCAL_PATH_ELEMENT__LINKS:
				return EConfML2Package.ELINK_CONTAINER__LINKS;
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
				return EConfML2Package.ELOCAL_PATH_ELEMENT__CONTENTS;
			default:
				return -1;
			}
		}
		if (baseClass == EDescriptionContainer.class) {
			switch (baseFeatureID) {
			case EConfML2Package.EDESCRIPTION_CONTAINER__DESCRIPTIONS:
				return EConfML2Package.ELOCAL_PATH_ELEMENT__DESCRIPTIONS;
			default:
				return -1;
			}
		}
		if (baseClass == EIconContainer.class) {
			switch (baseFeatureID) {
			case EConfML2Package.EICON_CONTAINER__ICONS:
				return EConfML2Package.ELOCAL_PATH_ELEMENT__ICONS;
			default:
				return -1;
			}
		}
		if (baseClass == ELinkContainer.class) {
			switch (baseFeatureID) {
			case EConfML2Package.ELINK_CONTAINER__LINKS:
				return EConfML2Package.ELOCAL_PATH_ELEMENT__LINKS;
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
		result.append(", constraint: ");
		result.append(constraint);
		result.append(", readOnly: ");
		result.append(readOnly);
		result.append(", required: ");
		result.append(required);
		result.append(", map: ");
		result.append(map);
		result.append(')');
		return result.toString();
	}

} //ELocalPathElementImpl
