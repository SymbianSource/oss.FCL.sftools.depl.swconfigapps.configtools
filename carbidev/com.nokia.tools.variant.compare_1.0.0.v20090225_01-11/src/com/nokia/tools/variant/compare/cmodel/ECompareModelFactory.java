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

package com.nokia.tools.variant.compare.cmodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.nokia.tools.variant.compare.cmodel.ECompareModelPackage
 * @generated
 */
public interface ECompareModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ECompareModelFactory eINSTANCE = com.nokia.tools.variant.compare.cmodel.impl.ECompareModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>EModel Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EModel Root</em>'.
	 * @generated
	 */
	EModelRoot createEModelRoot();

	/**
	 * Returns a new object of class '<em>EDiff Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EDiff Group</em>'.
	 * @generated
	 */
	EDiffGroup createEDiffGroup();

	/**
	 * Returns a new object of class '<em>EDiff Simple</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EDiff Simple</em>'.
	 * @generated
	 */
	EDiffSimple createEDiffSimple();

	/**
	 * Returns a new object of class '<em>EDiff Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EDiff Sequence</em>'.
	 * @generated
	 */
	EDiffSequence createEDiffSequence();

	/**
	 * Returns a new object of class '<em>EDiff Resource Setting2</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EDiff Resource Setting2</em>'.
	 * @generated
	 */
	EDiffResourceSetting2 createEDiffResourceSetting2();

	/**
	 * Returns a new object of class '<em>EDiff Local Path Setting</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EDiff Local Path Setting</em>'.
	 * @generated
	 */
	EDiffLocalPathSetting createEDiffLocalPathSetting();

	/**
	 * Returns a new object of class '<em>EDiff Mismatch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EDiff Mismatch</em>'.
	 * @generated
	 */
	EDiffMismatch createEDiffMismatch();

	/**
	 * Returns a new object of class '<em>ECheckable Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ECheckable Element</em>'.
	 * @generated
	 */
	ECheckableElement createECheckableElement();

	/**
	 * Returns a new object of class '<em>EDiff Sequence Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EDiff Sequence Item</em>'.
	 * @generated
	 */
	EDiffSequenceItem createEDiffSequenceItem();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ECompareModelPackage getECompareModelPackage();

} //ECompareModelFactory
