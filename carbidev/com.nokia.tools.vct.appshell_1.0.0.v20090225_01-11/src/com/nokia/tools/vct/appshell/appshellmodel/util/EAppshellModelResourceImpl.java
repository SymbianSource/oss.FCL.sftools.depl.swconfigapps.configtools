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
 * Description: This file is part of com.nokia.tools.vct.appshell component.
 */

package com.nokia.tools.vct.appshell.appshellmodel.util;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMLLoad;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource </b> associated with the package.
 * <!-- end-user-doc -->
 * @see com.nokia.tools.vct.appshell.appshellmodel.util.EAppshellModelResourceFactoryImpl
 * @generated
 */
public class EAppshellModelResourceImpl extends XMLResourceImpl {
	/**
	 * Creates an instance of the resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param uri the URI of the new resource.
	 * @generated
	 */
	public EAppshellModelResourceImpl(URI uri) {
		super(uri);
	}

	@Override
	public void doSave(OutputStream outputStream, Map<?, ?> options)
			throws IOException {
		PrintWriter pw = new PrintWriter(outputStream);
		pw.print("<?xml version=\"");
		pw.print("1.0");
		pw.print("\" encoding=\"");
		pw.print(encoding);
		pw.println("\"?>");
		pw.println("<!DOCTYPE xcfwml SYSTEM \"appshelldata.dtd\">");
		pw.flush();
		Map<Object,Object> opt2 = new HashMap<Object, Object>();
		opt2.put(OPTION_SAVE_DOCTYPE, Boolean.FALSE);
		opt2.put(OPTION_DECLARE_XML, Boolean.FALSE);
		
		super.doSave(outputStream, mergeMaps(opt2, options));
	}
	
	@Override
	public void doSave(Writer writer, Map<?, ?> options) throws IOException {
		PrintWriter pw = new PrintWriter(writer);
		pw.print("<?xml version=\"");
		pw.print("1.0");
		pw.print("\" encoding=\"");
		pw.print(encoding);
		pw.println("\"?>");
		pw.println("<!DOCTYPE xcfwml SYSTEM \"appshelldata.dtd\">");
		pw.flush();
		Map<Object,Object> opt2 = new HashMap<Object, Object>();
		opt2.put(OPTION_SAVE_DOCTYPE, Boolean.FALSE);
		opt2.put(OPTION_DECLARE_XML, Boolean.FALSE);
		
		super.doSave(writer, mergeMaps(opt2, options));
	}
	
	@Override
	protected XMLLoad createXMLLoad() {
	    return new EAppshellXMLLoad(createXMLHelper());
	}
	
} //EAppshellModelResourceImpl
