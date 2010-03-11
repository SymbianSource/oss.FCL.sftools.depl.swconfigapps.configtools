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
 * Description: This file is part of com.nokia.tools.variant.content.confml.model component.
 */

package com.nokia.tools.variant.content.confml.impl;


import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.nokia.tools.variant.content.confml.ConfmlPackage;
import com.nokia.tools.variant.content.confml.Feature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.content.confml.impl.FeatureImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.impl.FeatureImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.impl.FeatureImpl#getRelevant <em>Relevant</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.impl.FeatureImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.impl.FeatureImpl#getIconTitle <em>Icon Title</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.impl.FeatureImpl#getIconDescriptor <em>Icon Descriptor</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.impl.FeatureImpl#getIconURI <em>Icon URI</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.impl.FeatureImpl#isComputedRelevant <em>Computed Relevant</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureImpl extends EObjectImpl implements Feature {
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
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getIconTitle() <em>Icon Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String ICON_TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIconTitle() <em>Icon Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconTitle()
	 * @generated
	 * @ordered
	 */
	protected String iconTitle = ICON_TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getIconDescriptor() <em>Icon Descriptor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconDescriptor()
	 * @generated
	 * @ordered
	 */
	protected static final Object ICON_DESCRIPTOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIconDescriptor() <em>Icon Descriptor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconDescriptor()
	 * @generated
	 * @ordered
	 */
	protected Object iconDescriptor = ICON_DESCRIPTOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getIconURI() <em>Icon URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconURI()
	 * @generated
	 * @ordered
	 */
	protected static final URI ICON_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIconURI() <em>Icon URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconURI()
	 * @generated
	 * @ordered
	 */
	protected URI iconURI = ICON_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #isComputedRelevant() <em>Computed Relevant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isComputedRelevant()
	 * @generated
	 * @ordered
	 */
	protected static final boolean COMPUTED_RELEVANT_EDEFAULT = false;

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
	protected FeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfmlPackage.Literals.FEATURE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.FEATURE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.FEATURE__REF, oldRef, ref));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.FEATURE__RELEVANT, oldRelevant, relevant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.FEATURE__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIconTitle() {
		return iconTitle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIconTitle(String newIconTitle) {
		String oldIconTitle = iconTitle;
		iconTitle = newIconTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.FEATURE__ICON_TITLE, oldIconTitle, iconTitle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getIconDescriptor() {
		return iconDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIconDescriptor(Object newIconDescriptor) {
		Object oldIconDescriptor = iconDescriptor;
		iconDescriptor = newIconDescriptor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.FEATURE__ICON_DESCRIPTOR, oldIconDescriptor, iconDescriptor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URI getIconURI() {
		return iconURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIconURI(URI newIconURI) {
		URI oldIconURI = iconURI;
		iconURI = newIconURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.FEATURE__ICON_URI, oldIconURI, iconURI));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.FEATURE__COMPUTED_RELEVANT, oldComputedRelevant, computedRelevant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfmlPackage.FEATURE__NAME:
				return getName();
			case ConfmlPackage.FEATURE__REF:
				return getRef();
			case ConfmlPackage.FEATURE__RELEVANT:
				return getRelevant();
			case ConfmlPackage.FEATURE__DESCRIPTION:
				return getDescription();
			case ConfmlPackage.FEATURE__ICON_TITLE:
				return getIconTitle();
			case ConfmlPackage.FEATURE__ICON_DESCRIPTOR:
				return getIconDescriptor();
			case ConfmlPackage.FEATURE__ICON_URI:
				return getIconURI();
			case ConfmlPackage.FEATURE__COMPUTED_RELEVANT:
				return isComputedRelevant() ? Boolean.TRUE : Boolean.FALSE;
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConfmlPackage.FEATURE__NAME:
				setName((String)newValue);
				return;
			case ConfmlPackage.FEATURE__REF:
				setRef((String)newValue);
				return;
			case ConfmlPackage.FEATURE__RELEVANT:
				setRelevant((String)newValue);
				return;
			case ConfmlPackage.FEATURE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ConfmlPackage.FEATURE__ICON_TITLE:
				setIconTitle((String)newValue);
				return;
			case ConfmlPackage.FEATURE__ICON_DESCRIPTOR:
				setIconDescriptor(newValue);
				return;
			case ConfmlPackage.FEATURE__ICON_URI:
				setIconURI((URI)newValue);
				return;
			case ConfmlPackage.FEATURE__COMPUTED_RELEVANT:
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
			case ConfmlPackage.FEATURE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ConfmlPackage.FEATURE__REF:
				setRef(REF_EDEFAULT);
				return;
			case ConfmlPackage.FEATURE__RELEVANT:
				setRelevant(RELEVANT_EDEFAULT);
				return;
			case ConfmlPackage.FEATURE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ConfmlPackage.FEATURE__ICON_TITLE:
				setIconTitle(ICON_TITLE_EDEFAULT);
				return;
			case ConfmlPackage.FEATURE__ICON_DESCRIPTOR:
				setIconDescriptor(ICON_DESCRIPTOR_EDEFAULT);
				return;
			case ConfmlPackage.FEATURE__ICON_URI:
				setIconURI(ICON_URI_EDEFAULT);
				return;
			case ConfmlPackage.FEATURE__COMPUTED_RELEVANT:
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
			case ConfmlPackage.FEATURE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ConfmlPackage.FEATURE__REF:
				return REF_EDEFAULT == null ? ref != null : !REF_EDEFAULT.equals(ref);
			case ConfmlPackage.FEATURE__RELEVANT:
				return RELEVANT_EDEFAULT == null ? relevant != null : !RELEVANT_EDEFAULT.equals(relevant);
			case ConfmlPackage.FEATURE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ConfmlPackage.FEATURE__ICON_TITLE:
				return ICON_TITLE_EDEFAULT == null ? iconTitle != null : !ICON_TITLE_EDEFAULT.equals(iconTitle);
			case ConfmlPackage.FEATURE__ICON_DESCRIPTOR:
				return ICON_DESCRIPTOR_EDEFAULT == null ? iconDescriptor != null : !ICON_DESCRIPTOR_EDEFAULT.equals(iconDescriptor);
			case ConfmlPackage.FEATURE__ICON_URI:
				return ICON_URI_EDEFAULT == null ? iconURI != null : !ICON_URI_EDEFAULT.equals(iconURI);
			case ConfmlPackage.FEATURE__COMPUTED_RELEVANT:
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
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", ref: ");
		result.append(ref);
		result.append(", relevant: ");
		result.append(relevant);
		result.append(", description: ");
		result.append(description);
		result.append(", iconTitle: ");
		result.append(iconTitle);
		result.append(", iconDescriptor: ");
		result.append(iconDescriptor);
		result.append(", iconURI: ");
		result.append(iconURI);
		result.append(", computedRelevant: ");
		result.append(computedRelevant);
		result.append(')');
		return result.toString();
	}

} //FeatureImpl
