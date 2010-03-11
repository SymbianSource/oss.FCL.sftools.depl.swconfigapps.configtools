/**
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
 * $Id$
 */
package com.nokia.tools.carbide.ct.confml.model.confml1.impl;

import com.nokia.tools.carbide.ct.confml.model.confml1.*;

import org.eclipse.emf.ecore.EClass;
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
public class EConfML1FactoryImpl extends EFactoryImpl implements
		EConfML1Factory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EConfML1Factory init() {
		try {
			EConfML1Factory theEConfML1Factory = (EConfML1Factory) EPackage.Registry.INSTANCE
					.getEFactory("http://www.s60.com/xml/confml/1");
			if (theEConfML1Factory != null) {
				return theEConfML1Factory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EConfML1FactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EConfML1FactoryImpl() {
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
		case EConfML1Package.ECONFIGURATION_ELEMENT:
			return createEConfigurationElement();
		case EConfML1Package.EFEATURE_ELEMENT:
			return createEFeatureElement();
		case EConfML1Package.EFEATURE_DATA:
			return createEFeatureData();
		case EConfML1Package.ESETTING_ELEMENT:
			return createESettingElement();
		case EConfML1Package.ESETTING_DATA:
			return createESettingData();
		case EConfML1Package.EVIEW_ELEMENT:
			return createEViewElement();
		case EConfML1Package.EGROUP:
			return createEGroup();
		case EConfML1Package.EFEATURE_RFS:
			return createEFeatureRfs();
		case EConfML1Package.ESETTING_RFS:
			return createESettingRfs();
		case EConfML1Package.EMETA_ELEMENT:
			return createEMetaElement();
		case EConfML1Package.EOPTION_ELEMENT:
			return createEOptionElement();
		case EConfML1Package.EPROPERTY_ELEMENT:
			return createEPropertyElement();
		case EConfML1Package.EDESCRIPTION_ELEMENT:
			return createEDescriptionElement();
		case EConfML1Package.EICON_ELEMENT:
			return createEIconElement();
		case EConfML1Package.ELINK_ELEMENT:
			return createELinkElement();
		case EConfML1Package.EDATA_ELEMENT:
			return createEDataElement();
		case EConfML1Package.ERFS_ELEMENT:
			return createERfsElement();
		case EConfML1Package.ECOMMON_ATTRS:
			return createECommonAttrs();
		case EConfML1Package.EMETA_CONTENT:
			return createEMetaContent();
		case EConfML1Package.EREF_NAMED_ELEMENT:
			return createERefNamedElement();
		case EConfML1Package.ECONF_ML_DOCUMENT:
			return createEConfMLDocument();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName()
					+ "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EConfigurationElement createEConfigurationElement() {
		EConfigurationElementImpl eConfigurationElement = new EConfigurationElementImpl();
		return eConfigurationElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EFeatureElement createEFeatureElement() {
		EFeatureElementImpl eFeatureElement = new EFeatureElementImpl();
		return eFeatureElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EFeatureData createEFeatureData() {
		EFeatureDataImpl eFeatureData = new EFeatureDataImpl();
		return eFeatureData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESettingElement createESettingElement() {
		ESettingElementImpl eSettingElement = new ESettingElementImpl();
		return eSettingElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESettingData createESettingData() {
		ESettingDataImpl eSettingData = new ESettingDataImpl();
		return eSettingData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EViewElement createEViewElement() {
		EViewElementImpl eViewElement = new EViewElementImpl();
		return eViewElement;
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
	public EFeatureRfs createEFeatureRfs() {
		EFeatureRfsImpl eFeatureRfs = new EFeatureRfsImpl();
		return eFeatureRfs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESettingRfs createESettingRfs() {
		ESettingRfsImpl eSettingRfs = new ESettingRfsImpl();
		return eSettingRfs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMetaElement createEMetaElement() {
		EMetaElementImpl eMetaElement = new EMetaElementImpl();
		return eMetaElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOptionElement createEOptionElement() {
		EOptionElementImpl eOptionElement = new EOptionElementImpl();
		return eOptionElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPropertyElement createEPropertyElement() {
		EPropertyElementImpl ePropertyElement = new EPropertyElementImpl();
		return ePropertyElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDescriptionElement createEDescriptionElement() {
		EDescriptionElementImpl eDescriptionElement = new EDescriptionElementImpl();
		return eDescriptionElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EIconElement createEIconElement() {
		EIconElementImpl eIconElement = new EIconElementImpl();
		return eIconElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ELinkElement createELinkElement() {
		ELinkElementImpl eLinkElement = new ELinkElementImpl();
		return eLinkElement;
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
	public ERfsElement createERfsElement() {
		ERfsElementImpl eRfsElement = new ERfsElementImpl();
		return eRfsElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ECommonAttrs createECommonAttrs() {
		ECommonAttrsImpl eCommonAttrs = new ECommonAttrsImpl();
		return eCommonAttrs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMetaContent createEMetaContent() {
		EMetaContentImpl eMetaContent = new EMetaContentImpl();
		return eMetaContent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ERefNamedElement createERefNamedElement() {
		ERefNamedElementImpl eRefNamedElement = new ERefNamedElementImpl();
		return eRefNamedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EConfMLDocument createEConfMLDocument() {
		EConfMLDocumentImpl eConfMLDocument = new EConfMLDocumentImpl();
		return eConfMLDocument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EConfML1Package getEConfML1Package() {
		return (EConfML1Package) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EConfML1Package getPackage() {
		return EConfML1Package.eINSTANCE;
	}

} //EConfML1FactoryImpl