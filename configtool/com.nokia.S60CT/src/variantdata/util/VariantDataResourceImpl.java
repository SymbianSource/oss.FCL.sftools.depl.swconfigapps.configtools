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
package variantdata.util;

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
import configurationemf.util.ConfXMLHandler;
import configurationemf.util.ConfXMLHelperImpl;
import configurationemf.util.ConfXMLSaveImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource </b> associated with the package.
 * <!-- end-user-doc -->
 * @see variantdata.util.VariantDataResourceFactoryImpl
 * @generated
 */
public class VariantDataResourceImpl extends XMLResourceImpl {
	XMLCustomizerVD vdCustomizer = new XMLCustomizerVD();
	/**
	 * Creates an instance of the resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param uri the URI of the new resource.
	 * @generated
	 */
	public VariantDataResourceImpl(URI uri) {
		super(uri);
	}

	@Override
	public void load(Map options) throws IOException {
		if(options==null)
			options = new HashMap();
		options.put(XMLResource.OPTION_EXTENDED_META_DATA, vdCustomizer.getExtendedMetaData());
		XMLMap map = new XMLMapImpl();
		XMLInfo info = new XMLInfoImpl();
		info.setXMLRepresentation(XMLInfo.CONTENT);
		map.add(ConfigurationemfPackage.eINSTANCE.getContent_Value(), info);
		options.put(XMLResource.OPTION_XML_MAP, map);
		options.put(XMLResource.OPTION_ENCODING, "UTF-8");
		super.load(options);
	}

	@Override
	public void save(Map options) throws IOException {
		if(options==null)
			options = new HashMap();
		options.put(XMLResource.OPTION_EXTENDED_META_DATA, vdCustomizer.getExtendedMetaData());
		
		XMLMap map = new XMLMapImpl();
		XMLInfo info = new XMLInfoImpl();
		info.setXMLRepresentation(XMLInfo.CONTENT);
		map.add(ConfigurationemfPackage.eINSTANCE.getContent_Value(), info);
		
		options.put(XMLResource.OPTION_XML_MAP, map);
		options.put(XMLResource.OPTION_ENCODING, "UTF-8");
		super.save(options);
	}

	private class ConfXMLLoadImpl extends XMLLoadImpl{
		//@Override
		protected DefaultHandler makeDefaultHandler() {
			return new ConfXMLHandler(resource, helper, options);
		}

		public ConfXMLLoadImpl(XMLHelper helper){
			super(helper);
		}
		
	}
	public boolean isVariantDataXML(){
		return this.getURI().fileExtension().compareTo("xml")==0;
	}
	//@Override
	protected XMLLoad createXMLLoad() {
		return new ConfXMLLoadImpl(new ConfXMLHelperImpl());
	}
	//@Override
	protected XMLSave createXMLSave() {
		return new ConfXMLSaveImpl(createXMLHelper());
	}
	
} //VariantDataResourceImpl
