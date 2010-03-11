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

package com.nokia.tools.variant.editor.model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.editor.model.UIMessage;
import com.nokia.tools.variant.editor.model.UIModelPackage;
import com.nokia.tools.variant.editor.model.UISetting;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UI Setting</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.editor.model.impl.UISettingImpl#getSetting <em>Setting</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.model.impl.UISettingImpl#isSelected <em>Selected</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.model.impl.UISettingImpl#isFocused <em>Focused</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.model.impl.UISettingImpl#getUiMessages <em>Ui Messages</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.model.impl.UISettingImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.model.impl.UISettingImpl#getData <em>Data</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UISettingImpl extends EObjectImpl implements UISetting {
	/**
	 * The cached value of the '{@link #getSetting() <em>Setting</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSetting()
	 * @generated
	 * @ordered
	 */
	protected Setting setting;

	/**
	 * The default value of the '{@link #isSelected() <em>Selected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSelected()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SELECTED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSelected() <em>Selected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSelected()
	 * @generated
	 * @ordered
	 */
	protected boolean selected = SELECTED_EDEFAULT;

	/**
	 * The default value of the '{@link #isFocused() <em>Focused</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFocused()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FOCUSED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFocused() <em>Focused</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFocused()
	 * @generated
	 * @ordered
	 */
	protected boolean focused = FOCUSED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUiMessages() <em>Ui Messages</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUiMessages()
	 * @generated
	 * @ordered
	 */
	protected EList<UIMessage> uiMessages;

	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<UISetting> children;

	/**
	 * The default value of the '{@link #getData() <em>Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected static final Object DATA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getData() <em>Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected Object data = DATA_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UISettingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UIModelPackage.Literals.UI_SETTING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Setting getSetting() {
		if (setting != null && setting.eIsProxy()) {
			InternalEObject oldSetting = (InternalEObject)setting;
			setting = (Setting)eResolveProxy(oldSetting);
			if (setting != oldSetting) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UIModelPackage.UI_SETTING__SETTING, oldSetting, setting));
			}
		}
		return setting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Setting basicGetSetting() {
		return setting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSetting(Setting newSetting) {
		Setting oldSetting = setting;
		setting = newSetting;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UIModelPackage.UI_SETTING__SETTING, oldSetting, setting));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelected(boolean newSelected) {
		boolean oldSelected = selected;
		selected = newSelected;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UIModelPackage.UI_SETTING__SELECTED, oldSelected, selected));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFocused() {
		return focused;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFocused(boolean newFocused) {
		boolean oldFocused = focused;
		focused = newFocused;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UIModelPackage.UI_SETTING__FOCUSED, oldFocused, focused));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UIMessage> getUiMessages() {
		if (uiMessages == null) {
			uiMessages = new EObjectResolvingEList<UIMessage>(UIMessage.class, this, UIModelPackage.UI_SETTING__UI_MESSAGES);
		}
		return uiMessages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UISetting> getChildren() {
		if (children == null) {
			children = new EObjectContainmentEList<UISetting>(UISetting.class, this, UIModelPackage.UI_SETTING__CHILDREN);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getData() {
		return data;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setData(Object newData) {
		Object oldData = data;
		data = newData;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UIModelPackage.UI_SETTING__DATA, oldData, data));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UIModelPackage.UI_SETTING__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
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
			case UIModelPackage.UI_SETTING__SETTING:
				if (resolve) return getSetting();
				return basicGetSetting();
			case UIModelPackage.UI_SETTING__SELECTED:
				return isSelected() ? Boolean.TRUE : Boolean.FALSE;
			case UIModelPackage.UI_SETTING__FOCUSED:
				return isFocused() ? Boolean.TRUE : Boolean.FALSE;
			case UIModelPackage.UI_SETTING__UI_MESSAGES:
				return getUiMessages();
			case UIModelPackage.UI_SETTING__CHILDREN:
				return getChildren();
			case UIModelPackage.UI_SETTING__DATA:
				return getData();
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
			case UIModelPackage.UI_SETTING__SETTING:
				setSetting((Setting)newValue);
				return;
			case UIModelPackage.UI_SETTING__SELECTED:
				setSelected(((Boolean)newValue).booleanValue());
				return;
			case UIModelPackage.UI_SETTING__FOCUSED:
				setFocused(((Boolean)newValue).booleanValue());
				return;
			case UIModelPackage.UI_SETTING__UI_MESSAGES:
				getUiMessages().clear();
				getUiMessages().addAll((Collection<? extends UIMessage>)newValue);
				return;
			case UIModelPackage.UI_SETTING__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends UISetting>)newValue);
				return;
			case UIModelPackage.UI_SETTING__DATA:
				setData(newValue);
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
			case UIModelPackage.UI_SETTING__SETTING:
				setSetting((Setting)null);
				return;
			case UIModelPackage.UI_SETTING__SELECTED:
				setSelected(SELECTED_EDEFAULT);
				return;
			case UIModelPackage.UI_SETTING__FOCUSED:
				setFocused(FOCUSED_EDEFAULT);
				return;
			case UIModelPackage.UI_SETTING__UI_MESSAGES:
				getUiMessages().clear();
				return;
			case UIModelPackage.UI_SETTING__CHILDREN:
				getChildren().clear();
				return;
			case UIModelPackage.UI_SETTING__DATA:
				setData(DATA_EDEFAULT);
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
			case UIModelPackage.UI_SETTING__SETTING:
				return setting != null;
			case UIModelPackage.UI_SETTING__SELECTED:
				return selected != SELECTED_EDEFAULT;
			case UIModelPackage.UI_SETTING__FOCUSED:
				return focused != FOCUSED_EDEFAULT;
			case UIModelPackage.UI_SETTING__UI_MESSAGES:
				return uiMessages != null && !uiMessages.isEmpty();
			case UIModelPackage.UI_SETTING__CHILDREN:
				return children != null && !children.isEmpty();
			case UIModelPackage.UI_SETTING__DATA:
				return DATA_EDEFAULT == null ? data != null : !DATA_EDEFAULT.equals(data);
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
		result.append(" (selected: ");
		result.append(selected);
		result.append(", focused: ");
		result.append(focused);
		result.append(", data: ");
		result.append(data);
		result.append(')');
		return result.toString();
	}

} //UISettingImpl
