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
 * Description: This file is part of com.nokia.tools.variant.javascript component.
 */
package com.nokia.tools.variant.javascript.jsmodel.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Map;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

import com.nokia.tools.variant.javascript.jsmodel.EJSDocument;
import com.nokia.tools.variant.javascript.jsmodel.EJSModelFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource </b> associated with the package.
 * <!-- end-user-doc -->
 * @see com.nokia.tools.variant.javascript.jsmodel.util.EJSModelResourceFactoryImpl
 * @generated
 */
public class EJSModelResourceImpl extends ResourceImpl {
    /**
     * Creates an instance of the resource.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param uri the URI of the new resource.
     * @generated
     */
    public EJSModelResourceImpl(URI uri) {
        super(uri);
    }
    
    @Override
    protected void doLoad(InputStream inputStream, Map<?, ?> options)
            throws IOException {
        
        Reader reader = new InputStreamReader(inputStream);
        StringBuilder tmp = new StringBuilder();
        char[] buff = new char[4096];
        int len;
        
        while ((len = reader.read(buff)) >= 0) {
            tmp.append(buff, 0, len);
        }
        
        EJSDocument document = EJSModelFactory.eINSTANCE.createEJSDocument();
        document.setScript(tmp.toString());
        getContents().add(document);
    }
    
    @Override
    protected void doSave(OutputStream outputStream, Map<?, ?> options)
            throws IOException {
        EJSDocument document = (EJSDocument)getContents().get(0);
        Writer writer = new OutputStreamWriter(outputStream);
        writer.write(document.getScript());
    }

} //EJSModelResourceImpl
