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
 * Description: This file is part of com.nokia.tools.variant.resourcelibrary component.
 */

package com.nokia.tools.variant.resourcelibrary.views;

import org.eclipse.gef.commands.CommandStack;
import org.eclipse.ui.part.IPage;

import com.nokia.tools.variant.resourcelibrary.model.ResourceModelRoot;

public interface IResourceLibraryPage extends IPage {
	void refresh();
	void expandAll();
	void collapseAll();
	CommandStack getCommandStack();
	ResourceModelRoot getResourceModelRoot();
}
