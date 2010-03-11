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
package gcmodel.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource </b> associated with the package.
 * <!-- end-user-doc -->
 * @see gcmodel.util.GcmodelResourceFactoryImpl
 * @generated
 */
public class GcmodelResourceImpl extends XMLResourceImpl {
	/**
	 * Creates an instance of the resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param uri the URI of the new resource.
	 * @generated
	 */
	public GcmodelResourceImpl(URI uri) {
		super(uri);
	}

	XMLCustomizerGC customizer = new XMLCustomizerGC();
	private static final String xslStart = "<xsl:stylesheet";
	private static final String xslEnd = "</xsl:stylesheet>";
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.resource.impl.ResourceImpl#load(java.util.Map)
	 */
	@Override
	public void load(Map options) throws IOException {
		URI uri =	this.getURI();
		File file = new File(uri.toFileString());
		if(!file.exists()&&!file.isFile()){
			IOException e = new IOException(uri.toFileString()+": is not a valid URI");
			throw e;
		}
		String fileContent = openFile(file);
		InputStream xmlContent = getXMLContent(fileContent);
		if (xmlContent == null) {
			IOException e = new IOException(uri.toFileString()+": illegal file format");
			throw e;
		}
		String xsltContent = getXSLTContent(fileContent);
		if (xsltContent == null) {
			IOException e = new IOException(uri.toFileString()+": illegal file format");
			throw e;
		}
		if(options==null)options = new HashMap<Object, Object>();
		
		options.put(XMLResource.OPTION_EXTENDED_META_DATA, customizer.getExtendedMetaData());
		
		super.load(xmlContent,options);
		gcmodel.File gcFile = (gcmodel.File)this.getContents().get(0);
		gcFile.setTemplate(xsltContent);
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
	
	private InputStream getXMLContent( String fileContent )
	{
		if (!fileContent.contains(xslStart) || !fileContent.contains(xslEnd)) {
			// Illegal format
			return null;
		}
		// Before XSL stylesheet tag
		String result = fileContent.substring( 0, fileContent.indexOf( xslStart ) );
		// After XSL stylesheet tag
		result += fileContent.substring( fileContent.indexOf( xslEnd ) + xslEnd.length() + 1 );
		return new ByteArrayInputStream( result.getBytes() );
	}
	
	/**
	 * @param file
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private String openFile(File file) throws FileNotFoundException,
			IOException {
		StringBuffer data = new StringBuffer( ( int ) file.length() );
		FileReader reader = new FileReader( file );
		char[] buffer = new char[1024];
		int read = 0;
		while ( (read = reader.read( buffer ) ) != -1 )
		{
			data.append( buffer, 0, read );
		}
		String xml = data.toString();
		return xml;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.resource.impl.ResourceImpl#save(java.util.Map)
	 */
	@Override
	public void save(Map<?, ?> options) throws IOException {
		super.save(options);
	}

	
} //GcmodelResourceImpl
