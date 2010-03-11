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
package com.nokia.tools.s60ct.model.confml.tests;

import com.nokia.tools.s60ct.model.confml.ConfmlFactory;
import com.nokia.tools.s60ct.model.confml.EOption;
import com.nokia.tools.s60ct.model.confml.ESequenceSetting;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>EOption</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.EOption#getMapValue(java.lang.String) <em>Get Map Value</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class EOptionTest extends ESettingOptionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(EOptionTest.class);
	}

	/**
	 * Constructs a new EOption test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOptionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this EOption test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EOption getFixture() {
		return (EOption)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(getFactory().createEOption());
	}

	private ConfmlFactory getFactory() {
		return ConfmlFactory.eINSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '{@link com.nokia.tools.s60ct.model.confml.EOption#getMapValue(java.lang.String) <em>Get Map Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.model.confml.EOption#getMapValue(java.lang.String)
	 * @generated NOT
	 */
	public void testGetMapValue__String() {
		ESequenceSetting source = getFixture().getMapSourceSetting();
		assertNull(source);
		ESequenceSetting seqset = getFactory().createESequenceSetting();
		getFixture().setMapSourceSetting(seqset);
		source = getFixture().getMapSourceSetting();
		getFixture().setMap("map/setting");
		assertEquals("map/setting",getFixture().getMap());
		assertNotNull(source);
	}

} //EOptionTest
