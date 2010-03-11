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

import java.util.Arrays;
import java.util.Properties;

/**
 * Utility class that checks used java version. 
 *
 */
public class JavaVersionChecker {
	
	private static final String EMPTY_STRING = "";
	private static final String JAVA_VENDOR_PROPERTY = "java.vendor";
	private static final String JAVA_VERSION_PROPERTY = "java.runtime.version";
	
	/**
	 * Checks currently used java vendor and version
	 * 
	 * @return true if current JRE vendor and version is supported
	 */
	public static boolean isCurrentJreSupported(){
		String fetchedVersion = null;
		String fetchedVendor = null;
		boolean ret = false;
		
		try {
			fetchedVersion = getSystemPropertyValue(JAVA_VERSION_PROPERTY);
			fetchedVendor = getSystemPropertyValue(JAVA_VENDOR_PROPERTY);
		} catch (Exception e) {
			return false;
		}
		
		ret = isSupportedJreVersion(fetchedVendor, fetchedVersion);
		
		return ret;
	}
	
	/**
	 * Returns currently used JRE vendor and version in one String.
	 * @return currently used JRE vendor and version
	 */
	public static String getCurrentVendorAndVersion(){
		String fetchedVersion = null;
		String fetchedVendor = null;
		
		try {
			fetchedVersion = getSystemPropertyValue(JAVA_VERSION_PROPERTY);
			fetchedVendor = getSystemPropertyValue(JAVA_VENDOR_PROPERTY);
		} catch (Exception e) {
			return "Unknown";
		}

		return fetchedVendor + " " + fetchedVersion;
	}
	
	/**
	 * Returns supported JRE names in one String each on own line.
	 * 
	 * @return supported JRE names (vendor and version)
	 */
	public static String getSupportedJreNames(){
		StringBuffer sb = new StringBuffer();
		
		//Supported Sun JREs
		for (int i = 0; i < SupportedJavaVersions.supportedSunJreVersions.length; i++) {
			sb.append(SupportedJavaVersions.vendorSun);
			sb.append(" ");
			sb.append(SupportedJavaVersions.supportedSunJreVersions[i]);
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	
	/**
	 * Returns false is given version and vendor is not supported.  
	 * 
	 * @param vendor JRE vendor
	 * @param version JRE version
	 * @return true if given JRE vendor and version is supported. 
	 * 
	 * @see SupportedJavaVersions
	 */
	public static boolean isSupportedJreVersion(String vendor, String version){
		boolean ret = false;
		
		if (Arrays.asList(SupportedJavaVersions.vendorSun).contains(vendor)){
			if (Arrays.asList(SupportedJavaVersions.supportedSunJreVersions).contains(version)){
				ret = true;
			}
		}
		
		return ret;	
	}
	
	
	/**
	 * Fetches requested system property.
	 * 
	 * @param propertyKey name of system property
	 * @return value of given system property
	 * @throws IllegalStateException 
	 */
	public static String getSystemPropertyValue(String propertyKey) throws IllegalStateException, IllegalArgumentException{
		String value = null;
		
		try {
			Properties systemProperties = System.getProperties();
			if (systemProperties.containsKey(propertyKey)){
				value = (String)systemProperties.getProperty(propertyKey, EMPTY_STRING);	
			}
			
		} catch (Exception e) {
			throw new IllegalStateException("Could not fetch requested system property: '" + propertyKey + "'. " + e.getMessage(), e); 
		}
		
		if (value == null){
			throw new IllegalArgumentException("Could not fetch requested system property: '"+ propertyKey + "'.");	
		}
		
		return value;
	}

}