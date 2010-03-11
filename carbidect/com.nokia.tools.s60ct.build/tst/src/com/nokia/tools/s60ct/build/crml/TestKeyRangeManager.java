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

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.nokia.tools.vct.crml.crmodel.ECRMLFactory;
import com.nokia.tools.vct.crml.crmodel.EKey;
import com.nokia.tools.vct.crml.crmodel.EKeyRange;
import com.nokia.tools.vct.crml.crmodel.EKeyType;

public class TestKeyRangeManager {
	KeyRangeManager manager = KeyRangeManager.INSTANCE;
	private EKeyRange keyRange;
	
	@Before
	public void setUp() throws Exception {
		keyRange = ECRMLFactory.eINSTANCE.createEKeyRange();
		keyRange.setFirstInt("0x07000000");
		keyRange.setLastInt("0x07ffffff");
		keyRange.setRef("PIM/Contact");
		keyRange.setIndexBits("0x00ff0000");
		keyRange.setCountInt("0x07000000");
		keyRange.setFirstIndex("2");
		
		EKey key = ECRMLFactory.eINSTANCE.createEKey();
		key.setIdent("0x00000001");
		keyRange.getKeys().add(key);
		
		key = ECRMLFactory.eINSTANCE.createEKey();
		key.setIdent("0x00000002");
		keyRange.getKeys().add(key);
		
		key = ECRMLFactory.eINSTANCE.createEKey();
		key.setIdent("0x0000f00f");
		keyRange.getKeys().add(key);
	}
	
	@Test
	public void testCreateCountKey() throws Exception {
		EKey countKey = manager.createCountKey(keyRange);
		assertEquals("0x07000000", countKey.getIdent());
		assertEquals(EKeyType.INT, countKey.getType());
	}
	
	@Test
	public void testCreateKeysIndex() throws Exception {
		EKey[] keys = manager.createKeysIndex(keyRange, 0);
		assertEquals(3, keys.length);
		EKey key = keys[0];
		assertEquals("0x7020001", key.getIdent());
		
		key = keys[1];
		assertEquals("0x7020002", key.getIdent());
		
		key = keys[2];
		assertEquals("0x702f00f", key.getIdent());

		keys = manager.createKeysIndex(keyRange, 1);
		assertEquals(3, keys.length);
		key = keys[0];
		assertEquals("0x7030001", key.getIdent());
		
		key = keys[1];
		assertEquals("0x7030002", key.getIdent());
		
		key = keys[2];
		assertEquals("0x703f00f", key.getIdent());
	}
	
	@Test
	public void testCalculateAbsoluteAddress() throws Exception {
		long movedIndexBif = manager.moveFirstIndex("0x00ff0000", 2);
		long expected = 131072;
		assertEquals(expected, movedIndexBif);
		long address = manager.calculateAbsAddress(16711680, movedIndexBif, 117440512);
		expected = 117571584;
		assertEquals(expected, address);
	}
}
