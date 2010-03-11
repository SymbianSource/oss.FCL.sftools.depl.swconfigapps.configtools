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
package IBY.impl;

import IBY.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import IBY.Entry;
import IBY.FileName;
import IBY.IBYFactory;
import IBY.IBYFile;
import IBY.IBYPackage;
import IBY.Location;
import IBY.SrcPath;
import IBY.TargetPath;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class IBYFactoryImpl extends EFactoryImpl implements IBYFactory {
	
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static IBYFactory init() {
		try {
			IBYFactory theIBYFactory = (IBYFactory)EPackage.Registry.INSTANCE.getEFactory(IBYPackage.eNS_URI); 
			if (theIBYFactory != null) {
				return theIBYFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new IBYFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IBYFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case IBYPackage.IBY_FILE: return createIBYFile();
			case IBYPackage.LOCATION: return createLocation();
			case IBYPackage.ENTRY: return createEntry();
			case IBYPackage.SRC_PATH: return createSrcPath();
			case IBYPackage.TARGET_PATH: return createTargetPath();
			case IBYPackage.FILE_NAME: return createFileName();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IBYFile createIBYFile() {
		IBYFileImpl ibyFile = new IBYFileImpl();
		return ibyFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Location createLocation() {
		LocationImpl location = new LocationImpl();
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Entry createEntry() {
		EntryImpl entry = new EntryImpl();
		return entry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SrcPath createSrcPath() {
		SrcPathImpl srcPath = new SrcPathImpl();
		return srcPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public TargetPath createTargetPath() {
		TargetPathImpl targetPath = new TargetPathImpl();
		return targetPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public FileName createFileName() {
		FileNameImpl fileName = new FileNameImpl();
		return fileName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IBYPackage getIBYPackage() {
		return (IBYPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static IBYPackage getPackage() {
		return IBYPackage.eINSTANCE;
	}

} //IBYFactoryImpl
