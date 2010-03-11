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
package com.nokia.tools.s60ct.build.crml;

import static org.junit.Assert.assertEquals;

import org.eclipse.emf.common.util.EList;
import org.junit.Before;
import org.junit.Test;

import com.nokia.tools.vct.crml.crmodel.EAccess;
import com.nokia.tools.vct.crml.crmodel.EAccessType;
import com.nokia.tools.vct.crml.crmodel.ECRMLFactory;
import com.nokia.tools.vct.crml.crmodel.ERepository;

public class TestCenrepGenerator {
	
	private ERepository rep;
	private EList<EAccess> access;
	private EAccess ac;

	@Before
	public void before() throws Exception {
		rep = ECRMLFactory.eINSTANCE.createERepository();

	}
	
	@Test
	public void testRepositoryWithNoAccess() throws Exception {
		rep = ECRMLFactory.eINSTANCE.createERepository();
		String cap = CenrepGenerator.createCap(rep);
		assertEquals("", cap);
	}
	
	@Test
	public void testRepositoryWithBadCaps() throws Exception {
		access = rep.getAccess();
		ac = ECRMLFactory.eINSTANCE.createEAccess();
		ac.setCapabilities("SomeCabdr");
//		ac.setType(EAccessType.ND);
		access.add(ac);
		
		assertEquals("", CenrepGenerator.createCap(rep));
	}
	
	@Test
	public void testRepositoryWithDuplicateCaps() throws Exception {
		access = rep.getAccess();
		ac = ECRMLFactory.eINSTANCE.createEAccess();
		ac.setCapabilities("Cap1");
		ac.setType(EAccessType.READ);
		access.add(ac);

		ac.setCapabilities("Cap1");
		ac.setType(EAccessType.READ);
		access.add(ac);

		assertEquals("cap_rd=Cap1", CenrepGenerator.createCap(rep));
	}

	@Test
	public void testCreateRepositoryCap() throws Exception {
		access = rep.getAccess();
		
		ac = ECRMLFactory.eINSTANCE.createEAccess();
		ac.setCapabilities("ReadDeviceData");
		ac.setType(EAccessType.READ);
		access.add(ac);
		
		ac = ECRMLFactory.eINSTANCE.createEAccess();
		ac.setCapabilities("WriteDeviceData");
		ac.setType(EAccessType.WRITE);
		access.add(ac);
		
		ac = ECRMLFactory.eINSTANCE.createEAccess();
		ac.setCapabilities("AlwaysPass");
		ac.setType(EAccessType.READ);
		access.add(ac);

		String repCap = CenrepGenerator.createCap(rep);
		assertEquals("cap_rd=ReadDeviceData cap_wr=WriteDeviceData",repCap.trim());
	}
	
	@Test
	public void testConvertAccessType() throws Exception {
		ac = ECRMLFactory.eINSTANCE.createEAccess();
		ac.setCapabilities("ReadDeviceData");
		ac.setType(EAccessType.READ);

		String accessType = CenrepGenerator.converAccessType(ac);
		
		assertEquals("cap_rd", accessType);
	}
}
