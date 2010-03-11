/*
* Copyright (c) 2007 Nokia Corporation and/or its subsidiary(-ies). 
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
package com.nokia.tools.s60ct.model.confml.util;

import com.nokia.tools.s60ct.model.confml.*;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.nokia.tools.s60ct.model.confml.ConfmlPackage;
import com.nokia.tools.s60ct.model.confml.ECompositeSetting;
import com.nokia.tools.s60ct.model.confml.ECompositeValue;
import com.nokia.tools.s60ct.model.confml.EDescriptionContainer;
import com.nokia.tools.s60ct.model.confml.EFeature;
import com.nokia.tools.s60ct.model.confml.EIconContainer;
import com.nokia.tools.s60ct.model.confml.EItemSetting;
import com.nokia.tools.s60ct.model.confml.ELinkContainer;
import com.nokia.tools.s60ct.model.confml.EOption;
import com.nokia.tools.s60ct.model.confml.EOptionMap;
import com.nokia.tools.s60ct.model.confml.EProperty;
import com.nokia.tools.s60ct.model.confml.EResourceLocator;
import com.nokia.tools.s60ct.model.confml.EResourceSetting;
import com.nokia.tools.s60ct.model.confml.EResourceValue;
import com.nokia.tools.s60ct.model.confml.ESequenceSetting;
import com.nokia.tools.s60ct.model.confml.ESequenceValue;
import com.nokia.tools.s60ct.model.confml.ESequenceValueItem;
import com.nokia.tools.s60ct.model.confml.ESetting;
import com.nokia.tools.s60ct.model.confml.ESettingContainer;
import com.nokia.tools.s60ct.model.confml.ESettingOption;
import com.nokia.tools.s60ct.model.confml.ESettingValue;
import com.nokia.tools.s60ct.model.confml.ESettingValueContainer;
import com.nokia.tools.s60ct.model.confml.ESimpleSetting;
import com.nokia.tools.s60ct.model.confml.ESimpleValue;
import com.nokia.tools.s60ct.model.confml.ESubSettingValue;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage
 * @generated
 */
public class ConfmlAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ConfmlPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfmlAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ConfmlPackage.eINSTANCE;
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
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfmlSwitch<Adapter> modelSwitch =
		new ConfmlSwitch<Adapter>() {
			@Override
			public Adapter caseEFeature(EFeature object) {
				return createEFeatureAdapter();
			}
			@Override
			public Adapter caseESetting(ESetting object) {
				return createESettingAdapter();
			}
			@Override
			public Adapter caseESettingOption(ESettingOption object) {
				return createESettingOptionAdapter();
			}
			@Override
			public Adapter caseESimpleSetting(ESimpleSetting object) {
				return createESimpleSettingAdapter();
			}
			@Override
			public Adapter caseESequenceSetting(ESequenceSetting object) {
				return createESequenceSettingAdapter();
			}
			@Override
			public Adapter caseEItemSetting(EItemSetting object) {
				return createEItemSettingAdapter();
			}
			@Override
			public Adapter caseESubSettingValue(ESubSettingValue object) {
				return createESubSettingValueAdapter();
			}
			@Override
			public Adapter caseEDescriptionContainer(EDescriptionContainer object) {
				return createEDescriptionContainerAdapter();
			}
			@Override
			public Adapter caseEIconContainer(EIconContainer object) {
				return createEIconContainerAdapter();
			}
			@Override
			public Adapter caseEResourceLocator(EResourceLocator object) {
				return createEResourceLocatorAdapter();
			}
			@Override
			public Adapter caseESettingValue(ESettingValue object) {
				return createESettingValueAdapter();
			}
			@Override
			public Adapter caseECompositeSetting(ECompositeSetting object) {
				return createECompositeSettingAdapter();
			}
			@Override
			public Adapter caseEResourceSetting(EResourceSetting object) {
				return createEResourceSettingAdapter();
			}
			@Override
			public Adapter caseESettingContainer(ESettingContainer object) {
				return createESettingContainerAdapter();
			}
			@Override
			public Adapter caseESimpleValue(ESimpleValue object) {
				return createESimpleValueAdapter();
			}
			@Override
			public Adapter caseESequenceValue(ESequenceValue object) {
				return createESequenceValueAdapter();
			}
			@Override
			public Adapter caseESequenceValueItem(ESequenceValueItem object) {
				return createESequenceValueItemAdapter();
			}
			@Override
			public Adapter caseECompositeValue(ECompositeValue object) {
				return createECompositeValueAdapter();
			}
			@Override
			public Adapter caseESettingValueContainer(ESettingValueContainer object) {
				return createESettingValueContainerAdapter();
			}
			@Override
			public Adapter caseEResourceValue(EResourceValue object) {
				return createEResourceValueAdapter();
			}
			@Override
			public Adapter caseEProperty(EProperty object) {
				return createEPropertyAdapter();
			}
			@Override
			public Adapter caseELinkContainer(ELinkContainer object) {
				return createELinkContainerAdapter();
			}
			@Override
			public Adapter caseEOptionMap(EOptionMap object) {
				return createEOptionMapAdapter();
			}
			@Override
			public Adapter caseEOption(EOption object) {
				return createEOptionAdapter();
			}
			@Override
			public Adapter caseEValueEditorDocument(EValueEditorDocument object) {
				return createEValueEditorDocumentAdapter();
			}
			@Override
			public Adapter casePattern(Pattern object) {
				return createPatternAdapter();
			}
			@Override
			public Adapter caseView(View object) {
				return createViewAdapter();
			}
			@Override
			public Adapter caseEGroup(EGroup object) {
				return createEGroupAdapter();
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
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.s60ct.model.confml.EFeature <em>EFeature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.s60ct.model.confml.EFeature
	 * @generated
	 */
	public Adapter createEFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.s60ct.model.confml.ESetting <em>ESetting</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.s60ct.model.confml.ESetting
	 * @generated
	 */
	public Adapter createESettingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.s60ct.model.confml.ESettingOption <em>ESetting Option</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.s60ct.model.confml.ESettingOption
	 * @generated
	 */
	public Adapter createESettingOptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.s60ct.model.confml.ESimpleSetting <em>ESimple Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.s60ct.model.confml.ESimpleSetting
	 * @generated
	 */
	public Adapter createESimpleSettingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.s60ct.model.confml.ESequenceSetting <em>ESequence Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.s60ct.model.confml.ESequenceSetting
	 * @generated
	 */
	public Adapter createESequenceSettingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.s60ct.model.confml.EItemSetting <em>EItem Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.s60ct.model.confml.EItemSetting
	 * @generated
	 */
	public Adapter createEItemSettingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.s60ct.model.confml.ESubSettingValue <em>ESub Setting Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.s60ct.model.confml.ESubSettingValue
	 * @generated
	 */
	public Adapter createESubSettingValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.s60ct.model.confml.EDescriptionContainer <em>EDescription Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.s60ct.model.confml.EDescriptionContainer
	 * @generated
	 */
	public Adapter createEDescriptionContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.s60ct.model.confml.EIconContainer <em>EIcon Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.s60ct.model.confml.EIconContainer
	 * @generated
	 */
	public Adapter createEIconContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.s60ct.model.confml.EResourceLocator <em>EResource Locator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.s60ct.model.confml.EResourceLocator
	 * @generated
	 */
	public Adapter createEResourceLocatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.s60ct.model.confml.ESettingValue <em>ESetting Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.s60ct.model.confml.ESettingValue
	 * @generated
	 */
	public Adapter createESettingValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.s60ct.model.confml.ECompositeSetting <em>EComposite Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.s60ct.model.confml.ECompositeSetting
	 * @generated
	 */
	public Adapter createECompositeSettingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.s60ct.model.confml.EResourceSetting <em>EResource Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.s60ct.model.confml.EResourceSetting
	 * @generated
	 */
	public Adapter createEResourceSettingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.s60ct.model.confml.ESettingContainer <em>ESetting Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.s60ct.model.confml.ESettingContainer
	 * @generated
	 */
	public Adapter createESettingContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.s60ct.model.confml.ESimpleValue <em>ESimple Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.s60ct.model.confml.ESimpleValue
	 * @generated
	 */
	public Adapter createESimpleValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.s60ct.model.confml.ESequenceValue <em>ESequence Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.s60ct.model.confml.ESequenceValue
	 * @generated
	 */
	public Adapter createESequenceValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.s60ct.model.confml.ESequenceValueItem <em>ESequence Value Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.s60ct.model.confml.ESequenceValueItem
	 * @generated
	 */
	public Adapter createESequenceValueItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.s60ct.model.confml.ECompositeValue <em>EComposite Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.s60ct.model.confml.ECompositeValue
	 * @generated
	 */
	public Adapter createECompositeValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.s60ct.model.confml.ESettingValueContainer <em>ESetting Value Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.s60ct.model.confml.ESettingValueContainer
	 * @generated
	 */
	public Adapter createESettingValueContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.s60ct.model.confml.EResourceValue <em>EResource Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.s60ct.model.confml.EResourceValue
	 * @generated
	 */
	public Adapter createEResourceValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.s60ct.model.confml.EProperty <em>EProperty</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.s60ct.model.confml.EProperty
	 * @generated
	 */
	public Adapter createEPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.s60ct.model.confml.ELinkContainer <em>ELink Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.s60ct.model.confml.ELinkContainer
	 * @generated
	 */
	public Adapter createELinkContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.s60ct.model.confml.EOptionMap <em>EOption Map</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.s60ct.model.confml.EOptionMap
	 * @generated
	 */
	public Adapter createEOptionMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.s60ct.model.confml.EOption <em>EOption</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.s60ct.model.confml.EOption
	 * @generated
	 */
	public Adapter createEOptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.s60ct.model.confml.EValueEditorDocument <em>EValue Editor Document</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.s60ct.model.confml.EValueEditorDocument
	 * @generated
	 */
	public Adapter createEValueEditorDocumentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.s60ct.model.confml.Pattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.s60ct.model.confml.Pattern
	 * @generated
	 */
	public Adapter createPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.s60ct.model.confml.View <em>View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.s60ct.model.confml.View
	 * @generated
	 */
	public Adapter createViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.s60ct.model.confml.EGroup <em>EGroup</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.s60ct.model.confml.EGroup
	 * @generated
	 */
	public Adapter createEGroupAdapter() {
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

} //ConfmlAdapterFactory
