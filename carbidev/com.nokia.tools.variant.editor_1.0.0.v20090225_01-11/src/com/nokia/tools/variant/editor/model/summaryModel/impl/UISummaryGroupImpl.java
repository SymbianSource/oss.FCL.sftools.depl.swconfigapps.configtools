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
 * Description: This file is part of com.nokia.tools.variant.editor component.
 */

package com.nokia.tools.variant.editor.model.summaryModel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import com.nokia.tools.variant.editor.model.summaryModel.SummaryModelPackage;
import com.nokia.tools.variant.editor.model.summaryModel.UIElement;
import com.nokia.tools.variant.editor.model.summaryModel.UISummaryGroup;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UI Summary Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.editor.model.summaryModel.impl.UISummaryGroupImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.model.summaryModel.impl.UISummaryGroupImpl#getUiElements <em>Ui Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UISummaryGroupImpl extends EObjectImpl implements UISummaryGroup {
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
	 * The cached value of the '{@link #getUiElements() <em>Ui Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUiElements()
	 * @generated
	 * @ordered
	 */
	protected EList<UIElement> uiElements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UISummaryGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SummaryModelPackage.Literals.UI_SUMMARY_GROUP;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SummaryModelPackage.UI_SUMMARY_GROUP__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UIElement> getUiElements() {
		if (uiElements == null) {
			uiElements = new EObjectResolvingEList<UIElement>(UIElement.class, this, SummaryModelPackage.UI_SUMMARY_GROUP__UI_ELEMENTS);
		}
		return uiElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SummaryModelPackage.UI_SUMMARY_GROUP__TITLE:
				return getTitle();
			case SummaryModelPackage.UI_SUMMARY_GROUP__UI_ELEMENTS:
				return getUiElements();
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
			case SummaryModelPackage.UI_SUMMARY_GROUP__TITLE:
				setTitle((String)newValue);
				return;
			case SummaryModelPackage.UI_SUMMARY_GROUP__UI_ELEMENTS:
				getUiElements().clear();
				getUiElements().addAll((Collection<? extends UIElement>)newValue);
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
			case SummaryModelPackage.UI_SUMMARY_GROUP__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case SummaryModelPackage.UI_SUMMARY_GROUP__UI_ELEMENTS:
				getUiElements().clear();
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
			case SummaryModelPackage.UI_SUMMARY_GROUP__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case SummaryModelPackage.UI_SUMMARY_GROUP__UI_ELEMENTS:
				return uiElements != null && !uiElements.isEmpty();
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
		result.append(" (title: ");
		result.append(title);
		result.append(')');
		return result.toString();
	}

} //UISummaryGroupImpl
