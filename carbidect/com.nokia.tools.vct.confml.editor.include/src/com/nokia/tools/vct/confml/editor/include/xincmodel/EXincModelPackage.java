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
 * Description: This file is part of com.nokia.tools.vct.confml.editor.include component.
 */

package com.nokia.tools.vct.confml.editor.include.xincmodel;

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
 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EXincModelFactory
 * @model kind="package"
 * @generated
 */
public interface EXincModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "xincmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///xinc-editor";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "xinc";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EXincModelPackage eINSTANCE = com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EXincModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.EResourceContainer <em>EResource Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EResourceContainer
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EXincModelPackageImpl#getEResourceContainer()
	 * @generated
	 */
	int ERESOURCE_CONTAINER = 5;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EDocumentImpl <em>EDocument</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EDocumentImpl
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EXincModelPackageImpl#getEDocument()
	 * @generated
	 */
	int EDOCUMENT = 0;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EIncludeImpl <em>EInclude</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EIncludeImpl
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EXincModelPackageImpl#getEInclude()
	 * @generated
	 */
	int EINCLUDE = 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EProjectResourceImpl <em>EProject Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EProjectResourceImpl
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EXincModelPackageImpl#getEProjectResource()
	 * @generated
	 */
	int EPROJECT_RESOURCE = 3;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EProjectFileImpl <em>EProject File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EProjectFileImpl
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EXincModelPackageImpl#getEProjectFile()
	 * @generated
	 */
	int EPROJECT_FILE = 2;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EProjectFolderImpl <em>EProject Folder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EProjectFolderImpl
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EXincModelPackageImpl#getEProjectFolder()
	 * @generated
	 */
	int EPROJECT_FOLDER = 4;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_CONTAINER__RESOURCES = 0;

	/**
	 * The number of structural features of the '<em>EResource Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERESOURCE_CONTAINER_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDOCUMENT__RESOURCES = ERESOURCE_CONTAINER__RESOURCES;

	/**
	 * The feature id for the '<em><b>Includes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDOCUMENT__INCLUDES = ERESOURCE_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDOCUMENT__VERSION = ERESOURCE_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDOCUMENT__NAME = ERESOURCE_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>EDocument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDOCUMENT_FEATURE_COUNT = ERESOURCE_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Href</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EINCLUDE__HREF = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EINCLUDE__TARGET = 1;

	/**
	 * The number of structural features of the '<em>EInclude</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EINCLUDE_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROJECT_RESOURCE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Project Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROJECT_RESOURCE__PROJECT_PATH = 1;

	/**
	 * The number of structural features of the '<em>EProject Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROJECT_RESOURCE_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROJECT_FILE__NAME = EPROJECT_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Project Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROJECT_FILE__PROJECT_PATH = EPROJECT_RESOURCE__PROJECT_PATH;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROJECT_FILE__RESOURCE = EPROJECT_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Included</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROJECT_FILE__INCLUDED = EPROJECT_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROJECT_FILE__VERSION = EPROJECT_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>EProject File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROJECT_FILE_FEATURE_COUNT = EPROJECT_RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROJECT_FOLDER__NAME = EPROJECT_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Project Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROJECT_FOLDER__PROJECT_PATH = EPROJECT_RESOURCE__PROJECT_PATH;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROJECT_FOLDER__RESOURCES = EPROJECT_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EProject Folder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPROJECT_FOLDER_FEATURE_COUNT = EPROJECT_RESOURCE_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.EConfMLVersion <em>EConf ML Version</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EConfMLVersion
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EXincModelPackageImpl#getEConfMLVersion()
	 * @generated
	 */
	int ECONF_ML_VERSION = 6;


	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.EDocument <em>EDocument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EDocument</em>'.
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EDocument
	 * @generated
	 */
	EClass getEDocument();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.EDocument#getIncludes <em>Includes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Includes</em>'.
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EDocument#getIncludes()
	 * @see #getEDocument()
	 * @generated
	 */
	EReference getEDocument_Includes();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.EDocument#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EDocument#getVersion()
	 * @see #getEDocument()
	 * @generated
	 */
	EAttribute getEDocument_Version();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.EDocument#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EDocument#getName()
	 * @see #getEDocument()
	 * @generated
	 */
	EAttribute getEDocument_Name();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.EInclude <em>EInclude</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EInclude</em>'.
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EInclude
	 * @generated
	 */
	EClass getEInclude();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.EInclude#getHref <em>Href</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Href</em>'.
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EInclude#getHref()
	 * @see #getEInclude()
	 * @generated
	 */
	EAttribute getEInclude_Href();

	/**
	 * Returns the meta object for the reference '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.EInclude#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EInclude#getTarget()
	 * @see #getEInclude()
	 * @generated
	 */
	EReference getEInclude_Target();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.EProjectFile <em>EProject File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EProject File</em>'.
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EProjectFile
	 * @generated
	 */
	EClass getEProjectFile();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.EProjectFile#getResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resource</em>'.
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EProjectFile#getResource()
	 * @see #getEProjectFile()
	 * @generated
	 */
	EAttribute getEProjectFile_Resource();

	/**
	 * Returns the meta object for the reference list '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.EProjectFile#getIncluded <em>Included</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Included</em>'.
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EProjectFile#getIncluded()
	 * @see #getEProjectFile()
	 * @generated
	 */
	EReference getEProjectFile_Included();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.EProjectFile#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EProjectFile#getVersion()
	 * @see #getEProjectFile()
	 * @generated
	 */
	EAttribute getEProjectFile_Version();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.EProjectResource <em>EProject Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EProject Resource</em>'.
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EProjectResource
	 * @generated
	 */
	EClass getEProjectResource();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.EProjectResource#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EProjectResource#getName()
	 * @see #getEProjectResource()
	 * @generated
	 */
	EAttribute getEProjectResource_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.EProjectResource#getProjectPath <em>Project Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project Path</em>'.
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EProjectResource#getProjectPath()
	 * @see #getEProjectResource()
	 * @generated
	 */
	EAttribute getEProjectResource_ProjectPath();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.EProjectFolder <em>EProject Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EProject Folder</em>'.
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EProjectFolder
	 * @generated
	 */
	EClass getEProjectFolder();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.EResourceContainer <em>EResource Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EResource Container</em>'.
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EResourceContainer
	 * @generated
	 */
	EClass getEResourceContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.EResourceContainer#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resources</em>'.
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EResourceContainer#getResources()
	 * @see #getEResourceContainer()
	 * @generated
	 */
	EReference getEResourceContainer_Resources();

	/**
	 * Returns the meta object for enum '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.EConfMLVersion <em>EConf ML Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EConf ML Version</em>'.
	 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EConfMLVersion
	 * @generated
	 */
	EEnum getEConfMLVersion();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EXincModelFactory getEXincModelFactory();

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
		 * The meta object literal for the '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EDocumentImpl <em>EDocument</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EDocumentImpl
		 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EXincModelPackageImpl#getEDocument()
		 * @generated
		 */
		EClass EDOCUMENT = eINSTANCE.getEDocument();

		/**
		 * The meta object literal for the '<em><b>Includes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDOCUMENT__INCLUDES = eINSTANCE.getEDocument_Includes();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDOCUMENT__VERSION = eINSTANCE.getEDocument_Version();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDOCUMENT__NAME = eINSTANCE.getEDocument_Name();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EIncludeImpl <em>EInclude</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EIncludeImpl
		 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EXincModelPackageImpl#getEInclude()
		 * @generated
		 */
		EClass EINCLUDE = eINSTANCE.getEInclude();

		/**
		 * The meta object literal for the '<em><b>Href</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EINCLUDE__HREF = eINSTANCE.getEInclude_Href();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EINCLUDE__TARGET = eINSTANCE.getEInclude_Target();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EProjectFileImpl <em>EProject File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EProjectFileImpl
		 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EXincModelPackageImpl#getEProjectFile()
		 * @generated
		 */
		EClass EPROJECT_FILE = eINSTANCE.getEProjectFile();

		/**
		 * The meta object literal for the '<em><b>Resource</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPROJECT_FILE__RESOURCE = eINSTANCE.getEProjectFile_Resource();

		/**
		 * The meta object literal for the '<em><b>Included</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EPROJECT_FILE__INCLUDED = eINSTANCE.getEProjectFile_Included();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPROJECT_FILE__VERSION = eINSTANCE.getEProjectFile_Version();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EProjectResourceImpl <em>EProject Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EProjectResourceImpl
		 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EXincModelPackageImpl#getEProjectResource()
		 * @generated
		 */
		EClass EPROJECT_RESOURCE = eINSTANCE.getEProjectResource();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPROJECT_RESOURCE__NAME = eINSTANCE.getEProjectResource_Name();

		/**
		 * The meta object literal for the '<em><b>Project Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPROJECT_RESOURCE__PROJECT_PATH = eINSTANCE.getEProjectResource_ProjectPath();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EProjectFolderImpl <em>EProject Folder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EProjectFolderImpl
		 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EXincModelPackageImpl#getEProjectFolder()
		 * @generated
		 */
		EClass EPROJECT_FOLDER = eINSTANCE.getEProjectFolder();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.EResourceContainer <em>EResource Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EResourceContainer
		 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EXincModelPackageImpl#getEResourceContainer()
		 * @generated
		 */
		EClass ERESOURCE_CONTAINER = eINSTANCE.getEResourceContainer();

		/**
		 * The meta object literal for the '<em><b>Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERESOURCE_CONTAINER__RESOURCES = eINSTANCE.getEResourceContainer_Resources();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.confml.editor.include.xincmodel.EConfMLVersion <em>EConf ML Version</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.EConfMLVersion
		 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.impl.EXincModelPackageImpl#getEConfMLVersion()
		 * @generated
		 */
		EEnum ECONF_ML_VERSION = eINSTANCE.getEConfMLVersion();

	}

} //EXincModelPackage
