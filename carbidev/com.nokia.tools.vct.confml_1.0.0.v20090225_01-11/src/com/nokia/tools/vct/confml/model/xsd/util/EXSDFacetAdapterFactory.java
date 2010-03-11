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

package com.nokia.tools.vct.confml.model.xsd.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.nokia.tools.vct.confml.model.xsd.EFacet;
import com.nokia.tools.vct.confml.model.xsd.ELength;
import com.nokia.tools.vct.confml.model.xsd.EMaxExclusive;
import com.nokia.tools.vct.confml.model.xsd.EMaxInclusive;
import com.nokia.tools.vct.confml.model.xsd.EMaxLength;
import com.nokia.tools.vct.confml.model.xsd.EMinExclusive;
import com.nokia.tools.vct.confml.model.xsd.EMinInclusive;
import com.nokia.tools.vct.confml.model.xsd.EMinLength;
import com.nokia.tools.vct.confml.model.xsd.ENumFacet;
import com.nokia.tools.vct.confml.model.xsd.EPattern;
import com.nokia.tools.vct.confml.model.xsd.ETotalDigits;
import com.nokia.tools.vct.confml.model.xsd.EXSDFacetPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.nokia.tools.vct.confml.model.xsd.EXSDFacetPackage
 * @generated
 */
public class EXSDFacetAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EXSDFacetPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EXSDFacetAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = EXSDFacetPackage.eINSTANCE;
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
	protected EXSDFacetSwitch<Adapter> modelSwitch = new EXSDFacetSwitch<Adapter>() {
		@Override
		public Adapter caseEFacet(EFacet object) {
			return createEFacetAdapter();
		}

		@Override
		public Adapter caseENumFacet(ENumFacet object) {
			return createENumFacetAdapter();
		}

		@Override
		public Adapter caseEMinInclusive(EMinInclusive object) {
			return createEMinInclusiveAdapter();
		}

		@Override
		public Adapter caseEMinExclusive(EMinExclusive object) {
			return createEMinExclusiveAdapter();
		}

		@Override
		public Adapter caseEMaxInclusive(EMaxInclusive object) {
			return createEMaxInclusiveAdapter();
		}

		@Override
		public Adapter caseEMaxExclusive(EMaxExclusive object) {
			return createEMaxExclusiveAdapter();
		}

		@Override
		public Adapter caseELength(ELength object) {
			return createELengthAdapter();
		}

		@Override
		public Adapter caseEMinLength(EMinLength object) {
			return createEMinLengthAdapter();
		}

		@Override
		public Adapter caseEMaxLength(EMaxLength object) {
			return createEMaxLengthAdapter();
		}

		@Override
		public Adapter caseETotalDigits(ETotalDigits object) {
			return createETotalDigitsAdapter();
		}

		@Override
		public Adapter caseEPattern(EPattern object) {
			return createEPatternAdapter();
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
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.xsd.EFacet <em>EFacet</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.xsd.EFacet
	 * @generated
	 */
	public Adapter createEFacetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.xsd.ENumFacet <em>ENum Facet</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.xsd.ENumFacet
	 * @generated
	 */
	public Adapter createENumFacetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.xsd.EMinInclusive <em>EMin Inclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.xsd.EMinInclusive
	 * @generated
	 */
	public Adapter createEMinInclusiveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.xsd.EMinExclusive <em>EMin Exclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.xsd.EMinExclusive
	 * @generated
	 */
	public Adapter createEMinExclusiveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.xsd.EMaxInclusive <em>EMax Inclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.xsd.EMaxInclusive
	 * @generated
	 */
	public Adapter createEMaxInclusiveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.xsd.EMaxExclusive <em>EMax Exclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.xsd.EMaxExclusive
	 * @generated
	 */
	public Adapter createEMaxExclusiveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.xsd.ELength <em>ELength</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.xsd.ELength
	 * @generated
	 */
	public Adapter createELengthAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.xsd.EMinLength <em>EMin Length</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.xsd.EMinLength
	 * @generated
	 */
	public Adapter createEMinLengthAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.xsd.EMaxLength <em>EMax Length</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.xsd.EMaxLength
	 * @generated
	 */
	public Adapter createEMaxLengthAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.xsd.ETotalDigits <em>ETotal Digits</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.xsd.ETotalDigits
	 * @generated
	 */
	public Adapter createETotalDigitsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.confml.model.xsd.EPattern <em>EPattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.confml.model.xsd.EPattern
	 * @generated
	 */
	public Adapter createEPatternAdapter() {
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

} //EXSDFacetAdapterFactory
