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

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import org.junit.Before;
import org.junit.Test;

import com.nokia.tools.s60ct.build.builder.utils.ISettingCollector;
import com.nokia.tools.s60ct.build.builder.utils.SettingAndLayer;
import com.nokia.tools.vct.crml.crmodel.ECRMLFactory;
import com.nokia.tools.vct.crml.crmodel.EKey;
import com.nokia.tools.vct.crml.crmodel.ERepository;

public class TestRepositoryWithData {
	
	private ERepository repository;

	@Before
	public void before() throws Exception {
		ECRMLFactory einstance = ECRMLFactory.eINSTANCE;
		repository = einstance.createERepository();
		repository.setUidName("someuidname");
		repository.setUidValue("0x123");
		
		EKey key = einstance.createEKey();
		key.setIdent("0x1");
		key.setRef("f1/s1");
		repository.getKey().add(key);
		key = einstance.createEKey();
		key.setIdent("0x2");
		key.setRef("f1/s2");
		repository.getKey().add(key);
	}
	
	@Test
	public void testSettingValueCollectorCalled() throws Exception {
		ISettingCollector scMock = createMock(ISettingCollector.class);
		expect(scMock.getSetting(null, "f1/s1")).andReturn(new SettingAndLayer(null,null));
		expect(scMock.getSetting(null, "f1/s2")).andReturn(new SettingAndLayer(null,null));
		replay(scMock);
		try {
			new RepositoryWithData(repository,null,scMock);
		} catch (NullPointerException expected) {}
		verify(scMock);
	}
}
