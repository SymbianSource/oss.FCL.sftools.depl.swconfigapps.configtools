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

package com.nokia.tools.variant.editor.model.summaryModel;

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
 * @see com.nokia.tools.variant.editor.model.summaryModel.SummaryModelFactory
 * @model kind="package"
 * @generated
 */
public interface SummaryModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "summaryModel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://ui_editor_model/1.1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "summaryModel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SummaryModelPackage eINSTANCE = com.nokia.tools.variant.editor.model.summaryModel.impl.SummaryModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.editor.model.summaryModel.impl.UISummaryModelImpl <em>UI Summary Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.editor.model.summaryModel.impl.UISummaryModelImpl
	 * @see com.nokia.tools.variant.editor.model.summaryModel.impl.SummaryModelPackageImpl#getUISummaryModel()
	 * @generated
	 */
	int UI_SUMMARY_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Ui Groups</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_SUMMARY_MODEL__UI_GROUPS = 0;

	/**
	 * The number of structural features of the '<em>UI Summary Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_SUMMARY_MODEL_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.editor.model.summaryModel.impl.UIElementImpl <em>UI Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.editor.model.summaryModel.impl.UIElementImpl
	 * @see com.nokia.tools.variant.editor.model.summaryModel.impl.SummaryModelPackageImpl#getUIElement()
	 * @generated
	 */
	int UI_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_ELEMENT__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Last Saved Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_ELEMENT__LAST_SAVED_VALUE = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_ELEMENT__VALUE = 3;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_ELEMENT__DEFAULT_VALUE = 4;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_ELEMENT__NOTE = 5;

	/**
	 * The number of structural features of the '<em>UI Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_ELEMENT_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.editor.model.summaryModel.impl.UISummaryGroupImpl <em>UI Summary Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.editor.model.summaryModel.impl.UISummaryGroupImpl
	 * @see com.nokia.tools.variant.editor.model.summaryModel.impl.SummaryModelPackageImpl#getUISummaryGroup()
	 * @generated
	 */
	int UI_SUMMARY_GROUP = 2;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_SUMMARY_GROUP__TITLE = 0;

	/**
	 * The feature id for the '<em><b>Ui Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_SUMMARY_GROUP__UI_ELEMENTS = 1;

	/**
	 * The number of structural features of the '<em>UI Summary Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_SUMMARY_GROUP_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.editor.model.summaryModel.impl.NoteImpl <em>Note</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.editor.model.summaryModel.impl.NoteImpl
	 * @see com.nokia.tools.variant.editor.model.summaryModel.impl.SummaryModelPackageImpl#getNote()
	 * @generated
	 */
	int NOTE = 3;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTE__DATE = 0;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTE__CONTENT = 1;

	/**
	 * The number of structural features of the '<em>Note</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.editor.model.summaryModel.impl.HistoryImpl <em>History</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.editor.model.summaryModel.impl.HistoryImpl
	 * @see com.nokia.tools.variant.editor.model.summaryModel.impl.SummaryModelPackageImpl#getHistory()
	 * @generated
	 */
	int HISTORY = 4;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY__NOTE = 0;

	/**
	 * The number of structural features of the '<em>History</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.editor.model.summaryModel.SUMMARYTYPE <em>SUMMARYTYPE</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.editor.model.summaryModel.SUMMARYTYPE
	 * @see com.nokia.tools.variant.editor.model.summaryModel.impl.SummaryModelPackageImpl#getSUMMARYTYPE()
	 * @generated
	 */
	int SUMMARYTYPE = 5;


	/**
	 * Returns the meta object for class '{@link com.nokia.tools.variant.editor.model.summaryModel.UISummaryModel <em>UI Summary Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UI Summary Model</em>'.
	 * @see com.nokia.tools.variant.editor.model.summaryModel.UISummaryModel
	 * @generated
	 */
	EClass getUISummaryModel();

	/**
	 * Returns the meta object for the reference list '{@link com.nokia.tools.variant.editor.model.summaryModel.UISummaryModel#getUiGroups <em>Ui Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Ui Groups</em>'.
	 * @see com.nokia.tools.variant.editor.model.summaryModel.UISummaryModel#getUiGroups()
	 * @see #getUISummaryModel()
	 * @generated
	 */
	EReference getUISummaryModel_UiGroups();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.variant.editor.model.summaryModel.UIElement <em>UI Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UI Element</em>'.
	 * @see com.nokia.tools.variant.editor.model.summaryModel.UIElement
	 * @generated
	 */
	EClass getUIElement();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.editor.model.summaryModel.UIElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.variant.editor.model.summaryModel.UIElement#getName()
	 * @see #getUIElement()
	 * @generated
	 */
	EAttribute getUIElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.editor.model.summaryModel.UIElement#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.nokia.tools.variant.editor.model.summaryModel.UIElement#getType()
	 * @see #getUIElement()
	 * @generated
	 */
	EAttribute getUIElement_Type();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.editor.model.summaryModel.UIElement#getLastSavedValue <em>Last Saved Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Saved Value</em>'.
	 * @see com.nokia.tools.variant.editor.model.summaryModel.UIElement#getLastSavedValue()
	 * @see #getUIElement()
	 * @generated
	 */
	EAttribute getUIElement_LastSavedValue();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.editor.model.summaryModel.UIElement#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.nokia.tools.variant.editor.model.summaryModel.UIElement#getValue()
	 * @see #getUIElement()
	 * @generated
	 */
	EAttribute getUIElement_Value();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.editor.model.summaryModel.UIElement#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Value</em>'.
	 * @see com.nokia.tools.variant.editor.model.summaryModel.UIElement#getDefaultValue()
	 * @see #getUIElement()
	 * @generated
	 */
	EAttribute getUIElement_DefaultValue();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.editor.model.summaryModel.UIElement#getNote <em>Note</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Note</em>'.
	 * @see com.nokia.tools.variant.editor.model.summaryModel.UIElement#getNote()
	 * @see #getUIElement()
	 * @generated
	 */
	EAttribute getUIElement_Note();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.variant.editor.model.summaryModel.UISummaryGroup <em>UI Summary Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UI Summary Group</em>'.
	 * @see com.nokia.tools.variant.editor.model.summaryModel.UISummaryGroup
	 * @generated
	 */
	EClass getUISummaryGroup();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.editor.model.summaryModel.UISummaryGroup#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see com.nokia.tools.variant.editor.model.summaryModel.UISummaryGroup#getTitle()
	 * @see #getUISummaryGroup()
	 * @generated
	 */
	EAttribute getUISummaryGroup_Title();

	/**
	 * Returns the meta object for the reference list '{@link com.nokia.tools.variant.editor.model.summaryModel.UISummaryGroup#getUiElements <em>Ui Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Ui Elements</em>'.
	 * @see com.nokia.tools.variant.editor.model.summaryModel.UISummaryGroup#getUiElements()
	 * @see #getUISummaryGroup()
	 * @generated
	 */
	EReference getUISummaryGroup_UiElements();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.variant.editor.model.summaryModel.Note <em>Note</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Note</em>'.
	 * @see com.nokia.tools.variant.editor.model.summaryModel.Note
	 * @generated
	 */
	EClass getNote();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.editor.model.summaryModel.Note#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see com.nokia.tools.variant.editor.model.summaryModel.Note#getDate()
	 * @see #getNote()
	 * @generated
	 */
	EAttribute getNote_Date();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.editor.model.summaryModel.Note#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see com.nokia.tools.variant.editor.model.summaryModel.Note#getContent()
	 * @see #getNote()
	 * @generated
	 */
	EAttribute getNote_Content();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.variant.editor.model.summaryModel.History <em>History</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>History</em>'.
	 * @see com.nokia.tools.variant.editor.model.summaryModel.History
	 * @generated
	 */
	EClass getHistory();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.variant.editor.model.summaryModel.History#getNote <em>Note</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Note</em>'.
	 * @see com.nokia.tools.variant.editor.model.summaryModel.History#getNote()
	 * @see #getHistory()
	 * @generated
	 */
	EReference getHistory_Note();

	/**
	 * Returns the meta object for enum '{@link com.nokia.tools.variant.editor.model.summaryModel.SUMMARYTYPE <em>SUMMARYTYPE</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>SUMMARYTYPE</em>'.
	 * @see com.nokia.tools.variant.editor.model.summaryModel.SUMMARYTYPE
	 * @generated
	 */
	EEnum getSUMMARYTYPE();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SummaryModelFactory getSummaryModelFactory();

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
		 * The meta object literal for the '{@link com.nokia.tools.variant.editor.model.summaryModel.impl.UISummaryModelImpl <em>UI Summary Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.editor.model.summaryModel.impl.UISummaryModelImpl
		 * @see com.nokia.tools.variant.editor.model.summaryModel.impl.SummaryModelPackageImpl#getUISummaryModel()
		 * @generated
		 */
		EClass UI_SUMMARY_MODEL = eINSTANCE.getUISummaryModel();

		/**
		 * The meta object literal for the '<em><b>Ui Groups</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UI_SUMMARY_MODEL__UI_GROUPS = eINSTANCE.getUISummaryModel_UiGroups();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.variant.editor.model.summaryModel.impl.UIElementImpl <em>UI Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.editor.model.summaryModel.impl.UIElementImpl
		 * @see com.nokia.tools.variant.editor.model.summaryModel.impl.SummaryModelPackageImpl#getUIElement()
		 * @generated
		 */
		EClass UI_ELEMENT = eINSTANCE.getUIElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UI_ELEMENT__NAME = eINSTANCE.getUIElement_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UI_ELEMENT__TYPE = eINSTANCE.getUIElement_Type();

		/**
		 * The meta object literal for the '<em><b>Last Saved Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UI_ELEMENT__LAST_SAVED_VALUE = eINSTANCE.getUIElement_LastSavedValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UI_ELEMENT__VALUE = eINSTANCE.getUIElement_Value();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UI_ELEMENT__DEFAULT_VALUE = eINSTANCE.getUIElement_DefaultValue();

		/**
		 * The meta object literal for the '<em><b>Note</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UI_ELEMENT__NOTE = eINSTANCE.getUIElement_Note();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.variant.editor.model.summaryModel.impl.UISummaryGroupImpl <em>UI Summary Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.editor.model.summaryModel.impl.UISummaryGroupImpl
		 * @see com.nokia.tools.variant.editor.model.summaryModel.impl.SummaryModelPackageImpl#getUISummaryGroup()
		 * @generated
		 */
		EClass UI_SUMMARY_GROUP = eINSTANCE.getUISummaryGroup();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UI_SUMMARY_GROUP__TITLE = eINSTANCE.getUISummaryGroup_Title();

		/**
		 * The meta object literal for the '<em><b>Ui Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UI_SUMMARY_GROUP__UI_ELEMENTS = eINSTANCE.getUISummaryGroup_UiElements();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.variant.editor.model.summaryModel.impl.NoteImpl <em>Note</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.editor.model.summaryModel.impl.NoteImpl
		 * @see com.nokia.tools.variant.editor.model.summaryModel.impl.SummaryModelPackageImpl#getNote()
		 * @generated
		 */
		EClass NOTE = eINSTANCE.getNote();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTE__DATE = eINSTANCE.getNote_Date();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTE__CONTENT = eINSTANCE.getNote_Content();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.variant.editor.model.summaryModel.impl.HistoryImpl <em>History</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.editor.model.summaryModel.impl.HistoryImpl
		 * @see com.nokia.tools.variant.editor.model.summaryModel.impl.SummaryModelPackageImpl#getHistory()
		 * @generated
		 */
		EClass HISTORY = eINSTANCE.getHistory();

		/**
		 * The meta object literal for the '<em><b>Note</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HISTORY__NOTE = eINSTANCE.getHistory_Note();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.variant.editor.model.summaryModel.SUMMARYTYPE <em>SUMMARYTYPE</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.editor.model.summaryModel.SUMMARYTYPE
		 * @see com.nokia.tools.variant.editor.model.summaryModel.impl.SummaryModelPackageImpl#getSUMMARYTYPE()
		 * @generated
		 */
		EEnum SUMMARYTYPE = eINSTANCE.getSUMMARYTYPE();

	}

} //SummaryModelPackage
