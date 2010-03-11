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

import junit.framework.Assert;
import junit.textui.TestRunner;
import configurationemf.ConfigurationemfFactory;
import configurationemf.Feature;
import configurationemf.LeafSetting;
import configurationemf.ParentSetting;
import configurationemf.RootConf;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Leaf Setting</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class LeafSettingTest extends SettingTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(LeafSettingTest.class);
	}

	/**
	 * Constructs a new Leaf Setting test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LeafSettingTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Leaf Setting test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected LeafSetting getFixture() {
		return (LeafSetting)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ConfigurationemfFactory.eINSTANCE.createLeafSetting());
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

	@Override
	public void testSetCurrentValue() {
		RootConf conf = ConfigurationemfFactory.eINSTANCE.createRootConf();
		Feature feature = ConfigurationemfFactory.eINSTANCE.createFeature();
		feature.setRef("f1");
		conf.getFeature().add(feature);
		ParentSetting ps = ConfigurationemfFactory.eINSTANCE.createParentSetting();
		ps.setRef("ps1");
		feature.getParentSetting().add(ps);
		LeafSetting setting = getFixture();
		setting.setRef("ls1");
		ps.getLeafSetting().add(setting);
		String someValue = "someValue";
		setting.setCurrentValue(someValue);
		Assert.assertTrue("Current value set does not work", setting.getCurrentValue().compareTo(someValue)==0);
	}

	public void testGetAbsRef() {
		
	}

	public void testGetTopValue() {
		
	}

	@Override
	public void testSetRfs() {
		
	}

	@Override
	public void testIsRfs() {
		
	}
	
	
	
} //LeafSettingTest
