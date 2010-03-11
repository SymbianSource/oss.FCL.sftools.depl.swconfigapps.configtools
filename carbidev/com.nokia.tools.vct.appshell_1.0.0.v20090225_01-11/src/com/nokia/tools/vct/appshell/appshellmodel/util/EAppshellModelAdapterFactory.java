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

package com.nokia.tools.vct.appshell.appshellmodel.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.nokia.tools.vct.appshell.appshellmodel.EApplicationElement;
import com.nokia.tools.vct.appshell.appshellmodel.EAppshellDocument;
import com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage;
import com.nokia.tools.vct.appshell.appshellmodel.EDataElement;
import com.nokia.tools.vct.appshell.appshellmodel.EFolderElement;
import com.nokia.tools.vct.appshell.appshellmodel.EHideDescriptor;
import com.nokia.tools.vct.appshell.appshellmodel.EIconDescriptor;
import com.nokia.tools.vct.appshell.appshellmodel.ELockDescriptor;
import com.nokia.tools.vct.appshell.appshellmodel.ENameDescriptor;
import com.nokia.tools.vct.appshell.appshellmodel.EURLElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage
 * @generated
 */
public class EAppshellModelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EAppshellModelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAppshellModelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = EAppshellModelPackage.eINSTANCE;
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
	protected EAppshellModelSwitch<Adapter> modelSwitch =
		new EAppshellModelSwitch<Adapter>() {
			@Override
			public Adapter caseEAppshellDocument(EAppshellDocument object) {
				return createEAppshellDocumentAdapter();
			}
			@Override
			public Adapter caseEFolderElement(EFolderElement object) {
				return createEFolderElementAdapter();
			}
			@Override
			public Adapter caseEApplicationElement(EApplicationElement object) {
				return createEApplicationElementAdapter();
			}
			@Override
			public Adapter caseEURLElement(EURLElement object) {
				return createEURLElementAdapter();
			}
			@Override
			public Adapter caseEDataElement(EDataElement object) {
				return createEDataElementAdapter();
			}
			@Override
			public Adapter caseELockDescriptor(ELockDescriptor object) {
				return createELockDescriptorAdapter();
			}
			@Override
			public Adapter caseEIconDescriptor(EIconDescriptor object) {
				return createEIconDescriptorAdapter();
			}
			@Override
			public Adapter caseEHideDescriptor(EHideDescriptor object) {
				return createEHideDescriptorAdapter();
			}
			@Override
			public Adapter caseENameDescriptor(ENameDescriptor object) {
				return createENameDescriptorAdapter();
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
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.appshell.appshellmodel.EAppshellDocument <em>EAppshell Document</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellDocument
	 * @generated
	 */
	public Adapter createEAppshellDocumentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.appshell.appshellmodel.EFolderElement <em>EFolder Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EFolderElement
	 * @generated
	 */
	public Adapter createEFolderElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.appshell.appshellmodel.EApplicationElement <em>EApplication Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EApplicationElement
	 * @generated
	 */
	public Adapter createEApplicationElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.appshell.appshellmodel.EURLElement <em>EURL Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EURLElement
	 * @generated
	 */
	public Adapter createEURLElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.appshell.appshellmodel.EDataElement <em>EData Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EDataElement
	 * @generated
	 */
	public Adapter createEDataElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.appshell.appshellmodel.ELockDescriptor <em>ELock Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.ELockDescriptor
	 * @generated
	 */
	public Adapter createELockDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.appshell.appshellmodel.EIconDescriptor <em>EIcon Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EIconDescriptor
	 * @generated
	 */
	public Adapter createEIconDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.appshell.appshellmodel.EHideDescriptor <em>EHide Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EHideDescriptor
	 * @generated
	 */
	public Adapter createEHideDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.nokia.tools.vct.appshell.appshellmodel.ENameDescriptor <em>EName Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.nokia.tools.vct.appshell.appshellmodel.ENameDescriptor
	 * @generated
	 */
	public Adapter createENameDescriptorAdapter() {
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

} //EAppshellModelAdapterFactory
