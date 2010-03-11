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
import configurationemf.Configuration;
import configurationemf.ConfigurationemfFactory;
import configurationemf.Feature;
import configurationemf.Identification;
import configurationemf.LeafSetting;
import configurationemf.Meta;
import configurationemf.ParentSetting;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link configurationemf.Configuration#isReadOnly() <em>Read Only</em>}</li>
 *   <li>{@link configurationemf.Configuration#getMetaId() <em>Meta Id</em>}</li>
 *   <li>{@link configurationemf.Configuration#getOwner() <em>Owner</em>}</li>
 *   <li>{@link configurationemf.Configuration#getEditor() <em>Editor</em>}</li>
 *   <li>{@link configurationemf.Configuration#getStatus() <em>Status</em>}</li>
 *   <li>{@link configurationemf.Configuration#getVersion() <em>Version</em>}</li>
 *   <li>{@link configurationemf.Configuration#getPlatform() <em>Platform</em>}</li>
 *   <li>{@link configurationemf.Configuration#getProduct() <em>Product</em>}</li>
 *   <li>{@link configurationemf.Configuration#getCustomer() <em>Customer</em>}</li>
 *   <li>{@link configurationemf.Configuration#getDate() <em>Date</em>}</li>
 *   <li>{@link configurationemf.Configuration#getRelease() <em>Release</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link configurationemf.Configuration#getAllSettings() <em>Get All Settings</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public abstract class ConfigurationTest extends AttributeAndDescTest {

	private String TEST_INPUT = "ABC";

	/**
	 * Constructs a new Configuration test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Configuration test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Configuration getFixture() {
		return (Configuration)fixture;
	}

	/**
	 * Tests the '{@link configurationemf.Configuration#isReadOnly() <em>Read Only</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Configuration#isReadOnly()
	 * @generated
	 */
	public void testIsReadOnly() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
//		Configuration config = getFixture();
//		config.ec
	}

	/**
	 * Tests the '{@link configurationemf.Configuration#getMetaId() <em>Meta Id</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Configuration#getMetaId()
	 * @generated NOT
	 */
	public void testGetMetaId() {
		Configuration conf = getFixture();
		assertNull(conf.getMetaId());
		Meta meta = ConfigurationemfFactory.eINSTANCE.createMeta();
		Identification id = ConfigurationemfFactory.eINSTANCE.createIdentification();
		id.setValue("test");
		meta.setIdentification(id);
		conf.setMeta(meta);
		assertEquals("test", conf.getMetaId());
	}

	/**
	 * Tests the '{@link configurationemf.Configuration#setMetaId(java.lang.String) <em>Meta Id</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Configuration#setMetaId(java.lang.String)
	 * @generated NOT
	 */
	public void testSetMetaId() {
		Configuration conf = getFixture();
		conf.setMetaId("test");
		Meta meta = conf.getMeta();
		assertNotNull(meta);
		Identification id = meta.getIdentification();
		assertNotNull(id);
		assertEquals("test", id.getValue());
		conf.setMetaId(null);
		assertNull(conf.getMeta());
	}

	/**
	 * Tests the '{@link configurationemf.Configuration#getOwner() <em>Owner</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Configuration#getOwner()
	 * @generated
	 */
	public void testGetOwner() {
		// Ensure that you remove @generated or mark it @generated NOT
//		fail();
		Configuration config = getFixture();
		config.setOwner(TEST_INPUT);
		assertEquals(config.getOwner(), TEST_INPUT);
	}

	/**
	 * Tests the '{@link configurationemf.Configuration#setOwner(java.lang.String) <em>Owner</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Configuration#setOwner(java.lang.String)
	 * @generated
	 */
	public void testSetOwner() {
		// Ensure that you remove @generated or mark it @generated NOT
//		fail();
	}

	/**
	 * Tests the '{@link configurationemf.Configuration#getEditor() <em>Editor</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Configuration#getEditor()
	 * @generated
	 */
	public void testGetEditor() {
		// Ensure that you remove @generated or mark it @generated NOT
//		fail();
		Configuration config = getFixture();
		config.setEditor(TEST_INPUT);
		assertEquals(TEST_INPUT,config.getEditor());

	}

	/**
	 * Tests the '{@link configurationemf.Configuration#setEditor(java.lang.String) <em>Editor</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Configuration#setEditor(java.lang.String)
	 * @generated
	 */
	public void testSetEditor() {
		// Ensure that you remove @generated or mark it @generated NOT
//		fail();
	}

	/**
	 * Tests the '{@link configurationemf.Configuration#getStatus() <em>Status</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Configuration#getStatus()
	 * @generated
	 */
	public void testGetStatus() {
		// Ensure that you remove @generated or mark it @generated NOT
//		fail();
		Configuration config = getFixture();
		config.setStatus(TEST_INPUT);
		assertEquals(TEST_INPUT,config.getStatus());

	}

	/**
	 * Tests the '{@link configurationemf.Configuration#setStatus(java.lang.String) <em>Status</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Configuration#setStatus(java.lang.String)
	 * @generated
	 */
	public void testSetStatus() {
		// Ensure that you remove @generated or mark it @generated NOT
//		fail();
	}

	/**
	 * Tests the '{@link configurationemf.Configuration#getVersion() <em>Version</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Configuration#getVersion()
	 * @generated
	 */
	public void testGetVersion() {
		// Ensure that you remove @generated or mark it @generated NOT
//		fail();
		Configuration config = getFixture();
		config.setVersion(TEST_INPUT);
		assertEquals(TEST_INPUT, config.getVersion());

	}

	/**
	 * Tests the '{@link configurationemf.Configuration#setVersion(java.lang.String) <em>Version</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Configuration#setVersion(java.lang.String)
	 * @generated
	 */
	public void testSetVersion() {
		// Ensure that you remove @generated or mark it @generated NOT
//		fail();
	}

	/**
	 * Tests the '{@link configurationemf.Configuration#getPlatform() <em>Platform</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Configuration#getPlatform()
	 * @generated
	 */
	public void testGetPlatform() {
		// Ensure that you remove @generated or mark it @generated NOT
//		fail();
		Configuration config = getFixture();
		config.setPlatform(TEST_INPUT);
		assertEquals(TEST_INPUT, config.getPlatform());
	}

	/**
	 * Tests the '{@link configurationemf.Configuration#setPlatform(java.lang.String) <em>Platform</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Configuration#setPlatform(java.lang.String)
	 * @generated
	 */
	public void testSetPlatform() {
		// Ensure that you remove @generated or mark it @generated NOT
//		fail();
	}

	/**
	 * Tests the '{@link configurationemf.Configuration#getProduct() <em>Product</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Configuration#getProduct()
	 * @generated
	 */
	public void testGetProduct() {
		// Ensure that you remove @generated or mark it @generated NOT
//		fail();
		Configuration config = getFixture();
		config.setProduct(TEST_INPUT);
		assertEquals(TEST_INPUT, config.getProduct());
	}

	/**
	 * Tests the '{@link configurationemf.Configuration#setProduct(java.lang.String) <em>Product</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Configuration#setProduct(java.lang.String)
	 * @generated
	 */
	public void testSetProduct() {
		// Ensure that you remove @generated or mark it @generated NOT
//		fail();
	}

	/**
	 * Tests the '{@link configurationemf.Configuration#getCustomer() <em>Customer</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Configuration#getCustomer()
	 * @generated
	 */
	public void testGetCustomer() {
		// Ensure that you remove @generated or mark it @generated NOT
//		fail();
		Configuration config = getFixture();
		config.setVersion(TEST_INPUT );
		assertEquals(TEST_INPUT , config.getVersion());
	}

	/**
	 * Tests the '{@link configurationemf.Configuration#setCustomer(java.lang.String) <em>Customer</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Configuration#setCustomer(java.lang.String)
	 * @generated
	 */
	public void testSetCustomer() {
		// Ensure that you remove @generated or mark it @generated NOT
//		fail();
	}

	/**
	 * Tests the '{@link configurationemf.Configuration#getDate() <em>Date</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Configuration#getDate()
	 * @generated
	 */
	public void testGetDate() {
		// Ensure that you remove @generated or mark it @generated NOT
//		fail();
		Configuration config = getFixture();
		config.setDate(TEST_INPUT );
		assertEquals(TEST_INPUT , config.getDate());
	}

	/**
	 * Tests the '{@link configurationemf.Configuration#setDate(java.lang.String) <em>Date</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Configuration#setDate(java.lang.String)
	 * @generated
	 */
	public void testSetDate() {
		// Ensure that you remove @generated or mark it @generated NOT
//		fail();
	}

	/**
	 * Tests the '{@link configurationemf.Configuration#getRelease() <em>Release</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Configuration#getRelease()
	 * @generated
	 */
	public void testGetRelease() {
		// Ensure that you remove @generated or mark it @generated NOT
//		fail();
	}

	/**
	 * Tests the '{@link configurationemf.Configuration#setRelease(java.lang.String) <em>Release</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Configuration#setRelease(java.lang.String)
	 * @generated
	 */
	public void testSetRelease() {
		// Ensure that you remove @generated or mark it @generated NOT
//		fail();
	}

	/**
	 * Tests the '{@link configurationemf.Configuration#getAllSettings() <em>Get All Settings</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Configuration#getAllSettings()
	 * @generated
	 */
	public void testGetAllSettings() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
//		Configuration config = getFixture();
//		Feature f1 = ConfigurationemfFactory.eINSTANCE.createFeature();
//		ParentSetting ps1 = ConfigurationemfFactory.eINSTANCE.createParentSetting();
//		f1.getParentSetting().add(ps1);
//		config.getFeature().add(f1);
//		assertTrue(config.getAllSettings().size()!=0);
//		assertEquals(ps1, config.getAllSettings().get(0));
	}

	/**
	 * Tests the '{@link configurationemf.Configuration#getAllSettings() <em>Get All Settings</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Configuration#getAllSettings()
	 * @generated NOT
	 */
	public void testGetAllSettingsEmptyConfiguration() {
		Configuration conf = getFixture();
		if(conf.getAllSettings()==null)fail("All settings are never null");
		Assert.assertTrue(conf.getAllSettings().isEmpty());
	}
	
	public void testGetAllSettingFeatures(){
		Configuration conf = getFixture();
		Feature feature =ConfigurationemfFactory.eINSTANCE.createFeature();
		ParentSetting setting = ConfigurationemfFactory.eINSTANCE.createParentSetting();
		feature.getParentSetting().add(setting);
		conf.getFeature().add(feature);
		Assert.assertFalse(conf.getAllSettings().isEmpty());
		
	}
	
} //ConfigurationTest
