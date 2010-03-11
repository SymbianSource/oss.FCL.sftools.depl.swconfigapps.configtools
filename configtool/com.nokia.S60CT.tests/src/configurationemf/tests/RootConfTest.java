/*
* Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
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
package configurationemf.tests;

import configurationemf.ConfigurationemfFactory;
import configurationemf.RootConf;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Root Conf</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link configurationemf.RootConf#getFeatureByRef(java.lang.String) <em>Get Feature By Ref</em>}</li>
 *   <li>{@link configurationemf.RootConf#getLevel() <em>Get Level</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class RootConfTest extends ConfigurationTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RootConfTest.class);
	}

	/**
	 * Constructs a new Root Conf test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RootConfTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Root Conf test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected RootConf getFixture() {
		return (RootConf)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ConfigurationemfFactory.eINSTANCE.createRootConf());
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
	 * Tests the '{@link configurationemf.RootConf#getFeatureByRef(java.lang.String) <em>Get Feature By Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.RootConf#getFeatureByRef(java.lang.String)
	 * @generated
	 */
	public void testGetFeatureByRef__String() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link configurationemf.RootConf#getLevel() <em>Get Level</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.RootConf#getLevel()
	 * @generated
	 */
	public void testGetLevel() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

} //RootConfTest
