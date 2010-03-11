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

package com.nokia.tools.variant.confml.core.model.core;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see com.nokia.tools.variant.confml.core.model.core.EConfmlRootFactory
 * @model kind="package"
 * @generated
 */
public interface EConfmlRootPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "core";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.nokia.com/xml/ns/confml-core";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ns0";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EConfmlRootPackage eINSTANCE = com.nokia.tools.variant.confml.core.model.core.impl.EConfmlRootPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.core.impl.EBinaryResourceImpl <em>EBinary Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.confml.core.model.core.impl.EBinaryResourceImpl
	 * @see com.nokia.tools.variant.confml.core.model.core.impl.EConfmlRootPackageImpl#getEBinaryResource()
	 * @generated
	 */
	int EBINARY_RESOURCE = 0;

	/**
	 * The number of structural features of the '<em>EBinary Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EBINARY_RESOURCE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.core.impl.EWorkspaceModelImpl <em>EWorkspace Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.confml.core.model.core.impl.EWorkspaceModelImpl
	 * @see com.nokia.tools.variant.confml.core.model.core.impl.EConfmlRootPackageImpl#getEWorkspaceModel()
	 * @generated
	 */
	int EWORKSPACE_MODEL = 1;

	/**
	 * The feature id for the '<em><b>Project Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EWORKSPACE_MODEL__PROJECT_MAP = 0;

	/**
	 * The number of structural features of the '<em>EWorkspace Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EWORKSPACE_MODEL_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.variant.confml.core.model.core.impl.EProjectEntryImpl <em>EProject Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.variant.confml.core.model.core.impl.EProjectEntryImpl
	 * @see com.nokia.tools.variant.confml.core.model.core.impl.EConfmlRootPackageImpl#getEProjectEntry()
	 * @generated
	 */
	int EPROJECT_ENTRY = 2;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROJECT_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROJECT_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>EProject Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROJECT_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.common.appmodel.ESourceLocator <em>ESource Locator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.common.appmodel.ESourceLocator
	 * @see com.nokia.tools.variant.confml.core.model.core.impl.EConfmlRootPackageImpl#getESourceLocator()
	 * @generated
	 */
	int ESOURCE_LOCATOR = 3;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESOURCE_LOCATOR__URI = 0;

	/**
	 * The number of structural features of the '<em>ESource Locator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESOURCE_LOCATOR_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '<em>Eclipse IExtension</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.core.runtime.IExtension
	 * @see com.nokia.tools.variant.confml.core.model.core.impl.EConfmlRootPackageImpl#getEclipse_IExtension()
	 * @generated
	 */
	int ECLIPSE_IEXTENSION = 4;

	/**
	 * The meta object id for the '<em>Java URI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.net.URI
	 * @see com.nokia.tools.variant.confml.core.model.core.impl.EConfmlRootPackageImpl#getJava_URI()
	 * @generated
	 */
	int JAVA_URI = 5;

	/**
	 * The meta object id for the '<em>Eclipse IPath</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.core.runtime.IPath
	 * @see com.nokia.tools.variant.confml.core.model.core.impl.EConfmlRootPackageImpl#getEclipse_IPath()
	 * @generated
	 */
	int ECLIPSE_IPATH = 6;

	/**
	 * The meta object id for the '<em>Eclipse IResource</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.core.resources.IResource
	 * @see com.nokia.tools.variant.confml.core.model.core.impl.EConfmlRootPackageImpl#getEclipse_IResource()
	 * @generated
	 */
	int ECLIPSE_IRESOURCE = 7;

	/**
	 * The meta object id for the '<em>Eclipse IFile</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.core.resources.IFile
	 * @see com.nokia.tools.variant.confml.core.model.core.impl.EConfmlRootPackageImpl#getEclipse_IFile()
	 * @generated
	 */
	int ECLIPSE_IFILE = 8;

	/**
	 * The meta object id for the '<em>Eclipse IProject</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.core.resources.IProject
	 * @see com.nokia.tools.variant.confml.core.model.core.impl.EConfmlRootPackageImpl#getEclipse_IProject()
	 * @generated
	 */
	int ECLIPSE_IPROJECT = 9;


	/**
	 * The meta object id for the '<em>Eclipse Version</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osgi.framework.Version
	 * @see com.nokia.tools.variant.confml.core.model.core.impl.EConfmlRootPackageImpl#getEclipse_Version()
	 * @generated
	 */
	int ECLIPSE_VERSION = 10;


	/**
	 * The meta object id for the '<em>Eclipse IFile Store</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.core.filesystem.IFileStore
	 * @see com.nokia.tools.variant.confml.core.model.core.impl.EConfmlRootPackageImpl#getEclipse_IFileStore()
	 * @generated
	 */
	int ECLIPSE_IFILE_STORE = 11;


	/**
	 * The meta object id for the '<em>Ecore URI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.URI
	 * @see com.nokia.tools.variant.confml.core.model.core.impl.EConfmlRootPackageImpl#getEcore_URI()
	 * @generated
	 */
	int ECORE_URI = 12;


	/**
	 * Returns the meta object for class '{@link com.nokia.tools.variant.confml.core.model.core.EBinaryResource <em>EBinary Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EBinary Resource</em>'.
	 * @see com.nokia.tools.variant.confml.core.model.core.EBinaryResource
	 * @generated
	 */
	EClass getEBinaryResource();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.variant.confml.core.model.core.EWorkspaceModel <em>EWorkspace Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EWorkspace Model</em>'.
	 * @see com.nokia.tools.variant.confml.core.model.core.EWorkspaceModel
	 * @generated
	 */
	EClass getEWorkspaceModel();

	/**
	 * Returns the meta object for the map '{@link com.nokia.tools.variant.confml.core.model.core.EWorkspaceModel#getProjectMap <em>Project Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Project Map</em>'.
	 * @see com.nokia.tools.variant.confml.core.model.core.EWorkspaceModel#getProjectMap()
	 * @see #getEWorkspaceModel()
	 * @generated
	 */
	EReference getEWorkspaceModel_ProjectMap();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>EProject Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EProject Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueType="com.nokia.tools.variant.confml.core.model.application.EConfigurationProject" valueContainment="true" valueRequired="true"
	 * @generated
	 */
	EClass getEProjectEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEProjectEntry()
	 * @generated
	 */
	EAttribute getEProjectEntry_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEProjectEntry()
	 * @generated
	 */
	EReference getEProjectEntry_Value();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.common.appmodel.ESourceLocator <em>ESource Locator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ESource Locator</em>'.
	 * @see com.nokia.tools.vct.common.appmodel.ESourceLocator
	 * @generated
	 */
	EClass getESourceLocator();

	/**
	 * Returns the meta object for the attribute list '{@link com.nokia.tools.vct.common.appmodel.ESourceLocator#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Uri</em>'.
	 * @see com.nokia.tools.vct.common.appmodel.ESourceLocator#getUri()
	 * @see #getESourceLocator()
	 * @generated
	 */
	EAttribute getESourceLocator_Uri();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.core.runtime.IExtension <em>Eclipse IExtension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Eclipse IExtension</em>'.
	 * @see org.eclipse.core.runtime.IExtension
	 * @model instanceClass="org.eclipse.core.runtime.IExtension"
	 * @generated
	 */
	EDataType getEclipse_IExtension();

	/**
	 * Returns the meta object for data type '{@link java.net.URI <em>Java URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Java URI</em>'.
	 * @see java.net.URI
	 * @model instanceClass="java.net.URI"
	 * @generated
	 */
	EDataType getJava_URI();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.core.runtime.IPath <em>Eclipse IPath</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Eclipse IPath</em>'.
	 * @see org.eclipse.core.runtime.IPath
	 * @model instanceClass="org.eclipse.core.runtime.IPath"
	 * @generated
	 */
	EDataType getEclipse_IPath();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.core.resources.IResource <em>Eclipse IResource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Eclipse IResource</em>'.
	 * @see org.eclipse.core.resources.IResource
	 * @model instanceClass="org.eclipse.core.resources.IResource"
	 * @generated
	 */
	EDataType getEclipse_IResource();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.core.resources.IFile <em>Eclipse IFile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Eclipse IFile</em>'.
	 * @see org.eclipse.core.resources.IFile
	 * @model instanceClass="org.eclipse.core.resources.IFile"
	 * @generated
	 */
	EDataType getEclipse_IFile();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.core.resources.IProject <em>Eclipse IProject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Eclipse IProject</em>'.
	 * @see org.eclipse.core.resources.IProject
	 * @model instanceClass="org.eclipse.core.resources.IProject"
	 * @generated
	 */
	EDataType getEclipse_IProject();

	/**
	 * Returns the meta object for data type '{@link org.osgi.framework.Version <em>Eclipse Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Eclipse Version</em>'.
	 * @see org.osgi.framework.Version
	 * @model instanceClass="org.osgi.framework.Version"
	 * @generated
	 */
	EDataType getEclipse_Version();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.core.filesystem.IFileStore <em>Eclipse IFile Store</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Eclipse IFile Store</em>'.
	 * @see org.eclipse.core.filesystem.IFileStore
	 * @model instanceClass="org.eclipse.core.filesystem.IFileStore"
	 * @generated
	 */
	EDataType getEclipse_IFileStore();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.common.util.URI <em>Ecore URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Ecore URI</em>'.
	 * @see org.eclipse.emf.common.util.URI
	 * @model instanceClass="org.eclipse.emf.common.util.URI"
	 * @generated
	 */
	EDataType getEcore_URI();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EConfmlRootFactory getEConfmlRootFactory();

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
		 * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.core.impl.EBinaryResourceImpl <em>EBinary Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.confml.core.model.core.impl.EBinaryResourceImpl
		 * @see com.nokia.tools.variant.confml.core.model.core.impl.EConfmlRootPackageImpl#getEBinaryResource()
		 * @generated
		 */
		EClass EBINARY_RESOURCE = eINSTANCE.getEBinaryResource();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.core.impl.EWorkspaceModelImpl <em>EWorkspace Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.confml.core.model.core.impl.EWorkspaceModelImpl
		 * @see com.nokia.tools.variant.confml.core.model.core.impl.EConfmlRootPackageImpl#getEWorkspaceModel()
		 * @generated
		 */
		EClass EWORKSPACE_MODEL = eINSTANCE.getEWorkspaceModel();

		/**
		 * The meta object literal for the '<em><b>Project Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EWORKSPACE_MODEL__PROJECT_MAP = eINSTANCE.getEWorkspaceModel_ProjectMap();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.variant.confml.core.model.core.impl.EProjectEntryImpl <em>EProject Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.variant.confml.core.model.core.impl.EProjectEntryImpl
		 * @see com.nokia.tools.variant.confml.core.model.core.impl.EConfmlRootPackageImpl#getEProjectEntry()
		 * @generated
		 */
		EClass EPROJECT_ENTRY = eINSTANCE.getEProjectEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPROJECT_ENTRY__KEY = eINSTANCE.getEProjectEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EPROJECT_ENTRY__VALUE = eINSTANCE.getEProjectEntry_Value();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.common.appmodel.ESourceLocator <em>ESource Locator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.common.appmodel.ESourceLocator
		 * @see com.nokia.tools.variant.confml.core.model.core.impl.EConfmlRootPackageImpl#getESourceLocator()
		 * @generated
		 */
		EClass ESOURCE_LOCATOR = eINSTANCE.getESourceLocator();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESOURCE_LOCATOR__URI = eINSTANCE.getESourceLocator_Uri();

		/**
		 * The meta object literal for the '<em>Eclipse IExtension</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.core.runtime.IExtension
		 * @see com.nokia.tools.variant.confml.core.model.core.impl.EConfmlRootPackageImpl#getEclipse_IExtension()
		 * @generated
		 */
		EDataType ECLIPSE_IEXTENSION = eINSTANCE.getEclipse_IExtension();

		/**
		 * The meta object literal for the '<em>Java URI</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.net.URI
		 * @see com.nokia.tools.variant.confml.core.model.core.impl.EConfmlRootPackageImpl#getJava_URI()
		 * @generated
		 */
		EDataType JAVA_URI = eINSTANCE.getJava_URI();

		/**
		 * The meta object literal for the '<em>Eclipse IPath</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.core.runtime.IPath
		 * @see com.nokia.tools.variant.confml.core.model.core.impl.EConfmlRootPackageImpl#getEclipse_IPath()
		 * @generated
		 */
		EDataType ECLIPSE_IPATH = eINSTANCE.getEclipse_IPath();

		/**
		 * The meta object literal for the '<em>Eclipse IResource</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.core.resources.IResource
		 * @see com.nokia.tools.variant.confml.core.model.core.impl.EConfmlRootPackageImpl#getEclipse_IResource()
		 * @generated
		 */
		EDataType ECLIPSE_IRESOURCE = eINSTANCE.getEclipse_IResource();

		/**
		 * The meta object literal for the '<em>Eclipse IFile</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.core.resources.IFile
		 * @see com.nokia.tools.variant.confml.core.model.core.impl.EConfmlRootPackageImpl#getEclipse_IFile()
		 * @generated
		 */
		EDataType ECLIPSE_IFILE = eINSTANCE.getEclipse_IFile();

		/**
		 * The meta object literal for the '<em>Eclipse IProject</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.core.resources.IProject
		 * @see com.nokia.tools.variant.confml.core.model.core.impl.EConfmlRootPackageImpl#getEclipse_IProject()
		 * @generated
		 */
		EDataType ECLIPSE_IPROJECT = eINSTANCE.getEclipse_IProject();

		/**
		 * The meta object literal for the '<em>Eclipse Version</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osgi.framework.Version
		 * @see com.nokia.tools.variant.confml.core.model.core.impl.EConfmlRootPackageImpl#getEclipse_Version()
		 * @generated
		 */
		EDataType ECLIPSE_VERSION = eINSTANCE.getEclipse_Version();

		/**
		 * The meta object literal for the '<em>Eclipse IFile Store</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.core.filesystem.IFileStore
		 * @see com.nokia.tools.variant.confml.core.model.core.impl.EConfmlRootPackageImpl#getEclipse_IFileStore()
		 * @generated
		 */
		EDataType ECLIPSE_IFILE_STORE = eINSTANCE.getEclipse_IFileStore();

		/**
		 * The meta object literal for the '<em>Ecore URI</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.common.util.URI
		 * @see com.nokia.tools.variant.confml.core.model.core.impl.EConfmlRootPackageImpl#getEcore_URI()
		 * @generated
		 */
		EDataType ECORE_URI = eINSTANCE.getEcore_URI();

	}

} //EConfmlRootPackage
