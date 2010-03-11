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

package com.nokia.tools.vct.navigator.sign;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.navigator.CommonActionProvider;

import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;

public class SignatureActionProvider extends CommonActionProvider {

	@Override
	public void fillContextMenu(IMenuManager menu) {
		ISelection selection = getContext().getSelection();
		if (!(selection instanceof IStructuredSelection)) {
			return;
		}
		Object[] objs = ((IStructuredSelection) selection).toArray();
		if (objs.length != 1) {
			return;
		}
		Object selected = objs[0];
		if (selected instanceof IContainer) {
			IContainer folder = (IContainer) selected;
			URI resourceURI = URI.createPlatformResourceURI(folder
					.getFullPath().toString(), true);
			resourceURI = resourceURI.appendSegment("");
			EConfigurationProject cpf = ConfMLCore.getProjectModel(folder
					.getProject());
			if (cpf == null) {
				return;
			}
			boolean added = false;
			menu.add(new Separator("cpf-signature"));
			if (folder instanceof IProject) {
				menu.add(new SignRootAction(cpf));
				menu.add(new ShowSigningStatusAction(cpf));
				added = true;
			}

			EConfMLLayer layer = ConfMLCore.getLayer(folder);
			if (layer != null) {
				if (resourceURI.equals(layer.getLayerURI())) {
					menu.add(new SignLayerAction(layer));
					menu.add(new VerifyLayerAction(layer));
					added = true;
				}
			}
			if (added) {
				menu.add(new Separator());
			}
		}
	}
}
