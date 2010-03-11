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
package cenrep.impl;

import cenrep.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import cenrep.ACCESS_TYPE;
import cenrep.Access;
import cenrep.Bit;
import cenrep.CenrepFactory;
import cenrep.CenrepPackage;
import cenrep.Date;
import cenrep.Editor;
import cenrep.Identification;
import cenrep.Key;
import cenrep.KeyRange;
import cenrep.Meta;
import cenrep.Owner;
import cenrep.Platform;
import cenrep.Product;
import cenrep.Release;
import cenrep.Repository;
import cenrep.Status;
import cenrep.TYPE;
import cenrep.Value;
import cenrep.Version;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CenrepFactoryImpl extends EFactoryImpl implements CenrepFactory {
	
	
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CenrepFactory init() {
		try {
			CenrepFactory theCenrepFactory = (CenrepFactory)EPackage.Registry.INSTANCE.getEFactory("http:///cenrep.ecore"); 
			if (theCenrepFactory != null) {
				return theCenrepFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CenrepFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CenrepFactoryImpl() {
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
			case CenrepPackage.META: return createMeta();
			case CenrepPackage.IDENTIFICATION: return createIdentification();
			case CenrepPackage.DATE: return createDate();
			case CenrepPackage.OWNER: return createOwner();
			case CenrepPackage.EDITOR: return createEditor();
			case CenrepPackage.STATUS: return createStatus();
			case CenrepPackage.VERSION: return createVersion();
			case CenrepPackage.PLATFORM: return createPlatform();
			case CenrepPackage.PRODUCT: return createProduct();
			case CenrepPackage.RELEASE: return createRelease();
			case CenrepPackage.REPOSITORY: return createRepository();
			case CenrepPackage.KEY: return createKey();
			case CenrepPackage.KEY_RANGE: return createKeyRange();
			case CenrepPackage.ACCESS: return createAccess();
			case CenrepPackage.VALUE: return createValue();
			case CenrepPackage.BIT: return createBit();
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
			case CenrepPackage.TYPE:
				return createTYPEFromString(eDataType, initialValue);
			case CenrepPackage.ACCESS_TYPE:
				return createACCESS_TYPEFromString(eDataType, initialValue);
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
			case CenrepPackage.TYPE:
				return convertTYPEToString(eDataType, instanceValue);
			case CenrepPackage.ACCESS_TYPE:
				return convertACCESS_TYPEToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Meta createMeta() {
		MetaImpl meta = new MetaImpl();
		return meta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identification createIdentification() {
		IdentificationImpl identification = new IdentificationImpl();
		return identification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date createDate() {
		DateImpl date = new DateImpl();
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Owner createOwner() {
		OwnerImpl owner = new OwnerImpl();
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Editor createEditor() {
		EditorImpl editor = new EditorImpl();
		return editor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Status createStatus() {
		StatusImpl status = new StatusImpl();
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Version createVersion() {
		VersionImpl version = new VersionImpl();
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Platform createPlatform() {
		PlatformImpl platform = new PlatformImpl();
		return platform;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Product createProduct() {
		ProductImpl product = new ProductImpl();
		return product;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Release createRelease() {
		ReleaseImpl release = new ReleaseImpl();
		return release;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Repository createRepository() {
		RepositoryImpl repository = new RepositoryImpl();
		return repository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Key createKey() {
		KeyImpl key = new KeyImpl();
		return key;
	}
	
	public Key createBitmask(){
		Key bitmask = this.createKey();
		Bit bit = this.createBit();
		bit.setNumber(1);
		bitmask.getBits().add(bit);
		return bitmask;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KeyRange createKeyRange() {
		KeyRangeImpl keyRange = new KeyRangeImpl();
		return keyRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Access createAccess() {
		AccessImpl access = new AccessImpl();
		return access;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Value createValue() {
		ValueImpl value = new ValueImpl();
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bit createBit() {
		BitImpl bit = new BitImpl();
		return bit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TYPE createTYPEFromString(EDataType eDataType, String initialValue) {
		TYPE result = TYPE.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTYPEToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ACCESS_TYPE createACCESS_TYPEFromString(EDataType eDataType, String initialValue) {
		ACCESS_TYPE result = ACCESS_TYPE.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertACCESS_TYPEToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CenrepPackage getCenrepPackage() {
		return (CenrepPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CenrepPackage getPackage() {
		return CenrepPackage.eINSTANCE;
	}

} //CenrepFactoryImpl
