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
 * Description: This file is part of com.nokia.tools.variant.confml.core component.
 */

package com.nokia.tools.variant.confml.core.model.core.util;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.nokia.tools.variant.confml.core.model.application.EConfigurationProject;
import com.nokia.tools.variant.confml.core.model.core.EBinaryResource;
import com.nokia.tools.variant.confml.core.model.core.EConfmlRootPackage;
import com.nokia.tools.variant.confml.core.model.core.ESourceLocator;
import com.nokia.tools.variant.confml.core.model.core.EWorkspaceModel;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.nokia.tools.variant.confml.core.model.core.EConfmlRootPackage
 * @generated
 */
public class EConfmlRootAdapterFactory extends AdapterFactoryImpl {
	/**
     * The cached model package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static EConfmlRootPackage modelPackage;

	/**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EConfmlRootAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = EConfmlRootPackage.eINSTANCE;
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
	protected EConfmlRootSwitch<Adapter> modelSwitch =
		new EConfmlRootSwitch<Adapter>() {
            @Override
            public Adapter caseEBinaryResource(EBinaryResource object) {
                return createEBinaryResourceAdapter();
            }
            @Override
            public Adapter caseEWorkspaceModel(EWorkspaceModel object) {
                return createEWorkspaceModelAdapter();
            }
            @Override
            public Adapter caseEProjectEntry(Map.Entry<String, EConfigurationProject> object) {
                return createEProjectEntryAdapter();
            }
            @Override
            public Adapter caseESourceLocator(ESourceLocator object) {
                return createESourceLocatorAdapter();
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
     * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.confml.core.model.core.EBinaryResource <em>EBinary Resource</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.nokia.tools.variant.confml.core.model.core.EBinaryResource
     * @generated
     */
	public Adapter createEBinaryResourceAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.confml.core.model.core.EWorkspaceModel <em>EWorkspace Model</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.nokia.tools.variant.confml.core.model.core.EWorkspaceModel
     * @generated
     */
	public Adapter createEWorkspaceModelAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>EProject Entry</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see java.util.Map.Entry
     * @generated
     */
	public Adapter createEProjectEntryAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link com.nokia.tools.variant.confml.core.model.core.ESourceLocator <em>ESource Locator</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.nokia.tools.variant.confml.core.model.core.ESourceLocator
     * @generated
     */
	public Adapter createESourceLocatorAdapter() {
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

} //EConfmlRootAdapterFactory
