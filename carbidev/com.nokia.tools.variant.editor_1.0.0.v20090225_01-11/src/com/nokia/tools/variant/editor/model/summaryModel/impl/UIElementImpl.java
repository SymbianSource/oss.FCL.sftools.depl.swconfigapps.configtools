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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.nokia.tools.variant.editor.model.summaryModel.SUMMARYTYPE;
import com.nokia.tools.variant.editor.model.summaryModel.SummaryModelPackage;
import com.nokia.tools.variant.editor.model.summaryModel.UIElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UI Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.editor.model.summaryModel.impl.UIElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.model.summaryModel.impl.UIElementImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.model.summaryModel.impl.UIElementImpl#getLastSavedValue <em>Last Saved Value</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.model.summaryModel.impl.UIElementImpl#getValue <em>Value</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.model.summaryModel.impl.UIElementImpl#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link com.nokia.tools.variant.editor.model.summaryModel.impl.UIElementImpl#getNote <em>Note</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UIElementImpl extends EObjectImpl implements UIElement {
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
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final SUMMARYTYPE TYPE_EDEFAULT = SUMMARYTYPE.NAME;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected SUMMARYTYPE type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLastSavedValue() <em>Last Saved Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastSavedValue()
	 * @generated
	 * @ordered
	 */
	protected static final String LAST_SAVED_VALUE_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getLastSavedValue() <em>Last Saved Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastSavedValue()
	 * @generated
	 * @ordered
	 */
	protected String lastSavedValue = LAST_SAVED_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = "";

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
	 * The default value of the '{@link #getDefaultValue() <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultValue() <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected String defaultValue = DEFAULT_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getNote() <em>Note</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNote()
	 * @generated
	 * @ordered
	 */
	protected static final String NOTE_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getNote() <em>Note</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNote()
	 * @generated
	 * @ordered
	 */
	protected String note = NOTE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UIElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SummaryModelPackage.Literals.UI_ELEMENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SummaryModelPackage.UI_ELEMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SUMMARYTYPE getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(SUMMARYTYPE newType) {
		SUMMARYTYPE oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SummaryModelPackage.UI_ELEMENT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLastSavedValue() {
		return lastSavedValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastSavedValue(String newLastSavedValue) {
		String oldLastSavedValue = lastSavedValue;
		lastSavedValue = newLastSavedValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SummaryModelPackage.UI_ELEMENT__LAST_SAVED_VALUE, oldLastSavedValue, lastSavedValue));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SummaryModelPackage.UI_ELEMENT__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultValue() {
		return defaultValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultValue(String newDefaultValue) {
		String oldDefaultValue = defaultValue;
		defaultValue = newDefaultValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SummaryModelPackage.UI_ELEMENT__DEFAULT_VALUE, oldDefaultValue, defaultValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNote() {
		return note;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNote(String newNote) {
		String oldNote = note;
		note = newNote;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SummaryModelPackage.UI_ELEMENT__NOTE, oldNote, note));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isDirty() {
		if (lastSavedValue != null && !lastSavedValue.equals(value)) {
			return true;
		}
		else
			return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isDefault() {
		if (defaultValue == null && value == null) {
			return true;
		}
		if (defaultValue != null && defaultValue.equals(value)) {
			return true;
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SummaryModelPackage.UI_ELEMENT__NAME:
				return getName();
			case SummaryModelPackage.UI_ELEMENT__TYPE:
				return getType();
			case SummaryModelPackage.UI_ELEMENT__LAST_SAVED_VALUE:
				return getLastSavedValue();
			case SummaryModelPackage.UI_ELEMENT__VALUE:
				return getValue();
			case SummaryModelPackage.UI_ELEMENT__DEFAULT_VALUE:
				return getDefaultValue();
			case SummaryModelPackage.UI_ELEMENT__NOTE:
				return getNote();
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
			case SummaryModelPackage.UI_ELEMENT__NAME:
				setName((String)newValue);
				return;
			case SummaryModelPackage.UI_ELEMENT__TYPE:
				setType((SUMMARYTYPE)newValue);
				return;
			case SummaryModelPackage.UI_ELEMENT__LAST_SAVED_VALUE:
				setLastSavedValue((String)newValue);
				return;
			case SummaryModelPackage.UI_ELEMENT__VALUE:
				setValue((String)newValue);
				return;
			case SummaryModelPackage.UI_ELEMENT__DEFAULT_VALUE:
				setDefaultValue((String)newValue);
				return;
			case SummaryModelPackage.UI_ELEMENT__NOTE:
				setNote((String)newValue);
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
			case SummaryModelPackage.UI_ELEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SummaryModelPackage.UI_ELEMENT__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case SummaryModelPackage.UI_ELEMENT__LAST_SAVED_VALUE:
				setLastSavedValue(LAST_SAVED_VALUE_EDEFAULT);
				return;
			case SummaryModelPackage.UI_ELEMENT__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case SummaryModelPackage.UI_ELEMENT__DEFAULT_VALUE:
				setDefaultValue(DEFAULT_VALUE_EDEFAULT);
				return;
			case SummaryModelPackage.UI_ELEMENT__NOTE:
				setNote(NOTE_EDEFAULT);
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
			case SummaryModelPackage.UI_ELEMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SummaryModelPackage.UI_ELEMENT__TYPE:
				return type != TYPE_EDEFAULT;
			case SummaryModelPackage.UI_ELEMENT__LAST_SAVED_VALUE:
				return LAST_SAVED_VALUE_EDEFAULT == null ? lastSavedValue != null : !LAST_SAVED_VALUE_EDEFAULT.equals(lastSavedValue);
			case SummaryModelPackage.UI_ELEMENT__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case SummaryModelPackage.UI_ELEMENT__DEFAULT_VALUE:
				return DEFAULT_VALUE_EDEFAULT == null ? defaultValue != null : !DEFAULT_VALUE_EDEFAULT.equals(defaultValue);
			case SummaryModelPackage.UI_ELEMENT__NOTE:
				return NOTE_EDEFAULT == null ? note != null : !NOTE_EDEFAULT.equals(note);
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
		result.append(", type: ");
		result.append(type);
		result.append(", lastSavedValue: ");
		result.append(lastSavedValue);
		result.append(", value: ");
		result.append(value);
		result.append(", defaultValue: ");
		result.append(defaultValue);
		result.append(", note: ");
		result.append(note);
		result.append(')');
		return result.toString();
	}

} //UIElementImpl
