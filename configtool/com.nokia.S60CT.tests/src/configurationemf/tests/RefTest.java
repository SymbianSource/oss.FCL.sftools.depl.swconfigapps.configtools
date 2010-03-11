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
import configurationemf.Data;
import configurationemf.Ref;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link configurationemf.Ref#getAbsRef() <em>Get Abs Ref</em>}</li>
 *   <li>{@link configurationemf.Ref#getConfiguration() <em>Get Configuration</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class RefTest extends ContentTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RefTest.class);
	}

	/**
	 * Constructs a new Ref test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RefTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Ref test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Ref getFixture() {
		return (Ref)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ConfigurationemfFactory.eINSTANCE.createRef());
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
	 * Tests the '{@link configurationemf.Ref#getAbsRef() <em>Get Abs Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Ref#getAbsRef()
	 * @generated
	 */
	public void testGetAbsRef() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link configurationemf.Ref#getConfiguration() <em>Get Configuration</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Ref#getConfiguration()
	 * @generated
	 */
	public void testGetConfiguration() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	public void testSelfAdapter(){
		Ref ref = getFixture();
		Ref ref1 = ConfigurationemfFactory.eINSTANCE.createRef();
		Data data = ConfigurationemfFactory.eINSTANCE.createData();
		data.getRef().add(ref);
		ref.getRef().add(ref1);
		ref.getRef().remove(ref1);
		assertTrue(data.getRef().isEmpty());
	}
} //RefTest
