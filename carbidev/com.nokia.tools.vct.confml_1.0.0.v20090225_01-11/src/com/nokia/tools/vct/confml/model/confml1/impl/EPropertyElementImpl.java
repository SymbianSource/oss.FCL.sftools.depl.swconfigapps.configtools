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

package com.nokia.tools.vct.confml.model.confml1.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.nokia.tools.vct.confml.model.confml1.EConfML1Package;
import com.nokia.tools.vct.confml.model.confml1.EDescriptionContainer;
import com.nokia.tools.vct.confml.model.confml1.EDescriptionElement;
import com.nokia.tools.vct.confml.model.confml1.EIconElement;
import com.nokia.tools.vct.confml.model.confml1.ELinkContainer;
import com.nokia.tools.vct.confml.model.confml1.ELinkElement;
import com.nokia.tools.vct.confml.model.confml1.EPropertyElement;
import com.nokia.tools.vct.confml.model.confml1.EXLinkReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EProperty Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.impl.EPropertyElementImpl#getContents <em>Contents</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.impl.EPropertyElementImpl#getLinks <em>Links</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.impl.EPropertyElementImpl#getHref <em>Href</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.impl.EPropertyElementImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.impl.EPropertyElementImpl#getDescriptions <em>Descriptions</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.impl.EPropertyElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.impl.EPropertyElementImpl#getValue <em>Value</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.impl.EPropertyElementImpl#getUnit <em>Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EPropertyElementImpl extends ECommonAttrsImpl implements
		EPropertyElement {
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
	 * The default value of the '{@link #getHref() <em>Href</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHref()
	 * @generated
	 * @ordered
	 */
	protected static final String HREF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHref() <em>Href</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHref()
	 * @generated
	 * @ordered
	 */
	protected String href = HREF_EDEFAULT;

	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_EDEFAULT;

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
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getUnit() <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnit()
	 * @generated
	 * @ordered
	 */
	protected static final String UNIT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUnit() <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnit()
	 * @generated
	 * @ordered
	 */
	protected String unit = UNIT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EPropertyElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EConfML1Package.Literals.EPROPERTY_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getContents() {
		if (contents == null) {
			contents = new BasicFeatureMap(this,
					EConfML1Package.EPROPERTY_ELEMENT__CONTENTS);
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
				EConfML1Package.Literals.ELINK_CONTAINER__LINKS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHref() {
		return href;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHref(String newHref) {
		String oldHref = href;
		href = newHref;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					EConfML1Package.EPROPERTY_ELEMENT__HREF, oldHref, href));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitle(String newTitle) {
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					EConfML1Package.EPROPERTY_ELEMENT__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EDescriptionElement> getDescriptions() {
		return getContents().list(
				EConfML1Package.Literals.EDESCRIPTION_CONTAINER__DESCRIPTIONS);
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
					EConfML1Package.EPROPERTY_ELEMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					EConfML1Package.EPROPERTY_ELEMENT__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnit(String newUnit) {
		String oldUnit = unit;
		unit = newUnit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					EConfML1Package.EPROPERTY_ELEMENT__UNIT, oldUnit, unit));
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
		case EConfML1Package.EPROPERTY_ELEMENT__CONTENTS:
			return ((InternalEList<?>) getContents()).basicRemove(otherEnd,
					msgs);
		case EConfML1Package.EPROPERTY_ELEMENT__LINKS:
			return ((InternalEList<?>) getLinks()).basicRemove(otherEnd, msgs);
		case EConfML1Package.EPROPERTY_ELEMENT__DESCRIPTIONS:
			return ((InternalEList<?>) getDescriptions()).basicRemove(otherEnd,
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
		case EConfML1Package.EPROPERTY_ELEMENT__CONTENTS:
			if (coreType)
				return getContents();
			return ((FeatureMap.Internal) getContents()).getWrapper();
		case EConfML1Package.EPROPERTY_ELEMENT__LINKS:
			return getLinks();
		case EConfML1Package.EPROPERTY_ELEMENT__HREF:
			return getHref();
		case EConfML1Package.EPROPERTY_ELEMENT__TITLE:
			return getTitle();
		case EConfML1Package.EPROPERTY_ELEMENT__DESCRIPTIONS:
			return getDescriptions();
		case EConfML1Package.EPROPERTY_ELEMENT__NAME:
			return getName();
		case EConfML1Package.EPROPERTY_ELEMENT__VALUE:
			return getValue();
		case EConfML1Package.EPROPERTY_ELEMENT__UNIT:
			return getUnit();
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
		case EConfML1Package.EPROPERTY_ELEMENT__CONTENTS:
			((FeatureMap.Internal) getContents()).set(newValue);
			return;
		case EConfML1Package.EPROPERTY_ELEMENT__LINKS:
			getLinks().clear();
			getLinks().addAll((Collection<? extends ELinkElement>) newValue);
			return;
		case EConfML1Package.EPROPERTY_ELEMENT__HREF:
			setHref((String) newValue);
			return;
		case EConfML1Package.EPROPERTY_ELEMENT__TITLE:
			setTitle((String) newValue);
			return;
		case EConfML1Package.EPROPERTY_ELEMENT__DESCRIPTIONS:
			getDescriptions().clear();
			getDescriptions().addAll(
					(Collection<? extends EDescriptionElement>) newValue);
			return;
		case EConfML1Package.EPROPERTY_ELEMENT__NAME:
			setName((String) newValue);
			return;
		case EConfML1Package.EPROPERTY_ELEMENT__VALUE:
			setValue((String) newValue);
			return;
		case EConfML1Package.EPROPERTY_ELEMENT__UNIT:
			setUnit((String) newValue);
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
		case EConfML1Package.EPROPERTY_ELEMENT__CONTENTS:
			getContents().clear();
			return;
		case EConfML1Package.EPROPERTY_ELEMENT__LINKS:
			getLinks().clear();
			return;
		case EConfML1Package.EPROPERTY_ELEMENT__HREF:
			setHref(HREF_EDEFAULT);
			return;
		case EConfML1Package.EPROPERTY_ELEMENT__TITLE:
			setTitle(TITLE_EDEFAULT);
			return;
		case EConfML1Package.EPROPERTY_ELEMENT__DESCRIPTIONS:
			getDescriptions().clear();
			return;
		case EConfML1Package.EPROPERTY_ELEMENT__NAME:
			setName(NAME_EDEFAULT);
			return;
		case EConfML1Package.EPROPERTY_ELEMENT__VALUE:
			setValue(VALUE_EDEFAULT);
			return;
		case EConfML1Package.EPROPERTY_ELEMENT__UNIT:
			setUnit(UNIT_EDEFAULT);
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
		case EConfML1Package.EPROPERTY_ELEMENT__CONTENTS:
			return contents != null && !contents.isEmpty();
		case EConfML1Package.EPROPERTY_ELEMENT__LINKS:
			return !getLinks().isEmpty();
		case EConfML1Package.EPROPERTY_ELEMENT__HREF:
			return HREF_EDEFAULT == null ? href != null : !HREF_EDEFAULT
					.equals(href);
		case EConfML1Package.EPROPERTY_ELEMENT__TITLE:
			return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT
					.equals(title);
		case EConfML1Package.EPROPERTY_ELEMENT__DESCRIPTIONS:
			return !getDescriptions().isEmpty();
		case EConfML1Package.EPROPERTY_ELEMENT__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT
					.equals(name);
		case EConfML1Package.EPROPERTY_ELEMENT__VALUE:
			return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT
					.equals(value);
		case EConfML1Package.EPROPERTY_ELEMENT__UNIT:
			return UNIT_EDEFAULT == null ? unit != null : !UNIT_EDEFAULT
					.equals(unit);
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
		if (baseClass == EObject.class) {
			switch (derivedFeatureID) {
			case EConfML1Package.EPROPERTY_ELEMENT__CONTENTS:
				return EConfML1Package.ECONTENTS__CONTENTS;
			default:
				return -1;
			}
		}
		if (baseClass == ELinkContainer.class) {
			switch (derivedFeatureID) {
			case EConfML1Package.EPROPERTY_ELEMENT__LINKS:
				return EConfML1Package.ELINK_CONTAINER__LINKS;
			default:
				return -1;
			}
		}
		if (baseClass == EXLinkReference.class) {
			switch (derivedFeatureID) {
			case EConfML1Package.EPROPERTY_ELEMENT__HREF:
				return EConfML1Package.EX_LINK_REFERENCE__HREF;
			case EConfML1Package.EPROPERTY_ELEMENT__TITLE:
				return EConfML1Package.EX_LINK_REFERENCE__TITLE;
			default:
				return -1;
			}
		}
		if (baseClass == EIconElement.class) {
			switch (derivedFeatureID) {
			default:
				return -1;
			}
		}
		if (baseClass == EDescriptionContainer.class) {
			switch (derivedFeatureID) {
			case EConfML1Package.EPROPERTY_ELEMENT__DESCRIPTIONS:
				return EConfML1Package.EDESCRIPTION_CONTAINER__DESCRIPTIONS;
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
		if (baseClass == EObject.class) {
			switch (baseFeatureID) {
			case EConfML1Package.ECONTENTS__CONTENTS:
				return EConfML1Package.EPROPERTY_ELEMENT__CONTENTS;
			default:
				return -1;
			}
		}
		if (baseClass == ELinkContainer.class) {
			switch (baseFeatureID) {
			case EConfML1Package.ELINK_CONTAINER__LINKS:
				return EConfML1Package.EPROPERTY_ELEMENT__LINKS;
			default:
				return -1;
			}
		}
		if (baseClass == EXLinkReference.class) {
			switch (baseFeatureID) {
			case EConfML1Package.EX_LINK_REFERENCE__HREF:
				return EConfML1Package.EPROPERTY_ELEMENT__HREF;
			case EConfML1Package.EX_LINK_REFERENCE__TITLE:
				return EConfML1Package.EPROPERTY_ELEMENT__TITLE;
			default:
				return -1;
			}
		}
		if (baseClass == EIconElement.class) {
			switch (baseFeatureID) {
			default:
				return -1;
			}
		}
		if (baseClass == EDescriptionContainer.class) {
			switch (baseFeatureID) {
			case EConfML1Package.EDESCRIPTION_CONTAINER__DESCRIPTIONS:
				return EConfML1Package.EPROPERTY_ELEMENT__DESCRIPTIONS;
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
		result.append(", href: ");
		result.append(href);
		result.append(", title: ");
		result.append(title);
		result.append(", name: ");
		result.append(name);
		result.append(", value: ");
		result.append(value);
		result.append(", unit: ");
		result.append(unit);
		result.append(')');
		return result.toString();
	}

} //EPropertyElementImpl
