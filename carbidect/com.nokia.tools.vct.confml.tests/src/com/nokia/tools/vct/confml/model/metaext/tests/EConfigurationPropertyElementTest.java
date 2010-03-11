/*
* Copyright (c) 2008 Nokia Corporation and/or its subsidiary(-ies).
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

package com.nokia.tools.vct.confml.model.metaext.tests;

import com.nokia.tools.vct.confml.model.metaext.EConfigurationPropertyElement;
import com.nokia.tools.vct.confml.model.metaext.EMetaExtFactory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>EConfiguration Property Element</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class EConfigurationPropertyElementTest extends TestCase {

	/**
	 * The fixture for this EConfiguration Property Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EConfigurationPropertyElement fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(EConfigurationPropertyElementTest.class);
	}

	/**
	 * Constructs a new EConfiguration Property Element test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EConfigurationPropertyElementTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this EConfiguration Property Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(EConfigurationPropertyElement fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this EConfiguration Property Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EConfigurationPropertyElement getFixture() {
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
		setFixture(EMetaExtFactory.eINSTANCE
				.createEConfigurationPropertyElement());
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
	
	public void testSome() throws Exception {
		EConfigurationPropertyElement fix = getFixture();
		String name = "name";
		String value = "value";
		fix.setName(name);
		fix.setValue(value);
		
		assertEquals(value, fix.getValue());
		
	}

} //EConfigurationPropertyElementTest
