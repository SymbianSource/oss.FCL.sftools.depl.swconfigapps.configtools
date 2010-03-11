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
 * Description: This file is part of com.nokia.tools.vct.ibyml component.
 */

package com.nokia.tools.vct.ibyml.ibymodel;

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
 * @see com.nokia.tools.vct.ibyml.ibymodel.EIBYModelFactory
 * @model kind="package"
 * @generated
 */
public interface EIBYModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ibymodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.s60.com/xml/iby/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "iby";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eCONTENT_TYPE = "com.nokia.tools.vct.ibyml";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EIBYModelPackage eINSTANCE = com.nokia.tools.vct.ibyml.ibymodel.impl.EIBYModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.ibyml.ibymodel.impl.EEntityImpl <em>EEntity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.ibyml.ibymodel.impl.EEntityImpl
	 * @see com.nokia.tools.vct.ibyml.ibymodel.impl.EIBYModelPackageImpl#getEEntity()
	 * @generated
	 */
	int EENTITY = 0;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENTITY__REF = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENTITY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>EEntity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENTITY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.ibyml.ibymodel.impl.EIBYFileImpl <em>EIBY File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.ibyml.ibymodel.impl.EIBYFileImpl
	 * @see com.nokia.tools.vct.ibyml.ibymodel.impl.EIBYModelPackageImpl#getEIBYFile()
	 * @generated
	 */
	int EIBY_FILE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EIBY_FILE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Flag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EIBY_FILE__FLAG = 1;

	/**
	 * The feature id for the '<em><b>Entries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EIBY_FILE__ENTRIES = 2;

	/**
	 * The feature id for the '<em><b>Locations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EIBY_FILE__LOCATIONS = 3;

	/**
	 * The number of structural features of the '<em>EIBY File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EIBY_FILE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.ibyml.ibymodel.impl.EEntryImpl <em>EEntry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.ibyml.ibymodel.impl.EEntryImpl
	 * @see com.nokia.tools.vct.ibyml.ibymodel.impl.EIBYModelPackageImpl#getEEntry()
	 * @generated
	 */
	int EENTRY = 2;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENTRY__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENTRY__TARGET = 1;

	/**
	 * The feature id for the '<em><b>File Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENTRY__FILE_NAME = 2;

	/**
	 * The number of structural features of the '<em>EEntry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EENTRY_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.ibyml.ibymodel.impl.EFileNameImpl <em>EFile Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.ibyml.ibymodel.impl.EFileNameImpl
	 * @see com.nokia.tools.vct.ibyml.ibymodel.impl.EIBYModelPackageImpl#getEFileName()
	 * @generated
	 */
	int EFILE_NAME = 3;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFILE_NAME__REF = EENTITY__REF;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFILE_NAME__VALUE = EENTITY__VALUE;

	/**
	 * The feature id for the '<em><b>Plugin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFILE_NAME__PLUGIN = EENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Encoding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFILE_NAME__ENCODING = EENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>EFile Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFILE_NAME_FEATURE_COUNT = EENTITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.nokia.tools.vct.ibyml.ibymodel.impl.EIBYDocumentImpl <em>EIBY Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.ibyml.ibymodel.impl.EIBYDocumentImpl
	 * @see com.nokia.tools.vct.ibyml.ibymodel.impl.EIBYModelPackageImpl#getEIBYDocument()
	 * @generated
	 */
	int EIBY_DOCUMENT = 4;

	/**
	 * The feature id for the '<em><b>Root</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EIBY_DOCUMENT__ROOT = 0;

	/**
	 * The number of structural features of the '<em>EIBY Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EIBY_DOCUMENT_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.ibyml.ibymodel.EEntity <em>EEntity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EEntity</em>'.
	 * @see com.nokia.tools.vct.ibyml.ibymodel.EEntity
	 * @generated
	 */
	EClass getEEntity();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.ibyml.ibymodel.EEntity#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ref</em>'.
	 * @see com.nokia.tools.vct.ibyml.ibymodel.EEntity#getRef()
	 * @see #getEEntity()
	 * @generated
	 */
	EAttribute getEEntity_Ref();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.ibyml.ibymodel.EEntity#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.nokia.tools.vct.ibyml.ibymodel.EEntity#getValue()
	 * @see #getEEntity()
	 * @generated
	 */
	EAttribute getEEntity_Value();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.ibyml.ibymodel.EIBYFile <em>EIBY File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EIBY File</em>'.
	 * @see com.nokia.tools.vct.ibyml.ibymodel.EIBYFile
	 * @generated
	 */
	EClass getEIBYFile();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.ibyml.ibymodel.EIBYFile#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.nokia.tools.vct.ibyml.ibymodel.EIBYFile#getName()
	 * @see #getEIBYFile()
	 * @generated
	 */
	EAttribute getEIBYFile_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.ibyml.ibymodel.EIBYFile#getFlag <em>Flag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Flag</em>'.
	 * @see com.nokia.tools.vct.ibyml.ibymodel.EIBYFile#getFlag()
	 * @see #getEIBYFile()
	 * @generated
	 */
	EAttribute getEIBYFile_Flag();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.vct.ibyml.ibymodel.EIBYFile#getEntries <em>Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entries</em>'.
	 * @see com.nokia.tools.vct.ibyml.ibymodel.EIBYFile#getEntries()
	 * @see #getEIBYFile()
	 * @generated
	 */
	EReference getEIBYFile_Entries();

	/**
	 * Returns the meta object for the containment reference list '{@link com.nokia.tools.vct.ibyml.ibymodel.EIBYFile#getLocations <em>Locations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Locations</em>'.
	 * @see com.nokia.tools.vct.ibyml.ibymodel.EIBYFile#getLocations()
	 * @see #getEIBYFile()
	 * @generated
	 */
	EReference getEIBYFile_Locations();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.ibyml.ibymodel.EEntry <em>EEntry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EEntry</em>'.
	 * @see com.nokia.tools.vct.ibyml.ibymodel.EEntry
	 * @generated
	 */
	EClass getEEntry();

	/**
	 * Returns the meta object for the containment reference '{@link com.nokia.tools.vct.ibyml.ibymodel.EEntry#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see com.nokia.tools.vct.ibyml.ibymodel.EEntry#getSource()
	 * @see #getEEntry()
	 * @generated
	 */
	EReference getEEntry_Source();

	/**
	 * Returns the meta object for the containment reference '{@link com.nokia.tools.vct.ibyml.ibymodel.EEntry#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see com.nokia.tools.vct.ibyml.ibymodel.EEntry#getTarget()
	 * @see #getEEntry()
	 * @generated
	 */
	EReference getEEntry_Target();

	/**
	 * Returns the meta object for the containment reference '{@link com.nokia.tools.vct.ibyml.ibymodel.EEntry#getFileName <em>File Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>File Name</em>'.
	 * @see com.nokia.tools.vct.ibyml.ibymodel.EEntry#getFileName()
	 * @see #getEEntry()
	 * @generated
	 */
	EReference getEEntry_FileName();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.ibyml.ibymodel.EFileName <em>EFile Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EFile Name</em>'.
	 * @see com.nokia.tools.vct.ibyml.ibymodel.EFileName
	 * @generated
	 */
	EClass getEFileName();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.ibyml.ibymodel.EFileName#getPlugin <em>Plugin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Plugin</em>'.
	 * @see com.nokia.tools.vct.ibyml.ibymodel.EFileName#getPlugin()
	 * @see #getEFileName()
	 * @generated
	 */
	EAttribute getEFileName_Plugin();

	/**
	 * Returns the meta object for the attribute '{@link com.nokia.tools.vct.ibyml.ibymodel.EFileName#getEncoding <em>Encoding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Encoding</em>'.
	 * @see com.nokia.tools.vct.ibyml.ibymodel.EFileName#getEncoding()
	 * @see #getEFileName()
	 * @generated
	 */
	EAttribute getEFileName_Encoding();

	/**
	 * Returns the meta object for class '{@link com.nokia.tools.vct.ibyml.ibymodel.EIBYDocument <em>EIBY Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EIBY Document</em>'.
	 * @see com.nokia.tools.vct.ibyml.ibymodel.EIBYDocument
	 * @generated
	 */
	EClass getEIBYDocument();

	/**
	 * Returns the meta object for the containment reference '{@link com.nokia.tools.vct.ibyml.ibymodel.EIBYDocument#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Root</em>'.
	 * @see com.nokia.tools.vct.ibyml.ibymodel.EIBYDocument#getRoot()
	 * @see #getEIBYDocument()
	 * @generated
	 */
	EReference getEIBYDocument_Root();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EIBYModelFactory getEIBYModelFactory();

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
		 * The meta object literal for the '{@link com.nokia.tools.vct.ibyml.ibymodel.impl.EEntityImpl <em>EEntity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.ibyml.ibymodel.impl.EEntityImpl
		 * @see com.nokia.tools.vct.ibyml.ibymodel.impl.EIBYModelPackageImpl#getEEntity()
		 * @generated
		 */
		EClass EENTITY = eINSTANCE.getEEntity();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EENTITY__REF = eINSTANCE.getEEntity_Ref();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EENTITY__VALUE = eINSTANCE.getEEntity_Value();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.ibyml.ibymodel.impl.EIBYFileImpl <em>EIBY File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.ibyml.ibymodel.impl.EIBYFileImpl
		 * @see com.nokia.tools.vct.ibyml.ibymodel.impl.EIBYModelPackageImpl#getEIBYFile()
		 * @generated
		 */
		EClass EIBY_FILE = eINSTANCE.getEIBYFile();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EIBY_FILE__NAME = eINSTANCE.getEIBYFile_Name();

		/**
		 * The meta object literal for the '<em><b>Flag</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EIBY_FILE__FLAG = eINSTANCE.getEIBYFile_Flag();

		/**
		 * The meta object literal for the '<em><b>Entries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EIBY_FILE__ENTRIES = eINSTANCE.getEIBYFile_Entries();

		/**
		 * The meta object literal for the '<em><b>Locations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EIBY_FILE__LOCATIONS = eINSTANCE.getEIBYFile_Locations();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.ibyml.ibymodel.impl.EEntryImpl <em>EEntry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.ibyml.ibymodel.impl.EEntryImpl
		 * @see com.nokia.tools.vct.ibyml.ibymodel.impl.EIBYModelPackageImpl#getEEntry()
		 * @generated
		 */
		EClass EENTRY = eINSTANCE.getEEntry();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EENTRY__SOURCE = eINSTANCE.getEEntry_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EENTRY__TARGET = eINSTANCE.getEEntry_Target();

		/**
		 * The meta object literal for the '<em><b>File Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EENTRY__FILE_NAME = eINSTANCE.getEEntry_FileName();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.ibyml.ibymodel.impl.EFileNameImpl <em>EFile Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.ibyml.ibymodel.impl.EFileNameImpl
		 * @see com.nokia.tools.vct.ibyml.ibymodel.impl.EIBYModelPackageImpl#getEFileName()
		 * @generated
		 */
		EClass EFILE_NAME = eINSTANCE.getEFileName();

		/**
		 * The meta object literal for the '<em><b>Plugin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EFILE_NAME__PLUGIN = eINSTANCE.getEFileName_Plugin();

		/**
		 * The meta object literal for the '<em><b>Encoding</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EFILE_NAME__ENCODING = eINSTANCE.getEFileName_Encoding();

		/**
		 * The meta object literal for the '{@link com.nokia.tools.vct.ibyml.ibymodel.impl.EIBYDocumentImpl <em>EIBY Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.nokia.tools.vct.ibyml.ibymodel.impl.EIBYDocumentImpl
		 * @see com.nokia.tools.vct.ibyml.ibymodel.impl.EIBYModelPackageImpl#getEIBYDocument()
		 * @generated
		 */
		EClass EIBY_DOCUMENT = eINSTANCE.getEIBYDocument();

		/**
		 * The meta object literal for the '<em><b>Root</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EIBY_DOCUMENT__ROOT = eINSTANCE.getEIBYDocument_Root();

	}

} //EIBYModelPackage
