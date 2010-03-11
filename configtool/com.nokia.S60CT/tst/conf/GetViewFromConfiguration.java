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

package conf;

import junit.framework.Assert;
import junit.framework.JUnit4TestAdapter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import configurationemf.ConfigurationemfFactory;
import configurationemf.RootConf;
import configurationemf.View;

public class GetViewFromConfiguration {

	public static junit.framework.Test suite(){
		return new JUnit4TestAdapter(GetViewFromConfiguration.class);
	}
	
	RootConf conf = null;
	
	
	@Before
	public void setUp(){
		conf = ConfigurationemfFactory.eINSTANCE.createRootConf();
	}
	
	@After
	public void tearDown(){
		conf=null;
	}
	@Test
	public void findViewInCurrentConfiguration() throws Exception {
		View toBeFound = createViewWithID("id");
		conf.getView().add(toBeFound);
		Assert.assertEquals(toBeFound, conf.getViewById("ID"));
	}

	private View createViewWithID(String id) {
		View toBeFound = createViewWithID("id");
		
		return toBeFound;
	}
	@Test
	public void fingViewInSubConfiguration() throws Exception {
		
	}
	@Test
	public void findViewInBasedOnConfiguration() throws Exception {
		
	}
}
