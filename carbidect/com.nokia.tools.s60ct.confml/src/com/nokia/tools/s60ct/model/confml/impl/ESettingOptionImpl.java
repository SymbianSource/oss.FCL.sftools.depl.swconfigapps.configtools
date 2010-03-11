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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.nokia.tools.s60ct.model.confml.ConfmlPackage;
import com.nokia.tools.s60ct.model.confml.ESettingOption;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ESetting Option</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESettingOptionImpl#getDescriptionText <em>Description Text</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESettingOptionImpl#getDescriptionUri <em>Description Uri</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESettingOptionImpl#getDescriptionUriText <em>Description Uri Text</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESettingOptionImpl#getRelevant <em>Relevant</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESettingOptionImpl#getRelevantAST <em>Relevant AST</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESettingOptionImpl#isComputedRelevant <em>Computed Relevant</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ESettingOptionImpl extends EObjectImpl implements ESettingOption {
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
	protected ESettingOptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfmlPackage.Literals.ESETTING_OPTION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING_OPTION__DESCRIPTION_TEXT, oldDescriptionText, descriptionText));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING_OPTION__DESCRIPTION_URI, oldDescriptionUri, descriptionUri));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING_OPTION__DESCRIPTION_URI_TEXT, oldDescriptionUriText, descriptionUriText));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING_OPTION__RELEVANT, oldRelevant, relevant));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING_OPTION__RELEVANT_AST, oldRelevantAST, relevantAST));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING_OPTION__COMPUTED_RELEVANT, oldComputedRelevant, computedRelevant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfmlPackage.ESETTING_OPTION__DESCRIPTION_TEXT:
				return getDescriptionText();
			case ConfmlPackage.ESETTING_OPTION__DESCRIPTION_URI:
				return getDescriptionUri();
			case ConfmlPackage.ESETTING_OPTION__DESCRIPTION_URI_TEXT:
				return getDescriptionUriText();
			case ConfmlPackage.ESETTING_OPTION__RELEVANT:
				return getRelevant();
			case ConfmlPackage.ESETTING_OPTION__RELEVANT_AST:
				return getRelevantAST();
			case ConfmlPackage.ESETTING_OPTION__COMPUTED_RELEVANT:
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
			case ConfmlPackage.ESETTING_OPTION__DESCRIPTION_TEXT:
				setDescriptionText((String)newValue);
				return;
			case ConfmlPackage.ESETTING_OPTION__DESCRIPTION_URI:
				setDescriptionUri((String)newValue);
				return;
			case ConfmlPackage.ESETTING_OPTION__DESCRIPTION_URI_TEXT:
				setDescriptionUriText((String)newValue);
				return;
			case ConfmlPackage.ESETTING_OPTION__RELEVANT:
				setRelevant((String)newValue);
				return;
			case ConfmlPackage.ESETTING_OPTION__RELEVANT_AST:
				setRelevantAST(newValue);
				return;
			case ConfmlPackage.ESETTING_OPTION__COMPUTED_RELEVANT:
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
			case ConfmlPackage.ESETTING_OPTION__DESCRIPTION_TEXT:
				setDescriptionText(DESCRIPTION_TEXT_EDEFAULT);
				return;
			case ConfmlPackage.ESETTING_OPTION__DESCRIPTION_URI:
				setDescriptionUri(DESCRIPTION_URI_EDEFAULT);
				return;
			case ConfmlPackage.ESETTING_OPTION__DESCRIPTION_URI_TEXT:
				setDescriptionUriText(DESCRIPTION_URI_TEXT_EDEFAULT);
				return;
			case ConfmlPackage.ESETTING_OPTION__RELEVANT:
				setRelevant(RELEVANT_EDEFAULT);
				return;
			case ConfmlPackage.ESETTING_OPTION__RELEVANT_AST:
				setRelevantAST(RELEVANT_AST_EDEFAULT);
				return;
			case ConfmlPackage.ESETTING_OPTION__COMPUTED_RELEVANT:
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
			case ConfmlPackage.ESETTING_OPTION__DESCRIPTION_TEXT:
				return DESCRIPTION_TEXT_EDEFAULT == null ? descriptionText != null : !DESCRIPTION_TEXT_EDEFAULT.equals(descriptionText);
			case ConfmlPackage.ESETTING_OPTION__DESCRIPTION_URI:
				return DESCRIPTION_URI_EDEFAULT == null ? descriptionUri != null : !DESCRIPTION_URI_EDEFAULT.equals(descriptionUri);
			case ConfmlPackage.ESETTING_OPTION__DESCRIPTION_URI_TEXT:
				return DESCRIPTION_URI_TEXT_EDEFAULT == null ? descriptionUriText != null : !DESCRIPTION_URI_TEXT_EDEFAULT.equals(descriptionUriText);
			case ConfmlPackage.ESETTING_OPTION__RELEVANT:
				return RELEVANT_EDEFAULT == null ? relevant != null : !RELEVANT_EDEFAULT.equals(relevant);
			case ConfmlPackage.ESETTING_OPTION__RELEVANT_AST:
				return RELEVANT_AST_EDEFAULT == null ? relevantAST != null : !RELEVANT_AST_EDEFAULT.equals(relevantAST);
			case ConfmlPackage.ESETTING_OPTION__COMPUTED_RELEVANT:
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
		result.append(" (descriptionText: ");
		result.append(descriptionText);
		result.append(", descriptionUri: ");
		result.append(descriptionUri);
		result.append(", descriptionUriText: ");
		result.append(descriptionUriText);
		result.append(", relevant: ");
		result.append(relevant);
		result.append(", relevantAST: ");
		result.append(relevantAST);
		result.append(", computedRelevant: ");
		result.append(computedRelevant);
		result.append(')');
		return result.toString();
	}

} //ESettingOptionImpl
