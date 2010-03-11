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
package configurationemf.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLLoad;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.XMLSave;
import org.eclipse.emf.ecore.xmi.impl.XMLInfoImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLLoadImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLMapImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.xml.sax.helpers.DefaultHandler;

import configurationemf.ConfigurationemfPackage;
import configurationemf.RootConf;
import configurationemf.util.FeatureRefConnector.SettingNotFound;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource </b> associated with the package.
 * <!-- end-user-doc -->
 * @see configurationemf.util.ConfigurationemfResourceFactoryImpl
 * 
 */
public class ConfigurationemfResourceImpl extends XMLResourceImpl {
	
	XMLCustomizerCONFML confmlCustomizer = new XMLCustomizerCONFML();
	
	private class ConfXMLLoadImpl extends XMLLoadImpl{
		//@Override
		protected DefaultHandler makeDefaultHandler() {
			return new ConfXMLHandler(resource, helper, options);
		}

		public ConfXMLLoadImpl(XMLHelper helper){
			super(helper);
		}
		
	}
	
	//@Override
	protected XMLLoad createXMLLoad() {
		return new ConfXMLLoadImpl(new ConfXMLHelperImpl());
	}
	//@Override
	protected XMLSave createXMLSave() {
		return new ConfXMLSaveImpl(createXMLHelper());
	}
	
	public void load(Map options) throws IOException {
		if(options==null)
			options = new HashMap();
		
		options.put(XMLResource.OPTION_EXTENDED_META_DATA, confmlCustomizer.getExtendedMetaData());
		
		XMLMap map = new XMLMapImpl();
		XMLInfo info = new XMLInfoImpl();
		info.setXMLRepresentation(XMLInfo.CONTENT);
		map.add(ConfigurationemfPackage.eINSTANCE.getContent_Value(), info);
		options.put(XMLResource.OPTION_XML_MAP, map);
		super.load(options);
		RootConf root = (RootConf)this.getContents().get(0);
		FeatureRefConnector connectorObj = new FeatureRefConnector(root);
		connectorObj.connectData();
		try{
			connectorObj.connectRfs();
		}catch(SettingNotFound e){
			System.out.println("Some refs are not connected.");
		}
		
	}
	
	public void save(Map options) throws IOException {
		if(options==null)
			options = new HashMap();
		options.put(XMLResource.OPTION_EXTENDED_META_DATA, confmlCustomizer.getExtendedMetaData());
		
		XMLMap map = new XMLMapImpl();
		XMLInfo info = new XMLInfoImpl();
		info.setXMLRepresentation(XMLInfo.CONTENT);
		map.add(ConfigurationemfPackage.eINSTANCE.getContent_Value(), info);
		
		options.put(XMLResource.OPTION_XML_MAP, map);
		options.put(XMLResource.OPTION_ENCODING, "UTF-16");
		super.save(options);
	}
	
	
	/**
	 * Creates an instance of the resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param uri the URI of the new resource.
	 * @generated
	 */
	public ConfigurationemfResourceImpl(URI uri) {
		super(uri);
		/*
		 * THIS FEATURE IS NEEDED LATER FOR MIGRATING EXISTING CONFML FILES
		 * FOR CONFIGURATION TOOL 3.X. THIS FEATURE QUIETLY MODIFIES ANY CONFML FILE 
		 * PRIOR TO OPENING AND IT UPDATES THE XINLUDE NAMESPACE AND ADDS REQUIRED 
		 * URI FRAGMENTS.
		 * 
		 * The value of XMLCustomizerCONFML.includeNS should replace 
		 * includens = "http://www.w3.org/2001/xinclude" in XMLCustomizerCONFML.setExtendedMetaData()
		 * method.
		 */
//		ConfMLRepairer repairer = new ConfMLRepairer();
//		repairer.repair(uri);
		//ConfMLRepairer repairer = new ConfMLRepairer();
		//repairer.repair(uri);
	}

} //ConfigurationemfResourceImpl
