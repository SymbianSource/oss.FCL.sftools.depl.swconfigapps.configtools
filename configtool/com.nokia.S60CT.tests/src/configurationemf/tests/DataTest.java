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
import configurationemf.RootConf;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Data</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DataTest extends TestCase {

	/**
	 * The fixture for this Data test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Data fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DataTest.class);
	}

	/**
	 * Constructs a new Data test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Data test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Data fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Data test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Data getFixture() {
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
		setFixture(ConfigurationemfFactory.eINSTANCE.createData());
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
		Data data = getFixture();
		RootConf conf= ConfigurationemfFactory.eINSTANCE.createRootConf();
		conf.setData(data);
		Ref ref = ConfigurationemfFactory.eINSTANCE.createRef();
		Ref ref2 = ConfigurationemfFactory.eINSTANCE.createRef();
		data.getRef().add(ref);
		data.getRef().add(ref2);
		data.getRef().remove(ref);
		assertEquals(conf.getData(), data);
		data.getRef().remove(ref2);
		assertNull(conf.getData());
	}
} //DataTest
