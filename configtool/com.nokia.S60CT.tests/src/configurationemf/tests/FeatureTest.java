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
import configurationemf.Feature;
import configurationemf.LeafSetting;
import configurationemf.ParentSetting;
import configurationemf.Ref;
import configurationemf.RootConf;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link configurationemf.Feature#isReadOnly() <em>Read Only</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link configurationemf.Feature#getSettingByRef(java.lang.String) <em>Get Setting By Ref</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class FeatureTest extends ReferableTest {
	final int FIRST_ELEMENT = 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(FeatureTest.class);
	}

	/**
	 * Constructs a new Feature test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Feature test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Feature getFixture() {
		return (Feature)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ConfigurationemfFactory.eINSTANCE.createFeature());
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
	 * Tests the '{@link configurationemf.Feature#isReadOnly() <em>Read Only</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Feature#isReadOnly()
	 * @generated NOT
	 */
	public void testIsReadOnly() {
		Feature feature = getFixture();
		assertFalse(feature.isReadOnly());
	}

	/**
	 * Tests the '{@link configurationemf.Feature#getSettingByRef(java.lang.String) <em>Get Setting By Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Feature#getSettingByRef(java.lang.String)
	 * @generated NOT
	 */
	public void testGetSettingByRef__String() {
		// Ensure that you remove @generated or mark it @generated NOT
		String settingRef = "s1";
		Feature f = getFixture();
		ParentSetting setting = ConfigurationemfFactory.eINSTANCE.createParentSetting();
		setting.setRef(settingRef);
		f.getParentSetting().add(setting);
		assertEquals(setting,f.getSettingByRef(settingRef));
		assertTrue(setting.equals(f.getSettingByRef(settingRef)));
	}

	public void testMoveSettingToAnotherFeature(){
		ParentSetting setting = ConfigurationemfFactory.eINSTANCE.createParentSetting();
		setting.setRef("s1");
		RootConf conf = ConfigurationemfFactory.eINSTANCE.createRootConf();
		Feature f1 = ConfigurationemfFactory.eINSTANCE.createFeature();
		f1.setRef("f1");
		Feature f2 = ConfigurationemfFactory.eINSTANCE.createFeature();
		f2.setRef("f2");
		conf.getFeature().add(f1);
		conf.getFeature().add(f2);
		
		f1.getParentSetting().add(setting);
		String val = "val";
		setting.setCurrentValue(val);
		assertEquals(1, f1.getRefs().size());
		assertNotNull(conf.getData());
		assertEquals(1, conf.getData().getRef().size());
		assertEquals(1, ((Ref)conf.getData().getRef().get(FIRST_ELEMENT)).getRef().size());
		assertEquals(val, ((Ref)((Ref)conf.getData().getRef().get(FIRST_ELEMENT)).getRef().get(FIRST_ELEMENT)).getValue());
	
		f2.getParentSetting().add(setting);
		assertEquals(FIRST_ELEMENT, f1.getRefs().size());
		assertNotNull(conf.getData());
		assertEquals(1, conf.getData().getRef().size());
		assertEquals(1, ((Ref)conf.getData().getRef().get(FIRST_ELEMENT)).getRef().size());
		assertEquals("f2", ((Ref)conf.getData().getRef().get(FIRST_ELEMENT)).getName());
		assertEquals(val, ((Ref)((Ref)conf.getData().getRef().get(FIRST_ELEMENT)).getRef().get(FIRST_ELEMENT)).getValue());
		
		f2.getParentSetting().remove(setting);
		assertNull(conf.getData());
	}
	
	public void testRfsConnection(){
		RootConf conf = ConfigurationemfFactory.eINSTANCE.createRootConf();
		ParentSetting setting = ConfigurationemfFactory.eINSTANCE.createParentSetting();
		Feature f1 = ConfigurationemfFactory.eINSTANCE.createFeature();
		Feature f2 = ConfigurationemfFactory.eINSTANCE.createFeature();
		setting.setRef("s1");
		f1.setRef("f1");
		f2.setRef("f2");
		conf.getFeature().add(f1);
		conf.getFeature().add(f2);
		
		f1.getParentSetting().add(setting);
		setting.setRfs(true);
		assertEquals(true,	setting.isRfs());
		assertNotNull(conf.getRfs());
		assertEquals(1, conf.getRfs().getRef().size());
		Ref ref1 = conf.getRfs().getRef().get(FIRST_ELEMENT).getRef().get(FIRST_ELEMENT);
		assertEquals("s1", ref1.getName());
		
		f1.getParentSetting().remove(setting);
		assertEquals(0,f1.getRfsRefs().size());
		assertNull(conf.getRfs());
	}
	
	
	
} //FeatureTest
