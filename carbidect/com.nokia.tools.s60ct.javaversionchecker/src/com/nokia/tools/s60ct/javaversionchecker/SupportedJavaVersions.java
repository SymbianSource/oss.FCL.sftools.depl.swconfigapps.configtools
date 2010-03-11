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
	String versionSun15012b04 = "1.5.0_12-b04";
	
	public String[] supportedJreVendors = {vendorSun};
	public String[] supportedSunJreVersions = {versionSun15012b04};
	
	//Links to JRE download sites:
	public String sunJreDownloadSite = "http://java.sun.com/products/archive/";
	public String sunJre1_5_0_12DownloadSite = "http://java.sun.com/products/archive/j2se/5.0_12/index.html";
 }
