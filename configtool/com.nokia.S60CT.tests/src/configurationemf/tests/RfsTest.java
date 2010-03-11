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

import junit.textui.TestRunner;
import configurationemf.ConfigurationemfFactory;
import configurationemf.Ref;
import configurationemf.Rfs;
import configurationemf.RootConf;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Rfs</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RfsTest extends DataTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RfsTest.class);
	}

	/**
	 * Constructs a new Rfs test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RfsTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Rfs test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Rfs getFixture() {
		return (Rfs)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ConfigurationemfFactory.eINSTANCE.createRfs());
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
	
	public void testDataSelfAdapter(){
		Rfs rfs = getFixture();
		RootConf conf= ConfigurationemfFactory.eINSTANCE.createRootConf();
		conf.setRfs(rfs);
		Ref ref = ConfigurationemfFactory.eINSTANCE.createRef();
		Ref ref2 = ConfigurationemfFactory.eINSTANCE.createRef();
		rfs.getRef().add(ref);
		rfs.getRef().add(ref2);
		rfs.getRef().remove(ref);
		assertEquals(conf.getRfs(), rfs);
		rfs.getRef().remove(ref2);
		assertNull(conf.getRfs());
	}
	
	

} //RfsTest
