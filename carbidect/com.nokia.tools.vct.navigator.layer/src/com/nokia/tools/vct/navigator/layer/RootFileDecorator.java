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
 * Description: This file is part of com.nokia.tools.vct.navigator.layer component.
 */

package com.nokia.tools.vct.navigator.layer;

import java.net.URL;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;

import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;

public class RootFileDecorator implements ILightweightLabelDecorator {

	private ListenerList listeners;
	private ImageDescriptor rootDescriptor;

	public RootFileDecorator() {
		listeners = new ListenerList();
	}

	private void lazyInit() {
		if (rootDescriptor == null) {
			URL url = ConfigurationNavigatorPlugin.getPlugin().getBundle().getEntry("icons/full/ovr16/ActiveRoot.gif");
			rootDescriptor = ImageDescriptor.createFromURL(url);
		}
	}
	
	public void decorate(Object element, IDecoration decoration) {
		lazyInit();
		if (!(element instanceof IFile)) {
			return;
		}
		IFile file = (IFile)element;
		EConfigurationProject cp = ConfMLCore.getProjectModel(file.getProject());
		if (cp == null) {
			return;
		}
		URI rootConfmlURI = cp.getRootConfml();
		URI fileURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		if (rootConfmlURI.equals(fileURI)) {
			decoration.addOverlay(rootDescriptor);
		}
	}

	public void addListener(ILabelProviderListener listener) {
		listeners.add(listener);
	}

	public void dispose() {
		listeners.clear();
	}

	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {
		listeners.remove(listener);
	}

}
