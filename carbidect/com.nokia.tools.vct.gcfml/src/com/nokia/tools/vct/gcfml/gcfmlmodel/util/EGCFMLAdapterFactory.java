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
 * Description: This file is part of com.nokia.tools.vct.gcfml component.
 */

package com.nokia.tools.vct.gcfml.gcfmlmodel.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.nokia.tools.vct.gcfml.gcfmlmodel.EFile;
import com.nokia.tools.vct.gcfml.gcfmlmodel.EGCFMLDocumentRoot;
import com.nokia.tools.vct.gcfml.gcfmlmodel.EGCFMLPackage;
import com.nokia.tools.vct.gcfml.gcfmlmodel.EOutput;
import com.nokia.tools.vct.gcfml.gcfmlmodel.ESetting;
import com.nokia.tools.vct.gcfml.gcfmlmodel.EStylesheet;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.EGCFMLPackage
 * @generated
 */
public class EGCFMLAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EGCFMLPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EGCFMLAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = EGCFMLPackage.eINSTANCE;
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
	protected EGCFMLSwitch<Adapter> modelSwitch =
		new EGCFMLSwitch<Adapter>() {
			@Override
			public Adapter caseEFile(EFile object) {
				return createEFileAdapter();
			}
			@Override
			public Adapter caseESetting(ESetting object) {
				return createESettingAdapter();
			}
			@Override
			public Adapter caseEGCFMLDocumentRoot(EGCFMLDocumentRoot object) {
				return createEGCFMLDocumentRootAdapter();
			}
			@Override
			public Adapter caseEStylesheet(EStylesheet object) {
				return createEStylesheetAdapter();
			}
			@Override
			public Adapter caseEOutput(EOutput object) {
				return createEOutputAdapter();
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
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EFile <em>EFile</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.EFile
	 * @generated
	 */
	public Adapter createEFileAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.ESetting <em>ESetting</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.ESetting
	 * @generated
	 */
	public Adapter createESettingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EGCFMLDocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.EGCFMLDocumentRoot
	 * @generated
	 */
	public Adapter createEGCFMLDocumentRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EStylesheet <em>EStylesheet</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.EStylesheet
	 * @generated
	 */
	public Adapter createEStylesheetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.gcfml.gcfmlmodel.EOutput <em>EOutput</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.EOutput
	 * @generated
	 */
	public Adapter createEOutputAdapter() {
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

} //EGCFMLAdapterFactory
