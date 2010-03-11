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
 * Description: This file is part of com.nokia.tools.vct.gcfml component.
 */

package com.nokia.tools.vct.gcfml.gcfmlmodel;

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
 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.EGCFMLFactory
 * @model kind="package"
 * @generated
 */
public interface EGCFMLPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "gcfmlmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.s60.com/xml/gcfml/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "gcfml";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eCONTENT_TYPE = "com.nokia.tools.vct.content.gcfml";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EGCFMLPackage eINSTANCE = com.nokia.tools.vct.gcfml.gcfmlmodel.impl.EGCFMLPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.impl.EFileImpl <em>EFile</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.impl.EFileImpl
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.impl.EGCFMLPackageImpl#getEFile()
	 * @generated
	 */
	int EFILE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFILE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFILE__TARGET = 1;

	/**
	 * The feature id for the '<em><b>Setting</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFILE__SETTING = 2;

	/**
	 * The feature id for the '<em><b>Stylesheet</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFILE__STYLESHEET = 3;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFILE__LOCATION = 4;

	/**
	 * The number of structural features of the '<em>EFile</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFILE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.impl.ESettingImpl <em>ESetting</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.impl.ESettingImpl
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.impl.EGCFMLPackageImpl#getESetting()
	 * @generated
	 */
	int ESETTING = 1;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING__REF = 0;

	/**
	 * The number of structural features of the '<em>ESetting</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESETTING_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.impl.EGCFMLDocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.impl.EGCFMLDocumentRootImpl
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.impl.EGCFMLPackageImpl#getEGCFMLDocumentRoot()
	 * @generated
	 */
	int EGCFML_DOCUMENT_ROOT = 2;

	/**
	 * The feature id for the '<em><b>File</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EGCFML_DOCUMENT_ROOT__FILE = 0;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EGCFML_DOCUMENT_ROOT_FEATURE_COUNT = 1;


	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.impl.EStylesheetImpl <em>EStylesheet</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.impl.EStylesheetImpl
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.impl.EGCFMLPackageImpl#getEStylesheet()
	 * @generated
	 */
	int ESTYLESHEET = 3;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTYLESHEET__VERSION = 0;

	/**
	 * The feature id for the '<em><b>Output</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTYLESHEET__OUTPUT = 1;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTYLESHEET__CONTENT = 2;

	/**
	 * The number of structural features of the '<em>EStylesheet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTYLESHEET_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.impl.EOutputImpl <em>EOutput</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.impl.EOutputImpl
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.impl.EGCFMLPackageImpl#getEOutput()
	 * @generated
	 */
	int EOUTPUT = 4;

	/**
	 * The feature id for the '<em><b>Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOUTPUT__METHOD = 0;

	/**
	 * The feature id for the '<em><b>Encoding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOUTPUT__ENCODING = 1;

	/**
	 * The feature id for the '<em><b>Indent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOUTPUT__INDENT = 2;

	/**
	 * The number of structural features of the '<em>EOutput</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOUTPUT_FEATURE_COUNT = 3;

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EFile <em>EFile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EFile</em>'.
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.EFile
	 * @generated
	 */
	EClass getEFile();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EFile#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.EFile#getName()
	 * @see #getEFile()
	 * @generated
	 */
	EAttribute getEFile_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EFile#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target</em>'.
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.EFile#getTarget()
	 * @see #getEFile()
	 * @generated
	 */
	EAttribute getEFile_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EFile#getSetting <em>Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Setting</em>'.
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.EFile#getSetting()
	 * @see #getEFile()
	 * @generated
	 */
	EReference getEFile_Setting();

	/**
	 * Returns the meta object for the containment reference '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EFile#getStylesheet <em>Stylesheet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Stylesheet</em>'.
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.EFile#getStylesheet()
	 * @see #getEFile()
	 * @generated
	 */
	EReference getEFile_Stylesheet();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EFile#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.EFile#getLocation()
	 * @see #getEFile()
	 * @generated
	 */
	EAttribute getEFile_Location();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.ESetting <em>ESetting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ESetting</em>'.
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.ESetting
	 * @generated
	 */
	EClass getESetting();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.ESetting#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ref</em>'.
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.ESetting#getRef()
	 * @see #getESetting()
	 * @generated
	 */
	EAttribute getESetting_Ref();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EGCFMLDocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.EGCFMLDocumentRoot
	 * @generated
	 */
	EClass getEGCFMLDocumentRoot();

	/**
	 * Returns the meta object for the containment reference '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EGCFMLDocumentRoot#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>File</em>'.
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.EGCFMLDocumentRoot#getFile()
	 * @see #getEGCFMLDocumentRoot()
	 * @generated
	 */
	EReference getEGCFMLDocumentRoot_File();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EStylesheet <em>EStylesheet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EStylesheet</em>'.
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.EStylesheet
	 * @generated
	 */
	EClass getEStylesheet();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EStylesheet#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.EStylesheet#getVersion()
	 * @see #getEStylesheet()
	 * @generated
	 */
	EAttribute getEStylesheet_Version();

	/**
	 * Returns the meta object for the containment reference '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EStylesheet#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Output</em>'.
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.EStylesheet#getOutput()
	 * @see #getEStylesheet()
	 * @generated
	 */
	EReference getEStylesheet_Output();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EStylesheet#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.EStylesheet#getContent()
	 * @see #getEStylesheet()
	 * @generated
	 */
	EAttribute getEStylesheet_Content();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EOutput <em>EOutput</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EOutput</em>'.
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.EOutput
	 * @generated
	 */
	EClass getEOutput();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EOutput#getMethod <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Method</em>'.
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.EOutput#getMethod()
	 * @see #getEOutput()
	 * @generated
	 */
	EAttribute getEOutput_Method();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EOutput#getEncoding <em>Encoding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Encoding</em>'.
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.EOutput#getEncoding()
	 * @see #getEOutput()
	 * @generated
	 */
	EAttribute getEOutput_Encoding();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EOutput#getIndent <em>Indent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Indent</em>'.
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.EOutput#getIndent()
	 * @see #getEOutput()
	 * @generated
	 */
	EAttribute getEOutput_Indent();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EGCFMLFactory getEGCFMLFactory();

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
		 * The meta object literal for the '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.impl.EFileImpl <em>EFile</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.impl.EFileImpl
		 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.impl.EGCFMLPackageImpl#getEFile()
		 * @generated
		 */
		EClass EFILE = eINSTANCE.getEFile();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EFILE__NAME = eINSTANCE.getEFile_Name();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EFILE__TARGET = eINSTANCE.getEFile_Target();

		/**
		 * The meta object literal for the '<em><b>Setting</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EFILE__SETTING = eINSTANCE.getEFile_Setting();

		/**
		 * The meta object literal for the '<em><b>Stylesheet</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EFILE__STYLESHEET = eINSTANCE.getEFile_Stylesheet();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EFILE__LOCATION = eINSTANCE.getEFile_Location();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.impl.ESettingImpl <em>ESetting</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.impl.ESettingImpl
		 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.impl.EGCFMLPackageImpl#getESetting()
		 * @generated
		 */
		EClass ESETTING = eINSTANCE.getESetting();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESETTING__REF = eINSTANCE.getESetting_Ref();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.impl.EGCFMLDocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.impl.EGCFMLDocumentRootImpl
		 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.impl.EGCFMLPackageImpl#getEGCFMLDocumentRoot()
		 * @generated
		 */
		EClass EGCFML_DOCUMENT_ROOT = eINSTANCE.getEGCFMLDocumentRoot();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EGCFML_DOCUMENT_ROOT__FILE = eINSTANCE.getEGCFMLDocumentRoot_File();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.impl.EStylesheetImpl <em>EStylesheet</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.impl.EStylesheetImpl
		 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.impl.EGCFMLPackageImpl#getEStylesheet()
		 * @generated
		 */
		EClass ESTYLESHEET = eINSTANCE.getEStylesheet();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESTYLESHEET__VERSION = eINSTANCE.getEStylesheet_Version();

		/**
		 * The meta object literal for the '<em><b>Output</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESTYLESHEET__OUTPUT = eINSTANCE.getEStylesheet_Output();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESTYLESHEET__CONTENT = eINSTANCE.getEStylesheet_Content();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.impl.EOutputImpl <em>EOutput</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.impl.EOutputImpl
		 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.impl.EGCFMLPackageImpl#getEOutput()
		 * @generated
		 */
		EClass EOUTPUT = eINSTANCE.getEOutput();

		/**
		 * The meta object literal for the '<em><b>Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EOUTPUT__METHOD = eINSTANCE.getEOutput_Method();

		/**
		 * The meta object literal for the '<em><b>Encoding</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EOUTPUT__ENCODING = eINSTANCE.getEOutput_Encoding();

		/**
		 * The meta object literal for the '<em><b>Indent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EOUTPUT__INDENT = eINSTANCE.getEOutput_Indent();

	}

} //EGCFMLPackage
