/*
* Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
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
package configurationemf;

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
 * @see configurationemf.ConfigurationemfFactory
 * @model kind="package"
 * @generated
 */
public interface ConfigurationemfPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "configurationemf";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * Confml namespace
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	String eNS_URI = "http://www.s60.com/xml/confml/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	String eNS_PREFIX = "";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConfigurationemfPackage eINSTANCE = configurationemf.impl.ConfigurationemfPackageImpl.init();

	/**
	 * The meta object id for the '{@link configurationemf.impl.CommonAttrImpl <em>Common Attr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.CommonAttrImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getCommonAttr()
	 * @generated
	 */
	int COMMON_ATTR = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_ATTR__ID = 0;

	/**
	 * The number of structural features of the '<em>Common Attr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_ATTR_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link configurationemf.impl.ConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.ConfigurationImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getConfiguration()
	 * @generated
	 */
	int CONFIGURATION = 0;

	/**
	 * The meta object id for the '{@link configurationemf.impl.AttributeAndDescImpl <em>Attribute And Desc</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.AttributeAndDescImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getAttributeAndDesc()
	 * @generated
	 */
	int ATTRIBUTE_AND_DESC = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_AND_DESC__ID = COMMON_ATTR__ID;

	/**
	 * The feature id for the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_AND_DESC__DESC = COMMON_ATTR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Attribute And Desc</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_AND_DESC_FEATURE_COUNT = COMMON_ATTR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__ID = ATTRIBUTE_AND_DESC__ID;

	/**
	 * The feature id for the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__DESC = ATTRIBUTE_AND_DESC__DESC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__NAME = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Vers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__VERS = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__FEATURE = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>View</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__VIEW = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Meta</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__META = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__ICON = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Link</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__LINK = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__DATA = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__READ_ONLY = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Meta Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__META_ID = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__OWNER = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Editor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__EDITOR = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__STATUS = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__VERSION = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Platform</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__PLATFORM = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Product</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__PRODUCT = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Customer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__CUSTOMER = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__DATE = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Release</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__RELEASE = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 18;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FEATURE_COUNT = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 19;

	/**
	 * The meta object id for the '{@link configurationemf.impl.FeatureImpl <em>Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.FeatureImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getFeature()
	 * @generated
	 */
	int FEATURE = 1;

	/**
	 * The meta object id for the '{@link configurationemf.impl.SettingImpl <em>Setting</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.SettingImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getSetting()
	 * @generated
	 */
	int SETTING = 2;

	/**
	 * The meta object id for the '{@link configurationemf.impl.ViewImpl <em>View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.ViewImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getView()
	 * @generated
	 */
	int VIEW = 4;

	/**
	 * The meta object id for the '{@link configurationemf.impl.GroupImpl <em>Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.GroupImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getGroup()
	 * @generated
	 */
	int GROUP = 5;

	/**
	 * The meta object id for the '{@link configurationemf.impl.OptionImpl <em>Option</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.OptionImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getOption()
	 * @generated
	 */
	int OPTION = 7;

	/**
	 * The meta object id for the '{@link configurationemf.impl.MetaImpl <em>Meta</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.MetaImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getMeta()
	 * @generated
	 */
	int META = 8;

	/**
	 * The meta object id for the '{@link configurationemf.impl.IdentificationImpl <em>Identification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.IdentificationImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getIdentification()
	 * @generated
	 */
	int IDENTIFICATION = 10;

	/**
	 * The meta object id for the '{@link configurationemf.impl.DateImpl <em>Date</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.DateImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getDate()
	 * @generated
	 */
	int DATE = 11;

	/**
	 * The meta object id for the '{@link configurationemf.impl.OwnerImpl <em>Owner</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.OwnerImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getOwner()
	 * @generated
	 */
	int OWNER = 12;

	/**
	 * The meta object id for the '{@link configurationemf.impl.EditorImpl <em>Editor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.EditorImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getEditor()
	 * @generated
	 */
	int EDITOR = 13;

	/**
	 * The meta object id for the '{@link configurationemf.impl.StatusImpl <em>Status</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.StatusImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getStatus()
	 * @generated
	 */
	int STATUS = 14;

	/**
	 * The meta object id for the '{@link configurationemf.impl.VersionImpl <em>Version</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.VersionImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getVersion()
	 * @generated
	 */
	int VERSION = 15;

	/**
	 * The meta object id for the '{@link configurationemf.impl.PlatformImpl <em>Platform</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.PlatformImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getPlatform()
	 * @generated
	 */
	int PLATFORM = 16;

	/**
	 * The meta object id for the '{@link configurationemf.impl.ProductImpl <em>Product</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.ProductImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getProduct()
	 * @generated
	 */
	int PRODUCT = 17;

	/**
	 * The meta object id for the '{@link configurationemf.impl.ReleaseImpl <em>Release</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.ReleaseImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getRelease()
	 * @generated
	 */
	int RELEASE = 9;

	/**
	 * The meta object id for the '{@link configurationemf.impl.CustomerImpl <em>Customer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.CustomerImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getCustomer()
	 * @generated
	 */
	int CUSTOMER = 18;

	/**
	 * The meta object id for the '{@link configurationemf.impl.GSettingImpl <em>GSetting</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.GSettingImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getGSetting()
	 * @generated
	 */
	int GSETTING = 19;

	/**
	 * The meta object id for the '{@link configurationemf.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.PropertyImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 20;

	/**
	 * The meta object id for the '{@link configurationemf.impl.PatternImpl <em>Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.PatternImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getPattern()
	 * @generated
	 */
	int PATTERN = 21;

	/**
	 * The meta object id for the '{@link configurationemf.impl.LengthImpl <em>Length</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.LengthImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getLength()
	 * @generated
	 */
	int LENGTH = 22;

	/**
	 * The meta object id for the '{@link configurationemf.impl.MaxLengthImpl <em>Max Length</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.MaxLengthImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getMaxLength()
	 * @generated
	 */
	int MAX_LENGTH = 23;

	/**
	 * The meta object id for the '{@link configurationemf.impl.MinLengthImpl <em>Min Length</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.MinLengthImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getMinLength()
	 * @generated
	 */
	int MIN_LENGTH = 24;

	/**
	 * The meta object id for the '{@link configurationemf.impl.MaxExclusiveImpl <em>Max Exclusive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.MaxExclusiveImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getMaxExclusive()
	 * @generated
	 */
	int MAX_EXCLUSIVE = 25;

	/**
	 * The meta object id for the '{@link configurationemf.impl.MaxInclusiveImpl <em>Max Inclusive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.MaxInclusiveImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getMaxInclusive()
	 * @generated
	 */
	int MAX_INCLUSIVE = 26;

	/**
	 * The meta object id for the '{@link configurationemf.impl.MinInclusiveImpl <em>Min Inclusive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.MinInclusiveImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getMinInclusive()
	 * @generated
	 */
	int MIN_INCLUSIVE = 27;

	/**
	 * The meta object id for the '{@link configurationemf.impl.MinExclusiveImpl <em>Min Exclusive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.MinExclusiveImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getMinExclusive()
	 * @generated
	 */
	int MIN_EXCLUSIVE = 28;

	/**
	 * The meta object id for the '{@link configurationemf.impl.TotalDigitsImpl <em>Total Digits</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.TotalDigitsImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getTotalDigits()
	 * @generated
	 */
	int TOTAL_DIGITS = 29;

	/**
	 * The meta object id for the '{@link configurationemf.impl.LeafSettingImpl <em>Leaf Setting</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.LeafSettingImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getLeafSetting()
	 * @generated
	 */
	int LEAF_SETTING = 30;

	/**
	 * The meta object id for the '{@link configurationemf.impl.ParentSettingImpl <em>Parent Setting</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.ParentSettingImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getParentSetting()
	 * @generated
	 */
	int PARENT_SETTING = 31;

	/**
	 * The meta object id for the '{@link configurationemf.impl.LeafGroupImpl <em>Leaf Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.LeafGroupImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getLeafGroup()
	 * @generated
	 */
	int LEAF_GROUP = 32;

	/**
	 * The meta object id for the '{@link configurationemf.impl.ParentGroupImpl <em>Parent Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.ParentGroupImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getParentGroup()
	 * @generated
	 */
	int PARENT_GROUP = 33;

	/**
	 * The meta object id for the '{@link configurationemf.impl.ContentImpl <em>Content</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.ContentImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getContent()
	 * @generated
	 */
	int CONTENT = 34;

	/**
	 * The meta object id for the '{@link configurationemf.impl.DILImpl <em>DIL</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.DILImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getDIL()
	 * @generated
	 */
	int DIL = 37;

	/**
	 * The meta object id for the '{@link configurationemf.impl.IconImpl <em>Icon</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.IconImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getIcon()
	 * @generated
	 */
	int ICON = 35;

	/**
	 * The meta object id for the '{@link configurationemf.impl.LinkImpl <em>Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.LinkImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getLink()
	 * @generated
	 */
	int LINK = 36;

	/**
	 * The meta object id for the '{@link configurationemf.impl.RootConfImpl <em>Root Conf</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.RootConfImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getRootConf()
	 * @generated
	 */
	int ROOT_CONF = 38;

	
	/**
	 * The meta object id for the '{@link configurationemf.impl.SubConfImpl <em>Sub Conf</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.SubConfImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getSubConf()
	 * @generated
	 */
	int SUB_CONF = 39;

	/**
	 * The meta object id for the '{@link configurationemf.impl.DataImpl <em>Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.DataImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getData()
	 * @generated
	 */
	int DATA = 40;

	/**
	 * The meta object id for the '{@link configurationemf.impl.RefImpl <em>Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.RefImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getRef()
	 * @generated
	 */
	int REF = 42;

	/**
	 * The meta object id for the '{@link configurationemf.impl.ReferableImpl <em>Referable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.ReferableImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getReferable()
	 * @generated
	 */
	int REFERABLE = 43;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERABLE__ID = ATTRIBUTE_AND_DESC__ID;

	/**
	 * The feature id for the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERABLE__DESC = ATTRIBUTE_AND_DESC__DESC;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERABLE__REF = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERABLE__REFS = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Rfs Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERABLE__RFS_REFS = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Referable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERABLE_FEATURE_COUNT = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__ID = REFERABLE__ID;

	/**
	 * The feature id for the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__DESC = REFERABLE__DESC;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__REF = REFERABLE__REF;

	/**
	 * The feature id for the '<em><b>Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__REFS = REFERABLE__REFS;

	/**
	 * The feature id for the '<em><b>Rfs Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__RFS_REFS = REFERABLE__RFS_REFS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__NAME = REFERABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__RELEVANT = REFERABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Conf</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__CONF = REFERABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Parent Setting</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__PARENT_SETTING = REFERABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Link</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__LINK = REFERABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__ICON = REFERABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__READ_ONLY = REFERABLE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_FEATURE_COUNT = REFERABLE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__ID = REFERABLE__ID;

	/**
	 * The feature id for the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__DESC = REFERABLE__DESC;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__REF = REFERABLE__REF;

	/**
	 * The feature id for the '<em><b>Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__REFS = REFERABLE__REFS;

	/**
	 * The feature id for the '<em><b>Rfs Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__RFS_REFS = REFERABLE__RFS_REFS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__NAME = REFERABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__TYPE = REFERABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__CONSTRAINT = REFERABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__RELEVANT = REFERABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__READ_ONLY = REFERABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__REQUIRED = REFERABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Option</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__OPTION = REFERABLE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__PROPERTY = REFERABLE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Min Length</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__MIN_LENGTH = REFERABLE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Max Length</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__MAX_LENGTH = REFERABLE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Length</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__LENGTH = REFERABLE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Max Inclusive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__MAX_INCLUSIVE = REFERABLE_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Max Exclusive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__MAX_EXCLUSIVE = REFERABLE_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Min Exclusive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__MIN_EXCLUSIVE = REFERABLE_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__PATTERN = REFERABLE_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Min Inclusive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__MIN_INCLUSIVE = REFERABLE_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Total Digits</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__TOTAL_DIGITS = REFERABLE_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Link</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__LINK = REFERABLE_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__ICON = REFERABLE_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Bool Options</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__BOOL_OPTIONS = REFERABLE_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__DEFAULT_VALUE = REFERABLE_FEATURE_COUNT + 20;

	/**
	 * The feature id for the '<em><b>Current Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__CURRENT_VALUE = REFERABLE_FEATURE_COUNT + 21;

	/**
	 * The feature id for the '<em><b>Top Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__TOP_VALUE = REFERABLE_FEATURE_COUNT + 22;

	/**
	 * The feature id for the '<em><b>Current Conf</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__CURRENT_CONF = REFERABLE_FEATURE_COUNT + 23;

	/**
	 * The feature id for the '<em><b>Default Conf</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__DEFAULT_CONF = REFERABLE_FEATURE_COUNT + 24;

	/**
	 * The feature id for the '<em><b>Ro</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__RO = REFERABLE_FEATURE_COUNT + 25;

	/**
	 * The feature id for the '<em><b>Possible Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__POSSIBLE_VALUE = REFERABLE_FEATURE_COUNT + 26;

	/**
	 * The feature id for the '<em><b>Current Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__CURRENT_TYPE = REFERABLE_FEATURE_COUNT + 27;

	/**
	 * The feature id for the '<em><b>Value Changeble</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__VALUE_CHANGEBLE = REFERABLE_FEATURE_COUNT + 28;

	/**
	 * The feature id for the '<em><b>Rfs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING__RFS = REFERABLE_FEATURE_COUNT + 29;

	/**
	 * The number of structural features of the '<em>Setting</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTING_FEATURE_COUNT = REFERABLE_FEATURE_COUNT + 30;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__ID = ATTRIBUTE_AND_DESC__ID;

	/**
	 * The feature id for the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__DESC = ATTRIBUTE_AND_DESC__DESC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__NAME = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Conf</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__CONF = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Meta</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__META = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Parent Group</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__PARENT_GROUP = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Link</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__LINK = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__ICON = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__READ_ONLY = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_FEATURE_COUNT = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__ID = ATTRIBUTE_AND_DESC__ID;

	/**
	 * The feature id for the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__DESC = ATTRIBUTE_AND_DESC__DESC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__NAME = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>GSetting</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__GSETTING = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__READ_ONLY = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__ICON = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_FEATURE_COUNT = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__ID = ATTRIBUTE_AND_DESC__ID;

	/**
	 * The feature id for the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__DESC = ATTRIBUTE_AND_DESC__DESC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__NAME = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__RELEVANT = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__VALUE = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Link</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__LINK = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__ICON = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__READ_ONLY = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Option</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION_FEATURE_COUNT = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META__ID = COMMON_ATTR__ID;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META__IDENTIFICATION = COMMON_ATTR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META__OWNER = COMMON_ATTR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Editor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META__EDITOR = COMMON_ATTR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Status</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META__STATUS = COMMON_ATTR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Version</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META__VERSION = COMMON_ATTR_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Platform</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META__PLATFORM = COMMON_ATTR_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Product</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META__PRODUCT = COMMON_ATTR_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Customer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META__CUSTOMER = COMMON_ATTR_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Date</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META__DATE = COMMON_ATTR_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Release</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META__RELEASE = COMMON_ATTR_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Meta</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_FEATURE_COUNT = COMMON_ATTR_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT__VALUE = 0;

	/**
	 * The number of structural features of the '<em>Content</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link configurationemf.impl.RfsImpl <em>Rfs</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.RfsImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getRfs()
	 * @generated
	 */
	int RFS = 41;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__VALUE = CONTENT__VALUE;

	/**
	 * The number of structural features of the '<em>Release</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFICATION__VALUE = CONTENT__VALUE;

	/**
	 * The number of structural features of the '<em>Identification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFICATION_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE__VALUE = CONTENT__VALUE;

	/**
	 * The number of structural features of the '<em>Date</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OWNER__VALUE = CONTENT__VALUE;

	/**
	 * The number of structural features of the '<em>Owner</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OWNER_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR__VALUE = CONTENT__VALUE;

	/**
	 * The number of structural features of the '<em>Editor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS__VALUE = CONTENT__VALUE;

	/**
	 * The number of structural features of the '<em>Status</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__VALUE = CONTENT__VALUE;

	/**
	 * The number of structural features of the '<em>Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM__VALUE = CONTENT__VALUE;

	/**
	 * The number of structural features of the '<em>Platform</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT__VALUE = CONTENT__VALUE;

	/**
	 * The number of structural features of the '<em>Product</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__VALUE = CONTENT__VALUE;

	/**
	 * The number of structural features of the '<em>Customer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__ID = SETTING__ID;

	/**
	 * The feature id for the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__DESC = SETTING__DESC;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__REF = SETTING__REF;

	/**
	 * The feature id for the '<em><b>Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__REFS = SETTING__REFS;

	/**
	 * The feature id for the '<em><b>Rfs Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__RFS_REFS = SETTING__RFS_REFS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__NAME = SETTING__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__TYPE = SETTING__TYPE;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__CONSTRAINT = SETTING__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__RELEVANT = SETTING__RELEVANT;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__READ_ONLY = SETTING__READ_ONLY;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__REQUIRED = SETTING__REQUIRED;

	/**
	 * The feature id for the '<em><b>Option</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__OPTION = SETTING__OPTION;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__PROPERTY = SETTING__PROPERTY;

	/**
	 * The feature id for the '<em><b>Min Length</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__MIN_LENGTH = SETTING__MIN_LENGTH;

	/**
	 * The feature id for the '<em><b>Max Length</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__MAX_LENGTH = SETTING__MAX_LENGTH;

	/**
	 * The feature id for the '<em><b>Length</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__LENGTH = SETTING__LENGTH;

	/**
	 * The feature id for the '<em><b>Max Inclusive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__MAX_INCLUSIVE = SETTING__MAX_INCLUSIVE;

	/**
	 * The feature id for the '<em><b>Max Exclusive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__MAX_EXCLUSIVE = SETTING__MAX_EXCLUSIVE;

	/**
	 * The feature id for the '<em><b>Min Exclusive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__MIN_EXCLUSIVE = SETTING__MIN_EXCLUSIVE;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__PATTERN = SETTING__PATTERN;

	/**
	 * The feature id for the '<em><b>Min Inclusive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__MIN_INCLUSIVE = SETTING__MIN_INCLUSIVE;

	/**
	 * The feature id for the '<em><b>Total Digits</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__TOTAL_DIGITS = SETTING__TOTAL_DIGITS;

	/**
	 * The feature id for the '<em><b>Link</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__LINK = SETTING__LINK;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__ICON = SETTING__ICON;

	/**
	 * The feature id for the '<em><b>Bool Options</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__BOOL_OPTIONS = SETTING__BOOL_OPTIONS;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__DEFAULT_VALUE = SETTING__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Current Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__CURRENT_VALUE = SETTING__CURRENT_VALUE;

	/**
	 * The feature id for the '<em><b>Top Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__TOP_VALUE = SETTING__TOP_VALUE;

	/**
	 * The feature id for the '<em><b>Current Conf</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__CURRENT_CONF = SETTING__CURRENT_CONF;

	/**
	 * The feature id for the '<em><b>Default Conf</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__DEFAULT_CONF = SETTING__DEFAULT_CONF;

	/**
	 * The feature id for the '<em><b>Ro</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__RO = SETTING__RO;

	/**
	 * The feature id for the '<em><b>Possible Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__POSSIBLE_VALUE = SETTING__POSSIBLE_VALUE;

	/**
	 * The feature id for the '<em><b>Current Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__CURRENT_TYPE = SETTING__CURRENT_TYPE;

	/**
	 * The feature id for the '<em><b>Value Changeble</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__VALUE_CHANGEBLE = SETTING__VALUE_CHANGEBLE;

	/**
	 * The feature id for the '<em><b>Rfs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__RFS = SETTING__RFS;

	/**
	 * The feature id for the '<em><b>Leaf Setting</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__LEAF_SETTING = SETTING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Frames</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__FRAMES = SETTING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Template</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__TEMPLATE = SETTING_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Current Extension Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__CURRENT_EXTENSION_POLICY = SETTING_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Min Occurs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__MIN_OCCURS = SETTING_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Max Occurs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING__MAX_OCCURS = SETTING_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Parent Setting</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_SETTING_FEATURE_COUNT = SETTING_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__ID = PARENT_SETTING__ID;

	/**
	 * The feature id for the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__DESC = PARENT_SETTING__DESC;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__REF = PARENT_SETTING__REF;

	/**
	 * The feature id for the '<em><b>Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__REFS = PARENT_SETTING__REFS;

	/**
	 * The feature id for the '<em><b>Rfs Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__RFS_REFS = PARENT_SETTING__RFS_REFS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__NAME = PARENT_SETTING__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__TYPE = PARENT_SETTING__TYPE;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__CONSTRAINT = PARENT_SETTING__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__RELEVANT = PARENT_SETTING__RELEVANT;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__READ_ONLY = PARENT_SETTING__READ_ONLY;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__REQUIRED = PARENT_SETTING__REQUIRED;

	/**
	 * The feature id for the '<em><b>Option</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__OPTION = PARENT_SETTING__OPTION;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__PROPERTY = PARENT_SETTING__PROPERTY;

	/**
	 * The feature id for the '<em><b>Min Length</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__MIN_LENGTH = PARENT_SETTING__MIN_LENGTH;

	/**
	 * The feature id for the '<em><b>Max Length</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__MAX_LENGTH = PARENT_SETTING__MAX_LENGTH;

	/**
	 * The feature id for the '<em><b>Length</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__LENGTH = PARENT_SETTING__LENGTH;

	/**
	 * The feature id for the '<em><b>Max Inclusive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__MAX_INCLUSIVE = PARENT_SETTING__MAX_INCLUSIVE;

	/**
	 * The feature id for the '<em><b>Max Exclusive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__MAX_EXCLUSIVE = PARENT_SETTING__MAX_EXCLUSIVE;

	/**
	 * The feature id for the '<em><b>Min Exclusive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__MIN_EXCLUSIVE = PARENT_SETTING__MIN_EXCLUSIVE;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__PATTERN = PARENT_SETTING__PATTERN;

	/**
	 * The feature id for the '<em><b>Min Inclusive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__MIN_INCLUSIVE = PARENT_SETTING__MIN_INCLUSIVE;

	/**
	 * The feature id for the '<em><b>Total Digits</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__TOTAL_DIGITS = PARENT_SETTING__TOTAL_DIGITS;

	/**
	 * The feature id for the '<em><b>Link</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__LINK = PARENT_SETTING__LINK;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__ICON = PARENT_SETTING__ICON;

	/**
	 * The feature id for the '<em><b>Bool Options</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__BOOL_OPTIONS = PARENT_SETTING__BOOL_OPTIONS;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__DEFAULT_VALUE = PARENT_SETTING__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Current Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__CURRENT_VALUE = PARENT_SETTING__CURRENT_VALUE;

	/**
	 * The feature id for the '<em><b>Top Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__TOP_VALUE = PARENT_SETTING__TOP_VALUE;

	/**
	 * The feature id for the '<em><b>Current Conf</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__CURRENT_CONF = PARENT_SETTING__CURRENT_CONF;

	/**
	 * The feature id for the '<em><b>Default Conf</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__DEFAULT_CONF = PARENT_SETTING__DEFAULT_CONF;

	/**
	 * The feature id for the '<em><b>Ro</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__RO = PARENT_SETTING__RO;

	/**
	 * The feature id for the '<em><b>Possible Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__POSSIBLE_VALUE = PARENT_SETTING__POSSIBLE_VALUE;

	/**
	 * The feature id for the '<em><b>Current Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__CURRENT_TYPE = PARENT_SETTING__CURRENT_TYPE;

	/**
	 * The feature id for the '<em><b>Value Changeble</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__VALUE_CHANGEBLE = PARENT_SETTING__VALUE_CHANGEBLE;

	/**
	 * The feature id for the '<em><b>Rfs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__RFS = PARENT_SETTING__RFS;

	/**
	 * The feature id for the '<em><b>Leaf Setting</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__LEAF_SETTING = PARENT_SETTING__LEAF_SETTING;

	/**
	 * The feature id for the '<em><b>Frames</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__FRAMES = PARENT_SETTING__FRAMES;

	/**
	 * The feature id for the '<em><b>Template</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__TEMPLATE = PARENT_SETTING__TEMPLATE;

	/**
	 * The feature id for the '<em><b>Current Extension Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__CURRENT_EXTENSION_POLICY = PARENT_SETTING__CURRENT_EXTENSION_POLICY;

	/**
	 * The feature id for the '<em><b>Min Occurs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__MIN_OCCURS = PARENT_SETTING__MIN_OCCURS;

	/**
	 * The feature id for the '<em><b>Max Occurs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING__MAX_OCCURS = PARENT_SETTING__MAX_OCCURS;

	/**
	 * The number of structural features of the '<em>GSetting</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSETTING_FEATURE_COUNT = PARENT_SETTING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__ID = ATTRIBUTE_AND_DESC__ID;

	/**
	 * The feature id for the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__DESC = ATTRIBUTE_AND_DESC__DESC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__NAME = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__VALUE = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__UNIT = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = ATTRIBUTE_AND_DESC_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__VALUE = 0;

	/**
	 * The number of structural features of the '<em>Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LENGTH__VALUE = 0;

	/**
	 * The number of structural features of the '<em>Length</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LENGTH_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAX_LENGTH__VALUE = 0;

	/**
	 * The number of structural features of the '<em>Max Length</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAX_LENGTH_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIN_LENGTH__VALUE = 0;

	/**
	 * The number of structural features of the '<em>Min Length</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIN_LENGTH_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAX_EXCLUSIVE__VALUE = 0;

	/**
	 * The number of structural features of the '<em>Max Exclusive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAX_EXCLUSIVE_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAX_INCLUSIVE__VALUE = 0;

	/**
	 * The number of structural features of the '<em>Max Inclusive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAX_INCLUSIVE_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIN_INCLUSIVE__VALUE = 0;

	/**
	 * The number of structural features of the '<em>Min Inclusive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIN_INCLUSIVE_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIN_EXCLUSIVE__VALUE = 0;

	/**
	 * The number of structural features of the '<em>Min Exclusive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIN_EXCLUSIVE_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOTAL_DIGITS__VALUE = 0;

	/**
	 * The number of structural features of the '<em>Total Digits</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOTAL_DIGITS_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING__ID = SETTING__ID;

	/**
	 * The feature id for the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING__DESC = SETTING__DESC;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING__REF = SETTING__REF;

	/**
	 * The feature id for the '<em><b>Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING__REFS = SETTING__REFS;

	/**
	 * The feature id for the '<em><b>Rfs Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING__RFS_REFS = SETTING__RFS_REFS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING__NAME = SETTING__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING__TYPE = SETTING__TYPE;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING__CONSTRAINT = SETTING__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Relevant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING__RELEVANT = SETTING__RELEVANT;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING__READ_ONLY = SETTING__READ_ONLY;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING__REQUIRED = SETTING__REQUIRED;

	/**
	 * The feature id for the '<em><b>Option</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING__OPTION = SETTING__OPTION;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING__PROPERTY = SETTING__PROPERTY;

	/**
	 * The feature id for the '<em><b>Min Length</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING__MIN_LENGTH = SETTING__MIN_LENGTH;

	/**
	 * The feature id for the '<em><b>Max Length</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING__MAX_LENGTH = SETTING__MAX_LENGTH;

	/**
	 * The feature id for the '<em><b>Length</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING__LENGTH = SETTING__LENGTH;

	/**
	 * The feature id for the '<em><b>Max Inclusive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING__MAX_INCLUSIVE = SETTING__MAX_INCLUSIVE;

	/**
	 * The feature id for the '<em><b>Max Exclusive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING__MAX_EXCLUSIVE = SETTING__MAX_EXCLUSIVE;

	/**
	 * The feature id for the '<em><b>Min Exclusive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING__MIN_EXCLUSIVE = SETTING__MIN_EXCLUSIVE;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING__PATTERN = SETTING__PATTERN;

	/**
	 * The feature id for the '<em><b>Min Inclusive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING__MIN_INCLUSIVE = SETTING__MIN_INCLUSIVE;

	/**
	 * The feature id for the '<em><b>Total Digits</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING__TOTAL_DIGITS = SETTING__TOTAL_DIGITS;

	/**
	 * The feature id for the '<em><b>Link</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING__LINK = SETTING__LINK;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING__ICON = SETTING__ICON;

	/**
	 * The feature id for the '<em><b>Bool Options</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING__BOOL_OPTIONS = SETTING__BOOL_OPTIONS;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING__DEFAULT_VALUE = SETTING__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Current Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING__CURRENT_VALUE = SETTING__CURRENT_VALUE;

	/**
	 * The feature id for the '<em><b>Top Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING__TOP_VALUE = SETTING__TOP_VALUE;

	/**
	 * The feature id for the '<em><b>Current Conf</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING__CURRENT_CONF = SETTING__CURRENT_CONF;

	/**
	 * The feature id for the '<em><b>Default Conf</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING__DEFAULT_CONF = SETTING__DEFAULT_CONF;

	/**
	 * The feature id for the '<em><b>Ro</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING__RO = SETTING__RO;

	/**
	 * The feature id for the '<em><b>Possible Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING__POSSIBLE_VALUE = SETTING__POSSIBLE_VALUE;

	/**
	 * The feature id for the '<em><b>Current Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING__CURRENT_TYPE = SETTING__CURRENT_TYPE;

	/**
	 * The feature id for the '<em><b>Value Changeble</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING__VALUE_CHANGEBLE = SETTING__VALUE_CHANGEBLE;

	/**
	 * The feature id for the '<em><b>Rfs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING__RFS = SETTING__RFS;

	/**
	 * The number of structural features of the '<em>Leaf Setting</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING_FEATURE_COUNT = SETTING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_GROUP__ID = GROUP__ID;

	/**
	 * The feature id for the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_GROUP__DESC = GROUP__DESC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_GROUP__NAME = GROUP__NAME;

	/**
	 * The feature id for the '<em><b>GSetting</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_GROUP__GSETTING = GROUP__GSETTING;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_GROUP__READ_ONLY = GROUP__READ_ONLY;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_GROUP__ICON = GROUP__ICON;

	/**
	 * The number of structural features of the '<em>Leaf Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_GROUP_FEATURE_COUNT = GROUP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_GROUP__ID = GROUP__ID;

	/**
	 * The feature id for the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_GROUP__DESC = GROUP__DESC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_GROUP__NAME = GROUP__NAME;

	/**
	 * The feature id for the '<em><b>GSetting</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_GROUP__GSETTING = GROUP__GSETTING;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_GROUP__READ_ONLY = GROUP__READ_ONLY;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_GROUP__ICON = GROUP__ICON;

	/**
	 * The feature id for the '<em><b>Leaf Group</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_GROUP__LEAF_GROUP = GROUP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parent Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_GROUP_FEATURE_COUNT = GROUP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Href</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIL__HREF = 0;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIL__TITLE = 1;

	/**
	 * The number of structural features of the '<em>DIL</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIL_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Href</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICON__HREF = DIL__HREF;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICON__TITLE = DIL__TITLE;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICON__ID = DIL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Icon</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICON_FEATURE_COUNT = DIL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Href</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__HREF = DIL__HREF;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__TITLE = DIL__TITLE;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__ID = DIL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FEATURE_COUNT = DIL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONF__ID = CONFIGURATION__ID;

	/**
	 * The feature id for the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONF__DESC = CONFIGURATION__DESC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONF__NAME = CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Vers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONF__VERS = CONFIGURATION__VERS;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONF__FEATURE = CONFIGURATION__FEATURE;

	/**
	 * The feature id for the '<em><b>View</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONF__VIEW = CONFIGURATION__VIEW;

	/**
	 * The feature id for the '<em><b>Meta</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONF__META = CONFIGURATION__META;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONF__ICON = CONFIGURATION__ICON;

	/**
	 * The feature id for the '<em><b>Link</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONF__LINK = CONFIGURATION__LINK;

	/**
	 * The feature id for the '<em><b>Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONF__DATA = CONFIGURATION__DATA;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONF__READ_ONLY = CONFIGURATION__READ_ONLY;

	/**
	 * The feature id for the '<em><b>Meta Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONF__META_ID = CONFIGURATION__META_ID;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONF__OWNER = CONFIGURATION__OWNER;

	/**
	 * The feature id for the '<em><b>Editor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONF__EDITOR = CONFIGURATION__EDITOR;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONF__STATUS = CONFIGURATION__STATUS;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONF__VERSION = CONFIGURATION__VERSION;

	/**
	 * The feature id for the '<em><b>Platform</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONF__PLATFORM = CONFIGURATION__PLATFORM;

	/**
	 * The feature id for the '<em><b>Product</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONF__PRODUCT = CONFIGURATION__PRODUCT;

	/**
	 * The feature id for the '<em><b>Customer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONF__CUSTOMER = CONFIGURATION__CUSTOMER;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONF__DATE = CONFIGURATION__DATE;

	/**
	 * The feature id for the '<em><b>Release</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONF__RELEASE = CONFIGURATION__RELEASE;

	/**
	 * The feature id for the '<em><b>Sub Conf</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONF__SUB_CONF = CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Include</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONF__INCLUDE = CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONF__ROOT = CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Rfs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONF__RFS = CONFIGURATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Root Conf</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CONF_FEATURE_COUNT = CONFIGURATION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONF__ID = CONFIGURATION__ID;

	/**
	 * The feature id for the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONF__DESC = CONFIGURATION__DESC;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONF__NAME = CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Vers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONF__VERS = CONFIGURATION__VERS;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONF__FEATURE = CONFIGURATION__FEATURE;

	/**
	 * The feature id for the '<em><b>View</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONF__VIEW = CONFIGURATION__VIEW;

	/**
	 * The feature id for the '<em><b>Meta</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONF__META = CONFIGURATION__META;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONF__ICON = CONFIGURATION__ICON;

	/**
	 * The feature id for the '<em><b>Link</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONF__LINK = CONFIGURATION__LINK;

	/**
	 * The feature id for the '<em><b>Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONF__DATA = CONFIGURATION__DATA;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONF__READ_ONLY = CONFIGURATION__READ_ONLY;

	/**
	 * The feature id for the '<em><b>Meta Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONF__META_ID = CONFIGURATION__META_ID;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONF__OWNER = CONFIGURATION__OWNER;

	/**
	 * The feature id for the '<em><b>Editor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONF__EDITOR = CONFIGURATION__EDITOR;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONF__STATUS = CONFIGURATION__STATUS;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONF__VERSION = CONFIGURATION__VERSION;

	/**
	 * The feature id for the '<em><b>Platform</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONF__PLATFORM = CONFIGURATION__PLATFORM;

	/**
	 * The feature id for the '<em><b>Product</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONF__PRODUCT = CONFIGURATION__PRODUCT;

	/**
	 * The feature id for the '<em><b>Customer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONF__CUSTOMER = CONFIGURATION__CUSTOMER;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONF__DATE = CONFIGURATION__DATE;

	/**
	 * The feature id for the '<em><b>Release</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONF__RELEASE = CONFIGURATION__RELEASE;

	/**
	 * The number of structural features of the '<em>Sub Conf</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONF_FEATURE_COUNT = CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA__REF = 0;

	/**
	 * The number of structural features of the '<em>Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS__REF = DATA__REF;

	/**
	 * The number of structural features of the '<em>Rfs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RFS_FEATURE_COUNT = DATA_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REF__VALUE = CONTENT__VALUE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REF__NAME = CONTENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REF__REF = CONTENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Referable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REF__REFERABLE = CONTENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REF__TEMPLATE = CONTENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Extension Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REF__EXTENSION_POLICY = CONTENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Empty</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REF__EMPTY = CONTENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REF_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link configurationemf.impl.FrameImpl <em>Frame</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.FrameImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getFrame()
	 * @generated
	 */
	int FRAME = 44;

	/**
	 * The feature id for the '<em><b>Leaf Settings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAME__LEAF_SETTINGS = 0;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAME__NUMBER = 1;

	/**
	 * The feature id for the '<em><b>Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAME__TEMPLATE = 2;

	/**
	 * The feature id for the '<em><b>Template Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAME__TEMPLATE_OWNER = 3;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAME__REF = 4;

	/**
	 * The number of structural features of the '<em>Frame</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAME_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link configurationemf.impl.LeafSettingDelegatorImpl <em>Leaf Setting Delegator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.impl.LeafSettingDelegatorImpl
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getLeafSettingDelegator()
	 * @generated
	 */
	int LEAF_SETTING_DELEGATOR = 45;

	/**
	 * The feature id for the '<em><b>Leaf Setting</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING_DELEGATOR__LEAF_SETTING = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING_DELEGATOR__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING_DELEGATOR__REF = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING_DELEGATOR__TYPE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING_DELEGATOR__NAME = 4;

	/**
	 * The number of structural features of the '<em>Leaf Setting Delegator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_SETTING_DELEGATOR_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link configurationemf.TYPE <em>TYPE</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.TYPE
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getTYPE()
	 * @generated
	 */
	int TYPE = 46;




	/**
	 * The meta object id for the '{@link configurationemf.EXTENSION_POLICY <em>EXTENSION POLICY</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.EXTENSION_POLICY
	 * @see configurationemf.impl.ConfigurationemfPackageImpl#getEXTENSION_POLICY()
	 * @generated
	 */
	int EXTENSION_POLICY = 47;




	/**
	 * Returns the meta object for class '{@link configurationemf.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see configurationemf.Configuration
	 * @generated
	 */
	EClass getConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Configuration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see configurationemf.Configuration#getName()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Name();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Configuration#getVers <em>Vers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vers</em>'.
	 * @see configurationemf.Configuration#getVers()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Vers();

	/**
	 * Returns the meta object for the containment reference list '{@link configurationemf.Configuration#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Feature</em>'.
	 * @see configurationemf.Configuration#getFeature()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_Feature();

	/**
	 * Returns the meta object for the containment reference list '{@link configurationemf.Configuration#getView <em>View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>View</em>'.
	 * @see configurationemf.Configuration#getView()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_View();

	/**
	 * Returns the meta object for the containment reference '{@link configurationemf.Configuration#getMeta <em>Meta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Meta</em>'.
	 * @see configurationemf.Configuration#getMeta()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_Meta();

	/**
	 * Returns the meta object for the containment reference list '{@link configurationemf.Configuration#getIcon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Icon</em>'.
	 * @see configurationemf.Configuration#getIcon()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_Icon();

	/**
	 * Returns the meta object for the containment reference list '{@link configurationemf.Configuration#getLink <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link</em>'.
	 * @see configurationemf.Configuration#getLink()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_Link();

	/**
	 * Returns the meta object for the containment reference '{@link configurationemf.Configuration#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data</em>'.
	 * @see configurationemf.Configuration#getData()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_Data();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Configuration#isReadOnly <em>Read Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Read Only</em>'.
	 * @see configurationemf.Configuration#isReadOnly()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_ReadOnly();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Configuration#getMetaId <em>Meta Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Meta Id</em>'.
	 * @see configurationemf.Configuration#getMetaId()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_MetaId();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Configuration#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Owner</em>'.
	 * @see configurationemf.Configuration#getOwner()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Owner();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Configuration#getEditor <em>Editor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Editor</em>'.
	 * @see configurationemf.Configuration#getEditor()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Editor();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Configuration#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see configurationemf.Configuration#getStatus()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Status();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Configuration#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see configurationemf.Configuration#getVersion()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Version();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Configuration#getPlatform <em>Platform</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Platform</em>'.
	 * @see configurationemf.Configuration#getPlatform()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Platform();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Configuration#getProduct <em>Product</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Product</em>'.
	 * @see configurationemf.Configuration#getProduct()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Product();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Configuration#getCustomer <em>Customer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Customer</em>'.
	 * @see configurationemf.Configuration#getCustomer()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Customer();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Configuration#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see configurationemf.Configuration#getDate()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Date();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Configuration#getRelease <em>Release</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Release</em>'.
	 * @see configurationemf.Configuration#getRelease()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Release();

	/**
	 * Returns the meta object for class '{@link configurationemf.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature</em>'.
	 * @see configurationemf.Feature
	 * @generated
	 */
	EClass getFeature();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Feature#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see configurationemf.Feature#getName()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Name();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Feature#getRelevant <em>Relevant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relevant</em>'.
	 * @see configurationemf.Feature#getRelevant()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Relevant();

	/**
	 * Returns the meta object for the container reference '{@link configurationemf.Feature#getConf <em>Conf</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Conf</em>'.
	 * @see configurationemf.Feature#getConf()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_Conf();

	/**
	 * Returns the meta object for the containment reference list '{@link configurationemf.Feature#getParentSetting <em>Parent Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parent Setting</em>'.
	 * @see configurationemf.Feature#getParentSetting()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_ParentSetting();

	/**
	 * Returns the meta object for the containment reference list '{@link configurationemf.Feature#getLink <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link</em>'.
	 * @see configurationemf.Feature#getLink()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_Link();

	/**
	 * Returns the meta object for the containment reference list '{@link configurationemf.Feature#getIcon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Icon</em>'.
	 * @see configurationemf.Feature#getIcon()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_Icon();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Feature#isReadOnly <em>Read Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Read Only</em>'.
	 * @see configurationemf.Feature#isReadOnly()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_ReadOnly();

	/**
	 * Returns the meta object for class '{@link configurationemf.Setting <em>Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Setting</em>'.
	 * @see configurationemf.Setting
	 * @generated
	 */
	EClass getSetting();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Setting#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see configurationemf.Setting#getName()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_Name();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Setting#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see configurationemf.Setting#getType()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_Type();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Setting#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constraint</em>'.
	 * @see configurationemf.Setting#getConstraint()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_Constraint();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Setting#getRelevant <em>Relevant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relevant</em>'.
	 * @see configurationemf.Setting#getRelevant()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_Relevant();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Setting#isReadOnly <em>Read Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Read Only</em>'.
	 * @see configurationemf.Setting#isReadOnly()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_ReadOnly();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Setting#getRequired <em>Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required</em>'.
	 * @see configurationemf.Setting#getRequired()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_Required();

	/**
	 * Returns the meta object for the containment reference list '{@link configurationemf.Setting#getOption <em>Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Option</em>'.
	 * @see configurationemf.Setting#getOption()
	 * @see #getSetting()
	 * @generated
	 */
	EReference getSetting_Option();

	/**
	 * Returns the meta object for the containment reference '{@link configurationemf.Setting#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Property</em>'.
	 * @see configurationemf.Setting#getProperty()
	 * @see #getSetting()
	 * @generated
	 */
	EReference getSetting_Property();

	/**
	 * Returns the meta object for the containment reference '{@link configurationemf.Setting#getMinLength <em>Min Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Min Length</em>'.
	 * @see configurationemf.Setting#getMinLength()
	 * @see #getSetting()
	 * @generated
	 */
	EReference getSetting_MinLength();

	/**
	 * Returns the meta object for the containment reference '{@link configurationemf.Setting#getMaxLength <em>Max Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Max Length</em>'.
	 * @see configurationemf.Setting#getMaxLength()
	 * @see #getSetting()
	 * @generated
	 */
	EReference getSetting_MaxLength();

	/**
	 * Returns the meta object for the containment reference '{@link configurationemf.Setting#getLength <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Length</em>'.
	 * @see configurationemf.Setting#getLength()
	 * @see #getSetting()
	 * @generated
	 */
	EReference getSetting_Length();

	/**
	 * Returns the meta object for the containment reference '{@link configurationemf.Setting#getMaxInclusive <em>Max Inclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Max Inclusive</em>'.
	 * @see configurationemf.Setting#getMaxInclusive()
	 * @see #getSetting()
	 * @generated
	 */
	EReference getSetting_MaxInclusive();

	/**
	 * Returns the meta object for the containment reference '{@link configurationemf.Setting#getMaxExclusive <em>Max Exclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Max Exclusive</em>'.
	 * @see configurationemf.Setting#getMaxExclusive()
	 * @see #getSetting()
	 * @generated
	 */
	EReference getSetting_MaxExclusive();

	/**
	 * Returns the meta object for the containment reference '{@link configurationemf.Setting#getMinExclusive <em>Min Exclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Min Exclusive</em>'.
	 * @see configurationemf.Setting#getMinExclusive()
	 * @see #getSetting()
	 * @generated
	 */
	EReference getSetting_MinExclusive();

	/**
	 * Returns the meta object for the containment reference '{@link configurationemf.Setting#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Pattern</em>'.
	 * @see configurationemf.Setting#getPattern()
	 * @see #getSetting()
	 * @generated
	 */
	EReference getSetting_Pattern();

	/**
	 * Returns the meta object for the containment reference '{@link configurationemf.Setting#getMinInclusive <em>Min Inclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Min Inclusive</em>'.
	 * @see configurationemf.Setting#getMinInclusive()
	 * @see #getSetting()
	 * @generated
	 */
	EReference getSetting_MinInclusive();

	/**
	 * Returns the meta object for the containment reference '{@link configurationemf.Setting#getTotalDigits <em>Total Digits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Total Digits</em>'.
	 * @see configurationemf.Setting#getTotalDigits()
	 * @see #getSetting()
	 * @generated
	 */
	EReference getSetting_TotalDigits();

	/**
	 * Returns the meta object for the containment reference list '{@link configurationemf.Setting#getLink <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link</em>'.
	 * @see configurationemf.Setting#getLink()
	 * @see #getSetting()
	 * @generated
	 */
	EReference getSetting_Link();

	/**
	 * Returns the meta object for the containment reference list '{@link configurationemf.Setting#getIcon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Icon</em>'.
	 * @see configurationemf.Setting#getIcon()
	 * @see #getSetting()
	 * @generated
	 */
	EReference getSetting_Icon();

	/**
	 * Returns the meta object for the reference list '{@link configurationemf.Setting#getBoolOptions <em>Bool Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Bool Options</em>'.
	 * @see configurationemf.Setting#getBoolOptions()
	 * @see #getSetting()
	 * @generated
	 */
	EReference getSetting_BoolOptions();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Setting#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Value</em>'.
	 * @see configurationemf.Setting#getDefaultValue()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_DefaultValue();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Setting#getCurrentValue <em>Current Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Value</em>'.
	 * @see configurationemf.Setting#getCurrentValue()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_CurrentValue();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Setting#getTopValue <em>Top Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Top Value</em>'.
	 * @see configurationemf.Setting#getTopValue()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_TopValue();

	/**
	 * Returns the meta object for the reference '{@link configurationemf.Setting#getCurrentConf <em>Current Conf</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Current Conf</em>'.
	 * @see configurationemf.Setting#getCurrentConf()
	 * @see #getSetting()
	 * @generated
	 */
	EReference getSetting_CurrentConf();

	/**
	 * Returns the meta object for the reference '{@link configurationemf.Setting#getDefaultConf <em>Default Conf</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Default Conf</em>'.
	 * @see configurationemf.Setting#getDefaultConf()
	 * @see #getSetting()
	 * @generated
	 */
	EReference getSetting_DefaultConf();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Setting#isRo <em>Ro</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ro</em>'.
	 * @see configurationemf.Setting#isRo()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_Ro();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Setting#getPossibleValue <em>Possible Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Possible Value</em>'.
	 * @see configurationemf.Setting#getPossibleValue()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_PossibleValue();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Setting#getCurrentType <em>Current Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Type</em>'.
	 * @see configurationemf.Setting#getCurrentType()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_CurrentType();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Setting#isValueChangeble <em>Value Changeble</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value Changeble</em>'.
	 * @see configurationemf.Setting#isValueChangeble()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_ValueChangeble();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Setting#isRfs <em>Rfs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rfs</em>'.
	 * @see configurationemf.Setting#isRfs()
	 * @see #getSetting()
	 * @generated
	 */
	EAttribute getSetting_Rfs();

	/**
	 * Returns the meta object for class '{@link configurationemf.AttributeAndDesc <em>Attribute And Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute And Desc</em>'.
	 * @see configurationemf.AttributeAndDesc
	 * @generated
	 */
	EClass getAttributeAndDesc();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.AttributeAndDesc#getDesc <em>Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Desc</em>'.
	 * @see configurationemf.AttributeAndDesc#getDesc()
	 * @see #getAttributeAndDesc()
	 * @generated
	 */
	EAttribute getAttributeAndDesc_Desc();

	/**
	 * Returns the meta object for class '{@link configurationemf.View <em>View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>View</em>'.
	 * @see configurationemf.View
	 * @generated
	 */
	EClass getView();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.View#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see configurationemf.View#getName()
	 * @see #getView()
	 * @generated
	 */
	EAttribute getView_Name();

	/**
	 * Returns the meta object for the container reference '{@link configurationemf.View#getConf <em>Conf</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Conf</em>'.
	 * @see configurationemf.View#getConf()
	 * @see #getView()
	 * @generated
	 */
	EReference getView_Conf();

	/**
	 * Returns the meta object for the containment reference '{@link configurationemf.View#getMeta <em>Meta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Meta</em>'.
	 * @see configurationemf.View#getMeta()
	 * @see #getView()
	 * @generated
	 */
	EReference getView_Meta();

	/**
	 * Returns the meta object for the containment reference list '{@link configurationemf.View#getParentGroup <em>Parent Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parent Group</em>'.
	 * @see configurationemf.View#getParentGroup()
	 * @see #getView()
	 * @generated
	 */
	EReference getView_ParentGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link configurationemf.View#getLink <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link</em>'.
	 * @see configurationemf.View#getLink()
	 * @see #getView()
	 * @generated
	 */
	EReference getView_Link();

	/**
	 * Returns the meta object for the containment reference list '{@link configurationemf.View#getIcon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Icon</em>'.
	 * @see configurationemf.View#getIcon()
	 * @see #getView()
	 * @generated
	 */
	EReference getView_Icon();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.View#isReadOnly <em>Read Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Read Only</em>'.
	 * @see configurationemf.View#isReadOnly()
	 * @see #getView()
	 * @generated
	 */
	EAttribute getView_ReadOnly();

	/**
	 * Returns the meta object for class '{@link configurationemf.Group <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Group</em>'.
	 * @see configurationemf.Group
	 * @generated
	 */
	EClass getGroup();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Group#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see configurationemf.Group#getName()
	 * @see #getGroup()
	 * @generated
	 */
	EAttribute getGroup_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link configurationemf.Group#getGSetting <em>GSetting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>GSetting</em>'.
	 * @see configurationemf.Group#getGSetting()
	 * @see #getGroup()
	 * @generated
	 */
	EReference getGroup_GSetting();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Group#isReadOnly <em>Read Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Read Only</em>'.
	 * @see configurationemf.Group#isReadOnly()
	 * @see #getGroup()
	 * @generated
	 */
	EAttribute getGroup_ReadOnly();

	/**
	 * Returns the meta object for the containment reference list '{@link configurationemf.Group#getIcon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Icon</em>'.
	 * @see configurationemf.Group#getIcon()
	 * @see #getGroup()
	 * @generated
	 */
	EReference getGroup_Icon();

	/**
	 * Returns the meta object for class '{@link configurationemf.CommonAttr <em>Common Attr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Common Attr</em>'.
	 * @see configurationemf.CommonAttr
	 * @generated
	 */
	EClass getCommonAttr();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.CommonAttr#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see configurationemf.CommonAttr#getId()
	 * @see #getCommonAttr()
	 * @generated
	 */
	EAttribute getCommonAttr_Id();

	/**
	 * Returns the meta object for class '{@link configurationemf.Option <em>Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Option</em>'.
	 * @see configurationemf.Option
	 * @generated
	 */
	EClass getOption();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Option#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see configurationemf.Option#getName()
	 * @see #getOption()
	 * @generated
	 */
	EAttribute getOption_Name();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Option#getRelevant <em>Relevant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relevant</em>'.
	 * @see configurationemf.Option#getRelevant()
	 * @see #getOption()
	 * @generated
	 */
	EAttribute getOption_Relevant();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Option#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see configurationemf.Option#getValue()
	 * @see #getOption()
	 * @generated
	 */
	EAttribute getOption_Value();

	/**
	 * Returns the meta object for the containment reference list '{@link configurationemf.Option#getLink <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link</em>'.
	 * @see configurationemf.Option#getLink()
	 * @see #getOption()
	 * @generated
	 */
	EReference getOption_Link();

	/**
	 * Returns the meta object for the containment reference list '{@link configurationemf.Option#getIcon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Icon</em>'.
	 * @see configurationemf.Option#getIcon()
	 * @see #getOption()
	 * @generated
	 */
	EReference getOption_Icon();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Option#isReadOnly <em>Read Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Read Only</em>'.
	 * @see configurationemf.Option#isReadOnly()
	 * @see #getOption()
	 * @generated
	 */
	EAttribute getOption_ReadOnly();

	/**
	 * Returns the meta object for class '{@link configurationemf.Meta <em>Meta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Meta</em>'.
	 * @see configurationemf.Meta
	 * @generated
	 */
	EClass getMeta();

	/**
	 * Returns the meta object for the containment reference '{@link configurationemf.Meta#getIdentification <em>Identification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Identification</em>'.
	 * @see configurationemf.Meta#getIdentification()
	 * @see #getMeta()
	 * @generated
	 */
	EReference getMeta_Identification();

	/**
	 * Returns the meta object for the containment reference '{@link configurationemf.Meta#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owner</em>'.
	 * @see configurationemf.Meta#getOwner()
	 * @see #getMeta()
	 * @generated
	 */
	EReference getMeta_Owner();

	/**
	 * Returns the meta object for the containment reference '{@link configurationemf.Meta#getEditor <em>Editor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Editor</em>'.
	 * @see configurationemf.Meta#getEditor()
	 * @see #getMeta()
	 * @generated
	 */
	EReference getMeta_Editor();

	/**
	 * Returns the meta object for the containment reference '{@link configurationemf.Meta#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Status</em>'.
	 * @see configurationemf.Meta#getStatus()
	 * @see #getMeta()
	 * @generated
	 */
	EReference getMeta_Status();

	/**
	 * Returns the meta object for the containment reference '{@link configurationemf.Meta#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Version</em>'.
	 * @see configurationemf.Meta#getVersion()
	 * @see #getMeta()
	 * @generated
	 */
	EReference getMeta_Version();

	/**
	 * Returns the meta object for the containment reference '{@link configurationemf.Meta#getPlatform <em>Platform</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Platform</em>'.
	 * @see configurationemf.Meta#getPlatform()
	 * @see #getMeta()
	 * @generated
	 */
	EReference getMeta_Platform();

	/**
	 * Returns the meta object for the containment reference '{@link configurationemf.Meta#getProduct <em>Product</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Product</em>'.
	 * @see configurationemf.Meta#getProduct()
	 * @see #getMeta()
	 * @generated
	 */
	EReference getMeta_Product();

	/**
	 * Returns the meta object for the containment reference '{@link configurationemf.Meta#getCustomer <em>Customer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Customer</em>'.
	 * @see configurationemf.Meta#getCustomer()
	 * @see #getMeta()
	 * @generated
	 */
	EReference getMeta_Customer();

	/**
	 * Returns the meta object for the containment reference '{@link configurationemf.Meta#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Date</em>'.
	 * @see configurationemf.Meta#getDate()
	 * @see #getMeta()
	 * @generated
	 */
	EReference getMeta_Date();

	/**
	 * Returns the meta object for the reference '{@link configurationemf.Meta#getRelease <em>Release</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Release</em>'.
	 * @see configurationemf.Meta#getRelease()
	 * @see #getMeta()
	 * @generated
	 */
	EReference getMeta_Release();

	/**
	 * Returns the meta object for class '{@link configurationemf.Identification <em>Identification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identification</em>'.
	 * @see configurationemf.Identification
	 * @generated
	 */
	EClass getIdentification();

	/**
	 * Returns the meta object for class '{@link configurationemf.Date <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Date</em>'.
	 * @see configurationemf.Date
	 * @generated
	 */
	EClass getDate();

	/**
	 * Returns the meta object for class '{@link configurationemf.Owner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Owner</em>'.
	 * @see configurationemf.Owner
	 * @generated
	 */
	EClass getOwner();

	/**
	 * Returns the meta object for class '{@link configurationemf.Editor <em>Editor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Editor</em>'.
	 * @see configurationemf.Editor
	 * @generated
	 */
	EClass getEditor();

	/**
	 * Returns the meta object for class '{@link configurationemf.Status <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Status</em>'.
	 * @see configurationemf.Status
	 * @generated
	 */
	EClass getStatus();

	/**
	 * Returns the meta object for class '{@link configurationemf.Version <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Version</em>'.
	 * @see configurationemf.Version
	 * @generated
	 */
	EClass getVersion();

	/**
	 * Returns the meta object for class '{@link configurationemf.Platform <em>Platform</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Platform</em>'.
	 * @see configurationemf.Platform
	 * @generated
	 */
	EClass getPlatform();

	/**
	 * Returns the meta object for class '{@link configurationemf.Product <em>Product</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Product</em>'.
	 * @see configurationemf.Product
	 * @generated
	 */
	EClass getProduct();

	/**
	 * Returns the meta object for class '{@link configurationemf.Release <em>Release</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Release</em>'.
	 * @see configurationemf.Release
	 * @generated
	 */
	EClass getRelease();

	/**
	 * Returns the meta object for class '{@link configurationemf.Referable <em>Referable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Referable</em>'.
	 * @see configurationemf.Referable
	 * @generated
	 */
	EClass getReferable();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Referable#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ref</em>'.
	 * @see configurationemf.Referable#getRef()
	 * @see #getReferable()
	 * @generated
	 */
	EAttribute getReferable_Ref();

	/**
	 * Returns the meta object for the reference list '{@link configurationemf.Referable#getRefs <em>Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Refs</em>'.
	 * @see configurationemf.Referable#getRefs()
	 * @see #getReferable()
	 * @generated
	 */
	EReference getReferable_Refs();

	/**
	 * Returns the meta object for the reference list '{@link configurationemf.Referable#getRfsRefs <em>Rfs Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Rfs Refs</em>'.
	 * @see configurationemf.Referable#getRfsRefs()
	 * @see #getReferable()
	 * @generated
	 */
	EReference getReferable_RfsRefs();

	/**
	 * Returns the meta object for class '{@link configurationemf.Frame <em>Frame</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Frame</em>'.
	 * @see configurationemf.Frame
	 * @generated
	 */
	EClass getFrame();

	/**
	 * Returns the meta object for the containment reference list '{@link configurationemf.Frame#getLeafSettings <em>Leaf Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Leaf Settings</em>'.
	 * @see configurationemf.Frame#getLeafSettings()
	 * @see #getFrame()
	 * @generated
	 */
	EReference getFrame_LeafSettings();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Frame#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see configurationemf.Frame#getNumber()
	 * @see #getFrame()
	 * @generated
	 */
	EAttribute getFrame_Number();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Frame#isTemplate <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Template</em>'.
	 * @see configurationemf.Frame#isTemplate()
	 * @see #getFrame()
	 * @generated
	 */
	EAttribute getFrame_Template();

	/**
	 * Returns the meta object for the reference '{@link configurationemf.Frame#getTemplateOwner <em>Template Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Template Owner</em>'.
	 * @see configurationemf.Frame#getTemplateOwner()
	 * @see #getFrame()
	 * @generated
	 */
	EReference getFrame_TemplateOwner();

	/**
	 * Returns the meta object for the reference '{@link configurationemf.Frame#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see configurationemf.Frame#getRef()
	 * @see #getFrame()
	 * @generated
	 */
	EReference getFrame_Ref();

	/**
	 * Returns the meta object for class '{@link configurationemf.LeafSettingDelegator <em>Leaf Setting Delegator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Leaf Setting Delegator</em>'.
	 * @see configurationemf.LeafSettingDelegator
	 * @generated
	 */
	EClass getLeafSettingDelegator();

	/**
	 * Returns the meta object for the reference '{@link configurationemf.LeafSettingDelegator#getLeafSetting <em>Leaf Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Leaf Setting</em>'.
	 * @see configurationemf.LeafSettingDelegator#getLeafSetting()
	 * @see #getLeafSettingDelegator()
	 * @generated
	 */
	EReference getLeafSettingDelegator_LeafSetting();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.LeafSettingDelegator#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see configurationemf.LeafSettingDelegator#getValue()
	 * @see #getLeafSettingDelegator()
	 * @generated
	 */
	EAttribute getLeafSettingDelegator_Value();

	/**
	 * Returns the meta object for the reference '{@link configurationemf.LeafSettingDelegator#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see configurationemf.LeafSettingDelegator#getRef()
	 * @see #getLeafSettingDelegator()
	 * @generated
	 */
	EReference getLeafSettingDelegator_Ref();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.LeafSettingDelegator#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see configurationemf.LeafSettingDelegator#getType()
	 * @see #getLeafSettingDelegator()
	 * @generated
	 */
	EAttribute getLeafSettingDelegator_Type();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.LeafSettingDelegator#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see configurationemf.LeafSettingDelegator#getName()
	 * @see #getLeafSettingDelegator()
	 * @generated
	 */
	EAttribute getLeafSettingDelegator_Name();

	/**
	 * Returns the meta object for enum '{@link configurationemf.TYPE <em>TYPE</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>TYPE</em>'.
	 * @see configurationemf.TYPE
	 * @generated
	 */
	EEnum getTYPE();

	/**
	 * Returns the meta object for enum '{@link configurationemf.EXTENSION_POLICY <em>EXTENSION POLICY</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EXTENSION POLICY</em>'.
	 * @see configurationemf.EXTENSION_POLICY
	 * @generated
	 */
	EEnum getEXTENSION_POLICY();

	/**
	 * Returns the meta object for class '{@link configurationemf.Customer <em>Customer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Customer</em>'.
	 * @see configurationemf.Customer
	 * @generated
	 */
	EClass getCustomer();

	/**
	 * Returns the meta object for class '{@link configurationemf.GSetting <em>GSetting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>GSetting</em>'.
	 * @see configurationemf.GSetting
	 * @generated
	 */
	EClass getGSetting();

	/**
	 * Returns the meta object for class '{@link configurationemf.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see configurationemf.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Property#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see configurationemf.Property#getName()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Name();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Property#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see configurationemf.Property#getValue()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Value();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Property#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see configurationemf.Property#getUnit()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Unit();

	/**
	 * Returns the meta object for class '{@link configurationemf.Pattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern</em>'.
	 * @see configurationemf.Pattern
	 * @generated
	 */
	EClass getPattern();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Pattern#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see configurationemf.Pattern#getValue()
	 * @see #getPattern()
	 * @generated
	 */
	EAttribute getPattern_Value();

	/**
	 * Returns the meta object for class '{@link configurationemf.Length <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Length</em>'.
	 * @see configurationemf.Length
	 * @generated
	 */
	EClass getLength();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Length#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see configurationemf.Length#getValue()
	 * @see #getLength()
	 * @generated
	 */
	EAttribute getLength_Value();

	/**
	 * Returns the meta object for class '{@link configurationemf.MaxLength <em>Max Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Max Length</em>'.
	 * @see configurationemf.MaxLength
	 * @generated
	 */
	EClass getMaxLength();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.MaxLength#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see configurationemf.MaxLength#getValue()
	 * @see #getMaxLength()
	 * @generated
	 */
	EAttribute getMaxLength_Value();

	/**
	 * Returns the meta object for class '{@link configurationemf.MinLength <em>Min Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Min Length</em>'.
	 * @see configurationemf.MinLength
	 * @generated
	 */
	EClass getMinLength();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.MinLength#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see configurationemf.MinLength#getValue()
	 * @see #getMinLength()
	 * @generated
	 */
	EAttribute getMinLength_Value();

	/**
	 * Returns the meta object for class '{@link configurationemf.MaxExclusive <em>Max Exclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Max Exclusive</em>'.
	 * @see configurationemf.MaxExclusive
	 * @generated
	 */
	EClass getMaxExclusive();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.MaxExclusive#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see configurationemf.MaxExclusive#getValue()
	 * @see #getMaxExclusive()
	 * @generated
	 */
	EAttribute getMaxExclusive_Value();

	/**
	 * Returns the meta object for class '{@link configurationemf.MaxInclusive <em>Max Inclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Max Inclusive</em>'.
	 * @see configurationemf.MaxInclusive
	 * @generated
	 */
	EClass getMaxInclusive();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.MaxInclusive#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see configurationemf.MaxInclusive#getValue()
	 * @see #getMaxInclusive()
	 * @generated
	 */
	EAttribute getMaxInclusive_Value();

	/**
	 * Returns the meta object for class '{@link configurationemf.MinInclusive <em>Min Inclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Min Inclusive</em>'.
	 * @see configurationemf.MinInclusive
	 * @generated
	 */
	EClass getMinInclusive();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.MinInclusive#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see configurationemf.MinInclusive#getValue()
	 * @see #getMinInclusive()
	 * @generated
	 */
	EAttribute getMinInclusive_Value();

	/**
	 * Returns the meta object for class '{@link configurationemf.MinExclusive <em>Min Exclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Min Exclusive</em>'.
	 * @see configurationemf.MinExclusive
	 * @generated
	 */
	EClass getMinExclusive();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.MinExclusive#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see configurationemf.MinExclusive#getValue()
	 * @see #getMinExclusive()
	 * @generated
	 */
	EAttribute getMinExclusive_Value();

	/**
	 * Returns the meta object for class '{@link configurationemf.TotalDigits <em>Total Digits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Total Digits</em>'.
	 * @see configurationemf.TotalDigits
	 * @generated
	 */
	EClass getTotalDigits();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.TotalDigits#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see configurationemf.TotalDigits#getValue()
	 * @see #getTotalDigits()
	 * @generated
	 */
	EAttribute getTotalDigits_Value();

	/**
	 * Returns the meta object for class '{@link configurationemf.LeafSetting <em>Leaf Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Leaf Setting</em>'.
	 * @see configurationemf.LeafSetting
	 * @generated
	 */
	EClass getLeafSetting();

	/**
	 * Returns the meta object for class '{@link configurationemf.ParentSetting <em>Parent Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parent Setting</em>'.
	 * @see configurationemf.ParentSetting
	 * @generated
	 */
	EClass getParentSetting();

	/**
	 * Returns the meta object for the containment reference list '{@link configurationemf.ParentSetting#getLeafSetting <em>Leaf Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Leaf Setting</em>'.
	 * @see configurationemf.ParentSetting#getLeafSetting()
	 * @see #getParentSetting()
	 * @generated
	 */
	EReference getParentSetting_LeafSetting();

	/**
	 * Returns the meta object for the containment reference list '{@link configurationemf.ParentSetting#getFrames <em>Frames</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Frames</em>'.
	 * @see configurationemf.ParentSetting#getFrames()
	 * @see #getParentSetting()
	 * @generated
	 */
	EReference getParentSetting_Frames();

	/**
	 * Returns the meta object for the containment reference '{@link configurationemf.ParentSetting#getTemplate <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Template</em>'.
	 * @see configurationemf.ParentSetting#getTemplate()
	 * @see #getParentSetting()
	 * @generated
	 */
	EReference getParentSetting_Template();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.ParentSetting#getCurrentExtensionPolicy <em>Current Extension Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Extension Policy</em>'.
	 * @see configurationemf.ParentSetting#getCurrentExtensionPolicy()
	 * @see #getParentSetting()
	 * @generated
	 */
	EAttribute getParentSetting_CurrentExtensionPolicy();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.ParentSetting#getMinOccurs <em>Min Occurs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Occurs</em>'.
	 * @see configurationemf.ParentSetting#getMinOccurs()
	 * @see #getParentSetting()
	 * @generated
	 */
	EAttribute getParentSetting_MinOccurs();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.ParentSetting#getMaxOccurs <em>Max Occurs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Occurs</em>'.
	 * @see configurationemf.ParentSetting#getMaxOccurs()
	 * @see #getParentSetting()
	 * @generated
	 */
	EAttribute getParentSetting_MaxOccurs();

	/**
	 * Returns the meta object for class '{@link configurationemf.LeafGroup <em>Leaf Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Leaf Group</em>'.
	 * @see configurationemf.LeafGroup
	 * @generated
	 */
	EClass getLeafGroup();

	/**
	 * Returns the meta object for class '{@link configurationemf.ParentGroup <em>Parent Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parent Group</em>'.
	 * @see configurationemf.ParentGroup
	 * @generated
	 */
	EClass getParentGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link configurationemf.ParentGroup#getLeafGroup <em>Leaf Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Leaf Group</em>'.
	 * @see configurationemf.ParentGroup#getLeafGroup()
	 * @see #getParentGroup()
	 * @generated
	 */
	EReference getParentGroup_LeafGroup();

	/**
	 * Returns the meta object for class '{@link configurationemf.Content <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Content</em>'.
	 * @see configurationemf.Content
	 * @generated
	 */
	EClass getContent();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Content#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see configurationemf.Content#getValue()
	 * @see #getContent()
	 * @generated
	 */
	EAttribute getContent_Value();

	/**
	 * Returns the meta object for class '{@link configurationemf.Icon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Icon</em>'.
	 * @see configurationemf.Icon
	 * @generated
	 */
	EClass getIcon();

	/**
	 * Returns the meta object for class '{@link configurationemf.Link <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link</em>'.
	 * @see configurationemf.Link
	 * @generated
	 */
	EClass getLink();

	/**
	 * Returns the meta object for class '{@link configurationemf.DIL <em>DIL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DIL</em>'.
	 * @see configurationemf.DIL
	 * @generated
	 */
	EClass getDIL();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.DIL#getHref <em>Href</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Href</em>'.
	 * @see configurationemf.DIL#getHref()
	 * @see #getDIL()
	 * @generated
	 */
	EAttribute getDIL_Href();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.DIL#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see configurationemf.DIL#getTitle()
	 * @see #getDIL()
	 * @generated
	 */
	EAttribute getDIL_Title();

	/**
	 * Returns the meta object for class '{@link configurationemf.RootConf <em>Root Conf</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root Conf</em>'.
	 * @see configurationemf.RootConf
	 * @generated
	 */
	EClass getRootConf();

	/**
	 * Returns the meta object for the containment reference list '{@link configurationemf.RootConf#getSubConf <em>Sub Conf</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Conf</em>'.
	 * @see configurationemf.RootConf#getSubConf()
	 * @see #getRootConf()
	 * @generated
	 */
	EReference getRootConf_SubConf();

	/**
	 * Returns the meta object for the reference list '{@link configurationemf.RootConf#getInclude <em>Include</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Include</em>'.
	 * @see configurationemf.RootConf#getInclude()
	 * @see #getRootConf()
	 * @generated
	 */
	EReference getRootConf_Include();

	/**
	 * Returns the meta object for the reference '{@link configurationemf.RootConf#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Root</em>'.
	 * @see configurationemf.RootConf#getRoot()
	 * @see #getRootConf()
	 * @generated
	 */
	EReference getRootConf_Root();

	/**
	 * Returns the meta object for the containment reference '{@link configurationemf.RootConf#getRfs <em>Rfs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rfs</em>'.
	 * @see configurationemf.RootConf#getRfs()
	 * @see #getRootConf()
	 * @generated
	 */
	EReference getRootConf_Rfs();

	/**
	 * Returns the meta object for class '{@link configurationemf.SubConf <em>Sub Conf</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Conf</em>'.
	 * @see configurationemf.SubConf
	 * @generated
	 */
	EClass getSubConf();

	/**
	 * Returns the meta object for class '{@link configurationemf.Data <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data</em>'.
	 * @see configurationemf.Data
	 * @generated
	 */
	EClass getData();

	/**
	 * Returns the meta object for the containment reference list '{@link configurationemf.Data#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ref</em>'.
	 * @see configurationemf.Data#getRef()
	 * @see #getData()
	 * @generated
	 */
	EReference getData_Ref();

	/**
	 * Returns the meta object for class '{@link configurationemf.Rfs <em>Rfs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rfs</em>'.
	 * @see configurationemf.Rfs
	 * @generated
	 */
	EClass getRfs();

	/**
	 * Returns the meta object for class '{@link configurationemf.Ref <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ref</em>'.
	 * @see configurationemf.Ref
	 * @generated
	 */
	EClass getRef();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Ref#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see configurationemf.Ref#getName()
	 * @see #getRef()
	 * @generated
	 */
	EAttribute getRef_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link configurationemf.Ref#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ref</em>'.
	 * @see configurationemf.Ref#getRef()
	 * @see #getRef()
	 * @generated
	 */
	EReference getRef_Ref();

	/**
	 * Returns the meta object for the reference '{@link configurationemf.Ref#getReferable <em>Referable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referable</em>'.
	 * @see configurationemf.Ref#getReferable()
	 * @see #getRef()
	 * @generated
	 */
	EReference getRef_Referable();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Ref#isTemplate <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Template</em>'.
	 * @see configurationemf.Ref#isTemplate()
	 * @see #getRef()
	 * @generated
	 */
	EAttribute getRef_Template();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Ref#getExtensionPolicy <em>Extension Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extension Policy</em>'.
	 * @see configurationemf.Ref#getExtensionPolicy()
	 * @see #getRef()
	 * @generated
	 */
	EAttribute getRef_ExtensionPolicy();

	/**
	 * Returns the meta object for the attribute '{@link configurationemf.Ref#isEmpty <em>Empty</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Empty</em>'.
	 * @see configurationemf.Ref#isEmpty()
	 * @see #getRef()
	 * @generated
	 */
	EAttribute getRef_Empty();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ConfigurationemfFactory getConfigurationemfFactory();

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
	interface Literals  {
		/**
		 * The meta object literal for the '{@link configurationemf.impl.ConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.ConfigurationImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getConfiguration()
		 * @generated
		 */
		EClass CONFIGURATION = eINSTANCE.getConfiguration();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__NAME = eINSTANCE.getConfiguration_Name();

		/**
		 * The meta object literal for the '<em><b>Vers</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__VERS = eINSTANCE.getConfiguration_Vers();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__FEATURE = eINSTANCE.getConfiguration_Feature();

		/**
		 * The meta object literal for the '<em><b>View</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__VIEW = eINSTANCE.getConfiguration_View();

		/**
		 * The meta object literal for the '<em><b>Meta</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__META = eINSTANCE.getConfiguration_Meta();

		/**
		 * The meta object literal for the '<em><b>Icon</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__ICON = eINSTANCE.getConfiguration_Icon();

		/**
		 * The meta object literal for the '<em><b>Link</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__LINK = eINSTANCE.getConfiguration_Link();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__DATA = eINSTANCE.getConfiguration_Data();

		/**
		 * The meta object literal for the '<em><b>Read Only</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__READ_ONLY = eINSTANCE.getConfiguration_ReadOnly();

		/**
		 * The meta object literal for the '<em><b>Meta Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__META_ID = eINSTANCE.getConfiguration_MetaId();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__OWNER = eINSTANCE.getConfiguration_Owner();

		/**
		 * The meta object literal for the '<em><b>Editor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__EDITOR = eINSTANCE.getConfiguration_Editor();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__STATUS = eINSTANCE.getConfiguration_Status();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__VERSION = eINSTANCE.getConfiguration_Version();

		/**
		 * The meta object literal for the '<em><b>Platform</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__PLATFORM = eINSTANCE.getConfiguration_Platform();

		/**
		 * The meta object literal for the '<em><b>Product</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__PRODUCT = eINSTANCE.getConfiguration_Product();

		/**
		 * The meta object literal for the '<em><b>Customer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__CUSTOMER = eINSTANCE.getConfiguration_Customer();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__DATE = eINSTANCE.getConfiguration_Date();

		/**
		 * The meta object literal for the '<em><b>Release</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__RELEASE = eINSTANCE.getConfiguration_Release();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.FeatureImpl <em>Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.FeatureImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getFeature()
		 * @generated
		 */
		EClass FEATURE = eINSTANCE.getFeature();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__NAME = eINSTANCE.getFeature_Name();

		/**
		 * The meta object literal for the '<em><b>Relevant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__RELEVANT = eINSTANCE.getFeature_Relevant();

		/**
		 * The meta object literal for the '<em><b>Conf</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__CONF = eINSTANCE.getFeature_Conf();

		/**
		 * The meta object literal for the '<em><b>Parent Setting</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__PARENT_SETTING = eINSTANCE.getFeature_ParentSetting();

		/**
		 * The meta object literal for the '<em><b>Link</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__LINK = eINSTANCE.getFeature_Link();

		/**
		 * The meta object literal for the '<em><b>Icon</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__ICON = eINSTANCE.getFeature_Icon();

		/**
		 * The meta object literal for the '<em><b>Read Only</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__READ_ONLY = eINSTANCE.getFeature_ReadOnly();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.SettingImpl <em>Setting</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.SettingImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getSetting()
		 * @generated
		 */
		EClass SETTING = eINSTANCE.getSetting();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__NAME = eINSTANCE.getSetting_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__TYPE = eINSTANCE.getSetting_Type();

		/**
		 * The meta object literal for the '<em><b>Constraint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__CONSTRAINT = eINSTANCE.getSetting_Constraint();

		/**
		 * The meta object literal for the '<em><b>Relevant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__RELEVANT = eINSTANCE.getSetting_Relevant();

		/**
		 * The meta object literal for the '<em><b>Read Only</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__READ_ONLY = eINSTANCE.getSetting_ReadOnly();

		/**
		 * The meta object literal for the '<em><b>Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__REQUIRED = eINSTANCE.getSetting_Required();

		/**
		 * The meta object literal for the '<em><b>Option</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SETTING__OPTION = eINSTANCE.getSetting_Option();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SETTING__PROPERTY = eINSTANCE.getSetting_Property();

		/**
		 * The meta object literal for the '<em><b>Min Length</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SETTING__MIN_LENGTH = eINSTANCE.getSetting_MinLength();

		/**
		 * The meta object literal for the '<em><b>Max Length</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SETTING__MAX_LENGTH = eINSTANCE.getSetting_MaxLength();

		/**
		 * The meta object literal for the '<em><b>Length</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SETTING__LENGTH = eINSTANCE.getSetting_Length();

		/**
		 * The meta object literal for the '<em><b>Max Inclusive</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SETTING__MAX_INCLUSIVE = eINSTANCE.getSetting_MaxInclusive();

		/**
		 * The meta object literal for the '<em><b>Max Exclusive</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SETTING__MAX_EXCLUSIVE = eINSTANCE.getSetting_MaxExclusive();

		/**
		 * The meta object literal for the '<em><b>Min Exclusive</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SETTING__MIN_EXCLUSIVE = eINSTANCE.getSetting_MinExclusive();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SETTING__PATTERN = eINSTANCE.getSetting_Pattern();

		/**
		 * The meta object literal for the '<em><b>Min Inclusive</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SETTING__MIN_INCLUSIVE = eINSTANCE.getSetting_MinInclusive();

		/**
		 * The meta object literal for the '<em><b>Total Digits</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SETTING__TOTAL_DIGITS = eINSTANCE.getSetting_TotalDigits();

		/**
		 * The meta object literal for the '<em><b>Link</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SETTING__LINK = eINSTANCE.getSetting_Link();

		/**
		 * The meta object literal for the '<em><b>Icon</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SETTING__ICON = eINSTANCE.getSetting_Icon();

		/**
		 * The meta object literal for the '<em><b>Bool Options</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SETTING__BOOL_OPTIONS = eINSTANCE.getSetting_BoolOptions();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__DEFAULT_VALUE = eINSTANCE.getSetting_DefaultValue();

		/**
		 * The meta object literal for the '<em><b>Current Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__CURRENT_VALUE = eINSTANCE.getSetting_CurrentValue();

		/**
		 * The meta object literal for the '<em><b>Top Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__TOP_VALUE = eINSTANCE.getSetting_TopValue();

		/**
		 * The meta object literal for the '<em><b>Current Conf</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SETTING__CURRENT_CONF = eINSTANCE.getSetting_CurrentConf();

		/**
		 * The meta object literal for the '<em><b>Default Conf</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SETTING__DEFAULT_CONF = eINSTANCE.getSetting_DefaultConf();

		/**
		 * The meta object literal for the '<em><b>Ro</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__RO = eINSTANCE.getSetting_Ro();

		/**
		 * The meta object literal for the '<em><b>Possible Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__POSSIBLE_VALUE = eINSTANCE.getSetting_PossibleValue();

		/**
		 * The meta object literal for the '<em><b>Current Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__CURRENT_TYPE = eINSTANCE.getSetting_CurrentType();

		/**
		 * The meta object literal for the '<em><b>Value Changeble</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__VALUE_CHANGEBLE = eINSTANCE.getSetting_ValueChangeble();

		/**
		 * The meta object literal for the '<em><b>Rfs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTING__RFS = eINSTANCE.getSetting_Rfs();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.AttributeAndDescImpl <em>Attribute And Desc</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.AttributeAndDescImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getAttributeAndDesc()
		 * @generated
		 */
		EClass ATTRIBUTE_AND_DESC = eINSTANCE.getAttributeAndDesc();

		/**
		 * The meta object literal for the '<em><b>Desc</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_AND_DESC__DESC = eINSTANCE.getAttributeAndDesc_Desc();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.ViewImpl <em>View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.ViewImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getView()
		 * @generated
		 */
		EClass VIEW = eINSTANCE.getView();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEW__NAME = eINSTANCE.getView_Name();

		/**
		 * The meta object literal for the '<em><b>Conf</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW__CONF = eINSTANCE.getView_Conf();

		/**
		 * The meta object literal for the '<em><b>Meta</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW__META = eINSTANCE.getView_Meta();

		/**
		 * The meta object literal for the '<em><b>Parent Group</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW__PARENT_GROUP = eINSTANCE.getView_ParentGroup();

		/**
		 * The meta object literal for the '<em><b>Link</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW__LINK = eINSTANCE.getView_Link();

		/**
		 * The meta object literal for the '<em><b>Icon</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW__ICON = eINSTANCE.getView_Icon();

		/**
		 * The meta object literal for the '<em><b>Read Only</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEW__READ_ONLY = eINSTANCE.getView_ReadOnly();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.GroupImpl <em>Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.GroupImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getGroup()
		 * @generated
		 */
		EClass GROUP = eINSTANCE.getGroup();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUP__NAME = eINSTANCE.getGroup_Name();

		/**
		 * The meta object literal for the '<em><b>GSetting</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GROUP__GSETTING = eINSTANCE.getGroup_GSetting();

		/**
		 * The meta object literal for the '<em><b>Read Only</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUP__READ_ONLY = eINSTANCE.getGroup_ReadOnly();

		/**
		 * The meta object literal for the '<em><b>Icon</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GROUP__ICON = eINSTANCE.getGroup_Icon();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.CommonAttrImpl <em>Common Attr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.CommonAttrImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getCommonAttr()
		 * @generated
		 */
		EClass COMMON_ATTR = eINSTANCE.getCommonAttr();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMON_ATTR__ID = eINSTANCE.getCommonAttr_Id();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.OptionImpl <em>Option</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.OptionImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getOption()
		 * @generated
		 */
		EClass OPTION = eINSTANCE.getOption();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTION__NAME = eINSTANCE.getOption_Name();

		/**
		 * The meta object literal for the '<em><b>Relevant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTION__RELEVANT = eINSTANCE.getOption_Relevant();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTION__VALUE = eINSTANCE.getOption_Value();

		/**
		 * The meta object literal for the '<em><b>Link</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTION__LINK = eINSTANCE.getOption_Link();

		/**
		 * The meta object literal for the '<em><b>Icon</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTION__ICON = eINSTANCE.getOption_Icon();

		/**
		 * The meta object literal for the '<em><b>Read Only</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTION__READ_ONLY = eINSTANCE.getOption_ReadOnly();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.MetaImpl <em>Meta</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.MetaImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getMeta()
		 * @generated
		 */
		EClass META = eINSTANCE.getMeta();

		/**
		 * The meta object literal for the '<em><b>Identification</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference META__IDENTIFICATION = eINSTANCE.getMeta_Identification();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference META__OWNER = eINSTANCE.getMeta_Owner();

		/**
		 * The meta object literal for the '<em><b>Editor</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference META__EDITOR = eINSTANCE.getMeta_Editor();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference META__STATUS = eINSTANCE.getMeta_Status();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference META__VERSION = eINSTANCE.getMeta_Version();

		/**
		 * The meta object literal for the '<em><b>Platform</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference META__PLATFORM = eINSTANCE.getMeta_Platform();

		/**
		 * The meta object literal for the '<em><b>Product</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference META__PRODUCT = eINSTANCE.getMeta_Product();

		/**
		 * The meta object literal for the '<em><b>Customer</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference META__CUSTOMER = eINSTANCE.getMeta_Customer();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference META__DATE = eINSTANCE.getMeta_Date();

		/**
		 * The meta object literal for the '<em><b>Release</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference META__RELEASE = eINSTANCE.getMeta_Release();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.IdentificationImpl <em>Identification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.IdentificationImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getIdentification()
		 * @generated
		 */
		EClass IDENTIFICATION = eINSTANCE.getIdentification();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.DateImpl <em>Date</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.DateImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getDate()
		 * @generated
		 */
		EClass DATE = eINSTANCE.getDate();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.OwnerImpl <em>Owner</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.OwnerImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getOwner()
		 * @generated
		 */
		EClass OWNER = eINSTANCE.getOwner();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.EditorImpl <em>Editor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.EditorImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getEditor()
		 * @generated
		 */
		EClass EDITOR = eINSTANCE.getEditor();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.StatusImpl <em>Status</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.StatusImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getStatus()
		 * @generated
		 */
		EClass STATUS = eINSTANCE.getStatus();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.VersionImpl <em>Version</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.VersionImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getVersion()
		 * @generated
		 */
		EClass VERSION = eINSTANCE.getVersion();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.PlatformImpl <em>Platform</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.PlatformImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getPlatform()
		 * @generated
		 */
		EClass PLATFORM = eINSTANCE.getPlatform();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.ProductImpl <em>Product</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.ProductImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getProduct()
		 * @generated
		 */
		EClass PRODUCT = eINSTANCE.getProduct();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.ReleaseImpl <em>Release</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.ReleaseImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getRelease()
		 * @generated
		 */
		EClass RELEASE = eINSTANCE.getRelease();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.ReferableImpl <em>Referable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.ReferableImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getReferable()
		 * @generated
		 */
		EClass REFERABLE = eINSTANCE.getReferable();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERABLE__REF = eINSTANCE.getReferable_Ref();

		/**
		 * The meta object literal for the '<em><b>Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERABLE__REFS = eINSTANCE.getReferable_Refs();

		/**
		 * The meta object literal for the '<em><b>Rfs Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERABLE__RFS_REFS = eINSTANCE.getReferable_RfsRefs();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.FrameImpl <em>Frame</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.FrameImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getFrame()
		 * @generated
		 */
		EClass FRAME = eINSTANCE.getFrame();

		/**
		 * The meta object literal for the '<em><b>Leaf Settings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FRAME__LEAF_SETTINGS = eINSTANCE.getFrame_LeafSettings();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FRAME__NUMBER = eINSTANCE.getFrame_Number();

		/**
		 * The meta object literal for the '<em><b>Template</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FRAME__TEMPLATE = eINSTANCE.getFrame_Template();

		/**
		 * The meta object literal for the '<em><b>Template Owner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FRAME__TEMPLATE_OWNER = eINSTANCE.getFrame_TemplateOwner();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FRAME__REF = eINSTANCE.getFrame_Ref();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.LeafSettingDelegatorImpl <em>Leaf Setting Delegator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.LeafSettingDelegatorImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getLeafSettingDelegator()
		 * @generated
		 */
		EClass LEAF_SETTING_DELEGATOR = eINSTANCE.getLeafSettingDelegator();

		/**
		 * The meta object literal for the '<em><b>Leaf Setting</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LEAF_SETTING_DELEGATOR__LEAF_SETTING = eINSTANCE.getLeafSettingDelegator_LeafSetting();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LEAF_SETTING_DELEGATOR__VALUE = eINSTANCE.getLeafSettingDelegator_Value();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LEAF_SETTING_DELEGATOR__REF = eINSTANCE.getLeafSettingDelegator_Ref();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LEAF_SETTING_DELEGATOR__TYPE = eINSTANCE.getLeafSettingDelegator_Type();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LEAF_SETTING_DELEGATOR__NAME = eINSTANCE.getLeafSettingDelegator_Name();

		/**
		 * The meta object literal for the '{@link configurationemf.TYPE <em>TYPE</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.TYPE
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getTYPE()
		 * @generated
		 */
		EEnum TYPE = eINSTANCE.getTYPE();

		/**
		 * The meta object literal for the '{@link configurationemf.EXTENSION_POLICY <em>EXTENSION POLICY</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.EXTENSION_POLICY
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getEXTENSION_POLICY()
		 * @generated
		 */
		EEnum EXTENSION_POLICY = eINSTANCE.getEXTENSION_POLICY();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.CustomerImpl <em>Customer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.CustomerImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getCustomer()
		 * @generated
		 */
		EClass CUSTOMER = eINSTANCE.getCustomer();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.GSettingImpl <em>GSetting</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.GSettingImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getGSetting()
		 * @generated
		 */
		EClass GSETTING = eINSTANCE.getGSetting();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.PropertyImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__NAME = eINSTANCE.getProperty_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__VALUE = eINSTANCE.getProperty_Value();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__UNIT = eINSTANCE.getProperty_Unit();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.PatternImpl <em>Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.PatternImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getPattern()
		 * @generated
		 */
		EClass PATTERN = eINSTANCE.getPattern();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATTERN__VALUE = eINSTANCE.getPattern_Value();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.LengthImpl <em>Length</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.LengthImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getLength()
		 * @generated
		 */
		EClass LENGTH = eINSTANCE.getLength();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LENGTH__VALUE = eINSTANCE.getLength_Value();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.MaxLengthImpl <em>Max Length</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.MaxLengthImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getMaxLength()
		 * @generated
		 */
		EClass MAX_LENGTH = eINSTANCE.getMaxLength();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAX_LENGTH__VALUE = eINSTANCE.getMaxLength_Value();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.MinLengthImpl <em>Min Length</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.MinLengthImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getMinLength()
		 * @generated
		 */
		EClass MIN_LENGTH = eINSTANCE.getMinLength();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MIN_LENGTH__VALUE = eINSTANCE.getMinLength_Value();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.MaxExclusiveImpl <em>Max Exclusive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.MaxExclusiveImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getMaxExclusive()
		 * @generated
		 */
		EClass MAX_EXCLUSIVE = eINSTANCE.getMaxExclusive();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAX_EXCLUSIVE__VALUE = eINSTANCE.getMaxExclusive_Value();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.MaxInclusiveImpl <em>Max Inclusive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.MaxInclusiveImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getMaxInclusive()
		 * @generated
		 */
		EClass MAX_INCLUSIVE = eINSTANCE.getMaxInclusive();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAX_INCLUSIVE__VALUE = eINSTANCE.getMaxInclusive_Value();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.MinInclusiveImpl <em>Min Inclusive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.MinInclusiveImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getMinInclusive()
		 * @generated
		 */
		EClass MIN_INCLUSIVE = eINSTANCE.getMinInclusive();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MIN_INCLUSIVE__VALUE = eINSTANCE.getMinInclusive_Value();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.MinExclusiveImpl <em>Min Exclusive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.MinExclusiveImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getMinExclusive()
		 * @generated
		 */
		EClass MIN_EXCLUSIVE = eINSTANCE.getMinExclusive();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MIN_EXCLUSIVE__VALUE = eINSTANCE.getMinExclusive_Value();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.TotalDigitsImpl <em>Total Digits</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.TotalDigitsImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getTotalDigits()
		 * @generated
		 */
		EClass TOTAL_DIGITS = eINSTANCE.getTotalDigits();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOTAL_DIGITS__VALUE = eINSTANCE.getTotalDigits_Value();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.LeafSettingImpl <em>Leaf Setting</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.LeafSettingImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getLeafSetting()
		 * @generated
		 */
		EClass LEAF_SETTING = eINSTANCE.getLeafSetting();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.ParentSettingImpl <em>Parent Setting</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.ParentSettingImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getParentSetting()
		 * @generated
		 */
		EClass PARENT_SETTING = eINSTANCE.getParentSetting();

		/**
		 * The meta object literal for the '<em><b>Leaf Setting</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARENT_SETTING__LEAF_SETTING = eINSTANCE.getParentSetting_LeafSetting();

		/**
		 * The meta object literal for the '<em><b>Frames</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARENT_SETTING__FRAMES = eINSTANCE.getParentSetting_Frames();

		/**
		 * The meta object literal for the '<em><b>Template</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARENT_SETTING__TEMPLATE = eINSTANCE.getParentSetting_Template();

		/**
		 * The meta object literal for the '<em><b>Current Extension Policy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARENT_SETTING__CURRENT_EXTENSION_POLICY = eINSTANCE.getParentSetting_CurrentExtensionPolicy();

		/**
		 * The meta object literal for the '<em><b>Min Occurs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARENT_SETTING__MIN_OCCURS = eINSTANCE.getParentSetting_MinOccurs();

		/**
		 * The meta object literal for the '<em><b>Max Occurs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARENT_SETTING__MAX_OCCURS = eINSTANCE.getParentSetting_MaxOccurs();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.LeafGroupImpl <em>Leaf Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.LeafGroupImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getLeafGroup()
		 * @generated
		 */
		EClass LEAF_GROUP = eINSTANCE.getLeafGroup();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.ParentGroupImpl <em>Parent Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.ParentGroupImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getParentGroup()
		 * @generated
		 */
		EClass PARENT_GROUP = eINSTANCE.getParentGroup();

		/**
		 * The meta object literal for the '<em><b>Leaf Group</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARENT_GROUP__LEAF_GROUP = eINSTANCE.getParentGroup_LeafGroup();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.ContentImpl <em>Content</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.ContentImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getContent()
		 * @generated
		 */
		EClass CONTENT = eINSTANCE.getContent();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTENT__VALUE = eINSTANCE.getContent_Value();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.IconImpl <em>Icon</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.IconImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getIcon()
		 * @generated
		 */
		EClass ICON = eINSTANCE.getIcon();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.LinkImpl <em>Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.LinkImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getLink()
		 * @generated
		 */
		EClass LINK = eINSTANCE.getLink();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.DILImpl <em>DIL</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.DILImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getDIL()
		 * @generated
		 */
		EClass DIL = eINSTANCE.getDIL();

		/**
		 * The meta object literal for the '<em><b>Href</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIL__HREF = eINSTANCE.getDIL_Href();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIL__TITLE = eINSTANCE.getDIL_Title();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.RootConfImpl <em>Root Conf</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.RootConfImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getRootConf()
		 * @generated
		 */
		EClass ROOT_CONF = eINSTANCE.getRootConf();

		/**
		 * The meta object literal for the '<em><b>Sub Conf</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_CONF__SUB_CONF = eINSTANCE.getRootConf_SubConf();

		/**
		 * The meta object literal for the '<em><b>Include</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_CONF__INCLUDE = eINSTANCE.getRootConf_Include();

		/**
		 * The meta object literal for the '<em><b>Root</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_CONF__ROOT = eINSTANCE.getRootConf_Root();

		/**
		 * The meta object literal for the '<em><b>Rfs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_CONF__RFS = eINSTANCE.getRootConf_Rfs();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.SubConfImpl <em>Sub Conf</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.SubConfImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getSubConf()
		 * @generated
		 */
		EClass SUB_CONF = eINSTANCE.getSubConf();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.DataImpl <em>Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.DataImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getData()
		 * @generated
		 */
		EClass DATA = eINSTANCE.getData();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA__REF = eINSTANCE.getData_Ref();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.RfsImpl <em>Rfs</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.RfsImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getRfs()
		 * @generated
		 */
		EClass RFS = eINSTANCE.getRfs();

		/**
		 * The meta object literal for the '{@link configurationemf.impl.RefImpl <em>Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see configurationemf.impl.RefImpl
		 * @see configurationemf.impl.ConfigurationemfPackageImpl#getRef()
		 * @generated
		 */
		EClass REF = eINSTANCE.getRef();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REF__NAME = eINSTANCE.getRef_Name();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REF__REF = eINSTANCE.getRef_Ref();

		/**
		 * The meta object literal for the '<em><b>Referable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REF__REFERABLE = eINSTANCE.getRef_Referable();

		/**
		 * The meta object literal for the '<em><b>Template</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REF__TEMPLATE = eINSTANCE.getRef_Template();

		/**
		 * The meta object literal for the '<em><b>Extension Policy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REF__EXTENSION_POLICY = eINSTANCE.getRef_ExtensionPolicy();

		/**
		 * The meta object literal for the '<em><b>Empty</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REF__EMPTY = eINSTANCE.getRef_Empty();

}

} //ConfigurationemfPackage
