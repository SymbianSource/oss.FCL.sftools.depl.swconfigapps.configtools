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

import com.nokia.tools.vct.confml.editor.view.vemodel.EGroupContainer;
import com.nokia.tools.vct.confml.editor.view.vemodel.EGroupEntry;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.nokia.tools.vct.confml.editor.view.vemodel.EDescriptionContainer;
import com.nokia.tools.vct.confml.editor.view.vemodel.EGroup;
import com.nokia.tools.vct.confml.editor.view.vemodel.EIconContainer;
import com.nokia.tools.vct.confml.editor.view.vemodel.EView;
import com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EView</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewImpl#getDescriptionText <em>Description Text</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewImpl#getDescriptionUri <em>Description Uri</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewImpl#getDescriptionUriTitle <em>Description Uri Title</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewImpl#getIconUri <em>Icon Uri</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewImpl#getIconUriTitle <em>Icon Uri Title</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewImpl#getGroupsAndViews <em>Groups And Views</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewImpl#getInclusionURI <em>Inclusion URI</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewImpl#getFileURI <em>File URI</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EViewImpl extends EObjectImpl implements EView {
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
	 * The default value of the '{@link #getIconUri() <em>Icon Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconUri()
	 * @generated
	 * @ordered
	 */
	protected static final String ICON_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIconUri() <em>Icon Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconUri()
	 * @generated
	 * @ordered
	 */
	protected String iconUri = ICON_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getIconUriTitle() <em>Icon Uri Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconUriTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String ICON_URI_TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIconUriTitle() <em>Icon Uri Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconUriTitle()
	 * @generated
	 * @ordered
	 */
	protected String iconUriTitle = ICON_URI_TITLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getGroupsAndViews() <em>Groups And Views</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroupsAndViews()
	 * @generated
	 * @ordered
	 */
	protected EList<EGroupEntry> groupsAndViews;

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
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getInclusionURI() <em>Inclusion URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInclusionURI()
	 * @generated
	 * @ordered
	 */
	protected static final String INCLUSION_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInclusionURI() <em>Inclusion URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInclusionURI()
	 * @generated
	 * @ordered
	 */
	protected String inclusionURI = INCLUSION_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getFileURI() <em>File URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileURI()
	 * @generated
	 * @ordered
	 */
	protected static final String FILE_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFileURI() <em>File URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileURI()
	 * @generated
	 * @ordered
	 */
	protected String fileURI = FILE_URI_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EViewImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EViewEditorPackage.Literals.EVIEW;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EViewEditorPackage.EVIEW__DESCRIPTION_TEXT, oldDescriptionText, descriptionText));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EViewEditorPackage.EVIEW__DESCRIPTION_URI, oldDescriptionUri, descriptionUri));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EViewEditorPackage.EVIEW__DESCRIPTION_URI_TITLE, oldDescriptionUriTitle, descriptionUriTitle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIconUri() {
		return iconUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIconUri(String newIconUri) {
		String oldIconUri = iconUri;
		iconUri = newIconUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EViewEditorPackage.EVIEW__ICON_URI, oldIconUri, iconUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIconUriTitle() {
		return iconUriTitle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIconUriTitle(String newIconUriTitle) {
		String oldIconUriTitle = iconUriTitle;
		iconUriTitle = newIconUriTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EViewEditorPackage.EVIEW__ICON_URI_TITLE, oldIconUriTitle, iconUriTitle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EGroupEntry> getGroupsAndViews() {
		if (groupsAndViews == null) {
			groupsAndViews = new EObjectContainmentEList<EGroupEntry>(EGroupEntry.class, this, EViewEditorPackage.EVIEW__GROUPS_AND_VIEWS);
		}
		return groupsAndViews;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EViewEditorPackage.EVIEW__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EViewEditorPackage.EVIEW__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInclusionURI() {
		return inclusionURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInclusionURI(String newInclusionURI) {
		String oldInclusionURI = inclusionURI;
		inclusionURI = newInclusionURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EViewEditorPackage.EVIEW__INCLUSION_URI, oldInclusionURI, inclusionURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFileURI() {
		return fileURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFileURI(String newFileURI) {
		String oldFileURI = fileURI;
		fileURI = newFileURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EViewEditorPackage.EVIEW__FILE_URI, oldFileURI, fileURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @NOT generated
	 */
	public EList<EGroup> getGroups() {
		EList groups = new BasicEList();
		for (EGroupEntry ge :  getGroupsAndViews())
		{
			if (ge instanceof EGroup)
			{
				groups.add(ge);
			}
		}
		return groups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @NOT generated
	 */
	public EList<EView> getIncludeViews() {
		EList views = new BasicEList();
		for (EGroupEntry ge :  getGroupsAndViews())
		{
			if (ge instanceof EView)
			{
				views.add(ge);
			}
		}
		return views;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EViewEditorPackage.EVIEW__GROUPS_AND_VIEWS:
				return ((InternalEList<?>)getGroupsAndViews()).basicRemove(otherEnd, msgs);
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
			case EViewEditorPackage.EVIEW__DESCRIPTION_TEXT:
				return getDescriptionText();
			case EViewEditorPackage.EVIEW__DESCRIPTION_URI:
				return getDescriptionUri();
			case EViewEditorPackage.EVIEW__DESCRIPTION_URI_TITLE:
				return getDescriptionUriTitle();
			case EViewEditorPackage.EVIEW__ICON_URI:
				return getIconUri();
			case EViewEditorPackage.EVIEW__ICON_URI_TITLE:
				return getIconUriTitle();
			case EViewEditorPackage.EVIEW__GROUPS_AND_VIEWS:
				return getGroupsAndViews();
			case EViewEditorPackage.EVIEW__NAME:
				return getName();
			case EViewEditorPackage.EVIEW__ID:
				return getId();
			case EViewEditorPackage.EVIEW__INCLUSION_URI:
				return getInclusionURI();
			case EViewEditorPackage.EVIEW__FILE_URI:
				return getFileURI();
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
			case EViewEditorPackage.EVIEW__DESCRIPTION_TEXT:
				setDescriptionText((String)newValue);
				return;
			case EViewEditorPackage.EVIEW__DESCRIPTION_URI:
				setDescriptionUri((String)newValue);
				return;
			case EViewEditorPackage.EVIEW__DESCRIPTION_URI_TITLE:
				setDescriptionUriTitle((String)newValue);
				return;
			case EViewEditorPackage.EVIEW__ICON_URI:
				setIconUri((String)newValue);
				return;
			case EViewEditorPackage.EVIEW__ICON_URI_TITLE:
				setIconUriTitle((String)newValue);
				return;
			case EViewEditorPackage.EVIEW__GROUPS_AND_VIEWS:
				getGroupsAndViews().clear();
				getGroupsAndViews().addAll((Collection<? extends EGroupEntry>)newValue);
				return;
			case EViewEditorPackage.EVIEW__NAME:
				setName((String)newValue);
				return;
			case EViewEditorPackage.EVIEW__ID:
				setId((String)newValue);
				return;
			case EViewEditorPackage.EVIEW__INCLUSION_URI:
				setInclusionURI((String)newValue);
				return;
			case EViewEditorPackage.EVIEW__FILE_URI:
				setFileURI((String)newValue);
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
			case EViewEditorPackage.EVIEW__DESCRIPTION_TEXT:
				setDescriptionText(DESCRIPTION_TEXT_EDEFAULT);
				return;
			case EViewEditorPackage.EVIEW__DESCRIPTION_URI:
				setDescriptionUri(DESCRIPTION_URI_EDEFAULT);
				return;
			case EViewEditorPackage.EVIEW__DESCRIPTION_URI_TITLE:
				setDescriptionUriTitle(DESCRIPTION_URI_TITLE_EDEFAULT);
				return;
			case EViewEditorPackage.EVIEW__ICON_URI:
				setIconUri(ICON_URI_EDEFAULT);
				return;
			case EViewEditorPackage.EVIEW__ICON_URI_TITLE:
				setIconUriTitle(ICON_URI_TITLE_EDEFAULT);
				return;
			case EViewEditorPackage.EVIEW__GROUPS_AND_VIEWS:
				getGroupsAndViews().clear();
				return;
			case EViewEditorPackage.EVIEW__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EViewEditorPackage.EVIEW__ID:
				setId(ID_EDEFAULT);
				return;
			case EViewEditorPackage.EVIEW__INCLUSION_URI:
				setInclusionURI(INCLUSION_URI_EDEFAULT);
				return;
			case EViewEditorPackage.EVIEW__FILE_URI:
				setFileURI(FILE_URI_EDEFAULT);
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
			case EViewEditorPackage.EVIEW__DESCRIPTION_TEXT:
				return DESCRIPTION_TEXT_EDEFAULT == null ? descriptionText != null : !DESCRIPTION_TEXT_EDEFAULT.equals(descriptionText);
			case EViewEditorPackage.EVIEW__DESCRIPTION_URI:
				return DESCRIPTION_URI_EDEFAULT == null ? descriptionUri != null : !DESCRIPTION_URI_EDEFAULT.equals(descriptionUri);
			case EViewEditorPackage.EVIEW__DESCRIPTION_URI_TITLE:
				return DESCRIPTION_URI_TITLE_EDEFAULT == null ? descriptionUriTitle != null : !DESCRIPTION_URI_TITLE_EDEFAULT.equals(descriptionUriTitle);
			case EViewEditorPackage.EVIEW__ICON_URI:
				return ICON_URI_EDEFAULT == null ? iconUri != null : !ICON_URI_EDEFAULT.equals(iconUri);
			case EViewEditorPackage.EVIEW__ICON_URI_TITLE:
				return ICON_URI_TITLE_EDEFAULT == null ? iconUriTitle != null : !ICON_URI_TITLE_EDEFAULT.equals(iconUriTitle);
			case EViewEditorPackage.EVIEW__GROUPS_AND_VIEWS:
				return groupsAndViews != null && !groupsAndViews.isEmpty();
			case EViewEditorPackage.EVIEW__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EViewEditorPackage.EVIEW__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case EViewEditorPackage.EVIEW__INCLUSION_URI:
				return INCLUSION_URI_EDEFAULT == null ? inclusionURI != null : !INCLUSION_URI_EDEFAULT.equals(inclusionURI);
			case EViewEditorPackage.EVIEW__FILE_URI:
				return FILE_URI_EDEFAULT == null ? fileURI != null : !FILE_URI_EDEFAULT.equals(fileURI);
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
				case EViewEditorPackage.EVIEW__ICON_URI: return EViewEditorPackage.EICON_CONTAINER__ICON_URI;
				case EViewEditorPackage.EVIEW__ICON_URI_TITLE: return EViewEditorPackage.EICON_CONTAINER__ICON_URI_TITLE;
				default: return -1;
			}
		}
		if (baseClass == EGroupContainer.class) {
			switch (derivedFeatureID) {
				case EViewEditorPackage.EVIEW__GROUPS_AND_VIEWS: return EViewEditorPackage.EGROUP_CONTAINER__GROUPS_AND_VIEWS;
				default: return -1;
			}
		}
		if (baseClass == EGroupEntry.class) {
			switch (derivedFeatureID) {
				case EViewEditorPackage.EVIEW__NAME: return EViewEditorPackage.EGROUP_ENTRY__NAME;
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
		if (baseClass == EIconContainer.class) {
			switch (baseFeatureID) {
				case EViewEditorPackage.EICON_CONTAINER__ICON_URI: return EViewEditorPackage.EVIEW__ICON_URI;
				case EViewEditorPackage.EICON_CONTAINER__ICON_URI_TITLE: return EViewEditorPackage.EVIEW__ICON_URI_TITLE;
				default: return -1;
			}
		}
		if (baseClass == EGroupContainer.class) {
			switch (baseFeatureID) {
				case EViewEditorPackage.EGROUP_CONTAINER__GROUPS_AND_VIEWS: return EViewEditorPackage.EVIEW__GROUPS_AND_VIEWS;
				default: return -1;
			}
		}
		if (baseClass == EGroupEntry.class) {
			switch (baseFeatureID) {
				case EViewEditorPackage.EGROUP_ENTRY__NAME: return EViewEditorPackage.EVIEW__NAME;
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
		result.append(", iconUri: ");
		result.append(iconUri);
		result.append(", iconUriTitle: ");
		result.append(iconUriTitle);
		result.append(", name: ");
		result.append(name);
		result.append(", id: ");
		result.append(id);
		result.append(", inclusionURI: ");
		result.append(inclusionURI);
		result.append(", fileURI: ");
		result.append(fileURI);
		result.append(')');
		return result.toString();
	}

} //EViewImpl
