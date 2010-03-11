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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.nokia.tools.variant.editor.model.SortingCriteria;
import com.nokia.tools.variant.editor.model.SortingOrder;
import com.nokia.tools.variant.editor.model.UIGroup;
import com.nokia.tools.variant.editor.model.UIMessage;
import com.nokia.tools.variant.editor.model.UIMessageType;
import com.nokia.tools.variant.editor.model.UIModel;
import com.nokia.tools.variant.editor.model.UIModelFactory;
import com.nokia.tools.variant.editor.model.UIModelPackage;
import com.nokia.tools.variant.editor.model.UISetting;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UIModelFactoryImpl extends EFactoryImpl implements UIModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UIModelFactory init() {
		try {
			UIModelFactory theUIModelFactory = (UIModelFactory)EPackage.Registry.INSTANCE.getEFactory("http://ui_editor_model/1.0"); 
			if (theUIModelFactory != null) {
				return theUIModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UIModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UIModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case UIModelPackage.UI_MODEL: return createUIModel();
			case UIModelPackage.UI_GROUP: return createUIGroup();
			case UIModelPackage.UI_SETTING: return createUISetting();
			case UIModelPackage.UI_MESSAGE: return createUIMessage();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case UIModelPackage.UI_MESSAGE_TYPE:
				return createUIMessageTypeFromString(eDataType, initialValue);
			case UIModelPackage.SORTING_ORDER:
				return createSortingOrderFromString(eDataType, initialValue);
			case UIModelPackage.SORTING_CRITERIA:
				return createSortingCriteriaFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case UIModelPackage.UI_MESSAGE_TYPE:
				return convertUIMessageTypeToString(eDataType, instanceValue);
			case UIModelPackage.SORTING_ORDER:
				return convertSortingOrderToString(eDataType, instanceValue);
			case UIModelPackage.SORTING_CRITERIA:
				return convertSortingCriteriaToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UIModel createUIModel() {
		UIModelImpl uiModel = new UIModelImpl();
		return uiModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UIGroup createUIGroup() {
		UIGroupImpl uiGroup = new UIGroupImpl();
		return uiGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UISetting createUISetting() {
		UISettingImpl uiSetting = new UISettingImpl();
		return uiSetting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UIMessage createUIMessage() {
		UIMessageImpl uiMessage = new UIMessageImpl();
		return uiMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UIMessageType createUIMessageTypeFromString(EDataType eDataType, String initialValue) {
		UIMessageType result = UIMessageType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUIMessageTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SortingOrder createSortingOrderFromString(EDataType eDataType, String initialValue) {
		SortingOrder result = SortingOrder.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSortingOrderToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SortingCriteria createSortingCriteriaFromString(EDataType eDataType, String initialValue) {
		SortingCriteria result = SortingCriteria.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSortingCriteriaToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UIModelPackage getUIModelPackage() {
		return (UIModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UIModelPackage getPackage() {
		return UIModelPackage.eINSTANCE;
	}

} //UIModelFactoryImpl
