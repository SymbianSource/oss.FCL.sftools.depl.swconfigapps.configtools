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

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.nokia.tools.vct.confml.model.confml2.EConfML2Package;
import com.nokia.tools.vct.confml.model.confml2.EIconContainer;
import com.nokia.tools.vct.confml.model.confml2.EIconElement;
import com.nokia.tools.vct.confml.model.confml2.ELinkElement;
import com.nokia.tools.vct.confml.model.confml2.EMetaContent;
import com.nokia.tools.vct.confml.model.confml2.EMetaElement;
import com.nokia.tools.vct.confml.model.metaext.EConfigurationPropertyElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EMeta Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.EMetaElementImpl#getContents <em>Contents</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.EMetaElementImpl#getLinks <em>Links</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.EMetaElementImpl#getIcons <em>Icons</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.EMetaElementImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.EMetaElementImpl#getDate <em>Date</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.EMetaElementImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.EMetaElementImpl#getEditor <em>Editor</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.EMetaElementImpl#getProduct <em>Product</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.EMetaElementImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.EMetaElementImpl#getPlatform <em>Platform</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.EMetaElementImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.EMetaElementImpl#getRelease <em>Release</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.EMetaElementImpl#getCustomer <em>Customer</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.EMetaElementImpl#getOrigin <em>Origin</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.EMetaElementImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.EMetaElementImpl#getConfigurationProperty <em>Configuration Property</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml2.impl.EMetaElementImpl#getOtherElements <em>Other Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EMetaElementImpl extends EObjectImpl implements EMetaElement {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMetaElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EConfML2Package.Literals.EMETA_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getContents() {
		if (contents == null) {
			contents = new BasicFeatureMap(this,
					EConfML2Package.EMETA_ELEMENT__CONTENTS);
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
	public EList<EMetaContent> getId() {
		return getContents().list(EConfML2Package.Literals.EMETA_ELEMENT__ID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EMetaContent> getDate() {
		return getContents().list(EConfML2Package.Literals.EMETA_ELEMENT__DATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EMetaContent> getOwner() {
		return getContents()
				.list(EConfML2Package.Literals.EMETA_ELEMENT__OWNER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EMetaContent> getEditor() {
		return getContents().list(
				EConfML2Package.Literals.EMETA_ELEMENT__EDITOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EMetaContent> getProduct() {
		return getContents().list(
				EConfML2Package.Literals.EMETA_ELEMENT__PRODUCT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EMetaContent> getStatus() {
		return getContents().list(
				EConfML2Package.Literals.EMETA_ELEMENT__STATUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EMetaContent> getPlatform() {
		return getContents().list(
				EConfML2Package.Literals.EMETA_ELEMENT__PLATFORM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EMetaContent> getVersion() {
		return getContents().list(
				EConfML2Package.Literals.EMETA_ELEMENT__VERSION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EMetaContent> getRelease() {
		return getContents().list(
				EConfML2Package.Literals.EMETA_ELEMENT__RELEASE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EMetaContent> getCustomer() {
		return getContents().list(
				EConfML2Package.Literals.EMETA_ELEMENT__CUSTOMER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EMetaContent> getOrigin() {
		return getContents().list(
				EConfML2Package.Literals.EMETA_ELEMENT__ORIGIN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EMetaContent> getTarget() {
		return getContents().list(
				EConfML2Package.Literals.EMETA_ELEMENT__TARGET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EConfigurationPropertyElement> getConfigurationProperty() {
		return getContents().list(
				EConfML2Package.Literals.EMETA_ELEMENT__CONFIGURATION_PROPERTY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getOtherElements() {
		return (FeatureMap) getContents().<FeatureMap.Entry> list(
				EConfML2Package.Literals.EMETA_ELEMENT__OTHER_ELEMENTS);
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
		case EConfML2Package.EMETA_ELEMENT__CONTENTS:
			return ((InternalEList<?>) getContents()).basicRemove(otherEnd,
					msgs);
		case EConfML2Package.EMETA_ELEMENT__LINKS:
			return ((InternalEList<?>) getLinks()).basicRemove(otherEnd, msgs);
		case EConfML2Package.EMETA_ELEMENT__ICONS:
			return ((InternalEList<?>) getIcons()).basicRemove(otherEnd, msgs);
		case EConfML2Package.EMETA_ELEMENT__ID:
			return ((InternalEList<?>) getId()).basicRemove(otherEnd, msgs);
		case EConfML2Package.EMETA_ELEMENT__DATE:
			return ((InternalEList<?>) getDate()).basicRemove(otherEnd, msgs);
		case EConfML2Package.EMETA_ELEMENT__OWNER:
			return ((InternalEList<?>) getOwner()).basicRemove(otherEnd, msgs);
		case EConfML2Package.EMETA_ELEMENT__EDITOR:
			return ((InternalEList<?>) getEditor()).basicRemove(otherEnd, msgs);
		case EConfML2Package.EMETA_ELEMENT__PRODUCT:
			return ((InternalEList<?>) getProduct())
					.basicRemove(otherEnd, msgs);
		case EConfML2Package.EMETA_ELEMENT__STATUS:
			return ((InternalEList<?>) getStatus()).basicRemove(otherEnd, msgs);
		case EConfML2Package.EMETA_ELEMENT__PLATFORM:
			return ((InternalEList<?>) getPlatform()).basicRemove(otherEnd,
					msgs);
		case EConfML2Package.EMETA_ELEMENT__VERSION:
			return ((InternalEList<?>) getVersion())
					.basicRemove(otherEnd, msgs);
		case EConfML2Package.EMETA_ELEMENT__RELEASE:
			return ((InternalEList<?>) getRelease())
					.basicRemove(otherEnd, msgs);
		case EConfML2Package.EMETA_ELEMENT__CUSTOMER:
			return ((InternalEList<?>) getCustomer()).basicRemove(otherEnd,
					msgs);
		case EConfML2Package.EMETA_ELEMENT__ORIGIN:
			return ((InternalEList<?>) getOrigin()).basicRemove(otherEnd, msgs);
		case EConfML2Package.EMETA_ELEMENT__TARGET:
			return ((InternalEList<?>) getTarget()).basicRemove(otherEnd, msgs);
		case EConfML2Package.EMETA_ELEMENT__CONFIGURATION_PROPERTY:
			return ((InternalEList<?>) getConfigurationProperty()).basicRemove(
					otherEnd, msgs);
		case EConfML2Package.EMETA_ELEMENT__OTHER_ELEMENTS:
			return ((InternalEList<?>) getOtherElements()).basicRemove(
					otherEnd, msgs);
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
		case EConfML2Package.EMETA_ELEMENT__CONTENTS:
			if (coreType)
				return getContents();
			return ((FeatureMap.Internal) getContents()).getWrapper();
		case EConfML2Package.EMETA_ELEMENT__LINKS:
			return getLinks();
		case EConfML2Package.EMETA_ELEMENT__ICONS:
			return getIcons();
		case EConfML2Package.EMETA_ELEMENT__ID:
			return getId();
		case EConfML2Package.EMETA_ELEMENT__DATE:
			return getDate();
		case EConfML2Package.EMETA_ELEMENT__OWNER:
			return getOwner();
		case EConfML2Package.EMETA_ELEMENT__EDITOR:
			return getEditor();
		case EConfML2Package.EMETA_ELEMENT__PRODUCT:
			return getProduct();
		case EConfML2Package.EMETA_ELEMENT__STATUS:
			return getStatus();
		case EConfML2Package.EMETA_ELEMENT__PLATFORM:
			return getPlatform();
		case EConfML2Package.EMETA_ELEMENT__VERSION:
			return getVersion();
		case EConfML2Package.EMETA_ELEMENT__RELEASE:
			return getRelease();
		case EConfML2Package.EMETA_ELEMENT__CUSTOMER:
			return getCustomer();
		case EConfML2Package.EMETA_ELEMENT__ORIGIN:
			return getOrigin();
		case EConfML2Package.EMETA_ELEMENT__TARGET:
			return getTarget();
		case EConfML2Package.EMETA_ELEMENT__CONFIGURATION_PROPERTY:
			return getConfigurationProperty();
		case EConfML2Package.EMETA_ELEMENT__OTHER_ELEMENTS:
			if (coreType)
				return getOtherElements();
			return ((FeatureMap.Internal) getOtherElements()).getWrapper();
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
		case EConfML2Package.EMETA_ELEMENT__CONTENTS:
			((FeatureMap.Internal) getContents()).set(newValue);
			return;
		case EConfML2Package.EMETA_ELEMENT__LINKS:
			getLinks().clear();
			getLinks().addAll((Collection<? extends ELinkElement>) newValue);
			return;
		case EConfML2Package.EMETA_ELEMENT__ICONS:
			getIcons().clear();
			getIcons().addAll((Collection<? extends EIconElement>) newValue);
			return;
		case EConfML2Package.EMETA_ELEMENT__ID:
			getId().clear();
			getId().addAll((Collection<? extends EMetaContent>) newValue);
			return;
		case EConfML2Package.EMETA_ELEMENT__DATE:
			getDate().clear();
			getDate().addAll((Collection<? extends EMetaContent>) newValue);
			return;
		case EConfML2Package.EMETA_ELEMENT__OWNER:
			getOwner().clear();
			getOwner().addAll((Collection<? extends EMetaContent>) newValue);
			return;
		case EConfML2Package.EMETA_ELEMENT__EDITOR:
			getEditor().clear();
			getEditor().addAll((Collection<? extends EMetaContent>) newValue);
			return;
		case EConfML2Package.EMETA_ELEMENT__PRODUCT:
			getProduct().clear();
			getProduct().addAll((Collection<? extends EMetaContent>) newValue);
			return;
		case EConfML2Package.EMETA_ELEMENT__STATUS:
			getStatus().clear();
			getStatus().addAll((Collection<? extends EMetaContent>) newValue);
			return;
		case EConfML2Package.EMETA_ELEMENT__PLATFORM:
			getPlatform().clear();
			getPlatform().addAll((Collection<? extends EMetaContent>) newValue);
			return;
		case EConfML2Package.EMETA_ELEMENT__VERSION:
			getVersion().clear();
			getVersion().addAll((Collection<? extends EMetaContent>) newValue);
			return;
		case EConfML2Package.EMETA_ELEMENT__RELEASE:
			getRelease().clear();
			getRelease().addAll((Collection<? extends EMetaContent>) newValue);
			return;
		case EConfML2Package.EMETA_ELEMENT__CUSTOMER:
			getCustomer().clear();
			getCustomer().addAll((Collection<? extends EMetaContent>) newValue);
			return;
		case EConfML2Package.EMETA_ELEMENT__ORIGIN:
			getOrigin().clear();
			getOrigin().addAll((Collection<? extends EMetaContent>) newValue);
			return;
		case EConfML2Package.EMETA_ELEMENT__TARGET:
			getTarget().clear();
			getTarget().addAll((Collection<? extends EMetaContent>) newValue);
			return;
		case EConfML2Package.EMETA_ELEMENT__CONFIGURATION_PROPERTY:
			getConfigurationProperty().clear();
			getConfigurationProperty()
					.addAll(
							(Collection<? extends EConfigurationPropertyElement>) newValue);
			return;
		case EConfML2Package.EMETA_ELEMENT__OTHER_ELEMENTS:
			((FeatureMap.Internal) getOtherElements()).set(newValue);
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
		case EConfML2Package.EMETA_ELEMENT__CONTENTS:
			getContents().clear();
			return;
		case EConfML2Package.EMETA_ELEMENT__LINKS:
			getLinks().clear();
			return;
		case EConfML2Package.EMETA_ELEMENT__ICONS:
			getIcons().clear();
			return;
		case EConfML2Package.EMETA_ELEMENT__ID:
			getId().clear();
			return;
		case EConfML2Package.EMETA_ELEMENT__DATE:
			getDate().clear();
			return;
		case EConfML2Package.EMETA_ELEMENT__OWNER:
			getOwner().clear();
			return;
		case EConfML2Package.EMETA_ELEMENT__EDITOR:
			getEditor().clear();
			return;
		case EConfML2Package.EMETA_ELEMENT__PRODUCT:
			getProduct().clear();
			return;
		case EConfML2Package.EMETA_ELEMENT__STATUS:
			getStatus().clear();
			return;
		case EConfML2Package.EMETA_ELEMENT__PLATFORM:
			getPlatform().clear();
			return;
		case EConfML2Package.EMETA_ELEMENT__VERSION:
			getVersion().clear();
			return;
		case EConfML2Package.EMETA_ELEMENT__RELEASE:
			getRelease().clear();
			return;
		case EConfML2Package.EMETA_ELEMENT__CUSTOMER:
			getCustomer().clear();
			return;
		case EConfML2Package.EMETA_ELEMENT__ORIGIN:
			getOrigin().clear();
			return;
		case EConfML2Package.EMETA_ELEMENT__TARGET:
			getTarget().clear();
			return;
		case EConfML2Package.EMETA_ELEMENT__CONFIGURATION_PROPERTY:
			getConfigurationProperty().clear();
			return;
		case EConfML2Package.EMETA_ELEMENT__OTHER_ELEMENTS:
			getOtherElements().clear();
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
		case EConfML2Package.EMETA_ELEMENT__CONTENTS:
			return contents != null && !contents.isEmpty();
		case EConfML2Package.EMETA_ELEMENT__LINKS:
			return !getLinks().isEmpty();
		case EConfML2Package.EMETA_ELEMENT__ICONS:
			return !getIcons().isEmpty();
		case EConfML2Package.EMETA_ELEMENT__ID:
			return !getId().isEmpty();
		case EConfML2Package.EMETA_ELEMENT__DATE:
			return !getDate().isEmpty();
		case EConfML2Package.EMETA_ELEMENT__OWNER:
			return !getOwner().isEmpty();
		case EConfML2Package.EMETA_ELEMENT__EDITOR:
			return !getEditor().isEmpty();
		case EConfML2Package.EMETA_ELEMENT__PRODUCT:
			return !getProduct().isEmpty();
		case EConfML2Package.EMETA_ELEMENT__STATUS:
			return !getStatus().isEmpty();
		case EConfML2Package.EMETA_ELEMENT__PLATFORM:
			return !getPlatform().isEmpty();
		case EConfML2Package.EMETA_ELEMENT__VERSION:
			return !getVersion().isEmpty();
		case EConfML2Package.EMETA_ELEMENT__RELEASE:
			return !getRelease().isEmpty();
		case EConfML2Package.EMETA_ELEMENT__CUSTOMER:
			return !getCustomer().isEmpty();
		case EConfML2Package.EMETA_ELEMENT__ORIGIN:
			return !getOrigin().isEmpty();
		case EConfML2Package.EMETA_ELEMENT__TARGET:
			return !getTarget().isEmpty();
		case EConfML2Package.EMETA_ELEMENT__CONFIGURATION_PROPERTY:
			return !getConfigurationProperty().isEmpty();
		case EConfML2Package.EMETA_ELEMENT__OTHER_ELEMENTS:
			return !getOtherElements().isEmpty();
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
		if (baseClass == EIconContainer.class) {
			switch (derivedFeatureID) {
			case EConfML2Package.EMETA_ELEMENT__ICONS:
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
		if (baseClass == EIconContainer.class) {
			switch (baseFeatureID) {
			case EConfML2Package.EICON_CONTAINER__ICONS:
				return EConfML2Package.EMETA_ELEMENT__ICONS;
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
		result.append(')');
		return result.toString();
	}

} //EMetaElementImpl
