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
package cenrep.tests;

import cenrep.Bit;
import cenrep.CenrepFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Bit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link cenrep.Bit#getNumber() <em>Number</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link cenrep.RVG#canGenerate() <em>Can Generate</em>}</li>
 *   <li>{@link cenrep.RVG#setGConf(java.lang.String) <em>Set GConf</em>}</li>
 *   <li>{@link cenrep.RVG#setPriority(java.lang.String) <em>Set Priority</em>}</li>
 *   <li>{@link cenrep.RVG#getGPriority() <em>Get GPriority</em>}</li>
 *   <li>{@link cenrep.RVG#getFolder() <em>Get Folder</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class BitTest extends ContentTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(BitTest.class);
	}

	/**
	 * Constructs a new Bit test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BitTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Bit test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Bit getFixture() {
		return (Bit)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(CenrepFactory.eINSTANCE.createBit());
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

	public void testGValue(){
		Bit bit = getFixture();
		
		assertEquals("false", bit.getGvalue());
		bit.setNumber(10);
		assertEquals("false", bit.getGvalue());
		bit.setGvalue("false");
		assertEquals("false", bit.getGvalue());
		bit.setGvalue("true");
		assertEquals("true", bit.getGvalue());
	}
	/**
	 * Tests the '{@link cenrep.Bit#getNumber() <em>Number</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.Bit#getNumber()
	 * @generated
	 */
	public void testGetNumber() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link cenrep.Bit#setNumber(int) <em>Number</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.Bit#setNumber(int)
	 * @generated
	 */
	public void testSetNumber() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link cenrep.RVG#canGenerate() <em>Can Generate</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.RVG#canGenerate()
	 * @generated
	 */
	public void testCanGenerate() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link cenrep.RVG#setGConf(java.lang.String) <em>Set GConf</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.RVG#setGConf(java.lang.String)
	 * @generated
	 */
	public void testSetGConf__String() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link cenrep.RVG#setPriority(java.lang.String) <em>Set Priority</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.RVG#setPriority(java.lang.String)
	 * @generated
	 */
	public void testSetPriority__String() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link cenrep.RVG#getGPriority() <em>Get GPriority</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.RVG#getGPriority()
	 * @generated
	 */
	public void testGetGPriority() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link cenrep.RVG#getFolder() <em>Get Folder</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.RVG#getFolder()
	 * @generated
	 */
	public void testGetFolder() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

} //BitTest
