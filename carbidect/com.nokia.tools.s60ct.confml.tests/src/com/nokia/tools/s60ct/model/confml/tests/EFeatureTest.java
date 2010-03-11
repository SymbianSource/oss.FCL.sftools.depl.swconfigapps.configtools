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
import com.nokia.tools.s60ct.model.confml.EFeature;
import com.nokia.tools.s60ct.model.confml.ESimpleSetting;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>EFeature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.EFeature#getView() <em>Get View</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class EFeatureTest extends TestCase {

	/**
	 * The fixture for this EFeature test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EFeature fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(EFeatureTest.class);
	}

	/**
	 * Constructs a new EFeature test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EFeatureTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this EFeature test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(EFeature fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this EFeature test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EFeature getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ConfmlFactory.eINSTANCE.createEFeature());
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
	 * Tests the '{@link com.nokia.tools.s60ct.model.confml.EFeature#getView() <em>Get View</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.s60ct.model.confml.EFeature#getView()
	 * @generated NOT
	 */
	public void testGetView() {
		assertEquals(null, getFixture().getView());
		//fail();
	}

	public void testEFeature() {
		EFeature feature = getFixture();
		String name = "name";
		feature.setName(name);
		assertEquals(name, feature.getName());
		
		ESimpleSetting ssetting = ConfmlFactory.eINSTANCE.createESimpleSetting();
		feature.getSettings().add(ssetting);
		assertEquals(1, feature.getSettings().size());
	}

} //EFeatureTest
