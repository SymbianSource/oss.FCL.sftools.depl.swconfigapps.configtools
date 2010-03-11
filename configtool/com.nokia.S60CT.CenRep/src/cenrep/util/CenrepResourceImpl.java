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
package cenrep.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLInfoImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLMapImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;

import cenrep.CenrepPackage;



/**
 * <!-- begin-user-doc -->
 * The <b>Resource </b> associated with the package.
 * <!-- end-user-doc -->
 * @see cenrep.util.CenrepResourceFactoryImpl
 * @generated
 */
public class CenrepResourceImpl extends XMLResourceImpl {
	
	XMLCustomizer customizer = new XMLCustomizer();
	
	/**
	 * Creates an instance of the resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param uri the URI of the new resource.
	 * @generated
	 */
	public CenrepResourceImpl(URI uri) {
		super(uri);
	}

	public void save(Map options) throws IOException {
		if(options==null)
			options = new HashMap();
		options.put(XMLResource.OPTION_EXTENDED_META_DATA, customizer.getExtendedMetaData());
		
		XMLMap map = new XMLMapImpl();
		XMLInfo info = new XMLInfoImpl();
		info.setXMLRepresentation(XMLInfo.CONTENT);
		
		map.add(CenrepPackage.eINSTANCE.getContent_Value(), info);
		
		options.put(XMLResource.OPTION_XML_MAP, map);
		options.put(XMLResource.OPTION_ENCODING, "UTF-16");
		super.save(options);
	}

	public void load(Map options) throws IOException {
		if(options==null)
			options = new HashMap();
		
		
		XMLMap map = new XMLMapImpl();
		XMLInfo info = new XMLInfoImpl();
		info.setXMLRepresentation(XMLInfo.CONTENT);
		map.add(CenrepPackage.eINSTANCE.getContent_Value(), info);
		
		options.put(XMLResource.OPTION_XML_MAP, map);
		options.put(XMLResource.OPTION_EXTENDED_META_DATA, customizer.getExtendedMetaData());
		super.load(options);
	}
	
	
} //CenrepResourceImpl
