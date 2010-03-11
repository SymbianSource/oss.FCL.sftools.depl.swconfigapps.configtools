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
 * Description: This file is part of com.nokia.tools.vct.crml component.
 */

package com.nokia.tools.vct.crml.crmodel.impl;

import com.nokia.tools.vct.crml.crmodel.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.nokia.tools.vct.crml.crmodel.EAccess;
import com.nokia.tools.vct.crml.crmodel.EAccessType;
import com.nokia.tools.vct.crml.crmodel.EBit;
import com.nokia.tools.vct.crml.crmodel.ECRMLDocumentRoot;
import com.nokia.tools.vct.crml.crmodel.ECRMLFactory;
import com.nokia.tools.vct.crml.crmodel.ECRMLPackage;
import com.nokia.tools.vct.crml.crmodel.EContent;
import com.nokia.tools.vct.crml.crmodel.EKey;
import com.nokia.tools.vct.crml.crmodel.EKeyRange;
import com.nokia.tools.vct.crml.crmodel.EKeyType;
import com.nokia.tools.vct.crml.crmodel.EMeta;
import com.nokia.tools.vct.crml.crmodel.ERepository;
import com.nokia.tools.vct.crml.crmodel.EValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ECRMLFactoryImpl extends EFactoryImpl implements ECRMLFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ECRMLFactory init() {
		try {
			ECRMLFactory theECRMLFactory = (ECRMLFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.s60.com/xml/cenrep/1"); 
			if (theECRMLFactory != null) {
				return theECRMLFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ECRMLFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ECRMLFactoryImpl() {
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
			case ECRMLPackage.EMETA: return createEMeta();
			case ECRMLPackage.ECONTENT: return createEContent();
			case ECRMLPackage.EREPOSITORY: return createERepository();
			case ECRMLPackage.EKEY: return createEKey();
			case ECRMLPackage.EKEY_RANGE: return createEKeyRange();
			case ECRMLPackage.EACCESS: return createEAccess();
			case ECRMLPackage.EVALUE: return createEValue();
			case ECRMLPackage.EBIT: return createEBit();
			case ECRMLPackage.ECRML_DOCUMENT_ROOT: return createECRMLDocumentRoot();
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
			case ECRMLPackage.EKEY_TYPE:
				return createEKeyTypeFromString(eDataType, initialValue);
			case ECRMLPackage.EACCESS_TYPE:
				return createEAccessTypeFromString(eDataType, initialValue);
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
			case ECRMLPackage.EKEY_TYPE:
				return convertEKeyTypeToString(eDataType, instanceValue);
			case ECRMLPackage.EACCESS_TYPE:
				return convertEAccessTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMeta createEMeta() {
		EMetaImpl eMeta = new EMetaImpl();
		return eMeta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EContent createEContent() {
		EContentImpl eContent = new EContentImpl();
		return eContent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ERepository createERepository() {
		ERepositoryImpl eRepository = new ERepositoryImpl();
		return eRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EKey createEKey() {
		EKeyImpl eKey = new EKeyImpl();
		return eKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EKeyRange createEKeyRange() {
		EKeyRangeImpl eKeyRange = new EKeyRangeImpl();
		return eKeyRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAccess createEAccess() {
		EAccessImpl eAccess = new EAccessImpl();
		return eAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EValue createEValue() {
		EValueImpl eValue = new EValueImpl();
		return eValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EBit createEBit() {
		EBitImpl eBit = new EBitImpl();
		return eBit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ECRMLDocumentRoot createECRMLDocumentRoot() {
		ECRMLDocumentRootImpl ecrmlDocumentRoot = new ECRMLDocumentRootImpl();
		return ecrmlDocumentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EKeyType createEKeyTypeFromString(EDataType eDataType, String initialValue) {
		EKeyType result = EKeyType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEKeyTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAccessType createEAccessTypeFromString(EDataType eDataType, String initialValue) {
		EAccessType result = EAccessType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEAccessTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ECRMLPackage getECRMLPackage() {
		return (ECRMLPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ECRMLPackage getPackage() {
		return ECRMLPackage.eINSTANCE;
	}

} //ECRMLFactoryImpl
