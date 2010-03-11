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

import org.eclipse.emf.ecore.resource.Resource;

import com.nokia.tools.variant.editor.cpfInfo.CPFInformation;

/**
 * Covertor used for loading/saving CPFProperties into ConfML <meta> tags
 * 
 */
public interface CPFInformationConvertor {
	public CPFInformation loadCPFInformationFromResource(Resource resource);
	
	public void copyCPFInformationToResource(Resource resource, CPFInformation cpfInformation);
}
