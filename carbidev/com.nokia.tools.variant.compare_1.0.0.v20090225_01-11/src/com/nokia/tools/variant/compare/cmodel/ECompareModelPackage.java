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
 * Description: This file is part of com.nokia.tools.variant.compare component.
 */

package com.nokia.tools.variant.compare.cmodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see com.nokia.tools.variant.compare.cmodel.ECompareModelFactory
 * @model kind="package"
 * @generated
 */
public interface ECompareModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "cmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "model:///compare";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "cmp";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ECompareModelPackage eINSTANCE = com.nokia.tools.variant.compare.cmodel.impl.ECompareModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.compare.cmodel.EGroupContainer <em>EGroup Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.compare.cmodel.EGroupContainer
	 * @see com.nokia.tools.variant.compare.cmodel.impl.ECompareModelPackageImpl#getEGroupContainer()
	 * @generated
	 */
	int EGROUP_CONTAINER = 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.compare.cmodel.impl.EModelRootImpl <em>EModel Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.compare.cmodel.impl.EModelRootImpl
	 * @see com.nokia.tools.variant.compare.cmodel.impl.ECompareModelPackageImpl#getEModelRoot()
	 * @generated
	 */
	int EMODEL_ROOT = 3;

	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.compare.cmodel.impl.ECheckableElementImpl <em>ECheckable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.compare.cmodel.impl.ECheckableElementImpl
	 * @see com.nokia.tools.variant.compare.cmodel.impl.ECompareModelPackageImpl#getECheckableElement()
	 * @generated
	 */
	int ECHECKABLE_ELEMENT = 11;

	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.compare.cmodel.ECompareElement <em>ECompare Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.compare.cmodel.ECompareElement
	 * @see com.nokia.tools.variant.compare.cmodel.impl.ECompareModelPackageImpl#getECompareElement()
	 * @generated
	 */
	int ECOMPARE_ELEMENT = 2;

	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.compare.cmodel.impl.EDiffGroupImpl <em>EDiff Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.compare.cmodel.impl.EDiffGroupImpl
	 * @see com.nokia.tools.variant.compare.cmodel.impl.ECompareModelPackageImpl#getEDiffGroup()
	 * @generated
	 */
	int EDIFF_GROUP = 4;

	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.compare.cmodel.impl.EDiffSimpleImpl <em>EDiff Simple</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.compare.cmodel.impl.EDiffSimpleImpl
	 * @see com.nokia.tools.variant.compare.cmodel.impl.ECompareModelPackageImpl#getEDiffSimple()
	 * @generated
	 */
	int EDIFF_SIMPLE = 6;

	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.compare.cmodel.impl.EDiffSequenceImpl <em>EDiff Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.compare.cmodel.impl.EDiffSequenceImpl
	 * @see com.nokia.tools.variant.compare.cmodel.impl.ECompareModelPackageImpl#getEDiffSequence()
	 * @generated
	 */
	int EDIFF_SEQUENCE = 7;

	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.compare.cmodel.EDiffSettingContainer <em>EDiff Setting Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.compare.cmodel.EDiffSettingContainer
	 * @see com.nokia.tools.variant.compare.cmodel.impl.ECompareModelPackageImpl#getEDiffSettingContainer()
	 * @generated
	 */
	int EDIFF_SETTING_CONTAINER = 0;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SETTING_CONTAINER__SETTINGS = 0;

	/**
	 * The number of structural features of the '<em>EDiff Setting Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SETTING_CONTAINER_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EGROUP_CONTAINER__GROUPS = 0;

	/**
	 * The number of structural features of the '<em>EGroup Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EGROUP_CONTAINER_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Exists In Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPARE_ELEMENT__EXISTS_IN_SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Exists In Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPARE_ELEMENT__EXISTS_IN_TARGET = 1;

	/**
	 * The feature id for the '<em><b>Source Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPARE_ELEMENT__SOURCE_OBJECT = 2;

	/**
	 * The feature id for the '<em><b>Target Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPARE_ELEMENT__TARGET_OBJECT = 3;

	/**
	 * The number of structural features of the '<em>ECompare Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECOMPARE_ELEMENT_FEATURE_COUNT = 4;

	/**
	 * The feature id for the '<em><b>Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMODEL_ROOT__GROUPS = EGROUP_CONTAINER__GROUPS;

	/**
	 * The number of structural features of the '<em>EModel Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMODEL_ROOT_FEATURE_COUNT = EGROUP_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Exists In Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_GROUP__EXISTS_IN_SOURCE = ECOMPARE_ELEMENT__EXISTS_IN_SOURCE;

	/**
	 * The feature id for the '<em><b>Exists In Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_GROUP__EXISTS_IN_TARGET = ECOMPARE_ELEMENT__EXISTS_IN_TARGET;

	/**
	 * The feature id for the '<em><b>Source Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_GROUP__SOURCE_OBJECT = ECOMPARE_ELEMENT__SOURCE_OBJECT;

	/**
	 * The feature id for the '<em><b>Target Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_GROUP__TARGET_OBJECT = ECOMPARE_ELEMENT__TARGET_OBJECT;

	/**
	 * The feature id for the '<em><b>Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_GROUP__GROUPS = ECOMPARE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_GROUP__SETTINGS = ECOMPARE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_GROUP__NAME = ECOMPARE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>EDiff Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_GROUP_FEATURE_COUNT = ECOMPARE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.compare.cmodel.impl.EDiffSettingImpl <em>EDiff Setting</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.compare.cmodel.impl.EDiffSettingImpl
	 * @see com.nokia.tools.variant.compare.cmodel.impl.ECompareModelPackageImpl#getEDiffSetting()
	 * @generated
	 */
	int EDIFF_SETTING = 5;

	/**
	 * The feature id for the '<em><b>Exists In Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SETTING__EXISTS_IN_SOURCE = ECOMPARE_ELEMENT__EXISTS_IN_SOURCE;

	/**
	 * The feature id for the '<em><b>Exists In Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SETTING__EXISTS_IN_TARGET = ECOMPARE_ELEMENT__EXISTS_IN_TARGET;

	/**
	 * The feature id for the '<em><b>Source Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SETTING__SOURCE_OBJECT = ECOMPARE_ELEMENT__SOURCE_OBJECT;

	/**
	 * The feature id for the '<em><b>Target Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SETTING__TARGET_OBJECT = ECOMPARE_ELEMENT__TARGET_OBJECT;

	/**
	 * The feature id for the '<em><b>Checked</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SETTING__CHECKED = ECOMPARE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Abs Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SETTING__ABS_REF = ECOMPARE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SETTING__NAME = ECOMPARE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Source Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SETTING__SOURCE_DEFAULT = ECOMPARE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Target Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SETTING__TARGET_DEFAULT = ECOMPARE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>EDiff Setting</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SETTING_FEATURE_COUNT = ECOMPARE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Exists In Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SIMPLE__EXISTS_IN_SOURCE = EDIFF_SETTING__EXISTS_IN_SOURCE;

	/**
	 * The feature id for the '<em><b>Exists In Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SIMPLE__EXISTS_IN_TARGET = EDIFF_SETTING__EXISTS_IN_TARGET;

	/**
	 * The feature id for the '<em><b>Source Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SIMPLE__SOURCE_OBJECT = EDIFF_SETTING__SOURCE_OBJECT;

	/**
	 * The feature id for the '<em><b>Target Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SIMPLE__TARGET_OBJECT = EDIFF_SETTING__TARGET_OBJECT;

	/**
	 * The feature id for the '<em><b>Checked</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SIMPLE__CHECKED = EDIFF_SETTING__CHECKED;

	/**
	 * The feature id for the '<em><b>Abs Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SIMPLE__ABS_REF = EDIFF_SETTING__ABS_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SIMPLE__NAME = EDIFF_SETTING__NAME;

	/**
	 * The feature id for the '<em><b>Source Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SIMPLE__SOURCE_DEFAULT = EDIFF_SETTING__SOURCE_DEFAULT;

	/**
	 * The feature id for the '<em><b>Target Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SIMPLE__TARGET_DEFAULT = EDIFF_SETTING__TARGET_DEFAULT;

	/**
	 * The feature id for the '<em><b>Source Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SIMPLE__SOURCE_VALUE = EDIFF_SETTING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SIMPLE__TARGET_VALUE = EDIFF_SETTING_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>EDiff Simple</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SIMPLE_FEATURE_COUNT = EDIFF_SETTING_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Exists In Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SEQUENCE__EXISTS_IN_SOURCE = EDIFF_SETTING__EXISTS_IN_SOURCE;

	/**
	 * The feature id for the '<em><b>Exists In Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SEQUENCE__EXISTS_IN_TARGET = EDIFF_SETTING__EXISTS_IN_TARGET;

	/**
	 * The feature id for the '<em><b>Source Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SEQUENCE__SOURCE_OBJECT = EDIFF_SETTING__SOURCE_OBJECT;

	/**
	 * The feature id for the '<em><b>Target Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SEQUENCE__TARGET_OBJECT = EDIFF_SETTING__TARGET_OBJECT;

	/**
	 * The feature id for the '<em><b>Checked</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SEQUENCE__CHECKED = EDIFF_SETTING__CHECKED;

	/**
	 * The feature id for the '<em><b>Abs Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SEQUENCE__ABS_REF = EDIFF_SETTING__ABS_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SEQUENCE__NAME = EDIFF_SETTING__NAME;

	/**
	 * The feature id for the '<em><b>Source Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SEQUENCE__SOURCE_DEFAULT = EDIFF_SETTING__SOURCE_DEFAULT;

	/**
	 * The feature id for the '<em><b>Target Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SEQUENCE__TARGET_DEFAULT = EDIFF_SETTING__TARGET_DEFAULT;

	/**
	 * The feature id for the '<em><b>Item Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SEQUENCE__ITEM_COUNT = EDIFF_SETTING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SEQUENCE__ITEMS = EDIFF_SETTING_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>EDiff Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SEQUENCE_FEATURE_COUNT = EDIFF_SETTING_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.compare.cmodel.impl.EDiffResourceSetting2Impl <em>EDiff Resource Setting2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.compare.cmodel.impl.EDiffResourceSetting2Impl
	 * @see com.nokia.tools.variant.compare.cmodel.impl.ECompareModelPackageImpl#getEDiffResourceSetting2()
	 * @generated
	 */
	int EDIFF_RESOURCE_SETTING2 = 8;

	/**
	 * The feature id for the '<em><b>Exists In Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_RESOURCE_SETTING2__EXISTS_IN_SOURCE = EDIFF_SETTING__EXISTS_IN_SOURCE;

	/**
	 * The feature id for the '<em><b>Exists In Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_RESOURCE_SETTING2__EXISTS_IN_TARGET = EDIFF_SETTING__EXISTS_IN_TARGET;

	/**
	 * The feature id for the '<em><b>Source Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_RESOURCE_SETTING2__SOURCE_OBJECT = EDIFF_SETTING__SOURCE_OBJECT;

	/**
	 * The feature id for the '<em><b>Target Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_RESOURCE_SETTING2__TARGET_OBJECT = EDIFF_SETTING__TARGET_OBJECT;

	/**
	 * The feature id for the '<em><b>Checked</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_RESOURCE_SETTING2__CHECKED = EDIFF_SETTING__CHECKED;

	/**
	 * The feature id for the '<em><b>Abs Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_RESOURCE_SETTING2__ABS_REF = EDIFF_SETTING__ABS_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_RESOURCE_SETTING2__NAME = EDIFF_SETTING__NAME;

	/**
	 * The feature id for the '<em><b>Source Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_RESOURCE_SETTING2__SOURCE_DEFAULT = EDIFF_SETTING__SOURCE_DEFAULT;

	/**
	 * The feature id for the '<em><b>Target Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_RESOURCE_SETTING2__TARGET_DEFAULT = EDIFF_SETTING__TARGET_DEFAULT;

	/**
	 * The feature id for the '<em><b>Source Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_RESOURCE_SETTING2__SOURCE_PATH = EDIFF_SETTING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_RESOURCE_SETTING2__TARGET_PATH = EDIFF_SETTING_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>EDiff Resource Setting2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_RESOURCE_SETTING2_FEATURE_COUNT = EDIFF_SETTING_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.compare.cmodel.impl.EDiffLocalPathSettingImpl <em>EDiff Local Path Setting</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.compare.cmodel.impl.EDiffLocalPathSettingImpl
	 * @see com.nokia.tools.variant.compare.cmodel.impl.ECompareModelPackageImpl#getEDiffLocalPathSetting()
	 * @generated
	 */
	int EDIFF_LOCAL_PATH_SETTING = 9;

	/**
	 * The feature id for the '<em><b>Exists In Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_LOCAL_PATH_SETTING__EXISTS_IN_SOURCE = EDIFF_SIMPLE__EXISTS_IN_SOURCE;

	/**
	 * The feature id for the '<em><b>Exists In Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_LOCAL_PATH_SETTING__EXISTS_IN_TARGET = EDIFF_SIMPLE__EXISTS_IN_TARGET;

	/**
	 * The feature id for the '<em><b>Source Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_LOCAL_PATH_SETTING__SOURCE_OBJECT = EDIFF_SIMPLE__SOURCE_OBJECT;

	/**
	 * The feature id for the '<em><b>Target Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_LOCAL_PATH_SETTING__TARGET_OBJECT = EDIFF_SIMPLE__TARGET_OBJECT;

	/**
	 * The feature id for the '<em><b>Checked</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_LOCAL_PATH_SETTING__CHECKED = EDIFF_SIMPLE__CHECKED;

	/**
	 * The feature id for the '<em><b>Abs Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_LOCAL_PATH_SETTING__ABS_REF = EDIFF_SIMPLE__ABS_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_LOCAL_PATH_SETTING__NAME = EDIFF_SIMPLE__NAME;

	/**
	 * The feature id for the '<em><b>Source Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_LOCAL_PATH_SETTING__SOURCE_DEFAULT = EDIFF_SIMPLE__SOURCE_DEFAULT;

	/**
	 * The feature id for the '<em><b>Target Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_LOCAL_PATH_SETTING__TARGET_DEFAULT = EDIFF_SIMPLE__TARGET_DEFAULT;

	/**
	 * The feature id for the '<em><b>Source Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_LOCAL_PATH_SETTING__SOURCE_VALUE = EDIFF_SIMPLE__SOURCE_VALUE;

	/**
	 * The feature id for the '<em><b>Target Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_LOCAL_PATH_SETTING__TARGET_VALUE = EDIFF_SIMPLE__TARGET_VALUE;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_LOCAL_PATH_SETTING__URI = EDIFF_SIMPLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Equal Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_LOCAL_PATH_SETTING__EQUAL_CONTENT = EDIFF_SIMPLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>EDiff Local Path Setting</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_LOCAL_PATH_SETTING_FEATURE_COUNT = EDIFF_SIMPLE_FEATURE_COUNT + 2;


	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.compare.cmodel.impl.EDiffMismatchImpl <em>EDiff Mismatch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.compare.cmodel.impl.EDiffMismatchImpl
	 * @see com.nokia.tools.variant.compare.cmodel.impl.ECompareModelPackageImpl#getEDiffMismatch()
	 * @generated
	 */
	int EDIFF_MISMATCH = 10;

	/**
	 * The feature id for the '<em><b>Exists In Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_MISMATCH__EXISTS_IN_SOURCE = EDIFF_SETTING__EXISTS_IN_SOURCE;

	/**
	 * The feature id for the '<em><b>Exists In Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_MISMATCH__EXISTS_IN_TARGET = EDIFF_SETTING__EXISTS_IN_TARGET;

	/**
	 * The feature id for the '<em><b>Source Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_MISMATCH__SOURCE_OBJECT = EDIFF_SETTING__SOURCE_OBJECT;

	/**
	 * The feature id for the '<em><b>Target Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_MISMATCH__TARGET_OBJECT = EDIFF_SETTING__TARGET_OBJECT;

	/**
	 * The feature id for the '<em><b>Checked</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_MISMATCH__CHECKED = EDIFF_SETTING__CHECKED;

	/**
	 * The feature id for the '<em><b>Abs Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_MISMATCH__ABS_REF = EDIFF_SETTING__ABS_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_MISMATCH__NAME = EDIFF_SETTING__NAME;

	/**
	 * The feature id for the '<em><b>Source Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_MISMATCH__SOURCE_DEFAULT = EDIFF_SETTING__SOURCE_DEFAULT;

	/**
	 * The feature id for the '<em><b>Target Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_MISMATCH__TARGET_DEFAULT = EDIFF_SETTING__TARGET_DEFAULT;

	/**
	 * The feature id for the '<em><b>Source Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_MISMATCH__SOURCE_TYPE = EDIFF_SETTING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_MISMATCH__TARGET_TYPE = EDIFF_SETTING_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>EDiff Mismatch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_MISMATCH_FEATURE_COUNT = EDIFF_SETTING_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Checked</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECHECKABLE_ELEMENT__CHECKED = 0;

	/**
	 * The number of structural features of the '<em>ECheckable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECHECKABLE_ELEMENT_FEATURE_COUNT = 1;


	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.compare.cmodel.impl.EDiffSequenceItemImpl <em>EDiff Sequence Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.compare.cmodel.impl.EDiffSequenceItemImpl
	 * @see com.nokia.tools.variant.compare.cmodel.impl.ECompareModelPackageImpl#getEDiffSequenceItem()
	 * @generated
	 */
	int EDIFF_SEQUENCE_ITEM = 12;

	/**
	 * The feature id for the '<em><b>Exists In Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SEQUENCE_ITEM__EXISTS_IN_SOURCE = ECOMPARE_ELEMENT__EXISTS_IN_SOURCE;

	/**
	 * The feature id for the '<em><b>Exists In Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SEQUENCE_ITEM__EXISTS_IN_TARGET = ECOMPARE_ELEMENT__EXISTS_IN_TARGET;

	/**
	 * The feature id for the '<em><b>Source Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SEQUENCE_ITEM__SOURCE_OBJECT = ECOMPARE_ELEMENT__SOURCE_OBJECT;

	/**
	 * The feature id for the '<em><b>Target Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SEQUENCE_ITEM__TARGET_OBJECT = ECOMPARE_ELEMENT__TARGET_OBJECT;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SEQUENCE_ITEM__SETTINGS = ECOMPARE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EDiff Sequence Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIFF_SEQUENCE_ITEM_FEATURE_COUNT = ECOMPARE_ELEMENT_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link com.nokia.tools.variant.compare.cmodel.EModelRoot <em>EModel Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EModel Root</em>'.
	 * @see com.nokia.tools.variant.compare.cmodel.EModelRoot
	 * @generated
	 */
	EClass getEModelRoot();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.variant.compare.cmodel.EDiffGroup <em>EDiff Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EDiff Group</em>'.
	 * @see com.nokia.tools.variant.compare.cmodel.EDiffGroup
	 * @generated
	 */
	EClass getEDiffGroup();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.compare.cmodel.EDiffGroup#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.variant.compare.cmodel.EDiffGroup#getName()
	 * @see #getEDiffGroup()
	 * @generated
	 */
	EAttribute getEDiffGroup_Name();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.variant.compare.cmodel.EDiffSetting <em>EDiff Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EDiff Setting</em>'.
	 * @see com.nokia.tools.variant.compare.cmodel.EDiffSetting
	 * @generated
	 */
	EClass getEDiffSetting();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.compare.cmodel.EDiffSetting#getAbsRef <em>Abs Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abs Ref</em>'.
	 * @see com.nokia.tools.variant.compare.cmodel.EDiffSetting#getAbsRef()
	 * @see #getEDiffSetting()
	 * @generated
	 */
	EAttribute getEDiffSetting_AbsRef();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.compare.cmodel.EDiffSetting#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.variant.compare.cmodel.EDiffSetting#getName()
	 * @see #getEDiffSetting()
	 * @generated
	 */
	EAttribute getEDiffSetting_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.compare.cmodel.EDiffSetting#isSourceDefault <em>Source Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Default</em>'.
	 * @see com.nokia.tools.variant.compare.cmodel.EDiffSetting#isSourceDefault()
	 * @see #getEDiffSetting()
	 * @generated
	 */
	EAttribute getEDiffSetting_SourceDefault();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.compare.cmodel.EDiffSetting#isTargetDefault <em>Target Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Default</em>'.
	 * @see com.nokia.tools.variant.compare.cmodel.EDiffSetting#isTargetDefault()
	 * @see #getEDiffSetting()
	 * @generated
	 */
	EAttribute getEDiffSetting_TargetDefault();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.variant.compare.cmodel.EGroupContainer <em>EGroup Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EGroup Container</em>'.
	 * @see com.nokia.tools.variant.compare.cmodel.EGroupContainer
	 * @generated
	 */
	EClass getEGroupContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.variant.compare.cmodel.EGroupContainer#getGroups <em>Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Groups</em>'.
	 * @see com.nokia.tools.variant.compare.cmodel.EGroupContainer#getGroups()
	 * @see #getEGroupContainer()
	 * @generated
	 */
	EReference getEGroupContainer_Groups();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.variant.compare.cmodel.ECompareElement <em>ECompare Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ECompare Element</em>'.
	 * @see com.nokia.tools.variant.compare.cmodel.ECompareElement
	 * @generated
	 */
	EClass getECompareElement();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.compare.cmodel.ECompareElement#isExistsInSource <em>Exists In Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exists In Source</em>'.
	 * @see com.nokia.tools.variant.compare.cmodel.ECompareElement#isExistsInSource()
	 * @see #getECompareElement()
	 * @generated
	 */
	EAttribute getECompareElement_ExistsInSource();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.compare.cmodel.ECompareElement#isExistsInTarget <em>Exists In Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exists In Target</em>'.
	 * @see com.nokia.tools.variant.compare.cmodel.ECompareElement#isExistsInTarget()
	 * @see #getECompareElement()
	 * @generated
	 */
	EAttribute getECompareElement_ExistsInTarget();

	/**
	 * Returns the meta object for the reference '{@link com.nokia.tools.variant.compare.cmodel.ECompareElement#getSourceObject <em>Source Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Object</em>'.
	 * @see com.nokia.tools.variant.compare.cmodel.ECompareElement#getSourceObject()
	 * @see #getECompareElement()
	 * @generated
	 */
	EReference getECompareElement_SourceObject();

	/**
	 * Returns the meta object for the reference '{@link com.nokia.tools.variant.compare.cmodel.ECompareElement#getTargetObject <em>Target Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Object</em>'.
	 * @see com.nokia.tools.variant.compare.cmodel.ECompareElement#getTargetObject()
	 * @see #getECompareElement()
	 * @generated
	 */
	EReference getECompareElement_TargetObject();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.variant.compare.cmodel.EDiffSimple <em>EDiff Simple</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EDiff Simple</em>'.
	 * @see com.nokia.tools.variant.compare.cmodel.EDiffSimple
	 * @generated
	 */
	EClass getEDiffSimple();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.compare.cmodel.EDiffSimple#getSourceValue <em>Source Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Value</em>'.
	 * @see com.nokia.tools.variant.compare.cmodel.EDiffSimple#getSourceValue()
	 * @see #getEDiffSimple()
	 * @generated
	 */
	EAttribute getEDiffSimple_SourceValue();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.compare.cmodel.EDiffSimple#getTargetValue <em>Target Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Value</em>'.
	 * @see com.nokia.tools.variant.compare.cmodel.EDiffSimple#getTargetValue()
	 * @see #getEDiffSimple()
	 * @generated
	 */
	EAttribute getEDiffSimple_TargetValue();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.variant.compare.cmodel.EDiffSequence <em>EDiff Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EDiff Sequence</em>'.
	 * @see com.nokia.tools.variant.compare.cmodel.EDiffSequence
	 * @generated
	 */
	EClass getEDiffSequence();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.compare.cmodel.EDiffSequence#getItemCount <em>Item Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Item Count</em>'.
	 * @see com.nokia.tools.variant.compare.cmodel.EDiffSequence#getItemCount()
	 * @see #getEDiffSequence()
	 * @generated
	 */
	EAttribute getEDiffSequence_ItemCount();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.variant.compare.cmodel.EDiffSequence#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Items</em>'.
	 * @see com.nokia.tools.variant.compare.cmodel.EDiffSequence#getItems()
	 * @see #getEDiffSequence()
	 * @generated
	 */
	EReference getEDiffSequence_Items();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.variant.compare.cmodel.EDiffSettingContainer <em>EDiff Setting Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EDiff Setting Container</em>'.
	 * @see com.nokia.tools.variant.compare.cmodel.EDiffSettingContainer
	 * @generated
	 */
	EClass getEDiffSettingContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.variant.compare.cmodel.EDiffSettingContainer#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Settings</em>'.
	 * @see com.nokia.tools.variant.compare.cmodel.EDiffSettingContainer#getSettings()
	 * @see #getEDiffSettingContainer()
	 * @generated
	 */
	EReference getEDiffSettingContainer_Settings();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.variant.compare.cmodel.EDiffResourceSetting2 <em>EDiff Resource Setting2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EDiff Resource Setting2</em>'.
	 * @see com.nokia.tools.variant.compare.cmodel.EDiffResourceSetting2
	 * @generated
	 */
	EClass getEDiffResourceSetting2();

	/**
	 * Returns the meta object for the containment reference '{@link com.nokia.tools.variant.compare.cmodel.EDiffResourceSetting2#getSourcePath <em>Source Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source Path</em>'.
	 * @see com.nokia.tools.variant.compare.cmodel.EDiffResourceSetting2#getSourcePath()
	 * @see #getEDiffResourceSetting2()
	 * @generated
	 */
	EReference getEDiffResourceSetting2_SourcePath();

	/**
	 * Returns the meta object for the containment reference '{@link com.nokia.tools.variant.compare.cmodel.EDiffResourceSetting2#getTargetPath <em>Target Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target Path</em>'.
	 * @see com.nokia.tools.variant.compare.cmodel.EDiffResourceSetting2#getTargetPath()
	 * @see #getEDiffResourceSetting2()
	 * @generated
	 */
	EReference getEDiffResourceSetting2_TargetPath();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.variant.compare.cmodel.EDiffLocalPathSetting <em>EDiff Local Path Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EDiff Local Path Setting</em>'.
	 * @see com.nokia.tools.variant.compare.cmodel.EDiffLocalPathSetting
	 * @generated
	 */
	EClass getEDiffLocalPathSetting();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.compare.cmodel.EDiffLocalPathSetting#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see com.nokia.tools.variant.compare.cmodel.EDiffLocalPathSetting#getUri()
	 * @see #getEDiffLocalPathSetting()
	 * @generated
	 */
	EAttribute getEDiffLocalPathSetting_Uri();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.compare.cmodel.EDiffLocalPathSetting#isEqualContent <em>Equal Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Equal Content</em>'.
	 * @see com.nokia.tools.variant.compare.cmodel.EDiffLocalPathSetting#isEqualContent()
	 * @see #getEDiffLocalPathSetting()
	 * @generated
	 */
	EAttribute getEDiffLocalPathSetting_EqualContent();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.variant.compare.cmodel.EDiffMismatch <em>EDiff Mismatch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EDiff Mismatch</em>'.
	 * @see com.nokia.tools.variant.compare.cmodel.EDiffMismatch
	 * @generated
	 */
	EClass getEDiffMismatch();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.compare.cmodel.EDiffMismatch#getSourceType <em>Source Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Type</em>'.
	 * @see com.nokia.tools.variant.compare.cmodel.EDiffMismatch#getSourceType()
	 * @see #getEDiffMismatch()
	 * @generated
	 */
	EAttribute getEDiffMismatch_SourceType();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.compare.cmodel.EDiffMismatch#getTargetType <em>Target Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Type</em>'.
	 * @see com.nokia.tools.variant.compare.cmodel.EDiffMismatch#getTargetType()
	 * @see #getEDiffMismatch()
	 * @generated
	 */
	EAttribute getEDiffMismatch_TargetType();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.variant.compare.cmodel.ECheckableElement <em>ECheckable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ECheckable Element</em>'.
	 * @see com.nokia.tools.variant.compare.cmodel.ECheckableElement
	 * @generated
	 */
	EClass getECheckableElement();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.compare.cmodel.ECheckableElement#isChecked <em>Checked</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Checked</em>'.
	 * @see com.nokia.tools.variant.compare.cmodel.ECheckableElement#isChecked()
	 * @see #getECheckableElement()
	 * @generated
	 */
	EAttribute getECheckableElement_Checked();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.variant.compare.cmodel.EDiffSequenceItem <em>EDiff Sequence Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EDiff Sequence Item</em>'.
	 * @see com.nokia.tools.variant.compare.cmodel.EDiffSequenceItem
	 * @generated
	 */
	EClass getEDiffSequenceItem();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ECompareModelFactory getECompareModelFactory();

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
		 * The meta object literal for the '{@link com.nokia.tools.variant.compare.cmodel.impl.EModelRootImpl <em>EModel Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.compare.cmodel.impl.EModelRootImpl
		 * @see com.nokia.tools.variant.compare.cmodel.impl.ECompareModelPackageImpl#getEModelRoot()
		 * @generated
		 */
		EClass EMODEL_ROOT = eINSTANCE.getEModelRoot();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.variant.compare.cmodel.impl.EDiffGroupImpl <em>EDiff Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.compare.cmodel.impl.EDiffGroupImpl
		 * @see com.nokia.tools.variant.compare.cmodel.impl.ECompareModelPackageImpl#getEDiffGroup()
		 * @generated
		 */
		EClass EDIFF_GROUP = eINSTANCE.getEDiffGroup();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDIFF_GROUP__NAME = eINSTANCE.getEDiffGroup_Name();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.variant.compare.cmodel.impl.EDiffSettingImpl <em>EDiff Setting</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.compare.cmodel.impl.EDiffSettingImpl
		 * @see com.nokia.tools.variant.compare.cmodel.impl.ECompareModelPackageImpl#getEDiffSetting()
		 * @generated
		 */
		EClass EDIFF_SETTING = eINSTANCE.getEDiffSetting();

		/**
		 * The meta object literal for the '<em><b>Abs Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDIFF_SETTING__ABS_REF = eINSTANCE.getEDiffSetting_AbsRef();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDIFF_SETTING__NAME = eINSTANCE.getEDiffSetting_Name();

		/**
		 * The meta object literal for the '<em><b>Source Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDIFF_SETTING__SOURCE_DEFAULT = eINSTANCE.getEDiffSetting_SourceDefault();

		/**
		 * The meta object literal for the '<em><b>Target Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDIFF_SETTING__TARGET_DEFAULT = eINSTANCE.getEDiffSetting_TargetDefault();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.variant.compare.cmodel.EGroupContainer <em>EGroup Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.compare.cmodel.EGroupContainer
		 * @see com.nokia.tools.variant.compare.cmodel.impl.ECompareModelPackageImpl#getEGroupContainer()
		 * @generated
		 */
		EClass EGROUP_CONTAINER = eINSTANCE.getEGroupContainer();

		/**
		 * The meta object literal for the '<em><b>Groups</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EGROUP_CONTAINER__GROUPS = eINSTANCE.getEGroupContainer_Groups();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.variant.compare.cmodel.ECompareElement <em>ECompare Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.compare.cmodel.ECompareElement
		 * @see com.nokia.tools.variant.compare.cmodel.impl.ECompareModelPackageImpl#getECompareElement()
		 * @generated
		 */
		EClass ECOMPARE_ELEMENT = eINSTANCE.getECompareElement();

		/**
		 * The meta object literal for the '<em><b>Exists In Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECOMPARE_ELEMENT__EXISTS_IN_SOURCE = eINSTANCE.getECompareElement_ExistsInSource();

		/**
		 * The meta object literal for the '<em><b>Exists In Target</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECOMPARE_ELEMENT__EXISTS_IN_TARGET = eINSTANCE.getECompareElement_ExistsInTarget();

		/**
		 * The meta object literal for the '<em><b>Source Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECOMPARE_ELEMENT__SOURCE_OBJECT = eINSTANCE.getECompareElement_SourceObject();

		/**
		 * The meta object literal for the '<em><b>Target Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECOMPARE_ELEMENT__TARGET_OBJECT = eINSTANCE.getECompareElement_TargetObject();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.variant.compare.cmodel.impl.EDiffSimpleImpl <em>EDiff Simple</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.compare.cmodel.impl.EDiffSimpleImpl
		 * @see com.nokia.tools.variant.compare.cmodel.impl.ECompareModelPackageImpl#getEDiffSimple()
		 * @generated
		 */
		EClass EDIFF_SIMPLE = eINSTANCE.getEDiffSimple();

		/**
		 * The meta object literal for the '<em><b>Source Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDIFF_SIMPLE__SOURCE_VALUE = eINSTANCE.getEDiffSimple_SourceValue();

		/**
		 * The meta object literal for the '<em><b>Target Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDIFF_SIMPLE__TARGET_VALUE = eINSTANCE.getEDiffSimple_TargetValue();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.variant.compare.cmodel.impl.EDiffSequenceImpl <em>EDiff Sequence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.compare.cmodel.impl.EDiffSequenceImpl
		 * @see com.nokia.tools.variant.compare.cmodel.impl.ECompareModelPackageImpl#getEDiffSequence()
		 * @generated
		 */
		EClass EDIFF_SEQUENCE = eINSTANCE.getEDiffSequence();

		/**
		 * The meta object literal for the '<em><b>Item Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDIFF_SEQUENCE__ITEM_COUNT = eINSTANCE.getEDiffSequence_ItemCount();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDIFF_SEQUENCE__ITEMS = eINSTANCE.getEDiffSequence_Items();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.variant.compare.cmodel.EDiffSettingContainer <em>EDiff Setting Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.compare.cmodel.EDiffSettingContainer
		 * @see com.nokia.tools.variant.compare.cmodel.impl.ECompareModelPackageImpl#getEDiffSettingContainer()
		 * @generated
		 */
		EClass EDIFF_SETTING_CONTAINER = eINSTANCE.getEDiffSettingContainer();

		/**
		 * The meta object literal for the '<em><b>Settings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDIFF_SETTING_CONTAINER__SETTINGS = eINSTANCE.getEDiffSettingContainer_Settings();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.variant.compare.cmodel.impl.EDiffResourceSetting2Impl <em>EDiff Resource Setting2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.compare.cmodel.impl.EDiffResourceSetting2Impl
		 * @see com.nokia.tools.variant.compare.cmodel.impl.ECompareModelPackageImpl#getEDiffResourceSetting2()
		 * @generated
		 */
		EClass EDIFF_RESOURCE_SETTING2 = eINSTANCE.getEDiffResourceSetting2();

		/**
		 * The meta object literal for the '<em><b>Source Path</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDIFF_RESOURCE_SETTING2__SOURCE_PATH = eINSTANCE.getEDiffResourceSetting2_SourcePath();

		/**
		 * The meta object literal for the '<em><b>Target Path</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDIFF_RESOURCE_SETTING2__TARGET_PATH = eINSTANCE.getEDiffResourceSetting2_TargetPath();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.variant.compare.cmodel.impl.EDiffLocalPathSettingImpl <em>EDiff Local Path Setting</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.compare.cmodel.impl.EDiffLocalPathSettingImpl
		 * @see com.nokia.tools.variant.compare.cmodel.impl.ECompareModelPackageImpl#getEDiffLocalPathSetting()
		 * @generated
		 */
		EClass EDIFF_LOCAL_PATH_SETTING = eINSTANCE.getEDiffLocalPathSetting();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDIFF_LOCAL_PATH_SETTING__URI = eINSTANCE.getEDiffLocalPathSetting_Uri();

		/**
		 * The meta object literal for the '<em><b>Equal Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDIFF_LOCAL_PATH_SETTING__EQUAL_CONTENT = eINSTANCE.getEDiffLocalPathSetting_EqualContent();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.variant.compare.cmodel.impl.EDiffMismatchImpl <em>EDiff Mismatch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.compare.cmodel.impl.EDiffMismatchImpl
		 * @see com.nokia.tools.variant.compare.cmodel.impl.ECompareModelPackageImpl#getEDiffMismatch()
		 * @generated
		 */
		EClass EDIFF_MISMATCH = eINSTANCE.getEDiffMismatch();

		/**
		 * The meta object literal for the '<em><b>Source Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDIFF_MISMATCH__SOURCE_TYPE = eINSTANCE.getEDiffMismatch_SourceType();

		/**
		 * The meta object literal for the '<em><b>Target Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDIFF_MISMATCH__TARGET_TYPE = eINSTANCE.getEDiffMismatch_TargetType();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.variant.compare.cmodel.impl.ECheckableElementImpl <em>ECheckable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.compare.cmodel.impl.ECheckableElementImpl
		 * @see com.nokia.tools.variant.compare.cmodel.impl.ECompareModelPackageImpl#getECheckableElement()
		 * @generated
		 */
		EClass ECHECKABLE_ELEMENT = eINSTANCE.getECheckableElement();

		/**
		 * The meta object literal for the '<em><b>Checked</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECHECKABLE_ELEMENT__CHECKED = eINSTANCE.getECheckableElement_Checked();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.variant.compare.cmodel.impl.EDiffSequenceItemImpl <em>EDiff Sequence Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.compare.cmodel.impl.EDiffSequenceItemImpl
		 * @see com.nokia.tools.variant.compare.cmodel.impl.ECompareModelPackageImpl#getEDiffSequenceItem()
		 * @generated
		 */
		EClass EDIFF_SEQUENCE_ITEM = eINSTANCE.getEDiffSequenceItem();

	}

} //ECompareModelPackage
