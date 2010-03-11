/*
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies).
 * All rights reserved.
 * This component and the accompanying materials are made available
 * under the terms of "Eclipse Public License v1.0"
 * which accompanies this distribution, and is available
 * at the URL "http://www.eclipse.org/legal/epl-v10.html".
 * 
 * Initial Contributors:
 * Nokia Corporation - Initial contribution
 * 
 * Contributors:
 * 
 * Description: This file is part of com.nokia.tools.vct.imaker.core.test component.
 */

package com.nokia.tools.variant.imaker.core;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.net.URI;

import org.junit.Before;
import org.junit.Test;

import com.nokia.tools.vct.imaker.core.IImageMaker;
import com.nokia.tools.vct.imaker.core.ImakerCore;

public class ImakerCoreTest {
	
	private IImageMaker imageMaker;

	@Before
	public void before() throws Exception {
		imageMaker = ImakerCore.getImageMaker(new URI("file//s:"));
	}
//	
//	@Test
//	public void bundleVersion() throws Exception {
//		String bundleVersion = imageMaker.getVersion();
//		System.out.println(bundleVersion);
//		assertNotNull(bundleVersion);
//		assertFalse("Bundle version should not be emtpy!", bundleVersion.equals(""));
//	}
//	
//	@Test
//	public void test1() throws Exception {
//		assertTrue(1==1);
//	}

	@Test
	public void bundleVersion() throws Exception {
		String bundleVersion = imageMaker.getVersion();
		assertNotNull(bundleVersion);
		assertFalse("Bundle version should not be emtpy!", bundleVersion.equals(""));
		assertTrue(bundleVersion.length()>= 5);
	}

	@Test
	public void imakerVersion() throws Exception {
		String imakerVerion = imageMaker.getImakerVerion();
		System.out.println(imakerVerion);
		assertTrue("Incorrect version!",imakerVerion.startsWith("iMaker"));
	}
}
