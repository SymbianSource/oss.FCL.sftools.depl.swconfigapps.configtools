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
 * Description: This file is part of com.nokia.tools.variant.resourcelibrary component.
 */

package com.nokia.tools.s60ct.resources.model.impl;

import com.nokia.tools.s60ct.resources.model.*;

import java.io.File;
import java.io.InputStream;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ELibraryModelFactoryImpl extends EFactoryImpl implements ELibraryModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ELibraryModelFactory init() {
		try {
			ELibraryModelFactory theELibraryModelFactory = (ELibraryModelFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.nokia.com/xml/ns/confml-core/resourcelibrary"); 
			if (theELibraryModelFactory != null) {
				return theELibraryModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ELibraryModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ELibraryModelFactoryImpl() {
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
			case ELibraryModelPackage.ELIBRARY_DIRECTORY: return createELibraryDirectory();
			case ELibraryModelPackage.ELIBRARY_FILE: return createELibraryFile();
			case ELibraryModelPackage.ELIBRARY_ROOT: return createELibraryRoot();
			case ELibraryModelPackage.ELIBRARY_THEME_FILE: return createELibraryThemeFile();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ELibraryModelPackage.EPATH:
				return createEPathFromString(eDataType, initialValue);
			case ELibraryModelPackage.INPUT_STREAM:
				return createInputStreamFromString(eDataType, initialValue);
			case ELibraryModelPackage.ICONTENT_TYPE:
				return createIContentTypeFromString(eDataType, initialValue);
			case ELibraryModelPackage.JAVA_IO_FILE:
				return createJAVA_IO_FILEFromString(eDataType, initialValue);
			case ELibraryModelPackage.ECLIPSE_IPATH:
				return createEclipse_IPathFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ELibraryModelPackage.EPATH:
				return convertEPathToString(eDataType, instanceValue);
			case ELibraryModelPackage.INPUT_STREAM:
				return convertInputStreamToString(eDataType, instanceValue);
			case ELibraryModelPackage.ICONTENT_TYPE:
				return convertIContentTypeToString(eDataType, instanceValue);
			case ELibraryModelPackage.JAVA_IO_FILE:
				return convertJAVA_IO_FILEToString(eDataType, instanceValue);
			case ELibraryModelPackage.ECLIPSE_IPATH:
				return convertEclipse_IPathToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ELibraryDirectory createELibraryDirectory() {
		ELibraryDirectoryImpl eLibraryDirectory = new ELibraryDirectoryImpl();
		return eLibraryDirectory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ELibraryFile createELibraryFile() {
		ELibraryFileImpl eLibraryFile = new ELibraryFileImpl();
		return eLibraryFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ELibraryRoot createELibraryRoot() {
		ELibraryRootImpl eLibraryRoot = new ELibraryRootImpl();
		return eLibraryRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ELibraryThemeFile createELibraryThemeFile() {
		ELibraryThemeFileImpl eLibraryThemeFile = new ELibraryThemeFileImpl();
		return eLibraryThemeFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IPath createEPathFromString(EDataType eDataType, String initialValue) {
		return (IPath)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEPathToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputStream createInputStreamFromString(EDataType eDataType, String initialValue) {
		return (InputStream)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertInputStreamToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IContentType createIContentTypeFromString(EDataType eDataType, String initialValue) {
		return (IContentType)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIContentTypeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public File createJAVA_IO_FILEFromString(EDataType eDataType, String initialValue) {
		return (File)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJAVA_IO_FILEToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IPath createEclipse_IPathFromString(EDataType eDataType, String initialValue) {
		return (IPath)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEclipse_IPathToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ELibraryModelPackage getELibraryModelPackage() {
		return (ELibraryModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ELibraryModelPackage getPackage() {
		return ELibraryModelPackage.eINSTANCE;
	}

} //resourcesFactoryImpl
