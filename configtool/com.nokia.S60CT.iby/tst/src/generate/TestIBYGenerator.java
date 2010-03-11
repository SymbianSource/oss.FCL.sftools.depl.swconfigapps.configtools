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

package generate;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;
import junit.framework.TestCase;
import mock.EntryMock;
import mock.FileNameMock;
import mock.IBYFileMock;
import mock.SrcPathMock;
import mock.TargetPathMock;
import IBY.IBYFile;

public class TestIBYGenerator extends TestCase
{
	final String ref1 = "a";
	final String ref2 = "b";
	final String ref3 = "c";
	
	public void testSetValues()
	{
		IBYFileMock file = new IBYFileMock();
		IBYGenerator generator = new IBYGenerator( new IBYFile[] { file }, "var" );
		
		EntryMock entry = new EntryMock();
		SrcPathMock src = new SrcPathMock();
		TargetPathMock target = new TargetPathMock();
		FileNameMock fileName = new FileNameMock();
		
		src.setRef( ref1 );
		target.setRef( ref2 );
		fileName.setRef( ref3 );
		
		entry.setSource( src );
		entry.setTarget( target );
		entry.setFileName( fileName );
		file.getEntries().add( entry );
		
		Map< String, Object > values = new HashMap< String, Object >();
		
		values.put( ref1, "1" );
		values.put( ref2, "1" );
		values.put( "sd", "1" );
		
		generator.setValues( values );
		
		Assert.assertTrue( "Values not Set.", src.isValueSet() && target.isValueSet() );
		Assert.assertFalse( "Values should not be set.", fileName.isValueSet() );
	}
	
	public void testGenerate()
	{
		IBYFileMock file = new IBYFileMock();
		IBYGenerator generator = new IBYGenerator( new IBYFile[] { file }, "var" );
		
		EntryMock entry = new EntryMock();
		SrcPathMock src = new SrcPathMock();
		TargetPathMock target = new TargetPathMock();
		FileNameMock fileName = new FileNameMock();
		
		src.setRef( ref1 );
		target.setRef( ref2 );
		fileName.setRef( ref3 );
		
		entry.setSource( src );
		entry.setTarget( target );
		Map< String, String > files = new HashMap< String, String >();
		files.put( "FileName1", "" );
		fileName.setFiles( files );
		entry.setFileName( fileName );
		file.getEntries().add( entry );
		
		Map< String, Object > values = new HashMap< String, Object >();
		
		values.put( ref1, "1" );
		values.put( ref2, "1" );
		values.put( "sd", "1" );
		
		generator.setValues( values );
		
		generator.saveIBYFile( file );
	}
	
	public void testReset()
	{
		IBYFileMock file = new IBYFileMock();
		IBYGenerator generator = new IBYGenerator( new IBYFile[] { file }, "var" );
		
		EntryMock entry = new EntryMock();
		SrcPathMock src = new SrcPathMock();
		TargetPathMock target = new TargetPathMock();
		FileNameMock fileName = new FileNameMock();
		
		src.setRef( ref1 );
		target.setRef( ref2 );
		fileName.setRef( ref3 );
		
		entry.setSource( src );
		entry.setTarget( target );
		entry.setFileName( fileName );
		file.getEntries().add( entry );
		
		Map< String, Object > values = new HashMap< String, Object >();
		
		values.put( ref1, "1" );
		values.put( ref2, "1" );
		values.put( "sd", "1" );
		
		generator.setValues( values );
		
		generator.reset();
	}
}
