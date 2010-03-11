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
import cenrep.Key;
import cenrep.TYPE;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Key</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link cenrep.IAccessable#getReadAccess() <em>Read Access</em>}</li>
 *   <li>{@link cenrep.IAccessable#getWriteAccess() <em>Write Access</em>}</li>
 *   <li>{@link cenrep.IAccessable#getGAccess() <em>GAccess</em>}</li>
 *   <li>{@link cenrep.Key#isBitmaskKey() <em>Bitmask Key</em>}</li>
 *   <li>{@link cenrep.Key#isSimpleKey() <em>Simple Key</em>}</li>
 *   <li>{@link cenrep.Key#getShortIdent() <em>Short Ident</em>}</li>
 *   <li>{@link cenrep.Key#getStrType() <em>Str Type</em>}</li>
 *   <li>{@link cenrep.Key#isDecFormat() <em>Dec Format</em>}</li>
 *   <li>{@link cenrep.Key#isHexFormat() <em>Hex Format</em>}</li>
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
public class KeyTest extends AttributeAndDescriptionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(KeyTest.class);
	}

	/**
	 * Constructs a new Key test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KeyTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Key test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Key getFixture() {
		return (Key)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(CenrepFactory.eINSTANCE.createKey());
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

	public void testGetGValue(){
		Key key=getFixture();
		key.setRef("q");
		assertNull(key.getGvalue());
		key.setGvalue("a");
		assertEquals("Gvalue does not work for simple key.", "a", key.getGvalue());
		key.setGvalue(null);
		key.setRef(null);
		Bit bit = CenrepFactory.eINSTANCE.createBit();
		key.getBits().add(bit);
		bit.setNumber(5);
		Bit bit2 = CenrepFactory.eINSTANCE.createBit();
		key.getBits().add(bit2);
		bit2.setNumber(0);
		assertEquals("Gvalue not ZERO for bitmask key, bit not defined.", "0", key.getGvalue());
		bit.setGvalue("true");
		assertEquals("Gvalue incorrect for bitmask key, bit defined.", "32", key.getGvalue());
		key.setType(TYPE.BINARY);
		assertEquals("Gvalue incorrect for binary bitmask key, bit defined.", "00000020", key.getGvalue());
		bit2.setGvalue("true");
		assertEquals("Gvalue incorrect for binary bitmask key, bit defined.", "00000021", key.getGvalue());
		
	}
	/**
	 * Tests the '{@link cenrep.Key#isBitmaskKey() <em>Bitmask Key</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.Key#isBitmaskKey()
	 * @generated
	 */
	public void testIsBitmaskKey() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link cenrep.Key#setBitmaskKey(boolean) <em>Bitmask Key</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.Key#setBitmaskKey(boolean)
	 * @generated
	 */
	public void testSetBitmaskKey() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link cenrep.Key#isSimpleKey() <em>Simple Key</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.Key#isSimpleKey()
	 * @generated
	 */
	public void testIsSimpleKey() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link cenrep.Key#setSimpleKey(boolean) <em>Simple Key</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.Key#setSimpleKey(boolean)
	 * @generated
	 */
	public void testSetSimpleKey() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link cenrep.Key#getShortIdent() <em>Short Ident</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.Key#getShortIdent()
	 * @generated
	 */
	public void testGetShortIdent() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link cenrep.Key#setShortIdent(java.lang.String) <em>Short Ident</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.Key#setShortIdent(java.lang.String)
	 * @generated
	 */
	public void testSetShortIdent() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link cenrep.Key#getStrType() <em>Str Type</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.Key#getStrType()
	 * @generated
	 */
	public void testGetStrType() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link cenrep.Key#isDecFormat() <em>Dec Format</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.Key#isDecFormat()
	 * @generated
	 */
	public void testIsDecFormat() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link cenrep.Key#isHexFormat() <em>Hex Format</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cenrep.Key#isHexFormat()
	 * @generated
	 */
	public void testIsHexFormat() {
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

} //KeyTest
