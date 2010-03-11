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

package generate.test;

import generate.CenrepGenerator;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;
import junit.framework.TestCase;
import mocks.BitMock;
import mocks.KeyMock;
import mocks.RepositoryMock;
import cenrep.Bit;
import cenrep.CenrepFactory;
import cenrep.Key;
import cenrep.Repository;

public class GeneratorTest extends TestCase {
	
	
	CenrepGenerator generator;
	String foundKRef = "foundKey";
	Repository rep=null;
	
	@Override
	protected void setUp() throws Exception {
		generator = new CenrepGenerator();
		rep = CenrepFactory.eINSTANCE.createRepository();
		rep.setUidValue("0x111111");
	}

	@Override
	protected void tearDown() throws Exception {
		generator = null;
		rep=null;
	}

	public void testSetValue(){
		
		
		KeyMock keyWithFRef = new KeyMock(foundKRef);
		KeyMock keyWithNFRef = new KeyMock("nfoundKey");
		
		Key keyWithBits = new KeyMock(null);
		BitMock foundBit = new BitMock("foundBit");
		BitMock nFoundBit = new BitMock("nfoundBit");
		keyWithBits.getBits().add(foundBit);
		keyWithBits.getBits().add(nFoundBit);
		
		Repository rep = new RepositoryMock();
		rep.getKey().add(keyWithBits);
		rep.getKey().add(keyWithFRef);
		rep.getKey().add(keyWithNFRef);
		
		Map<String, Object> value = new HashMap<String, Object>();
		value.put(foundKRef, "1");
		value.put("nFoundKey", "2");
		value.put("foundBit", "1");
		
		generator.setRepositories(new Repository[]{rep});
		generator.setRefValue(value);
		
		Assert.assertTrue("Key's value is not set.",keyWithFRef.isGValueSet());
		Assert.assertFalse("Key's value is set, but ref was not in data",keyWithNFRef.isGValueSet());
		Assert.assertTrue("Bit's value is not set.",foundBit.isGValueSet());
		Assert.assertFalse("Bit's value is set, but ref was not in data",nFoundBit.isGValueSet());
	}
	
	public void testGenerateEmptyRep(){
		Repository rep = CenrepFactory.eINSTANCE.createRepository();
		rep.setUidValue("0x111111");
		generator.setRepositories(new Repository[]{rep});
		Map<String,String> result = (Map<String, String>)generator.generate();
		Assert.assertFalse("Empty repository is not generated", result.size()!=1);
	}
	
	public void testGenerateSimpleKey(){
		rep.getKey().add(createSimpleKey());
		generator.setRepositories(new Repository[]{rep});
		Map<String,String> result = (Map<String, String>)generator.generate();
		Assert.assertFalse("Simple key is not generated", result.size()!=1);
	}

	private Key createSimpleKey() {
		Key simpleKey = CenrepFactory.eINSTANCE.createKey();
		simpleKey.setIdent("0x0000001");
		simpleKey.setGvalue("1");
		return simpleKey;
	}

	private Key createBitmaskKey() {
		Key bitmaskKey = CenrepFactory.eINSTANCE.createKey();
		bitmaskKey.setIdent("0x0000001");
		Bit bit1 = CenrepFactory.eINSTANCE.createBit();
		bit1.setNumber(1);
		bit1.setGvalue("true");
		Assert.assertTrue("Bit 1 cannot be generated",bit1.canGenerate());
		Bit bit2 = CenrepFactory.eINSTANCE.createBit();
		bit2.setNumber(2);
		bit2.setGvalue("true");
		bitmaskKey.getBits().add(bit1);
		bitmaskKey.getBits().add(bit2);
		Assert.assertTrue("Bit 2 cannot be generated",bit2.canGenerate());
		Assert.assertTrue("Key cannot be generated",bitmaskKey.canGenerate());
		return bitmaskKey;
	}
	
	public void testGenerateBitmaskKey(){
		rep.getKey().add(createBitmaskKey());
		generator.setRepositories(new Repository[]{rep});
		Map<String,String> result = (Map<String, String>)generator.generate();
		Assert.assertTrue("Bitmask key is not generated "+result.size(), result.size()==1);
	}
	
	public void testGenerateRfsKey()
	{
		Key key = CenrepFactory.eINSTANCE.createKey();
		key.setIdent("0x0000001");
		key.setName( "RfsKey" );
		key.setRfs( true );
		rep.getKey().add(key);
		Map<String, Object> value = new HashMap<String, Object>();
		value.put( key.getRef(), "NewValue");
		generator.setRepositories( new Repository[] { rep } );
		generator.setRefValue(value);
		Map< String, String > result = ( Map< String, String > ) generator.generate();
		Assert.assertTrue( "RFS key is not generated " + result.size(), result.size() == 1 );
	}
}
