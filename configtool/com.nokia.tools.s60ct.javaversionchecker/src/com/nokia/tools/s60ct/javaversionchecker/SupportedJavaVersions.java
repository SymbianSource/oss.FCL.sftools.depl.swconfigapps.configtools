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

/**
 * Interface a list of all supported Java Runtime Environments that 
 * are tested with Configuration Tool plug-ins. 
 *
 */
public interface SupportedJavaVersions {
	
	// Vendors
	String vendorSun = "Sun Microsystems Inc.";
	
	// Sun versions
	String versionSun160b105 = "1.6.0-b105";
	
	public String[] supportedJreVendors = {vendorSun};
	public String[] supportedSunJreVersions = {versionSun160b105};
	
	//Links to JRE download sites:
	public String sunJreDownloadSite = "http://java.sun.com/products/archive/";
	public String sunJre1_6_0_DownloadSite = "http://java.sun.com/products/archive/j2se/6/index.html";
 }
