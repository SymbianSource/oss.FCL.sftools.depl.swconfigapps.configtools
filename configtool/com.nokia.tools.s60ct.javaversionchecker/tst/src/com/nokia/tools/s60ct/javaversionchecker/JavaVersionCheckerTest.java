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
package com.nokia.tools.s60ct.javaversionchecker;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for JavaVersionChecker
 */
public class JavaVersionCheckerTest {
	
	static final String UNSUPPORTED_VENDOR = "unsupported vendor";
	static final String SUPPORTED_VENDOR = SupportedJavaVersions.vendorSun;
	static final String UNSUPPORTED_SUN_VERSION = "1.0";
	static final String SUPPORTED_SUN_VERSION = SupportedJavaVersions.versionSun160b105;

	Properties systemProperties = null;
	Object expectedCurrentVersion = null;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		systemProperties = System.getProperties();
		expectedCurrentVersion = systemProperties.get("java.runtime.version");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.nokia.tools.s60ct.javaversionchecker.JavaVersionChecker#isSupportedJreVersion(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testIsSupportedJreVersion()throws Exception {
		assertTrue("True expected when given vendor and version: " + SUPPORTED_VENDOR + " " + SUPPORTED_SUN_VERSION, 
				JavaVersionChecker.isSupportedJreVersion(SUPPORTED_VENDOR, SUPPORTED_SUN_VERSION));
	}
	
	/**
	 * Test method for {@link com.nokia.tools.s60ct.javaversionchecker.JavaVersionChecker#isSupportedJreVersion(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testIsSupportedJreVersionNull()throws Exception {
		assertFalse("False expected when given vendor and version: NULL NULL", 
				JavaVersionChecker.isSupportedJreVersion(null, null));
	}

	/**
	 * Test method for {@link com.nokia.tools.s60ct.javaversionchecker.JavaVersionChecker#isSupportedJreVersion(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testIsSupportedJreVersionNok() throws Exception{
		assertFalse("False expected when given vendor and version: " + UNSUPPORTED_VENDOR + " " + UNSUPPORTED_SUN_VERSION, 
				JavaVersionChecker.isSupportedJreVersion(UNSUPPORTED_VENDOR, UNSUPPORTED_SUN_VERSION));
	}

	/**
	 * Test method for {@link com.nokia.tools.s60ct.javaversionchecker.JavaVersionChecker#isCurrentJreSupported()}.
	 */
	@Test
	public void testIsCurrentJreSupported() throws Exception {
		String version = systemProperties.getProperty("java.runtime.version");
		String vendor = systemProperties.getProperty("java.vendor");
		
		if (version.equals(SupportedJavaVersions.versionSun160b105) && vendor.equals(SupportedJavaVersions.vendorSun)){
			assertTrue("Current JRE is expected to be supported: " + vendor + " " + version, 
					JavaVersionChecker.isCurrentJreSupported());
		}else{
			assertFalse("Current JRE is expected to be supported: " + vendor + " " + version, 
					JavaVersionChecker.isCurrentJreSupported());
		}
	}
	
	
	/**
	 * Test method for {@link com.nokia.tools.s60ct.javaversionchecker.JavaVersionChecker#getSystemPropertyValue(java.lang.String)}.
	 */
	@Test
	public void testGetSystemPropertyValue() throws Exception{
		assertEquals("True expected ", expectedCurrentVersion, JavaVersionChecker.getSystemPropertyValue("java.runtime.version"));
	}

	
	/**
	 * Test method for {@link com.nokia.tools.s60ct.javaversionchecker.JavaVersionChecker#getSystemPropertyValue(java.lang.String)}.
	 */
	@Test
	public void testGetSystemPropertyValueNok(){
		
		try {
			JavaVersionChecker.getSystemPropertyValue("INVALID PROPERTY");
			fail("IllegalArgumentException expected.");
		} catch (IllegalStateException e) {
			fail("IllegalArgumentException expected.");		
		} catch (IllegalArgumentException e) {
			return;
		}
		
		fail("IllegalArgumentException expected.");
	}
	
	/**
	 * Test method for {@link com.nokia.tools.s60ct.javaversionchecker.JavaVersionChecker#getSupportedJreNames()}.
	 */
	@Test
	public void testGetSupportedJreNames() throws Exception{
		
		String names = JavaVersionChecker.getSupportedJreNames();
		
		assertNotNull("Not null expected", names);
		assertTrue("Greater lenght expected", names.length() > 1);
	}

	
	/**
	 * Test method for {@link com.nokia.tools.s60ct.javaversionchecker.JavaVersionChecker#getCurrentVendorAndVersion()}.
	 */
	@Test
	public void testGetCurrentVendorAndVersion() throws Exception {
		String version = systemProperties.getProperty("java.runtime.version");
		String vendor = systemProperties.getProperty("java.vendor");
		
		String result = JavaVersionChecker.getCurrentVendorAndVersion();
		
		
		assertTrue("Current JRE version not found from result: " + version, 
				result.contains(version));
		assertTrue("Current JRE vendor not found from result: " + vendor, 
				result.contains(vendor));

	}
	
}