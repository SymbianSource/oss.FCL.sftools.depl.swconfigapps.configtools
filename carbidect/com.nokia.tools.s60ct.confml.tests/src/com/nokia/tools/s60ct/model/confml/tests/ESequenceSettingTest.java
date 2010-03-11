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
import com.nokia.tools.s60ct.model.confml.EItemSetting;
import com.nokia.tools.s60ct.model.confml.ESequenceSetting;
import com.nokia.tools.s60ct.model.confml.ESequenceValue;
import com.nokia.tools.s60ct.model.confml.ESequenceValueItem;
import com.nokia.tools.s60ct.model.confml.ESettingValueType;
import com.nokia.tools.s60ct.model.confml.ESimpleSetting;
import com.nokia.tools.s60ct.model.confml.ESimpleValue;
import com.nokia.tools.s60ct.model.confml.ESubSettingValue;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>ESequence Setting</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ESequenceSettingTest extends ESettingTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ESequenceSettingTest.class);
	}

	/**
	 * Constructs a new ESequence Setting test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESequenceSettingTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this ESequence Setting test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ESequenceSetting getFixture() {
		return (ESequenceSetting)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(getFactory().createESequenceSetting());
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
	
	public void testSequenceSetting() throws Exception {
		ESimpleSetting nameSetting = getFactory().createESimpleSetting();
		nameSetting.setType(ESettingValueType.STRING);
		ESimpleSetting phoneSetting = getFactory().createESimpleSetting();
		phoneSetting.setType(ESettingValueType.INTEGER);
		
		ESequenceSetting ss = getFixture();
		ss.getSubTypes().add(nameSetting);
		ss.getSubTypes().add(phoneSetting);
		
		assertTrue(!ss.getSubTypes().isEmpty());
		
		
		ESequenceValue essv = getFactory().createESequenceValue();
		ss.setValue(essv);
		//template item
		ESimpleValue tv1 = getFactory().createESimpleValue();
		tv1.setValue("template name");
		ESimpleValue tv2 = getFactory().createESimpleValue();
		tv2.setValue("12345");
		ESequenceValueItem template = getFactory().createESequenceValueItem();
		template.getSubSettings().add(tv1);
		template.getSubSettings().add(tv2);
		//item 1
		ESimpleValue iv1 = getFactory().createESimpleValue();
		tv1.setValue("name1");
		ESimpleValue iv2 = getFactory().createESimpleValue();
		tv2.setValue("1111");
		ESequenceValueItem item = getFactory().createESequenceValueItem();
		item.getSubSettings().add(iv1);
		item.getSubSettings().add(iv2);

		essv.setTemplate(template);
		essv.getItems().add(item);
		
		assertTrue(ss.getValue()!=null);
		assertEquals(ss.getValue(), essv);
		assertSame(essv.getTemplate(), template);
		assertEquals(essv.getItems().size(), 1);
	}

	private ConfmlFactory getFactory() {
		return ConfmlFactory.eINSTANCE;
	}

	@Override
	public void testClearDirty() {
	}

	@Override
	public void testIsDefault() {
	}

	@Override
	public void testIsDirty() {
	}

} //ESequenceSettingTest
