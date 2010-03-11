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

package com.nokia.tools.variant.editor.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.nokia.tools.variant.editor.model.UIModelFactory
 * @model kind="package"
 * @generated
 */
public interface UIModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://ui_editor_model/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UIModelPackage eINSTANCE = com.nokia.tools.variant.editor.model.impl.UIModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.editor.model.impl.UIModelImpl <em>UI Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.editor.model.impl.UIModelImpl
	 * @see com.nokia.tools.variant.editor.model.impl.UIModelPackageImpl#getUIModel()
	 * @generated
	 */
	int UI_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Ui Groups</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_MODEL__UI_GROUPS = 0;

	/**
	 * The number of structural features of the '<em>UI Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_MODEL_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.editor.model.impl.UIGroupImpl <em>UI Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.editor.model.impl.UIGroupImpl
	 * @see com.nokia.tools.variant.editor.model.impl.UIModelPackageImpl#getUIGroup()
	 * @generated
	 */
	int UI_GROUP = 1;

	/**
	 * The feature id for the '<em><b>Ui Settings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_GROUP__UI_SETTINGS = 0;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_GROUP__TITLE = 1;

	/**
	 * The feature id for the '<em><b>Sorting Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_GROUP__SORTING_ORDER = 2;

	/**
	 * The feature id for the '<em><b>Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_GROUP__MODEL = 3;

	/**
	 * The feature id for the '<em><b>Ui Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_GROUP__UI_GROUPS = 4;

	/**
	 * The number of structural features of the '<em>UI Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_GROUP_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.editor.model.impl.UISettingImpl <em>UI Setting</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.editor.model.impl.UISettingImpl
	 * @see com.nokia.tools.variant.editor.model.impl.UIModelPackageImpl#getUISetting()
	 * @generated
	 */
	int UI_SETTING = 2;

	/**
	 * The feature id for the '<em><b>Setting</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_SETTING__SETTING = 0;

	/**
	 * The feature id for the '<em><b>Selected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_SETTING__SELECTED = 1;

	/**
	 * The feature id for the '<em><b>Focused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_SETTING__FOCUSED = 2;

	/**
	 * The feature id for the '<em><b>Ui Messages</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_SETTING__UI_MESSAGES = 3;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_SETTING__CHILDREN = 4;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_SETTING__DATA = 5;

	/**
	 * The number of structural features of the '<em>UI Setting</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_SETTING_FEATURE_COUNT = 6;


	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.editor.model.impl.UIMessageImpl <em>UI Message</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.editor.model.impl.UIMessageImpl
	 * @see com.nokia.tools.variant.editor.model.impl.UIModelPackageImpl#getUIMessage()
	 * @generated
	 */
	int UI_MESSAGE = 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_MESSAGE__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_MESSAGE__TEXT = 1;

	/**
	 * The number of structural features of the '<em>UI Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_MESSAGE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.editor.model.UIMessageType <em>UI Message Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.editor.model.UIMessageType
	 * @see com.nokia.tools.variant.editor.model.impl.UIModelPackageImpl#getUIMessageType()
	 * @generated
	 */
	int UI_MESSAGE_TYPE = 4;


	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.editor.model.SortingOrder <em>Sorting Order</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.editor.model.SortingOrder
	 * @see com.nokia.tools.variant.editor.model.impl.UIModelPackageImpl#getSortingOrder()
	 * @generated
	 */
	int SORTING_ORDER = 5;


	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.editor.model.SortingCriteria <em>Sorting Criteria</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.editor.model.SortingCriteria
	 * @see com.nokia.tools.variant.editor.model.impl.UIModelPackageImpl#getSortingCriteria()
	 * @generated
	 */
	int SORTING_CRITERIA = 6;


	/**
	 * Returns the meta object for class '{@link com.nokia.tools.variant.editor.model.UIModel <em>UI Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UI Model</em>'.
	 * @see com.nokia.tools.variant.editor.model.UIModel
	 * @generated
	 */
	EClass getUIModel();

	/**
	 * Returns the meta object for the reference list '{@link com.nokia.tools.variant.editor.model.UIModel#getUiGroups <em>Ui Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Ui Groups</em>'.
	 * @see com.nokia.tools.variant.editor.model.UIModel#getUiGroups()
	 * @see #getUIModel()
	 * @generated
	 */
	EReference getUIModel_UiGroups();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.variant.editor.model.UIGroup <em>UI Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UI Group</em>'.
	 * @see com.nokia.tools.variant.editor.model.UIGroup
	 * @generated
	 */
	EClass getUIGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.variant.editor.model.UIGroup#getUiSettings <em>Ui Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ui Settings</em>'.
	 * @see com.nokia.tools.variant.editor.model.UIGroup#getUiSettings()
	 * @see #getUIGroup()
	 * @generated
	 */
	EReference getUIGroup_UiSettings();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.editor.model.UIGroup#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see com.nokia.tools.variant.editor.model.UIGroup#getTitle()
	 * @see #getUIGroup()
	 * @generated
	 */
	EAttribute getUIGroup_Title();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.editor.model.UIGroup#getSortingOrder <em>Sorting Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sorting Order</em>'.
	 * @see com.nokia.tools.variant.editor.model.UIGroup#getSortingOrder()
	 * @see #getUIGroup()
	 * @generated
	 */
	EAttribute getUIGroup_SortingOrder();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.editor.model.UIGroup#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model</em>'.
	 * @see com.nokia.tools.variant.editor.model.UIGroup#getModel()
	 * @see #getUIGroup()
	 * @generated
	 */
	EAttribute getUIGroup_Model();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.variant.editor.model.UIGroup#getUiGroups <em>Ui Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ui Groups</em>'.
	 * @see com.nokia.tools.variant.editor.model.UIGroup#getUiGroups()
	 * @see #getUIGroup()
	 * @generated
	 */
	EReference getUIGroup_UiGroups();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.variant.editor.model.UISetting <em>UI Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UI Setting</em>'.
	 * @see com.nokia.tools.variant.editor.model.UISetting
	 * @generated
	 */
	EClass getUISetting();

	/**
	 * Returns the meta object for the reference '{@link com.nokia.tools.variant.editor.model.UISetting#getSetting <em>Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Setting</em>'.
	 * @see com.nokia.tools.variant.editor.model.UISetting#getSetting()
	 * @see #getUISetting()
	 * @generated
	 */
	EReference getUISetting_Setting();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.editor.model.UISetting#isSelected <em>Selected</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Selected</em>'.
	 * @see com.nokia.tools.variant.editor.model.UISetting#isSelected()
	 * @see #getUISetting()
	 * @generated
	 */
	EAttribute getUISetting_Selected();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.editor.model.UISetting#isFocused <em>Focused</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Focused</em>'.
	 * @see com.nokia.tools.variant.editor.model.UISetting#isFocused()
	 * @see #getUISetting()
	 * @generated
	 */
	EAttribute getUISetting_Focused();

	/**
	 * Returns the meta object for the reference list '{@link com.nokia.tools.variant.editor.model.UISetting#getUiMessages <em>Ui Messages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Ui Messages</em>'.
	 * @see com.nokia.tools.variant.editor.model.UISetting#getUiMessages()
	 * @see #getUISetting()
	 * @generated
	 */
	EReference getUISetting_UiMessages();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.variant.editor.model.UISetting#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see com.nokia.tools.variant.editor.model.UISetting#getChildren()
	 * @see #getUISetting()
	 * @generated
	 */
	EReference getUISetting_Children();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.editor.model.UISetting#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data</em>'.
	 * @see com.nokia.tools.variant.editor.model.UISetting#getData()
	 * @see #getUISetting()
	 * @generated
	 */
	EAttribute getUISetting_Data();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.variant.editor.model.UIMessage <em>UI Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UI Message</em>'.
	 * @see com.nokia.tools.variant.editor.model.UIMessage
	 * @generated
	 */
	EClass getUIMessage();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.editor.model.UIMessage#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.nokia.tools.variant.editor.model.UIMessage#getType()
	 * @see #getUIMessage()
	 * @generated
	 */
	EAttribute getUIMessage_Type();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.editor.model.UIMessage#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see com.nokia.tools.variant.editor.model.UIMessage#getText()
	 * @see #getUIMessage()
	 * @generated
	 */
	EAttribute getUIMessage_Text();

	/**
	 * Returns the meta object for enum '{@link com.nokia.tools.variant.editor.model.UIMessageType <em>UI Message Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>UI Message Type</em>'.
	 * @see com.nokia.tools.variant.editor.model.UIMessageType
	 * @generated
	 */
	EEnum getUIMessageType();

	/**
	 * Returns the meta object for enum '{@link com.nokia.tools.variant.editor.model.SortingOrder <em>Sorting Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Sorting Order</em>'.
	 * @see com.nokia.tools.variant.editor.model.SortingOrder
	 * @generated
	 */
	EEnum getSortingOrder();

	/**
	 * Returns the meta object for enum '{@link com.nokia.tools.variant.editor.model.SortingCriteria <em>Sorting Criteria</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Sorting Criteria</em>'.
	 * @see com.nokia.tools.variant.editor.model.SortingCriteria
	 * @generated
	 */
	EEnum getSortingCriteria();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UIModelFactory getUIModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.nokia.tools.variant.editor.model.impl.UIModelImpl <em>UI Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.editor.model.impl.UIModelImpl
		 * @see com.nokia.tools.variant.editor.model.impl.UIModelPackageImpl#getUIModel()
		 * @generated
		 */
		EClass UI_MODEL = eINSTANCE.getUIModel();

		/**
		 * The meta object literal for the '<em><b>Ui Groups</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UI_MODEL__UI_GROUPS = eINSTANCE.getUIModel_UiGroups();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.variant.editor.model.impl.UIGroupImpl <em>UI Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.editor.model.impl.UIGroupImpl
		 * @see com.nokia.tools.variant.editor.model.impl.UIModelPackageImpl#getUIGroup()
		 * @generated
		 */
		EClass UI_GROUP = eINSTANCE.getUIGroup();

		/**
		 * The meta object literal for the '<em><b>Ui Settings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UI_GROUP__UI_SETTINGS = eINSTANCE.getUIGroup_UiSettings();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UI_GROUP__TITLE = eINSTANCE.getUIGroup_Title();

		/**
		 * The meta object literal for the '<em><b>Sorting Order</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UI_GROUP__SORTING_ORDER = eINSTANCE.getUIGroup_SortingOrder();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UI_GROUP__MODEL = eINSTANCE.getUIGroup_Model();

		/**
		 * The meta object literal for the '<em><b>Ui Groups</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UI_GROUP__UI_GROUPS = eINSTANCE.getUIGroup_UiGroups();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.variant.editor.model.impl.UISettingImpl <em>UI Setting</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.editor.model.impl.UISettingImpl
		 * @see com.nokia.tools.variant.editor.model.impl.UIModelPackageImpl#getUISetting()
		 * @generated
		 */
		EClass UI_SETTING = eINSTANCE.getUISetting();

		/**
		 * The meta object literal for the '<em><b>Setting</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UI_SETTING__SETTING = eINSTANCE.getUISetting_Setting();

		/**
		 * The meta object literal for the '<em><b>Selected</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UI_SETTING__SELECTED = eINSTANCE.getUISetting_Selected();

		/**
		 * The meta object literal for the '<em><b>Focused</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UI_SETTING__FOCUSED = eINSTANCE.getUISetting_Focused();

		/**
		 * The meta object literal for the '<em><b>Ui Messages</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UI_SETTING__UI_MESSAGES = eINSTANCE.getUISetting_UiMessages();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UI_SETTING__CHILDREN = eINSTANCE.getUISetting_Children();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UI_SETTING__DATA = eINSTANCE.getUISetting_Data();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.variant.editor.model.impl.UIMessageImpl <em>UI Message</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.editor.model.impl.UIMessageImpl
		 * @see com.nokia.tools.variant.editor.model.impl.UIModelPackageImpl#getUIMessage()
		 * @generated
		 */
		EClass UI_MESSAGE = eINSTANCE.getUIMessage();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UI_MESSAGE__TYPE = eINSTANCE.getUIMessage_Type();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UI_MESSAGE__TEXT = eINSTANCE.getUIMessage_Text();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.variant.editor.model.UIMessageType <em>UI Message Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.editor.model.UIMessageType
		 * @see com.nokia.tools.variant.editor.model.impl.UIModelPackageImpl#getUIMessageType()
		 * @generated
		 */
		EEnum UI_MESSAGE_TYPE = eINSTANCE.getUIMessageType();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.variant.editor.model.SortingOrder <em>Sorting Order</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.editor.model.SortingOrder
		 * @see com.nokia.tools.variant.editor.model.impl.UIModelPackageImpl#getSortingOrder()
		 * @generated
		 */
		EEnum SORTING_ORDER = eINSTANCE.getSortingOrder();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.variant.editor.model.SortingCriteria <em>Sorting Criteria</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.editor.model.SortingCriteria
		 * @see com.nokia.tools.variant.editor.model.impl.UIModelPackageImpl#getSortingCriteria()
		 * @generated
		 */
		EEnum SORTING_CRITERIA = eINSTANCE.getSortingCriteria();

	}

} //UIModelPackage
