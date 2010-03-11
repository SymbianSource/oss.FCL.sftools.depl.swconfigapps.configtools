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
package IBY;

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
 * @see IBY.IBYFactory
 * @model kind="package"
 * @generated
 */
public interface IBYPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "IBY";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	String eNS_URI = "http://www.s60.com/xml/iby/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "IBY";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	IBYPackage eINSTANCE = IBY.impl.IBYPackageImpl.init();

	/**
	 * The meta object id for the '{@link IBY.impl.EntityImpl <em>Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see IBY.impl.EntityImpl
	 * @see IBY.impl.IBYPackageImpl#getEntity()
	 * @generated
	 */
	int ENTITY = 0;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__REF = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Gvalue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__GVALUE = 2;

	/**
	 * The number of structural features of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link IBY.impl.IBYFileImpl <em>File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see IBY.impl.IBYFileImpl
	 * @see IBY.impl.IBYPackageImpl#getIBYFile()
	 * @generated
	 */
	int IBY_FILE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IBY_FILE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Locationt</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IBY_FILE__LOCATIONT = 1;

	/**
	 * The feature id for the '<em><b>Entries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IBY_FILE__ENTRIES = 2;

	/**
	 * The feature id for the '<em><b>Flag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IBY_FILE__FLAG = 3;

	/**
	 * The feature id for the '<em><b>Valid Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IBY_FILE__VALID_CONTENT = 4;

	/**
	 * The number of structural features of the '<em>File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IBY_FILE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link IBY.impl.LocationImpl <em>Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see IBY.impl.LocationImpl
	 * @see IBY.impl.IBYPackageImpl#getLocation()
	 * @generated
	 */
	int LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__REF = ENTITY__REF;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__VALUE = ENTITY__VALUE;

	/**
	 * The feature id for the '<em><b>Gvalue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__GVALUE = ENTITY__GVALUE;

	/**
	 * The number of structural features of the '<em>Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link IBY.impl.EntryImpl <em>Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see IBY.impl.EntryImpl
	 * @see IBY.impl.IBYPackageImpl#getEntry()
	 * @generated
	 */
	int ENTRY = 3;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY__TARGET = 1;

	/**
	 * The feature id for the '<em><b>File Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY__FILE_NAME = 2;

	/**
	 * The number of structural features of the '<em>Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link IBY.impl.SrcPathImpl <em>Src Path</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see IBY.impl.SrcPathImpl
	 * @see IBY.impl.IBYPackageImpl#getSrcPath()
	 * @generated
	 */
	int SRC_PATH = 4;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRC_PATH__REF = ENTITY__REF;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRC_PATH__VALUE = ENTITY__VALUE;

	/**
	 * The feature id for the '<em><b>Gvalue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRC_PATH__GVALUE = ENTITY__GVALUE;

	/**
	 * The number of structural features of the '<em>Src Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRC_PATH_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link IBY.impl.TargetPathImpl <em>Target Path</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see IBY.impl.TargetPathImpl
	 * @see IBY.impl.IBYPackageImpl#getTargetPath()
	 * @generated
	 */
	int TARGET_PATH = 5;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_PATH__REF = ENTITY__REF;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_PATH__VALUE = ENTITY__VALUE;

	/**
	 * The feature id for the '<em><b>Gvalue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_PATH__GVALUE = ENTITY__GVALUE;

	/**
	 * The number of structural features of the '<em>Target Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_PATH_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link IBY.impl.Entity2Impl <em>Entity2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see IBY.impl.Entity2Impl
	 * @see IBY.impl.IBYPackageImpl#getEntity2()
	 * @generated
	 */
	int ENTITY2 = 7;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY2__REF = ENTITY__REF;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY2__VALUE = ENTITY__VALUE;

	/**
	 * The feature id for the '<em><b>Gvalue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY2__GVALUE = ENTITY__GVALUE;

	/**
	 * The feature id for the '<em><b>Plugin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY2__PLUGIN = ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Files</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY2__FILES = ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY2__TARGETS = ENTITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY2__COMMENTS = ENTITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Encodings</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY2__ENCODINGS = ENTITY_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Entity2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY2_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link IBY.impl.FileNameImpl <em>File Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see IBY.impl.FileNameImpl
	 * @see IBY.impl.IBYPackageImpl#getFileName()
	 * @generated
	 */
	int FILE_NAME = 6;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_NAME__REF = ENTITY2__REF;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_NAME__VALUE = ENTITY2__VALUE;

	/**
	 * The feature id for the '<em><b>Gvalue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_NAME__GVALUE = ENTITY2__GVALUE;

	/**
	 * The feature id for the '<em><b>Plugin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_NAME__PLUGIN = ENTITY2__PLUGIN;

	/**
	 * The feature id for the '<em><b>Files</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_NAME__FILES = ENTITY2__FILES;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_NAME__TARGETS = ENTITY2__TARGETS;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_NAME__COMMENTS = ENTITY2__COMMENTS;

	/**
	 * The feature id for the '<em><b>Encodings</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_NAME__ENCODINGS = ENTITY2__ENCODINGS;

	/**
	 * The number of structural features of the '<em>File Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_NAME_FEATURE_COUNT = ENTITY2_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link IBY.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity</em>'.
	 * @see IBY.Entity
	 * @generated
	 */
	EClass getEntity();

	/**
	 * Returns the meta object for the attribute '{@link IBY.Entity#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ref</em>'.
	 * @see IBY.Entity#getRef()
	 * @see #getEntity()
	 * @generated
	 */
	EAttribute getEntity_Ref();

	/**
	 * Returns the meta object for the attribute '{@link IBY.Entity#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see IBY.Entity#getValue()
	 * @see #getEntity()
	 * @generated
	 */
	EAttribute getEntity_Value();

	/**
	 * Returns the meta object for the attribute '{@link IBY.Entity#getGvalue <em>Gvalue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gvalue</em>'.
	 * @see IBY.Entity#getGvalue()
	 * @see #getEntity()
	 * @generated
	 */
	EAttribute getEntity_Gvalue();

	/**
	 * Returns the meta object for class '{@link IBY.IBYFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File</em>'.
	 * @see IBY.IBYFile
	 * @generated
	 */
	EClass getIBYFile();

	/**
	 * Returns the meta object for the attribute '{@link IBY.IBYFile#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see IBY.IBYFile#getName()
	 * @see #getIBYFile()
	 * @generated
	 */
	EAttribute getIBYFile_Name();

	/**
	 * Returns the meta object for the containment reference '{@link IBY.IBYFile#getLocationt <em>Locationt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Locationt</em>'.
	 * @see IBY.IBYFile#getLocationt()
	 * @see #getIBYFile()
	 * @generated
	 */
	EReference getIBYFile_Locationt();

	/**
	 * Returns the meta object for the containment reference list '{@link IBY.IBYFile#getEntries <em>Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entries</em>'.
	 * @see IBY.IBYFile#getEntries()
	 * @see #getIBYFile()
	 * @generated
	 */
	EReference getIBYFile_Entries();

	/**
	 * Returns the meta object for the attribute '{@link IBY.IBYFile#getFlag <em>Flag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Flag</em>'.
	 * @see IBY.IBYFile#getFlag()
	 * @see #getIBYFile()
	 * @generated
	 */
	EAttribute getIBYFile_Flag();

	/**
	 * Returns the meta object for the attribute '{@link IBY.IBYFile#isValidContent <em>Valid Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Valid Content</em>'.
	 * @see IBY.IBYFile#isValidContent()
	 * @see #getIBYFile()
	 * @generated
	 */
	EAttribute getIBYFile_ValidContent();

	/**
	 * Returns the meta object for class '{@link IBY.Location <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Location</em>'.
	 * @see IBY.Location
	 * @generated
	 */
	EClass getLocation();

	/**
	 * Returns the meta object for class '{@link IBY.Entry <em>Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entry</em>'.
	 * @see IBY.Entry
	 * @generated
	 */
	EClass getEntry();

	/**
	 * Returns the meta object for the containment reference '{@link IBY.Entry#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see IBY.Entry#getSource()
	 * @see #getEntry()
	 * @generated
	 */
	EReference getEntry_Source();

	/**
	 * Returns the meta object for the containment reference '{@link IBY.Entry#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see IBY.Entry#getTarget()
	 * @see #getEntry()
	 * @generated
	 */
	EReference getEntry_Target();

	/**
	 * Returns the meta object for the containment reference '{@link IBY.Entry#getFileName <em>File Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>File Name</em>'.
	 * @see IBY.Entry#getFileName()
	 * @see #getEntry()
	 * @generated
	 */
	EReference getEntry_FileName();

	/**
	 * Returns the meta object for class '{@link IBY.SrcPath <em>Src Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Src Path</em>'.
	 * @see IBY.SrcPath
	 * @generated
	 */
	EClass getSrcPath();

	/**
	 * Returns the meta object for class '{@link IBY.TargetPath <em>Target Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Path</em>'.
	 * @see IBY.TargetPath
	 * @generated
	 */
	EClass getTargetPath();

	/**
	 * Returns the meta object for class '{@link IBY.FileName <em>File Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Name</em>'.
	 * @see IBY.FileName
	 * @generated
	 */
	EClass getFileName();

	/**
	 * Returns the meta object for class '{@link IBY.Entity2 <em>Entity2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity2</em>'.
	 * @see IBY.Entity2
	 * @generated
	 */
	EClass getEntity2();

	/**
	 * Returns the meta object for the attribute '{@link IBY.Entity2#getPlugin <em>Plugin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Plugin</em>'.
	 * @see IBY.Entity2#getPlugin()
	 * @see #getEntity2()
	 * @generated
	 */
	EAttribute getEntity2_Plugin();

	/**
	 * Returns the meta object for the attribute '{@link IBY.Entity2#getFiles <em>Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Files</em>'.
	 * @see IBY.Entity2#getFiles()
	 * @see #getEntity2()
	 * @generated
	 */
	EAttribute getEntity2_Files();

	/**
	 * Returns the meta object for the attribute '{@link IBY.Entity2#getTargets <em>Targets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Targets</em>'.
	 * @see IBY.Entity2#getTargets()
	 * @see #getEntity2()
	 * @generated
	 */
	EAttribute getEntity2_Targets();

	/**
	 * Returns the meta object for the attribute '{@link IBY.Entity2#getComments <em>Comments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comments</em>'.
	 * @see IBY.Entity2#getComments()
	 * @see #getEntity2()
	 * @generated
	 */
	EAttribute getEntity2_Comments();

	/**
	 * Returns the meta object for the attribute '{@link IBY.Entity2#getEncodings <em>Encodings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Encodings</em>'.
	 * @see IBY.Entity2#getEncodings()
	 * @see #getEntity2()
	 * @generated
	 */
	EAttribute getEntity2_Encodings();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	IBYFactory getIBYFactory();

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
		 * The meta object literal for the '{@link IBY.impl.EntityImpl <em>Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see IBY.impl.EntityImpl
		 * @see IBY.impl.IBYPackageImpl#getEntity()
		 * @generated
		 */
		EClass ENTITY = eINSTANCE.getEntity();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY__REF = eINSTANCE.getEntity_Ref();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY__VALUE = eINSTANCE.getEntity_Value();

		/**
		 * The meta object literal for the '<em><b>Gvalue</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY__GVALUE = eINSTANCE.getEntity_Gvalue();

		/**
		 * The meta object literal for the '{@link IBY.impl.IBYFileImpl <em>File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see IBY.impl.IBYFileImpl
		 * @see IBY.impl.IBYPackageImpl#getIBYFile()
		 * @generated
		 */
		EClass IBY_FILE = eINSTANCE.getIBYFile();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IBY_FILE__NAME = eINSTANCE.getIBYFile_Name();

		/**
		 * The meta object literal for the '<em><b>Locationt</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IBY_FILE__LOCATIONT = eINSTANCE.getIBYFile_Locationt();

		/**
		 * The meta object literal for the '<em><b>Entries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IBY_FILE__ENTRIES = eINSTANCE.getIBYFile_Entries();

		/**
		 * The meta object literal for the '<em><b>Flag</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IBY_FILE__FLAG = eINSTANCE.getIBYFile_Flag();

		/**
		 * The meta object literal for the '<em><b>Valid Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IBY_FILE__VALID_CONTENT = eINSTANCE.getIBYFile_ValidContent();

		/**
		 * The meta object literal for the '{@link IBY.impl.LocationImpl <em>Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see IBY.impl.LocationImpl
		 * @see IBY.impl.IBYPackageImpl#getLocation()
		 * @generated
		 */
		EClass LOCATION = eINSTANCE.getLocation();

		/**
		 * The meta object literal for the '{@link IBY.impl.EntryImpl <em>Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see IBY.impl.EntryImpl
		 * @see IBY.impl.IBYPackageImpl#getEntry()
		 * @generated
		 */
		EClass ENTRY = eINSTANCE.getEntry();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTRY__SOURCE = eINSTANCE.getEntry_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTRY__TARGET = eINSTANCE.getEntry_Target();

		/**
		 * The meta object literal for the '<em><b>File Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTRY__FILE_NAME = eINSTANCE.getEntry_FileName();

		/**
		 * The meta object literal for the '{@link IBY.impl.SrcPathImpl <em>Src Path</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see IBY.impl.SrcPathImpl
		 * @see IBY.impl.IBYPackageImpl#getSrcPath()
		 * @generated
		 */
		EClass SRC_PATH = eINSTANCE.getSrcPath();

		/**
		 * The meta object literal for the '{@link IBY.impl.TargetPathImpl <em>Target Path</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see IBY.impl.TargetPathImpl
		 * @see IBY.impl.IBYPackageImpl#getTargetPath()
		 * @generated
		 */
		EClass TARGET_PATH = eINSTANCE.getTargetPath();

		/**
		 * The meta object literal for the '{@link IBY.impl.FileNameImpl <em>File Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see IBY.impl.FileNameImpl
		 * @see IBY.impl.IBYPackageImpl#getFileName()
		 * @generated
		 */
		EClass FILE_NAME = eINSTANCE.getFileName();

		/**
		 * The meta object literal for the '{@link IBY.impl.Entity2Impl <em>Entity2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see IBY.impl.Entity2Impl
		 * @see IBY.impl.IBYPackageImpl#getEntity2()
		 * @generated
		 */
		EClass ENTITY2 = eINSTANCE.getEntity2();

		/**
		 * The meta object literal for the '<em><b>Plugin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY2__PLUGIN = eINSTANCE.getEntity2_Plugin();

		/**
		 * The meta object literal for the '<em><b>Files</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY2__FILES = eINSTANCE.getEntity2_Files();

		/**
		 * The meta object literal for the '<em><b>Targets</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY2__TARGETS = eINSTANCE.getEntity2_Targets();

		/**
		 * The meta object literal for the '<em><b>Comments</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY2__COMMENTS = eINSTANCE.getEntity2_Comments();

		/**
		 * The meta object literal for the '<em><b>Encodings</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY2__ENCODINGS = eINSTANCE.getEntity2_Encodings();

	}

} //IBYPackage
