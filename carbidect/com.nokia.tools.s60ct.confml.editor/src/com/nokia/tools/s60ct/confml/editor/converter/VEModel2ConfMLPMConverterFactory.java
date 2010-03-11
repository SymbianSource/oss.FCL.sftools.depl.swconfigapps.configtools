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
package com.nokia.tools.s60ct.confml.editor.converter;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.nokia.tools.vct.confml.model.confml1.EConfML1Factory;
import com.nokia.tools.vct.confml.model.confml1.EConfMLDocument;
import com.nokia.tools.vct.confml.model.confml1.util.EConfML1ResourceImpl;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Document;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Factory;
import com.nokia.tools.vct.confml.model.confml2.EConfigurationElement;

public class VEModel2ConfMLPMConverterFactory {

	public static IVEModel2ConfMLPMConverter getConvertor(Resource resource) {
		EList<EObject> contents = resource.getContents();
		if (contents.size() > 0) {
			Object root = contents.get(0);
			if (root instanceof EConfMLDocument) {
				return new VEModel2ConfML1PMConverter();
			} else {
				return new VEModel2ConfML2PMConverter();
			}
		} else {
			if(resource instanceof EConfML1ResourceImpl) {
				if (contents.size() == 0) {
					EConfMLDocument document = EConfML1Factory.eINSTANCE
					.createEConfMLDocument();

					com.nokia.tools.vct.confml.model.confml1.EConfigurationElement	configuration = EConfML1Factory.eINSTANCE.createEConfigurationElement();
					document.setConfiguration(configuration);
					configuration.setName("data");
					resource.getContents().add(document);
					return new VEModel2ConfML1PMConverter();
				}				
			} else {
				if (contents.size() == 0) {
					EConfML2Document document2 = EConfML2Factory.eINSTANCE
					.createEConfML2Document();
					EConfigurationElement	configuration = EConfML2Factory.eINSTANCE.createEConfigurationElement();
					document2.setConfiguration(configuration);
					configuration.setName("data");
					resource.getContents().add(document2);
					return new VEModel2ConfML2PMConverter();
				}
			}
		}
		return null;
	}
}
