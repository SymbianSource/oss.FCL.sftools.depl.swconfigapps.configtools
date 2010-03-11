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
import com.nokia.tools.s60ct.model.confml.ESimpleSetting;
import com.nokia.tools.s60ct.model.confml.ESimpleValue;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>ESimple Setting</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ESimpleSettingTest extends ESettingTest {

	private ConfmlFactory factory = ConfmlFactory.eINSTANCE;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ESimpleSettingTest.class);
	}

	/**
	 * Constructs a new ESimple Setting test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESimpleSettingTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this ESimple Setting test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ESimpleSetting getFixture() {
		return (ESimpleSetting)fixture;
	}

	@Override
	public void testClearDirty() {
//		super.testClearDirty();
	}

	@Override
	public void testIsDefault() {
		ESimpleSetting setting = getFixture();
		ESimpleValue value = factory.createESimpleValue();
		value.setValue("value");
		setting.setValue(value);
		ESimpleValue defaultValue = factory.createESimpleValue();
		defaultValue.setValue("defvalue");
		setting.setDefaultValue(defaultValue);
		assertFalse(setting.isDefault());
	}

	@Override
	public void testIsDirty() {
		ESimpleSetting setting = getFixture();
		ESimpleValue value = factory.createESimpleValue();
		value.setValue("value");
		setting.setValue(value);
		ESimpleValue defaultValue = factory.createESimpleValue();
		defaultValue.setValue("defvalue");
		setting.setDefaultValue(defaultValue);
		setting.setModified(true);
		assertTrue(setting.isDirty());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ConfmlFactory.eINSTANCE.createESimpleSetting());
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

} //ESimpleSettingTest
