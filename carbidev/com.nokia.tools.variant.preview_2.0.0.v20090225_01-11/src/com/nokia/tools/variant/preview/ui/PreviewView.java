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
 * Description: This file is part of com.nokia.tools.variant.preview component.
 */

package com.nokia.tools.variant.preview.ui;

import com.nokia.tools.variant.common.ui.views.GenericPageBookView;
import com.nokia.tools.variant.preview.ContentPreviewPlugin;

public class PreviewView extends
	GenericPageBookView<IPreviewViewPage> {
	public static final String VIEW_ID = ContentPreviewPlugin.PREVIEW_VIEW_ID;

	public PreviewView() {
		super(IPreviewViewPage.class, "", null);
	}

}
