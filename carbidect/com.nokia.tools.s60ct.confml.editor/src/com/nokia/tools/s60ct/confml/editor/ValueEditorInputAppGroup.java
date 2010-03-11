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

package com.nokia.tools.s60ct.confml.editor;

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;

import com.nokia.tools.vct.common.appmodel.EAppGroup;

public class ValueEditorInputAppGroup extends URIEditorInput {

	private EAppGroup group;
		
	public EAppGroup getGroup() {
		return group;
	}

	public ValueEditorInputAppGroup(URI uri, EAppGroup group) {
		super(uri);
		this.group = group;
		
	}

	@Override
	public String getName() {
		return group.getName();
	}
		
}
