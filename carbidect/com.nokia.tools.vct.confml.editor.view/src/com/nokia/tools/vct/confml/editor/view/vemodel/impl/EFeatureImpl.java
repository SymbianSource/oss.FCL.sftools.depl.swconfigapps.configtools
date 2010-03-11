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
 * Description: This file is part of com.nokia.tools.vct.confml.editor.view component.
 */

package com.nokia.tools.vct.confml.editor.view.vemodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.nokia.tools.vct.confml.editor.view.vemodel.EFeature;
import com.nokia.tools.vct.confml.editor.view.vemodel.ERefTarget;
import com.nokia.tools.vct.confml.editor.view.vemodel.EResourceLocator;
import com.nokia.tools.vct.confml.editor.view.vemodel.ESetting;
import com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef;
import com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EFeature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.EFeatureImpl#getDescriptionText <em>Description Text</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.EFeatureImpl#getDescriptionUri <em>Description Uri</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.EFeatureImpl#getDescriptionUriTitle <em>Description Uri Title</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.EFeatureImpl#getResourceUri <em>Resource Uri</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.EFeatureImpl#getRefs <em>Refs</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.EFeatureImpl#getSettings <em>Settings</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.EFeatureImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EFeatureImpl extends EObjectImpl implements EFeature {
	/**
	 * The default value of the '{@link #getDescriptionText() <em>Description Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptionText()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescriptionText() <em>Description Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptionText()
	 * @generated
	 * @ordered
	 */
	protected String descriptionText = DESCRIPTION_TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescriptionUri() <em>Description Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptionUri()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescriptionUri() <em>Description Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptionUri()
	 * @generated
	 * @ordered
	 */
	protected String descriptionUri = DESCRIPTION_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescriptionUriTitle() <em>Description Uri Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptionUriTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_URI_TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescriptionUriTitle() <em>Description Uri Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptionUriTitle()
	 * @generated
	 * @ordered
	 */
	protected String descriptionUriTitle = DESCRIPTION_URI_TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getResourceUri() <em>Resource Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceUri()
	 * @generated
	 * @ordered
	 */
	protected static final String RESOURCE_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResourceUri() <em>Resource Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceUri()
	 * @generated
	 * @ordered
	 */
	protected String resourceUri = RESOURCE_URI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRefs() <em>Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<ESettingRef> refs;

	/**
	 * The cached value of the '{@link #getSettings() <em>Settings</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSettings()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, ESetting> settings;

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
	protected EFeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EViewEditorPackage.Literals.EFEATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescriptionText() {
		return descriptionText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescriptionText(String newDescriptionText) {
		String oldDescriptionText = descriptionText;
		descriptionText = newDescriptionText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EViewEditorPackage.EFEATURE__DESCRIPTION_TEXT, oldDescriptionText, descriptionText));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescriptionUri() {
		return descriptionUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescriptionUri(String newDescriptionUri) {
		String oldDescriptionUri = descriptionUri;
		descriptionUri = newDescriptionUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EViewEditorPackage.EFEATURE__DESCRIPTION_URI, oldDescriptionUri, descriptionUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescriptionUriTitle() {
		return descriptionUriTitle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescriptionUriTitle(String newDescriptionUriTitle) {
		String oldDescriptionUriTitle = descriptionUriTitle;
		descriptionUriTitle = newDescriptionUriTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EViewEditorPackage.EFEATURE__DESCRIPTION_URI_TITLE, oldDescriptionUriTitle, descriptionUriTitle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResourceUri() {
		return resourceUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceUri(String newResourceUri) {
		String oldResourceUri = resourceUri;
		resourceUri = newResourceUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EViewEditorPackage.EFEATURE__RESOURCE_URI, oldResourceUri, resourceUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ESettingRef> getRefs() {
		if (refs == null) {
			refs = new EObjectWithInverseResolvingEList<ESettingRef>(ESettingRef.class, this, EViewEditorPackage.EFEATURE__REFS, EViewEditorPackage.ESETTING_REF__TARGET);
		}
		return refs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, ESetting> getSettings() {
		if (settings == null) {
			settings = new EcoreEMap<String,ESetting>(EViewEditorPackage.Literals.ESETTING_ENTRY, ESettingEntryImpl.class, this, EViewEditorPackage.EFEATURE__SETTINGS);
		}
		return settings;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EViewEditorPackage.EFEATURE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EViewEditorPackage.EFEATURE__REFS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRefs()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EViewEditorPackage.EFEATURE__REFS:
				return ((InternalEList<?>)getRefs()).basicRemove(otherEnd, msgs);
			case EViewEditorPackage.EFEATURE__SETTINGS:
				return ((InternalEList<?>)getSettings()).basicRemove(otherEnd, msgs);
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
			case EViewEditorPackage.EFEATURE__DESCRIPTION_TEXT:
				return getDescriptionText();
			case EViewEditorPackage.EFEATURE__DESCRIPTION_URI:
				return getDescriptionUri();
			case EViewEditorPackage.EFEATURE__DESCRIPTION_URI_TITLE:
				return getDescriptionUriTitle();
			case EViewEditorPackage.EFEATURE__RESOURCE_URI:
				return getResourceUri();
			case EViewEditorPackage.EFEATURE__REFS:
				return getRefs();
			case EViewEditorPackage.EFEATURE__SETTINGS:
				if (coreType) return getSettings();
				else return getSettings().map();
			case EViewEditorPackage.EFEATURE__NAME:
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
			case EViewEditorPackage.EFEATURE__DESCRIPTION_TEXT:
				setDescriptionText((String)newValue);
				return;
			case EViewEditorPackage.EFEATURE__DESCRIPTION_URI:
				setDescriptionUri((String)newValue);
				return;
			case EViewEditorPackage.EFEATURE__DESCRIPTION_URI_TITLE:
				setDescriptionUriTitle((String)newValue);
				return;
			case EViewEditorPackage.EFEATURE__RESOURCE_URI:
				setResourceUri((String)newValue);
				return;
			case EViewEditorPackage.EFEATURE__REFS:
				getRefs().clear();
				getRefs().addAll((Collection<? extends ESettingRef>)newValue);
				return;
			case EViewEditorPackage.EFEATURE__SETTINGS:
				((EStructuralFeature.Setting)getSettings()).set(newValue);
				return;
			case EViewEditorPackage.EFEATURE__NAME:
				setName((String)newValue);
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
			case EViewEditorPackage.EFEATURE__DESCRIPTION_TEXT:
				setDescriptionText(DESCRIPTION_TEXT_EDEFAULT);
				return;
			case EViewEditorPackage.EFEATURE__DESCRIPTION_URI:
				setDescriptionUri(DESCRIPTION_URI_EDEFAULT);
				return;
			case EViewEditorPackage.EFEATURE__DESCRIPTION_URI_TITLE:
				setDescriptionUriTitle(DESCRIPTION_URI_TITLE_EDEFAULT);
				return;
			case EViewEditorPackage.EFEATURE__RESOURCE_URI:
				setResourceUri(RESOURCE_URI_EDEFAULT);
				return;
			case EViewEditorPackage.EFEATURE__REFS:
				getRefs().clear();
				return;
			case EViewEditorPackage.EFEATURE__SETTINGS:
				getSettings().clear();
				return;
			case EViewEditorPackage.EFEATURE__NAME:
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
			case EViewEditorPackage.EFEATURE__DESCRIPTION_TEXT:
				return DESCRIPTION_TEXT_EDEFAULT == null ? descriptionText != null : !DESCRIPTION_TEXT_EDEFAULT.equals(descriptionText);
			case EViewEditorPackage.EFEATURE__DESCRIPTION_URI:
				return DESCRIPTION_URI_EDEFAULT == null ? descriptionUri != null : !DESCRIPTION_URI_EDEFAULT.equals(descriptionUri);
			case EViewEditorPackage.EFEATURE__DESCRIPTION_URI_TITLE:
				return DESCRIPTION_URI_TITLE_EDEFAULT == null ? descriptionUriTitle != null : !DESCRIPTION_URI_TITLE_EDEFAULT.equals(descriptionUriTitle);
			case EViewEditorPackage.EFEATURE__RESOURCE_URI:
				return RESOURCE_URI_EDEFAULT == null ? resourceUri != null : !RESOURCE_URI_EDEFAULT.equals(resourceUri);
			case EViewEditorPackage.EFEATURE__REFS:
				return refs != null && !refs.isEmpty();
			case EViewEditorPackage.EFEATURE__SETTINGS:
				return settings != null && !settings.isEmpty();
			case EViewEditorPackage.EFEATURE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		if (baseClass == EResourceLocator.class) {
			switch (derivedFeatureID) {
				case EViewEditorPackage.EFEATURE__RESOURCE_URI: return EViewEditorPackage.ERESOURCE_LOCATOR__RESOURCE_URI;
				default: return -1;
			}
		}
		if (baseClass == ERefTarget.class) {
			switch (derivedFeatureID) {
				case EViewEditorPackage.EFEATURE__REFS: return EViewEditorPackage.EREF_TARGET__REFS;
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
		if (baseClass == EResourceLocator.class) {
			switch (baseFeatureID) {
				case EViewEditorPackage.ERESOURCE_LOCATOR__RESOURCE_URI: return EViewEditorPackage.EFEATURE__RESOURCE_URI;
				default: return -1;
			}
		}
		if (baseClass == ERefTarget.class) {
			switch (baseFeatureID) {
				case EViewEditorPackage.EREF_TARGET__REFS: return EViewEditorPackage.EFEATURE__REFS;
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
		result.append(" (descriptionText: ");
		result.append(descriptionText);
		result.append(", descriptionUri: ");
		result.append(descriptionUri);
		result.append(", descriptionUriTitle: ");
		result.append(descriptionUriTitle);
		result.append(", resourceUri: ");
		result.append(resourceUri);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //EFeatureImpl
