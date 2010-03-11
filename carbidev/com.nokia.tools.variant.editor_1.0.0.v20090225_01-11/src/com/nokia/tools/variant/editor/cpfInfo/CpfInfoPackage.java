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

package com.nokia.tools.variant.editor.cpfInfo;

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
 * @see com.nokia.tools.variant.editor.cpfInfo.CpfInfoFactory
 * @model kind="package"
 * @generated
 */
public interface CpfInfoPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "cpfInfo";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://cpfInfo";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "cpfInfo";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CpfInfoPackage eINSTANCE = com.nokia.tools.variant.editor.cpfInfo.impl.CpfInfoPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.editor.cpfInfo.impl.CPFImpl <em>CPF</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.editor.cpfInfo.impl.CPFImpl
	 * @see com.nokia.tools.variant.editor.cpfInfo.impl.CpfInfoPackageImpl#getCPF()
	 * @generated
	 */
	int CPF = 0;

	/**
	 * The feature id for the '<em><b>Cpf Info</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPF__CPF_INFO = 0;

	/**
	 * The number of structural features of the '<em>CPF</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPF_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.editor.cpfInfo.impl.CPFInformationImpl <em>CPF Information</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.editor.cpfInfo.impl.CPFInformationImpl
	 * @see com.nokia.tools.variant.editor.cpfInfo.impl.CpfInfoPackageImpl#getCPFInformation()
	 * @generated
	 */
	int CPF_INFORMATION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPF_INFORMATION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPF_INFORMATION__AUTHOR = 1;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPF_INFORMATION__OWNER = 2;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPF_INFORMATION__VERSION = 3;

	/**
	 * The feature id for the '<em><b>Platform</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPF_INFORMATION__PLATFORM = 4;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPF_INFORMATION__DATE = 5;

	/**
	 * The feature id for the '<em><b>Release</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPF_INFORMATION__RELEASE = 6;

	/**
	 * The feature id for the '<em><b>Data File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPF_INFORMATION__DATA_FILE = 7;

	/**
	 * The feature id for the '<em><b>View Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPF_INFORMATION__VIEW_ID = 8;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPF_INFORMATION__DESCRIPTION = 9;

	/**
	 * The feature id for the '<em><b>Product</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPF_INFORMATION__PRODUCT = 10;

	/**
	 * The feature id for the '<em><b>Customer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPF_INFORMATION__CUSTOMER = 11;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPF_INFORMATION__STATUS = 12;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPF_INFORMATION__ORIGIN = 13;

	/**
	 * The feature id for the '<em><b>Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPF_INFORMATION__TARGET = 14;

	/**
	 * The feature id for the '<em><b>Root Conf ML Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPF_INFORMATION__ROOT_CONF_ML_PATH = 15;

	/**
	 * The feature id for the '<em><b>Layer Popup Info Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPF_INFORMATION__LAYER_POPUP_INFO_TEXT = 16;

	/**
	 * The number of structural features of the '<em>CPF Information</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPF_INFORMATION_FEATURE_COUNT = 17;


	/**
	 * Returns the meta object for class '{@link com.nokia.tools.variant.editor.cpfInfo.CPF <em>CPF</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CPF</em>'.
	 * @see com.nokia.tools.variant.editor.cpfInfo.CPF
	 * @generated
	 */
	EClass getCPF();

	/**
	 * Returns the meta object for the reference '{@link com.nokia.tools.variant.editor.cpfInfo.CPF#getCpfInfo <em>Cpf Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Cpf Info</em>'.
	 * @see com.nokia.tools.variant.editor.cpfInfo.CPF#getCpfInfo()
	 * @see #getCPF()
	 * @generated
	 */
	EReference getCPF_CpfInfo();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.variant.editor.cpfInfo.CPFInformation <em>CPF Information</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CPF Information</em>'.
	 * @see com.nokia.tools.variant.editor.cpfInfo.CPFInformation
	 * @generated
	 */
	EClass getCPFInformation();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.editor.cpfInfo.CPFInformation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.variant.editor.cpfInfo.CPFInformation#getName()
	 * @see #getCPFInformation()
	 * @generated
	 */
	EAttribute getCPFInformation_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.editor.cpfInfo.CPFInformation#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Author</em>'.
	 * @see com.nokia.tools.variant.editor.cpfInfo.CPFInformation#getAuthor()
	 * @see #getCPFInformation()
	 * @generated
	 */
	EAttribute getCPFInformation_Author();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.editor.cpfInfo.CPFInformation#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Owner</em>'.
	 * @see com.nokia.tools.variant.editor.cpfInfo.CPFInformation#getOwner()
	 * @see #getCPFInformation()
	 * @generated
	 */
	EAttribute getCPFInformation_Owner();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.editor.cpfInfo.CPFInformation#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see com.nokia.tools.variant.editor.cpfInfo.CPFInformation#getVersion()
	 * @see #getCPFInformation()
	 * @generated
	 */
	EAttribute getCPFInformation_Version();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.editor.cpfInfo.CPFInformation#getPlatform <em>Platform</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Platform</em>'.
	 * @see com.nokia.tools.variant.editor.cpfInfo.CPFInformation#getPlatform()
	 * @see #getCPFInformation()
	 * @generated
	 */
	EAttribute getCPFInformation_Platform();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.editor.cpfInfo.CPFInformation#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see com.nokia.tools.variant.editor.cpfInfo.CPFInformation#getDate()
	 * @see #getCPFInformation()
	 * @generated
	 */
	EAttribute getCPFInformation_Date();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.editor.cpfInfo.CPFInformation#getRelease <em>Release</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Release</em>'.
	 * @see com.nokia.tools.variant.editor.cpfInfo.CPFInformation#getRelease()
	 * @see #getCPFInformation()
	 * @generated
	 */
	EAttribute getCPFInformation_Release();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.editor.cpfInfo.CPFInformation#getDataFile <em>Data File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data File</em>'.
	 * @see com.nokia.tools.variant.editor.cpfInfo.CPFInformation#getDataFile()
	 * @see #getCPFInformation()
	 * @generated
	 */
	EAttribute getCPFInformation_DataFile();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.editor.cpfInfo.CPFInformation#getViewId <em>View Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>View Id</em>'.
	 * @see com.nokia.tools.variant.editor.cpfInfo.CPFInformation#getViewId()
	 * @see #getCPFInformation()
	 * @generated
	 */
	EAttribute getCPFInformation_ViewId();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.editor.cpfInfo.CPFInformation#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.nokia.tools.variant.editor.cpfInfo.CPFInformation#getDescription()
	 * @see #getCPFInformation()
	 * @generated
	 */
	EAttribute getCPFInformation_Description();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.editor.cpfInfo.CPFInformation#getProduct <em>Product</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Product</em>'.
	 * @see com.nokia.tools.variant.editor.cpfInfo.CPFInformation#getProduct()
	 * @see #getCPFInformation()
	 * @generated
	 */
	EAttribute getCPFInformation_Product();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.editor.cpfInfo.CPFInformation#getCustomer <em>Customer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Customer</em>'.
	 * @see com.nokia.tools.variant.editor.cpfInfo.CPFInformation#getCustomer()
	 * @see #getCPFInformation()
	 * @generated
	 */
	EAttribute getCPFInformation_Customer();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.editor.cpfInfo.CPFInformation#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see com.nokia.tools.variant.editor.cpfInfo.CPFInformation#getStatus()
	 * @see #getCPFInformation()
	 * @generated
	 */
	EAttribute getCPFInformation_Status();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.editor.cpfInfo.CPFInformation#getOrigin <em>Origin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Origin</em>'.
	 * @see com.nokia.tools.variant.editor.cpfInfo.CPFInformation#getOrigin()
	 * @see #getCPFInformation()
	 * @generated
	 */
	EAttribute getCPFInformation_Origin();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.editor.cpfInfo.CPFInformation#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target</em>'.
	 * @see com.nokia.tools.variant.editor.cpfInfo.CPFInformation#getTarget()
	 * @see #getCPFInformation()
	 * @generated
	 */
	EAttribute getCPFInformation_Target();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.editor.cpfInfo.CPFInformation#getRootConfMLPath <em>Root Conf ML Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Root Conf ML Path</em>'.
	 * @see com.nokia.tools.variant.editor.cpfInfo.CPFInformation#getRootConfMLPath()
	 * @see #getCPFInformation()
	 * @generated
	 */
	EAttribute getCPFInformation_RootConfMLPath();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.variant.editor.cpfInfo.CPFInformation#getLayerPopupInfoText <em>Layer Popup Info Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Layer Popup Info Text</em>'.
	 * @see com.nokia.tools.variant.editor.cpfInfo.CPFInformation#getLayerPopupInfoText()
	 * @see #getCPFInformation()
	 * @generated
	 */
	EAttribute getCPFInformation_LayerPopupInfoText();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CpfInfoFactory getCpfInfoFactory();

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
		 * The meta object literal for the '{@link com.nokia.tools.variant.editor.cpfInfo.impl.CPFImpl <em>CPF</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.editor.cpfInfo.impl.CPFImpl
		 * @see com.nokia.tools.variant.editor.cpfInfo.impl.CpfInfoPackageImpl#getCPF()
		 * @generated
		 */
		EClass CPF = eINSTANCE.getCPF();

		/**
		 * The meta object literal for the '<em><b>Cpf Info</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CPF__CPF_INFO = eINSTANCE.getCPF_CpfInfo();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.variant.editor.cpfInfo.impl.CPFInformationImpl <em>CPF Information</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.editor.cpfInfo.impl.CPFInformationImpl
		 * @see com.nokia.tools.variant.editor.cpfInfo.impl.CpfInfoPackageImpl#getCPFInformation()
		 * @generated
		 */
		EClass CPF_INFORMATION = eINSTANCE.getCPFInformation();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPF_INFORMATION__NAME = eINSTANCE.getCPFInformation_Name();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPF_INFORMATION__AUTHOR = eINSTANCE.getCPFInformation_Author();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPF_INFORMATION__OWNER = eINSTANCE.getCPFInformation_Owner();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPF_INFORMATION__VERSION = eINSTANCE.getCPFInformation_Version();

		/**
		 * The meta object literal for the '<em><b>Platform</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPF_INFORMATION__PLATFORM = eINSTANCE.getCPFInformation_Platform();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPF_INFORMATION__DATE = eINSTANCE.getCPFInformation_Date();

		/**
		 * The meta object literal for the '<em><b>Release</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPF_INFORMATION__RELEASE = eINSTANCE.getCPFInformation_Release();

		/**
		 * The meta object literal for the '<em><b>Data File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPF_INFORMATION__DATA_FILE = eINSTANCE.getCPFInformation_DataFile();

		/**
		 * The meta object literal for the '<em><b>View Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPF_INFORMATION__VIEW_ID = eINSTANCE.getCPFInformation_ViewId();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPF_INFORMATION__DESCRIPTION = eINSTANCE.getCPFInformation_Description();

		/**
		 * The meta object literal for the '<em><b>Product</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPF_INFORMATION__PRODUCT = eINSTANCE.getCPFInformation_Product();

		/**
		 * The meta object literal for the '<em><b>Customer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPF_INFORMATION__CUSTOMER = eINSTANCE.getCPFInformation_Customer();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPF_INFORMATION__STATUS = eINSTANCE.getCPFInformation_Status();

		/**
		 * The meta object literal for the '<em><b>Origin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPF_INFORMATION__ORIGIN = eINSTANCE.getCPFInformation_Origin();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPF_INFORMATION__TARGET = eINSTANCE.getCPFInformation_Target();

		/**
		 * The meta object literal for the '<em><b>Root Conf ML Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPF_INFORMATION__ROOT_CONF_ML_PATH = eINSTANCE.getCPFInformation_RootConfMLPath();

		/**
		 * The meta object literal for the '<em><b>Layer Popup Info Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPF_INFORMATION__LAYER_POPUP_INFO_TEXT = eINSTANCE.getCPFInformation_LayerPopupInfoText();

	}

} //CpfInfoPackage
