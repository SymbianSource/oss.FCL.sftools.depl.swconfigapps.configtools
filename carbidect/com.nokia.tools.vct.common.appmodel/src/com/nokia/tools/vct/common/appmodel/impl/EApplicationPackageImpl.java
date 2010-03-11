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
 * Description: This file is part of com.nokia.tools.vct.common.appmodel component.
 */

package com.nokia.tools.vct.common.appmodel.impl;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.nokia.tools.vct.common.appmodel.EAppCompositeData;
import com.nokia.tools.vct.common.appmodel.EAppCompositeType;
import com.nokia.tools.vct.common.appmodel.EAppDataContainer;
import com.nokia.tools.vct.common.appmodel.EAppDescriptionContainer;
import com.nokia.tools.vct.common.appmodel.EAppExpression;
import com.nokia.tools.vct.common.appmodel.EAppFeature;
import com.nokia.tools.vct.common.appmodel.EAppGroup;
import com.nokia.tools.vct.common.appmodel.EAppGroupContainer;
import com.nokia.tools.vct.common.appmodel.EAppIconContainer;
import com.nokia.tools.vct.common.appmodel.EAppIncludeElement;
import com.nokia.tools.vct.common.appmodel.EAppMetadata;
import com.nokia.tools.vct.common.appmodel.EAppNamedItem;
import com.nokia.tools.vct.common.appmodel.EAppOptionContainer;
import com.nokia.tools.vct.common.appmodel.EAppProperty;
import com.nokia.tools.vct.common.appmodel.EAppPropertyContainer;
import com.nokia.tools.vct.common.appmodel.EAppResourceData;
import com.nokia.tools.vct.common.appmodel.EAppResourceType;
import com.nokia.tools.vct.common.appmodel.EAppRfsInfo;
import com.nokia.tools.vct.common.appmodel.EAppSequenceData;
import com.nokia.tools.vct.common.appmodel.EAppSequenceDataItem;
import com.nokia.tools.vct.common.appmodel.EAppSequenceType;
import com.nokia.tools.vct.common.appmodel.EAppSetting;
import com.nokia.tools.vct.common.appmodel.EAppSettingData;
import com.nokia.tools.vct.common.appmodel.EAppSettingOption;
import com.nokia.tools.vct.common.appmodel.EAppSettingRef;
import com.nokia.tools.vct.common.appmodel.EAppSettingType;
import com.nokia.tools.vct.common.appmodel.EAppSimpleData;
import com.nokia.tools.vct.common.appmodel.EAppSimpleType;
import com.nokia.tools.vct.common.appmodel.EAppTypeConstraints;
import com.nokia.tools.vct.common.appmodel.EAppTypeContainer;
import com.nokia.tools.vct.common.appmodel.EAppValueType;
import com.nokia.tools.vct.common.appmodel.EAppView;
import com.nokia.tools.vct.common.appmodel.EApplicationFactory;
import com.nokia.tools.vct.common.appmodel.EApplicationPackage;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;
import com.nokia.tools.vct.common.appmodel.ESourceLocator;
import com.nokia.tools.vct.common.appmodel.EStorageClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EApplicationPackageImpl extends EPackageImpl implements EApplicationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eConfMLLayerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAppFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAppSettingDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAppViewEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAppSettingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAppSubSettingDataEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAppRfsInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAppDescriptionContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAppIconContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAppNamedItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAppPropertyContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAppPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAppResourceEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eConfigurationProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAppMetadataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAppIncludeElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAppTypeConstraintsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eSourceLocatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAppViewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAppGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAppGroupContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAppSettingRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAppSettingEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAppFeatureEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAppSimpleDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAppCompositeDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAppSequenceDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAppSequenceDataItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAppDataContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAppResourceDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAppExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAppSettingTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAppSimpleTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAppSequenceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAppCompositeTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAppTypeContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAppResourceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAppSettingOptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAppOptionContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAppSettingTypeEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eAppValueTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eStorageClassEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType ecore_URIEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType java_Map_StringEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EApplicationPackageImpl() {
		super(eNS_URI, EApplicationFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EApplicationPackage init() {
		if (isInited) return (EApplicationPackage)EPackage.Registry.INSTANCE.getEPackage(EApplicationPackage.eNS_URI);

		// Obtain or create and register package
		EApplicationPackageImpl theEApplicationPackage = (EApplicationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof EApplicationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new EApplicationPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theEApplicationPackage.createPackageContents();

		// Initialize created meta-data
		theEApplicationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEApplicationPackage.freeze();

		return theEApplicationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEConfMLLayer() {
		return eConfMLLayerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEConfMLLayer_Features() {
		return (EReference)eConfMLLayerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEConfMLLayer_Views() {
		return (EReference)eConfMLLayerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEConfMLLayer_ResourceMap() {
		return (EReference)eConfMLLayerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEConfMLLayer_DocumentMap() {
		return (EReference)eConfMLLayerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEConfMLLayer_ImplMap() {
		return (EReference)eConfMLLayerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEConfMLLayer_LayerFiles() {
		return (EAttribute)eConfMLLayerEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEConfMLLayer_Parent() {
		return (EReference)eConfMLLayerEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEConfMLLayer_RootConfml() {
		return (EAttribute)eConfMLLayerEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEConfMLLayer_LayerURI() {
		return (EAttribute)eConfMLLayerEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEConfMLLayer_Name() {
		return (EAttribute)eConfMLLayerEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEConfMLLayer_Includes() {
		return (EReference)eConfMLLayerEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAppFeature() {
		return eAppFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEAppFeature_Settings() {
		return (EReference)eAppFeatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEAppFeature_Relevant() {
		return (EReference)eAppFeatureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppFeature_Ref() {
		return (EAttribute)eAppFeatureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAppSettingData() {
		return eAppSettingDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEAppSettingData_TypeInfo() {
		return (EReference)eAppSettingDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAppViewEntry() {
		return eAppViewEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppViewEntry_Key() {
		return (EAttribute)eAppViewEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEAppViewEntry_Value() {
		return (EReference)eAppViewEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAppSetting() {
		return eAppSettingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEAppSetting_ValueInfo() {
		return (EReference)eAppSettingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppSetting_Ref() {
		return (EAttribute)eAppSettingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAppSubSettingDataEntry() {
		return eAppSubSettingDataEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppSubSettingDataEntry_Key() {
		return (EAttribute)eAppSubSettingDataEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEAppSubSettingDataEntry_Value() {
		return (EReference)eAppSubSettingDataEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAppRfsInfo() {
		return eAppRfsInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppRfsInfo_Rfs() {
		return (EAttribute)eAppRfsInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAppDescriptionContainer() {
		return eAppDescriptionContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppDescriptionContainer_Description() {
		return (EAttribute)eAppDescriptionContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAppIconContainer() {
		return eAppIconContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppIconContainer_IconDescriptor() {
		return (EAttribute)eAppIconContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppIconContainer_IconTitle() {
		return (EAttribute)eAppIconContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppIconContainer_IconURI() {
		return (EAttribute)eAppIconContainerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAppNamedItem() {
		return eAppNamedItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppNamedItem_Name() {
		return (EAttribute)eAppNamedItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAppPropertyContainer() {
		return eAppPropertyContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEAppPropertyContainer_Properties() {
		return (EReference)eAppPropertyContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAppProperty() {
		return eAppPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppProperty_Name() {
		return (EAttribute)eAppPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppProperty_Value() {
		return (EAttribute)eAppPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppProperty_Unit() {
		return (EAttribute)eAppPropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAppResourceEntry() {
		return eAppResourceEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppResourceEntry_Key() {
		return (EAttribute)eAppResourceEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppResourceEntry_Value() {
		return (EAttribute)eAppResourceEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEConfigurationProject() {
		return eConfigurationProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEConfigurationProject_Layers() {
		return (EReference)eConfigurationProjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEConfigurationProject_LastLayer() {
		return (EReference)eConfigurationProjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEConfigurationProject_RootConfml() {
		return (EAttribute)eConfigurationProjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEConfigurationProject_Name() {
		return (EAttribute)eConfigurationProjectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEConfigurationProject_Storage() {
		return (EAttribute)eConfigurationProjectEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEConfigurationProject_ConfVersion() {
		return (EAttribute)eConfigurationProjectEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEConfigurationProject_DefaultView() {
		return (EReference)eConfigurationProjectEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEConfigurationProject_SettingHidden() {
		return (EAttribute)eConfigurationProjectEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAppMetadata() {
		return eAppMetadataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppMetadata_Date() {
		return (EAttribute)eAppMetadataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppMetadata_Owner() {
		return (EAttribute)eAppMetadataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppMetadata_Editor() {
		return (EAttribute)eAppMetadataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppMetadata_Status() {
		return (EAttribute)eAppMetadataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppMetadata_Version() {
		return (EAttribute)eAppMetadataEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppMetadata_Platform() {
		return (EAttribute)eAppMetadataEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppMetadata_Product() {
		return (EAttribute)eAppMetadataEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppMetadata_Release() {
		return (EAttribute)eAppMetadataEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppMetadata_Customer() {
		return (EAttribute)eAppMetadataEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppMetadata_Origin() {
		return (EAttribute)eAppMetadataEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppMetadata_Target() {
		return (EAttribute)eAppMetadataEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppMetadata_MetaId() {
		return (EAttribute)eAppMetadataEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppMetadata_ConfigurationPropertyMap() {
		return (EAttribute)eAppMetadataEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAppIncludeElement() {
		return eAppIncludeElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppIncludeElement_Source() {
		return (EAttribute)eAppIncludeElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppIncludeElement_Target() {
		return (EAttribute)eAppIncludeElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAppTypeConstraints() {
		return eAppTypeConstraintsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppTypeConstraints_MinInclusive() {
		return (EAttribute)eAppTypeConstraintsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppTypeConstraints_MaxInclusive() {
		return (EAttribute)eAppTypeConstraintsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppTypeConstraints_MinExclusive() {
		return (EAttribute)eAppTypeConstraintsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppTypeConstraints_MaxExclusive() {
		return (EAttribute)eAppTypeConstraintsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppTypeConstraints_MinLength() {
		return (EAttribute)eAppTypeConstraintsEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppTypeConstraints_Length() {
		return (EAttribute)eAppTypeConstraintsEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppTypeConstraints_MaxLength() {
		return (EAttribute)eAppTypeConstraintsEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppTypeConstraints_TotalDigits() {
		return (EAttribute)eAppTypeConstraintsEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppTypeConstraints_Pattern() {
		return (EAttribute)eAppTypeConstraintsEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getESourceLocator() {
		return eSourceLocatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESourceLocator_Uri() {
		return (EAttribute)eSourceLocatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEAppSetting_RfsInfo() {
		return (EReference)eAppSettingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEAppSetting_TypeInfo() {
		return (EReference)eAppSettingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAppView() {
		return eAppViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAppGroup() {
		return eAppGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEAppGroup_Settings() {
		return (EReference)eAppGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAppGroupContainer() {
		return eAppGroupContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEAppGroupContainer_Groups() {
		return (EReference)eAppGroupContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAppSettingRef() {
		return eAppSettingRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEAppSettingRef_Resolved() {
		return (EReference)eAppSettingRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppSettingRef_Name() {
		return (EAttribute)eAppSettingRefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppSettingRef_SubSettingsRef() {
		return (EAttribute)eAppSettingRefEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAppSettingEntry() {
		return eAppSettingEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppSettingEntry_Key() {
		return (EAttribute)eAppSettingEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEAppSettingEntry_Value() {
		return (EReference)eAppSettingEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAppFeatureEntry() {
		return eAppFeatureEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEAppFeatureEntry_Value() {
		return (EReference)eAppFeatureEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppFeatureEntry_Key() {
		return (EAttribute)eAppFeatureEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAppSimpleData() {
		return eAppSimpleDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppSimpleData_Value() {
		return (EAttribute)eAppSimpleDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppSimpleData_Map() {
		return (EAttribute)eAppSimpleDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAppCompositeData() {
		return eAppCompositeDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAppSequenceData() {
		return eAppSequenceDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEAppSequenceData_Items() {
		return (EReference)eAppSequenceDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEAppSequenceData_Template() {
		return (EReference)eAppSequenceDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAppSequenceDataItem() {
		return eAppSequenceDataItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAppDataContainer() {
		return eAppDataContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEAppDataContainer_SubSettings() {
		return (EReference)eAppDataContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAppResourceData() {
		return eAppResourceDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEAppResourceData_LocalPath() {
		return (EReference)eAppResourceDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEAppResourceData_TargetPath() {
		return (EReference)eAppResourceDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAppExpression() {
		return eAppExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppExpression_Literal() {
		return (EAttribute)eAppExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAppSettingType() {
		return eAppSettingTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppSettingType_ReadOnly() {
		return (EAttribute)eAppSettingTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEAppSettingType_Constraint() {
		return (EReference)eAppSettingTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEAppSettingType_Relevant() {
		return (EReference)eAppSettingTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppSettingType_Required() {
		return (EAttribute)eAppSettingTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppSettingType_Deprecated() {
		return (EAttribute)eAppSettingTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAppSimpleType() {
		return eAppSimpleTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppSimpleType_Type() {
		return (EAttribute)eAppSimpleTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAppSequenceType() {
		return eAppSequenceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppSequenceType_MinOccurs() {
		return (EAttribute)eAppSequenceTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppSequenceType_MaxOccurs() {
		return (EAttribute)eAppSequenceTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppSequenceType_MapKey() {
		return (EAttribute)eAppSequenceTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppSequenceType_MapValue() {
		return (EAttribute)eAppSequenceTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAppCompositeType() {
		return eAppCompositeTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAppTypeContainer() {
		return eAppTypeContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEAppTypeContainer_TypeMap() {
		return (EReference)eAppTypeContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAppResourceType() {
		return eAppResourceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppResourceType_File() {
		return (EAttribute)eAppResourceTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEAppResourceType_LocalPath() {
		return (EReference)eAppResourceTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEAppResourceType_TargetPath() {
		return (EReference)eAppResourceTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAppSettingOption() {
		return eAppSettingOptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppSettingOption_Name() {
		return (EAttribute)eAppSettingOptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppSettingOption_LiteralValue() {
		return (EAttribute)eAppSettingOptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEAppSettingOption_Relevant() {
		return (EReference)eAppSettingOptionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppSettingOption_RefValue() {
		return (EAttribute)eAppSettingOptionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAppOptionContainer() {
		return eAppOptionContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEAppOptionContainer_Options() {
		return (EReference)eAppOptionContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAppSettingTypeEntry() {
		return eAppSettingTypeEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAppSettingTypeEntry_Key() {
		return (EAttribute)eAppSettingTypeEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEAppSettingTypeEntry_Value() {
		return (EReference)eAppSettingTypeEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEAppValueType() {
		return eAppValueTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEStorageClass() {
		return eStorageClassEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEcore_URI() {
		return ecore_URIEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getJava_Map_String() {
		return java_Map_StringEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EApplicationFactory getEApplicationFactory() {
		return (EApplicationFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		eConfMLLayerEClass = createEClass(ECONF_ML_LAYER);
		createEReference(eConfMLLayerEClass, ECONF_ML_LAYER__FEATURES);
		createEReference(eConfMLLayerEClass, ECONF_ML_LAYER__VIEWS);
		createEReference(eConfMLLayerEClass, ECONF_ML_LAYER__RESOURCE_MAP);
		createEReference(eConfMLLayerEClass, ECONF_ML_LAYER__DOCUMENT_MAP);
		createEReference(eConfMLLayerEClass, ECONF_ML_LAYER__IMPL_MAP);
		createEAttribute(eConfMLLayerEClass, ECONF_ML_LAYER__LAYER_FILES);
		createEReference(eConfMLLayerEClass, ECONF_ML_LAYER__PARENT);
		createEAttribute(eConfMLLayerEClass, ECONF_ML_LAYER__ROOT_CONFML);
		createEAttribute(eConfMLLayerEClass, ECONF_ML_LAYER__LAYER_URI);
		createEAttribute(eConfMLLayerEClass, ECONF_ML_LAYER__NAME);
		createEReference(eConfMLLayerEClass, ECONF_ML_LAYER__INCLUDES);

		eAppFeatureEClass = createEClass(EAPP_FEATURE);
		createEReference(eAppFeatureEClass, EAPP_FEATURE__SETTINGS);
		createEReference(eAppFeatureEClass, EAPP_FEATURE__RELEVANT);
		createEAttribute(eAppFeatureEClass, EAPP_FEATURE__REF);

		eAppSettingDataEClass = createEClass(EAPP_SETTING_DATA);
		createEReference(eAppSettingDataEClass, EAPP_SETTING_DATA__TYPE_INFO);

		eAppViewEntryEClass = createEClass(EAPP_VIEW_ENTRY);
		createEAttribute(eAppViewEntryEClass, EAPP_VIEW_ENTRY__KEY);
		createEReference(eAppViewEntryEClass, EAPP_VIEW_ENTRY__VALUE);

		eAppViewEClass = createEClass(EAPP_VIEW);

		eAppGroupEClass = createEClass(EAPP_GROUP);
		createEReference(eAppGroupEClass, EAPP_GROUP__SETTINGS);

		eAppGroupContainerEClass = createEClass(EAPP_GROUP_CONTAINER);
		createEReference(eAppGroupContainerEClass, EAPP_GROUP_CONTAINER__GROUPS);

		eAppSettingRefEClass = createEClass(EAPP_SETTING_REF);
		createEReference(eAppSettingRefEClass, EAPP_SETTING_REF__RESOLVED);
		createEAttribute(eAppSettingRefEClass, EAPP_SETTING_REF__NAME);
		createEAttribute(eAppSettingRefEClass, EAPP_SETTING_REF__SUB_SETTINGS_REF);

		eAppSettingEntryEClass = createEClass(EAPP_SETTING_ENTRY);
		createEAttribute(eAppSettingEntryEClass, EAPP_SETTING_ENTRY__KEY);
		createEReference(eAppSettingEntryEClass, EAPP_SETTING_ENTRY__VALUE);

		eAppFeatureEntryEClass = createEClass(EAPP_FEATURE_ENTRY);
		createEReference(eAppFeatureEntryEClass, EAPP_FEATURE_ENTRY__VALUE);
		createEAttribute(eAppFeatureEntryEClass, EAPP_FEATURE_ENTRY__KEY);

		eAppSimpleDataEClass = createEClass(EAPP_SIMPLE_DATA);
		createEAttribute(eAppSimpleDataEClass, EAPP_SIMPLE_DATA__VALUE);
		createEAttribute(eAppSimpleDataEClass, EAPP_SIMPLE_DATA__MAP);

		eAppCompositeDataEClass = createEClass(EAPP_COMPOSITE_DATA);

		eAppSequenceDataEClass = createEClass(EAPP_SEQUENCE_DATA);
		createEReference(eAppSequenceDataEClass, EAPP_SEQUENCE_DATA__ITEMS);
		createEReference(eAppSequenceDataEClass, EAPP_SEQUENCE_DATA__TEMPLATE);

		eAppSequenceDataItemEClass = createEClass(EAPP_SEQUENCE_DATA_ITEM);

		eAppDataContainerEClass = createEClass(EAPP_DATA_CONTAINER);
		createEReference(eAppDataContainerEClass, EAPP_DATA_CONTAINER__SUB_SETTINGS);

		eAppResourceDataEClass = createEClass(EAPP_RESOURCE_DATA);
		createEReference(eAppResourceDataEClass, EAPP_RESOURCE_DATA__LOCAL_PATH);
		createEReference(eAppResourceDataEClass, EAPP_RESOURCE_DATA__TARGET_PATH);

		eAppExpressionEClass = createEClass(EAPP_EXPRESSION);
		createEAttribute(eAppExpressionEClass, EAPP_EXPRESSION__LITERAL);

		eAppSettingTypeEClass = createEClass(EAPP_SETTING_TYPE);
		createEAttribute(eAppSettingTypeEClass, EAPP_SETTING_TYPE__READ_ONLY);
		createEReference(eAppSettingTypeEClass, EAPP_SETTING_TYPE__CONSTRAINT);
		createEReference(eAppSettingTypeEClass, EAPP_SETTING_TYPE__RELEVANT);
		createEAttribute(eAppSettingTypeEClass, EAPP_SETTING_TYPE__REQUIRED);
		createEAttribute(eAppSettingTypeEClass, EAPP_SETTING_TYPE__DEPRECATED);

		eAppSimpleTypeEClass = createEClass(EAPP_SIMPLE_TYPE);
		createEAttribute(eAppSimpleTypeEClass, EAPP_SIMPLE_TYPE__TYPE);

		eAppSequenceTypeEClass = createEClass(EAPP_SEQUENCE_TYPE);
		createEAttribute(eAppSequenceTypeEClass, EAPP_SEQUENCE_TYPE__MIN_OCCURS);
		createEAttribute(eAppSequenceTypeEClass, EAPP_SEQUENCE_TYPE__MAX_OCCURS);
		createEAttribute(eAppSequenceTypeEClass, EAPP_SEQUENCE_TYPE__MAP_KEY);
		createEAttribute(eAppSequenceTypeEClass, EAPP_SEQUENCE_TYPE__MAP_VALUE);

		eAppCompositeTypeEClass = createEClass(EAPP_COMPOSITE_TYPE);

		eAppTypeContainerEClass = createEClass(EAPP_TYPE_CONTAINER);
		createEReference(eAppTypeContainerEClass, EAPP_TYPE_CONTAINER__TYPE_MAP);

		eAppResourceTypeEClass = createEClass(EAPP_RESOURCE_TYPE);
		createEAttribute(eAppResourceTypeEClass, EAPP_RESOURCE_TYPE__FILE);
		createEReference(eAppResourceTypeEClass, EAPP_RESOURCE_TYPE__LOCAL_PATH);
		createEReference(eAppResourceTypeEClass, EAPP_RESOURCE_TYPE__TARGET_PATH);

		eAppSettingOptionEClass = createEClass(EAPP_SETTING_OPTION);
		createEAttribute(eAppSettingOptionEClass, EAPP_SETTING_OPTION__NAME);
		createEAttribute(eAppSettingOptionEClass, EAPP_SETTING_OPTION__LITERAL_VALUE);
		createEReference(eAppSettingOptionEClass, EAPP_SETTING_OPTION__RELEVANT);
		createEAttribute(eAppSettingOptionEClass, EAPP_SETTING_OPTION__REF_VALUE);

		eAppOptionContainerEClass = createEClass(EAPP_OPTION_CONTAINER);
		createEReference(eAppOptionContainerEClass, EAPP_OPTION_CONTAINER__OPTIONS);

		eAppSettingTypeEntryEClass = createEClass(EAPP_SETTING_TYPE_ENTRY);
		createEAttribute(eAppSettingTypeEntryEClass, EAPP_SETTING_TYPE_ENTRY__KEY);
		createEReference(eAppSettingTypeEntryEClass, EAPP_SETTING_TYPE_ENTRY__VALUE);

		eAppSettingEClass = createEClass(EAPP_SETTING);
		createEReference(eAppSettingEClass, EAPP_SETTING__RFS_INFO);
		createEReference(eAppSettingEClass, EAPP_SETTING__TYPE_INFO);
		createEReference(eAppSettingEClass, EAPP_SETTING__VALUE_INFO);
		createEAttribute(eAppSettingEClass, EAPP_SETTING__REF);

		eAppSubSettingDataEntryEClass = createEClass(EAPP_SUB_SETTING_DATA_ENTRY);
		createEAttribute(eAppSubSettingDataEntryEClass, EAPP_SUB_SETTING_DATA_ENTRY__KEY);
		createEReference(eAppSubSettingDataEntryEClass, EAPP_SUB_SETTING_DATA_ENTRY__VALUE);

		eAppRfsInfoEClass = createEClass(EAPP_RFS_INFO);
		createEAttribute(eAppRfsInfoEClass, EAPP_RFS_INFO__RFS);

		eAppDescriptionContainerEClass = createEClass(EAPP_DESCRIPTION_CONTAINER);
		createEAttribute(eAppDescriptionContainerEClass, EAPP_DESCRIPTION_CONTAINER__DESCRIPTION);

		eAppIconContainerEClass = createEClass(EAPP_ICON_CONTAINER);
		createEAttribute(eAppIconContainerEClass, EAPP_ICON_CONTAINER__ICON_DESCRIPTOR);
		createEAttribute(eAppIconContainerEClass, EAPP_ICON_CONTAINER__ICON_TITLE);
		createEAttribute(eAppIconContainerEClass, EAPP_ICON_CONTAINER__ICON_URI);

		eAppNamedItemEClass = createEClass(EAPP_NAMED_ITEM);
		createEAttribute(eAppNamedItemEClass, EAPP_NAMED_ITEM__NAME);

		eAppPropertyContainerEClass = createEClass(EAPP_PROPERTY_CONTAINER);
		createEReference(eAppPropertyContainerEClass, EAPP_PROPERTY_CONTAINER__PROPERTIES);

		eAppPropertyEClass = createEClass(EAPP_PROPERTY);
		createEAttribute(eAppPropertyEClass, EAPP_PROPERTY__NAME);
		createEAttribute(eAppPropertyEClass, EAPP_PROPERTY__VALUE);
		createEAttribute(eAppPropertyEClass, EAPP_PROPERTY__UNIT);

		eAppResourceEntryEClass = createEClass(EAPP_RESOURCE_ENTRY);
		createEAttribute(eAppResourceEntryEClass, EAPP_RESOURCE_ENTRY__KEY);
		createEAttribute(eAppResourceEntryEClass, EAPP_RESOURCE_ENTRY__VALUE);

		eConfigurationProjectEClass = createEClass(ECONFIGURATION_PROJECT);
		createEReference(eConfigurationProjectEClass, ECONFIGURATION_PROJECT__LAYERS);
		createEReference(eConfigurationProjectEClass, ECONFIGURATION_PROJECT__LAST_LAYER);
		createEAttribute(eConfigurationProjectEClass, ECONFIGURATION_PROJECT__ROOT_CONFML);
		createEAttribute(eConfigurationProjectEClass, ECONFIGURATION_PROJECT__NAME);
		createEAttribute(eConfigurationProjectEClass, ECONFIGURATION_PROJECT__STORAGE);
		createEAttribute(eConfigurationProjectEClass, ECONFIGURATION_PROJECT__CONF_VERSION);
		createEReference(eConfigurationProjectEClass, ECONFIGURATION_PROJECT__DEFAULT_VIEW);
		createEAttribute(eConfigurationProjectEClass, ECONFIGURATION_PROJECT__SETTING_HIDDEN);

		eAppMetadataEClass = createEClass(EAPP_METADATA);
		createEAttribute(eAppMetadataEClass, EAPP_METADATA__DATE);
		createEAttribute(eAppMetadataEClass, EAPP_METADATA__OWNER);
		createEAttribute(eAppMetadataEClass, EAPP_METADATA__EDITOR);
		createEAttribute(eAppMetadataEClass, EAPP_METADATA__STATUS);
		createEAttribute(eAppMetadataEClass, EAPP_METADATA__VERSION);
		createEAttribute(eAppMetadataEClass, EAPP_METADATA__PLATFORM);
		createEAttribute(eAppMetadataEClass, EAPP_METADATA__PRODUCT);
		createEAttribute(eAppMetadataEClass, EAPP_METADATA__RELEASE);
		createEAttribute(eAppMetadataEClass, EAPP_METADATA__CUSTOMER);
		createEAttribute(eAppMetadataEClass, EAPP_METADATA__ORIGIN);
		createEAttribute(eAppMetadataEClass, EAPP_METADATA__TARGET);
		createEAttribute(eAppMetadataEClass, EAPP_METADATA__META_ID);
		createEAttribute(eAppMetadataEClass, EAPP_METADATA__CONFIGURATION_PROPERTY_MAP);

		eAppIncludeElementEClass = createEClass(EAPP_INCLUDE_ELEMENT);
		createEAttribute(eAppIncludeElementEClass, EAPP_INCLUDE_ELEMENT__SOURCE);
		createEAttribute(eAppIncludeElementEClass, EAPP_INCLUDE_ELEMENT__TARGET);

		eAppTypeConstraintsEClass = createEClass(EAPP_TYPE_CONSTRAINTS);
		createEAttribute(eAppTypeConstraintsEClass, EAPP_TYPE_CONSTRAINTS__MIN_INCLUSIVE);
		createEAttribute(eAppTypeConstraintsEClass, EAPP_TYPE_CONSTRAINTS__MAX_INCLUSIVE);
		createEAttribute(eAppTypeConstraintsEClass, EAPP_TYPE_CONSTRAINTS__MIN_EXCLUSIVE);
		createEAttribute(eAppTypeConstraintsEClass, EAPP_TYPE_CONSTRAINTS__MAX_EXCLUSIVE);
		createEAttribute(eAppTypeConstraintsEClass, EAPP_TYPE_CONSTRAINTS__MIN_LENGTH);
		createEAttribute(eAppTypeConstraintsEClass, EAPP_TYPE_CONSTRAINTS__LENGTH);
		createEAttribute(eAppTypeConstraintsEClass, EAPP_TYPE_CONSTRAINTS__MAX_LENGTH);
		createEAttribute(eAppTypeConstraintsEClass, EAPP_TYPE_CONSTRAINTS__TOTAL_DIGITS);
		createEAttribute(eAppTypeConstraintsEClass, EAPP_TYPE_CONSTRAINTS__PATTERN);

		eSourceLocatorEClass = createEClass(ESOURCE_LOCATOR);
		createEAttribute(eSourceLocatorEClass, ESOURCE_LOCATOR__URI);

		// Create enums
		eAppValueTypeEEnum = createEEnum(EAPP_VALUE_TYPE);
		eStorageClassEEnum = createEEnum(ESTORAGE_CLASS);

		// Create data types
		ecore_URIEDataType = createEDataType(ECORE_URI);
		java_Map_StringEDataType = createEDataType(JAVA_MAP_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		eConfMLLayerEClass.getESuperTypes().add(this.getEAppMetadata());
		eAppFeatureEClass.getESuperTypes().add(this.getEAppDescriptionContainer());
		eAppFeatureEClass.getESuperTypes().add(this.getEAppIconContainer());
		eAppFeatureEClass.getESuperTypes().add(this.getEAppNamedItem());
		eAppSettingDataEClass.getESuperTypes().add(this.getESourceLocator());
		eAppViewEClass.getESuperTypes().add(this.getEAppGroupContainer());
		eAppViewEClass.getESuperTypes().add(this.getEAppDescriptionContainer());
		eAppViewEClass.getESuperTypes().add(this.getEAppIconContainer());
		eAppViewEClass.getESuperTypes().add(this.getEAppNamedItem());
		eAppViewEClass.getESuperTypes().add(this.getESourceLocator());
		eAppGroupEClass.getESuperTypes().add(this.getEAppGroupContainer());
		eAppGroupEClass.getESuperTypes().add(this.getEAppDescriptionContainer());
		eAppGroupEClass.getESuperTypes().add(this.getEAppIconContainer());
		eAppGroupEClass.getESuperTypes().add(this.getEAppNamedItem());
		eAppSettingRefEClass.getESuperTypes().add(this.getEAppPropertyContainer());
		eAppSettingRefEClass.getESuperTypes().add(this.getEAppOptionContainer());
		eAppSettingRefEClass.getESuperTypes().add(this.getEAppDescriptionContainer());
		eAppSettingRefEClass.getESuperTypes().add(this.getEAppTypeConstraints());
		eAppSimpleDataEClass.getESuperTypes().add(this.getEAppSettingData());
		eAppCompositeDataEClass.getESuperTypes().add(this.getEAppSettingData());
		eAppCompositeDataEClass.getESuperTypes().add(this.getEAppDataContainer());
		eAppSequenceDataEClass.getESuperTypes().add(this.getEAppSettingData());
		eAppSequenceDataItemEClass.getESuperTypes().add(this.getEAppDataContainer());
		eAppSequenceDataItemEClass.getESuperTypes().add(this.getESourceLocator());
		eAppResourceDataEClass.getESuperTypes().add(this.getEAppCompositeData());
		eAppSettingTypeEClass.getESuperTypes().add(this.getEAppDescriptionContainer());
		eAppSettingTypeEClass.getESuperTypes().add(this.getEAppIconContainer());
		eAppSettingTypeEClass.getESuperTypes().add(this.getEAppNamedItem());
		eAppSettingTypeEClass.getESuperTypes().add(this.getEAppPropertyContainer());
		eAppSettingTypeEClass.getESuperTypes().add(this.getEAppTypeConstraints());
		eAppSimpleTypeEClass.getESuperTypes().add(this.getEAppSettingType());
		eAppSimpleTypeEClass.getESuperTypes().add(this.getEAppOptionContainer());
		eAppSequenceTypeEClass.getESuperTypes().add(this.getEAppTypeContainer());
		eAppSequenceTypeEClass.getESuperTypes().add(this.getEAppSettingType());
		eAppCompositeTypeEClass.getESuperTypes().add(this.getEAppTypeContainer());
		eAppCompositeTypeEClass.getESuperTypes().add(this.getEAppSettingType());
		eAppResourceTypeEClass.getESuperTypes().add(this.getEAppCompositeType());
		eConfigurationProjectEClass.getESuperTypes().add(this.getEAppMetadata());

		// Initialize classes and features; add operations and parameters
		initEClass(eConfMLLayerEClass, EConfMLLayer.class, "EConfMLLayer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEConfMLLayer_Features(), this.getEAppFeatureEntry(), null, "features", null, 0, -1, EConfMLLayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEConfMLLayer_Views(), this.getEAppViewEntry(), null, "views", null, 0, -1, EConfMLLayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEConfMLLayer_ResourceMap(), this.getEAppResourceEntry(), null, "resourceMap", null, 0, -1, EConfMLLayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEConfMLLayer_DocumentMap(), this.getEAppResourceEntry(), null, "documentMap", null, 0, -1, EConfMLLayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEConfMLLayer_ImplMap(), this.getEAppResourceEntry(), null, "implMap", null, 0, -1, EConfMLLayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEConfMLLayer_LayerFiles(), this.getEcore_URI(), "layerFiles", null, 0, -1, EConfMLLayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEConfMLLayer_Parent(), this.getEConfMLLayer(), null, "parent", null, 0, 1, EConfMLLayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEConfMLLayer_RootConfml(), this.getEcore_URI(), "rootConfml", null, 1, 1, EConfMLLayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEConfMLLayer_LayerURI(), this.getEcore_URI(), "layerURI", null, 1, 1, EConfMLLayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEConfMLLayer_Name(), ecorePackage.getEString(), "name", null, 0, 1, EConfMLLayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEConfMLLayer_Includes(), this.getEAppIncludeElement(), null, "includes", null, 0, -1, EConfMLLayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eAppFeatureEClass, EAppFeature.class, "EAppFeature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEAppFeature_Settings(), this.getEAppSettingEntry(), null, "settings", null, 0, -1, EAppFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEAppFeature_Relevant(), this.getEAppExpression(), null, "relevant", null, 0, 1, EAppFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAppFeature_Ref(), ecorePackage.getEString(), "ref", "", 0, 1, EAppFeature.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(eAppFeatureEClass, ecorePackage.getEBoolean(), "computeRelevant", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(eAppSettingDataEClass, EAppSettingData.class, "EAppSettingData", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEAppSettingData_TypeInfo(), this.getEAppSettingType(), null, "typeInfo", null, 1, 1, EAppSettingData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(eAppSettingDataEClass, ecorePackage.getEBoolean(), "computeRelevant", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(eAppSettingDataEClass, ecorePackage.getEBoolean(), "computeConstraint", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(eAppViewEntryEClass, Map.Entry.class, "EAppViewEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEAppViewEntry_Key(), ecorePackage.getEString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEAppViewEntry_Value(), this.getEAppView(), null, "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eAppViewEClass, EAppView.class, "EAppView", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eAppGroupEClass, EAppGroup.class, "EAppGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEAppGroup_Settings(), this.getEAppSettingRef(), null, "settings", null, 0, -1, EAppGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eAppGroupContainerEClass, EAppGroupContainer.class, "EAppGroupContainer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEAppGroupContainer_Groups(), this.getEAppGroup(), null, "groups", null, 0, -1, EAppGroupContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eAppSettingRefEClass, EAppSettingRef.class, "EAppSettingRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEAppSettingRef_Resolved(), this.getEAppSetting(), null, "resolved", null, 0, 1, EAppSettingRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAppSettingRef_Name(), ecorePackage.getEString(), "name", null, 0, 1, EAppSettingRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAppSettingRef_SubSettingsRef(), ecorePackage.getEString(), "subSettingsRef", null, 0, -1, EAppSettingRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eAppSettingEntryEClass, Map.Entry.class, "EAppSettingEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEAppSettingEntry_Key(), ecorePackage.getEString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEAppSettingEntry_Value(), this.getEAppSetting(), null, "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eAppFeatureEntryEClass, Map.Entry.class, "EAppFeatureEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEAppFeatureEntry_Value(), this.getEAppFeature(), null, "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAppFeatureEntry_Key(), ecorePackage.getEString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eAppSimpleDataEClass, EAppSimpleData.class, "EAppSimpleData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEAppSimpleData_Value(), ecorePackage.getEString(), "value", null, 0, 1, EAppSimpleData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAppSimpleData_Map(), ecorePackage.getEString(), "map", null, 0, 1, EAppSimpleData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eAppCompositeDataEClass, EAppCompositeData.class, "EAppCompositeData", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eAppSequenceDataEClass, EAppSequenceData.class, "EAppSequenceData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEAppSequenceData_Items(), this.getEAppSequenceDataItem(), null, "items", null, 0, -1, EAppSequenceData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEAppSequenceData_Template(), this.getEAppSequenceDataItem(), null, "template", null, 0, 1, EAppSequenceData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eAppSequenceDataItemEClass, EAppSequenceDataItem.class, "EAppSequenceDataItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eAppDataContainerEClass, EAppDataContainer.class, "EAppDataContainer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEAppDataContainer_SubSettings(), this.getEAppSubSettingDataEntry(), null, "subSettings", null, 0, -1, EAppDataContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eAppResourceDataEClass, EAppResourceData.class, "EAppResourceData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEAppResourceData_LocalPath(), this.getEAppSettingData(), null, "localPath", null, 0, 1, EAppResourceData.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEAppResourceData_TargetPath(), this.getEAppSettingData(), null, "targetPath", null, 0, 1, EAppResourceData.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eAppExpressionEClass, EAppExpression.class, "EAppExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEAppExpression_Literal(), ecorePackage.getEString(), "literal", null, 0, 1, EAppExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(eAppExpressionEClass, ecorePackage.getEBoolean(), "computeBoolean", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "contextRoot", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "contextThis", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(eAppSettingTypeEClass, EAppSettingType.class, "EAppSettingType", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEAppSettingType_ReadOnly(), ecorePackage.getEBoolean(), "readOnly", null, 1, 1, EAppSettingType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEAppSettingType_Constraint(), this.getEAppExpression(), null, "constraint", null, 0, 1, EAppSettingType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEAppSettingType_Relevant(), this.getEAppExpression(), null, "relevant", null, 0, 1, EAppSettingType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAppSettingType_Required(), ecorePackage.getEBoolean(), "required", null, 1, 1, EAppSettingType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAppSettingType_Deprecated(), ecorePackage.getEBoolean(), "deprecated", null, 1, 1, EAppSettingType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eAppSimpleTypeEClass, EAppSimpleType.class, "EAppSimpleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEAppSimpleType_Type(), this.getEAppValueType(), "type", null, 1, 1, EAppSimpleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eAppSequenceTypeEClass, EAppSequenceType.class, "EAppSequenceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEAppSequenceType_MinOccurs(), ecorePackage.getEIntegerObject(), "minOccurs", null, 0, 1, EAppSequenceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAppSequenceType_MaxOccurs(), ecorePackage.getEIntegerObject(), "maxOccurs", null, 0, 1, EAppSequenceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAppSequenceType_MapKey(), ecorePackage.getEString(), "mapKey", null, 0, 1, EAppSequenceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAppSequenceType_MapValue(), ecorePackage.getEString(), "mapValue", null, 0, 1, EAppSequenceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eAppCompositeTypeEClass, EAppCompositeType.class, "EAppCompositeType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eAppTypeContainerEClass, EAppTypeContainer.class, "EAppTypeContainer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEAppTypeContainer_TypeMap(), this.getEAppSettingTypeEntry(), null, "typeMap", null, 0, -1, EAppTypeContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eAppResourceTypeEClass, EAppResourceType.class, "EAppResourceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEAppResourceType_File(), ecorePackage.getEBoolean(), "file", null, 1, 1, EAppResourceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEAppResourceType_LocalPath(), this.getEAppSettingType(), null, "localPath", null, 0, 1, EAppResourceType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEAppResourceType_TargetPath(), this.getEAppSettingType(), null, "targetPath", null, 0, 1, EAppResourceType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eAppSettingOptionEClass, EAppSettingOption.class, "EAppSettingOption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEAppSettingOption_Name(), ecorePackage.getEString(), "name", null, 1, 1, EAppSettingOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAppSettingOption_LiteralValue(), ecorePackage.getEString(), "literalValue", null, 0, 1, EAppSettingOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEAppSettingOption_Relevant(), this.getEAppExpression(), null, "relevant", null, 0, 1, EAppSettingOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAppSettingOption_RefValue(), ecorePackage.getEString(), "refValue", null, 0, 1, EAppSettingOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eAppOptionContainerEClass, EAppOptionContainer.class, "EAppOptionContainer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEAppOptionContainer_Options(), this.getEAppSettingOption(), null, "options", null, 0, -1, EAppOptionContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eAppSettingTypeEntryEClass, Map.Entry.class, "EAppSettingTypeEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEAppSettingTypeEntry_Key(), ecorePackage.getEString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEAppSettingTypeEntry_Value(), this.getEAppSettingType(), null, "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eAppSettingEClass, EAppSetting.class, "EAppSetting", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEAppSetting_RfsInfo(), this.getEAppRfsInfo(), null, "rfsInfo", null, 1, 1, EAppSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEAppSetting_TypeInfo(), this.getEAppSettingType(), null, "typeInfo", null, 1, 1, EAppSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEAppSetting_ValueInfo(), this.getEAppSettingData(), null, "valueInfo", null, 1, 1, EAppSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAppSetting_Ref(), ecorePackage.getEString(), "ref", null, 0, 1, EAppSetting.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(eAppSubSettingDataEntryEClass, Map.Entry.class, "EAppSubSettingDataEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEAppSubSettingDataEntry_Key(), ecorePackage.getEString(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEAppSubSettingDataEntry_Value(), this.getEAppSettingData(), null, "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eAppRfsInfoEClass, EAppRfsInfo.class, "EAppRfsInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEAppRfsInfo_Rfs(), ecorePackage.getEBoolean(), "rfs", null, 1, 1, EAppRfsInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eAppDescriptionContainerEClass, EAppDescriptionContainer.class, "EAppDescriptionContainer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEAppDescriptionContainer_Description(), ecorePackage.getEString(), "description", null, 0, 1, EAppDescriptionContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eAppIconContainerEClass, EAppIconContainer.class, "EAppIconContainer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEAppIconContainer_IconDescriptor(), ecorePackage.getEJavaObject(), "iconDescriptor", null, 0, 1, EAppIconContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAppIconContainer_IconTitle(), ecorePackage.getEString(), "iconTitle", null, 0, 1, EAppIconContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAppIconContainer_IconURI(), this.getEcore_URI(), "iconURI", null, 0, 1, EAppIconContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eAppNamedItemEClass, EAppNamedItem.class, "EAppNamedItem", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEAppNamedItem_Name(), ecorePackage.getEString(), "name", null, 0, 1, EAppNamedItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eAppPropertyContainerEClass, EAppPropertyContainer.class, "EAppPropertyContainer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEAppPropertyContainer_Properties(), this.getEAppProperty(), null, "properties", null, 0, -1, EAppPropertyContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eAppPropertyEClass, EAppProperty.class, "EAppProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEAppProperty_Name(), ecorePackage.getEString(), "name", null, 0, 1, EAppProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAppProperty_Value(), ecorePackage.getEString(), "value", null, 0, 1, EAppProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAppProperty_Unit(), ecorePackage.getEString(), "unit", null, 0, 1, EAppProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eAppResourceEntryEClass, Map.Entry.class, "EAppResourceEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEAppResourceEntry_Key(), this.getEcore_URI(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAppResourceEntry_Value(), this.getEcore_URI(), "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eConfigurationProjectEClass, EConfigurationProject.class, "EConfigurationProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEConfigurationProject_Layers(), this.getEConfMLLayer(), null, "layers", null, 0, -1, EConfigurationProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEConfigurationProject_LastLayer(), this.getEConfMLLayer(), null, "lastLayer", null, 0, 1, EConfigurationProject.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getEConfigurationProject_RootConfml(), this.getEcore_URI(), "rootConfml", null, 0, 1, EConfigurationProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEConfigurationProject_Name(), ecorePackage.getEString(), "name", null, 0, 1, EConfigurationProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEConfigurationProject_Storage(), this.getEStorageClass(), "storage", null, 1, 1, EConfigurationProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEConfigurationProject_ConfVersion(), ecorePackage.getEString(), "confVersion", null, 0, 1, EConfigurationProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEConfigurationProject_DefaultView(), this.getEAppView(), null, "defaultView", null, 0, 1, EConfigurationProject.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getEConfigurationProject_SettingHidden(), ecorePackage.getEBoolean(), "settingHidden", null, 0, 1, EConfigurationProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eAppMetadataEClass, EAppMetadata.class, "EAppMetadata", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEAppMetadata_Date(), ecorePackage.getEString(), "date", null, 0, 1, EAppMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAppMetadata_Owner(), ecorePackage.getEString(), "owner", null, 0, 1, EAppMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAppMetadata_Editor(), ecorePackage.getEString(), "editor", null, 0, 1, EAppMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAppMetadata_Status(), ecorePackage.getEString(), "status", null, 0, 1, EAppMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAppMetadata_Version(), ecorePackage.getEString(), "version", null, 0, 1, EAppMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAppMetadata_Platform(), ecorePackage.getEString(), "platform", null, 0, 1, EAppMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAppMetadata_Product(), ecorePackage.getEString(), "product", null, 0, 1, EAppMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAppMetadata_Release(), ecorePackage.getEString(), "release", null, 0, 1, EAppMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAppMetadata_Customer(), ecorePackage.getEString(), "customer", null, 0, 1, EAppMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAppMetadata_Origin(), ecorePackage.getEString(), "origin", null, 0, 1, EAppMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAppMetadata_Target(), ecorePackage.getEString(), "target", null, 0, 1, EAppMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAppMetadata_MetaId(), ecorePackage.getEString(), "metaId", null, 0, 1, EAppMetadata.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAppMetadata_ConfigurationPropertyMap(), this.getJava_Map_String(), "configurationPropertyMap", null, 0, 1, EAppMetadata.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eAppIncludeElementEClass, EAppIncludeElement.class, "EAppIncludeElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEAppIncludeElement_Source(), this.getEcore_URI(), "source", null, 1, 1, EAppIncludeElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAppIncludeElement_Target(), this.getEcore_URI(), "target", null, 1, 1, EAppIncludeElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eAppTypeConstraintsEClass, EAppTypeConstraints.class, "EAppTypeConstraints", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEAppTypeConstraints_MinInclusive(), ecorePackage.getEJavaObject(), "minInclusive", null, 0, 1, EAppTypeConstraints.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAppTypeConstraints_MaxInclusive(), ecorePackage.getEJavaObject(), "maxInclusive", null, 0, 1, EAppTypeConstraints.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAppTypeConstraints_MinExclusive(), ecorePackage.getEJavaObject(), "minExclusive", null, 0, 1, EAppTypeConstraints.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAppTypeConstraints_MaxExclusive(), ecorePackage.getEJavaObject(), "maxExclusive", null, 0, 1, EAppTypeConstraints.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAppTypeConstraints_MinLength(), ecorePackage.getEIntegerObject(), "minLength", null, 0, 1, EAppTypeConstraints.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAppTypeConstraints_Length(), ecorePackage.getEIntegerObject(), "length", null, 0, 1, EAppTypeConstraints.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAppTypeConstraints_MaxLength(), ecorePackage.getEIntegerObject(), "maxLength", null, 0, 1, EAppTypeConstraints.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAppTypeConstraints_TotalDigits(), ecorePackage.getEIntegerObject(), "totalDigits", null, 0, 1, EAppTypeConstraints.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAppTypeConstraints_Pattern(), ecorePackage.getEString(), "pattern", null, 0, -1, EAppTypeConstraints.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eSourceLocatorEClass, ESourceLocator.class, "ESourceLocator", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getESourceLocator_Uri(), this.getEcore_URI(), "uri", null, 0, -1, ESourceLocator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(eAppValueTypeEEnum, EAppValueType.class, "EAppValueType");
		addEEnumLiteral(eAppValueTypeEEnum, EAppValueType.STRING);
		addEEnumLiteral(eAppValueTypeEEnum, EAppValueType.INTEGER);
		addEEnumLiteral(eAppValueTypeEEnum, EAppValueType.DECIMAL);
		addEEnumLiteral(eAppValueTypeEEnum, EAppValueType.SELECTION);
		addEEnumLiteral(eAppValueTypeEEnum, EAppValueType.BOOLEAN);
		addEEnumLiteral(eAppValueTypeEEnum, EAppValueType.MULTISELECTION);
		addEEnumLiteral(eAppValueTypeEEnum, EAppValueType.DATE);
		addEEnumLiteral(eAppValueTypeEEnum, EAppValueType.TIME);
		addEEnumLiteral(eAppValueTypeEEnum, EAppValueType.DATETIME);
		addEEnumLiteral(eAppValueTypeEEnum, EAppValueType.DURATION);
		addEEnumLiteral(eAppValueTypeEEnum, EAppValueType.LOCAL_FILE);
		addEEnumLiteral(eAppValueTypeEEnum, EAppValueType.LOCAL_FOLDER);

		initEEnum(eStorageClassEEnum, EStorageClass.class, "EStorageClass");
		addEEnumLiteral(eStorageClassEEnum, EStorageClass.PROJECT);
		addEEnumLiteral(eStorageClassEEnum, EStorageClass.PKZIP);
		addEEnumLiteral(eStorageClassEEnum, EStorageClass.SECURE_M0);
		addEEnumLiteral(eStorageClassEEnum, EStorageClass.ENCRYPTED);

		// Initialize data types
		initEDataType(ecore_URIEDataType, URI.class, "Ecore_URI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(java_Map_StringEDataType, Map.class, "Java_Map_String", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "java.util.Map<java.lang.String, java.lang.String>");

		// Create resource
		createResource(eNS_URI);
	}

} //EApplicationPackageImpl
