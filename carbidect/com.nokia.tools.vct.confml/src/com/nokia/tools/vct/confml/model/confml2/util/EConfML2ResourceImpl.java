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
 * Description: This file is part of com.nokia.tools.vct.confml component.
 */

package com.nokia.tools.vct.confml.model.confml2.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLLoad;
import org.eclipse.emf.ecore.xmi.XMLSave;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;

import com.nokia.tools.vct.confml.model.confml1.util.ConfMLXmlLoad;
import com.nokia.tools.vct.confml.model.confml1.util.ConfXMLHelperImpl;
import com.nokia.tools.vct.confml.model.confml1.util.ConfXMLSaveImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource </b> associated with the package.
 * <!-- end-user-doc -->
 * @see com.nokia.tools.vct.confml.model.confml2.util.EConfML2ResourceFactoryImpl
 * @generated
 */
public class EConfML2ResourceImpl extends XMLResourceImpl {
	/**
	 * Creates an instance of the resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param uri the URI of the new resource.
	 * @generated
	 */
	public EConfML2ResourceImpl(URI uri) {
		super(uri);
	}

	@Override
	protected XMLLoad createXMLLoad() {
		return new ConfMLXmlLoad(createXMLHelper());
	}

	@Override
	protected XMLSave createXMLSave() {
		return new ConfXMLSaveImpl(createXMLHelper());
	}

	@Override
	protected XMLHelper createXMLHelper() {
		return new ConfXMLHelperImpl();
	}

} //EConfML2ResourceImpl
