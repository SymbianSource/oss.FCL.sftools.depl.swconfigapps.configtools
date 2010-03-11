/*
* Copyright (c) 2007 Nokia Corporation and/or its subsidiary(-ies). 
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
*/
package com.nokia.tools.s60ct.model.confml.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.nokia.tools.s60ct.model.confml.ConfmlPackage;
import com.nokia.tools.s60ct.model.confml.EFeature;
import com.nokia.tools.s60ct.model.confml.EIconContainer;
import com.nokia.tools.s60ct.model.confml.ELinkContainer;
import com.nokia.tools.s60ct.model.confml.ESetting;
import com.nokia.tools.s60ct.model.confml.View;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EFeature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.EFeatureImpl#getDescriptionText <em>Description Text</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.EFeatureImpl#getDescriptionUri <em>Description Uri</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.EFeatureImpl#getDescriptionUriText <em>Description Uri Text</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.EFeatureImpl#getIconUriTitle <em>Icon Uri Title</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.EFeatureImpl#getIconUri <em>Icon Uri</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.EFeatureImpl#getLinkUri <em>Link Uri</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.EFeatureImpl#getLinkUriTitle <em>Link Uri Title</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.EFeatureImpl#getSettings <em>Settings</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.EFeatureImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.EFeatureImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.EFeatureImpl#getRelevant <em>Relevant</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.EFeatureImpl#getRelevantAST <em>Relevant AST</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.EFeatureImpl#isComputedRelevant <em>Computed Relevant</em>}</li>
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
	 * The default value of the '{@link #getDescriptionUriText() <em>Description Uri Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptionUriText()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_URI_TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescriptionUriText() <em>Description Uri Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptionUriText()
	 * @generated
	 * @ordered
	 */
	protected String descriptionUriText = DESCRIPTION_URI_TEXT_EDEFAULT;

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
	 * The default value of the '{@link #getLinkUri() <em>Link Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkUri()
	 * @generated
	 * @ordered
	 */
	protected static final String LINK_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLinkUri() <em>Link Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkUri()
	 * @generated
	 * @ordered
	 */
	protected String linkUri = LINK_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getLinkUriTitle() <em>Link Uri Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkUriTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String LINK_URI_TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLinkUriTitle() <em>Link Uri Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkUriTitle()
	 * @generated
	 * @ordered
	 */
	protected String linkUriTitle = LINK_URI_TITLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSettings() <em>Settings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSettings()
	 * @generated
	 * @ordered
	 */
	protected EList<ESetting> settings;

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
	 * The default value of the '{@link #getRelevantAST() <em>Relevant AST</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelevantAST()
	 * @generated
	 * @ordered
	 */
	protected static final Object RELEVANT_AST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRelevantAST() <em>Relevant AST</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelevantAST()
	 * @generated
	 * @ordered
	 */
	protected Object relevantAST = RELEVANT_AST_EDEFAULT;

	/**
	 * The default value of the '{@link #isComputedRelevant() <em>Computed Relevant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isComputedRelevant()
	 * @generated
	 * @ordered
	 */
	protected static final boolean COMPUTED_RELEVANT_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isComputedRelevant() <em>Computed Relevant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isComputedRelevant()
	 * @generated
	 * @ordered
	 */
	protected boolean computedRelevant = COMPUTED_RELEVANT_EDEFAULT;

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
		return ConfmlPackage.Literals.EFEATURE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.EFEATURE__DESCRIPTION_TEXT, oldDescriptionText, descriptionText));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.EFEATURE__DESCRIPTION_URI, oldDescriptionUri, descriptionUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescriptionUriText() {
		return descriptionUriText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescriptionUriText(String newDescriptionUriText) {
		String oldDescriptionUriText = descriptionUriText;
		descriptionUriText = newDescriptionUriText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.EFEATURE__DESCRIPTION_URI_TEXT, oldDescriptionUriText, descriptionUriText));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.EFEATURE__ICON_URI_TITLE, oldIconUriTitle, iconUriTitle));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.EFEATURE__ICON_URI, oldIconUri, iconUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinkUri() {
		return linkUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkUri(String newLinkUri) {
		String oldLinkUri = linkUri;
		linkUri = newLinkUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.EFEATURE__LINK_URI, oldLinkUri, linkUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinkUriTitle() {
		return linkUriTitle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkUriTitle(String newLinkUriTitle) {
		String oldLinkUriTitle = linkUriTitle;
		linkUriTitle = newLinkUriTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.EFEATURE__LINK_URI_TITLE, oldLinkUriTitle, linkUriTitle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ESetting> getSettings() {
		if (settings == null) {
			settings = new EObjectContainmentEList<ESetting>(ESetting.class, this, ConfmlPackage.EFEATURE__SETTINGS);
		}
		return settings;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.EFEATURE__REF, oldRef, ref));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.EFEATURE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.EFEATURE__RELEVANT, oldRelevant, relevant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getRelevantAST() {
		return relevantAST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelevantAST(Object newRelevantAST) {
		Object oldRelevantAST = relevantAST;
		relevantAST = newRelevantAST;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.EFEATURE__RELEVANT_AST, oldRelevantAST, relevantAST));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isComputedRelevant() {
		return computedRelevant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComputedRelevant(boolean newComputedRelevant) {
		boolean oldComputedRelevant = computedRelevant;
		computedRelevant = newComputedRelevant;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.EFEATURE__COMPUTED_RELEVANT, oldComputedRelevant, computedRelevant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @NOT generated 
	 */
	public View getView() {
		if (this.eContainer() != null) {
			EObject parent = this.eContainer();
			if (parent instanceof View) {
				return (View) parent;
			}
		}
		
		return null; 
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfmlPackage.EFEATURE__SETTINGS:
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
			case ConfmlPackage.EFEATURE__DESCRIPTION_TEXT:
				return getDescriptionText();
			case ConfmlPackage.EFEATURE__DESCRIPTION_URI:
				return getDescriptionUri();
			case ConfmlPackage.EFEATURE__DESCRIPTION_URI_TEXT:
				return getDescriptionUriText();
			case ConfmlPackage.EFEATURE__ICON_URI_TITLE:
				return getIconUriTitle();
			case ConfmlPackage.EFEATURE__ICON_URI:
				return getIconUri();
			case ConfmlPackage.EFEATURE__LINK_URI:
				return getLinkUri();
			case ConfmlPackage.EFEATURE__LINK_URI_TITLE:
				return getLinkUriTitle();
			case ConfmlPackage.EFEATURE__SETTINGS:
				return getSettings();
			case ConfmlPackage.EFEATURE__REF:
				return getRef();
			case ConfmlPackage.EFEATURE__NAME:
				return getName();
			case ConfmlPackage.EFEATURE__RELEVANT:
				return getRelevant();
			case ConfmlPackage.EFEATURE__RELEVANT_AST:
				return getRelevantAST();
			case ConfmlPackage.EFEATURE__COMPUTED_RELEVANT:
				return isComputedRelevant() ? Boolean.TRUE : Boolean.FALSE;
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
			case ConfmlPackage.EFEATURE__DESCRIPTION_TEXT:
				setDescriptionText((String)newValue);
				return;
			case ConfmlPackage.EFEATURE__DESCRIPTION_URI:
				setDescriptionUri((String)newValue);
				return;
			case ConfmlPackage.EFEATURE__DESCRIPTION_URI_TEXT:
				setDescriptionUriText((String)newValue);
				return;
			case ConfmlPackage.EFEATURE__ICON_URI_TITLE:
				setIconUriTitle((String)newValue);
				return;
			case ConfmlPackage.EFEATURE__ICON_URI:
				setIconUri((String)newValue);
				return;
			case ConfmlPackage.EFEATURE__LINK_URI:
				setLinkUri((String)newValue);
				return;
			case ConfmlPackage.EFEATURE__LINK_URI_TITLE:
				setLinkUriTitle((String)newValue);
				return;
			case ConfmlPackage.EFEATURE__SETTINGS:
				getSettings().clear();
				getSettings().addAll((Collection<? extends ESetting>)newValue);
				return;
			case ConfmlPackage.EFEATURE__REF:
				setRef((String)newValue);
				return;
			case ConfmlPackage.EFEATURE__NAME:
				setName((String)newValue);
				return;
			case ConfmlPackage.EFEATURE__RELEVANT:
				setRelevant((String)newValue);
				return;
			case ConfmlPackage.EFEATURE__RELEVANT_AST:
				setRelevantAST(newValue);
				return;
			case ConfmlPackage.EFEATURE__COMPUTED_RELEVANT:
				setComputedRelevant(((Boolean)newValue).booleanValue());
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
			case ConfmlPackage.EFEATURE__DESCRIPTION_TEXT:
				setDescriptionText(DESCRIPTION_TEXT_EDEFAULT);
				return;
			case ConfmlPackage.EFEATURE__DESCRIPTION_URI:
				setDescriptionUri(DESCRIPTION_URI_EDEFAULT);
				return;
			case ConfmlPackage.EFEATURE__DESCRIPTION_URI_TEXT:
				setDescriptionUriText(DESCRIPTION_URI_TEXT_EDEFAULT);
				return;
			case ConfmlPackage.EFEATURE__ICON_URI_TITLE:
				setIconUriTitle(ICON_URI_TITLE_EDEFAULT);
				return;
			case ConfmlPackage.EFEATURE__ICON_URI:
				setIconUri(ICON_URI_EDEFAULT);
				return;
			case ConfmlPackage.EFEATURE__LINK_URI:
				setLinkUri(LINK_URI_EDEFAULT);
				return;
			case ConfmlPackage.EFEATURE__LINK_URI_TITLE:
				setLinkUriTitle(LINK_URI_TITLE_EDEFAULT);
				return;
			case ConfmlPackage.EFEATURE__SETTINGS:
				getSettings().clear();
				return;
			case ConfmlPackage.EFEATURE__REF:
				setRef(REF_EDEFAULT);
				return;
			case ConfmlPackage.EFEATURE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ConfmlPackage.EFEATURE__RELEVANT:
				setRelevant(RELEVANT_EDEFAULT);
				return;
			case ConfmlPackage.EFEATURE__RELEVANT_AST:
				setRelevantAST(RELEVANT_AST_EDEFAULT);
				return;
			case ConfmlPackage.EFEATURE__COMPUTED_RELEVANT:
				setComputedRelevant(COMPUTED_RELEVANT_EDEFAULT);
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
			case ConfmlPackage.EFEATURE__DESCRIPTION_TEXT:
				return DESCRIPTION_TEXT_EDEFAULT == null ? descriptionText != null : !DESCRIPTION_TEXT_EDEFAULT.equals(descriptionText);
			case ConfmlPackage.EFEATURE__DESCRIPTION_URI:
				return DESCRIPTION_URI_EDEFAULT == null ? descriptionUri != null : !DESCRIPTION_URI_EDEFAULT.equals(descriptionUri);
			case ConfmlPackage.EFEATURE__DESCRIPTION_URI_TEXT:
				return DESCRIPTION_URI_TEXT_EDEFAULT == null ? descriptionUriText != null : !DESCRIPTION_URI_TEXT_EDEFAULT.equals(descriptionUriText);
			case ConfmlPackage.EFEATURE__ICON_URI_TITLE:
				return ICON_URI_TITLE_EDEFAULT == null ? iconUriTitle != null : !ICON_URI_TITLE_EDEFAULT.equals(iconUriTitle);
			case ConfmlPackage.EFEATURE__ICON_URI:
				return ICON_URI_EDEFAULT == null ? iconUri != null : !ICON_URI_EDEFAULT.equals(iconUri);
			case ConfmlPackage.EFEATURE__LINK_URI:
				return LINK_URI_EDEFAULT == null ? linkUri != null : !LINK_URI_EDEFAULT.equals(linkUri);
			case ConfmlPackage.EFEATURE__LINK_URI_TITLE:
				return LINK_URI_TITLE_EDEFAULT == null ? linkUriTitle != null : !LINK_URI_TITLE_EDEFAULT.equals(linkUriTitle);
			case ConfmlPackage.EFEATURE__SETTINGS:
				return settings != null && !settings.isEmpty();
			case ConfmlPackage.EFEATURE__REF:
				return REF_EDEFAULT == null ? ref != null : !REF_EDEFAULT.equals(ref);
			case ConfmlPackage.EFEATURE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ConfmlPackage.EFEATURE__RELEVANT:
				return RELEVANT_EDEFAULT == null ? relevant != null : !RELEVANT_EDEFAULT.equals(relevant);
			case ConfmlPackage.EFEATURE__RELEVANT_AST:
				return RELEVANT_AST_EDEFAULT == null ? relevantAST != null : !RELEVANT_AST_EDEFAULT.equals(relevantAST);
			case ConfmlPackage.EFEATURE__COMPUTED_RELEVANT:
				return computedRelevant != COMPUTED_RELEVANT_EDEFAULT;
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
				case ConfmlPackage.EFEATURE__ICON_URI_TITLE: return ConfmlPackage.EICON_CONTAINER__ICON_URI_TITLE;
				case ConfmlPackage.EFEATURE__ICON_URI: return ConfmlPackage.EICON_CONTAINER__ICON_URI;
				default: return -1;
			}
		}
		if (baseClass == ELinkContainer.class) {
			switch (derivedFeatureID) {
				case ConfmlPackage.EFEATURE__LINK_URI: return ConfmlPackage.ELINK_CONTAINER__LINK_URI;
				case ConfmlPackage.EFEATURE__LINK_URI_TITLE: return ConfmlPackage.ELINK_CONTAINER__LINK_URI_TITLE;
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
				case ConfmlPackage.EICON_CONTAINER__ICON_URI_TITLE: return ConfmlPackage.EFEATURE__ICON_URI_TITLE;
				case ConfmlPackage.EICON_CONTAINER__ICON_URI: return ConfmlPackage.EFEATURE__ICON_URI;
				default: return -1;
			}
		}
		if (baseClass == ELinkContainer.class) {
			switch (baseFeatureID) {
				case ConfmlPackage.ELINK_CONTAINER__LINK_URI: return ConfmlPackage.EFEATURE__LINK_URI;
				case ConfmlPackage.ELINK_CONTAINER__LINK_URI_TITLE: return ConfmlPackage.EFEATURE__LINK_URI_TITLE;
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
		result.append(", descriptionUriText: ");
		result.append(descriptionUriText);
		result.append(", iconUriTitle: ");
		result.append(iconUriTitle);
		result.append(", iconUri: ");
		result.append(iconUri);
		result.append(", linkUri: ");
		result.append(linkUri);
		result.append(", linkUriTitle: ");
		result.append(linkUriTitle);
		result.append(", ref: ");
		result.append(ref);
		result.append(", name: ");
		result.append(name);
		result.append(", relevant: ");
		result.append(relevant);
		result.append(", relevantAST: ");
		result.append(relevantAST);
		result.append(", computedRelevant: ");
		result.append(computedRelevant);
		result.append(')');
		return result.toString();
	}

} //EFeatureImpl
