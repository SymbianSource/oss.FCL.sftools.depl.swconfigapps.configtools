/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.nokia.tools.carbide.ct.ui.overview;

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
 * @see com.nokia.tools.carbide.ct.ui.overview.OverviewFactory
 * @model kind="package"
 * @generated
 */
public interface OverviewPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "overview";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.s60.com/overview";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ov";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OverviewPackage eINSTANCE = com.nokia.tools.carbide.ct.ui.overview.impl.OverviewPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.ui.overview.impl.LineNumberContainerImpl <em>Line Number Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.ui.overview.impl.LineNumberContainerImpl
	 * @see com.nokia.tools.carbide.ct.ui.overview.impl.OverviewPackageImpl#getLineNumberContainer()
	 * @generated
	 */
	int LINE_NUMBER_CONTAINER = 7;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_NUMBER_CONTAINER__LINE_NUMBER = 0;

	/**
	 * The number of structural features of the '<em>Line Number Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_NUMBER_CONTAINER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.ui.overview.impl.ConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.ui.overview.impl.ConfigurationImpl
	 * @see com.nokia.tools.carbide.ct.ui.overview.impl.OverviewPackageImpl#getConfiguration()
	 * @generated
	 */
	int CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__LINE_NUMBER = LINE_NUMBER_CONTAINER__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__FEATURES = LINE_NUMBER_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__NAME = LINE_NUMBER_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__VERSION = LINE_NUMBER_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__DESCRIPTION = LINE_NUMBER_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FEATURE_COUNT = LINE_NUMBER_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.ui.overview.impl.FeatureImpl <em>Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.ui.overview.impl.FeatureImpl
	 * @see com.nokia.tools.carbide.ct.ui.overview.impl.OverviewPackageImpl#getFeature()
	 * @generated
	 */
	int FEATURE = 1;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__LINE_NUMBER = LINE_NUMBER_CONTAINER__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__SETTINGS = LINE_NUMBER_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__REF = LINE_NUMBER_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__NAME = LINE_NUMBER_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_FEATURE_COUNT = LINE_NUMBER_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.ui.overview.impl.SettingImpl <em>Setting</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.ui.overview.impl.SettingImpl
	 * @see com.nokia.tools.carbide.ct.ui.overview.impl.OverviewPackageImpl#getSetting()
	 * @generated
	 */
	int SETTING = 2;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__LINE_NUMBER = LINE_NUMBER_CONTAINER__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__REF = LINE_NUMBER_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__NAME = LINE_NUMBER_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Setting</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING_FEATURE_COUNT = LINE_NUMBER_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.ui.overview.impl.SimpleSettingImpl <em>Simple Setting</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.ui.overview.impl.SimpleSettingImpl
	 * @see com.nokia.tools.carbide.ct.ui.overview.impl.OverviewPackageImpl#getSimpleSetting()
	 * @generated
	 */
	int SIMPLE_SETTING = 3;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__LINE_NUMBER = SETTING__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__REF = SETTING__REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__NAME = SETTING__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__TYPE = SETTING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING__VALUE = SETTING_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Simple Setting</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SETTING_FEATURE_COUNT = SETTING_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.ui.overview.impl.SequenceSettingImpl <em>Sequence Setting</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.ui.overview.impl.SequenceSettingImpl
	 * @see com.nokia.tools.carbide.ct.ui.overview.impl.OverviewPackageImpl#getSequenceSetting()
	 * @generated
	 */
	int SEQUENCE_SETTING = 4;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING__LINE_NUMBER = SETTING__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING__REF = SETTING__REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING__NAME = SETTING__NAME;

	/**
	 * The feature id for the '<em><b>Sub Settings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING__SUB_SETTINGS = SETTING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING__VALUES = SETTING_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sequence Setting</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_SETTING_FEATURE_COUNT = SETTING_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.ui.overview.impl.SequenceValueItemImpl <em>Sequence Value Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.ui.overview.impl.SequenceValueItemImpl
	 * @see com.nokia.tools.carbide.ct.ui.overview.impl.OverviewPackageImpl#getSequenceValueItem()
	 * @generated
	 */
	int SEQUENCE_VALUE_ITEM = 5;

	/**
	 * The feature id for the '<em><b>Sub Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_VALUE_ITEM__SUB_VALUES = 0;

	/**
	 * The number of structural features of the '<em>Sequence Value Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_VALUE_ITEM_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.carbide.ct.ui.overview.impl.SimpleValueImpl <em>Simple Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.carbide.ct.ui.overview.impl.SimpleValueImpl
	 * @see com.nokia.tools.carbide.ct.ui.overview.impl.OverviewPackageImpl#getSimpleValue()
	 * @generated
	 */
	int SIMPLE_VALUE = 6;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_VALUE__LINE_NUMBER = LINE_NUMBER_CONTAINER__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_VALUE__VALUE = LINE_NUMBER_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_VALUE__TYPE = LINE_NUMBER_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Simple Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_VALUE_FEATURE_COUNT = LINE_NUMBER_CONTAINER_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.ui.overview.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see com.nokia.tools.carbide.ct.ui.overview.Configuration
	 * @generated
	 */
	EClass getConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.ui.overview.Configuration#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Features</em>'.
	 * @see com.nokia.tools.carbide.ct.ui.overview.Configuration#getFeatures()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_Features();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.ui.overview.Configuration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.carbide.ct.ui.overview.Configuration#getName()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.ui.overview.Configuration#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see com.nokia.tools.carbide.ct.ui.overview.Configuration#getVersion()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Version();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.ui.overview.Configuration#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.nokia.tools.carbide.ct.ui.overview.Configuration#getDescription()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Description();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.ui.overview.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature</em>'.
	 * @see com.nokia.tools.carbide.ct.ui.overview.Feature
	 * @generated
	 */
	EClass getFeature();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.ui.overview.Feature#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Settings</em>'.
	 * @see com.nokia.tools.carbide.ct.ui.overview.Feature#getSettings()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_Settings();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.ui.overview.Feature#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ref</em>'.
	 * @see com.nokia.tools.carbide.ct.ui.overview.Feature#getRef()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Ref();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.ui.overview.Feature#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.carbide.ct.ui.overview.Feature#getName()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Name();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.ui.overview.Setting <em>Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Setting</em>'.
	 * @see com.nokia.tools.carbide.ct.ui.overview.Setting
	 * @generated
	 */
	EClass getSetting();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.ui.overview.Setting#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ref</em>'.
	 * @see com.nokia.tools.carbide.ct.ui.overview.Setting#getRef()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_Ref();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.ui.overview.Setting#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.carbide.ct.ui.overview.Setting#getName()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_Name();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.ui.overview.SimpleSetting <em>Simple Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Setting</em>'.
	 * @see com.nokia.tools.carbide.ct.ui.overview.SimpleSetting
	 * @generated
	 */
	EClass getSimpleSetting();

	/**
	 * Returns the meta object for the reference '{@link com.nokia.tools.carbide.ct.ui.overview.SimpleSetting#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see com.nokia.tools.carbide.ct.ui.overview.SimpleSetting#getValue()
	 * @see #getSimpleSetting()
	 * @generated
	 */
	EReference getSimpleSetting_Value();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.ui.overview.SimpleSetting#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.nokia.tools.carbide.ct.ui.overview.SimpleSetting#getType()
	 * @see #getSimpleSetting()
	 * @generated
	 */
	EAttribute getSimpleSetting_Type();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.ui.overview.SequenceSetting <em>Sequence Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence Setting</em>'.
	 * @see com.nokia.tools.carbide.ct.ui.overview.SequenceSetting
	 * @generated
	 */
	EClass getSequenceSetting();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.ui.overview.SequenceSetting#getSubSettings <em>Sub Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Settings</em>'.
	 * @see com.nokia.tools.carbide.ct.ui.overview.SequenceSetting#getSubSettings()
	 * @see #getSequenceSetting()
	 * @generated
	 */
	EReference getSequenceSetting_SubSettings();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.ui.overview.SequenceSetting#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see com.nokia.tools.carbide.ct.ui.overview.SequenceSetting#getValues()
	 * @see #getSequenceSetting()
	 * @generated
	 */
	EReference getSequenceSetting_Values();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.ui.overview.SequenceValueItem <em>Sequence Value Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence Value Item</em>'.
	 * @see com.nokia.tools.carbide.ct.ui.overview.SequenceValueItem
	 * @generated
	 */
	EClass getSequenceValueItem();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.carbide.ct.ui.overview.SequenceValueItem#getSubValues <em>Sub Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Values</em>'.
	 * @see com.nokia.tools.carbide.ct.ui.overview.SequenceValueItem#getSubValues()
	 * @see #getSequenceValueItem()
	 * @generated
	 */
	EReference getSequenceValueItem_SubValues();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.ui.overview.SimpleValue <em>Simple Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Value</em>'.
	 * @see com.nokia.tools.carbide.ct.ui.overview.SimpleValue
	 * @generated
	 */
	EClass getSimpleValue();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.ui.overview.SimpleValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.nokia.tools.carbide.ct.ui.overview.SimpleValue#getValue()
	 * @see #getSimpleValue()
	 * @generated
	 */
	EAttribute getSimpleValue_Value();

	/**
	 * Returns the meta object for the reference '{@link com.nokia.tools.carbide.ct.ui.overview.SimpleValue#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see com.nokia.tools.carbide.ct.ui.overview.SimpleValue#getType()
	 * @see #getSimpleValue()
	 * @generated
	 */
	EReference getSimpleValue_Type();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.carbide.ct.ui.overview.LineNumberContainer <em>Line Number Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Line Number Container</em>'.
	 * @see com.nokia.tools.carbide.ct.ui.overview.LineNumberContainer
	 * @generated
	 */
	EClass getLineNumberContainer();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.carbide.ct.ui.overview.LineNumberContainer#getLineNumber <em>Line Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line Number</em>'.
	 * @see com.nokia.tools.carbide.ct.ui.overview.LineNumberContainer#getLineNumber()
	 * @see #getLineNumberContainer()
	 * @generated
	 */
	EAttribute getLineNumberContainer_LineNumber();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OverviewFactory getOverviewFactory();

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
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.ui.overview.impl.ConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.ui.overview.impl.ConfigurationImpl
		 * @see com.nokia.tools.carbide.ct.ui.overview.impl.OverviewPackageImpl#getConfiguration()
		 * @generated
		 */
		EClass CONFIGURATION = eINSTANCE.getConfiguration();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__FEATURES = eINSTANCE.getConfiguration_Features();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__NAME = eINSTANCE.getConfiguration_Name();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__VERSION = eINSTANCE.getConfiguration_Version();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__DESCRIPTION = eINSTANCE.getConfiguration_Description();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.ui.overview.impl.FeatureImpl <em>Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.ui.overview.impl.FeatureImpl
		 * @see com.nokia.tools.carbide.ct.ui.overview.impl.OverviewPackageImpl#getFeature()
		 * @generated
		 */
		EClass FEATURE = eINSTANCE.getFeature();

		/**
		 * The meta object literal for the '<em><b>Settings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__SETTINGS = eINSTANCE.getFeature_Settings();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__REF = eINSTANCE.getFeature_Ref();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__NAME = eINSTANCE.getFeature_Name();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.ui.overview.impl.SettingImpl <em>Setting</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.ui.overview.impl.SettingImpl
		 * @see com.nokia.tools.carbide.ct.ui.overview.impl.OverviewPackageImpl#getSetting()
		 * @generated
		 */
		EClass SETTING = eINSTANCE.getSetting();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__REF = eINSTANCE.getSetting_Ref();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__NAME = eINSTANCE.getSetting_Name();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.ui.overview.impl.SimpleSettingImpl <em>Simple Setting</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.ui.overview.impl.SimpleSettingImpl
		 * @see com.nokia.tools.carbide.ct.ui.overview.impl.OverviewPackageImpl#getSimpleSetting()
		 * @generated
		 */
		EClass SIMPLE_SETTING = eINSTANCE.getSimpleSetting();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_SETTING__VALUE = eINSTANCE.getSimpleSetting_Value();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_SETTING__TYPE = eINSTANCE.getSimpleSetting_Type();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.ui.overview.impl.SequenceSettingImpl <em>Sequence Setting</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.ui.overview.impl.SequenceSettingImpl
		 * @see com.nokia.tools.carbide.ct.ui.overview.impl.OverviewPackageImpl#getSequenceSetting()
		 * @generated
		 */
		EClass SEQUENCE_SETTING = eINSTANCE.getSequenceSetting();

		/**
		 * The meta object literal for the '<em><b>Sub Settings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE_SETTING__SUB_SETTINGS = eINSTANCE.getSequenceSetting_SubSettings();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE_SETTING__VALUES = eINSTANCE.getSequenceSetting_Values();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.ui.overview.impl.SequenceValueItemImpl <em>Sequence Value Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.ui.overview.impl.SequenceValueItemImpl
		 * @see com.nokia.tools.carbide.ct.ui.overview.impl.OverviewPackageImpl#getSequenceValueItem()
		 * @generated
		 */
		EClass SEQUENCE_VALUE_ITEM = eINSTANCE.getSequenceValueItem();

		/**
		 * The meta object literal for the '<em><b>Sub Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE_VALUE_ITEM__SUB_VALUES = eINSTANCE.getSequenceValueItem_SubValues();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.ui.overview.impl.SimpleValueImpl <em>Simple Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.ui.overview.impl.SimpleValueImpl
		 * @see com.nokia.tools.carbide.ct.ui.overview.impl.OverviewPackageImpl#getSimpleValue()
		 * @generated
		 */
		EClass SIMPLE_VALUE = eINSTANCE.getSimpleValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_VALUE__VALUE = eINSTANCE.getSimpleValue_Value();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_VALUE__TYPE = eINSTANCE.getSimpleValue_Type();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.carbide.ct.ui.overview.impl.LineNumberContainerImpl <em>Line Number Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.carbide.ct.ui.overview.impl.LineNumberContainerImpl
		 * @see com.nokia.tools.carbide.ct.ui.overview.impl.OverviewPackageImpl#getLineNumberContainer()
		 * @generated
		 */
		EClass LINE_NUMBER_CONTAINER = eINSTANCE.getLineNumberContainer();

		/**
		 * The meta object literal for the '<em><b>Line Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINE_NUMBER_CONTAINER__LINE_NUMBER = eINSTANCE.getLineNumberContainer_LineNumber();

	}

} //OverviewPackage
