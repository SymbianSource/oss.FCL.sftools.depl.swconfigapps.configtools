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
 * Description: This file is part of com.nokia.tools.variant.editor component.
 */

package com.nokia.tools.variant.editor.model.convertor;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.nokia.tools.vct.confml.model.confml1.EConfMLDocument;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Document;

public class CPFInformationConvertorFactory {
	public static CPFInformationConvertor getCPFInformationConvertor(Resource rootConfMLResource) {
		EList<EObject> contents = rootConfMLResource.getContents();
		if (contents.size() == 0) {
			return null;
		}
		EObject root = contents.get(0);
		if (root instanceof EConfMLDocument) {
			return new ConfML1CPFInformationConvertor();
		} else if (root instanceof EConfML2Document) {
			return new ConfML2CPFInformationConvertor();		
		}
		return null;
	}
}
