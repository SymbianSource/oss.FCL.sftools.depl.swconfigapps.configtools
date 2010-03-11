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

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;

import com.nokia.tools.variant.common.ui.views.GenericPageBookView;
import com.nokia.tools.variant.preview.ui.IPreviewViewPageContributor;
import com.nokia.tools.variant.resourcelibrary.model.ResourceModelRoot;

public class ResourceLibraryView extends
		GenericPageBookView<IResourceLibraryPage> implements
		IPreviewViewPageContributor {

	public static final String ID = "com.nokia.tools.variant.resourcelibrary.views.ResourceLibraryView";

	public ResourceLibraryView() {
		super(IResourceLibraryPage.class, "", null);
	}

	@Override
	protected boolean isImportant(IWorkbenchPart part) {
		return part != this && part instanceof IEditorPart;
	}

	@Override
	protected PageRec doCreatePage(IWorkbenchPart part) {
		Object resorceModelRoot = part.getAdapter(ResourceModelRoot.class);

		if (resorceModelRoot != null) {
			IResourceLibraryContentProvider contentProvider = new ResourceLibraryContentProvider(
					(ResourceModelRoot) resorceModelRoot);
			ResourceLibraryPage page = new ResourceLibraryPage(part,
					contentProvider);
			initPage(page);
			page.createControl(getPageBook());

			return new PageRec(part, page);
		}
		return null;
	}
}
