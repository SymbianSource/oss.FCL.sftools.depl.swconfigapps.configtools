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
 * Description: This file is part of com.nokia.tools.variant.compare component.
 */

package com.nokia.tools.variant.compare.cmodel.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.nokia.tools.variant.compare.cmodel.ECheckableElement;
import com.nokia.tools.variant.compare.cmodel.ECompareElement;
import com.nokia.tools.variant.compare.cmodel.ECompareModelPackage;
import com.nokia.tools.variant.compare.cmodel.EDiffGroup;
import com.nokia.tools.variant.compare.cmodel.EDiffLocalPathSetting;
import com.nokia.tools.variant.compare.cmodel.EDiffMismatch;
import com.nokia.tools.variant.compare.cmodel.EDiffResourceSetting2;
import com.nokia.tools.variant.compare.cmodel.EDiffSequence;
import com.nokia.tools.variant.compare.cmodel.EDiffSequenceItem;
import com.nokia.tools.variant.compare.cmodel.EDiffSetting;
import com.nokia.tools.variant.compare.cmodel.EDiffSettingContainer;
import com.nokia.tools.variant.compare.cmodel.EDiffSimple;
import com.nokia.tools.variant.compare.cmodel.EGroupContainer;
import com.nokia.tools.variant.compare.cmodel.EModelRoot;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.nokia.tools.variant.compare.cmodel.ECompareModelPackage
 * @generated
 */
public class ECompareModelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ECompareModelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ECompareModelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ECompareModelPackage.eINSTANCE;
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
	protected ECompareModelSwitch<Adapter> modelSwitch =
		new ECompareModelSwitch<Adapter>() {
			@Override
			public Adapter caseEDiffSettingContainer(EDiffSettingContainer object) {
				return createEDiffSettingContainerAdapter();
			}
			@Override
			public Adapter caseEGroupContainer(EGroupContainer object) {
				return createEGroupContainerAdapter();
			}
			@Override
			public Adapter caseECompareElement(ECompareElement object) {
				return createECompareElementAdapter();
			}
			@Override
			public Adapter caseEModelRoot(EModelRoot object) {
				return createEModelRootAdapter();
			}
			@Override
			public Adapter caseEDiffGroup(EDiffGroup object) {
				return createEDiffGroupAdapter();
			}
			@Override
			public Adapter caseEDiffSetting(EDiffSetting object) {
				return createEDiffSettingAdapter();
			}
			@Override
			public Adapter caseEDiffSimple(EDiffSimple object) {
				return createEDiffSimpleAdapter();
			}
			@Override
			public Adapter caseEDiffSequence(EDiffSequence object) {
				return createEDiffSequenceAdapter();
			}
			@Override
			public Adapter caseEDiffResourceSetting2(EDiffResourceSetting2 object) {
				return createEDiffResourceSetting2Adapter();
			}
			@Override
			public Adapter caseEDiffLocalPathSetting(EDiffLocalPathSetting object) {
				return createEDiffLocalPathSettingAdapter();
			}
			@Override
			public Adapter caseEDiffMismatch(EDiffMismatch object) {
				return createEDiffMismatchAdapter();
			}
			@Override
			public Adapter caseECheckableElement(ECheckableElement object) {
				return createECheckableElementAdapter();
			}
			@Override
			public Adapter caseEDiffSequenceItem(EDiffSequenceItem object) {
				return createEDiffSequenceItemAdapter();
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
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.compare.cmodel.EModelRoot <em>EModel Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.variant.compare.cmodel.EModelRoot
	 * @generated
	 */
	public Adapter createEModelRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.compare.cmodel.EDiffGroup <em>EDiff Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.variant.compare.cmodel.EDiffGroup
	 * @generated
	 */
	public Adapter createEDiffGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.compare.cmodel.EDiffSetting <em>EDiff Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.variant.compare.cmodel.EDiffSetting
	 * @generated
	 */
	public Adapter createEDiffSettingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.compare.cmodel.EGroupContainer <em>EGroup Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.variant.compare.cmodel.EGroupContainer
	 * @generated
	 */
	public Adapter createEGroupContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.compare.cmodel.ECompareElement <em>ECompare Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.variant.compare.cmodel.ECompareElement
	 * @generated
	 */
	public Adapter createECompareElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.compare.cmodel.EDiffSimple <em>EDiff Simple</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.variant.compare.cmodel.EDiffSimple
	 * @generated
	 */
	public Adapter createEDiffSimpleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.compare.cmodel.EDiffSequence <em>EDiff Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.variant.compare.cmodel.EDiffSequence
	 * @generated
	 */
	public Adapter createEDiffSequenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.compare.cmodel.EDiffSettingContainer <em>EDiff Setting Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.variant.compare.cmodel.EDiffSettingContainer
	 * @generated
	 */
	public Adapter createEDiffSettingContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.compare.cmodel.EDiffResourceSetting2 <em>EDiff Resource Setting2</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.variant.compare.cmodel.EDiffResourceSetting2
	 * @generated
	 */
	public Adapter createEDiffResourceSetting2Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.compare.cmodel.EDiffLocalPathSetting <em>EDiff Local Path Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.variant.compare.cmodel.EDiffLocalPathSetting
	 * @generated
	 */
	public Adapter createEDiffLocalPathSettingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.compare.cmodel.EDiffMismatch <em>EDiff Mismatch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.variant.compare.cmodel.EDiffMismatch
	 * @generated
	 */
	public Adapter createEDiffMismatchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.compare.cmodel.ECheckableElement <em>ECheckable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.variant.compare.cmodel.ECheckableElement
	 * @generated
	 */
	public Adapter createECheckableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.compare.cmodel.EDiffSequenceItem <em>EDiff Sequence Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.variant.compare.cmodel.EDiffSequenceItem
	 * @generated
	 */
	public Adapter createEDiffSequenceItemAdapter() {
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

} //ECompareModelAdapterFactory
