/*
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies).
 * All rights reserved.
 * This component and the accompanying materials are made available
 * under the terms of "Eclipse Public License v1.0"
 * which accompanies this distribution, and is available
 * at the URL "http://www.eclipse.org/legal/epl-v10.html".
 * 
 * Initial Contributors:
 * Nokia Corporation - Initial contribution
 * 
 * Contributors:
 * 
 * Description: This file is part of com.nokia.tools.vct.gcfml component.
 */

package com.nokia.tools.vct.gcfml.gcfmlmodel.util;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMIException;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;

import com.nokia.tools.vct.gcfml.gcfmlmodel.EFile;
import com.nokia.tools.vct.gcfml.gcfmlmodel.EGCFMLFactory;
import com.nokia.tools.vct.gcfml.gcfmlmodel.EStylesheet;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource </b> associated with the package.
 * <!-- end-user-doc -->
 * @see com.nokia.tools.vct.gcfml.gcfmlmodel.util.EGCFMLResourceFactoryImpl
 * @generated
 */
public class EGCFMLResourceImpl extends XMLResourceImpl {

	private static final String xslStart = "<xsl:stylesheet";
	private static final String xslEnd = "</xsl:stylesheet>";
	private static final String templateStart = "<xsl:template";
	private static final String templateEnd = "</xsl:template>";
	
	
	/**
	 * Creates an instance of the resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param uri the URI of the new resource.
	 * @generated
	 */
	public EGCFMLResourceImpl(URI uri) {
		super(uri);
	}
	
	/*@Override
	protected XMLLoad createXMLLoad()
	{
		return new GCFMLXmlLoad(createXMLHelper());
	}
	
	@Override
	protected XMLHelper createXMLHelper()
	{
		return new GCFMLXMLHelperImpl();
	}*/
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.resource.impl.ResourceImpl#load(java.util.Map)
	 */
	@Override
	public void doLoad(InputStream inputStream, Map<?, ?> options)
			throws IOException {
		/*
		if(!file.exists()&&!file.isFile()){
			IOException e = new IOException(uri.toFileString()+": is not a valid URI"); //not needed?!?
			throw e;
		}*/

		// Remove XSLT template before parsing and add XSLT content manually
		String fileContent = openFile(inputStream);
		InputStream xmlContent = removeXSLTTemplate(fileContent);
		if (xmlContent == null) {
			getErrors().add(new XMIException("XSLT stylesheet template missing"));
			return;
		}
		String xsltContent = getXSLTContent(fileContent);
		if (xsltContent == null) {
			getErrors().add(new XMIException("XSLT stylesheet missing"));
			return;
		}
		super.doLoad(xmlContent, options);
		EFile gcFile = (EFile) this.getContents().get(0);
		if (gcFile.getStylesheet() == null) {
			EStylesheet stylesheet = EGCFMLFactory.eINSTANCE.createEStylesheet();
			gcFile.setStylesheet(stylesheet);
		}
		gcFile.getStylesheet().setContent(xsltContent);
	}
	
	private String getXSLTContent( String fileContent )
	{
		if (!fileContent.contains(xslStart) || !fileContent.contains(xslEnd)) {
			// Illegal format
			return null;
		}
		// Everything between XSL stylesheet tags
		return fileContent.substring( fileContent.indexOf( xslStart ), fileContent.indexOf( xslEnd ) + xslEnd.length() );
	}
	
	private InputStream removeXSLTTemplate(String fileContent)
	{
		if (!fileContent.contains(templateStart) || !fileContent.contains(templateEnd)) {
			// Illegal format
			return null;
		}
		// Before XSL template tag
		String result = fileContent.substring(0, fileContent.indexOf(templateStart));
		// After XSL template tag
		result += fileContent.substring(fileContent.lastIndexOf(templateEnd) + templateEnd.length() + 1 );
		return new ByteArrayInputStream(result.getBytes());
	}
	
	/**
	 * @param file
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private String openFile(InputStream iStream) throws FileNotFoundException,
			IOException {
		InputStreamReader isr = new InputStreamReader(iStream);
		StringWriter writer = new StringWriter();
		int read = 0;
		char[] buffer = new char[1024];
		while ( (read = isr.read( buffer ) ) != -1 ) {
			writer.write(buffer, 0, read);
		}
			
		return writer.toString();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.resource.impl.ResourceImpl#save(java.util.Map)
	 */
	@Override
	public void save(Map<?, ?> options) throws IOException {
		
		super.save(options);
	}
	

} //EGCFMLResourceImpl
