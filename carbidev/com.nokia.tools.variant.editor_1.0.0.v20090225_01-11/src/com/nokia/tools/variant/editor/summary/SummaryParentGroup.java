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

package com.nokia.tools.variant.editor.summary;

import com.nokia.tools.variant.content.confml.impl.ParentGroupImpl;

/**
 * It represents a parent group of the Summary page. It can contain the leaf groups (SummaryLeafGroup)
 * 
 */
public class SummaryParentGroup extends ParentGroupImpl{
	public SummaryParentGroup(){
		super();
		setName("Summary");
	}
}
