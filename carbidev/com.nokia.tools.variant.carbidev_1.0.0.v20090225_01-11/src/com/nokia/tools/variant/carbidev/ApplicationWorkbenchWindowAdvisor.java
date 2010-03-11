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
 * Description: This file is part of com.nokia.tools.variant.carbidev component.
 */

package com.nokia.tools.variant.carbidev;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

import com.nokia.tools.variant.editor.drop.CPFEditorAreaDropAdapter;

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

	public ApplicationWorkbenchWindowAdvisor(
			IWorkbenchWindowConfigurer configurer) {
		super(configurer);
	}

	public ActionBarAdvisor createActionBarAdvisor(
			IActionBarConfigurer configurer) {
		return new ApplicationActionBarAdvisor(configurer);
	}

	public void preWindowOpen() {
		IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
		// Rectangle clientArea = Display.getCurrent().getClientArea();
		// configurer
		// .setInitialSize(new Point(clientArea.width, clientArea.height));
		configurer.setShowMenuBar(true);
		configurer.setShowCoolBar(true);
		configurer.setShowStatusLine(true);
		String appName = (String) Activator.getPluginProperties().getObject("appName");
		configurer.setTitle(appName);

		
		configurer.addEditorAreaTransfer(FileTransfer.getInstance());
		configurer.configureEditorAreaDropListener(
				new CPFEditorAreaDropAdapter(configurer.getWindow()));
	}
	
	@Override
	public void postWindowCreate() {
		super.postWindowCreate();
		ImageDescriptor id = Activator.getImageDescriptor("icons/carbidev_app.ico");
		IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
		configurer.getWindow().getShell().setImage(id.createImage());
	}

}
