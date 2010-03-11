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

package itemProviders;

import java.io.File;
import java.util.List;

import junit.framework.TestCase;
import mock.AdapterFactoryMock;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import s60ct.provider.FrameItemProvider;
import configurationemf.Feature;
import configurationemf.Frame;
import configurationemf.LeafSettingDelegator;
import configurationemf.ParentSetting;
import configurationemf.RootConf;
import configurationemf.util.ConfigurationemfResourceFactoryImpl;
import configurationemf.util.ConfigurationemfResourceImpl;


public class FrameItemProviderTest extends TestCase {
	
	ResourceSet resourceSet=null;
	FrameItemProvider itemProvider = null;
	
	public FrameItemProviderTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		resourceSet = new ResourceSetImpl();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("confml", new ConfigurationemfResourceFactoryImpl());
		
		itemProvider=new FrameItemProvider(new AdapterFactoryMock());
	
	}

	protected void tearDown() throws Exception {
		resourceSet=null;
		
		itemProvider=null;
	}

	public void testGetChildFeatureObjectObjectTemplate() {
		ParentSetting pSetting = readSequenceSetting("inputFiles\\phonebook.confml");
		Frame template = pSetting.getTemplate();
		List<LeafSettingDelegator> delegators = (List<LeafSettingDelegator>)itemProvider.getChildren(template);
		assertEquals("Template should have one EMPTY setting.",template.getLeafSettings().size()+1, delegators.size());
		assertEquals(FrameItemProvider.EMPTY_DELEGATOR,delegators.get(delegators.size()-1));
	
		pSetting = readBasedOnSequenceSetting("inputFiles\\myReplace.confml");
		template = pSetting.getTemplate();
		delegators = (List<LeafSettingDelegator>)itemProvider.getChildren(template);
		assertEquals("Template should NOT have an EMPTY setting.",template.getLeafSettings().size(), delegators.size());
		
	}

	private ParentSetting readSequenceSetting(String filePath) {
		Resource resource = new ConfigurationemfResourceImpl(URI.createFileURI(filePath));
		try{
			resource.load(null);
		}catch(Exception e){
			fail(e.getMessage());
		}
		if(!resource.getContents().isEmpty())
		{
			RootConf configuration = (RootConf)resource.getContents().get(0);
			Feature feature = configuration.getFeature().get(0);
			ParentSetting pSetting = feature.getParentSetting().get(0);
			return pSetting;
		}
		else
			return null;
	}
	
	private ParentSetting readBasedOnSequenceSetting(String filePath) {
		resourceSet.getResources().clear();
		Resource resource = resourceSet.createResource(URI.createFileURI(new File(filePath).getAbsolutePath()));
		
		try{
			resource.load(null);
		}catch(Exception e){
			fail(e.getMessage());
		}
		if(!resource.getContents().isEmpty())
		{
			RootConf configuration = (RootConf)resource.getContents().get(0);
			RootConf basedOn = configuration.getInclude().get(0);
			Feature feature = basedOn.getFeature().get(0);
			ParentSetting pSetting = feature.getParentSetting().get(0);
			return pSetting;
		}
		else
			return null;
	}
}
