/*
* Copyright (c) 2010 Nokia Corporation and/or its subsidiary(-ies).
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

package com.nokia.tools.variant.confml.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import junit.framework.TestCase;

import com.nokia.tools.variant.confml.core.ConfMLUtil;

public class ConfMLUtilTest extends TestCase {
	
	public void testMetadata() throws Exception {
		String activeConfig = "test.confml";
		File metadata = File.createTempFile(".metadata", "");
		
		
		ConfMLUtil.updateProjectMetadata(metadata, activeConfig);
		
		BufferedReader br = new BufferedReader(new FileReader(metadata));
		String line = null;
		boolean contains = false;
		while((line=br.readLine())!=null) {
			if(line.contains(activeConfig)) {
				contains = true;
				break;
			}
		}
		br.close();
		
		if(!contains) {
			fail(".metadata file was updated appropriately. It should contain "+activeConfig);
		}
	}

}
