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
 * Description: This file is part of com.nokia.tools.variant.confml.core component.
 */

package com.nokia.tools.variant.confml.core.model.metadata;

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
 * @see com.nokia.tools.variant.confml.core.model.metadata.EMetadataFactory
 * @model kind="package"
 * @generated
 */
public interface EMetadataPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "metadata";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.nokia.com/xml/ns/confml-core/metadata-2.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EMetadataPackage eINSTANCE = com.nokia.tools.variant.confml.core.model.metadata.impl.EMetadataPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.metadata.impl.EMetadataImpl <em>EMetadata</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.confml.core.model.metadata.impl.EMetadataImpl
	 * @see com.nokia.tools.variant.confml.core.model.metadata.impl.EMetadataPackageImpl#getEMetadata()
	 * @generated
	 */
	int EMETADATA = 0;

	/**
	 * The feature id for the '<em><b>Components</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETADATA__COMPONENTS = 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETADATA__PROPERTIES = 1;

	/**
	 * The number of structural features of the '<em>EMetadata</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETADATA_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.metadata.impl.EMetaComponentImpl <em>EMeta Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.confml.core.model.metadata.impl.EMetaComponentImpl
	 * @see com.nokia.tools.variant.confml.core.model.metadata.impl.EMetadataPackageImpl#getEMetaComponent()
	 * @generated
	 */
	int EMETA_COMPONENT = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA_COMPONENT__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA_COMPONENT__PATH = 1;

	/**
	 * The number of structural features of the '<em>EMeta Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA_COMPONENT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.metadata.impl.EMetaPropertyImpl <em>EMeta Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.confml.core.model.metadata.impl.EMetaPropertyImpl
	 * @see com.nokia.tools.variant.confml.core.model.metadata.impl.EMetadataPackageImpl#getEMetaProperty()
	 * @generated
	 */
	int EMETA_PROPERTY = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA_PROPERTY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA_PROPERTY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>EMeta Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMETA_PROPERTY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.metadata.impl.ECPFMetadataImpl <em>ECPF Metadata</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.confml.core.model.metadata.impl.ECPFMetadataImpl
	 * @see com.nokia.tools.variant.confml.core.model.metadata.impl.EMetadataPackageImpl#getECPFMetadata()
	 * @generated
	 */
	int ECPF_METADATA = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECPF_METADATA__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECPF_METADATA__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>View Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECPF_METADATA__VIEW_ID = 2;

	/**
	 * The feature id for the '<em><b>Cpf Root File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECPF_METADATA__CPF_ROOT_FILE = 3;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECPF_METADATA__AUTHOR = 4;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECPF_METADATA__VERSION = 5;

	/**
	 * The feature id for the '<em><b>Data Override File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECPF_METADATA__DATA_OVERRIDE_FILE = 6;

	/**
	 * The feature id for the '<em><b>Product</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECPF_METADATA__PRODUCT = 7;

	/**
	 * The feature id for the '<em><b>Platform</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECPF_METADATA__PLATFORM = 8;

	/**
	 * The feature id for the '<em><b>Release</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECPF_METADATA__RELEASE = 9;

	/**
	 * The feature id for the '<em><b>Customer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECPF_METADATA__CUSTOMER = 10;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECPF_METADATA__OWNER = 11;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECPF_METADATA__DATE = 12;

	/**
	 * The number of structural features of the '<em>ECPF Metadata</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECPF_METADATA_FEATURE_COUNT = 13;

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.variant.confml.core.model.metadata.EMetadata <em>EMetadata</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EMetadata</em>'.
	 * @see com.nokia.tools.variant.confml.core.model.metadata.EMetadata
	 * @generated
	 */
	EClass getEMetadata();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.variant.confml.core.model.metadata.EMetadata#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Components</em>'.
	 * @see com.nokia.tools.variant.confml.core.model.metadata.EMetadata#getComponents()
	 * @see #getEMetadata()
	 * @generated
	 */
	EReference getEMetadata_Components();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.variant.confml.core.model.metadata.EMetadata#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see com.nokia.tools.variant.confml.core.model.metadata.EMetadata#getProperties()
	 * @see #getEMetadata()
	 * @generated
	 */
	EReference getEMetadata_Properties();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.variant.confml.core.model.metadata.EMetaComponent <em>EMeta Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EMeta Component</em>'.
	 * @see com.nokia.tools.variant.confml.core.model.metadata.EMetaComponent
	 * @generated
	 */
	EClass getEMetaComponent();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.metadata.EMetaComponent#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.nokia.tools.variant.confml.core.model.metadata.EMetaComponent#getType()
	 * @see #getEMetaComponent()
	 * @generated
	 */
	EAttribute getEMetaComponent_Type();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.metadata.EMetaComponent#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see com.nokia.tools.variant.confml.core.model.metadata.EMetaComponent#getPath()
	 * @see #getEMetaComponent()
	 * @generated
	 */
	EAttribute getEMetaComponent_Path();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.variant.confml.core.model.metadata.EMetaProperty <em>EMeta Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EMeta Property</em>'.
	 * @see com.nokia.tools.variant.confml.core.model.metadata.EMetaProperty
	 * @generated
	 */
	EClass getEMetaProperty();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.metadata.EMetaProperty#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.variant.confml.core.model.metadata.EMetaProperty#getName()
	 * @see #getEMetaProperty()
	 * @generated
	 */
	EAttribute getEMetaProperty_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.metadata.EMetaProperty#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.nokia.tools.variant.confml.core.model.metadata.EMetaProperty#getValue()
	 * @see #getEMetaProperty()
	 * @generated
	 */
	EAttribute getEMetaProperty_Value();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata <em>ECPF Metadata</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ECPF Metadata</em>'.
	 * @see com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata
	 * @generated
	 */
	EClass getECPFMetadata();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getName()
	 * @see #getECPFMetadata()
	 * @generated
	 */
	EAttribute getECPFMetadata_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getDescription()
	 * @see #getECPFMetadata()
	 * @generated
	 */
	EAttribute getECPFMetadata_Description();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getViewId <em>View Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>View Id</em>'.
	 * @see com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getViewId()
	 * @see #getECPFMetadata()
	 * @generated
	 */
	EAttribute getECPFMetadata_ViewId();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getCpfRootFile <em>Cpf Root File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cpf Root File</em>'.
	 * @see com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getCpfRootFile()
	 * @see #getECPFMetadata()
	 * @generated
	 */
	EAttribute getECPFMetadata_CpfRootFile();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Author</em>'.
	 * @see com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getAuthor()
	 * @see #getECPFMetadata()
	 * @generated
	 */
	EAttribute getECPFMetadata_Author();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getVersion()
	 * @see #getECPFMetadata()
	 * @generated
	 */
	EAttribute getECPFMetadata_Version();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getDataOverrideFile <em>Data Override File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Override File</em>'.
	 * @see com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getDataOverrideFile()
	 * @see #getECPFMetadata()
	 * @generated
	 */
	EAttribute getECPFMetadata_DataOverrideFile();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getProduct <em>Product</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Product</em>'.
	 * @see com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getProduct()
	 * @see #getECPFMetadata()
	 * @generated
	 */
	EAttribute getECPFMetadata_Product();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getPlatform <em>Platform</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Platform</em>'.
	 * @see com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getPlatform()
	 * @see #getECPFMetadata()
	 * @generated
	 */
	EAttribute getECPFMetadata_Platform();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getRelease <em>Release</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Release</em>'.
	 * @see com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getRelease()
	 * @see #getECPFMetadata()
	 * @generated
	 */
	EAttribute getECPFMetadata_Release();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getCustomer <em>Customer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Customer</em>'.
	 * @see com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getCustomer()
	 * @see #getECPFMetadata()
	 * @generated
	 */
	EAttribute getECPFMetadata_Customer();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Owner</em>'.
	 * @see com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getOwner()
	 * @see #getECPFMetadata()
	 * @generated
	 */
	EAttribute getECPFMetadata_Owner();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata#getDate()
	 * @see #getECPFMetadata()
	 * @generated
	 */
	EAttribute getECPFMetadata_Date();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EMetadataFactory getEMetadataFactory();

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
		 * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.metadata.impl.EMetadataImpl <em>EMetadata</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.confml.core.model.metadata.impl.EMetadataImpl
		 * @see com.nokia.tools.variant.confml.core.model.metadata.impl.EMetadataPackageImpl#getEMetadata()
		 * @generated
		 */
		EClass EMETADATA = eINSTANCE.getEMetadata();

		/**
		 * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMETADATA__COMPONENTS = eINSTANCE.getEMetadata_Components();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMETADATA__PROPERTIES = eINSTANCE.getEMetadata_Properties();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.metadata.impl.EMetaComponentImpl <em>EMeta Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.confml.core.model.metadata.impl.EMetaComponentImpl
		 * @see com.nokia.tools.variant.confml.core.model.metadata.impl.EMetadataPackageImpl#getEMetaComponent()
		 * @generated
		 */
		EClass EMETA_COMPONENT = eINSTANCE.getEMetaComponent();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMETA_COMPONENT__TYPE = eINSTANCE.getEMetaComponent_Type();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMETA_COMPONENT__PATH = eINSTANCE.getEMetaComponent_Path();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.metadata.impl.EMetaPropertyImpl <em>EMeta Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.confml.core.model.metadata.impl.EMetaPropertyImpl
		 * @see com.nokia.tools.variant.confml.core.model.metadata.impl.EMetadataPackageImpl#getEMetaProperty()
		 * @generated
		 */
		EClass EMETA_PROPERTY = eINSTANCE.getEMetaProperty();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMETA_PROPERTY__NAME = eINSTANCE.getEMetaProperty_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMETA_PROPERTY__VALUE = eINSTANCE.getEMetaProperty_Value();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.metadata.impl.ECPFMetadataImpl <em>ECPF Metadata</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.confml.core.model.metadata.impl.ECPFMetadataImpl
		 * @see com.nokia.tools.variant.confml.core.model.metadata.impl.EMetadataPackageImpl#getECPFMetadata()
		 * @generated
		 */
		EClass ECPF_METADATA = eINSTANCE.getECPFMetadata();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECPF_METADATA__NAME = eINSTANCE.getECPFMetadata_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECPF_METADATA__DESCRIPTION = eINSTANCE.getECPFMetadata_Description();

		/**
		 * The meta object literal for the '<em><b>View Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECPF_METADATA__VIEW_ID = eINSTANCE.getECPFMetadata_ViewId();

		/**
		 * The meta object literal for the '<em><b>Cpf Root File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECPF_METADATA__CPF_ROOT_FILE = eINSTANCE.getECPFMetadata_CpfRootFile();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECPF_METADATA__AUTHOR = eINSTANCE.getECPFMetadata_Author();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECPF_METADATA__VERSION = eINSTANCE.getECPFMetadata_Version();

		/**
		 * The meta object literal for the '<em><b>Data Override File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECPF_METADATA__DATA_OVERRIDE_FILE = eINSTANCE.getECPFMetadata_DataOverrideFile();

		/**
		 * The meta object literal for the '<em><b>Product</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECPF_METADATA__PRODUCT = eINSTANCE.getECPFMetadata_Product();

		/**
		 * The meta object literal for the '<em><b>Platform</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECPF_METADATA__PLATFORM = eINSTANCE.getECPFMetadata_Platform();

		/**
		 * The meta object literal for the '<em><b>Release</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECPF_METADATA__RELEASE = eINSTANCE.getECPFMetadata_Release();

		/**
		 * The meta object literal for the '<em><b>Customer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECPF_METADATA__CUSTOMER = eINSTANCE.getECPFMetadata_Customer();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECPF_METADATA__OWNER = eINSTANCE.getECPFMetadata_Owner();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECPF_METADATA__DATE = eINSTANCE.getECPFMetadata_Date();

	}

} //EMetadataPackage
