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

import junit.framework.Assert;
import junit.textui.TestRunner;
import cenrep.CenrepFactory;
import cenrep.Key;
import cenrep.Repository;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Repository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link cenrep.IAccessable#getReadAccess() <em>Read Access</em>}</li>
 *   <li>{@link cenrep.IAccessable#getWriteAccess() <em>Write Access</em>}</li>
 *   <li>{@link cenrep.IAccessable#getGAccess() <em>GAccess</em>}</li>
 *   <li>{@link cenrep.Repository#getSimpleKeys() <em>Simple Keys</em>}</li>
 *   <li>{@link cenrep.Repository#getBitmaskKeys() <em>Bitmask Keys</em>}</li>
 *   <li>{@link cenrep.Repository#getFileName() <em>File Name</em>}</li>
 *   <li>{@link cenrep.Repository#getProblems() <em>Problems</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link cenrep.Repository#canGenerate() <em>Can Generate</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class RepositoryTest extends AttributeAndDescriptionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RepositoryTest.class);
	}

	/**
	 * Constructs a new Repository test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepositoryTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Repository test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Repository getFixture() {
		return (Repository)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(CenrepFactory.eINSTANCE.createRepository());
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
	 * Tests the '{@link cenrep.IAccessable#getReadAccess() <em>Read Access</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.IAccessable#getReadAccess()
	 * @generated
	 */
	public void testGetReadAccess() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link cenrep.IAccessable#setReadAccess(cenrep.Access) <em>Read Access</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.IAccessable#setReadAccess(cenrep.Access)
	 * @generated
	 */
	public void testSetReadAccess() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link cenrep.IAccessable#getWriteAccess() <em>Write Access</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.IAccessable#getWriteAccess()
	 * @generated
	 */
	public void testGetWriteAccess() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link cenrep.IAccessable#setWriteAccess(cenrep.Access) <em>Write Access</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.IAccessable#setWriteAccess(cenrep.Access)
	 * @generated
	 */
	public void testSetWriteAccess() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link cenrep.IAccessable#getGAccess() <em>GAccess</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.IAccessable#getGAccess()
	 * @generated
	 */
	public void testGetGAccess() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link cenrep.Repository#getSimpleKeys() <em>Simple Keys</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.Repository#getSimpleKeys()
	 * @generated NOT
	 */
	public void testGetSimpleKeys() {
		Key simpleKey = CenrepFactory.eINSTANCE.createKey();
		simpleKey.setRef("");
		Key otherKey = CenrepFactory.eINSTANCE.createKey();
		
		Repository rep = getFixture();
		rep.getKey().add(simpleKey);
		rep.getKey().add(otherKey);
		Assert.assertTrue("Not only one key", rep.getSimpleKeys().size()==1);
		Assert.assertEquals(simpleKey, rep.getSimpleKeys().get(0));
	}

	/**
	 * Tests the '{@link cenrep.Repository#getBitmaskKeys() <em>Bitmask Keys</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.Repository#getBitmaskKeys()
	 * @generated
	 */
	public void testGetBitmaskKeys() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link cenrep.Repository#getFileName() <em>File Name</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.Repository#getFileName()
	 * @generated
	 */
	public void testGetFileName() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link cenrep.Repository#getProblems() <em>Problems</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.Repository#getProblems()
	 * @generated
	 */
	public void testGetProblems() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link cenrep.Repository#canGenerate() <em>Can Generate</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.Repository#canGenerate()
	 * @generated
	 */
	public void testCanGenerate() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

} //RepositoryTest
