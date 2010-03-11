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
 * Description: This file is part of com.nokia.tools.vct.confml.editor.include component.
 */

package com.nokia.tools.vct.confml.editor.include.xincmodel.presentation;
import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;

import com.nokia.tools.vct.confml.editor.include.XIncludeEditorPlugin;
import com.nokia.tools.vct.confml.editor.include.xincmodel.EDocument;
import com.nokia.tools.vct.confml.editor.include.xincmodel.EInclude;


public class BadIncludeReferenceDecorator implements ILightweightLabelDecorator {
	private ImageDescriptor descr;
	
	public BadIncludeReferenceDecorator() {
	}
	
	private void lazyInit() {
		if (descr == null) {
			URL url = XIncludeEditorPlugin.getPlugin().getBundle().getEntry("icons/full/ovr16/ErrorObject.gif");
			descr = ImageDescriptor.createFromURL(url);
		}
	}
	
	public void decorate(Object element, IDecoration decoration) {
		if (hasError(element)) {
			lazyInit();
			decoration.addOverlay(descr, IDecoration.BOTTOM_RIGHT);
		}
	}
	
	private boolean hasError(Object obj) {
		if (obj instanceof EInclude) {
			return ((EInclude)obj).getTarget() == null;
		} else if (obj instanceof EDocument) {
			for (EInclude inc : ((EDocument)obj).getIncludes()) {
				if (hasError(inc)) {
					return true;
				}
			}
		}
		return false;
	}
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}
	public void addListener(ILabelProviderListener listener) {
	}
	public void removeListener(ILabelProviderListener listener) {
	}
	public void dispose() {
	}
	
}
