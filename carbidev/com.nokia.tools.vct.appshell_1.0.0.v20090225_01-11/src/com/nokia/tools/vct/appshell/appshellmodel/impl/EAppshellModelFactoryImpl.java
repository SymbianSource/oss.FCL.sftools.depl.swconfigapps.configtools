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
 * Description: This file is part of com.nokia.tools.vct.appshell component.
 */

package com.nokia.tools.vct.appshell.appshellmodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.nokia.tools.vct.appshell.appshellmodel.EApplicationElement;
import com.nokia.tools.vct.appshell.appshellmodel.EAppshellDocument;
import com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelFactory;
import com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage;
import com.nokia.tools.vct.appshell.appshellmodel.EBooleanFlag;
import com.nokia.tools.vct.appshell.appshellmodel.EDataElement;
import com.nokia.tools.vct.appshell.appshellmodel.EFolderElement;
import com.nokia.tools.vct.appshell.appshellmodel.EURLElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EAppshellModelFactoryImpl extends EFactoryImpl implements EAppshellModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EAppshellModelFactory init() {
		try {
			EAppshellModelFactory theEAppshellModelFactory = (EAppshellModelFactory)EPackage.Registry.INSTANCE.getEFactory("http:://www.s60.com/xml/applicationshell/1"); 
			if (theEAppshellModelFactory != null) {
				return theEAppshellModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EAppshellModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAppshellModelFactoryImpl() {
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
			case EAppshellModelPackage.EAPPSHELL_DOCUMENT: return createEAppshellDocument();
			case EAppshellModelPackage.EFOLDER_ELEMENT: return createEFolderElement();
			case EAppshellModelPackage.EAPPLICATION_ELEMENT: return createEApplicationElement();
			case EAppshellModelPackage.EURL_ELEMENT: return createEURLElement();
			case EAppshellModelPackage.EDATA_ELEMENT: return createEDataElement();
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
			case EAppshellModelPackage.EBOOLEAN_FLAG:
				return createEBooleanFlagFromString(eDataType, initialValue);
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
			case EAppshellModelPackage.EBOOLEAN_FLAG:
				return convertEBooleanFlagToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAppshellDocument createEAppshellDocument() {
		EAppshellDocumentImpl eAppshellDocument = new EAppshellDocumentImpl();
		return eAppshellDocument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EFolderElement createEFolderElement() {
		EFolderElementImpl eFolderElement = new EFolderElementImpl();
		return eFolderElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EApplicationElement createEApplicationElement() {
		EApplicationElementImpl eApplicationElement = new EApplicationElementImpl();
		return eApplicationElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EURLElement createEURLElement() {
		EURLElementImpl eurlElement = new EURLElementImpl();
		return eurlElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataElement createEDataElement() {
		EDataElementImpl eDataElement = new EDataElementImpl();
		return eDataElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EBooleanFlag createEBooleanFlagFromString(EDataType eDataType, String initialValue) {
		EBooleanFlag result = EBooleanFlag.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEBooleanFlagToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAppshellModelPackage getEAppshellModelPackage() {
		return (EAppshellModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EAppshellModelPackage getPackage() {
		return EAppshellModelPackage.eINSTANCE;
	}

} //EAppshellModelFactoryImpl
