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

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.nokia.tools.s60ct.model.confml.ConfmlPackage;
import com.nokia.tools.s60ct.model.confml.EOption;
import com.nokia.tools.s60ct.model.confml.EOptionMap;
import com.nokia.tools.s60ct.model.confml.ESettingOption;
import com.nokia.tools.s60ct.model.confml.ESettingValueType;
import com.nokia.tools.s60ct.model.confml.ESimpleSetting;
import com.nokia.tools.s60ct.model.confml.ESimpleValue;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ESimple Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESimpleValueImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ESimpleValueImpl extends ESettingValueImpl implements ESimpleValue {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ESimpleValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfmlPackage.Literals.ESIMPLE_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @NOT generated
	 */
	public String getValue() {
		
		if (getType() instanceof ESimpleSetting && ((ESimpleSetting)getType()).getType().equals(ESettingValueType.DATETIME))
			return dateTimeCorrection(value);
		else
			return value;
	}

	public String getTrueValue() 
	{
		return value;
	}
	
    private String dateTimeCorrection(String dateTime) {
		
		if (dateTime!= null && dateTime.length() > 10) {
			if (dateTime.charAt(10) == '-') {
				StringBuilder sb = new StringBuilder(dateTime);
				sb.setCharAt(10, 'T');
				dateTime = sb.toString();
			} 
		} 
		return dateTime;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @NOT generated
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		// if value is one of options, then remember it
		if (getType()!= null && getType() instanceof ESimpleSetting)
		{
			ESimpleSetting ss = (ESimpleSetting)getType();
			setChosenOption(null);
			EList<ESettingOption> options = ss.getOptions();
			if (options != null && newValue != null) {
				for (ESettingOption opt : options) {
					Map<String, EOptionMap> optionValues = ((EOption)opt).getOptionValues();
					if (optionValues != null) {
						for (String optionKey : optionValues.keySet()) 
						{
							EOptionMap optionMapEntry = optionValues.get(optionKey);
	
							if (newValue.equals(optionMapEntry.getValue2Save())
							|| newValue.equals(optionMapEntry.getMapValue())) {
	
								setChosenOption(optionKey);
								this.setMap(optionMapEntry.getValue2Save());
								break;
							}
						}
						if (getChosenOption() != null) {
							break;
						}
					}
				}
			}
		}
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESIMPLE_VALUE__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfmlPackage.ESIMPLE_VALUE__VALUE:
				return getValue();
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
			case ConfmlPackage.ESIMPLE_VALUE__VALUE:
				setValue((String)newValue);
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
			case ConfmlPackage.ESIMPLE_VALUE__VALUE:
				setValue(VALUE_EDEFAULT);
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
			case ConfmlPackage.ESIMPLE_VALUE__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
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
		result.append(" (value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //ESimpleValueImpl
