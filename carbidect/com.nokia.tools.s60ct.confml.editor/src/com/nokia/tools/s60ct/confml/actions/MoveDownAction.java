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

package com.nokia.tools.s60ct.confml.actions;

import com.nokia.tools.s60ct.confml.viewer.FeatureViewer;
import com.nokia.tools.s60ct.model.confml.presentation.ConfmlEditor;

public class MoveDownAction extends MoveAction 
{
	public MoveDownAction(FeatureViewer featureViewer,ConfmlEditor editor) 
	{
		super(featureViewer,editor);
	}


	@Override
	public String getText() {
		return "Move Down";
	}

	@Override
	public String getId() {
		return "Move Down";
	}


}
