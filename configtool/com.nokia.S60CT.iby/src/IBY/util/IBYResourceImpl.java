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
package IBY.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource </b> associated with the package.
 * <!-- end-user-doc -->
 * @see IBY.util.IBYResourceFactoryImpl
 * @generated NOT
 */
public class IBYResourceImpl extends XMLResourceImpl {
	XMLCustomizer customizer = new XMLCustomizer();
	Map options = new HashMap();
	
	/**
	 * Creates an instance of the resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param uri the URI of the new resource.
	 * @generated NOT
	 */
	public IBYResourceImpl(URI uri) {
		super(uri);
		this.setEncoding("UTF-16");
		options.put(XMLResource.OPTION_EXTENDED_META_DATA, customizer.getExtendedMetaData());
	}

	public void load(Map<?, ?> options) throws IOException {
		super.load(this.options);
	}

	
	public void save(Map<?, ?> options) throws IOException {
		super.save(this.options);
	}

	
} //IBYResourceImpl
