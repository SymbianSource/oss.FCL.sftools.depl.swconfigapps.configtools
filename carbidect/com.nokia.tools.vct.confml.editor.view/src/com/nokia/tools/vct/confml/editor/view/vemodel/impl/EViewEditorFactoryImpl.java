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
 * Description: This file is part of com.nokia.tools.vct.confml.editor.view component.
 */

package com.nokia.tools.vct.confml.editor.view.vemodel.impl;

import com.nokia.tools.vct.confml.editor.view.vemodel.*;
import java.net.URI;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.nokia.tools.vct.confml.editor.view.vemodel.EFeature;
import com.nokia.tools.vct.confml.editor.view.vemodel.EGroup;
import com.nokia.tools.vct.confml.editor.view.vemodel.ERefOption;
import com.nokia.tools.vct.confml.editor.view.vemodel.ERefProperty;
import com.nokia.tools.vct.confml.editor.view.vemodel.ESetting;
import com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef;
import com.nokia.tools.vct.confml.editor.view.vemodel.EView;
import com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorFactory;
import com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage;
import com.nokia.tools.vct.confml.editor.view.vemodel.EViewsEditorDocument;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EViewEditorFactoryImpl extends EFactoryImpl implements EViewEditorFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EViewEditorFactory init() {
		try {
			EViewEditorFactory theEViewEditorFactory = (EViewEditorFactory)EPackage.Registry.INSTANCE.getEFactory("http://view_editor/1.0"); 
			if (theEViewEditorFactory != null) {
				return theEViewEditorFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EViewEditorFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EViewEditorFactoryImpl() {
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
			case EViewEditorPackage.EVIEWS_EDITOR_DOCUMENT: return createEViewsEditorDocument();
			case EViewEditorPackage.EVIEW: return createEView();
			case EViewEditorPackage.EGROUP: return createEGroup();
			case EViewEditorPackage.ESETTING_REF: return createESettingRef();
			case EViewEditorPackage.EFEATURE: return createEFeature();
			case EViewEditorPackage.ESETTING_ENTRY: return (EObject)createESettingEntry();
			case EViewEditorPackage.EFEATURE_ENTRY: return (EObject)createEFeatureEntry();
			case EViewEditorPackage.ESETTING: return createESetting();
			case EViewEditorPackage.EVIEW_ENTRY: return (EObject)createEViewEntry();
			case EViewEditorPackage.EREF_PROPERTY: return createERefProperty();
			case EViewEditorPackage.EREF_OPTION: return createERefOption();
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
			case EViewEditorPackage.EJAVA_URI:
				return createEJavaURIFromString(eDataType, initialValue);
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
			case EViewEditorPackage.EJAVA_URI:
				return convertEJavaURIToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EViewsEditorDocument createEViewsEditorDocument() {
		EViewsEditorDocumentImpl eViewsEditorDocument = new EViewsEditorDocumentImpl();
		return eViewsEditorDocument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EView createEView() {
		EViewImpl eView = new EViewImpl();
		return eView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EGroup createEGroup() {
		EGroupImpl eGroup = new EGroupImpl();
		return eGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESettingRef createESettingRef() {
		ESettingRefImpl eSettingRef = new ESettingRefImpl();
		return eSettingRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EFeature createEFeature() {
		EFeatureImpl eFeature = new EFeatureImpl();
		return eFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, ESetting> createESettingEntry() {
		ESettingEntryImpl eSettingEntry = new ESettingEntryImpl();
		return eSettingEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, EFeature> createEFeatureEntry() {
		EFeatureEntryImpl eFeatureEntry = new EFeatureEntryImpl();
		return eFeatureEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESetting createESetting() {
		ESettingImpl eSetting = new ESettingImpl();
		return eSetting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, EView> createEViewEntry() {
		EViewEntryImpl eViewEntry = new EViewEntryImpl();
		return eViewEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ERefProperty createERefProperty() {
		ERefPropertyImpl eRefProperty = new ERefPropertyImpl();
		return eRefProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ERefOption createERefOption() {
		ERefOptionImpl eRefOption = new ERefOptionImpl();
		return eRefOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URI createEJavaURIFromString(EDataType eDataType, String initialValue) {
		return (URI)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEJavaURIToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EViewEditorPackage getEViewEditorPackage() {
		return (EViewEditorPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EViewEditorPackage getPackage() {
		return EViewEditorPackage.eINSTANCE;
	}

} //EViewEditorFactoryImpl
