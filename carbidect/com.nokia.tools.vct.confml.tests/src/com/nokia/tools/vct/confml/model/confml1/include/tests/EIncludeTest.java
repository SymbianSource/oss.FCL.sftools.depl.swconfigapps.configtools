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

package com.nokia.tools.vct.confml.model.confml1.include.tests;

import com.nokia.tools.vct.confml.model.confml1.include.EConfMLIncludeFactory;
import com.nokia.tools.vct.confml.model.confml1.include.EInclude;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>EInclude</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class EIncludeTest extends TestCase {

	/**
	 * The fixture for this EInclude test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EInclude fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(EIncludeTest.class);
	}

	/**
	 * Constructs a new EInclude test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EIncludeTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this EInclude test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(EInclude fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this EInclude test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EInclude getFixture() {
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
		setFixture(EConfMLIncludeFactory.eINSTANCE.createEInclude());
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
	
	public void testHref() throws Exception {
		EInclude fix = getFixture();
		String value = "value";
		fix.setHref(value);
		assertEquals(value, fix.getHref());
		
	}

} //EIncludeTest
