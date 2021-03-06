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
 * Description: This file is part of com.nokia.tools.vct.confml component.
 */

package com.nokia.tools.vct.confml.model.confml1.util;

import com.nokia.tools.vct.confml.model.confml1.*;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.nokia.tools.vct.confml.model.confml1.ECommonAttrs;
import com.nokia.tools.vct.confml.model.confml1.EConfML1Package;
import com.nokia.tools.vct.confml.model.confml1.EConfMLDocument;
import com.nokia.tools.vct.confml.model.confml1.EConfigurationElement;
import com.nokia.tools.vct.confml.model.confml1.EDataElement;
import com.nokia.tools.vct.confml.model.confml1.EDescriptionContainer;
import com.nokia.tools.vct.confml.model.confml1.EDescriptionElement;
import com.nokia.tools.vct.confml.model.confml1.EFeatureData;
import com.nokia.tools.vct.confml.model.confml1.EFeatureElement;
import com.nokia.tools.vct.confml.model.confml1.EFeatureRfs;
import com.nokia.tools.vct.confml.model.confml1.EGroup;
import com.nokia.tools.vct.confml.model.confml1.EGroupContainer;
import com.nokia.tools.vct.confml.model.confml1.EIconContainer;
import com.nokia.tools.vct.confml.model.confml1.EIconElement;
import com.nokia.tools.vct.confml.model.confml1.ELinkContainer;
import com.nokia.tools.vct.confml.model.confml1.ELinkElement;
import com.nokia.tools.vct.confml.model.confml1.EMetaContainer;
import com.nokia.tools.vct.confml.model.confml1.EMetaContent;
import com.nokia.tools.vct.confml.model.confml1.EMetaElement;
import com.nokia.tools.vct.confml.model.confml1.EOptionElement;
import com.nokia.tools.vct.confml.model.confml1.EPropertyElement;
import com.nokia.tools.vct.confml.model.confml1.ERefNamedElement;
import com.nokia.tools.vct.confml.model.confml1.ERfsElement;
import com.nokia.tools.vct.confml.model.confml1.ESettingData;
import com.nokia.tools.vct.confml.model.confml1.ESettingDataContainer;
import com.nokia.tools.vct.confml.model.confml1.ESettingElement;
import com.nokia.tools.vct.confml.model.confml1.ESettingRfs;
import com.nokia.tools.vct.confml.model.confml1.ESettingRfsContainer;
import com.nokia.tools.vct.confml.model.confml1.ESettingTypeContainer;
import com.nokia.tools.vct.confml.model.confml1.EViewElement;
import com.nokia.tools.vct.confml.model.confml1.EXLinkReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.nokia.tools.vct.confml.model.confml1.EConfML1Package
 * @generated
 */
public class EConfML1AdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EConfML1Package modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EConfML1AdapterFactory() {
		if (modelPackage == null) {
			modelPackage = EConfML1Package.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EConfML1Switch<Adapter> modelSwitch = new EConfML1Switch<Adapter>() {
		@Override
		public Adapter caseEConfigurationElement(EConfigurationElement object) {
			return createEConfigurationElementAdapter();
		}

		@Override
		public Adapter caseEContents(EObject object) {
			return createEContentsAdapter();
		}

		@Override
		public Adapter caseEFeatureElement(EFeatureElement object) {
			return createEFeatureElementAdapter();
		}

		@Override
		public Adapter caseEFeatureData(EFeatureData object) {
			return createEFeatureDataAdapter();
		}

		@Override
		public Adapter caseESettingTypeContainer(ESettingTypeContainer object) {
			return createESettingTypeContainerAdapter();
		}

		@Override
		public Adapter caseESettingElement(ESettingElement object) {
			return createESettingElementAdapter();
		}

		@Override
		public Adapter caseESettingDataContainer(ESettingDataContainer object) {
			return createESettingDataContainerAdapter();
		}

		@Override
		public Adapter caseESettingData(ESettingData object) {
			return createESettingDataAdapter();
		}

		@Override
		public Adapter caseEViewElement(EViewElement object) {
			return createEViewElementAdapter();
		}

		@Override
		public Adapter caseEGroup(EGroup object) {
			return createEGroupAdapter();
		}

		@Override
		public Adapter caseEGroupContainer(EGroupContainer object) {
			return createEGroupContainerAdapter();
		}

		@Override
		public Adapter caseEFeatureRfs(EFeatureRfs object) {
			return createEFeatureRfsAdapter();
		}

		@Override
		public Adapter caseESettingRfs(ESettingRfs object) {
			return createESettingRfsAdapter();
		}

		@Override
		public Adapter caseEMetaContainer(EMetaContainer object) {
			return createEMetaContainerAdapter();
		}

		@Override
		public Adapter caseEMetaElement(EMetaElement object) {
			return createEMetaElementAdapter();
		}

		@Override
		public Adapter caseEOptionElement(EOptionElement object) {
			return createEOptionElementAdapter();
		}

		@Override
		public Adapter caseEPropertyElement(EPropertyElement object) {
			return createEPropertyElementAdapter();
		}

		@Override
		public Adapter caseEDescriptionContainer(EDescriptionContainer object) {
			return createEDescriptionContainerAdapter();
		}

		@Override
		public Adapter caseEDescriptionElement(EDescriptionElement object) {
			return createEDescriptionElementAdapter();
		}

		@Override
		public Adapter caseEIconContainer(EIconContainer object) {
			return createEIconContainerAdapter();
		}

		@Override
		public Adapter caseEIconElement(EIconElement object) {
			return createEIconElementAdapter();
		}

		@Override
		public Adapter caseELinkContainer(ELinkContainer object) {
			return createELinkContainerAdapter();
		}

		@Override
		public Adapter caseELinkElement(ELinkElement object) {
			return createELinkElementAdapter();
		}

		@Override
		public Adapter caseEDataElement(EDataElement object) {
			return createEDataElementAdapter();
		}

		@Override
		public Adapter caseERfsElement(ERfsElement object) {
			return createERfsElementAdapter();
		}

		@Override
		public Adapter caseEXLinkReference(EXLinkReference object) {
			return createEXLinkReferenceAdapter();
		}

		@Override
		public Adapter caseECommonAttrs(ECommonAttrs object) {
			return createECommonAttrsAdapter();
		}

		@Override
		public Adapter caseEMetaContent(EMetaContent object) {
			return createEMetaContentAdapter();
		}

		@Override
		public Adapter caseERefNamedElement(ERefNamedElement object) {
			return createERefNamedElementAdapter();
		}

		@Override
		public Adapter caseEConfMLDocument(EConfMLDocument object) {
			return createEConfMLDocumentAdapter();
		}

		@Override
		public Adapter caseESettingRfsContainer(ESettingRfsContainer object) {
			return createESettingRfsContainerAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.confml1.EConfigurationElement <em>EConfiguration Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.confml1.EConfigurationElement
	 * @generated
	 */
	public Adapter createEConfigurationElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecore.EObject <em>EContents</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecore.EObject
	 * @generated
	 */
	public Adapter createEContentsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.confml1.EFeatureElement <em>EFeature Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.confml1.EFeatureElement
	 * @generated
	 */
	public Adapter createEFeatureElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.confml1.EFeatureData <em>EFeature Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.confml1.EFeatureData
	 * @generated
	 */
	public Adapter createEFeatureDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.confml1.ESettingTypeContainer <em>ESetting Type Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.confml1.ESettingTypeContainer
	 * @generated
	 */
	public Adapter createESettingTypeContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.confml1.ESettingElement <em>ESetting Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.confml1.ESettingElement
	 * @generated
	 */
	public Adapter createESettingElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.confml1.ESettingDataContainer <em>ESetting Data Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.confml1.ESettingDataContainer
	 * @generated
	 */
	public Adapter createESettingDataContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.confml1.ESettingData <em>ESetting Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.confml1.ESettingData
	 * @generated
	 */
	public Adapter createESettingDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.confml1.EViewElement <em>EView Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.confml1.EViewElement
	 * @generated
	 */
	public Adapter createEViewElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.confml1.EGroup <em>EGroup</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.confml1.EGroup
	 * @generated
	 */
	public Adapter createEGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.confml1.EGroupContainer <em>EGroup Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.confml1.EGroupContainer
	 * @generated
	 */
	public Adapter createEGroupContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.confml1.EFeatureRfs <em>EFeature Rfs</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.confml1.EFeatureRfs
	 * @generated
	 */
	public Adapter createEFeatureRfsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.confml1.ESettingRfs <em>ESetting Rfs</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.confml1.ESettingRfs
	 * @generated
	 */
	public Adapter createESettingRfsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.confml1.EMetaContainer <em>EMeta Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.confml1.EMetaContainer
	 * @generated
	 */
	public Adapter createEMetaContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.confml1.EMetaElement <em>EMeta Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.confml1.EMetaElement
	 * @generated
	 */
	public Adapter createEMetaElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.confml1.EOptionElement <em>EOption Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.confml1.EOptionElement
	 * @generated
	 */
	public Adapter createEOptionElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.confml1.EPropertyElement <em>EProperty Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.confml1.EPropertyElement
	 * @generated
	 */
	public Adapter createEPropertyElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.confml1.EDescriptionContainer <em>EDescription Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.confml1.EDescriptionContainer
	 * @generated
	 */
	public Adapter createEDescriptionContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.confml1.EDescriptionElement <em>EDescription Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.confml1.EDescriptionElement
	 * @generated
	 */
	public Adapter createEDescriptionElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.confml1.EIconContainer <em>EIcon Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.confml1.EIconContainer
	 * @generated
	 */
	public Adapter createEIconContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.confml1.EIconElement <em>EIcon Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.confml1.EIconElement
	 * @generated
	 */
	public Adapter createEIconElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.confml1.ELinkContainer <em>ELink Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.confml1.ELinkContainer
	 * @generated
	 */
	public Adapter createELinkContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.confml1.ELinkElement <em>ELink Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.confml1.ELinkElement
	 * @generated
	 */
	public Adapter createELinkElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.confml1.EDataElement <em>EData Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.confml1.EDataElement
	 * @generated
	 */
	public Adapter createEDataElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.confml1.ERfsElement <em>ERfs Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.confml1.ERfsElement
	 * @generated
	 */
	public Adapter createERfsElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.confml1.EXLinkReference <em>EX Link Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.confml1.EXLinkReference
	 * @generated
	 */
	public Adapter createEXLinkReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.confml1.ECommonAttrs <em>ECommon Attrs</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.confml1.ECommonAttrs
	 * @generated
	 */
	public Adapter createECommonAttrsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.confml1.EMetaContent <em>EMeta Content</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.confml1.EMetaContent
	 * @generated
	 */
	public Adapter createEMetaContentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.confml1.ERefNamedElement <em>ERef Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.confml1.ERefNamedElement
	 * @generated
	 */
	public Adapter createERefNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.confml1.EConfMLDocument <em>EConf ML Document</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.confml1.EConfMLDocument
	 * @generated
	 */
	public Adapter createEConfMLDocumentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.confml1.ESettingRfsContainer <em>ESetting Rfs Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.confml1.ESettingRfsContainer
	 * @generated
	 */
	public Adapter createESettingRfsContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //EConfML1AdapterFactory
