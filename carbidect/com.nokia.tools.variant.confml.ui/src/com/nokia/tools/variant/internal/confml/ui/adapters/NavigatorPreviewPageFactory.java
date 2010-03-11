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

package com.nokia.tools.variant.internal.confml.ui.adapters;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.navigator.resources.ProjectExplorer;
import org.eclipse.ui.views.navigator.ResourceNavigator;

/**
 * Adapter factory for preview page for navigators
 * 
 */
public class NavigatorPreviewPageFactory implements IAdapterFactory {

	/** The factory produces generic selection-based preview page */
	static final Class<?>[] adapters = { /*IPreviewViewPage.class */};

	@SuppressWarnings("unchecked")
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (!(adaptableObject instanceof CommonNavigator
				|| adaptableObject instanceof ResourceNavigator || adaptableObject instanceof ProjectExplorer)) {
			return null;
		}

//		if (!adapterType.equals(IPreviewViewPage.class)) {
//			return null;
//		}
//
//		return new PreviewViewPage((IWorkbenchPart)adaptableObject);
		return null;
	}

	public Class<?>[] getAdapterList() {
		return adapters.clone();
	}
}
