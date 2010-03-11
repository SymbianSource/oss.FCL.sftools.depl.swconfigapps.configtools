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

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;

import com.nokia.tools.s60ct.model.confml.ESequenceValueItem;
import com.nokia.tools.s60ct.model.confml.EValueEditorDocument;

public abstract class VEModel2ConfMLPMConverter implements
		IVEModel2ConfMLPMConverter {

	public abstract void mergeItemsWithResource(Resource resource,
			List<ESequenceValueItem> items, String featureRef, String settingRef);

	public abstract void mergePMDataWithResource(Resource resource, List<Object> featureDataObjects);

	public abstract List<Object> createPMData(EValueEditorDocument editorModel);

}
